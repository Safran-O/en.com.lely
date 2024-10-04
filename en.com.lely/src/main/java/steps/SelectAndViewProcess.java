package steps;

import driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectModel.SearchAndVerifyProcess_Page;
import pageObjectModel.SelectAndViewProcess_Page;
import java.util.concurrent.TimeUnit;
import static pageObjectModel.Abstract.isFileDownloaded;

public class SelectAndViewProcess {
    private WebDriver driver = Driver.driver;
    WebDriverWait wait = new WebDriverWait(driver, 5);
    SearchAndVerifyProcess_Page searchAndVerifyProcess_page = new SearchAndVerifyProcess_Page();
    SelectAndViewProcess_Page selectAndViewProcess_page = new SelectAndViewProcess_Page();

    @Given("Navigate to Techdocs")
    public void navigate_to_techdocs() {
        driver.get("https://www.lely.com/techdocs/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @When("Click Searhbox")
    public void click_searhbox() {
        searchAndVerifyProcess_page.clickReject();
        selectAndViewProcess_page.clickSearchableBox();
    }

    @Then("Enter {string} and choose it")
    public void enter_and_choose_it(String value) throws InterruptedException {
        selectAndViewProcess_page.sendValue(value);
        selectAndViewProcess_page.resultInfo();
        Thread.sleep(5000);
    }

    @Then("View the document")
    public void view_the_document() throws InterruptedException {
        selectAndViewProcess_page.clickViewDoc();
        Thread.sleep(5000);

    }

    @Then("Return the main tab")
    public void return_the_main_tab() throws InterruptedException {
        selectAndViewProcess_page.switchBackToOriginalTab();
        Thread.sleep(5000);
        selectAndViewProcess_page.downloadDocument();

        // İndirilen dosyaların olduğu klasör
        String downloadDir = "/Users/onursafran/Downloads";
        // Kontrol edilecek dosya adı
        String fileName = "D-S006VT_-.pdf";

        // Dosyanın var olup olmadığını kontrol et
        boolean isDownloaded = isFileDownloaded(downloadDir, fileName);
        Assert.assertTrue("File was not downloaded", isDownloaded);
    }
}
