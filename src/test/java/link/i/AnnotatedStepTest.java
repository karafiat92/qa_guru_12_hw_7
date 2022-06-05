package link.i;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {

    private static final String REPOSITORY = "eroshenkoam/webdriver-coverage-plugin",
            ISSUE_NAME = "Incorrect display of locator counters on the page";

    @Test
    @DisplayName("Подтверждение имени ищью с помощью аннотаций")
    public void testIssueNameAnnotated() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithName(ISSUE_NAME);
    }

}
