package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPageTest {

    @FindBy(id = "inputUsername")
    private WebElement userNameField;

    @FindBy(id = "inputPassword")
    private WebElement passwordField;

    @FindBy(tagName = "button")
    private WebElement submitBtn;

    public LogInPageTest(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loginUser(String userName, String password) {
        userNameField.sendKeys(String.valueOf(userName));
        passwordField.sendKeys(String.valueOf(password));
        try {
            submitBtn.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
