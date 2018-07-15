package com.backbase.test.tests;
import com.backbase.test.helpers.model.Computer;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.backbase.test.helpers.business.Base;
import org.testng.Assert;
import org.testng.ITestContext;



public class CreateNewComp extends TestBase
{
    @Test(dataProvider = "validComputer",dataProviderClass = DataProviders.class)
    //@Parameters({"company"},{"name"},{""})
    public void canCreateComp(Computer computer,ITestContext context) {
        Assert.assertTrue(base.createNewComp(computer));
        context.setAttribute("createdPC", computer);
        context.setAttribute("test","test");
        context.setAttribute("123","13");
    }
}
