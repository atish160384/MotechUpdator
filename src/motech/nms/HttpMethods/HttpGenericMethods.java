package motech.nms.HttpMethods;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Base64;

public class HttpGenericMethods<T> extends GsonConverter<T> {

    private HttpClient httpClient;



    public HttpGenericMethods() {
        super();
        httpClient = new DefaultHttpClient();
    }

    public int postwithJson(String url, T t, String authHeader) throws IOException {
        HttpResponse response = httpClient
                .execute(createPostRequestWithJson(url, t, authHeader));
        return response.getStatusLine().getStatusCode();
    }

    public String createAuthenticationHeader(String uname, String passwd){
        String auth = uname + ":" + passwd;
        byte[] encodedAuth = Base64.getEncoder().encode(
                auth.getBytes(Charset.forName("ISO-8859-1")));
        return  "Basic " + new String(encodedAuth);

    }

    public HttpPost createPostRequestWithJson(String url, T t, String authHeader)
            throws IOException {
        HttpPost post = new HttpPost(url);
        StringEntity postEntity = new StringEntity(converttoJson(t),
                ContentType.APPLICATION_JSON);
        post.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
        post.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        post.setEntity(postEntity);
        return post;
    }

}
