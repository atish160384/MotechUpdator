package motech.nms.HttpMethods;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class HttpGenericMethods<T> extends GsonConverter<T> {

    private HttpClient httpClient;

    public HttpGenericMethods() {
        super();
        httpClient = new DefaultHttpClient();
    }

    public int postwithJson(String url, T t) throws IOException {
        HttpResponse response = httpClient
                .execute(createPostRequestWithJson(url, t));
        return response.getStatusLine().getStatusCode();
    }

    public HttpPost createPostRequestWithJson(String url, T t)
            throws IOException {

        HttpPost post = new HttpPost(url);
        StringEntity postEntity = new StringEntity(converttoJson(t),
                ContentType.APPLICATION_JSON);
        post.setHeader("content-type", ContentType.APPLICATION_JSON.getMimeType());
        post.setEntity(postEntity);
        return post;
    }

}
