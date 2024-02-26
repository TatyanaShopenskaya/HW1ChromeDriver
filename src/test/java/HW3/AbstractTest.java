package HW3;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
public class AbstractTest {
    @BeforeEach
    void setup() {
        Selenide.open("https://test-stand.gb.ru/login");
    }

    @AfterEach
    void teardown() {
        WebDriverRunner.closeWebDriver();
    }
}
