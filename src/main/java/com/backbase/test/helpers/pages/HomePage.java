package com.backbase.test.helpers.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    private String searchFieldLocator = "//input[@id='searchbox']";
    private String searchButtonLocator = "//input[@id='searchsubmit']";
    private String addCompLocator = "//a[@id='add']";
    private String siteUrl = "http://computer-database.herokuapp.com/computers";

    //public HomePage(WebDriver driver) throws Exception
    public HomePage(WebDriver driver) {
        super (driver);
        PageFactory.initElements(driver, this);
    }

    public void open()
    {
        openUrl(siteUrl);
    }
//    public HomePage() throws Exception {
//
//        //openBrowser();
//        openUrl(siteUrl);
//
//        if (!(getPageTitle().equalsIgnoreCase("Computers database")))
//            throw new Exception("this is not the home page");
//
//    }

//    public ResultsPage search(String keyword) throws Exception {
//
//        typeText(searchFieldLocator, keyword);
//        clickElement(searchButtonLocator);
//        return new ResultsPage();
//    }

    public void search(String keyword)
    {
        typeText(searchFieldLocator, keyword);
        clickElement(searchButtonLocator);
    }

    public void addNewComputer()
    {
        clickElement(addCompLocator);
    }
//    public AddNewComputerPage newComp() throws Exception {
//        clickElement(addCompLocator);
//        return new AddNewComputerPage();}

}
