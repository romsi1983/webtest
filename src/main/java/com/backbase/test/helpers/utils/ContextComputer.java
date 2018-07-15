package com.backbase.test.helpers.utils;
import com.backbase.test.helpers.model.Computer;
import org.testng.ITestContext;


public class ContextComputer {

    public void saveComputerToContext(Computer computer,ITestContext context)
    {
        context.setAttribute("computerName",computer.getComputerName());
        context.setAttribute("company",computer.getCompany());
        context.setAttribute("discontinued",computer.getDiscontinued());
        context.setAttribute("introduced",computer.getIntroduced());
    }

//    public <Computer>computer(ITestContext context)
//    {
//        return new Object[][]{
//                {computer.newEntity()
//                        .withCompany(context.getAttribute("company"))
//                        .withComputerName(context.getAttribute("computerName"))
//                        .withIntroduced(context.getAttribute("introduced"))
//                        .withDiscontinued(context.getAttribute("discontinued"))
//                        .build()}
//        };
//    }



}
