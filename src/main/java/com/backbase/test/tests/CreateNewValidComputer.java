package com.backbase.test.tests;

import com.backbase.test.helpers.model.Computer;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.List;

public class CreateNewValidComputer extends TestBase {
    @Test(dataProvider = "validComputer",dataProviderClass = DataProviders.class,testName = "Create New Valid Computer")
    public void createNewValidComputer(Computer computer) {
        //Create new computer
        td.saveOrigComputer(computer);
        List<String> errors = base.createNewComp(computer);
        //Check if there were errors on creation
        if (errors.size()>0) Assert.fail("errors on creating Computer");
        //Find Created Computer
        Assert.assertTrue(base.searchExactComputer(computer,1));
        //Delete Computer
        if (!(base.deleteComputer(computer))) Assert.fail("computer was not deleted");
        Assert.assertTrue(base.searchExactComputer(computer,0)); }
}
