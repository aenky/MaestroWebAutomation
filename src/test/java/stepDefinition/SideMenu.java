package stepDefinition;

import CommonUtility.AssertMethods;
import CommonUtility.CommonMethods;
import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.WebElement;
import pom.SideMenuElement;
import java.awt.*;

public class SideMenu {

    @And("^Validate the side menu is displayed$")
    public void Validate_the_side_menu_is_displayed() {
        WaitMethods.pause(3);
        AssertMethods.elementIsDisplayed(SideMenuElement.leftSideNavigationMenu(),"Validate the side menu is displayed");
        WaitMethods.pause(3);
    }

    @When("Move cursor on side menu")
    public void move_cursor_on_side_menu() {
        WaitMethods.pause(2);
        SeleniumMethods.moveCursorOnElement(SideMenuElement.leftSideNavigationMenu(),"Move cursor on side menu");
    }

    @Then("^Validate the side menu is expand and displayed menu name$")
    public void validate_the_side_menu_is_expand_and_displayed_menu_name() {
        AssertMethods.elementIsDisplayed(SideMenuElement.peopleTabTextOnSideMenu(),"Validate the side menu is expand and displayed menu name");
    }

    @When("Move cursor on search textbox")
    public void move_cursor_on_search_textbox() {
        SeleniumMethods.moveCursorOnElement(SideMenuElement.searchNuggetTextBox(),"Move cursor on search textbox");
    }

    @Then("^Validate the side menu is collapse and menu name is not Displayed$")
    public void validate_the_side_menu_is_collapse_and_menu_name_is_not_displayed() {
        AssertMethods.elementIsNotDisplayed(SideMenuElement.peopleTabTextOnSideMenu(),"Validate the side menu is collapse and menu name is not Displayed");
    }

    @When("Click on people option from side menu")
    public void Click_on_people_option_from_side_menu() {
        clickOnSideMenuOption(SideMenuElement.peopleIconOnSideMenu(), "Click on people option from side menu");
    }

    @Then("^Validate the current page URL has \"([^\"]*)\" end point$")
    public void validate_the_side_menu_is_collapse_and_menu_name_is_not_displayed(String endPoint) {
        WaitMethods.pause(3);
        String currentURL = SeleniumMethods.getCurrentURL("Get Current URL");
        AssertMethods.elementTextIsEndWith(currentURL,endPoint,"Validate the current page URL has "+endPoint+" end point");
    }

    @Then("^Validate that the search user textbox is displayed$")
    public void Validate_the_search_user_textbox_is_displayed() {
        AssertMethods.elementIsDisplayed(SideMenuElement.searchUserTextBox(),"Validate that the search user textbox is displayed");
    }

    @When("Click on the channel option from side menu")
    public void Click_on_group_option_from_side_menu() {
        clickOnSideMenuOption(SideMenuElement.groupIconOnSideMenu(), "Click on channel option from side menu");
    }

    @Then("^Validate the search group textbox is displayed$")
    public void Validate_the_search_group_textbox_is_displayed() {
        AssertMethods.elementIsDisplayed(SideMenuElement.searchGroupTextBox(),"Validate the search group textbox is displayed");
    }

    @When("Click on nuggets option from side menu")
    public void Click_on_nuggets_option_from_side_menu() {
        clickOnSideMenuOption(SideMenuElement.nuggetsIconOnSideMenu(),"Click on nuggets option from side menu");
    }

    @Then("^Validate the unread tab is displayed on top menu$")
    public void Validate_the_unread_tab_is_displayed() {
        AssertMethods.elementIsDisplayed(SideMenuElement.unreadNuggetTab(),"Validate the unread tab is displayed on top menu");
    }

    @When("Click on assignment option from side menu")
    public void Click_on_assignment_option_from_side_menu() {
        clickOnSideMenuOption(SideMenuElement.assignmentIconOnSideMenu(),"Click on assignment option from side menu");

    }

    @Then("^Validate the in progress tab is displayed on top menu$")
    public void Validate_the_inProgress_tab_is_displayed() {
        AssertMethods.elementIsDisplayed(SideMenuElement.inProgressNuggetTab(),"Validate the in progress tab is displayed on top menu");
    }

    @When("Click on team lead option from side menu")
    public void Click_on_team_lead_option_from_side_menu() {
        clickOnSideMenuOption(SideMenuElement.teamLeadIconOnSideMenu(),"Click on team lead option from side menu");

    }

    @Then("^Validate the approval due tab is displayed on top menu$")
    public void Validate_the_approval_due_tab_is_displayed() {
        AssertMethods.elementIsDisplayed(SideMenuElement.approvalDueNuggetTab(),"Validate the approval due tab is displayed on top menu");
    }

    @When("Click on good news option from side menu")
    public void Click_on_good_news_option_from_side_menu() {
        clickOnSideMenuOption(SideMenuElement.goodNewsIconOnSideMenu(),"Click on good news option from side menu");

    }

    @Then("^Validate the triage tab is displayed on top menu$")
    public void Validate_the_triage_tab_is_displayed() {
        AssertMethods.elementIsDisplayed(SideMenuElement.triageNuggetTab(),"Validate the triage tab is displayed on top menu");
    }

    @When("Click on bad news option from side menu")
    public void Click_on_bad_news_option_from_side_menu() {
        clickOnSideMenuOption(SideMenuElement.badNewsIconOnSideMenu(),"Click on bad news option from side menu");

    }

    @Then("^Validate the overdue triage tab is displayed on top menu$")
    public void Validate_the_overdue_triage_tab_is_displayed() {
        AssertMethods.elementIsDisplayed(SideMenuElement.overdueTriageNuggetTab(),"Validate the overdue triage tab is displayed on top menu");
    }

    @When("Click on dashboard option from side menu")
    public void Click_on_dashboard_option_from_side_menu() {
        //WaitMethods.pause(3);
        //SeleniumMethods.moveCursorOnElement(SideMenuElement.leftSideNavigationMenu(),"Move cursor on side menu");
        clickOnSideMenuOption(SideMenuElement.projectsIconOnSideMenu(),"Click on dashboard option from side menu");
    }

    @When("Validate the login page is displayed")
    public void Validate_the_login_page_is_displayed() {
        WaitMethods.pause(3);
        AssertMethods.elementIsDisplayed(SideMenuElement.loginPageHeading(),"Validate the login page is displayed");
    }

    @When("Click on logout option from side menu")
    public void Click_on_logout_option_from_side_menu() {
        WaitMethods.pause(3);
        move_cursor_on_side_menu();
        SeleniumMethods.click(SideMenuElement.logoutNavigationMenuOption(),"Click on logout option from side menu");
        WaitMethods.pause(40);
        WaitMethods.pause(40);
        WaitMethods.pause(40);
        WaitMethods.pause(40);
        WaitMethods.pause(40);


    }

    @When("Click on the logout option from side menu")
    public void Click_on_the_logout_option_from_side_menu() {
        WaitMethods.pause(3);
        move_cursor_on_side_menu();
        SeleniumMethods.click(SideMenuElement.logoutNavigationMenuOption(),"Click on logout option from side menu");
        WaitMethods.pause(30);
        SeleniumMethods.refreshPage();
        WaitMethods.pause(2);


    }

    @Then("^Validate the active sprints tab is displayed on sub menu of dashboard$")
    public void Validate_the_active_sprints_tab_is_displayed() {
        AssertMethods.elementIsDisplayed(SideMenuElement.activeSprintsNuggetTab(),"Validate the active sprints tab is displayed on sub menu of dashboard");
    }

    @When("Click on Releases option from side menu")
    public void Click_on_releases_option_from_side_menu() {
        //WaitMethods.pause(3);
        //SeleniumMethods.moveCursorOnElement(SideMenuElement.leftSideNavigationMenu(),"Move cursor on side menu");
        clickOnSideMenuOption(SideMenuElement.releasesIconOnSideMenu(),"Click on Releases option from side menu");

    }

    @Then("^Validate the active releases tab is displayed on top menu$")
    public void Validate_the_active_releases_tab_is_displayed() {
        AssertMethods.elementIsDisplayed(SideMenuElement.activeReleasesTab(),"Validate the active releases tab is displayed on top menu");
    }

    @When("Click on the setting option from side menu")
    public void Click_on_setting_option_from_side_menu() {
        clickOnSideMenuOption(SideMenuElement.settingIconOnSideMenu(),"Click on Setting option from side menu");
    }

    public void clickOnSideMenuOption(WebElement element, String log){
        WaitMethods.pause(5);
        try {
            move_cursor_on_side_menu();
            SeleniumMethods.click(element,log);
        } catch (Exception e) {
            SeleniumMethods.refreshPage();
            WaitMethods.pause(5);
            move_cursor_on_side_menu();
            SeleniumMethods.click(element,log);
        }
    }

    @When("Zoom-In the page section")
    public void Zoom_In_the_page_section() throws AWTException {
        WaitMethods.pause(3);
        CommonMethods.browserZoomIn();
        CommonMethods.browserZoomIn();

    }

    @Then("^Validate the User setting menu is displayed on setting page$")
    public void Validate_the_User_setting_menu_is_displayed() {
        AssertMethods.elementIsDisplayed(SideMenuElement.userSettingMenu(),"Validate the User setting menu is displayed on setting page");
    }

    @Then("^Validate the inbox option is displayed on side navigation menu$")
    public void Validate_the_inbox_option_is_displayed_on_side_navigation_menu() {
        AssertMethods.elementIsDisplayed(SideMenuElement.inboxNavigationMenuOption(),"Validate the inbox option is displayed on side navigation menu");
    }

    @Then("^Validate the people option is displayed on side navigation menu$")
    public void Validate_the_people_option_is_displayed_on_side_navigation_menu() {
        AssertMethods.elementIsDisplayed(SideMenuElement.peopleNavigationMenuOption(),"Validate the people option is displayed on side navigation menu");
    }

    @Then("^Validate the channel option is displayed on side navigation menu$")
    public void Validate_the_group_option_is_displayed_on_side_navigation_menu() {
        AssertMethods.elementIsDisplayed(SideMenuElement.groupNavigationMenuOption(),"Validate the channel option is displayed on side navigation menu");
    }

    @Then("^Validate the my nuggets option is displayed on side navigation menu$")
    public void Validate_the_nuggets_option_is_displayed_on_side_navigation_menu() {
        AssertMethods.elementIsDisplayed(SideMenuElement.nuggetsNavigationMenuOption(),"Validate the my nuggets option is displayed on side navigation menu");
    }

    @Then("^Validate the logout option is displayed on side navigation menu$")
    public void Validate_the_logout_option_is_displayed_on_side_navigation_menu() {
        SeleniumMethods.moveCursorOnElement(SideMenuElement.leftSideNavigationMenu(),"Move cursor on side menu");
        AssertMethods.elementIsDisplayed(SideMenuElement.logoutNavigationMenuOption(),"Validate the logout option is displayed on side navigation menu");
    }

    @Then("^Validate the assignment option is displayed on side navigation menu$")
    public void Validate_the_assignment_option_is_displayed_on_side_navigation_menu() {
        AssertMethods.elementIsDisplayed(SideMenuElement.assignmentNavigationMenuOption(),"Validate the assignment option is displayed on side navigation menu");
    }

    @Then("^Validate the dashboard option is displayed on side navigation menu$")
    public void Validate_the_dashboard_option_is_displayed_on_side_navigation_menu() {
        AssertMethods.elementIsDisplayed(SideMenuElement.projectsNavigationMenuOption(),"Validate the dashboard option is displayed on side navigation menu");
    }

    @Then("^Validate the releases option is displayed on side navigation menu$")
    public void Validate_the_releases_option_is_displayed_on_side_navigation_menu() {
        AssertMethods.elementIsDisplayed(SideMenuElement.releasesNavigationMenuOption(),"Validate the releases option is displayed on side navigation menu");
    }

    @Then("^Validate the report option is displayed on side navigation menu$")
    public void Validate_the_report_option_is_displayed_on_side_navigation_menu() {
        AssertMethods.elementIsDisplayed(SideMenuElement.reportNavigationMenuOption(),"Validate the report option is displayed on side navigation menu");
    }

    @Then("^Validate the setting option is displayed on side navigation menu$")
    public void Validate_the_setting_option_is_displayed_on_side_navigation_menu() {
        AssertMethods.elementIsDisplayed(SideMenuElement.settingsNavigationMenuOption(),"Validate the setting option is displayed on side navigation menu");
    }

    @Then("^Validate the team lead option is displayed on side navigation menu$")
    public void Validate_the_team_lead_option_is_displayed_on_side_navigation_menu() {
        AssertMethods.elementIsDisplayed(SideMenuElement.teamLeadNavigationMenuOption(),"Validate the team lead option is displayed on side navigation menu");
    }

    @Then("^Validate the good news option is displayed on side navigation menu$")
    public void Validate_the_good_news_option_is_displayed_on_side_navigation_menu() {
        AssertMethods.elementIsDisplayed(SideMenuElement.goodNewsNavigationMenuOption(),"Validate the good news option is displayed on side navigation menu");
    }

    @Then("^Validate the bad news option is displayed on side navigation menu$")
    public void Validate_the_bad_news_option_is_displayed_on_side_navigation_menu() {
        AssertMethods.elementIsDisplayed(SideMenuElement.badNewsNavigationMenuOption(),"Validate the bad news option is displayed on side navigation menu");
    }

    @When("Click on inbox option from side menu")
    public void Click_on_inbox_option_from_side_menu() {
        clickOnSideMenuOption(SideMenuElement.inboxIconOnSideMenu(),"Click on inbox option from side menu");

    }

    @Then("^Validate the nuggets tab is displayed on top menu$")
    public void Validate_the_nugget_tab_is_displayed() {
        AssertMethods.elementIsDisplayed(SideMenuElement.nuggetsTab(),"Validate the nuggets tab is displayed on top menu");
    }

    @When("Click on report option from side menu")
    public void Click_on_report_option_from_side_menu() {
        //WaitMethods.pause(3);
        //move_cursor_on_side_menu();
        clickOnSideMenuOption(SideMenuElement.reportIconOnSideMenu(),"Click on report option from side menu");

    }

    @Then("^Validate the in progress tab is displayed on top menu of report page$")
    public void Validate_the_in_progress_tab_is_displayed_of_Report() {
        AssertMethods.elementIsDisplayed(SideMenuElement.inProgressReportTab(),"Validate the in progress tab is displayed on top menu of report page");
    }

}
