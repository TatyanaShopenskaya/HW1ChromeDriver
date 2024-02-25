package HW2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractTest {
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    static void init() {

        ChromeOptions chromeOptions = new ChromeOptions();    // Настройки локального WebDriver.a
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterAll
    static void teardown() throws InterruptedException {
        Thread.sleep(2000L);
        driver.quit();
    }
}

