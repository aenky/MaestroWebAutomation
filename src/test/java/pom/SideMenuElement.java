package pom;

import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import stepDefinition.ServiceHook;

import java.util.List;

public class SideMenuElement {
    private static WebElement element = null;
    private static List<WebElement> elementList = null;

    public static WebElement leftSideNavigationMenu() {
        element = null;
        try {
            By by = By.xpath("(//div[contains(@class,'maz-base-component maz-sidebar')])[1]");
            WaitMethods.waitForElementToLoad(by, 15);
            element = SeleniumMethods.findElement(by,"Navigation Menu");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }


    public static WebElement peopleTabTextOnSideMenu() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(),'People')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"People tab on side Navigation Menu");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement searchNuggetTextBox() {
        element = null;
        try {
            By by = By.xpath("//input[@placeholder='Search Nugget']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Search nugget text box");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement peopleIconOnSideMenu() {
        element = null;
        try {
            By by = By.xpath("//i[contains(text(),'people_alt')]/../..");
            WaitMethods.waitForElementToBeClickable(by, 20);
            element = SeleniumMethods.findElement(by, "People icon on sideMenu");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement searchUserTextBox() {
        element = null;
        try {
            By by = By.xpath("(//div[@targeticon='search']/../input)[2]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Search text box");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement groupIconOnSideMenu() {
        element = null;
        try {
            By by = By.xpath("//i[contains(text(),'groups')]/../..");
            WaitMethods.waitForElementToBeClickable(by, 20);
            element = SeleniumMethods.findElement(by, "Group icon on sideMenu");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement searchGroupTextBox() {
        element = null;
        try {
            By by = By.xpath("//input[@placeholder='Search for public channel']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Search group text box");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement nuggetsIconOnSideMenu() {
        element = null;
        try {
            By by = By.xpath("//i[contains(text(),'widgets')]/../..");
            WaitMethods.waitForElementToBeClickable(by, 20);
            element = SeleniumMethods.findElement(by, "Nuggets icon on side menu");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement unreadNuggetTab() {
        element = null;
        try {
            By by = By.id("nugget_page_unread");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Unread Nugget Tab");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement assignmentIconOnSideMenu() {
        element = null;
        try {
            By by = By.xpath("//i[contains(text(),'assignment')]/../..");
            WaitMethods.waitForElementToBeClickable(by, 20);
            element = SeleniumMethods.findElement(by,"Assignment icon on side menu");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement inProgressNuggetTab() {
        element = null;
        try {
            By by = By.id("assignment_page_inprogress");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "In progress nugget tab");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement teamLeadIconOnSideMenu() {
        element = null;
        try {
            By by = By.xpath("//i[contains(text(),'thumbs_up_down')]/../..");
            WaitMethods.waitForElementToBeClickable(by, 20);
            element = SeleniumMethods.findElement(by, "Team lead icon on side menu");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement approvalDueNuggetTab() {
        element = null;
        try {
            By by = By.id("lead-approval-due");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Approval Due nugget tab");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement goodNewsIconOnSideMenu() {
        element = null;
        try {
            By by = By.xpath("//i[contains(text(),'thumb_up')]/../..");
            WaitMethods.waitForElementToBeClickable(by, 20);
            element = SeleniumMethods.findElement(by, "Good News icon on side menu");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement triageNuggetTab() {
        element = null;
        try {
            By by = By.id("good_news_triage");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Triage Nugget Tab");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement badNewsIconOnSideMenu() {
        element = null;
        try {
            By by = By.xpath("//i[contains(text(),'thumb_down')]/../..");
            WaitMethods.waitForElementToBeClickable(by, 20);
            element = SeleniumMethods.findElement(by, "Bad News icon on side menu");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement overdueTriageNuggetTab() {
        element = null;
        try {
            By by = By.id("bad_news_overdue_triage");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Overdue Triage Nugget Tab");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement projectsIconOnSideMenu() {
        element = null;
        try {
            By by = By.xpath("//button[contains(@id,'CoreBtn')]/div/i[contains(text(),'storage')]/../..");
            WaitMethods.waitForElementToLoad(by, 20);
            WaitMethods.pause(3);
            element = SeleniumMethods.findElement(by, "Projects icon on side menu");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement activeSprintsNuggetTab() {
        element = null;
        try {
            By by = By.id("projects_page_active");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by,"Active Sprints Nugget Tab");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement releasesIconOnSideMenu() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(),'Releases')]/..");
            WaitMethods.waitForElementToBeClickable(by, 20);
            element = SeleniumMethods.findElement(by,"Releases icon on side menu");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement activeReleasesTab() {
        element = null;
        try {
            By by = By.id("releases_active");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Active Releases Tab");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement settingIconOnSideMenu() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(),'Settings')]");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by, "Setting icon on side menu");
            } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement userSettingMenu() {
        element = null;
        try {
            By by = By.id("SettingsNavigationSidebar");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Setting on Menu Tab");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement inboxNavigationMenuOption() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(),'Inbox')]");
            WaitMethods.waitForElementToLoad(by, 20);
            element = SeleniumMethods.findElement(by, "Inbox navigation menu option");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement peopleNavigationMenuOption() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(),'People')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "People navigation menu option");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement groupNavigationMenuOption() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(),'Channels')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Group Navigation Menu Option");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement nuggetsNavigationMenuOption() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(),'Nuggets')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Nuggets Navigation Menu Option");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement logoutNavigationMenuOption() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(),'Logout')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Logout Navigation Menu Option");

        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement assignmentNavigationMenuOption() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(),'Assignment')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Assignment Navigation Menu Option");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement projectsNavigationMenuOption() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(),'Dashboard')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Projects Navigation Menu Option");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement releasesNavigationMenuOption() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(),'Releases')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Releases Navigation Menu Option");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement reportNavigationMenuOption() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(),'Report')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Report Navigation Menu Option");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement settingsNavigationMenuOption() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(),'Settings')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Settings Navigation Menu Option");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement teamLeadNavigationMenuOption() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(),'Team Lead')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Team Lead Navigation Menu Option");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement goodNewsNavigationMenuOption() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(),'Good News')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Good News Navigation Menu Option");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement badNewsNavigationMenuOption() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(),'Bad News')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Bad News Navigation Menu Option");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement loginPageHeading() {
        element = null;
        try {
            By by = By.xpath("//h3[contains(text(), 'Login')]");
            WaitMethods.waitForElementToLoad(by, 150);
            element = SeleniumMethods.findElement(by, "Login Page Heading");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement inboxIconOnSideMenu() {
        element = null;
        try {
            By by = By.xpath("//i[contains(text(),'inbox')]/../..");
            WaitMethods.waitForElementToBeClickable(by, 20);
            element = SeleniumMethods.findElement(by, "Inbox icon on side menu");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement nuggetsTab() {
        element = null;
        try {
            By by = By.id("inbox_nugget");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Nuggets Tab");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement reportIconOnSideMenu() {
        element = null;
        try {
            By by = By.xpath("//i[contains(text(),'summarize')]/../..");
            WaitMethods.waitForElementToBeClickable(by, 10);
            element = SeleniumMethods.findElement(by, "Report icon on side menu");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement inProgressReportTab() {
        element = null;
        try {
            By by = By.id("report_page_inprogress");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "In Progress Report Tab");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement loadingIcon() {
        element = null;
        try {
            By by = By.xpath("(//div[@class='maz-loader__anim'])[1]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Loading Icon");
        } catch (Exception e) {
            //throw e;
        }
        return element;
    }
}
