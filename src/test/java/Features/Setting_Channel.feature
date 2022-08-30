Feature: Channel Module's Test Case of Setting Menu

  @regression @critical @dependant @setting @channels @TC-CH1
  Scenario Outline: Verify that the channels option is not displayed on sub-menu of the settings option for common, resource, team lead, project maestro and release maestro role type user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the "Channels" option is not displayed on the sub menu

    Examples:
      | UserRoll         | EndPoint               |
      | commonRoleUser   | /settings/user-profile |
      | resourceRoleUser | /settings/user-profile |
      | teamLeadRoleUser | /settings/user-profile |
      | PM_RoleUser      | /settings/user-profile |
      | RM_RoleUser      | /settings/user-profile |

  @regression @critical @dependant @setting @channels @TC-CH2
  Scenario Outline: Verify that the channels option is displayed on sub-menu of the settings option for admin role type user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the "Channels" option is displayed on the sub menu

    Examples:
      | UserRoll      | EndPoint               |
      | adminRoleUser | /settings/user-profile |

  @regression @setting @channels @TC-CH3
  Scenario Outline: Verify that the click functionality on the channels option from the settings submenu
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the channels option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new channel button is displayed

    Examples:
      | UserRoll      | EndPoint         |
      | adminRoleUser | /settings/groups |

  @regression @setting @channels @TC-CH4
  Scenario Outline: Verify that the click functionality on the new channel button
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the channels option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new channel button is displayed
    When Click on the new channel button
    Then Validate that the create new channel dialog box heading is displayed

    Examples:
      | UserRoll      | EndPoint         |
      | adminRoleUser | /settings/groups |

  @regression @setting @channels @TC-CH5
  Scenario Outline: Verify click functionality on the close icon of new channel dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the channels option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new channel button is displayed
    When Click on the new channel button
    And Click on the close icon
    Then Validate that the create new channel dialog box is closed

    Examples:
      | UserRoll      | EndPoint         |
      | adminRoleUser | /settings/groups |

  @regression @dependant @setting @channels @TC-CH6
  Scenario Outline: Verify that the create button is disabled until the user does not fill up the required field on create channel dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the channels option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new channel button is displayed
    When Click on the new channel button
    Then Validate that the create button is disabled
    When Enter "<ChannelName>" on the channel name text box
    Then Validate that the create button is Enable

    Examples:
      | UserRoll      | EndPoint         | ChannelName  |
      | adminRoleUser | /settings/groups | Auto Channel |

  @regression @setting @channels @TC-CH7
  Scenario Outline: Verify that the user can not enter more than 50 characters on the name text box of the 'Create Channel' dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the channels option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new channel button is displayed
    When Click on the new channel button
    And Enter "<ChannelName>" on the channel name text box
    Then Validate that the max length validation message is displayed

    Examples:
      | UserRoll      | EndPoint         | ChannelName                                                |
      | adminRoleUser | /settings/groups | Auto The Name on the text box of Create Channel Dialog box |

  @regression @critical @dependant @setting @channels @TC-CH8 @TC-CH9 @TC-CH10
  Scenario Outline: Verify that the admin user can create channel with different type
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the channels option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new channel button is displayed
    When Click on the new channel button
    And Enter "<ChannelName>" on the channel name text box
    And Click on the "<Type>" channel type
    And Click on the create button
    Then Validate that the validation toast message appears with "<Message>"
    #And Validate that the created channel name is displayed on the list and highlighted
    When Deactivate the created channel


    Examples:
      | UserRoll      | EndPoint         | ChannelName   | Type    | Message                    |
      | adminRoleUser | /settings/groups | AAuto Channel | Public  | Successfully created group |
      | adminRoleUser | /settings/groups | AAuto Channel | Private | Successfully created group |
      | adminRoleUser | /settings/groups | AAuto Channel | Both    | Successfully created group |

  @regression @setting @channels @TC-CH11
  Scenario Outline: Verify that the save button is enabled after updating the channel name on the channel edit section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the channels option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created channel from list
    Then Validate that the save button is disabled
    When Update "<ChannelName>" the channel name
    Then Validate that the save button is enabled

    Examples:
      | UserRoll      | EndPoint         | ChannelName          |
      | adminRoleUser | /settings/groups | AAuto Update Channel |

  @regression @setting @channels @TC-CH12
  Scenario Outline: Verify that the user can not enter more than 50 characters on the name text box of the 'Edit Channel' section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the channels option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created channel from list
    And Update "<ChannelName>" the channel name
    Then Validate that the max length validation message is displayed on the edit section

    Examples:
      | UserRoll      | EndPoint         | ChannelName                                                   |
      | adminRoleUser | /settings/groups | Auto The Name on the text box of Create Department Dialog box |

  @regression @critical @dependant @setting @channels @TC-CH13
  Scenario Outline: Verify that the user can change the channel name
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the channels option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created channel from list
    And Update "<ChannelName>" the channel name
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"
    And Validate that the updated channel name is also reflated on the channel list

    Examples:
      | UserRoll      | EndPoint         | ChannelName           | Message                    |
      | adminRoleUser | /settings/groups | AAAuto Update Channel | Successfully updated group |

  @regression @setting @channels @TC-CH14
  Scenario Outline: Verify that the user can change the channel's description
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the channels option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created channel from list
    And Update "<ChannelDescription>" the channel description
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"
    And Validate that the updated channel description is also reflated on the channel list

    Examples:
      | UserRoll      | EndPoint         | ChannelDescription              | Message                    |
      | adminRoleUser | /settings/groups | Auto Update Channel Description | Successfully updated group |

  @regression @dependant @setting @channels @TC-CH15
  Scenario Outline: Verify that the user can change the channel type
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the channels option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created channel from list
    And Update "<ChannelType>" the channel type
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"
    And Validate that the updated channel name is also reflated on the channel list

    Examples:
      | UserRoll      | EndPoint         | ChannelType | Message                    |
      | adminRoleUser | /settings/groups | Public      | Successfully updated group |
      | adminRoleUser | /settings/groups | Private     | Successfully updated group |
      | adminRoleUser | /settings/groups | Both        | Successfully updated group |

  @regression @critical @dependant @setting @channels @TC-CH16
  Scenario Outline: Verify that the user can not create a duplicate channel
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the channels option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new channel button is displayed
    When Click on the new channel button
    And Enter channel name which is already existing on the list
    And Click on the create button
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll      | EndPoint         | Message                  |
      | adminRoleUser | /settings/groups | repetitive channel title |

  @regression @critical @dependant @setting @channels @TC-CH17
  Scenario Outline: Verify that the user can deactivate the channels
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the channels option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created channel from list
    And Click on the deactivate channel check box
    And Click on the save button
    #Then Validate that the validation toast message appears with "<Message>"
    And Remove the active filter from inactive column
    And Apply the inactive filter on inactive column
    Then Validate that the list of deactivate channels

    Examples:
      | UserRoll      | EndPoint         | Message                    |
      | adminRoleUser | /settings/groups | Successfully updated group |

  @regression @setting @channels @TC-CH18
  Scenario Outline: Verify that the user can activate the channels
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the channels option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the first channel from list
    And Remove the active filter from inactive column
    And Click on the created channel from list
    And Click on the deactivate channel check box
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"
    #And Validate that the deactivate department is removed from the list
    When Deactivate the created channel

    Examples:
      | UserRoll      | EndPoint         | Message                    |
      | adminRoleUser | /settings/groups | Successfully updated group |