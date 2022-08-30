package stepDefinition;


import CommonUtility.AssertMethods;
import CommonUtility.CommonMethods;
import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.JSONArray;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pom.DashboardElement;
import pom.Setting_CalendarElement;
import pom.Setting_ChannelElement;
import pom.SideMenuElement;
import java.awt.*;
import java.util.List;


public class Dashboard {

    public static String projectId;
    public static String projectName = "";
    public static String secondaryMaestro="";

    @Then("^Validate the active project tab is displayed on sub menu of dashboard$")
    public void Validate_the_active_project_tab_is_displayed() {
        AssertMethods.elementIsDisplayed(DashboardElement.activeProjectTab(), "Validate the active project tab is displayed on sub menu of dashboard");
    }

    @Then("^Validate the backlog sprints tab is displayed on sub menu of dashboard$")
    public void Validate_the_backlog_sprints_tab_is_displayed() {
        AssertMethods.elementIsDisplayed(DashboardElement.backlogSprintsTab(), "Validate the backlog sprints tab is displayed on sub menu of dashboard");
    }

    @Then("^Validate the released sprints tab is displayed on sub menu of dashboard$")
    public void Validate_the_released_sprints_tab_is_displayed() {
        AssertMethods.elementIsDisplayed(DashboardElement.releasedSprintsTab(), "Validate the released sprints tab is displayed on sub menu of dashboard");
    }

    @When("Click on active sprints tab")
    public void Click_on_active_sprints_tab() {
        WaitMethods.pause(1);
        SeleniumMethods.click(SideMenuElement.activeSprintsNuggetTab(), "Click on active sprints tab");
    }

    @When("Click on backlog sprints tab")
    public void Click_on_backlog_sprints_tab() {
        WaitMethods.pause(1);
        SeleniumMethods.click(DashboardElement.backlogSprintsTab(), "Click on backlog sprints tab");
    }

    @When("Click on released sprints tab")
    public void Click_on_releases_sprints_tab() {
        WaitMethods.pause(1);
        SeleniumMethods.click(DashboardElement.releasedSprintsTab(), "Click on released sprints tab");
    }

    @Then("^Validate the create project button is displayed$")
    public void Validate_the_create_project_button_is_displayed() {
        WebElement element=DashboardElement.createProjectButton();
        AssertMethods.elementIsDisplayed(element, "Validate the released sprints tab is displayed on sub menu of dashboard");
    }

    @When("Click on the create project button")
    public void Click_on_the_create_project_button() {
        SeleniumMethods.click(DashboardElement.createProjectButton(), "Click on the create project button");
    }

    @Then("^Validate create project heading is displayed on open dialog box$")
    public void Validate_the_create_project_heading_is_displayed_on_open_dialog_box() {
        AssertMethods.elementTextIsEqualToIgnoreCase(DashboardElement.createProjectDialogboxHeading(), "create project", "Validate create project heading is displayed on open dialog box");
    }

    @Then("^Validate the close icon is displayed on create project dialog box$")
    public void Validate_the_close_icon_is_displayed() {
        AssertMethods.elementIsDisplayed(DashboardElement.closeIcon(), "Validate the close icon is displayed on create project dialog box");
    }

    @When("^Click on the close icon of create project dialog box$")
    public void Click_on_the_close_icon_of_create_project_dialog_box() {
        SeleniumMethods.click(DashboardElement.closeIcon(), "Click on the close icon of create project dialog box");
    }

    @Then("^Validate that the create button is disabled$")
    public void Validate_the_create_button_is_disabled() {
        WaitMethods.pause(2);
        AssertMethods.elementAttributeValueIsEqualTo(DashboardElement.createButton(), "disabled", "true", "Validate the create button is disabled");
    }

    @When("Select workflow from dropdown")
    public void select_workflow_from_dropdown() {
        SeleniumMethods.click(DashboardElement.projectWorkflowField(), "Click on the workflow dropdown");
        SeleniumMethods.click(DashboardElement.projectWorkflowList().get(0), "Select workflow from dropdown");
    }

    @When("Select \"([^\"]*)\" status from dropdown")
    public void select_status_from_dropdown(String status) {
        DashboardElement.projectStatusField().click();
        List<WebElement> statusList = DashboardElement.projectStatusList();
        for (WebElement element : statusList) {
            if (element.getText().equalsIgnoreCase(status)) {
                SeleniumMethods.click(element, "Select " + status + " status from dropdown");
            }
        }
    }

    @When("Select project maestro from dropdown")
    public void select_project_maestro_from_dropdown() {
        SeleniumMethods.click(DashboardElement.projectMaestroField(), "Click on project maestro dropdown");
        WaitMethods.pause(1);
        SeleniumMethods.click(DashboardElement.projectMaestroList().get(0), "Select project maestro from dropdown");
    }

    @When("Select secondary maestro from dropdown")
    public void select_secondary_maestro_from_dropdown() {
        WaitMethods.pause(2);
        SeleniumMethods.click(DashboardElement.secondaryMaestroField(), "Click on secondary maestro dropdown");
        SeleniumMethods.click(DashboardElement.secondaryMaestroList().get(1), "Select secondary maestro from dropdown");
    }

    @When("Enter project name on title field")
    public void enter_project_name_on_title_field() {
        String timeStamp = CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        projectName = "Automation Test " + timeStamp;
        SeleniumMethods.sendKey(DashboardElement.projectTitleField(), projectName, "Enter project name");
    }

    @Then("^Validate that the create button is Enable$")
    public void Validate_the_create_button_is_Enable() {
        AssertMethods.elementIsEnabled(DashboardElement.createButton(), "Validate the create button is Enable");
    }

    @Then("^Validate the create project button is not Displayed$")
    public void Validate_the_create_project_button_is_not_Displayed() {
        boolean isCreateProjectButton = false;
        WaitMethods.pause(2);
        try {
            if (DashboardElement.createProjectButtons().isDisplayed()) {
                isCreateProjectButton = true;
            }
        } catch (Exception e) {
        }

        Assert.assertTrue(!isCreateProjectButton);
        CommonMethods.logInfo("Validate the create project button is not Displayed");

    }

    @Then("^Validate the successfully created project toast notification message is displayed$")
    public void Validate_the_successfully_created_project_toast_notification_message() {
        AssertMethods.elementTextIsStartWith(DashboardElement.toastNotificationPopup().getText(), "Successfully created", "Validate the successfully created project toast notification message is displayed");
    }

    @When("Click on the create button")
    public void Click_on_the_create_button() {
        SeleniumMethods.click(DashboardElement.createButton(), "Click on the create button");
    }

    @And("Click on the first project from list")
    public void Click_on_the_first_project_from_list() {
        SeleniumMethods.click(DashboardElement.projectList().get(0), "Click on the first project from list");
    }

    @And("Update the project title name")
    public void Update_the_project_title_name() {
        String editProjectName = "Update Project " + CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        WebElement el = DashboardElement.editProjectName();
        el.sendKeys(Keys.CONTROL + "A");
        el.sendKeys(Keys.DELETE);
        WaitMethods.pause(2);
        SeleniumMethods.sendKey(el, editProjectName, "Update the project Name");
        WaitMethods.pause(2);

    }

    @When("Click on the save button")
    public void click_on_the_save_button() {
        WaitMethods.pause(2);
        SeleniumMethods.click(DashboardElement.saveButton(), "Click on the save button");
    }

    @When("Wait for \"([^\"]*)\" sec")
    public void wait_for_sec(String sec) {
        WaitMethods.pause(Integer.parseInt(sec));
    }

    @Then("^Validate the successfully updated project details toast notification message is displayed$")
    public void validate_the_successfully_updated_project_toast_notification_message() {
        WaitMethods.pause(3);
        AssertMethods.elementTextIsStartWith(DashboardElement.toastNotificationPopup().getText(), "Successfully updated", "Validate the successfully updated project details toast notification message is displayed");
    }

    @And("Change the project maestro")
    public void change_the_project_maestro() {
        SeleniumMethods.click(DashboardElement.editProjectMaestroDropdown(), "Click on the project maestro dropdown");
        SeleniumMethods.click(DashboardElement.projectMaestroList().get(3), "Select the project maestro");
    }

    @And("Change the secondary maestro")
    public void change_the_secondary_maestro() {
        SeleniumMethods.click(DashboardElement.editSecondaryMaestroDropdown(), "Click on the secondary maestro dropdown");
        secondaryMaestro= DashboardElement.secondaryMaestroList().get(5).getText();
        SeleniumMethods.click(DashboardElement.secondaryMaestroList().get(5), "Select the secondary maestro");
    }

    @And("Update the project description")
    public void update_the_project_description() {
        WebElement el = DashboardElement.editDescriptionTextBox();
        el.sendKeys(Keys.CONTROL + "A");
        el.sendKeys(Keys.DELETE);
        WaitMethods.pause(2);
        SeleniumMethods.sendKey(el, "Update the project details", "Update the project description");
    }

    @When("Change \"([^\"]*)\" status from dropdown")
    public void change_status_from_dropdown(String status) {
        DashboardElement.editProjectStatusField().click();
        List<WebElement> statusList = DashboardElement.projectStatusList();
        for (WebElement element : statusList) {
            if (element.getText().equalsIgnoreCase(status)) {
                SeleniumMethods.click(element, "Select " + status + " status from dropdown");
            }
        }
    }

    @Then("^Validate the project name field is disable$")
    public void Validate_the_project_name_field_is_disabled() {
        AssertMethods.elementAttributeValueIsEqualTo(DashboardElement.editProjectName(), "disabled", "true", "Validate the project name field is disable");
    }

    @Then("^Validate the project status dropdown is disable$")
    public void validate_the_project_status_dropdown_is_disabled() {
        AssertMethods.elementAttributeValueIsEqualTo(DashboardElement.editProjectStatusField(), "disabled", "true", "Validate the project status dropdown is disable");
    }

    @Then("^Validate the project maestro dropdown is disable$")
    public void validate_the_project_maestro_dropdown_is_disabled() {
        AssertMethods.elementAttributeValueIsEqualTo(DashboardElement.editProjectMaestroDropdown(), "disabled", "true", "Validate the project maestro dropdown is disable");
    }

    @Then("^Validate the Secondary maestro dropdown is disable$")
    public void validate_the_secondary_maestro_dropdown_is_disabled() {
        AssertMethods.elementAttributeValueIsEqualTo(DashboardElement.editSecondaryMaestroDropdown(), "disabled", "true", "Validate the Secondary maestro dropdown is disable");
    }

    @Then("^Validate all listed project status is Active$")
    public void validate_all_listed_project_status_is_Active() {
        List<WebElement> listOfStatus = DashboardElement.listOfProjectStatus();

        for (WebElement element : listOfStatus) {
            AssertMethods.elementTextIsEqualToIgnoreCase(element, "Active", "Validate the listed project status is Active");
        }

    }

    @Then("^Validate the project description field is disable$")
    public void Validate_the_project_description_field_is_disabled() {
        AssertMethods.elementAttributeValueIsEqualTo(DashboardElement.editDescriptionTextBox(), "disabled", "true", "Validate the project description field is disable");
    }

    @Then("^Validate all the column name in the active project tab$")
    public void validate_all_the_column_name_in_the_active_project_tab() {
        List<WebElement> listOfColumnHeading = DashboardElement.listOfProjectColumnHeading();
        AssertMethods.elementTextIsEqualToIgnoreCase(listOfColumnHeading.get(0), "Id", "Validate the Id column name in the active project tab");
        AssertMethods.elementTextIsEqualToIgnoreCase(listOfColumnHeading.get(1), "Name", "Validate the Name column name in the active project tab");
        AssertMethods.elementTextIsEqualToIgnoreCase(listOfColumnHeading.get(2), "Alert", "Validate the Alert column name in the active project tab");
        AssertMethods.elementTextIsEqualToIgnoreCase(listOfColumnHeading.get(3), "Tempo", "Validate the Tempo column name in the active project tab");
        AssertMethods.elementTextIsEqualToIgnoreCase(listOfColumnHeading.get(4), "Status", "Validate the Status column name in the active project tab");
        AssertMethods.elementTextIsEqualToIgnoreCase(listOfColumnHeading.get(5), "Workflow", "Validate the Workflow column name in the active project tab");
        AssertMethods.elementTextIsEqualToIgnoreCase(listOfColumnHeading.get(6), "Project Maestro", "Validate the Project Maestro column name in the active project tab");
        AssertMethods.elementTextIsEqualToIgnoreCase(listOfColumnHeading.get(7), "Secondary Maestro", "Validate the Secondary Maestro column name in the active project tab");

    }

    @When("Get the first project's ID and Double click on that project")
    public void Get_the_first_projects_ID_and_Double_click_on_that_project() throws AWTException {
        Actions actions = new Actions(ServiceHook.driver);
        List<WebElement> listOfProjectId = DashboardElement.listOfProjectId();
        Dashboard.projectId = listOfProjectId.get(0).getText();
        actions.doubleClick(listOfProjectId.get(0)).perform();
        WaitMethods.pause(1);

    }

    @Then("^Validate the project Id on the redirected tab heading name$")
    public void Validate_the_project_Id_with_redirected_tab_heading_name() {
        String PId="";
        SeleniumMethods.scrollToElementHorizontal(DashboardElement.scrollElement(),5);
        WaitMethods.pause(3);
        List<WebElement> listOfProjectColumnHeading = DashboardElement.listOfDashboardSubTabHeading();
        for(WebElement el: listOfProjectColumnHeading){
            if(el.getText().equalsIgnoreCase(Dashboard.projectId)){
                PId=el.getText();
            }
        }

        AssertMethods.textIsEqualTo(PId, Dashboard.projectId, "Validate the project Id on the redirected tab heading name");
    }

    @Then("^Validate the project details section with the Chat, Details and Attachment section$")
    public void Validate_the_project_details_section_with_the_Chat_Details_and_Attachment_section() {
        AssertMethods.elementIsDisplayed(DashboardElement.chatTabIcon(), "Validate the project details section with the project Chat section");
        AssertMethods.elementIsDisplayed(DashboardElement.detailsTabIcon(), "Validate the project details section with the project Details section");
        AssertMethods.elementIsDisplayed(DashboardElement.chatAttachmentTabIcon(), "Validate the project details section with the project chat Attachment section");

    }

    @Then("^Validate the project nugget list or message is list is empty$")
    public void Validate_the_project_nugget_list_or_message_is_list_is_empty() {
        List<WebElement> listOfProjectColumnHeading = DashboardElement.listOfNugget();
        boolean isTrue = false;
        if (listOfProjectColumnHeading.size() > 0) {
            isTrue = true;
        } else if (DashboardElement.emptyListMessage().isDisplayed()) {
            isTrue = true;
        }
        Assert.assertTrue(isTrue);
        CommonMethods.logInfo("Validate the project nugget list or message is list is empty");

    }

    @When("Click on the project chat tab")
    public void Click_on_the_nugget_chat_tab() {
        SeleniumMethods.click(DashboardElement.chatTabIcon(), "Click on the project chat tab");
    }

    @Then("^Validate the system is displayed the chat section$")
    public void Validate_the_system_is_displayed_the_chat_section() {
        AssertMethods.elementTextIsEndWith(DashboardElement.chatTabIcon().getAttribute("class"), "active", "Validate the system is displayed the chat section");
    }

    @When("Click on the project details tab")
    public void Click_on_the_project_details_tab() {
        SeleniumMethods.click(DashboardElement.detailsTabIcon(), "Click on the project details tab");
    }

    @Then("^Validate the system is displayed the project details section$")
    public void Validate_the_system_is_displayed_the_project_details_section() {
        AssertMethods.elementTextIsEndWith(DashboardElement.detailsTabIcon().getAttribute("class"), "active", "Validate the system is displayed the project details section");
        AssertMethods.elementIsDisplayed(DashboardElement.editProjectName(), "Validate the system is displayed the edit project name field");
        AssertMethods.elementIsDisplayed(DashboardElement.editDescriptionTextBox(), "Validate the system is displayed the edit project description field");
    }

    @When("Click on the project attachment tab")
    public void Click_on_the_project_attachment_tab() {
        SeleniumMethods.click(DashboardElement.chatAttachmentTabIcon(), "Click on the project attachment tab");
    }

    @Then("^Validate the system is displayed the project chat attachment section$")
    public void Validate_the_system_is_displayed_the_project_chat_attachment_section() {
        AssertMethods.elementTextIsEndWith(DashboardElement.chatAttachmentTabIcon().getAttribute("class"), "active", "Validate the system is displayed the project chat attachment section");
    }

    @Then("^Validate that the created project is displayed in the List$")
    public void Validate_the_created_project_is_displayed_in_the_List() {
        WaitMethods.pause(2);
        AssertMethods.elementTextIsEqualTo(DashboardElement.createdProjectName(), projectName, "Validate that the created project is displayed in the List");
    }

    @Then("^Validate that the created project is highlighted in the List$")
    public void validate_the_created_project_is_highlighted_in_the_List() {
        AssertMethods.elementTextIsEndWith(DashboardElement.createdProjectRow(projectName).getAttribute("class"), "active", "Validate that the created project is highlighted in the List");
    }

    @When("Remove active status from project status filter")
    public void remove_active_status_from_project_status_filter() {
        SeleniumMethods.click(DashboardElement.statusHeader(), "Click on the status header");
        SeleniumMethods.click(DashboardElement.filterOption(), "Click on the filter option");
        SeleniumMethods.click(DashboardElement.filterCheckBoxOption("Active"), "Click on the active filter option");
        SeleniumMethods.click(DashboardElement.applyFilterButton(), "Click on the apply filter button");
        WaitMethods.pause(2);
    }

    @When("Click on the status filter option")
    public void click_on_status_filter_option() {
        SeleniumMethods.click(DashboardElement.statusHeader(), "Click on the status filter option");
    }

    @When("Select \"([^\"]*)\" status from filter list")
    public void select_status_from_filter_list(String status) {
        String[] statusList = new String[0];

        SeleniumMethods.click(DashboardElement.filterOption(), "Click on the filter option");
        if (status.contains(",")) {
            statusList = status.split(",");
            for (String text : statusList) {
                SeleniumMethods.click(DashboardElement.filterCheckBoxOption(text.trim()), "Click on the " + text + " filter option");
            }
        }
        else {
            SeleniumMethods.click(DashboardElement.filterCheckBoxOption(status), "Click on the " + status + " filter option");
        }
        SeleniumMethods.click(DashboardElement.applyFilterButton(), "Click on the apply filter button");
    }

    @Then("^Validate the all listed project status is \"([^\"]*)\"$")
    public void validate_the_all_listed_project_status(String status) {
        WaitMethods.pause(3);
        if (status.equalsIgnoreCase("on hold")) {
            status = "On-hold";
        }
        List<WebElement> projectStatusList = DashboardElement.listOfProjectStatus();
        for (WebElement element : projectStatusList) {
            if (!element.getText().equalsIgnoreCase(status)) {
                AssertMethods.elementTextIsEqualToIgnoreCase(element, status, "Validate that the all project status is " + status);
            }
        }
        CommonMethods.logInfo("Validate that the all project status is " + status);
    }

    @Then("^Validate the all the listed project status is \"([^\"]*)\"$")
    public void validate_the_all_the_listed_project_status(String status) {
        WaitMethods.pause(3);
        String[] statusList = new String[0];
        statusList = status.split(",");

            if (statusList[0].trim().equalsIgnoreCase("on hold")) {
                statusList[0] = "On-hold";
            }
            else if(statusList[1].trim().equalsIgnoreCase("on hold")){
                statusList[1] = "On-hold";
            }

            List<WebElement> projectStatusList = DashboardElement.listOfProjectStatus();
            for (WebElement element : projectStatusList) {
                if (!(element.getText().equalsIgnoreCase(statusList[0].trim()) || element.getText().equalsIgnoreCase(statusList[1].trim()))) {
                    AssertMethods.elementTextIsEqualToIgnoreCase(element, statusList[0], "Validate that the all project status is " + status);
                }
            }
            CommonMethods.logInfo("Validate that the all project status is " + status);

    }

    @Then("^Remove all automation project from list$")
    public void remove_all_automation_project_from_list() {
        WaitMethods.pause(2);
        for (WebElement element : Setting_ChannelElement.channelTypeList()) {
            if (element.getText().startsWith("Automation Test ")) {
                SeleniumMethods.click(element,"Click on project name");
                WaitMethods.pause(1);
                change_status_from_dropdown("On Hold");
                WaitMethods.pause(1);
                click_on_the_save_button();
                WaitMethods.pause(2);
            }
        }



    }


}
