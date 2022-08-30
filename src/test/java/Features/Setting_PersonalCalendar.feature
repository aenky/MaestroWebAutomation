Feature: Personal Calendar Module Test Case of Setting Menu

  @regression @setting @PC @TC-PC1
  Scenario Outline: Verify that the click functionality on the personal calendar option from the settings submenu
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the personal calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new event button is displayed

    Examples:
      | UserRoll       | EndPoint                    |
      | commonRoleUser | /settings/personal-calendar |

  @regression @setting @PC @TC-PC2
  Scenario Outline: Verify that the first event is by default selected from the event list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the personal calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the first event list is selected

    Examples:
      | UserRoll    | EndPoint                    |
      | allRoleUser | /settings/personal-calendar |

  @regression @dependant @setting @PC @TC-PC3
  Scenario Outline: Verify that the click functionality on the new event button of the personal calendar page
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the personal calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new event button is displayed
    When Click on the new event button
    Then Validate that the create event dialog box heading is displayed

    Examples:
      | UserRoll       | EndPoint                    |
      | commonRoleUser | /settings/personal-calendar |

  @regression @setting @PC @TC-PC4
  Scenario Outline: Verify that the click functionality on the close icon of the create new event
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the personal calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new event button is displayed
    When Click on the new event button
    Then Validate that the create event dialog box heading is displayed
    When Click on the close icon
    Then Validate that the create event dialog box is closed

    Examples:
      | UserRoll       | EndPoint                    |
      | commonRoleUser | /settings/personal-calendar |

  @regression @dependant @setting @PC @TC-PC5
  Scenario Outline: Verify that the create event button is enabled after filling up all the required field
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the personal calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new event button is displayed
    When Click on the new event button
    Then Validate that the create event dialog box heading is displayed
    And Validate that the create button is disabled
    When Enter the event name on name text box
    Then Validate that the create button is disabled
    When Select the event start date
    Then Validate that the create button is disabled
    When Select the event end date
    Then Validate that the create button is disabled
    When Select the "<Option>" option from repeat dropdown
    Then Validate that the create button is Enable

    Examples:
      | UserRoll       | EndPoint                    | Option |
      | commonRoleUser | /settings/personal-calendar | Never  |

  @regression @dependant @setting @PC @TC-PC6
  Scenario Outline: Verify that the user cannot select a past date on the Start Date Picker of the Personal Events dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the personal calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new event button is displayed
    When Click on the new event button
    Then Validate that the create event dialog box heading is displayed
    When Click on the start date field
    Then Validate that the past date is disabled on the date picker

    Examples:
      | UserRoll       | EndPoint                    |
      | commonRoleUser | /settings/personal-calendar |

  @regression @dependant @setting @PC @TC-PC7
  Scenario Outline: Verify that the user can not select the past date of the selected start date on the end date picker of create event dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the personal calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new event button is displayed
    When Click on the new event button
    Then Validate that the create event dialog box heading is displayed
    When Select the event start date
    And Click on the end date field
    Then Validate that the date is disabled till the selected start date on the end date picker

    Examples:
      | UserRoll       | EndPoint                    |
      | commonRoleUser | /settings/personal-calendar |

  @regression @dependant @setting @PC @TC-PC8 @TC-PC9 @TC-PC10
  Scenario Outline: Verify that the user can create the new personal event with a different repeat option
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the personal calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new event button is displayed
    When Click on the new event button
    Then Validate that the create event dialog box heading is displayed
    And Validate that the create button is disabled
    When Enter the event name on name text box
    And Select the event start date
    And Select the event end date
    And Select the "<Option>" option from repeat dropdown
    And Click on the create button
    Then Validate that the validation toast message appears with "<Message>"
    And Validate that the created event is displayed first on the list and highlighted
    And Delete the created event


    Examples:
      | UserRoll       | EndPoint                    | Option  | Message                      |
      | commonRoleUser | /settings/personal-calendar | Yearly  | Successfully Created Holiday |
      | PM_RoleUser    | /settings/personal-calendar | Monthly | Successfully Created Holiday |
      | RM_RoleUser    | /settings/personal-calendar | Never   | Successfully Created Holiday |

  @regression @critical @dependant @setting @PC @TC-PC11
  Scenario Outline: Verify that the user can update the personal event name
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the personal calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new event button is displayed
    When Click on the new event button
    Then Validate that the create event dialog box heading is displayed
    And Validate that the create button is disabled
    When Enter the event name on name text box
    And Select the event start date
    And Select the event end date
    And Select the "<Option>" option from repeat dropdown
    And Click on the create button
    Then Validate that the validation toast message appears with "<Message>"
    When Update the created event name
    And Click on the save button
    Then Validate that the validation toast message appears with "<UpdateMessage>"
    And Validate that the updated event name is also reflated on the listed event

    Examples:
      | UserRoll         | EndPoint                    | Option | Message                      | UpdateMessage        |
      | resourceRoleUser | /settings/personal-calendar | Yearly | Successfully Created Holiday | Successfully Updated |

  @regression @critical @dependant @setting @PC @TC-PC12
  Scenario Outline: Verify that the user can update the personal event start date
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the personal calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    When Update the event start date
    And Click on the save button
    Then Validate that the validation toast message appears with "<UpdateMessage>"
    And Validate that the updated event start date is also reflated on the listed event

    Examples:
      | UserRoll         | EndPoint                    | UpdateMessage        |
      | resourceRoleUser | /settings/personal-calendar | Successfully Updated |

  @regression @critical @dependant @setting @PC @TC-PC13
  Scenario Outline: Verify that the user can update the personal event end date
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the personal calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    When Update the event end date
    And Click on the save button
    Then Validate that the validation toast message appears with "<UpdateMessage>"
    And Validate that the updated event end date is also reflated on the listed event

    Examples:
      | UserRoll         | EndPoint                    | UpdateMessage        |
      | resourceRoleUser | /settings/personal-calendar | Successfully Updated |

  @regression @dependant @setting @PC @TC-PC14
  Scenario Outline: Verify that the user can update the personal event repeat option
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the personal calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    When Update the event repeat option
    And Click on the save button
    Then Validate that the validation toast message appears with "<UpdateMessage>"
    And Validate that the updated event repeat option is also reflated on the listed event

    Examples:
      | UserRoll         | EndPoint                    | UpdateMessage        |
      | resourceRoleUser | /settings/personal-calendar | Successfully Updated |

  @regression @dependant @setting @PC @TC-PC15
  Scenario Outline: Verify that the user can not update the past date on start date picker
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the personal calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the start date field of event edit section
    Then Validate that the past date is disabled on the date picker

    Examples:
      | UserRoll         | EndPoint                    |
      | resourceRoleUser | /settings/personal-calendar |

  @regression @dependant @setting @PC @TC-PC16
  Scenario Outline: Verify that the event end date is automatically updated when the user selects the future date of the selected end date on the start date picker
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the personal calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    When Update the events start date
    And Click on the save button
    Then Validate that the validation toast message appears with "<UpdateMessage>"
    And Validate that the updated event start date and end date are same

    Examples:
      | UserRoll         | EndPoint                    | UpdateMessage        |
      | resourceRoleUser | /settings/personal-calendar | Successfully Updated |

  @regression @critical @dependant @setting @PC @TC-PC17
  Scenario Outline: Verify that the user can not create the same name event
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the personal calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the new event button
    Then Validate that the create event dialog box heading is displayed
    When Enter the same event name which is already exist
    And Select the event start date
    And Select the event end date
    And Select the "<Option>" option from repeat dropdown
    And Click on the create button
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll         | EndPoint                    | Option | Message          |
      | resourceRoleUser | /settings/personal-calendar | Yearly | Repetitive Title |

  @regression @critical @dependant @setting @PC @TC-PC18
  Scenario Outline: Verify that the user can delete his personal event
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the personal calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the delete checkbox
    And Click on the save button
    Then Validate that the validation toast message appears with "<UpdateMessage>"

    Examples:
      | UserRoll         | EndPoint                    | UpdateMessage                |
      | resourceRoleUser | /settings/personal-calendar | Successfully Deleted Holiday |

  @regression @critical @dependant @setting @PC @TC-PC19
  Scenario Outline: Verify that the user can add his weekly off days
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the personal calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the "<WeeklyOffDay>" checkbox for weekly off
    Then Validate that the validation toast message appears with "<UpdateMessage>"

    Examples:
      | UserRoll       | EndPoint                    | WeeklyOffDay | UpdateMessage                |
      | commonRoleUser | /settings/personal-calendar | Sunday       | Successfully Created Holiday |

  @regression @critical @dependant @setting @PC @TC-PC20
  Scenario Outline: Verify that the user can remove his weekly off days
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the personal calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the "<WeeklyOffDay>" checkbox for weekly off
    Then Validate that the validation toast message appears with "<UpdateMessage>"

    Examples:
      | UserRoll       | EndPoint                    | WeeklyOffDay | UpdateMessage                |
      | commonRoleUser | /settings/personal-calendar | Sunday       | Successfully Deleted Holiday |


