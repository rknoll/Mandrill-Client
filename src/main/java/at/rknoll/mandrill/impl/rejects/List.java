package at.rknoll.mandrill.impl.rejects;

import at.rknoll.mandrill.MandrillAPI;
import at.rknoll.mandrill.MandrillRequest;
import at.rknoll.mandrill.response.Reject;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by rknoll on 05/07/15.
 */
public class List extends MandrillRequest<Reject[]> {
    private String email;
    private boolean includeExpired;

    public List(MandrillAPI api, String url) {
        super(api, url, Reject[].class);
    }

    public String getEmail() {
        return email;
    }

    public List setEmail(String email) {
        this.email = email;
        return this;
    }

    @JsonProperty("include_expired")
    public boolean isIncludeExpired() {
        return includeExpired;
    }

    public List setIncludeExpired(boolean includeExpired) {
        this.includeExpired = includeExpired;
        return this;
    }
}
