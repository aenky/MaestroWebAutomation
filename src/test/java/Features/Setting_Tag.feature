Feature: Tag Module's Test Case of Setting Menu

  @regression @dependant @setting @tag @TC-T1
  Scenario Outline: Verify that the tag option is not displayed on sub-menu of the settings option for common, resource, team lead, project maestro and release maestro role type user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the "Tags" option is not displayed on the sub menu

    Examples:
      | UserRoll         | EndPoint               |
      | commonRoleUser   | /settings/user-profile |
      | resourceRoleUser | /settings/user-profile |
      | teamLeadRoleUser | /settings/user-profile |
      | PM_RoleUser      | /settings/user-profile |
      | RM_RoleUser      | /settings/user-profile |

  @regression @dependant @setting @tag @TC-T2
  Scenario Outline: Verify that the tag option is displayed on sub-menu of the settings option for admin role type user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the "Tags" option is displayed on the sub menu

    Examples:
      | UserRoll      | EndPoint               |
      | adminRoleUser | /settings/user-profile |

  @regression @setting @tag @TC-T3
  Scenario Outline: Verify that the click functionality on the tag option from the settings submenu
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the tags option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new tag button is displayed

    Examples:
      | UserRoll      | EndPoint       |
      | adminRoleUser | /settings/tags |

  @regression @dependant @setting @tag @TC-T4
  Scenario Outline: Verify that the click functionality on the new tag button
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the tags option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new tag button is displayed
    When Click on the new tag button
    Then Validate that the create new tag dialog box heading is displayed

    Examples:
      | UserRoll      | EndPoint       |
      | adminRoleUser | /settings/tags |

  @regression @setting @tag @TC-T5
  Scenario Outline: Verify click functionality on the close icon of new tag dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the tags option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new tag button is displayed
    When Click on the new tag button
    And Click on the close icon
    Then Validate that the create new tag dialog box is closed

    Examples:
      | UserRoll      | EndPoint       |
      | adminRoleUser | /settings/tags |

  @regression @dependant @setting @tag @TC-T6
  Scenario Outline: Verify that the create button is disabled until the user does not fill up the required field on create tag dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the tags option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new tag button is displayed
    When Click on the new tag button
    Then Validate that the create button is disabled
    When Enter "<TagName>" on the tag name text box
    Then Validate that the create button is Enable

    Examples:
      | UserRoll      | EndPoint       | TagName  |
      | adminRoleUser | /settings/tags | Auto Tag |

  @regression @dependant @setting @tag @TC-T7
  Scenario Outline: Verify that the user can not enter more than 50 characters on the name text box of the 'Create The New Tag' dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the tags option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new tag button is displayed
    When Click on the new tag button
    And Enter "<TagName>" on the tag name text box
    Then Validate that the max length validation message is displayed

    Examples:
      | UserRoll      | EndPoint       | TagName                                                |
      | adminRoleUser | /settings/tags | Auto The Name on the text box of Create Tag Dialog box |

  @regression @critical @dependant @setting @tag @TC-T8
  Scenario Outline: Verify that the user can create the new tag with the required field
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the tags option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new tag button is displayed
    When Click on the new tag button
    And Enter "<TagName>" on the tag name text box
    And Click on the create button
    Then Validate that the validation toast message appears with "<Message>"
    And Validate that the created tag name is displayed on the list and highlighted
    When Deactivate the created tag

    Examples:
      | UserRoll      | EndPoint       | TagName   | Message                  |
      | adminRoleUser | /settings/tags | AAuto Tag | Successfully created tag |

  @regression @critical @dependant @setting @tag @TC-T9
  Scenario Outline: Verify that the user can create the new tag with the all the field
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the tags option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new tag button is displayed
    When Click on the new tag button
    And Enter "<TagName>" on the tag name text box
    And Enter the description on the text box
    And Click on the create button
    Then Validate that the validation toast message appears with "<Message>"
    And Validate that the created tag name is displayed on the list and highlighted

    Examples:
      | UserRoll      | EndPoint       | TagName   | Message                  |
      | adminRoleUser | /settings/tags | AAuto tag | Successfully created tag |

  @regression @dependant @setting @tag @TC-T10
  Scenario Outline: Verify that the save button is enabled after updating the tag name on the tag edit section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the tags option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created tag from list
    Then Validate that the save button is disabled
    When Update "<TagName>" the tag name
    Then Validate that the save button is enabled

    Examples:
      | UserRoll      | EndPoint       | TagName          |
      | adminRoleUser | /settings/tags | AAuto Update Tag |

  @regression @setting @tag @TC-T11
  Scenario Outline: Verify that the save button is enabled after updating the description on the tag edit section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the tags option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created tag from list
    Then Validate that the save button is disabled
    When Update "<TagDescription>" the tag description
    Then Validate that the save button is enabled

    Examples:
      | UserRoll      | EndPoint       | TagDescription               |
      | adminRoleUser | /settings/tags | AAuto Update Tag Description |

  @regression @dependant @setting @tag @TC-T12
  Scenario Outline: Verify that the user can not enter more than 50 characters on the name text box of the 'Edit Tag' section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the tags option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created tag from list
    Then Validate that the save button is disabled
    When Update "<TagName>" the tag name
    And Click on the save button
    Then Validate that the max length validation message is displayed on the edit section

    Examples:
      | UserRoll      | EndPoint       | TagName                                            |
      | adminRoleUser | /settings/tags | Auto The Name on the text box of edit tag text box |

  @regression @dependant @setting @tag @TC-T13
  Scenario Outline: Verify that the user can update the tag name
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the tags option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created tag from list
    Then Validate that the save button is disabled
    When Update "<TagName>" the tag name
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll      | EndPoint       | TagName           | Message                  |
      | adminRoleUser | /settings/tags | AAAuto Update Tag | Successfully updated tag |

  @regression @setting @tag @TC-T14
  Scenario Outline: Verify that the user can update the tag description
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the tags option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created tag from list
    Then Validate that the save button is disabled
    When Update "<TagDescription>" the tag description
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll      | EndPoint       | TagDescription               | Message                  |
      | adminRoleUser | /settings/tags | AAuto Update Tag Description | Successfully updated tag |

  @regression @critical @dependant @setting @tag @TC-T15
  Scenario Outline: Verify that the user can not create a duplicate tag
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the tags option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new tag button is displayed
    When Click on the new tag button
    And Enter tag name which is already existing on the list
    And Click on the create button
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll      | EndPoint       | Message          |
      | adminRoleUser | /settings/tags | Repetitive Title |

  @regression @critical @dependant @setting @tag @TC-T16
  Scenario Outline: Verify that the user can deactivate the tag
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the tags option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created tag from list
    And Click on the deactivate tag check box
    And Click on the save button
    #Then Validate that the validation toast message appears with "<Message>"
    And Remove the active filter from inactive column
    And Apply the inactive filter on inactive column
    Then Validate that the deactivate tag is displayed on the list

    Examples:
      | UserRoll      | EndPoint       | Message                  |
      | adminRoleUser | /settings/tags | Tag successfully updated |

  @regression @setting @tag @TC-T17
  Scenario Outline: Verify that the user can activate the tag
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the tags option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the first tag from the list
    And Remove the active filter from inactive column
    And Click on the created tag from list
    And Click on the deactivate tag check box
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"
    #And Validate that the deactivate tag is removed from the list
    When Click on the deactivate tag check box
    And Click on the save button
    And Wait for "2" sec

    Examples:
      | UserRoll      | EndPoint       | Message                  |
      | adminRoleUser | /settings/tags | Successfully updated tag |