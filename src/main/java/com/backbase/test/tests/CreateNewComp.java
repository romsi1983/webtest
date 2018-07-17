package com.backbase.test.tests;
import com.backbase.test.helpers.model.Computer;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;


public class CreateNewComp extends TestBase
{
    @Test(dataProvider = "validComputer",dataProviderClass = DataProviders.class,testName = "Create New Computer")
    //@Parameters({"company"},{"name"},{""})
    public void canCreateComp(Computer computer) {
        List<String> errors = base.createNewComp(computer);
        if (errors.size()>0) Assert.fail("errors on creating Computer");
//        Assert.assertTrue(base.createNewComp(computer));
        td.saveComputer(computer);
    }
}
