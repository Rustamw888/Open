package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class SmokeTests extends TestBase {

    @Test
    @Description("Проверка вкладки 'карты'")
    @DisplayName("Отображение внутренних компонентов вкладки 'карты'")
    void generatedTest() {
        step("Открыть главную страницу", () ->
            open("https://www.open.ru/"));
    }

    @Test
    @Description("Отсутствие ошибок в консоли")
    @DisplayName("Консоль браузера не должна иметь ошибок")
    void consoleShouldNotHaveErrorsTest() {
        step("Открыть главную страницу", () ->
                open("https://www.open.ru/"));

        step("Консоль браузера не содержит текст 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}