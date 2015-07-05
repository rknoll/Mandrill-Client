package at.rknoll.mandrill.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rknoll on 05.06.2015.
 */
public class RecipientMergeVar {
    private String recipient;
    private List<MergeVar> mergeVars;

    public RecipientMergeVar() {
    }

    public RecipientMergeVar(final String recipient) {
        this.recipient = recipient;
    }

    public RecipientMergeVar addMergeVar(final MergeVar mergeVar) {
        if (mergeVars == null) {
            mergeVars = new ArrayList<>();
        }
        mergeVars.add(mergeVar);
        return this;
    }

    @JsonProperty("rcpt")
    public String getRecipient() {
        return recipient;
    }

    public RecipientMergeVar setRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    @JsonProperty("vars")
    public List<MergeVar> getMergeVars() {
        return mergeVars;
    }

    public RecipientMergeVar setMergeVars(List<MergeVar> mergeVars) {
        this.mergeVars = mergeVars;
        return this;
    }
}
