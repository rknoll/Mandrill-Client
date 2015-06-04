package at.rknoll.mandrill.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Created by rknoll on 04/06/15.
 */
public class MandrillAPI {
    private final String key;
    private final String baseURL;
    private final HttpClient client;
    private final ObjectMapper mapper;

    public MandrillAPI(final String key, final String baseURL) {
        this(key, baseURL, HttpClients.createDefault());
    }

    public MandrillAPI(final String key, final String baseURL, final HttpClient client) {
        this.key = key;
        this.baseURL = baseURL;
        this.client = client;
        this.mapper = new ObjectMapper();
        this.mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    public Future<String> handle(final Request request) {
        final RequestURL requestURL = request.getClass().getAnnotation(RequestURL.class);
        final String url = requestURL != null ? requestURL.value() : null;
        return query(url, request);
    }

    private void sendRequest(final String url, final Request request, final CompletableFuture<String> result) {
        if (url == null) {
            result.completeExceptionally(new IllegalArgumentException("url"));
            return;
        }

        try {
            final HttpPost httpPost = new HttpPost(baseURL + url);

            final ObjectNode requestTree = mapper.valueToTree(request);
            requestTree.put("key", key);

            httpPost.setEntity(new StringEntity(requestTree.toString()));
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            final HttpResponse response = client.execute(httpPost);
            result.complete(EntityUtils.toString(response.getEntity()));
        } catch (Throwable e) {
            result.completeExceptionally(e);
        }
    }

    private Future<String> query(final String url, final Request request) {
        final CompletableFuture<String> result = new CompletableFuture<>();
        CompletableFuture.runAsync(() -> sendRequest(url, request, result));
        return result;
    }
}
