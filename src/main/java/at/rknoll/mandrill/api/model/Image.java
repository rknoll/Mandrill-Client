package at.rknoll.mandrill.api.model;

/**
 * Created by rknoll on 04/06/15.
 */
public class Image {
    private String type;
    private String name;
    private String content;

    public Image(final String name, final String type, final String content) {
        this.name = name;
        this.type = type;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
