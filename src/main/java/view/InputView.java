package view;

import controller.RetryIntention;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final char ZERO = '0';

    private InputView() {

    }

    public static List<Integer> getUserGuess() {
        String line = SCANNER.nextLine();
        char[] charArray = line.toCharArray();
        return convertToIntegerList(charArray);
    }

    public static RetryIntention retryOrExit() {
        int input = SCANNER.nextInt();
        return RetryIntention.valueOf(input);
    }

    private static List<Integer> convertToIntegerList(char[] charArray) {
        if (Objects.isNull(charArray) || charArray.length != 3) {
            throw new IllegalArgumentException("세 자리 숫자를 입력해주세요.");
        }
        return Arrays.asList(parseInt(charArray[0]), parseInt(charArray[1]), parseInt(charArray[2]));
    }

    private static Integer parseInt(char number) {
        try {
            return Integer.valueOf(number - ZERO);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자값을 입력해 주세요.");
        }
    }

}
