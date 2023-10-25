package baseball.domain.view;

import baseball.domain.dto.ResultDto;
import baseball.domain.model.BallCount;
import baseball.domain.model.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class OutputDataTest {
    EnumMap<BallCount, Integer> result;

    @BeforeEach
    void setUp() {
        result = Arrays.stream(BallCount.values())
                .collect(Collectors.toMap(value -> value, count -> 0, (a, b) -> b,
                        () -> new EnumMap<>(BallCount.class)));
    }

    @Test
    void 결과_출력() {
        result.put(BallCount.OUT, 3);
        result.put(BallCount.BALL, 0);
        result.put(BallCount.STRIKE, 0);
        OutputData.gameResultPrint(new ResultDto(new Score(result)));
    }
}