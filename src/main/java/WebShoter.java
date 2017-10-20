import com.sun.jna.platform.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


/**
 * Created by dmaslov on 20/10/2017.
 */
public class WebShoter {
    public static void main(String[] args) {
        System.out.println("daad");

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dmaslov\\sources\\Java\\dmitr.io\\webshoter\\driver\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        //driver.manage().window().fullscreen();
        driver.get("http://www.deloitte.ru/");
        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        // File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        driver.close();
        try {
            ImageIO.write(fpScreenshot.getImage(), "PNG", new File("C:\\Users\\dmaslov\\sources\\Java\\dmitr.io\\screenshot.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
