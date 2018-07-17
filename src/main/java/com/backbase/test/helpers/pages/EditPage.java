package com.backbase.test.helpers.pages;

import org.openqa.selenium.WebDriver;

public class EditPage extends BasePage {
    private String computerNameLocator = "//input[@id='name']";
    private String computerInroducedLocator = "//input[@id='introduced']";
    private String computerDiscontinedLocator = "//input[@id='discontinued']";
    private String computerCompanyLocator = "//select[@id='company']";
    private String computerSubmitLocator = "//div/input[@type='submit']";
    private String computerCanselLocator = "//a[@class='btn']";
    private String computerDeleteLocator = "//form/input[@type='submit']";
    private String errorLocator = "//div[@class='clearfix error']";
    private String errorColour = "rgb(200, 120, 114)";

    public EditPage(WebDriver driver) {
        super (driver);
    }

    public void enterCompName(String compName) {
        typeText(computerNameLocator, compName);
    }

    public void enterIntroducedDate(String introducedDate) {
        typeText(computerInroducedLocator, introducedDate);
    }

    public void enterDiscontinuedDate(String discontinuedDate) {
        typeText(computerDiscontinedLocator, discontinuedDate);
    }

    public void chooseCompany(String companyName) {
        String value = companyName;
        if (companyName == null) value = "-- Choose a company --";
        selectValue(computerCompanyLocator, value);
    }

    public void submit() {
        clickElement(computerSubmitLocator);
        //return !isOnPage(errorLocator);
    }

    public void delete() {
        clickElement(computerDeleteLocator);
    }

    public void canselComputer() {
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

    public boolean isNew() {
        return getURL().endsWith("new");
    }


}
