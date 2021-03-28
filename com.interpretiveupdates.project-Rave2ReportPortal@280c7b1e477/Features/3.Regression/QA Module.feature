#Author:
@Regression  @QAModuole @QAVeraCode
Feature: F7996 2017 Q3 Issues - IU

  @QAModule @QATC07 
  Scenario Outline: TC_07_IU_QA_Rule_Update_Custom
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
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
    And select "RuleID"
    Then validate CPT Changes in Database "YES"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @QAModule @QATC07_MODIFY 
  Scenario Outline: TC_07_QA_Rule_Update_DEL_MODIFY_Custom
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And Select System Proposal "DEL" "Modify"
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
    And select "RuleID"
    Then validate CPT Changes in Database "YES"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @QAModule @QATC06  
  Scenario Outline: TC_06_IU_QA_Rule_Update_Library
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
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    Then validate CPT Changes in Database "NO"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "NO"
    Then validate CPT Changes in Database "YES"
    And user Click on QA Review Complete ""
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "Testing Review"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  @QAModule @QATC06_MODIFY 
  Scenario Outline: TC_06_QA_Rule_Update_DEL_MODIFY_Library
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And Select System Proposal "DEL" "Modify"
    And Complete Editorials with "No Editorial Changes"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    Then validate CPT Changes in Database "NO"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "Testing Review"
    And select "RuleID"
    Then validate CPT Changes in Database "YES"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  @QAModule @QATC01
  Scenario Outline: TC_01_QA_CPM_Returned tasks to QA
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
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
    When return rule from "QA" to "CPM"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "CPM Review Work Queue" for "FINAL MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And user click on "" "Return Response To QA"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "QA Review - CPM Response"
    When Reassign task "" "iht_ittest01"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "QA Review Work Queue" for "FINAL MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    Then validate Return Response Comments "QA" "CPM Review"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @QAModule @QATC03
  Scenario Outline: TC_03_QA_IU_PostQA Routing
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
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
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @QAModule @Feb1morrun 
  Scenario Outline: TC_04_QA_Final MD_Returned tasks to QA
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And click on "Generate Summaries"
    And user Enter Final MD Config Comments
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "Editorial Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    When user complete all Editorial Reviews ""
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    When return rule from "QA" to "PO"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And user click on "" "Return Response To QA"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "QA Review - Final PO Response"
    When Reassign task "" "iht_ittest01"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "QA Review Work Queue" for "FINAL MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    When return rule from "QA" to "Editorial"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Editorial Review Work Queue" for "FINAL MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And user click on "" "Return Response To QA"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "QA Review - Editorial Response"
    When Reassign task "" "iht_ittest01"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "QA Review Work Queue" for "FINAL MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    Then validate Return Response Comments "QA" "Editorial Review"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  @QAModule @QAPOSTRTC02
  Scenario Outline: TC_02_QA_Post_Config_Review_and_QA_Return_Config_Review_Config
    								 TC_03_QA_IU_PostQA Routing

    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
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
    When return rule from "QA" to "Configuration"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "Configuration Review - QA Return"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @QAModule @QATC775
  Scenario Outline: TC775_QA_PPMD-2547_Rule Update failed for Rule 6484.20 in UAT_Choose No on Editorial Warning pop-up
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And Complete Editorials with "Editorial Changes"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    And User should be Logged out from IU Application
    Then validate Editorial Changes in Database "SUB_RULE_DESC"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @QAModule @QATC1093 
  Scenario Outline: TC1093_QA_PPMD_3088_Change communication_Scenario1_QA
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And Complete Editorials with "Update Tabs"
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
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    And User should be Logged out from IU Application
    Then validate Editorial Changes in Database "SUB_RULE_DESC;SUB_RULE_NOTES;SUB_RULE_SCRIPT;SUB_RULE_RATIONALE;REFERENCE"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @QAModule @QATC658
  Scenario Outline: TC658_QA_PPMD_7448_1_Rule review request is fetching incorrect rule to review process
  
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And Complete Editorials with "Editorial Changes"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    And User should be Logged out from IU Application
    Then validate Editorial Changes in Database "SUB_RULE_DESC"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;Y |