import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseTest {
  @BeforeAll
  static void setUp(){
    Configuration.browser= "edge";
    com.codeborne.selenide.Configuration.browserSize = "1920x1080";
    Configuration.pageLoadStrategy = "eager";
  }
}
