#Author:
@Regression 
Feature: Released rule status being reset to 'Not Started' for MD tasks if same user releases rules again as Admin MD

   @Regression
  	Scenario Outline: Assignee inline filter is not working in Rule Review Work Queue
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "MD Review Work Queue" for "FINAL MD DEL" Instance
     And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    When user select Rule with Multiple Payers "2"
    And navigate to My tasks and go to rule in instance "" "MD Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "MD Decesion" "No Action"
    And user Enter Final MD Config Comments
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    And click on "Return Rule Response"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    Then navigate to Admin rule review and Validate Column value "Admin" "FINAL MD DEL" "Assignee" "iht_ittest01"
    And User should be Logged out from IU Application
  
Examples: 
      | FiterName                            | FilterValue                        |
      | Library Status;FilterTaskStatus;Task | Custom;Not Started;Final MD Review |