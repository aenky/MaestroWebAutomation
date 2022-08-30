Feature: Login Module Test Case

  @regression @login @TC1
  Scenario: Verify the login button is disabled when the email and password fields are blank
    Given I open Maestro website
    Then Validate the login button is disable


  @regression @login @TC2
  Scenario Outline: Verify the login button is disabled when the password fields is blank
    Given I open Maestro website
    When Enter user email "<UserEmail>"
    Then Validate the login button is disable

    Examples:
      | UserEmail             |
      | qatest016@yopmail.com |

  @regression @login @TC3
  Scenario Outline: Verify the login button is disabled when the email fields are blank
    Given I open Maestro website
    When Enter user password "<Password>"
    Then Validate the login button is disable

    Examples:
      | Password    |
      | QAtest@2020 |

  @regression @login @TC4
  Scenario Outline: Verify the login button is enable after enter the email and password
    Given I open Maestro website
    When Enter user email "<UserEmail>"
    When Enter user password "<Password>"
    Then Validate the login button is enable

    Examples:
      | UserEmail             | Password    |
      | qatest016@yopmail.com | QAtest@2020 |

  @regression @login @TC5
  Scenario Outline: Verify validation message when user enter the invalid email format on login page.
    Given I open Maestro website
    When Enter user email "<InvalidEmailFormat>"
    And Enter user password "<Password>"
    And Click on login button
    Then Validate the validation message "<ValidationMessage>" for invalid email format

    Examples:
      | InvalidEmailFormat | Password    | ValidationMessage           |
      | test@gmail         | QAtest@2020 | Invalid Email Format        |
      | testgmail.com      | QAtest@2020 | Invalid Email Format        |
      | test@gmail.c       | QAtest@2020 | Incorrect Email Or Password |
      | test@gmail.        | QAtest@2020 | Invalid Email Format        |

  @regression @login @TC6
  Scenario Outline: Verify validation message when user enter the invalid email on login page.
    Given I open Maestro website
    When Enter user email "<InvalidEmail>"
    And Enter user password "<Password>"
    And Click on login button
    Then Validate the validation message "<ValidationMessage>" is displayed for wrong email Id

    Examples:
      | InvalidEmail           | Password    | ValidationMessage           |
      | qatest_016@yopmail.com | QAtest@2020 | Incorrect Email Or Password |

  @regression @login @TCL7
  Scenario Outline: Verify validation message when user enter the invalid password on login page.
    Given I open Maestro website
    When Enter user email "<Email>"
    And Enter user password "<InvalidPassword>"
    And Click on login button
    Then Validate the validation message "<ValidationMessage>" is displayed for wrong email Id

    Examples:
      | Email                 | InvalidPassword | ValidationMessage           |
      | qatest016@yopmail.com | QA_test@2020    | Incorrect Email Or Password |

  @regression @login @TC8
  Scenario Outline: Verify validation message when user enter the invalid email and password on login page
    Given I open Maestro website
    When Enter user email "<InvalidUserEmail>"
    And Enter user password "<InvalidPassword>"
    And Click on login button
    Then Validate the validation message "<ValidationMessage>" is displayed for wrong email Id

    Examples:
      | InvalidUserEmail       | InvalidPassword | ValidationMessage           |
      | qatest_016@yopmail.com | QA_test@2020    | Incorrect Email Or Password |

  @regression @critical @login @TC9
  Scenario Outline: Verify user is able to login with valid credentials
    Given I open Maestro website
    When Enter user email "<ValidUserEmail>"
    And Enter user password "<ValidPassword>"
    And Click on login button
    Then Validate Maestro logo is displayed
    #And Validate User Name Icon is displayed

    Examples:
      | ValidUserEmail        | ValidPassword |
      | qatest016@yopmail.com | QAtest@2020   |

  #@regression @login @TC10
  Scenario Outline: Verify Account select page when user has more than one account on same email.
    Given I open Maestro website
    When Enter user email "<ValidUserEmail>"
    And Enter user password "<ValidPassword>"
    And Click on login button
    Then Validate account type dropdown is display
    And Validate login button is displayed on select account type page

    Examples:
      | ValidUserEmail    | ValidPassword |
      | amistry@xeba.tech | Aki@26991     |

  #@regression @login @TC11
  Scenario Outline: Verify account type dropdown list
    Given I open Maestro website
    When Enter user email "<ValidUserEmail>"
    And Enter user password "<ValidPassword>"
    And Click on login button
    Then Validate account type dropdown is display
    When Click on account type dropdown
    Then Validate list of account type is not empty

    Examples:
      | ValidUserEmail    | ValidPassword |
      | amistry@xeba.tech | Aki@26991     |

  #@regression @login @TC12
  Scenario Outline: Verify account type dropdown list
    Given I open Maestro website
    When Enter user email "<ValidUserEmail>"
    And Enter user password "<ValidPassword>"
    And Click on login button
    Then Validate account type dropdown is display
    When Click on account type dropdown
    And Select "<AccountType>" account type from list
    And Click on Login button of account type page
    And Click on side Menu
    Then Validate account type is "<AccountType>"

    Examples:
      | ValidUserEmail    | ValidPassword | AccountType |
      | amistry@xeba.tech | Aki@26991     | QA          |
