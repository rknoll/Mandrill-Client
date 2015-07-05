package at.rknoll.mandrill;

import at.rknoll.mandrill.response.Reject;
import at.rknoll.mandrill.response.UsersInfo;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
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
public class MandrillAPITest {
    private MandrillAPI api;
    private CloseableHttpClient mHttpClientMock;
    private CloseableHttpResponse mHttpResponseMock;
    private StatusLine mStatusLineMock;
    private HttpEntity mHttpEntityMock;

    @Before
    public void setUp() {
        mHttpClientMock = Mockito.mock(CloseableHttpClient.class);
        mHttpResponseMock = Mockito.mock(CloseableHttpResponse.class);
        mStatusLineMock = Mockito.mock(StatusLine.class);
        mHttpEntityMock = Mockito.mock(HttpEntity.class);

        api = new MandrillAPI("example key", null, mHttpClientMock);
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
        mockResponse("{\"username\":\"ok\"}");
        final UsersInfo result = api.users().info().execute();
        assertEquals("ok", result.getUsername());
    }

    @Test(expected = MandrillException.class)
    public void usersInfoErrorTest() throws MandrillException {
        mockResponse("forbidden", HttpStatus.SC_FORBIDDEN);
        final UsersInfo result = api.users().info().execute();
    }

    @Test
    public void rejectsTest() throws MandrillException {
        mockResponse("[{\"email\":\"test\"}]");
        final Reject[] rejects = api.rejects().list().setIncludeExpired(true).execute();
        assertEquals(1, rejects.length);
        assertEquals("test", rejects[0].getEmail());
    }
}
