package pageObjectModel;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SelectAndViewProcess_Page extends Abstract {
    private WebDriver driver = Driver.driver;
    private LocatorReader locatorReader = new LocatorReader();
    private By downloadLink = By.xpath("//*[@class='result-item']//*[@class='buttons']//*[@href='https://www.lelynet.com/_layouts/15/document/TechDocHandler.aspx?name=D-S006VT_-.pdf&mode=download']");

    public SelectAndViewProcess_Page() {
        WebDriver driver1 = Driver.driver;
        PageFactory.initElements(driver1, this);
    }

    public void clickSearchableBox() {
        WebElement element = driver.findElement(locatorReader.getLocator("clickSearchableBox"));
        clickFunction(element);
    }

    public void sendValue(String value) {
        WebElement element = driver.findElement(locatorReader.getLocator("clickSearchableBoxSearchArea"));
        sendKeysFunction(element, value);
    }

    public void resultInfo() {
        WebElement element = driver.findElement(locatorReader.getLocator("resultInfo"));
        clickFunction(element);
    }

    public void clickViewDoc() {
        WebElement element = driver.findElement(locatorReader.getLocator("viewThisDoc"));
        clickFunction(element);
    }

    public void switchBackToOriginalTab() {
        String originalTab = driver.getWindowHandle();
        driver.switchTo().window(originalTab);
    }

    public void downloadDocument() {
        WebElement element = driver.findElement(locatorReader.getLocator("downloadLink2"));
        scrollToElement(element);
        wait.until(ExpectedConditions.visibilityOfElementLocated(downloadLink));
        clickFunction(element);
    }
}
