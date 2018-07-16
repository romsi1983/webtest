package com.backbase.test.tests;
import com.backbase.test.helpers.model.Computer;
import org.testng.annotations.Test;
import org.testng.Assert;


public class CreateNewComp extends TestBase
{
    @Test(dataProvider = "validComputer",dataProviderClass = DataProviders.class)
    //@Parameters({"company"},{"name"},{""})
    public void canCreateComp(Computer computer) {
        td.saveComputer(computer);
        // Assert.assertTrue(base.createNewComp(computer));
        // base.saveComputer(computer);
    }
}
