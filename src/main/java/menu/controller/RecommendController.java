package menu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import menu.domain.DayWeek;
import menu.domain.coach.Coach;
import menu.domain.coach.Crew;
import menu.domain.coach.Name;
import menu.domain.menu.Category;
import menu.service.RecommendService;
import menu.util.InputParser;
import menu.util.InputValidator;
import menu.view.InputView;
import menu.view.OutputView;

public class RecommendController {

    private final RecommendService recommendService;
    private final InputView inputView;
    private final OutputView outputView;

    public RecommendController() {
        this.recommendService = new RecommendService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void process() {
        outputView.printStartMessage();
        Crew crew = getCrewProcess();
        Map<DayWeek, Category> resultCategories = recommendService.service(crew);
        outputView.printRecommendResult(resultCategories, crew);
        outputView.printCompleteMessage();
    }

    private List<String> getCoachNames() {
        try {
            String coachNameInput = inputView.inputCoachName();
            InputValidator.validateCoachNameInputFormat(coachNameInput);
            List<String> coachNames = InputParser.parseInputByDelimiter(coachNameInput, ",");
            InputValidator.validateCoachSize(coachNames);
            InputValidator.validateCoachNameDuplicate(coachNames);
            return coachNames;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCoachNames();
        }
    }

    private Crew getCrewProcess() {
        List<String> coachNames = getCoachNames();
        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachNames) {
            getCantEatMenus(coaches, coachName);
        }
        return new Crew(coaches);
    }

    private void getCantEatMenus(List<Coach> coaches, String coachName) {
        try {
            String cantEatMenus = inputView.inputCantEatMenus(coachName);
            coaches.add(new Coach(new Name(coachName), InputParser.parseInputByDelimiter(cantEatMenus, ",")));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getCantEatMenus(coaches, coachName);
        }
    }

}
