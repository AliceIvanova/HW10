import com.codeborne.selenide.Condition;
import com.codeborne.selenide.conditions.TextCondition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class IssueTest {
  @Test
  void testIssueSearch() {
    SelenideLogger .addListener("allure", new AllureSelenide());
    open("https://github.com/");
    $(".header-search-button").click();
    $("#query-builder-test").sendKeys("AliceIvanova/HW10");
    $("#query-builder-test").submit();

    $(linkText("AliceIvanova/HW10")).click();
    $("#issues-tab").click();
    $(".mt-4").shouldHave(Condition.text("Issue of HW10"));
  }

}