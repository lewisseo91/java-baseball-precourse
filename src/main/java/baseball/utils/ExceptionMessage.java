package baseball.utils;

public class ExceptionMessage {
    private static final String ERROR_TITLE = "[ERROR]";
    public static void printExceptionWrongInput() {
        System.out.println(ERROR_TITLE + " 유효하지 않은 입력입니다. 다시 입력 해 주세요.");
    }
}
