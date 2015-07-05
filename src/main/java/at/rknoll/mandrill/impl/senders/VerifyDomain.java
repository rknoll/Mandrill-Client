package at.rknoll.mandrill.impl.senders;

import at.rknoll.mandrill.MandrillAPI;

/**
 * Created by rknoll on 05.06.2015.
 */
public class VerifyDomain extends Domain {
    private String mailbox;

    public VerifyDomain(MandrillAPI api, String url) {
        super(api, url);
    }

    public String getMailbox() {
        return mailbox;
    }

    public VerifyDomain setMailbox(final String mailbox) {
        this.mailbox = mailbox;
        return this;
    }
}
