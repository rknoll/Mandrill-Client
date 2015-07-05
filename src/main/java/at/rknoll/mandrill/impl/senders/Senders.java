package at.rknoll.mandrill.impl.senders;

import at.rknoll.mandrill.MandrillAPI;
import at.rknoll.mandrill.MandrillRequest;

/**
 * Created by rknoll on 04/06/15.
 */
public class Senders {
    private final MandrillAPI api;

    public Senders(final MandrillAPI api) {
        this.api = api;
    }

    public MandrillRequest<String> list() {
        return new MandrillRequest<>(api, "/senders/list", String.class);
    }

    public MandrillRequest<String> domains() {
        return new MandrillRequest<>(api, "/senders/domains", String.class);
    }

    public Domain addDomain() {
        return new Domain(api, "/senders/add-domain");
    }

    public Domain checkDomain() {
        return new Domain(api, "/senders/check-domain");
    }

    public VerifyDomain verifyDomain() {
        return new VerifyDomain(api, "/senders/verify-domain");
    }

    public Info info() {
        return new Info(api, "/senders/info");
    }
}
