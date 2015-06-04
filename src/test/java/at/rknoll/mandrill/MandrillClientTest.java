package at.rknoll.mandrill;

import at.rknoll.mandrill.api.MandrillException;
import at.rknoll.mandrill.api.impl.Users;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

/**
 * Created by rknoll on 04/06/15.
 */
public class MandrillClientTest {
    private MandrillClient client;
    private HttpClient mHttpClientMock;
    private HttpResponse mHttpResponseMock;
    private StatusLine mStatusLineMock;
    private HttpEntity mHttpEntityMock;

    @Before
    public void setUp() {
        mHttpClientMock = Mockito.mock(HttpClient.class);
        mHttpResponseMock = Mockito.mock(HttpResponse.class);
        mStatusLineMock = Mockito.mock(StatusLine.class);
        mHttpEntityMock = Mockito.mock(HttpEntity.class);

        client = new MandrillClient("example_key", mHttpClientMock);
    }

    private void mockResponse(final String response, final int code) {
        final InputStream jsonResponse = new ByteArrayInputStream(response.getBytes(StandardCharsets.UTF_8));
        try {
            Mockito.when(mHttpClientMock.execute(Mockito.isA(HttpPost.class))).thenReturn(mHttpResponseMock);
            Mockito.when(mHttpResponseMock.getStatusLine()).thenReturn(mStatusLineMock);
            Mockito.when(mStatusLineMock.getStatusCode()).thenReturn(code);
            Mockito.when(mHttpResponseMock.getEntity()).thenReturn(mHttpEntityMock);
            Mockito.when(mHttpEntityMock.getContent()).thenReturn(jsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mockResponse(final String response) {
        mockResponse(response, HttpStatus.SC_OK);
    }

    @Test
    public void usersInfoTest() throws MandrillException {
        mockResponse("ok");
        final String result = client.request(new Users.Info());
        assertEquals("ok", result);
    }

    @Test(expected = MandrillException.class)
    public void usersInfoErrorTest() throws MandrillException {
        mockResponse("forbidden", HttpStatus.SC_FORBIDDEN);
        final String result = client.request(new Users.Info());
    }

}
