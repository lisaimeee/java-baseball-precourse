import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class GameOperatorTest {
    @DisplayName("1_에서_9_까지_서로_다른_임의의_수_3개를_선택한다.")
    @Test
    void _1_에서_9_까지_서로_다른_임의의_수_3개를_선택한다() {
        List<Integer> numbers = GameOperator.get3DistinctNumbers();
        Assertions.assertAll(
                () -> assertThat(numbers)
                        .hasSize(3),
                () -> assertThat(new HashSet<>(numbers))
                        .hasSize(3),
                () -> assertThat(BaseballGameNumber._1To9NumberList.containsAll(numbers))
                        .isTrue()
        );
    }
}
