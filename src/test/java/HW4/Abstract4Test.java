package HW4;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class Abstract4Test {
    @BeforeEach
    void init() {

//        Configuration.remote = "http://localhost:4444/wd/hub";
//        Configuration.browser = "chrome";
//        Configuration.browserVersion = "114";
//        Map<String, Object> options = new HashMap<>();
//        options.put("enableVNC", true);
//        options.put("enableLog", true);
//        Configuration.browserCapabilities.setCapability("selenoid:options", options);
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        open("https://test-stand.gb.ru/login");
    }

    @AfterEach
    void teardown() {
        WebDriverRunner.closeWebDriver();
    }
}
