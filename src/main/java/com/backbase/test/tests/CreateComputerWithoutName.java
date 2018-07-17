package com.backbase.test.tests;

import com.backbase.test.helpers.model.Computer;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.List;

public class CreateComputerWithoutName extends TestBase {
    @Test(dataProvider = "invalidComputer",dataProviderClass = DataProviders.class,testName = "Create Invalid Computer")
    public void createInvalidComputer(Computer computer) {
        //Create new computer
        td.saveOrigComputer(computer);
        List<String> errors = base.createNewComp(computer);
        //Check if there were errors on creation
        if (errors.size() == 0) { Assert.fail("was created computer without name"); }
        if (errors.size() != 1) Assert.fail("many errors on create invalid computer");
        Assert.assertTrue(errors.get(0).contentEquals("computerName")); }
}
