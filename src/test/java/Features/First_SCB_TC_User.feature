Feature: Scenario Based Test Cases of User Modules

  @regression @SC @SCU @TC-SCU01
  Scenario Outline: Validate that the sign up new user functionality
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the users option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the invite new users button is displayed
    When Click on the invite new users button
    Then Validate that the invite new users dialog box heading is displayed
    When Enter the email on the invite user email text box
    And Click on the done button
    Then Validate that the validation toast message is appears of invited user
    When Click on the logout option from side menu
    And Open new window and open yopmail url
    And Enter invited user email on yopmail and search email
    And Click on the invitation sign up link and switch to new open window
    Then Validate that the sign up page title is displayed
    When Enter all the user details
    And Click on the sign up button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the user profile option from setting sub menu
    #Then Validate that the first name and last name of created user is displayed on user profile page
    Examples:
      | UserRoll      | EndPoint        |
      | adminRoleUser | /settings/users |

  @regression @SC @SCU @TC-SCU02
  Scenario Outline: Validate that the newly created user is displayed on user list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the users option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the newly created user displayed on the user list

    Examples:
      | UserRoll      | EndPoint        |
      | adminRoleUser | /settings/users |

  @regression @SC @SCU @TC-SCU03
  Scenario: Validate that the newly created user is able to login
    Given I open Maestro website
    When Enter the newly created user's email
    And Enter the newly created user's password
    And Click on login button
    Then Validate Maestro logo is displayed
    #And Validate User Name Icon is displayed


  @regression @SC @SCU @TC-SCU04
  Scenario Outline: Validate that the assign private channel to newly created user and check that channel is displayed on the newly created user channel list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the users option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the newly created user
    And Select the private channel
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"
    When Click on the logout option from side menu
    And Enter the newly created user's email
    And Enter the newly created user's password
    And Click on login button
    And Click on the channel option from side menu
    Then Validate the current page URL has "/groups" end point
    And Validate that the assigned channel is displayed on the list

    Examples:
      | UserRoll      | EndPoint        | Message              |
      | adminRoleUser | /settings/users | Successfully updated |

  @regression @SC @SCU @TC-SCU05
  Scenario Outline: Validate that the remove private channel from newly created user and check that channel is removed from the newly created user channel list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the users option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the newly created user
    And Remove the selected private channel
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"
    When Click on the logout option from side menu
    And Enter the newly created user's email
    And Enter the newly created user's password
    And Click on login button
    And Click on the channel option from side menu
    Then Validate the current page URL has "/groups" end point
    And Validate that the assigned channel is removed from the list

    Examples:
      | UserRoll      | EndPoint        | Message              |
      | adminRoleUser | /settings/users | Successfully updated |

  @regression @SC @SCU @TC-SCU06
  Scenario Outline: Verify that the newly created user can change his password and he can login successfully with new password
    Given I open Maestro website
    When Enter the newly created user's email
    And Enter the newly created user's password
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Enter the "<UserRoll>" password on old password field
    And Enter the "<NewPassword>" password on new password field
    And Enter the "<NewPassword>" password on repeat new password field
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"
    When Click on the logout option from side menu
    And Enter the newly created user's email
    And Enter user password "<NewPassword>"
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Enter the "<NewPassword>" password on the old password field
    And Enter the "<UserRoll>" password on the new password field
    And Enter the "<UserRoll>" password on the repeat new password field
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll      | EndPoint               | NewPassword | Message                       |
      | adminRoleUser | /settings/user-profile | Qa@1010     | Password Successfully Updated |


  @regression @SC @SCU @TC-SCU07
  Scenario Outline: Validate that the admin user can deactivate the newly created user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the users option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the newly created user
    And Click on the inactive checkbox
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll      | EndPoint        | Message             |
      | adminRoleUser | /settings/users | Successfully kicked |

  @regression @SC @SCU @TC-SCU08
  Scenario: Validate that the inactive user is not able to login
    Given I open Maestro website
    When Enter the newly created user's email
    And Enter the newly created user's password
    And Click on login button
    Then Validate account type dropdown is display
    When Click on account type dropdown
    Then Validate that the list of account type is empty

  @regression @SC @SCU @TC-SCU09
  Scenario Outline: Validate that the displayed the nugget details when mouse hover on the sent nugget id message on the channel
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the chat input message field is displayed
    When Enter the nugget id on chat input field
    And Click on the chat send icon
    Then Validate that the sent message is displayed on the channel sent message section
    When Move cursor on the sent nugget id message
    Then Validate that the nugget details popup is displayed
    And Validate that the nugget id is displayed on the nugget details popup
    And Validate that the nugget name is displayed on the nugget details popup
    And Validate that the nugget description is displayed on the nugget details popup

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @SC @SCU @TC-SCU10
  Scenario Outline: Validate that the displayed nugget on the search list when click on the open icon of the sent nugget id message popup on the channel
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    Then Validate that the sent message is displayed on the channel sent message section
    When Move cursor on the sent nugget id message
    Then Validate that the nugget details popup is displayed
    When Click on the open nugget icon
    Then Validate the current page URL has "/nugget/search" end point
    Then Validate that the system is redirected on the search result tab
    And Validate that the nugget is displayed on search result tab list
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any channel from the list
    When Click on more option menu of sent message
    And Click on the delete message option from the list
    Then Validate that the message is deleted from the chat section

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /groups  |

  @regression @SC @SCU @TC-SCU11
  Scenario Outline: Validate that the displayed the nugget details when mouse hover on the sent nugget id message on the people chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    Then Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the chat input message field is displayed
    When Enter the nugget id on chat input field
    And Click on the chat send icon
    Then Validate that the sent message is displayed on the channel sent message section
    When Move cursor on the sent nugget id message
    Then Validate that the nugget details popup is displayed
    And Validate that the nugget id is displayed on the nugget details popup
    And Validate that the nugget name is displayed on the nugget details popup
    And Validate that the nugget description is displayed on the nugget details popup

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /people  |

  @regression @SC @SCU @TC-SCU12
  Scenario Outline: Validate that the displayed nugget on the search list when click on the open icon of the sent nugget id message popup on the people chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    Then Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    Then Validate that the sent message is displayed on the channel sent message section
    When Move cursor on the sent nugget id message
    Then Validate that the nugget details popup is displayed
    When Click on the open nugget icon
    Then Validate the current page URL has "/nugget/search" end point
    Then Validate that the system is redirected on the search result tab
    And Validate that the nugget is displayed on search result tab list
    Then Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the any user from the list
    When Click on more option menu of sent message
    And Click on the delete message option from the list
    Then Validate that the message is deleted from the chat section

    Examples:
      | UserRoll    | EndPoint |
      | allRoleUser | /people  |

  @regression @SC @SCU @TC-SCU13
  Scenario Outline: Validate that the displayed the nugget details when mouse hover on the sent nugget id message on the nugget chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<EndPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget chat tab
    Then Validate that the input message field is displayed
    When Enter the nugget id on nugget chat input field
    And Click on the send button
    Then Validate that the sent message is displayed on the channel sent message section
    When Move cursor on the sent nugget id message
    Then Validate that the nugget details popup is displayed
    And Validate that the nugget id is displayed on the nugget details popup
    And Validate that the nugget name is displayed on the nugget details popup
    And Validate that the nugget description is displayed on the nugget details popup

    Examples:
      | UserRoll    | EndPoint       |
      | allRoleUser | /nugget/unread |

  @regression @SC @SCU @TC-SCU14
  Scenario Outline: Validate that the displayed nugget on the search list when click on the open icon of the sent nugget id message popup on the nugget chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<EndPoint>" end point
    When Click on the subscribed nugget tab
    And Click on the nugget chat tab
    Then Validate that the sent message is displayed on the channel sent message section
    When Move cursor on the sent nugget id message
    Then Validate that the nugget details popup is displayed
    When Click on the open nugget icon
    Then Validate the current page URL has "/nugget/search" end point
    Then Validate that the system is redirected on the search result tab
    And Validate that the nugget is displayed on search result tab list
    When Click on nuggets option from side menu
    And Click on the subscribed nugget tab
    And Click on the nugget chat tab
    When Click on more option menu of sent message
    And Click on the delete message option from the list
    Then Validate that the message is deleted from the chat section

    Examples:
      | UserRoll    | EndPoint       |
      | allRoleUser | /nugget/unread |

  @regression @SC @SCU @TC-SCU15
  Scenario Outline: Validate that the audit message appears when the nugget name is changed
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Click on the subscribed nugget tab
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the nugget details tab
    And Update the nugget name on name text box
    And Click on the save button
    And Click on the nugget chat tab
    Then Validate that the chat has displayed "<Message>" audit message
    And Validate that the audit chat "<Message>" message color is "<ColorCode>"
    When Move cursor on the "<Message>" audit message
    Then Validate that the update details popup is displayed

    Examples:
      | UserRoll    | EndPoint              | Message       | ColorCode |
      | allRoleUser | /nugget/subscriptions | Modified Name | #1e90ff   |

  @regression @SC @SCU @TC-SCU16
  Scenario Outline: Validate that the audit message appears when the nugget type is changed
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Click on the subscribed nugget tab
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the nugget details tab
    And Update the nugget type
    And Click on the save button
    And Click on the nugget chat tab
    Then Validate that the chat has displayed changed nugget type audit message

    Examples:
      | UserRoll    | EndPoint              |
      | allRoleUser | /nugget/subscriptions |

  @regression @SC @SCU @TC-SCU17
  Scenario Outline: Validate that the audit message appears when the nugget priority is changed
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Click on the subscribed nugget tab
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the nugget details tab
    And Update the nugget priority
    And Click on the save button
    And Click on the nugget chat tab
    Then Validate that the chat has displayed changed nugget's priority audit message

    Examples:
      | UserRoll    | EndPoint              |
      | allRoleUser | /nugget/subscriptions |

  @regression @SC @SCU @TC-SCU18
  Scenario Outline: Validate that the audit message appears when the nugget description is changed
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Click on the subscribed nugget tab
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the nugget details tab
    And Update the nugget description on the description text box
    And Click on the save button
    And Click on the nugget chat tab
    Then Validate that the chat has displayed "<Message>" audit message
    And Validate that the audit chat "<Message>" message color is "<ColorCode>"
    When Move cursor on the "<Message>" audit message
    Then Validate that the update details popup is displayed

    Examples:
      | UserRoll    | EndPoint              | Message              | ColorCode |
      | allRoleUser | /nugget/subscriptions | Modified Description | #1e90ff   |

  @regression @SC @SCU @TC-SCU19 @test
  Scenario Outline: Validate that the audit message appears when the nugget moved to backlog
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Click on the subscribed nugget tab
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the nugget details tab
    And Click on backlog checkbox
    And Select the current date from open datepicker
    And Click on the save button
    And Click on the nugget chat tab
    Then Validate that the chat has displayed moved nugget to backlog audit message

    Examples:
      | UserRoll    | EndPoint              |
      | allRoleUser | /nugget/subscriptions |







