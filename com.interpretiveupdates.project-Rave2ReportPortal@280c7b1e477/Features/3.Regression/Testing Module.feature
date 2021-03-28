#Author:
@Regression @Testing @TestingVeraCode
Feature: TESTING MODULE

  @TC3005 @Testing   @Jan28nightrun
  
  Scenario Outline: TC_05_Testing_TC3005_U_Testing Completed_Check
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
     When user click on "PO Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "DEL" "Remove"
    And Complete Editorials with "Editorial Changes"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    Then validate CPT Changes in Database "NO"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "Testing Review"
    When Reassign task "" "iht_ittest01"
    And select "RuleID"
    Then validate CPT Changes in Database "YES"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    And Complete all testing Reviews
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Status" "Completed"
    And User should be Logged out from IU Application
    Then validate Editorial Changes in Database "SUB_RULE_DESC"

  
    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @TCTEST03 @Jan28nightrun
  Scenario Outline: TC_03_Testing_Testing Required
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And Select System Proposal "DEL" "Remove"
    And Complete Editorials with "No Editorial Changes"
    And click on "Generate Summaries"
    And user Enter Final MD Config Comments
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    Then validate CPT Changes in Database "NO"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "Configuration Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Configuration Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    And complete all Config Reviews
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "QA Review - Post Configuration"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    And Complete Post Additional Configuration
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "Testing Review"
    When Reassign task "" "iht_ittest01"
    And select "RuleID"
    Then validate CPT Changes in Database "YES"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    And Complete all testing Reviews
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Status" "Completed"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @TCTEST01 @Jan28nightrun
  Scenario Outline: TC_01_Testing_Return Rule to QA Check
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And Select System Proposal "DEL" "Remove"
    And Complete Editorials with "No Editorial Changes"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    Then validate CPT Changes in Database "NO"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "Testing Review"
    When Reassign task "" "iht_ittest01"
    And select "RuleID"
    Then validate CPT Changes in Database "YES"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    When return rule from "Testing" to "QA"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "QA Review - Testing Return"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @TCTEST0204  
  Scenario Outline: TC_02_Testing_Testing Pool Tasks
    								TC_04_Testing_TC1875_U_Testing Review_ Attach BRAT Test Results

    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And Select System Proposal "DEL" "Remove"
    And Complete Editorials with "No Editorial Changes"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    When user click on task tab and go to rule in instance "GroupTasks" "Testing Review Work Queue" "FINAL MD DEL"
    And user click on Claim Tasks
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "Testing Review"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    Then user Upload File in TestingReview and validate
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

