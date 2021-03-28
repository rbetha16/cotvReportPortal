#Author:
@Regression @Cpmassignsep27
Feature: F7996 2017 Q3 Issues - IU

  @Regression @TC133521
  Scenario Outline: TC13352_1 CPM review task Reassignment to completed status task
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "MD Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL MD DEL MULTIPAYER2" and "<FilterValue>"
    When user select Rule with Multiple Payers "TWOCPMPAYERSDB"
    And navigate to My tasks and go to rule in instance "" "MD Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "DEL" "Remove"
    And Complete Editorials with "No Editorial Changes"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "CPM Review"
    Then validate Rule review value row wise "1" "CPM Review" "Not Started" "iht_ittest01"
    Then validate Rule review value row wise "2" "CPM Review" "Not Started" "iht_ittest02"
    Then validate Rule review value row wise "3" "CPM Review" "Not Started" "iht_ittest03"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    And Select CPM System Proposal "DEL" "REMOVE" ""
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "CPM Review"
    Then validate Rule review value row wise "1" "CPM Review" "Started" "iht_ittest01"
    Then validate Rule review value row wise "2" "CPM Review" "Not Started" "iht_ittest02"
    Then validate Rule review value row wise "3" "CPM Review" "Not Started" "iht_ittest03"
    When Reassign CPM on specific row "CPM" "iht_ittest01" "iht_ittest02 - iht_ittest02"
    Then validate Rule review value row wise "2" "CPM Review" "Not Started" "iht_ittest02"
    Then validate Rule review value row wise "3" "CPM Review" "Not Started" "iht_ittest03"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "CPM Review Work Queue" for "FINAL MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "CPM Review"
    Then validate Rule review value row wise "2" "CPM Review" "Completed" "iht_ittest02"
    Then validate Rule review value row wise "3" "CPM Review" "Not Started" "iht_ittest03"
    When Reassign CPM on specific row "CPM" "iht_ittest03" "iht_ittest02 - iht_ittest02"
    Then validate Rule review value row wise "2" "CPM Review" "Started" "iht_ittest02"
    And User should be Logged out from IU Application

  Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @Regression
  Scenario Outline: TC13352_2 CPM review task Reassignment to completed status task
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "MD Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL MD DEL MULTIPAYER2" and "<FilterValue>"
    When user select Rule with Multiple Payers "TWOCPMPAYERSDB"
    And navigate to My tasks and go to rule in instance "" "MD Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "DEL" "Remove"
    And Complete Editorials with "No Editorial Changes"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "CPM Review"
    Then validate Rule review value row wise "1" "CPM Review" "Not Started" "iht_ittest01"
    Then validate Rule review value row wise "2" "CPM Review" "Not Started" "iht_ittest02"
    Then validate Rule review value row wise "3" "CPM Review" "Not Started" "iht_ittest03"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    And click on "Require Presentation"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "CPM Review"
    Then validate Rule review value row wise "1" "CPM Review" "Requires Presentation" "iht_ittest01"
    Then validate Rule review value row wise "2" "CPM Review" "Not Started" "iht_ittest02"
    Then validate Rule review value row wise "3" "CPM Review" "Not Started" "iht_ittest03"
    When Reassign CPM on specific row "CPM" "iht_ittest02" "iht_ittest01 - iht_ittest01"
    Then validate Rule review value row wise "1" "CPM Review" "Started" "iht_ittest01"
    Then validate Rule review value row wise "3" "CPM Review" "Not Started" "iht_ittest03"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Require Presentation"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "CPM Review"
    When Reassign CPM on specific row "CPM" "iht_ittest03" "iht_ittest01 - iht_ittest01"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "CPM Review"
    Then validate Rule review value row wise "1" "CPM Review" "Started" "iht_ittest01"
    And User should be Logged out from IU Application

     Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @Regression
  Scenario Outline: TC13352_3 CPM review task Reassignment to completed status task
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "MD Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL MD DEL MULTIPAYER2" and "<FilterValue>"
    When user select Rule with Multiple Payers "TWOCPMPAYERSDB"
    And navigate to My tasks and go to rule in instance "" "MD Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "DEL" "Remove"
    And Complete Editorials with "No Editorial Changes"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "CPM Review"
    Then validate Rule review value row wise "1" "CPM Review" "Not Started" "iht_ittest01"
    Then validate Rule review value row wise "2" "CPM Review" "Not Started" "iht_ittest02"
    Then validate Rule review value row wise "3" "CPM Review" "Not Started" "iht_ittest03"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "CPM Review"
    Then validate Rule review value row wise "1" "CPM Review" "Completed" "iht_ittest01"
    Then validate Rule review value row wise "2" "CPM Review" "Not Started" "iht_ittest02"
    Then validate Rule review value row wise "3" "CPM Review" "Not Started" "iht_ittest03"
    When Reassign CPM on specific row "CPM" "iht_ittest02" "iht_ittest01 - iht_ittest01"
    Then validate Rule review value row wise "1" "CPM Review" "Started" "iht_ittest01"
    Then validate Rule review value row wise "3" "CPM Review" "Not Started" "iht_ittest03"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest03" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "CPM Review Work Queue" for "FINAL MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "CPM Review"
    Then validate Rule review value row wise "3" "CPM Review" "Started" "iht_ittest03"
    Then validate Rule review value row wise "1" "CPM Review" "Started" "iht_ittest01"
    When Reassign CPM on specific row "CPM" "iht_ittest01" "iht_ittest03 - iht_ittest03"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "CPM Review"
    Then validate Rule review value row wise "3" "CPM Review" "Started" "iht_ittest03"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |
