package org.example.Sem4;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import java.io.File;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {
    private final SelenideElement fullNameRow = $x("//div[@class='profile-info svelte-vyyzan']/div[1]/div[2]");
    private final SelenideElement fullNameUnderCard = $x("//div[@class='mdc-card']/div[2]/h2");
    private final SelenideElement birthdate = $x("//div[@class='profile-info svelte-vyyzan']/div[2]/div[2]");
    private final SelenideElement editProfile = $x("//button[@title='More options']");
    private final SelenideElement newAvatarImageInput = $x("//input[@type='file']");
    private final SelenideElement saveProfileUpdateData = $x("//button[@type='submit']");
    private final SelenideElement birthdateField = $x("//input[@type='date']");
    private final SelenideElement closeButton = $x("//button[@data-mdc-dialog-action='close']");

    public String getTextFullNameRow() {
        return fullNameRow.shouldBe(visible).text();
    }

    public String getTextFullNameUnderCard() {
        return fullNameUnderCard.shouldBe(visible).text();
    }

    public void clickEditProfile() {
        editProfile.shouldBe(visible).click();
    }

    public void uploadNewAvatarImage(String path) {
        newAvatarImageInput.shouldBe(visible).uploadFile(new File(path));
    }

    public String getFileName() {
        return newAvatarImageInput.getValue();
    }
    public String getBirthdate() {
        return birthdate.shouldBe(visible).text();
    }

    public void clickSaveProfileUpdateData() {
        saveProfileUpdateData.shouldBe(visible).click();

    }
    public void changeBirthdate(String birthdate){
        Selenide.sleep(5000L);
        birthdateField.shouldBe(visible).setValue(birthdate);
        clickSaveProfileUpdateData();
        closeButton.shouldBe(visible).click();
    }
}