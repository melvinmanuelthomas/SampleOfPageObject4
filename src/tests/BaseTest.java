package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.GoogleSearchPage;
import utils.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTest extends DriverFactory

    {

        @BeforeTest
        public void setUp() {
        wd = DriverFactory.setBrowser("chrome");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            GoogleSearchPage page = new GoogleSearchPage(wd);
            page.openGooglePage();
        }

        @AfterTest
        public void quit() {
        wd.quit();
    }

        public void captureScreenshot()throws IOException {
            String extension = ".png";
            File scrFile = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
            FileUtils.copyFile(scrFile, new File("./src" +timestamp+extension));
        }



    }