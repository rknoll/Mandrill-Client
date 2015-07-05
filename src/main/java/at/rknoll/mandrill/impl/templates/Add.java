package at.rknoll.mandrill.impl.templates;

import at.rknoll.mandrill.MandrillAPI;
import at.rknoll.mandrill.MandrillRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rknoll on 05.06.2015.
 */
public class Add extends MandrillRequest<String> {
    private String name;
    private String fromEmail;
    private String fromName;
    private String subject;
    private String html;
    private String text;
    private boolean publish;
    private List<String> labels;

    public Add(MandrillAPI api, String url) {
        super(api, url, String.class);
    }

    public Add addLabel(final String label) {
        if (labels == null) {
            labels = new ArrayList<>();
        }
        labels.add(label);
        return this;
    }

    public String getName() {
        return name;
    }

    public Add setName(final String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("from_email")
    public String getFromEmail() {
        return fromEmail;
    }

    public Add setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
        return this;
    }

    @JsonProperty("from_name")
    public String getFromName() {
        return fromName;
    }

    public Add setFromName(String fromName) {
        this.fromName = fromName;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Add setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    @JsonProperty("code")
    public String getHtml() {
        return html;
    }

    public Add setHtml(String html) {
        this.html = html;
        return this;
    }

    public String getText() {
        return text;
    }

    public Add setText(String text) {
        this.text = text;
        return this;
    }

    public boolean isPublish() {
        return publish;
    }

    public Add setPublish(boolean publish) {
        this.publish = publish;
        return this;
    }

    public List<String> getLabels() {
        return labels;
    }

    public Add setLabels(List<String> labels) {
        this.labels = labels;
        return this;
    }
}
