Feature: People Module Test Case

  @regression @critical @people @TC-P1
  Scenario Outline: Verify that the search user with valid search text
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the search user textbox is displayed
    When Enter the "<userNameText>" search user name text
    Then Validate that the search user list is displayed

    Examples:
      | UserRoll    | EndPoint | userNameText |
      | allRoleUser | /people  | Auto         |

  @regression @people @TC-P2
  Scenario Outline: Verify that the search user with invalid search text
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the search user textbox is displayed
    When Enter the "<userNameText>" search user name text
    Then Validate that the no results found message is displayed on the list

    Examples:
      | UserRoll    | EndPoint | userNameText |
      | allRoleUser | /people  | absks1       |

  @regression @critical @people @TC-P3 @TC-P4
  Scenario Outline: Verify that the search user which is already present on the chat list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the search user textbox is displayed
    When Enter the "<userNameText>" search user name text
    Then Validate that the search user list is displayed
    And Validate that the search result is displayed from user chat list


    Examples:
      | UserRoll    | EndPoint | userNameText |
      | allRoleUser | /people  | Ankit        |
      | allRoleUser | /people  | Ankit Mistry |

  @regression @people @TC-P5
  Scenario Outline: Select any user from the people chat list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the list of message is displayed

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /people  |

  @regression @people @TC-P6
  Scenario Outline: Verify that the user is not selected by default from people's chat list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the user is not selected
    And Validate that the chat message input field is disabled

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /people  |

  @regression @people @TC-P7
  Scenario Outline: Verify that the Media, Document, Links tab is displayed on the right side section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the media tab is displayed
    And Validate that the document tab is displayed
    And Validate that the links tab is displayed

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /people  |

  @regression @people @TC-P8
  Scenario Outline: Verify that the Media tab is selected by default on the right side section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the media tab is displayed
    And Validate that the media tab is selected

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /people  |


  @regression @people @TC-P9
  Scenario Outline: Verify that the click functionality on the Document tab on the right side section of the people chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the document tab is displayed
    When Click on the documents sub tab
    And Validate that the document tab is selected

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /people  |

  @regression @people @TC-P10
  Scenario Outline: Verify that the click functionality on the Link tab on the right side section of the people chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the links tab is displayed
    When Click on the links sub tab
    And Validate that the links tab is selected

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /people  |

  @regression @critical @people @TC-P11
  Scenario Outline: Verify that the user can send a message to any user on the personal chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the chat input message field is displayed
    When Enter the "<Message>" on chat input field
    And Click on the chat send icon
    Then Validate that the sent message is displayed on the people chat section

    Examples:
      | UserRoll    | EndPoint | Message        |
      | allRoleUser | /people  | Auto Chat Test |

  @regression @people @TC-P12
  Scenario Outline: Verify that the more option menu is displayed on the message
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the chat input message field is displayed
    And Validate that the more option menu is displayed on the sent message

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /people  |

  @regression @people @TC-P13
  Scenario Outline: Verify that the list on option on the more option list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the chat input message field is displayed
    When Enter the "<Message>" on chat input field
    And Click on the chat send icon
    Then Validate that the sent message is displayed on the people chat section
    And Validate that the more option menu is displayed on the sent message
    When Click on the more option menu of sent message
    Then Validate all the option is displayed on the more menu list

    Examples:
      | UserRoll    | EndPoint | Message        |
      | allRoleUser | /people  | Auto Chat Test |

  @regression @critical @people @TC-P14
  Scenario Outline: Verify that the user can reply to the sent message
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the sent message is displayed on the people chat section
    When Click on the more option menu of sent message
    And Click on the reply option from the list
    And Enter the message for the reply message
    And Click on the chat send icon
    Then Validate that the main message and replied message both are displayed on the chat section

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /people  |

  @regression @critical @people @TC-P15
  Scenario Outline: Verify that the user can edit the sent message
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the chat input message field is displayed
    When Enter the "<Message>" on chat input field
    And Click on the chat send icon
    Then Validate that the sent message is displayed on the people chat section
    When Click on the more option menu of sent message
    And Click on the edit message option from the list
    And Enter new message on the chat input field
    And Click on the chat send icon
    Then Validate that the updated sent message is displayed on the chat section

    Examples:
      | UserRoll    | EndPoint | Message        |
      | allRoleUser | /people  | Auto Chat Test |

  @regression @critical @people @TC-P16
  Scenario Outline: Verify that the user can delete the sent message
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the sent message is displayed on the people chat section
    When Click on the more option menu of sent message
    And Click on the delete message option from the list
    Then Validate that the message is deleted from the chat section

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /people  |

  @regression @people @TC-P17
  Scenario Outline: Verify that the user can send the video file on the people chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the chat input message field is displayed
    When Select the new video file
    And Click on the chat send icon
    Then Validate that the sent video file is displayed on the chat section
    When Delete the last sent message

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /people  |

  @regression @people @TC-P18
  Scenario Outline: Verify that the user can send the audio file on the people chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the chat input message field is displayed
    When Select the new audio file
    And Click on the chat send icon
    Then Validate that the sent audio file is displayed on the chat section
    When Delete the last sent message

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /people  |

  @regression @people @TC-P19
  Scenario Outline: Verify that the user can send the document file on the people chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the chat input message field is displayed
    When Select the new document file
    And Click on the chat send icon
    Then Validate that the sent document file is displayed on the chat section
    When Delete the last sent message

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /people  |

  @regression @people @TC-P20
  Scenario Outline: Verify that the user can send the image file on the people chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the chat input message field is displayed
    When Select the new image
    And Click on the chat send icon
    Then Validate that the sent image is displayed on the chat section
    When Delete the last sent message

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /people  |

  @regression @people @TC-P21 @TC-P22
  Scenario Outline: Verify that the user is not able to send more than 25MB file on the people's chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the chat input message field is displayed
    When Select the new "<File>" file
    And Click on the chat send icon
    Then Validate that the toast validation message appears

    Examples:
      | UserRoll       | EndPoint | File  |
      | commonRoleUser | /people  | Video |
      | commonRoleUser | /people  | Image |


  @regression @people @TC-P23 @TC-P24 @TC-P25
  Scenario Outline: Verify that the sent image file, video file and audio file is also displayed in media section of people's attached tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the chat input message field is displayed
    When Select the "<FileType>" file from the local
    And Click on the chat send icon
    Then Validate that the sent "<FileType>" file is displayed on the chat section
    When Click on the media sub tab
    And Validated that the sent "<FileType>" file is displayed on media section
    And Delete the last sent message

    Examples:
      | UserRoll    | EndPoint | FileType |
      | allRoleUser | /people  | Image    |
      | allRoleUser | /people  | Video    |
      | allRoleUser | /people  | Audio    |

  @regression @people @TC-P26
  Scenario Outline: Verify that the sent document file is also displayed in Documents section of people's attached tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the chat input message field is displayed
    When Select the new document file
    And Click on the chat send icon
    Then Validate that the sent document file is displayed on the chat section
    When  Click on the documents sub tab
    Then Validated that the sent document file is displayed on documents section
    When Delete the last sent message

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /people  |

  @regression @people @TC-P27
  Scenario Outline: Verify that the sent URL link is also displayed in Links section of people's attached tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the chat input message field is displayed
    When Enter current URL on the chat input field
    And Click on the chat send icon
    Then Validate that the sent link message is displayed on the chat section
    When Click on the links sub tab
    Then Validate that the sent link message is displayed on the chat section
    When Delete the last sent message

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /people  |

  @regression @people @TC-P28
  Scenario Outline: Verify that the sent URL is displayed as a link message and in blue color (#1e90ff)
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the chat input message field is displayed
    When Enter current URL on the chat input field
    And Click on the chat send icon
    Then Validate that the sent link message is displayed on the chat section
    And Validate that the sent link message element has href attribute
    And Validate that the link message color is "<ColorCode>"
    When Delete the last sent message

    Examples:
      | UserRoll    | EndPoint | ColorCode |
      | allRoleUser | /people  | #1e90ff   |

  @regression @people @TC-P29
  Scenario Outline: Verify that the user can open the URL from the sent link message
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
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
      | allRoleUser | /people  |

  @regression @people @TC-P30
  Scenario Outline: Verify that the click functionality on the emoji icon
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the chat input message field is displayed
    When Click on the emoji icon
    Then Validate that the emoji section is open

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /people  |

  @regression @people @TC-P31
  Scenario Outline: Verify that the user can search the emoji
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the chat input message field is displayed
    When Click on the emoji icon
    Then Validate that the emoji section is open
    When Enter the "<EmojiName>" text on the search text box
    Then Validate that the searched "<EmojiName>" emoji is displayed

    Examples:
      | UserRoll    | EndPoint | EmojiName  |
      | allRoleUser | /people  | smiley_cat |
      | allRoleUser | /people  | thumbs_up  |

  @regression @people @TC-P32
  Scenario Outline: Verify that the user can send the emoji
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
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
      | allRoleUser | /people  | smiley_cat | 😺    |
