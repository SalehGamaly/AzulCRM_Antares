package com.azulCRM.step_definitions;

import com.azulCRM.pages.LoginPage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class AzulCRMLogin_StepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page of the CRM application")
    public void user_is_on_the_login_page_of_the_crm_application() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }
    @When("user enters HR information")
    public void user_enters_hr_information() {
        loginPage.login(ConfigurationReader.getProperty("hr_username"), ConfigurationReader.getProperty("hr_password"));

    }
    @When("user enters Marketing information")
    public void user_enters_marketing_information() {
        loginPage.login(ConfigurationReader.getProperty("marketing_username"), ConfigurationReader.getProperty("marketing_password"));

    }

    @When("user enters Helpdesk information")
    public void user_enters_helpdesk_information() {
        loginPage.login(ConfigurationReader.getProperty("marketing_username"), ConfigurationReader.getProperty("marketing_password"));

    }
    @Then("user should land on homepage")
    public void user_should_land_on_homepage() {
        BrowserUtils.sleep(3);

        String expectedInTitle = "Portal";

        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
    }

    @When("the user login with below {string}, {string}")
    public void theUserLoginWithBelow(String username, String password) {
        loginPage.login(username,password);
    }

    @Then("the user should not be able to log in")
    public void the_user_should_not_be_able_to_log_in() {
        BrowserUtils.verifyTitle("Authorization");
    }



}
