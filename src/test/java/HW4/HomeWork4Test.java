// Задание 2.

package HW4;
import com.codeborne.selenide.Selenide;
import org.example.Sem4.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.page;;
public class HomeWork4Test extends Abstract4Test {

    @Test
    void changeDateTest() {
            LoginPage loginPage = page(LoginPage.class);
            loginPage.authorize("GB202309fef0812", "73bca41767");

            StudentPage studentPage = page(StudentPage.class);
            studentPage.openProfilePage();

            ProfilePage profilePage = page(ProfilePage.class);
            profilePage.clickEditProfile();
            profilePage.changeBirthdate("10.02.2002");
            Selenide.sleep(5000L);
            Assertions.assertEquals("10.02.2002", profilePage.getBirthdate());
        }
}