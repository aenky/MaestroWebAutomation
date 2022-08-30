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
;import java.util.List;

public class Setting_Channel {

    public static String name = "";
    public static String channelType = "";
    public static String channelDescription = "";

    @When("^Click on the channels option$")
    public void click_on_the_channels_option() {
        SeleniumMethods.click(Setting_ChannelElement.channelsOption(), "Click on the channels option");
    }

    @Then("^Validate that the new channel button is displayed$")
    public void validate_that_the_new_channel_button_is_displayed() {
        AssertMethods.elementIsDisplayed(Setting_ChannelElement.newChannelButton(), "Validate that the new channel button is displayed");
    }

    @When("^Click on the new channel button$")
    public void click_on_the_new_channel_button() {
        SeleniumMethods.click(Setting_ChannelElement.newChannelButton(), "Click on the new channel button");
    }

    @Then("^Validate that the create new channel dialog box heading is displayed$")
    public void validate_the_create_new_channel_dialog_box_heading_is_displayed() {
        AssertMethods.elementTextIsEqualTo(Setting_CalendarElement.dialogBoxHeading(), "Create New Channel", "Validate that the create new channel dialog box heading is displayed");
    }

    @Then("^Validate that the create new channel dialog box is closed$")
    public void validate_that_the_create_new_channel_dialog_box_is_closed() {
        WaitMethods.pause(1);
        boolean isSprintDialogBoxClosed = true;
        try {
            if (Setting_CalendarElement.theDialogBoxHeading().isDisplayed()) {
                isSprintDialogBoxClosed = false;
            }
        } catch (Exception e) {
        }
        AssertMethods.isTrue(isSprintDialogBoxClosed, "Validate that the create new channel dialog box is closed");
    }

    @Then("^Enter \"([^\"]*)\" on the channel name text box$")
    public void enter_name_on_department_text_box(String departmentName) {
        String timeStamp = " " + CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        name = departmentName + timeStamp;
        SeleniumMethods.sendKey(ReleasesElement.nameField(), name, "Enter " + name + " on channel Name text box");
    }

    @When("^Click on the \"([^\"]*)\" channel type$")
    public void click_on_the_channel_type(String type) {
        channelType = type;
        SeleniumMethods.click(Setting_ChannelElement.channelTypeCheckBox(type), "Click on the " + type + " channel type");
    }

    @Then("^Validate that the created channel name is displayed on the list and highlighted$")
    public void validate_the_created_department_is_highlighted_on_the_list() {
        for (WebElement element : Setting_CalendarElement.eventNameList()) {
            if (element.getText().equals(name)) {
                AssertMethods.elementTextIsEqualTo(element, name, "Validate that the created channel name is listed");
                WaitMethods.pause(2);
                AssertMethods.elementTextIsEndWith(Setting_CalendarElement.eventList().get(0).getAttribute("class"), "active", "Validate the created channel is displayed on the list and highlighted");
                break;
            }
        }
    }

    @When("^Deactivate the created channel$")
    public void deactivate_the_created_channel() {
        if (!channelType.equals("Both")) {
            for (WebElement element : Setting_CalendarElement.eventNameList()) {
                if (element.getText().equals(name)) {
                    SeleniumMethods.click(element, "Click on the created channel");
                    break;
                }
            }
            SeleniumMethods.click(Setting_ChannelElement.deactivateChannelCheckBox(), "Click on the deactivate channel check box");
            WaitMethods.pause(1);
            SeleniumMethods.click(DashboardElement.saveButton(), "Click on the save button");
            WaitMethods.pause(2);
        }

    }

    @Then("^Update \"([^\"]*)\" the channel name$")
    public void update_the_channel_name(String channelName) {
        String timeStamp = CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        name = channelName + " " + timeStamp;
        SeleniumMethods.clearTheField(ReleasesElement.editNameField(), "Clear input field");
        WaitMethods.pause(1);
        SeleniumMethods.sendKey(ReleasesElement.editNameField(), name, "Update the " + name + " on channel name");
    }

    @And("Click on the created channel from list")
    public void Click_on_the_created_channel_from_list() {
        for (WebElement element : DashboardElement.projectList()) {
            if (element.getText().equals(name)) {
                SeleniumMethods.click(element, "Click on the created channel from list");
            }
        }
    }

    @Then("^Validate that the updated channel name is also reflated on the channel list$")
    public void validate_that_the_updated_channel_name_is_also_reflated_on_the_channel_list() {
        for (WebElement element : DashboardElement.projectList()) {
            if (element.getText().equals(name)) {
                AssertMethods.elementTextIsEqualTo(element, name, "Validate that the updated channel name is also reflated on the channel list");
            }
        }
    }


    @And("Update \"([^\"]*)\" the channel description")
    public void update_the_channel_description(String text) {
        String timeStamp = CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        WebElement el = DashboardElement.editDescriptionTextBox();
        el.sendKeys(Keys.CONTROL + "A");
        el.sendKeys(Keys.DELETE);
        WaitMethods.pause(2);
        channelDescription=text+timeStamp;
        SeleniumMethods.sendKey(el, channelDescription, "Update the channel description");
    }

    @Then("^Validate that the updated channel description is also reflated on the channel list$")
    public void validate_that_the_updated_channel_description_is_also_reflated_on_the_channel_list() {
        AssertMethods.elementTextIsEqualTo(Setting_ChannelElement.channelDescriptionList().get(0), channelDescription, "Validate that the updated channel description is also reflated on the channel list");
    }

    @And("Update \"([^\"]*)\" the channel type")
    public void update_the_channel_type(String type) {
        channelType = type;
        SeleniumMethods.click(Setting_ChannelElement.editChannelTypeCheckBox(type), "Update " + type + " the channel type");
    }

    @Then("^Validate that the updated channel type is also reflated on the channel list$")
    public void validate_that_the_updated_channel_type_is_also_reflated_on_the_channel_list() {
        AssertMethods.elementTextIsEqualTo(Setting_ChannelElement.channelTypeList().get(0), channelType, "Validate that the updated channel type is also reflated on the channel list");
    }

    @And("Click on the first channel from list")
    public void Click_on_the_first_channel_from_list() {
        SeleniumMethods.click(DashboardElement.projectList().get(0), "Click on the first channel from list");
    }

    @And("Apply the inactive filter on inactive column")
    public void apply_the_inactive_filter_on_inactive_column() {
        SeleniumMethods.click(Setting_DepartmentsElement.inactiveColumnFilterIcon(), "Click on the inactive column filter icon");
        SeleniumMethods.click(DashboardElement.filterOption(), "Click on the filter option");
        SeleniumMethods.click(DashboardElement.filterCheckBoxOption("Inactive"), "Click on the inactive filter option");
        SeleniumMethods.click(DashboardElement.applyFilterButton(), "Click on the apply filter button");
        WaitMethods.pause(2);
    }

    @Then("^Validate that the list of deactivate channels$")
    public void validate_that_the_list_of_deactivate_channels() {
        boolean isDeactivate=true;
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
        AssertMethods.isTrue(isDeactivate,"Validate that the list of Deactivate channels");
    }

    @And("Click on the deactivate channel check box")
    public void Click_on_the_deactivate_check_box() {
        SeleniumMethods.click(Setting_ChannelElement.deactivateChannelCheckBox(), "Click on the deactivate channel check box");
    }

    @Then("^Enter channel name which is already existing on the list$")
    public void enter_channel_name_which_is_already_existing_on_the_list() {
        SeleniumMethods.sendKey(ReleasesElement.nameField(), name, "Enter channel name which is already existing on the list");
    }
}
