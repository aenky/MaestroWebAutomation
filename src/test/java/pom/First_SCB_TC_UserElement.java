package pom;

import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class First_SCB_TC_UserElement {

    private static WebElement element = null;
    private static List<WebElement> elementList = null;

    public static WebElement searchEmailField() {
        element = null;
        try {
            By by = By.id("login");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Search Email Field Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement enterSearchEmailIcon() {
        element = null;
        try {
            By by = By.id("refreshbut");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Enter Search Email Icon Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement signUpUserLink() {
        element = null;
        try {
            By by = By.xpath("//a[contains(., 'here')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Sign Up User Link Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement pageHeading() {
        element = null;
        By by = By.xpath("//h3[@class='title-header']");
        WaitMethods.waitForElementToLoad(by, 5);
        element = SeleniumMethods.findElementForElementNotVisible(by, "Page Heading Element");

        return element;
    }

    public static WebElement elementById(String id) {
        element = null;
        try {
            By by = By.id(id);
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, id+" field Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement privacyPolicyCheckBox() {
        element = null;
        try {
            By by = By.xpath("//input[@id='privacyPolicy']/../label[1]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Privacy Policy Check Box Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement signUpButton() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'Sign up')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Sign Up Button Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> checkBoxList(String name, String id) {
        elementList=null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr/td[3]//div[contains(text(),'"+name+"')]/../../../td["+id+"]/div//label");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList =SeleniumMethods.findElements(by, "Check Box List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement divElement(String text) {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(),'"+text+"')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Div Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement nuggetSummeryPopup() {
        element = null;
        try {
            By by = By.xpath("//div[contains(@class,'nugget-summary')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Nugget Summery Popup");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement nuggetSummeryPopupDetails(String id) {
        element = null;
        try {
            By by = By.xpath("//div[contains(@class,'nugget-summary')]/div[1]/span["+id+"]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Nugget Summery Popup Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement sentMessage(String message) {
        element = null;
        try {
            By by = By.xpath("(//strong[contains(text(),'"+message+"')])[last()]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Sent message Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement nuggetSummeryPopupDescription() {
        element = null;
        try {
            By by = By.xpath("//div[contains(@class,'nugget-summary')]/div[2]/div");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Nugget Summery Popup Description Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement threeDotsMenuIcon(String message) {
        element = null;
        try {
            By by = By.xpath("//strong[contains(text(),'"+message+"')]/../../../../../../..//i[contains(text(),'more_horiz')]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Three Dots Menu Icon");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement nuggetNameTextBox() {
        element = null;
        try {
            By by = By.xpath("//input[@placeholder='Nugget name *']");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Nugget Name Textbox Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement auditMessageSummeryPopup() {
        element = null;
        try {
            By by = By.xpath("//div[contains(@class,'scrollbar diff regular overflow-auto')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Audit Message Summery Popup");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement backlogCheckBox() {
        element = null;
        try {
            By by = By.xpath("//label[contains(text(),'Backlog')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Backlog Check Box");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement currentDateOption() {
        element = null;
        try {
            By by = By.xpath("//div[@class='month-picker__days']/button[contains(@class,'highlight')]/following::button[1]");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Current Date Option Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

}
