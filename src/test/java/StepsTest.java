import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {
  private static final String searchField = "#query-builder-test";
  private static final String repository = "AliceIvanova/HW10";
  private static final String wlc = "Issue of HW10";
  private static final String issuesTab = "#issues-tab";
  private static final String containerText = ".mt-4";
  private static final String clickButton = ".header-search-button";

  @Test
  void testIssueSearch() {
    SelenideLogger.addListener("allure", new AllureSelenide());

    step("Открываем главную страницу", () -> {
      open("https://github.com/");
    });
    step("Кликаем по полю", () -> {
      $(clickButton).click();
    });

    step("Вводим адрес репозитория", () -> {
      $(searchField).sendKeys(repository);
    });
    step("Подтверждаем ввод", () -> {
      $(searchField).submit();
    });

    step("Кликаем по ссылке репозитория", () -> {
      $(linkText(repository)).click();
    });
    step("Переходим на вкладку Issue", () -> {
      $(issuesTab).click();
    });
    step("Проверяем наличие сообщения Добро пожаловать", () -> {
      $(containerText).shouldHave(Condition.text(wlc));
    });
  }

  @Test
  public void testAnnotatedStep() {
    SelenideLogger.addListener("allure", new AllureSelenide());
    WebStepsTest steps = new WebStepsTest();

    steps.openMainPage();
    steps.searchForRepository();
    steps.clickRepository();
    steps.issueTab();
    steps.nameOfIssue();
  }
}