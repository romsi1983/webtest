package Helpers.Driver;


public class HomePage extends BasePage
{

    private String searchFieldLocator = "//input[@id='searchbox']";
    private String searchButtonLocator = "//input[@id='searchsubmit']";
    private String addCompLocator = "//a[@id='add']";
    private String siteUrl = "http://computer-database.herokuapp.com/computers";

    //public HomePage(WebDriver driver) throws Exception
    public HomePage() throws Exception
    {

        open(siteUrl);

        if (!(getPageTitle().equalsIgnoreCase("Computers database")))
            throw new Exception("this is not the home page");

    }

    public ResultsPage search(String keyword) throws Exception
    {

        typeText(searchFieldLocator, keyword);
        clickElement(searchButtonLocator);
        return new ResultsPage();
    }

    public AddNewPage newComp() throws Exception
    {
        clickElement(addCompLocator);
        return new AddNewPage();
    }
}
