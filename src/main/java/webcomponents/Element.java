package webcomponents;

import data.ConfigurationManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

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
        return findWebElement().getText().trim();
    }

    protected boolean isDisplayed(){
        try{
            return findWebElement().isDisplayed();
        }catch (Exception e){
            logger.error("Element " + findWebElement() + " is not displayed", e);
        }
        return findWebElement().isDisplayed();
    }

    protected boolean isEnabled(){
        try{
            return findWebElement().isEnabled();
        }catch (Exception e){
            logger.error("Element " + findWebElement() + " is not enabled", e);
        }
        return findWebElement().isEnabled();
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
}
