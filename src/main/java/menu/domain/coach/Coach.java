package menu.domain.coach;

import static menu.constant.ErrorMessage.CANT_EAT_MENUS_SIZE_ERROR_MESSAGE;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final Name name;
    private final List<String> cantEatMenus;
    private final List<String> recommendedMenus;

    public Coach(Name name, List<String> cantEatMenus) {
        this.name = name;
        validateCantEatMenusSize(cantEatMenus);
        this.cantEatMenus = cantEatMenus;
        this.recommendedMenus = new ArrayList<>();
    }

    public boolean isCantEatMenu(String menuName) {
        return cantEatMenus.contains(menuName);
    }

    public boolean alreadyRecommendedMenu(String menuName) {
        return recommendedMenus.contains(menuName);
    }

    public void addRecommendMenu(String menuName) {
        recommendedMenus.add(menuName);
    }

    public List<String> getRecommendedMenus() {
        return recommendedMenus;
    }

    private void validateCantEatMenusSize(List<String> cantEatMenus) {
        if (cantEatMenus.size() > 2) {
            throw new IllegalArgumentException(CANT_EAT_MENUS_SIZE_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return name.getName();
    }
}
