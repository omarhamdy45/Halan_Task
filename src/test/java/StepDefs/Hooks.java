package StepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.val;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver ;
    public static String  password="Omar@1234";
    public static String email="sample@face.com";
    public static String LoginPage ="http://www.testyou.in/Login.aspx";



    @Before
    public static void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager manager = WebDriverManager.getInstance(DriverManagerType.CHROME);
        manager.clearResolutionCache();
        manager.clearDriverCache();
        manager.setup();
        driver = new ChromeDriver(options);
        Hooks.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Hooks.driver.manage().window().maximize();

    }

    @After
    public static void closeBrowser() throws InterruptedException {
        driver.quit();
    }

}
