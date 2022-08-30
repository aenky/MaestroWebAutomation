Feature: Nugget Module Test Case

  @regression @nugget @TC-N1
  Scenario Outline: Verify the Create Nugget button is displayed on Index, My Nugget, Assignment, Team Lead, Good News, Bad News and Setting.
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on inbox option from side menu
    And Validate the current page URL has "<endPoint>" end point
    And Validate the create nugget button is displayed
    When Click on nuggets option from side menu
    Then Validate the create nugget button is displayed
    When Click on assignment option from side menu
    Then Validate the create nugget button is displayed
    When Click on team lead option from side menu
    Then Validate the create nugget button is displayed
    When Click on good news option from side menu
    Then Validate the create nugget button is displayed
    When Click on bad news option from side menu
    Then Validate the create nugget button is displayed
    When Click on the setting option from side menu
    Then Validate the create nugget button is displayed


    Examples:
      | UserRoll    | endPoint      |
      | allRoleUser | /inbox/nugget |

  @regression @critical @nugget @TC-N2
  Scenario Outline: Verify the click functionality on Create Nugget button
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    And Validate the create nugget button is displayed
    When Click on the create nugget button
    Then Validate the create nugget heading on open dialog box

    Examples:
      | UserRoll    | endPoint       |
      | allRoleUser | /nugget/unread |

  @regression @nugget @TC-N3
  Scenario Outline: Verify the all field on create nugget dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the create nugget button
    Then Validate the create nugget heading on open dialog box
    And Validate the nugget type dropdown field is displayed
    And Validate the nugget name text box field is displayed
    And Validate the nugget project dropdown field is displayed
    And Validate the nugget priority dropdown field is displayed
    And Validate the nugget description text box field is displayed

    Examples:
      | UserRoll    | endPoint       |
      | allRoleUser | /nugget/unread |

  @regression @nugget @TC-N4
  Scenario Outline: Verify the click functionality on close (X) icon on create nugget dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the create nugget button
    Then Validate the create nugget heading on open dialog box
    And Validate the close icon is displayed on open dialog box
    When Click on the close icon of open dialog box
    Then Validate the create nugget button is displayed

    Examples:
      | UserRoll    | endPoint       |
      | allRoleUser | /nugget/unread |

  @regression @nugget @TC-N5
  Scenario Outline: Verify the create button is disabled until all required field is filled up on create nugget dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the create nugget button
    Then Validate the create nugget heading on open dialog box
    And Validate that the create button is disabled
    When Select "<Type>" nugget type from dropdown
    Then Validate that the create button is disabled
    When Enter the nugget name on name text box
    Then Validate that the create button is disabled
    When Select project from dropdown
    Then Validate that the create button is disabled
    When Select "<Priority>" nugget priority from dropdown
    Then Validate that the create button is disabled
    When Enter the description on description text box
    Then Validate that the create button is Enable

    Examples:
      | UserRoll    | endPoint       | Type | Priority |
      | allRoleUser | /nugget/unread | Bug  | Normal   |

  @regression @nugget @TC-N6
  Scenario Outline: Verify the validation message on all required field
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the create nugget button
    Then Validate the create nugget heading on open dialog box
    #When Click on the nugget type field
    #And Click on the outside of field
    #Then Validate the required field validation message displayed
    When Click on the nugget name field
    And Click on the outside of field
    Then Validate the required field validation message displayed on name field
    When Click on the nugget project field
    And Click on the outside of field
    Then Validate the required field validation message displayed on project field
    #When Click on the nugget priority field
    #And Click on the outside of field
    #Then Validate the required field validation message displayed
    When Click on the nugget description field
    And Click on the outside of field
    Then Validate the required field validation message displayed on description field

    Examples:
      | UserRoll    | endPoint       |
      | allRoleUser | /nugget/unread |

  @regression @critical @nugget @TC-N7
  Scenario Outline: Verify the user is able to create nugget
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the create nugget button
    Then Validate the create nugget heading on open dialog box
    When Select "<Type>" nugget type from dropdown
    And Enter the nugget name on name text box
    And Select project from dropdown
    And Select "<Priority>" nugget priority from dropdown
    And Enter the description on description text box
    And Click on the create button
    Then Validate that the successfully created nugget toast notification message is displayed

    Examples:
      | UserRoll    | endPoint       | Type | Priority |
      | allRoleUser | /nugget/unread | Bug  | Normal   |

  @regression @nugget @TC-N8
  Scenario Outline: Verify the system is redirected to the subscribed tab when the user is able to create the new nugget
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the create nugget button
    Then Validate the create nugget heading on open dialog box
    When Select "<Type>" nugget type from dropdown
    And Enter the nugget name on name text box
    And Select project from dropdown
    And Select "<Priority>" nugget priority from dropdown
    And Enter the description on description text box
    And Click on the create button
    Then Validate that the subscribed tab is displayed as active tab
    And Validate that the created nugget is displayed first on the list and highlighted

    Examples:
      | UserRoll    | endPoint       | Type | Priority |
      | allRoleUser | /nugget/unread | Bug  | Normal   |

  @regression @critical @nugget @TC-N10
  Scenario Outline: Validate the audit message on nugget public chat when user created new nugget
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the create nugget button
    Then Validate the create nugget heading on open dialog box
    When Select "<Type>" nugget type from dropdown
    And Enter the nugget name on name text box
    And Select project from dropdown
    And Select "<Priority>" nugget priority from dropdown
    And Enter the description on description text box
    And Click on the create button
    Then Validate that the successfully created nugget toast notification message is displayed
    And Validate the audit message for create new nugget

    Examples:
      | UserRoll    | endPoint       | Type | Priority |
      | allRoleUser | /nugget/unread | Bug  | Normal   |

  #@regression @critical @nugget @TC-N11
  Scenario Outline: Validate that the newly created nugget should be subscribed automatically for login user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the create nugget button
    Then Validate the create nugget heading on open dialog box
    When Select "<Type>" nugget type from dropdown
    And Enter the nugget name on name text box
    And Select project from dropdown
    And Select "<Priority>" nugget priority from dropdown
    And Enter the description on description text box
    And Click on the create button
    Then Validate that the successfully created nugget toast notification message is displayed
    And Validate the created nugget is subscribed automatically

    Examples:
      | UserRoll    | endPoint       | Type | Priority |
      | allRoleUser | /nugget/unread | Bug  | Normal   |

  @regression @critical @nugget @TC-N12
  Scenario Outline: Validate that the subscribe and unsubscribe functionality on the nugget
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    Then Validate that the subscribed tab is displayed as active tab
    When Click on the nugget subscribe checkbox
    Then Validate that the successfully unsubscribed the nugget toast notification message is displayed
    When Click on the nugget subscribe checkbox
    Then Validate that the successfully subscribed the nugget toast notification message is displayed

    Examples:
      | UserRoll    | endPoint       |
      | allRoleUser | /nugget/unread |

  @regression @nugget @TC-N13
  Scenario Outline: Validate that the nugget details section has chat, message, attachment and assignment tab is displayed on the right side section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    Then Validate that the subscribed tab is displayed as active tab
    And Validate that the nugget details section has Chat, Details, Attachment and Assignment section tab is displayed

    Examples:
      | UserRoll    | endPoint       |
      | allRoleUser | /nugget/unread |

  @regression @nugget @TC-N14
  Scenario Outline: Verify the click functionality on the nugget chat tab of the right side menu
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    Then Validate that the subscribed tab is displayed as active tab
    When Click on the nugget chat tab
    Then Validate the system is displayed the chat section

    Examples:
      | UserRoll    | endPoint       |
      | allRoleUser | /nugget/unread |

  @regression @nugget @TC-N15
  Scenario Outline: Verify the click functionality on the nugget details tab of the right side menu
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    Then Validate that the subscribed tab is displayed as active tab
    When Click on the nugget details tab
    Then Validate that the system is displayed the nugget details section

    Examples:
      | UserRoll    | endPoint       |
      | allRoleUser | /nugget/unread |

  @regression @nugget @TC-N16
  Scenario Outline: Verify the click functionality on the nugget chat attachment details tab of the right side menu
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    Then Validate that the subscribed tab is displayed as active tab
    When Click on the nugget attachment tab
    Then Validate that the system is displayed the nugget chat attachment section

    Examples:
      | UserRoll    | endPoint       |
      | allRoleUser | /nugget/unread |

  @regression @nugget @TC-N17
  Scenario Outline: Verify the click functionality on the nugget assignment details tab of the right side menu
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    Then Validate that the subscribed tab is displayed as active tab
    When Click on the nugget assignment tab
    Then Validate that the system is displayed the nugget assignment section

    Examples:
      | UserRoll    | endPoint       |
      | allRoleUser | /nugget/unread |


  @regression @nugget @TC-N18 @TC-N19
  Scenario Outline: Verify that the Common role type user is not able to update the nugget details
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the create nugget button
    Then Validate the create nugget heading on open dialog box
    When Select "<Type>" nugget type from dropdown
    And Enter the nugget name on name text box
    And Select project from dropdown
    And Select "<Priority>" nugget priority from dropdown
    And Enter the description on description text box
    And Click on the create button
    Then Validate that the successfully created nugget toast notification message is displayed
    When Click on the nugget details tab
    Then Validate that the all nugget edit fields are disabled

    Examples:
      | UserRoll         | endPoint       | Type | Priority |
      | commonRoleUser   | /nugget/unread | Bug  | Normal   |
      | resourceRoleUser | /nugget/unread | Bug  | Normal   |
      #| teamLeadRoleUser | /nugget/unread | Bug  | Normal   |
      #| adminRoleUser    | /nugget/unread | Bug  | Normal   |

  @regression @nugget @TC-N23
  Scenario Outline: Verify that the only project maestro user is able to see tags dropdown field
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    Then Validate that the subscribed tab is displayed as active tab
    When Click on the nugget details tab
    Then Validate that the tags dropdown field is displayed

    Examples:
      | UserRoll    | endPoint       |
      | allRoleUser | /nugget/unread |

  @regression @nugget @TC-N24
  Scenario Outline: Verify that the tag dropdown field is disabled for admin, resource, team lead, release maestro user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the create nugget button
    Then Validate the create nugget heading on open dialog box
    When Select "<Type>" nugget type from dropdown
    And Enter the nugget name on name text box
    And Select project from dropdown
    And Select "<Priority>" nugget priority from dropdown
    And Enter the description on description text box
    And Click on the create button
    Then Validate that the successfully created nugget toast notification message is displayed
    When Click on the nugget details tab
    Then Validate that the Tags dropdown is disabled

    Examples:
      | UserRoll         | endPoint       | Type | Priority |
      | RM_RoleUser      | /nugget/unread | Bug  | Normal   |
      | resourceRoleUser | /nugget/unread | Bug  | Normal   |
      | teamLeadRoleUser | /nugget/unread | Bug  | Normal   |
      | adminRoleUser    | /nugget/unread | Bug  | Normal   |

  #@regression @critical @nugget @TC-N25 #Removed the subscribe and unsubscribe checkbox from nugget details section
  Scenario Outline: Verify that the user is able to perform subscribe and unsubscribe functionality from nugget details section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    Then Validate that the subscribed tab is displayed as active tab
    When Click on the nugget details tab
    Then Validate that the subscribed nugget checkbox is displayed
    When Click on the nugget subscribe checkbox of nugget details section
    Then Validate that the successfully unsubscribed the nugget toast notification message is displayed
    When Click on the nugget subscribe checkbox of nugget details section
    Then Validate that the successfully subscribed the nugget toast notification message is displayed

    Examples:
      | UserRoll    | endPoint       |
      | allRoleUser | /nugget/unread |

  @regression @critical @nugget @TC-N26
  Scenario Outline: Verify that the Team Lead and Project Maestro user is able to add and removed the nugget phase
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the create nugget button
    Then Validate the create nugget heading on open dialog box
    When Select "<Type>" nugget type from dropdown
    And Enter the nugget name on name text box
    And Select project from dropdown
    And Select "<Priority>" nugget priority from dropdown
    And Enter the description on description text box
    And Click on the create button
    Then Validate that the successfully created nugget toast notification message is displayed
    When Click on the nugget assignment tab
    Then Validate that the edit phase icon is displayed
    When Click on the edit phase icon
    And Click on the remove phase icon
    Then Validate that the removed phase toast message appears
    And Click on the add phase icon
    Then Validate that the added phase toast message appears

    Examples:
      | UserRoll         | endPoint       | Type | Priority |
      | teamLeadRoleUser | /nugget/unread | Bug  | Normal   |
      | PM_RoleUser      | /nugget/unread | Bug  | Normal   |

  @regression @critical @nugget @TC-N27
  Scenario Outline: Verify that the Team Lead and Project Maestro user is unable to add and removed the nugget triage phase
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    When Click on the nugget assignment tab
    Then Validate that the edit phase icon is displayed
    When Click on the edit phase icon
    Then Validate that the add and remove icon is not appears on triage phase

    Examples:
      | UserRoll         | endPoint       |
      | teamLeadRoleUser | /nugget/unread |
      | PM_RoleUser      | /nugget/unread |

  @regression @critical @nugget @TC-N28
  Scenario Outline: Verify that the Team Lead role user is able to add and removed the resources on nugget phase
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget assignment tab
    And Click on the first nugget phase
    Then Validate that the edit resources icon is displayed
    When Click on the add resource icon
    Then Validate that the added resource toast message appears
    When Click on the remove resource icon
    Then Validate that the removed resource toast message appears

    Examples:
      | UserRoll         | endPoint       |
      | teamLeadRoleUser | /nugget/unread |

  @regression @critical @nugget @TC-N29
  Scenario Outline: Verify that the project maestro user is not able to add and remove the nugget resource
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget assignment tab
    And Click on the first nugget phase
    Then Validate that the edit resources icon is displayed
    When Click on the add resource icon
    Then Validate that the validation toast message appears with "<ValidationMessage>"

    Examples:
      | UserRoll    | endPoint       | ValidationMessage                              |
      | PM_RoleUser | /nugget/unread | Only Nugget Project Managers Can Assign Nugget |

  @regression @critical @nugget @TC-N30
  Scenario Outline: Verify that the resource, common, release maestro and admin user is unable to add and removed the resources on the nugget phase
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the create nugget button
    Then Validate the create nugget heading on open dialog box
    When Select "<Type>" nugget type from dropdown
    And Enter the nugget name on name text box
    And Select project from dropdown
    And Select "<Priority>" nugget priority from dropdown
    And Enter the description on description text box
    And Click on the create button
    Then Validate that the successfully created nugget toast notification message is displayed
    When Click on the nugget assignment tab
    Then Validate that the edit phase icon does not display

    Examples:
      | UserRoll         | endPoint       | Type | Priority |
      | RM_RoleUser      | /nugget/unread | Bug  | Normal   |
      | resourceRoleUser | /nugget/unread | Bug  | Normal   |
      | commonRoleUser   | /nugget/unread | Bug  | Normal   |
      | adminRoleUser    | /nugget/unread | Bug  | Normal   |

  @regression @critical @nugget @TC-N31
  Scenario Outline: Verify that the resource, common, release maestro and admin role user is unable to add and removed the nugget phase
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget assignment tab
    Then Validate that the edit resources icon does not display

    Examples:
      | UserRoll         | endPoint       |
      | RM_RoleUser      | /nugget/unread |
      | resourceRoleUser | /nugget/unread |
      | commonRoleUser   | /nugget/unread |
      | adminRoleUser    | /nugget/unread |

  @regression @critical @nugget @TC-N32
  Scenario Outline: Verify that the user is able to send text message on the nugget chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget chat tab
    Then Validate that the input message field is displayed
    When Enter "<Message>" on chat input field
    And Click on the send button
    Then Validate that the sent message is displayed on chat section

    Examples:
      | UserRoll    | endPoint       | Message      |
      | allRoleUser | /nugget/unread | Auto testing |

  @regression @nugget @TC-N33
  Scenario Outline: Verify that the user is able to send emoji on the nugget chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget chat tab
    Then Validate that the input message field is displayed
    When Click on the nugget chat emoji icon
    Then Validate that the emoji section is open

    Examples:
      | UserRoll    | endPoint       |
      | allRoleUser | /nugget/unread |

  @regression @nugget @TC-N34
  Scenario Outline: Verify that the user is able to send emoji on the nugget chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget chat tab
    Then Validate that the input message field is displayed
    When Click on the nugget chat emoji icon
    Then Validate that the emoji section is open
    When Enter the "<EmojiName>" text on the search text box
    And Click on the emoji
    And Click on the send button
    Then Validate that the "<Emoji>" emoji message is displayed

    Examples:
      | UserRoll    | endPoint       | EmojiName  | Emoji |
      | allRoleUser | /nugget/unread | smiley_cat | 😺    |

  @regression @nugget @TC-N35
  Scenario Outline: Verify user is able to send image in the nugget chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget chat tab
    Then Validate that the input message field is displayed
    When Select the image
    And Click on the send button
    Then Validate that the sent image is displayed on chat section

    Examples:
      | UserRoll    | endPoint       |
      | allRoleUser | /nugget/unread |

  @regression @nugget @TC-N36
  Scenario Outline: Verify user is able to send document file in the nugget chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget chat tab
    Then Validate that the input message field is displayed
    When Select the document file
    And Click on the send button
    Then Validate that the sent document file is displayed on chat section

    Examples:
      | UserRoll    | endPoint       |
      | RM_RoleUser | /nugget/unread |

  @regression @nugget @TC-N37
  Scenario Outline: Verify user is able to send audio file in the nugget chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget chat tab
    Then Validate that the input message field is displayed
    When Select the audio file
    And Click on the send button
    Then Validate that the sent audio file is displayed on chat section

    Examples:
      | UserRoll         | endPoint       |
      | resourceRoleUser | /nugget/unread |

  @regression @nugget @TC-N38
  Scenario Outline: Verify user is able to send Video file in the nugget chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget chat tab
    Then Validate that the input message field is displayed
    When Select the video file
    And Click on the send button
    Then Validate that the sent video file is displayed on chat section

    Examples:
      | UserRoll       | endPoint       |
      | commonRoleUser | /nugget/unread |

  @regression @nugget @TC-N39
  Scenario Outline: Verify that the sent chat message has more option menu (Three Dote menu)
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget chat tab
    Then Validate that the input message field is displayed
    When Enter "<Message>" on chat input field
    And Click on the send button
    Then Validate that the sent message is displayed on chat section
    And Validate that the more option menu is displayed on sent message

    Examples:
      | UserRoll    | endPoint       | Message      |
      | allRoleUser | /nugget/unread | Auto testing |


  @regression @nugget @TC-N40
  Scenario Outline: Verify that the list of options menu on more options menu (Three Dots menu) of the sent message
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget chat tab
    Then Validate that the input message field is displayed
    When Enter "<Message>" on chat input field
    And Click on the send button
    Then Validate that the more option menu is displayed on sent message
    When Click on the more option menu
    Then Validate all the option is displayed on the list

    Examples:
      | UserRoll    | endPoint       | Message      |
      | allRoleUser | /nugget/unread | Auto testing |

  @regression @critical @nugget @TC-N41
  Scenario Outline: Verify that the user is able to reply to the sent message of the nugget chat section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget chat tab
    Then Validate that the input message field is displayed
    When Enter "<Message>" on chat input field
    And Click on the send button
    Then Validate that the more option menu is displayed on sent message
    When Click on the more option menu
    And Click on the reply message option
    And Enter the message for reply message
    And Click on the send button
    Then Validate that the main message and replied message both are displayed on the chat section
    Examples:
      | UserRoll    | endPoint       | Message      |
      | allRoleUser | /nugget/unread | Auto testing |

  @regression @critical @nugget @TC-N42
  Scenario Outline: Verify that the user is able to edit the message on nugget chat section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget chat tab
    Then Validate that the input message field is displayed
    When Enter "<Message>" on chat input field
    And Click on the send button
    Then Validate that the more option menu is displayed on sent message
    When Click on the more option menu
    And Click on the edit message option
    And Enter new message on chat input field
    And Click on the send button
    Then Validate that the updated sent message is displayed on chat section
    Examples:
      | UserRoll    | endPoint       | Message      |
      | allRoleUser | /nugget/unread | Auto testing |

  @regression @critical @nugget @TC-N43
  Scenario Outline: Verify that the user is able to delete the message on nugget chat section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget chat tab
    Then Validate that the input message field is displayed
    When Enter "<Message>" on chat input field
    And Click on the send button
    Then Validate that the more option menu is displayed on sent message
    When Click on the more option menu
    And Click on the delete message option
    Then Validate that the message is deleted from the chat section
    Examples:
      | UserRoll    | endPoint       | Message      |
      | allRoleUser | /nugget/unread | Auto testing |

  @regression @nugget @TC-N44 @TC-N45
  Scenario Outline: Verify that the user is not able to send more than 25MB file in the chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget chat tab
    Then Validate that the input message field is displayed
    When Select the "<File>" file
    And Click on the send button
    Then Validate that the toast validation message appears

    Examples:
      | UserRoll       | endPoint       | File  |
      | commonRoleUser | /nugget/unread | Video |
      | commonRoleUser | /nugget/unread | Image |

  @regression @nugget @TC-N46
  Scenario Outline: Verify that the user is able to select and send multiple files in the nugget chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget chat tab
    Then Validate that the input message field is displayed
    When Select the multiple files
    And Click on the send button
    Then Validate that the all selected file is sent and displayed on chat section

    Examples:
      | UserRoll      | endPoint       |
      | adminRoleUser | /nugget/unread |

  @regression @nugget @TC-N47
  Scenario Outline: Verify that the user is able to remove the selected file from the nugget chat section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget chat tab
    Then Validate that the input message field is displayed
    When Select the audio file
    Then Validate that the file is added on selected section
    And Click on the close icon of selected file
    Then Validate that the selected file is removed from section

    Examples:
      | UserRoll      | endPoint       |
      | adminRoleUser | /nugget/unread |

  @regression @nugget @TC-N48 @TC-N49 @TC-N50
  Scenario Outline: Verify that the sent image file, video file and audio file is also displayed in media section of nugget atteched tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget chat tab
    Then Validate that the input message field is displayed
    When Select the "<File>" file from local
    And Click on the send button
    Then Validate that the sent "<File>" file is displayed on chat section
    When Click on the nugget attachment tab
    And Click on the media sub tab
    Then Validated that the sent "<File>" file is displayed on media section

    Examples:
      | UserRoll    | endPoint       | File  |
      | PM_RoleUser | /nugget/unread | Image |
      | PM_RoleUser | /nugget/unread | Video |
      | PM_RoleUser | /nugget/unread | Audio |

  @regression @nugget @TC-N51
  Scenario Outline: Verify that the sent document file is also displayed in Documents section of nugget attached tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget chat tab
    Then Validate that the input message field is displayed
    When Select the document file
    And Click on the send button
    Then Validate that the sent document file is displayed on chat section
    When Click on the nugget attachment tab
    And Click on the documents sub tab
    Then Validated that the sent document file is displayed on documents section

    Examples:
      | UserRoll    | endPoint       |
      | PM_RoleUser | /nugget/unread |

  @regression @nugget @TC-N52
  Scenario Outline: Verify that the sent URL link is also displayed in Links section of nugget attached tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget chat tab
    Then Validate that the input message field is displayed
    When Enter current URL in chat input field
    And Click on the send button
    Then Validate that the sent link message is displayed on chat section
    When Click on the nugget attachment tab
    And Click on the links sub tab
    Then Validated that the sent link URL is displayed on links section

    Examples:
      | UserRoll    | endPoint       |
      | PM_RoleUser | /nugget/unread |


  @regression @nugget @TC-N53
  Scenario Outline: Verify that the audit message has only one (Reply) option on nugget chat more option list (three dot menu)
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget chat tab
    Then Validate that the more option menu is displayed on audit message
    When Click on the more option menu of audit message
    Then Validate that the more option list has only one value
    And Validate that the more option list has only reply option
    Examples:
      | UserRoll         | endPoint       |
      | teamLeadRoleUser | /nugget/unread |

  @regression @nugget @TC-N54
  Scenario Outline: Verify that the audit message color is blue (#1e90ff)
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget chat tab
    Then Validate that the chat has displayed created nugget audit message
    And Validate that the audit chat message color is "<ColorCode>"

    Examples:
      | UserRoll         | endPoint       | ColorCode |
      | teamLeadRoleUser | /nugget/unread | #1e90ff   |

  @regression @critical @nugget @TC-N55
  Scenario Outline: Verify that the user is able to search the nugget with nugget id
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the subscribed nugget tab
    And Get the any nugget id from list
    And Enter the nugget id on the search tab
    And Press enter key from keyboard
    Then Validate that the system is redirected on the search result tab
    And Validate that the searched nugget is displayed on search result tab list

    Examples:
      | UserRoll         | endPoint       |
      | teamLeadRoleUser | /nugget/unread |

