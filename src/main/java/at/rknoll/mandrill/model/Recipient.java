package at.rknoll.mandrill.model;

/**
 * Created by rknoll on 04/06/15.
 */
public class Recipient {
	private String email;

	public Recipient() {
	}

	public Recipient(final String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public Recipient setEmail(String email) {
		this.email = email;
		return this;
	}
}
