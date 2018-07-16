package com.backbase.test.helpers.pages;
import com.backbase.test.helpers.model.Computer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.backbase.test.helpers.utils.TextFunctions;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    private String searchFieldLocator = "//input[@id='searchbox']";
    private String searchButtonLocator = "//input[@id='searchsubmit']";
    private String addCompLocator = "//a[@id='add']";
    private String siteUrl = "http://computer-database.herokuapp.com/computers";
    private String alertLocator = "//div[@class='alert-message warning']";
    private String foundLocator = "//section/h1";
    private String computerTableLocator = "//table/tbody";


    public HomePage(WebDriver driver) {
        super (driver);
        PageFactory.initElements(driver, this);
    }

    public void open()
    {
        openUrl(siteUrl);
    }

    public Integer search(String keyword)
    {
        typeText(searchFieldLocator, keyword);
        clickElement(searchButtonLocator);
        String foundText = getValue(foundLocator);
        if (foundText.contentEquals("No computers found")) return 0;
        TextFunctions textFunc = new TextFunctions();
        String foundComps = textFunc.FindSubStringByBoundsValues(foundText, "", " computer");
        if (foundComps.contentEquals("One")) return 1;
        return Integer.parseInt(foundComps);
    }

    public List<Computer> getCompList () {
        List<Computer> getCompList = new ArrayList<>();
        List<List<String>> tableDataValues = tableData(computerTableLocator);
        for (List <String> entry: tableDataValues) {
            Computer comp = new Computer();
//            getCompList.add(comp););
            comp = comp.newEntity()
                    .withComputerName(checkIfNull(entry.get(0)))
                    .withIntroduced(checkIfNull(entry.get(1)))
                    .withDiscontinued(checkIfNull(entry.get(2)))
                    .withCompany(checkIfNull(entry.get(3)))
                    .build();
            getCompList.add(comp);
        }
        return getCompList;
    }

    private String checkIfNull(String entry)
    {
        if (entry.contentEquals("-")) return null;
        return entry;
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
