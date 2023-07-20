package com.azulCRM.pages;


import com.azulCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendMessagePage {

    public SendMessagePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@id='feed-add-post-form-tab-message']/span")
    public WebElement messageTab;


  @FindBy(xpath = "//body[@contenteditable='true']")
   public WebElement messageBody;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendButton;

    @FindBy(xpath = "//div[text()='Test Message SC1']")
    public WebElement sentMessage;

    @FindBy(xpath = "//span[@class='feed-add-info-text']")
    public WebElement errorEmptyMessage;

    @FindBy(xpath = "//span[@class='feed-add-post-del-but']")
    public WebElement deselectRecipient;

    @FindBy(xpath = "//span[@class='feed-add-info-text']")
    public WebElement errorEmptyRecipient;

    @FindBy(xpath = "//button[@id='blog-submit-button-cancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//span[@class='feed-add-post-destination-text']")
    public WebElement allEmployeesElement;


}
