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

public class Setting_Departments {

    public static String name="";

    @When("^Click on the departments option$")
    public void click_on_the_departments_option() {
        SeleniumMethods.click(Setting_DepartmentsElement.departmentsOption(), "Click on the departments option");
    }

    @Then("^Validate that the new department button is displayed$")
    public void validate_that_the_new_department_button_is_displayed() {
        AssertMethods.elementIsDisplayed(Setting_DepartmentsElement.newDepartmentButton(), "Validate that the new department button is displayed");
    }

    @When("^Click on the new department button$")
    public void Click_on_the_new_department_button() {
        SeleniumMethods.click(Setting_DepartmentsElement.newDepartmentButton(), "Click on the new department button");
    }

    @Then("^Validate that the create new department dialog box heading is displayed$")
    public void validate_the_create_new_department_dialog_box_heading_is_displayed() {
        AssertMethods.elementTextIsEqualTo(Setting_CalendarElement.dialogBoxHeading(), "Create New Department", "Validate that the create new department dialog box heading is displayed");
    }

    @Then("^Validate that the create new department dialog box is closed$")
    public void validate_that_the_create_new_department_dialog_box_is_closed() {
        WaitMethods.pause(1);
        boolean isSprintDialogBoxClosed = true;
        try {
            if (Setting_CalendarElement.theDialogBoxHeading().isDisplayed()) {
                isSprintDialogBoxClosed = false;
            }
        } catch (Exception e) {
        }
        AssertMethods.isTrue(isSprintDialogBoxClosed, "Validate that the create new department dialog box is closed");
    }

    /*@Then("^Validate that the create button is disabled$")
    public void Validate_that_the_confirm_button_is_disabled$() {
        AssertMethods.elementAttributeValueIsEqualTo(Setting_DepartmentsElement.createButton(),"disabled","true", "Validate that the create button is disabled");
    }*/

    /*@Then("^Validate that the create button is enabled")
    public void Validate_that_the_create_button_is_enabled$() {
        AssertMethods.elementIsEnabled(DashboardElement.createButton(), "Validate that the create button is enabled");
    }*/

    @Then("^Enter \"([^\"]*)\" on the department name text box$")
    public void enter_name_on_department_text_box(String departmentName) {
        String timeStamp= " "+CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        name=departmentName+timeStamp;
        SeleniumMethods.sendKey(ReleasesElement.nameField(), name, "Enter " + name + " on department Name text box");
    }

    @Then("^Validate that the max length validation message is displayed$")
    public void validate_the_max_length_validation_message_is_displayed() {
        AssertMethods.elementTextIsEqualTo(Setting_DepartmentsElement.validationMessageField("2"), "This field must be at most 50 characters long.", "Validate that the max length validation message is displayed");
    }

    /*@When("^Click on the confirm button$")
    public void Click_on_the_confirm_button() {
        SeleniumMethods.click(Setting_DepartmentsElement.createButton(), "Click on the confirm button");
    }*/

    @Then("^Validate that the created department name is displayed on the list and highlighted$")
    public void validate_the_created_department_is_highlighted_on_the_list() {
        for(WebElement element: Setting_CalendarElement.eventNameList()){
            if(element.getText().equals(name)) {
                AssertMethods.elementTextIsEqualTo(element, name, "Validate that the created department name is listed");
                WaitMethods.pause(2);
                //AssertMethods.elementTextIsEndWith(Setting_CalendarElement.eventList().get(0).getAttribute("class"), "active", "Validate the created department is displayed on the list and highlighted");
                break;
            }
        }
    }

    @And("Click on the first department from list")
    public void Click_on_the_first_department_from_list() {
        SeleniumMethods.click(DashboardElement.projectList().get(0), "Click on the first department from list");
    }

    @And("Click on the created department from list")
    public void Click_on_the_created_department_from_list() {
        for(WebElement element:DashboardElement.projectList()) {
            if(element.getText().equals(name)) {
                SeleniumMethods.click(element, "Click on the created department from list");
            }
        }
    }

    @Then("^Update \"([^\"]*)\" the department name$")
    public void update_the_department_name(String departmentName) {
        String timeStamp= CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        name= departmentName+" "+timeStamp;
        SeleniumMethods.clearTheField(ReleasesElement.editNameField(), "Clear input field");
        WaitMethods.pause(1);
        SeleniumMethods.sendKey(ReleasesElement.editNameField(), name, "Update the " + name + " on department Name");
    }

    @Then("^Validate that the max length validation message is displayed on the edit section$")
    public void validate_the_max_length_validation_message_is_displayed_on_edit_section() {
        AssertMethods.elementTextIsEqualTo(Setting_DepartmentsElement.validationMessageField("1"), "This field must be at most 50 characters long.", "Validate that the max length validation message is displayed on the edit section");
    }

    @Then("^Validate that the updated department name is also reflated on the listed event$")
    public void validate_that_the_updated_event_name_is_also_reflated_on_the_listed_event() {
        AssertMethods.elementTextIsEqualTo(Setting_CalendarElement.eventNameList().get(0), name, "Validate that the updated department name is also reflated on the listed event");
    }

    @And("Click on the deactivate department check box")
    public void Click_on_the_deactivate_check_box() {
        WaitMethods.pause(1);
        SeleniumMethods.click(Setting_DepartmentsElement.deactivateDepartmentCheckBox(), "Click on the deactivate department check box");
    }

    @Then("^Validate that the deactivate department is removed from the list$")
    public void validate_the_deactivate_department_is_removed_from_the_list() {
        WaitMethods.pause(2);
        boolean isRemoved=true;
        for(WebElement element: Setting_CalendarElement.eventNameList()){
            if(element.getText().equals(name)) {
                isRemoved=false;
                break;
            }
        }
        AssertMethods.isTrue(isRemoved,"Validate that the deactivate department is removed from the list");
    }

    @And("^Remove the active filter from inactive column$")
    public void remove_the_active_filter_from_inactive_column() {
        WaitMethods.pause(1);
        SeleniumMethods.clickWithJs(Setting_DepartmentsElement.inactiveColumnFilterIcon(), "Click on the inactive column filter icon");
        WaitMethods.pause(1);
        SeleniumMethods.click(DashboardElement.filterOption(), "Click on the filter option");
        SeleniumMethods.click(DashboardElement.filterCheckBoxOption("Active"), "Click on the active filter option");
        SeleniumMethods.click(DashboardElement.applyFilterButton(), "Click on the apply filter button");
        WaitMethods.pause(2);
    }

    @And("Apply the inactive filter on inactive department column")
    public void apply_the_inactive_filter_on_inactive_department_column() {
        SeleniumMethods.click(Setting_DepartmentsElement.inactiveColumnFilterIcon(), "Click on the inactive column filter icon");
        SeleniumMethods.click(DashboardElement.filterOption(), "Click on the filter option");
        SeleniumMethods.click(DashboardElement.filterCheckBoxOption("Inactive"), "Click on the inactive filter option");
        SeleniumMethods.click(DashboardElement.applyFilterButton(), "Click on the apply filter button");
        WaitMethods.pause(2);
    }

    @Then("^Validate that the list of deactivate department$")
    public void validate_that_the_list_of_deactivate_department() {
        boolean isDeactivate=true;
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
        AssertMethods.isTrue(isDeactivate,"Validate that the list of deactivate department");
    }

    @Then("^Enter department name which is already existing on the list$")
    public void enter_department_name_which_is_already_existing_on_the_list() {
        SeleniumMethods.sendKey(ReleasesElement.nameField(), name, "Enter department name which is already existing on the list");
    }

}
