package baseball.domain;

import baseball.utils.Game;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class TurnResultTest {
    @Test
    void 낫싱_결과_출력() {
        TurnResult turnResult = new TurnResult(0, 0);
        String expectResult = "낫싱";

        assertThat(turnResult.toString()).isEqualTo(expectResult);
    }

    @Test
    void 원볼_결과_출력() {
        TurnResult turnResult = new TurnResult(0, 1);
        String expectResult = "1볼 ";

        assertThat(turnResult.toString()).isEqualTo(expectResult);
    }

    @Test
    void 원스트라이크_결과_출력() {
        TurnResult turnResult = new TurnResult(1, 0);
        String expectResult = "1스트라이크 ";

        assertThat(turnResult.toString()).isEqualTo(expectResult);
    }

    @Test
    void 원스트라이크_원볼_결과_출력() {
        TurnResult turnResult = new TurnResult(1, 1);
        String expectResult = "1스트라이크 1볼 ";

        assertThat(turnResult.toString()).isEqualTo(expectResult);
    }

    @Test
    void 쓰리스트라이크_결과_출력() {
        TurnResult turnResult = new TurnResult(3, 0);
        String expectResult = "3스트라이크 ";

        assertThat(turnResult.toString()).isEqualTo(expectResult);
    }

    @Test
    void 승리_결과_확인() {
        TurnResult turnResult = new TurnResult(3, 0);

        assertTrue(turnResult.isFinished(Game.FINISH_STRIKE_COUNT));
    }

}