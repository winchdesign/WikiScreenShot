import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by winch on 28.03.2016.
 */
public class WikiEngMainPage {
    private WebDriver driver;

    @FindBy (xpath = "//div[@id='mp-itn']/ul/li/a[1]")
    private WebElement secondLink;

    public WikiEngMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver goToItem (){

        secondLink.click();
        return driver;
    }
}
