package link.i.additionally;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParametersTest {

    @Test
       @DisplayName("��� ������� ����")
    public void testAnnotated() {
        Allure.parameter("������", "���������� �������");
        Allure.parameter("�����", "������");

    }

}
