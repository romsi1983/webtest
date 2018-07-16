package com.backbase.test.tests;
import com.backbase.test.helpers.utils.TestData;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.backbase.test.helpers.business.Base;


public class TestBase {
    public static ThreadLocal<Base> tlBase = new ThreadLocal<>();
    public static ThreadLocal<TestData> tlTd = new ThreadLocal<>();
    public Base base;
    public TestData td;


    @BeforeTest
    public void start() {
        //System.out.println("Before Test");
        if (tlBase.get() != null) { base = tlBase.get(); }
        else
        {
            base = new Base();
            tlBase.set(base);
        }

        if (tlTd.get() != null) {td = tlTd.get();}
        else
        {
            td = new TestData();
            tlTd.set(td);
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    System.out.println("Running Shutdown Hook");
                    //td.quit();
                    td = null;
                }
            });
        }
    }
    @AfterTest
    public void stop() {
        if (tlBase.get() != null)
        {
            base = tlBase.get();
            base.quit();
            base = null;
        }
    }

}
