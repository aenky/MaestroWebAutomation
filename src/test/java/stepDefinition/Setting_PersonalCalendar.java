package stepDefinition;

import CommonUtility.AssertMethods;
import CommonUtility.CommonMethods;
import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import pom.*;

import java.util.List;

public class Setting_PersonalCalendar {

    public static String name="";
    public static int date=0;
    public static String repeatOption="";

    @When("^Click on the personal calendar option$")
    public void Click_on_the_personal_calendar_option() {
        SeleniumMethods.click(Setting_CalendarElement.personalCalendarOption(), "Click on the personal calendar option");
    }

    @Then("^Validate that the new event button is displayed$")
    public void validate_that_the_new_event_button_is_displayed() {
        AssertMethods.elementIsDisplayed(Setting_CalendarElement.newEventButton(),  "Validate that the new event button is displayed");
    }

    @Then("^Validate that the first event list is selected$")
    public void validate_the_first_event_list_is_selected() {
        WaitMethods.pause(2);
        AssertMethods.elementTextIsEndWith(Setting_CalendarElement.eventList().get(0).getAttribute("class"), "active", "Validate that the first event list is selected");
    }

    @When("^Click on the new event button$")
    public void click_on_the_new_event_button() {
        SeleniumMethods.click(Setting_CalendarElement.newEventButton(), "Click on the new event button");
    }

    @Then("^Validate that the create event dialog box heading is displayed$")
    public void validate_the_create_event_dialog_box_heading_is_displayed() {
        AssertMethods.elementTextIsEqualTo(Setting_CalendarElement.dialogBoxHeading(), "Create New Event", "Validate that the create event dialog box heading is displayed");
    }

    @Then("^Validate that the create event dialog box is closed$")
    public void validate_that_the_create_event_dialog_box_is_closed() {
        WaitMethods.pause(1);
        boolean isSprintDialogBoxClosed=true;
        try {
            if(Setting_CalendarElement.theDialogBoxHeading().isDisplayed()){
                isSprintDialogBoxClosed=false;
            }
        }catch (Exception e){}
        AssertMethods.isTrue(isSprintDialogBoxClosed,"Validate that the create event dialog box is closed");
    }

    @When("Enter the event name on name text box")
    public void enter_event_name_on_name_field() {
        String timeStamp = CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        name = "Automation Event " + timeStamp;
        SeleniumMethods.sendKey(Setting_CalendarElement.nameTextBox(), name, "Enter the '" + name + "' event name on name text box");
    }

    @When("Enter the same event name which is already exist")
    public void enter_the_same_event_name_which_is_already_exist() {
        SeleniumMethods.sendKey(Setting_CalendarElement.nameTextBox(), name, "Enter the '" + name + "' same event name which is already exist");
    }

    @When("^Select the event start date$")
    public void select_the_event_start_date() {
        WaitMethods.pause(1);
        SeleniumMethods.click(Setting_CalendarElement.startDate(), "Click on the event start date picker");
        SeleniumMethods.clickWithJs(SprintElement.rightSideArrow(), "Click on the right side arrow");
        WaitMethods.pause(1);
        WebElement element=SprintElement.selectDate("12");
        date= Integer.parseInt(element.getText());
        SeleniumMethods.click(element, "Select 12 date from date picker");
        WaitMethods.pause(2);

    }

    @When("^Select the event end date$")
    public void select_the_event_end_date() {
        WaitMethods.pause(1);
        SeleniumMethods.click(Setting_CalendarElement.endDate(), "Click on the event end date picker");
        SeleniumMethods.clickWithJs(SprintElement.rightSideArrow(), "Click on the right side arrow");
        WaitMethods.pause(1);
        SeleniumMethods.click(SprintElement.selectDate("12"), "Select 12 date from date picker");
        WaitMethods.pause(1);

    }

    @When("^Select the \"([^\"]*)\" option from repeat dropdown$")
    public void select_the_option_from_repeat_dropdown(String option) {
        WaitMethods.pause(1);
        SeleniumMethods.click(Setting_CalendarElement.repeatDropdown(), "Click on the repeat dropdown");
        for (WebElement element : Setting_UserProfileElement.dropdownOptionList()) {
            if (element.getText().equalsIgnoreCase(option)) {
                SeleniumMethods.click(element, "Click on the "+ option+" option");
                break;
            }
        }
    }

    @Then("^Validate that the created event is displayed first on the list and highlighted$")
    public void validate_the_created_event_is_highlighted_on_the_list() {
        AssertMethods.elementTextIsEqualTo(Setting_CalendarElement.eventNameList().get(0), name, "Validate that the created event name is same");
        //WaitMethods.pause(2);
        //AssertMethods.elementTextIsEndWith(DashboardElement.projectList().get(0).getAttribute("class"), "active", "Validate the created nugget is displayed first on the list and highlighted");
    }

    @Then("^Delete the created event$")
    public void delete_the_created_event() {
        SeleniumMethods.click(Setting_CalendarElement.eventNameList().get(0), "Click on the created event name from list");
        WaitMethods.pause(1);
        SeleniumMethods.click(Setting_CalendarElement.deleteEventCheckBox(), "Click on the delete event check box");
        WaitMethods.pause(1);
        SeleniumMethods.click(DashboardElement.saveButton(), "Click on the save button");
        WaitMethods.pause(3);
    }

    @When("^Click on the start date field$")
    public void click_on_the_start_date_field() {
        WaitMethods.pause(1);
        SeleniumMethods.click(Setting_CalendarElement.startDate(), "Click on the start date picker");
        WaitMethods.pause(1);
    }

    @Then("^Validate that the past date is disabled on the date picker$")
    public void validate_the_past_date_is_disabled_on_the_date_picker() {
        int date= Integer.parseInt(CommonMethods.getCurrentDateTime("dd"))-1;
        List<WebElement> dates=ReleasesElement.listOfDate();
        for(int i=0; i<date; i++){
            int j=i+1;
            AssertMethods.elementAttributeValueIsEqualTo(dates.get(i),"disabled","true","Validate that the "+j+" date is disabled on the date picker");
        }
    }

    @When("^Click on the end date field$")
    public void click_on_the_end_date_field() {
        WaitMethods.pause(1);
        SeleniumMethods.click(Setting_CalendarElement.endDate(), "Click on the end date picker");
        SeleniumMethods.clickWithJs(SprintElement.rightSideArrow(), "Click on the right side arrow");
        WaitMethods.pause(1);
    }

    @Then("^Validate that the date is disabled till the selected start date on the end date picker$")
    public void validate_the_date_is_disabled_till_the_selected_start_date_on_the_end_date_picker() {
        int intDate= date-1;
        List<WebElement> dates=ReleasesElement.listOfDate();
        for(int i=0; i<intDate; i++){
            int j=i+1;
            AssertMethods.elementAttributeValueIsEqualTo(dates.get(i),"disabled","true","Validate that the "+j+" date is disabled on the date picker");
        }
    }

    @When("Update the created event name")
    public void update_the_created_event_name() {
        String timeStamp = CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        name = "Automation Update Event " + timeStamp;
        SeleniumMethods.click(Setting_CalendarElement.eventNameList().get(0), "Click on the created event name from list");
        WaitMethods.pause(1);
        SeleniumMethods.clearTheField(NuggetElement.nuggetNameTextBox(),"The event name text box text is clear");
        SeleniumMethods.sendKey(NuggetElement.nuggetNameTextBox(), name, "Enter the '" + name + "' event name on name text box");
    }

    @Then("^Validate that the updated event name is also reflated on the listed event$")
    public void validate_that_the_updated_event_name_is_also_reflated_on_the_listed_event() {
        AssertMethods.elementTextIsEqualTo(Setting_CalendarElement.eventNameList().get(0), name, "Validate that the updated event name is also reflated on the listed event");
    }

    @When("^Update the event start date$")
    public void update_the_event_start_date() {
        WaitMethods.pause(1);
        SeleniumMethods.click(Setting_CalendarElement.editStartDate(), "Click on the edit event start date picker");
        WaitMethods.pause(1);
        WebElement element=SprintElement.selectDate("15");
        date= Integer.parseInt(element.getText());
        SeleniumMethods.click(element, "Select 15 date from date picker");
        WaitMethods.pause(2);
    }

    @Then("^Validate that the updated event start date is also reflated on the listed event$")
    public void validate_that_the_updated_event_start_date_is_also_reflated_on_the_listed_event() {
        int month = Integer.parseInt(CommonMethods.getCurrentDateTime("MM"));
        String year = CommonMethods.getCurrentDateTime("yyyy");
        if(month==12){year=CommonMethods.nextYear();}

        AssertMethods.elementTextIsEqualTo(Setting_CalendarElement.eventDateList().get(0), CommonMethods.nextMonth()+"/"+date+"/"+year, "Validate that the updated event start date is also reflated on the listed event");
    }

    @When("^Update the event end date$")
    public void update_the_event_end_date() {
        WaitMethods.pause(1);
        SeleniumMethods.click(Setting_CalendarElement.editEndDate(), "Click on the edit event end date picker");
        WaitMethods.pause(1);
        WebElement element=SprintElement.selectDate("18");
        date= Integer.parseInt(element.getText());
        SeleniumMethods.click(element, "Select 18 date from date picker");
        WaitMethods.pause(2);

    }

    @Then("^Validate that the updated event end date is also reflated on the listed event$")
    public void validate_that_the_updated_event_end_date_is_also_reflated_on_the_listed_event() {
        int month = Integer.parseInt(CommonMethods.getCurrentDateTime("MM"))+1;
        String year = CommonMethods.getCurrentDateTime("yyyy");
        if(month==12){year=CommonMethods.nextYear();}
        String endDate= Setting_CalendarElement.eventDateList().get(0).getText().split("-")[1].trim();
        AssertMethods.textIsEqualTo(endDate, CommonMethods.nextMonth()+"/"+date+"/"+year, "Validate that the updated event end date is also reflated on the listed event");
    }

    @When("^Update the event repeat option$")
    public void update_the_event_repeat_option() {
        WaitMethods.pause(1);
        SeleniumMethods.click(Setting_CalendarElement.editRepeatDropdown(), "Click on the edit repeat dropdown");
        List<WebElement> elementList=Setting_UserProfileElement.dropdownOptionList();
        int i=0;
        for (WebElement element : Setting_UserProfileElement.dropdownList()) {
            if (!element.getAttribute("class").endsWith("selected")) {
                repeatOption=elementList.get(i).getText();
                SeleniumMethods.click(element, "Click on the "+repeatOption+" option");
                break;
            }
            i++;
        }

    }

    @Then("^Validate that the updated event repeat option is also reflated on the listed event$")
    public void validate_that_the_updated_event_repeat_option_is_also_reflated_on_the_listed_event() {
        AssertMethods.textIsEqualToIgnoreCase(Setting_CalendarElement.eventsSelectedRepeatOptionList().get(0).getText(), repeatOption, "Validate that the updated event repeat option is also reflated on the listed event");
    }

    @When("^Update the events start date$")
    public void update_the_events_start_date() {
        WaitMethods.pause(1);
        SeleniumMethods.click(Setting_CalendarElement.editStartDate(), "Click on the edit event start date picker");
        WaitMethods.pause(1);
        WebElement element=SprintElement.selectDate("21");
        date= Integer.parseInt(element.getText());
        SeleniumMethods.click(element, "Select 21 date from date picker");
        WaitMethods.pause(2);
    }

    @Then("^Validate that the updated event start date and end date are same$")
    public void validate_that_the_updated_event_start_date_and_end_date_are_same() {
        int month = Integer.parseInt(CommonMethods.getCurrentDateTime("MM"))+1;
        String year = CommonMethods.getCurrentDateTime("yyyy");
        if(month==12){year=CommonMethods.nextYear();}
        AssertMethods.elementTextIsEqualTo(Setting_CalendarElement.eventDateList().get(0), CommonMethods.nextMonth()+"/"+date+"/"+year, "Validate that the updated event end date is also reflated on the listed event");
    }

    @Then("^Click on the delete checkbox$")
    public void click_on_the_delete_checkbox() {
        SeleniumMethods.click(Setting_CalendarElement.deleteEventCheckBox(), "Click on the delete event check box");
        WaitMethods.pause(2);
    }

    @Then("^Click on the \"([^\"]*)\" checkbox for weekly off$")
    public void click_on_the_checkbox_for_weekly_off(String weekDay) {
        SeleniumMethods.click(Setting_CalendarElement.weekdayCheckbox(weekDay), "Click on the "+weekDay+" checkbox for weekly off");
        WaitMethods.pause(1);
    }

    @When("^Click on the start date field of event edit section$")
    public void click_on_the_start_date_field_of_event_edit_section() {
        WaitMethods.pause(1);
        SeleniumMethods.click(Setting_CalendarElement.editStartDate(), "Click on the start date field of event edit section");
        SeleniumMethods.click(ReleasesElement.leftSideArrow(), "Click on the left side arrow");
        WaitMethods.pause(1);
    }

    @When("^Click on the company calendar option$")
    public void Click_on_the_company_calendar_option() {
        SeleniumMethods.click(Setting_CalendarElement.companyCalendarOption(), "Click on the company calendar option");
    }

}
