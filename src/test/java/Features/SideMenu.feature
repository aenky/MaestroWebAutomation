Feature: Side Menu Module Test Case

  @regression @sideMenu @TC1
  Scenario Outline: Verify the side menu is displayed on left side
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed

    Examples:
      | UserRoll    |
      | allRoleUser |

  @regression @sideMenu @TC2
  Scenario Outline: Verify the expand functionality of side menu.
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Move cursor on side menu
    Then Validate the side menu is expand and displayed menu name

    Examples:
      | UserRoll    |
      | allRoleUser |

  @regression @sideMenu @TC3
  Scenario Outline: Verify the collapse functionality of side menu.
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Move cursor on side menu
    Then Validate the side menu is expand and displayed menu name
    When Move cursor on search textbox
    Then Validate the side menu is collapse and menu name is not Displayed

    Examples:
      | UserRoll    |
      | allRoleUser |

  @regression @critical @sideMenu @TC4
  Scenario Outline: Verify the option in side menu when user login with common user role.
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Move cursor on side menu
    Then Validate the side menu is expand and displayed menu name
    And Validate the inbox option is displayed on side navigation menu
    And Validate the people option is displayed on side navigation menu
    And Validate the channel option is displayed on side navigation menu
    And Validate the my nuggets option is displayed on side navigation menu
    And Validate the setting option is displayed on side navigation menu
    And Validate the logout option is displayed on side navigation menu

    Examples:
      | UserRoll       |
      | commonRoleUser |

  @regression @critical @sideMenu @TC5
  Scenario Outline: Verify the option in side menu when user login with Resource user role.
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Move cursor on side menu
    Then Validate the side menu is expand and displayed menu name
    And Validate the inbox option is displayed on side navigation menu
    And Validate the people option is displayed on side navigation menu
    And Validate the channel option is displayed on side navigation menu
    And Validate the my nuggets option is displayed on side navigation menu
    And Validate the assignment option is displayed on side navigation menu
    And Validate the dashboard option is displayed on side navigation menu
    And Validate the releases option is displayed on side navigation menu
    And Validate the setting option is displayed on side navigation menu
    And Validate the logout option is displayed on side navigation menu

    Examples:
      | UserRoll         |
      | resourceRoleUser |

  @regression @critical @sideMenu @TC6
  Scenario Outline: Verify the option in side menu when user login with 'Lead Resource' user role.
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Move cursor on side menu
    Then Validate the side menu is expand and displayed menu name
    And Validate the inbox option is displayed on side navigation menu
    And Validate the people option is displayed on side navigation menu
    And Validate the channel option is displayed on side navigation menu
    And Validate the my nuggets option is displayed on side navigation menu
    And Validate the assignment option is displayed on side navigation menu
    And Validate the team lead option is displayed on side navigation menu
    And Validate the dashboard option is displayed on side navigation menu
    And Validate the releases option is displayed on side navigation menu
    And Validate the report option is displayed on side navigation menu
    And Validate the setting option is displayed on side navigation menu
    And Validate the logout option is displayed on side navigation menu

    Examples:
      | UserRoll         |
      | teamLeadRoleUser |

  @regression @critical @sideMenu @TC7
  Scenario Outline: Verify the option in side menu when user login with 'Project Maestro' user role.
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Zoom-In the page section
    And Move cursor on side menu
    Then Validate the side menu is expand and displayed menu name
    And Validate the inbox option is displayed on side navigation menu
    And Validate the people option is displayed on side navigation menu
    And Validate the channel option is displayed on side navigation menu
    And Validate the my nuggets option is displayed on side navigation menu
    And Validate the dashboard option is displayed on side navigation menu
    And Validate the good news option is displayed on side navigation menu
    And Validate the bad news option is displayed on side navigation menu
    And Validate the dashboard option is displayed on side navigation menu
    And Validate the releases option is displayed on side navigation menu
    And Validate the report option is displayed on side navigation menu
    And Validate the setting option is displayed on side navigation menu
    And Validate the logout option is displayed on side navigation menu

    Examples:
      | UserRoll    |
      | PM_RoleUser |

  @regression @critical @sideMenu @TC8
  Scenario Outline: Verify the option in side menu when user login with 'Releases Maestro' user role.
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Move cursor on side menu
    Then Validate the side menu is expand and displayed menu name
    And Validate the inbox option is displayed on side navigation menu
    And Validate the people option is displayed on side navigation menu
    And Validate the channel option is displayed on side navigation menu
    And Validate the my nuggets option is displayed on side navigation menu
    And Validate the dashboard option is displayed on side navigation menu
    And Validate the releases option is displayed on side navigation menu
    And Validate the report option is displayed on side navigation menu
    And Validate the setting option is displayed on side navigation menu
    And Validate the logout option is displayed on side navigation menu

    Examples:
      | UserRoll    |
      | RM_RoleUser |

  @regression @critical @sideMenu @TC9
  Scenario Outline: Verify the option in side menu when user login with 'Admin' user role.
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Move cursor on side menu
    Then Validate the side menu is expand and displayed menu name
    And Validate the inbox option is displayed on side navigation menu
    And Validate the people option is displayed on side navigation menu
    And Validate the channel option is displayed on side navigation menu
    And Validate the my nuggets option is displayed on side navigation menu
    #And Validate the report option is displayed on side navigation menu
    And Validate the setting option is displayed on side navigation menu
    And Validate the logout option is displayed on side navigation menu

    Examples:
      | UserRoll      |
      | adminRoleUser |

  @regression @sideMenu @TC10
  Scenario Outline: Verify the click functionality on People option of side menu.
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the search user textbox is displayed

    Examples:
      | UserRoll    | endPoint |
      | allRoleUser | /people  |

  @regression @sideMenu @TC11
  Scenario Outline: Verify the click functionality on Group option of side menu.
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate the search group textbox is displayed

    Examples:
      | UserRoll    | endPoint |
      | allRoleUser | /groups  |

  @regression @sideMenu @TC12
  Scenario Outline: Verify the click functionality on Nuggets option of side menu.
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate the unread tab is displayed on top menu

    Examples:
      | UserRoll    | endPoint       |
      | allRoleUser | /nugget/unread |

  @regression @sideMenu @TC13
  Scenario Outline: Verify the click functionality on Assignment option of side menu.
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate the in progress tab is displayed on top menu

    Examples:
      | UserRoll         | endPoint                |
      | resourceRoleUser | /assignment/in-progress |

  @regression @sideMenu @TC14
  Scenario Outline: Verify the click functionality on Team Lead option of side menu.
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on team lead option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate the approval due tab is displayed on top menu

    Examples:
      | UserRoll         | endPoint            |
      | teamLeadRoleUser | /lead/need-approval |


  @regression @sideMenu @TC15
  Scenario Outline: Verify the click functionality on Good News option of side menu.
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate the triage tab is displayed on top menu

    Examples:
      | UserRoll    | endPoint          |
      | allRoleUser | /good-news/triage |

  @regression @sideMenu @TC16
  Scenario Outline: Verify the click functionality on Bad News option of side menu.
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on bad news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate the overdue triage tab is displayed on top menu

    Examples:
      | UserRoll    | endPoint                 |
      | PM_RoleUser | /bad-news/overdue-triage |


  @regression @sideMenu @TC17
  Scenario Outline: Verify the click functionality on Dashboard option of side menu.
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate the active sprints tab is displayed on sub menu of dashboard

    Examples:
      | UserRoll    | endPoint                  |
      | allRoleUser | /projects/active-projects |

  @regression @sideMenu @TC18
  Scenario Outline: Verify the click functionality on Releases option of side menu
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate the active releases tab is displayed on top menu

    Examples:
      | UserRoll    | endPoint         |
      | allRoleUser | /releases/active |

  @regression @sideMenu @TC19
  Scenario Outline: Verify the click functionality on Setting option of side menu
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate the User setting menu is displayed on setting page

    Examples:
      | UserRoll         | endPoint               |
      | resourceRoleUser | /settings/user-profile |

  @regression @sideMenu @TC20
  Scenario Outline: Verify the click functionality on Logout option of side menu
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on logout option from side menu
    Then Validate the login page is displayed

    Examples:
      | UserRoll    |
      | allRoleUser |

  @regression @sideMenu @TC21
  Scenario Outline: Verify the click functionality on Inbox option of side menu
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on inbox option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate the nuggets tab is displayed on top menu

    Examples:
      | UserRoll         | endPoint      |
      | resourceRoleUser | /inbox/nugget |

  @regression @sideMenu @TC22
  Scenario Outline: Verify the click functionality on Report option of side menu
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on report option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate the in progress tab is displayed on top menu of report page

    Examples:
      | UserRoll    | endPoint            |
      | allRoleUser | /report/in-progress |

