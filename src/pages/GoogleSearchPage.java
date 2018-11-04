package pages;

import org.openqa.selenium.By;
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
        wd.findElement(By.cssSelector("input[type=\"submit\"]:nth-child(1)")).click();
        WebDriverWait wait = new WebDriverWait(wd, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("#logo > img"))));
        return new ResultPage(wd);
    }


}
