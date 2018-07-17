package com.backbase.test.tests;
import org.testng.annotations.DataProvider;
import com.backbase.test.helpers.model.Computer;

public class DataProviders {
    @DataProvider(name = "validComputer")
    public static Object[][] getValidComputer() {
        return new Object[][]{
                {Computer.newEntity()
                        .withCompany("RCA")
                        .withComputerName("NewComputer" + System.currentTimeMillis())
                        .withIntroduced("2017-01-01")
                        .withDiscontinued("2018-01-01")
                        .build()},
        };
    }

    @DataProvider(name = "editComputer")
    public static Object[][] getEditComputer() {
        return new Object[][]{
                {Computer.newEntity()
                        .withCompany("Sony")
                        .withComputerName("EditComputer" + System.currentTimeMillis())
                        .withIntroduced("2017-12-12")
                        .withDiscontinued("2018-12-12")
                        .build()},
        };
    }

}
