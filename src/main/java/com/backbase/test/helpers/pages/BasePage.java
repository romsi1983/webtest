package com.backbase.test.helpers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

//    protected static WebDriverWait wait;
//
//    protected static WebDriver driver;

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

//    static
//    {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--start-maximized");
//        driver = new ChromeDriver(chromeOptions);
//        wait = new WebDriverWait(driver, 100);
//    }

//    public static void closeBrowser() {
//        driver.quit();
//        driver = null;
//    }

//    public static void openBrowser()
//    {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--start-maximized");
//        driver = new ChromeDriver(chromeOptions);
//        wait = new WebDriverWait(driver, 100);
//    }


    public WebElement find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        find(locator).click();
    }


    public String getPageTitle() {
        return driver.getTitle();
    }

    public void openUrl(String url) {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--start-maximized");
//        driver = new ChromeDriver(chromeOptions);
//        wait = new WebDriverWait(driver, 100);
        driver.get(url);
    }


    public void typeText(String locator, String keyword) {
        WebElement textField = find(locator);
        textField.clear();
        if (keyword==null) return;
        textField.sendKeys(keyword);
        //find(locator).sendKeys(keyword);
    }


    public void selectValue(String locator, String keyword) {
        new Select(find(locator)).selectByVisibleText(keyword);
    }


    public String getValue(String locator) {
        return find(locator).getText();
    }


    public String getAttribute(String locator, String keyword) {
        return find(locator).getAttribute(keyword);
    }

    public String getCssValue(String locator, String keyword) {
        return find(locator).getCssValue(keyword);
    }

    public Boolean isDisplayed(String locator) {
        return find(locator).isDisplayed();
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }


    //ToDo: Redesign code: avoid exception handler
    public boolean isOnPage(String locator) {
        try {
            find(locator);
        } catch (Throwable ex) {
            return false;
        }
        return true;
    }

    public List<List<String>> tableData(String locator) {
        //List<String> tableData = new ArrayList<>();
        WebElement table = find(locator);
        List<WebElement> tableRows = table.findElements(By.xpath("tr"));
        //List<WebElement> tableCells= table.findElements(By.xpath("tr/td"));
        List<List<WebElement>> cells = new ArrayList<>();
        for (WebElement row : tableRows) {
            //List<WebElement> cells = row.findElements(By.xpath("td"));
            cells.add(row.findElements(By.xpath("td")));
        }
        List<List<String>> tableData = new ArrayList<>();
        for (List<WebElement> row : cells) {
            List<String> tempRow = new ArrayList<>();
            for (WebElement col : row) {
                tempRow.add(col.getText());
            }
            tableData.add(tempRow);
        }
        return tableData;
    }

    public boolean clickHrefByInnerText(String locator, String text) {
        WebElement table = find(locator);
        List<WebElement> tableRows = table.findElements(By.xpath("tr"));
        for (WebElement row : tableRows) {
            if (row.getAttribute("innerText").contentEquals(text)) {
                WebElement hRef = row.findElement(By.xpath("td/a"));
                hRef.click();
                return true;
            }
        }
        return false;
    }
}




