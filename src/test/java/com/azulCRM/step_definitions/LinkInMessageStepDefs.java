package com.azulCRM.step_definitions;

import com.azulCRM.pages.LoginPage;
import com.azulCRM.pages.PortalPage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class LinkInMessageStepDefs {

    LoginPage loginPage = new LoginPage();
    PortalPage portalPage = new PortalPage();

    WebDriver driver = Driver.getDriver();

    @Given("I am logged in as {string}")
    public void i_am_logged_in_as(String userType) {
        String username =null;
        String password =null;

        if(userType.equalsIgnoreCase("HR")){
            username = ConfigurationReader.getProperty("hr_username");
            password = ConfigurationReader.getProperty("hr_password");
        }else if(userType.equalsIgnoreCase("HelpDesk")){
            username = ConfigurationReader.getProperty("helpDesk_username");
            password = ConfigurationReader.getProperty("helpDesk_password");
        }else if(userType.equalsIgnoreCase("Marketing")){
            username = ConfigurationReader.getProperty("marketing_username");
            password = ConfigurationReader.getProperty("marketing_password");
        }
        //send username and password and login
        new LoginPage().login(username,password);

    }

    @When("I click on the message tab")
    public void i_click_on_the_message_tab() {
        portalPage.messageTab.click();

    }
    @When("I click on the Link icon under the message body")
    public void i_click_on_the_link_icon_under_the_message_body() {
        portalPage.addLinkButton.click();
    }
    @When("I enter the {string} as url link")
    public void i_enter_the_as_url_link(String linkURL) {
        portalPage.linkURLBar.sendKeys(linkURL);
    }
    @Then("I enter the {string} as link text")
    public void i_enter_the_as_link_text(String linkText) {
        portalPage.linkTextBar.sendKeys(linkText);
    }

    @Then("I click on the Save button")
    public void i_click_on_the_save_button() {
        portalPage.saveButton.click();
    }
    @Then("I click on the Send button")
    public void i_click_on_the_send_button() {
        portalPage.sendButton.click();
    }
    @Then("link is attached to the {string} in the message body")
    public void link_is_attached_to_the_in_the_message_body(String linkText) {
        Assert.assertTrue(portalPage.urlText.isEnabled());
    }
    @When("I click on the link in the message body")
    public void i_click_on_the_link_in_the_message_body() {
        portalPage.urlText.click();
    }
    @Then("I should be navigated to the new url and url should contain {string}")
    public void i_should_be_navigated_to_the_new_url_and_url_should_contain(String inURL) {
        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {

            String windowURL = driver.getCurrentUrl();

            if (windowURL.contains(inURL)) {

            BrowserUtils.waitFor(3);
            Assert.assertTrue(driver.getCurrentUrl().contains(inURL));

                break;
            }
        }
    }

    @Then("the link should open in a new tab")
    public void the_link_should_open_in_a_new_tab() {
        Assert.assertEquals(driver.getWindowHandles().size(), 2);
    }



}
