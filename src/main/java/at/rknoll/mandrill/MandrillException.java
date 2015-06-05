package at.rknoll.mandrill;

/**
 * Created by rknoll on 04/06/15.
 */
public class MandrillException extends Exception {

    public MandrillException() {
    }

    public MandrillException(final String message) {
        super(message);
    }

    public MandrillException(final Throwable cause) {
        super(cause);
    }

    public MandrillException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
