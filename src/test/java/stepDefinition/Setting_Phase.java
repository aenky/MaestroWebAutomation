package stepDefinition;

import CommonUtility.AssertMethods;
import CommonUtility.CommonMethods;
import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import pom.*;

import java.util.List;

public class Setting_Phase {

    public static String name = "";


    @When("^Click on the phases option$")
    public void click_on_the_phases_option() {
        SeleniumMethods.click(Setting_PhaseElement.phasesOption(), "Click on the phases option");
    }

    @Then("^Validate that the new phase button is displayed$")
    public void validate_that_the_new_phase_button_is_displayed() {
        AssertMethods.elementIsDisplayed(Setting_PhaseElement.newPhaseButton(), "Validate that the new phase button is displayed");
    }

    @When("^Click on the new phase button$")
    public void click_on_the_new_phase_button() {
        SeleniumMethods.click(Setting_PhaseElement.newPhaseButton(), "Click on the new phase button");
    }

    @Then("^Validate that the create new phase dialog box heading is displayed$")
    public void validate_the_create_new_phase_dialog_box_heading_is_displayed() {
        AssertMethods.elementTextIsEqualTo(Setting_CalendarElement.dialogBoxHeading(), "Create New Phase", "Validate that the create new phase dialog box heading is displayed");
    }

    @Then("^Validate that the create new phase dialog box is closed$")
    public void validate_that_the_create_new_channel_dialog_box_is_closed() {
        WaitMethods.pause(1);
        boolean isSprintDialogBoxClosed = true;
        try {
            if (Setting_CalendarElement.theDialogBoxHeading().isDisplayed()) {
                isSprintDialogBoxClosed = false;
            }
        } catch (Exception e) {
        }
        AssertMethods.isTrue(isSprintDialogBoxClosed, "Validate that the create new phase dialog box is closed");
    }

    @Then("^Enter \"([^\"]*)\" on the phase name text box$")
    public void enter_name_on_phase_text_box(String departmentName) {
        String timeStamp = " " + CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        name = departmentName + timeStamp;
        SeleniumMethods.sendKey(DashboardElement.editProjectName(), name, "Enter " + name + " on phase name text box");
    }

    @Then("^Validate that the created phase name is displayed on the list and highlighted$")
    public void validate_the_created_phase_is_highlighted_on_the_list() {
        for (WebElement element : Setting_CalendarElement.eventNameList()) {
            if (element.getText().equals(name)) {
                AssertMethods.elementTextIsEqualTo(element, name, "Validate that the created phase name is listed");
                WaitMethods.pause(2);
                //AssertMethods.elementTextIsEndWith(Setting_CalendarElement.eventList().get(0).getAttribute("class"), "active", "Validate the created phase is displayed on the list and highlighted");
                break;
            }
        }
    }

    @When("^Deactivate the created phase$")
    public void deactivate_the_created_channel() {
        for (WebElement element : Setting_CalendarElement.eventNameList()) {
            if (element.getText().equals(name)) {
                SeleniumMethods.click(element, "Click on the created phase");
                break;
            }
        }
        SeleniumMethods.click(Setting_PhaseElement.deactivatePhaseCheckBox(), "Click on the deactivate phase check box");
        WaitMethods.pause(1);
        SeleniumMethods.click(DashboardElement.saveButton(), "Click on the save button");
        WaitMethods.pause(2);

    }

    @When("^Select the associated skill from dropdown$")
    public void select_associated_skill_from_dropdown() {
        SeleniumMethods.click(Setting_PhaseElement.associatedSkillDropdown(2), "Click on associated skill dropdown");
        SeleniumMethods.click(Setting_UserProfileElement.dropdownOptionList().get(0), "Select the first associated skill from dropdown");
    }

    @And("Click on the created phase from list")
    public void Click_on_the_created_phase_from_list() {
        for (WebElement element : DashboardElement.projectList()) {
            if (element.getText().equals(name)) {
                SeleniumMethods.click(element, "Click on the created phase from list");
            }
        }
    }

    @Then("^Update \"([^\"]*)\" the phase name$")
    public void update_the_phase_name(String phaseName) {
        String timeStamp = CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        name = phaseName + " " + timeStamp;
        SeleniumMethods.clearTheField(Setting_PhaseElement.phaseNameTextBox(), "Clear input field");
        WaitMethods.pause(1);
        SeleniumMethods.sendKey(Setting_PhaseElement.phaseNameTextBox(), name, "Update the " + name + " on phase name");
    }

    @Then("^Validate that the length validation message is displayed$")
    public void validate_the_length_validation_message_is_displayed() {
        AssertMethods.elementTextIsEqualTo(Setting_DepartmentsElement.validationMessageField("1"), "This field must be at most 50 characters long.", "Validate that the length validation message is displayed");
    }

    @When("^Update the associated skill from dropdown$")
    public void update_associated_skill_from_dropdown() {
        SeleniumMethods.click(Setting_PhaseElement.associatedSkillDropdown(1), "Click on associated skill dropdown");
        SeleniumMethods.click(Setting_UserProfileElement.dropdownOptionList().get(1), "Select the first associated skill from dropdown");
    }

    @Then("^Enter phase name which is already existing on the list$")
    public void enter_phase_name_which_is_already_existing_on_the_list() {
        SeleniumMethods.sendKey(DashboardElement.editProjectName(), name, "Enter phase name which is already existing on the list");
    }

    @And("Click on the deactivate phase check box")
    public void Click_on_the_deactivate_phase_check_box() {
        SeleniumMethods.click(Setting_PhaseElement.deactivatePhaseCheckBox(), "Click on the deactivate phase check box");
    }

    @Then("^Validate that the deactivate phase is displayed on the list$")
    public void validate_that_the_deactivate_phase_is_displayed_on_the_list() {
        boolean isDeactivate=false;
        for(int i=0;i<=20;i++) {
            List<WebElement> elementList=Setting_CalendarElement.eventNameList();
            for (WebElement element : elementList) {
                if (element.getText().equals(name)) {
                    isDeactivate = true;
                    break;
                }
            }
            if(isDeactivate){break;}
            SeleniumMethods.scrollToElement(elementList.get(elementList.size()-2));
            WaitMethods.pause(3);
        }
        AssertMethods.isTrue(isDeactivate,"Validate that the deactivate phase is displayed on the list");
    }

    @And("Click on the first phase from the list")
    public void Click_on_the_first_phase_from_list() {
        SeleniumMethods.click(DashboardElement.projectList().get(0), "Click on the first phase from the list");
    }

}
