package menu.view;

import java.util.Map;
import java.util.StringJoiner;
import menu.domain.DayWeek;
import menu.domain.coach.Coach;
import menu.domain.coach.Crew;
import menu.domain.menu.Category;

public class OutputView {

    public static final String COMPLETE_MESSAGE = "추천을 완료했습니다.";

    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printRecommendResult(Map<DayWeek, Category> resultCategories, Crew crew) {
        System.out.println();
        System.out.println("메뉴 추천 결과입니다.");
        printWeekDay(resultCategories);
        printCategories(resultCategories);
        printMenus(crew);
    }

    public void printWeekDay(Map<DayWeek, Category> resultCategories) {
        StringJoiner stringJoiner = new StringJoiner(" | ", "[ 구분 | ", " ]");
        for (DayWeek dayWeek : resultCategories.keySet()) {
            stringJoiner.add(dayWeek.getName());
        }
        System.out.println(stringJoiner.toString());
    }

    public void printCategories(Map<DayWeek, Category> resultCategories) {
        StringJoiner stringJoiner = new StringJoiner(" | ", "[ 카테고리 | ", " ]");
        for (Category category : resultCategories.values()) {
            stringJoiner.add(category.getName());
        }
        System.out.println(stringJoiner.toString());
    }

    public void printMenus(Crew crew) {
        for (Coach coach : crew.getCoaches()) {
            StringJoiner stringJoiner = new StringJoiner(" | ", "[ ", " ]");
            stringJoiner.add(coach.getName());
            for (String menuName : coach.getRecommendedMenus()) {
                stringJoiner.add(menuName);
            }
            System.out.println(stringJoiner.toString());
        }
    }

    public void printCompleteMessage() {
        System.out.println();
        System.out.println(COMPLETE_MESSAGE);
    }
}
