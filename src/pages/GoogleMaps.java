package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleMaps extends BasePage {

    public GoogleMaps(WebDriver driver) {
        super(driver);
    }

    public GoogleMaps openDirections() {
        wd.findElement(By.cssSelector("#searchbox-directions")).click();
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("#sb_ifc51 > input"))));
        return this;
    }

    public GoogleMaps destinationInput(String from, String destinations) {
        wd.findElement(By.xpath("//*[@id=\"sb_ifc51\"]/input")).clear();
        wd.findElement(By.xpath("//*[@id=\"sb_ifc51\"]/input")).sendKeys(from);
        wd.findElement(By.xpath("//*[@id=\"sb_ifc52\"]/input")).sendKeys(destinations);
        wd.findElement(By.xpath("//*[@id=\"sb_ifc52\"]/input")).sendKeys(Keys.ENTER);
        return this;
    }
    public GoogleMaps verifyTimeBetweenDesinations(String from, String destinations) {
        WebElement element1 = wd.findElement(By.xpath("//*[@id=\"section-directions-trip-0\"]/div[2]/div[1]/div[1]/div[1]/span[1]"));
        System.out.println("The time it takes from " + from + " and " + destinations + " is " + element1.getText());
        return this;
    }
}

