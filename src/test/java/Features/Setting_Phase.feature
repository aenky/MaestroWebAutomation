Feature: Phase Module's Test Case of Setting Menu

  @regression @dependant @setting @phase @TC-PH1
  Scenario Outline: Verify that the phase option is not displayed on sub-menu of the settings option for common, resource, team lead, project maestro and release maestro role type user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the "Phases" option is not displayed on the sub menu

    Examples:
      | UserRoll         | EndPoint               |
      | commonRoleUser   | /settings/user-profile |
      | resourceRoleUser | /settings/user-profile |
      | teamLeadRoleUser | /settings/user-profile |
      | PM_RoleUser      | /settings/user-profile |
      | RM_RoleUser      | /settings/user-profile |

  @regression @dependant @setting @phase @TC-PH2
  Scenario Outline: Verify that the phase option is displayed on sub-menu of the settings option for admin role type user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the "Phases" option is displayed on the sub menu

    Examples:
      | UserRoll      | EndPoint               |
      | adminRoleUser | /settings/user-profile |

  @regression @setting @phase @TC-PH3
  Scenario Outline: Verify that the click functionality on the phase option from the settings submenu
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the phases option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new phase button is displayed

    Examples:
      | UserRoll      | EndPoint         |
      | adminRoleUser | /settings/phases |

  @regression @dependant @setting @phase @TC-PH4
  Scenario Outline: Verify that the click functionality on the new phase button
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the phases option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new phase button is displayed
    When Click on the new phase button
    Then Validate that the create new phase dialog box heading is displayed

    Examples:
      | UserRoll      | EndPoint         |
      | adminRoleUser | /settings/phases |

  @regression @setting @phase @TC-PH5
  Scenario Outline: Verify click functionality on the close icon of new phase dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the phases option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new phase button is displayed
    When Click on the new phase button
    And Click on the close icon
    Then Validate that the create new channel dialog box is closed

    Examples:
      | UserRoll      | EndPoint         |
      | adminRoleUser | /settings/phases |

  @regression @dependant @setting @phase @TC-PH6
  Scenario Outline: Verify that the create button is disabled until the user does not fill up the required field on create phase dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the phases option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new phase button is displayed
    When Click on the new phase button
    Then Validate that the create button is disabled
    When Enter "<PhaseName>" on the phase name text box
    Then Validate that the create button is Enable

    Examples:
      | UserRoll      | EndPoint         | PhaseName  |
      | adminRoleUser | /settings/phases | Auto Phase |

  @regression @dependant @setting @phase @TC-PH7
  Scenario Outline: Verify that the user can not enter more than 50 characters on the name text box of the 'Create The New Phase' dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the phases option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new phase button is displayed
    When Click on the new phase button
    And Enter "<PhaseName>" on the phase name text box
    Then Validate that the length validation message is displayed

    Examples:
      | UserRoll      | EndPoint         | PhaseName                                                |
      | adminRoleUser | /settings/phases | Auto The Name on the text box of Create Phase Dialog box |

  @regression @critical @dependant @setting @phase @TC-PH8
  Scenario Outline: Verify that the user can create the new phase with the required field
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the phases option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new phase button is displayed
    When Click on the new phase button
    And Enter "<PhaseName>" on the phase name text box
    And Select the associated skill from dropdown
    And Click on the create button
    Then Validate that the validation toast message appears with "<Message>"
    And Validate that the created phase name is displayed on the list and highlighted
    When Deactivate the created phase

    Examples:
      | UserRoll      | EndPoint         | PhaseName   | Message                    |
      | adminRoleUser | /settings/phases | AAuto Phase | Successfully created phase |

  @regression @critical @dependant @setting @phase @TC-PH9
  Scenario Outline: Verify that the user can create the new phase with the all the field
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the phases option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new phase button is displayed
    When Click on the new phase button
    And Enter "<PhaseName>" on the phase name text box
    And Select the associated skill from dropdown
    And Enter the description on the text box
    And Click on the create button
    Then Validate that the validation toast message appears with "<Message>"
    And Validate that the created phase name is displayed on the list and highlighted

    Examples:
      | UserRoll      | EndPoint         | PhaseName   | Message                    |
      | adminRoleUser | /settings/phases | AAuto Phase | Successfully created phase |

  @regression @dependant @setting @phase @TC-PH10
  Scenario Outline: Verify that the save button is enabled after updating the channel name on the channel edit section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the phases option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created phase from list
    Then Validate that the save button is disabled
    When Update "<PhaseName>" the phase name
    Then Validate that the save button is enabled

    Examples:
      | UserRoll      | EndPoint         | PhaseName          |
      | adminRoleUser | /settings/phases | AAuto Update Phase |

  @regression @setting @phase @TC-PH11
  Scenario Outline: Verify that the save button is enabled after updating the associated skill field on the phase edit section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the phases option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created phase from list
    Then Validate that the save button is disabled
    When Update the associated skill from dropdown
    Then Validate that the save button is enabled

    Examples:
      | UserRoll      | EndPoint         |
      | adminRoleUser | /settings/phases |


  @regression @dependant @setting @phase @TC-PH12
  Scenario Outline: Verify that the user can not enter more than 50 characters on the name text box of the 'Edit phase' section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the phases option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created phase from list
    Then Validate that the save button is disabled
    When Update "<PhaseName>" the phase name
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll      | EndPoint         | PhaseName                                            | Message                                   |
      | adminRoleUser | /settings/phases | Auto The Name on the text box of edit phase text box | At Most 50 Characters Are Valid For Title |

  @regression @dependant @setting @phase @TC-PH13
  Scenario Outline: Verify that the user can update the phase name
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the phases option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created phase from list
    Then Validate that the save button is disabled
    When Update "<PhaseName>" the phase name
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll      | EndPoint         | PhaseName           | Message                    |
      | adminRoleUser | /settings/phases | AAAuto Update Phase | Phase successfully updated |

  @regression @setting @phase @TC-PH14
  Scenario Outline: Verify that the user can update the associated skill of phase
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the phases option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created phase from list
    Then Validate that the save button is disabled
    When Update the associated skill from dropdown
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll      | EndPoint         | Message                    |
      | adminRoleUser | /settings/phases | Phase successfully updated |

  @regression @critical @dependant @setting @phase @TC-PH15
  Scenario Outline: Verify that the user can not create a duplicate phase
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the phases option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new phase button is displayed
    When Click on the new phase button
    And Enter phase name which is already existing on the list
    And Select the associated skill from dropdown
    And Click on the create button
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll      | EndPoint         | Message          |
      | adminRoleUser | /settings/phases | Repetitive Title |

  @regression @critical @dependant @setting @phase @TC-PH16
  Scenario Outline: Verify that the user can deactivate the phases
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the phases option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created phase from list
    And Click on the deactivate phase check box
    And Click on the save button
    #Then Validate that the validation toast message appears with "<Message>"
    And Remove the active filter from inactive column
    And Apply the inactive filter on inactive column
    Then Validate that the deactivate phase is displayed on the list

    Examples:
      | UserRoll      | EndPoint         | Message                    |
      | adminRoleUser | /settings/phases | Phase successfully updated |

  @regression @setting @phase @TC-PH17
  Scenario Outline: Verify that the user can activate the phases
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the phases option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the first phase from the list
    And Remove the active filter from inactive column
    And Click on the created phase from list
    And Click on the deactivate phase check box
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"
    #And Validate that the deactivate phase is removed from the list
    When Click on the deactivate phase check box
    And Click on the save button
    And Wait for "2" sec

    Examples:
      | UserRoll      | EndPoint         | Message                    |
      | adminRoleUser | /settings/phases | Phase successfully updated |