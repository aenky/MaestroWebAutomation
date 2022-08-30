Feature: Scenario Based Test Cases of Nuggets Modules

  @regression @critical @SC @SCN @TC-SCN00
  Scenario Outline: Verify the user is able to create a nugget of Scenario Based Project
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the create nugget button
    Then Validate the create nugget heading on open dialog box
    When Select "<Type>" nugget type from dropdown
    And Enter the nugget name on name text box
    And Select the "<ProjectName>" project from dropdown
    And Select "<Priority>" nugget priority from dropdown
    And Enter the description on description text box
    And Click on the create button
    Then Validate that the successfully created nugget toast notification message is displayed

    Examples:
      | UserRoll   | endPoint       | Type | Priority | ProjectName           |
      | scenarioTC | /nugget/unread | Bug  | Normal   | Scenario Base Project |


  @regression @SC @SCN @TC-SCN01
  Scenario Outline: Validate that the created nugget from another user will be displayed on 'Good News > Triage' of 'Project Maestro' user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    And Validate the current page URL has "<endPoint>" end point
    Then Validate that the created nugget is displayed on triage nugget list

    Examples:
      | UserRoll   | endPoint          |
      | scenarioQA | /good-news/triage |

  @regression @SC @SCN @TC-SCN02
  Scenario Outline: Validate that the created nugget from another user will be displayed on 'Good News > Triage' of 'Secondary Maestro' user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    And Validate the current page URL has "<endPoint>" end point
    Then Validate that the created nugget is displayed on triage nugget list

    Examples:
      | UserRoll   | endPoint          |
      | scenarioTC | /good-news/triage |

  @regression @critical @SC @SCN @TC-SCN03
  Scenario Outline: Validate that the user can create the new sprint on created nugget and assign to that created nugget
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    And Validate the current page URL has "<endPoint>" end point
    Then Validate that the created nugget is displayed on triage nugget list
    When Click on the created nugget
    And Click on the created nugget's sprint dropdown
    And Click on the create sprint button
    Then Validate that the create sprint dialog box is open
    When Enter the sprint name on name text box
    And Click on save button of create sprint dialog box
    Then Validate that the successfully created sprint toast notification message is displayed
    When Click on the save icon
    And Click on the created nugget's sprint dropdown
    Then Validate that the assign sprint is selected
    When Add nugget name on the list

    Examples:
      | UserRoll   | endPoint          |
      | scenarioQA | /good-news/triage |

  @regression @SC @SCN @TC-SCN04
  Scenario Outline: Validate that the 'Project Maestro' user can assign a nugget to any Resources
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    And Validate the current page URL has "<endPoint>" end point
    Then Validate that the created nugget is displayed on triage nugget list
    And Click on the created nugget
    And Select the "<ResourcesName>" resource from any phase
    Then Validate that the assign resource toast validation message is displayed
    When Remove the "<ResourcesName>" resource

    Examples:
      | UserRoll   | endPoint          | ResourcesName  |
      | scenarioQA | /good-news/triage | AAuto Resource |

  @regression @SC @SCN @TC-SCN05
  Scenario Outline: Validate that the 'Secondary Maestro' user can assign a nugget to any Resources
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    And Validate the current page URL has "<endPoint>" end point
    And Click on the created nugget
    And Select the "<ResourcesName>" resource from any phase
    Then Validate that the assign resource toast validation message is displayed
    When Remove the "<ResourcesName>" resource

    Examples:
      | UserRoll   | endPoint          | ResourcesName  |
      | scenarioTC | /good-news/triage | AAuto Resource |

  @regression @SC @SCN @TC-SCN06
  Scenario Outline: Validate that the 'Assigned' column status is changed when the user assigns a phase to resource
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    And Validate the current page URL has "<endPoint>" end point
    And Click on the created nugget
    Then Validate that the nugget's assigned status is "None"
    When Select the "<ResourcesName>" resource from any phase
    Then Validate that the assign resource toast validation message is displayed
    And Validate that the nugget's assigned status is "Partial"
    When Click on the second phase
    When Select the "<OtherResourcesName>" resource from any phase
    Then Validate that the assign resource toast validation message is displayed
    #And Validate that the nugget's assigned status is "Full"
    When Remove the "<OtherResourcesName>" resource
    And Click on the first phase
    And Click on the edit resource icon
    And Remove the "<ResourcesName>" resource

    Examples:
      | UserRoll   | endPoint          | ResourcesName  | OtherResourcesName |
      | scenarioTC | /good-news/triage | AAuto Resource | AAuto Scenario     |

  @regression @critical @SC @SCN @TC-SCN07
  Scenario Outline: Validate that the nugget is moved to the Good News > Upcoming when user assign resource on all the phase
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    And Validate the current page URL has "<endPoint>" end point
    And Click on the created nugget
    When Select the "<ResourcesName>" resource from any phase
    Then Validate that the assign resource toast validation message is displayed
    When Click on the second phase
    When Select the "<OtherResourcesName>" resource from any phase
    Then Validate that the assign resource toast validation message is displayed
    #And Validate that the created nugget is removed from triage list
    When Click on the "<TabName>" sub tab
    Then Validate that the nugget name is displayed on the nugget list

    Examples:
      | UserRoll   | endPoint          | ResourcesName  | OtherResourcesName | TabName  |
      | scenarioTC | /good-news/triage | AAuto Resource | AAuto Scenario     | Upcoming |

  @regression @SC @SCN @TC-SCN08
  Scenario Outline: Validate that the created active sprint is displayed on 'Dashboard > Active Sprint' list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    And Validate the current page URL has "<endPoint>" end point
    And Click on the "<TabName>" sub tab
    Then Validate that the created sprint is displayed on active sprint list

    Examples:
      | UserRoll   | endPoint                  | TabName        |
      | scenarioQA | /projects/active-projects | Active Sprints |

  @regression @critical @SC @SCN @TC-SCN09
  Scenario Outline: Validate that the project / secondary maestro user can create the new release
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    And Validate the current page URL has "<endPoint>" end point
    Then Validate that the create release button is displayed
    When Click on the create release button
    Then Validate that the create release dialog box is open
    When Enter the release name
    And Select the current release date
    And select the current release cutoff date
    And Select the "<ReleaseMaestro>" release maestro from dropdown
    And Select the "<SecondaryMaestro>" secondary maestro from dropdown
    And Enter the description on the text box
    Then Validate that the create button is Enable
    When Click on the create button
    Then Validate the successfully created release toast notification message is displayed
    And Validate that the created release is displayed in the List

    Examples:
      | UserRoll   | endPoint         | ReleaseMaestro | SecondaryMaestro |
      | scenarioQA | /releases/active | Auto Scenario  | Auto QAS         |

  @regression @critical @SC @SCN @TC-SCN10
  Scenario Outline: Validate that the assign the created release on active sprint and check that the assigned release name, release date and release cutoff date are displayed on the sprint of active spirit list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    And Validate the current page URL has "<endPoint>" end point
    And Click on the "<TabName>" sub tab
    Then Validate that the created sprint is displayed on active sprint list
    When Click on the created sprint
    And Click on the sprint details tab
    And Select the created release to the sprint
    And Click on the save button
    Then Validate that the assigned release name is displayed on selected sprint's release column
    And Validate that the assigned release date is displayed on selected sprint's release date column
    And Validate that the assigned release cutoff date is displayed on selected sprint's release cutoff date column

    Examples:
      | UserRoll   | endPoint                  | TabName        |
      | scenarioQA | /projects/active-projects | Active Sprints |

  @regression @critical @SC @SCN @TC-SCN11
  Scenario Outline: Validate that the user can unassigne the release from sprint and check that the release name, release date and release cutoff date are remove from the sprint of active spirit list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    And Validate the current page URL has "<endPoint>" end point
    And Click on the "<TabName>" sub tab
    Then Validate that the created sprint is displayed on active sprint list
    When Click on the created sprint
    And Click on the sprint details tab
    And Click on the close icon
    And Click on the close icon
    And Click on the save button
    Then Validate that the assigned release name is removed from the selected sprint's release column
    And Validate that the assigned release date is removed from the selected sprint's release date column
    And Validate that the assigned release cutoff date is removed from the selected sprint's release cutoff date column

    Examples:
      | UserRoll   | endPoint                  | TabName        |
      | scenarioQA | /projects/active-projects | Active Sprints |

  #Release date is Shadow dom element so not able to get element value
  #Need to find way how to automate shadow dom element
  @regression @critical @SC @SCN @TC-SCN12
  Scenario Outline: Validate that the assign the release on the created sprint and check that the release date is displayed on the release date field of sprint's detail section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    And Validate the current page URL has "<endPoint>" end point
    And Click on the "<TabName>" sub tab
    Then Validate that the created sprint is displayed on active sprint list
    When Click on the created sprint
    And Click on the sprint details tab
    And Select the created release to the sprint
    And Click on the save button
    And Wait for "2" sec
    #Then Validate that the release date field date is same as release date

    Examples:
      | UserRoll   | endPoint                  | TabName        |
      | scenarioQA | /projects/active-projects | Active Sprints |

  @regression  @critical @SC @SCN @TC-SCN13
  Scenario Outline: Validate that the assigned nugget is displayed in 'Assignments > Estimate Due' for the first phase's resource
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the "<TabName>" sub tab
    Then Validate that the nugget name is displayed on the nugget list

    Examples:
      | UserRoll     | endPoint                | TabName       |
      | AutoResource | /assignment/in-progress | Estimates Due |

  @regression @critical @SC @SCN @TC-SCN14
  Scenario Outline: Validate that the assigned nugget is displayed in 'Assignments > Upcoming Estimate' for the second phase's resource
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the "<TabName>" sub tab
    Then Validate that the nugget name is displayed on the nugget list

    Examples:
      | UserRoll     | endPoint                | TabName            |
      | AutoScenario | /assignment/in-progress | Upcoming Estimates |

  @regression @critical @SC @SCN @TC-SCN15
  Scenario Outline: Validate that the nugget is moved to the 'Good News > Triage' from 'Good News > Upcoming' when the user unassign resource from any of the phase
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    And Validate the current page URL has "<endPoint>" end point
    And Click on the "<TabName>" sub tab
    Then Validate that the nugget name is displayed on the nugget list
    And Click on the created nugget
    And Click on the first phase
    And Click on the edit resource icon
    And Remove the "<ResourcesName>" resource
    Then Validate that the removed resource toast validation message is displayed
    And Click on the second phase
    And Click on the edit resource icon
    When Remove the "<OtherResourcesName>" resource
    Then Validate that the removed resource toast validation message is displayed
    #And Validate that the created nugget is removed from triage list
    When Click on the "Triage" sub tab
    Then Validate that the nugget name is displayed on the nugget list

    Examples:
      | UserRoll   | endPoint          | ResourcesName  | OtherResourcesName | TabName  |
      | scenarioTC | /good-news/triage | AAuto Resource | AAuto Scenario     | Upcoming |

  @regression  @critical @SC @SCN @TC-SCN16
  Scenario Outline: Validate that the 'Estimated' column's status is None on 'Good News > Upcoming' nugget when no one resource assigns his nugget estimate time
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    And Validate the current page URL has "<endPoint>" end point
    And Click on the created nugget
    And Click on the first phase
    And Select the "<ResourcesName>" resource from any phase
    Then Validate that the assign resource toast validation message is displayed
    When Click on the second phase
    When Select the "<OtherResourcesName>" resource from any phase
    Then Validate that the assign resource toast validation message is displayed
    #And Validate that the created nugget is removed from triage list
    When Click on the "<TabName>" sub tab
    Then Validate that the nugget name is displayed on the nugget list
    And Validate that the nugget's estimated status is "None"

    Examples:
      | UserRoll   | endPoint          | ResourcesName  | OtherResourcesName | TabName  |
      | scenarioTC | /good-news/triage | AAuto Resource | AAuto Scenario     | Upcoming |

  @regression @critical @SC @SCN @TC-SCN17
  Scenario Outline: Validate that the nugget is moved into "Assignment > In progress" when the user adds a nugget's estimated start date is the current date
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Validate the current page URL has "<endPoint>" end point
    And Click on the "<TabName>" sub tab
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the created nugget
    And Click on the nugget timecard tab
    And Select the current date on start date
    And Select any future date on target date
    And Enter "3" hours on estimate hours field
    And Click on the submit estimate button
    Then Validate that the success toast message is displayed
    And Click on the "In Progress" sub tab
    And Validate the current page URL has "<endPoint>" end point
    Then Validate that the nugget name is displayed on the nugget list

    Examples:
      | UserRoll     | endPoint                | TabName       |
      | AutoResource | /assignment/in-progress | Estimates Due |

  @regression  @critical @SC @SCN @TC-SCN18
  Scenario Outline: Validate that the assigned nugget is moved into Assignments > Estimate Due' for the second phase's resource when the first phase's all resources add his nugget estimate time
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the "<TabName>" sub tab
    Then Validate that the nugget name is displayed on the nugget list

    Examples:
      | UserRoll     | endPoint                | TabName       |
      | AutoScenario | /assignment/in-progress | Estimates Due |

  @regression @critical @SC @SCN @TC-SCN19
  Scenario Outline: Validate that the 'Estimated' column's status is Partial on 'Good News > Upcoming' nugget when any one assigned resource adds his nugget estimate time
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the "<TabName>" sub tab
    And Click on the created nugget
    Then Validate that the nugget name is displayed on the nugget list
    And Validate that the nugget's estimated status is "Partial"

    Examples:
      | UserRoll   | endPoint          | TabName  |
      | scenarioTC | /good-news/triage | Upcoming |

  @regression @critical @SC @SCN @TC-SCN20
  Scenario Outline: Validate that the user can not select the past date on the start date field of the nugget add assignment tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Validate the current page URL has "<endPoint>" end point
    And Click on the "<TabName>" sub tab
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the created nugget
    And Click on the nugget timecard tab
    And Click on start date field
    Then Validate that the past date is disabled on the date picker

    Examples:
      | UserRoll     | endPoint                | TabName       |
      | AutoScenario | /assignment/in-progress | Estimates Due |

  @regression @critical @SC @SCN @TC-SCN21
  Scenario Outline: Validate that the user can not select the past date on the end date field from the start date on the nugget add assignment tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Validate the current page URL has "<endPoint>" end point
    And Click on the "<TabName>" sub tab
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the created nugget
    And Click on the nugget timecard tab
    And Select the future date on start date
    And Click on the target date field
    Then Validate that the date is disabled till the selected start date on the target date picker

    Examples:
      | UserRoll     | endPoint                | TabName       |
      | AutoScenario | /assignment/in-progress | Estimates Due |

  @regression @critical @SC @SCN @TC-SCN22
  Scenario Outline: Validate that the nugget is moved into the "Assignment > Upcoming" list when the user adds nugget's estimated start date is a future date
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Validate the current page URL has "<endPoint>" end point
    And Click on the "<TabName>" sub tab
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the created nugget
    And Click on the nugget timecard tab
    And Select the future date on start date
    And Select any future date on target date
    And Enter "2" hours on estimate hours field
    And Click on the submit estimate button
    Then Validate that the success toast message is displayed
    And Click on the "Upcoming" sub tab
    And Validate the current page URL has "/assignment/upcoming" end point
    Then Validate that the nugget name is displayed on the nugget list

    Examples:
      | UserRoll     | endPoint                | TabName       |
      | AutoScenario | /assignment/in-progress | Estimates Due |

  @regression @critical @SC @SCN @TC-SCN23
  Scenario Outline: Validate that the 'Estimated' column's status is Full on 'Good News > Upcoming' nugget when all assigned resource adds his nugget estimate time
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the "<TabName>" sub tab
    And Click on the created nugget
    Then Validate that the nugget name is displayed on the nugget list
    And Validate that the nugget's estimated status is "Full"

    Examples:
      | UserRoll   | endPoint          | TabName  |
      | scenarioTC | /good-news/triage | Upcoming |

  @regression @critical @SC @SCN @TC-SCN24
  Scenario Outline: Validate that the first phase's assigned resource can able to add a journal card
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Validate the current page URL has "<endPoint>" end point
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the created nugget
    And Click on the nugget timecard tab
    And Click on the add journal icon
    And Select the current date
    And Add "<Hours>" on the journal hours field
    And Enter "<Notes>" the journal notes
    And Click on the submit journal button
    Then Validate that the validation toast message appears with "<Message>"
    And Validate the added journal details is displayed on the journal log list
    When Click on the nugget assignment tab
    And Get the resource name

    Examples:
      | UserRoll     | endPoint                | Hours | Notes              | Message              |
      | AutoResource | /assignment/in-progress | 2     | Auto Journal Notes | Successfully updated |

  @regression @critical @SC @SCN @TC-SCN25
  Scenario Outline: Validate that the added nugget journal is displayed on the 'Good News > Journal Reports' tab of the project maestro user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the "<TabName>" sub tab
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the recently added resource journal's nugget
    Then Validate the added journal details is displayed on the journal log list

    Examples:
      | UserRoll   | endPoint          | TabName         |
      | scenarioTC | /good-news/triage | Journal Reports |

  @regression @critical @SC @SCN @TC-SCN26
  Scenario Outline: Validate that the first phase's assigned resource can complete his nugget and that nugget is displayed on the 'Assignments > Completed' tab list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Validate the current page URL has "<endPoint>" end point
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the created nugget
    When Click on the nugget assignment tab
    And Get the resource name
    And Click on the nugget timecard tab
    #And Click on the add journal icon
    #And Select the current date
    And Add "<Hours>" on the journal hours field
    And Enter "<Notes>" the journal notes
    And Click on the submit journal button
    And Click on the OK button
    When Click on the completed sub tab
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the created nugget
    And Click on the nugget assignment tab
    Then Validate the added journal details is displayed on the journal log list

    Examples:
      | UserRoll     | endPoint                | Hours | Notes              |
      | AutoResource | /assignment/in-progress | 3     | Auto Journal Notes |

  @regression @critical @SC @SCN @TC-SCN27
  Scenario Outline: Validate that the completed nugget of the first phase's assigned resource is displayed on the 'Good News > Approvals Due' of the project maestro user and the project maestro user can approve that nugget for the first phase's assigned resource
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the "<TabName>" sub tab
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the recently completed nugget of resource
    And Click on the nugget chat tab
    Then Validate that the completed resource is displayed on the selected nugget resource column
    When Approve the selected nugget
    Then Validate that the selected nugget is removed from the list

    Examples:
      | UserRoll   | endPoint          | TabName       |
      | scenarioTC | /good-news/triage | Approvals Due |

  @regression @critical @SC @SCN @TC-SCN28
  Scenario Outline: Validate that the nugget status is displayed 'Approved' on the 'Assignments > Completed' tab list on the first phase's assigned resource
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Click on the completed sub tab
    And Validate the current page URL has "<endPoint>" end point
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the created nugget
    Then Validate that the completed nugget's status is "<Status>"

    Examples:
      | UserRoll     | endPoint              | Status   |
      | AutoResource | /assignment/completed | Approved |

  @regression @critical @SC @SCN @TC-SCN29
  Scenario Outline: Validate that the second phase's assigned resource can update his estimate date with the current date and add nugget's journal
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Click on the "Upcoming" sub tab
    And Validate the current page URL has "<endPoint>" end point
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the created nugget
    And Click on the nugget timecard tab
    And Select the current date on start date
    And Click on the submit estimate button
    Then Validate that the selected nugget is removed from the list
    When Click on the "In Progress" sub tab
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the created nugget
    And Click on the nugget timecard tab
    And Click on the add journal icon
    And Select the current date
    And Add "<Hours>" on the journal hours field
    And Enter "<Notes>" the journal notes
    And Click on the submit journal button
    Then Validate that the validation toast message appears with "<Message>"
    And Validate the added journal details is displayed on the journal log list
    When Click on the nugget assignment tab
    And Get the resource name

    Examples:
      | UserRoll     | endPoint             | Hours | Notes              | Message              |
      | AutoScenario | /assignment/upcoming | 1     | Auto Journal Notes | Successfully updated |

  @regression  @critical @SC @SCN @TC-SCN30
  Scenario Outline:  Validate that the added nugget journal is displayed on the 'Good News > Journal Reports' tab of the secondary maestro user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the "<TabName>" sub tab
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the recently added resource journal's nugget
    Then Validate the added journal details is displayed on the journal log list

    Examples:
      | UserRoll   | endPoint          | TabName         |
      | scenarioQA | /good-news/triage | Journal Reports |

  @regression @critical @SC @SCN @TC-SCN31
  Scenario Outline: Validate that the second phase's assigned resource can complete his task using the 'Mark As Completed' checkbox of nugget's daily journal section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Validate the current page URL has "<endPoint>" end point
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the created nugget
    And Click on the nugget timecard tab
    And Click on the 'Mark As Complete' checkBox
    Then Validate that the message on the open confirmation dialog box
    When Click on the submit button
    Then Validate that the selected nugget is removed from the list
    When Click on the completed sub tab
    Then Validate that the nugget name is displayed on the nugget list

    Examples:
      | UserRoll     | endPoint                |
      | AutoScenario | /assignment/in-progress |

  @regression @critical @SC @SCN @TC-SCN32
  Scenario Outline: Validate that the completed nugget of the second phase's assigned resource is displayed on the 'Good News > Approvals Due' of the secondary maestro user and the secondary maestro user can approve that nugget for the second phase's assigned resource
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the "<TabName>" sub tab
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the recently completed nugget of resource
    And Click on the nugget chat tab
    Then Validate that the completed resource is displayed on the selected nugget resource column
    When Approve the selected nugget
    Then Validate that the selected nugget is removed from the list

    Examples:
      | UserRoll   | endPoint          | TabName       |
      | scenarioQA | /good-news/triage | Approvals Due |

    #Staer Team Lead Automation Test case

  @regression @critical @SC @SCN @TC-SCN33
  Scenario Outline: Create the nugget and assign that nugget to team lead resource also assign sprint to this nugget
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the create nugget button
    Then Validate the create nugget heading on open dialog box
    When Select "<Type>" nugget type from dropdown
    And Enter the nugget name on name text box
    And Select the "<ProjectName>" project from dropdown
    And Select "<Priority>" nugget priority from dropdown
    And Enter the description on description text box
    And Click on the create button
    Then Validate that the successfully created nugget toast notification message is displayed
    And Click on good news option from side menu
    And Wait for "3" sec
    When Get Nugget Id
    And Select the "<TeamLeadResourcesName>" resource from any phase
    Then Validate that the assign resource toast validation message is displayed
    When Click on the second phase
    When Select the "<TeamLeadResourcesName>" resource from any phase
    Then Validate that the assign resource toast validation message is displayed
    And Wait for "3" sec
    When Click on the created nugget's sprint dropdown
    And Click on the created sprint from list
    When Click on the save icon
    And Click on the created nugget's sprint dropdown
    And Add nugget name on the list
    Then Validate that the assign sprint is selected

    Examples:
      | UserRoll   | endPoint       | Type | Priority | ProjectName           | TeamLeadResourcesName |
      | scenarioTC | /nugget/unread | Bug  | Normal   | Scenario Base Project | AAuto TeamLead        |

  @regression  @critical @SC @SCN @TC-SCN34
  Scenario Outline: Validate that the assign nugget is displayed on the 'Estimates Due' tab for team lead resource
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the "<TabName>" sub tab
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the created nugget
    Then Validate that the "first" assigned phase name is displayed on the nugget

    Examples:
      | UserRoll   | endPoint                | TabName       |
      | TLResource | /assignment/in-progress | Estimates Due |

  @regression @critical @SC @SCN @TC-SCN35
  Scenario Outline: Validate that the assigned nugget's second phase is displayed on the 'Upcoming Estimates' tab for team lead resource
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the "<TabName>" sub tab
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the created nugget
    Then Validate that the "second" assigned phase name is displayed on the nugget

    Examples:
      | UserRoll   | endPoint                | TabName            |
      | TLResource | /assignment/in-progress | Upcoming Estimates |

  @regression @critical @SC @SCN @TC-SCN36
  Scenario Outline: Validate that the team lead resource can not remove himself from the nugget assignment phase
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the "<TabName>" sub tab
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the created nugget
    And Click on the nugget assignment tab
    And Click on the edit resource icon
    Then Validate that the remove icon is not appears on the "<TeamLeadResourcesName>" team lead resource
    When Click on the second phase
    And Click on the edit resource icon
    Then Validate that the remove icon is not appears on the "<TeamLeadResourcesName>" team lead resource

    Examples:
      | UserRoll   | endPoint                | TabName       | TeamLeadResourcesName |
      | TLResource | /assignment/in-progress | Estimates Due | AAuto TeamLead        |

  @regression @critical @SC @SCN @TC-SCN37
  Scenario Outline: Validate that the when team lead resource adds his first phase's estimate time then after his second phase appears on the 'Estimates Due' nugget list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the "<TabName>" sub tab
    Then Validate that the nugget name is displayed on the nugget list
    And Validate that the "first" assigned phase name is displayed on the nugget
    When Click on the created nugget
    And Click on the nugget timecard tab
    And Select the current date on start date
    And Select any future date on target date
    And Enter "1" hours on estimate hours field
    And Click on the submit estimate button
    Then Validate that the success toast message is displayed
    Then Validate that the nugget name is displayed on the nugget list
    And Validate that the "second" assigned phase name is displayed on the nugget

    Examples:
      | UserRoll   | endPoint                | TabName       |
      | TLResource | /assignment/in-progress | Estimates Due |

  @regression @critical @SC @SCN @TC-SCN38
  Scenario Outline: Validate that the team lead user can add estimate time for remaining all assigned phases
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the "<TabName>" sub tab
    Then Validate that the nugget name is displayed on the nugget list
    And Validate that the "second" assigned phase name is displayed on the nugget
    When Click on the created nugget
    And Click on the nugget timecard tab
    And Select the current date on start date
    And Select any future date on target date
    And Enter "1" hours on estimate hours field
    And Click on the submit estimate button
    Then Validate that the success toast message is displayed
    When Click on the "In Progress" sub tab
    And Validate that the all assigned phase nugget is displayed on the list

    Examples:
      | UserRoll   | endPoint                | TabName       |
      | TLResource | /assignment/in-progress | Estimates Due |

  @regression @critical @SC @SCN @TC-SCN39
  Scenario Outline: Validate that the team lead resource can assign nugget to resource user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the nugget name is displayed on the nugget list
    When Click on the first phase nugget
    And Click on the nugget assignment tab
    And Click on the edit resource icon
    And Select the "<ResourcesName>" resource from any phase
    Then Validate that the assign resource toast validation message is displayed
    When Click on the second phase nugget
    And Click on the nugget assignment tab
    And Click on the edit resource icon
    And Select the "<OtherResourcesName>" resource from any phase
    Then Validate that the assign resource toast validation message is displayed

    Examples:
      | UserRoll   | endPoint                | ResourcesName  | OtherResourcesName |
      | TLResource | /assignment/in-progress | AAuto Resource | AAuto Scenario     |

  @regression @critical  @SC @SCN @TC-SCN40
  Scenario Outline: Validate that the assigned all resource user can see his nugget on the 'Estimates Due' nugget list and add his estimate time
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Validate the current page URL has "<endPoint>" end point
    And Click on the "<TabName>" sub tab
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the created nugget
    And Click on the nugget timecard tab
    And Select the current date on start date
    And Select any future date on target date
    And Enter "3" hours on estimate hours field
    And Click on the submit estimate button
    Then Validate that the success toast message is displayed
    And Click on the "In Progress" sub tab
    And Validate the current page URL has "<endPoint>" end point
    Then Validate that the nugget name is displayed on the nugget list

    Examples:
      | UserRoll     | endPoint                | TabName       |
      | AutoResource | /assignment/in-progress | Estimates Due |
      | AutoScenario | /assignment/in-progress | Estimates Due |

  @regression @critical @SC @SCN @TC-SCN41
  Scenario Outline: Validate that the all resource user can add his daily journal and can complete his nugget
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Validate the current page URL has "<endPoint>" end point
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the created nugget
    When Click on the nugget assignment tab
    And Get the resource name
    And Click on the nugget timecard tab
    And Click on the add journal icon
    And Select the current date
    And Add "<Hours>" on the journal hours field
    And Enter "<Notes>" the journal notes
    And Click on the submit journal button
    And Click on the OK button
    When Click on the completed sub tab
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the created nugget
    And Click on the nugget assignment tab
    Then Validate the added journal details is displayed on the journal log list

    Examples:
      | UserRoll     | endPoint                | Hours | Notes              |
      | AutoResource | /assignment/in-progress | 3     | Auto Journal Notes |
      | AutoScenario | /assignment/in-progress | 3     | Auto Journal Notes |

  @regression @critical @SC @SCN @TC-SCN42
  Scenario Outline: Validate that the added nugget journal is displayed on 'Team Lead > Journal Reports'  nugget list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on team lead option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the "<TabName>" sub tab
    Then Validate that the all added phase of nugget name is displayed on the nugget list
    When Click on the recently added "<Phase>" phase resource journal's nugget
    And Click on the "<Phase>" phase
    Then Validate the added journal details is displayed on the journal log list

    Examples:
      | UserRoll   | endPoint            | TabName         | Phase  |
      | TLResource | /lead/need-approval | Journal Reports | first  |
      | TLResource | /lead/need-approval | Journal Reports | second |

  @regression @critical @SC @SCN @TC-SCN43
  Scenario Outline: Validate that the completed nugget journal is displayed on 'Team Lead > Approvals Due'  nugget list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on team lead option from side menu
    And Validate the current page URL has "<endPoint>" end point
    Then Validate that the "<Phase>" completed phase of nugget name is displayed on the nugget list

    Examples:
      | UserRoll   | endPoint            | Phase  |
      | TLResource | /lead/need-approval | first  |
      | TLResource | /lead/need-approval | second |

  @regression @critical @SC @SCN @TC-SCN44
  Scenario Outline: Validate that the team lead user can approve nugget's assignment which is assigned by him
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on team lead option from side menu
    And Validate the current page URL has "<endPoint>" end point
    And Click on the nugget chat tab
    Then Validate that the "<Phase>" completed phase of nugget name is displayed on the nugget list
    When Approve the "<Phase>" phase of nugget
    Then Validate that the approved "<Phase>" phase nugget is removed from the list

    Examples:
      | UserRoll   | endPoint            | Phase |
      | TLResource | /lead/need-approval | first |

  @regression @critical @SC @SCN @TC-SCN45
  Scenario Outline: Validate that the nugget status is displayed 'Approved' on the 'Assignments > Completed' tab nugget list when team lead user approved nugget
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Click on the completed sub tab
    And Validate the current page URL has "<endPoint>" end point
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the "<Phase>" phase nugget
    Then Validate that the completed nugget's "<Phase>" phase status is "<Status>"

    Examples:
      | UserRoll     | endPoint              | Status   | Phase |
      | AutoResource | /assignment/completed | Approved | first |


  @regression @critical @SC @SCN @TC-SCN46
  Scenario Outline: Validate that the team lead user can add 'Need To Work' for nugget phase
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on team lead option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    When Click on the nugget chat tab
    And Add Need To Work the "<Phase>" phase of nugget
    And Click on the nugget assignment tab
    Then Validate that the "<User>" user status is updated with Need To Work on the workflow resource list

    Examples:
      | UserRoll   | endPoint            | User           | Phase  |
      | TLResource | /lead/need-approval | AAuto Scenario | second |

  @regression @critical @SC @SCN @TC-SCN47
  Scenario Outline: Validate that the resource user can add estimated date and time of the 'Need To Work' nugget and complete his assigned work
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Validate the current page URL has "<endPoint>" end point
    And Click on the "Estimates Due" sub tab
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the created nugget
    And Click on the nugget timecard tab
    And Select the current date on start date
    And Select any future date on target date
    And Enter "<Hours>" hours on estimate hours field
    And Click on the submit estimate button
    Then Validate that the success toast message is displayed
    And Click on the "In Progress" sub tab
    And Validate the current page URL has "<endPoint>" end point
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the created nugget
    And Add "<Hours>" on the journal hours field
    And Enter "<Notes>" the journal notes
    And Click on the submit journal button
    And Click on the OK button
    When Click on the completed sub tab
    Then Validate that the nugget name is displayed on the nugget list

    Examples:
      | UserRoll     | endPoint                | Hours | Notes              |
      | AutoScenario | /assignment/in-progress | 4     | Auto Journal Notes |

  @regression @critical @SC @SCN @TC-SCN48
  Scenario Outline: Validate that the team lead user can approve the 'Need To Work' nugget's assignment which is assigned by him
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on team lead option from side menu
    And Validate the current page URL has "<endPoint>" end point
    And Click on the nugget chat tab
    Then Validate that the "<Phase>" completed phase of nugget name is displayed on the nugget list
    When Approve the "<Phase>" phase of nugget
    Then Validate that the approved "<Phase>" phase nugget is removed from the list

    Examples:
      | UserRoll   | endPoint            | Phase  |
      | TLResource | /lead/need-approval | second |

  @regression @critical @SC @SCN @TC-SCN49
  Scenario Outline: Validate that the team lead user can complete his assignment
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Validate the current page URL has "<endPoint>" end point
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the "<Phase>" phase nugget
    And Click on the nugget assignment tab
    And Get the resource name
    And Click on the nugget timecard tab
    And Click on the add journal icon
    And Select the current date
    And Add "<Hours>" on the journal hours field
    And Enter "<Notes>" the journal notes
    And Click on the submit journal button
    And Click on the OK button
    When Click on the completed sub tab
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the created nugget
    And Click on the nugget assignment tab
    Then Validate the added journal details is displayed on the journal log list

    Examples:
      | UserRoll   | endPoint                | Hours | Notes              | Phase  |
      | TLResource | /assignment/in-progress | 1     | Auto Journal Notes | first  |
      | TLResource | /assignment/in-progress | 1     | Auto Journal Notes | second |

  @regression @critical @SC @SCN @TC-SCN50
  Scenario Outline: Validate that the project / secondary maestro user can approved team lead user' nugget
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    And Click on the "Approvals Due" sub tab
    Then Validate the current page URL has "<endPoint>" end point
    When Click on the nugget chat tab
    And Approve the "<Phase>" phase of the nugget
    Then Validate that the approved "<Phase>" nugget is removed from the list

    Examples:
      | UserRoll   | endPoint                 | Phase |
      | scenarioQA | /good-news/need-approval | first |

  @regression @critical @SC @SCN @TC-SCN51
  Scenario Outline: Validate that the nugget status is displayed 'Approved' on the 'Assignments > Completed' tab nugget list when project / secondary maestro user approved the team lead users nugget
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Click on the completed sub tab
    And Validate the current page URL has "<endPoint>" end point
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the "<Phase>" phase nugget
    Then Validate that the completed nugget's "<Phase>" phase status is "<Status>"

    Examples:
      | UserRoll   | endPoint              | Status   | Phase |
      | TLResource | /assignment/completed | Approved | first |


  @regression @critical @SC @SCN @TC-SCN52
  Scenario Outline: Validate that the project / secondary maestro user can add 'Need To Work' on the team lead's nugget phase
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    And Click on the "Approvals Due" sub tab
    Then Validate the current page URL has "<endPoint>" end point
    When Click on the created nugget
    And Click on the nugget chat tab
    And Add Need To Work the "<Phase>" phase of the nugget
    And Click on the nugget assignment tab
    Then Validate that the "<User>" user status is updated with Need To Work on the workflow resource list

    Examples:
      | UserRoll   | endPoint                 | Phase  | User           |
      | scenarioQA | /good-news/need-approval | second | AAuto TeamLead |

  @regression @critical @SC @SCN @TC-SCN53
  Scenario Outline: Validate that the team lead user can add estimated date and time of the 'Need To Work' nugget and complete his assigned work
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Validate the current page URL has "<endPoint>" end point
    And Click on the "Estimates Due" sub tab
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the created nugget
    And Click on the nugget timecard tab
    And Select the current date on start date
    And Select any future date on target date
    And Enter "<Hours>" hours on estimate hours field
    And Click on the submit estimate button
    Then Validate that the success toast message is displayed
    And Click on the "In Progress" sub tab
    And Validate the current page URL has "<endPoint>" end point
    Then Validate that the nugget name is displayed on the nugget list
    When Click on the created nugget
    And Add "<Hours>" on the journal hours field
    And Enter "<Notes>" the journal notes
    And Click on the submit journal button
    And Click on the OK button
    When Click on the completed sub tab
    Then Validate that the nugget name is displayed on the nugget list

    Examples:
      | UserRoll   | endPoint                | Hours | Notes              |
      | TLResource | /assignment/in-progress | 2     | Auto Journal Notes |

  @regression @critical @SC @SCN @TC-SCN54
  Scenario Outline: Validate that the project / secondary maestro user can approve the 'Need To Work' nugget's assignment which is assigned by him
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    And Click on the "Approvals Due" sub tab
    Then Validate the current page URL has "<endPoint>" end point
    When Click on the nugget chat tab
    And Approve the "<Phase>" phase of the nugget
    Then Validate that the approved "<Phase>" nugget is removed from the list

    Examples:
      | UserRoll   | endPoint                 | Phase  |
      | scenarioQA | /good-news/need-approval | second |

  @regression @critical @SC @SCN @TC-SCN55
  Scenario Outline: Validate that the displayed list of the sprint's nugget when user double click on the sprint
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    And Click on the "<Tab>" sub tab
    Then Validate the current page URL has "<endPoint>" end point
    When Double click on the created sprint
    Then Validate that the list on sprint's nugget is displayed

    Examples:
      | UserRoll   | endPoint         | Tab            |
      | scenarioQA | /projects/active | Active Sprints |

  @regression @critical @SC @SCN @TC-SCN56
  Scenario Outline: Verify that the user can complete the release and check that the completed release is displayed in the released list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the created release is displayed in the List
    When Click on the created release from list
    And Click on the release details tab
    And Click on the complete check box
    And Click on the OK button
    Then Validate that the completed release is removed from the list
    When Click on the "<Tab>" sub tab
    Then Validate that the completed release is displayed on the released list

    Examples:
      | UserRoll   | endPoint         | Tab      |
      | scenarioQA | /releases/active | Released |

  @regression @critical @SC @SCN @TC-SCN57
  Scenario Outline: Validate that the sprint which is assigned to the release is also released and displayed that sprint on the released sprint list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    And Click on the "<Tab>" sub tab
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the released sprint is displayed on released sprint list and sprint's tempo is "<Tempo>"

    Examples:
      | UserRoll   | endPoint           | Tab              | Tempo    |
      | scenarioQA | /projects/released | Released Sprints | Released |

  @regression @critical @SC @SCN @TC-SCN58
  Scenario Outline: Validate that the released nugget is displayed on the 'My Nugget > Release' nugget list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Click on the "<Tab>" sub tab
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the released nugget is displayed on released nugget list and nugget's tempo is "<Tempo>"

    Examples:
      | UserRoll   | endPoint         | Tab      | Tempo    |
      | scenarioTC | /nugget/released | Released | Released |

  @regression @SC @SCN @TC-SCN59
  Scenario Outline: Validate that the audit message appears when the nugget is released
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    And Click on the "<Tab>" sub tab
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the released sprint is displayed on released sprint list and sprint's tempo is "<Tempo>"
    When Double click on the created sprint
    And Click on the created nugget
    And Click on the nugget chat tab
    Then Validate that the chat has displayed "<Message>" audit message

    Examples:
      | UserRoll   | endPoint           | Tab              | Tempo    | Message                       |
      | scenarioQA | /projects/released | Released Sprints | Released | This nugget has been released |

  @regression @SC @SCN @TC-SCN60
  Scenario Outline: Validate that the audit message appears when the sprint is released
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on dashboard option from side menu
    And Click on the "<Tab>" sub tab
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the released sprint is displayed on released sprint list and sprint's tempo is "<Tempo>"
    When Click on the created sprint
    And Click on the nugget chat tab
    Then Validate that the chat has displayed "<Message>" audit message

    Examples:
      | UserRoll   | endPoint           | Tab              | Tempo    | Message                       |
      | scenarioQA | /projects/released | Released Sprints | Released | This sprint has been released |


  @regression @SC @SCN @TC-SCN61
  Scenario Outline: Validate that the release nugget is removed from the assigned nugget's resource users 'Assignment > Completed' nugget list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on assignment option from side menu
    And Click on the completed sub tab
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the created nugget is removed from assignment's completed nugget list

    Examples:
      | UserRoll     | endPoint              |
      | AutoResource | /assignment/completed |
      | AutoScenario | /assignment/completed |

  @regression @critical @SC @SCN @TC-SCN62
  Scenario Outline: Validate that the released sprint is not displayed on the  active nugget's sprint dropdown
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on nuggets option from side menu
    And Validate the current page URL has "<endPoint>" end point
    When Click on the create nugget button
    Then Validate the create nugget heading on open dialog box
    When Select "<Type>" nugget type from dropdown
    And Enter the nugget name on name text box
    And Select the "<ProjectName>" project from dropdown
    And Select "<Priority>" nugget priority from dropdown
    And Enter the description on description text box
    And Click on the create button
    Then Validate that the successfully created nugget toast notification message is displayed
    When Click on the sprint dropdown
    Then Validate that the released sprint is displayed on sprint dropdown list

    Examples:
      | UserRoll   | endPoint       | Type | Priority | ProjectName           |
      | scenarioTC | /nugget/unread | Bug  | Normal   | Scenario Base Project |

  @regression @critical @SC @SCN @TC-SCN63
  Scenario Outline: Validate that the audit message appears on nugget chat when nugget is moved into the archive
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on good news option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    When Click on the created nugget
    And Get the created nugget id from list
    And Click on the archive checkbox
    And Click on the save icon on backlog tab
    And Enter the nugget id on the search tab
    And Press enter key from keyboard
    Then Validate that the searched nugget is displayed on search result tab list
    When Click on the nugget chat tab
    Then Validate that the chat has displayed archive nugget audit message

    Examples:
      | UserRoll   | endPoint          |
      | scenarioTC | /good-news/triage |