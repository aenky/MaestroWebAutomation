package pom;

import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Setting_TagElement {

    private static WebElement element = null;
    private static List<WebElement> elementList = null;

    public static WebElement tagsOption() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'Tags')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "tag Option");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement newTagButton() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'New Tag')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "New Tag Button");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement deactivateTagCheckBox() {
        element = null;
        try {
            By by = By.xpath("//label[contains(text(),'Deactivate This Tag')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Deactivate Tag CheckBox");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }
}
