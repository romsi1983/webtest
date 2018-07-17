package com.backbase.test.helpers.utils;

import com.backbase.test.helpers.model.Computer;

import java.util.List;

public class ListFunctions {
    public int findCompsInList(List<Computer> compList, Computer comp)
    {
        int found = 0;
        if (compList.size()==0) return found;
        for (Computer temp : compList) {
            if (!(compareValues(temp.getComputerName(),comp.getComputerName()))) break;
            if (!(compareValues(temp.getCompany(),comp.getCompany()))) break;
            if (!(compareValues(temp.getIntroduced(),comp.getIntroduced()))) break;
            if (!(compareValues(temp.getDiscontinued(),comp.getDiscontinued()))) break;
            found++;
        }
        return found;
    }
    private boolean compareValues(String value1,String value2){
        if ((value1==null)&&(value2==null)) return true;
        if ((value1==null)||(value2==null)) return false;
        return value1.contentEquals(value2);
    }
}
