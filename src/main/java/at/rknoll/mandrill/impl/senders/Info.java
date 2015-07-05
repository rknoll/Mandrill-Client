package at.rknoll.mandrill.impl.senders;

import at.rknoll.mandrill.MandrillAPI;
import at.rknoll.mandrill.MandrillRequest;

/**
 * Created by rknoll on 05.06.2015.
 */
public class Info extends MandrillRequest<String> {
    private String address;

    public Info(MandrillAPI api, String url) {
        super(api, url, String.class);
    }

    public String getAddress() {
        return address;
    }

    public Info setAddress(String address) {
        this.address = address;
        return this;
    }
}
