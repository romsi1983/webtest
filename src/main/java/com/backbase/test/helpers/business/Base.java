package com.backbase.test.helpers.business;

import com.backbase.test.helpers.model.Computer;
import com.backbase.test.helpers.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class Base {
    private WebDriver driver;
    private HomePage homePage;
    private ResultsPage resultsPage;
    private EditPage editPage;
    private Computer comp;

    public Base(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver);
        editPage = new EditPage(driver);
        comp = new Computer();
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
        String alert = homePage.getAlertMessage();
        if (!(alert.contentEquals("Done! Computer " + computer.getComputerName() + " has been created"))) return false;
        //System.out.println("computer was created");
        return true;
    }

    public List<Computer> search (String keyword) {
        List<Computer> search = new ArrayList<>();
        homePage.open();
        int foundComps = homePage.search(keyword);
        if (foundComps == 0) return search;
        // ToDO: if number of found documents is > then shown on page -> implement collecting data from all pages
        search = homePage.getCompList();
        return search;
    }

    public void selectComputer(Computer computer)  { homePage.selectComputer(computer); }

    public boolean deleteComputer(Computer computer)
    {
        homePage.selectComputer(computer);
        editPage.delete();
        String alert = homePage.getAlertMessage();
        if (!(alert.contentEquals("Done! Computer has been deleted"))) return false;
        return true;
    }



}
