public class GameResult {
    private final BaseballGameNumber answer;
    private final BaseballGameNumber guess;
    private int strike;

    public GameResult(BaseballGameNumber answer, BaseballGameNumber guess) {
        this.answer = answer;
        this.guess = guess;
        countStrike();
    }

    private void countStrike() {
        if (guess.first() == answer.first()) {
            strike++;
        }
        if (guess.second() == answer.second()) {
            strike++;
        }
        if (guess.third() == answer.third()) {
            strike++;
        }
    }

    public boolean isAnswer() {
        return answer.equals(guess);
    }

    public boolean hasHint() {
        return !isAnswer();
    }

    public int strike() {
        return strike;
    }
}
