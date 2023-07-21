package com.azulCRM.step_definitions;

import com.azulCRM.pages.CompanyStructurePage;
import com.azulCRM.pages.LoginPage;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;

public class AddDepartment_stepDefinition {

    CompanyStructurePage companyStructurePage = new CompanyStructurePage();

    @Then("user sees Company Structure  in the employee menu")
    public void user_sees_company_structure_in_the_employee_menu() {

        companyStructurePage.employeeMenu.click();

    }

    @Then("user hr can click add department")
    public void user_hr_can_click_add_department() {
        companyStructurePage.addDepartment.click();


    }

    @Then("user hr input {string} department name")
    public void user_hr_input_department_name(String departmentName) {
        companyStructurePage.inputDepartmentName.sendKeys(departmentName);

    }

    @Then("user hr select {string} parent department")
    public void user_hr_select_parent_department(String parentDepartment) {
        companyStructurePage.parentDepartment.click();
        Select selectDepartment = new Select(companyStructurePage.parentDepartment);
        selectDepartment.selectByVisibleText(parentDepartment);
        companyStructurePage.addButton.click();

    }


    @Then("user Helpdesk verify there is no ADD DEPARTMENT option")
    public void userHelpdeskVerifyThereIsNoADDDEPARTMENTOption() {

        try {
            WebElement addButton = companyStructurePage.addDepartment;
            System.out.println(addButton+ "The Add Department button is displayed for the Helpdesk user.");
        } catch (NoSuchElementException e) {
            System.out.println("The 'Add Department' button is NOT displayed for the Helpdesk user.");
        }

    }

    @Then("user Marketing verify there is no ADD DEPARTMENT option")
    public void userMarketingVerifyThereIsNoADDDEPARTMENTOption() {
        try {
            WebElement addButton = companyStructurePage.addButton;
            System.out.println("The 'Add Department' button is displayed for the Marketing user.");
        } catch (NoSuchElementException e) {
            System.out.println("The 'Add Department' button is NOT displayed for the Marketing user.");
        }


    }
    }


