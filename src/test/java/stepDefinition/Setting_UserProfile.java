package stepDefinition;

import CommonUtility.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.JSONArray;
import org.openqa.selenium.WebElement;
import pom.LoginElement;
import pom.NuggetElement;
import pom.Setting_UserProfileElement;
import pom.SideMenuElement;

import java.awt.*;
import java.util.List;

public class Setting_UserProfile {

    public static String departmentName = "";
    public static JSONArray userDataList = new JSONArray();

    @Then("^Validate that the \"([^\"]*)\" option is displayed on the sub menu$")
    public void validate_that_the_option_is_displayed_on_the_sub_menu(String option) {
        boolean isFlag = false;
        for (WebElement element : Setting_UserProfileElement.settingSubMenuOptionList()) {
            if (element.getText().equals(option)) {
                isFlag = true;
                break;
            }
        }
        AssertMethods.isTrue(isFlag, "Validate that the " + option + " option is displayed on the sub menu");

    }

    @Then("^Validate that the list of option on setting sub menu is three$")
    public void validate_that_the_list_of_option_on_setting_sub_menu_is_three() {
        WaitMethods.pause(1);
        AssertMethods.elementListSizeIsSame(Setting_UserProfileElement.settingSubMenuOptionList(), 3, "Validate that the list of option on setting sub menu is three");
    }

    @Then("^Validate that the list of option on setting sub menu is thirteen")
    public void validate_that_the_list_of_option_on_setting_sub_menu_is_thirteen() throws AWTException {
        WaitMethods.pause(1);
        AssertMethods.elementListSizeIsSame(Setting_UserProfileElement.settingSubMenuOptionList(), 13, "Validate that the list of option on setting sub menu is thirteen");
        CommonMethods.browserZoomIn();
    }

    @Then("^Validate that the user profile option is selected$")
    public void validate_that_the_user_profile_option_is_selected() {
        AssertMethods.elementTextHasText(Setting_UserProfileElement.settingSubMenuOptionList().get(0).getAttribute("class"), "maz-active", "Validate that the user profile option is selected");
    }

    @Then("^Validate that the user id field is disabled$")
    public void validate_that_the_user_id_field_is_disabled() {
        AssertMethods.elementAttributeValueIsEqualTo(Setting_UserProfileElement.userIdField(), "disabled", "true", "Validate that the user id field is disabled");
    }

    @Then("^Validate that the email field is disabled$")
    public void validate_that_the_email_field_is_disabled() {
        AssertMethods.elementAttributeValueIsEqualTo(Setting_UserProfileElement.emailField(), "disabled", "true", "Validate that the email field is disabled");
    }

    @Then("^Validate that the phone number field is disabled$")
    public void validate_that_the_phone_number_field_is_disabled() {
        AssertMethods.elementAttributeValueIsEqualTo(Setting_UserProfileElement.phoneNumberField(), "disabled", "true", "Validate that the phone number field is disabled");
    }

    @Then("^Validate that the social media field is disabled$")
    public void validate_that_the_social_media_field_is_disabled() {
        AssertMethods.elementAttributeValueIsEqualTo(Setting_UserProfileElement.socialMediaField(), "disabled", "true", "Validate that the social media field is disabled");
    }

    @Then("^Validate that the city field is disabled$")
    public void validate_that_the_city_field_is_disabled() {
        AssertMethods.elementAttributeValueIsEqualTo(Setting_UserProfileElement.cityField(), "disabled", "true", "Validate that the city field is disabled");
    }

    @When("^Click on the user option from setting sub menu$")
    public void Click_on_the_user_option_from_setting_sub_menu() {
        WebElement element = CommonMethods.settingOption(Setting_UserProfileElement.settingSubMenuOptionList(), "Users");
        SeleniumMethods.click(element, "Click on the user option from setting sub menu");
    }

    @When("^Find \"([^\"]*)\" user from the user list and Click on it$")
    public void Click_on_the_user_option_from_setting_sub_menu(String userType) {
        ConfigMethods config = new ConfigMethods();
        String userEmail = config.userEmail(userType);
        WaitMethods.pause(3);
        while (true) {
            List<WebElement> elements = Setting_UserProfileElement.dataListTable();
            SeleniumMethods.scrollToElement(elements.get(elements.size()-5));
            WaitMethods.pause(3);
            if (Setting_UserProfileElement.allDataLoaded() != null) {
                break;
            }
        }

        for (WebElement element : NuggetElement.nuggetIdList("3")) {
            if (element.getText().equals("AutoAdmin")) {
                SeleniumMethods.click(element, "Click on the login user's email");
                break;
            }
        }
    }

    @When("^Get selected department$")
    public void get_Selected_department() {
        SeleniumMethods.click(Setting_UserProfileElement.userDepartmentDropdown(), "Click on the department dropdown");
        int i=0;
        for (WebElement element : Setting_UserProfileElement.dropdownList()) {
            if (element.getAttribute("class").endsWith("selected")) {
                departmentName = Setting_UserProfileElement.dropdownOptionList().get(i).getText();
                break;
            }
            i++;
        }
        SeleniumMethods.click(Setting_UserProfileElement.userDepartmentDropdown(), "Click on the department dropdown");
    }


    @When("^Click on the user profile option from setting sub menu$")
    public void Click_on_the_user_profile_option_from_setting_sub_menu() throws AWTException {
        WaitMethods.pause(3);
        SeleniumMethods.click(SideMenuElement.groupIconOnSideMenu(), "Click on channel option from side menu");
        WaitMethods.pause(3);
        SeleniumMethods.click(SideMenuElement.settingIconOnSideMenu(), "Click on Setting option from side menu");

        WaitMethods.pause(4);
        WebElement element = CommonMethods.settingOption(Setting_UserProfileElement.settingSubMenuOptionList(), "User Profile");
        SeleniumMethods.clickWithJs(element, "Click on the user profile option from setting sub menu");
    }

    @Then("^Validate that the user department is same as selected on the user list$")
    public void validate_that_the_user_department_is_same_as_selected_on_the_user_list() {
        WaitMethods.pause(4);
        AssertMethods.elementTextIsEqualTo(Setting_UserProfileElement.usersSelectedDepartment(), departmentName, "Validate that the user department is same as selected on the user list");
    }

    @When("^Get selected user role type$")
    public void get_Selected_user_role_type() {
        SeleniumMethods.clickWithJs(Setting_UserProfileElement.userRoleDropdown(), "Click on the role dropdown");
        int i=0;
        for (WebElement element : Setting_UserProfileElement.dropdownList()) {
            if (element.getAttribute("class").endsWith("selected")) {
                departmentName = Setting_UserProfileElement.dropdownOptionList().get(i).getText();
                break;
            }
            i++;
        }
        SeleniumMethods.clickWithJs(Setting_UserProfileElement.userRoleDropdown(), "Click on the role dropdown");
    }

    @Then("^Validate that the user role is same as selected on the user list$")
    public void validate_that_the_user_role_is_same_as_selected_on_the_user_list() {
        WaitMethods.pause(4);
        AssertMethods.elementTextIsEqualTo(Setting_UserProfileElement.usersSelectedRole(), departmentName, "Validate that the user role is same as selected on the user list");
    }

    @When("^Get selected private channel$")
    public void get_selected_private_channel() {
        SeleniumMethods.clickWithJs(Setting_UserProfileElement.privateChannelDropdown(), "Click on the private channel dropdown");
        for (WebElement element : Setting_UserProfileElement.dropdownOptionList()) {
            if (element.getAttribute("class").endsWith("selected")) {
                userDataList.add(element.getText());
            }
        }
    }

    @Then("^Validate that the private channel is same as selected on the user list$")
    public void validate_that_the_private_channel_is_same_as_selected_on_the_user_list() {
        WaitMethods.pause(4);
        boolean isChannel=true;
        for (Object channel : userDataList) {
            boolean isTrue = false;
            for (WebElement element : Setting_UserProfileElement.usersPrivateChannels()) {
                if (element.getText().equals(channel.toString())) {
                    isTrue=true;
                    break;
                }
            }
            if(!isTrue){
                isChannel=false;
                break;
            }
        }
        AssertMethods.isTrue(isChannel, "Validate that the private channel is same as selected on the user list");
    }

    @When("^Get selected user skills$")
    public void get_selected_user_skills() throws AWTException {
        for(WebElement el:Setting_UserProfileElement.skillDropdownList()) {
            SeleniumMethods.clickWithJs(el, "Click on the skill dropdown");
            WaitMethods.pause(1);
            for (WebElement element : Setting_UserProfileElement.dropdownOptionList()) {
                if (element.getAttribute("class").endsWith("selected")) {
                    userDataList.add(element.getText());
                    break;
                }
            }
            SeleniumMethods.clickWithJs(el, "Click on the skill dropdown");
        }
    }

    @Then("^Validate that the user skills is same as selected on the user list$")
    public void validate_that_the_user_skills_is_same_as_selected_on_the_user_list() {
        WaitMethods.pause(4);
        boolean isSkill=true;
        for (Object skill : userDataList) {
            boolean isTrue = false;
            for (WebElement element : Setting_UserProfileElement.userSkills()) {
                if (element.getText().equals(skill.toString())) {
                    isTrue=true;
                    break;
                }
            }
            if(!isTrue){
                isSkill=false;
                break;
            }
        }
        AssertMethods.isTrue(isSkill, "Validate that the user skills is same as selected on the user list");
    }

    @Then("^Validate that the user profile button is disabled$")
    public void validate_that_the_user_profile_button_is_disabled() {
        AssertMethods.elementAttributeValueIsEqualTo(Setting_UserProfileElement.updateProfileButton(),"disabled","true", "Validate that the user profile button is disabled");
    }

    @Then("^Validate that the user profile button is enabled")
    public void validate_that_the_user_profile_button_is_enabled() {
        AssertMethods.elementIsEnabled(Setting_UserProfileElement.updateProfileButton(), "Validate that the user profile button is enabled");
    }

    @Then("^Enter the \"([^\"]*)\" on the first name text box$")
    public void enter_the_first_name_on_text_box(String name) {
        SeleniumMethods.clearTheField(Setting_UserProfileElement.firstNameTextBox(),"The first name text box text is clear");
        SeleniumMethods.sendKey(Setting_UserProfileElement.firstNameTextBox(),name,"Enter the "+name+" on the first name text box");
    }

    @Then("^Enter the \"([^\"]*)\" on the last name text box$")
    public void enter_the_last_name_on_text_box(String name) {
        SeleniumMethods.clearTheField(Setting_UserProfileElement.lastNameTextBox(),"The last name text box text is clear");
        SeleniumMethods.sendKey(Setting_UserProfileElement.lastNameTextBox(),name,"Enter the "+name+" on the last name text box");
    }

    @When("^Update the date from date dropdown$")
    public void update_the_date_from_date_dropdown() {
        SeleniumMethods.click(Setting_UserProfileElement.dateDropdown(), "Click on the date dropdown");
        for (WebElement element : Setting_UserProfileElement.dropdownList()) {
            if (!element.getAttribute("class").endsWith("selected")) {
                element.click();
                break;
            }
        }
    }

    @When("^Refresh the page$")
    public void refresh_the_page() {
        SeleniumMethods.refreshPage();
        CommonMethods.logInfo("Refresh the page");
        WaitMethods.pause(2);
    }

    @When("^Update the month from date dropdown$")
    public void update_the_month_from_date_dropdown() {
        SeleniumMethods.click(Setting_UserProfileElement.monthDropdown(), "Click on the month dropdown");
        WaitMethods.pause(1);
        for (WebElement element : Setting_UserProfileElement.dropdownList()) {
            if (!element.getAttribute("class").endsWith("selected")) {
                element.click();
                break;
            }
        }

    }

    @When("^Update the year from date dropdown$")
    public void update_the_year_from_date_dropdown() {
        SeleniumMethods.click(Setting_UserProfileElement.yearDropdown(), "Click on the year dropdown");
        WaitMethods.pause(2);
        for (WebElement element : Setting_UserProfileElement.dropdownList()) {
            if (!element.getAttribute("class").endsWith("selected")) {
                SeleniumMethods.clickWithJs(element,"Select any year");
                break;
            }
        }
    }

    @When("^Click on the update profile button$")
    public void Click_on_the_update_profile_button$() {
        WaitMethods.pause(1);
        SeleniumMethods.click(Setting_UserProfileElement.updateProfileButton(), "Click on the update profile button$");

    }

    @Then("^Enter the \"([^\"]*)\" password on old password field$")
    public void enter_the_password_on_old_password_field(String userRole) {
        ConfigMethods cofig=new ConfigMethods();
        SeleniumMethods.sendKey(Setting_UserProfileElement.oldPasswordField(),cofig.userPassword(userRole),"Enter the password on old password field");
    }

    @Then("^Enter the \"([^\"]*)\" password on the old password field$")
    public void enter_the_password_on_the_old_password_field(String pass) {
        SeleniumMethods.sendKey(Setting_UserProfileElement.oldPasswordField(),pass,"Enter the password on old password field");
    }

    @Then("^Enter the \"([^\"]*)\" password on new password field$")
    public void enter_the_password_on_new_password_field(String newPass) {
        SeleniumMethods.sendKey(Setting_UserProfileElement.newPasswordField(),newPass,"Enter the password on new password field");
    }

    @Then("^Enter the \"([^\"]*)\" password on repeat new password field$")
    public void enter_the_password_on_repeat_new_password_field(String newPass) {
        SeleniumMethods.sendKey(Setting_UserProfileElement.repeatPasswordField(),newPass,"Enter the password on repeat new password field");
    }

    @Then("^Validate that the \"([^\"]*)\" validation message appears on repeat new password field$")
    public void validate_that_the_validation_message_appears(String msg) {
        AssertMethods.elementTextIsEqualTo(Setting_UserProfileElement.inputValidation(),msg, "Validate that the "+msg+" validation message appears on repeat new password field");
    }

    @When("^Enter the user email \"([^\"]*)\"$")
    public void enter_user_email(String userRole) {
        ConfigMethods cofig=new ConfigMethods();
        SeleniumMethods.sendKey(LoginElement.loginEmailTextBox(), cofig.userEmail(userRole), "Enter the User Email");
    }

    @Then("^Enter the \"([^\"]*)\" password on the new password field$")
    public void enter_the_password_on_the_new_password_field(String userRole) {
        ConfigMethods cofig=new ConfigMethods();
        SeleniumMethods.sendKey(Setting_UserProfileElement.newPasswordField(),cofig.userPassword(userRole),"Enter the password on new password field");
    }

    @Then("^Enter the \"([^\"]*)\" password on the repeat new password field$")
    public void enter_the_password_on_the_repeat_new_password_field(String userRole) {
        ConfigMethods cofig=new ConfigMethods();
        SeleniumMethods.sendKey(Setting_UserProfileElement.repeatPasswordField(),cofig.userPassword(userRole),"Enter the password on repeat new password field");
    }
}
