package tests.loginpagetests;

import data.BasePage;
import org.testng.annotations.Test;

/**
 * Created by oleksandr on 11.02.2018.
 */
public class LoginPage extends BasePage{

    @Test
    public static void getBasePage() throws InterruptedException {
        System.out.println("Getting first page");
        Thread.sleep(3000);
    }
}
