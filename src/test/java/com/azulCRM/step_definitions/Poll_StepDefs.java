package com.azulCRM.step_definitions;

import com.azulCRM.pages.Poll_page;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Poll_StepDefs {

    WebDriver driver = Driver.getDriver();

    Poll_page pollPage = new Poll_page();

    @Given("User is on the log in page")
    public void user_is_on_the_log_in_page() {
        Driver.getDriver().get("https://qa.azulcrm.com/");
    }
    @When("User enter the username")
    public void user_enter_the_username() {
        pollPage.login.sendKeys("hr1@cybertekschool.com");

    }
    @When("user enter the password")
    public void user_enter_the_password() {

        pollPage.password.sendKeys("UserUser");

    }
    @When("user click to log in button")
    public void user_click_to_log_in_button() {

        pollPage.loginButton.click();

    }

    @When("user click to Poll button")
    public void user_click_to_poll_button() {

        pollPage.Poll.click();

    }

    @Then("verify All employees set by default")
    public void verifyAllEmployeesSetByDefault() {

        String expectedResult = "All employees";
        String actualResult = pollPage.AllEmployees.getText();

        Assert.assertEquals(expectedResult, actualResult);

    }

    @When("user enter a simple message {string}")
    public void userEnterASimpleMessage(String message) {

        driver.switchTo().frame(driver.findElement(By.className("bx-editor-iframe")));
        pollPage.MessageField.click();
        pollPage.MessageField.sendKeys(message);
        driver.switchTo().parentFrame();
    }

    @And("user enter the question {string}.")
    public void userEnterTheQuestion(String question) {
        pollPage.questionField.sendKeys(question);
    }


    @And("user enter the first answer {string}")
    public void userEnterTheFirstAnswer(String answer) {
        pollPage.answer1Field.sendKeys(answer);

    }

    @And("user enter the second answer {string}")
    public void userEnterTheSecondAnswer(String answer) {
        pollPage.answer2Field.sendKeys(answer);

    }

    @Then("user click to send button")
    public void userClickToSendButton() {
        pollPage.sendButton.click();
    }

    @Then("user select the allow multiple choice checkbox")
    public void userSelectTheAllowMultipleChoiceCheckbox() {
        pollPage.checkboxButton.click();
    }

    @Then("user click to the unselect button")
    public void userClickToTheUnselectButton() {
        pollPage.unselectButton.click();

    }

    @Then("verify the  Error message is Please specify at least one person.")
    public void verifyTheErrorMessageIsPleaseSpecifyAtLeastOnePerson() {
        String expectedErreurMessage= "Please specify at least one person.";
        String actualErreurMessage =pollPage.onePersonErreur.getText();

        Assert.assertEquals(expectedErreurMessage, actualErreurMessage);
    }

    @Then("verify the Error message is The message title is not specified")
    public void verifyTheErrorMessageIsTheMessageTitleIsNotSpecified() {
        String expectedTitleNotSpecified = "The message title is not specified";
        String actualTitleNotSpecified = pollPage.notSpecifiedErreur.getText();

        Assert.assertEquals(expectedTitleNotSpecified, actualTitleNotSpecified);
    }


    @Then("user verify the question what is your favorite color? has no answers.")
    public void userVerifyTheQuestionWhatIsYourFavoriteColorHasNoAnswers() {
        String expectedTitleNoAnswer = "The question \"what is your favorite color?\" has no answers.";
        String actualTitleNoAnswer = pollPage.noAnswerErreur.getText();

        Assert.assertEquals(expectedTitleNoAnswer, actualTitleNoAnswer);
    }

    @Then("user should see the erreur message the question text is not specified.")
    public void userShouldSeeTheErreurMessageTheQuestionTextIsNotSpecified() {
        String expectedTitleNoAnswer = "The question text is not specified.";
        String actualTitleNoAnswer = pollPage.noAnswerErreur.getText();

        Assert.assertEquals(expectedTitleNoAnswer, actualTitleNoAnswer);
    }

    @Then("{string} error message is displayed")
    public void errorMessageIsDisplayed(String expectedErrorMessage) {
        String actualTitleNoAnswer = pollPage.errorMessage.getText();
        Assert.assertEquals(expectedErrorMessage, actualTitleNoAnswer);

    }
}
