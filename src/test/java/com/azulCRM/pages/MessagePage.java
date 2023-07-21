package com.azulCRM.pages;

import com.azulCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessagePage {

    public MessagePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//span[@id='feed-add-post-form-tab-message']/span")
    public WebElement messageBtn;

    @FindBy (xpath = "//span[@id = 'bx-b-uploadfile-blogPostForm']")
    public WebElement attachBtn;


    @FindBy (xpath = "//input[@name='bxu_files[]']")
    public WebElement uploadFilesBox;


    @FindBy(xpath = "//span[@class='feed-and-post-load-number']")
    public WebElement loadingBar;


    @FindBy(xpath = "//span[@bx-bound='Y']")
    public WebElement deleteBtn;

    @FindBy(xpath = "//span[@class='insert-btn']")
    public WebElement insertInText;


    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement messageBody;

    @FindBy(xpath = "(//div[@class = 'diskuf-files-block'])[1]")
    public WebElement attachedFiles;




}


