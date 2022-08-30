package stepDefinition;

import CommonUtility.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import pom.LoginElement;
import pom.PeopleElement;
import pom.SCB_TC_Channel_PeopleElement;


public class SCB_TC_Channel_People {

    public static int badgeCount=0;
    public static int totalBadgeCount=0;
    WebDriver newDriver=null;
    public static String chatMessage="";
    ConfigMethods config=new ConfigMethods();

    @When("^Get the channel icon badge count$")
    public void get_the_channel_icon_badge_count() {
        if (SCB_TC_Channel_PeopleElement.channelBadgeCountDivList().size() == 1) {
            badgeCount = 0;
        } else {
            badgeCount = Integer.parseInt(SeleniumMethods.getElementText(SCB_TC_Channel_PeopleElement.channelIconBadgeCount(), "Get the channel icon badge count"));

        }
    }

    @When("^Get the people icon badge count$")
    public void get_the_people_icon_badge_count() {
        if (SCB_TC_Channel_PeopleElement.peopleBadgeCountDivList().size() == 1) {
            badgeCount = 0;
        } else {
            badgeCount = Integer.parseInt(SeleniumMethods.getElementText(SCB_TC_Channel_PeopleElement.peopleIconBadgeCount(), "Get the people icon badge count"));

        }
    }

    @When("^Get the \"([^\"]*)\" channel badge count$")
    public void get_the_channel_badge_count(String channelName) {
        if (SCB_TC_Channel_PeopleElement.channelBadgeCountDivList(channelName).size() == 1) {
            badgeCount = 0;
        } else {
            badgeCount = Integer.parseInt(SeleniumMethods.getElementText(SCB_TC_Channel_PeopleElement.channelBadgeCount(channelName), "Get the channel badge count"));

        }
    }

    @When("^Open new browser and open maestro website$")
    public void open_new_browser_and_open_maestro_website() {
        newDriver=SeleniumMethods.initBrowser();
        String url=config.getBaseURL();
        newDriver.get(url);
    }

    @When("^Click on the \"([^\"]*)\" channel from the list$")
    public void Click_on_the_channel_from_the_list(String channelName) {
        for(WebElement element:SCB_TC_Channel_PeopleElement.chatUserList(newDriver)) {
            if(element.getText().equalsIgnoreCase(channelName)) {
                element.click();
                CommonMethods.logInfo("Click on the "+channelName+" channel from the list");
                WaitMethods.pause(1);
                break;
            }
        }
    }

    @When("^Click on the \"([^\"]*)\" channel from the channel list$")
    public void Click_on_the_channel_from_the_channel_list(String channelName) {
        for(WebElement element:PeopleElement.chatUserList()) {
            if(element.getText().equalsIgnoreCase(channelName)) {
                element.click();
                CommonMethods.logInfo("Click on the "+channelName+" channel from the channel list");
                WaitMethods.pause(3);
                break;
            }
        }
    }

    @When("^Close the newly opened browser$")
    public void close_the_newly_opened_browser() {
        WaitMethods.pause(2);
        newDriver.quit();
        CommonMethods.logInfo("Newly opened browser is closed!!!");
    }

    @When("^Enter \"([^\"]*)\" on the chat input field$")
    public void enter_message_on_the_chat_input_field(String message) {
        WaitMethods.pause(1);
        chatMessage = message + " " + CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        SeleniumMethods.click(SCB_TC_Channel_PeopleElement.inputChatMessageField(newDriver), "Click on on chat input field");
        SeleniumMethods.sendKey(SCB_TC_Channel_PeopleElement.inputChatMessageField(newDriver), chatMessage, "Enter the "+Nugget.chatMessage+" message on chat input field");
    }

    @When("^Login with the \"([^\"]*)\" role user credentials$")
    public void login_with_the_role_user_credentials(String userRoll) {
        String userEmail= config.userEmail(userRoll);
        String userPass= config.userPassword(userRoll);
        SeleniumMethods.sendKey(SCB_TC_Channel_PeopleElement.loginEmailTextBox(newDriver), userEmail, "Enter Email");
        SeleniumMethods.sendKey(SCB_TC_Channel_PeopleElement.loginPasswordTextBox(newDriver),(userPass),"Enter Password");
    }

    @And("Click on the login button")
    public void Click_on_the_login_button() {
        SeleniumMethods.click(SCB_TC_Channel_PeopleElement.loginButton(newDriver),"Click on login button");
        WaitMethods.pause(2);

    }

    @And("^Validate that the side menu is displayed$")
    public void Validate_that_the_side_menu_is_displayed() {
        WaitMethods.pause(3);
        AssertMethods.elementIsDisplayed(SCB_TC_Channel_PeopleElement.leftSideNavigationMenu(newDriver),"Validate the side menu is displayed");
        WaitMethods.pause(3);
    }

    @When("^Move the cursor on side menu$")
    public void move_the_cursor_on_side_menu() {
        WaitMethods.pause(2);
        SCB_TC_Channel_PeopleElement.moveCursorOnElement(SCB_TC_Channel_PeopleElement.leftSideNavigationMenu(newDriver), newDriver,"Move cursor on side menu");
    }

    @When("^Click on channel option from side menu$")
    public void Click_on_group_option_from_side_menu() {
        clickOnSideMenuOption(SCB_TC_Channel_PeopleElement.groupIconOnSideMenu(newDriver), "Click on channel option from side menu");
    }

    @When("^Click on the people option from side menu$")
    public void Click_on_the_people_option_from_side_menu() {
        clickOnSideMenuOption(SCB_TC_Channel_PeopleElement.peopleIconOnSideMenu(newDriver), "Click on people option from side menu");
    }

    public void clickOnSideMenuOption(WebElement element, String log){
        WaitMethods.pause(5);
        try {
            move_the_cursor_on_side_menu();
            SeleniumMethods.click(element,log);
        } catch (Exception e) {
            SeleniumMethods.refreshPage();
            WaitMethods.pause(5);
            move_the_cursor_on_side_menu();
            SeleniumMethods.click(element,log);
        }
    }
    @When("^Click on the send icon$")
    public void Click_on_the_send_icon() {
        WaitMethods.pause(1);
        SeleniumMethods.click(SCB_TC_Channel_PeopleElement.sendButtonIcon(newDriver), "Click on the chat send icon");
    }

    @Then("^Validate the sent message is displayed on the chat section$")
    public void validate_the_sent_message_is_displayed_on_chat_section() {
        WaitMethods.pause(1);
        AssertMethods.elementIsDisplayed(SCB_TC_Channel_PeopleElement.sentMessage(newDriver,chatMessage), "Validate the sent message is displayed on the chat section");
    }

    @Then("^Validate that the channel icon badge count is increased$")
    public void validate_the_channel_icon_badge_count_is_increased() {
        WaitMethods.pause(2);
        boolean isCount=false;
        int count=Integer.parseInt(SeleniumMethods.getElementText(SCB_TC_Channel_PeopleElement.channelIconBadgeCount(),"Get the channel icon badge count"));
        if(count==badgeCount+1){
            isCount=true;
        }
        AssertMethods.isTrue(isCount, "Validate that the channel icon badge count is increased");

    }

    @Then("^Validate that the \"([^\"]*)\" channel badge count is increased$")
    public void validate_the_channel_badge_count_is_increased(String channelName) {
        WaitMethods.pause(2);
        boolean isCount=false;
        int count=Integer.parseInt(SeleniumMethods.getElementText(SCB_TC_Channel_PeopleElement.channelBadgeCount(channelName),"Get the channel badge count"));
        if(count==badgeCount+1){
            isCount=true;
        }
        AssertMethods.isTrue(isCount, "Validate that the channel badge count is increased");

    }

    @When("^Get the total number of badge count from the channel list$")
    public void get_the_total_number_of_badge_count_from_the_channel_list() {
        int count=0;
        for(WebElement element : SCB_TC_Channel_PeopleElement.badgeCountList()){
            if (element.getText().equals("")) {
                continue;
            } else {
                count = count+Integer.parseInt(element.getText());


            }
        }
        totalBadgeCount=count;
        CommonMethods.logInfo("Total number of badge count from the channel list: "+totalBadgeCount);
    }

    @Then("^Validate that the channel icon badge count and total badge count of the channel name are the same$")
    public void validate_the_channel_icon_badge_count_and_total_badge_count_of_the_channel_name_are_the_same() {
        boolean isCount=false;
        if(totalBadgeCount==badgeCount){
            isCount=true;
        }
        AssertMethods.isTrue(isCount, "Validate that the channel icon badge count and total badge count of the channel name are the same");
    }

    @Then("^Validate that the sent message more option has only the reply option$")
    public void validate_the_sent_message_more_option_has_only_the_reply_option() {
        WaitMethods.pause(2);
        SeleniumMethods.click(SCB_TC_Channel_PeopleElement.threeDotsMenuIcon(newDriver, chatMessage), "Click on the sent message more option icon");
        WaitMethods.pause(1);
        AssertMethods.elementListSizeIsSame(SCB_TC_Channel_PeopleElement.moreOptionMenuList(newDriver),1, "Validate that the option list size is one");
        AssertMethods.elementTextIsEqualTo(SCB_TC_Channel_PeopleElement.moreOptionMenuList(newDriver).get(0),"Reply", "Validate that the only reply option is displayed");
    }

    @Then("^Validate that the two right icon is displayed on read message$")
    public void validate_the_two_right_icon_is_displayed_on_read_message() {
        WaitMethods.pause(2);
        AssertMethods.elementIsDisplayed(SCB_TC_Channel_PeopleElement.readMSgIcon(newDriver, chatMessage), "Validate that the two right icon is displayed on read message");
    }

    @Then("^Validate that the two right icon color code is \"([^\"]*)\"$")
    public void validate_the_two_right_icon_is_color_code(String colorCode) {
        WaitMethods.pause(2);
        String color=SCB_TC_Channel_PeopleElement.readMSgIcon(newDriver, chatMessage).getCssValue("color");
        String textColorCode = Color.fromString(color).asHex();
        CommonMethods.logInfo("Hex code of read message icon:" + textColorCode);
        AssertMethods.textIsEqualTo(textColorCode,colorCode,"Validate that the two right icon color code is "+colorCode);
    }

    @When("^Move cursor on the seen message icon$")
    public void move_cursor_on_the_seen_message_icon() {
        SCB_TC_Channel_PeopleElement.moveCursorOnElement(SCB_TC_Channel_PeopleElement.readMSgIcon(newDriver, chatMessage), newDriver, "Move cursor on the seen message icon");
        WaitMethods.pause(2);
    }

    @Then("^Validate that the seen user list popper is displayed$")
    public void validate_the_seen_user_list_popper_is_displayed() {
        WaitMethods.pause(1);
        AssertMethods.elementIsDisplayed(SCB_TC_Channel_PeopleElement.seenPopper(newDriver), "Validate that the seen user list popper is displayed");
    }

    @When("^Click on the \"([^\"]*)\" user name from the list$")
    public void Click_on_the_user_name_from_the_list(String userName) {
        for(WebElement element:SCB_TC_Channel_PeopleElement.chatUserList(newDriver)) {
            if(element.getText().equalsIgnoreCase(userName)) {
                element.click();
                CommonMethods.logInfo("Click on the "+userName+" user name from the list");
                WaitMethods.pause(1);
                break;
            }
        }
    }

    @Then("^Validate that the people icon badge count is increased$")
    public void validate_the_people_icon_badge_count_is_increased() {
        WaitMethods.pause(2);
        boolean isCount=false;
        int count=Integer.parseInt(SeleniumMethods.getElementText(SCB_TC_Channel_PeopleElement.peopleIconBadgeCount(),"Get the people icon badge count"));
        if(count==badgeCount+1){
            isCount=true;
        }
        AssertMethods.isTrue(isCount, "Validate that the people icon badge count is increased");

    }

    @Then("^Validate that the \"([^\"]*)\" channel badge count is removed$")
    public void validate_the_channel_badge_count_is_removed(String channelName) {
        WaitMethods.pause(2);
        WebElement element=SCB_TC_Channel_PeopleElement.channelBadgeCountNotExist(channelName);
        boolean isTrue=false;
        if(element==null){
            isTrue=true;
        }
        AssertMethods.isTrue(isTrue,"Validate that the "+channelName+" channel badge count is removed");
    }

    @Then("^Validate that the channel icon badge count is decreased$")
    public void validate_the_channel_icon_badge_count_is_decreased() {
        WaitMethods.pause(2);
        boolean isCount=false;
        int count=Integer.parseInt(SeleniumMethods.getElementText(SCB_TC_Channel_PeopleElement.channelIconBadgeCount(),"Get the channel icon badge count"));
        if(count==badgeCount-1){
            isCount=true;
        }
        AssertMethods.isTrue(isCount, "Validate that the channel icon badge count is decreased");

    }

    @When("^Get the \"([^\"]*)\" people badge count$")
    public void get_the_people_badge_count(String peopleName) {
        WebElement element= SCB_TC_Channel_PeopleElement.channelBadgeCountNotExist(peopleName);

        if (element==null) {
            badgeCount = 0;
        } else {
            String count = SeleniumMethods.getElementText(element, "Get the people badge count");
            badgeCount = Integer.parseInt(count);

        }
    }

    @Then("^Validate that the \"([^\"]*)\" people badge count is increased$")
    public void validate_the_people_badge_count_is_increased(String peopleName) {
        WaitMethods.pause(2);
        boolean isCount=false;
        int count=Integer.parseInt(SeleniumMethods.getElementText(SCB_TC_Channel_PeopleElement.channelBadgeCount(peopleName),"Get the people badge count"));
        if(count==badgeCount+1){
            isCount=true;
        }
        AssertMethods.isTrue(isCount, "Validate that the people badge count is increased");

    }

    @When("^Get the total number of badge count from the people list$")
    public void get_the_total_number_of_badge_count_from_the_people_list() {
        int count=0;
        for(WebElement element : SCB_TC_Channel_PeopleElement.badgeCountList()){
            if (element.getText().equals("")) {
                continue;
            } else {
                count = count+Integer.parseInt(element.getText());
            }
        }
        totalBadgeCount=count;
        CommonMethods.logInfo("Total number of badge count from the people list: "+totalBadgeCount);
    }

    @Then("^Validate that the people icon badge count and total badge count of the people name are the same$")
    public void validate_the_people_icon_badge_count_and_total_badge_count_of_the_people_name_are_the_same() {
        boolean isCount=false;
        if(totalBadgeCount==badgeCount){
            isCount=true;
        }
        AssertMethods.isTrue(isCount, "Validate that the people icon badge count and total badge count of the people name are the same");
    }

    @When("^Click on the \"([^\"]*)\" people from the people list$")
    public void Click_on_the_people_from_the_people_list(String peopleName) {
        for(WebElement element:PeopleElement.chatUserList()) {
            if(element.getText().equalsIgnoreCase(peopleName)) {
                element.click();
                CommonMethods.logInfo("Click on the "+peopleName+" people from the people list");
                WaitMethods.pause(3);
                break;
            }
        }
    }

    @Then("^Validate that the \"([^\"]*)\" people badge count is removed$")
    public void validate_the_people_badge_count_is_removed(String userName) {
        WaitMethods.pause(2);
        WebElement element=SCB_TC_Channel_PeopleElement.channelBadgeCountNotExist(userName);
        boolean isTrue=false;
        if(element==null){
            isTrue=true;
        }
        AssertMethods.isTrue(isTrue,"Validate that the "+userName+" people badge count is removed");
    }

    @Then("^Validate that the people icon badge count is decreased$")
    public void validate_the_people_icon_badge_count_is_decreased() {
        WaitMethods.pause(2);
        boolean isCount=false;
        int count;
        if(SCB_TC_Channel_PeopleElement.peopleIconBadgeCountNotExist()==null){
            count=0;
        }
        else {
            count=Integer.parseInt(SeleniumMethods.getElementText(SCB_TC_Channel_PeopleElement.peopleIconBadgeCount(),"Get the people icon badge count"));
        }
        if(count==badgeCount-1){
            isCount=true;
        }
        AssertMethods.isTrue(isCount, "Validate that the people icon badge count is decreased");

    }

}
