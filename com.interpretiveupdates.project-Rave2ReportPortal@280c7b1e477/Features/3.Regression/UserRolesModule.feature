#Author: trinath.kumar@cotiviti.com
Feature: End to End Functionality

  @Test01
  Scenario Outline: TC_01_US_User_Rules_Validation_Editorial
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "Assignment Configuration" Instances Screen
    And validate the user role operation "iht_ittest01","unCheck"
    And user navigate to IU "GroupTasks" Instances Screen
    And click task "Editorial Review Work Queue" by instance name "Final MD Del" in group tasks tab
    And Apply filters in My Task and Retrive Rule in DB "SINGLEPAYER-Editorial Review" and "<FilterValue>"
    And Get Rule and Payer value
    And User should be Logged out from IU Application
    Given User login to Client Profile Application through "QA_URL"
    When user Navigate "Payer Shorts" tab
    Then select "ANWNV" and navigate to "Mappings" tab
    And "Check" onshore operations
    And user should be logged out from Client Profile application
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "GroupTasks" Instances Screen
    And click task "Editorial Review Work Queue" by instance name "Final MD Del" in group tasks tab
    And validate rule id
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "Assignment Configuration" Instances Screen
    And validate the user role operation "iht_ittest01","Check"
    And User should be Logged out from IU Application
    Given User login to Client Profile Application through "QA_URL"
    When user Navigate "Payer Shorts" tab
    Then select "ANWNV" and navigate to "Mappings" tab
    And "UnCheck" onshore operations

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @Test02
  Scenario Outline: TC_02_US_User_Rules_Validation_Testing
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "Assignment Configuration" Instances Screen
    And validate the user role operation "iht_ittest01","unCheck"
    And user navigate to IU "GroupTasks" Instances Screen
    And click task "Testing Review Work Queue" by instance name "Final MD Del" in group tasks tab
    And Apply filters in My Task and Retrive Rule in DB "SINGLEPAYER-Testing Review" and "<FilterValue>"
    And Get Rule and Payer value
    And User should be Logged out from IU Application
    Given User login to Client Profile Application through "QA_URL"
    When user Navigate "Payer Shorts" tab
    Then select "ANWNV" and navigate to "Mappings" tab
    And "Check" onshore operations
    And user should be logged out from Client Profile application
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "GroupTasks" Instances Screen
    And click task "Testing Review Work Queue" by instance name "Final MD Del" in group tasks tab
    And validate rule id
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "Assignment Configuration" Instances Screen
    And validate the user role operation "iht_ittest01","Check"
    And User should be Logged out from IU Application
    Given User login to Client Profile Application through "QA_URL"
    When user Navigate "Payer Shorts" tab
    Then select "ANWNV" and navigate to "Mappings" tab
    And "UnCheck" onshore operations

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @Test03
  Scenario Outline: TC_03_US_User_Rules_Validation_QA
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "Assignment Configuration" Instances Screen
    And validate the user role operation "iht_ittest01","unCheck"
    And user navigate to IU "GroupTasks" Instances Screen
    And click task "QA Review Work Queue" by instance name "Final MD Del" in group tasks tab
    And Apply filters in My Task and Retrive Rule in DB "SINGLEPAYER-QA Review" and "<FilterValue>"
    And Get Rule and Payer value
    And User should be Logged out from IU Application
    Given User login to Client Profile Application through "QA_URL"
    When user Navigate "Payer Shorts" tab
    Then select "ANWNV" and navigate to "Mappings" tab
    And "Check" onshore operations
    And user should be logged out from Client Profile application
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    And user navigate to group task IU screen
    And click task "QA Review Work Queue" by instance name "Final MD Del" in group tasks tab
    And validate rule id
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "Assignment Configuration" Instances Screen
    And validate the user role operation "iht_ittest01","Check"
    And User should be Logged out from IU Application
    Given User login to Client Profile Application through "QA_URL"
    When user Navigate "Payer Shorts" tab
    Then select "ANWNV" and navigate to "Mappings" tab
    And "UnCheck" onshore operations

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @Test04
  Scenario Outline: TC_04_US_User_Rules_Validation_Config
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "GroupTasks" Instances Screen
    And click task "Configuration Review Work Queue" by instance name "Final MD Del" in group tasks tab
    And Apply filters in My Task and Retrive Rule in DB "SINGLEPAYER-Configuration Review" and "<FilterValue>"
    And Get Rule and Payer value
    And User should be Logged out from IU Application
    Given User login to Client Profile Application through "QA_URL"
    When user Navigate "Payer Shorts" tab
    Then select "ANWNV" and navigate to "Mappings" tab
    And "Check" onshore operations
    And user should be logged out from Client Profile application
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    And user navigate to group task IU screen
    And click task "Configuration Review Work Queue" by instance name "Final MD Del" in group tasks tab
    And validate rule id
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "Assignment Configuration" Instances Screen
    And validate the user role operation "iht_ittest01","Check"
    And User should be Logged out from IU Application
    Given User login to Client Profile Application through "QA_URL"
    When user Navigate "Payer Shorts" tab
    Then select "ANWNV" and navigate to "Mappings" tab
    And "UnCheck" onshore operations

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |
