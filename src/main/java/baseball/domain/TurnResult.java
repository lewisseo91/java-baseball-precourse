package baseball.domain;

public class TurnResult {
    StringBuilder resultString;
    private int strikeCount;
    private int ballCount;

    public TurnResult(int strikeCount, int ballCount) {
        this.resultString = new StringBuilder();
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    private void getResultNothing() {
        resultString.append(BallStatus.NOTHING.getDisplayName());
    }

    private void getResultStrike() {
        resultString.append(strikeCount)
                .append(BallStatus.STRIKE.getDisplayName())
                .append(" ");
    }

    private void getResultBall() {
        resultString.append(ballCount)
                .append(BallStatus.BALL.getDisplayName())
                .append(" ");
    }

    @Override
    public String toString() {

        if (ballCount == 0 && strikeCount == 0) {
            getResultNothing();
            return resultString.toString();
        }

        if (strikeCount > 0) getResultStrike();

        if (ballCount > 0) getResultBall();

        return resultString.toString();
    }

}