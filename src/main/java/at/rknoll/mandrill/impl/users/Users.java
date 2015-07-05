package at.rknoll.mandrill.impl.users;

import at.rknoll.mandrill.MandrillAPI;
import at.rknoll.mandrill.MandrillRequest;
import at.rknoll.mandrill.response.UsersInfo;

/**
 * Created by rknoll on 04/06/15.
 */
public class Users {
    private final MandrillAPI api;

    public Users(final MandrillAPI api) {
        this.api = api;
    }

    public MandrillRequest<UsersInfo> info() {
        return new MandrillRequest<>(api, "/users/info", UsersInfo.class);
    }

    public MandrillRequest<String> ping() {
        return new MandrillRequest<>(api, "/users/ping", String.class);
    }

    public MandrillRequest<String> ping2() {
        return new MandrillRequest<>(api, "/users/ping2", String.class);
    }

    public MandrillRequest<String> senders() {
        return new MandrillRequest<>(api, "/users/senders", String.class);
    }
}
