package menu.domain.coach;

import java.util.List;

public class Coach {
    private Name name;
    private List<String> cantEatMenus;

    public Coach(Name name, List<String> cantEatMenus) {
        this.name = name;
        this.cantEatMenus = cantEatMenus;
    }
}
