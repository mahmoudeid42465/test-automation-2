import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    public static WebDriver driver;
@BeforeTest
    public void SetupDriver ()throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new  ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        Thread.sleep(3000);
    }

    @AfterTest
    public void EndDriver()
    {
       // driver.quit();
    }
}
