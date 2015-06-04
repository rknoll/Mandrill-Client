package at.rknoll.mandrill.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rknoll on 04/06/15.
 */
public class Message {
    private String subject;
    private String html;
    private String text;
    private String fromEmail;
    private String fromName;
    private List<Recipient> to;
    private boolean preserveRecipients;
    private boolean trackOpens;
    private boolean trackClicks;

    public Message() {
    }

    public Message(final String subject, final String fromEmail, final String fromName) {
        this.subject = subject;
        this.fromEmail = fromEmail;
        this.fromName = fromName;
    }

    public void addRecipient(final Recipient recipient) {
        if (to == null) {
            to = new ArrayList<>();
        }
        to.add(recipient);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String text) {
        this.html = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("from_email")
    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    @JsonProperty("from_name")
    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public List<Recipient> getTo() {
        return to;
    }

    public void setTo(List<Recipient> to) {
        this.to = to;
    }

    @JsonProperty("preserve_recipients")
    public boolean isPreserveRecipients() {
        return preserveRecipients;
    }

    public void setPreserveRecipients(boolean preserveRecipients) {
        this.preserveRecipients = preserveRecipients;
    }

    @JsonProperty("track_opens")
    public boolean isTrackOpens() {
        return trackOpens;
    }

    public void setTrackOpens(boolean trackOpens) {
        this.trackOpens = trackOpens;
    }

    @JsonProperty("track_clicks")
    public boolean isTrackClicks() {
        return trackClicks;
    }

    public void setTrackClicks(boolean trackClicks) {
        this.trackClicks = trackClicks;
    }
}