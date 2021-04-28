package view;

import domain.GameResult;

public class PrintView {

    private static final int TRY_ANOTHER_GAME = 1;
    private static final int EXIT_GAME = 2;
    private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요: ";
    public static final String RETRY_MESSAGE = "게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.";

    private PrintView() {

    }

    private static final String ANOTHER_GAME_OR_EXIT_MESSAGE =
            String.format("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.", TRY_ANOTHER_GAME, EXIT_GAME);

    public static void printRequestUserInputMessage() {
        System.out.print(NUMBER_INPUT_MESSAGE);
    }

    public static void printResultMessage(GameResult result) {
        System.out.println(GameResultMessage.message(result));
    }

    public static void printRetryMessage(){
        System.out.println(RETRY_MESSAGE);
    }

    public static void printErrorMessage(String message){
        System.err.println(message);
    }
}
