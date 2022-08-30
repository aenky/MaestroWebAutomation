Feature: Department Module's Test Case of Setting Menu

  @regression @critical @dependant @setting @department @TC-D1
  Scenario Outline: Verify that the departments option is not displayed on sub-menu of the settings option for common, resource, team lead, project maestro and release maestro role type user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the "Departments" option is not displayed on the sub menu

    Examples:
      | UserRoll         | EndPoint               |
      | commonRoleUser   | /settings/user-profile |
      | resourceRoleUser | /settings/user-profile |
      | teamLeadRoleUser | /settings/user-profile |
      | PM_RoleUser      | /settings/user-profile |
      | RM_RoleUser      | /settings/user-profile |

  @regression @critical @dependant @setting @department @TC-U2
  Scenario Outline: Verify that the departments option is displayed on sub-menu of the settings option for admin role type user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the "Departments" option is displayed on the sub menu

    Examples:
      | UserRoll      | EndPoint               |
      | adminRoleUser | /settings/user-profile |

  @regression @setting @department @TC-D3
  Scenario Outline: Verify that the click functionality on the departments option from the settings submenu
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the departments option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new department button is displayed

    Examples:
      | UserRoll      | EndPoint              |
      | adminRoleUser | /settings/departments |

  @regression @setting @department @TC-D4
  Scenario Outline: Verify that the click functionality on the new department button
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the departments option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new department button is displayed
    When Click on the new department button
    Then Validate that the create new department dialog box heading is displayed

    Examples:
      | UserRoll      | EndPoint              |
      | adminRoleUser | /settings/departments |

  @regression @setting @department @TC-D5
  Scenario Outline: Verify click functionality on the close icon of new department dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the departments option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new department button is displayed
    When Click on the new department button
    And Click on the close icon
    Then Validate that the create new department dialog box is closed

    Examples:
      | UserRoll      | EndPoint              |
      | adminRoleUser | /settings/departments |

  @regression @dependant @setting @department @TC-D6
  Scenario Outline: Verify that the Confirm button is disabled until the user does not fill up the required field
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the departments option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new department button is displayed
    When Click on the new department button
    Then Validate that the create button is disabled
    When Enter "<DepartmentName>" on the department name text box
    Then Validate that the create button is Enable

    Examples:
      | UserRoll      | EndPoint              | DepartmentName   |
      | adminRoleUser | /settings/departments | AAuto Department |

  @regression @dependant @setting @department @TC-D7
  Scenario Outline: Verify that the user can not enter more than 50 characters on the name text box of the 'Create Department' dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the departments option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new department button is displayed
    When Click on the new department button
    And Enter "<DepartmentName>" on the department name text box
    Then Validate that the max length validation message is displayed

    Examples:
      | UserRoll      | EndPoint              | DepartmentName                                                |
      | adminRoleUser | /settings/departments | Auto The Name on the text box of Create Department Dialog box |

  @regression @critical @dependant @setting @department @TC-D8
  Scenario Outline: Verify that the admin user can create the new department
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the departments option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new department button is displayed
    When Click on the new department button
    And Enter "<DepartmentName>" on the department name text box
    And Click on the create button
    Then Validate that the validation toast message appears with "<Message>"
    And Validate that the created department name is displayed on the list and highlighted

    Examples:
      | UserRoll      | EndPoint              | DepartmentName   | Message                         |
      | adminRoleUser | /settings/departments | AAuto Department | Successfully created department |


  @regression @dependant @setting @department @TC-D9
  Scenario Outline: Verify that the save button of the edit section is enabled after updating the text on the department text box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the departments option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the first department from list
    Then Validate that the save button is disabled
    When Update "<DepartmentName>" the department name
    Then Validate that the save button is enabled

    Examples:
      | UserRoll      | EndPoint              | DepartmentName          |
      | adminRoleUser | /settings/departments | AAuto Update Department |

  @regression @dependant @setting @department @TC-D10
  Scenario Outline: Verify that the user can not enter more than 50 characters on the name text box of the 'Edit Department' section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the departments option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the first department from list
    And Update "<DepartmentName>" the department name
    Then Validate that the max length validation message is displayed on the edit section

    Examples:
      | UserRoll      | EndPoint              | DepartmentName                                                |
      | adminRoleUser | /settings/departments | Auto The Name on the text box of Create Department Dialog box |

  @regression @critical @dependant @setting @department @TC-D11
  Scenario Outline: Verify that the admin user can update the department name
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the departments option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created department from list
    And Update "<DepartmentName>" the department name
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"
    And Validate that the updated department name is also reflated on the listed event

    Examples:
      | UserRoll      | EndPoint              | DepartmentName          | Message              |
      | adminRoleUser | /settings/departments | AAuto Update Department | Successfully updated |

  @regression @critical @dependant @setting @department @TC-D12
  Scenario Outline: Verify that the user can not create a duplicate department
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the departments option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new department button is displayed
    When Click on the new department button
    And Enter department name which is already existing on the list
    And Click on the create button
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll      | EndPoint              | Message         |
      | adminRoleUser | /settings/departments | Repetitive Name |

  @regression @critical @dependant @setting @department @TC-D13
  Scenario Outline: Verify that the user can deactivate the department
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the departments option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created department from list
    And Click on the deactivate department check box
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"
    And Validate that the deactivate department is removed from the list

    Examples:
      | UserRoll      | EndPoint              | Message                             |
      | adminRoleUser | /settings/departments | Successfully deactivated department |

  @regression @critical @dependant @setting @department @TC-D14
  Scenario Outline: Verify that the user can filter the deactivate department
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the departments option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the first department from list
    And Remove the active filter from inactive column
    And Apply the inactive filter on inactive department column
    Then Validate that the list of deactivate department

    Examples:
      | UserRoll      | EndPoint              |
      | adminRoleUser | /settings/departments |

  @regression @setting @department @TC-D15
  Scenario Outline: Verify that the user can active the deactivate department
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the departments option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the first department from list
    And Remove the active filter from inactive column
    And Apply the inactive filter on inactive department column
    And Click on the created department from list
    And Click on the deactivate department check box
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"
    #And Validate that the deactivate department is removed from the list
    When Click on the deactivate department check box
    And Click on the save button
    And Wait for "2" sec

    Examples:
      | UserRoll      | EndPoint              | Message              |
      | adminRoleUser | /settings/departments | Successfully updated |