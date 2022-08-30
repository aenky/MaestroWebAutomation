package stepDefinition;

import CommonUtility.AssertMethods;
import CommonUtility.CommonMethods;
import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.JSONArray;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pom.*;

import java.awt.*;
import java.util.List;
import java.util.Objects;

public class SCB_TC_Nugget {

    public static String resourceName = "";
    public static String currentDate = "";
    public static String selectedDate = "";
    public static String journalHours = "3";
    public static String journalNotes = "Auto Journal Notes";
    public static String projectName = "Scenario Base Project";
    public static JSONArray phaseList;
    public static JSONArray nuggetList = new JSONArray();

    @When("^Select the \"([^\"]*)\" project from dropdown$")
    public void select_the_project_from_dropdown(String name) {
        projectName = name;
        SeleniumMethods.click(NuggetElement.nuggetProjectDropdown(), "Click on project dropdown field");
        for (WebElement element : NuggetElement.nuggetProjectList()) {
            if (element.getText().equals(projectName)) {
                SeleniumMethods.click(element, "Select the " + projectName + " project from dropdown");
                break;
            }
        }
    }

    @Then("^Validate that the created nugget is displayed on triage nugget list$")
    public void Validate_the_created_nugget_is_displayed_on_triage_nugget_list() {
        String name = "";
        for (WebElement element : SCB_TC_NuggetElement.nameList()) {
            if (element.getText().equals(Nugget.nuggetName)) {
                name = element.getText();
                break;
            }
        }
        AssertMethods.elementTextHasText(Nugget.nuggetName, name, "Validate that the created nugget is displayed on triage nugget list");
    }

    @Then("^Click on the created nugget$")
    public void click_on_the_created_nugget() {
        boolean isClicked=false;
        for (int i = 0; i <= 20; i++) {
            List<WebElement> elementList = SCB_TC_NuggetElement.nameList();
            for (WebElement element : SCB_TC_NuggetElement.nameList()) {
                if (element.getText().equals(Nugget.nuggetName)) {
                    SeleniumMethods.click(element, "Click on the " + Nugget.nuggetName + " created nugget");
                    isClicked=true;
                    break;
                }
            }
            if (isClicked) {
                break;
            }
            SeleniumMethods.scrollToElement(elementList.get(elementList.size() - 2));
            WaitMethods.pause(3);
        }
    }

    @When("^Select the \"([^\"]*)\" resource from any phase$")
    public void select_the_resource_from_any_phase(String name) {
        resourceName = name;
        SeleniumMethods.clickWithJs(SCB_TC_NuggetElement.assignIcon(name), "Click on assign icon of resource");
    }

    @When("^Get Nugget Id$")
    public void get_nugget_id() {
        Nugget.nuggetId= NuggetElement.nuggetId().getText();
    }

    @When("^Remove the \"([^\"]*)\" resource$")
    public void remove_the_resource(String name) {
        resourceName = name;
        SeleniumMethods.clickWithJs(SCB_TC_NuggetElement.removeIcon(name), "Click on remove icon of resource");
        WaitMethods.pause(2);
    }

    @Then("^Validate that the assign resource toast validation message is displayed$")
    public void Validate_that_the_assign_resource_toast_validation_message_is_displayed() {
        WaitMethods.pause(2);
        AssertMethods.elementTextIsEqualToIgnoreCase(DashboardElement.toastNotificationPopup(), "Successfully assigned to " + resourceName + "", "Validate that the assign resource toast validation message is displayed");

    }

    @Then("^Validate that the nugget's assigned status is \"([^\"]*)\"$")
    public void Validate_that_the_nuggets_assigned_status(String assignedStatus) {
        WaitMethods.pause(4);
        AssertMethods.elementTextIsEqualTo(SCB_TC_NuggetElement.assignedStatus(Nugget.nuggetName), assignedStatus, "Validate that the nugget's assigned status is " + assignedStatus + "");
        WaitMethods.pause(2);
    }

    @Then("^Click on the second phase$")
    public void click_on_the_second_phase() {
        WaitMethods.pause(2);
        List<WebElement> elementList = SCB_TC_NuggetElement.listOfPhases();
        phaseList = new JSONArray();
        for (WebElement el : elementList) {
            phaseList.add(el.getText());
        }
        SeleniumMethods.click(elementList.get(elementList.size() - 1), "Click on the second phase");
        WaitMethods.pause(1);
    }

    @Then("^Click on the first phase$")
    public void click_on_the_first_phase() {
        List<WebElement> elementList = SCB_TC_NuggetElement.listOfPhases();
        SeleniumMethods.click(elementList.get(1), "Click on the second phase");
        WaitMethods.pause(1);
    }

    @When("^Click on the edit resource icon$")
    public void Click_on_the_edit_resource_icon() {
        WaitMethods.pause(2);
        SeleniumMethods.click(NuggetElement.editNuggetResourcesIcon(), "Click on the edit resource icon");
    }

    @Then("^Validate that the created nugget is removed from triage list$")
    public void Validate_that_the_created_nugget_is_removed_from_triage_list() {
        String name = "";
        for (WebElement element : SCB_TC_NuggetElement.nameList()) {
            if (element.getText().equals(Nugget.nuggetName)) {
                name = element.getText();
                break;
            }
        }
        AssertMethods.elementTextHasText(name, "", "Validate that the created nugget is removed from triage list");
    }

    @When("^Click on the \"([^\"]*)\" sub tab$")
    public void Click_on_the_sub_tab(String tabName) {
        SeleniumMethods.scrollToElementHorizontal(DashboardElement.scrollElement(), 5);
        SeleniumMethods.click(DashboardElement.chatTabIcon(), "Click on the nugget chat tab");
        WaitMethods.pause(1);
        WebElement el=null;
        for (WebElement element : SCB_TC_NuggetElement.listOfSubTab()) {
            if (element.getText().equals(tabName)) {
                el=element;
                break;
            }
        }
        SeleniumMethods.click(el, "Click on the " + tabName + " sub tab");
        WaitMethods.pause(2);
    }

    @Then("^Validate that the nugget name is displayed on the nugget list$")
    public void Validate_that_the_nugget_is_displayed_on_the_nugget_list() {
        WaitMethods.pause(2);
        String name = "";
        for (int i = 0; i <= 20; i++) {
            List<WebElement> elementList = SCB_TC_NuggetElement.nameList();
            for (WebElement element : elementList) {
                if (element.getText().equals(Nugget.nuggetName)) {
                    name = element.getText();
                    break;
                }
            }
            if (!Objects.equals(name, "")) {
                break;
            }
            SeleniumMethods.scrollToElement(elementList.get(elementList.size() - 12));
            WaitMethods.pause(3);
        }
        AssertMethods.elementTextHasText(name, Nugget.nuggetName, "Validate that the nugget name is displayed on the nugget list");
    }

    @Then("^Validate that the removed resource toast validation message is displayed$")
    public void Validate_that_the_removed_resource_toast_validation_message_is_displayed() {
        AssertMethods.elementTextIsEqualToIgnoreCase(DashboardElement.toastNotificationPopup(), "Successfully unassigned from " + resourceName + "", "Validate that the removed resource toast validation message is displayed");
    }

    @Then("^Validate that the nugget's estimated status is \"([^\"]*)\"$")
    public void Validate_that_the_nuggets_estimated_status(String estimatedStatus) {
        AssertMethods.elementTextIsEqualTo(SCB_TC_NuggetElement.estimatedStatus(Nugget.nuggetName), estimatedStatus, "Validate that the nugget's estimated status is " + estimatedStatus + "");
        WaitMethods.pause(2);
    }

    @Then("^Click on the nugget timecard tab$")
    public void click_on_the_nugget_timecard_tab() {
        WaitMethods.pause(1);
        SeleniumMethods.click(SCB_TC_NuggetElement.timeCardTabIcon(), "Click on the nugget timecard tab");
    }

    @When("^Select the current date on start date$")
    public void select_the_current_date_on_start_date() {
        SeleniumMethods.click(Setting_CalendarElement.editStartDate(), "Click on the start date field");
        WaitMethods.pause(1);

        if (SCB_TC_NuggetElement.currentDateOptionForNull() == null) {
            SeleniumMethods.click(ReleasesElement.leftSideArrow(), "Click on the left side arrow");
            WaitMethods.pause(1);
        }
        WebElement element = SCB_TC_NuggetElement.currentDateOption();
        currentDate = element.getText();
        SeleniumMethods.click(element, "Select the current date");
        WaitMethods.pause(2);
    }

    @When("^Select the future date on start date$")
    public void select_the_future_date_on_start_date() {
        SeleniumMethods.click(Setting_CalendarElement.editStartDate(), "Click on the start date field");
        WaitMethods.pause(1);
        WebElement element = SCB_TC_NuggetElement.currentDateOption();
        currentDate = element.getText();
        if (Integer.parseInt(currentDate) > 28) {
            SeleniumMethods.clickWithJs(SprintElement.rightSideArrow(), "Click on the right side arrow");
            WaitMethods.pause(1);
            SeleniumMethods.click(SCB_TC_NuggetElement.selectDate("2"), "Select 2 date from start date");
            selectedDate = "2";
        } else {
            WebElement el = SCB_TC_NuggetElement.selectDate(String.valueOf((Integer.parseInt(currentDate) + 3)));
            selectedDate = el.getText();
            SeleniumMethods.click(el, "Select " + el.getText() + " date from start date");
        }
        WaitMethods.pause(2);

    }

    @When("^Select any future date on target date$")
    public void select_any_future_date_on_target_date() {
        SeleniumMethods.click(SCB_TC_NuggetElement.targetDate(), "Click on the target date field");
        WaitMethods.pause(1);
        if (Integer.parseInt(currentDate) >= 27) {
            SeleniumMethods.clickWithJs(SprintElement.rightSideArrow(), "Click on the right side arrow");
            WaitMethods.pause(1);
            SeleniumMethods.click(SCB_TC_NuggetElement.selectDate("3"), "Select 2 date from target date");
        } else {
            WebElement element = SCB_TC_NuggetElement.selectDate(String.valueOf((Integer.parseInt(currentDate) + 4)));
            SeleniumMethods.click(element, "Select " + element.getText() + " date from target date");
        }
        WaitMethods.pause(2);
    }

    @When("^Enter \"([^\"]*)\" hours on estimate hours field$")
    public void select_any_future_date_on_target_date(String hours) {
        SeleniumMethods.clearTheField(SCB_TC_NuggetElement.estimatedHoursField(), "Clear the hours on estimate hours field");
        SeleniumMethods.sendKey(SCB_TC_NuggetElement.estimatedHoursField(), hours, "Enter the hours on estimate hours field");
    }

    @Then("^Click on the submit estimate button$")
    public void click_on_the_submit_estimate_button() {
        WaitMethods.pause(1);
        SeleniumMethods.click(SCB_TC_NuggetElement.submitEstimateButton(), "Click on the submit estimate button");
    }


    @Then("^Validate that the success toast message is displayed$")
    public void Validate_that_the_success_toast_message_is_displayed() {
        AssertMethods.elementTextIsStartWith(DashboardElement.toastNotificationPopup().getText(), "Successfully updated", "Validate that the success toast message is displayed");
        WaitMethods.pause(2);
    }

    @Then("^Validate that the date is disabled till the selected start date on the target date picker$")
    public void validate_the_date_is_disabled_till_the_selected_start_date_on_the_target_date_picker() {
        int intDate = Integer.parseInt(selectedDate) - 1;
        List<WebElement> dates = ReleasesElement.listOfDate();
        for (int i = 0; i < intDate; i++) {
            int j = i + 1;
            AssertMethods.elementAttributeValueIsEqualTo(dates.get(i), "disabled", "true", "Validate that the " + j + " date is disabled on the date picker");
        }
    }

    @When("^Click on start date field$")
    public void click_on_start_date_field() {
        WaitMethods.pause(1);
        SeleniumMethods.click(Setting_CalendarElement.editStartDate(), "Click on start date picker");
        WaitMethods.pause(1);
    }

    @When("^Click on the target date field$")
    public void click_on_the_target_date_field() {
        WaitMethods.pause(1);
        SeleniumMethods.click(SCB_TC_NuggetElement.targetDate(), "Click on the target date picker");
        WaitMethods.pause(1);
    }

    @Then("^Click on the add journal icon$")
    public void click_on_the_add_journal_icon() {
        SeleniumMethods.click(SCB_TC_NuggetElement.plusIcon(), "Click on the add journal icon");
    }

    @When("^Select the current date$")
    public void select_the_current_date() throws AWTException {
        //CommonMethods.browserZoomIn();
        WaitMethods.pause(1);
        WebElement element = SCB_TC_NuggetElement.currentDateOption();
        SeleniumMethods.clickWithJs(element, "Select the current date");
        WaitMethods.pause(2);
        click_on_the_nugget_timecard_tab();
    }

    @When("^Add \"([^\"]*)\" on the journal hours field$")
    public void add_on_the_journal_hours_field(String hours) {
        WaitMethods.pause(1);
        journalHours = hours;
        SeleniumMethods.clearTheField(SCB_TC_NuggetElement.hoursField(), "Clear the journal hours field");
        SeleniumMethods.sendKey(SCB_TC_NuggetElement.hoursField(), hours, "Add on the journal hours field");
    }

    @When("^Enter \"([^\"]*)\" the journal notes$")
    public void Enter_the_journal_notes(String notes) {
        journalNotes = notes;
        SeleniumMethods.clearTheField(SCB_TC_NuggetElement.notesField(), "Clear the journal note field");
        SeleniumMethods.sendKey(SCB_TC_NuggetElement.notesField(), notes, "Enter the journal notes");
    }

    @Then("^Click on the submit journal button$")
    public void click_on_the_submit_journal_button() {
        SeleniumMethods.click(SCB_TC_NuggetElement.submitJournalButton(), "Click on the submit journal button");
    }

    @Then("^Click on the OK button$")
    public void click_on_the_OK_button() {
        SeleniumMethods.click(SCB_TC_NuggetElement.okButton(), "Click on the OK button");
    }

    @Then("^Validate the added journal details is displayed on the journal log list$")
    public void validate_the_added_journal_details_is_displayed_on_the_journal_log_list() {
        String currentDate = CommonMethods.getCurrentDateTime("MM/dd/yyyy");
        List<WebElement> date = SCB_TC_NuggetElement.journalDateList();
        List<WebElement> hoursList = SCB_TC_NuggetElement.journalHoursList();
        List<WebElement> journalNotesList = SCB_TC_NuggetElement.journalNotesList();

        int i = 0;
        for (WebElement el : date) {
            if (el.getText().equals(currentDate)) {
                AssertMethods.elementTextIsEqualTo(el, currentDate, "Validate that the logged journal date is " + currentDate);
                AssertMethods.elementTextIsEqualTo(hoursList.get(i), "0" + journalHours + ":00", "Validate that the logged journal time is " + hoursList.get(i).getText());
                AssertMethods.elementTextIsEqualTo(journalNotesList.get(i), journalNotes, "Validate that the logged journal notes is " + journalNotes);
                break;
            }
            i++;
        }
    }

    @When("^Get the resource name$")
    public void get_the_resource_name() {
        WaitMethods.pause(2);
        resourceName = SCB_TC_NuggetElement.resourceName().getText();
        CommonMethods.logInfo("Get the resource name: " + resourceName);
    }

    @Then("^Click on the recently added resource journal's nugget$")
    public void click_on_the_recently_added_resource_journal_nugget() {
        List<WebElement> resourceList = SCB_TC_NuggetElement.resourceNameList();
        int i = 0;
        for (WebElement element : SCB_TC_NuggetElement.nameList()) {
            if (element.getText().equals(Nugget.nuggetName) && resourceList.get(i).getText().equals(resourceName)) {
                SeleniumMethods.click(element, "Click on the recently added resource journal's nugget");
                break;
            }
            i++;
        }
    }

    @When("^Click on the completed sub tab$")
    public void Click_on_the_Completed_sub_tab() throws AWTException {
        SeleniumMethods.scrollToElementHorizontal(DashboardElement.scrollElement(), 5);
        CommonMethods.browserZoomIn();
        CommonMethods.browserZoomIn();
        for (WebElement element : SCB_TC_NuggetElement.listOfSubTab()) {
            if (element.getText().equals("Completed")) {
                SeleniumMethods.clickWithJs(element, "Click on the Completed sub tab");
                break;
            }
        }
        WaitMethods.pause(2);
    }

    @Then("^Validate that the completed resource is displayed on the selected nugget resource column$")
    public void Validate_that_the_completed_resource_is_displayed_on_the_selected_nugget_resource_column() {
        AssertMethods.elementTextIsEqualTo(SCB_TC_NuggetElement.userName(Nugget.nuggetName).get(0), resourceName, "Validate that the completed resource is displayed on the selected nugget resource column");

    }

    @When("^Approve the selected nugget$")
    public void approve_the_selected_nugget() {
        SeleniumMethods.scrollToElementHorizontal(DashboardElement.scrollElement(), 5);
        int i = 0;
        for (WebElement element : SCB_TC_NuggetElement.userName(Nugget.nuggetName)) {
            if (element.getText().equals(resourceName)) {
                SeleniumMethods.clickWithJs(SCB_TC_NuggetElement.approveCheckBox(Nugget.nuggetName).get(i), "Click on the Approve check box");
                break;
            }
            i++;
        }
        WaitMethods.pause(2);
        SeleniumMethods.clickWithJs(SprintElement.saveAssignSprintIcon(), "Click on the save icon");
        WaitMethods.pause(2);
    }

    @Then("^Validate that the selected nugget is removed from the list$")
    public void Validate_that_the_selected_nugget_is_removed_from_list() {
        String name = "";
        for (WebElement element : SCB_TC_NuggetElement.nameList()) {
            if (element.getText().equals(Nugget.nuggetName)) {
                name = element.getText();
                break;
            }
        }
        AssertMethods.elementTextHasText(name, "", "Validate that the created nugget is removed from triage list");
    }

    @Then("^Click on the recently completed nugget of resource$")
    public void click_on_the_recently_completed_nugget_of_resource() {
        List<WebElement> resourceList = SCB_TC_NuggetElement.userName(Nugget.nuggetName);
        int i = 0;
        for (WebElement element : SCB_TC_NuggetElement.nameList()) {
            if (element.getText().equals(Nugget.nuggetName) && resourceList.get(i).getText().equals(resourceName)) {
                SeleniumMethods.click(element, "Click on the recently completed nugget of resource");
                break;
            }
            i++;
        }
    }

    @Then("^Validate that the completed nugget's status is \"([^\"]*)\"$")
    public void Validate_that_the_completed_nuggets_status(String status) {
        AssertMethods.elementTextIsEqualTo(SCB_TC_NuggetElement.completedNugetStatus(Nugget.nuggetName), status, "Validate that the completed nugget's status is " + status + "");
    }

    @Then("^Validate that the completed nugget's \"([^\"]*)\" phase status is \"([^\"]*)\"$")
    public void Validate_that_the_completed_nuggets_phase_status(String phase, String status) {
        if (phase.equalsIgnoreCase("first")) {
            AssertMethods.elementTextIsEqualTo(SCB_TC_NuggetElement.nugetStatus(Nugget.nuggetName, phaseList.get(1).toString()), status, "Validate that the completed nugget's status is " + status + "");
        }
        else {
            AssertMethods.elementTextIsEqualTo(SCB_TC_NuggetElement.nugetStatus(Nugget.nuggetName, phaseList.get(2).toString()), status, "Validate that the completed nugget's status is " + status + "");
        }
    }

    @Then("^Click on the 'Mark As Complete' checkBox$")
    public void click_on_the_Mark_As_Complete_checkBox() {
        SeleniumMethods.click(SCB_TC_NuggetElement.markAsCompleteCheckBox(), "Click on the 'Mark As Complete' checkBox");
    }

    @Then("^Validate that the message on the open confirmation dialog box$")
    public void Validate_that_the_message_on_the_open_confirmation_dialog_box() {
        AssertMethods.elementTextIsEqualTo(SCB_TC_NuggetElement.dialogBoxText(), "Do you want this Nugget marked as complete and moved to the completed tab?", "Validate that the message on the open confirmation dialog box");
    }

    @Then("^Click on the submit button$")
    public void click_on_the_submit_button() {
        WaitMethods.pause(1);
        SeleniumMethods.click(SCB_TC_NuggetElement.submitButton(), "Click on the submit button");
    }

    @When("Click on the created nugget's sprint dropdown")
    public void click_on_the_created_nuggets_sprint_dropdown() {
        SeleniumMethods.clickWithJs(SprintElement.nuggetSprintDropdown(Nugget.nuggetName), "Click on the created nugget's sprint dropdown");
    }

    @When("Add nugget name on the list")
    public void add_Nugget_On_The_List() {
        nuggetList.add(Nugget.nuggetName);
    }

    @When("^Click on save icon$")
    public void click_on_the_save_icon() {
        SeleniumMethods.clickWithJs(SprintElement.saveAssignSprintIcon(), "Click on save icon");
        WaitMethods.pause(2);
    }

    @Then("^Validate that the created sprint is displayed on active sprint list$")
    public void Validate_the_created_sprint_is_displayed_on_active_sprint_list() {
        String name = "";
        for (WebElement el : SCB_TC_NuggetElement.nameList()) {
            if (el.getText().equals(projectName + ": " + Sprint.sprintName)) {
                name = el.getText();
                break;
            }
        }
        AssertMethods.elementTextHasText(name, projectName + ": " + Sprint.sprintName, "Validate that the created sprint is displayed on active sprint list");
    }

    @When("^Select the current release date$")
    public void select_the_current_release_date() {
        WaitMethods.pause(2);
        SeleniumMethods.click(ReleasesElement.releaseDateField(), "Click on the release date picker");
        SeleniumMethods.click(SCB_TC_NuggetElement.currentDateOption(), "Select the current date");
        WaitMethods.pause(2);

    }

    @When("^select the current release cutoff date$")
    public void select_the_current_release_cutoff_date() {
        WaitMethods.pause(2);
        SeleniumMethods.click(ReleasesElement.releaseCutoffDateField(), "Click on the release cutoff date picker");
        SeleniumMethods.click(SCB_TC_NuggetElement.currentDateOption(), "Select the current date");
        WaitMethods.pause(2);
    }

    @When("^Select the \"([^\"]*)\" release maestro from dropdown$")
    public void select_release_maestro_from_dropdown(String user) {
        SeleniumMethods.click(ReleasesElement.releaseMaestroDropdown(), "Click on release maestro dropdown");
        for (WebElement el : DashboardElement.projectMaestroList()) {
            if (el.getText().equals(user)) {
                SeleniumMethods.click(el, "Select the " + user + " release maestro from dropdown");
                break;
            }
        }
    }

    @When("^Select the \"([^\"]*)\" secondary maestro from dropdown$")
    public void select_secondary_maestro_from_dropdown(String user) {
        SeleniumMethods.click(ReleasesElement.secondaryMaestroDropdown(), "Click on secondary maestro dropdown");
        for (WebElement el : DashboardElement.projectMaestroList()) {
            if (el.getText().equals(user)) {
                SeleniumMethods.click(el, "Select the " + user + " secondary maestro from dropdown");
                break;
            }
        }
    }

    @When("^Click on the created sprint$")
    public void click_on_the_created_sprint() {
        WebElement element = null;
        for (WebElement el : SCB_TC_NuggetElement.nameList()) {
            if (el.getText().equals(projectName + ": " + Sprint.sprintName)) {
                element = el;
                break;
            }
        }
        SeleniumMethods.click(element, "Click on the created sprint");

    }

    @When("Click on the sprint details tab")
    public void Click_on_the_sprint_details_tab() {
        SeleniumMethods.click(DashboardElement.detailsTabIcon(), "Click on the sprint details tab");
    }

    @When("^Select the created release to the sprint$")
    public void select_the_created_release_to_the_sprint() {
        WebElement el = null;
        SeleniumMethods.click(SCB_TC_NuggetElement.releaseDropDown(), "Click on the release dropdown");
        for (WebElement element : Setting_UserProfileElement.dropdownOptionList()) {
            if (element.getText().equals(Releases.releaseName)) {
                el = element;
                break;
            }
        }
        SeleniumMethods.click(el, "Select the created release");
        WaitMethods.pause(1);
    }

    @Then("^Validate that the assigned release name is displayed on selected sprint's release column$")
    public void Validate_that_the_assigned_release_name_is_displayed_on_selected_sprints_release_column() {
        WaitMethods.pause(3);
        AssertMethods.elementTextIsEqualTo(SCB_TC_NuggetElement.tableColumnText(projectName + ": " + Sprint.sprintName, "4"), Releases.releaseName, "Validate that the assigned release name is displayed on selected sprint's release column");
    }

    @Then("^Validate that the assigned release date is displayed on selected sprint's release date column$")
    public void Validate_that_the_assigned_release_date_is_displayed_on_selected_sprints_release_date_column() {
        AssertMethods.elementTextIsEqualTo(SCB_TC_NuggetElement.tableColumnTextOfSpan(projectName + ": " + Sprint.sprintName, "5"), CommonMethods.getCurrentDateTime("MM/dd/yyyy"), "Validate that the assigned release name is displayed on selected sprint's release column");
    }

    @Then("^Validate that the assigned release cutoff date is displayed on selected sprint's release cutoff date column$")
    public void Validate_that_the_assigned_release_cutoff_date_is_displayed_on_selected_sprints_release_date_column() {
        AssertMethods.elementTextIsEqualTo(SCB_TC_NuggetElement.tableColumnTextOfSpan(projectName + ": " + Sprint.sprintName, "6"), CommonMethods.getCurrentDateTime("MM/dd/yyyy"), "Validate that the assigned release name is displayed on selected sprint's release column");
    }

    @Then("^Validate that the assigned release name is removed from the selected sprint's release column$")
    public void Validate_that_the_assigned_release_name_is_removed_from_the_selected_sprints_release_column() {
        WaitMethods.pause(3);
        AssertMethods.elementTextIsEqualTo(SCB_TC_NuggetElement.tableColumnText(projectName + ": " + Sprint.sprintName, "4"), "", "Validate that the assigned release name is displayed on selected sprint's release column");
    }

    @Then("^Validate that the assigned release date is removed from the selected sprint's release date column$")
    public void Validate_that_the_assigned_release_date_is_removed_from_the_selected_sprints_release_date_column() {
        AssertMethods.elementTextIsEqualTo(SCB_TC_NuggetElement.tableColumnTextOfSpan(projectName + ": " + Sprint.sprintName, "5"), "", "Validate that the assigned release name is displayed on selected sprint's release column");
    }

    @Then("^Validate that the assigned release cutoff date is removed from the selected sprint's release cutoff date column$")
    public void Validate_that_the_assigned_release_cutoff_date_is_removed_from_the_selected_sprints_release_date_column() {
        AssertMethods.elementTextIsEqualTo(SCB_TC_NuggetElement.tableColumnTextOfSpan(projectName + ": " + Sprint.sprintName, "6"), "", "Validate that the assigned release name is displayed on selected sprint's release column");
    }

    @Then("^Validate that the \"([^\"]*)\" assigned phase name is displayed on the nugget$")
    public void Validate_that_the_assigned_phase_name_is_displayed_on_the_nugget(String phase) {
        WaitMethods.pause(2);
        String phaseName = "";
        if (phase.equalsIgnoreCase("first")) {
            phaseName = phaseList.get(1).toString();
        } else {
            phaseName = phaseList.get(2).toString();
        }
        AssertMethods.elementTextIsEqualTo(SCB_TC_NuggetElement.tableColumnText(Nugget.nuggetName, "5"), phaseName, "Validate that the " + phase + " assigned phase name is displayed on the nugget");
    }

    @Then("^Validate that the all assigned phase nugget is displayed on the list$")
    public void Validate_that_the_all_assigned_phase_nugget_is_displayed_on_the_list() {
        for (Object phase : phaseList) {
            String name = "";
            for (WebElement el : SCB_TC_NuggetElement.tableColumnTextList(Nugget.nuggetName, "9")) {
                if (el.getText().equals(phase.toString())) {
                    name = el.getText();
                }
            }
            AssertMethods.elementTextHasText(phase.toString(), name, "Validate that the " + phase + " assigned phase name is displayed on the nugget");
        }

    }

    @Then("^Validate that the remove icon is not appears on the \"([^\"]*)\" team lead resource$")
    public void Validate_that_the_remove_icon_is_not_appears_on_team_lead_resource(String resource) {
        AssertMethods.elementIsNotDisplayed(SCB_TC_NuggetElement.removeIconNotVisible(resource), "Validate that the remove icon is not appears on the " + resource + " team lead resource");
    }

    @When("Click on the first phase nugget")
    public void Click_on_the_first_phase_nugget() {
        SeleniumMethods.click(SCB_TC_NuggetElement.tableRow(Nugget.nuggetName, "9", phaseList.get(1).toString()), "Click on the first phase nugget");
    }

    @When("Click on the second phase nugget")
    public void Click_on_the_second_phase_nugget() {
        SeleniumMethods.click(SCB_TC_NuggetElement.tableRow(Nugget.nuggetName, "9", phaseList.get(2).toString()), "Click on the second phase nugget");
    }

    @When("Click on the \"([^\"]*)\" phase nugget")
    public void Click_on_the_phase_nugget(String phase) {
        if (phase.equalsIgnoreCase("first")) {
            SeleniumMethods.click(SCB_TC_NuggetElement.tableRow(Nugget.nuggetName, "9", phaseList.get(1).toString()), "Click on the first phase nugget");
        } else {
            SeleniumMethods.click(SCB_TC_NuggetElement.tableRow(Nugget.nuggetName, "9", phaseList.get(2).toString()), "Click on the second phase nugget");
        }
    }

    @Then("^Validate that the all added phase of nugget name is displayed on the nugget list$")
    public void Validate_that_the_all_added_phase_of_nugget_is_displayed_on_the_nugget_list() {
        AssertMethods.elementIsDisplayed(SCB_TC_NuggetElement.tableRow(Nugget.nuggetName, "8", phaseList.get(1).toString()), "Validate that the added phase of nugget name is displayed on the nugget list");
        AssertMethods.elementIsDisplayed(SCB_TC_NuggetElement.tableRow(Nugget.nuggetName, "8", phaseList.get(2).toString()), "Validate that the added phase of nugget name is displayed on the nugget list");
    }

    @Then("^Validate that the \"([^\"]*)\" completed phase of nugget name is displayed on the nugget list$")
    public void Validate_that_the_all_completed_phase_of_nugget_is_displayed_on_the_nugget_list(String phase) {
        if (phase.equalsIgnoreCase("first")) {
            AssertMethods.elementIsDisplayed(SCB_TC_NuggetElement.tableRow(Nugget.nuggetName, "11", phaseList.get(1).toString()), "Validate that the " + phase + " completed phase of nugget name is displayed on the nugget list");
        } else {
            AssertMethods.elementIsDisplayed(SCB_TC_NuggetElement.tableRow(Nugget.nuggetName, "11", phaseList.get(2).toString()), "Validate that the " + phase + " completed phase of nugget name is displayed on the nugget list");
        }
    }

    @Then("^Click on the recently added \"([^\"]*)\" phase resource journal's nugget$")
    public void click_on_the_recently_added_phase_resource_journal_nugget(String phase) {
        if (phase.equalsIgnoreCase("first")) {
            SeleniumMethods.click(SCB_TC_NuggetElement.tableRow(Nugget.nuggetName, "8", phaseList.get(1).toString()), "Click on the recently added " + phase + " phase resource journal's nugget");
        } else {
            SeleniumMethods.click(SCB_TC_NuggetElement.tableRow(Nugget.nuggetName, "8", phaseList.get(1).toString()), "Click on the recently added " + phase + " phase resource journal's nugget");
            SeleniumMethods.click(SCB_TC_NuggetElement.tableRow(Nugget.nuggetName, "8", phaseList.get(2).toString()), "Click on the recently added " + phase + " phase resource journal's nugget");
        }
    }


    @Then("^Click on the \"([^\"]*)\" phase$")
    public void click_on_the_phase(String phase) {
        List<WebElement> elementList = SCB_TC_NuggetElement.listOfPhases();
        if (phase.equalsIgnoreCase("first")) {
            SeleniumMethods.click(elementList.get(1), "Click on the " + phase + " phase");
        } else {
            SeleniumMethods.clickWithJs(elementList.get(2), "Click on the " + phase + " phase");
        }

        WaitMethods.pause(1);
    }

    @When("^Approve the \"([^\"]*)\" phase of nugget$")
    public void approve_the_selected_nugget(String phase) {
        WaitMethods.pause(2);
        SeleniumMethods.scrollToElementHorizontal(DashboardElement.scrollElement(), 5);
        if (phase.equalsIgnoreCase("first")) {
            SeleniumMethods.clickWithJs(SCB_TC_NuggetElement.approveCheckBox(Nugget.nuggetName, "11", phaseList.get(1).toString(), "7"), "Click on the recently completed " + phase + " phase's approve check box");
        } else {
            //SeleniumMethods.clickWithJs(SCB_TC_NuggetElement.approveCheckBox(Nugget.nuggetName, "11",phaseList.get(1).toString(),"7"), "Click on the recently completed " + phase + " phase's approve check box");
            SeleniumMethods.clickWithJs(SCB_TC_NuggetElement.approveCheckBox(Nugget.nuggetName, "11", phaseList.get(2).toString(), "7"), "Click on the recently completed " + phase + " phase's approve check box");
        }
        WaitMethods.pause(2);
        SeleniumMethods.clickWithJs(SprintElement.saveAssignSprintIcon(), "Click on the save icon");
        WaitMethods.pause(3);
    }

    @Then("^Validate that the approved \"([^\"]*)\" phase nugget is removed from the list$")
    public void Validate_that_the_selected_nugget_is_removed_from_list(String phase) {
        boolean isNuggetPhase = true;
        for (WebElement element : SCB_TC_NuggetElement.tableColumnTextList(Nugget.nuggetName, "11")) {
            if (phase.equalsIgnoreCase("first")) {
                if (element.getText().equals(phaseList.get(1).toString())) {
                    isNuggetPhase = false;
                    break;
                }
            } else {
                if (element.getText().equals(phaseList.get(2).toString())) {
                    isNuggetPhase = false;
                    break;
                }
            }
        }
        AssertMethods.isTrue(isNuggetPhase, "Validate that the approved " + phase + " phase nugget is removed from the list");
    }

    @Then("^Validate that the approved \"([^\"]*)\" nugget is removed from the list$")
    public void Validate_that_the_approved_nugget_is_removed_from_list(String phase) {
        boolean isNuggetPhase = true;
        for (WebElement element : SCB_TC_NuggetElement.tableColumnTextList(Nugget.nuggetName, "10")) {
            if (phase.equalsIgnoreCase("first")) {
                if (element.getText().equals(phaseList.get(1).toString())) {
                    isNuggetPhase = false;
                    break;
                }
            } else {
                if (element.getText().equals(phaseList.get(2).toString())) {
                    isNuggetPhase = false;
                    break;
                }
            }
        }
        AssertMethods.isTrue(isNuggetPhase, "Validate that the approved " + phase + " phase nugget is removed from the list");
    }

    @When("^Approve the \"([^\"]*)\" phase of the nugget$")
    public void approve_the_selected_phase_nugget(String phase) {
        WaitMethods.pause(2);
        SeleniumMethods.scrollToElementHorizontal(DashboardElement.scrollElement(), 5);
        if (phase.equalsIgnoreCase("first")) {
            SeleniumMethods.clickWithJs(SCB_TC_NuggetElement.approveNuggetCheckBox(Nugget.nuggetName, "10", phaseList.get(1).toString()), "Click on the recently completed " + phase + " phase's approve check box");
        } else {
            SeleniumMethods.clickWithJs(SCB_TC_NuggetElement.approveNuggetCheckBox(Nugget.nuggetName, "10", phaseList.get(2).toString()), "Click on the recently completed " + phase + " phase's approve check box");
        }
        WaitMethods.pause(2);
        SeleniumMethods.clickWithJs(SprintElement.saveAssignSprintIcon(), "Click on the save icon");
        WaitMethods.pause(2);
    }

    @When("^Add Need To Work the \"([^\"]*)\" phase of nugget$")
    public void add_Need_To_Work_the_selected_nugget(String phase) {
        WaitMethods.pause(2);
        SeleniumMethods.scrollToElementHorizontal(DashboardElement.scrollElement(), 5);
        if (phase.equalsIgnoreCase("first")) {
            SeleniumMethods.clickWithJs(SCB_TC_NuggetElement.approveCheckBox(Nugget.nuggetName, "11", phaseList.get(1).toString(), "8"), "Click on the recently completed " + phase + " phase's approve check box");
        } else {
            SeleniumMethods.clickWithJs(SCB_TC_NuggetElement.approveCheckBox(Nugget.nuggetName, "11", phaseList.get(2).toString(), "8"), "Click on the recently completed " + phase + " phase's approve check box");
        }
        WaitMethods.pause(2);
        SeleniumMethods.clickWithJs(SprintElement.saveAssignSprintIcon(), "Click on the save icon");
        WaitMethods.pause(3);
    }

    @Then("^Validate that the \"([^\"]*)\" user status is updated with Need To Work on the workflow resource list$")
    public void Validate_that_the_user_status_is_updated_with_Need_To_Work_on_the_workflow_resource_list(String name) {
        WaitMethods.pause(1);
        AssertMethods.elementTextIsEqualTo(SCB_TC_NuggetElement.resourceStatus(name), "Need-work", "Validate that the " + name + " user status is updated with Need To Work on the workflow resource list");
    }

    @When("^Add Need To Work the \"([^\"]*)\" phase of the nugget$")
    public void add_Need_To_Work_the_selected_phase_nugget(String phase) {
        WaitMethods.pause(2);
        SeleniumMethods.scrollToElementHorizontal(DashboardElement.scrollElement(), 5);
        if (phase.equalsIgnoreCase("first")) {
            SeleniumMethods.clickWithJs(SCB_TC_NuggetElement.approveCheckBox(Nugget.nuggetName, "10", phaseList.get(1).toString(), "7"), "Click on the recently completed " + phase + " phase's approve check box");
        } else {
            SeleniumMethods.clickWithJs(SCB_TC_NuggetElement.approveCheckBox(Nugget.nuggetName, "10", phaseList.get(2).toString(), "7"), "Click on the recently completed " + phase + " phase's approve check box");
        }
        WaitMethods.pause(2);
        SeleniumMethods.clickWithJs(SprintElement.saveAssignSprintIcon(), "Click on the save icon");
        WaitMethods.pause(2);
    }

    @When("^Double click on the created sprint$")
    public void double_click_on_the_created_sprint() {
        WebElement element = null;
        for (WebElement el : SCB_TC_NuggetElement.nameList()) {
            if (el.getText().equals(projectName + ": " + Sprint.sprintName)) {
                element = el;
                break;
            }
        }
        Actions actions = new Actions(ServiceHook.driver);
        actions.doubleClick(element).perform();
        CommonMethods.logInfo("Double click on the created sprint");

    }

    @Then("^Validate that the list on sprint's nugget is displayed$")
    public void Validate_that_the_list_on_sprints_nugget_is_displayed() {
        boolean isNuggetList = false;
        AssertMethods.elementListSizeIsSame(NuggetElement.nuggetNameList(), nuggetList.size(), "Validate that the list on sprint's nugget and created nugget list size is same");
        for (Object nugget : nuggetList) {
            isNuggetList = false;
            for (WebElement el : NuggetElement.nuggetNameList()) {
                if (el.getText().equals(nugget.toString())) {
                    isNuggetList = true;
                    break;
                }
            }
            if (!isNuggetList) {
                break;
            }
        }
        AssertMethods.isTrue(isNuggetList, "Validate that the list on sprint's nugget is displayed");
    }

    @Then("^Click on the created release from list$")
    public void click_on_the_created_release_from_list() {
        WaitMethods.pause(1);
        SeleniumMethods.click(ReleasesElement.createdReleaseName(Releases.releaseName), "Click on the created release from list");
    }

    @Then("^Click on the complete check box$")
    public void click_on_the_complete_check_box() {
        SeleniumMethods.click(ReleasesElement.completeCheckBox(), "Click on the complete check box");
    }

    @Then("^Validate that the completed release is removed from the list$")
    public void Validate_the_created_release_is_removed_from_the_List() {
        WaitMethods.pause(2);
        AssertMethods.elementIsNotDisplayed(ReleasesElement.createdReleaseName(Releases.releaseName), "Validate that the completed release is removed from the list");
    }

    @Then("^Validate that the completed release is displayed on the released list$")
    public void validate_that_the_completed_release_is_displayed_on_the_released_list() {
        boolean isReleased = false;
        for (int i = 0; i <= 20; i++) {
            List<WebElement> elementList = SCB_TC_NuggetElement.nameList();
            for (WebElement element : elementList) {
                if (element.getText().equals(Releases.releaseName)) {
                    isReleased = true;
                    break;
                }
            }
            if (isReleased) {
                break;
            }
            SeleniumMethods.scrollToElement(elementList.get(elementList.size() - 2));
            WaitMethods.pause(3);
        }
        AssertMethods.isTrue(isReleased, "Validate that the completed release is displayed on the released list");
    }

    @Then("^Validate that the released sprint is displayed on released sprint list and sprint's tempo is \"([^\"]*)\"$")
    public void Validate_the_released_sprint_is_displayed_on_released_sprint_list(String tempo) {
        String name = "";
        for (int i = 0; i <= 20; i++) {
            List<WebElement> elementList = SCB_TC_NuggetElement.nameList();
            for (WebElement el : elementList) {
                if (el.getText().equals(projectName + ": " + Sprint.sprintName)) {
                    name = el.getText();
                    AssertMethods.elementTextIsEqualTo(SCB_TC_NuggetElement.tableColumnText(el.getText(), "3"), tempo, "Validate that the nugget's tempo is " + tempo);
                    break;
                }
            }
            if (!Objects.equals(name, "")) {
                break;
            }
            SeleniumMethods.scrollToElement(elementList.get(elementList.size() - 2));
            WaitMethods.pause(3);
        }
        AssertMethods.elementTextHasText(name, projectName + ": " + Sprint.sprintName, "Validate that the released sprint is displayed on released sprint list and sprint's tempo is "+tempo);
    }


    @Then("^Validate that the released nugget is displayed on released nugget list and nugget's tempo is \"([^\"]*)\"$")
    public void Validate_that_the_released_nugget_is_displayed_on_released_nugget_list(String tempo) {
        boolean isNuggetList = false;
        for (Object nugget : nuggetList) {
            isNuggetList = false;
            for (int i = 0; i <= 20; i++) {
                List<WebElement> elementList = NuggetElement.nuggetNameList();
                for (WebElement el : elementList) {
                    if (el.getText().equals(nugget.toString())) {
                        isNuggetList = true;
                        CommonMethods.logInfo("Validate that the released nugget " + el.getText() + " is displayed ");
                        AssertMethods.elementTextIsEqualTo(SCB_TC_NuggetElement.tableColumnText(el.getText(), "4"), tempo, "Validate that the nugget's tempo is " + tempo);
                        break;
                    }
                }
                if (isNuggetList) {
                    break;
                }
                SeleniumMethods.scrollToElement(elementList.get(elementList.size() - 2));
                WaitMethods.pause(3);
            }
            if (!isNuggetList) {
                break;
            }
        }
        AssertMethods.isTrue(isNuggetList, "Validate that the released nugget is displayed on released nugget list and nugget's tempo is "+tempo);
    }

    @Then("^Validate that the created nugget is removed from assignment's completed nugget list$")
    public void Validate_that_the_created_nugget_is_removed_from_assignments_completed_nugget_list() {
        String name = "";
        for (Object nugget : nuggetList) {
            for (int i = 0; i <= 20; i++) {
                List<WebElement> elementList = SCB_TC_NuggetElement.nameList();
                for (WebElement element : elementList) {
                    if (element.getText().equals(nugget.toString())) {
                        name = element.getText();
                        break;
                    }
                }
                if (!Objects.equals(name, "")) {
                    break;
                }
                SeleniumMethods.scrollToElement(elementList.get(elementList.size() - 2));
                WaitMethods.pause(3);
            }
        }
        AssertMethods.elementTextHasText(name, "", "Validate that the created nugget is removed from assignment's completed nugget list");
    }

    @Then("^Validate that the released sprint is displayed on sprint dropdown list$")
    public void Validate_the_released_sprint_is_displayed_on_sprint_list() {
        AssertMethods.elementIsNotDisplayed(SprintElement.sprintNameNotVisible(Sprint.sprintName), "Validate that the released sprint is displayed on sprint dropdown list");
    }

    @When("^Get the created nugget id from list$")
    public void get_the_Created_nugget_id_from_list() {
        WaitMethods.pause(1);
        Nugget.nuggetId= SCB_TC_NuggetElement.tableColumnText(Nugget.nuggetName,"1").getText();
    }

    @Then("^Validate that the chat has displayed archive nugget audit message$")
    public void validate_that_the_chat_has_displayed_archive_nugget_audit_message() {
        AssertMethods.elementTextIsEqualTo(NuggetElement.auditMessage("Moved to Archive permanently"),"Moved to Archive permanently", "Validate that the chat has displayed archive nugget audit message");
    }

    @Then("^Validate that the chat has displayed \"([^\"]*)\" audit message$")
    public void validate_that_the_chat_has_displayed_nugget_audit_message(String message) {
        WaitMethods.pause(1);
        AssertMethods.elementTextIsEqualTo(NuggetElement.auditMessage(message),message, "Validate that the chat has displayed "+message+" audit message");
    }


}
