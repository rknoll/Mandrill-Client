package at.rknoll.mandrill;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by rknoll on 04/06/15.
 */
public class MandrillRequest<T> {
	private final MandrillAPI api;
	private final String url;
	private final Class<T> clazz;

	public MandrillRequest(final MandrillAPI api, final String url, Class<T> clazz) {
		this.api = api;
		this.url = url;
		this.clazz = clazz;
	}

	public T execute() throws MandrillException {
		try {
			return api.execute(this, clazz).get();
		} catch (InterruptedException | ExecutionException e) {
			throw new MandrillException(e);
		}
	}

	public Future<T> executeAsync() {
		return api.execute(this, clazz);
	}

	@JsonIgnore
	public String getUrl() {
		return url;
	}
}
