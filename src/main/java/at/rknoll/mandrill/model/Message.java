package at.rknoll.mandrill.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rknoll on 04/06/15.
 */
public class Message {
	private String subject;
	private String html;
	private String text;
	private String fromEmail;
	private String fromName;
	private List<Recipient> to;
	private boolean preserveRecipients;
	private boolean trackOpens;
	private boolean trackClicks;
	private Object headers;
	private boolean important;
	private boolean autoText;
	private boolean autoHtml;
	private boolean viewContentLink;
	private List<Image> images;
	private List<MergeVar> globalMergeVars;
	private List<RecipientMergeVar> mergeVars;

	public Message() {
	}

	public Message(final String subject, final String fromEmail, final String fromName) {
		this.subject = subject;
		this.fromEmail = fromEmail;
		this.fromName = fromName;
	}

	public Message addRecipient(final Recipient recipient) {
		if (to == null) {
			to = new ArrayList<>();
		}
		to.add(recipient);
		return this;
	}

	public Message addImage(final Image image) {
		if (images == null) {
			images = new ArrayList<>();
		}
		images.add(image);
		return this;
	}

	public Message addGlobalMergeVar(final MergeVar mergeVar) {
		if (globalMergeVars == null) {
			globalMergeVars = new ArrayList<>();
		}
		globalMergeVars.add(mergeVar);
		return this;
	}

	public Message addMergeVar(final RecipientMergeVar mergeVar) {
		if (mergeVars == null) {
			mergeVars = new ArrayList<>();
		}
		mergeVars.add(mergeVar);
		return this;
	}

	public String getSubject() {
		return subject;
	}

	public Message setSubject(String subject) {
		this.subject = subject;
		return this;
	}

	public String getHtml() {
		return html;
	}

	public Message setHtml(String text) {
		this.html = text;
		return this;
	}

	public String getText() {
		return text;
	}

	public Message setText(String text) {
		this.text = text;
		return this;
	}

	@JsonProperty("from_email")
	public String getFromEmail() {
		return fromEmail;
	}

	public Message setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
		return this;
	}

	@JsonProperty("from_name")
	public String getFromName() {
		return fromName;
	}

	public Message setFromName(String fromName) {
		this.fromName = fromName;
		return this;
	}

	public List<Recipient> getTo() {
		return to;
	}

	public Message setTo(List<Recipient> to) {
		this.to = to;
		return this;
	}

	@JsonProperty("preserve_recipients")
	public boolean isPreserveRecipients() {
		return preserveRecipients;
	}

	public Message setPreserveRecipients(boolean preserveRecipients) {
		this.preserveRecipients = preserveRecipients;
		return this;
	}

	@JsonProperty("track_opens")
	public boolean isTrackOpens() {
		return trackOpens;
	}

	public Message setTrackOpens(boolean trackOpens) {
		this.trackOpens = trackOpens;
		return this;
	}

	@JsonProperty("track_clicks")
	public boolean isTrackClicks() {
		return trackClicks;
	}

	public Message setTrackClicks(boolean trackClicks) {
		this.trackClicks = trackClicks;
		return this;
	}

	public Object getHeaders() {
		return headers;
	}

	public Message setHeaders(Object headers) {
		this.headers = headers;
		return this;
	}

	public boolean isImportant() {
		return important;
	}

	public Message setImportant(boolean important) {
		this.important = important;
		return this;
	}

	@JsonProperty("auto_text")
	public boolean isAutoText() {
		return autoText;
	}

	public Message setAutoText(boolean autoText) {
		this.autoText = autoText;
		return this;
	}

	@JsonProperty("auto_html")
	public boolean isAutoHtml() {
		return autoHtml;
	}

	public Message setAutoHtml(boolean autoHtml) {
		this.autoHtml = autoHtml;
		return this;
	}

	@JsonProperty("view_content_link")
	public boolean isViewContentLink() {
		return viewContentLink;
	}

	public Message setViewContentLink(boolean viewContentLink) {
		this.viewContentLink = viewContentLink;
		return this;
	}

	public List<Image> getImages() {
		return images;
	}

	public Message setImages(List<Image> images) {
		this.images = images;
		return this;
	}

	@JsonProperty("global_merge_vars")
	public List<MergeVar> getGlobalMergeVars() {
		return globalMergeVars;
	}

	public Message setGlobalMergeVars(List<MergeVar> globalMergeVars) {
		this.globalMergeVars = globalMergeVars;
		return this;
	}

	@JsonProperty("merge_vars")
	public List<RecipientMergeVar> getMergeVars() {
		return mergeVars;
	}

	public Message setMergeVars(List<RecipientMergeVar> mergeVars) {
		this.mergeVars = mergeVars;
		return this;
	}
}
