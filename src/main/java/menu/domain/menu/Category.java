package menu.domain.menu;

public enum Category {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);

    private String name;
    private int code;

    Category(String name, int code) {
        this.name = name;
        this.code = code;
    }
}
