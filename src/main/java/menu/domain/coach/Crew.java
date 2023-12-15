package menu.domain.coach;

import static menu.constant.ErrorMessage.CREW_SIZE_ERROR_MESSAGE;

import java.util.List;

public class Crew {
    private final List<Coach> coaches;

    public Crew(List<Coach> coaches) {
        validateCrewSize(coaches);
        this.coaches = coaches;
    }

    private void validateCrewSize(List<Coach> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException(CREW_SIZE_ERROR_MESSAGE);
        }
    }
}
