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

public class Test1_LoginSteps extends BaseUtil {

    private BaseUtil base;

    public Test1_LoginSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("I navigate to the login test page")
    public void iNavigateToTheLoginTestPage() {
        System.out.println("Navigate to the login page");
        base.Driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @And("I type Correct Username in Username field")
    public void iTypeCorrectUsernameInUsernameField() {
        System.out.println("I type Correct Username in Username field");
        WebElement TestUsername = base.Driver.findElement(By.id("username"));
        TestUsername.sendKeys("tomsmith");
    }

    @And("I type Correct Password in Password field")
    public void iTypeCorrectPasswordInPasswordField() {
        System.out.println("I type Correct Password in Password field");
        WebElement TestPassword = base.Driver.findElement(By.id("password"));
        TestPassword.sendKeys("SuperSecretPassword!");
    }

    @And("I click the Login button")
    public void iClickTheLoginButton() {
        System.out.println("I click the Login button");
        WebElement TestLoginBt = base.Driver.findElement(By.xpath("//button[@class='radius']"));
        TestLoginBt.click();
    }

    @Then("I should see that User logged in with message ‘You logged into a secure area!’")
    public void iShouldSeeThatUserLoggedInWithMessageYouLoggedIntoASecureArea() {
        System.out.println("I should see that User logged in with message: You logged into a secure area!");

        //Initializing the 'wait' with X seconds delay before it throws a NoSuchElementException
        WebDriverWait wait = new WebDriverWait(base.Driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash")));
        System.out.println("Flash = " + base.Driver.findElement(By.className("flash")).getText());

        String expectedMessage = "You logged into a secure area!";
        String actualMessage = base.Driver.findElement(By.className("flash")).getText();

        //System.out.println("expectedMessage = " + expectedMessage);
        //System.out.println("actualMessage = " + actualMessage);
        if (actualMessage.contains(expectedMessage)) {
            System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed");

        }

        //Assert.assertEquals("It's not displayed", base.Driver.findElement(By.className("flash")).isDisplayed(), true);
        Assert.assertTrue(actualMessage.contains(expectedMessage));
        System.out.println("After assert");
    }

    @And("I type Incorrect Password in Password field")
    public void iTypeIncorrectPasswordInPasswordField() {
        System.out.println("I type Correct Password in Password field");
        WebElement TestPassword = base.Driver.findElement(By.id("password"));
        TestPassword.sendKeys("SuperSecretPassvord!");
    }

    @And("I type Incorrect Username in Username field")
    public void iTypeIncorrectUsernameInUsernameField() {
        System.out.println("I type Correct Password in Password field");
        WebElement TestUsername = base.Driver.findElement(By.id("password"));
        TestUsername.sendKeys("tom");
    }
}