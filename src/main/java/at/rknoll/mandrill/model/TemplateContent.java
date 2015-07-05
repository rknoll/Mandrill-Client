package at.rknoll.mandrill.model;

/**
 * Created by rknoll on 05.06.2015.
 */
public class TemplateContent {
    private String name;
    private String content;

    public TemplateContent() {
    }

    public TemplateContent(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public TemplateContent setName(String name) {
        this.name = name;
        return this;
    }

    public String getContent() {
        return content;
    }

    public TemplateContent setContent(String content) {
        this.content = content;
        return this;
    }
}
