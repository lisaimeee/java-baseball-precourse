public class GameResult {
    private final BaseballGameNumber answer;
    private final BaseballGameNumber guess;

    public GameResult(BaseballGameNumber answer, BaseballGameNumber guess) {
        this.answer = answer;
        this.guess = guess;
    }

    public boolean isAnswer() {
        return answer.equals(guess);
    }

    public boolean hasHint() {
        return !isAnswer();
    }
}
