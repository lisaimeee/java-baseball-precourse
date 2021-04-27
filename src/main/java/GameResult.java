public class GameResult {
    private final BaseballGameNumber answer;
    private final BaseballGameNumber guess;
    private int strike;
    private int ball;

    public GameResult(BaseballGameNumber answer, BaseballGameNumber guess) {
        this.answer = answer;
        this.guess = guess;
        countStrike();
        countBall();
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

    private void countBall() {
        if (guess.first() == answer.second() || guess.first() == answer.third()) {
            ball++;
        }
        if (guess.second() == answer.first() || guess.second() == answer.third()) {
            ball++;
        }
        if (guess.third() == answer.first() || guess.third() == answer.second()) {
            ball++;
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

    public int ball() {
        return ball;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }
}
