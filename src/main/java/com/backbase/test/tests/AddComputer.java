package com.backbase.test.tests;

import com.backbase.test.helpers.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddComputer {
    @Test
    @Parameters({"company"})
    public void DoAddComputer(String company) throws Exception {
//        HomePage home = new HomePage();
//        AddNewComputerPage newComp = home.newComp();
//        newComp.ChooseCompany(company);
//        newComp.CreateNewComputer();
//        Assert.assertTrue(newComp.isNameWithError());
    }

    @BeforeTest
    public void beforeTest() throws Exception
    {

    }

    @AfterTest
    public void afterTest() {
//        BasePage.closeBrowser();
    }
}
