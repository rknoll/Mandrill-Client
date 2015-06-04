package at.rknoll.mandrill;

import at.rknoll.mandrill.api.impl.MessagesSend;
import at.rknoll.mandrill.api.impl.UsersInfo;
import at.rknoll.mandrill.api.model.Message;
import at.rknoll.mandrill.api.model.Recipient;
import org.junit.Before;

/**
 * Created by rknoll on 04/06/15.
 */
public class MandrillClientTest {
    private MandrillClient client;

    @Before
    public void setUp() {
        client = new MandrillClient("example key");
    }

}
