package pageObjectModel;

import driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public abstract class Abstract {
    private WebDriver driver = Driver.driver;
    WebDriverWait wait = new WebDriverWait(driver, 5);
    Actions actions = new Actions(driver);  // Actions sınıfı ile kaydırma ve fare hareketlerini kullanacağız

    public void clickFunction(WebElement clickElement){
        wait.until(ExpectedConditions.elementToBeClickable(clickElement));
        clickElement.click();
    }

    public void assertTrue(WebElement actual){
        wait.until(ExpectedConditions.visibilityOf(actual));
        Assert.assertTrue("It is included", actual.isDisplayed());
    }

    public void sendKeysFunction(WebElement sendkeysElement, String value){
        wait.until(ExpectedConditions.visibilityOf(sendkeysElement));
        sendkeysElement.sendKeys(value);
    }

    public static boolean isFileDownloaded(String downloadDir, String fileName) {
        // Klasör objesi
        File dir = new File(downloadDir);

        // Klasördeki tüm dosyaları listeleme
        File[] dirContents = dir.listFiles();

        // Klasördeki dosyaları kontrol
        if (dirContents != null) {
            for (File file : dirContents) {
                if (file.getName().equals(fileName)) {
                    return true;  // Dosya bulundu
                }
            }
        }
        return false;  // Dosya bulunamadı
    }

    public void scrollToElement(WebElement element) {
        try {
            // Element ekranda görünürse kaydır
            wait.until(ExpectedConditions.visibilityOf(element));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            throw new RuntimeException("Elemente kaydırma işlemi başarısız oldu. Element: " + element + ". Hata: " + e.getMessage());
        }
    }
}
