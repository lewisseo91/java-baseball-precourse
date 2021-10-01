package baseball.utils;

public class Message {
    public static void printRequestIntro() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public static void printResult(String resultMessage) {
        System.out.println(resultMessage);
    }

    public static void printFinishCelebration() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    public static void printAskRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
