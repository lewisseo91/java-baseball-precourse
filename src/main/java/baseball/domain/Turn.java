package baseball.domain;

import java.util.List;

public class Turn {
    private List<Ball> balls;

    public Turn(List<Ball> balls) {
        this.balls = balls;
    }

    public boolean isBall(Ball otherBall) {
        return balls.contains(otherBall);
    }

    public boolean isStrike(Ball otherBall) {
        if (!isBall(otherBall)) return false;

        int ballPosition = balls.indexOf(otherBall);
        return ballPosition == otherBall.getPosition();
    }
}
