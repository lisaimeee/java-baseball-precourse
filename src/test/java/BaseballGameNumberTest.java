import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class BaseballGameNumberTest {
    @DisplayName("숫자는_세자리_수이다")
    @Test
    void 숫자는_세자리_수이다() {
        int first = 1;
        int second = 2;
        int third = 3;
        BaseballGameNumber baseballGameNumber = new BaseballGameNumber(first, second, third);

        Assertions.assertAll(
                () -> assertThat(baseballGameNumber.first())
                        .isNotNull()
                        .isEqualTo(first),
                () -> assertThat(baseballGameNumber.second())
                        .isNotNull()
                        .isEqualTo(second),
                () -> assertThat(baseballGameNumber.third())
                        .isNotNull()
                        .isEqualTo(third)
        );
    }

    @DisplayName("숫자는_1_9_까지_수로_이루어져_있다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "4,5,6", "7,8,9"})
    void 숫자는_1_9_까지_수로_이루어져_있다(int first, int second, int third) {
        BaseballGameNumber baseballGameNumber = new BaseballGameNumber(first, second, third);
        List<Integer> _1To9NumberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(_1To9NumberList)
                .contains(baseballGameNumber.first())
                .contains(baseballGameNumber.second())
                .contains(baseballGameNumber.third());
    }

    @DisplayName("숫자가_1_9_사이의_숫자가_아니면_IllegalArgumentException_을_던진다")
    @ParameterizedTest
    @CsvSource(value = {"0,2,3", "1,10,3", "1,2,-1"})
    void 숫자가_1_9_사이의_숫자가_아니면_IllegalArgumentException_을_던진다(int first, int second, int third) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BaseballGameNumber(first, second, third))
                .withMessage("1-9 사이의 숫자를 입력해주세요.");
    }


    @DisplayName("세자리_수는_서로_다른_수로_이루어져_있다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "4,5,6", "7,8,9"})
    void 세자리_수는_서로_다른_수로_이루어져_있다(int first, int second, int third) {
        BaseballGameNumber baseballGameNumber = new BaseballGameNumber(first, second, third);
        assertThat(
                new HashSet<>(
                        Arrays.asList(baseballGameNumber.first(),
                                baseballGameNumber.second(),
                                baseballGameNumber.third())))
                .hasSize(3);
    }

    @DisplayName("서로_다른_수를_입력하지_않으면_IllegalArgumentException_을_던진다")
    @ParameterizedTest
    @CsvSource(value = {"1,1,3", "4,5,5", "9,8,9"})
    void 서로_다른_수를_입력하지_않으면_IllegalArgumentException_을_던진다(int first, int second, int third) {
        assertThatIllegalArgumentException().
                isThrownBy(() -> new BaseballGameNumber(first, second, third))
                .withMessage("서로 다른 숫자를 입력해주세요.");

    }
}
