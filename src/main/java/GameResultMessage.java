public class GameResultMessage {
    private static final String STRIKE_MESSAGE = "%d 스트라이크";
    private static final String BALL_MESSAGE = "%d 볼";
    private static final String EMPTY_MESSAGE = "";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String CORRECT_ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임종료";

    private GameResultMessage() {

    }

    public static String message(GameResult result) {
        if (result.isAnswer()) {
            return CORRECT_ANSWER_MESSAGE;
        }
        if(result.isNothing()){
            return nothingMessage(result);
        }
        return hintMessage(result);
    }

    private static String hintMessage(GameResult result) {
        if(result.strike() == 0){
            return ballMessage(result);
        }
        if(result.ball() == 0){
            return strikeMessage(result);
        }
        return String.join(" ", strikeMessage(result), ballMessage(result));
    }

    private static String strikeMessage(GameResult result) {
        if (result.strike() > 0) {
            return String.format(STRIKE_MESSAGE, result.strike());
        }
        return EMPTY_MESSAGE;
    }

    private static String ballMessage(GameResult result) {
        if (result.ball() > 0) {
            return String.format(BALL_MESSAGE, result.ball());
        }
        return EMPTY_MESSAGE;
    }

    private static String nothingMessage(GameResult result) {
        if (result.strike() == 0 && result.ball() == 0) {
            return NOTHING_MESSAGE;
        }
        return EMPTY_MESSAGE;
    }

}
