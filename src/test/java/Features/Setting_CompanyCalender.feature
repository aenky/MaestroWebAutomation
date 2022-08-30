Feature: Company Calendar Module Test Case of Setting Menu

  @regression @setting @CC @TC-CC1
  Scenario Outline: Verify that the click functionality on the company calendar option from the settings submenu
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the company calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new event button is displayed

    Examples:
      | UserRoll      | EndPoint                   |
      | adminRoleUser | /settings/company-calendar |

  @regression @setting @CC @TC-CC2
  Scenario Outline: Verify that the click functionality on the new event button of the company calendar page
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the company calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new event button is displayed
    When Click on the new event button
    Then Validate that the create event dialog box heading is displayed

    Examples:
      | UserRoll      | EndPoint                   |
      | adminRoleUser | /settings/company-calendar |

  @regression @setting @CC @TC-CC3
  Scenario Outline: Verify that the click functionality on the close icon of the create new event dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the company calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new event button is displayed
    When Click on the new event button
    Then Validate that the create event dialog box heading is displayed
    When Click on the close icon
    Then Validate that the create event dialog box is closed

    Examples:
      | UserRoll      | EndPoint                   |
      | adminRoleUser | /settings/company-calendar |

  @regression @dependant @setting @CC @TC-CC4
  Scenario Outline: Verify that the create event button is enabled after filling up all the required field on create new company event dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the company calendar option
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
      | UserRoll      | EndPoint                   | Option |
      | adminRoleUser | /settings/company-calendar | Never  |

  @regression @dependant @setting @CC @TC-CC5
  Scenario Outline: Verify that the user cannot select a past date on the Start Date Picker of the company events dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the company calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new event button is displayed
    When Click on the new event button
    Then Validate that the create event dialog box heading is displayed
    When Click on the start date field
    Then Validate that the past date is disabled on the date picker

    Examples:
      | UserRoll      | EndPoint                   |
      | adminRoleUser | /settings/company-calendar |

  @regression @dependant @setting @CC @TC-CC6
  Scenario Outline: Verify that the user can not select the past date of the selected start date on the end date picker of create event dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the company calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new event button is displayed
    When Click on the new event button
    Then Validate that the create event dialog box heading is displayed
    When Select the event start date
    And Click on the end date field
    Then Validate that the date is disabled till the selected start date on the end date picker

    Examples:
      | UserRoll      | EndPoint                   |
      | adminRoleUser | /settings/company-calendar |

  @regression @dependant @setting @CC @TC-CC7 @TC-CC8 @TC-CC9
  Scenario Outline: Verify that the user can create the new company event with a different repeat option
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the company calendar option
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
      | UserRoll      | EndPoint                   | Option  | Message                      |
      | adminRoleUser | /settings/company-calendar | Yearly  | Successfully Created Holiday |
      | adminRoleUser | /settings/company-calendar | Monthly | Successfully Created Holiday |
      | adminRoleUser | /settings/company-calendar | Never   | Successfully Created Holiday |

  @regression @critical @dependant @setting @CC @TC-CC10
  Scenario Outline: Verify that the user can update the company event name
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the company calendar option
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
      | UserRoll      | EndPoint                   | Option | Message                      | UpdateMessage        |
      | adminRoleUser | /settings/company-calendar | Yearly | Successfully Created Holiday | Successfully Updated |

  @regression @setting @CC @TC-CC11
  Scenario Outline: Verify that the first event is by default selected on the event list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the company calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the first event list is selected

    Examples:
      | UserRoll      | EndPoint                   |
      | adminRoleUser | /settings/company-calendar |

  @regression @dependant @setting @CC @TC-CC12
  Scenario Outline: Verify that the user can update the company event start date
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the company calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    When Update the event start date
    And Click on the save button
    Then Validate that the validation toast message appears with "<UpdateMessage>"
    And Validate that the updated event start date is also reflated on the listed event

    Examples:
      | UserRoll      | EndPoint                   | UpdateMessage        |
      | adminRoleUser | /settings/company-calendar | Successfully Updated |

  @regression @dependant @setting @CC @TC-CC13
  Scenario Outline: Verify that the user can update the company event end date
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the company calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    When Update the event end date
    And Click on the save button
    Then Validate that the validation toast message appears with "<UpdateMessage>"
    And Validate that the updated event end date is also reflated on the listed event

    Examples:
      | UserRoll      | EndPoint                   | UpdateMessage        |
      | adminRoleUser | /settings/company-calendar | Successfully Updated |

  @regression @dependant @setting @CC @TC-CC14
  Scenario Outline: Verify that the user can update the company event repeat option
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the company calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    When Update the event repeat option
    And Click on the save button
    Then Validate that the validation toast message appears with "<UpdateMessage>"
    And Validate that the updated event repeat option is also reflated on the listed event

    Examples:
      | UserRoll      | EndPoint                   | UpdateMessage        |
      | adminRoleUser | /settings/company-calendar | Successfully Updated |

  @regression @dependant @setting @CC @TC-CC15
  Scenario Outline: Verify that the user can not update the past date on start date picker of company event
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the company calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the start date field of event edit section
    Then Validate that the past date is disabled on the date picker

    Examples:
      | UserRoll      | EndPoint                   |
      | adminRoleUser | /settings/company-calendar |

  @regression @dependant @setting @CC @TC-CC16
  Scenario Outline: Verify that the event end date is automatically updated when the user selects the future date of the selected end date on the start date picker
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the company calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    When Update the events start date
    And Click on the save button
    Then Validate that the validation toast message appears with "<UpdateMessage>"
    And Validate that the updated event start date and end date are same

    Examples:
      | UserRoll      | EndPoint                   | UpdateMessage        |
      | adminRoleUser | /settings/company-calendar | Successfully Updated |

  @regression @critical @dependant @setting @CC @TC-CC17
  Scenario Outline: Verify that the user can not create the same name of company event
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the company calendar option
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
      | UserRoll      | EndPoint                   | Option | Message          |
      | adminRoleUser | /settings/company-calendar | Yearly | Repetitive Title |

  @regression @critical @dependant @setting @CC @TC-CC18
  Scenario Outline: Verify that the user can delete his company event
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the company calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the delete checkbox
    And Click on the save button
    Then Validate that the validation toast message appears with "<UpdateMessage>"

    Examples:
      | UserRoll      | EndPoint                   | UpdateMessage                |
      | adminRoleUser | /settings/company-calendar | Successfully Deleted Holiday |

  @regression @critical @dependant @setting @CC @TC-CC19
  Scenario Outline: Verify that the user can add his weekly off days on the company calendar
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the company calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the "<WeeklyOffDay>" checkbox for weekly off
    Then Validate that the validation toast message appears with "<UpdateMessage>"

    Examples:
      | UserRoll      | EndPoint                   | WeeklyOffDay | UpdateMessage                |
      | adminRoleUser | /settings/company-calendar | Sunday       | Successfully Created Holiday |

  @regression @critical @dependant @setting @CC @TC-CC20
  Scenario Outline: Verify that the user can remove his weekly off days on the company calendar
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the company calendar option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the "<WeeklyOffDay>" checkbox for weekly off
    Then Validate that the validation toast message appears with "<UpdateMessage>"

    Examples:
      | UserRoll      | EndPoint                   | WeeklyOffDay | UpdateMessage                |
      | adminRoleUser | /settings/company-calendar | Sunday       | Successfully Deleted Holiday |