package baseball.domain;

import java.util.List;

public class Turn {
    private List<Ball> balls;
    private TurnStatus turnStatus;
    private int strikeCount;
    private int ballCount;

    public Turn(List<Ball> balls, TurnStatus turnStatus) {
        this.balls = balls;
        this.turnStatus = turnStatus;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isBall(Ball otherBall) {
        return balls.contains(otherBall);
    }

    public boolean isStrike(Ball otherBall, int position) {
        if (!isBall(otherBall)) return false;

        int ballPosition = balls.indexOf(otherBall);
        return ballPosition == position;
    }

    public void calculateCount(Turn otherTurn) {
        List<Ball> otherBalls = otherTurn.balls;
        strikeCount = 0;
        ballCount = 0;

        for (int i = 0; i < otherBalls.size(); i++) {
            Ball computerBall = otherBalls.get(i);
            ballCheck(this, computerBall, i);
        }
    }

    private void ballCheck(Turn myTurn, Ball computerBall, int index) {
        if (myTurn.isStrike(computerBall, index)) {
            strikeCount++;
            return;
        }

        if (myTurn.isBall(computerBall)) {
            ballCount++;
        }
    }
}
