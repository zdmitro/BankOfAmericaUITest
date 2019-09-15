import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class  BaseTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true); //Allow java scrip execution
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().deleteAllCookies();
        this.driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() {
        if(this.driver != null) {
            this.driver.manage().deleteAllCookies();
           //this.driver.quit();
        }

    }

    public WebDriver getDriver() {
        return driver;
    }

}
