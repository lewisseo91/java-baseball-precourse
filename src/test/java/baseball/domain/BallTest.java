package baseball.domain;

import baseball.utils.Game;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.aggregator.ArgumentAccessException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    @Test
    void 다른_주소_같은_공() {
        int testNum = 6;
        Ball ball = new Ball(testNum);
        Ball otherBall = new Ball(testNum);

        assertThat(ball.getNumber()).isEqualTo(testNum);
        assertThat(ball).isEqualTo(otherBall);
    }

    @Test
    void 공_범위() {
        int testNum = 0;
        Ball ball = new Ball(testNum);

        assertThat(ball.checkInRange(Game.START_NUM_IN_RANGE, Game.END_NUM_IN_RANGE)).isEqualTo(0);

        int testNum2 = 4;
        Ball ball2 = new Ball(testNum2);

        assertThat(ball2.checkInRange(Game.START_NUM_IN_RANGE, Game.END_NUM_IN_RANGE)).isEqualTo(1);
    }

}