package link.i;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {
    SelenideElement searchInput = $(".header-search-input");
    String repository = "eroshenkoam/webdriver-coverage-plugin",
            issueName = "Incorrect display of locator counters on the page",
            address = "https://github.com";

    @Test
    @DisplayName("Подтверждение имени ищью с помощью селенида")
    public void testIssueNameSelenide() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open(address);
        searchInput.click();
        searchInput.sendKeys(repository);
        searchInput.submit();
        $(linkText(repository)).click();
        $(partialLinkText("Issues")).click();
        $(withText(issueName)).shouldBe(Condition.visible);
    }
}
