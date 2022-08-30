package stepDefinition;

import CommonUtility.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import pom.*;

import java.awt.*;
import java.util.List;

public class First_SCB_TC_User {

    public static String userEmail = "newauto202208081655@yopmail.com";
    public static String userName = "";
    public static String firstName = "Dharmaketu";
    public static String lastName = "QAMukhopadhyay";
    public static String password = "QAtest@2020";
    public String SValue ="";
    public String NewSelectedValue ="";
    public int date =0;

    @Then("^Enter the email on the invite user email text box$")
    public void enter_email_on_the_invite_user_email_text_box() {
        String time = CommonMethods.getCurrentDateTime("yyyyMMddHHmm");
        userEmail = "newauto" + time + "@yopmail.com";
        SeleniumMethods.sendKey(Setting_UsersElement.emailTextBox(), userEmail, "Enter " + userEmail + " email on invite user email text box");
    }

    @Then("^Validate that the validation toast message is appears of invited user$")
    public void Validate_that_the_added_resource_toast_message_appears_of_invited_user() {
        AssertMethods.elementTextIsEqualToIgnoreCase(DashboardElement.toastNotificationPopup(), userEmail + " invited to Maestro", "Validate that the validation toast message appears");
        WaitMethods.pause(5);
    }

    @Then("^Open new window and open yopmail url$")
    public void open_new_Window_and_open_yopmail_url() {
        SeleniumMethods.openNewWindow("Open New Tab");
        SeleniumMethods.switchToNewWindow("Switch to the new Window");
        SeleniumMethods.openURL("https://yopmail.com/");
        WaitMethods.pause(1);
    }


    @Then("^Enter invited user email on yopmail and search email$")
    public void enter_invited_user_email_on_yopmail_and_search_email() {
        SeleniumMethods.sendKey(First_SCB_TC_UserElement.searchEmailField(), userEmail, "Enter invited user email " + userEmail + " on search email field");
        WaitMethods.pause(1);
        SeleniumMethods.click(First_SCB_TC_UserElement.enterSearchEmailIcon(), "Click on the search icon");
    }

    @Then("^Click on the invitation sign up link and switch to new open window$")
    public void Click_on_the_invitation_sign_up_link_and_switch_to_new_open_window() {
        WaitMethods.pause(1);
        SeleniumMethods.switchFrameById("ifmail");
        WaitMethods.pause(1);
        SeleniumMethods.click(First_SCB_TC_UserElement.signUpUserLink(), "Click on the sign up user link");
        SeleniumMethods.switchMainFrame();
        WaitMethods.pause(2);
        SeleniumMethods.switchToNewWindowWithIndex(2, "Switch to the new Window");

    }

    @Then("^Validate that the sign up page title is displayed$")
    public void Validate_that_the_sign_up_page_title_is_displayed() {
        AssertMethods.elementTextIsEqualToIgnoreCase(First_SCB_TC_UserElement.pageHeading(), "Sign up", "Validate that the sign up page title is displayed");
        WaitMethods.pause(5);
    }

    @Then("^Enter all the user details$")
    public void enter_all_the_user_details() {
        String time = CommonMethods.getCurrentDateTime("yyyyMMddHHmm");

        userName = "Auto_" + time;
        firstName = CommonMethods.firstName();
        lastName = "QA" + CommonMethods.lastName();

        SeleniumMethods.sendKey(First_SCB_TC_UserElement.elementById("title"), userName, "Enter user Name");
        SeleniumMethods.sendKey(First_SCB_TC_UserElement.elementById("firstName"), firstName, "Enter First Name");
        SeleniumMethods.sendKey(First_SCB_TC_UserElement.elementById("lastName"), lastName, "Enter Last Name");
        SeleniumMethods.sendKey(First_SCB_TC_UserElement.elementById("password"), password, "Enter Password");
        SeleniumMethods.sendKey(First_SCB_TC_UserElement.elementById("confirmPassword"), password, "Enter Confirm Password");
        SeleniumMethods.click(First_SCB_TC_UserElement.privacyPolicyCheckBox(), "Click on the privacy policy check box");
    }

    @Then("^Click on the sign up button$")
    public void click_on_the_sign_up_button() {
        WaitMethods.pause(1);
        SeleniumMethods.click(First_SCB_TC_UserElement.signUpButton(), "Click on the sign up button");

    }

    @Then("^Validate that the first name and last name of created user is displayed on user profile page$")
    public void Validate_that_the_first_name_and_last_name_of_created_user_is_displayed_on_user_profile_page() {
        AssertMethods.elementTextIsEqualToIgnoreCase(Setting_UserProfileElement.firstNameTextBox(), firstName, "Validate that the first name of created user is displayed on user profile page");
        AssertMethods.elementTextIsEqualToIgnoreCase(Setting_UserProfileElement.lastNameTextBox(), lastName, "Validate that the last name of created user is displayed on user profile page");

    }

    @When("^Validate that the newly created user displayed on the user list$")
    public void validate_that_the_newly_created_user_displayed_on_the_user_list() {
        WaitMethods.pause(3);
        while (true) {
            List<WebElement> elements = Setting_UserProfileElement.dataListTable();
            SeleniumMethods.scrollToElement(elements.get(elements.size() - 5));
            WaitMethods.pause(3);
            if (Setting_UserProfileElement.allDataLoaded() != null) {
                break;
            }
        }
        boolean isFirstName = false;
        boolean isLastName = false;
        for (WebElement element : NuggetElement.nuggetIdList("3")) {
            if (element.getText().equals(firstName)) {
                isFirstName = true;
                break;
            }
        }
        for (WebElement element : NuggetElement.nuggetIdList("2")) {
            if (element.getText().equals(lastName)) {
                isLastName = true;
                break;
            }
        }
        AssertMethods.isTrue(isFirstName, "Validate that the newly created user's first name is displayed on the user list");
        AssertMethods.isTrue(isLastName, "Validate that the newly created user's last name is displayed on the user list");
    }

    @When("^Enter the newly created user's email$")
    public void enter_user_email() {
        SeleniumMethods.sendKey(LoginElement.loginEmailTextBox(), userEmail, "Enter the newly created user email");
    }

    @And("^Enter the newly created user's password")
    public void enter_user_password() {
        SeleniumMethods.sendKey(LoginElement.loginPasswordTextBox(), (password), "Enter the newly created password");
    }

    @When("^Click on the newly created user$")
    public void click_on_the_newly_created_user() {
        boolean isDisplayed = false;
        WaitMethods.pause(3);
        List<WebElement> elementList = NuggetElement.nuggetIdList("3");
        for (int i = 0; i <= 20; i++) {
            for (WebElement element : elementList) {
                if (element.getText().equals(firstName) && element.isDisplayed()) {
                    SeleniumMethods.click(element, "Click on the newly created user");
                    isDisplayed = true;
                    break;
                }
            }
            if (isDisplayed) {
                break;
            }
            SeleniumMethods.scrollToElement(elementList.get(elementList.size() - 5));

        }
    }

    @When("^Validate that the assigned channel is displayed on the list$")
    public void validate_that_the_assigned_channel_is_displayed_on_the_list() {
        String groupName = "";
        for (WebElement el : PeopleElement.chatUserList()) {
            if (el.getText().equalsIgnoreCase(Setting_Users.selectedValue)) {
                groupName = el.getText();
            }
        }
        AssertMethods.elementTextHasText(Setting_Users.selectedValue, groupName, "Validate that the assigned channel is displayed on the list");
    }

    @When("^Validate that the assigned channel is removed from the list$")
    public void validate_that_the_assigned_channel_is_removed_from_the_list() {
        String groupName = "";
        for (WebElement el : PeopleElement.chatUserList()) {
            if (el.getText().equalsIgnoreCase(Setting_Users.selectedValue)) {
                groupName = el.getText();
            }
        }
        AssertMethods.elementTextHasText("", groupName, "Validate that the assigned channel is removed from the list");
    }

    @Then("^Click on the inactive checkbox$")
    public void click_on_the_inactive_checkbox() throws AWTException {
        WaitMethods.pause(1);
        CommonMethods.browserZoomIn();
        CommonMethods.browserZoomIn();
        CommonMethods.browserZoomIn();
        CommonMethods.browserZoomIn();
        SeleniumMethods.click(First_SCB_TC_UserElement.checkBoxList(firstName, "7").get(0), "Click on the inactive checkbox");

    }

    @Then("Validate that the list of account type is empty")
    public void validate_list_of_account_type_is_empty() {
        WaitMethods.pause(2);
        AssertMethods.elementListSizeIsSame(LoginElement.listOfAccountType(),0,"Validate that the list of account type is empty");
    }

    @When("^Enter the nugget id on chat input field$")
    public void enter_the_nuggetId_on_chat_input_field() {
        WaitMethods.pause(1);
        Nugget.chatMessage = Nugget.nuggetId;
        SeleniumMethods.click(PeopleElement.inputChatMessageField(), "Click on on chat input field");
        SeleniumMethods.sendKey(PeopleElement.inputChatMessageField(), Nugget.chatMessage, "Enter the "+Nugget.chatMessage+" message on chat input field");
    }

    @When("^Enter the nugget id on nugget chat input field$")
    public void enter_the_nuggetId_on_nugget_chat_input_field() {
        WaitMethods.pause(1);
        Nugget.chatMessage = Nugget.nuggetId;
        SeleniumMethods.click(NuggetElement.inputChatMessageField(), "Click on nugget chat input field");
        SeleniumMethods.sendKey(NuggetElement.inputChatMessageField(), Nugget.chatMessage, "Enter the "+Nugget.chatMessage+" message on chat input field");
    }

    @When("^Move cursor on the sent nugget id message$")
    public void move_cursor_on_the_seen_message_icon() {
        SeleniumMethods.moveCursorOnElement(First_SCB_TC_UserElement.sentMessage(Nugget.chatMessage),"Move cursor on the sent nugget id message");
        WaitMethods.pause(2);
    }

    @Then("Validate that the nugget details popup is displayed")
    public void validate_that_the_nugget_details_popup_is_displayed() {
        AssertMethods.elementIsDisplayed(First_SCB_TC_UserElement.nuggetSummeryPopup(),"Validate that the nugget details popup is displayed");
    }

    @Then("Validate that the nugget id is displayed on the nugget details popup")
    public void validate_that_the_nugget_id_is_displayed_on_the_nugget_details_popup() {
        AssertMethods.elementTextIsEqualTo(First_SCB_TC_UserElement.nuggetSummeryPopupDetails("1"),Nugget.nuggetId,"Validate that the nugget id is displayed on the nugget details popup");
    }

    @Then("Validate that the nugget name is displayed on the nugget details popup")
    public void validate_that_the_nugget_name_is_displayed_on_the_nugget_details_popup() {
        AssertMethods.elementTextIsEqualTo(First_SCB_TC_UserElement.nuggetSummeryPopupDetails("2"),Nugget.nuggetName,"Validate that the nugget name is displayed on the nugget details popup");
    }

    @Then("Validate that the nugget description is displayed on the nugget details popup")
    public void validate_that_the_nugget_description_is_displayed_on_the_nugget_details_popup() {
        AssertMethods.elementTextIsEqualTo(First_SCB_TC_UserElement.nuggetSummeryPopupDescription(),Nugget.nuggetDescription,"Validate that the nugget description is displayed on the nugget details popup");
    }

    @Then("^Validate that the sent message is displayed on the channel sent message section$")
    public void validate_that_the_sent_message_is_displayed_on_channel_sent_message_section() {
        WaitMethods.pause(1);
        AssertMethods.elementIsDisplayed(First_SCB_TC_UserElement.sentMessage(Nugget.chatMessage), "Validate that the sent message is displayed on the channel sent message section");
    }

    @When("^Click on more option menu of sent message$")
    public void Click_on_more_option_menu() {
        SeleniumMethods.clickWithJs(PeopleElement.inputChatMessageField(), "Click on on chat input field");
        WaitMethods.pause(1);
        SeleniumMethods.clickWithJs(First_SCB_TC_UserElement.threeDotsMenuIcon(Nugget.chatMessage), "Click on more option menu");
    }

    @When("^Click on the open nugget icon$")
    public void Click_on_open_nugget_icon() {
        WaitMethods.pause(1);
        SeleniumMethods.click(First_SCB_TC_UserElement.nuggetSummeryPopupDetails("3"), "Click on the open nugget icon");
    }

    @Then("^Validate that the nugget is displayed on search result tab list$")
    public void validate_that_the_nugget_is_displayed_on_search_result_tab_list() {
        AssertMethods.elementTextIsEqualTo(NuggetElement.nuggetIdList("2").get(0),Nugget.nuggetId, "Validate that the nugget is displayed on search result tab list");
    }

    @When("Update the nugget name on name text box")
    public void Update_nugget_name_on_name_field() {
        String timeStamp = CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        String nuggetName = "Update Nugget " + timeStamp;
        WebElement element=First_SCB_TC_UserElement.nuggetNameTextBox();
        SeleniumMethods.clearTheField(element,"Clear Nugget name field");
        SeleniumMethods.sendKey(element, nuggetName , "Enter '" + nuggetName + "' Nugget name");
    }

    @Then("^Validate that the audit chat \"([^\"]*)\" message color is \"([^\"]*)\"$")
    public void validate_that_the_audit_chat_message_color(String msg,String colorCode) {
        WebElement element= NuggetElement.auditMessage(msg);
        String color=element.getCssValue("color");
        String textColorCode = Color.fromString(color).asHex();
        CommonMethods.logInfo("Hex code of audit message:" + textColorCode);
        Assert.assertEquals(textColorCode,colorCode);
        CommonMethods.logInfo("Validate that the audit chat "+msg+" message color is "+colorCode);
    }

    @When("^Move cursor on the \"([^\"]*)\" audit message$")
    public void move_cursor_on_the_audit_message(String message) {
        SeleniumMethods.moveCursorOnElement(NuggetElement.auditMessage(message),"Move cursor on the "+message+" audit message");
        WaitMethods.pause(2);
    }

    @Then("Validate that the update details popup is displayed")
    public void validate_that_the_update_details_popup_is_displayed() {
        AssertMethods.elementIsDisplayed(First_SCB_TC_UserElement.auditMessageSummeryPopup(),"Validate that the nugget details popup is displayed");
    }

    @When("^Update the nugget type$")
    public void update_the_nugget_type() {
        WaitMethods.pause(1);
        SeleniumMethods.click(NuggetElement.editNuggetTypeDropdownField(), "Click on the nugget type dropdown");
        int i=0;
        for (WebElement element : Setting_UserProfileElement.dropdownList()) {
            if (element.getAttribute("class").endsWith("selected")) {
                WaitMethods.pause(1);
                SValue = Setting_UserProfileElement.dropdownOptionList().get(i).getText();
                break;
            }
            i++;
        }
        i=0;
        for (WebElement element : Setting_UserProfileElement.dropdownList()) {
            if (!element.getAttribute("class").endsWith("selected")) {
                WaitMethods.pause(1);
                NewSelectedValue = Setting_UserProfileElement.dropdownOptionList().get(i).getText();
                SeleniumMethods.clickWithJs(Setting_UserProfileElement.dropdownOptionList().get(i), "Select " + NewSelectedValue + " nugget type.");
                break;
            }
            i++;
        }
        WaitMethods.pause(1);
    }

    @Then("^Validate that the chat has displayed changed nugget type audit message$")
    public void validate_that_the_chat_has_displayed_changed_nugget_type_audit_message() {
        WaitMethods.pause(1);
        String message="Modified Type from "+SValue+" to "+NewSelectedValue;
        AssertMethods.elementTextIsEqualTo(NuggetElement.auditMessage(message),message, "Validate that the chat has displayed "+message+" audit message");
    }

    @When("^Update the nugget priority$")
    public void update_the_nugget_priority() {
        WaitMethods.pause(1);
        SeleniumMethods.click(NuggetElement.editNuggetPriorityDropdownField(), "Click on the nugget priority dropdown");
        int i=0;
        for (WebElement element : Setting_UserProfileElement.dropdownList()) {
            if (element.getAttribute("class").endsWith("selected")) {
                WaitMethods.pause(1);
                SValue = Setting_UserProfileElement.dropdownOptionList().get(i).getText();
                break;
            }
            i++;
        }
        i=0;
        for (WebElement element : Setting_UserProfileElement.dropdownList()) {
            if (!element.getAttribute("class").endsWith("selected")) {
                WaitMethods.pause(1);
                NewSelectedValue = Setting_UserProfileElement.dropdownOptionList().get(i).getText();
                SeleniumMethods.clickWithJs(Setting_UserProfileElement.dropdownOptionList().get(i), "Select " + NewSelectedValue + " nugget priority.");
                break;
            }
            i++;
        }
        WaitMethods.pause(1);
    }

    @Then("^Validate that the chat has displayed changed nugget's priority audit message$")
    public void validate_that_the_chat_has_displayed_changed_nugget_priority_audit_message() {
        WaitMethods.pause(1);
        String message="Modified Priority from "+SValue+" to "+NewSelectedValue;
        AssertMethods.elementTextIsEqualTo(NuggetElement.auditMessage(message),message, "Validate that the chat has displayed "+message+" audit message");
    }

    @When("^Update the nugget description on the description text box$")
    public void Update_nugget_description_on_the_description_field() {
        String timeStamp = CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        String name = "Update Description " + timeStamp;
        WebElement element=NuggetElement.editNuggetDescription();
        SeleniumMethods.clearTheField(element,"Clear nugget description field");
        SeleniumMethods.sendKey(element, name , "Enter '" + name + "' nugget description");
    }

    @When("^Click on backlog checkbox$")
    public void click_on_backlog_checkbox() {
        WebElement element=First_SCB_TC_UserElement.backlogCheckBox();
        SeleniumMethods.scrollToElement(element);
        WaitMethods.pause(1);
        SeleniumMethods.clickWithJs(element,"Click on backlog checkbox");
    }

    @Then("^Validate that the chat has displayed moved nugget to backlog audit message$")
    public void validate_that_the_chat_has_displayed_moved_nugget_to_backlog_audit_message() {
        String timeStamp = CommonMethods.getCurrentDateTime("EEE dd MMM yyyy");
        WaitMethods.pause(1);
        String day=CommonMethods.getCurrentDateTime("dd");
        String message="Moved to Backlog until "+timeStamp.replace(" "+day+" "," "+date+" ");
        AssertMethods.elementTextIsEqualTo(NuggetElement.auditMessage(message),message, "Validate that the chat has displayed moved nugget to backlog '"+message+"' audit message");
    }

    @When("^Select the current date from open datepicker$")
    public void select_the_current_date() {
        WaitMethods.pause(1);
        WebElement element = First_SCB_TC_UserElement.currentDateOption();
        date= Integer.parseInt(element.getText());
        SeleniumMethods.click(element, "Select the current date");
        WaitMethods.pause(2);
    }
}
