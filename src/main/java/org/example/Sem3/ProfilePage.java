package org.example.Sem3;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import java.io.File;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
public class ProfilePage {
    @FindBy(xpath = "//h2[@class='mdc-typography--headline6 svelte-vyyzan']")
    private SelenideElement h2fullName;
    @FindBy(xpath = "//h3/following-sibling::div" +
            "//div[contains(text(), 'Full name')]/following-sibling::div")
    private SelenideElement fullName;
    private final SelenideElement editProfile = $("button[title='More options']");
    private final SelenideElement newAvatarImageInput = $("input[type='file']");
    //или локатор $x("//form[@id='update-item']//span[contains(text(), 'New Avatar')]/following-sibling::input")
    // этот вариант говорит, что искомый элемент находится внутри другой вновь открывшейся формы

    private final SelenideElement saveProfileUpdateData = $("button[type='submit']");



    public String getH2FullNameText () {
        return h2fullName.shouldBe(visible).text();
    }

    public String getFullNameText () {
        return fullName.shouldBe(visible).text();
    }

    public void clickEditProfile () {
        editProfile.shouldBe(visible).click();
    }
    public void uploadNewAvatarImage (String pathToFile) {
        newAvatarImageInput.shouldBe(visible).uploadFile(new File(pathToFile));
    }
    public String getUploadFileName () {
        return newAvatarImageInput.getValue();
    }

    public void clickSaveProfileUpdateData () {
        saveProfileUpdateData.shouldBe(visible).click();
    }

}
