package data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Created by oleksandr on 17.02.2018.
 */
public class ConfigurationManager {

    WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    public void startDriver(String browser, String url){
        if(browser.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.setCapability("platform", "WINDOWS");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.navigate().to(url);
        }else if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.navigate().to(url);
        }
    }

}
