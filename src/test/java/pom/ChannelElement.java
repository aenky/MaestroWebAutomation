package pom;

import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import stepDefinition.ServiceHook;

import java.util.List;

public class ChannelElement {

    private static WebElement element = null;
    private static List<WebElement> elementList = null;

    public static WebElement channelHeading() {
        element = null;
        try {
            By by = By.xpath("//div[@class='room-name']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Channel Heading");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement moreOption() {
        element = null;
        try {
            By by = By.xpath("//i[contains(text(),'more_vert')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"More Option");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement memberListDialogBoxHeading() {
        element = null;
        try {
            By by = By.xpath("//p[@class='maz-dialog__header__title']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Member List Dialog Box Heading");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement membersListDialogBoxHeading() {
        element = null;
        By by = By.xpath("//p[@class='maz-dialog__header__title']");
        WaitMethods.waitForElementToLoad(by, 5);
        element = SeleniumMethods.findElementForElementNotVisible(by, "Members List Dialog Box Heading");

        return element;
    }

    public static List<WebElement> channelMembersList() {
        elementList = null;
        try {
            By by = By.xpath("//b[contains(text(), 'Participants')]/../../../../../../../../tbody/tr/td[2]/div/div");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList = SeleniumMethods.findElements(by,"Channel Members List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement leaveOption() {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(),'Leave')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "LeaveOption");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement channelName(String name) {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(),'"+name+"')]/../../..");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Channel Name");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

}
