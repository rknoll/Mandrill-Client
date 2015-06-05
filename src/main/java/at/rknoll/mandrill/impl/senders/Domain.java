package at.rknoll.mandrill.impl.senders;

import at.rknoll.mandrill.MandrillAPI;
import at.rknoll.mandrill.MandrillRequest;

/**
 * Created by rknoll on 05.06.2015.
 */
public class Domain extends MandrillRequest<String> {
	private String domain;

	public Domain(MandrillAPI api, String url) {
		super(api, url, String.class);
	}

	public String getDomain() {
		return domain;
	}

	public Domain setDomain(final String domain) {
		this.domain = domain;
		return this;
	}
}
