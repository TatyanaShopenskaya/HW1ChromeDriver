package org.example.Sem2;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.GetValue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    private final WebDriverWait wait;
    @FindBy(xpath = "//h2[@class='mdc-typography--headline6 svelte-vyyzan']")
    private WebElement h2fullName;
    @FindBy(xpath = "//h3/following-sibling::div" +
            "//div[contains(text(), 'Full name')]/following-sibling::div")
    private WebElement fullName;
    @FindBy(xpath = "//div[contains(text(), 'Date of birth')]/following-sibling::div")
    private WebElement dateOfBirth;
    @FindBy(css = "button[title='More options']")
    private WebElement editProfile;
    @FindBy(css = "input[type='file']")
    private WebElement newAvatarImageInput;
    @FindBy(css = "button[type='submit']")
    private WebElement saveProfileUpdateData;

    @FindBy(css = "input[type='date']")
    private WebElement newBirthDayDateInput;

    @FindBy(css = "button[data-mdc-dialog-action='close']")
    private WebElement closeWidowEditingProfile;


    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    public String getH2FullNameText() {
        return wait.until(ExpectedConditions.visibilityOf(h2fullName)).getText();
    }

    public String getFullNameText() {
        return wait.until(ExpectedConditions.visibilityOf(fullName)).getText();
    }

    public String getDayOfBirthText() {
        return wait.until(ExpectedConditions.visibilityOf(dateOfBirth)).getText();
    }


    public void clickEditProfile() throws InterruptedException {
//        Thread.sleep(3000L);
        wait.until(ExpectedConditions.visibilityOf(editProfile)).click();
    }

    public void uploadNewAvatarImage(String pathToFile) {
        wait.until(ExpectedConditions.visibilityOf(newAvatarImageInput)).sendKeys(pathToFile);
    }

    public String getUploadFileName() {
        return newAvatarImageInput.getAttribute("value");
    }

    public void uploadnewBirthDayDate(String date) {
        wait.until(ExpectedConditions.visibilityOf(newBirthDayDateInput)).clear();
        newBirthDayDateInput.sendKeys(date);
    }


    public void clickSaveProfileUpdateData() {
        wait.until(ExpectedConditions.visibilityOf(saveProfileUpdateData)).click();
    }

    public void clickCloseWidowEditingProfile() throws InterruptedException {
        Thread.sleep(1000L);
        wait.until(ExpectedConditions.visibilityOf(closeWidowEditingProfile)).click();
    }


}
