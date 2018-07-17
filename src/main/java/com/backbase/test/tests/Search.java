package com.backbase.test.tests;
import com.backbase.test.helpers.model.Computer;
import com.backbase.test.helpers.utils.ListFunctions;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.List;

public class Search extends TestBase{
    @Parameters("expectedSearchResult")
    @Test(testName = "Search")
    public void CanDoSearch(@Optional("1") int expectedSearchResult){
        //Computer comp = td.getComputer();

        //new comps for debugging
        Computer comp = td.getComputer();
//        comp = comp.newEntity()
//                .withComputerName("ASCI Purple")
//                .withIntroduced(("2005-01-01"))
//                .withDiscontinued(null)
//                .withCompany("IBM")
//                .build();

        Computer editComp = new Computer();
        editComp = editComp.newEntity()
                .withComputerName("EditComp"+ System.currentTimeMillis())
                .withIntroduced("2005-10-20")
                .withDiscontinued("2018-07-18")
                .withCompany("Acorn computer")
                .build();

        List<Computer>  foundComps = base.search(comp.getComputerName());
        if (foundComps.size()==0) Assert.fail("nothing was found");
        ListFunctions lf = new ListFunctions();
        int assurance = lf.findCompsInList(foundComps,comp);
        if (assurance==0) Assert.fail("created PC is not found");
        Assert.assertTrue(base.selectComputer(comp));
        List<String> errors = base.editComp(editComp);

        foundComps = base.search(editComp.getComputerName());
        if (foundComps.size()==0) Assert.fail("nothing was found");
        assurance = lf.findCompsInList(foundComps,editComp);
        if (assurance==0) Assert.fail("edited PC is not found");
        if (errors.size()>0) Assert.fail("errors on edit pc");
        if (!(base.deleteComputer(editComp))) Assert.fail("computer was not deleted");
        foundComps = base.search(editComp.getComputerName());
        if (foundComps.size()!=0) Assert.fail("deleted computer could be found");
    }
}
