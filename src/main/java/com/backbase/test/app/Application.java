package com.backbase.test.app;

import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class Application {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("Test started");

        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();

        testng.addListener(tla);
        // testng.setTestClasses(new Class[] { test.TestTitle.class });

        List<String> suites = Lists.newArrayList();
        suites.add("./testng.xml");// path to xml..
        // // suites.add("c:/tests/testng2.xml");
        //
        testng.setTestSuites(suites);

        testng.run();

        System.out.println("Test finished");

    }

}
