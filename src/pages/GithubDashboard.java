package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GithubDashboard extends BasePage {
    public GithubDashboard(WebDriver driver) {
        super(driver);
    }
@FindBy(css= "#user-links > li:nth-child(3) > details > summary > img")
WebElement profileInfo;

    @FindBy(css= "#user-links > li:nth-child(3) > details > details-menu > ul > li.header-nav-current-user.css-truncate > a > strong")
    WebElement username;


    public GithubDashboard openProfilePopup() {
        profileInfo.click();
        return this;
    }

    public String getUsernamefromDashboard() {
        return username.getText();
    }


}
