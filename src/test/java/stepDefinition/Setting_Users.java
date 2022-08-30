package stepDefinition;

import CommonUtility.AssertMethods;
import CommonUtility.CommonMethods;
import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pom.*;


public class Setting_Users {

    public static String selectedValue = "";
    public static int numberOfSelectedSkill=0;

    @Then("^Validate that the \"([^\"]*)\" option is not displayed on the sub menu$")
    public void validate_that_the_option_is_not_displayed_on_the_sub_menu(String option) {
        boolean isFlag = false;
        for (WebElement element : Setting_UserProfileElement.settingSubMenuOptionList()) {
            if (element.getText().equals(option)) {
                isFlag = true;
                break;
            }
        }
        AssertMethods.isTrue(!isFlag, "Validate that the " + option + " option is not displayed on the sub menu");

    }

    @When("^Click on the users option$")
    public void click_on_the_users_option() {
        SeleniumMethods.click(Setting_UsersElement.usersOption(), "Click on the users option");
    }

    @Then("^Validate that the invite new users button is displayed$")
    public void validate_that_the_invite_new_users_button_is_displayed() {
        AssertMethods.elementIsDisplayed(Setting_UsersElement.inviteNewUsersButton(), "Validate that the invite new users button is displayed");
    }

    @When("^Click on the invite new users button$")
    public void Click_on_the_invite_new_users_button() {
        SeleniumMethods.click(Setting_UsersElement.inviteNewUsersButton(), "Click on the invite new users button");
    }

    @Then("^Validate that the invite new users dialog box heading is displayed$")
    public void validate_the_create_event_dialog_box_heading_is_displayed() {
        AssertMethods.elementTextIsEqualTo(Setting_CalendarElement.dialogBoxHeading(), "Invite New User", "Validate that the invite new users dialog box heading is displayed");
    }

    @Then("^Validate that the invite new users dialog box is closed$")
    public void validate_that_the_create_event_dialog_box_is_closed() {
        WaitMethods.pause(1);
        boolean isSprintDialogBoxClosed = true;
        try {
            if (Setting_CalendarElement.theDialogBoxHeading().isDisplayed()) {
                isSprintDialogBoxClosed = false;
            }
        } catch (Exception e) {
        }
        AssertMethods.isTrue(isSprintDialogBoxClosed, "Validate that the invite new users dialog box is closed");
    }

    @Then("^Validate that the done button is disabled$")
    public void validate_the_done_button_is_disabled() {
        AssertMethods.elementAttributeValueIsEqualTo(Setting_UsersElement.doneButton(), "disabled", "true", "Validate the done button is disabled");
    }

    @Then("^Enter \"([^\"]*)\" email on invite user email text box$")
    public void enter_email_on_invite_user_email_text_box(String email) {
        SeleniumMethods.sendKey(Setting_UsersElement.emailTextBox(), email, "Enter " + email + " email on invite user email text box");
    }

    @Then("^Validate that the done button is enable$")
    public void Validate_the_done_button_is_Enable() {
        AssertMethods.elementIsEnabled(Setting_UsersElement.doneButton(), "Validate the done button is Enable");
    }

    @When("^Click on the done button$")
    public void Click_on_the_done_button() {
        SeleniumMethods.click(Setting_UsersElement.doneButton(), "Click on the done button");
    }

    @Then("^Validate the count of user's table column$")
    public void Validate_the_count_of_users_table_column() {
        AssertMethods.elementListSizeIsSame(ReleasesElement.listOfTableHeader(), 7, "Validate the count of user's table column");
    }

    @And("Click on the first user from list")
    public void Click_on_the_first_user_from_list() {
        SeleniumMethods.click(DashboardElement.projectList().get(0), "Click on the first user from list");
    }

    @When("^Select the user role type$")
    public void Select_user_role_type() {
        WaitMethods.pause(4);
        SeleniumMethods.clickWithJs(Setting_UserProfileElement.userRoleDropdown(), "Click on the role dropdown");
        //SeleniumMethods.clickWithJs(Setting_UserProfileElement.userRoleDropdown(), "Click on the role dropdown");
        int i=0;
        WaitMethods.pause(1);
        for (WebElement element : Setting_UserProfileElement.dropdownList()) {
            if (!element.getAttribute("class").endsWith("selected")) {
                WaitMethods.pause(1);
                selectedValue = Setting_UserProfileElement.dropdownOptionList().get(i).getText();
                SeleniumMethods.click(Setting_UserProfileElement.dropdownOptionList().get(i), "Select " + selectedValue + " user role type");
                break;
            }
            i++;
        }
        SeleniumMethods.clickWithJs(Setting_UserProfileElement.userRoleDropdown(), "Click on the role dropdown");
        WaitMethods.pause(1);
    }


    @When("^Select the private channel$")
    public void select_private_channel() {
        WaitMethods.pause(4);
        SeleniumMethods.clickWithJs(Setting_UserProfileElement.privateChannelDropdown(), "Click on the private channel dropdown");
        //SeleniumMethods.clickWithJs(Setting_UserProfileElement.privateChannelDropdown(), "Click on the private channel dropdown");
        int i=0;
        for (WebElement element : Setting_UserProfileElement.dropdownList()) {
            if (!element.getAttribute("class").endsWith("selected")) {
                WaitMethods.pause(1);
                selectedValue = Setting_UserProfileElement.dropdownOptionList().get(i).getText();
                SeleniumMethods.click(Setting_UserProfileElement.dropdownOptionList().get(i), "Select " + selectedValue + " private channel");
                break;
            }
            i++;
        }
        SeleniumMethods.clickWithJs(Setting_UserProfileElement.privateChannelDropdown(), "Click on the private channel dropdown");
        WaitMethods.pause(1);
    }


    @Then("^Validate that the \"([^\"]*)\" Header is display$")
    public void validate_that_the__hHeader_is_display(String header) {
        boolean isTrue = false;
        for (WebElement element : ReleasesElement.listOfTableHeader()) {
            if (element.getText().equals(header)) {
                isTrue = true;
                break;
            }
        }
        Assert.assertTrue(isTrue);
        CommonMethods.logInfo("Validate that the " + header + " Header is displayed");
    }

    @Then("^Validate that the added role is also displayed on user list$")
    public void validate_that_the_added_role_is_also_displayed_on_user_list() {
        AssertMethods.elementTextHasText(Setting_UsersElement.selectedRoleOfUsersOnList().get(0).getText(), selectedValue, "Validate that the added role is also displayed on user list");
    }

    @When("^Unassign the selected user role type$")
    public void unassign_user_role_type() {
        WaitMethods.pause(4);
        SeleniumMethods.clickWithJs(Setting_UserProfileElement.userRoleDropdown(), "Click on the role dropdown");
        WaitMethods.pause(1);
        for (WebElement element : Setting_UserProfileElement.dropdownOptionList()) {
            if (element.getText().equals(selectedValue)) {
                WaitMethods.pause(1);
                selectedValue = element.getText();
                SeleniumMethods.click(element, "Unassign " + selectedValue + " user role type");
                break;
            }
        }
        SeleniumMethods.clickWithJs(Setting_UserProfileElement.userRoleDropdown(), "Click on the role dropdown");
    }

    @Then("^Validate that the unassign role is also removed from the user list$")
    public void validate_that_the_unassign_role_is_also_removed_from_user_list() {
        AssertMethods.elementTextHasNotEqualTo(Setting_UsersElement.selectedRoleOfUsersOnList().get(0), selectedValue, "Validate that the unassign role is also removed from the user list");
    }

    @When("^Remove the selected private channel$")
    public void remove_the_selected_private_channel() {
        WaitMethods.pause(4);
        SeleniumMethods.clickWithJs(Setting_UserProfileElement.privateChannelDropdown(), "Click on the private channel dropdown");
        WaitMethods.pause(1);
        for (WebElement element : Setting_UserProfileElement.dropdownOptionList()) {
            if (element.getText().equals(selectedValue)) {
                WaitMethods.pause(1);
                selectedValue = element.getText();
                SeleniumMethods.click(element, "Select " + selectedValue + " private channel");
                break;
            }
        }
        SeleniumMethods.clickWithJs(Setting_UserProfileElement.privateChannelDropdown(), "Click on the private channel dropdown");
    }

    @When("^Select the user skills$")
    public void select_the_user_skills() {
        SeleniumMethods.clickWithJs(Setting_UserProfileElement.skillDropdownList().get(Setting_UserProfileElement.skillDropdownList().size() - 1), "Click on the skill dropdown");
        WaitMethods.pause(1);
        for (WebElement element : Setting_UserProfileElement.dropdownOptionList()) {
            if (!element.getAttribute("class").endsWith("selected")) {
                WaitMethods.pause(1);
                selectedValue = element.getText();
                SeleniumMethods.click(element, "Select " + selectedValue + " the user skill");
                break;
            }
        }
    }

    @When("^Get the size of selected skill$")
    public void get_the_size_of_selected_skill() {
        numberOfSelectedSkill=Setting_UserProfileElement.skillDropdownList().size();

    }

    @Then("^Validate that the skill is assign to user$")
    public void validate_that_the_skill_is_assign_to_user() {
        WaitMethods.pause(3);
        AssertMethods.elementListSizeIsSame(Setting_UserProfileElement.skillDropdownList(), numberOfSelectedSkill+1, "Validate that the skill is assign to user");
    }

    @When("^Remove the selected skill$")
    public void remove_the_selected_skill() {
        SeleniumMethods.clickWithJs(Setting_UsersElement.skillCloseIconList().get(0), "Click on the assigned skill close icon");
        WaitMethods.pause(1);

    }

    @Then("^Validate that the skill is removed from user$")
    public void validate_that_the_skill_is_removed_from_user() {
        WaitMethods.pause(3);
        AssertMethods.elementListSizeIsSame(Setting_UserProfileElement.skillDropdownList(), numberOfSelectedSkill-1, "Validate that the skill is assign to user");
    }

    @When("^Add the user specialty$")
    public void add_the_user_specialty() {
        SeleniumMethods.clickWithJs(Setting_UsersElement.specialtiesDropdownList().get(0), "Click on the specialty dropdown");
        WaitMethods.pause(1);
        SeleniumMethods.click(Setting_UsersElement.specialtiesOptionList().get(0), "Select the first option from open user specialty dropdown");

    }

    @When("^Remove the user specialty$")
    public void remove_the_user_specialty() {
        SeleniumMethods.clickWithJs(Setting_UsersElement.specialtiesDropdownList().get(0), "Click on the specialty dropdown");
        WaitMethods.pause(1);
        SeleniumMethods.click(Setting_UsersElement.specialtiesOptionList().get(0), "Select the first option from open user specialty dropdown");

    }

    @And("Click on the deactivate check box of first user from list")
    public void click_on_the_deactivate_check_box_of_first_user_from_list() {
        WaitMethods.pause(5);
        SeleniumMethods.click(Setting_UsersElement.deactivateUsersCheckBoxList().get(0), "Click on the deactivate check box of first user from list");
    }

    @Then("^Validate that the wrong email validation message is displayed$")
    public void Validate_the_wrong_email_validation_message_is_displayed() {
        AssertMethods.elementTextIsEqualTo(Setting_UsersElement.emailErrorMSGTextBox(), "Invalid email format, example: user@example.com", "Validate that the wrong email validation message is displayed");
    }

}
