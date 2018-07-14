package Helpers.Driver;
import Helpers.Support.TextFunctions;


public class ResultsPage extends BasePage
{
    private String resultLinkLocator = "//a[contains(text(),'Displaying')]";

    //public ResultsPage(WebDriver driver) throws Exception
    public ResultsPage() throws Exception
    {
        String currentURL = getURL();
        //String found = getValue(resultLinkLocator);
        if (currentURL.indexOf("?f=")==-1)
           throw new Exception("this is not the results page");
    }

    public String searchResult()
    {
        String found = getValue(resultLinkLocator);
        TextFunctions textFunc = new TextFunctions();
        return textFunc.FindSubStringByBoundsValues(found,"of ","");
    }
}