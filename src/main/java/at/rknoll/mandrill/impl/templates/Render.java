package at.rknoll.mandrill.impl.templates;

import at.rknoll.mandrill.MandrillAPI;
import at.rknoll.mandrill.MandrillRequest;
import at.rknoll.mandrill.model.MergeVar;
import at.rknoll.mandrill.model.TemplateContent;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by rknoll on 05.06.2015.
 */
public class Render extends MandrillRequest<String> {
    private String templateName;
    private java.util.List<TemplateContent> templateContent;
    private java.util.List<MergeVar> mergeVars;

    public Render(MandrillAPI api, String url) {
        super(api, url, String.class);
    }

    public Render addTemplateContent(final TemplateContent templateContent) {
        if (this.templateContent == null) {
            this.templateContent = new ArrayList<>();
        }
        this.templateContent.add(templateContent);
        return this;
    }

    public Render addMergeVar(final MergeVar mergeVar) {
        if (mergeVars == null) {
            mergeVars = new ArrayList<>();
        }
        mergeVars.add(mergeVar);
        return this;
    }

    @JsonProperty("template_name")
    public String getTemplateName() {
        return templateName;
    }

    public Render setTemplateName(String templateName) {
        this.templateName = templateName;
        return this;
    }

    @JsonProperty("template_content")
    public java.util.List<TemplateContent> getTemplateContent() {
        return templateContent;
    }

    public Render setTemplateContent(java.util.List<TemplateContent> templateContent) {
        this.templateContent = templateContent;
        return this;
    }

    @JsonProperty("merge_vars")
    public java.util.List<MergeVar> getMergeVars() {
        return mergeVars;
    }

    public Render setMergeVars(java.util.List<MergeVar> mergeVars) {
        this.mergeVars = mergeVars;
        return this;
    }
}
