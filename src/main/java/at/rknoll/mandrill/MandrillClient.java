package at.rknoll.mandrill;

import at.rknoll.mandrill.api.MandrillAPI;
import at.rknoll.mandrill.api.Request;

import java.util.concurrent.ExecutionException;

/**
 * Created by rknoll on 04/06/15.
 */
public class MandrillClient {
    public static final String DEFAULT_BASE_URL = "https://mandrillapp.com/api/1.0";

    private final MandrillAPI api;

    public MandrillClient(final String key) {
        this(key, DEFAULT_BASE_URL);
    }

    public MandrillClient(final String key, final String baseURL) {
        this.api = new MandrillAPI(key, baseURL);
    }

    public String request(final Request request) throws ExecutionException, InterruptedException {
        return api.handle(request).get();
    }
}
