package pom;

import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Setting_CalendarElement {

    private static WebElement element = null;
    private static List<WebElement> elementList = null;

    public static WebElement personalCalendarOption() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'Personal Calendar')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "Personal Calendar Option");
        } catch (Exception e) {
           throw e;
        }
        return element;
    }

    public static WebElement companyCalendarOption() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'Company Calendar')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "Personal Calendar Option");
        } catch (Exception e) {
           throw e;
        }
        return element;
    }

    public static WebElement newEventButton() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'New Event')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by, "New Event Button");
        } catch (Exception e) {
           throw e;
        }
        return element;
    }

    public static List<WebElement> eventList() {
        elementList = null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr");
            WaitMethods.waitForElementToLoad(by, 5);
            elementList = SeleniumMethods.findElements(by, "Event List Element");
        } catch (Exception e) {
           throw e;
        }
        return elementList;
    }

    public static WebElement dialogBoxHeading() {
        element = null;
        try {
            By by = By.xpath("//p[@class='maz-dialog__header__title']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Dialog Box Heading");
        } catch (Exception e) {
           throw e;
        }
        return element;
    }

    public static WebElement theDialogBoxHeading() {
        element = null;
        By by = By.xpath("//p[@class='maz-dialog__header__title']");
        WaitMethods.waitForElementToLoad(by, 5);
        element = SeleniumMethods.findElementForElementNotVisible(by, "Dialog Box Heading");
        return element;
    }

    public static WebElement startDate() {
        element = null;
        try {
            By by = By.xpath("(//input[@aria-label='Start Date'])[2]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Start Date Element");
        } catch (Exception e) {
           throw e;
        }
        return element;
    }

    public static WebElement endDate() {
        element = null;
        try {
            By by = By.xpath("(//input[@aria-label='End Date'])[2]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "End Date Element");
        } catch (Exception e) {
           throw e;
        }
        return element;
    }

    public static WebElement repeatDropdown() {
        element = null;
        try {
            By by = By.xpath("(//input[@aria-label='Repeat'])[2]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Repeat Dropdown Element");
        } catch (Exception e) {
           throw e;
        }
        return element;
    }

    public static WebElement nameTextBox() {
        element = null;
        try {
            By by = By.xpath("(//input[@placeholder='Name *'])[2]");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Name Textbox Element");
        } catch (Exception e) {
           throw e;
        }
        return element;
    }

    public static List<WebElement> eventNameList() {
        elementList=null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr/td[1]/div/div");
            WaitMethods.waitForElementToBeClickable(by, 5);
            elementList =SeleniumMethods.findElements(by, "List Of Name Element");
        } catch (Exception e) {
           throw e;
        }
        return elementList;
    }

    public static WebElement deleteEventCheckBox() {
        element = null;
        try {
            By by = By.xpath("//label[contains(text(),'Delete This Holiday')]");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Delete Event CheckBox");
        } catch (Exception e) {
           throw e;
        }
        return element;
    }

    public static WebElement editStartDate() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Start Date']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Edit Start Date Element");
        } catch (Exception e) {
           throw e;
        }
        return element;
    }

    public static List<WebElement> eventDateList() {
        elementList=null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr/td[2]/div/div");
            WaitMethods.waitForElementToBeClickable(by, 5);
            elementList =SeleniumMethods.findElements(by, "Event Date List Element");
        } catch (Exception e) {
           throw e;
        }
        return elementList;
    }

    public static WebElement editEndDate() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='End Date']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Edit End Date Element");
        } catch (Exception e) {
           throw e;
        }
        return element;
    }

    public static WebElement editRepeatDropdown() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Repeat']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Edit Repeat Dropdown Element");
        } catch (Exception e) {
           throw e;
        }
        return element;
    }

    public static List<WebElement> eventsSelectedRepeatOptionList() {
        elementList=null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr/td[4]/div/div");
            WaitMethods.waitForElementToBeClickable(by, 5);
            elementList =SeleniumMethods.findElements(by, "Event Date List Element");
        } catch (Exception e) {
           throw e;
        }
        return elementList;
    }

    public static WebElement weekdayCheckbox(String day) {
        element = null;
        try {
            By by = By.xpath("//label[contains(text(),'"+day+"')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Week days Checkbox");
        } catch (Exception e) {
           throw e;
        }
        return element;
    }

}
