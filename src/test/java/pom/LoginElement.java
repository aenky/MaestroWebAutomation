package pom;
import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class LoginElement {
    private static WebElement element = null;
    private static List<WebElement> elementList = null;

    public static WebElement loginEmailTextBox() {
        element = null;
        try {
            By by = By.id("email");
            element =SeleniumMethods.findElement(by,"Email element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement loginPasswordTextBox() {
        element = null;
        try {
            By by = By.id("password");
            element =SeleniumMethods.findElement(by, "Password element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement loginButton() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'Login')]");
            element =SeleniumMethods.findElement(by, "Login button element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement wrongEmailAndPasswordValidationMsg() {
        element = null;
        try {
            By by = By.xpath("//p[@class='v-toast__text']");
            WaitMethods.waitForElementToLoad(by,5);
            element =SeleniumMethods.findElement(by,"Toast validation message element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement maestroLogo() {
        element = null;
        try {
            By by = By.xpath("//*[@customId='logo']");
            WaitMethods.waitForElementToBeClickable(by,20);
            element =SeleniumMethods.findElement(by, "Maestro Logo element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement userProfileImage() {
        element = null;
        try {
            By by = By.xpath("//div[@class='vue-avatar--wrapper']");
            WaitMethods.waitForElementToLoad(by,20);
            element =SeleniumMethods.findElement(by, "User profile element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement accountTypeDropdown() {
        element = null;
        try {
            By by = By.xpath("//input[@placeholder='Account']");
            //WaitMethods.waitForElementToBeClickable(by,10);
            element =SeleniumMethods.findElement(by, "Account dropdown element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement loginButtonOnSelectAccountTypePage() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'Login')]");
            //WaitMethods.waitForElementToBeClickable(by,10);
            element = SeleniumMethods.findElement(by, "Login button element on select account type page");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> listOfAccountType() {
        elementList = null;
        try {
            By by = By.xpath("//div[@class='maz-select__options-list__items-container maz-flex maz-direction-column']/button");
            WaitMethods.waitForElementToBeClickable(by,10);
            elementList = SeleniumMethods.findElements(by,"Find list of account type");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement accountType(String accountType) {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(),'"+accountType+"')]");
            //WaitMethods.waitForElementToBeClickable(by,10);
            element =SeleniumMethods.findElement(by,"Click on "+accountType+" Account type");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement sideMenu() {
        element = null;
        try {
            By by = By.id("sidebar");
            WaitMethods.waitForElementToBeClickable(by,10);
            element =SeleniumMethods.findElement(by,"Side Navigation menu");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

}
