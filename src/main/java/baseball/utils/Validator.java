package baseball.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Validator {
    private static final List<String> STANDARD_NUMBER = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");
    private static final int MAX_SIZE = 3;

    private Validator() {
    }

    public static void checkBallInput(final String ballInput) {
        checkBallNumberLength(ballInput);
    }

    private static void checkBallNumberLength(final String ballInput) {
        if (MAX_SIZE != ballInput.length()) {
            throw new IllegalArgumentException();
        }
    }

    private static List<String> checkBallNumberIsValidNumber(final String userBallInput) {
        List<String> splitUserBall = Arrays.asList(userBallInput.split(""));
        for (String ball : splitUserBall) {
            checkStandardNumber(ball);
        }
        return splitUserBall;
    }

    private static void checkStandardNumber(final String ball) {
        if (!STANDARD_NUMBER.contains(ball)) {
            throw new IllegalArgumentException();
        }
    }

}
