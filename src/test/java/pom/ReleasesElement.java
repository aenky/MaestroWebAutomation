package pom;

import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReleasesElement {

    private static WebElement element = null;
    private static List<WebElement> elementList = null;

    public static WebElement releasedSubTab() {
        element = null;
        try {
            By by = By.xpath("//span[contains(text(),'Released')]");
            WaitMethods.waitForElementToBeClickable(by, 15);
            element = SeleniumMethods.findElement(by,"Released Sub Tab Element");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static WebElement activeReleasesSubTabText() {
        element = null;
        try {
            By by = By.xpath("//button[@id='releases_active']//span[1]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Active Releases Sub Tab Text Element");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static List<WebElement> listOfTableHeader() {
        elementList=null;
        try {
            By by = By.xpath("//div[@class='content max-height-moduletab-content']//thead//tr//b");
            WaitMethods.waitForElementToLoad(by, 5);
            elementList =SeleniumMethods.findElements(by, "Table Header");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementList;
    }

    public static List<WebElement> listOfTableHeaders() {
        elementList=null;
        try {
            By by = By.xpath("//thead//tr[@class='table-titles table-title']//b");
            WaitMethods.waitForElementToLoad(by, 5);
            elementList =SeleniumMethods.findElements(by, "Table Header");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementList;
    }

    public static List<WebElement> tableRowList() {
        elementList=null;
        try {
            By by = By.xpath("//tbody/tr");
            WaitMethods.waitForElementToLoad(by, 5);
            elementList =SeleniumMethods.findElements(by, "Table Row List Element");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementList;
    }

    public static WebElement emptyListMessage() {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(),'No available data')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Empty List Message Element");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static List<WebElement> tempoList() {
        elementList=null;
        try {
            By by = By.xpath("//tbody/tr/td[3]/div/div");
            WaitMethods.waitForElementToLoad(by, 5);
            elementList =SeleniumMethods.findElements(by, "Tempo List Element");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementList;
    }

    public static WebElement createReleaseButton() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'Create Release')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Create Release Button Element");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static WebElement createTheReleaseButton() {
        element = null;
        By by = By.xpath("//button[contains(text(),'Create Release')]");
        WaitMethods.waitForElementToLoad(by, 5);
        element = SeleniumMethods.findElementForElementNotVisible(by, "Create Release Button Element");

        return element;
    }

    public static WebElement editReleaseDescription() {
        element = null;
        try {
            By by = By.xpath("//textarea[@placeholder='Description']");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Edit Release Description Element");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static WebElement editReleaseName() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Name']");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Edit Release Name Element");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static WebElement releaseDialogBoxHeading() {
        element = null;
        try {
            By by = By.xpath("//p[@class='maz-dialog__header__title']");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Release Dialog Box Heading Element");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static WebElement nameField() {
        element = null;
        try {
            By by = By.xpath("(//input[@aria-label='Name'])[2]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Name Field Element");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement releaseDateField() {
        element = null;
        try {
            By by = By.xpath("(//input[@aria-label='Release Date'])[2]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Release Date Field Element");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static WebElement releaseCutoffDateField() {
        element = null;
        try {
            By by = By.xpath("(//input[@aria-label='Release Cutoff'])[2]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Release Cutoff Date Field Element");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static WebElement releaseMaestroDropdown() {
        element = null;
        try {
            By by = By.xpath("(//input[@aria-label='Release Maestro'])[2]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Release Maestro Dropdown Element");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static WebElement secondaryMaestroDropdown() {
        element = null;
        try {
            By by = By.xpath("(//input[@aria-label='Secondary Maestro'])[2]");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Secondary Maestro Dropdown Element");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static WebElement descriptionField() {
        element = null;
        try {
            By by = By.xpath("//p[@class='maz-dialog__header__title']/../..//textarea[@placeholder='Description']");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Description Field Element");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static WebElement headingOfReleaseDialogBox() {
        element = null;
        try {
            By by = By.xpath("//p[@class='maz-dialog__header__title']");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElementForElementNotVisible(by, "Release Dialog Box Heading Element");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static WebElement createdReleaseName(String name) {
        element = null;
        try {
            By by = By.xpath("//tbody/tr/td[2]//div[contains(text(), '"+name+"')]");
            WaitMethods.waitForElementToBeClickable(by,10);
            element = SeleniumMethods.findElement(by, "Created Release Name");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static WebElement createdReleaseRow(String releaseName) {
        element = null;
        try {
            By by = By.xpath("//div[contains(text(), '"+releaseName+"')]/../../..");
            WaitMethods.waitForElementToLoad(by,10);
            element = SeleniumMethods.findElement(by, "Created releaseName Row");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static WebElement editNameField() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Name']");
            WaitMethods.waitForElementToBeClickable(by,10);
            element = SeleniumMethods.findElement(by, "Edit Name Field Element");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static List<WebElement> releaseNameList() {
        elementList = null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr/td[2]/div/div");
            WaitMethods.waitForElementToLoad(by,5);
            elementList = SeleniumMethods.findElements(by, "Release Name List Element");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementList;
    }

    public static WebElement editReleaseDateField() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Release Date']");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Edit Release Date Field Element");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static WebElement editReleaseCutoffDateField() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Release Cutoff']");
            WaitMethods.waitForElementToLoad(by,5);
            element = SeleniumMethods.findElement(by, "Edit Release Cutoff Date Field Element");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static WebElement editReleaseMaestroDropdown() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Release Maestro']");
            WaitMethods.waitForElementToBeClickable(by,5);
            element = SeleniumMethods.findElement(by, "Edit Release Maestro Dropdown Element");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static List<WebElement> releaseSecondaryMaestroList() {
        elementList = null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr/td[8]/div/div");
            WaitMethods.waitForElementToLoad(by,5);
            elementList = SeleniumMethods.findElements(by, "Release Secondary Maestro List Element");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementList;
    }

    public static List<WebElement> releaseMaestroList() {
        elementList = null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr/td[7]/div/div");
            WaitMethods.waitForElementToLoad(by,5);
            elementList = SeleniumMethods.findElements(by, "Release Maestro List Element");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementList;
    }

    public static WebElement leftSideArrow() {
        element = null;
        try {
            By by = By.xpath("//div[@class='maz-base-component maz-picker maz-picker--primary']/div[2]/div/div/div[1]/button[1]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by,"Left Side Arrow");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static List<WebElement> listOfDate() {
        elementList = null;
        try {
            By by = By.xpath("//div[@class='month-picker__days']/button");
            WaitMethods.waitForElementToLoad(by,5);
            elementList = SeleniumMethods.findElements(by, "List Of Date");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementList;
    }

    public static WebElement completeCheckBox() {
        element = null;
        try {
            By by = By.xpath("//label[contains(text(),'Complete')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by,"Complete Check Box");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static WebElement preflightButton() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'Preflight')]");
            WaitMethods.waitForElementToBeClickable(by, 5);
            element = SeleniumMethods.findElement(by,"Preflight Button Element");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }



}
