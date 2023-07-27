package com.azulCRM.step_definitions;

import com.azulCRM.pages.LoginPage;
import com.azulCRM.pages.SendMessagePage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertNotEquals;

import java.time.Duration;



public class SendMessageStepDefs {

    WebDriver driver = Driver.getDriver();
    SendMessagePage messagePage = new SendMessagePage();
    private String filledInMessage;

    //1
    @Given("user is on the Activity Stream page")
    public void user_is_on_the_activity_stream_page() {
        Driver.getDriver().get("https://qa.azulcrm.com/");

    }


    @And("user fills in the message content and recipient fields")
    public void user_fills_in_the_message_content_and_recipient_fields() {

        driver.switchTo().frame(driver.findElement(By.className("bx-editor-iframe")));

        messagePage.messageBody.click();

       messagePage.messageBody.sendKeys("Test Message SC1");

        driver.switchTo().defaultContent();


    }
    @And("user clicks on the Send button")
    public void user_clicks_on_the_send_button() {
        messagePage.sendButton.click();
    }
    @Then("the message should be sent to the recipient")
    public void the_message_should_be_sent_to_the_recipient_s() {
        messagePage.sentMessage.isDisplayed();
    }


    //2
    @When("user clicks on the Send button without filling in the message content")
    public void user_clicks_on_the_send_button_without_filling_in_the_message_content() {
        messagePage.sendButton.click();
    }

    @Then("user should see an error message that says {string}")
    public void user_should_see_an_error_message_that_says_the_message_title_is_not_specified(String expectedTitleError) {
        String actualTitleError = messagePage.errorEmptyMessage.getText();

        Assert.assertEquals(actualTitleError,expectedTitleError);
    }

    //3
    @And("user clicks on the Send button without a selected recipient")
    public void user_clicks_on_the_send_button_without_a_selected_recipient() {
        messagePage.deselectRecipient.click();
        messagePage.sendButton.click();

    }



    @Then("user should see a recipient error message that says {string}")
    public void user_should_see_an_error_message_that_says_please_specify_at_least_one_person(String expectedErrorMessage) {
        messagePage.errorEmptyRecipient.isDisplayed();
        String actualErrorMessage = messagePage.errorEmptyRecipient.getText();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

    }

    //4
    @When("user fills in the message content")
    public void user_fills_in_the_message_content() {
        driver.switchTo().frame(driver.findElement(By.className("bx-editor-iframe")));

        messagePage.messageBody.click();

        messagePage.messageBody.sendKeys("Test Message 4");

        driver.switchTo().defaultContent();
    }

    @And("user clicks on the Send button without specifying any recipients")
    public void user_clicks_on_the_send_button_without_specifying_any_recipients() {
        messagePage.sendButton.click();
    }

    @Then("the message delivery should be to {string}")
    public void the_message_delivery_should_be_to_all_employees(String expectedEmployees) {

        String actualEmployees = messagePage.allEmployeesElement.getText();

        Assert.assertEquals(actualEmployees, expectedEmployees);
    }

    //5
    @When("user is on the Message tab")
    public void user_is_on_the_message_tab() {
        messagePage.messageTab.click();
    }

    @When("user fills in {string} message")
    public void user_fills_in_message(String messageContent) {
        driver.switchTo().frame(driver.findElement(By.className("bx-editor-iframe")));

        messagePage.messageBody.click();

        messagePage.messageBody.sendKeys(messageContent);

        filledInMessage = messagePage.messageBody.getText();

        driver.switchTo().defaultContent();

    }

    @When("user clicks on the Cancel button")
    public void user_clicks_on_the_cancel_button() {


        messagePage.cancelButton.click();
    }
    @Then("the message should be cancelled")
    public void the_message_should_be_cancelled() {
        driver.switchTo().frame(driver.findElement(By.className("bx-editor-iframe")));
        String cancelledMessage = messagePage.messageBody.getText();

        assertNotEquals(cancelledMessage,filledInMessage);


    }


    @And("user clicks on the {string} tab")
    public void userClicksOnTheTab(String tab) {

        Driver.getDriver().findElement(By.xpath("//span[.='"+tab+"']")).click();

    }
}
