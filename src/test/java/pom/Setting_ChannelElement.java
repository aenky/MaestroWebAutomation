package pom;

import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Setting_ChannelElement {

    private static WebElement element = null;
    private static List<WebElement> elementList = null;

    public static WebElement channelsOption() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'Channels')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "Channels Option");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement newChannelButton() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'New Channel')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "New Department Button");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement channelTypeCheckBox(String type) {
        element = null;
        try {
            By by = By.xpath("(//label[contains(text(), '"+type+"')])[2]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "Channel Type Check Box");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement deactivateChannelCheckBox() {
        element = null;
        try {
            By by = By.xpath("//label[contains(text(),'Deactivate This Channel')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Deactivate Channel CheckBox");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> channelDescriptionList() {
        elementList=null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr/td[3]/div/div");
            WaitMethods.waitForElementToBeClickable(by, 5);
            elementList =SeleniumMethods.findElements(by, "Channel Description List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement editChannelTypeCheckBox(String type) {
        element = null;
        try {
            By by = By.xpath("(//label[contains(text(), '"+type+"')])");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "Edit Channel Type Check Box");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> channelTypeList() {
        elementList=null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr/td[2]/div/div");
            WaitMethods.waitForElementToBeClickable(by, 5);
            elementList =SeleniumMethods.findElements(by, "Channel Type List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> deactivateChannelList() {
        elementList=null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr/td[4]/div/div");
            WaitMethods.waitForElementToBeClickable(by, 5);
            elementList =SeleniumMethods.findElements(by, "Deactivate channel List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }
}
