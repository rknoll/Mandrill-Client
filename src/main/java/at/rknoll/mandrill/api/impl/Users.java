package at.rknoll.mandrill.api.impl;

import at.rknoll.mandrill.api.Request;
import at.rknoll.mandrill.api.RequestURL;

/**
 * Created by rknoll on 04/06/15.
 */
public interface Users {

    @RequestURL("/users/info")
    class Info implements Request {
    }

    @RequestURL("/users/ping")
    class Ping implements Request {
    }

    @RequestURL("/users/ping2")
    class Ping2 implements Request {
    }

    @RequestURL("/users/senders")
    class Senders implements Request {
    }

}
