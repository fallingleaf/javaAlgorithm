

public class SoldOutException extends RuntimeException {
    private String message;

    public SoldOutException(String msg) {
        message = msg;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
