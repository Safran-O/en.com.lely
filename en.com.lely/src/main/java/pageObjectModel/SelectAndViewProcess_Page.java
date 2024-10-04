package pageObjectModel;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SelectAndViewProcess_Page extends Abstract{
    private WebDriver driver = Driver.driver;
    private By downloadLink = By.xpath("//*[@class='result-item']//*[@class='buttons']//*[@href='https://www.lelynet.com/_layouts/15/document/TechDocHandler.aspx?name=D-S006VT_-.pdf&mode=download']");

    public SelectAndViewProcess_Page() {
        WebDriver driver1 = Driver.driver;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//*[@class='select2-selection__rendered']")
    private WebElement clickSearchableBox;
    public void clickSearchableBox() {
        clickFunction(clickSearchableBox);
    }

    @FindBy(xpath = "//*[@class='select2-search__field']")
    private WebElement clickSearchableBoxSearchArea;
    public void sendValue(String value) {
        sendKeysFunction(clickSearchableBoxSearchArea,value);
    }

    @FindBy(xpath = "//*[@class='select2-results__option select2-level-2 select2-results__option--highlighted']")
    private WebElement resultInfo;
    public void resultInfo() {
        clickFunction(resultInfo);
    }

    @FindBy(xpath = "//*[@class='result-item']//*[@class='buttons']//*[@href='https://www.lelynet.com/_layouts/15/document/TechDocHandler.aspx?name=D-S006VT_-.pdf&mode=view']")
    private WebElement viewThisDoc;
    public void clickViewDoc(){
        clickFunction(viewThisDoc);
    }

    public void switchBackToOriginalTab() {
        String originalTab = driver.getWindowHandle();
        driver.switchTo().window(originalTab);
    }

    public void downloadDocument() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(downloadLink)).click();
    }
}
