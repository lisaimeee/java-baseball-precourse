package domain;

import domain.BaseballGameNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
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
    @ParameterizedTest(name = "예) [{0},{1},{2}] 를 입력했을 때 ")
    @CsvSource(value = {"0,2,3", "1,10,3", "1,2,-1"})
    void 숫자가_1_9_사이의_숫자가_아니면_IllegalArgumentException_을_던진다(int first, int second, int third) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BaseballGameNumber(first, second, third))
                .withMessage("1-9 사이의 숫자를 입력해주세요.");
    }


    @DisplayName("세자리_수는_서로_다른_수로_이루어져_있다")
    @ParameterizedTest(name = "예) [{0},{1},{2}] 를 입력했을 때 정상 동작한다")
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
    @ParameterizedTest(name = "예) [{0},{1},{2}] 를 입력했을 때")
    @CsvSource(value = {"1,1,3", "4,5,5", "9,8,9"})
    void 서로_다른_수를_입력하지_않으면_IllegalArgumentException_을_던진다(int first, int second, int third) {
        assertThatIllegalArgumentException().
                isThrownBy(() -> new BaseballGameNumber(first, second, third))
                .withMessage("서로 다른 숫자를 입력해주세요.");

    }

    @Test
    void 리스트를_받아_BaseballGameNumber_를_생성한다() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        assertThat(BaseballGameNumber.of(numbers))
                .hasFieldOrPropertyWithValue("first", numbers.get(0))
                .hasFieldOrPropertyWithValue("second", numbers.get(1))
                .hasFieldOrPropertyWithValue("third", numbers.get(2));
    }

    @DisplayName("리스트 사이즈가 3이 아니면 IllegalArgumentException 을 던진다")
    @ParameterizedTest(name = "예) 사이즈가 {0} 일 때 ")
    @ValueSource(ints = {0, 1, 2, 4, 10})
    void 리스트_사이즈가_3_이_아니면_IllegalArgumentException_을_던진다(int size) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            numbers.add(i);
        }

        assertThatIllegalArgumentException()
                .isThrownBy(() -> BaseballGameNumber.of(numbers));
    }
}
