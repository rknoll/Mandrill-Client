package at.rknoll.mandrill.impl.rejects;

import at.rknoll.mandrill.MandrillAPI;

/**
 * Created by rknoll on 05/07/15.
 */
public class Rejects {
    private final MandrillAPI api;

    public Rejects(final MandrillAPI api) {
        this.api = api;
    }

    public Add add() {
        return new Add(api, "/rejects/add");
    }

    public Delete delete() {
        return new Delete(api, "/rejects/delete");
    }

    public List list() {
        return new List(api, "/rejects/list");
    }

}
