package com.backbase.test.tests;
import com.backbase.test.helpers.model.Computer;
import org.testng.annotations.Test;
import org.testng.Assert;

public class CreateSameComputer extends TestBase{
    @Test()

    public void CanCreateSameComp(){
        Computer computer = td.getComputer();
        td.saveComputer(computer);
//        Computer computer = base.getComputer();
//        Assert.assertFalse(base.createNewComp(computer));
    }
}
