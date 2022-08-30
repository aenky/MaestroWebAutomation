Feature: Scenario Based Test Cases of Channel and People

  @regression @critical @SC @SCC @TC-SC01 @TC-SC02
  Scenario Outline: Verify that the badge count is increased on the channel option of the navigation menu when someone sends a message on the channel
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Get the channel icon badge count
    And Open new browser and open maestro website
    When Login with the "<NewUserRoll>" role user credentials
    And Click on the login button
    Then Validate that the side menu is displayed
    When Click on channel option from side menu
    When Click on the "<ChannelName>" channel from the list
    And Enter "<Message>" on the chat input field
    And Click on the send icon
    Then Validate the sent message is displayed on the chat section
    When Close the newly opened browser
    Then Validate that the channel icon badge count is increased

    Examples:
      | UserRoll   | NewUserRoll | EndPoint | ChannelName      | Message           |
      | scenarioQA | scenarioTC  | /groups  | channel QA       | Auto channel Test |
      | scenarioQA | scenarioTC  | /groups  | Scenario Private | Auto channel Test |


  @regression @critical @SC @SCC @TC-SC03 @TC-SC04
  Scenario Outline: Verify that the badge count is increased on the channel name on the channel list section when someone sends a message on the channel
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Get the "<ChannelName>" channel badge count
    And Open new browser and open maestro website
    When Login with the "<NewUserRoll>" role user credentials
    And Click on the login button
    Then Validate that the side menu is displayed
    When Click on channel option from side menu
    When Click on the "<ChannelName>" channel from the list
    And Enter "<Message>" on the chat input field
    And Click on the send icon
    Then Validate the sent message is displayed on the chat section
    When Close the newly opened browser
    Then Validate that the "<ChannelName>" channel badge count is increased

    Examples:
      | UserRoll   | NewUserRoll | EndPoint | ChannelName      | Message           |
      | scenarioQA | scenarioTC  | /groups  | channel QA       | Auto channel Test |
      | scenarioQA | scenarioTC  | /groups  | Scenario Private | Auto channel Test |

  @regression @critical @SC @SCC @TC-SC05
  Scenario Outline: Verify that the badge count of the channel icon on the side navigation menu is the same as the total number of badge count on the channel name list
    Given Open new browser and open maestro website
    When Login with the "<NewUserRoll>" role user credentials
    And Click on the login button
    Then Validate that the side menu is displayed
    When Click on channel option from side menu
    And Click on the "<ChannelName>" channel from the list
    And Enter "<Message>" on the chat input field
    And Click on the send icon
    Then Validate the sent message is displayed on the chat section
    When Close the newly opened browser
    And I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Get the channel icon badge count
    And Get the total number of badge count from the channel list
    Then Validate that the channel icon badge count and total badge count of the channel name are the same

    Examples:
      | UserRoll   | NewUserRoll | EndPoint | ChannelName     | Message           |
      | scenarioQA | scenarioTC  | /groups  | Scenario Public | Auto channel Test |

  @regression @SC @SCC @TC-SC06
  Scenario Outline: Verify that the only reply option is displayed on the message more option list after reading the channel's message
    Given Open new browser and open maestro website
    When Login with the "<NewUserRoll>" role user credentials
    And Click on the login button
    Then Validate that the side menu is displayed
    When Click on channel option from side menu
    When Click on the "<ChannelName>" channel from the list
    And Enter "<Message>" on the chat input field
    And Click on the send icon
    Then Validate the sent message is displayed on the chat section

    When I open Maestro website
    And Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the "<ChannelName>" channel from the channel list

    Then Validate that the sent message more option has only the reply option
    When Close the newly opened browser

    Examples:
      | UserRoll   | NewUserRoll | EndPoint | ChannelName     | Message           |
      | scenarioQA | scenarioTC  | /groups  | Scenario Public | Auto channel Test |

  @regression @SC @SCC @TC-SC07
  Scenario Outline: Verify that the two right icons are displayed after reading the channel message
    Given Open new browser and open maestro website
    When Login with the "<NewUserRoll>" role user credentials
    And Click on the login button
    Then Validate that the side menu is displayed
    When Click on channel option from side menu
    When Click on the "<ChannelName>" channel from the list
    And Enter "<Message>" on the chat input field
    And Click on the send icon
    Then Validate the sent message is displayed on the chat section

    When I open Maestro website
    And Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the "<ChannelName>" channel from the channel list

    Then Validate that the two right icon is displayed on read message
    And Validate that the two right icon color code is "<ColorCode>"
    When Close the newly opened browser

    Examples:
      | UserRoll   | NewUserRoll | EndPoint | ChannelName     | Message           | ColorCode |
      | scenarioQA | scenarioTC  | /groups  | Scenario Public | Auto channel Test | #1e90ff   |

  @regression @SC @SCC @TC-SC08
  Scenario Outline: Verify that the list of users is displayed who have read the channel message
    Given Open new browser and open maestro website
    When Login with the "<NewUserRoll>" role user credentials
    And Click on the login button
    Then Validate that the side menu is displayed
    When Click on channel option from side menu
    When Click on the "<ChannelName>" channel from the list
    And Enter "<Message>" on the chat input field
    And Click on the send icon
    Then Validate the sent message is displayed on the chat section

    When I open Maestro website
    And Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the "<ChannelName>" channel from the channel list

    Then Validate that the two right icon is displayed on read message
    When Move cursor on the seen message icon
    Then Validate that the seen user list popper is displayed
    When Close the newly opened browser

    Examples:
      | UserRoll   | NewUserRoll | EndPoint | ChannelName     | Message           |
      | scenarioQA | scenarioTC  | /groups  | Scenario Public | Auto channel Test |

  @regression @critical @SC @SCC @TC-SC09
  Scenario Outline: Verify that the badge count on the channel name is removed when the user reads the message of the channel
    Given Open new browser and open maestro website
    When Login with the "<NewUserRoll>" role user credentials
    And Click on the login button
    Then Validate that the side menu is displayed
    When Click on channel option from side menu
    When Click on the "<ChannelName>" channel from the list
    And Enter "<Message>" on the chat input field
    And Click on the send icon
    Then Validate the sent message is displayed on the chat section
    When Close the newly opened browser

    And I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Get the "<ChannelName>" channel badge count
    And Click on the "<ChannelName>" channel from the channel list
    Then Validate that the "<ChannelName>" channel badge count is removed

    Examples:
      | UserRoll   | NewUserRoll | EndPoint | ChannelName | Message           |
      | scenarioQA | scenarioTC  | /groups  | channel QA  | Auto channel Test |


  @regression @critical @SC @SCC @TC-SC10
  Scenario Outline: Verify that the badge count on the channel icon option of the navigation menu is decreased when the user reads the message of the channel
    Given Open new browser and open maestro website
    When Login with the "<NewUserRoll>" role user credentials
    And Click on the login button
    Then Validate that the side menu is displayed
    When Click on channel option from side menu
    When Click on the "<ChannelName>" channel from the list
    And Enter "<Message>" on the chat input field
    And Click on the send icon
    Then Validate the sent message is displayed on the chat section
    When Close the newly opened browser

    And I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on the channel option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Get the channel icon badge count
    And Click on the "<ChannelName>" channel from the channel list
    Then Validate that the channel icon badge count is decreased

    Examples:
      | UserRoll   | NewUserRoll | EndPoint | ChannelName | Message           |
      | scenarioQA | scenarioTC  | /groups  | channel QA  | Auto channel Test |

  @regression @critical @SC @SCC @TC-SC11
  Scenario Outline: Verify that the badge count is increased on the people option of the navigation menu when someone sends a message on a personal chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Get the people icon badge count
    And Open new browser and open maestro website
    When Login with the "<NewUserRoll>" role user credentials
    And Click on the login button
    Then Validate that the side menu is displayed
    When Click on the people option from side menu
    When Click on the "<UserName>" user name from the list
    And Enter "<Message>" on the chat input field
    And Click on the send icon
    Then Validate the sent message is displayed on the chat section
    When Close the newly opened browser
    Then Validate that the people icon badge count is increased

    Examples:
      | UserRoll   | NewUserRoll | EndPoint | UserName      | Message          |
      | scenarioQA | scenarioTC  | /people  | Auto Scenario | Auto People Test |

  @regression @critical @SC @SCC @TC-SC12
  Scenario Outline: Verify that the badge count is increased on the people name of the people list when someone sends a message on a personal chat
    Given I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Get the "<UserName>" people badge count
    And Open new browser and open maestro website
    When Login with the "<NewUserRoll>" role user credentials
    And Click on the login button
    Then Validate that the side menu is displayed
    When Click on the people option from side menu
    When Click on the "Auto Scenario" user name from the list
    And Enter "<Message>" on the chat input field
    And Click on the send icon
    Then Validate the sent message is displayed on the chat section
    When Close the newly opened browser
    Then Validate that the "<UserName>" channel badge count is increased

    Examples:
      | UserRoll   | NewUserRoll   | EndPoint | UserName       | Message          |
      | scenarioQA | adminRoleUser | /people  | AutoAdmin User | Auto People Test |


  @regression @critical @SC @SCC @TC-SC13
  Scenario Outline: Verify that the badge count of the people icon on the navigation menu is the same as the total number of badge count on the ueser name list
    Given Open new browser and open maestro website
    When Login with the "<NewUserRoll>" role user credentials
    And Click on the login button
    Then Validate that the side menu is displayed
    When Click on the people option from side menu
    When Click on the "<UserName>" user name from the list
    And Enter "<Message>" on the chat input field
    And Click on the send icon
    Then Validate the sent message is displayed on the chat section
    When Close the newly opened browser

    And I open Maestro website
    And Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Get the people icon badge count
    And Get the total number of badge count from the people list
    Then Validate that the people icon badge count and total badge count of the people name are the same

    Examples:
      | UserRoll   | NewUserRoll   | EndPoint | UserName      | Message          |
      | scenarioQA | adminRoleUser | /people  | Auto Scenario | Auto People Test |

  @regression @SC @SCC @TC-SC14
  Scenario Outline: Verify that the only reply option is displayed on the message more option list after reading the personal chat message
    Given Open new browser and open maestro website
    When Login with the "<NewUserRoll>" role user credentials
    And Click on the login button
    Then Validate that the side menu is displayed
    When Click on the people option from side menu
    When Click on the "Auto Scenario" user name from the list
    And Enter "<Message>" on the chat input field
    And Click on the send icon
    Then Validate the sent message is displayed on the chat section

    When I open Maestro website
    And Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Click on the "<UserName>" people from the people list

    Then Validate that the sent message more option has only the reply option
    When Close the newly opened browser

    Examples:
      | UserRoll   | NewUserRoll   | EndPoint | UserName       | Message          |
      | scenarioQA | adminRoleUser | /people  | AutoAdmin User | Auto People Test |

  @regression @critical @SC @SCC @TC-SC15
  Scenario Outline: Verify that the badge count on the people's names is removed when the user reads the that user's message
    Given Open new browser and open maestro website
    When Login with the "<NewUserRoll>" role user credentials
    And Click on the login button
    Then Validate that the side menu is displayed
    When Click on the people option from side menu
    When Click on the "<UserName>" channel from the list
    And Enter "<Message>" on the chat input field
    And Click on the send icon
    Then Validate the sent message is displayed on the chat section
    When Close the newly opened browser

    And I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Get the "Auto QAS" people badge count
    And Click on the "Auto QAS" people from the people list
    Then Validate that the "Auto QAS" people badge count is removed

    Examples:
      | UserRoll      | NewUserRoll | EndPoint | UserName       | Message          |
      | adminRoleUser | scenarioTC  | /people  | AutoAdmin User | Auto People Test |

  @regression @critical @SC @SCC @TC-SC16
  Scenario Outline: Verify that the badge count on the people icon option of the navigation menu is decreased when the user reads the message of the users personal message
    Given Open new browser and open maestro website
    When Login with the "<NewUserRoll>" role user credentials
    And Click on the login button
    Then Validate that the side menu is displayed
    When Click on the people option from side menu
    When Click on the "<UserName>" channel from the list
    And Enter "<Message>" on the chat input field
    And Click on the send icon
    Then Validate the sent message is displayed on the chat section
    When Close the newly opened browser

    And I open Maestro website
    When Login with "<UserRoll>" role user credentials
    And Click on login button
    Then Validate the side menu is displayed
    When Click on people option from side menu
    Then Validate the current page URL has "<EndPoint>" end point
    When Get the people icon badge count
    And Click on the "AutoAdmin User" people from the people list
    Then Validate that the people icon badge count is decreased

    Examples:
      | UserRoll   | NewUserRoll   | EndPoint | UserName | Message          |
      | scenarioTC | adminRoleUser | /people  | Auto QAS | Auto People Test |