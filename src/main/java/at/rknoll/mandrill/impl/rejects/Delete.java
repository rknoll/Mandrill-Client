package at.rknoll.mandrill.impl.rejects;

import at.rknoll.mandrill.MandrillAPI;
import at.rknoll.mandrill.MandrillRequest;

/**
 * Created by rknoll on 05/07/15.
 */
public class Delete extends MandrillRequest<String> {
    private String email;

    public Delete(MandrillAPI api, String url) {
        super(api, url, String.class);
    }

    public String getEmail() {
        return email;
    }

    public Delete setEmail(String email) {
        this.email = email;
        return this;
    }
}
