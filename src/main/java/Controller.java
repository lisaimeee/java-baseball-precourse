public class Controller {

    public void startGame() {
        try {
            run();
        } catch (RuntimeException e) {
            PrintView.printErrorMessage(e.getMessage());
        }
    }

    private void run() {
        boolean retry = true;
        while (retry) {
            runNewGame();
            retry = askUserRetryOrExit().isRetry();
        }
    }

    private void runNewGame() {
        BaseballGameNumber answer = BaseballGameNumber.of(GameOperator.get3DistinctNumbers());
        boolean gameRunning = true;
        while (gameRunning) {
            PrintView.printRequestUserInputMessage();
            BaseballGameNumber guess = BaseballGameNumber.of(InputView.getUserGuess());
            GameResult result = new GameResult(answer, guess);
            PrintView.printResultMessage(result);
            gameRunning = !result.isAnswer();
        }
    }

    private RetryIntention askUserRetryOrExit() {
        PrintView.printRetryMessage();
        return InputView.retryOrExit();
    }
}
