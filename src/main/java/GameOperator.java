import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameOperator {
    private final static int SIZE = 3;
    private final static int FROM = 0;
    private GameOperator() {

    }

    public static List<Integer> get3DistinctNumbers() {
        List<Integer> oneToNine = new ArrayList<>(BaseballGameNumber._1To9NumberList);
        Collections.shuffle(oneToNine);
        return oneToNine.subList(FROM, SIZE);
    }
}
