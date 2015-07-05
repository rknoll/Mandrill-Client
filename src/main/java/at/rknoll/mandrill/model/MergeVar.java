package at.rknoll.mandrill.model;

/**
 * Created by rknoll on 05.06.2015.
 */
public class MergeVar {
    private String name;
    private Object content;

    public MergeVar() {
    }

    public MergeVar(final String name, final Object content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public MergeVar setName(String name) {
        this.name = name;
        return this;
    }

    public Object getContent() {
        return content;
    }

    public MergeVar setContent(Object content) {
        this.content = content;
        return this;
    }
}
