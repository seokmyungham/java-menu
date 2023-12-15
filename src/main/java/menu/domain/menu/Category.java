package menu.domain.menu;

import java.util.Arrays;

public enum Category {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);

    public static final String INVALID_CODE_ERROR_MESSAGE = "[ERROR] 코드와 일치하는 카테고리를 찾지 못했습니다.";

    private String name;
    private int code;

    Category(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public static Category getCategoryByCode(int code) {
        return Arrays.stream(Category.values())
                .filter(category -> category.code == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_CODE_ERROR_MESSAGE));
    }
}