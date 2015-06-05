package at.rknoll.mandrill.impl.templates;

import at.rknoll.mandrill.MandrillAPI;

/**
 * Created by rknoll on 05.06.2015.
 */
public class Templates {
	private final MandrillAPI api;

	public Templates(final MandrillAPI api) {
		this.api = api;
	}

	public Add add() {
		return new Add(api, "/templates/add");
	}

	public Add update() {
		return new Add(api, "/templates/update");
	}

	public Info info() {
		return new Info(api, "/templates/info");
	}

	public Info publish() {
		return new Info(api, "/templates/publish");
	}

	public Info delete() {
		return new Info(api, "/templates/delete");
	}

	public List list() {
		return new List(api, "/templates/list");
	}

	public Render render() {
		return new Render(api, "/templates/render");
	}

}
