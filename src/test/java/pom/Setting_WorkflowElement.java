package pom;

import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Setting_WorkflowElement {

    private static WebElement element = null;
    private static List<WebElement> elementList = null;

    public static WebElement workflowsOption() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'Workflows')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "Workflows Option");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement newWorkflowButton() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'New Workflow')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "New Workflow Button");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement deactivateWorkflowCheckBox() {
        element = null;
        try {
            By by = By.xpath("//label[contains(text(),'Deactivate This Workflow')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Deactivate Workflow CheckBox");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement editWorkflowNameField() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Workflow Name']");
            WaitMethods.waitForElementToBeClickable(by,10);
            element = SeleniumMethods.findElement(by, "Edit Workflow Name Field Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement addPhaseIcon() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(), '+')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "Add Phase Icon");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement addButton() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(), 'Add')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "Add Button");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> selectedPhaseList() {
        elementList=null;
        try {
            By by = By.xpath("//button[contains(text(), 'X')]/../p[3]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            elementList =SeleniumMethods.findElements(by, "Selected Phase List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement phaseDropdown() {
        element = null;
        try {
            By by = By.xpath("//form[@class='form']//input/../div");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "Phase Dropdown");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> closeIconList() {
        elementList=null;
        try {
            By by = By.xpath("//button[contains(text(), 'X')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            elementList =SeleniumMethods.findElements(by, "Close Icon List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }
}
