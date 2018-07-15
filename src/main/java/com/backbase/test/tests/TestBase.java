package com.backbase.test.tests;
import org.testng.annotations.BeforeTest;
import com.backbase.test.helpers.business.Base;
import org.testng.annotations.DataProvider;

public class TestBase {
    public static ThreadLocal<Base> tlBase = new ThreadLocal<>();
    public Base base;

    @BeforeTest
    public void start() {
        if (tlBase.get() != null) {
            base = tlBase.get();
            return;
        }

        base = new Base();
        tlBase.set(base);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                base.quit();
                base = null;
            }
        });
    }



}
