package com.azulCRM.pages;

import com.azulCRM.utilities.Driver;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CompanyStructurePage {

    public CompanyStructurePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@title='Employees']")
    public WebElement employeeMenu;

    @FindBy(xpath = "(//span[.='Company Structure'])[1]")
    public WebElement companyStructure;


    @FindBy(xpath = "//span[.='Add department']")
    public WebElement addDepartment;

    @FindBy(id="NAME")
    public WebElement inputDepartmentName;


    @FindBy(id = "IBLOCK_SECTION_ID")
    public WebElement parentDepartment;

    @FindBy(xpath = "//span[.='Add']")
    public WebElement addButton;

    @FindBy(xpath = "//a[@title='AzulCRM']")
    public WebElement departmentIsDisplayed;






}
