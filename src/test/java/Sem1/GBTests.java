package Sem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GBTests {

    @Test
    void loginTest(){
        String pathToChromeDriver = "src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //залипание времени
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.get("https://test-stand.gb.ru/login");
        WebElement userNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("form#login input[type='text]")));
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("form#password input[type='text]")));

        userNameField.sendKeys(System.setProperty("geekbrains-username", System.getenv("geekbrains-username")));
        passwordField.sendKeys(System.setProperty("geekbrains-password", System.getenv("geekbrains-password")));

        WebElement loginButton = driver.findElement(By.cssSelector("formlogin button"));
        loginButton.click();
        wait.until(ExpectedConditions.invisibilityOf(loginButton));

        WebElement usernameLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(System.getProperty("geekbrains-username",System.getenv("geekbrains-username")))));
        String actualUsername = usernameLink.getText().replace("\n"," ").trim();
        Assertions.assertEquals(
                String.format("Hello, %s",System.getProperty("geekbrains-username",System.getenv("geekbrains-username"))),
                actualUsername);
        driver.quit();
    }
}
