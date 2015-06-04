package at.rknoll.mandrill;

import at.rknoll.mandrill.api.MandrillAPI;
import at.rknoll.mandrill.api.MandrillException;
import at.rknoll.mandrill.api.Request;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by rknoll on 04/06/15.
 */
public class MandrillClient {
    public static final String DEFAULT_BASE_URL = "https://mandrillapp.com/api/1.0";

    private final MandrillAPI api;

    public MandrillClient(final String key) {
        this(key, DEFAULT_BASE_URL);
    }

    public MandrillClient(final String key, final HttpClient client) {
        this(key, DEFAULT_BASE_URL, client);
    }

    public MandrillClient(final String key, final String baseURL) {
        this.api = new MandrillAPI(key, baseURL);
    }

    public MandrillClient(final String key, final String baseURL, final HttpClient client) {
        this.api = new MandrillAPI(key, baseURL, client);
    }

    public String request(final Request request) throws MandrillException {
        try {
            return api.handle(request).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new MandrillException(e);
        }
    }

    public Future<String> requestAsync(final Request request) {
        return api.handle(request);
    }

}
