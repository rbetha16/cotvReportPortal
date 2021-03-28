#Author: trinath.kumar@cotiviti.com
@Regression @MDSummaries
Feature: MD Summaries Functionality

  Background: 
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen

  #************************************************************ SCENARIO-1 ***********************************************************************************
  @MDSummaries47.1
  Scenario Outline: 47.1_Library_Rule Review From Final_MD to Editorial
    When user click on "PO Review Work Queue" for "PRELIM PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Preliminary PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "PRELIM PO DEL" "Task" "Final PO Review After Preliminary"
    When Reassign task "" "iht_ittest02"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "PRELIM PO DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "PRELIM PO DEL" "Task" "Editorial Review"

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  #************************************************************ SCENARIO-2 ***********************************************************************************
  @MDSummaries47.2
  Scenario Outline: 47.2_MD_Post MD Review_Library rule - Logical Rule Change Defined - No CPT ARD - MD completed Editorials
    When user click on "PO Review Work Queue" for "PRELIM PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Preliminary PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "" "No Action"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "PRELIM PO DEL" "Task" "Final PO Review After Preliminary"
    When Reassign task "" "iht_ittest02"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "PRELIM PO DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "Approve Editorials"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "PRELIM PO DEL" "Task" "QA Review"

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  #************************************************************ SCENARIO-3 ***********************************************************************************
  @MDSummaries47.3
  Scenario Outline: 47.3_Rule Review Final_MD_To_CPM PIC
    When user click on "PO Review Work Queue" for "PRELIM PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Preliminary PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "" "No Action"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "PRELIM PO DEL" "Task" "Final PO Review After Preliminary"
    When Reassign task "" "iht_ittest02"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "PRELIM PO DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "Approve Editorials"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "PRELIM PO DEL" "Task" "CPM Review"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #************************************************************ SCENARIO-4 ***********************************************************************************
  @MDSummaries47.4
  Scenario Outline: 47.4_MD_Post MD Review_Library Rule with CPT ARD
    When user click on "PO Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL MD DEL MULTIPAYER2" and "<FilterValue>"
    When user select Rule with Multiple Payers "ONECPMPAYERSDB"
    And navigate to My tasks and go to rule in instance "" "PO Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL MD DEL" "Task" "CPM Review"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "CPM Review Work Queue" for "FINAL MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And Select CPM System Proposal "DEL" "NO ACTION" ""
    And click on "CPM Decesion Complete"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value in DB "FINAL MD DEL" "Status" "Manual RMR"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;Y |

  #************************************************************ SCENARIO-5 ***********************************************************************************
  @MDSummaries47.5
  Scenario Outline: 47.5 Rule Review FromFinal_MD to Editorial
    When user click on "PO Review Work Queue" for "PRELIM PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Preliminary PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "PRELIM PO DEL" "Task" "Final PO Review After Preliminary"
    When Reassign task "" "iht_ittest02"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "PRELIM PO DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    #And click on "Authorize Decisions"
    And Authorize and validate warning message
    Then validate Admin rule review value "Admin" "PRELIM PO DEL" "Task" "Editorial Review"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  #************************************************************ SCENARIO-6 ***********************************************************************************
  @MDSummaries47.6
  Scenario Outline: 47.6_MD_Post MD Review_Only Editorial changes, no logical changes rules moves to QA
    #When user click on "PO Review Work Queue" for "PRELIM PO DEL" Instance
    #And Apply filters in My Task and Retrive Rule in DB "Preliminary PO Review" and "<FilterValue>"
    #And select "RuleID"
    #And click on "Start Review"
    #And Complete Editorials with "No Editorial Changes"
    #And Select System Proposal "" "No Action"
    #And Select System Proposal "DEL" "Modify"
    #And click on "Generate Summaries"
    #And click on "Authorize Decisions"
    #Then validate Admin rule review value "Admin" "PRELIM PO DEL" "Task" "Final PO Review After Preliminary"
    #When Reassign task "" "iht_ittest02"
    #And User should be Logged out from IU Application
    #Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    #And user navigate to IU "MyTasks" Instances Screen
    #When user click on "PO Review Work Queue" for "PRELIM PO DEL" Instance
    #And select "RuleID"
    #And click on "Start Review"
    #And Complete Editorials with "Approve Editorials"
    #And click on "Authorize Decisions"
    #Then validate Admin rule review value "Admin" "PRELIM PO DEL" "Task" "QA Review"
    #And User should be Logged out from IU Application
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And Complete Editorials with "Approve Editorials"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review"

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  #************************************************************ SCENARIO-7 ***********************************************************************************
  @MDSummaries47.8
  Scenario Outline: 47.8_MD_Post MD Review_ Library or Custom rule - System Derived No Change Required ,MD complete editorials
    47.7_MD_Post MD Review_Library orCustom rule - MD designated No Change Required

   When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And set "No Change Required" in MD Review
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Status" "No Change Required"
    And select "RuleID"
    And set "Unset No change required" in MD Review
    Then validate Admin rule review value in DB "FINAL PO DEL" "Status" "Started"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #************************************************************ SCENARIO-8 ***********************************************************************************
  @MDSummaries47.9
  Scenario Outline: 47.9_Library or Custom_Rule Validation From Final_MD To QA
    #When user click on "PO Review Work Queue" for "PRELIM PO DEL" Instance
    #And Apply filters in My Task and Retrive Rule in DB "Preliminary PO Review" and "<FilterValue>"
    #And select "RuleID"
    #And click on "Start Review"
    #And Complete Editorials with "Update Tabs"
    #And Select System Proposal "" "No Action"
    #And click on "Generate Summaries"
    #And click on "Authorize Decisions"
    #Then validate Admin rule review value "Admin" "PRELIM PO DEL" "Task" "Final PO Review After Preliminary"
    #When Reassign task "" "iht_ittest02"
    #And User should be Logged out from IU Application
    #Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    #And user navigate to IU "MyTasks" Instances Screen
    #When user click on "PO Review Work Queue" for "PRELIM PO DEL" Instance
    #And select "RuleID"
    #And click on "Start Review"
    #And Complete Editorials with "Approve Editorials"
    #And click on "Authorize Decisions"
    #Then validate Admin rule review value "Admin" "PRELIM PO DEL" "Task" "QA Review"
    #And User should be Logged out from IU Application
    
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "Update Tabs"
    And Select System Proposal "" "No Action"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review"

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  #************************************************************ SCENARIO-9 ***********************************************************************************
  @MDSummaries47.10
  Scenario Outline: 47.10_MD_Post MD Review_Library or Custom rule - System Derived No Change Required
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Editorial Review"

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  #************************************************************ SCENARIO-10 ***********************************************************************************
  @MDSummariesTC689
  Scenario Outline: TC689-PPMD_2960_Final PO Review QA return Rule returned to QA skipping editorials_Custom_Scenario2
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Editorial Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "Update Tabs"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When return rule from "QA" to "PO"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Final PO Review - QA Return"
    And navigate to My tasks and go to rule in instance "MyTasks" "PO Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And user Enter Final MD Config Comments
    And Select System Proposal "DEL" "Modify"
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
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Editorial Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When user complete all Editorial Reviews ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |