package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GoogleMaps;
import pages.GoogleSearchPage;

import java.io.IOException;

public class GoogleSearchTest extends BaseTest{
    GoogleSearchPage googleSearchPage = new GoogleSearchPage(wd);




    /*@Test
    public void doGoogleSearch(){
     SearchPage searchPage = new SearchPage(wd);
     searchPage.openSearchPage()
             .doSearchWithInput("Last News");
    }

    @Test
    public void doGoogleSearchWithAnotherInput(){
        SearchPage searchPage = new SearchPage(wd);
        searchPage.openSearchPage()
                .doSearchWithInput("NBA starting date");
        ResultPage resultPage = new ResultPage(wd);
        Assert.assertEquals(resultPage.getFirstHeaderFromSearchPage(),
                "Key dates for 2018-19 NBA season | NBA.com");
    }

    @Test
    public void doGoogleSearch2(){
        System.setProperty("chromedriver", "/Users/juliakolesnyk/Desktop/LessonSample/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.findElement(By.cssSelector("div.a4bIc > input")).sendKeys("LinkedIn");
        driver.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(Keys.ENTER);
    }
    */

    /*@Test
    public void doYahooSearch() {
        wd.get("https://www.yahoo.com");
        wd.findElement(By.cssSelector("#uh-search-box")).sendKeys("Donald Trump");
        wd.findElement(By.cssSelector("#uh-search-box")).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(wd, 15);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("h3[class=\"title\"] a"))));
        wd.findElements(By.cssSelector("h3[class=\"title\"] a")).get(1).click();
    }
    */


  /* @Test
    public void doYahooSearch() {
       wd.get("https://www.yahoo.com");
       wd.findElement(By.cssSelector("#uh-search-box")).sendKeys("Donald Trump");
       wd.findElement(By.cssSelector("#uh-search-box")).sendKeys(Keys.ENTER);
       WebDriverWait wait = new WebDriverWait(wd, 10);
       WebElement element = wait.until(ExpectedConditions.visibilityOf(wd.findElements(By.cssSelector("h3[class=\"title\"] a")).get(0)));
       wd.findElements(By.cssSelector("h3[class=\"title\"] a")).get(5).click();
    }
    */

    @DataProvider(name = "Search Computer Manufacturers")
    public static Object[][] destinations() {
        return new Object[][] {
                {"Microsoft"}, {"Apple"}, {"Dell"}
        };
    }




//    @Test(dataProvider = "Search Computer Manufacturers")
//    public void doGoogleSearch(String searchName) {
//        wd.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(searchName);
//        wd.findElement(By.cssSelector("input[type=\"submit\"]:nth-child(1)")).click();
//        WebDriverWait wait = new WebDriverWait(wd, 10);
//        WebElement element = wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("#logo > img"))));
//        List<WebElement> list= wd.findElements(By.cssSelector("#search h3.LC20lb"));
//        for(WebElement webeElement:list){System.out.println(webeElement.getText());}
//
//    }


    @DataProvider(name = "Maps")
    public static Object[][] destination1() {
        return new Object[][] {
                {"1717 Arch St, Philadelphia, PA", "123 Main St, Camden, NJ"}, {"Liberty Bell, N 6th St & Market St, Philadelphia, PA 19106", "Rocky Steps, 2600 Benjamin Franklin Pkwy, Philadelphia, PA 19130"}
        };
    }


//    @Test(dataProvider = "Maps")
//    public void doGoogleMapSearch(String  from, String destinations) {
//        wd.findElement(By.cssSelector("div.a4bIc > input")).sendKeys("Google Maps");
//        wd.findElement(By.cssSelector("input[type=\"submit\"]:nth-child(1)")).click();
//        WebDriverWait wait = new WebDriverWait(wd, 10);
//        WebElement element = wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("#logo > img"))));
//        List<WebElement> list= wd.findElements(By.cssSelector("#search h3.LC20lb"));
//        list.get(0).click();
//        wd.findElement(By.cssSelector("#searchbox-directions")).click();
//        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("#sb_ifc51 > input"))));
//        wd.findElement(By.xpath("//*[@id=\"sb_ifc51\"]/input")).clear();
//        wd.findElement(By.xpath("//*[@id=\"sb_ifc51\"]/input")).sendKeys(from);
//        wd.findElement(By.xpath("//*[@id=\"sb_ifc52\"]/input")).sendKeys(destinations);
//        wd.findElement(By.xpath("//*[@id=\"sb_ifc52\"]/input")).sendKeys(Keys.ENTER);
//        WebElement element1 = wd.findElement(By.xpath("//*[@id=\"section-directions-trip-0\"]/div[2]/div[1]/div[1]/div[1]/span[1]"));
//        System.out.println("The time it takes from " + from + " and " + destinations + " is " + element1.getText());
//
//    }


    @BeforeMethod
    public void openGoogle(){
        googleSearchPage.openGooglePage();
    }

    @Test(dataProvider = "Maps")
    public void doGoogleMapSearch2(String  from, String destinations) throws IOException {
        googleSearchPage.doGoogleSearch("Google Maps")
                .clickOnLinkByValue(0);
        GoogleMaps googleMaps = new GoogleMaps(wd);
        googleMaps.openDirections()
                .destinationInput(from, destinations)
                .verifyTimeBetweenDesinations(from, destinations);
    captureScreenshot();
    }

    @Test
    public void doGoogleSearchParameters() {
        googleSearchPage
                .doGoogleSearch("planets")
                .clickOnLinkByValue(0);
    }



}
