package at.rknoll.mandrill.impl.rejects;

import at.rknoll.mandrill.MandrillAPI;
import at.rknoll.mandrill.MandrillRequest;

/**
 * Created by rknoll on 05/07/15.
 */
public class Add extends MandrillRequest<String> {
    private String email;
    private String comment;

    public Add(MandrillAPI api, String url) {
        super(api, url, String.class);
    }

    public String getEmail() {
        return email;
    }

    public Add setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Add setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
