package menu.domain.menu;

import static menu.domain.menu.Category.ASIAN;
import static menu.domain.menu.Category.CHINESE;
import static menu.domain.menu.Category.JAPANESE;
import static menu.domain.menu.Category.KOREAN;
import static menu.domain.menu.Category.WESTERN;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Menu {
    JAPANESE_MENU(JAPANESE, List.of(
            "규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오꼬노미야끼")),
    KOREAN_MENU(KOREAN, List.of(
            "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE_MENU(CHINESE, List.of(
            "깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN_MENU(ASIAN, List.of(
            "팟타이", "카오 팟", "나시고랭", "파인애플 볶음밥", "쌀국수", "똠양꿍", "반미", "월남쌈", "분짜")),
    WESTERN_MENU(WESTERN, List.of(
            "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private Category category;
    private List<String> menuNames;

    Menu(Category category, List<String> menuNames) {
        this.category = category;
        this.menuNames = menuNames;
    }

    public static List<String> getMenusByCategory(Category category) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.category.equals(category))
                .findFirst()
                .map(menu -> menu.menuNames)
                .orElse(Collections.emptyList());
    }
}
