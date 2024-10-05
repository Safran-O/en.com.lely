package pageObjectModel;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.openqa.selenium.By;

import java.io.FileReader;
import java.io.IOException;

public class LocatorReader {
    private JsonObject locators;

    public LocatorReader() {
        try (FileReader reader = new FileReader("src/main/resources/locator.json")) {
            Gson gson = new Gson();
            locators = gson.fromJson(reader, JsonObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public By getLocator(String elementName) {
        String type = locators.getAsJsonObject(elementName).get("type").getAsString();
        String value = locators.getAsJsonObject(elementName).get("value").getAsString();

        switch (type) {
            case "id":
                return By.id(value);
            case "name":
                return By.name(value);
            case "xpath":
                return By.xpath(value);
            case "css":
                return By.cssSelector(value);
            default:
                throw new IllegalArgumentException("Unknown locator type: " + type);
        }
    }
}
