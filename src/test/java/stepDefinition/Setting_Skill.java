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

public class Setting_Skill {

    public static String name = "";
    public static String specialty = "";

    @When("^Click on the skills option$")
    public void click_on_the_skills_option() {
        SeleniumMethods.click(Setting_SkillElement.skillsOption(), "Click on the skills option");
    }

    @Then("^Validate that the new skill button is displayed$")
    public void validate_that_the_new_skill_button_is_displayed() {
        AssertMethods.elementIsDisplayed(Setting_SkillElement.newSkillButton(), "Validate that the new skill button is displayed");
    }

    @When("^Click on the new skill button$")
    public void click_on_the_new_skill_button() {
        SeleniumMethods.click(Setting_SkillElement.newSkillButton(), "Click on the new skill button");
    }

    @Then("^Validate that the create new skill dialog box heading is displayed$")
    public void validate_the_create_new_skill_dialog_box_heading_is_displayed() {
        AssertMethods.elementTextIsEqualTo(Setting_CalendarElement.dialogBoxHeading(), "Create New Skill", "Validate that the create new skill dialog box heading is displayed");
    }

    @Then("^Validate that the create new skill dialog box is closed$")
    public void validate_that_the_create_new_skill_dialog_box_is_closed() {
        WaitMethods.pause(1);
        boolean isSprintDialogBoxClosed = true;
        try {
            if (Setting_CalendarElement.theDialogBoxHeading().isDisplayed()) {
                isSprintDialogBoxClosed = false;
            }
        } catch (Exception e) {
        }
        AssertMethods.isTrue(isSprintDialogBoxClosed, "Validate that the create new skill dialog box is closed");
    }

    @Then("^Enter \"([^\"]*)\" on the skill name text box$")
    public void enter_name_on_skill_text_box(String skillName) {
        String timeStamp = " " + CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        name = skillName + timeStamp;
        SeleniumMethods.sendKey(ReleasesElement.nameField(), name, "Enter " + name + " on skill name text box");
    }

    @Then("^Validate that the created skill name is displayed on the list and highlighted$")
    public void validate_the_created_skill_is_displayed_and_highlighted_on_the_list() {
        for (WebElement element : Setting_CalendarElement.eventNameList()) {
            if (element.getText().equals(name)) {
                AssertMethods.elementTextIsEqualTo(element, name, "Validate that the created skill name is listed");
                WaitMethods.pause(2);
                //AssertMethods.elementTextIsEndWith(Setting_CalendarElement.eventList().get(0).getAttribute("class"), "active", "Validate the created phase is displayed on the list and highlighted");
                break;
            }
        }
    }

    @When("^Deactivate the created skill$")
    public void deactivate_the_created_skill() {
        for (WebElement element : Setting_CalendarElement.eventNameList()) {
            if (element.getText().equals(name)) {
                SeleniumMethods.click(element, "Click on the created skill");
                break;
            }
        }
        SeleniumMethods.click(Setting_SkillElement.deactivateSkillCheckBox(), "Click on the deactivate skill check box");
        WaitMethods.pause(1);
        SeleniumMethods.click(DashboardElement.saveButton(), "Click on the save button");
        WaitMethods.pause(2);

    }

    @And("Click on the created skill from list")
    public void click_on_the_created_skill_from_list() {
        for (WebElement element : Setting_CalendarElement.eventNameList()) {
            if (element.getText().equals(name)) {
                SeleniumMethods.click(element, "Click on the created skill from list");
                break;
            }
        }
    }

    @Then("Add specialties on created skill")
    public void add_specialties_on_created_skill() {
        specialty = "QA";
        SeleniumMethods.sendKey(Setting_SkillElement.specialtiesTextBox(), "QA", "Add specialties on created skill");
        SeleniumMethods.pressEnterKeyFromKeyBoard(Setting_SkillElement.specialtiesTextBox(), "Press enter key from keyboard");
    }

    @Then("Remove specialty from skill")
    public void remove_specialty_from_skill() {
        SeleniumMethods.click(Setting_SkillElement.closeIconOfSpecialty(specialty), "Click on the close icon of specialty");
    }

    @And("Validate that the added specialty is displayed on selected skill")
    public void validate_that_the_added_specialty_are_displayed_on_selected_skill() {
        int i = 1;
        boolean isSpecialty = false;
        for (WebElement element : Setting_CalendarElement.eventNameList()) {
            if (element.getText().equals(name)) {
                for (WebElement el : Setting_SkillElement.specialtiesList(i)) {
                    if (el.getText().equals(specialty)) {
                        isSpecialty = true;
                    }
                }
                break;
            }
            i++;
        }
        AssertMethods.isTrue(isSpecialty, "Validate that the added specialty are displayed on selected skill");
    }

    @And("Validate that the removed specialty is also removed from selected skill")
    public void validate_that_the_removed_specialty_is_also_removed_from_selected_skill() {
        int i = 1;
        boolean isSpecialty = false;
        for (WebElement element : Setting_CalendarElement.eventNameList()) {
            if (element.getText().equals(name)) {
                if (Setting_SkillElement.specialtiesList(i).isEmpty()) {
                    isSpecialty = true;
                }
                break;
            }
            i++;
        }
        AssertMethods.isTrue(isSpecialty, "Validate that the removed specialty is also removed from selected skill");
    }

    @Then("^Update \"([^\"]*)\" the skill name$")
    public void update_the_skill_name(String skillName) {
        String timeStamp = CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        name = skillName + " " + timeStamp;
        SeleniumMethods.clearTheField(ReleasesElement.editNameField(), "Clear input field");
        WaitMethods.pause(1);
        SeleniumMethods.sendKey(ReleasesElement.editNameField(), name, "Update the " + name + " on skill name");
    }

    @Then("^Enter skill name which is already existing on the list$")
    public void enter_skill_name_which_is_already_existing_on_the_list() {
        SeleniumMethods.sendKey(ReleasesElement.nameField(), name, "Enter skill name which is already existing on the list");
    }

    @Then("^Validate that the updated skill name is displayed on the list$")
    public void validate_the_updated_skill_is_displayed_on_the_list() {
        for (WebElement element : Setting_CalendarElement.eventNameList()) {
            if (element.getText().equals(name)) {
                AssertMethods.elementTextIsEqualTo(element, name, "Validate that the created skill name is listed");
                break;
            }
        }
    }

    @And("Click on the deactivate skill check box")
    public void Click_on_the_deactivate_skill_check_box() {
        SeleniumMethods.click(Setting_SkillElement.deactivateSkillCheckBox(), "Click on the deactivate skill check box");
    }

    @Then("^Validate that the deactivate skill is displayed on the list$")
    public void validate_that_the_deactivate_skill_is_displayed_on_the_list() {
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
        AssertMethods.isTrue(isDeactivate,"Validate that the deactivate skill is displayed on the list");
    }

    @And("Click on the first skill from the list")
    public void Click_on_the_first_skill_from_list() {
        SeleniumMethods.click(DashboardElement.projectList().get(0), "Click on the first Skill from the list");
    }

}
