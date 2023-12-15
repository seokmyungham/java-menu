package menu.util;

import static menu.constant.ErrorMessage.INPUT_FORMAT_ERROR_MESSAGE;

public class InputValidator {
    private static final String COACH_NAME_INPUT_FORMAT = "^[가-힣a-zA-Z0-9]+(,[가-힣a-zA-Z0-9]+)*$";

    public static void validateCoachNameInputFormat(String input) {
        if (!input.matches(COACH_NAME_INPUT_FORMAT)) {
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR_MESSAGE);
        }
    }
}
