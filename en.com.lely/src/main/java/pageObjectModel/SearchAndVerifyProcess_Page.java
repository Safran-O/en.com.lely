package pageObjectModel;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchAndVerifyProcess_Page extends Abstract {
    private WebDriver driver = Driver.driver;
    private LocatorReader locatorReader = new LocatorReader(); // Locatorları JSON'dan okumak için

    public SearchAndVerifyProcess_Page() {
        WebDriver driver1 = Driver.driver;
        PageFactory.initElements(driver1, this);
    }

    public void clickSearchIcon() {
        WebElement clickSearhIcon = driver.findElement(locatorReader.getLocator("clickSearhIcon"));
        clickFunction(clickSearhIcon);
    }

    public void typeHappy(String value) {
        WebElement text = driver.findElement(locatorReader.getLocator("text"));
        sendKeysFunction(text, value);
    }

    public void clickSearhButton() {
        WebElement clickSearhButton = driver.findElement(locatorReader.getLocator("clickSearhButton"));
        clickFunction(clickSearhButton);
    }

    // Arama sonuçlarının arama terimini içerdiğini doğrulama
    public boolean doSearchResultsContain(String term) {
        WebElement relatedPlace = driver.findElement(locatorReader.getLocator("searchResults"));
        scrollToElement(relatedPlace);

        List<WebElement> results = driver.findElements(locatorReader.getLocator("getArticle"));
        List<String> notMatchingResults = new ArrayList<>(); // Arama terimini içermeyen sonuçlar için liste
        for (WebElement result : results) {
            String resultText = result.getText().toLowerCase();
            if (!result.getText().toLowerCase().contains(term.toLowerCase())) {
                notMatchingResults.add(resultText); // Terimi içermeyenleri listeye ekle
            }
        }

        // Arama terimini içermeyen sonuçları ekrana yazdır
        if (!notMatchingResults.isEmpty()) {
            System.out.println("The following results do not contain the search term '" + term + "':");
            for (String notMatching : notMatchingResults) {
                System.out.println(notMatching);
            }
            return false; // Eğer terimi içermeyen sonuçlar varsa false döner
        }

        return true;

    }

    public void clickReject() {
        WebElement clickReject = driver.findElement(locatorReader.getLocator("clickReject"));
        clickFunction(clickReject);
    }
}
