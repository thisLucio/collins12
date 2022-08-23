package Collins.NativeFunctions;

public class Display {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Display(String message) {
        this.message = message;
        System.out.println(message);
    }
}
