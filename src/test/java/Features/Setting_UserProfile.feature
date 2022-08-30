Feature: User Profile Module Test Case of Setting Menu

  @regression @dependant @setting @TC-S1 @TC-S2 @TC-S3 @TC-S3 @TC-S5
  Scenario Outline: Verify that the sub menu options of the settings menu for common, resource team lead, project maestro and release maestro role type user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the list of option on setting sub menu is three
    And Validate that the "User Profile" option is displayed on the sub menu
    And Validate that the "Date & time Settings" option is displayed on the sub menu
    And Validate that the "Personal Calendar" option is displayed on the sub menu

    Examples:
      | UserRoll         | EndPoint               |
      | commonRoleUser   | /settings/user-profile |
      | resourceRoleUser | /settings/user-profile |
      | teamLeadRoleUser | /settings/user-profile |
      | PM_RoleUser      | /settings/user-profile |
      | RM_RoleUser      | /settings/user-profile |

  @regression @dependant @setting @TC-S6
  Scenario Outline: Verify that the sub menu options of the settings menu for admin role type user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the list of option on setting sub menu is thirteen
    And Validate that the "User Profile" option is displayed on the sub menu
    And Validate that the "Date & time Settings" option is displayed on the sub menu
    And Validate that the "Personal Calendar" option is displayed on the sub menu
    And Validate that the "Default Settings" option is displayed on the sub menu
    And Validate that the "Company Calendar" option is displayed on the sub menu
    And Validate that the "Users" option is displayed on the sub menu
    And Validate that the "Departments" option is displayed on the sub menu
    And Validate that the "Channels" option is displayed on the sub menu
    And Validate that the "Phases" option is displayed on the sub menu
    And Validate that the "Skills" option is displayed on the sub menu
    And Validate that the "Workflows" option is displayed on the sub menu
    And Validate that the "Tags" option is displayed on the sub menu
    #And Validate that the "Release Note" option is displayed on the sub menu

    Examples:
      | UserRoll      | EndPoint               |
      | adminRoleUser | /settings/user-profile |

  @regression @dependant @setting @TC-S7
  Scenario Outline: Verify that the user profile option is by default selected
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the user profile option is selected

    Examples:
      | UserRoll      | EndPoint               |
      | adminRoleUser | /settings/user-profile |

  @regression @setting @userProfile @TC-UP1
  Scenario Outline: Verify that the 'User Id, Email, Phone Number, Social Media and City' field is disabled on the user profile page
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    #And Validate that the user id field is disabled
    And Validate that the email field is disabled
    And Validate that the phone number field is disabled
    And Validate that the social media field is disabled
    And Validate that the city field is disabled

    Examples:
      | UserRoll      | EndPoint               |
      | adminRoleUser | /settings/user-profile |

  @regression @critical @dependant @setting @userProfile @TC-UP2
  Scenario Outline: Verify that the selected department is displayed on the user profile page
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the user option from setting sub menu
    And Find "<UserRoll>" user from the user list and Click on it
    And Get selected department
    And Click on the user profile option from setting sub menu
    Then Validate that the user department is same as selected on the user list

    Examples:
      | UserRoll      | EndPoint               |
      | adminRoleUser | /settings/user-profile |

  @regression @critical @dependant @setting @userProfile @TC-UP3
  Scenario Outline: Verify that the selected user role for the login user is displayed on the user profile page
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the user option from setting sub menu
    And Find "<UserRoll>" user from the user list and Click on it
    And Get selected user role type
    And Click on the user profile option from setting sub menu
    Then Validate that the user role is same as selected on the user list

    Examples:
      | UserRoll      | EndPoint               |
      | adminRoleUser | /settings/user-profile |

  @regression @critical @dependant @setting @userProfile @TC-UP4
  Scenario Outline: Verify that the list of the selected channel for login user is displayed on the user profile page
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the user option from setting sub menu
    And Find "<UserRoll>" user from the user list and Click on it
    And Get selected private channel
    And Click on the user profile option from setting sub menu
    Then Validate that the private channel is same as selected on the user list

    Examples:
      | UserRoll      | EndPoint               |
      | adminRoleUser | /settings/user-profile |

  @regression @critical @dependant @setting @userProfile @TC-UP5
  Scenario Outline: Verify that the list of the selected skills for login user is displayed on the user profile page
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the user option from setting sub menu
    And Find "<UserRoll>" user from the user list and Click on it
    And Get selected user skills
    And Click on the user profile option from setting sub menu
    Then Validate that the user skills is same as selected on the user list

    Examples:
      | UserRoll      | EndPoint               |
      | adminRoleUser | /settings/user-profile |

  @regression @setting @userProfile @TC-UP6
  Scenario Outline: Verify that the 'Update Profile' button is enabled after updating the first name field
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the user profile button is disabled
    When Enter the "<FirstName>" on the first name text box
    Then Validate that the user profile button is enabled

    Examples:
      | UserRoll      | EndPoint               | FirstName |
      | adminRoleUser | /settings/user-profile | Ankit     |

  @regression @setting @userProfile @TC-UP7
  Scenario Outline: Verify that the 'Update Profile' button is enabled after updating the last name field
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the user profile button is disabled
    When Enter the "<LastName>" on the last name text box
    Then Validate that the user profile button is enabled

    Examples:
      | UserRoll      | EndPoint               | LastName |
      | adminRoleUser | /settings/user-profile | Mistry   |

  @regression @setting @userProfile @TC-UP8
  Scenario Outline: Verify that the 'Update Profile' button is enabled after updating the date of birth field
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the user profile button is disabled
    When Update the date from date dropdown
    Then Validate that the user profile button is enabled
    When Refresh the page
    Then Validate that the user profile button is disabled
    When Update the month from date dropdown
    Then Validate that the user profile button is enabled
    When Refresh the page
    Then Validate that the user profile button is disabled
    When Update the year from date dropdown
    Then Validate that the user profile button is enabled

    Examples:
      | UserRoll      | EndPoint               |
      | adminRoleUser | /settings/user-profile |

  @regression @critical @dependant @setting @userProfile @TC-UP9
  Scenario Outline: Verify that the user can update user's first name
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Enter the "<FirstName>" on the first name text box
    And Click on the update profile button
    Then Validate that the validation toast message appears with "<Message>"
    And Enter the "<OldName>" on the first name text box
    And Click on the update profile button
    Then Validate that the validation toast message appears with "<Message>"


    Examples:
      | UserRoll      | EndPoint               | FirstName | Message                     | OldName    |
      | adminRoleUser | /settings/user-profile | Ankit     | Member Successfully Updated | Auto Admin |

  @regression @critical @dependant @setting @userProfile @TC-UP10
  Scenario Outline: Verify that the user can update user's last name
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Enter the "<LastName>" on the last name text box
    And Click on the update profile button
    Then Validate that the validation toast message appears with "<Message>"
    And Enter the "<OldName>" on the last name text box
    And Click on the update profile button
    Then Validate that the validation toast message appears with "<Message>"


    Examples:
      | UserRoll      | EndPoint               | LastName | Message                     | OldName |
      | adminRoleUser | /settings/user-profile | Mistry   | Member Successfully Updated | User    |

  @regression @critical @dependant @setting @userProfile @TC-UP11
  Scenario Outline: Verify that the user can update user's date of birth
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Update the date from date dropdown
    And Update the month from date dropdown
    And Update the year from date dropdown
    And Click on the update profile button
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll      | EndPoint               | Message                     |
      | adminRoleUser | /settings/user-profile | Member Successfully Updated |

  @regression @setting @userProfile @TC-UP12
  Scenario Outline: Verify that the save button of the change password section is enabled after filling up all the field
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    Then Validate that the save button is disabled
    When Enter the "<UserRoll>" password on old password field
    Then Validate that the save button is disabled
    When Enter the "<NewPassword>" password on new password field
    Then Validate that the save button is disabled
    When Enter the "<NewPassword>" password on repeat new password field
    Then Validate that the save button is enabled

    Examples:
      | UserRoll      | EndPoint               | NewPassword |
      | adminRoleUser | /settings/user-profile | Qa@1010     |

  @regression @dependant @setting @userProfile @TC-UP13
  Scenario Outline: Verify that the user can not change the password by entering the wrong password on the old password field
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Enter the "QA@t2020" password on the old password field
    And Enter the "<NewPassword>" password on new password field
    And Enter the "<NewPassword>" password on repeat new password field
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll      | EndPoint               | NewPassword | Message                  |
      | adminRoleUser | /settings/user-profile | Qa@1010     | Invalid Current Password |

  @regression @dependant @setting @userProfile @TC-UP14
  Scenario Outline: Verify that the user can not change the password by entering the different password on the new password and repeat new password field
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Enter the "QA@t2020" password on the old password field
    And Enter the "<NewPassword>" password on new password field
    And Enter the "Qa@A1010" password on repeat new password field
    And Click on the save button
    Then Validate that the "<Message>" validation message appears on repeat new password field

    Examples:
      | UserRoll      | EndPoint               | NewPassword | Message                              |
      | adminRoleUser | /settings/user-profile | Qa@1010     | Password confirmation does not match |

  #@regression @critical @dependant @setting @userProfile @TC-UP15
  Scenario Outline: Verify that the user can change the password successfully
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Enter the "<UserRoll>" password on old password field
    And Enter the "<NewPassword>" password on new password field
    And Enter the "<NewPassword>" password on repeat new password field
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"
    When Click on logout option from side menu
    When Enter the user email "<UserRoll>"
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