package HW2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.example.Sem2.*;

import java.util.List;

public class LoginTest extends AbstractTest {

    @Test
    void loginTest() throws InterruptedException {
        driver.get("https://test-stand.gb.ru/login");

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loginInSystem("GB202309fef0812", "73bca41767");

        Thread.sleep(2000L);
        List<WebElement> searchList = driver.findElements(By.partialLinkText("Hello"));
        Assertions.assertEquals(1, searchList.size());

        MainPage mainPage = new MainPage(driver);
        mainPage.createPost();

        List<WebElement> title = driver.findElements(By.xpath("//*[@type='text']"));
        Assertions.assertEquals(1, title.size());

        CreatePostPage createPostPage = new CreatePostPage(driver);
        createPostPage.savePost("Post 26.02", "Today is 26.02");

        Thread.sleep(2000L);
//        ElementPage elementPage = new ElementPage(driver);
//        elementPage.deletePost();

    }

}
