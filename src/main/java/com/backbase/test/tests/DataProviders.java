package com.backbase.test.tests;
import org.testng.annotations.DataProvider;
import com.backbase.test.helpers.model.Computer;

public class DataProviders {
    @DataProvider(name = "validComputer")
    public static Object[][] getValidComputer() {
        return new Object[][]{
                {Computer.newEntity()
                        .withCompany("RCA")
                        .withCompany("NewCompany" + System.currentTimeMillis())
                        .withIntroduced("2017-01-01")
                        .withDiscontinued("2018-01-01")
                        .build()},
        };
    }
}