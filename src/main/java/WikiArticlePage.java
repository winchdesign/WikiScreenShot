import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ScreenShotMaker;

import java.io.IOException;

/**
 * Created by winch on 28.03.2016.
 */
public class WikiArticlePage {
    private WebDriver driver;

    @FindBy (css = "table.infobox:nth-child(3) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(1) > a:nth-child(1) > img:nth-child(1)")
    private WebElement picture;

    public WikiArticlePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void takePictureScreenShot () throws IOException {

        ScreenShotMaker screenShotMaker = new ScreenShotMaker(driver);
        screenShotMaker.takeElementScreenshot(picture);

    }
}
