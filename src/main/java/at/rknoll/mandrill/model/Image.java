package at.rknoll.mandrill.model;

import org.apache.commons.codec.binary.Base64OutputStream;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by rknoll on 04/06/15.
 */
public class Image {
	private String type;
	private String name;
	private String content;

	public Image() {
	}

	public Image(final String name, final String type, final String content) {
		this.name = name;
		this.type = type;
		this.content = content;
	}

	public Image(final String name, final String type, final InputStream content) throws IOException {
		this.name = name;
		this.type = type;

		// convert input stream to base64 string
		final ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
		final Base64OutputStream base64Output = new Base64OutputStream(byteArrayOutput);
		IOUtils.copy(content, base64Output);

		this.content = new String(byteArrayOutput.toByteArray());
	}

	public String getType() {
		return type;
	}

	public Image setType(String type) {
		this.type = type;
		return this;
	}

	public String getName() {
		return name;
	}

	public Image setName(String name) {
		this.name = name;
		return this;
	}

	public String getContent() {
		return content;
	}

	public Image setContent(String content) {
		this.content = content;
		return this;
	}
}
