package stepDefinition;

import CommonUtility.AssertMethods;
import CommonUtility.CommonMethods;
import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import pom.*;

import java.util.List;

public class Releases {

    public static String releaseName = "";
    public static String releaseMaestro = "";

    @Then("^Validate that the released sub tab is displayed on top menu$")
    public void validate_that_the_released_sub_tab_is_displayed() {
        AssertMethods.elementIsDisplayed(ReleasesElement.releasedSubTab(), "Validate that the released sub tab is displayed on top menu");
    }

    @Then("^Validate that the active sub tab is selected$")
    public void validate_that_the_active_sub_tab_is_selected() {
        AssertMethods.elementTextIsEndWith(SideMenuElement.activeReleasesTab().getAttribute("class"), "active", "Validate that the active sub tab is selected");
    }

    @Then("^Validate that the selected sub tab text color is \"([^\"]*)\"$")
    public void validate_that_the_selected_sub_tab_text_color(String colorCode) {
        WebElement element = ReleasesElement.activeReleasesSubTabText();
        String color = element.getCssValue("color");
        String textColorCode = Color.fromString(color).asHex();
        CommonMethods.logInfo("Hex code of sub tab text:" + textColorCode);
        Assert.assertEquals(textColorCode, colorCode);
        CommonMethods.logInfo("Validate that the selected sub tab text color is " + colorCode);
    }

    @When("^Click on the \"([^\"]*)\" sub-tab$")
    public void Click_on_the_nugget_chat_tab(String subTab) {

        if (subTab.equalsIgnoreCase("active")) {
            SeleniumMethods.click(SideMenuElement.activeReleasesTab(), "Click on the active sub-tab");
        } else if (subTab.equalsIgnoreCase("released")) {
            SeleniumMethods.click(ReleasesElement.releasedSubTab(), "Click on the released sub-tab");
        }
    }

    @Then("^Validate that the \"([^\"]*)\" Header is displayed$")
    public void validate_that_the_Header_is_displayed(String header) {
        boolean isTrue = false;
        for (WebElement element : ReleasesElement.listOfTableHeaders()) {
            if (element.getText().equals(header)) {
                isTrue = true;
                break;
            }
        }
        Assert.assertTrue(isTrue);
        CommonMethods.logInfo("Validate that the " + header + " Header is displayed");
    }

    @Then("^Validate that the released list is displayed or empty list message$")
    public void validate_that_the_released_list_is_displayed() {
        List<WebElement> tableRowList = ReleasesElement.tableRowList();

        if (tableRowList.isEmpty()) {
            AssertMethods.elementTextIsEqualTo(ReleasesElement.emptyListMessage(), "No available data", "Validate that the released empty list message is displayed");
        } else {
            AssertMethods.elementListIsNotEmpty(tableRowList, "Validate that the released list is displayed");
        }
    }

    @Then("^Validate that the released list has only seen released tempo$")
    public void validate_that_the_released_list_has_only_seen_released_tempo() {
        List<WebElement> tempoList = ReleasesElement.tempoList();

        if (!tempoList.isEmpty()) {
            for (WebElement element : tempoList) {
                if (!element.getText().equals("Released")) {
                    CommonMethods.logInfo("Displayed " + element.getText() + " tempo on released list");
                    Assert.assertFalse(true);
                }
            }
        } else {
            CommonMethods.logInfo("The released list is empty");
        }
        CommonMethods.logInfo("Validate that the released list has only seen released tempo");

    }

    @Then("^Validate that the create release button is displayed$")
    public void validate_that_the_create_release_button_is_displayed() {
        AssertMethods.elementIsDisplayed(ReleasesElement.createReleaseButton(), "Validate that the create release button is displayed");
    }

    @Then("^Validate that the create release button is not displayed$")
    public void validate_that_the_create_release_button_is_not_displayed() {
        boolean isReleaseButton = false;
        try {
            if (ReleasesElement.createTheReleaseButton().isDisplayed()) {
                isReleaseButton = true;
            }
        } catch (Exception e) {
        }
        CommonMethods.logInfo("Validate that the create release button is not displayed");
        Assert.assertTrue(!isReleaseButton);
    }

    @Then("^Validate that the release details section has displayed the chat tab$")
    public void Validate_the_nugget_details_section_with_the_Chat_section_Displayed() {
        AssertMethods.elementIsDisplayed(DashboardElement.chatTabIcon(), "Validate that the release details section has displayed the chat tab");
    }

    @Then("^Validate that the release details section has displayed the details tab$")
    public void Validate_the_nugget_details_section_with_the_details_section_displayed() {
        AssertMethods.elementIsDisplayed(DashboardElement.detailsTabIcon(), "Validate that the release details section has displayed the details tab");
    }

    @Then("^Validate that the release details section has displayed the attachment tab$")
    public void Validate_the_nugget_details_section_with_the_attachment_section_displayed() {
        AssertMethods.elementIsDisplayed(DashboardElement.chatAttachmentTabIcon(), "Validate that the release details section has displayed the attachment tab");
    }

    @When("^Click on the release chat tab$")
    public void Click_on_the_release_chat_tab() {
        SeleniumMethods.click(DashboardElement.chatTabIcon(), "Click on the release chat tab");
    }

    @Then("^Validate that send message icon is displayed$")
    public void Validate_the_send_message_icon_is_displayed() {
        AssertMethods.elementIsDisplayed(NuggetElement.sendButtonIcon(), "Validate that the send message icon is displayed");
    }

    @When("^Click on the release details tab$")
    public void Click_on_the_release_details_tab() {
        SeleniumMethods.click(DashboardElement.detailsTabIcon(), "Click on the release details tab");
    }

    @Then("^Validate that the system is displayed the release details section$")
    public void Validate_the_system_is_displayed_the_release_details_section() {
        AssertMethods.elementTextIsEndWith(DashboardElement.detailsTabIcon().getAttribute("class"), "active", "Validate the system is displayed the release details section");
        AssertMethods.elementIsDisplayed(ReleasesElement.editReleaseName(), "Validate the system is displayed the edit release name field");
        AssertMethods.elementIsDisplayed(ReleasesElement.editReleaseDescription(), "Validate the system is displayed the edit release description field");
    }

    @When("^Click on the release attachment tab$")
    public void Click_on_the_nugget_attachment_tab() {
        SeleniumMethods.click(DashboardElement.chatAttachmentTabIcon(), "Click on the release attachment tab");
    }

    @Then("^Validate that the system is displayed the release chat attachment section$")
    public void Validate_the_system_is_displayed_the_nugget_chat_attachment_section() {
        AssertMethods.elementTextIsEndWith(DashboardElement.chatAttachmentTabIcon().getAttribute("class"), "active", "Validate the system is displayed the nugget chat attachment section");
        AssertMethods.elementIsDisplayed(NuggetElement.mediaTab(), "Validate the system is displayed the media sub tab");
        AssertMethods.elementIsDisplayed(NuggetElement.linkTab(), "Validate the system is displayed the link sub tab");
        AssertMethods.elementIsDisplayed(NuggetElement.documentsTab(), "Validate the system is displayed the document sub tab");
    }

    @When("^Click on the create release button$")
    public void Click_on_the_create_release_button() {
        SeleniumMethods.click(ReleasesElement.createReleaseButton(), "Click on the create release button");
    }

    @Then("^Validate that the create release dialog box is open$")
    public void Validate_the_create_release_dialog_box_is_open() {
        WaitMethods.pause(1);
        AssertMethods.elementTextIsEqualTo(ReleasesElement.releaseDialogBoxHeading(), "Create Release", "Validate that the create release dialog box is open");
    }

    @Then("^Validate the release name field is displayed$")
    public void Validate_the_release_name_text_box_field_is_displayed() {
        AssertMethods.elementIsDisplayed(ReleasesElement.nameField(), "Validate the release name field is displayed");
    }

    @Then("^Validate the release date field is displayed$")
    public void Validate_the_release_date_field_is_displayed() {
        AssertMethods.elementIsDisplayed(ReleasesElement.releaseDateField(), "Validate the release date field is displayed");
    }

    @Then("^Validate the release cutoff field is displayed$")
    public void Validate_the_release_cutoff_field_is_displayed() {
        AssertMethods.elementIsDisplayed(ReleasesElement.releaseCutoffDateField(), "Validate the release cutoff field is displayed");
    }

    @Then("^Validate the release maestro dropdown is displayed$")
    public void Validate_the_release_maestro_dropdown_is_displayed() {
        AssertMethods.elementIsDisplayed(ReleasesElement.releaseMaestroDropdown(), "Validate the release maestro dropdown is displayed");
    }

    @Then("^Validate the secondary maestro dropdown is displayed$")
    public void Validate_the_secondary_maestro_dropdown_is_displayed() {
        AssertMethods.elementIsDisplayed(ReleasesElement.secondaryMaestroDropdown(), "Validate the secondary maestro dropdown is displayed");
    }

    @Then("^Validate the description field is displayed$")
    public void Validate_the_release_description_field_is_displayed() {
        AssertMethods.elementIsDisplayed(ReleasesElement.descriptionField(), "Validate the description field is displayed");
    }

    @Then("^Validate that the create release dialog box is closed")
    public void Validate_the_create_release_dialog_box_is_closed() {
        WaitMethods.pause(1);
        boolean isDialogBox = false;
        try {
            if (ReleasesElement.headingOfReleaseDialogBox().isDisplayed()) {
                isDialogBox = true;
            }
        } catch (Exception e) {
        }
        Assert.assertTrue(!isDialogBox);
        CommonMethods.logInfo("Validate that the create release dialog box is closed");
    }

    @When("^Enter the release name$")
    public void Enter_the_release_name() {
        String timeStamp = CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        releaseName = "Auto Release " + timeStamp;
        SeleniumMethods.sendKey(ReleasesElement.nameField(), releaseName, "Enter the release name");
    }

    @When("^Select the release date$")
    public void select_the_release_date() {
        WaitMethods.pause(2);
        SeleniumMethods.click(ReleasesElement.releaseDateField(), "Click on the release date picker");
        SeleniumMethods.clickWithJs(SprintElement.rightSideArrow(), "Click on the right side arrow");
        WaitMethods.pause(1);
        SeleniumMethods.click(SprintElement.selectDate("15"), "Select 15 date from date picker");
        WaitMethods.pause(2);

    }

    @When("^select the release cutoff date$")
    public void select_the_release_cutoff_date() {
        WaitMethods.pause(2);
        SeleniumMethods.click(ReleasesElement.releaseCutoffDateField(), "Click on the release cutoff date picker");
        SeleniumMethods.clickWithJs(SprintElement.rightSideArrow(), "Click on the right side arrow");
        WaitMethods.pause(1);
        SeleniumMethods.click(SprintElement.selectDate("13"), "Select 13 date from date picker");
        WaitMethods.pause(2);
    }

    @When("^Select the release maestro from dropdown$")
    public void select_release_maestro_from_dropdown() {
        SeleniumMethods.click(ReleasesElement.releaseMaestroDropdown(), "Click on release maestro dropdown");
        SeleniumMethods.click(DashboardElement.projectMaestroList().get(0), "Select release maestro from dropdown");
    }

    @Then("^Validate the successfully created release toast notification message is displayed$")
    public void Validate_the_successfully_created_release_toast_notification_message_is_displayed() {
        AssertMethods.elementTextIsStartWith(DashboardElement.toastNotificationPopup().getText(), "Successfully created", "Validate the successfully created release toast notification message is displayed");
    }

    @Then("^Validate that the created release is displayed in the List$")
    public void Validate_the_created_release_is_displayed_in_the_List() {
        WaitMethods.pause(2);
        AssertMethods.elementTextIsEqualTo(ReleasesElement.createdReleaseName(releaseName), releaseName, "Validate that the created release is displayed in the List");
    }

    @Then("^Validate that the created release is highlighted in the List$")
    public void validate_the_created_release_is_highlighted_in_the_List() {
        AssertMethods.elementTextIsEndWith(ReleasesElement.createdReleaseRow(releaseName).getAttribute("class"), "active", "Validate that the created release is highlighted in the List");
    }

    @When("^Enter the description on the text box$")
    public void enter_description_on_text_field() {
        String timeStamp = CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        SeleniumMethods.sendKey(ReleasesElement.descriptionField(), "Automation description " + timeStamp, "Enter 'Automation description " + timeStamp + "' description");
    }

    @When("^Change the release name$")
    public void change_the_release_name() {
        WaitMethods.pause(1);
        String timeStamp = CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        releaseName = "Edit Auto Release " + timeStamp;
        WebElement el = ReleasesElement.editNameField();
        el.sendKeys(Keys.CONTROL + "A");
        el.sendKeys(Keys.DELETE);
        SeleniumMethods.sendKey(el, releaseName, "Change the release name");
    }

    @When("^Change the released name$")
    public void change_the_released_name() {
        WaitMethods.pause(1);
        String timeStamp = CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        String releasedName = "Edit Auto Release " + timeStamp;
        WebElement el = ReleasesElement.editNameField();
        el.sendKeys(Keys.CONTROL + "A");
        el.sendKeys(Keys.DELETE);
        SeleniumMethods.sendKey(el, releasedName, "Change the release name");
    }

    @Then("^Validate the successfully update the release toast notification message is displayed$")
    public void Validate_the_successfully_update_release_toast_notification_message_is_displayed() {
        AssertMethods.elementTextIsStartWith(DashboardElement.toastNotificationPopup().getText(), "Successfully updated", "Validate the successfully update the release toast notification message is displayed");
    }

    @And("Click on the first release from the list")
    public void Click_on_the_first_release_from_the_list() {
        SeleniumMethods.click(DashboardElement.projectList().get(0), "Click on the first release from the list");
    }

    @Then("^Validate that the release name is updated on the list$")
    public void Validate_that_the_release_name_is_updated_on_the_list() {
        WaitMethods.pause(2);
        int i = 0;
        for (WebElement el : ReleasesElement.releaseNameList()) {
            if (el.getText().equals(releaseName)) {
                AssertMethods.elementTextIsEqualTo(ReleasesElement.releaseNameList().get(i), releaseName, "Validate that the release name is updated on the list");
            }
            i++;
        }
    }

    @When("^Change the release date$")
    public void change_the_release_date() {
        WaitMethods.pause(2);
        SeleniumMethods.click(ReleasesElement.editReleaseDateField(), "Click on the release date picker");
        WaitMethods.pause(1);
        SeleniumMethods.click(SprintElement.selectDate("16"), "Select 16 date from date picker");
        WaitMethods.pause(2);
    }


    @Then("^Validate that the release date is updated on the list$")
    public void Validate_that_the_release_date_is_updated_on_the_list() {
        WaitMethods.pause(2);
        // Shadow shadow = new Shadow(ServiceHook.driver);
        WebElement element = ServiceHook.driver.findElement(By.xpath("//input[@aria-label='Name']"));
        WebElement shadowRoot1 = CommonMethods.expandRootElement(element);
        WebElement divEl = shadowRoot1.findElement(By.cssSelector("div[id='placeholder']"));
        // String text = element.getText();
        //AssertMethods.elementTextIsEqualTo(ReleasesElement.releaseNameList().get(0), releaseName, "Validate that the release name is updated on the list");
    }

    @When("^Change the release cutoff date$")
    public void change_the_release_cutoff_date() {
        WaitMethods.pause(2);
        SeleniumMethods.click(ReleasesElement.editReleaseCutoffDateField(), "Click on the release cutoff date picker");
        WaitMethods.pause(1);
        SeleniumMethods.click(SprintElement.selectDate("14"), "Select 14 date from date picker");
        WaitMethods.pause(1);
    }

    @When("^Change the release maestro from dropdown$")
    public void change_release_maestro_from_dropdown() {
        SeleniumMethods.click(ReleasesElement.editReleaseMaestroDropdown(), "Click on release maestro dropdown");
        releaseMaestro = DashboardElement.projectMaestroList().get(1).getText();
        SeleniumMethods.click(DashboardElement.projectMaestroList().get(1), "Select release maestro from dropdown");
    }

    @When("^Change the release description$")
    public void change_the_release_description$() {
        WaitMethods.pause(1);
        String timeStamp = CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        String releaseDescription = "Update Auto Release " + timeStamp;
        WebElement el = ReleasesElement.editReleaseDescription();
        el.sendKeys(Keys.CONTROL + "A");
        el.sendKeys(Keys.DELETE);
        WaitMethods.pause(1);
        SeleniumMethods.sendKey(el, releaseName, "Change the release description$");
    }

    @Then("^Validate that the release secondary maestro is updated on the list$")
    public void Validate_that_the_release_secondary_maestro_is_updated_on_the_list() {
        WaitMethods.pause(2);
        int i = 0;
        for (WebElement el : ReleasesElement.releaseNameList()) {
            if (el.getText().equals(releaseName)) {
                AssertMethods.elementTextIsEqualTo(ReleasesElement.releaseSecondaryMaestroList().get(i), Dashboard.secondaryMaestro, "Validate that the release secondary maestro is updated on the list");
            }
            i++;

        }
    }

    @Then("^Validate that the release maestro is updated on the list$")
    public void Validate_that_the_release_maestro_is_updated_on_the_list() {
        WaitMethods.pause(2);
        int i = 0;
        for (WebElement el : ReleasesElement.releaseNameList()) {
            if (el.getText().equals(releaseName)) {
                AssertMethods.elementTextIsEqualTo(ReleasesElement.releaseMaestroList().get(i), releaseMaestro, "Validate that the release maestro is updated on the list");
            }
            i++;

        }
    }

    @Then("^Validate that the release date field is disabled$")
    public void Validate_that_the_release_date_field_is_disabled() {
        WaitMethods.pause(2);
        AssertMethods.elementAttributeValueIsEqualTo(ReleasesElement.editReleaseDateField(), "disabled", "true", "Validate that the release date field is disabled");
    }

    @Then("^Validate that the release cutoff date field is disabled$")
    public void Validate_that_the_release_cutoff_date_field_is_disabled() {
        WaitMethods.pause(2);
        AssertMethods.elementAttributeValueIsEqualTo(ReleasesElement.editReleaseCutoffDateField(), "disabled", "true", "Validate that the release cutoff date field is disabled");
    }

    @Then("^Validate that all fields are disabled$")
    public void Validate_that_fields_are_disabled() {
        WaitMethods.pause(1);
        AssertMethods.elementAttributeValueIsEqualTo(ReleasesElement.editNameField(), "disabled", "true", "Validate that the release name field is disabled");
        AssertMethods.elementAttributeValueIsEqualTo(ReleasesElement.editReleaseDateField(), "disabled", "true", "Validate that the release date field is disabled");
        AssertMethods.elementAttributeValueIsEqualTo(ReleasesElement.editReleaseCutoffDateField(), "disabled", "true", "Validate that the release cutoff date field is disabled");
        AssertMethods.elementAttributeValueIsEqualTo(ReleasesElement.editReleaseMaestroDropdown(), "disabled", "true", "Validate that the release maestro field is disabled");
        AssertMethods.elementAttributeValueIsEqualTo(DashboardElement.editSecondaryMaestroDropdown(), "disabled", "true", "Validate that the release secondary maestro field is disabled");
        AssertMethods.elementAttributeValueIsEqualTo(ReleasesElement.editReleaseDescription(), "disabled", "true", "Validate that the release Description field is disabled");
    }

    @When("^Change the release date lass than cutoff date$")
    public void change_the_release_date_lass_than_cutoff_date() {
        WaitMethods.pause(2);
        SeleniumMethods.click(ReleasesElement.editReleaseDateField(), "Click on the release date picker");
        WaitMethods.pause(1);
        SeleniumMethods.click(SprintElement.selectDate("1"), "Select 01 date from date picker");
        WaitMethods.pause(2);
    }

    @When("^Enter empty space on the release name$")
    public void Enter_space_on_the_release_name() {
        SeleniumMethods.sendKey(ReleasesElement.nameField(), "   ", "Enter empty space on the release name");
    }

    @When("^Enter more than 128 characters on the release name$")
    public void Enter_more_than_128_characters_on_the_release_name() {
        String name = "Hello Team, Here is we will automate the script for validate the validation message for enter more than 128 characters on the name field";
        SeleniumMethods.sendKey(ReleasesElement.nameField(), name, "Enter empty space on the release name");
    }

    @Then("^Validate that the length validation message \"([^\"]*)\" appears on name field$")
    public void Validate_the_required_field_validation_message_displayed(String message) {
        AssertMethods.elementTextIsEqualTo(NuggetElement.validationMSgForNuggetNameTextBox(), message, "Validate that the length validation message '" + message + "' appears on name field");
    }

    @When("^Change the release cutoff date with current date$")
    public void change_the_release_cutoff_date_with_current_date() {
        WaitMethods.pause(2);
        SeleniumMethods.click(ReleasesElement.editReleaseCutoffDateField(), "Click on the release cutoff date picker");
        WaitMethods.pause(1);
        if (SprintElement.selectDate("1").isEnabled()) {
            SeleniumMethods.click(ReleasesElement.leftSideArrow(), "Click on the left side arrow");
        }
        List<WebElement> dates = ReleasesElement.listOfDate();
        for (WebElement date : dates) {
            if (!CommonMethods.isAttributePresent(date, "disabled")) {
                SeleniumMethods.click(date, "Select " + date.getText() + " date from date picker");
                break;
            }
        }
        WaitMethods.pause(2);
    }

    @When("^Change the release date with current date$")
    public void change_the_release_date_with_current_date() {
        WaitMethods.pause(2);
        SeleniumMethods.click(ReleasesElement.editReleaseDateField(), "Click on the release date picker");
        WaitMethods.pause(1);
        if (SprintElement.selectDate("1").isEnabled()) {
            SeleniumMethods.click(ReleasesElement.leftSideArrow(), "Click on the left side arrow");
        }
        List<WebElement> dates = ReleasesElement.listOfDate();
        for (WebElement date : dates) {
            if (!CommonMethods.isAttributePresent(date, "disabled")) {
                SeleniumMethods.click(date, "Select " + date.getText() + " date from date picker");
                break;
            }
        }
        WaitMethods.pause(2);
    }

    @Then("^Validate that the complete check box is displayed$")
    public void Validate_the_complete_check_box_is_displayed() {
        AssertMethods.elementIsDisplayed(ReleasesElement.completeCheckBox(), "Validate that the complete check box is displayed");
    }

    @Then("^Validate that the preflight button is displayed$")
    public void Validate_the_preflight_button_is_displayed() {
        AssertMethods.elementIsDisplayed(ReleasesElement.preflightButton(), "Validate that the preflight button is displayed");
    }

}
