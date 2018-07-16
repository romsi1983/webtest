package com.backbase.test.helpers.utils;

import com.backbase.test.helpers.model.Computer;

public class TestData {
    private Computer comp;

    public TestData()
    {
        comp = new Computer();
    }

    public void saveComputer (Computer computer)
    {
        comp = null;
        comp = computer;
    }

    public Computer getComputer()
    {
        return comp;
    }

}
