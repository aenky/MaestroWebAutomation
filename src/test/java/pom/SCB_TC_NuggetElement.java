package pom;

import CommonUtility.CommonMethods;
import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import cucumber.api.java.en.When;
import gherkin.lexer.De;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import stepDefinition.Dashboard;
import stepDefinition.ServiceHook;
import stepDefinition.Sprint;

import java.util.List;

public class SCB_TC_NuggetElement {
    private static WebElement element = null;
    private static List<WebElement> elementList = null;

    public static List<WebElement> nameList() {
        elementList = null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr/td[2]/div/div");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList = SeleniumMethods.findElements(by,"Name Element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement assignIcon(String name) {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(),'"+name+"')]/../../../../td[1]//button[contains(text(),'+')]");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Assign Icon Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement removeIcon(String name) {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(),'"+name+"')]/../../../../td[1]//button[contains(text(),'-')]");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Remove Icon Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement removeIconNotVisible(String name) {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(),'"+name+"')]/../../../../td[1]//button[contains(text(),'-')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElementForElementNotVisible(by,"Remove Icon Element Not Visible");
        } catch (Exception e) {
            //throw e;
        }
        return element;
    }

    public static WebElement assignedStatus(String nuggetName) {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(),'"+nuggetName+"')]/../../../td[10]/div/div");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Assigned Status Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> listOfPhases() {
        elementList = null;
        try {
            By by = By.xpath("//div[@class='assignment-phase']/div");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList = SeleniumMethods.findElements(by,"List Of Phases Element");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> listOfSubTab() {
        elementList = null;
        try {
            By by = By.xpath("//div[@id='router']/div/div[1]//button/div[1]/div[1]/span[1]");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList = SeleniumMethods.findElements(by,"List Of Sub Tab Element");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement estimatedStatus(String nuggetName) {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(),'"+nuggetName+"')]/../../../td[9]/div/div");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Estimated Status Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement timeCardTabIcon() {
        element = null;
        try {
            By by = By.id("detail_sidebar_timecard");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Time Card Tab Icon Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement currentDateOption() {
        element = null;
        try {
            By by = By.xpath("//div[@class='month-picker__days']/button[contains(@class,'highlight')]");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Current Date Option Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement currentDateOptionForNull() {
        element = null;
        try {
            By by = By.xpath("//div[@class='month-picker__days']/button[contains(@class,'highlight')]");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElementForElementNotVisible(by,"Current Date Option Element");
        } catch (Exception e) {

        }
        return element;
    }

    public static WebElement targetDate() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Target Date']");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Target Date Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement estimatedHoursField() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Estimated Hours']");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Estimated Hours Field Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement submitEstimateButton() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'Submit Estimate')]");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Submit Estimate Button Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement selectDate(String date) {
        element = null;
        try {
            By by = By.xpath("//div[@class='month-picker__days']/button[contains(text(),'"+date+"')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by,date+" Date Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement plusIcon() {
        element = null;
        try {
            By by = By.xpath("//img[@class='plus-icon']");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by,"Plus Icon Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement hoursField() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Hours']");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by,"Hours Field Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement notesField() {
        element = null;
        try {
            By by = By.xpath("//textarea[@placeholder='Note *']");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by,"Notes Field Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement submitJournalButton() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'Submit Journal')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by,"Submit Journal Button Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> journalDateList() {
        elementList = null;
        try {
            By by = By.xpath("//div[@id='TimeCardDetailTimeCards' or @id='AssignmentDetailTimeCards']//tbody/tr/td[1]//span");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList = SeleniumMethods.findElements(by,"Journal Date List Elements");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> journalHoursList() {
        elementList = null;
        try {
            By by = By.xpath("//div[@id='TimeCardDetailTimeCards' or @id='AssignmentDetailTimeCards']//tbody/tr/td[2]/div/div");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList = SeleniumMethods.findElements(by,"Journal Hours List Elements");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> journalNotesList() {
        elementList = null;
        try {
            By by = By.xpath("//div[@id='TimeCardDetailTimeCards' or @id='AssignmentDetailTimeCards']//tbody/tr/td[3]/div/div");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList = SeleniumMethods.findElements(by,"Journal Notes List Elements");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement resourceName() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(), 'Journal for')]/following::span[1]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by,"Resource Name Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> resourceNameList() {
        elementList = null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr/td[6]//div[@class='username text-truncate']");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList = SeleniumMethods.findElements(by,"Resource Name List Elements");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement okButton() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'OK')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by,"OK Button Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> userName(String nuggetName) {
        elementList = null;
        try {
            By by = By.xpath("//div[contains(text(),'"+nuggetName+"')]/../../../td[11]/div/div/div");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList = SeleniumMethods.findElements(by,"User Name Element");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> approveCheckBox(String nuggetName) {
        elementList = null;
        try {
            By by = By.xpath("//div[contains(text(),'"+nuggetName+"')]/../../../td[6]//input");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList = SeleniumMethods.findElements(by,"Approve CheckBox Element");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement completedNugetStatus(String nuggetName) {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(),'"+nuggetName+"')]/../../../td[8]/div/div");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Completed Nuget Status Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement nugetStatus(String nuggetName, String phase) {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(),'"+nuggetName+"')]/../../../td[9]//div[contains(text(), '"+phase+"')]/../../../td[8]/div/div");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Completed Nuget Status Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement markAsCompleteCheckBox() {
        element = null;
        try {
            By by = By.xpath("//label[contains(text(),'Mark as Complete')]");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Mark as Complete checkbox Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement dialogBoxText(){
        element = null;
        try {
            By by = By.xpath("//div[@class='title']");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Dialog Box Text Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement submitButton() {
        element = null;
        try {
            By by = By.xpath("(//button[contains(text(),'Submit')])[last()]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by,"Submit Button Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }


    public static WebElement releaseDropDown() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Release']");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Release DropDown Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement tableColumnText(String text, String id) {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(),'"+text+"')]/../../../td["+id+"]/div/div");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Table Column Text Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> tableColumnTextList(String text, String id) {
        elementList = null;
        try {
            By by = By.xpath("//div[contains(text(),'"+text+"')]/../../../td["+id+"]/div/div");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList = SeleniumMethods.findElements(by,"Table Column Text Element");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement tableRow(String text, String id,String textTwo) {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(),'"+text+"')]/../../../td["+id+"]//div[contains(text(),'"+textTwo+"')]/../../../td[2]");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Table Row");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement tableColumnTextOfSpan(String text, String id) {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(),'"+text+"')]/../../../td["+id+"]/div/div/span");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Table Column span Text Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement approveCheckBox(String text,String id, String textTwo, String checkBoxId) {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(),'"+text+"')]/../../../td["+id+"]//div[contains(text(),'"+textTwo+"')]/../../../td["+checkBoxId+"]//label");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Check Box");
        } catch (Exception e) {
            throw e;
        }
        JavascriptExecutor js = (JavascriptExecutor) ServiceHook.driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

        return element;
    }

    public static WebElement approveNuggetCheckBox(String text,String id, String textTwo) {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(),'"+text+"')]/../../../td["+id+"]//div[contains(text(),'"+textTwo+"')]/../../../td[6]//label");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"approveCheckBox");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement resourceStatus(String name) {
        element = null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr/td[2]//div[contains(text(),'"+name+"')]/../../../../td[3]/div/div");
            WaitMethods.waitForElementToLoad(by, 10);
            element = SeleniumMethods.findElement(by,"Resource Status Elements");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }



}
