package at.rknoll.mandrill.impl.templates;

import at.rknoll.mandrill.MandrillAPI;
import at.rknoll.mandrill.MandrillRequest;

/**
 * Created by rknoll on 05.06.2015.
 */
public class Info extends MandrillRequest<String> {
	private String name;

	public Info(MandrillAPI api, String url) {
		super(api, url, String.class);
	}

	public String getName() {
		return name;
	}

	public Info setName(String name) {
		this.name = name;
		return this;
	}
}
