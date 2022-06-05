package link.i;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Подтверждение имени ищью с помощью лямбды")
    public void testIssueNameLambda() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> open(address));
        step("ищем репозиторий" + repository, () -> {
            searchInput.click();
            searchInput.sendKeys(repository);
            searchInput.submit();
        });
        step("Переходим по ссылке репозитория", () -> $(linkText(repository)).click());
        step("Кликаем на Issues", () -> $(partialLinkText("Issues")).click());
        step("Проверяем, что существует Issues с названием " + issueName, () -> {
            $(withText(issueName)).click();
            Allure.getLifecycle().addAttachment(
                    "исходники страницы",
                    "text/html",
                    "html",
                    WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8));
        });
    }
}
