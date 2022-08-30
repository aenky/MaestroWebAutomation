Feature: Dashboard Module Test Case

  @regression @dashboard @TC1
  Scenario Outline: Verify the all the sub Tabs on project page.
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate the active project tab is displayed on sub menu of dashboard
    And Validate the active sprints tab is displayed on sub menu of dashboard
    And Validate the backlog sprints tab is displayed on sub menu of dashboard
    And Validate the released sprints tab is displayed on sub menu of dashboard

    Examples:
      | UserRoll    | endPoint                  |
      | allRoleUser | /projects/active-projects |


  @regression @dashboard @TC2
  Scenario Outline: Verify click functionality on all the sub Tabs on the project page.
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    Then Validate the current page URL has "<ActiveProjectEndPoint>" end point
    When Click on active sprints tab
    Then Validate the current page URL has "<ActiveSprintEndPoint>" end point
    When Click on backlog sprints tab
    Then Validate the current page URL has "<BacklogSprintEndPoint>" end point
    When Click on released sprints tab
    Then Validate the current page URL has "<ReleasedSprintEndPoint>" end point

    Examples:
      | UserRoll    | ActiveProjectEndPoint     | ActiveSprintEndPoint | BacklogSprintEndPoint | ReleasedSprintEndPoint |
      | allRoleUser | /projects/active-projects | /projects/active     | /projects/backlogged  | /projects/released     |

  @regression @critical @dashboard @TC3
  Scenario Outline: Verify click functionality on 'Create Project' button.
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    Then Validate the current page URL has "<ActiveProjectEndPoint>" end point
    And Validate the create project button is displayed
    When Click on the create project button
    Then Validate create project heading is displayed on open dialog box

    Examples:
      | UserRoll    | ActiveProjectEndPoint     |
      | allRoleUser | /projects/active-projects |

  @regression @dashboard @TC4
  Scenario Outline: Verify the close icon functionality on the create project dialog box.
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    Then Validate the current page URL has "<ActiveProjectEndPoint>" end point
    When Click on the create project button
    Then Validate create project heading is displayed on open dialog box
    And Validate the close icon is displayed on create project dialog box
    When Click on the close icon of create project dialog box
    Then Validate the active project tab is displayed on sub menu of dashboard

    Examples:
      | UserRoll    | ActiveProjectEndPoint     |
      | allRoleUser | /projects/active-projects |


  @regression @dashboard @TC5
  Scenario Outline: Verify the create button is disabled until all the required field is filled up on create project dialog box.
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    Then Validate the current page URL has "<ActiveProjectEndPoint>" end point
    When Click on the create project button
    Then Validate create project heading is displayed on open dialog box
    And Validate that the create button is disabled
    When Select workflow from dropdown
    And Select "<Status>" status from dropdown
    And Select project maestro from dropdown
    Then Validate that the create button is disabled
    When Click on the close icon of create project dialog box
    When Click on the create project button
    Then Validate create project heading is displayed on open dialog box
    And Validate that the create button is disabled
    When Enter project name on title field
    And Select "<Status>" status from dropdown
    And Select project maestro from dropdown
    Then Validate that the create button is disabled
    When Click on the close icon of create project dialog box
    When Click on the create project button
    Then Validate create project heading is displayed on open dialog box
    And Validate that the create button is disabled
    When Enter project name on title field
    And Select workflow from dropdown
    And Select project maestro from dropdown
    And Validate that the create button is disabled
    When Click on the close icon of create project dialog box
    And Click on the create project button
    Then Validate create project heading is displayed on open dialog box
    And Validate that the create button is disabled
    When Enter project name on title field
    And Select "<Status>" status from dropdown
    And Select workflow from dropdown
    Then Validate that the create button is disabled
    When Select project maestro from dropdown
    Then Validate that the create button is Enable

    Examples:
      | UserRoll    | ActiveProjectEndPoint     | Status |
      | allRoleUser | /projects/active-projects | Active |

  @regression @dashboard @TC6
  Scenario Outline: Verify the close icon functionality on the create project dialog box.
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    Then Validate the current page URL has "<ActiveProjectEndPoint>" end point
    And Validate the create project button is not Displayed

    Examples:
      | UserRoll         | ActiveProjectEndPoint     |
      | resourceRoleUser | /projects/active-projects |
      | teamLeadRoleUser | /projects/active-projects |
      | RM_RoleUser      | /projects/active-projects |

  @regression @critical @dashboard @TC7
  Scenario Outline: Verify the create new project functionality
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    Then Validate the current page URL has "<ActiveProjectEndPoint>" end point
    And Click on the create project button
    Then Validate create project heading is displayed on open dialog box
    When Enter project name on title field
    And Select "<Status>" status from dropdown
    And Select workflow from dropdown
    And Select project maestro from dropdown
    And Select secondary maestro from dropdown
    And Click on the create button
    Then Validate the successfully created project toast notification message is displayed
    And Validate that the created project is displayed in the List
    And Validate that the created project is highlighted in the List

    Examples:
      | UserRoll    | ActiveProjectEndPoint     | Status |
      | allRoleUser | /projects/active-projects | Active |

  @regression @dashboard @TC8
  Scenario Outline: Verify the create new project without secondary maestro
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    Then Validate the current page URL has "<ActiveProjectEndPoint>" end point
    And Click on the create project button
    Then Validate create project heading is displayed on open dialog box
    When Enter project name on title field
    And Select "<Status>" status from dropdown
    And Select workflow from dropdown
    And Select project maestro from dropdown
    And Click on the create button
    Then Validate the successfully created project toast notification message is displayed
    And Validate that the created project is displayed in the List
    And Validate that the created project is highlighted in the List

    Examples:
      | UserRoll    | ActiveProjectEndPoint     | Status |
      | allRoleUser | /projects/active-projects | Active |

  @regression @dashboard @TC9 @TC10 @TC11
  Scenario Outline: Verify the create new project with 'Queued, On Hold, Approved' status
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    Then Validate the current page URL has "<ActiveProjectEndPoint>" end point
    When Remove active status from project status filter
    And Click on the create project button
    Then Validate create project heading is displayed on open dialog box
    When Enter project name on title field
    And Select "<Status>" status from dropdown
    And Select workflow from dropdown
    And Select project maestro from dropdown
    And Select secondary maestro from dropdown
    And Click on the create button
    Then Validate the successfully created project toast notification message is displayed
    And Validate that the created project is displayed in the List
    And Validate that the created project is highlighted in the List

    Examples:
      | UserRoll    | ActiveProjectEndPoint     | Status   |
      #| allRoleUser | /projects/active-projects | Queued   |
      | allRoleUser | /projects/active-projects | On Hold  |
      #| allRoleUser | /projects/active-projects | Approved |

  @regression @critical @dashboard @TC12
  Scenario Outline: Verify user is able to edit the project details
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    Then Validate the current page URL has "<ActiveProjectEndPoint>" end point
    And Click on the first project from list
    And Update the project title name
    And Click on the save button
    When Validate the successfully updated project details toast notification message is displayed
    And Change the project maestro
    And Click on the save button
    When Validate the successfully updated project details toast notification message is displayed
    And Change the secondary maestro
    And Click on the save button
    When Validate the successfully updated project details toast notification message is displayed
    And Update the project description
    And Click on the save button
    When Validate the successfully updated project details toast notification message is displayed
    And Change "<Status>" status from dropdown
    And Click on the save button
    When Validate the successfully updated project details toast notification message is displayed

    Examples:
      | UserRoll    | ActiveProjectEndPoint     | Status  |
      | allRoleUser | /projects/active-projects | On Hold |

  @regression @dashboard @TC13 @TC14 @TC15
  Scenario Outline: Verify that the user with Resource, Lead Resource, Release Maestro role not able to update the project details
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    Then Validate the current page URL has "<ActiveProjectEndPoint>" end point
    And Click on the first project from list
    Then Validate the project name field is disable
    And Validate the project status dropdown is disable
    And Validate the project maestro dropdown is disable
    And Validate the Secondary maestro dropdown is disable
    And Validate the project description field is disable

    Examples:
      | UserRoll         | ActiveProjectEndPoint     |
      | resourceRoleUser | /projects/active-projects |
      | teamLeadRoleUser | /projects/active-projects |
      | RM_RoleUser      | /projects/active-projects |

  @regression @dashboard @TC16
  Scenario Outline: Verify that the active status project is displayed in the project list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    Then Validate the current page URL has "<ActiveProjectEndPoint>" end point
    And Validate all listed project status is Active

    Examples:
      | UserRoll    | ActiveProjectEndPoint     |
      | allRoleUser | /projects/active-projects |


  @regression @dashboard @TC18
  Scenario Outline: Verify all the column names in the active project tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    Then Validate the current page URL has "<ActiveProjectEndPoint>" end point
    And Validate all the column name in the active project tab

    Examples:
      | UserRoll    | ActiveProjectEndPoint     |
      | allRoleUser | /projects/active-projects |

  @regression @dashboard @TC19
  Scenario Outline: Verify double click functionality on the project
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    Then Validate the current page URL has "<ActiveProjectEndPoint>" end point
    When Get the first project's ID and Double click on that project
    And Validate the project Id on the redirected tab heading name

    Examples:
      | UserRoll    | ActiveProjectEndPoint     |
      | allRoleUser | /projects/active-projects |

  @regression @dashboard @TC20
  Scenario Outline: Double click on the project and verify the list of that project nuggets
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    Then Validate the current page URL has "<ActiveProjectEndPoint>" end point
    When Get the first project's ID and Double click on that project
    Then Validate the project Id on the redirected tab heading name
    And Validate the project nugget list or message is list is empty

    Examples:
      | UserRoll    | ActiveProjectEndPoint     |
      | allRoleUser | /projects/active-projects |

  @regression @dashboard @TC21
  Scenario Outline: Verify the Project details section of the right side
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    Then Validate the current page URL has "<ActiveProjectEndPoint>" end point
    When Click on the first project from list
    Then Validate the project details section with the Chat, Details and Attachment section

    Examples:
      | UserRoll    | ActiveProjectEndPoint     |
      | allRoleUser | /projects/active-projects |

  @regression @dashboard @TC22
  Scenario Outline: Verify the click functionality on the project chat tab of the right side menu
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    Then Validate the current page URL has "<ActiveProjectEndPoint>" end point
    When Click on the first project from list
    Then Validate the project details section with the Chat, Details and Attachment section
    When Click on the project chat tab
    Then Validate the system is displayed the chat section

    Examples:
      | UserRoll    | ActiveProjectEndPoint     |
      | allRoleUser | /projects/active-projects |

  @regression @dashboard @TC23
  Scenario Outline: Verify the click functionality on the project details tab of the right side menu
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    Then Validate the current page URL has "<ActiveProjectEndPoint>" end point
    When Click on the first project from list
    Then Validate the project details section with the Chat, Details and Attachment section
    When Click on the project details tab
    Then Validate the system is displayed the project details section

    Examples:
      | UserRoll    | ActiveProjectEndPoint     |
      | allRoleUser | /projects/active-projects |

  @regression @dashboard @TC24
  Scenario Outline: Verify the click functionality on the project chat attachment details tab of the right side menu
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    Then Validate the current page URL has "<ActiveProjectEndPoint>" end point
    When Click on the first project from list
    Then Validate the project details section with the Chat, Details and Attachment section
    When Click on the project attachment tab
    Then Validate the system is displayed the project chat attachment section

    Examples:
      | UserRoll    | ActiveProjectEndPoint     |
      | allRoleUser | /projects/active-projects |

  @regression @dashboard @TC25 @TC26 @TC27
  Scenario Outline: Verify that the only that project list is displayed which is selected from status filter option
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    Then Validate the current page URL has "<ActiveProjectEndPoint>" end point
    When Remove active status from project status filter
    And Click on the status filter option
    And Select "<Status>" status from filter list
    Then Validate the all listed project status is "<Status>"


    Examples:
      | UserRoll    | ActiveProjectEndPoint     | Status   |
      #| allRoleUser | /projects/active-projects | Queued   |
      | allRoleUser | /projects/active-projects | On Hold  |
      #| allRoleUser | /projects/active-projects | Approved |

  @regression @dashboard @TC28
  Scenario Outline: The select multiple filter option from the project status filter list and verify that the project list is displayed as per selected status
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    Then Validate the current page URL has "<ActiveProjectEndPoint>" end point
    When Remove active status from project status filter
    And Click on the status filter option
    And Select "<Status>" status from filter list
    Then Validate the all the listed project status is "<Status>"


    Examples:
      | UserRoll    | ActiveProjectEndPoint     | Status          |
      #| allRoleUser | /projects/active-projects | Queued, On Hold |
      | allRoleUser | /projects/active-projects | On Hold, Active |
      #| allRoleUser | /projects/active-projects | Queued, Active  |

  @regression @dashboard @TC29
  Scenario Outline: Remove automation project from the list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    Then Validate the current page URL has "<ActiveProjectEndPoint>" end point
    And Remove all automation project from list

    Examples:
      | UserRoll    | ActiveProjectEndPoint     |
      | allRoleUser | /projects/active-projects |