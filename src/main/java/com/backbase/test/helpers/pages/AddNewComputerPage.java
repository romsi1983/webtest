package com.backbase.test.helpers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddNewComputerPage extends BasePage {
    private String computerNameLocator = "//input[@id='name']";
    private String computerInroducedLocator = "//input[@id='introduced']";
    private String computerDiscontinedLocator = "//input[@id='discontinued']";
    private String computerCompanyLocator = "//select[@id='company']";
    private String computerCreateLocator = "//input[@type='submit']";
    private String computerCanselLocator = "//a[@class='btn']";
    private String errorColour = "rgb(200, 120, 114)";


//    public AddNewComputerPage() throws Exception {
//        String currentURL = getURL();
//        //String found = getValue(resultLinkLocator);
//        if (currentURL.indexOf("new") == -1)
//            throw new Exception("this is not the Add a computer");
//    }

    public AddNewComputerPage(WebDriver driver) {
        super (driver);
        //PageFactory.initElements(driver, this);
    }

    public void EnterCompName(String compName) {
        typeText(computerNameLocator, compName);
    }

    public void EnterIntroducedDate(String introducedDate) {
        typeText(computerInroducedLocator, introducedDate);
    }

    public void EnterDiscontinuedDate(String discontinuedDate) {
        typeText(computerDiscontinedLocator, discontinuedDate);
    }

    public void ChooseCompany(String companyName) {

        selectValue(computerCompanyLocator, companyName);
    }

    public void CreateNewComputer() {
        clickElement(computerCreateLocator);
    }

    public void CanselCreateNewComputer() {
        clickElement(computerCanselLocator);
    }

    public boolean isNameWithError() {
        return errorColour.equalsIgnoreCase(getCssValue(computerNameLocator, "border-color"));
    }

    public boolean isIntroducedDateWithError() {
        return errorColour.equalsIgnoreCase(getCssValue(computerInroducedLocator, "border-color"));
    }

    public boolean isDiscontinedDateWithError() {
        return errorColour.equalsIgnoreCase(getCssValue(computerDiscontinedLocator, "border-color"));
    }


}
