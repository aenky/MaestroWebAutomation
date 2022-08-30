Feature: Skill Module's Test Case of Setting Menu

  @regression @dependant @setting @skill @TC-SK1
  Scenario Outline: Verify that the skill option is not displayed on sub-menu of the settings option for common, resource, team lead, project maestro and release maestro role type user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the "Skills" option is not displayed on the sub menu

    Examples:
      | UserRoll         | EndPoint               |
      | commonRoleUser   | /settings/user-profile |
      | resourceRoleUser | /settings/user-profile |
      | teamLeadRoleUser | /settings/user-profile |
      | PM_RoleUser      | /settings/user-profile |
      | RM_RoleUser      | /settings/user-profile |

  @regression @dependant @setting @skill @TC-SK2
  Scenario Outline: Verify that the skill option is displayed on sub-menu of the settings option for admin role type user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the "Skills" option is displayed on the sub menu

    Examples:
      | UserRoll      | EndPoint               |
      | adminRoleUser | /settings/user-profile |

  @regression @setting @skill @TC-SK3
  Scenario Outline: Verify that the click functionality on the skill option from the settings submenu
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the skills option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new skill button is displayed

    Examples:
      | UserRoll      | EndPoint         |
      | adminRoleUser | /settings/skills |

  @regression @dependant @setting @skill @TC-SK4
  Scenario Outline: Verify that the click functionality on the new skill button
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the skills option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new skill button is displayed
    When Click on the new skill button
    Then Validate that the create new skill dialog box heading is displayed

    Examples:
      | UserRoll      | EndPoint         |
      | adminRoleUser | /settings/skills |

  @regression @setting @skill @TC-SK5
  Scenario Outline: Verify click functionality on the close icon of new skill dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the skills option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new skill button is displayed
    When Click on the new skill button
    And Click on the close icon
    Then Validate that the create new skill dialog box is closed

    Examples:
      | UserRoll      | EndPoint         |
      | adminRoleUser | /settings/skills |

  @regression @dependant @setting @skill @TC-SK6
  Scenario Outline: Verify that the create button is disabled until the user does not fill up the required field on create skill dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the skills option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new skill button is displayed
    When Click on the new skill button
    Then Validate that the create button is disabled
    When Enter "<SkillName>" on the skill name text box
    Then Validate that the create button is Enable

    Examples:
      | UserRoll      | EndPoint         | SkillName  |
      | adminRoleUser | /settings/skills | Auto Skill |

  @regression @dependant @setting @skill @TC-SK7
  Scenario Outline: Verify that the user can not enter more than 50 characters on the name text box of the 'Create The New Skill' dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the skills option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new skill button is displayed
    When Click on the new skill button
    And Enter "<SkillName>" on the skill name text box
    Then Validate that the max length validation message is displayed

    Examples:
      | UserRoll      | EndPoint         | SkillName                                                |
      | adminRoleUser | /settings/skills | Auto The Name on the text box of Create Skill Dialog box |

  @regression @critical @dependant @setting @skill @TC-SK8
  Scenario Outline: Verify that the user can create the new skill with the required field
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the skills option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new skill button is displayed
    When Click on the new skill button
    And Enter "<SkillName>" on the skill name text box
    And Click on the create button
    Then Validate that the validation toast message appears with "<Message>"
    And Validate that the created skill name is displayed on the list and highlighted
    When Deactivate the created skill

    Examples:
      | UserRoll      | EndPoint         | SkillName   | Message                    |
      | adminRoleUser | /settings/skills | AAuto Skill | Successfully created skill |

  @regression @critical @dependant @setting @skill @TC-Sk9
  Scenario Outline: Verify that the user can create the new skill with the all the field
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the skills option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new skill button is displayed
    When Click on the new skill button
    And Enter "<SkillName>" on the skill name text box
    And Enter the description on the text box
    And Click on the create button
    Then Validate that the validation toast message appears with "<Message>"
    And Validate that the created skill name is displayed on the list and highlighted

    Examples:
      | UserRoll      | EndPoint         | SkillName   | Message                    |
      | adminRoleUser | /settings/skills | AAuto Skill | Successfully created Skill |

  @regression @critical @dependant @setting @skill @TC-SK10
  Scenario Outline: Verify that the user can add the specialty in created skill
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the skills option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created skill from list
    And Add specialties on created skill
    Then Validate that the validation toast message appears with "<Message>"
    And Validate that the added specialty is displayed on selected skill

    Examples:
      | UserRoll      | EndPoint         | Message                        |
      | adminRoleUser | /settings/skills | Specialty Successfully created |

  @regression @critical @dependant @setting @skill @TC-SK11
  Scenario Outline: Verify that the user can remove the specialty from created skill
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the skills option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created skill from list
    And Remove specialty from skill
    Then Validate that the validation toast message appears with "<Message>"
    And Validate that the removed specialty is also removed from selected skill

    Examples:
      | UserRoll      | EndPoint         | Message                        |
      | adminRoleUser | /settings/skills | Specialty Successfully deleted |

  @regression @critical @dependant @setting @skill @TC-SK12
  Scenario Outline: Verify that the save button is enabled after updating the skill name on the skill edit section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the skills option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created skill from list
    Then Validate that the save button is disabled
    When Update "<SkillsName>" the skill name
    Then Validate that the save button is enabled

    Examples:
      | UserRoll      | EndPoint         | SkillsName         |
      | adminRoleUser | /settings/skills | AAuto Update Skill |

  @regression @dependant @setting @skill @TC-SK13
  Scenario Outline: Verify that the user can not enter more than 50 characters on the name text box of the 'Edit phase' section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the skills option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created skill from list
    Then Validate that the save button is disabled
    When Update "<SkillName>" the skill name
    And Click on the save button
    Then Validate that the max length validation message is displayed on the edit section

    Examples:
      | UserRoll      | EndPoint         | SkillName                                            |
      | adminRoleUser | /settings/skills | Auto The Name on the text box of edit Skill text box |

  @regression @dependant @setting @skill @TC-SK14
  Scenario Outline: Verify that the user can update the skill name
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the skills option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created skill from list
    Then Validate that the save button is disabled
    When Update "<SkillName>" the skill name
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"
    And Validate that the updated skill name is displayed on the list

    Examples:
      | UserRoll      | EndPoint         | SkillName           | Message                    |
      | adminRoleUser | /settings/skills | AAAuto Update Skill | Skill successfully updated |

  @regression @critical @dependant @setting @skill @TC-SK15
  Scenario Outline: Verify that the user can not create a duplicate skill
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the skills option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new skill button is displayed
    When Click on the new skill button
    And Enter skill name which is already existing on the list
    And Click on the create button
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll      | EndPoint         | Message          |
      | adminRoleUser | /settings/skills | Repetitive Title |

  @regression @critical @dependant @setting @skill @TC-SK16
  Scenario Outline: Verify that the user can deactivate the Skills
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the skills option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created skill from list
    And Click on the deactivate skill check box
    And Click on the save button
    #Then Validate that the validation toast message appears with "<Message>"
    And Remove the active filter from inactive column
    And Apply the inactive filter on inactive column
    Then Validate that the deactivate skill is displayed on the list

    Examples:
      | UserRoll      | EndPoint         | Message                    |
      | adminRoleUser | /settings/skills | Phase successfully updated |

  @regression @setting @skill @TC-SK17
  Scenario Outline: Verify that the user can activate the Skill
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the skills option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the first skill from the list
    And Remove the active filter from inactive column
    And Click on the created skill from list
    And Click on the deactivate skill check box
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"
    #And Validate that the deactivate phase is removed from the list
    When Click on the deactivate skill check box
    And Click on the save button
    And Wait for "2" sec

    Examples:
      | UserRoll      | EndPoint         | Message                    |
      | adminRoleUser | /settings/skills | Skill successfully updated |