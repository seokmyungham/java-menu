package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import menu.domain.DayWeek;
import menu.domain.coach.Coach;
import menu.domain.coach.Crew;
import menu.domain.menu.Category;
import menu.domain.menu.Menu;

public class RecommendService {

    public Map<DayWeek, Category> service(Crew crew) {
        Map<DayWeek, Category> categoryHistory = new HashMap<>();
        for (DayWeek dayWeek : DayWeek.values()) {
            Category category = recommendCategory(categoryHistory);
            categoryHistory.put(dayWeek, category);
            recommendMenuToCoach(crew, category);
        }
        return categoryHistory;
    }

    private Category recommendCategory(Map<DayWeek, Category> categoryHistory) {
        Category category = Category.getCategoryByCode(Randoms.pickNumberInRange(1, 5));
        while (isCategoryOverMaximum(categoryHistory, category)) {
            category = Category.getCategoryByCode(Randoms.pickNumberInRange(1, 5));
        }
        return category;
    }

    private boolean isCategoryOverMaximum(Map<DayWeek, Category> categoryHistory, Category category) {
        return Collections.frequency(categoryHistory.values(), category) > 2;
    }

    private void recommendMenuToCoach(Crew crew, Category category) {
        for (Coach coach : crew.getCoaches()) {
            String menu = Randoms.shuffle(Menu.getMenusByCategory(category)).get(0);
            while (cantRecommendMenu(coach, menu)) {
                 menu = Randoms.shuffle(Menu.getMenusByCategory(category)).get(0);
            }
            coach.addRecommendMenu(menu);
        }
    }

    private boolean cantRecommendMenu(Coach coach, String menu) {
        return coach.alreadyRecommendedMenu(menu) || coach.isCantEatMenu(menu);
    }
}
