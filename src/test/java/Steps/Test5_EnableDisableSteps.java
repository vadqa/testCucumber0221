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

public class Test5_EnableDisableSteps extends BaseUtil {
    private final BaseUtil base;


    public Test5_EnableDisableSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("I navigate to the test page with Enable button")
    public void iNavigateToTheTestPageWithEnableButton() {
        System.out.println("Navigate to the page with Enable button");
        base.Driver.navigate().to("https://the-internet.herokuapp.com/dynamic_controls");
    }

    @And("I find the Enable button and click it")
    public void iFindTheEnableButtonAndClickIt() throws InterruptedException {
        System.out.println("I find the Enable button and click it");

        //Initializing the 'wait' with X seconds delay before it throws a NoSuchElementException
        WebDriverWait wait = new WebDriverWait(base.Driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Enable']")));
        System.out.println("Button Enable value = " + base.Driver.findElement(By.xpath("//button[text()='Enable']")).getText());

        // Perform the click operation
        WebElement ClickHereButton = base.Driver.findElement(By.xpath("//button[text()='Enable']"));
        Thread.sleep(3000);
        ClickHereButton.click();

    }

    @And("I wait until the async process is finished")
    public void iWaitUntilTheAsyncProcessIsFinished() throws InterruptedException {
        Thread.sleep(5000);

        //Initializing the 'wait' with X seconds delay before it throws a NoSuchElementException
        WebDriverWait wait = new WebDriverWait(base.Driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Disable']")));
        System.out.println("Button Disable value = " + base.Driver.findElement(By.xpath("//button[text()='Disable']")).getText());

    }

    @And("I submit the string to the input field")
    public void iSubmitTheStringToTheInputField() {
        System.out.println("I submit the string to the input field");
        WebElement TestUsername = base.Driver.findElement(By.xpath("//input[@type='text']"));
        System.out.println("Input type value = " + base.Driver.findElement(By.xpath("//input[@type='text']")));
        TestUsername.sendKeys("This is a simple string.");
    }

    @And("Click on the Disable button, wait for async process")
    public void clickOnTheDisableButtonWaitForAsyncProcess() throws InterruptedException {
        System.out.println("Click on the Disable button, wait for async process");

        // Perform the click operation
        WebElement ClickHereButton = base.Driver.findElement(By.xpath("//button[text()='Disable']"));
        Thread.sleep(3000);
        ClickHereButton.click();

        //Initializing the 'wait' with X seconds delay before it throws a NoSuchElementException
        WebDriverWait wait = new WebDriverWait(base.Driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Enable']")));
        System.out.println("Button Disable value = " + base.Driver.findElement(By.xpath("//button[text()='Enable']")).getText());

    }

    @Then("I should see that the input field is disabled and still contains the string")
    public void iShouldSeeThatTheInputFieldIsDisabledAndStillContainsTheString() {
        String expectedMessage = "This is a simple string.";
        String actualMessage = base.Driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value").toString();

        System.out.println("expectedMessage = " + expectedMessage);
        System.out.println("actualMessage = " + actualMessage);
        if (actualMessage.contains(expectedMessage)) {
            System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed");

        }

        //Assert.assertEquals("It's not displayed", base.Driver.findElement(By.xpath("//input[@type='text']")).isDisplayed(), true);
        Assert.assertTrue(actualMessage.contains(expectedMessage));
        System.out.println("After assert");
    }
}
