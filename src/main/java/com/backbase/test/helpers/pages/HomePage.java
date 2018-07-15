package com.backbase.test.helpers.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    private String searchFieldLocator = "//input[@id='searchbox']";
    private String searchButtonLocator = "//input[@id='searchsubmit']";
    private String addCompLocator = "//a[@id='add']";
    private String siteUrl = "http://computer-database.herokuapp.com/computers";
    private String alertLocator = "//div[@class='alert-message warning']";

    public HomePage(WebDriver driver) {
        super (driver);
        PageFactory.initElements(driver, this);
    }

    public void open()
    {
        openUrl(siteUrl);
    }

    public void search(String keyword)
    {
        typeText(searchFieldLocator, keyword);
        clickElement(searchButtonLocator);
    }

    public String getAllertMessage()
    {
        if (!(isOnPage(alertLocator)))return "";
        return getValue(alertLocator);
    }

    public void addNewComputer()
    {
        clickElement(addCompLocator);
    }


}
