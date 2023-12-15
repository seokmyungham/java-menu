package menu.domain;

public enum DayWeek {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    private String name;

    DayWeek(String name) {
        this.name = name;
    }
}
