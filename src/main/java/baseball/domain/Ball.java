package baseball.domain;

import java.util.Objects;

public class Ball {
    private int number;

    public Ball(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isSameBallNumber(Ball otherBall) {
        return number == otherBall.getNumber();
    }

    public int checkInRange(int startNumber, int endNumber) {
        if (number >= startNumber && number <= endNumber) {
            return 1;
        }

        return 0;
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
        return Objects.hash(number);
    }
}
