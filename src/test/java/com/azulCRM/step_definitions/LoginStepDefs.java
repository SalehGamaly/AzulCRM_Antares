package com.azulCRM.step_definitions;

import com.azulCRM.pages.LoginPage;
import com.azulCRM.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
public class LoginStepDefs {


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("Login to app in Before method");
    }

    @Given("user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        //based on input enter that user information
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

    @Given("user logged in with {string} and {string}")
    public void the_user_logged_in_with_username_and_password(String username, String password) {
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);
    }






}
