package pom;

import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PeopleElement {

    private static WebElement element = null;
    private static List<WebElement> elementList = null;

    public static List<WebElement> searchUserList() {
        elementList = null;
        try {
            By by = By.xpath("//div[@class='simplebar-content']//div/span[@class='username maz-dots-text maz-text-color']");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList = SeleniumMethods.findElements(by,"Search User List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement noResultFound() {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(),'No results found')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by,"No Results Found Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> searchChatUserList() {
        elementList = null;
        try {
            By by = By.xpath("//div[@class='simplebar-content']/div[2]//div[@class='vac-room-name vac-text-ellipsis']");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList = SeleniumMethods.findElements(by,"Search Chat User List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> chatUserList() {
        elementList = null;
        try {
            By by = By.xpath("//div[@class='vac-room-list pt-2 pl-2 pr-2 mb-2']/div/div[2]/div[1]/div[1]");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList = SeleniumMethods.findElements(by,"Search Chat User List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }


    public static List<WebElement> listOfChatMessages() {
        elementList = null;
        try {
            By by = By.xpath("//div[@class='messages-container d-flex flex-column position-relative']/div[@class='d-flex flex-column room-messages']/div");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList = SeleniumMethods.findElements(by,"List Of Chat Messages");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement chatInputBox() {
        element = null;
        try {
            By by = By.xpath("//div[@data-ph='Type message']/..");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Chat Input Box Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement inputChatMessageField() {
        element = null;
        try {
            By by = By.xpath("//div[@data-ph='Type message']");
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
            By by = By.xpath("//i[contains(text(),'send')]");
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
            By by = By.xpath("//p[contains(text(),'"+message+"')]");
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
            By by = By.xpath("//p[contains(text(),'"+message+"')]/../../../..//i[contains(text(),'more_horiz')]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Three Dots Menu Icon");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> moreOptionMenuList() {
        elementList=null;
        try {
            By by = By.xpath("//div[@class='menu-item']");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList =SeleniumMethods.findElements(by, "More Option Menu List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement fileInput() {
        element = null;
        try {
            By by = By.xpath("//input[@type='file']");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "File Input Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> sentVideoFileList() {
        elementList=null;
        try {
            By by = By.xpath("//figure[contains(@type,'video')]/figcaption");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList =SeleniumMethods.findElements(by, "Sent Video File Element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> sentVideoFileTimeList() {
        elementList=null;
        try {
            By by = By.xpath("//figure[contains(@type,'video')]/..//span[@class='timestamp pr-1']");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList =SeleniumMethods.findElements(by, "Sent Video File time Element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> sentAudioFileList() {
        elementList=null;
        try {
            By by = By.xpath("(//div[@id='router']//div[@id='messages-container'])[1]//div[contains(@type,'audio')]/div[1]");
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
            By by = By.xpath("(//div[@id='router']//div[@id='messages-container'])[1]//div[contains(@type,'audio')]/..//span[@class='timestamp pr-1']");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList =SeleniumMethods.findElements(by, "Sent Audio File Element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> sentDocFileList() {
        elementList=null;
        try {
            By by = By.xpath("(//div[@id='router']//div[@id='messages-container'])[1]//div[@class='svg-button icon-file mr-1']/../span");
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
            By by = By.xpath("(//div[@id='router']//div[@id='messages-container'])[1]//div[@class='svg-button icon-file mr-1']/../..//span[@class='timestamp pr-1']");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList =SeleniumMethods.findElements(by, "Sent Doc File Time Element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> sentImageFileList() {
        elementList=null;
        try {
            By by = By.xpath("(//div[@id='router']//div[@id='messages-container'])[1]//div[@aria-label='Image description']/../figcaption");
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
            By by = By.xpath("(//div[@id='router']//div[@id='messages-container'])[1]//div[@aria-label='Image description']/../..//span[@class='timestamp pr-1']");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList =SeleniumMethods.findElements(by, "Sent Image File Time Element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> moreMenuList() {
        elementList=null;
        try {
            By by = By.xpath("//i[contains(text(), 'more_horiz')]");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList =SeleniumMethods.findElements(by, "More Menu List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> deleteMessageOptionList() {
        elementList=null;
        try {
            By by = By.xpath("//div[contains(text(), 'Delete Message')]");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList =SeleniumMethods.findElements(by, "Delete Message Option List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> linkMessageList() {
        elementList = null;
        try {
            By by = By.xpath("(//div[@id='router']//div[@id='messages-container'])[1]/div//i[contains(text(),'more_horiz')]/../../../..//a");
            WaitMethods.waitForElementToLoad(by,5);
            elementList = SeleniumMethods.findElements(by, "Link Message List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement emojiIcon() {
        element = null;
        try {
            By by = By.xpath("//i[contains(text(),'insert_emoticon')]");
            WaitMethods.waitForElementToBeClickable(by,5);
            element = SeleniumMethods.findElement(by, "Emoji Icon Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement emojiSection() {
        element = null;
        try {
            By by = By.xpath("//div[@class='emoji-picker d-flex flex-column']");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Emoji Section Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement emojiSearchBox() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Search']");
            WaitMethods.waitForElementToBeClickable(by,5);
            element = SeleniumMethods.findElement(by, "Emoji Search Box Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> listOfEmojis() {
        elementList = null;
        try {
            By by = By.xpath("//div[@class='emojis']/span");
            WaitMethods.waitForElementToLoad(by,5);
            elementList = SeleniumMethods.findElements(by, "List Of Emojis");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

}

