public class BaseballGameNumberFixture {
    private BaseballGameNumberFixture() {

    }

    public static final BaseballGameNumber 정답 = new BaseballGameNumber(1, 2, 3);
    public static final BaseballGameNumber 일치하는_수_없음 = new BaseballGameNumber(4, 5, 6);
    public static final BaseballGameNumber 같은수_모두_같은자리 = new BaseballGameNumber(1, 2, 3);
    public static final BaseballGameNumber 다른자리_하나_일치 = new BaseballGameNumber(4, 1, 6);
    public static final BaseballGameNumber 다른자리_둘_일치 = new BaseballGameNumber(2, 3, 6);
    public static final BaseballGameNumber 다른자리_셋_일치 = new BaseballGameNumber(3, 1, 2);
    public static final BaseballGameNumber 같은수_같은자리_하나일치 = new BaseballGameNumber(1, 5, 6);
    public static final BaseballGameNumber 같은수_같은자리_두개일치 = new BaseballGameNumber(1, 2, 6);
    public static final BaseballGameNumber 같은수_같은자리_세개일치 = new BaseballGameNumber(1, 2, 3);

}
