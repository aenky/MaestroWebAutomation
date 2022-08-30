package stepDefinition;

import CommonUtility.AssertMethods;
import CommonUtility.CommonMethods;
import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import pom.DashboardElement;
import pom.NuggetElement;
import pom.PeopleElement;

import java.awt.*;
import java.io.File;
import java.util.List;
import java.util.Objects;

public class Nugget {

    public static String nuggetName = "";
    public static String chatMessage = "";
    public static String fileName = "";
    public static String secondFileName = "";
    public static String thirdFileName = "";
    public static String nuggetId = "";
    public static String nuggetDescription = "Automation description 20220524183044";
    public static String chatReplyMessage = "";

    @Then("^Validate the create nugget button is displayed$")
    public void Validate_the_create_nugget_button_is_displayed() {
        AssertMethods.elementIsDisplayed(NuggetElement.createNuggetButton(), "Validate the create nugget button is displayed");
    }

    @When("Click on the create nugget button")
    public void Click_on_the_create_nugget_button() {
        SeleniumMethods.click(NuggetElement.createNuggetButton(), "Click on the create nugget button");
        WaitMethods.pause(1);
    }

    @Then("^Validate the create nugget heading on open dialog box$")
    public void Validate_the_create_nugget_heading_on_open_dialog_box() {
        AssertMethods.elementIsDisplayed(NuggetElement.createNuggetHeading(), "Validate the create nugget heading on open dialog box");
    }

    @Then("^Validate the nugget type dropdown field is displayed$")
    public void Validate_the_nugget_type_dropdown_field_is_displayed() {
        AssertMethods.elementIsDisplayed(NuggetElement.nuggetTypeDropdown(), "Validate the nugget type dropdown field is displayed");
    }

    @Then("^Validate the nugget name text box field is displayed$")
    public void Validate_the_nugget_name_textbox_field_is_displayed() {
        AssertMethods.elementIsDisplayed(NuggetElement.nuggetNameTextBox(), "Validate the nugget name text box field is displayed");
    }

    @Then("^Validate the nugget project dropdown field is displayed$")
    public void Validate_the_nugget_project_dropdown_field_is_displayed() {
        AssertMethods.elementIsDisplayed(NuggetElement.nuggetProjectDropdown(), "Validate the nugget project dropdown field is displayed");
    }

    @Then("^Validate the nugget priority dropdown field is displayed$")
    public void Validate_the_nugget_priority_dropdown_field_is_displayed() {
        AssertMethods.elementIsDisplayed(NuggetElement.nuggetPriorityDropdown(), "Validate the nugget priority dropdown field is displayed");
    }

    @Then("^Validate the nugget description text box field is displayed$")
    public void Validate_the_nugget_description_textbox_field_is_displayed() {
        AssertMethods.elementIsDisplayed(NuggetElement.nuggetDescriptionTextBox(), "Validate the nugget description text box field is displayed");
    }

    @Then("^Validate the close icon is displayed on open dialog box$")
    public void Validate_the_close_icon_is_displayed() {
        AssertMethods.elementIsDisplayed(DashboardElement.closeIcon(), "Validate the close icon is displayed on open dialog box");
    }

    @When("^Click on the close icon of open dialog box$")
    public void Click_on_the_close_icon_of_open_dialog_box() {
        SeleniumMethods.clickWithJs(DashboardElement.closeIcon(), "Click on the close icon of open dialog box");
    }

    @When("Select \"([^\"]*)\" nugget type from dropdown")
    public void select_nugget_type_from_dropdown(String type) {
        SeleniumMethods.click(NuggetElement.nuggetTypeDropdown(), "Click on nugget type from dropdown");
        List<WebElement> statusList = NuggetElement.nuggetTypeList();
        for (WebElement element : statusList) {
            if (element.getText().equalsIgnoreCase(type)) {
                SeleniumMethods.click(element, "Select " + type + " type from dropdown");
            }
        }
    }

    @When("Enter the nugget name on name text box")
    public void enter_nugget_name_on_name_field() {
        String timeStamp = CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        nuggetName = "Automation Nugget " + timeStamp;
        SeleniumMethods.sendKey(NuggetElement.nuggetNameTextBox(), nuggetName, "Enter 'Automation Nugget " + timeStamp + "' Nugget name");
    }


    @When("Select project from dropdown")
    public void select_project_from_dropdown() {
        SeleniumMethods.click(NuggetElement.nuggetProjectDropdown(), "Click on project dropdown field");
        SeleniumMethods.click(NuggetElement.nuggetProjectList().get(0), "Select first project from dropdown");
    }

    @When("Select \"([^\"]*)\" nugget priority from dropdown")
    public void select_nugget_priority_from_dropdown(String priority) {
        SeleniumMethods.click(NuggetElement.nuggetPriorityDropdown(), "Click on nugget priority from dropdown");
        WaitMethods.pause(2);
        List<WebElement> statusList = NuggetElement.nuggetPriorityList();
        for (WebElement element : statusList) {
            if (element.getText().equalsIgnoreCase(priority)) {
                SeleniumMethods.click(element, "Select " + priority + " priority from dropdown");
            }
        }
    }

    @When("Enter the description on description text box")
    public void enter_description_on_text_field() {
        String timeStamp = CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        nuggetDescription= "Automation description " + timeStamp;
        SeleniumMethods.sendKey(NuggetElement.nuggetDescriptionTextBox(),nuggetDescription , "Enter 'Automation description " + timeStamp + "' description");
    }

    @When("Click on the nugget name field")
    public void Click_on_the_nugget_name_field() {
        SeleniumMethods.click(NuggetElement.nuggetNameTextBox(), "Click on the nugget name field");
    }

    @When("Click on the outside of field")
    public void Click_on_the_outside_of_field() {
        SeleniumMethods.click(NuggetElement.nuggetDescriptionTextBox(), "Click on the outside of field");
    }

    @Then("^Validate the required field validation message displayed on name field$")
    public void Validate_the_required_field_validation_message_displayed() {
        AssertMethods.elementIsDisplayed(NuggetElement.validationMSgForNuggetNameTextBox(), "Validate the required field validation message displayed on name field");
    }

    @When("Click on the nugget project field")
    public void Click_on_the_nugget_project_field() {
        SeleniumMethods.click(NuggetElement.nuggetProjectDropdown(), "Click on the nugget project field");
    }

    @Then("^Validate the required field validation message displayed on project field$")
    public void Validate_the_required_field_validation_message_displayed_on_project_field() {
        AssertMethods.elementIsDisplayed(NuggetElement.validationMSgForNuggetProjectTextBox(), "Validate the required field validation message displayed on project field");
    }

    @When("Click on the nugget description field")
    public void Click_on_the_nugget_description_field() {
        SeleniumMethods.click(NuggetElement.nuggetDescriptionTextBox(), "Click on the nugget description field");
    }

    @Then("^Validate the required field validation message displayed on description field$")
    public void Validate_the_required_field_validation_message_displayed_on_description_field() {
        AssertMethods.elementIsDisplayed(NuggetElement.validationMSgForNuggetDescriptionTextBox(), "Validate the required field validation message displayed on description field");
    }

    @Then("^Validate that the successfully created nugget toast notification message is displayed$")
    public void Validate_the_successfully_created_nugget_toast_notification_message() {
        AssertMethods.elementTextIsStartWith(DashboardElement.toastNotificationPopup().getText(), "Successfully created", "Validate the successfully created nugget toast notification message is displayed");
    }

    @Then("^Validate that the subscribed tab is displayed as active tab$")
    public void Validate_the_subscribed_tab_is_displayed_as_active_tab() {
        WaitMethods.pause(4);
        AssertMethods.elementTextIsEndWith(NuggetElement.subscribedTab().getAttribute("class"), "active", "Validate the subscribed tab is displayed as active tab");
    }

    @Then("^Validate that the created nugget is displayed first on the list and highlighted$")
    public void Validate_the_created_nugget_is_highlighted_on_the_list() {
        AssertMethods.elementTextIsEqualTo(NuggetElement.nuggetNameList().get(0), nuggetName, "Validate that the created nugget name is same");
        WaitMethods.pause(2);
        AssertMethods.elementTextIsEndWith(NuggetElement.nuggetList().get(0).getAttribute("class"), "active", "Validate the created nugget is displayed first on the list and highlighted");
    }

    @Then("^Validate the audit message for create new nugget$")
    public void Validate_the_audit_message_for_create_new_nugget() {
        WaitMethods.pause(4);
        AssertMethods.elementTextIsEqualTo(NuggetElement.nuggetNameList().get(0), nuggetName, "Validate that the created nugget name is same");
        AssertMethods.elementTextIsEqualTo(NuggetElement.auditMessageForCreate(), "Created", "Validate the audit message for create new nugget");
    }

    @Then("^Validate the created nugget is subscribed automatically$")
    public void Validate_the_created_nugget_is_subscribed_automatically() {
        AssertMethods.elementTextIsEqualTo(NuggetElement.nuggetNameList().get(0), nuggetName, "Validate that the created nugget name is same");
        AssertMethods.elementTextIsEqualTo(NuggetElement.auditMessageForCreate(), "Created", "Validate the audit message for create new nugget");
    }

    @When("Click on the subscribed nugget tab")
    public void Click_on_the_subscribed_nugget_tab() {
        SeleniumMethods.click(NuggetElement.subscribedTab(), "Click on the subscribed nugget tab");
    }

    @When("^Click on the nugget subscribe checkbox$")
    public void Click_on_the_nugget_subscribe_checkbox() {
        WaitMethods.pause(1);
        SeleniumMethods.click(NuggetElement.nuggetSubscribeList().get(0), "Click on the nugget subscribe checkbox");
        WaitMethods.pause(1);
    }

    @Then("^Validate that the successfully unsubscribed the nugget toast notification message is displayed$")
    public void Validate_that_the_successfully_unsubscribed_the_nugget_toast_notification_message_is_displayed() {
        AssertMethods.elementTextIsStartWith(DashboardElement.toastNotificationPopup().getText(), "Unfollowing Nugget", "Validate that the successfully unsubscribed the nugget toast notification message is displayed");
        WaitMethods.pause(3);
    }

    @Then("^Validate that the successfully subscribed the nugget toast notification message is displayed$")
    public void Validate_that_the_successfully_subscribed_the_nugget_toast_notification_message_is_displayed() {
        AssertMethods.elementTextIsStartWith(DashboardElement.toastNotificationPopup().getText(), "Following Nugget", "Validate that the successfully unsubscribed the nugget toast notification message is displayed");
    }

    @Then("^Validate that the nugget details section has Chat, Details, Attachment and Assignment section tab is displayed$")
    public void Validate_the_nugget_details_section_with_the_Chat_Details_and_Attachment_section() {
        AssertMethods.elementIsDisplayed(DashboardElement.chatTabIcon(), "Validate that the nugget details section has displayed Chat tab icon");
        AssertMethods.elementIsDisplayed(DashboardElement.detailsTabIcon(), "Validate that the nugget details section has displayed details tab icon");
        AssertMethods.elementIsDisplayed(DashboardElement.chatAttachmentTabIcon(), "Validate that the nugget details section has displayed Chat attachment tab icon");
        AssertMethods.elementIsDisplayed(NuggetElement.assignmentTabIcon(), "Validate that the nugget details section has displayed assignment tab icon");
    }

    @When("^Click on the nugget chat tab$")
    public void Click_on_the_nugget_chat_tab() {
        SeleniumMethods.click(DashboardElement.chatTabIcon(), "Click on the nugget chat tab");
    }

    @Then("^Validate that the system is displayed the nugget details section$")
    public void Validate_the_system_is_displayed_the_nugget_details_section() {
        AssertMethods.elementTextIsEndWith(DashboardElement.detailsTabIcon().getAttribute("class"), "active", "Validate the system is displayed the Nugget details section");
        AssertMethods.elementIsDisplayed(NuggetElement.editNuggetName(), "Validate the system is displayed the edit nugget name field");
        AssertMethods.elementIsDisplayed(NuggetElement.editNuggetDescription(), "Validate the system is displayed the edit nugget description field");
    }

    @When("Click on the nugget details tab")
    public void Click_on_the_nugget_details_tab() {
        SeleniumMethods.click(DashboardElement.detailsTabIcon(), "Click on the nugget details tab");
    }

    @When("Click on the nugget attachment tab")
    public void Click_on_the_nugget_attachment_tab() {
        SeleniumMethods.click(DashboardElement.chatAttachmentTabIcon(), "Click on the nugget attachment tab");
    }

    @Then("^Validate that the system is displayed the nugget chat attachment section$")
    public void Validate_the_system_is_displayed_the_nugget_chat_attachment_section() {
        AssertMethods.elementTextIsEndWith(DashboardElement.chatAttachmentTabIcon().getAttribute("class"), "active", "Validate the system is displayed the nugget chat attachment section");
    }

    @When("Click on the nugget assignment tab")
    public void Click_on_the_nugget_assignment_tab() {
        WaitMethods.pause(5);
        SeleniumMethods.click(NuggetElement.assignmentTabIcon(), "Click on the nugget assignment tab");
    }

    @Then("^Validate that the system is displayed the nugget assignment section$")
    public void Validate_the_system_is_displayed_the_nugget_assignment_section() {
        AssertMethods.elementTextIsEndWith(NuggetElement.assignmentTabIcon().getAttribute("class"), "active", "Validate that the system is displayed the nugget assignment section");
        AssertMethods.elementIsDisplayed(NuggetElement.nuggetAssignmentResourcesSectionHeading(), "Validate that the system is displayed the nugget assignment resources section");
        //AssertMethods.elementIsDisplayed(NuggetElement.nuggetAssignmentJournalSectionHeading(), "Validate that the system is displayed the nugget assignment journal section");
    }

    @Then("^Validate that the all nugget edit fields are disabled$")
    public void Validate_the_all_fields_are_disabled() {
        AssertMethods.elementAttributeValueIsEqualTo(NuggetElement.editNuggetNameField(), "disabled", "true", "Validate that the nugget name field is disable");
        AssertMethods.elementAttributeValueIsEqualTo(NuggetElement.editNuggetTypeDropdownField(), "disabled", "true", "Validate that the nugget type dropdown field is disable");
        AssertMethods.elementAttributeValueIsEqualTo(NuggetElement.editNuggetPriorityDropdownField(), "disabled", "true", "Validate that the nugget Priority dropdown field is disable");
        AssertMethods.elementAttributeValueIsEqualTo(NuggetElement.editNuggetProjectDropdownField(), "disabled", "true", "Validate that the nugget Project dropdown field is disable");
        AssertMethods.elementAttributeValueIsEqualTo(NuggetElement.editNuggetDescriptionField(), "disabled", "true", "Validate that the nugget description field is disable");
    }

    @When("^Click on the nugget subscribe checkbox of nugget details section$")
    public void Click_on_the_nugget_subscribe_checkbox_of_nugget_details_section() {
        WaitMethods.pause(1);
        SeleniumMethods.click(NuggetElement.nuggetSubscribeList().get(0), "Click on the nugget subscribe checkbox of nugget details section");
        WaitMethods.pause(1);
    }

    @Then("^Validate that the subscribed nugget checkbox is displayed$")
    public void Validate_the_subscribed_nugget_checkbox_is_displayed() {
        AssertMethods.elementIsDisplayed(NuggetElement.nuggetCheckboxOfNuggetDetailsSection(), "Validate that the subscribed nugget checkbox is displayed");
    }


    @Then("^Validate that the tags dropdown field is displayed$")
    public void Validate_the_tags_nugget_dropdown_is_displayed() {
        AssertMethods.elementIsDisplayed(NuggetElement.nuggetTagsDropdownField(), "Validate that the tags dropdown field is displayed");
    }

    @Then("^Validate that the Tags dropdown is disabled$")
    public void Validate_the_tags_nugget_dropdown_is_disabled() {
        /*try {
            if (NuggetElement.nuggetTagsDropdownField().isDisplayed()) {
                CommonMethods.logInfo("Validate that the Tags dropdown is appear");
                Assert.assertTrue(false);
            }
        } catch (Exception e) {
            CommonMethods.logInfo("Validate that the Tags dropdown does not appear");
        }*/
        AssertMethods.elementAttributeValueIsEqualTo(NuggetElement.nuggetTagsDropdownField(),"disabled","true","Validate that the Tags dropdown is disabled");
    }

    @Then("^Validate that the edit phase icon is displayed$")
    public void Validate_that_the_edit_phase_icon_is_displayed() {
        WaitMethods.pause(1);
        AssertMethods.elementIsDisplayed(NuggetElement.editNuggetPhaseIcon(), "Validate that the edit phase icon is displayed");
    }

    @When("^Click on the edit phase icon$")
    public void Click_on_the_edit_phase_icon() {
        WaitMethods.pause(2);
        SeleniumMethods.click(NuggetElement.editNuggetPhaseIcon(), "Click on the edit phase icon");
    }

    @When("^Click on the remove phase icon$")
    public void Click_on_the_remove_phase_icon() {
        WaitMethods.pause(2);
        SeleniumMethods.click(NuggetElement.nuggetPhaseAssignmentIconList().get(0), "Click on the remove phase icon");
    }

    @Then("^Validate that the removed phase toast message appears$")
    public void Validate_that_the_remove_phase_toast_message_appears() {
        String phaseName = NuggetElement.nuggetPhaseNameList().get(1).getText();
        AssertMethods.elementTextIsEqualToIgnoreCase(DashboardElement.toastNotificationPopup(), "Phase " + phaseName + " is removed", "Validate that the removed phase toast message appears");
        WaitMethods.pause(2);
    }

    @When("^Click on the add phase icon$")
    public void Click_on_the_add_phase_icon() {
        WaitMethods.pause(3);
        SeleniumMethods.click(NuggetElement.nuggetPhaseAssignmentIconList().get(0), "Click on the add phase icon");
    }

    @Then("^Validate that the added phase toast message appears$")
    public void Validate_that_the_added_phase_toast_message_appears() {
        String phaseName = NuggetElement.nuggetPhaseNameList().get(1).getText();
        AssertMethods.elementTextIsEqualToIgnoreCase(DashboardElement.toastNotificationPopup(), "Phase " + phaseName + " is added", "Validate that the added phase toast message appears");
    }

    @Then("^Validate that the add and remove icon is not appears on triage phase$")
    public void Validate_that_the_remove_and_add_icon_is_not_appears_on_triage_phase() {
        try {
            if (NuggetElement.addAndRemoveIconOfTriagePhase().isDisplayed()) {
                CommonMethods.logInfo("Validate that the add and remove icon is appears on triage phase");
                Assert.assertTrue(false);
            }
        } catch (Exception e) {
            CommonMethods.logInfo("Validate that the remove and add icon is not appears on triage phase");
        }
    }

    @When("^Click on the first nugget phase$")
    public void Click_on_the_first_nugget_phase() {
        WaitMethods.pause(3);
        SeleniumMethods.click(NuggetElement.nuggetPhaseAssignmentNameList().get(1), "Click on the first nugget phase");
    }

    @Then("^Validate that the edit resources icon is displayed$")
    public void Validate_that_the_edit_resources_icon_is_displayed() {
        AssertMethods.elementIsDisplayed(NuggetElement.editNuggetPhaseIcon(), "Validate that the edit resources icon is displayed");
    }

    @When("^Click on the add resource icon$")
    public void Click_on_the_add_resource_icon() {
        WaitMethods.pause(3);
        SeleniumMethods.click(NuggetElement.nuggetResourceAssignmentIconList().get(0), "Click on the add resource icon");
    }

    @Then("^Validate that the validation toast message appears with \"([^\"]*)\"$")
    public void Validate_that_the_added_resource_toast_message_appears(String message) {
        AssertMethods.elementTextIsEqualToIgnoreCase(DashboardElement.toastNotificationPopup(), message, "Validate that the validation toast message appears");
    }

    @Then("^Validate that the toast validation message appears$")
    public void Validate_that_the_toast_message_appears() {
        AssertMethods.elementTextIsEqualToIgnoreCase(DashboardElement.toastNotificationPopup(), fileName+" size is larger than 25mb", "Validate that the validation toast message appears");
    }

    @Then("^Validate that the added resource toast message appears$")
    public void Validate_that_the_added_resource_toast_message_appears() {
        String resourceName = NuggetElement.nuggetResourceNameList().get(0).getText();
        AssertMethods.elementTextIsEqualToIgnoreCase(DashboardElement.toastNotificationPopup(), "Successfully assigned to " + resourceName, "Validate that the added resource toast message appears");
        WaitMethods.pause(2);
    }

    @When("^Click on the remove resource icon$")
    public void Click_on_the_remove_resource_icon() {
        WaitMethods.pause(2);
        SeleniumMethods.click(NuggetElement.nuggetResourceAssignmentIconList().get(0), "Click on the remove resource icon");
    }

    @Then("^Validate that the removed resource toast message appears$")
    public void Validate_that_the_removed_resource_toast_message_appears() {
        String resourceName = NuggetElement.nuggetResourceNameList().get(0).getText();
        AssertMethods.elementTextIsEqualToIgnoreCase(DashboardElement.toastNotificationPopup(), "Successfully unassigned from " + resourceName, "Validate that the removed resource toast message appears");
    }

    @Then("^Validate that the edit phase icon does not display$")
    public void Validate_that_the_edit_phase_icon_does_not_display() {
        boolean isNotDisplayed=true;
        try {
            if (NuggetElement.editNuggetPhasesIcon().isDisplayed()) {
                isNotDisplayed=false;
            }
        } catch (Exception e) {}
        Assert.assertTrue(isNotDisplayed);
        CommonMethods.logInfo("Validate that the edit phase icon does not display");
    }

    @Then("^Validate that the edit resources icon does not display$")
    public void Validate_that_the_edit_resources_icon_does_not_display() {
        boolean isNotDisplayed=true;
        try {
            if (NuggetElement.editNuggetResourceIcon().isDisplayed()) {
                isNotDisplayed=false;
            }
        } catch (Exception e) {}
        Assert.assertTrue(isNotDisplayed);
        CommonMethods.logInfo("Validate that the edit resources icon does not display");

    }

    @Then("^Validate that the input message field is displayed$")
    public void validate_that_the_input_message_field_is_displayed() {
        AssertMethods.elementIsDisplayed(NuggetElement.inputChatMessageField(), "Validate that the input message field is displayed");
    }

    @When("^Enter \"([^\"]*)\" on chat input field$")
    public void enter_message_on_chat_input_field(String message) {
        WaitMethods.pause(5);
        chatMessage = message + " " + CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        SeleniumMethods.click(NuggetElement.inputChatMessageField(), "Click on on chat input field");
        SeleniumMethods.sendKey(NuggetElement.inputChatMessageField(), chatMessage, "Enter message on chat input field");
    }

    @When("^Click on the send button$")
    public void Click_on_the_send_button() {
        WaitMethods.pause(1);
        SeleniumMethods.click(NuggetElement.sendButtonIcon(), "Click on the send button");
    }

    @Then("^Validate that the sent message is displayed on chat section$")
    public void validate_that_the_sent_message_is_displayed_on_chat_section() {
        AssertMethods.elementIsDisplayed(NuggetElement.sentMessage(chatMessage), "Validate that the sent message is displayed on chat section");
    }

    @Then("^Validate that the more option menu is displayed on sent message$")
    public void validate_that_the_more_option_menu_is_displayed_on_sent_message() {
        AssertMethods.elementIsDisplayed(NuggetElement.threeDotsMenuIcon(chatMessage), "Validate that the more option menu is displayed on sent message");
    }

    @When("^Select the image$")
    public void Select_the_image() {
        WaitMethods.pause(1);
        File file = new File("Files/auto_test_img1.jpg");
        String absoluteImagePath = file.getAbsolutePath();
        fileName = absoluteImagePath.split("\\\\")[(absoluteImagePath.split("\\\\").length) - 1];
        SeleniumMethods.sendKey(NuggetElement.fileInput(), absoluteImagePath, "Select the image");
    }

    @Then("^Validate that the sent image is displayed on chat section$")
    public void validate_that_the_sent_image_is_displayed_on_chat_section() {
        WaitMethods.pause(2);
        List<WebElement> listOfFiles = NuggetElement.sentImageFileList();
        int fileListSize = listOfFiles.size() - 1;
        AssertMethods.elementTextIsEqualTo(listOfFiles.get(fileListSize), fileName, "Validate that the sent image is displayed on chat section");
        WaitMethods.pause(3);
        List<WebElement> listOfFilesTime = NuggetElement.sentImageTimeList();
        AssertMethods.elementListSizeIsSame(listOfFilesTime, listOfFiles.size(), "Validate that last image file is uploaded");
    }

    @When("^Select the document file$")
    public void Select_the_document_file() {
        WaitMethods.pause(1);
        File file = new File("Files/Auto_Test_Doc1.txt");
        String absoluteImagePath = file.getAbsolutePath();
        fileName = absoluteImagePath.split("\\\\")[(absoluteImagePath.split("\\\\").length) - 1];
        SeleniumMethods.sendKey(NuggetElement.fileInput(), absoluteImagePath, "Select the document file");
    }

    @Then("^Validate that the sent document file is displayed on chat section$")
    public void validate_that_the_sent_document_is_displayed_on_chat_section() {
        WaitMethods.pause(2);
        List<WebElement> listOfFiles = NuggetElement.sentDocFileList();
        int fileListSize = listOfFiles.size() - 1;
        AssertMethods.elementTextIsEqualTo(listOfFiles.get(fileListSize), fileName, "Validate that the sent document is displayed on chat section");
        WaitMethods.pause(3);
        List<WebElement> listOfFilesTime = NuggetElement.sentDocFileTimeList();
        AssertMethods.elementListSizeIsSame(listOfFilesTime, listOfFiles.size(), "Validate that last document file is uploaded");
    }

    @When("^Select the audio file$")
    public void Select_the_audio_file() {
        WaitMethods.pause(1);
        File file = new File("Files/file_example_MP3_700KB.mp3");
        String absoluteImagePath = file.getAbsolutePath();
        fileName = absoluteImagePath.split("\\\\")[(absoluteImagePath.split("\\\\").length) - 1];
        SeleniumMethods.sendKey(NuggetElement.fileInput(), absoluteImagePath, "Select the audio file");
    }

    @Then("^Validate that the sent audio file is displayed on chat section$")
    public void validate_that_the_sent_audio_file_is_displayed_on_chat_section() {
        WaitMethods.pause(2);
        List<WebElement> listOfFiles = NuggetElement.sentAudioFileList();
        int fileListSize = listOfFiles.size() - 1;
        AssertMethods.elementTextIsEqualTo(listOfFiles.get(fileListSize), fileName, "Validate that the sent audio is displayed on chat section");
        WaitMethods.pause(5);
        List<WebElement> listOfFilesTime = NuggetElement.sentAudioFileTimeList();
        AssertMethods.elementListSizeIsSame(listOfFilesTime, listOfFiles.size(), "Validate that last audio file is uploaded");
    }

    @When("^Select the video file$")
    public void Select_the_video_file() {
        WaitMethods.pause(1);
        File file = new File("Files/auto_test_video.mp4");
        String absoluteImagePath = file.getAbsolutePath();
        fileName = absoluteImagePath.split("\\\\")[(absoluteImagePath.split("\\\\").length) - 1];
        SeleniumMethods.sendKey(NuggetElement.fileInput(), absoluteImagePath, "Select the video file");
    }

    @Then("^Validate that the sent video file is displayed on chat section$")
    public void validate_that_the_sent_video_file_is_displayed_on_chat_section() {
        WaitMethods.pause(2);
        List<WebElement> listOfFiles = NuggetElement.sentVideoFileList();
        int fileListSize = listOfFiles.size() - 1;
        AssertMethods.elementTextIsEqualTo(listOfFiles.get(fileListSize), fileName, "Validate that the sent audio is displayed on chat section");
        WaitMethods.pause(5);
        List<WebElement> listOfFilesTime = NuggetElement.sentVideoFileTimeList();
        AssertMethods.elementListSizeIsSame(listOfFilesTime, listOfFiles.size(), "Validate that last video file is uploaded");
    }

    @When("^Click on the more option menu$")
    public void Click_on_the_more_option_menu() {
        WaitMethods.pause(1);
        SeleniumMethods.click(NuggetElement.threeDotsMenuIcon(chatMessage), "Click on the more option menu");
    }

    @Then("^Validate all the option is displayed on the list$")
    public void validate_that_the_option_is_displayed_on_the_list() {
        List<WebElement> optionList = PeopleElement.moreOptionMenuList();
        AssertMethods.elementTextIsEqualTo(optionList.get(0), "Reply", "Validate that the 'Reply' option is displayed");
        AssertMethods.elementTextIsEqualTo(optionList.get(1), "Edit Message", "Validate that the 'Edit Message' option is displayed");
        AssertMethods.elementTextIsEqualTo(optionList.get(2), "Delete Message", "Validate that the 'Delete Message' option is displayed");
    }

    @When("^Click on the edit message option$")
    public void Click_on_the_edit_message_option() {
        List<WebElement> optionList = PeopleElement.moreOptionMenuList();
        SeleniumMethods.click(optionList.get(1), "Click on the edit message option");
    }

    @When("^Enter new message on chat input field$")
    public void enter_new_message_on_chat_input_field() {
        WaitMethods.pause(1);
        chatMessage = "Update auto test meg " + CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        WebElement inputField = NuggetElement.inputChatMessageField();
        SeleniumMethods.click(inputField, "Click on on chat input field");
        SeleniumMethods.clearField(inputField, "Clear input field");
        WaitMethods.pause(1);
        SeleniumMethods.sendKey(inputField, chatMessage, "Enter new message on chat input field");
    }

    @Then("^Validate that the updated sent message is displayed on chat section$")
    public void validate_that_the_updated_sent_message_is_displayed_on_chat_section() {
        AssertMethods.elementIsDisplayed(NuggetElement.sentMessage(chatMessage), "Validate that the updated sent message is displayed on chat section");
    }

    @When("^Click on the delete message option$")
    public void Click_on_the_delete_message_option() {
        List<WebElement> optionList = PeopleElement.moreOptionMenuList();
        SeleniumMethods.click(optionList.get(2), "Click on the delete message option");
    }

    @Then("^Validate that the message is deleted from the chat section$")
    public void validate_that_the_message_is_deleted_from_the_chat_section() {
        WaitMethods.pause(2);
        List<WebElement> deleteMessageList = NuggetElement.deletedMessageText();
        AssertMethods.elementIsDisplayed(deleteMessageList.get(deleteMessageList.size() - 1), "Validate that the message is deleted from the chat section");
    }

    @When("^Click on the reply message option$")
    public void Click_on_the_reply_message_option() {
        List<WebElement> optionList = PeopleElement.moreOptionMenuList();
        SeleniumMethods.click(optionList.get(0), "Click on the reply message option");
    }

    @When("^Enter the message for reply message$")
    public void enter_the_message_for_reply_message() {
        WaitMethods.pause(1);
        chatReplyMessage = "Reply auto test meg " + CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        WebElement inputField = NuggetElement.inputChatMessageField();
        SeleniumMethods.click(inputField, "Click on on chat input field");
        SeleniumMethods.sendKey(inputField, chatReplyMessage, "Enter the message for reply message");
    }

    @Then("^Validate that the main message and replied message both are displayed on the chat section$")
    public void validate_that_the_main_message_and_replied_message_both_are_displayed_on_the_chat_section() {
        WaitMethods.pause(2);
        List<WebElement> mainMessageList = NuggetElement.mainMessageList();
        AssertMethods.elementTextIsEqualTo(mainMessageList.get(mainMessageList.size() - 1), chatMessage, "Validate that the main message is displayed on the chat section: "+chatMessage);
        List<WebElement> repliedMessageList = NuggetElement.repliedMessageList();
        AssertMethods.elementTextIsEqualTo(repliedMessageList.get(repliedMessageList.size() - 1), chatReplyMessage, "Validate that the replied message is displayed on the chat section: "+chatReplyMessage);

    }

    @When("^Select the \"([^\"]*)\" file$")
    public void Select_the_big_size_file(String fileType) {
        WaitMethods.pause(1);
        String filePath = "Files/SampleJPGImage_30mb.jpg";
        if (fileType.equalsIgnoreCase("video")) {
            filePath = "Files/SampleVideo_30mb.mp4";
        }
        File file = new File(filePath);
        String absoluteImagePath = file.getAbsolutePath();
        fileName = absoluteImagePath.split("\\\\")[(absoluteImagePath.split("\\\\").length) - 1];
        SeleniumMethods.sendKey(NuggetElement.fileInput(), absoluteImagePath, "Select the " + fileType + " file");
    }

    @When("^Select the multiple files$")
    public void Select_the_multiple_files() {
        WaitMethods.pause(1);
        File file = new File("Files/Auto_Test_Doc1.txt");
        String absoluteImagePath = file.getAbsolutePath();
        File file1 = new File("Files/file_example_MP3_700KB.mp3");
        String absoluteImagePath1 = file1.getAbsolutePath();
        File file2 = new File("Files/auto_test_img1.jpg");
        String absoluteImagePath2 = file2.getAbsolutePath();
        fileName = absoluteImagePath.split("\\\\")[(absoluteImagePath.split("\\\\").length) - 1];
        secondFileName = absoluteImagePath1.split("\\\\")[(absoluteImagePath.split("\\\\").length) - 1];
        thirdFileName = absoluteImagePath2.split("\\\\")[(absoluteImagePath.split("\\\\").length) - 1];

        SeleniumMethods.sendKey(NuggetElement.fileInput(), absoluteImagePath2 + "\n " + absoluteImagePath1 + "\n " + absoluteImagePath, "Select the multiple files");
    }

    @Then("^Validate that the all selected file is sent and displayed on chat section$")
    public void validate_that_the_all_selected_file_is_sent_and_displayed_on_chat_section() {
        WaitMethods.pause(2);
        List<WebElement> listOfFiles = NuggetElement.sentAudioFileList();
        int fileListSize = listOfFiles.size() - 1;
        AssertMethods.elementTextIsEqualTo(listOfFiles.get(fileListSize), secondFileName, "Validate that the sent audio is displayed on chat section");
        WaitMethods.pause(5);
        List<WebElement> listOfFilesTime = NuggetElement.sentAudioFileTimeList();
        AssertMethods.elementListSizeIsSame(listOfFilesTime, listOfFiles.size(), "Validate that last audio file is uploaded");

        listOfFiles = NuggetElement.sentImageFileList();
        fileListSize = listOfFiles.size() - 1;
        AssertMethods.elementTextIsEqualTo(listOfFiles.get(fileListSize), thirdFileName, "Validate that the sent image is displayed on chat section");
        WaitMethods.pause(3);
        listOfFilesTime = NuggetElement.sentImageTimeList();
        AssertMethods.elementListSizeIsSame(listOfFilesTime, listOfFiles.size(), "Validate that last image file is uploaded");

        listOfFiles = NuggetElement.sentDocFileList();
        fileListSize = listOfFiles.size() - 1;
        AssertMethods.elementTextIsEqualTo(listOfFiles.get(fileListSize), fileName, "Validate that the sent document is displayed on chat section");

        listOfFilesTime = NuggetElement.sentDocFileTimeList();
        AssertMethods.elementListSizeIsSame(listOfFilesTime, listOfFiles.size(), "Validate that last document file is uploaded");
    }

    @Then("^Validate that the file is added on selected section$")
    public void validate_that_the_file_is_added_on_selected_section() {
        WaitMethods.pause(1);
        AssertMethods.elementIsDisplayed(NuggetElement.selectedFileElement(fileName), "Validate that the file is added on selected section");
    }

    @When("^Click on the close icon of selected file$")
    public void Click_on_the_close_icon_of_selected_file() {
        SeleniumMethods.click(NuggetElement.closeSelectedFileIcon(), "Click on the close icon of selected file");
    }

    @Then("^Validate that the selected file is removed from section$")
    public void Validate_that_the_selected_file_is_removed_from_section() {
        boolean isNotDisplayed=true;
        try {
            if (NuggetElement.selectedFileElementRemoved(fileName).isDisplayed()) {
                isNotDisplayed=false;
            }
        } catch (Exception e) {}
        Assert.assertTrue(isNotDisplayed);
        CommonMethods.logInfo("Validate that the selected file is removed from section");
    }

    @Then("^Validate that the sent \"([^\"]*)\" file is displayed on chat section$")
    public void validate_that_the_sent_file_is_displayed_on_chat_section(String fileType) {
        WaitMethods.pause(5);
        List<WebElement>listOfFiles = null;
        if(fileType.equalsIgnoreCase("video")){
            listOfFiles = NuggetElement.sentVideoFileList();
        }
        else if(fileType.equalsIgnoreCase("image")){
            listOfFiles = NuggetElement.sentImageFileList();
        }
        else if(fileType.equalsIgnoreCase("audio")){
            listOfFiles= NuggetElement.sentAudioFileList();
        }

        int fileListSize = (listOfFiles != null ? listOfFiles.size() : 0) - 1;

        AssertMethods.elementTextIsEqualTo(listOfFiles.get(fileListSize), fileName, "Validate that the sent "+fileType+" file is displayed on chat section");
        WaitMethods.pause(4);
        List<WebElement> listOfFilesTime = null;
        if(fileType.equalsIgnoreCase("video")){
            listOfFilesTime = NuggetElement.sentVideoFileTimeList();
        }
        else if(fileType.equalsIgnoreCase("image")){
            listOfFilesTime = NuggetElement.sentImageTimeList();
        }
        else if(fileType.equalsIgnoreCase("audio")){
            listOfFilesTime= NuggetElement.sentAudioFileTimeList();
        }
        AssertMethods.elementListSizeIsSame(Objects.requireNonNull(listOfFilesTime), listOfFiles.size(), "Validate that last "+fileType+" file is uploaded");
    }

    @When("^Select the \"([^\"]*)\" file from local$")
    public void Select_the_files(String fileType) {
        WaitMethods.pause(1);
        String filePath = "Files/auto_test_img2.jpg";
        if (fileType.equalsIgnoreCase("video")) {
            filePath = "Files/auto_test_video.mp4";
        }
        else if(fileType.equalsIgnoreCase("audio")){
            filePath = "Files/file_example_MP3_700KB.mp3";
        }
        File file = new File(filePath);
        String absoluteImagePath = file.getAbsolutePath();
        fileName = absoluteImagePath.split("\\\\")[(absoluteImagePath.split("\\\\").length) - 1];
        SeleniumMethods.sendKey(NuggetElement.fileInput(), absoluteImagePath, "Select the " + fileType + " file");
    }

    @When("^Click on the media sub tab$")
    public void Click_on_the_media_sub_tab() {
        SeleniumMethods.click(NuggetElement.mediaTab(), "Click on the media sub tab");
    }

    @Then("^Validated that the sent \"([^\"]*)\" file is displayed on media section$")
    public void validate_that_the_sent_file_is_displayed_on_media_section(String fileType) {
        WaitMethods.pause(5);
        WebElement element= null;
        if(fileType.equalsIgnoreCase("video")){
            element = NuggetElement.sentFileInMediaTab(fileName).get(NuggetElement.sentFileInMediaTab(fileName).size()-1);
        }
        else if(fileType.equalsIgnoreCase("image")){
            element = NuggetElement.sentFileInMediaTab(fileName).get(NuggetElement.sentFileInMediaTab(fileName).size()-1);
        }
        else if(fileType.equalsIgnoreCase("audio")){
            element= NuggetElement.audioFileInMediaTab().get(NuggetElement.audioFileInMediaTab().size()-1);
        }
        AssertMethods.elementTextIsEqualTo(Objects.requireNonNull(element), fileName, "Validate that the sent "+fileType+" file is displayed on media section");
    }

    @When("^Click on the documents sub tab$")
    public void Click_on_the_documents_sub_tab() {
        SeleniumMethods.click(NuggetElement.documentsTab(), "Click on the documents sub tab");
    }

    @Then("^Validated that the sent document file is displayed on documents section$")
    public void validate_that_the_sent_document_file_is_displayed_on_document_section() {
        WaitMethods.pause(5);
        AssertMethods.elementTextIsEqualTo(NuggetElement.docFileInDocumentsTab(fileName).get(NuggetElement.docFileInDocumentsTab(fileName).size()-1), fileName, "Validated that the sent document file is displayed on documents section");
    }

    @When("^Enter current URL in chat input field$")
    public void enter_current_URL_on_chat_input_field() {
        WaitMethods.pause(5);
        chatMessage = SeleniumMethods.getCurrentURL("Get Current URL");
        SeleniumMethods.click(NuggetElement.inputChatMessageField(), "Click on on chat input field");
        SeleniumMethods.sendKey(NuggetElement.inputChatMessageField(), chatMessage, "Enter message on chat input field");
    }

    @When("^Click on the links sub tab$")
    public void Click_on_the_link_sub_tab() {
        SeleniumMethods.click(NuggetElement.linkTab(), "Click on the link sub tab");
    }

    @Then("^Validated that the sent link URL is displayed on links section$")
    public void validate_that_the_sent_link_URL_is_displayed_on_document_section() {
        WaitMethods.pause(2);
        AssertMethods.elementTextIsEqualTo(NuggetElement.urlInLinksTab(chatMessage), chatMessage, "Validated that the sent link URL is displayed on links section");
    }

    @Then("^Validate that the sent link message is displayed on chat section$")
    public void validate_that_the_sent_link_message_is_displayed_on_chat_section() {
        WaitMethods.pause(2);
        List<WebElement> listOfFiles = NuggetElement.linkMessageList();
        int fileListSize = listOfFiles.size() - 1;
        AssertMethods.elementTextIsEqualTo(listOfFiles.get(fileListSize), chatMessage, "Validate that the sent image is displayed on chat section");
    }

    @When("^Click on the more option menu of audit message$")
    public void Click_on_the_more_option_menu_of_audit_message() {
        WaitMethods.pause(1);
        SeleniumMethods.click(NuggetElement.threeDotsMenuIconOnAuditMessage("Created"), "Click on the more option menu of audit message");
    }

    @Then("^Validate that the more option menu is displayed on audit message$")
    public void validate_that_the_more_option_menu_is_displayed_on_audit_message() {
        AssertMethods.elementIsDisplayed(NuggetElement.threeDotsMenuIconOnAuditMessage("Created"), "Validate that the more option menu is displayed on audit message");
    }

    @Then("^Validate that the more option list has only one value$")
    public void validate_that_the_more_option_list_has_only_one_value() {
        WaitMethods.pause(1);
        List<WebElement> optionList = PeopleElement.moreOptionMenuList();
       AssertMethods.elementListSizeIsSame(optionList,1,"Validate that the more option list has only one value");
    }

    @Then("^Validate that the more option list has only reply option$")
    public void validate_that_the_more_option_list_has_only_reply_option() {
        List<WebElement> optionList = PeopleElement.moreOptionMenuList();
        AssertMethods.elementTextIsEqualToIgnoreCase(optionList.get(0),"reply","Validate that the more option list has only reply option");
    }

    @Then("^Validate that the chat has displayed created nugget audit message$")
    public void validate_that_the_chat_has_displayed_created_nugget_audit_message() {
        AssertMethods.elementTextIsEqualTo(NuggetElement.auditMessage("Created"),"Created", "Validate that the chat has displayed created nugget audit message");
    }

    @Then("^Validate that the audit chat message color is \"([^\"]*)\"$")
    public void validate_that_the_audit_chat_message_color(String colorCode) {
        WebElement element= NuggetElement.auditMessage("Created");
        String color=element.getCssValue("color");
        String textColorCode = Color.fromString(color).asHex();
        CommonMethods.logInfo("Hex code of audit message:" + textColorCode);
        Assert.assertEquals(textColorCode,colorCode);
        CommonMethods.logInfo("Validate that the audit chat message color is "+colorCode);
    }

    @When("^Get the any nugget id from list$")
    public void get_the_any_nugget_id_from_list() {
        WaitMethods.pause(1);
        nuggetId= NuggetElement.nuggetIdList("2").get(1).getText();
    }

    @When("^Enter the nugget id on the search tab$")
    public void enter_the_nugget_id_on_the_search_tab() {
        WaitMethods.pause(1);
        SeleniumMethods.sendKey(NuggetElement.searchNuggetTextBox(),nuggetId,"Enter the nugget id on the search tab");
    }

    @When("^Press enter key from keyboard$")
    public void press_enter_key_from_keyboard() {
        WaitMethods.pause(1);
        SeleniumMethods.pressEnterKeyFromKeyBoard(NuggetElement.searchNuggetTextBox(),"Press enter key from keyboard");
    }

    @Then("^Validate that the system is redirected on the search result tab$")
    public void validate_that_the_system_is_redirected_on_the_search_result_tab() throws AWTException {
        WaitMethods.pause(4);
        WebElement element= NuggetElement.searchResultTab();
        CommonMethods.browserZoomIn();
        CommonMethods.browserZoomIn();
        AssertMethods.elementTextIsEqualTo(element,"Search Results","Validate that the search result tab is displayed");
        String color=element.getCssValue("color");
        String textColorCode = Color.fromString(color).asHex();
        CommonMethods.logInfo("Hex code of audit message:" + textColorCode);
        Assert.assertEquals(textColorCode,"#1e90ff");
        CommonMethods.logInfo("Validate that the search result tab color is #1e90ff");
    }

    @Then("^Validate that the searched nugget is displayed on search result tab list$")
    public void validate_that_the_searched_nugget_is_displayed_on_search_result_tab_list() {
        AssertMethods.elementTextIsEqualTo(NuggetElement.nuggetIdList("2").get(0),nuggetId, "Validate that the searched nugget is displayed on search result tab list");
    }

    @When("^Click on the nugget chat emoji icon$")
    public void Click_on_the_emoji_icon() {
        WaitMethods.pause(3);
        SeleniumMethods.clickWithJs(NuggetElement.emojiIcon(), "Click on the nugget chat emoji icon");
    }

    @Then("^Validate that the \"([^\"]*)\" emoji message is displayed$")
    public void validate_that_the_emoji_message_is_displayed(String emoji) {
        AssertMethods.elementIsDisplayed(NuggetElement.sentMessage(emoji),"Validate that the "+emoji+" emoji message is displayed");
    }

}
