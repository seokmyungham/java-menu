package menu.domain.coach;

import static menu.constant.ErrorMessage.COACH_NAME_LENGTH_ERROR_MESSAGE;

public class Name {
    private final String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public void validateNameLength(String input) {
        if (input.length() < 2 || input.length() > 4) {
            throw new IllegalArgumentException(COACH_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
