import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class BaseballGameNumber {
    public final static List<Integer> _1To9NumberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private final static int BASEBALL_GAME_NUMBER_SIZE = 3;
    private final int first;
    private final int second;
    private final int third;

    public BaseballGameNumber(int first, int second, int third) {
        shouldOneToNine(first, second, third);
        shouldUnique(first, second, third);

        this.first = first;
        this.second = second;
        this.third = third;
    }

    private void shouldOneToNine(int first, int second, int third) {
        shouldOneToNine(first);
        shouldOneToNine(second);
        shouldOneToNine(third);
    }

    private void shouldOneToNine(int number) {
        if (!_1To9NumberList.contains(number)) {
            throw new IllegalArgumentException("1-9 사이의 숫자를 입력해주세요.");
        }
    }

    private void shouldUnique(int first, int second, int third) {
        Set<Integer> set = new HashSet<>(Arrays.asList(first, second, third));
        if(set.size() != BASEBALL_GAME_NUMBER_SIZE){
            throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요.");
        }
    }

    public int first() {
        return first;
    }

    public int second() {
        return second;
    }

    public int third() {
        return third;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballGameNumber that = (BaseballGameNumber) o;
        return first == that.first && second == that.second && third == that.third;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }
}
