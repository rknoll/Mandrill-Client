package at.rknoll.mandrill.impl.templates;

import at.rknoll.mandrill.MandrillAPI;
import at.rknoll.mandrill.MandrillRequest;
import at.rknoll.mandrill.response.Template;

/**
 * Created by rknoll on 05.06.2015.
 */
public class List extends MandrillRequest<Template[]> {
	private String label;

	public List(MandrillAPI api, String url) {
		super(api, url, Template[].class);
	}

	public String getLabel() {
		return label;
	}

	public List setLabel(String label) {
		this.label = label;
		return this;
	}
}
