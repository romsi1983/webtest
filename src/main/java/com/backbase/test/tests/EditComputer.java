package com.backbase.test.tests;

import com.backbase.test.helpers.model.Computer;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.List;

public class EditComputer extends TestBase {
    @Test(dataProvider = "validComputer",dataProviderClass = DataProviders.class,testName = "Edit Computer")
    public void editComputer(Computer computer) {
        //Create new computer
        td.saveOrigComputer(computer);
        List<String> errors = base.createNewComp(computer);
        //Check if there were errors on creation
        if (errors.size()>0) Assert.fail("errors on creating Computer");
        //Find Created Computer
        Assert.assertTrue(base.searchExactComputer(computer,1));
        //Computer editComp = new Computer();
        Computer editComp = td.newEditComputer();
        //Select found Computer
        Assert.assertTrue(base.selectComputer(computer));
        errors = base.editComp(editComp);
        if (errors.size()!=0) Assert.fail("Edit Computer Failed");
        Assert.assertTrue(base.searchExactComputer(editComp,1));
        //Delete Computer
        if (!(base.deleteComputer(editComp))) Assert.fail("computer was not deleted");
        Assert.assertTrue(base.searchExactComputer(editComp,0)); }
}
