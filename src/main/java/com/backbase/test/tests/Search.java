package com.backbase.test.tests;
import com.backbase.test.helpers.model.Computer;
import com.backbase.test.helpers.utils.ListFunctions;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Search extends TestBase{
    @Test()
    public void CanDoSearch(){
        //Computer comp = td.getComputer();
        Computer comp = new Computer();
        comp = comp.newEntity()
                .withComputerName("1234LINK")
                .withIntroduced(("2000-10-20"))
                .withDiscontinued("2018-07-18")
                .withCompany("Acorn computer")
                .build();
        List<Computer>  foundComps = base.search(comp.getComputerName());
        if (foundComps.size()==0)
        {
            Assert.fail("nothing was found");
        }

//            getCompList.add(comp););


        ListFunctions lf = new ListFunctions();
        int assurance = lf.findCompsInList(foundComps,comp);

    }
}
