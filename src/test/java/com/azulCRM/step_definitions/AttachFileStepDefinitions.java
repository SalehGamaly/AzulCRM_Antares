package com.azulCRM.step_definitions;

import com.azulCRM.pages.LoginPage;
import com.azulCRM.pages.MessagePage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;

public class AttachFileStepDefinitions {


    MessagePage messagePage = new MessagePage();

    LoginPage loginPage = new LoginPage();



    @Given("The user is on Home page")
    public void userIsOnHomePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.login(ConfigurationReader.getProperty("helpDesk_username"), ConfigurationReader.getProperty("UserUser"));

        BrowserUtils.waitFor(4);

    }


    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);


    @When("user clicks on the message tab")
    public void user_clicks_on_the_message_tab() {
       messagePage.messageBtn.click();
    }
    @When("user clicks on on the attach icon")
    public void user_clicks_on_on_the_attach_icon() {
     messagePage.attachBtn.click();

    }
    @Then("user sees {string} box")
    public void userSeesBox() {
       Assert.assertTrue(messagePage.uploadFilesBox.isDisplayed());
    }

    @Then("user uploads the files as messages")
    public void user_uploads_the_files_as_messages() {
        String projectPath = System.getProperty("user.dir");

        //the path of the file
        String filePathPDF = "src/test/resources/filesToUpload/java.pdf";

        //it concatenates the project path and the file path to obtain the full path of the PNG file
        String fullPathPDF = projectPath + "/" + filePathPDF;

        if (fullPathPDF.substring(fullPathPDF.lastIndexOf(".") + 1) != "pdf") {
            System.exit(1);
        } else {

            messagePage.uploadFilesBox.sendKeys(fullPathPDF);



        }

        wait.until(ExpectedConditions.invisibilityOf(messagePage.loadingBar));



        String projectPath1 = System.getProperty("user.dir");

        //the path of the file
        String filePathPNG = "src/test/resources/filesToUpload/pngg.png";


        //it concatenates the project path and the file path to obtain the full path of the PNG file
        String fullPathPNG = projectPath1 + "/" + filePathPNG;
        if (fullPathPNG.substring(fullPathPNG.lastIndexOf(".") + 1) != "png") {
            System.exit(1);
        } else{


            messagePage.uploadFilesBox.sendKeys(fullPathPNG);


    }
        wait.until(ExpectedConditions.invisibilityOf(messagePage.loadingBar));

        String projectPath2 = System.getProperty("user.dir");

        //the path of the file
        String filePathTXT = "src/test/resources/filesToUpload/q.txt";

        //it concatenates the project path and the file path to obtain the full path of the PNG file
        String fullPathTXT = projectPath2 + "/" + filePathTXT;

        if (fullPathTXT.substring(fullPathTXT.lastIndexOf(".") + 1) != "txt") {
            System.exit(1);
        } else {


            messagePage.uploadFilesBox.sendKeys(filePathTXT);

        }


        wait.until(ExpectedConditions.invisibilityOf(messagePage.loadingBar));


        String projectPath3 = System.getProperty("user.dir");

        //the path of the file
        String filePathJPG = "src/test/resources/filesToUpload/sun.jpg";

        //it concatenates the project path and the file path to obtain the full path of the PNG file
        String fullPathJPG = projectPath3 + "/" + filePathJPG;
        if (fullPathJPG.substring(fullPathJPG.lastIndexOf(".") + 1) != "jpg") {
            System.exit(1);
        } else {


            messagePage.uploadFilesBox.sendKeys(fullPathJPG);
        }


        wait.until(ExpectedConditions.invisibilityOf(messagePage.loadingBar));

        String projectPath4 = System.getProperty("user.dir");

        //the path of the file
        String filePathDOCX = "src/test/resources/filesToUpload/test.docx";

        //it concatenates the project path and the file path to obtain the full path of the PNG file
        String fullPathDOCX = projectPath4 + "/" + filePathDOCX;

        if (fullPathDOCX.substring(filePathDOCX.lastIndexOf(".") + 1) != "docx") {
            System.exit(1);
        } else {


            messagePage.uploadFilesBox.sendKeys(fullPathDOCX);
        }


        wait.until(ExpectedConditions.invisibilityOf(messagePage.loadingBar));

    }



    @When("user uploads the file")
    public void user_uploads_the_file() {
        String projectPath = System.getProperty("user.dir");

        //the path of the file
        String filePathPDF = "src/test/resources/filesToUpload/java.pdf";

        //it concatenates the project path and the file path to obtain the full path of the PNG file
        String fullPathPDF = projectPath + "/" + filePathPDF;

        messagePage.uploadFilesBox.sendKeys(fullPathPDF);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        wait.until(ExpectedConditions.invisibilityOf(messagePage.loadingBar));

        String projectPath1 = System.getProperty("user.dir");

        //the path of the file
        String filePathPNG = "src/test/resources/filesToUpload/pngg.png";

        //it concatenates the project path and the file path to obtain the full path of the PNG file
        String fullPathPNG = projectPath1 + "/" + filePathPNG;

        messagePage.uploadFilesBox.sendKeys(fullPathPNG);


        wait.until(ExpectedConditions.invisibilityOf(messagePage.loadingBar));

        String projectPath2 = System.getProperty("user.dir");

        //the path of the file
        String filePathTXT = "src/test/resources/filesToUpload/q.txt";

        //it concatenates the project path and the file path to obtain the full path of the PNG file
        String fullPathTXT = projectPath2 + "/" + filePathTXT;

        messagePage.uploadFilesBox.sendKeys(fullPathTXT);


        wait.until(ExpectedConditions.invisibilityOf(messagePage.loadingBar));


        String projectPath3 = System.getProperty("user.dir");

        //the path of the file
        String filePathJPG = "src/test/resources/filesToUpload/sun.jpg";

        //it concatenates the project path and the file path to obtain the full path of the PNG file
        String fullPathJPG = projectPath3 + "/" + filePathJPG;

        messagePage.uploadFilesBox.sendKeys(fullPathJPG);


        wait.until(ExpectedConditions.invisibilityOf(messagePage.loadingBar));

        String projectPath4 = System.getProperty("user.dir");

        //the path of the file
        String filePathDOCX = "src/test/resources/filesToUpload/test.docx";

        //it concatenates the project path and the file path to obtain the full path of the PNG file
        String fullPathDOCX = projectPath4 + "/" + filePathDOCX;

        messagePage.uploadFilesBox.sendKeys(fullPathDOCX);


        wait.until(ExpectedConditions.invisibilityOf(messagePage.loadingBar));

    }
    @When("user sees the {string} button after uploading")
    public void user_sees_the_button_after_uploading() {
      messagePage.deleteBtn.isDisplayed();
    }
    @When("user clicks the {string} button")
    public void user_clicks_the_button() {
       messagePage.deleteBtn.click();
    }
    @Then("user can see the files being removed")
    public void user_can_see_the_files_being_removed() {

    }




    @Given("The user is on {string} page")
    public void theUserIsOnPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.login(ConfigurationReader.getProperty("helpDesk_username"), ConfigurationReader.getProperty("UserUser"));

        BrowserUtils.waitFor(4);
    }


    @Then("user sees {string} option")
    public void userSeesOption() {
        messagePage.insertInText.isDisplayed();
    }

    @And("user clicks {string} button")
    public void userClicksButton() {
        messagePage.insertInText.click();
    }

    @Then("user sees file in text.")
    public void user_sees_file_in_text() {
        Driver.getDriver().switchTo().frame(messagePage.messageBody);
        Assert.assertFalse(messagePage.messageBody.getText().isEmpty());

    }


}


