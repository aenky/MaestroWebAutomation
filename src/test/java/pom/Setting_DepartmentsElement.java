package pom;

import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import stepDefinition.ServiceHook;

import java.util.List;

public class Setting_DepartmentsElement {
    private static WebElement element = null;
    private static List<WebElement> elementList = null;

    public static WebElement departmentsOption() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'Departments')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "Departments Option");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement newDepartmentButton() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'New Department')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "New Department Button");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    /*public static WebElement createButton() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'Create')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "Create Button");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }*/

    public static WebElement validationMessageField(String num) {
        element = null;
        try {
            By by = By.xpath("(//input[@aria-label='Name'])["+num+"]/../../div[2]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Confirm Button");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement deactivateDepartmentCheckBox() {
        element = null;
        try {
            By by = By.xpath("//label[contains(text(),'Deactivate This Department')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Deactivate Department CheckBox");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement inactiveColumnFilterIcon() {
        element = null;
        try {
            By by = By.xpath("//b[contains(text(),'Inactive')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Inactive Column Filter Icon");

        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> deactivateDepartmentList() {
        elementList=null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr/td[2]/div/div");
            WaitMethods.waitForElementToBeClickable(by, 5);
            elementList =SeleniumMethods.findElements(by, "Deactivate department List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }
}
