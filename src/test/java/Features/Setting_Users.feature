Feature: Users Module Test Case of Setting Menu

  @regression @dependant @setting @users @TC-U1
  Scenario Outline: Verify that the users option is not displayed on sub-menu of the settings option for common, resource, team lead, project maestro and release maestro role type user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the "Uses" option is not displayed on the sub menu

    Examples:
      | UserRoll         | EndPoint               |
      | commonRoleUser   | /settings/user-profile |
      | resourceRoleUser | /settings/user-profile |
      | teamLeadRoleUser | /settings/user-profile |
      | PM_RoleUser      | /settings/user-profile |
      | RM_RoleUser      | /settings/user-profile |

  @regression @dependant @setting @users @TC-U2
  Scenario Outline: Verify that the users option is displayed on sub-menu of the settings option for admin role type user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the "Users" option is displayed on the sub menu

    Examples:
      | UserRoll      | EndPoint               |
      | adminRoleUser | /settings/user-profile |

  @regression @setting @users @TC-U3
  Scenario Outline: Verify that the click functionality on the users option from the settings submenu
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the users option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the invite new users button is displayed

    Examples:
      | UserRoll      | EndPoint        |
      | adminRoleUser | /settings/users |

  @regression @dependant @setting @users @TC-U4
  Scenario Outline: Verify that the click functionality on the invite new users button
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

    Examples:
      | UserRoll      | EndPoint        |
      | adminRoleUser | /settings/users |

  @regression @setting @users @TC-U5
  Scenario Outline: Verify Click functionality on the close icon of invite new user dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the users option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the invite new users button is displayed
    When Click on the invite new users button
    Then Validate that the close icon is displayed
    When Click on the close icon of open dialog box
    Then Validate that the invite new users dialog box is closed

    Examples:
      | UserRoll      | EndPoint        |
      | adminRoleUser | /settings/users |

  @regression @setting @users @TC-U6
  Scenario Outline: Verify that the done button is disabled until the user does not fill up the required field
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
    And Validate that the done button is disabled
    When Enter "<Email>" email on invite user email text box
    Then Validate that the done button is enable

    Examples:
      | UserRoll      | EndPoint        | Email                 |
      | adminRoleUser | /settings/users | auto_test@yopmail.com |

  @regression @dependant @setting @users @TC-U7
  Scenario Outline: Verify that the send user invitation with invalid email format
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
    When Enter "<Email>" email on invite user email text box
    And Click on the done button
    Then Validate that the wrong email validation message is displayed

    Examples:
      | UserRoll      | EndPoint        | Email                  | Message              |
      | adminRoleUser | /settings/users | auto_test@yopmail.     | Invalid Email Format |
      | adminRoleUser | /settings/users | auto_test@yopmail      | Invalid Email Format |
      | adminRoleUser | /settings/users | auto_testyopmail.com   | Invalid Email Format |
      | adminRoleUser | /settings/users | auto_test@yopmail.c    | Invalid Email Format |
      | adminRoleUser | /settings/users | @auto_test@yopmail.com | Invalid Email Format |

  @regression @critical @dependant @setting @users @TC-U8
  Scenario Outline: Verify that the send user invitation with valid email format
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
    When Enter "<Email>" email on invite user email text box
    And Click on the done button
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll      | EndPoint        | Email                 | Message                                  |
      | adminRoleUser | /settings/users | auto_test@yopmail.com | auto_test@yopmail.com invited to Maestro |

  @regression @critical @dependant @setting @users @TC-U9
  Scenario Outline: Verify that the send user invitation with already existing user's email
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
    When Enter "<Email>" email on invite user email text box
    And Click on the done button
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll      | EndPoint        | Email             | Message                      |
      | adminRoleUser | /settings/users | amistry@xeba.tech | Already In This Organization |

  @regression @setting @users @TC-U10
  Scenario Outline: Verify the heading list of the user list table
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the users option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the invite new users button is displayed
    And Validate the count of user's table column
    #And Validate that the "Email" Header is display
    And Validate that the "Last Name" Header is display
    And Validate that the "First Name" Header is display
    And Validate that the "Department" Header is display
    And Validate that the "Roles" Header is display
    And Validate that the "Messages" Header is display
    And Validate that the "Inactive" Header is display

    Examples:
      | UserRoll      | EndPoint        |
      | adminRoleUser | /settings/users |

  @regression @setting @users @TC-U11
  Scenario Outline: Verify that the save button is enabled after updating the user role field on the user edit section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the users option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the first user from list
    Then Validate that the save button is disabled
    When Select the user role type
    Then Validate that the save button is enabled

    Examples:
      | UserRoll      | EndPoint        |
      | adminRoleUser | /settings/users |

  @regression @setting @users @TC-U12
  Scenario Outline: Verify that the save button is enabled after updating the private channel field on the user edit section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the users option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the first user from list
    Then Validate that the save button is disabled
    When Select the private channel
    Then Validate that the save button is enabled

    Examples:
      | UserRoll      | EndPoint        |
      | adminRoleUser | /settings/users |

  @regression @critical @dependant @setting @users @TC-U13
  Scenario Outline: Verify that the user can assign the new role to the user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the users option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the first user from list
    And Select the user role type
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"
    And Validate that the added role is also displayed on user list

    Examples:
      | UserRoll      | EndPoint        | Message                      |
      | adminRoleUser | /settings/users | successfully updated amadeus |

  @regression @critical @dependant @setting @users @TC-U14
  Scenario Outline: Verify that the user can unassign the role to the user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the users option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the first user from list
    And Unassign the selected user role type
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"
    And Validate that the unassign role is also removed from the user list

    Examples:
      | UserRoll      | EndPoint        | Message                        |
      | adminRoleUser | /settings/users | Successfully updated Amadeus |

  @regression @critical @dependant @setting @users @TC-U15
  Scenario Outline: Verify that the admin user can add on the private channels to the any user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the users option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the first user from list
    And Select the private channel
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll      | EndPoint        | Message              |
      | adminRoleUser | /settings/users | Successfully updated |

  @regression @critical @dependant @setting @users @TC-U16
  Scenario Outline: Verify that the admin user can remove any user from the private channels
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the users option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the first user from list
    And Remove the selected private channel
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"


    Examples:
      | UserRoll      | EndPoint        | Message              |
      | adminRoleUser | /settings/users | Successfully updated |

  @regression @critical @dependant @setting @users @TC-U17
  Scenario Outline: Verify that the admin user can add the skill of the user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the users option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the first user from list
    And Get the size of selected skill
    And Select the user skills
    Then Validate that the skill is assign to user

    Examples:
      | UserRoll      | EndPoint        |
      | adminRoleUser | /settings/users |

  @regression @critical @dependant @setting @users @TC-U18
  Scenario Outline: Verify that the admin user can add specialty from added user's skill
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the users option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the first user from list
    And Add the user specialty
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll      | EndPoint        | Message                      |
      | adminRoleUser | /settings/users | Specialty Successfully Grant |

  @regression @critical @dependant @setting @users @TC-U19
  Scenario Outline: Verify that the admin user can remove specialty from added user's skill
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the users option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the first user from list
    And Remove the user specialty
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll      | EndPoint        | Message                     |
      | adminRoleUser | /settings/users | Specialty Successfully Deny |

  @regression @critical @dependant @setting @users @TC-U20
  Scenario Outline: Verify that the admin user can remove the skill of the user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the users option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the first user from list
    And Get the size of selected skill
    And Remove the selected skill
    Then Validate that the skill is removed from user

    Examples:
      | UserRoll      | EndPoint        |
      | adminRoleUser | /settings/users |

  @regression @critical @dependant @setting @users @TC-U21 @TC-U22
  Scenario Outline: Verify that the admin can deactivate and active other users
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the users option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the deactivate check box of first user from list
    Then Validate that the validation toast message appears with "<Message>"
    When Click on the deactivate check box of first user from list
    Then Validate that the validation toast message appears with "Successfully"


    Examples:
      | UserRoll      | EndPoint        | Message             |
      | adminRoleUser | /settings/users | Successfully kicked |

