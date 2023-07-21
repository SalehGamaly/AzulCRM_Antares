package com.azulCRM.step_definitions;


import com.azulCRM.pages.MessagePage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AttachFileStepDefinitions {

    WebDriver driver = Driver.getDriver();
    MessagePage messagePage = new MessagePage();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    @Given("user is on the Home page")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get("https://qa.azulcrm.com/");

    }


    @And("user clicks on the Message tab")
    public void user_clicks_on_the_message_tab() {
        messagePage.messageBtn.click();


    }

    @And("user clicks Upload files and images box")
    public void userClicksUploadFilesAndImagesBox() {
        messagePage.attachBtn.click();
    }



    @Then("user uploads the files as messages in following formats:pdf, txt, jpeg, png, docx")
    public void userUploadsTheFilesAsMessagesInFollowingFormatsPdfTxtJpegPngDocx() {


        String projectPath = System.getProperty("user.dir");

        //the path of the file
        String filePathPDF = "src/test/resources/filesToUpload/java.pdf";

        //it concatenates the project path and the file path to obtain the full path of the PNG file
        String fullPathPDF = projectPath + "/" + filePathPDF;
        String filePathPNG = "src/test/resources/filesToUpload/java.png";
        String fullPathPNG = projectPath + "/" + filePathPNG;
        String filePathTXT = "src/test/resources/filesToUpload/java.txt";
        String fullPathTXT = projectPath + "/" + filePathTXT;
        String filePathJPG = "src/test/resources/filesToUpload/java.jpg";
        String fullPathJPG = projectPath + "/" + filePathJPG;
        String filePathDOCX = "src/test/resources/filesToUpload/java.docx";
        String fullPathDOCX = projectPath + "/" + filePathDOCX;


            messagePage.uploadFilesBox.sendKeys(fullPathDOCX);
            messagePage.uploadFilesBox.sendKeys(fullPathPDF);
            messagePage.uploadFilesBox.sendKeys(fullPathJPG);
            messagePage.uploadFilesBox.sendKeys(fullPathPNG);
            messagePage.uploadFilesBox.sendKeys(fullPathTXT);

            BrowserUtils.sleep(10);




    }


    @When("user uploads the files as messages")
    public void userUploadsTheFilesAsMessages() {
        String projectPath = System.getProperty("user.dir");

        //the path of the file
        String filePathPDF = "src/test/resources/filesToUpload/java.pdf";

        //it concatenates the project path and the file path to obtain the full path of the PNG file
        String fullPathPDF = projectPath + "/" + filePathPDF;

        messagePage.uploadFilesBox.sendKeys(fullPathPDF);


        BrowserUtils.sleep(10);


    }



    @And("user clicks Insert in text button")
    public void userClicksInsertInTextButton() {
        messagePage.insertInText.click();
    }

    @Then("Message box contains the file.")
    public void messageBoxContainsTheFile() {

        driver.switchTo().frame(driver.findElement(By.className("bx-editor-iframe")));

        Assert.assertTrue(messagePage.messageBody.getText().contains("pdf"));

    }
    @When("user uploads the files as messages in")
    public void userUploadsTheFilesAsMessagesIn() {

        String projectPath = System.getProperty("user.dir");

        String filePathPNG = "src/test/resources/filesToUpload/java.png";
        String fullPathPNG = projectPath + "/" + filePathPNG;




            messagePage.uploadFilesBox.sendKeys(fullPathPNG);






        }
    @And("user clicks the Remove button")
    public void userClicksTheRemoveButton() {
        messagePage.deleteBtn.click();

    }

    @Then("user can see the files being removed")
    public void userCanSeeTheFilesBeingRemoved() {
        Assert.assertTrue(!(messagePage.attachedFiles.getText().contains("b\t\n" +
                "My Drive / Uploaded files")));
    }



}




