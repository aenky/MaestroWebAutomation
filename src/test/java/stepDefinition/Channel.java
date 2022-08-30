package stepDefinition;

import CommonUtility.AssertMethods;
import CommonUtility.CommonMethods;
import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import pom.ChannelElement;
import pom.PeopleElement;
import pom.SideMenuElement;

import java.util.List;

public class Channel {

    public static String channelName="";

    @When("Enter the \"([^\"]*)\" search channel name text")
    public void enter_the_search_user_name_text(String channelName) {
        WaitMethods.pause(1);
        People.searchText = channelName;
        SeleniumMethods.sendKey(SideMenuElement.searchUserTextBox(), People.searchText, "Enter the " + People.searchText + " search channel name text");
    }

    @Then("^Validate that the search channel list is displayed$")
    public void validate_that_the_search_channel_list_is_displayed() {
        WaitMethods.pause(1);
        boolean isTrue = true;
        List<WebElement> userList = PeopleElement.searchUserList();
        if (userList.isEmpty()) {
            AssertMethods.elementTextIsEqualTo(PeopleElement.noResultFound(), "No results found", "Validate that the no results found message is displayed on the list");
        } else {
            for (WebElement element : userList) {
                if (!element.getText().contains(People.searchText)) {
                    isTrue = false;
                    break;
                }
            }
            AssertMethods.isTrue(isTrue,"Validate that the search channel list is displayed");
        }
    }

    @Then("^Validate that the search result is displayed from the channel list$")
    public void validate_that_the_search_result_is_displayed_from_channel_chat_list() {
        boolean isTrue = true;
        List<WebElement> userList = PeopleElement.searchChatUserList();
        for (WebElement element : userList) {
            if (!element.getText().contains(People.searchText)) {
                isTrue = false;
                break;
            }
        }
        AssertMethods.isTrue(isTrue,"Validate that the search result is displayed from the channel list");
    }

    @When("^Click on the any channel from the list$")
    public void Click_on_the_any_channel_from_the_list() {
        SeleniumMethods.click(PeopleElement.chatUserList().get(0), "Click on the any channel from the list");
        WaitMethods.pause(1);
    }

    @When("^Gat the channel name from the list and click on the that channel name$")
    public void gat_the_channel_name_and_click_on_the_channel_from_the_list() {
        for(WebElement element:PeopleElement.chatUserList()) {
            if (element.getText().equals("Auto Ankit")) {
                channelName = element.getText();
                SeleniumMethods.click(element, "Click on the any channel from the list");
            }
        }
    }

    @Then("^Validate that the channel is not selected$")
    public void validate_that_the_channel_is_not_selected() {
        boolean isSelected=false;
        if (PeopleElement.chatUserList().isEmpty()) {
            CommonMethods.logInfo("channels chat List is Empty");
        } else {
            for(WebElement element: PeopleElement.chatUserList()){
                if(element.getAttribute("class").equals("vac-room-item vac-room-selected")){
                    isSelected=true;
                    break;
                }
            }
            AssertMethods.isTrue(!isSelected,"Validate that the channel is not selected");
        }
    }

    @Then("^Validate that the sent message is displayed on the channel chat section$")
    public void validate_that_the_sent_message_is_displayed_on_channel_chat_section() {
        WaitMethods.pause(1);
        AssertMethods.elementIsDisplayed(PeopleElement.sentMessage(Nugget.chatMessage), "Validate that the sent message is displayed on the channel chat section");
    }

    @Then("^Validate that the channel name is displayed on the channel heading section$")
    public void validate_that_the_channel_name_is_displayed_on_the_channel_massage_section() {
        WaitMethods.pause(1);
        AssertMethods.elementTextIsEqualTo(ChannelElement.channelHeading(),channelName, "Validate that the channel name is displayed on the channel massage section");
    }

    @Then("^Validate that the more option is displayed on the channel heading section$")
    public void validate_that_the_more_option_is_displayed_on_the_channel_massage_section() {
        WaitMethods.pause(1);
        AssertMethods.elementIsDisplayed(ChannelElement.moreOption(), "Validate that the more option is displayed on the channel massage section");
    }

    @Then("^Validate that the channel name is displayed on the channels heading section$")
    public void validate_that_the_channel_name_is_displayed_on_the_channels_massage_section() {
        WaitMethods.pause(1);
        AssertMethods.elementIsDisplayed(ChannelElement.channelHeading(), "Validate that the channel name is displayed on the channels massage section");
    }

    @When("^Click on the channel heading$")
    public void Click_on_the_any_channel_heading$() {
        SeleniumMethods.click(ChannelElement.channelHeading(), "Click on the any channel heading$");
    }

    @Then("^Validate that the channel members dialog box is open$")
    public void validate_that_the_channel_members_dialog_box_is_open() {
        WaitMethods.pause(1);
        AssertMethods.elementIsDisplayed(ChannelElement.memberListDialogBoxHeading(), "Validate that the channel members dialog box is open");
    }

    @Then("^Validate that the channel name is displayed on the open dialog box heading$")
    public void validate_that_the_channel_name_is_displayed_on_the_open_dialog_box_heading() {
        WaitMethods.pause(1);
        AssertMethods.elementTextIsStartWith(ChannelElement.memberListDialogBoxHeading().getText(),channelName, "Validate that the channel name is displayed on the open dialog box heading");
    }

    @Then("^Validate that the channel members list is displayed$")
    public void validate_that_the_channel_members_list_is_displayed() {
        WaitMethods.pause(1);
        AssertMethods.elementListIsNotEmpty(ChannelElement.channelMembersList(), "Validate that the channel members list is displayed");
    }

    @Then("^Validate that the channel members dialog box is closed$")
    public void validate_that_the_channel_members_dialog_box_is_closed() {
        boolean isMemberListDialogBox = false;
        try {
            if (ChannelElement.memberListDialogBoxHeading().isDisplayed()) {
                isMemberListDialogBox = true;
            }
        } catch (Exception e) {
        }
        AssertMethods.isTrue(!isMemberListDialogBox, "Validate that the channel members dialog box is closed");
    }

    @When("^Click on the more option icon which is available on the channel heading$")
    public void Click_on_the_more_option_which_is_available_on_the_channel_heading$() {
        SeleniumMethods.click(ChannelElement.moreOption(), "Click on the more option icon which is available on the channel heading");
    }

    @When("^Click on the leave option$")
    public void Click_on_the_leave_option$() {
        SeleniumMethods.click(ChannelElement.leaveOption(), "Click on the leave option");
    }

    @Then("^Validate that the channel name is removed from the channel list$")
    public void validate_that_the_channel_name_is_removed_from_the_channel_list() {
        WaitMethods.pause(1);
        boolean isTrue = true;
        List<WebElement> userList = PeopleElement.searchChatUserList();
        for (WebElement element : userList) {
            if (element.getText().contains(channelName)) {
                isTrue = false;
                break;
            }
        }
        AssertMethods.isTrue(isTrue,"Validate that the channel name is removed from the channel list");
    }

    @When("^Click on the listed channel name$")
    public void Click_on_the_listed_channel_name$() {
        SeleniumMethods.click(PeopleElement.searchUserList().get(0), "Click on the listed channel name");
    }

    @Then("^Validate that the join channel name is displayed on the list$")
    public void validate_that_the_join_channel_name_is_displayed_on_the_list() {
        WaitMethods.pause(1);
        boolean isTrue = false;
        List<WebElement> userList = PeopleElement.searchChatUserList();
        for (WebElement element : userList) {
            if (!element.getText().contains(channelName)) {
                isTrue = true;
                break;
            }
        }
        AssertMethods.isTrue(isTrue,"Validate that the join channel name is displayed on the list");
    }

    @Then("^Validate that the newly join channel is selected$")
    public void validate_that_the_newly_join_channel_is_selected() {
        WaitMethods.pause(2);
        AssertMethods.elementTextIsEndWith(ChannelElement.channelName(channelName).getAttribute("class"),"selected", "Validate that the newly join channel is selected");
    }


}
