package stepDefinition;

import CommonUtility.AssertMethods;
import CommonUtility.CommonMethods;
import CommonUtility.SeleniumMethods;
import CommonUtility.WaitMethods;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import pom.*;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class People {

    public static String searchText = "";

    @When("Enter the \"([^\"]*)\" search user name text")
    public void enter_the_search_user_name_text(String userName) {
        WaitMethods.pause(1);
        searchText = userName;
        SeleniumMethods.sendKey(SideMenuElement.searchUserTextBox(), searchText, "Enter the " + searchText + " search user name text");
    }

    @Then("^Validate that the search user list is displayed$")
    public void validate_that_the_search_user_list_is_displayed() {
        WaitMethods.pause(1);
        boolean isTrue = true;
        List<WebElement> userList = PeopleElement.searchUserList();
        if (userList.isEmpty()) {
            AssertMethods.elementTextIsEqualTo(PeopleElement.noResultFound(), "No results found", "Validate that the no results found message is displayed on the list");
        } else {
            for (WebElement element : userList) {
                if (!element.getText().contains(searchText)) {
                    isTrue = false;
                    break;
                }
            }
            Assert.assertTrue(isTrue);
            CommonMethods.logInfo("Validate that the search user list is displayed");
        }
    }

    @Then("^Validate that the no results found message is displayed on the list$")
    public void validate_that_the_no_results_found_message_is_displayed_on_the_list() {
        AssertMethods.elementTextIsEqualTo(PeopleElement.noResultFound(), "No results found", "Validate that the no results found message is displayed on the list");
    }

    @Then("^Validate that the search result is displayed from user chat list$")
    public void validate_that_the_search_result_is_displayed_from_user_chat_list() {
        boolean isTrue = true;
        List<WebElement> userList = PeopleElement.searchChatUserList();
        for (WebElement element : userList) {
            if (!element.getText().contains(searchText)) {
                isTrue = false;
                break;
            }
        }
        Assert.assertTrue(isTrue);
        CommonMethods.logInfo("Validate that the search result is displayed from user chat list");
    }

    @When("^Click on the any user from the list$")
    public void Click_on_the_any_user_from_the_list() {
        SeleniumMethods.click(PeopleElement.chatUserList().get(0), "Click on the any user from the list");
    }

    @Then("^Validate that the list of message is displayed$")
    public void validate_that_the_list_of_message_is_displayed() {
        AssertMethods.elementIsDisplayed(PeopleElement.listOfChatMessages().get(PeopleElement.listOfChatMessages().size()-1), "Validate that the list of message is displayed");
    }

    @Then("^Validate that the user is not selected$")
    public void validate_that_the_user_is_not_selected() {
        boolean isSelected=false;
        if (PeopleElement.chatUserList().isEmpty()) {
            CommonMethods.logInfo("Chat User List is Empty");
        } else {
            for(WebElement element: PeopleElement.chatUserList()){
                if(element.getAttribute("class").equals("vac-room-item vac-room-selected")){
                    isSelected=true;
                    break;
                }
            }
            AssertMethods.isTrue(!isSelected,"Validate that the user is not selected");
        }
    }

    @Then("^Validate that the chat message input field is disabled$")
    public void validate_that_the_chat_message_input_field_is_disabled() {
        boolean isDisabled=false;
        if(PeopleElement.chatInputBox().getAttribute("class").contains("is-disabled")){
            isDisabled=true;
        }
        AssertMethods.isTrue(isDisabled, "Validate that the chat message input field is disabled");
    }

    @Then("^Validate that the media tab is displayed$")
    public void Validate_that_the_media_tab_is_displayed() {
        AssertMethods.elementIsDisplayed(NuggetElement.mediaTab(), "Validate that the system is displayed the media sub tab");
    }

    @Then("^Validate that the document tab is displayed$")
    public void Validate_that_the_document_tab_is_displayed() {
        AssertMethods.elementIsDisplayed(NuggetElement.documentsTab(), "Validate that the system is displayed the document sub tab");
    }

    @Then("^Validate that the links tab is displayed$")
    public void Validate_that_the_links_tab_is_displayed() {
        AssertMethods.elementIsDisplayed(NuggetElement.linkTab(), "Validate that the system is displayed the link sub tab");
    }

    @Then("^Validate that the media tab is selected$")
    public void Validate_that_the_media_tab_is_selected() {
        AssertMethods.elementTextIsEndWith(NuggetElement.mediaTab().getAttribute("class"),"active", "Validate that the media tab is selected");
    }

    @Then("^Validate that the document tab is selected$")
    public void Validate_that_the_document_tab_is_selected() {
        AssertMethods.elementTextIsEndWith(NuggetElement.documentsTab().getAttribute("class"),"active", "Validate that the document tab is selected");
    }

    @Then("^Validate that the links tab is selected$")
    public void Validate_that_the_links_tab_is_selected() {
        AssertMethods.elementTextIsEndWith(NuggetElement.linkTab().getAttribute("class"),"active", "Validate that the links tab is selected");
    }

    @When("^Enter the \"([^\"]*)\" on chat input field$")
    public void enter_the_message_on_chat_input_field(String message) {
        WaitMethods.pause(1);
        Nugget.chatMessage = message + " " + CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        SeleniumMethods.click(PeopleElement.inputChatMessageField(), "Click on on chat input field");
        SeleniumMethods.sendKey(PeopleElement.inputChatMessageField(), Nugget.chatMessage, "Enter the "+Nugget.chatMessage+" message on chat input field");
    }


    @Then("^Validate that the chat input message field is displayed$")
    public void validate_that_the_chat_input_message_field_is_displayed() {
        AssertMethods.elementIsDisplayed(PeopleElement.inputChatMessageField(), "Validate that the chat input message field is displayed");
    }

    @When("^Click on the chat send icon")
    public void Click_on_the_chat_send_icon() {
        WaitMethods.pause(1);
        SeleniumMethods.click(PeopleElement.sendButtonIcon(), "Click on the chat send icon");
        WaitMethods.pause(1);
    }

    @Then("^Validate that the sent message is displayed on the people chat section$")
    public void validate_that_the_sent_message_is_displayed_on_chat_section() {
        WaitMethods.pause(1);
        AssertMethods.elementIsDisplayed(PeopleElement.sentMessage(Nugget.chatMessage), "Validate that the sent message is displayed on the people chat section");
    }

    @Then("^Validate that the more option menu is displayed on the sent message$")
    public void validate_that_the_more_option_menu_is_displayed_on_sent_message() {
        AssertMethods.elementIsDisplayed(PeopleElement.threeDotsMenuIcon(Nugget.chatMessage), "Validate that the more option menu is displayed on the sent message");
    }

    @When("^Click on the more option menu of sent message$")
    public void Click_on_the_more_option_menu() {
        WaitMethods.pause(1);
        SeleniumMethods.click(PeopleElement.threeDotsMenuIcon(Nugget.chatMessage), "Click on the more option menu");
    }

    @Then("^Validate all the option is displayed on the more menu list$")
    public void validate_that_the_option_is_displayed_on_the_list() {
        List<WebElement> optionList = PeopleElement.moreOptionMenuList();
        AssertMethods.elementTextIsEqualTo(optionList.get(0), "Reply", "Validate that the 'Reply' option is displayed");
        AssertMethods.elementTextIsEqualTo(optionList.get(1), "Edit Message", "Validate that the 'Edit Message' option is displayed");
        AssertMethods.elementTextIsEqualTo(optionList.get(2), "Delete Message", "Validate that the 'Delete Message' option is displayed");
    }

    @When("^Click on the reply option from the list$")
    public void Click_on_the_reply_message_option() {
        List<WebElement> optionList = PeopleElement.moreOptionMenuList();
        SeleniumMethods.click(optionList.get(0), "Click on the reply option from the list");
    }

    @When("^Enter the message for the reply message$")
    public void enter_the_message_for_the_reply_message() {
        WaitMethods.pause(1);
        Nugget.chatReplyMessage = "Reply auto test meg " + CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        WebElement inputField = PeopleElement.inputChatMessageField();
        SeleniumMethods.click(inputField, "Click on on chat input field");
        SeleniumMethods.sendKey(inputField, Nugget.chatReplyMessage, "Enter the message for the reply message");
    }

    @When("^Click on the edit message option from the list$")
    public void Click_on_the_edit_message_option() {
        List<WebElement> optionList = PeopleElement.moreOptionMenuList();
        SeleniumMethods.click(optionList.get(1), "Click on the edit message option from the list");
    }

    @When("^Enter new message on the chat input field$")
    public void enter_new_message_on_the_chat_input_field() {
        WaitMethods.pause(1);
        Nugget.chatMessage = "Update auto test meg " + CommonMethods.getCurrentDateTime("yyyyMMddHHmmss");
        WebElement inputField = PeopleElement.inputChatMessageField();
        SeleniumMethods.click(inputField, "Click on chat input field");
        SeleniumMethods.clearField(inputField, "Clear input field");
        WaitMethods.pause(1);
        SeleniumMethods.sendKey(inputField, Nugget.chatMessage, "Enter new message on the chat input field");
        WaitMethods.pause(1);
    }

    @Then("^Validate that the updated sent message is displayed on the chat section$")
    public void validate_that_the_updated_sent_message_is_displayed_on_chat_section() {
        WaitMethods.pause(1);
        AssertMethods.elementIsDisplayed(PeopleElement.sentMessage(Nugget.chatMessage), "Validate that the updated sent message is displayed on the chat section");
    }

    @When("^Click on the delete message option from the list$")
    public void Click_on_the_delete_message_option() {
        List<WebElement> optionList = PeopleElement.moreOptionMenuList();
        SeleniumMethods.clickWithJs(optionList.get(2), "Click on the delete message option from the list");
    }

    @When("^Select the new video file$")
    public void Select_the_new_video_file() {
        WaitMethods.pause(1);
        File file = new File("Files/auto_test_video.mp4");
        String absoluteImagePath = file.getAbsolutePath();
        Nugget.fileName = absoluteImagePath.split("\\\\")[(absoluteImagePath.split("\\\\").length) - 1];
        SeleniumMethods.sendKey(PeopleElement.fileInput(), absoluteImagePath, "Select the new video file");
    }

    @Then("^Validate that the sent video file is displayed on the chat section$")
    public void validate_that_the_sent_video_file_is_displayed_on_the_chat_section() {
        WaitMethods.pause(2);
        List<WebElement> listOfFiles = PeopleElement.sentVideoFileList();
        int fileListSize = listOfFiles.size() - 1;
        AssertMethods.elementTextIsEqualTo(listOfFiles.get(fileListSize), Nugget.fileName, "Validate that the sent audio is displayed on chat section");
        WaitMethods.pause(5);
        List<WebElement> listOfFilesTime = PeopleElement.sentVideoFileTimeList();
        AssertMethods.elementListSizeIsSame(listOfFilesTime, listOfFiles.size(), "Validate that last video file is uploaded");
    }

    @When("^Select the new audio file$")
    public void Select_the_new_audio_file() {
        WaitMethods.pause(1);
        File file = new File("Files/file_example_MP3_700KB.mp3");
        String absoluteImagePath = file.getAbsolutePath();
        Nugget.fileName = absoluteImagePath.split("\\\\")[(absoluteImagePath.split("\\\\").length) - 1];
        SeleniumMethods.sendKey(PeopleElement.fileInput(), absoluteImagePath, "Select the new audio file");
    }

    @Then("^Validate that the sent audio file is displayed on the chat section$")
    public void validate_that_the_sent_audio_file_is_displayed_on_the_chat_section() {
        WaitMethods.pause(2);
        List<WebElement> listOfFiles = PeopleElement.sentAudioFileList();
        int fileListSize = listOfFiles.size() - 1;
        AssertMethods.elementTextIsEqualTo(listOfFiles.get(fileListSize), Nugget.fileName, "Validate that the sent audio is displayed on chat section");
        WaitMethods.pause(7);
        List<WebElement> listOfFilesTime = PeopleElement.sentAudioFileTimeList();
        AssertMethods.elementListSizeIsSame(listOfFilesTime, listOfFiles.size(), "Validate that last audio file is uploaded");
    }

    @When("^Select the new document file$")
    public void Select_the_document_file() {
        WaitMethods.pause(1);
        File file = new File("Files/Auto_Test_Doc1.txt");
        String absoluteImagePath = file.getAbsolutePath();
        Nugget.fileName = absoluteImagePath.split("\\\\")[(absoluteImagePath.split("\\\\").length) - 1];
        SeleniumMethods.sendKey(PeopleElement.fileInput(), absoluteImagePath, "Select the new document file");
    }

    @Then("^Validate that the sent document file is displayed on the chat section$")
    public void validate_that_the_sent_document_is_displayed_on_the_chat_section() {
        WaitMethods.pause(2);
        List<WebElement> listOfFiles = PeopleElement.sentDocFileList();
        int fileListSize = listOfFiles.size() - 1;
        AssertMethods.elementTextIsEqualTo(listOfFiles.get(fileListSize), Nugget.fileName, "Validate that the sent document is displayed on chat section");
        WaitMethods.pause(3);
        List<WebElement> listOfFilesTime = PeopleElement.sentDocFileTimeList();
        AssertMethods.elementListSizeIsSame(listOfFilesTime, listOfFiles.size(), "Validate that last document file is uploaded");
    }

    @When("^Select the new \"([^\"]*)\" file$")
    public void Select_the_big_size_file(String fileType) {
        WaitMethods.pause(1);
        String filePath = "Files/SampleJPGImage_30mb.jpg";
        if (fileType.equalsIgnoreCase("video")) {
            filePath = "Files/SampleVideo_30mb.mp4";
        }
        File file = new File(filePath);
        String absoluteImagePath = file.getAbsolutePath();
        Nugget.fileName = absoluteImagePath.split("\\\\")[(absoluteImagePath.split("\\\\").length) - 1];
        SeleniumMethods.sendKey(PeopleElement.fileInput(), absoluteImagePath, "Select the " + fileType + " file");
    }

    @When("^Select the new image$")
    public void Select_the_new_image() {
        WaitMethods.pause(1);
        File file = new File("Files/auto_test_img1.jpg");
        String absoluteImagePath = file.getAbsolutePath();
        Nugget.fileName = absoluteImagePath.split("\\\\")[(absoluteImagePath.split("\\\\").length) - 1];
        SeleniumMethods.sendKey(PeopleElement.fileInput(), absoluteImagePath, "Select the new image");
    }

    @Then("^Validate that the sent image is displayed on the chat section$")
    public void validate_that_the_sent_image_is_displayed_on_the_chat_section() {
        WaitMethods.pause(2);
        List<WebElement> listOfFiles = PeopleElement.sentImageFileList();
        int fileListSize = listOfFiles.size() - 1;
        AssertMethods.elementTextIsEqualTo(listOfFiles.get(fileListSize), Nugget.fileName, "Validate that the sent image is displayed on chat section");
        WaitMethods.pause(5);
        List<WebElement> listOfFilesTime = PeopleElement.sentImageTimeList();
        AssertMethods.elementListSizeIsSame(listOfFilesTime, listOfFiles.size(), "Validate that last image file is uploaded");
    }

    @When("^Delete the last sent message")
    public void delete_the_sent_file() {
        WaitMethods.pause(2);
        List<WebElement> moreMenuList=PeopleElement.moreMenuList();
        SeleniumMethods.click(moreMenuList.get(moreMenuList.size()-1),"Click on the lsat sent message more menu");
        WaitMethods.pause(1);
        List<WebElement> optionList = PeopleElement.deleteMessageOptionList();
        SeleniumMethods.click(optionList.get(optionList.size()-1), "Click on the delete message option from the list");
        WaitMethods.pause(2);
    }

    @When("^Select the \"([^\"]*)\" file from the local$")
    public void Select_the_files(String fileType) {
        WaitMethods.pause(1);
        String filePath = "Files/auto_test_img2.jpg";
        if (fileType.equalsIgnoreCase("video")) {
            filePath = "Files/auto_test_video.mp4";
        }
        else if(fileType.equalsIgnoreCase("audio")){
            filePath = "Files/file_example_MP3_700KB.mp3";
        }
        File file = new File(filePath);
        String absoluteImagePath = file.getAbsolutePath();
        Nugget.fileName = absoluteImagePath.split("\\\\")[(absoluteImagePath.split("\\\\").length) - 1];
        SeleniumMethods.sendKey(PeopleElement.fileInput(), absoluteImagePath, "Select the " + fileType + " file");
    }

    @Then("^Validate that the sent \"([^\"]*)\" file is displayed on the chat section$")
    public void validate_that_the_sent_file_is_displayed_on_the_chat_section(String fileType) {
        WaitMethods.pause(5);
        List<WebElement>listOfFiles = null;
        if(fileType.equalsIgnoreCase("video")){
            listOfFiles = PeopleElement.sentVideoFileList();
        }
        else if(fileType.equalsIgnoreCase("image")){
            listOfFiles = PeopleElement.sentImageFileList();
        }
        else if(fileType.equalsIgnoreCase("audio")){
            listOfFiles= PeopleElement.sentAudioFileList();
        }

        int fileListSize = (listOfFiles != null ? listOfFiles.size() : 0) - 1;

        AssertMethods.elementTextIsEqualTo(listOfFiles.get(fileListSize), Nugget.fileName, "Validate that the sent "+fileType+" file is displayed on chat section");
        WaitMethods.pause(4);
        List<WebElement> listOfFilesTime = null;
        if(fileType.equalsIgnoreCase("video")){
            listOfFilesTime = PeopleElement.sentVideoFileTimeList();
        }
        else if(fileType.equalsIgnoreCase("image")){
            listOfFilesTime = PeopleElement.sentImageTimeList();
        }
        else if(fileType.equalsIgnoreCase("audio")){
            listOfFilesTime= PeopleElement.sentAudioFileTimeList();
        }
        AssertMethods.elementListSizeIsSame(Objects.requireNonNull(listOfFilesTime), listOfFiles.size(), "Validate that last "+fileType+" file is uploaded");
    }

    @When("^Enter current URL on the chat input field$")
    public void enter_current_URL_on_the_chat_input_field() {
        WaitMethods.pause(2);
        Nugget.chatMessage = SeleniumMethods.getCurrentURL("Get Current URL");
        SeleniumMethods.click(PeopleElement.inputChatMessageField(), "Click on on chat input field");
        SeleniumMethods.sendKey(PeopleElement.inputChatMessageField(), Nugget.chatMessage, "Enter message on chat input field");
    }

    @Then("^Validate that the sent link message is displayed on the chat section$")
    public void validate_that_the_sent_link_message_is_displayed_on_the_chat_section() {
        WaitMethods.pause(1);
        List<WebElement> listOfFiles = PeopleElement.linkMessageList();
        int fileListSize = listOfFiles.size() - 1;
        AssertMethods.elementTextIsEqualTo(listOfFiles.get(fileListSize), Nugget.chatMessage, "Validate that the sent image is displayed on chat section");
    }

    @Then("^Validate that the sent link message element has href attribute$")
    public void validate_that_the_sent_link_message_element_has_href_attribute() {
        List<WebElement> listOfFiles = PeopleElement.linkMessageList();
        int fileListSize = listOfFiles.size() - 1;
        AssertMethods.elementAttributeValueIsEqualTo(listOfFiles.get(fileListSize),"href", Nugget.chatMessage, "Validate that the sent link message element has href attribute");
    }

    @Then("^Validate that the link message color is \"([^\"]*)\"$")
    public void validate_that_the_audit_chat_message_color(String colorCode) {
        List<WebElement> listOfFiles = PeopleElement.linkMessageList();
        int fileListSize = listOfFiles.size() - 1;
        String color=listOfFiles.get(fileListSize).getCssValue("color");
        String textColorCode = Color.fromString(color).asHex();
        CommonMethods.logInfo("Hex code of audit message:" + textColorCode);
        AssertMethods.textIsEqualTo(textColorCode,colorCode,"Validate that the link message color is "+colorCode);
    }

    @When("^Click on the sent message$")
    public void Click_on_the_sent_message() {
        List<WebElement> listOfFiles = PeopleElement.linkMessageList();
        int fileListSize = listOfFiles.size() - 1;
        SeleniumMethods.click(listOfFiles.get(fileListSize), "Click on the sent message");
    }

    @Then("^Validate that the link is open on the new tab$")
    public void validate_that_the_link_is_open_on_the_new_tab() {
        WaitMethods.pause(2);
        CommonMethods.switchNewWindow("chrome");
        WaitMethods.pause(2);
        String currentURL = SeleniumMethods.getCurrentURL("Get Current URL");
        AssertMethods.textIsEqualTo(currentURL, Nugget.chatMessage, "Validate that the current URL and sent message URL is same");

    }

    @When("^Close the newly opened tab$")
    public void close_the_newly_opened_tab() {
        CommonMethods.closeWindow();
        WaitMethods.pause(2);
        CommonMethods.switchMainWindow();
        WaitMethods.pause(2);
    }

    @When("^Click on the emoji icon$")
    public void Click_on_the_emoji_icon() {
        SeleniumMethods.click(PeopleElement.emojiIcon(), "Click on the emoji icon");
    }

    @Then("^Validate that the emoji section is open$")
    public void validate_that_the_emoji_section_is_open() {
        AssertMethods.elementIsDisplayed(PeopleElement.emojiSection(),"Validate that the emoji section is open");
    }

    @When("^Enter the \"([^\"]*)\" text on the search text box$")
    public void enter_the_text_on_the_search_text_box(String searchText) {
        SeleniumMethods.sendKey(PeopleElement.emojiSearchBox(), searchText, "Enter the "+searchText+" text on the search text box");
    }

    @Then("^Validate that the searched \"([^\"]*)\" emoji is displayed$")
    public void validate_that_the_searched_emoji_is_displayed(String emojiName) {
        AssertMethods.elementAttributeValueIsEqualTo(PeopleElement.listOfEmojis().get(0),"title",emojiName,"Validate that the searched "+emojiName+" emoji is displayed");
    }

    @When("^Click on the emoji$")
    public void Click_on_the_emoji() {
        SeleniumMethods.click(PeopleElement.listOfEmojis().get(0), "Click on the emoji");
    }

    @Then("^Validate that the \"([^\"]*)\" emoji message is sent$")
    public void validate_that_the_emoji_message_is_sent(String emoji) {
        AssertMethods.elementIsDisplayed(PeopleElement.sentMessage(emoji),"Validate that the "+emoji+" emoji message is sent");
    }


}