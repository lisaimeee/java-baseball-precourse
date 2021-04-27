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

}
