package com.azulCRM.pages;

import com.azulCRM.utilities.Driver;
import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PortalPage {

    public PortalPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[.='Message'])[2]")
    public WebElement messageTab;

    @FindBy(xpath = "//span[@title='Link']")
    public WebElement addLinkButton;

    @FindBy(xpath = "//input[@placeholder='Link URL']")
    public WebElement linkURLBar;

    @FindBy(xpath = "//input[@placeholder='Link text']")
    public WebElement linkTextBar;

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendButton;

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement messageBody;


    @FindBy(xpath = "(//a[@target='_blank'])[12]")
    public WebElement urlText;





}
