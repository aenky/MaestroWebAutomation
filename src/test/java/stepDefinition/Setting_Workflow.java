package stepDefinition;

import CommonUtility.AssertMethods;
import CommonUtility.CommonMethods;
import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pom.*;

import java.awt.*;
import java.util.List;

public class Setting_Workflow {

    public static String name = "";
    public static String description = "";
    public static String selectedValue = "";

    @When("^Click on the workflows option$")
    public void click_on_the_workflows_option() {
        SeleniumMethods.click(Setting_WorkflowElement.workflowsOption(), "Click on the workflows option");
    }

    @Then("^Validate that the new workflow button is displayed$")
    public void validate_that_the_new_workflow_button_is_displayed() {
        AssertMethods.elementIsDisplayed(Setting_WorkflowElement.newWorkflowButton(), "Validate that the new workflow button is displayed");
    }

    @When("^Click on the new workflow button$")
    public void click_on_the_new_workflow_button() {
        SeleniumMethods.click(Setting_WorkflowElement.newWorkflowButton(), "Click on the new workflow button");
    }

    @Then("^Validate that the create new workflow dialog box heading is displayed$")
    public void validate_the_create_new_workflow_dialog_box_heading_is_displayed() {
        AssertMethods.elementTextIsEqualTo(Setting_CalendarElement.dialogBoxHeading(), "Create New Workflow", "Validate that the create new workflow dialog box heading is displayed");
    }

    @Then("^Validate that the create new workflow dialog box is closed$")
    public void validate_that_the_create_new_workflow_dialog_box_is_closed() {
        WaitMethods.pause(1);
        boolean isSprintDialogBoxClosed = true;
        try {
            if (Setting_CalendarElement.theDialogBoxHeading().isDisplayed()) {
                isSprintDialogBoxClosed = false;
            }
        } catch (Exception e) {
        }
        AssertMethods.isTrue(isSprintDialogBoxClosed, "Validate that the create new workflow dialog box is closed");
    }

    @Then("^Enter \"([^\"]*)\" on the workflow name text box$")
    public void enter_name_on_workflow_text_box(String workflowName) {
        String timeStamp = " " + CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        name = workflowName + timeStamp;
        SeleniumMethods.sendKey(DashboardElement.editProjectName(), name, "Enter " + name + " on workflow name text box");
    }

    @Then("^Validate that the created workflow name is displayed on the list and highlighted$")
    public void validate_the_created_workflow_is_displayed_and_highlighted_on_the_list() {
        for (WebElement element : Setting_CalendarElement.eventNameList()) {
            if (element.getText().equals(name)) {
                AssertMethods.elementTextIsEqualTo(element, name, "Validate that the created workflow name is listed");
                //WaitMethods.pause(2);
                //AssertMethods.elementTextIsEndWith(Setting_CalendarElement.eventList().get(0).getAttribute("class"), "active", "Validate the created phase is displayed on the list and highlighted");
                break;
            }
        }
    }

    @When("^Deactivate the created workflow$")
    public void deactivate_the_created_workflow() {
        for (WebElement element : Setting_CalendarElement.eventNameList()) {
            if (element.getText().equals(name)) {
                SeleniumMethods.click(element, "Click on the created workflow");
                break;
            }
        }
        SeleniumMethods.click(Setting_WorkflowElement.deactivateWorkflowCheckBox(), "Click on the deactivate workflow check box");
        WaitMethods.pause(1);
        SeleniumMethods.click(DashboardElement.saveButton(), "Click on the save button");
        WaitMethods.pause(2);
    }

    @And("Click on the created workflow from list")
    public void click_on_the_created_workflow_from_list() {
        for (WebElement element : Setting_CalendarElement.eventNameList()) {
            if (element.getText().equals(name)) {
                SeleniumMethods.click(element, "Click on the created workflow from list");
                break;
            }
        }
    }

    @Then("^Update \"([^\"]*)\" the workflow name$")
    public void update_the_workflow_name(String workflowName) {
        String timeStamp = CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        name = workflowName + " " + timeStamp;
        SeleniumMethods.clearTheField(Setting_WorkflowElement.editWorkflowNameField(), "Clear input field");
        WaitMethods.pause(1);
        SeleniumMethods.sendKey(Setting_WorkflowElement.editWorkflowNameField(), name, "Update the " + name + " on workflow name");
    }

    @And("Update \"([^\"]*)\" the workflow description")
    public void update_the_workflow_description(String text) {
        WebElement el = DashboardElement.editDescriptionTextBox();
        el.sendKeys(Keys.CONTROL + "A");
        el.sendKeys(Keys.DELETE);
        WaitMethods.pause(2);
        description = text;
        SeleniumMethods.sendKey(el, description, "Update the workflow description");
    }

    @Then("^Enter workflow name which is already existing on the list$")
    public void enter_workflow_name_which_is_already_existing_on_the_list() {
        SeleniumMethods.sendKey(DashboardElement.editProjectName(), name, "Enter workflow name which is already existing on the list");
    }

    @When("^Click on the add phase icon on the edit workflow section$")
    public void click_on_the_add_phase_icon_on_the_edit_workflow_section() {
        SeleniumMethods.click(Setting_WorkflowElement.addPhaseIcon(), "Click on the add phase icon on the edit workflow section");
    }

    @Then("^Validate that the add phase icon is displayed$")
    public void validate_the_add_phase_icon_is_displayed() {
        AssertMethods.elementIsDisplayed(Setting_WorkflowElement.addPhaseIcon(), "Validate that the add phase icon is displayed");
    }

    @Then("^Validate that the Add Phase To Workflow dialog box heading is displayed$")
    public void validate_the_Add_Phase_To_Workflow_dialog_box_is_displayed() {
        AssertMethods.elementTextIsEqualTo(Setting_CalendarElement.dialogBoxHeading(), "Add Phase To Workflow", "Validate that the Add Phase To Workflow dialog box heading is displayed");
    }

    @Then("^Validate that the Add Phase To Workflow dialog box is closed$")
    public void validate_that_the_Add_Phase_To_Workflow_dialog_box_is_closed() {
        WaitMethods.pause(1);
        boolean isDialogBoxClosed = true;
        try {
            if (Setting_CalendarElement.theDialogBoxHeading().isDisplayed()) {
                isDialogBoxClosed = false;
            }
        } catch (Exception e) {
        }
        AssertMethods.isTrue(isDialogBoxClosed, "Validate that the Add Phase To Workflow dialog box is closed");
    }

    @Then("^Validate that the add button is disabled$")
    public void Validate_the_add_button_is_disabled() {
        AssertMethods.elementAttributeValueIsEqualTo(Setting_WorkflowElement.addButton(), "disabled", "true", "Validate the create button is disabled");
    }

    @Then("^Validate that the add button is Enable$")
    public void Validate_the_add_button_is_Enable() {
        AssertMethods.elementIsEnabled(Setting_WorkflowElement.addButton(), "Validate the add button is Enable");
    }

    @When("^Select the phase from the dropdown$")
    public void Select_the_phase_type() {
        SeleniumMethods.clickWithJs(Setting_WorkflowElement.phaseDropdown(), "Click on the add phase dropdown");
        int i = 0;
        WaitMethods.pause(1);
        for (WebElement element : Setting_UserProfileElement.dropdownList()) {
            if (!element.getAttribute("class").endsWith("selected")) {
                selectedValue = Setting_UserProfileElement.dropdownOptionList().get(i).getText();
                SeleniumMethods.click(Setting_UserProfileElement.dropdownOptionList().get(i), "Select the " + selectedValue + " phase");
                break;
            }
            i++;
        }
        SeleniumMethods.clickWithJs(Setting_WorkflowElement.phaseDropdown(), "Click on the add phase dropdown");
        WaitMethods.pause(1);
    }

    @When("^Select the multiple phase from the dropdown$")
    public void Select_the_multiple_phase() {
        SeleniumMethods.clickWithJs(Setting_WorkflowElement.phaseDropdown(), "Click on the add phase dropdown");
        int i = 0;
        int j = 0;
        WaitMethods.pause(1);
        for (WebElement element : Setting_UserProfileElement.dropdownList()) {
            if (!element.getAttribute("class").endsWith("selected")) {
                selectedValue = Setting_UserProfileElement.dropdownOptionList().get(i).getText();
                SeleniumMethods.click(Setting_UserProfileElement.dropdownOptionList().get(i), "Select the " + selectedValue + " phase");
                j++;
                if (j == 2)
                    break;
            }
            i++;
        }
        SeleniumMethods.clickWithJs(Setting_WorkflowElement.phaseDropdown(), "Click on the add phase dropdown");
        WaitMethods.pause(1);
    }

    @When("^Click on the add button$")
    public void click_on_the_add_button() {
        SeleniumMethods.click(Setting_WorkflowElement.addButton(), "Click on the add button");
    }

    @And("Validate that the added phase is displayed on the list")
    public void validate_that_the_added_phase_is_displayed_on_the_list() throws AWTException {
        CommonMethods.browserZoomIn();
        CommonMethods.browserZoomIn();
        WaitMethods.pause(1);
        String selectedPhase = "";
        for (WebElement element : Setting_WorkflowElement.selectedPhaseList()) {
            if (element.getText().equals(selectedValue)) {
                selectedPhase = element.getText();
                break;
            }
        }
        AssertMethods.textIsEqualTo(selectedPhase, selectedValue, "Validate that the added phase is displayed on the list");

    }

    @When("^Remove the selected phase$")
    public void remove_the_selected_phase() {
        SeleniumMethods.clickWithJs(Setting_WorkflowElement.closeIconList().get(0), "Click on the close icon of assigned phase");
        WaitMethods.pause(1);

    }

    @And("Validate that the phase is removed from the list")
    public void validate_that_the_phase_is_removed_from_the_list() {
        boolean isPhaseRemoved = true;
        for (WebElement element : Setting_WorkflowElement.selectedPhaseList()) {
            if (element.getText().equals(selectedValue)) {
                isPhaseRemoved = false;
                break;
            }
        }
        AssertMethods.isTrue(isPhaseRemoved, "Validate that the phase is removed from the list");
    }

    @And("Click on the deactivate workflow check box")
    public void Click_on_the_deactivate_workflow_check_box() {
        SeleniumMethods.click(Setting_WorkflowElement.deactivateWorkflowCheckBox(), "Click on the deactivate workflow check box");
    }

    @Then("^Validate that the deactivate workflow is displayed on the list$")
    public void validate_that_the_deactivate_workflow_is_displayed_on_the_list() {
        boolean isDeactivate = false;
        for (int i = 0; i <= 20; i++) {
            List<WebElement> elementList = Setting_CalendarElement.eventNameList();
            for (WebElement element : elementList) {
                if (element.getText().equals(name)) {
                    isDeactivate = true;
                    break;
                }
            }
            if (isDeactivate) {
                break;
            }
            SeleniumMethods.scrollToElement(elementList.get(elementList.size() - 2));
            WaitMethods.pause(3);
        }
        AssertMethods.isTrue(isDeactivate, "Validate that the deactivate workflow is displayed on the list");
    }

    @And("Click on the first workflow from the list")
    public void Click_on_the_first_workflow_from_list() {
        SeleniumMethods.click(DashboardElement.projectList().get(0), "Click on the first workflow from the list");
    }
}
