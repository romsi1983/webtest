package com.backbase.test.helpers.business;

import com.backbase.test.helpers.model.Computer;
import com.backbase.test.helpers.pages.*;
import com.backbase.test.helpers.utils.ListFunctions;

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
        comp = new Computer(); }

    public void quit() {driver.quit();}

    public List<String> createNewComp(Computer computer) {
        List<String> errors;
        homePage.open();
        homePage.addNewComputer();
        errors = editComputerSettings(computer);
        if (errors.size()>0) return errors;
        String alert = homePage.getAlertMessage();
        if (!(alert.contentEquals("Done! Computer " + computer.getComputerName() + " has been created"))) errors.add("alert");
        //System.out.println("computer was created");
        return errors; }

    public List<String> editComp(Computer computer)
    {
        List<String> errors;
        errors = editComputerSettings(computer);
        if (errors.size()>0) return errors;
        String alert = homePage.getAlertMessage();
        if (!(alert.contentEquals("Done! Computer " + computer.getComputerName() + " has been updated"))) errors.add("alert");
        return errors;
    }

    private List<Computer> search (String keyword) {
        List<Computer> search = new ArrayList<>();
        homePage.open();
        int foundComps = homePage.search(keyword);
        if (foundComps == 0) return search;
        // ToDO: if number of found documents is > then shown on page -> implement collecting data from all pages
        search = homePage.getCompList();
        return search; }

    public boolean searchExactComputer(Computer computer,int expectedResult) {
        List<Computer> foundComps = search(computer.getComputerName());
        ListFunctions lf = new ListFunctions();
        int assurance = lf.findCompsInList(foundComps,computer);
        if (assurance==expectedResult) return true;
        return false; }

    public boolean selectComputer(Computer computer)  { return homePage.selectComputer(computer); }

    public boolean deleteComputer(Computer computer) {
        if (!(homePage.selectComputer(computer))) return false;
        editPage.delete();
        String alert = homePage.getAlertMessage();
        return (alert.contentEquals("Done! Computer has been deleted"));  }

    private List<String> editComputerSettings(Computer computer) {
        List<String> errors = new ArrayList<>();
        editPage.chooseCompany(computer.getCompany());
        editPage.enterCompName(computer.getComputerName());
        editPage.enterIntroducedDate(computer.getIntroduced());
        editPage.enterDiscontinuedDate(computer.getDiscontinued());
        editPage.submit();
        if (homePage.isHomePage()) return errors;
        if (editPage.isNameWithError()) errors.add("computerName");
        if (editPage.isDiscontinedDateWithError()) errors.add("Discontinued");
        if (editPage.isIntroducedDateWithError()) errors.add("Introduced");
        return errors; }
}
