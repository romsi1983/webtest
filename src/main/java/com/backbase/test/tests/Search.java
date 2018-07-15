package com.backbase.test.tests;

import com.backbase.test.helpers.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Search {
    @Test
    @Parameters({"mySearch"})
    public void DoSearch(String mySearch) throws Exception {
//        HomePage home = new HomePage();
//        ResultsPage result = home.search(mySearch);
//        String foundComps = result.searchResult();
//        Assert.assertTrue(foundComps.length() > 0);
    }
//
//    @BeforeTest
//    public void beforeTest() throws Exception
//    {
//
//    }

    @AfterTest
    public void afterTest() {
//        BasePage.closeBrowser();
    }
}
