package Steps;

import Base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Test2_ModalSteps extends BaseUtil {

    private BaseUtil base;

    public Test2_ModalSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("I navigate to the test page with modal window")
    public void iNavigateToTheTestPageWithModalWindow() {
        System.out.println("Navigate to the login page");
        base.Driver.navigate().to("https://the-internet.herokuapp.com/exit_intent");
    }

    @And("I move a cursor to the Close tab button")
    public void iMoveACursorToTheCloseTabButton() throws AWTException, InterruptedException {
        //Adding wait
        base.Driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        //Create object of Robot class
        Robot robot = new Robot();

        //Set the target point for the cursor
        int x = 0;
        int y = 0;

        //Move cursor
        robot.mouseMove(x,y);

        System.out.println("Cursor moved");
        Thread.sleep(4000);
    }

    @Then("I should see that a modal windows appears")
    public void iShouldSeeThatAModalWindowsAppears() {
        System.out.println("I should see that a modal windows appears");

        //Initializing the 'wait' with X seconds delay before it throws a NoSuchElementException
        WebDriverWait wait = new WebDriverWait(base.Driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("modal-title")));
        System.out.println("modal-title = " + base.Driver.findElement(By.className("modal-title")).getText());

        Assert.assertEquals("Modal window is not displayed", base.Driver.findElement(By.className("modal-title")).isDisplayed(), true);
        System.out.println("After assert");

    }
}
