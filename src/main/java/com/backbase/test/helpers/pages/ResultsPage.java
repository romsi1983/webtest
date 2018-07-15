package com.backbase.test.helpers.pages;

import com.backbase.test.helpers.utils.TextFunctions;
import org.openqa.selenium.WebDriver;


public class ResultsPage extends BasePage {
    private String resultLinkLocator = "//a[contains(text(),'Displaying')]";

    public ResultsPage(WebDriver driver) {
        super (driver);
    }

    public String searchResult() {
        String found = getValue(resultLinkLocator);
        TextFunctions textFunc = new TextFunctions();
        return textFunc.FindSubStringByBoundsValues(found, "of ", "");
    }
}