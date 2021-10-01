package baseball.utils;

import baseball.domain.*;
import baseball.validation.BallValidation;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.*;

public class Game {
    public static final int START_NUM_IN_RANGE = 1;
    public static final int END_NUM_IN_RANGE = 9;
    public static final int GENERATE_NUMBER_COUNT = 3;
    public static final int FINISH_STRIKE_COUNT = 3;

    public void startGame() {
        Turn computerTurn = playComputerTurn();
        processMyTurn(computerTurn);
        askRestart();
    }

    private void processMyTurn(Turn computerTurn) {
        Turn myTurn = playMyTurn();
        myTurn.calculateCount(computerTurn);

        TurnResult turnResult = new TurnResult(myTurn.getStrikeCount(), myTurn.getBallCount());
        turnResult.showResult();

        if(turnResult.isFinished(FINISH_STRIKE_COUNT)) {
            return;
        }

        processMyTurn(computerTurn);
    }

    private Turn playMyTurn() {
        Message.printRequestIntro();
        String requestedNumbers = Console.readLine();

        if (!BallValidation.validateNumbers(requestedNumbers)) {
            ExceptionMessage.printExceptionWrongInput();
            return playMyTurn();
        }

        List<Ball> balls = getBallsFromString(requestedNumbers);
        return new Turn(balls, TurnStatus.MY);
    }

    private List<Ball> getBallsFromString(String numbers) {
        String[] numbersString = numbers.split("");
        List<Ball> resultBalls = new ArrayList<>();

        for (String numberString : numbersString) {
            int number = Integer.parseInt(numberString);
            resultBalls.add(new Ball(number));
        }

        return resultBalls;
    }

    private Turn playComputerTurn() {
        List<Ball> balls = generateRandomBalls();
        return new Turn(balls, TurnStatus.COMPUTER);
    }

    private List<Ball> generateRandomBalls() {
        Set<Integer> resultNumbers = new LinkedHashSet<>();

        while (resultNumbers.size() < Game.GENERATE_NUMBER_COUNT) {
            resultNumbers.add(Randoms.pickNumberInRange(START_NUM_IN_RANGE, END_NUM_IN_RANGE));
        }

        List<Ball> resultBalls = new ArrayList<>();
        for (int number : resultNumbers) {
            resultBalls.add(new Ball(number));
        }
        return resultBalls;
    }

    private void askRestart() {
        Message.printAskRestart();
        String restartAnswer = Console.readLine();

        if (restartAnswer.equals(RestartStatus.RESTART.getValue())) {
            startGame();
        }
    }
}
