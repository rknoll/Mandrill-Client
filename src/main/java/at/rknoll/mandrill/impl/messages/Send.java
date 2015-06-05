package at.rknoll.mandrill.impl.messages;

import at.rknoll.mandrill.MandrillAPI;
import at.rknoll.mandrill.MandrillRequest;
import at.rknoll.mandrill.model.Message;

/**
 * Created by rknoll on 05.06.2015.
 */
public class Send extends MandrillRequest<String> {
	private Message message;
	private boolean async;

	public Send(MandrillAPI api, String url) {
		super(api, url, String.class);
	}

	public Message getMessage() {
		return message;
	}

	public Send setMessage(final Message message) {
		this.message = message;
		return this;
	}

	public boolean isAsync() {
		return async;
	}

	public Send setAsync(final boolean async) {
		this.async = async;
		return this;
	}
}
