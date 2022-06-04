package link.i.additionally;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 76 ;

    @Test
    @Owner("karafiat")
    @Link(value = "Testing", url = "https://github.com")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Задачи в репозитории")
    @Story("Просмотр созданных задач в репозитории")
    @DisplayName("Мой любимый тест")

    public void testAnnotated() {
    }
}
