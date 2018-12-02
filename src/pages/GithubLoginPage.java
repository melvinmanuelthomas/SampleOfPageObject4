package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GithubLoginPage extends BasePage {
    public GithubLoginPage(WebDriver driver) {
        super(driver);
    }
@FindBy(css = "#login_field")
WebElement loginInput;

    @FindBy(css = "#password")
    WebElement passwordInput;

    @FindBy(css = "#login > form > div.auth-form-body.mt-3 > input.btn.btn-primary.btn-block")
    WebElement signInButton;

public GithubLoginPage openGithubLoginPage() {
    wd.get("https://github.com/login");
    return this;
}

public GithubDashboard loginWithCredentials(String username, String password) {
    loginInput.sendKeys(username);
    passwordInput.sendKeys(password);
    signInButton.click();
    return new GithubDashboard(wd);
}


}
