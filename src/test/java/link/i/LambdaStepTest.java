package link.i;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest {
    SelenideElement searchInput = $(".header-search-input");
    String repository = "eroshenkoam/webdriver-coverage-plugin",
            issueName = "Incorrect display of locator counters on the page",
            address = "https://github.com";

    @Test
    public void testIssueNameLambda() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("��������� ������� ��������", () -> open(address));
        step("���� �����������" + repository, () -> {
            searchInput.click();
            searchInput.sendKeys(repository);
            searchInput.submit();
        });
        step("��������� �� ������ �����������", () -> $(linkText(repository)).click());
        step("������� �� Issues", () -> $(partialLinkText("Issues")).click());
        step("���������, ��� ���������� Issues � ��������� " + issueName, () -> {
            $(withText(issueName)).click();
            Allure.getLifecycle().addAttachment(
                    "��������� ��������",
                    "text/html",
                    "html",
                    WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8));
        });
    }
}
