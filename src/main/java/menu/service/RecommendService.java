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
            Category category = Category.getCategoryByCode(Randoms.pickNumberInRange(1, 5));

            while (Collections.frequency(categoryHistory.values(), category) > 2) {
                category = Category.getCategoryByCode(Randoms.pickNumberInRange(1, 5));
            }

            categoryHistory.put(dayWeek, category);

            for (Coach coach : crew.getCoaches()) {
                String menu = Randoms.shuffle(Menu.getMenusByCategory(category)).get(0);

                while (coach.alreadyRecommendedMenu(menu) || coach.isCantEatMenu(menu)) {
                     menu = Randoms.shuffle(Menu.getMenusByCategory(category)).get(0);
                }

                coach.addRecommendMenu(menu);
            }
        }
        return categoryHistory;
    }
}
