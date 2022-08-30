package pom;

import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Setting_PhaseElement {

    private static WebElement element = null;
    private static List<WebElement> elementList = null;

    public static WebElement phasesOption() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'Phases')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "Phases Option");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement newPhaseButton() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'New Phase')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "New Phase Button");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement deactivatePhaseCheckBox() {
        element = null;
        try {
            By by = By.xpath("//label[contains(text(),'Deactivate This Phase')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Deactivate Phase CheckBox");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement associatedSkillDropdown(int index) {
        element = null;
        try {
            By by = By.xpath("(//input[@aria-label='Associated Skill'])["+index+"]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Associated Skill Dropdown");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement phaseNameTextBox() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Phase Name']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Phase Name Text Box");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }
}
