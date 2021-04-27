public class PrintView {
    private static final int TRY_ANOTHER_GAME = 1;
    private static final int EXIT_GAME = 2;
    private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요: ";

    private static final String ANOTHER_GAME_OR_EXIT_MESSAGE =
            String.format("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.", TRY_ANOTHER_GAME, EXIT_GAME);

    public void printRequestUserInputMessage() {
        System.out.println(NUMBER_INPUT_MESSAGE);
    }

    public void printResultMessage(GameResult result) {
        System.out.println(GameResultMessage.message(result));
    }

}
