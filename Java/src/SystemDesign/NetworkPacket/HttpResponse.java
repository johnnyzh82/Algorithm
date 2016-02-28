package SystemDesign.NetworkPacket;

/**
 * Created by yunlong on 2/28/16.
 */
public class HttpResponse {
    public StatusLine statusLine;
    public GeneralHeaders generalHeaders;
    public RequestHeaders requestHeaders;
    public EntityHeader entityHeader;
    public String messageBody;
}
