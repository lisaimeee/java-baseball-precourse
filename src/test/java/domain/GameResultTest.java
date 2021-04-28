package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


public class GameResultTest {
    @DisplayName("정답 또는 힌트를 제공한다")
    @ParameterizedTest
    @MethodSource("provider_정답_또는_힌트를_제공한다")
    void 정답_또는_힌트를_제공한다(BaseballGameNumber answer, BaseballGameNumber guess, boolean isAnswer, boolean hasHint){
        GameResult gameResult = new GameResult(answer, guess);
        assertThat(gameResult.isAnswer()).isEqualTo(isAnswer);
        assertThat(gameResult.hasHint()).isEqualTo(hasHint);

    }

    static Stream<Arguments> provider_정답_또는_힌트를_제공한다(){
        BaseballGameNumber answer = new BaseballGameNumber(1,2,3);
        BaseballGameNumber correctGuess = new BaseballGameNumber(1,2,3);
        BaseballGameNumber guess = new BaseballGameNumber(4,5,6);
        return Stream.of(
                Arguments.of(answer, correctGuess, true, false),
                Arguments.of(answer, guess, false, true)
                );
    }

    @DisplayName("같은_수가_같은_자리에_있으면_스트라이크이다")
    @ParameterizedTest
    @MethodSource("provider_같은_수가_같은_자리에_있으면_스트라이크이다")
    void 같은_수가_같은_자리에_있으면_스트라이크이다(BaseballGameNumber answer, BaseballGameNumber guess, int expectedStrike){
        GameResult result = new GameResult(answer, guess);
        assertThat(result.strike())
                .isEqualTo(expectedStrike);
    }
    static Stream<Arguments> provider_같은_수가_같은_자리에_있으면_스트라이크이다(){
        return Stream.of(
                Arguments.of(BaseballGameNumberFixture.정답, BaseballGameNumberFixture.낫싱, 0),
                Arguments.of(BaseballGameNumberFixture.정답, BaseballGameNumberFixture._1스트라이크, 1),
                Arguments.of(BaseballGameNumberFixture.정답, BaseballGameNumberFixture._2스트라이크, 2),
                Arguments.of(BaseballGameNumberFixture.정답, BaseballGameNumberFixture._3스트라이크, 3)
        );
    }

    @DisplayName("같은_수가_다른_자리에_있으면_볼이다")
    @ParameterizedTest
    @MethodSource("provider_같은_수가_다른_자리에_있으면_볼이다")
    void 같은_수가_다른_자리에_있으면_볼이다(BaseballGameNumber answer, BaseballGameNumber guess, int expectedBall){
        GameResult result = new GameResult(answer, guess);
        assertThat(result.ball())
                .isEqualTo(expectedBall);
    }

    static Stream<Arguments> provider_같은_수가_다른_자리에_있으면_볼이다(){
        return Stream.of(
                Arguments.of(BaseballGameNumberFixture.정답, BaseballGameNumberFixture.낫싱, 0),
                Arguments.of(BaseballGameNumberFixture.정답, BaseballGameNumberFixture._3스트라이크, 0),
                Arguments.of(BaseballGameNumberFixture.정답, BaseballGameNumberFixture._1볼, 1),
                Arguments.of(BaseballGameNumberFixture.정답, BaseballGameNumberFixture._2볼, 2),
                Arguments.of(BaseballGameNumberFixture.정답, BaseballGameNumberFixture._3볼, 3)
        );
    }

    @DisplayName("같은_수가_전혀_없으면_낫싱이다")
    @Test
    void 같은_수가_전혀_없으면_낫싱이다(){
        GameResult result = new GameResult(BaseballGameNumberFixture.정답, BaseballGameNumberFixture.낫싱);
        assertThat(result.ball())
                .isEqualTo(0);
        assertThat(result.strike())
                .isEqualTo(0);
        assertThat(result.isNothing())
                .isTrue();
    }

}
