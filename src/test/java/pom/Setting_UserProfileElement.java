package pom;

import CommonUtility.AssertMethods;
import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Setting_UserProfileElement {

    private static WebElement element = null;
    private static List<WebElement> elementList = null;

    public static List<WebElement> settingSubMenuOptionList() {
        elementList = null;
        try {
            By by = By.xpath("//div[@id='SettingsSidebar']//button");
            WaitMethods.waitForElementToLoad(by, 10);
            elementList = SeleniumMethods.findElements(by,"Setting Sub Menu Option List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement userIdField() {
        element = null;
        try {
            By by = By.xpath("//input[@placeholder='User Id']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "User Id Field");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement emailField() {
        element = null;
        try {
            By by = By.xpath("//input[@placeholder='Email']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Email Field");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement phoneNumberField() {
        element = null;
        try {
            By by = By.xpath("//input[@placeholder='phone']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Phone Number Field");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement socialMediaField() {
        element = null;
        try {
            By by = By.xpath("//input[@placeholder='Social Media']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Social Media Field");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement cityField() {
        element = null;
        try {
            By by = By.xpath("//input[@placeholder='City']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Email Field");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement allDataLoaded() {
        element = null;
        By by = By.xpath("(//table[@class='tracking-table'])[1]/div/div[contains(text(),'All Data Loaded')]");
        //WaitMethods.waitForElementToLoad(by, 5);
        element = SeleniumMethods.findElementForElementNotVisible(by, "All Data Loaded Element");

        return element;
    }

    public static List<WebElement> dataListTable() {
        elementList = null;
        try {
            By by = By.xpath("(//table[@class='tracking-table'])[1]/div/tbody/tr/td[2]");
            WaitMethods.waitForElementToLoad(by, 5);
            elementList = SeleniumMethods.findElements(by, "Data List Table");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> userEmailList() {
        elementList = null;
        try {
            By by = By.xpath("//table[@class='tracking-table']/div/tbody/tr/td[2]/div/div");
            WaitMethods.waitForElementToBeClickable(by, 10);
            elementList = SeleniumMethods.findElements(by,"User Email List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement userDepartmentDropdown() {
        element = null;
        try {
            By by = By.xpath("//input[@placeholder='Department']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "User Department Dropdown");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> dropdownOptionList() {
        elementList = null;
        try {
            By by = By.xpath("//button[contains(@class,'maz-select__options')]/span");
            WaitMethods.waitForElementToLoad(by, 5);
            elementList = SeleniumMethods.findElements(by, "Dropdown Option List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> dropdownList() {
        elementList = null;
        try {
            By by = By.xpath("//button[contains(@class,'maz-select__options')]");
            WaitMethods.waitForElementToLoad(by, 5);
            elementList = SeleniumMethods.findElements(by, "Dropdown List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement usersSelectedDepartment() {
        element = null;
        try {
            By by = By.xpath("//input[@placeholder='Departments']/../../li//span");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Users Selected Department");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement userRoleDropdown() {
        element = null;
        try {
            By by = By.xpath("(//input[@readonly='readonly'])[11]/../div/div");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "User Role Dropdown");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement usersSelectedRole() {
        element = null;
        try {
            By by = By.xpath("//input[@placeholder='Roles']/../../li//span");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Users Selected Role");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement privateChannelDropdown() {
        element = null;
        try {
            By by = By.xpath("(//input[@readonly='readonly'])[12]/../div");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Private Channel Dropdown");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static List<WebElement> usersPrivateChannels() {
        elementList = null;
        try {
            By by = By.xpath("//input[@placeholder='Channels']/../../li//span");
            WaitMethods.waitForElementToLoad(by, 5);
            elementList = SeleniumMethods.findElements(by, "Users Selected Role");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> skillDropdownList() {
        elementList = null;
        try {
            By by = By.xpath("(//tbody[@class='animation'])[2]/tr/td[3]//div[@class='maz-select__toggle']");
            WaitMethods.waitForElementToLoad(by, 5);
            elementList = SeleniumMethods.findElements(by, "Skill Dropdown List");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static List<WebElement> userSkills() {
        elementList = null;
        try {
            By by = By.xpath("(//tbody[@class='animation'])/tr/td[1]/div/div/div");
            WaitMethods.waitForElementToLoad(by, 5);
            elementList = SeleniumMethods.findElements(by, "User Skills");
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static WebElement updateProfileButton() {
        element = null;
        try {
            By by = By.xpath("//button[contains(text(),'Update Profile')]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Update Profile Button");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement firstNameTextBox() {
        element = null;
        try {
            By by = By.xpath("//input[@placeholder='First Name']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "First Name Text Box");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement lastNameTextBox() {
        element = null;
        try {
            By by = By.xpath("//input[@placeholder='Last Name']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Last Name Text Box");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement dateDropdown() {
        element = null;
        try {
            By by = By.xpath("//input[@placeholder='Date']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Date Dropdown");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement monthDropdown() {
        element = null;
        try {
            By by = By.xpath("//input[@placeholder='Month']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Month Dropdown");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement yearDropdown() {
        element = null;
        try {
            By by = By.xpath("//input[@placeholder='Year']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Year Dropdown");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement oldPasswordField() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Old Password']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Old Password Field");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement newPasswordField() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='New Password']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "New Password Field");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement repeatPasswordField() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Repeat New Password']");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Repeat New Password Field");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }

    public static WebElement inputValidation() {
        element = null;
        try {
            By by = By.xpath("//input[@aria-label='Repeat New Password']/../../div[2]");
            WaitMethods.waitForElementToLoad(by, 5);
            element = SeleniumMethods.findElement(by, "Input Validation");
        } catch (Exception e) {
            throw e;
        }
        return element;
    }



}
