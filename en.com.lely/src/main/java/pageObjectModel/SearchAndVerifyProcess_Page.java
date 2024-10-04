package pageObjectModel;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchAndVerifyProcess_Page extends Abstract {
    private WebDriver driver = Driver.driver;
    private By searchResults = By.xpath("//*[@class='page-section search-results']");

    public SearchAndVerifyProcess_Page() {
        WebDriver driver1 = Driver.driver;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//*[@class='header-navigation-button']//*[@class='header-navigation-button__label']")
    private WebElement clickSearhIcon;
    public void clickSearchIcon() {
        clickFunction(clickSearhIcon);
    }

    @FindBy(name = "q")
    private WebElement text;
    public void typeHappy(String value) {
        sendKeysFunction(text, value);
    }

    @FindBy(xpath = "//*[@class='button button-tertiary']")
    private WebElement clickSearhButton;
    public void clickSearhButton() {
        clickFunction(clickSearhButton);
    }

    //Arama sonuçlarının arama terimini içerdiğini doğrulama
    public boolean doSearchResultsContain(String term) {
        List<WebElement> results = driver.findElements(searchResults);
        for (WebElement result : results) {
            if (!result.getText().toLowerCase().contains(term.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    @FindBy(xpath = "//*[@class='wp-block-tc23-post-picker-group rapid-read-enabled rapid-read-date'] //*[@class='wp-block-tc23-post-picker']")
    private WebElement searchResultsArea;
    public void moveToPerformFunction(){
        new Actions(driver)
                .moveToElement(searchResultsArea)
                .perform();
    }


    @FindBy(id = "cookienotice-button-deny")
    private WebElement clickReject;
    public void clickReject() {
        clickFunction(clickReject);
    }
}
