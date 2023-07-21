package com.azulCRM.step_definitions;

import com.azulCRM.pages.CompanyStructurePage;
import com.azulCRM.pages.LoginPage;
import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CompanyStructure_stepDefinition {

    @Given("user is on the login page of the AzulCRM application")
    public void user_is_on_the_login_page_of_the_azul_crm_application() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    LoginPage loginPage = new LoginPage();

    @Given("user enters hr username")
    public void user_enters_hr_username() {
    loginPage.login.sendKeys(ConfigurationReader.getProperty("hr_username"));

    }
    @Given("user enters hr password")
    public void user_enters_hr_password() {
        loginPage.password.sendKeys(ConfigurationReader.getProperty("hr_password"));
        loginPage.loginButton.click();

    }
    CompanyStructurePage companyStructurePage = new CompanyStructurePage();


    @Then("user clicks employee menu")
    public void userClicksEmployeeMenu() {
        companyStructurePage.employeeMenu.click();
    }

    @And("user sees Company Structure in the employee menu")
    public void userSeesCompanyStructureInTheEmployeeMenu() {

        companyStructurePage.companyStructure.isDisplayed();

    }

    @Given("user enters Helpdesk username")
    public void user_enters_helpdesk_username() {
    loginPage.login.sendKeys(ConfigurationReader.getProperty("helpDesk_username"));

    }
    @Given("user enters Helpdesk password")
    public void user_enters_helpdesk_password() {
        loginPage.password.sendKeys(ConfigurationReader.getProperty("helpDesk_password"));
        loginPage.loginButton.click();

    }
    @Then("user Helpdesk sees Company Structure in the employee menu")
    public void userHelpdeskSeesCompanyStructureInTheEmployeeMenu() {
        companyStructurePage.employeeMenu.click();
        companyStructurePage.companyStructure.isDisplayed();
    }

    @Given("user enters Marketing username")
    public void userEntersMarketingUsername() {
        loginPage.login.sendKeys(ConfigurationReader.getProperty("marketing_username"));
    }

    @And("user enters Marketing password")
    public void userEntersMarketingPassword() {
        loginPage.password.sendKeys(ConfigurationReader.getProperty("marketing_password"));
        loginPage.loginButton.click();
    }
    @Then("user marketing sees Company Structure in the employee menu")
    public void userMarketingSeesCompanyStructureInTheEmployeeMenu() {
        companyStructurePage.employeeMenu.click();
        companyStructurePage.companyStructure.isDisplayed();

    }



}
