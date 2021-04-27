import org.assertj.core.api.Assertions;
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
        BaseballGameNumber answer = new BaseballGameNumber(1,2,3);
        BaseballGameNumber 일치하지_않음 = new BaseballGameNumber(4,5,6);
        BaseballGameNumber 같은수_같은자리_하나일치 = new BaseballGameNumber(1,5,6);
        BaseballGameNumber 같은수_같은자리_두개일치 = new BaseballGameNumber(1,2,6);
        BaseballGameNumber 같은수_같은자리_세개일치 = new BaseballGameNumber(1,2,3);

        return Stream.of(
                Arguments.of(answer, 일치하지_않음, 0),
                Arguments.of(answer, 같은수_같은자리_하나일치, 1),
                Arguments.of(answer, 같은수_같은자리_두개일치, 2),
                Arguments.of(answer, 같은수_같은자리_세개일치, 3)
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
        BaseballGameNumber answer = new BaseballGameNumber(1,2,3);
        BaseballGameNumber 일치하는_수_없음 = new BaseballGameNumber(4,5,6);
        BaseballGameNumber 같은수_모두_같은자리 = new BaseballGameNumber(1,2,3);
        BaseballGameNumber 다른자리_하나_일치 = new BaseballGameNumber(4,1,6);
        BaseballGameNumber 다른자리_둘_일치 = new BaseballGameNumber(2,3,6);
        BaseballGameNumber 다른자리_셋_일치 = new BaseballGameNumber(3,1,2);
        return Stream.of(
                Arguments.of(answer, 일치하는_수_없음, 0),
                Arguments.of(answer, 같은수_모두_같은자리, 0),
                Arguments.of(answer, 다른자리_하나_일치, 1),
                Arguments.of(answer, 다른자리_둘_일치, 2),
                Arguments.of(answer, 다른자리_셋_일치, 3)
        );
    }
}
