package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GithubDashboard;
import pages.GithubLoginPage;

public class GithubLoginTest extends BaseTest {
    @Test
    public void loginToGithub() {
        String expectedResult = "melvinmanuelthomas";
        wd.get("https://github.com/login");
        wd.findElement(By.cssSelector("#login_field")).sendKeys("melvinmanuelthomas");
        wd.findElement(By.cssSelector("#password")).sendKeys("CT6PWx$fML");
        wd.findElement(By.cssSelector("#login > form > div.auth-form-body.mt-3 > input.btn.btn-primary.btn-block")).click();
        wd.findElement(By.cssSelector("#user-links > li:nth-child(3) > details > summary > img")).click();
        wd.findElement(By.cssSelector("#user-links > li:nth-child(3) > details > details-menu > ul > li.header-nav-current-user.css-truncate > a > strong")).getText();
        Assert.assertEquals(wd.findElement(By.cssSelector("#user-links > li:nth-child(3) > details > details-menu > ul > li.header-nav-current-user.css-truncate > a > strong")).getText(), expectedResult
       );
    }

    @Test
    public void loginToGithubusingPOM() {
        String expectedResult = "melvinmanuelthomas";
        GithubLoginPage githubPage = new GithubLoginPage(wd);
        GithubDashboard githubDashboard = githubPage.openGithubLoginPage()
                .loginWithCredentials("melvinmanuelthomas", "CT6PWx$fML")
                .openProfilePopup();
        Assert.assertEquals(githubDashboard.getUsernamefromDashboard(), expectedResult);
    }




}
