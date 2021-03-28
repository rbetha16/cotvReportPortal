#Author: trinath.kumar@cotiviti.com
@Regression @Passrun
Feature: Released rule status being reset to 'Started' for MD tasks if same user releases rules again as Admin MD

  @Regression
  Scenario: TC7640_Released rule status being reset to 'Started' for MD tasks if same user releases rules again as Admin MD
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    And user click on "QA Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task Rule Work Queue "FilterTaskStatus;Task" and "Started;QA Review"
    Then Get rule from "QAWorkQueue" for "FINAL MD DEL" instance
    When user click on "CPM Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task Rule Work Queue "FilterTaskStatus;Task" and "Started;CPM Review"
    Then Get rule from "CPMWorkQueue" for "Final MD Del" instance
    When user click on "Editorial Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task Rule Work Queue "FilterTaskStatus;Task" and "Started;Editorial Review"
    Then Get rule from "EditorialWorkQueue" for "Final MD Del" instance
    When user click on "Testing Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task Rule Work Queue "FilterTaskStatus;Task" and "Started;Testing Review"
    Then Get rule from "TestingWorkQueue" for "Final MD Del" instance
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "Admin" Instances Screen
    And user navigate to IU "View All Tasks" Instances Screen
    And reassign task from user "iht_ittest02" to "iht_ittest01" for "Final MD DEL" Instance
    Then User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    And user click on "Admin MD Scrub Review" for "FINAL MD DEL" Instance
    And user navigate to IU "Admin MD Scrub" Instances Screen
    Then User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    And veify rule in "QAWorkQueue" for "FINAL MD DEL" instance
    Then user should be able see selected RuleVersion in the Grid
    When veify rule in "CPMWorkQueue" for "FINAL MD DEL" instance
    Then user should be able see selected RuleVersion in the Grid
    When veify rule in "EditorialWorkQueue" for "FINAL MD DEL" instance
    Then user should be able see selected RuleVersion in the Grid
    When veify rule in "TestingWorkQueue" for "FINAL MD DEL" instance
    And user should be able see selected RuleVersion in the Grid
    Then User should be Logged out from IU Application
