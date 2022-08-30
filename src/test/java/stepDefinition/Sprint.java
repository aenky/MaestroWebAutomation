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
import pom.SprintElement;
import java.awt.*;

public class Sprint {

    public static boolean isNuggetListEmpty=false;
    public static String sprintName="";
    public static String nuggetName="";

    @Then("^Validate that the nugget list is empty or not$")
    public void validate_that_the_nugget_list_is_empty_or_not() {
        SeleniumMethods.click(DashboardElement.chatTabIcon(), "Click on the nugget chat tab");
        if(SprintElement.nuggetList().isEmpty()){
            isNuggetListEmpty=true;
            CommonMethods.logInfo("Validate that the nugget list is empty");
        }
        else {
            isNuggetListEmpty=false;
            CommonMethods.logInfo("Validate that the nugget list is not empty");
        }
    }

    @When("^Create new nugget with \"([^\"]*)\" project if triage nugget list is empty$")
    public void create_new_nugget_if_triage_nugget_list_is_empty(String project) {
        Nugget nugget=new Nugget();
        if(isNuggetListEmpty){
            SeleniumMethods.click(NuggetElement.createNuggetButton(), "Click on the create nugget button");
            AssertMethods.elementIsDisplayed(NuggetElement.createNuggetHeading(), "Validate the create nugget heading on open dialog box");
            nugget.select_nugget_type_from_dropdown("Task");
            nugget.enter_nugget_name_on_name_field();
            SeleniumMethods.click(NuggetElement.nuggetProjectDropdown(), "Click on project dropdown field");
            for(WebElement element:NuggetElement.nuggetProjectList()){
                if(element.getText().equals(project)){
                    element.click();
                    CommonMethods.logInfo("Select "+project+" project from dropdown");
                }
            }
            nugget.select_nugget_priority_from_dropdown("Normal");
            nugget.enter_description_on_text_field();
            SeleniumMethods.click(DashboardElement.createButton(), "Click on the create button");
            AssertMethods.elementTextIsStartWith(DashboardElement.toastNotificationPopup().getText(), "Successfully created", "Validate the successfully created nugget toast notification message is displayed");
            isNuggetListEmpty=false;

        }else {
            CommonMethods.logInfo("The nugget list is not empty");
        }
    }

    @Then("^Validate that the sprint dropdown is displayed$")
    public void Validate_the_sprint_dropdown_is_displayed() {
        if(!isNuggetListEmpty) {
            WaitMethods.pause(3);
            SeleniumMethods.clickWithJs(SprintElement.nuggetSprintList().get(0), "Click on first nugget sprint option");
            WaitMethods.pause(1);
            AssertMethods.elementIsDisplayed(SprintElement.createSprintButton(), "Validate the create sprint button is displayed on open sprint dropdown");
        }
    }

    @Then("^Validate that the sprint dropdown is display$")
    public void Validate_the_sprint_dropdown_is_display() {
        if(!isNuggetListEmpty) {
            WaitMethods.pause(3);
            SeleniumMethods.clickWithJs(SprintElement.nuggetSprintListSix().get(0), "Click on first nugget sprint option");
            WaitMethods.pause(1);
            AssertMethods.elementIsDisplayed(SprintElement.createSprintButton(), "Validate the create sprint button is displayed on open sprint dropdown");
        }
    }

    @When("Click on approval due tab")
    public void Click_on_approval_due_tab() throws AWTException {
        CommonMethods.browserZoomIn();
        WaitMethods.pause(3);
        SeleniumMethods.click(DashboardElement.chatTabIcon(), "Click on the nugget chat tab");
        WaitMethods.pause(2);
        SeleniumMethods.clickWithJs(SprintElement.approvalDueNuggetTab(),"Click on approval due tab");

    }

    @When("Click on Backlog tab")
    public void Click_on_Backlog_tab() {
        SeleniumMethods.click(DashboardElement.chatTabIcon(), "Click on the nugget chat tab");
        WaitMethods.pause(1);
        SeleniumMethods.click(SprintElement.backlogNuggetTab(),"Click on Backlog tab");

    }

    @When("Click on delayed nuggets tab")
    public void click_on_delayed_nuggets_tab() {
        SeleniumMethods.click(DashboardElement.chatTabIcon(), "Click on the nugget chat tab");
        WaitMethods.pause(1);
        SeleniumMethods.click(SprintElement.delayedNuggetTab(),"Click on delayed nuggets tab");
    }

    @When("Click on overdue estimate tab")
    public void click_on_overdue_estimate_tab() {
        SeleniumMethods.click(DashboardElement.chatTabIcon(), "Click on the nugget chat tab");
        WaitMethods.pause(1);
        SeleniumMethods.click(SprintElement.overdueEstimateTab(),"Click on delayed nuggets tab");
    }

    @When("Click on the sprint dropdown")
    public void click_on_the_sprint_dropdown() {
        WaitMethods.pause(2);
        SeleniumMethods.clickWithJs(SprintElement.nuggetSprintList().get(0), "Click on first nugget sprint option");
    }

    @When("Click on the create sprint button")
    public void click_on_the_create_sprint_button() {
        SeleniumMethods.clickWithJs(SprintElement.createSprintButton(),"Click on the create sprint button");
    }

    @Then("^Validate that the create sprint dialog box is open$")
    public void Validate_that_the_create_sprint_dialog_box_is_open() {
            WaitMethods.pause(1);
            AssertMethods.elementIsDisplayed(SprintElement.createSprintDialogBoxHeading(), "Validate that the create sprint dialog box is open");
    }

    @Then("^Validate that tha sprint name field is displayed$")
    public void Validate_that_the_sprint_name_field_is_displayed() {
        AssertMethods.elementIsDisplayed(SprintElement.sprintNameTextBox(), "Validate that the sprint name field is displayed");
    }

    @Then("^Validate that the backlog check box and Return To Triage date pickers is displayed$")
    public void Validate_that_the_backlog_and_Backlog_check_box_Return_To_Triage_date_pickers_is_displayed() {
        AssertMethods.elementIsDisplayed(SprintElement.backlogCheckBox(), "Validate that the backlog check box is displayed");
        AssertMethods.elementIsDisplayed(SprintElement.returnToTriageDatePickers(), "Validate that the Return To Triage date pickers is displayed");
    }

    @Then("^Validate that the save button is displayed$")
    public void Validate_that_the_save_button_is_displayed() {
        AssertMethods.elementIsDisplayed(SprintElement.saveButton(2), "Validate that the save button is displayed");
    }

    @Then("^Validate that the close icon is displayed$")
    public void Validate_that_the_close_icon_is_displayed() {
        AssertMethods.elementIsDisplayed(DashboardElement.closeIcon(), "Validate that the close icon is displayed");
    }

    @Then("^Validate that the create sprint dialog box is closed$")
    public void Validate_that_the_create_sprint_dialog_box_is_closed() {
        WaitMethods.pause(1);
        boolean isSprintDialogBoxClosed=true;
        try {
            if(SprintElement.createSprintDialogBoxHeading().isDisplayed()){
                isSprintDialogBoxClosed=false;
            }
        }catch (Exception e){}
        Assert.assertTrue(isSprintDialogBoxClosed);
        CommonMethods.logInfo("Validate that the create sprint dialog box is closed");
    }

    @Then("^Validate that the Return To Triage date pickers field is disabled$")
    public void Validate_that_the_Return_To_Triage_date_pickers_is_disabled$() {
        AssertMethods.elementAttributeValueIsEqualTo(SprintElement.returnToTriageDatePickers(),"disabled","true", "Validate that the Return To Triage date pickers field is disabled");
    }

    @When("Click on the backlog checkbox")
    public void click_on_the_backlog_checkbox() {
        SeleniumMethods.clickWithJs(SprintElement.backlogCheckBox(),"Click on the backlog checkbox");
    }

    @Then("^Validate that the Return To Triage date pickers field is enabled")
    public void Validate_that_the_Return_To_Triage_date_pickers_is_enabled$() {
        AssertMethods.elementIsEnabled(SprintElement.returnToTriageDatePickers(), "Validate that the Return To Triage date pickers field is enabled");
    }

    @Then("^Validate that the save button is disabled$")
    public void Validate_that_the_save_button_is_disabled$() {
        AssertMethods.elementAttributeValueIsEqualTo(SprintElement.saveButton(1),"disabled","true", "Validate that the save button is disabled");
    }

    @Then("^Validate that the save button disabled$")
    public void Validate_that_the_save_button_disabled$() {
        AssertMethods.elementAttributeValueIsEqualTo(SprintElement.saveButton(2),"disabled","true", "Validate that the save button disabled");
    }

    @When("Enter the sprint name on name text box")
    public void enter_the_sprint_name_on_name_text_box() {
        sprintName="Auto Sprint "+CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        SeleniumMethods.sendKey(SprintElement.sprintNameTextBox(),sprintName,"Enter the sprint name on name text box");
    }

    @Then("^Validate that the save button is enabled")
    public void Validate_that_the_save_button_is_enabled$() {
        AssertMethods.elementIsEnabled(SprintElement.saveButton(1), "Validate that the save button is enabled");
    }

    @Then("^Validate that the save button enabled")
    public void Validate_that_the_save_button_enabled$() {
        AssertMethods.elementIsEnabled(SprintElement.saveButton(2), "Validate that the save button enabled");
    }

    @Then("^Validate that the successfully created sprint toast notification message is displayed$")
    public void Validate_the_successfully_created_sprint_toast_notification_message() {
        AssertMethods.elementTextIsStartWith(DashboardElement.toastNotificationPopup().getText(), "Successfully created", "Validate the successfully created sprint toast notification message is displayed");
    }

    @Then("^Validate that the created sprint is displayed on sprint list$")
    public void Validate_the_created_sprint_is_displayed_on_sprint_list() {
        AssertMethods.elementIsDisplayed(SprintElement.sprintName(sprintName), "Validate that the created sprint is displayed on sprint list");
    }

    @When("Select the return to triage date")
    public void select_the_return_to_triage_date() {
        WaitMethods.pause(2);
        //SeleniumMethods.click(SprintElement.returnToTriageDatePickers(),"Click on the return to triage date picker");
        SeleniumMethods.clickWithJs(SprintElement.rightSideArrow(),"Click on the right side arrow");
        WaitMethods.pause(1);
        SeleniumMethods.click(SprintElement.selectDate("15"),"Select 15 date from date picker");
        WaitMethods.pause(2);
    }

    @Then("^Validate that the selected return to triage date is displayed on created sprint name$")
    public void Validate_that_the_selected_return_to_triage_date_is_displayed_on_created_sprint_name() {
        int month= Integer.parseInt(CommonMethods.getCurrentDateTime("MM"))+1;
        String months= String.valueOf(month);
        if(month <10){
            months="0"+months;
        }
        String date= months +"/15/"+CommonMethods.getCurrentDateTime("yyyy");
        AssertMethods.elementTextIsEqualTo(SprintElement.sprintReturnDate(sprintName),date, "Validate that the selected return to triage date "+date+" is displayed on created sprint name");
    }

    @When("Click on the edit sprint icon")
    public void click_on_the_edit_sprint_icon() throws AWTException {
        sprintName= SprintElement.firstSprint().getText();
        CommonMethods.browserZoomIn();
        WaitMethods.pause(1);
        SeleniumMethods.moveCursorOnElement(SprintElement.moreOption(),"Move the cursor on more option icon");
        SeleniumMethods.clickWithJs(SprintElement.moreOption(),"Click on the more option icon");
        SeleniumMethods.moveCursorOnElement(SprintElement.editIcon(),"Move the cursor on more option icon");
        WaitMethods.pause(2);
        SeleniumMethods.clickWithJs(SprintElement.editIcon(),"Click on the edit sprint icon");
        WaitMethods.pause(2);
    }

    @Then("^Validate that the update sprint dialog box is open$")
    public void Validate_the_edit_sprint_dialog_box_is_open() {
        AssertMethods.elementIsDisplayed(SprintElement.updateDialogBoxHeader(), "Validate that the update sprint dialog box is open");
    }

    @When("Update the new sprint name")
    public void update_the_new_sprint_name() {
        sprintName="Update Sprint "+CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        SeleniumMethods.clickWithJs(SprintElement.closeIcon(),"Click on close icon");
        WaitMethods.pause(1);
        SeleniumMethods.sendKey(SprintElement.editTextBox(),sprintName,"Update the new sprint name");
    }

    @Then("^Validate that the successfully updated sprint toast notification message is displayed$")
    public void Validate_the_successfully_updated_sprint_toast_notification_message() {
        AssertMethods.elementTextIsStartWith(DashboardElement.toastNotificationPopup().getText(), "Successfully Updated", "Validate the successfully updated sprint toast notification message is displayed");
    }

    @When("Click on the update button")
    public void click_on_the_update_button() {
        WaitMethods.pause(1);
        SeleniumMethods.clickWithJs(SprintElement.updateButton(), "Click on the update button");
    }

    @Then("^Validate that the updated sprint is displayed on sprint list$")
    public void Validate_the_updated_sprint_is_displayed_on_sprint_list() {
        AssertMethods.elementIsDisplayed(SprintElement.sprintName(sprintName), "Validate that the updated sprint is displayed on sprint list");
    }

    @When("Update the new return to triage date")
    public void update_the_new_return_to_triage_date() {
        WaitMethods.pause(2);
        SeleniumMethods.clickWithJs(SprintElement.returnToTriageDatePickers(),"Click on the return to triage date picker");
        WaitMethods.pause(1);
        SeleniumMethods.clickWithJs(SprintElement.selectDate("18"),"Select 18 date from date picker");
        WaitMethods.pause(1);
    }

    @Then("^Validate that the updated return to triage date is displayed on sprint list$")
    public void Validate_that_the_updated_return_to_triage_date_is_displayed_on_sprint_list() {
        int month= Integer.parseInt(CommonMethods.getCurrentDateTime("MM"))+1;
        String months= String.valueOf(month);
        if(month <10){
            months="0"+months;
        }
        String date= months +"/18/"+CommonMethods.getCurrentDateTime("yyyy");
        AssertMethods.elementTextIsEqualTo(SprintElement.sprintReturnDate(sprintName),date, "Validate that the updated return to triage date "+date+" is displayed on sprint list");
    }

    @Then("^Validate that the return to triage date is removed$")
    public void Validate_that_the_updated_return_to_triage_date_is_updated_with_current_date() {
        String currentDate= CommonMethods.getCurrentDateTime("MM/dd/yyyy");
        AssertMethods.elementTextIsEqualTo(SprintElement.sprintReturnDate(sprintName),"", "Validate that the updated return to triage date is removed");
    }

    @Then("^Validate that the successfully delete sprint toast notification message is displayed$")
    public void Validate_the_successfully_delete_sprint_toast_notification_message() {
        AssertMethods.elementTextIsStartWith(DashboardElement.toastNotificationPopup().getText(), "Successfully Deleted", "Validate the successfully delete sprint toast notification message is displayed");
        SeleniumMethods.clickWithJs(SprintElement.nuggetSprintList().get(0), "Click on first nugget sprint option");
    }

    @When("Click on delete sprint icon")
    public void click_on_the_delete_sprint_icon() throws AWTException {
        sprintName= SprintElement.firstSprint().getText();
        CommonMethods.browserZoomIn();
        WaitMethods.pause(1);
        SeleniumMethods.moveCursorOnElement(SprintElement.moreOption(),"Move the cursor on more option icon");
        SeleniumMethods.clickWithJs(SprintElement.moreOption(),"Click on the more option icon");
        SeleniumMethods.moveCursorOnElement(SprintElement.deleteIcon(),"Move the cursor on delete sprint icon");
        WaitMethods.pause(2);
        SeleniumMethods.clickWithJs(SprintElement.deleteIcon(),"Click on the delete sprint icon");
        WaitMethods.pause(2);
    }

    @Then("^Validate that the deleted sprint is not displayed on sprint list$")
    public void Validate_the_deleted_sprint_is_not_displayed_on_sprint_list() {
        WaitMethods.pause(1);
        boolean isSprintDeleted=true;
        try {
            if(SprintElement.sprintName(sprintName).isDisplayed()){
                isSprintDeleted=false;
            }
        }catch (Exception e){}
        Assert.assertTrue(isSprintDeleted);
        CommonMethods.logInfo("Validate that the deleted sprint is not displayed on sprint list");
    }

    @When("Click on the more option menu of sprint")
    public void click_on_the_more_option_menu_of_sprint() throws AWTException {
        sprintName= SprintElement.firstSprint().getText();
        CommonMethods.browserZoomIn();
        WaitMethods.pause(1);
        SeleniumMethods.moveCursorOnElement(SprintElement.moreOption(),"Move the cursor on more option icon");
        SeleniumMethods.clickWithJs(SprintElement.moreOption(),"Click on the more option icon");
        SeleniumMethods.moveCursorOnElement(SprintElement.deleteIcon(),"Move the cursor on delete sprint icon");
    }

    @Then("^Validate that the edit sprint icon is displayed$")
    public void Validate_the_edit_sprint_icon_is_displayed() {
        AssertMethods.elementIsDisplayed(SprintElement.editIcon(), "Validate that the edit sprint icon is displayed");
    }
    @Then("^Validate that the delete sprint icon is displayed$")
    public void Validate_the_delete_sprint_icon_is_displayed() {
        AssertMethods.elementIsDisplayed(SprintElement.deleteIcon(), "Validate that the delete sprint icon is displayed");
    }

    @When("Enter the existing sprint name on name text box")
    public void enter_the_existing_sprint_name_on_name_text_box() {
        SeleniumMethods.sendKey(SprintElement.sprintNameTextBox(),sprintName,"Enter the existing sprint name on name text box");
    }

    @When("Get existing sprint name")
    public void get_existing_sprint_name() {
        sprintName= SprintElement.firstSprint().getText();
        CommonMethods.logInfo("Get existing project name");
    }

    @When("Click on the created sprint from list")
    public void click_on_the_created_sprint_from_list() throws AWTException {
        CommonMethods.browserZoomIn();
        WaitMethods.pause(1);
        SeleniumMethods.clickWithJs(SprintElement.sprintName(sprintName),"Click on the created sprint from list");
        WaitMethods.pause(2);
    }

    @When("Click on the assign sprint save button")
    public void click_on_the_assign_sprint_save_button() {
        SeleniumMethods.clickWithJs(SprintElement.saveIcon(),"Click on the assign sprint save button");
        WaitMethods.pause(3);
    }

    @Then("^Validate that the assign sprint is selected$")
    public void Validate_that_the_assign_sprint_is_selected() {
        AssertMethods.elementTextIsEndWith(SprintElement.sprintRow(sprintName).getAttribute("class"),"selected grid","Validate that the assign sprint is selected");
    }

    @When("Click on the none option from sprint list")
    public void click_on_the_none_option_from_sprint_list() {
        WaitMethods.pause(1);
        SeleniumMethods.clickWithJs(SprintElement.sprintName("None"),"Click on the none option from sprint list");
        WaitMethods.pause(3);
    }

    @Then("^Validate that the sprint is unassigned from nugget$")
    public void Validate_that_the_sprint_is_unassigned_from_nugget() {
        WaitMethods.pause(3);
        String colorCode="#3b3c53";
        sprintName= SprintElement.firstSprint().getText();
        WebElement element= SprintElement.sprintRow(sprintName);
        String color=element.getCssValue("color");
        String BG_ColorCode = Color.fromString(color).asHex();
        CommonMethods.logInfo("Hex code of sprint row bg color: " + BG_ColorCode);
        Assert.assertEquals(BG_ColorCode,colorCode);
        CommonMethods.logInfo("Validate that the sprint rows bg color is "+colorCode);
    }

    @Then("^Validate that the save assign sprint icon is displayed$")
    public void Validate_the_save_sprint_icon_is_displayed() {
        AssertMethods.elementIsDisplayed(SprintElement.saveAssignSprintIcon(), "Validate that the save assign sprint icon is displayed");
    }

    @Then("^Validate that the selected sprint name is removed$")
    public void Validate_the_selected_sprint_name_is_removed() {
        //
        //
        //
    }

    @When("^Click on the close icon$")
    public void click_on_the_close_icon() {
        SeleniumMethods.clickWithJs(SprintElement.closeAssignSprintIcon(),"Click on the close icon");
        WaitMethods.pause(2);
    }

    @Then("^Validate that the close assign sprint icon is displayed$")
    public void validate_the_close_sprint_icon_is_displayed() {
        AssertMethods.elementIsDisplayed(SprintElement.closeAssignSprintIcon(), "Validate that the close assign sprint icon is displayed");
    }

    @When("^Click on the save icon$")
    public void click_on_the_save_icon() {
        nuggetName=SprintElement.nuggetNameList().get(0).getText();
        SeleniumMethods.clickWithJs(SprintElement.saveAssignSprintIcon(),"Click on the save icon");
        WaitMethods.pause(2);
    }

    @When("^Click on save button of create sprint dialog box$")
    public void click_on_the_save_button() {
        WaitMethods.pause(2);
        SeleniumMethods.click(SprintElement.saveButton(2), "Click on the save button of create sprint dialog box");
    }

    @When("^Click on the save icon on backlog tab$")
    public void click_on_the_save_icon_backlog() {
        SeleniumMethods.clickWithJs(SprintElement.saveAssignSprintIcon(),"Click on the save icon on backlog tab");
        WaitMethods.pause(2);
    }

    @When("Click on the backlog tab")
    public void click_on_the_backlog_tab() {
        SeleniumMethods.clickWithJs(SprintElement.backlogNuggetTab(),"Click on the backlog tab");
        WaitMethods.pause(2);
    }

    @Then("^Validate that the moved nugget is displayed on the backlog List$")
    public void validate_the_moved_nugget_is_displayed_on_the_backlog_List() {
        boolean isNuggetExist=false;
        for(WebElement element: SprintElement.nuggetNameList()){
            if(element.getText().equals(nuggetName)){
                isNuggetExist=true;
                break;
            }
        }
        Assert.assertTrue(isNuggetExist);
        CommonMethods.logInfo("Validate that the moved nugget is displayed on the backlog List");
    }

    @When("Click on the archive button")
    public void click_on_the_archive_button() {
        SeleniumMethods.moveCursorOnElement(SprintElement.nuggetArchiveCheckbox(nuggetName),"Move cursor on archive button");
        WaitMethods.pause(1);
        SeleniumMethods.clickWithJs(SprintElement.nuggetArchiveCheckbox(nuggetName),"Click on the archive button");
        //SeleniumMethods.clickWithJs(SprintElement.nuggetArchiveCheckbox(nuggetName),"Click on the archive button");
        WaitMethods.pause(3);
    }

    @When("Click on the archive checkbox")
    public void click_on_the_archive_checkbox() {
        SeleniumMethods.moveCursorOnElement(SprintElement.nuggetArchiveCheckbox(Nugget.nuggetName),"Move cursor on archive button");
        WaitMethods.pause(1);
        SeleniumMethods.clickWithJs(SprintElement.nuggetArchiveCheckbox(Nugget.nuggetName),"Click on the archive button");
        WaitMethods.pause(3);
    }

    @When("Click on the first sprint from the list")
    public void click_on_the_first_sprint_from_the_list() {
        SeleniumMethods.clickWithJs(SprintElement.firstSprint(),"Click on the first sprint from the list");
        WaitMethods.pause(1);
    }

    @When("Click on the moved nuggets sprint dropdown")
    public void click_on_the_moved_nuggets_sprint_dropdown() {
        WaitMethods.pause(2);
        SeleniumMethods.clickWithJs(SprintElement.nuggetSprintDropdown(nuggetName), "Click on the moved nuggets sprint dropdown");
    }

}
