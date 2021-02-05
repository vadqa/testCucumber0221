package Steps;

import Base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test4_NewWindowSteps  extends BaseUtil {
    private final BaseUtil base;

    public Test4_NewWindowSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("I navigate to the test page with Click Here button")
    public void iNavigateToTheTestPageWithClickHereButton() {
        System.out.println("Navigate to the page with tables");
        base.Driver.navigate().to("https://the-internet.herokuapp.com/windows");
    }

    @And("I find the Click Here button")
    public void iFindTheClickHereButton() {
        System.out.println("I find the Click Here button");

        //Initializing the 'wait' with X seconds delay before it throws a NoSuchElementException
        WebDriverWait wait = new WebDriverWait(base.Driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/windows/new']")));

        System.out.println("Span value = " + base.Driver.findElement(By.xpath("//a[@href='/windows/new']")).getText());

    }

    @And("I click on the Click Here button")
    public void iClickOnTheClickHereButton() throws InterruptedException {
        // Perform the click operation that opens new window
        WebElement ClickHereButton = base.Driver.findElement(By.xpath("//a[@href='/windows/new']"));
        Thread.sleep(3000);
        ClickHereButton.click();

        }


    @Then("I should see that the new window opens")
    public void iShouldSeeThatTheNewWindowOpens() {
        System.out.println("I should see that the new window opens");

        // Store the current window handle
        String winHandleBefore = base.Driver.getWindowHandle();

        // Switch to new window opened
        for(String winHandle : base.Driver.getWindowHandles()) {
            base.Driver.switchTo().window(winHandle);
        }

        // Perform the actions on new window

        //Initializing the 'wait' with X seconds delay before it throws a NoSuchElementException
        WebDriverWait wait = new WebDriverWait(base.Driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("example")));
        System.out.println("Flash = " + base.Driver.findElement(By.className("example")).getText());

        Assert.assertEquals("Windows is not displayed", base.Driver.findElement(By.className("example")).isDisplayed(), true);
        System.out.println("After assert");

        // Close the new window, if that window no more required
        base.Driver.close();

        // Switch back to original browser (first window)
        base.Driver.switchTo().window(winHandleBefore);

        // Continue with original browser (first window)


    }
}

