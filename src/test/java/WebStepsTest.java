import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebStepsTest {
  private static final String searchField="#query-builder-test";
  private static final String repository="AliceIvanova/HW9";
  private static final String wlc="Welcome to issues!";
  private static final String issuesTab="#issues-tab";
  private static final String containerText=".container-md";
  private static final String clickButton=".header-search-button";
  @Step("Открытие стрицы")
  void openMainPage(){
    open("https://github.com/");
  }
  @Step("Поиск репозитория")
  public void searchForRepository(){
    $(clickButton).click();
    $(searchField).sendKeys(repository);
    $(searchField).submit();
  }
  @Step("Клик по ссылке")
  public void clickRepository(){
    $(linkText(repository)).click();
  }
  @Step("Переход на вкладку Issue")
  public void issueTab(){
    $(issuesTab).click();
  }
  @Step("Приветственное сообщение")
  public void welcomeText(){
    $(containerText).shouldHave(Condition.text(wlc));
  }
  @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
  public byte[] takeScreenshot() {
    return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
  }
}
