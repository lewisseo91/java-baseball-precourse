package baseball.validation;

import baseball.domain.Ball;
import baseball.utils.Game;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BallValidation {

    private BallValidation() { }

    public static boolean validateNumbers(String numbers) {
        int correctSize = Game.GENERATE_NUMBER_COUNT;
        int startRange = Game.START_NUM_IN_RANGE;
        int endRange = Game.END_NUM_IN_RANGE;
        if (!isCorrectSize(numbers, correctSize)) return false;
        if (!isNumber(numbers)) return false;
        if (!isAllNumbersInRange(numbers, correctSize, startRange, endRange)) return false;
        if (!isUniqueNumbers(numbers, correctSize)) return false;

        return true;
    }

    public static boolean isAllNumbersInRange(String numbers, int correctSize, int startRange, int endRange) {
        String[] splitNumbers = numbers.split("");
        int count = 0;

        for (String splitNumber : splitNumbers) {
            int number = Integer.parseInt(splitNumber);
            Ball ball = new Ball(number);
            // range 안이면 1 밖이면 0
            count += ball.checkInRange(startRange, endRange);
        }

        return count == correctSize;
    }

    public static boolean isCorrectSize(String numbers, int correctSize) {
        return numbers.length() == correctSize;
    }

    public static boolean isNumber(String numbers) {
        return numbers.matches("-?[0-9]+");
    }

    public static boolean isUniqueNumbers(String numbers, int correctSize) {
        String[] splitNumbers = numbers.split("");
        Set<String> numbersSet = new HashSet<>(Arrays.asList(splitNumbers));

        return numbersSet.size() == correctSize;
    }
}
