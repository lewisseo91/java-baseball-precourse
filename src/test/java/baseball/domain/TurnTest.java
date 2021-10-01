package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class TurnTest {
    private List<Ball> computerBalls;
    private List<Ball> myBalls;

    @BeforeEach
    void setup() {
        computerBalls = new ArrayList<Ball>();
        myBalls = new ArrayList<Ball>();
    }

    void addComputerBalls(int[] numbers) {
        for (int number: numbers) {
            computerBalls.add(new Ball(number));
        }
    }

    void addMyBalls(int[] numbers) {
        for (int number: numbers) {
            myBalls.add(new Ball(number));
        }
    }

    @Test
    void my_턴_생성_후_공_확인() {
        addMyBalls(new int[]{1, 2, 5});

        Turn turn = new Turn(myBalls, TurnStatus.MY);

        assertThat(turn.getBalls()).contains(new Ball(1));
        assertThat(turn.getBalls()).contains(new Ball(2));
        assertThat(turn.getBalls()).contains(new Ball(5));
    }

    @Test
    void computer_턴_생성_후_공_확인() {
        addComputerBalls(new int[]{3, 4, 6});

        Turn turn = new Turn(computerBalls, TurnStatus.COMPUTER);

        assertThat(turn.getBalls()).contains(new Ball(3));
        assertThat(turn.getBalls()).contains(new Ball(4));
        assertThat(turn.getBalls()).contains(new Ball(6));

        assertThat(turn.getBalls()).doesNotContain(new Ball(1));
    }

    @Test
    void 원볼() {
        addComputerBalls(new int[]{3, 4, 6});
        Turn computerTurn = new Turn(computerBalls, TurnStatus.COMPUTER);

        addMyBalls(new int[]{4, 5, 7});
        Turn myTurn = new Turn(myBalls, TurnStatus.MY);

        assertTrue(computerTurn.isBall(myTurn.getBalls().get(0)));
        assertFalse(computerTurn.isBall(myTurn.getBalls().get(1)));
        assertFalse(computerTurn.isBall(myTurn.getBalls().get(2)));
    }

    @Test
    void 원스트라이크() {
        addComputerBalls(new int[]{3, 4, 6});
        Turn computerTurn = new Turn(computerBalls, TurnStatus.COMPUTER);

        addMyBalls(new int[]{3, 1, 2});
        Turn myTurn = new Turn(myBalls, TurnStatus.MY);

        assertTrue(computerTurn.isStrike(myTurn.getBalls().get(0), 0));
        assertFalse(computerTurn.isStrike(myTurn.getBalls().get(1), 1));
        assertFalse(computerTurn.isStrike(myTurn.getBalls().get(2), 2));
    }

    @Test
    void 원볼_원스트라이크() {
        addComputerBalls(new int[]{3, 4, 6});
        Turn computerTurn = new Turn(computerBalls, TurnStatus.COMPUTER);

        addMyBalls(new int[]{3, 6, 2});
        Turn myTurn = new Turn(myBalls, TurnStatus.MY);

        assertTrue(computerTurn.isStrike(myTurn.getBalls().get(0), 0));
        assertTrue(computerTurn.isBall(myTurn.getBalls().get(1)));
        assertFalse(computerTurn.isStrike(myTurn.getBalls().get(2), 2));
        assertFalse(computerTurn.isBall(myTurn.getBalls().get(2)));
    }

    @Test
    void 쓰리스트라이크() {
        addComputerBalls(new int[]{3, 4, 6});
        Turn computerTurn = new Turn(computerBalls, TurnStatus.COMPUTER);

        addMyBalls(new int[]{3, 4, 6});
        Turn myTurn = new Turn(myBalls, TurnStatus.MY);

        assertTrue(computerTurn.isStrike(myTurn.getBalls().get(0), 0));
        assertTrue(computerTurn.isStrike(myTurn.getBalls().get(1), 1));
        assertTrue(computerTurn.isStrike(myTurn.getBalls().get(2), 2));
    }

    @Test
    void 볼_스트라이크_갯수_확인_원볼_원스트라이크() {
        addComputerBalls(new int[]{3, 7, 6});
        Turn computerTurn = new Turn(computerBalls, TurnStatus.COMPUTER);

        addMyBalls(new int[]{3, 4, 7});
        Turn myTurn = new Turn(myBalls, TurnStatus.MY);

        myTurn.calculateCount(computerTurn);

        assertEquals(1, myTurn.getBallCount());
        assertEquals(1, myTurn.getStrikeCount());
    }
}