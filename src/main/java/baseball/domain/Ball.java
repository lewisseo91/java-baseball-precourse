package baseball.domain;

import java.util.Objects;

public class Ball {
    private int number;
    private int position;

    public Ball(int number, int position) {
        this.number = number;
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public int getPosition() {
        return position;
    }

    public boolean isSameBallNumber(Ball otherBall) {
        return number == otherBall.getNumber();
    }

    public boolean isSamePosition(Ball otherBall) {
        return position == otherBall.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
