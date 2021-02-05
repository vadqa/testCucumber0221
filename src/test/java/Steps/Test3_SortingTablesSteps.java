package Steps;

import Base.BaseUtil;
import Pages.Test3_SortingTables;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;


public class Test3_SortingTablesSteps extends BaseUtil {

    private final BaseUtil base;

    public Test3_SortingTablesSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("I navigate to the test page with tables")
    public void iNavigateToTheTestPageWithTables() {
        System.out.println("Navigate to the page with tables");
        base.Driver.navigate().to("https://the-internet.herokuapp.com/tables");
    }

    @And("I find the column Last Name")
    public void iFindTheColumnLastName() {
        System.out.println("I find the column Last Name");

        //Initializing the 'wait' with X seconds delay before it throws a NoSuchElementException
        WebDriverWait wait = new WebDriverWait(base.Driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Last Name']")));
        System.out.println("Span value = " + base.Driver.findElement(By.xpath("//span[text()='Last Name']")).getText());

    }

    @And("I click on the column Last Name")
    public void iClickOnTheColumnLastName() throws AWTException, InterruptedException {
        WebElement table1Username = base.Driver.findElement(By.xpath("//span[text()='Last Name']"));
        Thread.sleep(4000);
        table1Username.click();

    }

    @Then("I should see that the TableOne is sorted by the Last Name column")
    public void iShouldSeeThatTheTableOneIsSortedByTheLastNameColumn() {
        Test3_SortingTables page = new Test3_SortingTables(base.Driver);

        //Capture all web elements into list
        //List<WebElement> elementsList = base.Driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> elementsList = base.Driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[1]"));

        //Capture text of all web elements into new (original) list
        List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
        System.out.println("originalList = " + originalList.toString());

        //sort on the original list of step 3 - sorted list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        System.out.println("sortedList = " + sortedList.toString());

        //Compare original list vs. sorted list
        //Assert.assertTrue(originalList.equals(sortedList));
        Assert.assertTrue("Table is NOT sorted ascending", originalList.equals(sortedList));
        System.out.println("After assert");

    }
}
