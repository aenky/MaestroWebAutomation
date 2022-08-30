package pom;

import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import stepDefinition.ServiceHook;

import java.util.List;

public class SprintElement {

    private static WebElement element = null;
    private static List<WebElement> elementList = null;

    public static WebElement createSprintButton() {
        element = null;
        try {
            By by = By.xpath("//i/../../span[contains(text(),'Create')]");
            WaitMethods.waitForElementToBeClickable(by,5);
            element = SeleniumMethods.findElement(by, "Create Sprint Button");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> nuggetList() {
        elementList=null;
        try {
            By by = By.xpath("(//table[@class='tracking-table'])[1]/div/tbody/tr");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList = SeleniumMethods.findElements(by, "Nugget List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> nuggetSprintList() {
        elementList=null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr/td[5]/div//input");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList = SeleniumMethods.findElements(by, "Nugget Sprint List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> nuggetSprintListSix() {
        elementList=null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr/td[6]/div//input");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList = SeleniumMethods.findElements(by, "Nugget Sprint List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement approvalDueNuggetTab() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(),'Approvals Due')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by,"Approval Due nugget tab");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement backlogNuggetTab() {
        element = null;
        try {
            By by = By.id("good_news_backlog");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Backlog nugget tab");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement delayedNuggetTab() {
        element = null;
        try {
            By by = By.id("bad_news_delayed_nuggets");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Delayed nugget tab");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement overdueEstimateTab() {
        element = null;
        try {
            By by = By.id("bad_news_overdue_estimate");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Overdue estimate tab");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement createSprintDialogBoxHeading() {
        element = null;
        try {
            By by = By.xpath("//p[contains(text(),'Add Sprint')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Create Sprint Dialog Box Heading");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement sprintNameTextBox() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Sprint Name']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Sprint Name Text Box Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement backlogCheckBox() {
        element = null;
        try {
            By by = By.xpath("//form[@class='mb-3 form']//label[contains(text(),'Backlog')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Backlog Check Box");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }
    public static WebElement returnToTriageDatePickers() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Return To Triage']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Return To Triage Date Pickers Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement saveButton(int index) {
        element = null;
        try {
            By by = By.xpath("(//button[contains(text(),'Save')])["+index+"]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Save Button Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }


    public static WebElement sprintName(String name) {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(), '"+name+"')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Sprint Name Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement sprintNameNotVisible(String name) {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(), '"+name+"')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElementForElementNotVisible(by,"Sprint Name Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement rightSideArrow() {
        element = null;
        try {
            By by = By.xpath("//div[@class='maz-base-component maz-picker maz-picker--primary']/div[2]/div/div/div[1]/button[2]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by,"Right Side Arrow");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement selectDate(String date) {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'"+date+"')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by,date+" date element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement sprintReturnDate(String name) {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(), '"+name+"')]/../span[2]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Sprint Return To Triage date Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement moreOption() {
        element = null;
        try {
            By by = By.xpath("//i[contains(text(), 'more_vert')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"More Option Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement editIcon() {
        element = null;
        try {
            By by = By.xpath("//span[@class='edit']/i");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Edit Icon");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement closeIcon() {
        element = null;
        try {
            By by = By.xpath("//button[@title='clear']/i");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Close Icon");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement editTextBox() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Enter text']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Edit Text box Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement updateButton() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(), 'Update')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Update Button Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement updateDialogBoxHeader() {
        element = null;
        try {
            By by = By.xpath("//p[contains(text(),'Update Sprint')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Update Dialog Box Header");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement firstSprint() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(),'Create')]/../../button[3]/span[1]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"First Sprint Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement deleteIcon() {
        element = null;
        try {
            By by = By.xpath("//span[@class='delete']/i");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Delete Icon");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement saveIcon() {
        element = null;
        try {
            By by = By.xpath("//i[contains(text(), 'save')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by,"Save Icon");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement sprintRow(String name) {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(), '"+name+"')]/..");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Sprint Row Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement saveAssignSprintIcon() {
        element = null;
        try {
            By by = By.xpath("//i[contains(text(), 'save')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Save Assign Sprint Icon");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement closeAssignSprintIcon() {
        element = null;
        try {
            By by = By.xpath("//i[contains(text(), 'close')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Close Icon");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> nuggetNameList() {
        elementList=null;
        try {
            By by = By.xpath("(//table[@class='tracking-table'])[1]/div/tbody/tr/td[2]/div/div");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList = SeleniumMethods.findElements(by, "Nugget name List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement nuggetArchiveCheckbox(String nuggetName) {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(),'"+nuggetName+"')]/../../../td[6]/div/span/div/label");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Nugget Archive Checkbox");
        } catch (Exception e) {
            throw e;
        }
        JavascriptExecutor js = (JavascriptExecutor) ServiceHook.driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        return element;
    }

    public static WebElement nuggetSprintDropdown(String nuggetName) {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(),'"+nuggetName+"')]/../../../td[5]/div/span/div/div/div/div");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by,"Nugget Sprint Dropdown");
        } catch (Exception e) {
            throw e;
        }
        JavascriptExecutor js = (JavascriptExecutor) ServiceHook.driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        return element;
    }

    public static WebElement listScrollElement() {
        element = null;
        try {
            By by = By.xpath("//div[@id='GoodNewsBacklog']/div//div[contains(@class,'scroll-content xeba-scrollbar')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"List Scroll Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

}
