package utils;

import com.sun.javafx.geom.Rectangle;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by winch on 28.03.2016.
 */
public class ScreenShotMaker {
    private final WebDriver driver;
    public ScreenShotMaker(WebDriver driver){
            this.driver = driver;
        }

    public File takeElementScreenshot(WebElement element) throws IOException {

        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage img = ImageIO.read(screen);
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
        Rectangle rect = new Rectangle(width, height);
        Point p = element.getLocation();
        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
        ImageIO.write(dest, "png", screen);
        FileNameGenerator fileNameGenerator = new FileNameGenerator();
        String fileName = fileNameGenerator.fileNameGenerator("Screenshot_")+".png";
        FileUtils.copyFile((screen), new File(fileName));
        return screen;

    }
}
