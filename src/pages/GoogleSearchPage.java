package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage extends BasePage {
    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public GoogleSearchPage openGooglePage() {
        wd.get("https://www.google.com");
        return this;

    }

    public ResultPage doGoogleSearch(String searchinput) {
        wd.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(searchinput);
        wd.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(wd, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("#hdtb-msb-vis > div.hdtb-mitem.hdtb-msel.hdtb-imb"))));
        return new ResultPage(wd);
    }


}
