import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.selenium.pages.PageObjectModels;
import org.selenium.pages.SearchMenu;
import org.selenium.pages.TopMenu;
import org.selenium.pages.WebdriverPage;

public class Utils {


    static WebDriver driver;

    static WebdriverPage basePage = new WebdriverPage();

    TopMenu topMenu = new TopMenu(driver);
    SearchMenu searchMenu = new SearchMenu(driver);
    PageObjectModels pageObjectModels = new PageObjectModels();

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver(getChromeOptions());
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/");
        if (!driver.findElement(basePage.getLogotype()).isDisplayed()) {
            throw new WebDriverException("Site was not reached");
        }
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return chromeOptions;

    }
}
