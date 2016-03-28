import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by winch on 28.03.2016.
 */
public class WikiMainPage {
    private WebDriver driver;

    @FindBy (xpath = "//body[@id='www-wikipedia-org']/div/div[2]/a/strong")
    private WebElement english;

    public  WikiMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver goToWikiEngMainPage (){
        english.click();
        return driver;
    }
}
