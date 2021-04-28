import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class RetryIntentionTest {

    @DisplayName("RETRY_인_경우_게임을_새로_시작하고_EXIT_인_경우_게임을_종료한다")
    @Test
    void RETRY_인_경우_게임을_새로_시작하고_EXIT_인_경우_게임을_종료한다() {
        Assertions.assertAll(
                () -> assertThat(RetryIntention.RETRY.isRetry()).isTrue(),
                () -> assertThat(RetryIntention.EXIT.isRetry()).isFalse()
        );
    }

    @ParameterizedTest(name = "1, 2 가 아닌 경우 - {0} 값의 경우에는 IllegalArgumentException 을 던진다")
    @ValueSource(ints = {3, 4})
    void _1_2_값_외에는_IllegalArgumentException_을_던진다(int value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RetryIntention.valueOf(value));
    }

    @ParameterizedTest(name = "{0} {1}인경우 isRetry {2}이다")
    @CsvSource({"1,true", "2,false"})
    void _1_인_경우_isRetry_true_2인_경우_isRetry_false_이다(int value, boolean isRetry) {
        assertThat(RetryIntention.valueOf(value).isRetry())
                .isEqualTo(isRetry);
    }
}