Feature: Release Module Test Case

  @regression @release @TC-R1
  Scenario Outline: Verify that the release module sub-tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate the active releases tab is displayed on top menu
    And Validate that the released sub tab is displayed on top menu

    Examples:
      | UserRoll    | endPoint         |
      | allRoleUser | /releases/active |

  @regression @release @TC-R2
  Scenario Outline: Verify that the active sub-tab is by default selected
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the active sub tab is selected
    And Validate that the selected sub tab text color is "<ColorCode>"

    Examples:
      | UserRoll    | endPoint         | ColorCode |
      | allRoleUser | /releases/active | #1e90ff   |

  @regression @release @TC-R3 @TC-R4
  Scenario Outline: Verify that the active sub-tab is by default selected
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    And Click on the "<SubTab>" sub-tab
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the "ID" Header is displayed
    And Validate that the "Name" Header is displayed
    And Validate that the "Tempo" Header is displayed
    And Validate that the "Release Date" Header is displayed
    And Validate that the "Release Cutoff" Header is displayed
    And Validate that the "Alert" Header is displayed
    And Validate that the "Release Maestro" Header is displayed
    And Validate that the "Secondary Maestro" Header is displayed

    Examples:
      | UserRoll    | endPoint           | SubTab   |
      | allRoleUser | /releases/active   | Active   |
      | allRoleUser | /releases/released | Released |

  @regression @release @TC-R5 @TC-R6
  Scenario Outline: Verify the list of data in the active and released sub-tab table
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    And Click on the "<SubTab>" sub-tab
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the released list is displayed or empty list message

    Examples:
      | UserRoll    | endPoint           | SubTab   |
      | allRoleUser | /releases/active   | Active   |
      | allRoleUser | /releases/released | Released |

  @regression @release @TC-R7
  Scenario Outline: Verify the released sub-tab table has only displayed released tempo on list
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    And Click on the "<SubTab>" sub-tab
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the released list has only seen released tempo

    Examples:
      | UserRoll    | endPoint           | SubTab   |
      | allRoleUser | /releases/released | Released |

  @regression @release @TC-R8
  Scenario Outline: Validate that the create release button is displayed on the release tab only for release maestro user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the create release button is displayed

    Examples:
      | UserRoll    | endPoint         |
      | RM_RoleUser | /releases/active |

  @regression @release @TC-R9
  Scenario Outline: Validate that the create release button is not displayed on the release tab of other user roles
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the create release button is not displayed

    Examples:
      | UserRoll         | endPoint         |
      | resourceRoleUser | /releases/active |
      | teamLeadRoleUser | /releases/active |
      | PM_RoleUser      | /releases/active |

  @regression @release @TC-R10
  Scenario Outline: Validate that the Chat tab, Details tab and Attachment tab is displayed on the right side section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the release details section has displayed the chat tab
    And Validate that the release details section has displayed the details tab
    And Validate that the release details section has displayed the attachment tab

    Examples:
      | UserRoll    | endPoint         |
      | allRoleUser | /releases/active |

  @regression @release @TC-R11
  Scenario Outline: Validate that the click functionality on the chat tab icon
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the release details section has displayed the chat tab
    When Click on the release chat tab
    Then Validate that the input message field is displayed
    And Validate that send message icon is displayed

    Examples:
      | UserRoll    | endPoint         |
      | allRoleUser | /releases/active |

  @regression @release @TC-R12
  Scenario Outline: Validate that the click functionality on the release details tab icon
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the release details section has displayed the chat tab
    When Click on the release details tab
    Then Validate that the system is displayed the release details section

    Examples:
      | UserRoll    | endPoint         |
      | allRoleUser | /releases/active |


  @regression @release @TC-R13
  Scenario Outline: Validate that the click functionality on the attachment tab icon
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the release details section has displayed the chat tab
    When Click on the release attachment tab
    Then Validate that the system is displayed the release chat attachment section

    Examples:
      | UserRoll    | endPoint         |
      | allRoleUser | /releases/active |

  @regression @release @TC-R14
  Scenario Outline: Verify that the click functionality on the create release button
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the create release button is displayed
    When Click on the create release button
    Then Validate that the create release dialog box is open

    Examples:
      | UserRoll    | endPoint         |
      | allRoleUser | /releases/active |

  @regression @release @TC-R15
  Scenario Outline: Verify that the all field on create release dialog box is displayed
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the create release button is displayed
    When Click on the create release button
    Then Validate that the create release dialog box is open
    And Validate the release name field is displayed
    And Validate the release date field is displayed
    And Validate the release cutoff field is displayed
    And Validate the release maestro dropdown is displayed
    And Validate the secondary maestro dropdown is displayed
    And Validate the description field is displayed

    Examples:
      | UserRoll    | endPoint         |
      | allRoleUser | /releases/active |

  @regression @release @TC-R16
  Scenario Outline: Verify that the click functionality on the close icon of create the release dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the create release button is displayed
    When Click on the create release button
    Then Validate that the create release dialog box is open
    When Click on the close icon of open dialog box
    Then Validate that the create release dialog box is closed

    Examples:
      | UserRoll    | endPoint         |
      | allRoleUser | /releases/active |

  @regression @critical @release @TC-R17
  Scenario Outline: Verify that the 'create' button is disabled until all required field is filled up
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the create release button is displayed
    When Click on the create release button
    Then Validate that the create release dialog box is open
    And Validate that the create button is disabled
    When Enter the release name
    Then Validate that the create button is disabled
    When Select the release date
    Then Validate that the create button is disabled
    When select the release cutoff date
    Then Validate that the create button is disabled
    When Select the release maestro from dropdown
    Then Validate that the create button is Enable

    Examples:
      | UserRoll    | endPoint         |
      | allRoleUser | /releases/active |

  @regression @critical @release @TC-R18
  Scenario Outline: Verify that the user can create a release with all fields on the release dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the create release button is displayed
    When Click on the create release button
    Then Validate that the create release dialog box is open
    When Enter the release name
    And Select the release date
    And select the release cutoff date
    And Select the release maestro from dropdown
    And Select secondary maestro from dropdown
    And Enter the description on the text box
    Then Validate that the create button is Enable
    When Click on the create button
    Then Validate the successfully created release toast notification message is displayed
    And Validate that the created release is displayed in the List
    And Validate that the created release is highlighted in the List
    When Click on the release details tab
    And Change the release cutoff date with current date
    And Change the release date with current date
    And Click on the save button
    Then Validate that the complete check box is displayed
    And Click on the complete check box
    And Click on the OK button
    Then Validate that the completed release is removed from the list

    Examples:
      | UserRoll    | endPoint         |
      | allRoleUser | /releases/active |


  @regression @release @TC-R19
  Scenario Outline: Verify that the user can create a release with only the required field on the release dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the create release button is displayed
    When Click on the create release button
    Then Validate that the create release dialog box is open
    When Enter the release name
    And Select the release date
    And select the release cutoff date
    And Select the release maestro from dropdown
    Then Validate that the create button is Enable
    When Click on the create button
    Then Validate the successfully created release toast notification message is displayed
    And Validate that the created release is displayed in the List
    And Validate that the created release is highlighted in the List

    Examples:
      | UserRoll    | endPoint         |
      | allRoleUser | /releases/active |

  @regression @critical @release @TC-R20
  Scenario Outline: Verify that the user is able to send the message on the release chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    When Click on the created release from list
    And Click on the release chat tab
    Then Validate that the input message field is displayed
    When Enter "<Message>" on chat input field
    And Click on the send button
    Then Validate that the sent message is displayed on chat section

    Examples:
      | UserRoll    | endPoint         | Message      |
      | allRoleUser | /releases/active | Auto testing |

  @regression @critical @release @TC-R21
  Scenario Outline: Verify that the user can change the release name on the active tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    When Click on the created release from list
    And Click on the release details tab
    Then Validate that the system is displayed the release details section
    When Change the release name
    And Click on the save button
    Then Validate the successfully update the release toast notification message is displayed
    And Validate that the release name is updated on the list

    Examples:
      | UserRoll    | endPoint         |
      | allRoleUser | /releases/active |

  @regression @critical @release @TC-R22
  Scenario Outline: Verify that the user can change the release date on the active tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    When Click on the created release from list
    And Click on the release details tab
    Then Validate that the system is displayed the release details section
    When Change the release date
    And Click on the save button
    Then Validate the successfully update the release toast notification message is displayed
    #And Validate that the release date is updated on the list

    Examples:
      | UserRoll    | endPoint         |
      | allRoleUser | /releases/active |

  @regression @critical @release @TC-R23
  Scenario Outline: Verify that the user can change the release cutoff date on the active tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    When Click on the created release from list
    And Click on the release details tab
    Then Validate that the system is displayed the release details section
    When Change the release cutoff date
    And Click on the save button
    Then Validate the successfully update the release toast notification message is displayed
    #And Validate that the release date is updated on the list

    Examples:
      | UserRoll    | endPoint         |
      | allRoleUser | /releases/active |


  @regression @release @TC-R24
  Scenario Outline: Verify that the user can change the release maestro on the active tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    When Click on the created release from list
    And Click on the release details tab
    Then Validate that the system is displayed the release details section
    When Change the release maestro from dropdown
    And Click on the save button
    Then Validate the successfully update the release toast notification message is displayed
    And Validate that the release maestro is updated on the list

    Examples:
      | UserRoll    | endPoint         |
      | allRoleUser | /releases/active |

  @regression @release @TC-R25
  Scenario Outline: Verify that the user can change the secondary maestro on the active tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    When Click on the created release from list
    And Click on the release details tab
    Then Validate that the system is displayed the release details section
    When Change the secondary maestro
    And Click on the save button
    Then Validate the successfully update the release toast notification message is displayed
    And Validate that the release secondary maestro is updated on the list

    Examples:
      | UserRoll    | endPoint         |
      | allRoleUser | /releases/active |

  @regression @release @TC-R26
  Scenario Outline: Verify that the user can change the release description on the active tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    When Click on the created release from list
    And Click on the release details tab
    Then Validate that the system is displayed the release details section
    When Change the release description
    And Click on the save button
    Then Validate the successfully update the release toast notification message is displayed

    Examples:
      | UserRoll    | endPoint         |
      | allRoleUser | /releases/active |

  @regression @release @TC-R27
  Scenario Outline: Verify that the user can change the release name on the released tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    And Click on the "<SubTab>" sub-tab
    Then Validate the current page URL has "<endPoint>" end point
    When Click on the first release from the list
    When Click on the release details tab
    Then Validate that the system is displayed the release details section
    When Change the released name
    And Click on the save button
    Then Validate the successfully update the release toast notification message is displayed
    And Validate that the release name is updated on the list

    Examples:
      | UserRoll    | endPoint           | SubTab   |
      | allRoleUser | /releases/released | Released |

  @regression @release @TC-R28
  Scenario Outline: Verify that the release date field is disabled on the release tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    And Click on the "<SubTab>" sub-tab
    Then Validate the current page URL has "<endPoint>" end point
    When Click on the first release from the list
    When Click on the release details tab
    Then Validate that the system is displayed the release details section
    And Validate that the release date field is disabled

    Examples:
      | UserRoll    | endPoint           | SubTab   |
      | allRoleUser | /releases/released | Released |

  @regression @release @TC-R29
  Scenario Outline: Verify that the release cutoff date field is disabled on the release tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    And Click on the "<SubTab>" sub-tab
    Then Validate the current page URL has "<endPoint>" end point
    When Click on the first release from the list
    When Click on the release details tab
    Then Validate that the system is displayed the release details section
    And Validate that the release cutoff date field is disabled

    Examples:
      | UserRoll    | endPoint           | SubTab   |
      | allRoleUser | /releases/released | Released |

  @regression @release @TC-R30
  Scenario Outline: Verify that the user can change the release maestro on the released tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    And Click on the "<SubTab>" sub-tab
    Then Validate the current page URL has "<endPoint>" end point
    When Click on the first release from the list
    When Click on the release details tab
    Then Validate that the system is displayed the release details section
    When Change the release maestro from dropdown
    And Click on the save button
    Then Validate the successfully update the release toast notification message is displayed
    And Validate that the release maestro is updated on the list

    Examples:
      | UserRoll    | endPoint           | SubTab   |
      | allRoleUser | /releases/released | Released |

  @regression @release @TC-R31
  Scenario Outline: Verify that the user can change the secondary maestro on the released tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    And Click on the "<SubTab>" sub-tab
    Then Validate the current page URL has "<endPoint>" end point
    When Click on the first release from the list
    When Click on the release details tab
    Then Validate that the system is displayed the release details section
    When Change the secondary maestro
    And Click on the save button
    Then Validate the successfully update the release toast notification message is displayed
    And Validate that the release secondary maestro is updated on the list

    Examples:
      | UserRoll    | endPoint           | SubTab   |
      | allRoleUser | /releases/released | Released |

  @regression @release @TC-R32
  Scenario Outline: Verify that the user can change the release description on the released tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    And Click on the "<SubTab>" sub-tab
    Then Validate the current page URL has "<endPoint>" end point
    When Click on the first release from the list
    When Click on the release details tab
    Then Validate that the system is displayed the release details section
    When Change the release description
    And Click on the save button
    Then Validate the successfully update the release toast notification message is displayed

    Examples:
      | UserRoll    | endPoint           | SubTab   |
      | allRoleUser | /releases/released | Released |

  @regression @release @TC-R33 @TC-R34 @TC-R35
  Scenario Outline: Verify that the resource edit field is disabled for other roles type user on the active tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    When Click on the first release from the list
    When Click on the release details tab
    Then Validate that the system is displayed the release details section
    And Validate that all fields are disabled

    Examples:
      | UserRoll         | endPoint         |
      | resourceRoleUser | /releases/active |
      | teamLeadRoleUser | /releases/active |
      | PM_RoleUser      | /releases/active |

  @regression @release @TC-R36 @TC-R37 @TC-R38
  Scenario Outline: Verify that the resource edit field is disabled for other roles type user on the released tab
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    And Click on the "<SubTab>" sub-tab
    Then Validate the current page URL has "<endPoint>" end point
    When Click on the first release from the list
    When Click on the release details tab
    Then Validate that the system is displayed the release details section
    And Validate that all fields are disabled

    Examples:
      | UserRoll         | endPoint           | SubTab   |
      | resourceRoleUser | /releases/released | Released |
      | teamLeadRoleUser | /releases/released | Released |
      | PM_RoleUser      | /releases/released | Released |

  @regression @release @TC-R39
  Scenario Outline: Validate that the user is not able to update release date less than release cutoff date
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    When Click on the created release from list
    When Click on the release details tab
    Then Validate that the system is displayed the release details section
    When Change the release date lass than cutoff date
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll    | endPoint         | Message                                       |
      | allRoleUser | /releases/active | The Launch Date Must Greater Than Cutoff Date |

  @regression @release @TC-R40
  Scenario Outline: Validate that the empty space is not allowed on the release name field of the release dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the create release button is displayed
    When Click on the create release button
    Then Validate that the create release dialog box is open
    When Enter empty space on the release name
    Then Validate the required field validation message displayed on name field

    Examples:
      | UserRoll    | endPoint         |
      | allRoleUser | /releases/active |

  @regression @release @TC-R41
  Scenario Outline: Validate that the text length validation on the release name field of release dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    And Validate that the create release button is displayed
    When Click on the create release button
    Then Validate that the create release dialog box is open
    When Enter more than 128 characters on the release name
    Then Validate that the length validation message "<Message>" appears on name field

    Examples:
      | UserRoll    | endPoint         | Message                                         |
      | allRoleUser | /releases/active | This field must be at most 128 characters long. |

  @regression @release @TC-R42
  Scenario Outline: Validate that the complete check box and preflight button is displayed on the release details section of that release whose release date is on past or the current date
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on Releases option from side menu
    Then Validate the current page URL has "<endPoint>" end point
    When Click on the created release from list
    And Click on the release details tab
    Then Validate that the system is displayed the release details section
    When Change the release cutoff date with current date
    And Change the release date with current date
    And Click on the save button
    Then Validate that the complete check box is displayed
    And Validate that the preflight button is displayed

    Examples:
      | UserRoll    | endPoint         |
      | allRoleUser | /releases/active |

  @regression @release @TC-R43
  Scenario Outline: Verify that the user can complete the release
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

    Examples:
      | UserRoll   | endPoint         |
      | scenarioQA | /releases/active |

