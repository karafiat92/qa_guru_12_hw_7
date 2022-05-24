package link.i.additionally;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParametersTest {

    @Test
       @DisplayName("Мой любимый тест")
    public void testAnnotated() {
        Allure.parameter("Регион", "Московская область");
        Allure.parameter("Город", "Москва");

    }

}
