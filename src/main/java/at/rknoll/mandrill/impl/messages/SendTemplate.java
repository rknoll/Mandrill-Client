package at.rknoll.mandrill.impl.messages;

import at.rknoll.mandrill.MandrillAPI;
import at.rknoll.mandrill.model.TemplateContent;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by rknoll on 05.06.2015.
 */
public class SendTemplate extends Send {
    private String templateName;
    private List<TemplateContent> templateContent;

    public SendTemplate(MandrillAPI api, String url) {
        super(api, url);
    }

    @JsonProperty("template_name")
    public String getTemplateName() {
        return templateName;
    }

    public SendTemplate setTemplateName(String templateName) {
        this.templateName = templateName;
        return this;
    }

    @JsonProperty("template_content")
    public List<TemplateContent> getTemplateContent() {
        return templateContent;
    }

    public SendTemplate setTemplateContent(List<TemplateContent> templateContent) {
        this.templateContent = templateContent;
        return this;
    }
}
