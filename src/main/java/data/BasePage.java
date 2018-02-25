package data;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * Created by oleksandr on 25.02.2018.
 */
public class BasePage extends ConfigurationManager{
    private static final Logger logger = Logger.getLogger(BasePage.class);
    private String browser = "chrome";
    private String url = "https://rozetka.com.ua/";

    @BeforeTest
    public void startApplication(){
       logger.info("Java installation folder and Java version: " + System.getProperty("java.home") + " "
               + System.getProperty("java.version"));
       logger.info("OS name is and OS version: " + System.getProperty("os.name") + " " +
                System.getProperty("os.version"));
       logger.info("Current User is " + System.getProperty("user.name"));
       logger.info("Current working directory of the User is " + System.getProperty("user.dir"));
       logger.info("Start application on " + browser + " browser and start URL = " + url);
       startDriver(browser, url);
       logger.info("Current url equals " + getCurrentUrl());
       logger.info("Current page is " + getTitle());
    }

    @AfterTest
    public void quit(){
        quitDriver();
    }
}
