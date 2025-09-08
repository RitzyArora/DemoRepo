package MultiThreadingBasicsAndAdvanced;

public class RequestContextHolder {
    private static final ThreadLocal<RequestContext> context=new ThreadLocal<>();
    public static void set(RequestContext rc)
    {
        context.set(rc);
    }

    public static RequestContext get()
    {
        return context.get();
    }

    public static void clear(){
        context.remove();
    }
}
