package stepDefinition;

import CommonUtility.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pom.LoginElement;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Login {

    ConfigMethods config=new ConfigMethods();

    @Given("I open Maestro website")
    public void i_open_Maestro_website() {
        String url=config.getBaseURL();
       SeleniumMethods.openURL(url);
    }

    @When("^Enter user email \"([^\"]*)\"$")
    public void enter_user_email(String email) {
        SeleniumMethods.sendKey(LoginElement.loginEmailTextBox(), email, "Enter Email");
    }

    @And("^Enter user password \"([^\"]*)\"$")
    public void enter_user_password(String password) {
        SeleniumMethods.sendKey(LoginElement.loginPasswordTextBox(),(password),"Enter Password");
    }

    @When("^Login with \"([^\"]*)\" role user credentials$")
    public void login_with_role_user_credentials(String userRoll) {
        String userEmail= config.userEmail(userRoll);
        String userPass= config.userPassword(userRoll);
        SeleniumMethods.sendKey(LoginElement.loginEmailTextBox(), userEmail, "Enter Email");
        SeleniumMethods.sendKey(LoginElement.loginPasswordTextBox(),(userPass),"Enter Password");
    }

    @And("Validate the login button is disable")
    public void Validate_the_login_button_is_disable() {
        AssertMethods.elementAttributeValueIsEqualTo(LoginElement.loginButton(),"disabled","true","Validate the login button is disable.");

    }

    @Then("Validate the login button is enable")
    public void Validate_the_login_button_is_enable() {
        AssertMethods.elementIsEnabled(LoginElement.loginButton(),"Validate the login button is enable");
    }

    @Then("Validate the validation message \"([^\"]*)\" is displayed for wrong email Id")
    public void Validate_the_validation_message_is_displayed_for_wrong_email_Id(String message) {
        AssertMethods.elementTextIsEqualToIgnoreCase(LoginElement.wrongEmailAndPasswordValidationMsg(),message,"Validate the validation message "+message+" is displayed for wrong email Id");
    }

    @Then("Validate the validation message \"([^\"]*)\" for invalid email format")
    public void Validate_the_validation_message_is_displayed_for_invalid_email_format(String message) {
        AssertMethods.elementTextIsEqualToIgnoreCase(LoginElement.wrongEmailAndPasswordValidationMsg(),message,"Validate the validation message "+message+" for invalid email format");
        AssertMethods.elementIsDisplayed(LoginElement.wrongEmailAndPasswordValidationMsg(),"Validation message is displayed");

    }

    @And("Click on login button")
    public void Click_on_login_button() throws AWTException {
        SeleniumMethods.click(LoginElement.loginButton(),"Click on login button");
        WaitMethods.pause(2);
        //Robot robot = new Robot();
        //robot.keyPress(KeyEvent.VK_ESCAPE);

    }


    @Then("Validate Maestro logo is displayed")
    public void Validate_Maestro_logo_is_displayed() {
        AssertMethods.elementIsDisplayed(LoginElement.maestroLogo(),"Validate Maestro logo is displayed");
    }

    @Then("Validate User Name Icon is displayed")
    public void Validate_User_Name_Icon_is_displayed() {
        WaitMethods.pause(5);
        AssertMethods.elementIsDisplayed(LoginElement.userProfileImage(),"Validate User Name Icon is displayed");
    }

    @Then("Validate account type dropdown is display")
    public void validate_account_type_dropdown_is_display() {
        AssertMethods.elementIsDisplayed(LoginElement.accountTypeDropdown(),"Validate account type dropdown is display");
    }

    @Then("Validate login button is displayed on select account type page")
    public void validate_login_button_is_displayed_on_select_account_type_page() {
        AssertMethods.elementIsDisplayed(LoginElement.loginButtonOnSelectAccountTypePage(),"Validate login button is displayed on select account type page");
    }


    @And("Click on account type dropdown")
    public void Click_on_account_type_dropdown() {
        SeleniumMethods.click(LoginElement.accountTypeDropdown(), "Click on account type dropdown");
    }

    @Then("Validate list of account type is not empty")
    public void validate_list_of_account_type_is_not_empty() {
        WaitMethods.pause(2);
        AssertMethods.elementListIsNotEmpty(LoginElement.listOfAccountType(),"Validate list of account type is not empty");
    }

    @And("Select \"([^\"]*)\" account type from list")
    public void select_account_type_from_list(String accountType) {
        SeleniumMethods.click(LoginElement.accountType(accountType), "Select "+accountType+" account type from list");
    }


    @And("Click on Login button of account type page")
    public void click_on_login_button_of_account_type_page() {
        SeleniumMethods.click(LoginElement.loginButtonOnSelectAccountTypePage(), "Click on Login button of account type page");
    }

    @And("Click on side Menu")
    public void click_on_side_Menu() {
        SeleniumMethods.click(LoginElement.sideMenu(), "Click on side Menu");
    }

    @Then("Validate account type is \"([^\"]*)\"")
    public void validate_list_of_account_type_is_not_empty(String accountType) {
        WaitMethods.pause(2);
        AssertMethods.elementTextIsEqualToIgnoreCase(LoginElement.accountType(accountType), accountType, "Validate account type is "+accountType);
    }
}
