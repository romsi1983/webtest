package com.backbase.test.tests;
import com.backbase.test.helpers.model.Computer;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.backbase.test.helpers.business.Base;


public class CreateNewComp extends TestBase
{

    @Test(dataProvider = "validComputer",dataProviderClass = DataProviders.class)
    //@Parameters({"company"},{"name"},{""})
    public void canCreateComp(Computer computer)
    {
        base.createNewComp(computer);
    }

}
