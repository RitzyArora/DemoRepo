package MultiThreadingBasicsAndAdvanced;

public class RequestContext {
    private String requestId;
    private String user;

    public RequestContext(String requestId, String user) {
        this.requestId = requestId;
        this.user = user;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getUser() {
        return user;
    }
}
