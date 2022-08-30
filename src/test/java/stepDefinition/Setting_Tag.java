package stepDefinition;

import CommonUtility.AssertMethods;
import CommonUtility.CommonMethods;
import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pom.*;

import java.util.List;

public class Setting_Tag {

    public static String name = "";
    public static String description = "";


    @When("^Click on the tags option$")
    public void click_on_the_tags_option() {
        SeleniumMethods.click(Setting_TagElement.tagsOption(), "Click on the tags option");
    }

    @Then("^Validate that the new tag button is displayed$")
    public void validate_that_the_new_tag_button_is_displayed() {
        AssertMethods.elementIsDisplayed(Setting_TagElement.newTagButton(), "Validate that the new tag button is displayed");
    }

    @When("^Click on the new tag button$")
    public void click_on_the_new_tag_button() {
        SeleniumMethods.click(Setting_TagElement.newTagButton(), "Click on the new tag button");
    }

    @Then("^Validate that the create new tag dialog box heading is displayed$")
    public void validate_the_create_new_tag_dialog_box_heading_is_displayed() {
        AssertMethods.elementTextIsEqualTo(Setting_CalendarElement.dialogBoxHeading(), "Create New Tag", "Validate that the create new tag dialog box heading is displayed");
    }

    @Then("^Validate that the create new tag dialog box is closed$")
    public void validate_that_the_create_new_tag_dialog_box_is_closed() {
        WaitMethods.pause(1);
        boolean isSprintDialogBoxClosed = true;
        try {
            if (Setting_CalendarElement.theDialogBoxHeading().isDisplayed()) {
                isSprintDialogBoxClosed = false;
            }
        } catch (Exception e) {
        }
        AssertMethods.isTrue(isSprintDialogBoxClosed, "Validate that the create new tag dialog box is closed");
    }

    @Then("^Enter \"([^\"]*)\" on the tag name text box$")
    public void enter_name_on_tag_text_box(String tagName) {
        String timeStamp = " " + CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        name = tagName + timeStamp;
        SeleniumMethods.sendKey(ReleasesElement.nameField(), name, "Enter " + name + " on tag name text box");
    }

    @Then("^Validate that the created tag name is displayed on the list and highlighted$")
    public void validate_the_created_tag_is_displayed_and_highlighted_on_the_list() {
        for (WebElement element : Setting_CalendarElement.eventNameList()) {
            if (element.getText().equals(name)) {
                AssertMethods.elementTextIsEqualTo(element, name, "Validate that the created tag name is listed");
                //WaitMethods.pause(2);
                //AssertMethods.elementTextIsEndWith(Setting_CalendarElement.eventList().get(0).getAttribute("class"), "active", "Validate the created phase is displayed on the list and highlighted");
                break;
            }
        }
    }

    @When("^Deactivate the created tag$")
    public void deactivate_the_created_tag() {
        for (WebElement element : Setting_CalendarElement.eventNameList()) {
            if (element.getText().equals(name)) {
                SeleniumMethods.click(element, "Click on the created tag");
                break;
            }
        }
        SeleniumMethods.click(Setting_TagElement.deactivateTagCheckBox(), "Click on the deactivate tag check box");
        WaitMethods.pause(1);
        SeleniumMethods.click(DashboardElement.saveButton(), "Click on the save button");
        WaitMethods.pause(2);
    }

    @And("Click on the created tag from list")
    public void click_on_the_created_tag_from_list() {
        for (WebElement element : Setting_CalendarElement.eventNameList()) {
            if (element.getText().equals(name)) {
                SeleniumMethods.click(element, "Click on the created tag from list");
                break;
            }
        }
    }

    @Then("^Update \"([^\"]*)\" the tag name$")
    public void update_the_tag_name(String workflowName) {
        String timeStamp = CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        name = workflowName + " " + timeStamp;
        SeleniumMethods.clearTheField(ReleasesElement.editNameField(), "Clear input field");
        WaitMethods.pause(1);
        SeleniumMethods.sendKey(ReleasesElement.editNameField(), name, "Update the " + name + " on tag name");
    }

    @And("Update \"([^\"]*)\" the tag description")
    public void update_the_tag_description(String text) {
        WebElement el = DashboardElement.editDescriptionTextBox();
        el.sendKeys(Keys.CONTROL + "A");
        el.sendKeys(Keys.DELETE);
        WaitMethods.pause(2);
        description=text;
        SeleniumMethods.sendKey(el, description, "Update the tag description");
    }

    @Then("^Enter tag name which is already existing on the list$")
    public void enter_tag_name_which_is_already_existing_on_the_list() {
        SeleniumMethods.sendKey(ReleasesElement.nameField(), name, "Enter tag name which is already existing on the list");
    }

    @And("Click on the deactivate tag check box")
    public void Click_on_the_tag_workflow_check_box() {
        SeleniumMethods.click(Setting_TagElement.deactivateTagCheckBox(), "Click on the deactivate tag check box");
    }

    @Then("^Validate that the deactivate tag is displayed on the list$")
    public void validate_that_the_tag_workflow_is_displayed_on_the_list() {
        boolean isDeactivate=false;
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
        AssertMethods.isTrue(isDeactivate,"Validate that the deactivate tag is displayed on the list");
    }

    @And("Click on the first tag from the list")
    public void Click_on_the_first_tag_from_list() {
        SeleniumMethods.click(DashboardElement.projectList().get(0), "Click on the first tag from the list");
    }

}
