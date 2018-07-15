package com.backbase.test.helpers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
        find(locator).sendKeys(keyword);
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
    public boolean isOnPage(String locator)
    {
        try{find(locator);}
        catch (Throwable ex) {return false;}
        return true;
    }

}


