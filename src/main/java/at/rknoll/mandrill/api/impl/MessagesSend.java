package at.rknoll.mandrill.api.impl;

import at.rknoll.mandrill.api.Request;
import at.rknoll.mandrill.api.RequestURL;
import at.rknoll.mandrill.api.model.Message;

/**
 * Created by rknoll on 04/06/15.
 */
@RequestURL("/messages/send")
public class MessagesSend implements Request {
    private Message message;
    private boolean async;

    public MessagesSend() {
    }

    public MessagesSend(final Message message, final boolean async) {
        this.message = message;
        this.async = async;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public boolean isAsync() {
        return async;
    }

    public void setAsync(boolean async) {
        this.async = async;
    }
}
