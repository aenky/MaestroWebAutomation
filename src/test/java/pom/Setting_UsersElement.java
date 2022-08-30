package pom;


import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Setting_UsersElement {

    private static WebElement element = null;
    private static List<WebElement> elementList = null;

    public static WebElement usersOption() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'Users')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "Users Option");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement inviteNewUsersButton() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'Invite New Users')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "Invite New Users Button");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement doneButton() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'Done')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "Done Button");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement emailTextBox() {
        element = null;
        try {
            By by = By.xpath("(//input[@aria-label='Email'])[2]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Email Text Box");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement emailErrorMSGTextBox() {
        element = null;
        try {
            By by = By.xpath("(//input[@aria-label='Email'])[2]/../../div[2]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Email Error Message Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }


    public static List<WebElement> selectedRoleOfUsersOnList() {
        elementList = null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr/td[5]/div/div");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList = SeleniumMethods.findElements(by,"Selected Role Of Users On List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> skillCloseIconList() {
        elementList = null;
        try {
            By by = By.xpath("//div[@class='coretable-root  table']//table//tbody//tr//td[2]//button");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList = SeleniumMethods.findElements(by,"Skill Close IconList");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> specialtiesDropdownList() {
        elementList = null;
        try {
            By by = By.xpath("//div[@class='coretable-root  table']//table//tbody//tr//td[4]//div[@class='maz-select__toggle']");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList = SeleniumMethods.findElements(by,"Specialties Dropdown List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> specialtiesOptionList() {
        elementList = null;
        try {
            By by = By.xpath("//div[@class='coretable-root  table']//table//tbody//tr//td[4]//button");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList = SeleniumMethods.findElements(by,"Specialties Option List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> deactivateUsersCheckBoxList() {
        elementList = null;
        try {
            By by = By.xpath("//div[@class='coretable-root maz-flex-1']//table//tbody//tr//td[last()]//label");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList = SeleniumMethods.findElements(by,"Deactivate Users Check Box List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

}
