Feature: Workflow Module's Test Case of Setting Menu

  @regression @dependant @setting @workflow @TC-W1
  Scenario Outline: Verify that the workflow option is not displayed on sub-menu of the settings option for common, resource, team lead, project maestro and release maestro role type user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the "Workflows" option is not displayed on the sub menu

    Examples:
      | UserRoll         | EndPoint               |
      | commonRoleUser   | /settings/user-profile |
      | resourceRoleUser | /settings/user-profile |
      | teamLeadRoleUser | /settings/user-profile |
      | PM_RoleUser      | /settings/user-profile |
      | RM_RoleUser      | /settings/user-profile |

  @regression @dependant @setting @workflow @TC-W2
  Scenario Outline: Verify that the workflow option is displayed on sub-menu of the settings option for admin role type user
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the "Workflows" option is displayed on the sub menu

    Examples:
      | UserRoll      | EndPoint               |
      | adminRoleUser | /settings/user-profile |

  @regression @setting @workflow @TC-W3
  Scenario Outline: Verify that the click functionality on the workflow option from the settings submenu
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the workflows option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new workflow button is displayed

    Examples:
      | UserRoll      | EndPoint            |
      | adminRoleUser | /settings/workflows |

  @regression @dependant @setting @workflow @TC-W4
  Scenario Outline: Verify that the click functionality on the new workflow button
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the workflows option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new workflow button is displayed
    When Click on the new workflow button
    Then Validate that the create new workflow dialog box heading is displayed

    Examples:
      | UserRoll      | EndPoint            |
      | adminRoleUser | /settings/workflows |

  @regression @setting @workflow @TC-W5
  Scenario Outline: Verify click functionality on the close icon of new workflow dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the workflows option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new workflow button is displayed
    When Click on the new workflow button
    And Click on the close icon
    Then Validate that the create new workflow dialog box is closed

    Examples:
      | UserRoll      | EndPoint            |
      | adminRoleUser | /settings/workflows |

  @regression @dependant @setting @workflow @TC-W6
  Scenario Outline: Verify that the create button is disabled until the user does not fill up the required field on create workflow dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the workflows option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new workflow button is displayed
    When Click on the new workflow button
    Then Validate that the create button is disabled
    When Enter "<WorkflowName>" on the workflow name text box
    Then Validate that the create button is Enable

    Examples:
      | UserRoll      | EndPoint            | WorkflowName  |
      | adminRoleUser | /settings/workflows | Auto Workflow |

  @regression @dependant @setting @workflow @TC-W7
  Scenario Outline: Verify that the user can not enter more than 50 characters on the name text box of the 'Create The New Workflow' dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the workflows option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new workflow button is displayed
    When Click on the new workflow button
    And Enter "<WorkflowName>" on the workflow name text box
    Then Validate that the length validation message is displayed

    Examples:
      | UserRoll      | EndPoint            | WorkflowName                                                |
      | adminRoleUser | /settings/workflows | Auto The Name on the text box of Create Workflow Dialog box |

  @regression @critical @dependant @setting @workflow @TC-W8
  Scenario Outline: Verify that the user can create the new workflow with the required field
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the workflows option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new workflow button is displayed
    When Click on the new workflow button
    And Enter "<WorkflowName>" on the workflow name text box
    And Click on the create button
    Then Validate that the validation toast message appears with "<Message>"
    And Validate that the created workflow name is displayed on the list and highlighted
    When Deactivate the created workflow

    Examples:
      | UserRoll      | EndPoint            | WorkflowName   | Message                       |
      | adminRoleUser | /settings/workflows | AAuto Workflow | Successfully created workflow |

  @regression @critical @dependant @setting @workflow @TC-W9
  Scenario Outline: Verify that the user can create the new workflow with the all the field
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the workflows option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new workflow button is displayed
    When Click on the new workflow button
    And Enter "<WorkflowName>" on the workflow name text box
    And Enter the description on the text box
    And Click on the create button
    Then Validate that the validation toast message appears with "<Message>"
    And Validate that the created workflow name is displayed on the list and highlighted

    Examples:
      | UserRoll      | EndPoint            | WorkflowName   | Message                       |
      | adminRoleUser | /settings/workflows | AAuto Workflow | Successfully created workflow |

  @regression @setting @workflow @TC-W10
  Scenario Outline: Verify that the save button is enabled after updating the workflow name on the workflow edit section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the workflows option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created workflow from list
    Then Validate that the save button is disabled
    When Update "<WorkflowName>" the workflow name
    Then Validate that the save button is enabled

    Examples:
      | UserRoll      | EndPoint            | WorkflowName          |
      | adminRoleUser | /settings/workflows | AAuto Update Workflow |

  @regression @setting @workflow @TC-W11
  Scenario Outline: Verify that the save button is enabled after updating the description on the workflow edit section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the workflows option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created workflow from list
    Then Validate that the save button is disabled
    When Update "<WorkflowDescription>" the workflow description
    Then Validate that the save button is enabled

    Examples:
      | UserRoll      | EndPoint            | WorkflowDescription               |
      | adminRoleUser | /settings/workflows | AAuto Update Workflow Description |

  @regression @dependant @setting @workflow @TC-W12
  Scenario Outline: Verify that the user can not enter more than 50 characters on the name text box of the 'Edit Workflow' section
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the workflows option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created workflow from list
    Then Validate that the save button is disabled
    When Update "<WorkflowName>" the workflow name
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll      | EndPoint            | WorkflowName                                            | Message                                   |
      | adminRoleUser | /settings/workflows | Auto The Name on the text box of edit workflow text box | At Most 50 Characters Are Valid For Title |

  @regression @dependant @setting @workflow @TC-W13
  Scenario Outline: Verify that the user can update the workflow name
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the workflows option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created workflow from list
    Then Validate that the save button is disabled
    When Update "<WorkflowName>" the workflow name
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll      | EndPoint            | WorkflowName           | Message                       |
      | adminRoleUser | /settings/workflows | AAAuto Update Workflow | Successfully updated workflow |

  @regression @dependant @setting @workflow @TC-W14
  Scenario Outline: Verify that the user can update the workflow description
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the workflows option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created workflow from list
    Then Validate that the save button is disabled
    When Update "<WorkflowDescription>" the workflow description
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll      | EndPoint            | WorkflowDescription               | Message                       |
      | adminRoleUser | /settings/workflows | AAuto Update Workflow Description | Successfully updated workflow |

  @regression @critical @dependant @setting @workflow @TC-W15
  Scenario Outline: Verify that the user can not create a duplicate workflow
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the workflows option
    Then Validate the current page URL has "<EndPoint>" end point
    And Validate that the new workflow button is displayed
    When Click on the new workflow button
    And Enter workflow name which is already existing on the list
    And Click on the create button
    Then Validate that the validation toast message appears with "<Message>"

    Examples:
      | UserRoll      | EndPoint            | Message          |
      | adminRoleUser | /settings/workflows | Repetitive Title |

  @regression @critical @dependant @setting @workflow @TC-W16
  Scenario Outline: Verify that the click functionality on add phase icon
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the workflows option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created workflow from list
    Then Validate that the add phase icon is displayed
    When Click on the add phase icon on the edit workflow section
    Then Validate that the Add Phase To Workflow dialog box heading is displayed

    Examples:
      | UserRoll      | EndPoint            |
      | adminRoleUser | /settings/workflows |

  @regression @setting @workflow @TC-W17
  Scenario Outline: Verify that the click functionality on the close icon of 'Add Phase To Workflow' dialog box
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the workflows option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created workflow from list
    Then Validate that the add phase icon is displayed
    When Click on the add phase icon on the edit workflow section
    And Click on the close icon
    Then Validate that the Add Phase To Workflow dialog box is closed

    Examples:
      | UserRoll      | EndPoint            |
      | adminRoleUser | /settings/workflows |

  @regression @dependant @setting @workflow @TC-W18
  Scenario Outline: Verify that the add phase button is disabled until the required field is not fillup
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the workflows option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created workflow from list
    Then Validate that the add phase icon is displayed
    When Click on the add phase icon on the edit workflow section
    Then Validate that the add button is disabled
    When Select the phase from the dropdown
    Then Validate that the add button is Enable

    Examples:
      | UserRoll      | EndPoint            |
      | adminRoleUser | /settings/workflows |

  @regression @critical @dependant @setting @workflow @TC-W19
  Scenario Outline: Verify that the user can add phase on the created workflow
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the workflows option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created workflow from list
    Then Validate that the add phase icon is displayed
    When Click on the add phase icon on the edit workflow section
    Then Validate that the Add Phase To Workflow dialog box heading is displayed
    When Select the phase from the dropdown
    And Click on the add button
    Then Validate that the validation toast message appears with "<Message>"
    And Validate that the added phase is displayed on the list

    Examples:
      | UserRoll      | EndPoint            | Message            |
      | adminRoleUser | /settings/workflows | Successfully added |

  @regression @critical @dependant @setting @workflow @TC-W20
  Scenario Outline: Verify that the user can removed phase from the workflow
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the workflows option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created workflow from list
    Then Validate that the added phase is displayed on the list
    When Remove the selected phase
    Then Validate that the validation toast message appears with "<Message>"
    And Validate that the phase is removed from the list

    Examples:
      | UserRoll      | EndPoint            | Message              |
      | adminRoleUser | /settings/workflows | Successfully removed |

  @regression @dependant @setting @workflow @TC-W21
  Scenario Outline: Verify that the user can add the multiple phases on the created workflow
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the workflows option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created workflow from list
    Then Validate that the add phase icon is displayed
    When Click on the add phase icon on the edit workflow section
    Then Validate that the Add Phase To Workflow dialog box heading is displayed
    When Select the multiple phase from the dropdown
    And Click on the add button
    Then Validate that the validation toast message appears with "<Message>"
    And Validate that the added phase is displayed on the list

    Examples:
      | UserRoll      | EndPoint            | Message            |
      | adminRoleUser | /settings/workflows | Successfully added |

  @regression @critical @dependant @setting @workflow @TC-W22
  Scenario Outline: Verify that the user can deactivate the workflow
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the workflows option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the created workflow from list
    And Click on the deactivate workflow check box
    And Click on the save button
    #Then Validate that the validation toast message appears with "<Message>"
    And Remove the active filter from inactive column
    And Apply the inactive filter on inactive column
    Then Validate that the deactivate workflow is displayed on the list

    Examples:
      | UserRoll      | EndPoint            | Message                       |
      | adminRoleUser | /settings/workflows | Workflow successfully updated |

  @regression @setting @workflow @TC-W23
  Scenario Outline: Verify that the user can activate the workflow
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the setting option from side menu
    And Click on the workflows option
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the first workflow from the list
    And Remove the active filter from inactive column
    And Click on the created workflow from list
    And Click on the deactivate workflow check box
    And Click on the save button
    Then Validate that the validation toast message appears with "<Message>"
    #And Validate that the deactivate phase is removed from the list
    When Click on the deactivate workflow check box
    And Click on the save button
    And Wait for "2" sec

    Examples:
      | UserRoll      | EndPoint            | Message                       |
      | adminRoleUser | /settings/workflows | Successfully updated workflow |