package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Test1_LoginPage {
    public Test1_LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
