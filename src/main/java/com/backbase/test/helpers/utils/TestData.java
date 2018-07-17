package com.backbase.test.helpers.utils;

import com.backbase.test.helpers.model.Computer;

public class TestData {
    private Computer origComp;
    private Computer editComp;

    public TestData()
    {
        origComp = new Computer();
        editComp = new Computer();
    }

    public void saveOrigComputer (Computer computer)  {origComp = computer; }
    public Computer getOrigComputer()
    {
        return origComp;
    }

    public void saveEditComputer (Computer computer)  {editComp = computer; }
    public Computer getEditComputer()
    {
        return editComp;
    }

    public Computer newEditComputer(){
        editComp = null;
        editComp = editComp.newEntity()
                .withComputerName("EditComp"+ System.currentTimeMillis())
                .withIntroduced("2005-10-20")
                .withDiscontinued("2018-07-18")
                .withCompany("Acorn computer")
                .build();
        return editComp; }


}
