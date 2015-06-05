package at.rknoll.mandrill.impl.messages;

import at.rknoll.mandrill.MandrillAPI;

/**
 * Created by rknoll on 04/06/15.
 */
public class Messages {
	private final MandrillAPI api;

	public Messages(final MandrillAPI api) {
		this.api = api;
	}

	public Send send() {
		return new Send(api, "/messages/send");
	}

	public SendTemplate sendTemplate() {
		return new SendTemplate(api, "/messages/send-template");
	}
}
