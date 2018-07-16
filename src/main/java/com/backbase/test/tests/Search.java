package com.backbase.test.tests;
import com.backbase.test.helpers.model.Computer;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Search extends TestBase{
    @Test()
    public void CanDoSearch(){
        Computer computer = td.getComputer();
//        List<Computer>  foundComps = base.search("Acer");
//        if (foundComps.size()==0)
//        {
//            Assert.fail("nothing was found");
//        }
    }
}
