package menu.domain.coach;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private Name name;
    private List<String> cantEatMenus;
    private List<String> recommendedMenus;

    public Coach(Name name, List<String> cantEatMenus) {
        this.name = name;
        this.cantEatMenus = cantEatMenus;
        this.recommendedMenus = new ArrayList<>();
    }

    public boolean isCantEatMenu(String menuName) {
        return cantEatMenus.contains(menuName);
    }

    public boolean alreadyRecommendedMenu(String menuName) {
        return recommendedMenus.contains(menuName);
    }
}
