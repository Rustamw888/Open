package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("openTest")
public class SmokeTests extends TestBase {

    // locators
    SelenideElement smallAndMediumBusinessTab = $("[role='menuitem'] [href='/small']");
    SelenideElement smallMedMainComponent = $(".open-ui-container.section--anketa");
    SelenideElement wrapForm = $("#rko_performance3");
    SelenideElement brokerTile = $("[href='/brokerage?from=product_slider_finance']");
    SelenideElement dealsTile = $("[href='/finance/repo?from=product_slider_finance']");
    SelenideElement operationsTile = $("[href='/finance/finance_markets?from=product_slider_finance']");
    SelenideElement privateBankingTab = $("[role='menuitem'] [href='https://pb.open.ru']");
    SelenideElement logo = $(".pr-menu .pr-menu__logo");


    // tests
    @Test
    @Description("Проверка вкладки 'Private Banking'")
    @DisplayName("Отображение внутренних компонентов вкладки 'Private Banking'")
    void privateBankingTest() {
        step("Открыть главную страницу", () ->
                open("https://www.open.ru/"));

        step("Кликаем на вкладку 'Private Banking'", () -> {
            privateBankingTab.click();
        });

        step("Вкладка 'Private Banking' имеет компоненты", () -> {
            assertEquals($$("[data-modal-id='#modal-form']").size(), 2);
            logo.shouldBe(visible);
        });
    }

    @Test
    @Description("Проверка вкладки 'Финансовым институтам'")
    @DisplayName("Отображение внутренних компонентов вкладки 'Финансовым институтам")
    void financialInstitutionsTest() {
        step("Открыть страницу 'Финансовым институтам'", () -> {
            open("https://www.open.ru/finance");
        });

        step("Вкладка 'Финансовым институтам' имеет компоненты", () -> {
            brokerTile.shouldHave(text("Брокерское обслуживание"));
            dealsTile.shouldHave(text("Сделки РЕПО"));
            operationsTile.shouldHave(text("Операции с банкнотами"));
        });
    }

    @Test
    @Description("Проверка вкладки 'Малому и среднему бизнесу'")
    @DisplayName("Отображение внутренних компонентов вкладки 'Малому и среднему бизнесу'")
    void smallMiddleBusinessTest() {
        step("Открыть главную страницу", () ->
            open("https://www.open.ru/"));

        step("Кликаем на вкладку 'Малому и среднему бизнесу'", () -> {
            smallAndMediumBusinessTab.click();
        });

        step("Вкладка 'Малому и среднему бизнесу' имеет компоненты", () -> {
            smallMedMainComponent.shouldHave(text("Откройте расчетный счет для бизнеса"));
            smallMedMainComponent.shouldHave(text("Заявка"));
            smallMedMainComponent.shouldHave(text("Консультация"));
            smallMedMainComponent.shouldHave(text("Открытие счета"));
        });
    }

    @Test
    @Description("Проверка заголовков главной страницы")
    @DisplayName("Title должен содержать текст")
    void titleTest() {
        step("Открыть главную страницу", () ->
                open("https://www.open.ru/"));

        step("Title должен содержать текст 'Частным клиентам | Банк Открытие'", () -> {
            String expectedTitle = "Частным клиентам | Банк Открытие";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
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