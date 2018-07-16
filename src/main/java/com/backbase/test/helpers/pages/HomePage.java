package com.backbase.test.helpers.pages;
import com.backbase.test.helpers.model.Computer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.backbase.test.helpers.utils.TextFunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Locale;

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

    public boolean isHomePage()
    {
        return getURL().contentEquals(siteUrl);
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
            try{
                comp = comp.newEntity()
                        .withComputerName(checkIfNull(entry.get(0)))
                        .withIntroduced(checkDate(entry.get(1)))
                        .withDiscontinued(checkDate(entry.get(2)))
                        .withCompany(checkIfNull(entry.get(3)))
                        .build();
                getCompList.add(comp);}
            catch (Throwable t){break;}
        }
        return getCompList;
    }

    private String checkIfNull(String entry)
    {
        if (entry.contentEquals("-")) return null;
        return entry;
    }

    private String checkDate(String entry) throws ParseException
    {
        if (entry.contentEquals("-")) return null;
        SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy",Locale.ENGLISH);
        Date date = sdf.parse(entry);
        sdf.applyPattern( "yyyy-MM-dd" );
        return sdf.format(date);
    }

    public String getAlertMessage()
    {
        if (!(isOnPage(alertLocator)))return "";
        return getValue(alertLocator);
    }

    public void addNewComputer()
    {
        clickElement(addCompLocator);
    }

    public void selectComputer(Computer comp)
    {
        String text = "";
        try{ text = comp.getComputerName()+"\t"+convertDate(comp.getIntroduced())+"\t"+convertDate(comp.getDiscontinued())+"\t"+convertNull(comp.getCompany());}
        catch (Throwable t){}

        clickHrefByInnerText(computerTableLocator, text);
    }

    private String convertNull(String value)
    {
        if (value==null) return "-";
        return value;
    }

    private String convertDate(String entry) throws ParseException
    {
        if (entry==null) return "-";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
        //SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy",Locale.ENGLISH);
        Date date = sdf.parse(entry);
        //sdf.applyPattern( "yyyy-MM-dd" );
        sdf.applyPattern("d MMM yyyy");
        return sdf.format(date);
    }


}
