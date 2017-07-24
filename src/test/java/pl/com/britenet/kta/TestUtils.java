package pl.com.britenet.kta;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpHeaders;

import java.nio.charset.Charset;

public class TestUtils {

    public static HttpHeaders httpHeaders() {
        return new HttpHeaders() {{
            String auth = "user:password";
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("UTF-8")));
            String authHeader = "Basic " + new String(encodedAuth);
            set("Authorization", authHeader);
        }};
    }
}
