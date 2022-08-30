Feature: Channel Module Test Case

  @regression @critical @channel @TC-C1
  Scenario Outline: Verify that the search channel with valid search text
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the search user textbox is displayed
    When Enter the "<ChannelNameText>" search channel name text
    Then Validate that the search channel list is displayed

    Examples:
      | UserRoll    | EndPoint | ChannelNameText |
      | allRoleUser | /groups  | QA              |

  @regression @channel @TC-C2
  Scenario Outline: Verify that the search channel with invalid search text
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the search user textbox is displayed
    When Enter the "<ChannelNameText>" search channel name text
    Then Validate that the no results found message is displayed on the list

    Examples:
      | UserRoll    | EndPoint | ChannelNameText |
      | allRoleUser | /groups  | aqrre12         |

  @regression @critical @channel @TC-C3 @TC-C4
  Scenario Outline: Verify that the search channel which is already present on the channel list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the search user textbox is displayed
    When Enter the "<userNameText>" search channel name text
    Then Validate that the search channel list is displayed
    And Validate that the search result is displayed from the channel list

    Examples:
      | UserRoll    | EndPoint | userNameText |
      | allRoleUser | /groups  | Ankit        |
      | allRoleUser | /groups  | Auto Ankit   |

  @regression @critical @channel @TC-C5
  Scenario Outline: Select any channel from the channels list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the list of message is displayed

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @channel @TC-C6
  Scenario Outline: Verify that the user is not selected by default from people's chat list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the channel is not selected
    And Validate that the chat message input field is disabled

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @channel @TC-C7
  Scenario Outline: Verify that the Media, Document, Links tab is displayed on the channels right side section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the media tab is displayed
    And Validate that the document tab is displayed
    And Validate that the links tab is displayed

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @channel @TC-C8
  Scenario Outline: Verify that the Media tab is selected by default on the right side section of the channel
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the media tab is displayed
    And Validate that the media tab is selected

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @channel @TC-C9
  Scenario Outline: Verify that the click functionality on the Document tab on the right side section of the of the channel chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the document tab is displayed
    When Click on the documents sub tab
    And Validate that the document tab is selected

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @channel @TC-C10
  Scenario Outline: Verify that the click functionality on the Link tab on the right side section of the channel chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the links tab is displayed
    When Click on the links sub tab
    And Validate that the links tab is selected

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @critical @channel @TC-C11
  Scenario Outline: Verify that the user can send a message on the any listed channel
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the chat input message field is displayed
    When Enter the "<Message>" on chat input field
    And Click on the chat send icon
    Then Validate that the sent message is displayed on the channel chat section

    Examples:
      | UserRoll    | EndPoint | Message           |
      | allRoleUser | /groups  | Auto channel Test |

  @regression @channel @TC-C12
  Scenario Outline: Verify that the more option menu is displayed on the channel message
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the chat input message field is displayed
    And Validate that the more option menu is displayed on the sent message

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @channel @TC-C13
  Scenario Outline: Verify that the list on option on the channel message more option list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the chat input message field is displayed
    When Enter the "<Message>" on chat input field
    And Click on the chat send icon
    Then Validate that the sent message is displayed on the channel chat section
    And Validate that the more option menu is displayed on the sent message
    When Click on the more option menu of sent message
    Then Validate all the option is displayed on the more menu list

    Examples:
      | UserRoll    | EndPoint | Message           |
      | allRoleUser | /groups  | Auto channel Test |

  @regression @critical @channel @TC-C14
  Scenario Outline: Verify that the user can reply to the channel sent message
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the sent message is displayed on the channel chat section
    When Click on the more option menu of sent message
    And Click on the reply option from the list
    And Enter the message for the reply message
    And Click on the chat send icon
    Then Validate that the main message and replied message both are displayed on the chat section

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @critical @channel @TC-C15
  Scenario Outline: Verify that the user can edit the channel sent message
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the chat input message field is displayed
    When Enter the "<Message>" on chat input field
    And Click on the chat send icon
    Then Validate that the sent message is displayed on the channel chat section
    When Click on the more option menu of sent message
    And Click on the edit message option from the list
    And Enter new message on the chat input field
    And Click on the chat send icon
    Then Validate that the updated sent message is displayed on the chat section

    Examples:
      | UserRoll    | EndPoint | Message           |
      | allRoleUser | /groups  | Auto channel Test |

  @regression @critical @channel @TC-C16
  Scenario Outline: Verify that the user can delete the channel sent message
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the sent message is displayed on the channel chat section
    When Click on the more option menu of sent message
    And Click on the delete message option from the list
    Then Validate that the message is deleted from the chat section

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @channel @TC-C17
  Scenario Outline: Verify that the user can send the video file on the channel chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the chat input message field is displayed
    When Select the new video file
    And Click on the chat send icon
    Then Validate that the sent video file is displayed on the chat section
    When Delete the last sent message

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @channel @TC-C18
  Scenario Outline: Verify that the user can send the audio file on the channel chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the chat input message field is displayed
    When Select the new audio file
    And Click on the chat send icon
    Then Validate that the sent audio file is displayed on the chat section
    When Delete the last sent message

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @channel @TC-C19
  Scenario Outline: Verify that the user can send the document file on the channel chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the chat input message field is displayed
    When Select the new document file
    And Click on the chat send icon
    Then Validate that the sent document file is displayed on the chat section
    When Delete the last sent message

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @channel @TC-C20
  Scenario Outline: Verify that the user can send the image file on the channel chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the chat input message field is displayed
    When Select the new image
    And Click on the chat send icon
    Then Validate that the sent image is displayed on the chat section
    When Delete the last sent message

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @channel @TC-C21 @TC-C22
  Scenario Outline: Verify that the user is not able to send more than 25MB file on the channel chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the chat input message field is displayed
    When Select the new "<File>" file
    And Click on the chat send icon
    Then Validate that the toast validation message appears

    Examples:
      | UserRoll       | EndPoint | File  |
      | commonRoleUser | /groups  | Video |
      | commonRoleUser | /groups  | Image |

  @regression @channel @TC-C23 @TC-C24 @TC-C25
  Scenario Outline: Verify that the sent image file, video file and audio file is also displayed in media section of channel's attached tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the chat input message field is displayed
    When Select the "<FileType>" file from the local
    And Click on the chat send icon
    Then Validate that the sent "<FileType>" file is displayed on the chat section
    When Click on the media sub tab
    And Validated that the sent "<FileType>" file is displayed on media section
    And Delete the last sent message

    Examples:
      | UserRoll    | EndPoint | FileType |
      | allRoleUser | /groups  | Image    |
      | allRoleUser | /groups  | Video    |
      | allRoleUser | /groups  | Audio    |

  @regression @channel @TC-C26
  Scenario Outline: Verify that the sent document file is also displayed in Documents section of channel's attached tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the chat input message field is displayed
    When Select the new document file
    And Click on the chat send icon
    Then Validate that the sent document file is displayed on the chat section
    When  Click on the documents sub tab
    Then Validated that the sent document file is displayed on documents section
    When Delete the last sent message

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @channel @TC-C27
  Scenario Outline: Verify that the sent URL link is also displayed in Links section of channel's attached tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the chat input message field is displayed
    When Enter current URL on the chat input field
    And Click on the chat send icon
    Then Validate that the sent link message is displayed on the chat section
    When Click on the links sub tab
    Then Validate that the sent link message is displayed on the chat section
    When Delete the last sent message

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @channel @TC-C28
  Scenario Outline: Verify that the sent URL on the channel is displayed as a link message and in blue color (#1e90ff)
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the chat input message field is displayed
    When Enter current URL on the chat input field
    And Click on the chat send icon
    Then Validate that the sent link message is displayed on the chat section
    And Validate that the sent link message element has href attribute
    And Validate that the link message color is "<ColorCode>"
    When Delete the last sent message

    Examples:
      | UserRoll    | EndPoint | ColorCode |
      | allRoleUser | /groups  | #1e90ff   |

  @regression @channel @TC-C29
  Scenario Outline: Verify that the user can open the URL from the sent link message on the channel
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the chat input message field is displayed
    When Enter current URL on the chat input field
    And Click on the chat send icon
    Then Validate that the sent link message is displayed on the chat section
    When Click on the sent message
    Then Validate that the link is open on the new tab
    When Close the newly opened tab
    And Delete the last sent message

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @channel @TC-C30
  Scenario Outline: Verify that the click functionality on the channel's emoji icon
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the chat input message field is displayed
    When Click on the emoji icon
    Then Validate that the emoji section is open

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @channel @TC-C31
  Scenario Outline: Verify that the user can search the emoji on the channel chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the chat input message field is displayed
    When Click on the emoji icon
    Then Validate that the emoji section is open
    When Enter the "<EmojiName>" text on the search text box
    Then Validate that the searched "<EmojiName>" emoji is displayed

    Examples:
      | UserRoll    | EndPoint | EmojiName  |
      | allRoleUser | /groups  | smiley_cat |
      | allRoleUser | /groups  | thumbs_up  |

  @regression @channel @TC-C32
  Scenario Outline: Verify that the user can send the emoji on the channel chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the chat input message field is displayed
    When Click on the emoji icon
    Then Validate that the emoji section is open
    When Enter the "<EmojiName>" text on the search text box
    And Click on the emoji
    And Click on the chat send icon
    Then Validate that the "<Emoji>" emoji message is sent
    And Delete the last sent message

    Examples:
      | UserRoll    | EndPoint | EmojiName  | Emoji |
      | allRoleUser | /groups  | smiley_cat | 😺    |

  @regression @channel @TC-C33
  Scenario Outline: Verify that the channel name is displayed on the channel's heading section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Gat the channel name from the list and click on the that channel name
    Then Validate that the channel name is displayed on the channel heading section

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @channel @TC-C34
  Scenario Outline: Verify that the more option menu is displayed on the public channel's heading section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the more option is displayed on the channel heading section

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @channel @TC-C35
  Scenario Outline: Verify that the click functionality on the channel name on the channel's heading section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Gat the channel name from the list and click on the that channel name
    Then Validate that the channel name is displayed on the channel heading section
    When Click on the channel heading
    Then Validate that the channel members dialog box is open
    And Validate that the channel name is displayed on the open dialog box heading

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @channel @TC-C36
  Scenario Outline: Verify that the channel members list is displayed on the open channel member dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Gat the channel name from the list and click on the that channel name
    Then Validate that the channel name is displayed on the channel heading section
    When Click on the channel heading
    Then Validate that the channel members dialog box is open
    And Validate that the channel members list is displayed

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @channel @TC-C37
  Scenario Outline: Verify the click functionality on the close icon of the channel member dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Gat the channel name from the list and click on the that channel name
    Then Validate that the channel name is displayed on the channel heading section
    When Click on the channel heading
    Then Validate that the channel members dialog box is open
    When Click on the close icon
    Then Validate that the channel members dialog box is closed

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @critical @channel @TC-C38
  Scenario Outline: Verify that the user can leave the public channel
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Gat the channel name from the list and click on the that channel name
    Then Validate that the more option is displayed on the channel heading section
    When Click on the more option icon which is available on the channel heading
    And Click on the leave option
    Then Validate that the channel name is removed from the channel list

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @critical @channel @TC-C39
  Scenario Outline: Verify that the user can join the public channel
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the search user textbox is displayed
    When Enter the "<ChannelNameText>" search channel name text
    Then Validate that the search channel list is displayed
    When Click on the listed channel name
    Then Validate that the join channel name is displayed on the list
    And Validate that the newly join channel is selected

    Examples:
      | UserRoll    | EndPoint | ChannelNameText |
      | allRoleUser | /groups  | Auto Ankit      |
