package steps;

import driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectModel.Elements;
import pageObjectModel.SearchAndVerifyProcess_Page;

import java.util.concurrent.TimeUnit;

public class SearchAndVerifyProcess {
    private WebDriver driver = Driver.driver;
    WebDriverWait wait = new WebDriverWait(driver, 5);
    SearchAndVerifyProcess_Page searchAndVerifyProcess_page = new SearchAndVerifyProcess_Page();
    Elements elementsPage = new Elements(driver);
    private By searchInput = By.name("q");


    @Given("Navigate to Url")
    public void navigate_to_url() {
        driver.get("https://www.lely.com/en");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @When("Click the search button")
    public void click_the_search_button() {
        searchAndVerifyProcess_page.clickReject();
        searchAndVerifyProcess_page.clickSearchIcon();
    }

    @Then("Verify search area appeared")
    public void verify_search_area_appeared() {
        wait.until(ExpectedConditions.elementToBeClickable(searchInput));
    }

    @Then("Enter happy into the search area")
    public void enter_happy_into_the_search_area() {
        searchAndVerifyProcess_page.typeHappy("happy");
    }

    @Then("Click the search icon")
    public void click_the_search_icon() throws InterruptedException {
        searchAndVerifyProcess_page.clickSearhButton();
            Thread.sleep(5000);
    }

    @Then("Verify that the descriptions")
    public void verify_that_the_descriptions() {
        Assert.assertTrue("Not all search results contain the search term",
                searchAndVerifyProcess_page.doSearchResultsContain("happy"));
    }
}
