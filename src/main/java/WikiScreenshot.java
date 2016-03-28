import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class WikiScreenshot {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://www.wikipedia.org";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testWikiScreenshot() throws Exception {

        driver.get(baseUrl);

        WikiMainPage wikiMainPage = new WikiMainPage(driver);
        wikiMainPage.goToWikiEngMainPage();

        WikiEngMainPage wikiEngMainPage = new WikiEngMainPage(driver);
        wikiEngMainPage.goToItem();

        WikiArticlePage wikiArticlePage = new WikiArticlePage(driver);
        wikiArticlePage.takePictureScreenShot();

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
