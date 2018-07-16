package com.backbase.test.helpers.utils;

import com.backbase.test.helpers.model.Computer;

import java.util.List;

public class ListFunctions {
    public int findCompsInList(List<Computer> compList, Computer comp)
    {
        int found = 0;
        for (Computer temp : compList) {
            if (temp == comp) found ++;
        }
        return found;
    }

}
