package pom;

import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Setting_SkillElement {

    private static WebElement element = null;
    private static List<WebElement> elementList = null;

    public static WebElement skillsOption() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'Skills')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "Skills Option");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement newSkillButton() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'New Skill')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "New Skill Button");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement deactivateSkillCheckBox() {
        element = null;
        try {
            By by = By.xpath("//label[contains(text(),'Deactivate This Skill')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Deactivate Skill CheckBox");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement specialtiesTextBox() {
        element = null;
        try {
            By by = By.xpath("//input[@placeholder='Specialties']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Specialties Text Box");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> specialtiesList(int index) {
        elementList=null;
        try {
            By by = By.xpath("//tr["+index+"]//td[3]//div[@class='specialty-card']");
            WaitMethods.waitForElementToBeClickable(by, 5);
            elementList =SeleniumMethods.findElements(by, "Specialties List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement closeIconOfSpecialty(String specialty) {
        element=null;
        try {
            By by = By.xpath("//span[contains(text(),'"+specialty+"')]/../../..//div[@class='ti-actions']");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element =SeleniumMethods.findElement(by, "Close Icon Of Specialty");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> tableColumnTextList(String text, String id) {
        elementList = null;
        try {
            By by = By.xpath("//div[contains(text(),'"+text+"')]/../../../td["+id+"]/div/div/div");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList = SeleniumMethods.findElements(by,"Table Column Text Element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

}
