package bridge.utils.constants;

public enum ExceptionMessage {

    INVALID_INPUT("잘못된 입력입니다."),;

    public static final String PREFIX = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}