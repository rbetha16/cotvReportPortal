#Author:
@Regression 
Feature: Released rule status being reset to 'Not Started' for MD tasks if same user releases rules again as Admin MD

  @Regression
  Scenario Outline: TC7642_Ability to create Manual RMR when split decision resulted in Requires Presentation and Completing Decisions
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "MD Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL MD DEL MULTIPAYER2" and "<FilterValue>"
    When user select Rule with Multiple Payers "ONECPMPAYERSDB"
    And navigate to My tasks and go to rule in instance "" "MD Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "MD Decesion" "No Action"
    And user Enter Final MD Config Comments
    And Complete Editorials with "No Editorial Changes"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "CPM Review"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Status" "Completed"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "CPM Review Work Queue" for "FINAL MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Require Presentation"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Status" "Manual RMR"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @Regression
  Scenario Outline: (Copy of) Ability to update Manual RMR with required Instructions-Manual RMR
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "MD Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL MD DEL MULTIPAYER2" and "<FilterValue>"
    When user select Rule with Multiple Payers "ONECPMPAYERSDB"
    And navigate to My tasks and go to rule in instance "" "MD Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "MD Decesion" "No Action"
    And user Enter Final MD Config Comments
    And Complete Editorials with "No Editorial Changes"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "CPM Review"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Status" "Completed"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "CPM Review Work Queue" for "FINAL MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Disagree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Status" "Manual RMR"
    And User should be Logged out from IU Application

     Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |