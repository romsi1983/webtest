package com.backbase.test.helpers.business;

import com.backbase.test.helpers.model.Computer;
import com.backbase.test.helpers.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Base {
    private WebDriver driver;

    private HomePage homePage;
    private ResultsPage resultsPage;
    private AddNewComputerPage newComp;

    public Base(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver);
        newComp = new AddNewComputerPage(driver);
    }

    public void quit() {driver.quit();}

    public void createNewComp(Computer computer)
    {
        homePage.open();
        homePage.addNewComputer();
        newComp.ChooseCompany(computer.getCompany());
        newComp.EnterCompName(computer.getComputerName());
        newComp.EnterIntroducedDate(computer.getIntroduced());
        newComp.EnterDiscontinuedDate(computer.getDiscontinued());
        newComp.CreateNewComputer();
    }



}
