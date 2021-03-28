#Author: trinath.kumar@cotiviti.com
@Regression 
Feature: Released rule status being reset to 'Not Started' for MD tasks if same user releases rules again as Admin MD

  @Regression
  Scenario: TC7641_Released rule status being reset to 'Not Started' for MD tasks if same user releases rules again as Admin MD
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    And user click on "QA Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task Rule Work Queue "FilterTaskStatus;Task" and "Not Started;QA Review"
    Then Get rule from "QAWorkQueue" for "FINAL MD DEL" instance
    When user click on "CPM Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task Rule Work Queue "FilterTaskStatus;Task" and "Not Started;CPM Review"
    Then Get rule from "CPMWorkQueue" for "FINAL MD DEL" instance
    When user click on "Editorial Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task Rule Work Queue "FilterTaskStatus;Task" and "Not Started;Editorial Review"
    Then Get rule from "EditorialWorkQueue" for "FINAL MD DEL" instance
    And User should be Logged out from IU Application
    
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
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
    And user should be able see selected RuleVersion in the Grid
    Then User should be Logged out from IU Application

  