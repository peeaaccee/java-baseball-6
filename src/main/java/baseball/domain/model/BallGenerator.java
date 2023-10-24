package baseball.domain.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BallGenerator {
    private static final int MAX_SIZE = 3;
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 9;

    public BallGenerator() {
    }

    private static class BallHolder {
        private static final BallGenerator INSTANCE = new BallGenerator();
    }

    public static BallGenerator getInstance() {
        return BallHolder.INSTANCE;
    }

    public String createRandomBall() {
        return String.valueOf(Randoms.pickNumberInRange(START_NUMBER, END_NUMBER));
    }

    public List<String> makeComputerBalls() {
        List<String> balls = new ArrayList<>();
        while (balls.size() < MAX_SIZE) {
            checkBallDuplication(balls);
        }
        return balls;
    }

    private void checkBallDuplication(List<String> balls) {
        String randomball = createRandomBall();
        if (!balls.contains(randomball)) {
            balls.add(randomball);
        }
    }
}
