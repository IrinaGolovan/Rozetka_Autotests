package data;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


/**
 * Created by oleksandr on 17.02.2018.
 */
public class ConfigurationManager {

    private WebDriver driver;
    private int implicitWait = 10;
    private static final Logger logger = Logger.getLogger(ConfigurationManager.class);
    public WebDriver getDriver(){ return driver; }

    public void startDriver(String browser, String url){
        if(browser.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.setCapability("platform", "WINDOWS");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.navigate().to(url);
            logger.info("Navigating to " + url);
        }else if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.navigate().to(url);
            logger.info("Navigating to " + url);
        }
    }

    public void quitDriver(){
        driver.quit();
    }

    public String getTitle(){
        logger.info("Getting page title");
        return driver.getTitle();
    }

    public String getCurrentUrl(){
        logger.info("Getting current url");
        return driver.getCurrentUrl();
    }

}
