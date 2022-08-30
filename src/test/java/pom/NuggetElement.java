package pom;

import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NuggetElement {
    private static WebElement element = null;
    private static List<WebElement> elementList = null;

    public static WebElement createNuggetButton() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(), 'Compose')]/..");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Create Nugget Button Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement createNuggetHeading() {
        element = null;
        try {
            By by = By.xpath("//p[contains(text(), 'Create Nugget')]");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Create Nugget Title Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement nuggetTypeDropdown() {
        element = null;
        try {
            By by = By.xpath("(//input[@placeholder='Type *'])[2]");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Nugget Type Dropdown Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement nuggetNameTextBox() {
        element = null;
        try {
            By by = By.xpath("//input[@placeholder='Name *']");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Nugget Name Textbox Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement nuggetProjectDropdown() {
        element = null;
        try {
            By by = By.xpath("//form[@slot='default']//input[@placeholder='Project *']");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Nugget Project Dropdown Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement nuggetPriorityDropdown() {
        element = null;
        try {
            By by = By.xpath("//form[@slot='default']//input[@placeholder='Priority *']");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Nugget Priority Dropdown Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement nuggetDescriptionTextBox() {
        element = null;
        try {
            By by = By.xpath("//form[@slot='default']//textarea[@placeholder='Description *']");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Nugget Description Textbox Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> nuggetTypeList() {
        elementList=null;
        try {
            By by = By.xpath("//div[contains(@class,'maz-select__options-list__items-container')]/button/span");
            WaitMethods.waitForElementToBeClickable(by, 5);
            elementList =SeleniumMethods.findElements(by, "Nugget Type List Element");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> nuggetProjectList() {
        elementList=null;
        try {
            By by = By.xpath("//div[contains(@class,'maz-select__options-list__items-container')]/button/span");
            WaitMethods.waitForElementToBeClickable(by, 5);
            elementList =SeleniumMethods.findElements(by, "Project List Element");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> nuggetPriorityList() {
        elementList=null;
        try {
            By by = By.xpath("//div[contains(@class,'maz-select__options-list__items-container')]/button/span");
            WaitMethods.waitForElementToBeClickable(by, 5);
            elementList =SeleniumMethods.findElements(by, "Nugget Priority List Element");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement validationMSgForNuggetNameTextBox() {
        element = null;
        try {
            By by = By.xpath("//input[@placeholder='Name *']/../../div[2]");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Validation MSg For Nugget Name Textbox Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement validationMSgForNuggetProjectTextBox() {
        element = null;
        try {
            By by = By.xpath("//input[@placeholder='Project *']/../../../../div[2]");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Validation MSg For Nugget Project Textbox Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement validationMSgForNuggetDescriptionTextBox() {
        element = null;
        try {
            By by = By.xpath("//textarea[@placeholder='Description *']/../../div[2]");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Validation MSg For Nugget Description Textbox Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement subscribedTab() {
        element = null;
        try {
            By by = By.id("nugget_page_subscriptions_active");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by,"Subscribed Tab Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> nuggetNameList() {
        elementList=null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr/td[3]/div/div");
            WaitMethods.waitForElementToBeClickable(by, 5);
            elementList =SeleniumMethods.findElements(by, "Nugget Name List Element");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> nuggetList() {
        elementList=null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr");
            WaitMethods.waitForElementToBeClickable(by, 5);
            elementList =SeleniumMethods.findElements(by, "Nugget List Element");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement auditMessageForCreate() {
        element = null;
        try {
            By by = By.xpath("(//span[@class='audit-message']/span/div)[2]");
            WaitMethods.waitForElementToLoad(by, 10);
            element = SeleniumMethods.findElement(by,"Audit Message For Create");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> nuggetSubscribeList() {
        elementList=null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr/td[1]//label");
            WaitMethods.waitForElementToBeClickable(by, 5);
            elementList =SeleniumMethods.findElements(by, "Nugget Subscribe Element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement assignmentTabIcon() {
        element = null;
        try {
            By by = By.id("detail_sidebar_assignment");
            WaitMethods.waitForElementToLoad(by, 10);
            element = SeleniumMethods.findElement(by,"Assignment Tab Icon Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement editNuggetName() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Nugget name']");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Edit Nugget Name Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement editNuggetDescription() {
        element = null;
        try {
            By by = By.xpath("//textarea[@placeholder='Description *']");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Edit Nugget Description Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement nuggetAssignmentResourcesSectionHeading() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(),'Resources')]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Nugget Assignment Resources Section Heading Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement nuggetAssignmentJournalSectionHeading() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(),'Journal for')]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Nugget Assignment Journal Section Heading Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement editNuggetNameField() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Nugget name']");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Edit Nugget Name Field Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement editNuggetTypeDropdownField() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Type']");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Edit Nugget Type Dropdown Field Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement editNuggetProjectDropdownField() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Project']");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Edit Nugget Project Dropdown Field Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement editNuggetPriorityDropdownField() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Priority']");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Edit Nugget Priority Dropdown Field Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement editNuggetDescriptionField() {
        element = null;
        try {
            By by = By.xpath("//textarea[@placeholder='Description *']");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Edit Nugget Description Field Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement nuggetCheckboxOfNuggetDetailsSection() {
        element = null;
        try {
            By by = By.xpath("//label[contains(text(),'Subscribed')]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Nugget Checkbox Of Nugget Details Section");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement nuggetTagsDropdownField() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Tags']");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Nugget Tags Dropdown Field");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement editNuggetPhaseIcon() {
        element = null;
        try {
            By by = By.xpath("(//div[@id='EditModeColumnHeader'])[1]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Edit Nugget Phase Icon Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement editNuggetPhasesIcon() {
        element = null;
        try {
            By by = By.xpath("(//div[@id='EditModeColumnHeader'])[1]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Edit Nugget Phases Icon Element");
        } catch (Exception e) {
        }
        return element;
    }

    public static WebElement editNuggetResourceIcon() {
        element = null;
        try {
            By by = By.xpath("(//div[@id='EditModeColumnHeader'])[2]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Edit Nugget Resource Icon Element");
        } catch (Exception e) {
        }
        return element;
    }

    public static List<WebElement> nuggetPhaseAssignmentIconList() {
        elementList=null;
        try {
            By by = By.xpath("//div[@class='assignment-phase']/../../../td[1]//button");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList =SeleniumMethods.findElements(by, "Nugget Phase Assignment Icon Element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> nuggetPhaseAssignmentNameList() {
        elementList=null;
        try {
            By by = By.xpath("//div[@class='assignment-phase']/div");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList =SeleniumMethods.findElements(by, "Nugget Phase Assignment name Element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> nuggetPhaseNameList() {
        elementList=null;
        try {
            By by = By.xpath("//div[@class='assignment-phase']/div");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList =SeleniumMethods.findElements(by, "Nugget Phase Name Element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement addAndRemoveIconOfTriagePhase() {
        element = null;
        try {
            By by = By.xpath("//div[@class='epxire']/../../../../td[1]//button");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Add and Remove Icon Of Triage Phase Element");
        } catch (Exception e) {
            //throw e;
        }
        return element;
    }

    public static WebElement editNuggetResourcesIcon() {
        element = null;
        try {
            By by = By.xpath("(//div[@id='EditModeColumnHeader'])[2]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Edit Nugget Resources Icon Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> nuggetResourceAssignmentIconList() {
        elementList=null;
        try {
            By by = By.xpath("//div[@class='username text-truncate']/../../../../td[1]//button");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList =SeleniumMethods.findElements(by, "Nugget Resource Assignment Icon Element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> nuggetResourceNameList() {
        elementList=null;
        try {
            By by = By.xpath("//div[@class='username text-truncate']/../../../../td[1]//button/../../../../td[2]");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList =SeleniumMethods.findElements(by, "Nugget Resource Name Element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement inputChatMessageField() {
        element = null;
        try {
            By by = By.xpath("(//div[@data-ph='Type message'])[2]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Input Chat Message Field Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement sendButtonIcon() {
        element = null;
        try {
            By by = By.xpath("(//i[contains(text(),'send')])[2]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Send button Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement sentMessage(String message) {
        element = null;
        try {
            By by = By.xpath("(//p[contains(text(),'"+message+"')])[last()]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Sent message Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement threeDotsMenuIcon(String message) {
        element = null;
        try {
            By by = By.xpath("(//p[contains(text(),'"+message+"')])[2]/../../../..//i[contains(text(),'more_horiz')]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Three Dots Menu Icon");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement fileInput() {
        element = null;
        try {
            By by = By.xpath("(//input[@type='file'])[2]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "File Input Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }


    public static List<WebElement> sentImageFileList() {
        elementList=null;
        try {
            By by = By.xpath("//div[@class='detail-sidebar']/div//i[contains(text(),'more_horiz')]/../../../..//div[@aria-label='Image description']/../figcaption");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList =SeleniumMethods.findElements(by, "Sent Image File Element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> sentImageTimeList() {
        elementList=null;
        try {
            By by = By.xpath("    //div[@class='detail-sidebar']/div//i[contains(text(),'more_horiz')]/../../../..//div[@aria-label='Image description']/../..//span[@class='timestamp pr-1']");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList =SeleniumMethods.findElements(by, "Sent Image File Time Element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }


    public static List<WebElement> sentDocFileList() {
        elementList=null;
        try {
            By by = By.xpath("//div[@class='detail-sidebar']/div//i[contains(text(),'more_horiz')]/../../../../div[2]//div[@class='svg-button icon-file mr-1']/../span");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList =SeleniumMethods.findElements(by, "Sent Doc File Element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> sentDocFileTimeList() {
        elementList=null;
        try {
            By by = By.xpath("//div[@class='detail-sidebar']/div//i[contains(text(),'more_horiz')]/../../../../div[2]//div[@class='svg-button icon-file mr-1']/../..//span[@class='timestamp pr-1']");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList =SeleniumMethods.findElements(by, "Sent Doc File Time Element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> sentAudioFileList() {
        elementList=null;
        try {
            By by = By.xpath("//div[@class='detail-sidebar']/div//i[contains(text(),'more_horiz')]/../../../..//div[contains(@type,'audio')]/div[1]");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList =SeleniumMethods.findElements(by, "Sent Audio File Element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> sentAudioFileTimeList() {
        elementList=null;
        try {
            By by = By.xpath("//div[@class='detail-sidebar']/div//i[contains(text(),'more_horiz')]/../../../..//div[contains(@type,'audio')]/..//span[@class='timestamp pr-1']");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList =SeleniumMethods.findElements(by, "Sent Audio File Element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> sentVideoFileList() {
        elementList=null;
        try {
            By by = By.xpath("//div[@class='detail-sidebar']/div//i[contains(text(),'more_horiz')]/../../../..//figure[contains(@type,'video')]/figcaption");
            WaitMethods.waitForElementToLoad(By.xpath("(//div[@class='detail-sidebar']/div//i[contains(text(),'more_horiz')]/../../../..//figure[contains(@type,'video')])[last()]/..//span[@class='timestamp pr-1']"), 10);
            elementList =SeleniumMethods.findElements(by, "Sent Video File Element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> sentVideoFileTimeList() {
        elementList=null;
        try {
            By by = By.xpath("//div[@class='detail-sidebar']/div//i[contains(text(),'more_horiz')]/../../../..//figure[contains(@type,'video')]/..//span[@class='timestamp pr-1']");
            WaitMethods.waitForElementToLoad(By.xpath("(//div[@class='detail-sidebar']/div//i[contains(text(),'more_horiz')]/../../../..//figure[contains(@type,'video')])[last()]/..//span[@class='timestamp pr-1']"), 10);
            elementList =SeleniumMethods.findElements(by, "Sent Video File time Element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }


    public static List<WebElement> deletedMessageText() {
        elementList = null;
        try {
            By by = By.xpath("//span[contains(text(),'This message was deleted')]");
            WaitMethods.waitForElementToLoad(by,5);
            elementList = SeleniumMethods.findElements(by, "Deleted Message Text Element");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> mainMessageList() {
        elementList = null;
        try {
            By by = By.xpath("//div[@class='reply-message']//div[@class='message-text']/div/p");
            WaitMethods.waitForElementToLoad(by,5);
            elementList = SeleniumMethods.findElements(by, "Main Message List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> repliedMessageList() {
        elementList = null;
        try {
            By by = By.xpath("//div[@class='reply-message']/../div[3]//p");
            WaitMethods.waitForElementToLoad(by,5);
            elementList = SeleniumMethods.findElements(by, "Replied Message List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement selectedFileElement(String fileName) {
        element = null;
        try {
            By by = By.xpath("//div[@class='position-relative']//div[@title='"+fileName+"']");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Selected File Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement closeSelectedFileIcon() {
        element = null;
        try {
            By by = By.xpath("//div[@class='remove-file']/i[@class='material-icons']");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "CloseSelected File Icon Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement selectedFileElementRemoved(String fileName) {
        element = null;
        try {
            By by = By.xpath("//div[@class='simplebar-mask']//div[@title='"+fileName+"']");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Selected File Element");
        } catch (Exception e) {}
        return element;
    }

    public static WebElement mediaTab() {
        element = null;
        try {
            By by = By.id("attachment_media");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Media Tab Element");
        } catch (Exception e) {}
        return element;
    }

    public static List<WebElement> sentFileInMediaTab(String fileName) {
        elementList = null;
        try {
            By by = By.xpath("//div[@class='maz-base-component attachment-content']//figcaption[@title='"+fileName+"']");
            WaitMethods.waitForElementToLoad(by,5);
            elementList = SeleniumMethods.findElements(by, "Sent File In Media Tab Element");
        } catch (Exception e) {}
        return elementList;
    }

    public static List<WebElement> audioFileInMediaTab() {
        elementList = null;
        try {
            By by = By.xpath("//div[@class='maz-base-component attachment-content']//div[@class='core-audio-legend text-truncate']");
            WaitMethods.waitForElementToLoad(by,5);
            elementList = SeleniumMethods.findElements(by, "Audio File In Media Tab Element");
        } catch (Exception e) {}
        return elementList;
    }

    public static WebElement documentsTab() {
        element = null;
        try {
            By by = By.id("attachment_documents");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Documents Tab Element");
        } catch (Exception e) {}
        return element;
    }

    public static List<WebElement> docFileInDocumentsTab(String fileName) {
        elementList = null;
        try {
            By by = By.xpath("//div[@class='maz-base-component attachment-content']//span[contains(text(), '"+fileName+"')]");
            WaitMethods.waitForElementToLoad(by,5);
            elementList = SeleniumMethods.findElements(by, "Documents File In Documents Tab Element");
        } catch (Exception e) {}
        return elementList;
    }

    public static WebElement linkTab() {
        element = null;
        try {
            By by = By.id("attachment_links");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Links Tab Element");
        } catch (Exception e) {}
        return element;
    }

    public static WebElement urlInLinksTab(String link) {
        element = null;
        try {
            By by = By.xpath("(//div[@class='maz-base-component attachment-content']//a[@href='"+link+"'])[last()]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "URL In Links Tab Element");

        } catch (Exception e) {}
        return element;
    }

    public static List<WebElement> linkMessageList() {
        elementList = null;
        try {
            By by = By.xpath("//div[@class='detail-sidebar']/div//i[contains(text(),'more_horiz')]/../../../..//a");
            WaitMethods.waitForElementToLoad(by,5);
            elementList = SeleniumMethods.findElements(by, "Link Message List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement threeDotsMenuIconOnAuditMessage(String message) {
        element = null;
        try {
            By by = By.xpath("(//div[contains(text(),'"+message+"')])[2]/../../../..//i[contains(text(),'more_horiz')]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Three Dots Menu Icon On Audit Message");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> moreOptionMenuListOfAuditMessage(String message) {
        elementList=null;
        try {
            By by = By.xpath("(//div[contains(text(),'"+message+"')])[2]/../../../div//span//div[@class='menu-item']");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList =SeleniumMethods.findElements(by, "More Option Menu List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement auditMessage(String message) {
        element = null;
        try {
            By by = By.xpath("(//div[contains(text(),'"+message+"')])[last()]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Audit Message Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> nuggetIdList(String id) {
        elementList=null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr/td["+id+"]/div/div");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList =SeleniumMethods.findElements(by, "Nugget Id List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement searchNuggetTextBox() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Search for a Nugget']");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Search Nugget Text Box");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement nuggetId() {
        element = null;
        try {
            By by = By.xpath("(//div[@class='title rounded']/span[@class='pre-title'])[1]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Nugget Id Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement searchResultTab() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(),'Search Results')]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Search Result Tab");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement emojiIcon() {
        element = null;
        try {
            By by = By.xpath("(//i[contains(text(),'insert_emoticon')])[2]");
            WaitMethods.waitForElementToBeClickable(by,5);
            element = SeleniumMethods.findElement(by, "Emoji Icon Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

}
