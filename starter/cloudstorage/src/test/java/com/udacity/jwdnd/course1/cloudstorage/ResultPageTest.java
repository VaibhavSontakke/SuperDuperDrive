package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPageTest {

    @FindBy(xpath = "//*[contains(@href,'home')]")
    private WebElement homeLink;

    @FindBy(id ="successMsg")
    private WebElement successMsg;

    public ResultPageTest(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getSuccessMessage() {
        String successMasssage = successMsg.getText();
        return successMasssage;
    }

    public void backToHome() {
        homeLink.click();
    }

}
