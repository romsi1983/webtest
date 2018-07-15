package com.backbase.test.tests;
import com.backbase.test.helpers.model.Computer;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.backbase.test.helpers.business.Base;
import org.testng.Assert;
import org.testng.ITestContext;


public class CreateSameComputer extends TestBase{
    @Test()

    public void CanCreateSameComp(ITestContext context){
        Object computer = context.getAttribute("createdPC");

        //Assert.assertFalse(base.createNewComp(computer));
    }
}
