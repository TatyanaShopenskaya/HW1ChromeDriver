package org.example.Sem2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
    public class ElementPage {
        @FindBy(xpath = "//button")
        private List<WebElement> elements;

        public ElementPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        public void deletePost() {
            elements.get(1).click();
        }

    }

