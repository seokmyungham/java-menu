package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String INPUT_COACH_NAME_PROMPT = "%n코치의 이름을 입력해 주세요. (, 로 구분)%n";
    public static final String INPUT_CANT_EAT_MENUS_PROMPT = "%n%s(이)가 못 먹는 메뉴를 입력해 주세요.%n";

    public String inputCoachName() {
        System.out.printf(INPUT_COACH_NAME_PROMPT);
        return Console.readLine();
    }

    public String inputCantEatMenus(String coachName) {
        System.out.printf(INPUT_CANT_EAT_MENUS_PROMPT);
        return Console.readLine();
    }
}
