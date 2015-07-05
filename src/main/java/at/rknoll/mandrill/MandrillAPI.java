package at.rknoll.mandrill;

import at.rknoll.mandrill.impl.messages.Messages;
import at.rknoll.mandrill.impl.rejects.Rejects;
import at.rknoll.mandrill.impl.senders.Senders;
import at.rknoll.mandrill.impl.templates.Templates;
import at.rknoll.mandrill.impl.users.Users;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Created by rknoll on 04/06/15.
 */
public class MandrillAPI {
    public static final String DEFAULT_BASE_URL = "https://mandrillapp.com/api/1.0";

    private static final Logger LOG = LoggerFactory.getLogger(MandrillAPI.class);

    private final List<MandrillExecuteListener> listeners;

    private final String key;
    private final String baseURL;
    private final CloseableHttpClient client;
    private final ObjectMapper mapper;

    public MandrillAPI(final String key) {
        this(key, null, null);
    }

    public MandrillAPI(final String key, final String baseURL) {
        this(key, baseURL, null);
    }

    public MandrillAPI(final String key, final String baseURL, final CloseableHttpClient client) {
        this.key = key;
        this.baseURL = baseURL != null ? baseURL : DEFAULT_BASE_URL;
        this.listeners = new ArrayList<>();
        this.mapper = new ObjectMapper();
        this.mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        if (client != null) {
            this.client = client;
        } else {
            final PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
            connManager.setMaxTotal(100);
            connManager.setDefaultMaxPerRoute(50);
            this.client = HttpClients.custom().setConnectionManager(connManager).build();
        }
    }

    public void addListener(final MandrillExecuteListener listener) {
        listeners.add(listener);
    }

    public void removeListener(final MandrillExecuteListener listener) {
        listeners.remove(listener);
    }

    public <T> Future<T> execute(final MandrillRequest request, Class<T> clazz) {
        final CompletableFuture<T> result = new CompletableFuture<>();
        CompletableFuture.runAsync(() -> execute(request, result, clazz));
        return result;
    }

    private <T> void execute(final MandrillRequest request, final CompletableFuture<T> result, Class<T> clazz) {
        CloseableHttpResponse response = null;
        try {
            final HttpPost httpPost = new HttpPost(baseURL + request.getUrl());

            final ObjectNode requestTree = mapper.valueToTree(request);
            requestTree.put("key", key);

            httpPost.setEntity(new StringEntity(requestTree.toString(),
                    ContentType.create("application/json", "utf-8")));
            httpPost.setHeader("Accept", "application/json;charset=utf-8");
            httpPost.setHeader("Content-type", "application/json;charset=utf-8");

            response = client.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            String responseContent = EntityUtils.toString(response.getEntity());

            if (statusCode != HttpStatus.SC_OK) {
                LOG.error("Mandrill Response: {}", responseContent);
                result.completeExceptionally(new MandrillException(responseContent));
            } else {
                LOG.debug("Mandrill Response: {}", responseContent);
                if (clazz.equals(String.class)) {
                    result.complete(clazz.cast(responseContent));
                } else {
                    result.complete(mapper.readValue(responseContent, clazz));
                }
            }
        } catch (Throwable e) {
            result.completeExceptionally(e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException ignored) {
                }
            }
        }

        // call listeners
        for (final MandrillExecuteListener listener : listeners) {
            listener.executed(request);
        }
    }

    public Messages messages() {
        return new Messages(this);
    }

    public Users users() {
        return new Users(this);
    }

    public Senders senders() {
        return new Senders(this);
    }

    public Templates templates() {
        return new Templates(this);
    }

    public Rejects rejects() {
        return new Rejects(this);
    }
}
