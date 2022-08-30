Feature: Sprint Module Test Case

  @regression @sprint @TC-St1
  Scenario Outline: Verify that the sprint dropdown is displayed on good news > triage tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    When Create new nugget with "<ProjectName>" project if triage nugget list is empty
    Then Validate that the sprint dropdown is displayed

    Examples:
      | UserRoll    | endPoint          | ProjectName         |
      | allRoleUser | /good-news/triage | Demo QA Automation1 |

  @regression @sprint @TC-S3
  Scenario Outline: Verify that the sprint dropdown is displayed on good news > Backlog tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    And Click on Backlog tab
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    And Validate that the sprint dropdown is displayed

    Examples:
      | UserRoll    | endPoint           |
      | allRoleUser | /good-news/backlog |


  @regression @sprint @TC-S4
  Scenario Outline: Verify that the sprint dropdown is displayed on good news > approval due tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    And Click on approval due tab
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    And Validate that the sprint dropdown is displayed

    Examples:
      | UserRoll    | endPoint                 |
      | allRoleUser | /good-news/need-approval |

  @regression @sprint @TC-S5
  Scenario Outline: Verify that the sprint dropdown is displayed on bad news > delayed nuggets tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Move cursor on side menu
    And Click on bad news option from side menu
    And Click on delayed nuggets tab
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    And Validate that the sprint dropdown is display

    Examples:
      | UserRoll    | endPoint                  |
      | allRoleUser | /bad-news/delayed-nuggets |

  @regression @sprint @TC-S6
  Scenario Outline: Verify that the sprint dropdown is displayed on bad news > overdue triage tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Move cursor on side menu
    And Click on bad news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    And Validate that the sprint dropdown is displayed

    Examples:
      | UserRoll    | endPoint                |
      | allRoleUser | bad-news/overdue-triage |


  @regression @sprint @TC-S7
  Scenario Outline: Verify that the sprint dropdown is displayed on bad news > overdue estimate tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Move cursor on side menu
    And Click on bad news option from side menu
    And Click on overdue estimate tab
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    And Validate that the sprint dropdown is display

    Examples:
      | UserRoll    | endPoint                   |
      | allRoleUser | /bad-news/overdue-estimate |

  @regression @sprint @TC-S8
  Scenario Outline: Verify that the user is able to click on create sprint button
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    When Create new nugget with "<ProjectName>" project if triage nugget list is empty
    And Click on the sprint dropdown
    And Click on the create sprint button
    Then Validate that the create sprint dialog box is open
    And Validate that tha sprint name field is displayed
    And Validate that the backlog check box and Return To Triage date pickers is displayed
    And Validate that the close icon is displayed
    And Validate that the save button is displayed

    Examples:
      | UserRoll    | endPoint          | ProjectName         |
      | allRoleUser | /good-news/triage | Demo QA Automation1 |

  @regression @sprint @TC-S9
  Scenario Outline: Verify that the user is able to close the create sprint dialog using the close icon
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    When Create new nugget with "<ProjectName>" project if triage nugget list is empty
    And Click on the sprint dropdown
    And Click on the create sprint button
    Then Validate that the create sprint dialog box is open
    When Click on the close icon of open dialog box
    Then Validate that the create sprint dialog box is closed

    Examples:
      | UserRoll    | endPoint          | ProjectName         |
      | allRoleUser | /good-news/triage | Demo QA Automation1 |

  @regression @sprint @TC-S10
  Scenario Outline: Verify that the Return To Triage date pickers field is disabled
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    When Create new nugget with "<ProjectName>" project if triage nugget list is empty
    And Click on the sprint dropdown
    And Click on the create sprint button
    Then Validate that the create sprint dialog box is open
    And Validate that the Return To Triage date pickers field is disabled

    Examples:
      | UserRoll    | endPoint          | ProjectName          |
      | allRoleUser | /good-news/triage | Demo QA Automation11 |

  @regression @critical @sprint @TC-S11
  Scenario Outline: Verify that the Return To Triage date picker is enabled after checked the backlog checkbox
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    When Create new nugget with "<ProjectName>" project if triage nugget list is empty
    And Click on the sprint dropdown
    And Click on the create sprint button
    Then Validate that the create sprint dialog box is open
    And Validate that the Return To Triage date pickers field is disabled
    When Click on the backlog checkbox
    Then Validate that the Return To Triage date pickers field is enabled

    Examples:
      | UserRoll    | endPoint          | ProjectName         |
      | allRoleUser | /good-news/triage | Demo QA Automation1 |

  @regression @sprint @TC-S12
  Scenario Outline: Verify that the save button is enabled after filling up the required fields
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    When Create new nugget with "<ProjectName>" project if triage nugget list is empty
    And Click on the sprint dropdown
    And Click on the create sprint button
    Then Validate that the create sprint dialog box is open
    And Validate that the save button disabled
    When Enter the sprint name on name text box
    Then Validate that the save button enabled

    Examples:
      | UserRoll    | endPoint          | ProjectName         |
      | allRoleUser | /good-news/triage | Demo QA Automation1 |

  @regression @critical @sprint @TC-S13
  Scenario Outline: Verify that the create new sprint with required field
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    When Create new nugget with "<ProjectName>" project if triage nugget list is empty
    And Click on the sprint dropdown
    And Click on the create sprint button
    Then Validate that the create sprint dialog box is open
    When Enter the sprint name on name text box
    And Click on save button of create sprint dialog box
    Then Validate that the successfully created sprint toast notification message is displayed
    When Click on the sprint dropdown
    Then Validate that the created sprint is displayed on sprint list
    When Click on delete sprint icon
    Then Validate that the successfully delete sprint toast notification message is displayed

    Examples:
      | UserRoll    | endPoint          | ProjectName         |
      | allRoleUser | /good-news/triage | Demo QA Automation1 |

  @regression @critical @sprint @TC-S14
  Scenario Outline: Verify that the create a new sprint with backlog functionality
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    When Create new nugget with "<ProjectName>" project if triage nugget list is empty
    And Click on the sprint dropdown
    And Click on the create sprint button
    Then Validate that the create sprint dialog box is open
    When Enter the sprint name on name text box
    And Click on the backlog checkbox
    And Select the return to triage date
    And Click on save button of create sprint dialog box
    And Click on the sprint dropdown
    Then Validate that the created sprint is displayed on sprint list
    And Validate that the selected return to triage date is displayed on created sprint name

    Examples:
      | UserRoll    | endPoint          | ProjectName         |
      | allRoleUser | /good-news/triage | Demo QA Automation1 |

  @regression @critical @sprint @TC-S15
  Scenario Outline: Verify that the edit and delete icon is displayed on sprint row
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    When Create new nugget with "<ProjectName>" project if triage nugget list is empty
    And Click on the sprint dropdown
    And Click on the more option menu of sprint
    Then Validate that the edit sprint icon is displayed
    And Validate that the delete sprint icon is displayed

    Examples:
      | UserRoll    | endPoint          | ProjectName         |
      | allRoleUser | /good-news/triage | Demo QA Automation1 |

  @regression @critical @sprint @TC-S16
  Scenario Outline: Verify that the user is not able to create same name sprint
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    When Create new nugget with "<ProjectName>" project if triage nugget list is empty
    And Click on the sprint dropdown
    And Get existing sprint name
    And Click on the create sprint button
    Then Validate that the create sprint dialog box is open
    When Enter the existing sprint name on name text box
    And Click on save button of create sprint dialog box
    Then Validate that the validation toast message appears with "<message>"

    Examples:
      | UserRoll    | endPoint          | ProjectName         | message                |
      | allRoleUser | /good-news/triage | Demo QA Automation1 | Repetitive Sprint Name |


  @regression @sprint @TC-S17
  Scenario Outline: Verify that the save and cancel icon is displayed when select sprint from the list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    When Create new nugget with "<ProjectName>" project if triage nugget list is empty
    And Click on the sprint dropdown
    And Click on the created sprint from list
    Then Validate that the save assign sprint icon is displayed
    And Validate that the close assign sprint icon is displayed

    Examples:
      | UserRoll    | endPoint          | ProjectName         |
      | allRoleUser | /good-news/triage | Demo QA Automation1 |

  #@regression @sprint @TC-S18
  Scenario Outline: Verify close icon functionality of selected sprint
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    When Create new nugget with "<ProjectName>" project if triage nugget list is empty
    And Click on the sprint dropdown
    And Click on the created sprint from list
    Then Validate that the close assign sprint icon is displayed
    When Click on the close icon
    Then Validate that the selected sprint name is removed

    Examples:
      | UserRoll    | endPoint          | ProjectName         |
      | allRoleUser | /good-news/triage | Demo QA Automation1 |

  #@regression @sprint @TC-S19
  Scenario Outline: Verify that the Backlog checkbox and 'Return to Triage' date is automatically selected on the nugget row when the user selects the backlog sprint
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    When Create new nugget with "<ProjectName>" project if triage nugget list is empty
    And Click on the sprint dropdown
    And Click on the created sprint from list
    Then Validate the backlog checkbox is selected
    And Validate that the return to triage date is selected

    Examples:
      | UserRoll    | endPoint          | ProjectName         |
      | allRoleUser | /good-news/triage | Demo QA Automation1 |

  @regression @critical @sprint @TC-S20
  Scenario Outline: Verify that the nugget is moved into the Backlog list when assign backlog sprint to the nugget
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    When Create new nugget with "<ProjectName>" project if triage nugget list is empty
    And Click on the sprint dropdown
    And Click on the first sprint from the list
    And Click on the save icon
    And Click on the backlog tab
    Then Validate that the moved nugget is displayed on the backlog List
    When Click on the moved nuggets sprint dropdown
    And Click on the none option from sprint list
    And Click on the save icon on backlog tab
    And Click on the archive button
    And Click on the save icon on backlog tab

    Examples:
      | UserRoll    | endPoint          | ProjectName         |
      | allRoleUser | /good-news/triage | Demo QA Automation1 |

  @regression @critical @sprint @TC-S21
  Scenario Outline: Verify that the user is able to edit the sprint name
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    When Create new nugget with "<ProjectName>" project if triage nugget list is empty
    And Click on the sprint dropdown
    And Click on the edit sprint icon
    Then Validate that the update sprint dialog box is open
    When Update the new sprint name
    And Click on the update button
    Then Validate that the successfully updated sprint toast notification message is displayed
    #When Click on the sprint dropdown
    Then Validate that the updated sprint is displayed on sprint list

    Examples:
      | UserRoll    | endPoint          | ProjectName         |
      | allRoleUser | /good-news/triage | Demo QA Automation1 |

  @regression @critical @sprint @TC-S22
  Scenario Outline: Verify that the user is able to edit the sprint return to triage date
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    When Create new nugget with "<ProjectName>" project if triage nugget list is empty
    And Click on the sprint dropdown
    And Click on the edit sprint icon
    Then Validate that the update sprint dialog box is open
    When Update the new return to triage date
    And Click on the update button
    Then Validate that the successfully updated sprint toast notification message is displayed
    #When Click on the sprint dropdown
    Then Validate that the updated return to triage date is displayed on sprint list

    Examples:
      | UserRoll    | endPoint          | ProjectName         |
      | allRoleUser | /good-news/triage | Demo QA Automation1 |

  @regression @sprint @TC-S23
  Scenario Outline: Verify that the sprint backlog date is removed when user uncheck the backlog checkbox
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    When Create new nugget with "<ProjectName>" project if triage nugget list is empty
    And Click on the sprint dropdown
    And Click on the edit sprint icon
    Then Validate that the update sprint dialog box is open
    When Click on the backlog checkbox
    And Click on the update button
    Then Validate that the successfully updated sprint toast notification message is displayed
    #When Click on the sprint dropdown
    Then Validate that the return to triage date is removed

    Examples:
      | UserRoll    | endPoint          | ProjectName         |
      | allRoleUser | /good-news/triage | Demo QA Automation1 |


  @regression @critical @sprint @TC-S24
  Scenario Outline: Verify that the user is able to delete the sprint
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    When Create new nugget with "<ProjectName>" project if triage nugget list is empty
    And Click on the sprint dropdown
    And Click on delete sprint icon
    Then Validate that the successfully delete sprint toast notification message is displayed
    When Click on the sprint dropdown
    Then Validate that the deleted sprint is not displayed on sprint list

    Examples:
      | UserRoll    | endPoint          | ProjectName         |
      | allRoleUser | /good-news/triage | Demo QA Automation1 |

  @regression @critical @sprint @TC-S25
  Scenario Outline: Verify that the user is able to assign the sprint on the nugget
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    When Create new nugget with "<ProjectName>" project if triage nugget list is empty
    And Click on the sprint dropdown
    And Click on the create sprint button
    Then Validate that the create sprint dialog box is open
    When Enter the sprint name on name text box
    And Click on save button of create sprint dialog box
    Then Validate that the successfully created sprint toast notification message is displayed
    When Click on the sprint dropdown
    And Click on the created sprint from list
    And Click on the assign sprint save button
    And Click on the sprint dropdown
    Then Validate that the assign sprint is selected

    Examples:
      | UserRoll    | endPoint          | ProjectName         |
      | allRoleUser | /good-news/triage | Demo QA Automation1 |

  @regression @critical @sprint @TC-S26
  Scenario Outline: Verify that the user is unable to delete the assigned sprint
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    When Create new nugget with "<ProjectName>" project if triage nugget list is empty
    And Click on the sprint dropdown
    And Click on delete sprint icon
    Then Validate that the validation toast message appears with "<message>"

    Examples:
      | UserRoll    | endPoint          | ProjectName         | message                                 |
      | allRoleUser | /good-news/triage | Demo QA Automation1 | Cannot Delete Sprint Containing Nuggets |

  @regression @critical @sprint @TC-S27
  Scenario Outline: Verify that the user is able to unassigned sprint from nugget
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget list is empty or not
    When Create new nugget with "<ProjectName>" project if triage nugget list is empty
    And Click on the sprint dropdown
    And Click on the none option from sprint list
    And Click on the assign sprint save button
    And Click on the sprint dropdown
    Then Validate that the sprint is unassigned from nugget
    And Click on delete sprint icon
    Then Validate that the successfully delete sprint toast notification message is displayed

    Examples:
      | UserRoll    | endPoint          | ProjectName         |
      | allRoleUser | /good-news/triage | Demo QA Automation1 |
