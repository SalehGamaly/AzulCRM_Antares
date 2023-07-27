package com.azulCRM.pages;

import com.azulCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Poll_page {

    public Poll_page(){PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(name="USER_LOGIN")
    public WebElement login;

    @FindBy(name="USER_PASSWORD")
    public WebElement password;

    @FindBy(className = "login-btn")
    public WebElement loginButton;

    @FindBy(xpath = "(//span[@class='menu-item-link-text'])[1])")
    public WebElement ActivityStream;

    @FindBy(xpath = "//span[@id='feed-add-post-form-tab-vote']/span")
    public WebElement Poll;

    @FindBy(xpath = "//span[@class='feed-add-post-destination-text']")
    public WebElement AllEmployees;

    @FindBy(xpath = "//body[@style='min-height: 184px;']")
    public WebElement MessageField;

    @FindBy(xpath = "//input[@placeholder='Question ']")
    public WebElement questionField;

    @FindBy(xpath = "//input[@placeholder='Answer  1']")
    public WebElement answer1Field;

    @FindBy(xpath = "//input[@placeholder='Answer  2']")
    public WebElement answer2Field;

//    @FindBy(xpath = "//button[@class='ui-btn ui-btn-lg ui-btn-primary']")
    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButton;

    @FindBy(xpath = "//input[@id='multi_0']")
    public WebElement checkboxButton;

    @FindBy(xpath = "//span[@class='feed-add-post-del-but']")
    public WebElement unselectButton;

    @FindBy(xpath = "//span[@class='feed-add-info-text']")
    public WebElement onePersonErreur;

    @FindBy(className = "feed-add-info-text")
    public WebElement notSpecifiedErreur;

    @FindBy(className = "feed-add-info-text")
    public WebElement noAnswerErreur;

    @FindBy(className = "feed-add-info-text")
    public WebElement noQuestionErreur;

    @FindBy(className = "feed-add-info-text")
    public WebElement errorMessage;







}
