package pom;

import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class DashboardElement {

    private static WebElement element = null;
    private static List<WebElement> elementlist = null;

    public static WebElement activeProjectTab() {
        element = null;
        try {
            By by = By.id("projects_page_all_projects");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Active Project Tab");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement backlogSprintsTab() {
        element = null;
        try {
            By by = By.id("projects_page_backlogged");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Backlog Sprints Tab");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement releasedSprintsTab() {
        element = null;
        try {
            By by = By.id("projects_page_released");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Released Sprints Tab");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement createProjectButton() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(), 'Create Project')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by,"Create Project Button");

        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement createProjectButtons() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(), 'Create Project')]");
            //WaitMethods.waitForElementToBeClickable(by, 5);
            element =SeleniumMethods.findElement(by, "Create Project Button");
        } catch (Exception e) {
            //throw e;
        }
        return element;
    }

    public static WebElement createProjectDialogboxHeading() {
        element = null;
        try {
            By by = By.xpath("//p[contains(text(), 'Create Project')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element =SeleniumMethods.findElement(by, "Create Project Dialog box Heading");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement closeIcon() {
        element = null;
        try {
            By by = By.xpath("//div[@class='maz-flex close-dialog']");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element =SeleniumMethods.findElement(by,"Close Icon");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement createButton() {
        element = null;
        try {
            By by = By.xpath("//div[contains(@class,'maz-dialog__body')]/..//button[contains(text(), 'Create')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element =SeleniumMethods.findElement(by, "Create Button");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement projectTitleField() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Title']");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element =SeleniumMethods.findElement(by, "Project Title Field");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement projectWorkflowField() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Workflow']");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element =SeleniumMethods.findElement(by,"Project Workflow Field");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement projectStatusField() {
        element = null;
        try {
            By by = By.xpath("(//input[@aria-label='Status'])[2]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element =SeleniumMethods.findElement(by, "Project Status Field");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement projectMaestroField() {
        element = null;
        try {
            By by = By.xpath("(//input[@aria-label='Project Maestro'])[2]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element =SeleniumMethods.findElement(by, "Project Maestro Field");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement secondaryMaestroField() {
        element = null;
        try {
            By by = By.xpath("(//input[@aria-label='Secondary Maestro'])[2]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element =SeleniumMethods.findElement(by, "Secondary Maestro Field");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> projectWorkflowList() {
        elementlist=null;
        try {
            By by = By.xpath("//div[contains(@class,'maz-select__options-list__items-container')]/button/span");
            WaitMethods.waitForElementToBeClickable(by, 5);
            elementlist =SeleniumMethods.findElements(by, "Project Workflow List");
        } catch (Exception e) {
            throw e;
        }
        return elementlist;
    }

    public static List<WebElement> projectStatusList() {
        elementlist=null;
        try {
            By by = By.xpath("//div[contains(@class,'maz-select__options-list__items-container')]/button/span");
            WaitMethods.waitForElementToBeClickable(by, 5);
            elementlist =SeleniumMethods.findElements(by, "Project Status List");
        } catch (Exception e) {
            throw e;
        }
        return elementlist;
    }

    public static List<WebElement> projectMaestroList() {
        elementlist=null;
        try {
            By by = By.xpath("//div[contains(@class,'maz-select__options-list__items-container')]/button/span");
            WaitMethods.waitForElementToBeClickable(by, 5);
            elementlist =SeleniumMethods.findElements(by, "Project Maestro List");
        } catch (Exception e) {
            throw e;
        }
        return elementlist;
    }

    public static List<WebElement> secondaryMaestroList() {
        elementlist=null;
        try {
            By by = By.xpath("//div[contains(@class,'maz-select__options-list__items-container')]/button/span");
            WaitMethods.waitForElementToBeClickable(by, 5);
            elementlist =SeleniumMethods.findElements(by, "Secondary Maestro List");
        } catch (Exception e) {
            throw e;
        }
        return elementlist;
    }

    public static WebElement toastNotificationPopup() {
        element = null;
        try {
            By by = By.xpath("//p[@class='v-toast__text']");
            WaitMethods.waitForElementToLoad(by,5);
            element =SeleniumMethods.findElement(by,"Toast Notification Popup");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> projectList() {
        elementlist = null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr");
            WaitMethods.waitForElementToLoad(by, 5);
            elementlist =SeleniumMethods.findElements(by, "List Of The Row");
        } catch (Exception e) {
            throw e;
        }
        return elementlist;
    }


    public static WebElement editProjectName() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Name']");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Edit Name Field");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement saveButton() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'Save')]");
            WaitMethods.waitForElementToBeClickable(by,5);
            element = SeleniumMethods.findElement(by,"Save Button");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement editProjectMaestroDropdown() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Project Maestro']");
            WaitMethods.waitForElementToBeClickable(by,5);
            element = SeleniumMethods.findElement(by, "Edit Project Maestro Dropdown");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement editSecondaryMaestroDropdown() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Secondary Maestro']");
            WaitMethods.waitForElementToBeClickable(by,5);
            element = SeleniumMethods.findElement(by, "Edit Secondary Maestro Dropdown");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement editDescriptionTextBox() {
        element = null;
        try {
            By by = By.xpath("//textarea[@placeholder='Description']");
            WaitMethods.waitForElementToBeClickable(by,5);
            element = SeleniumMethods.findElement(by, "Edit Description Textbox");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement editProjectStatusField() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Status']");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element =SeleniumMethods.findElement(by, "Edit Project Status Field");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> listOfProjectStatus() {
        elementlist = null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr/td[5]/div/div");
            WaitMethods.waitForElementToLoad(by, 5);
            elementlist =SeleniumMethods.findElements(by, "List Of Project Status");
        } catch (Exception e) {
            throw e;
        }
        return elementlist;
    }

    public static List<WebElement> listOfProjectColumnHeading() {
        elementlist = null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/thead/tr/th//b");
            WaitMethods.waitForElementToLoad(by, 5);
            elementlist = SeleniumMethods.findElements(by, "List Of Project Column Heading");
        } catch (Exception e) {
            throw e;
        }
        return elementlist;
    }

    public static List<WebElement> listOfProjectId() {
        elementlist = null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr/td[1]/div/div");
            WaitMethods.waitForElementToLoad(by, 5);
            elementlist =SeleniumMethods.findElements(by, "List Of Project Id");
        } catch (Exception e) {
            throw e;
        }
        return elementlist;
    }

    public static List<WebElement> listOfDashboardSubTabHeading() {
        elementlist = null;
        try {
            By by = By.xpath("//div[@id='ProjectsPage']//button/div[1]/div[1]/span[1]");
            WaitMethods.waitForElementToLoad(by, 5);
            elementlist =SeleniumMethods.findElements(by, "List Of Dashboard SubTab Heading");
        } catch (Exception e) {
            throw e;
        }
        return elementlist;
    }

    public static WebElement chatTabIcon() {
        element = null;
        try {
            By by = By.id("detail_sidebar_chat");
            WaitMethods.waitForElementToBeClickable(by,5);
            element = SeleniumMethods.findElement(by, "Chat Tab Icon");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement detailsTabIcon() {
        element = null;
        try {
            By by = By.id("detail_sidebar_details");
            WaitMethods.waitForElementToBeClickable(by,5);
            element = SeleniumMethods.findElement(by, "Details Tab Icon Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement chatAttachmentTabIcon() {
        element = null;
        try {
            By by = By.id("detail_sidebar_attachments");
            WaitMethods.waitForElementToBeClickable(by,5);
            element = SeleniumMethods.findElement(by, "Chat Attachment Tab Icon Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> listOfNugget() {
        elementlist = null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr");
            WaitMethods.waitForElementToLoad(by, 5);
            elementlist = SeleniumMethods.findElements(by, "List Of Nugget");
        } catch (Exception e) {
            throw e;
        }
        return elementlist;
    }

    public static WebElement emptyListMessage() {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(), 'No available data')]");
            WaitMethods.waitForElementToBeClickable(by,5);
            element = SeleniumMethods.findElement(by, "Empty List Message");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement attachmentMedia() {
        element = null;
        try {
            By by = By.id("attachment_media");
            WaitMethods.waitForElementToBeClickable(by,5);
            element = SeleniumMethods.findElement(by, "Attachment Media");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement attachmentDocuments() {
        element = null;
        try {
            By by = By.id("attachment_documents");
            WaitMethods.waitForElementToBeClickable(by,5);
            element = SeleniumMethods.findElement(by, "Attachment Documents");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement createdProjectName() {
        element = null;
        try {
            By by = By.xpath("//tbody/tr[@class='table-line maz-align-center table-row-item active']/td[2]//div[@class='text-column']");
            WaitMethods.waitForElementToBeClickable(by,10);
            element = SeleniumMethods.findElement(by, "Created Project Name");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement createdProjectRow(String projectName) {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(), '"+projectName+"')]/../../..");
            WaitMethods.waitForElementToLoad(by,10);
            element = SeleniumMethods.findElement(by, "Created Project Row");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement statusHeader() {
        element = null;
        try {
            By by = By.xpath("//b[contains(text(), 'Status')]");
            WaitMethods.waitForElementToBeClickable(by,10);
            element = SeleniumMethods.findElement(by, "Status Header Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement filterOption() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(), 'Filter')]");
            WaitMethods.waitForElementToBeClickable(by,10);
            element = SeleniumMethods.findElement(by, "Filter Option Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement filterCheckBoxOption(String status) {
        element = null;
        try {
            By by = By.xpath("//label[contains(text(), '"+status+"')]");
            WaitMethods.waitForElementToBeClickable(by,10);
            element = SeleniumMethods.findElement(by, "Filter Option Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement applyFilterButton() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(), 'Apply Filter')]");
            WaitMethods.waitForElementToBeClickable(by,10);
            element = SeleniumMethods.findElement(by, "Apply Filter Button");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement scrollElement() {
        element = null;
        try {
            By by = By.xpath("//div[@class='scrollbar coretab-scrollbar regular hover inactive--y']");
            WaitMethods.waitForElementToBeClickable(by,10);
            element = SeleniumMethods.findElement(by, "dsfsdf");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

}
