package pom;

import CommonUtility.CommonMethods;
import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SCB_TC_Channel_PeopleElement {

    private static WebElement element = null;
    private static List<WebElement> elementList = null;

    public static WebElement channelIconBadgeCount() {
        element = null;
        try {
            By by = By.xpath("//i[contains(text(),'groups')]/../../div[2]//span[@class='odometer-ribbon-inner']/span");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Channel Icon Badge Count Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> channelBadgeCountDivList() {
        elementList = null;
        try {
            By by = By.xpath("//i[contains(text(),'groups')]/../../div");
            WaitMethods.waitForElementToLoad(by, 5);
            elementList = SeleniumMethods.findElements(by,"Badge Count Div List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement peopleIconBadgeCount() {
        element = null;
        try {
            By by = By.xpath("//i[contains(text(),'people')]/../../div[2]//span[@class='odometer-ribbon-inner']/span");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"People Icon Badge Count Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement peopleIconBadgeCountNotExist() {
        element = null;
        try {
            By by = By.xpath("//i[contains(text(),'people')]/../../div[2]//span[@class='odometer-ribbon-inner']/span");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"People Icon Badge Count Element");
        } catch (Exception e) {
            return null;
        }
        return element;
    }

    public static List<WebElement> peopleBadgeCountDivList() {
        elementList = null;
        try {
            By by = By.xpath("//i[contains(text(),'people')]/../../div");
            WaitMethods.waitForElementToLoad(by, 5);
            elementList = SeleniumMethods.findElements(by,"People Badge Count Div List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement channelBadgeCount(String name) {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(),'"+name+"')]/../../div[2]//span[@class='odometer-ribbon-inner']/span");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"channel Badge Count Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> channelBadgeCountDivList(String name) {
        elementList = null;
        try {
            By by = By.xpath("//div[contains(text(),'"+name+"')]/../../div[2]/div");
            WaitMethods.waitForElementToLoad(by, 5);
            elementList = SeleniumMethods.findElements(by,"channel Badge Count Div List Element");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement channelBadgeCountNotExist(String name) {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(),'"+name+"')]/../../div[2]//span[@class='odometer-ribbon-inner']/span");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Badge Count Element");
        } catch (Exception e) {
            return null;
        }
        return element;
    }

    public static List<WebElement> badgeCountList() {
        elementList=null;
        try {
            By by = By.xpath("//div[@class='vac-title-container']/../../div[2]//span[@class='odometer-ribbon-inner']/span");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList =SeleniumMethods.findElements(by, "Badge Count Element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }


    public static WebElement inputChatMessageField(WebDriver newDriver) {
        element = null;
        try {
            By by = By.xpath("//div[@data-ph='Type message']");
            WaitMethods.waitForElementToLoad(by,newDriver,5);
            element = findElement(by, newDriver, "Input Chat Message Field Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> chatUserList(WebDriver newDriver) {
        elementList = null;
        try {
            By by = By.xpath("//div[@class='vac-room-list pt-2 pl-2 pr-2 mb-2']/div/div[2]/div[1]/div[1]");
            WaitMethods.waitForElementToBeClickable(by, newDriver, 10);
            elementList = findElements(by,newDriver ,"Search Chat User element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement loginEmailTextBox(WebDriver newDriver) {
        element = null;
        try {
            By by = By.id("email");
            element =findElement(by, newDriver,"Email element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement loginPasswordTextBox(WebDriver newDriver) {
        element = null;
        try {
            By by = By.id("password");
            element =findElement(by, newDriver, "Password element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement loginButton(WebDriver newDriver) {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'Login')]");
            element =findElement(by, newDriver, "Login button element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement leftSideNavigationMenu(WebDriver newDriver) {
        element = null;
        try {
            By by = By.xpath("(//div[contains(@class,'maz-base-component maz-sidebar')])[1]");
            WaitMethods.waitForElementToLoad(by, newDriver, 15);
            element = findElement(by, newDriver,"Navigation Menu element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement groupIconOnSideMenu(WebDriver newDriver) {
        element = null;
        try {
            By by = By.xpath("//i[contains(text(),'groups')]/../..");
            WaitMethods.waitForElementToBeClickable(by, newDriver, 20);
            element = findElement(by, newDriver, "Group icon element on sideMenu");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement sendButtonIcon(WebDriver newDriver) {
        element = null;
        try {
            By by = By.xpath("//i[contains(text(),'send')]");
            WaitMethods.waitForElementToLoad(by,newDriver,5);
            element = findElement(by,newDriver, "Send button Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement sentMessage(WebDriver newDriver, String message) {
        element = null;
        try {
            By by = By.xpath("//p[contains(text(),'"+message+"')]");
            WaitMethods.waitForElementToLoad(by, newDriver,5);
            element = findElement(by, newDriver, "Sent message Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement threeDotsMenuIcon(WebDriver newDriver, String message) {
        element = null;
        try {
            By by = By.xpath("//p[contains(text(),'"+message+"')]/../../../..//i[contains(text(),'more_horiz')]");
            WaitMethods.waitForElementToLoad(by, newDriver,5);
            element = findElement(by, newDriver,"Three Dots Menu Icon Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement readMSgIcon(WebDriver newDriver, String message) {
        element = null;
        try {
            By by = By.xpath("//p[contains(text(),'"+message+"')]/../../../../div[3]//i[contains(text(), 'done_all')]");
            WaitMethods.waitForElementToLoad(by, newDriver,5);
            element = findElement(by, newDriver,"Read Message Icon Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }
    public static WebElement seenPopper(WebDriver newDriver) {
        element = null;
        try {
            By by = By.xpath("//div[@class='viewers']");
            WaitMethods.waitForElementToLoad(by, newDriver,5);
            element = findElement(by, newDriver,"Seen Popper Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> moreOptionMenuList(WebDriver newDriver) {
        elementList=null;
        try {
            By by = By.xpath("//div[@class='menu-item']");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList =findElements(by, newDriver, "More Option Menu Element List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement peopleIconOnSideMenu(WebDriver newDriver) {
        element = null;
        try {
            By by = By.xpath("//i[contains(text(),'people_alt')]/../..");
            WaitMethods.waitForElementToBeClickable(by, 20);
            element = findElement(by, newDriver, "People icon element of sideMenu");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }







    public static WebElement findElement(By by, WebDriver newDriver,  String log) {
        WebElement el = null;
        try {
            el = newDriver.findElement(by);
            CommonMethods.logInfo(log);
        } catch (Exception e) {
            throw e;
        }
        return el;
    }

    public static List<WebElement> findElements(By by,WebDriver newDriver, String log) {
        List<WebElement> elList = null;
        try {
            elList =newDriver.findElements(by);
            CommonMethods.logInfo(log);
        } catch (Exception e) {
            throw e;
        }
        return elList;
    }

    public static void moveCursorOnElement(WebElement element, WebDriver newDriver, String log) {
        Actions action = new Actions(newDriver);
        action.moveToElement(element).build().perform();
        CommonMethods.logInfo(log);
        WaitMethods.pause(2);
    }

}
