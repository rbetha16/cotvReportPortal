#Author: trinath.kumar@cotiviti.com
@Regression @Editorials @Empty
Feature: Verfiy Editorial Module

  Background: 
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen

  @EditorialTC_02
  Scenario Outline: TC_06_Editorials_21_13_Editorial_Update Screen_update description
    TC_02_Editorials_Validation_Editorial Update_Screen_Validations
    TC_08_Editorials_Update Screen_Editorial MarkUp_CancelButton
    TC_04_Editorial_Update Screen_UI

    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    Then validate "<Tabs>" editorial update popup
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          | Tabs                                                  |
      | FilterTaskStatus | Custom;Not Started;N | New Rule Description;Notes;Script;Rationale;Reference |

  #########################################################################################################################
  @EditorialTC_03
  Scenario Outline: TC_03_Editorials_Response to QA_Return Rule_DB
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And click on "Generate Summaries"
    And user Enter Final MD Config Comments
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    And click on "CPM Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Editorial Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When user complete all Editorial Reviews ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When return rule from "QA" to "Editorial"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And user click on "" "Return Response To QA"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review - Editorial Response"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #########################################################################################################################
  @EditorialTC_05
  Scenario Outline: TC_05_Editorials_Editorial GroupTask
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And click on "Generate Summaries"
    And user Enter Final MD Config Comments
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    And click on "CPM Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Editorial Review"
    And user navigate to IU "GroupTasks" Instances Screen
    And click task "Editorial Review Work Queue" by instance name "EditorialPool" in group tasks tab
    #And user navigate to IU "MyTasks" Instances Screen
    #When user click on "Editorial Review Work Queue" for "Pool" Instance
    #Then validate multiple rule id
    #And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #########################################################################################################################
  @EditorialTC_10
  Scenario Outline: TC_10_Editorials_MD Completes_Custom Rule_CPM agrees MD Decision
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    When user select Rule with "Final PO Review"
    And click on "Start Review"
    And Select System Proposal "DEL" "Remove"
    And Complete Editorials with "No Editorial Changes"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    And click on "CPM Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #########################################################################################################################
  @EditorialTC_11
  Scenario Outline: TC_11_Editorials_MD Completes_Custom Rule_CPM Disagree MD Decision
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL PO DEL MULTIPAYER2" and "<FilterValue>"
    When user select Rule with Multiple Payers "ONECPMPAYERSDB"
    And navigate to My tasks and go to rule in instance "" "PO Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "PO Decesion" "No Action"
    And user Enter Final MD Config Comments
    And Complete Editorials with "No Editorial Changes"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "CPM Review"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Status" "Completed"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "CPM Review Work Queue" for "FINAL PO DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Disagree"
    And click on "Generate Summaries"
    And click on "CPM Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Status" "Manual RMR"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |