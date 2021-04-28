package view;

import domain.BaseballGameNumberFixture;
import domain.GameResult;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultMessageTest {

    @ParameterizedTest
    @MethodSource("provider_GameResult_를_받아서_프린트할_메시지로_변경한다")
    void GameResult_를_받아서_프린트할_메시지로_변경한다(GameResult result, String expectedMessage) {
        assertThat(GameResultMessage.message(result))
                .isEqualTo(expectedMessage);
    }

    static Stream<Arguments> provider_GameResult_를_받아서_프린트할_메시지로_변경한다() {

        GameResult 정답 = new GameResult(BaseballGameNumberFixture.정답, BaseballGameNumberFixture._3스트라이크);
        GameResult 낫싱 = new GameResult(BaseballGameNumberFixture.정답, BaseballGameNumberFixture.낫싱);
        GameResult _1스트라이크 = new GameResult(BaseballGameNumberFixture.정답, BaseballGameNumberFixture._1스트라이크);
        GameResult _2스트라이크 = new GameResult(BaseballGameNumberFixture.정답, BaseballGameNumberFixture._2스트라이크);
        GameResult _1볼 = new GameResult(BaseballGameNumberFixture.정답, BaseballGameNumberFixture._1볼);
        GameResult _2볼 = new GameResult(BaseballGameNumberFixture.정답, BaseballGameNumberFixture._2볼);
        GameResult _3볼 = new GameResult(BaseballGameNumberFixture.정답, BaseballGameNumberFixture._3볼);
        GameResult _1스트라이크_1볼 = new GameResult(BaseballGameNumberFixture.정답, BaseballGameNumberFixture._1스트라이크_1볼);
        GameResult _1스트라이크_2볼 = new GameResult(BaseballGameNumberFixture.정답, BaseballGameNumberFixture._1스트라이크_2볼);
        return Stream.of(
                Arguments.of(정답, "3개의 숫자를 모두 맞히셨습니다! 게임종료"),
                Arguments.of(낫싱, "낫싱"),
                Arguments.of(_1스트라이크, "1 스트라이크"),
                Arguments.of(_2스트라이크, "2 스트라이크"),
                Arguments.of(_1볼, "1 볼"),
                Arguments.of(_2볼, "2 볼"),
                Arguments.of(_3볼, "3 볼"),
                Arguments.of(_1스트라이크_1볼, "1 스트라이크 1 볼"),
                Arguments.of(_1스트라이크_2볼, "1 스트라이크 2 볼")
        );
    }
}