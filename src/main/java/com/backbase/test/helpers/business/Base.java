package com.backbase.test.helpers.business;

import com.backbase.test.helpers.model.Computer;
import com.backbase.test.helpers.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
    private WebDriver driver;

    private HomePage homePage;
    private ResultsPage resultsPage;
    private EditPage editPage;

    public Base(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver);
        editPage = new EditPage(driver);
    }

    public void quit() {driver.quit();}

    public boolean createNewComp(Computer computer)
    {
        homePage.open();
        homePage.addNewComputer();
        if (!(editPage.isNew())) return false;
        editPage.chooseCompany(computer.getCompany());
        editPage.enterCompName(computer.getComputerName());
        editPage.enterIntroducedDate(computer.getIntroduced());
        editPage.enterDiscontinuedDate(computer.getDiscontinued());
        if (!(editPage.submit())) return false ;
        String alert = homePage.getAllertMessage();
        if (!(alert.contentEquals("Done! Computer " + computer.getComputerName() + " has been created"))) return false;
        System.out.println("comp was created");


        return true;
    }



}
