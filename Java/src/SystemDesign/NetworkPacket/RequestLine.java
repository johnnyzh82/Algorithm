package SystemDesign.NetworkPacket;

/**
 * Created by yunlong on 2/28/16.
 */


public class RequestLine {
    public enum method {
        GET,
        POST,
        PUT,
        DELETE
    }
    public String requestUrl;
    public String httpVersion;
}
