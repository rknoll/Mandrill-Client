package at.rknoll.mandrill.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by rknoll on 05/07/15.
 */
public class Reject {
    private String email;
    private String reason;
    private String detail;
    private Date createdAt;
    private Date lastEventAt;
    private Date expiresAt;
    private boolean expired;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @JsonProperty("created_at")
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("last_event_at")
    public Date getLastEventAt() {
        return lastEventAt;
    }

    public void setLastEventAt(Date lastEventAt) {
        this.lastEventAt = lastEventAt;
    }

    @JsonProperty("expires_at")
    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}
