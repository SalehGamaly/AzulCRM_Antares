package com.azulCRM.pages;



import com.azulCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name="USER_LOGIN")
    public WebElement login;


    @FindBy(name="USER_PASSWORD")
    public WebElement password;

    @FindBy(className = "login-btn")
    public WebElement loginButton;


    public void login(String userNameStr, String passwordStr) {
        login.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        loginButton.click();
        // verification that we logged
    }
}
