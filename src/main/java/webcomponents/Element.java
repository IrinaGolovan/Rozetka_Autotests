package webcomponents;

import data.ConfigurationManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by irina on 11.02.2018.
 */
public abstract class Element extends ConfigurationManager{

    private By by;
    private List<WebElement> webElements;
    private int defaulttimeout = 10;
    private static final Logger logger = Logger.getLogger(Element.class);

    public Element(By by){
        this.by = by;
    }

    public Element(List<WebElement> webElements){
        this.webElements = webElements;
    }

    protected WebElement findWebElement(){ return getDriver().findElement(by); }

    protected List<WebElement> findWebElements() { return getDriver().findElements(by); }

    protected By getBy(){ return by; }

    protected void click(){
        try{
            findWebElement().click();
            logger.info("Element " + findWebElement() + " is clicked");
        }catch (Exception e){
            logger.error("Element "+ findWebElement() + " is not found",e);
        }
    }

    protected String getText(){
        try{
            return findWebElement().getText().trim();
        }catch (Exception e){
            logger.error("Cant get text from the element " + findWebElement(), e);
        }
        return null;
    }

    protected boolean isDisplayed(){
        try{
            return findWebElement().isDisplayed();
        }catch (Exception e){
            logger.error("Element " + findWebElement() + " is not displayed", e);
        }
        return false;
    }

    protected boolean isEnabled(){
        try{
            return findWebElement().isEnabled();
        }catch (Exception e){
            logger.error("Element " + findWebElement() + " is not enabled", e);
        }
        return false;
    }

    protected void sendText(String text){
        try{
            findWebElement().sendKeys(text);
        }catch (Exception e){
            logger.error("Text " + text + " was not typed in", e);
        }
    }

    protected String getAttribute(String attribute){
        try{
            return findWebElement().getAttribute(attribute).trim();
        }catch (Exception e){
            logger.error("Attribute of the element" + findWebElement() + " is not found", e);
        }
        return findWebElement().getAttribute(attribute).trim();
    }

    protected String getTagName(){
        try{
            return findWebElement().getTagName().trim();
        }catch(Exception e){
            logger.error("TagName of the element" + findWebElement() + " is not found", e);
        }
        return findWebElement().getTagName().trim();
    }

    public void waitForElementToBeClickable(){
        WebDriverWait wait = new WebDriverWait(getDriver(), defaulttimeout);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForElementToBeClickable(int timeout){
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForElementToBeVisible(){
        WebDriverWait wait = new WebDriverWait(getDriver(), defaulttimeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementToBeVisible(int timeout){
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementToBeInvisible(){
        WebDriverWait wait = new WebDriverWait(getDriver(), defaulttimeout);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitForElementToBeInvisible(int timeout){
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitForElementToBePresent(){
        WebDriverWait wait = new WebDriverWait(getDriver(), defaulttimeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementToBePresent(int timeout){
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementsToBePresent(){
        WebDriverWait wait = new WebDriverWait(getDriver(), defaulttimeout);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void waitForElementsToBePresent(int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void setImplicitWait(){
        getDriver().manage().timeouts().implicitlyWait(defaulttimeout, TimeUnit.SECONDS);
    }

    public void scrollToView(){
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", findWebElement());
    }
}
