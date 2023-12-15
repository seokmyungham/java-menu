package menu.util;

import static menu.constant.ErrorMessage.COACH_NAME_DUPLICATED_ERROR_MESSAGE;
import static menu.constant.ErrorMessage.CREW_SIZE_ERROR_MESSAGE;
import static menu.constant.ErrorMessage.INPUT_FORMAT_ERROR_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final String COACH_NAME_INPUT_FORMAT = "^[가-힣a-zA-Z0-9]+(,[가-힣a-zA-Z0-9]+)*$";

    public static void validateCoachNameInputFormat(String input) {
        if (!input.matches(COACH_NAME_INPUT_FORMAT)) {
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR_MESSAGE);
        }
    }

    public static void validateCoachSize(List<String> coachNames) {
        if (coachNames.size() < 2 || coachNames.size() > 5) {
            throw new IllegalArgumentException(CREW_SIZE_ERROR_MESSAGE);
        }
    }

    public static void validateCoachNameDuplicate(List<String> coachNames) {
        Set<String> validate = new HashSet<>(coachNames);

        if (coachNames.size() != validate.size()) {
            throw new IllegalArgumentException(COACH_NAME_DUPLICATED_ERROR_MESSAGE);
        }
    }
}
