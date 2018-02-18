package webcomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by irina on 11.02.2018.
 */
public abstract class Element {

    private By by;
    private List<WebElement> webElements;
    private int defaulttimeout = 10;

    public Element(By _by){
        this.by = _by;
    }

    public Element(List<WebElement> _webElements){
        this.webElements = _webElements;
    }



}
