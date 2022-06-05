package link.i;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    SelenideElement searchInput = $(".header-search-input");
    String address = "https://github.com";

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open(address);
    }

    @Step("ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        searchInput.click();
        searchInput.sendKeys(repo);
        searchInput.submit();
    }

    @Step("Переходим по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Кликаем на Issues")
    public void openIssuesTab() {
        $(partialLinkText("Issues")).click();
    }

    @Step("Проверяем, что существует Issues с названием {issueName}")
    public void shouldSeeIssueWithName(String issueName) {
        $(withText(issueName)).shouldBe(Condition.visible);
        attachScreenshot();
    }

    @Attachment(value = "Screamshout", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
