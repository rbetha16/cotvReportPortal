#Author: trinath.kumar@cotiviti.com
@Regression1 @EndToEndSubSequentPart2
Feature: End to End Scenarios part 2 for subsequent run

  Background: 
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen

  #***************************************************************************************** SCENARIO-01***************************************************************************************************
  @EndToEndSubSequent1
  Scenario Outline: TC19_End to End_No_ChangeRequired_Custom
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO ReviewSUBSEQUENTRUN" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And set "No Change Required" in MD Review
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Status" "No Change Required"
    And select "RuleID"
    And set "Unset No change required" in MD Review
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Status" "Started"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #***************************************************************************************** SCENARIO-02 ***************************************************************************************************
  @EndToEndSubSequent2
  Scenario Outline: TC19_End to End_No_ChangeRequired_DEL_NoLogical_Editorial Not Completed_Move to Editorial
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO ReviewSUBSEQUENTRUN" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Task" "Editorial Review"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #***************************************************************************************** SCENARIO-03 ***************************************************************************************************
  @EndToEndSubSequent3
  Scenario Outline: TC19_End to End_No_ChangeRequired_DEL_NoLogical_Move to QA
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO ReviewSUBSEQUENTRUN" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "Update Tabs"
    And Select System Proposal "" "No Action"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Task" "QA Review"

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  #***************************************************************************************** SCENARIO-04***************************************************************************************************
  @EndToEndSubSequent4
  Scenario Outline: TC19_End to End_No_ChangeRequired_Library
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO ReviewSUBSEQUENTRUN" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And set "No Change Required" in MD Review
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Status" "No Change Required"
    And select "RuleID"
    And set "Unset No change required" in MD Review
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Status" "Started"

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  #***************************************************************************************** SCENARIO-05***************************************************************************************************
  @EndToEndSubSequent5
  Scenario Outline: TC19_End to End_No_ChangeRequired_Not_DEL_NoLogical_Move to No Change required
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO ReviewSUBSEQUENTRUN" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "" "No Action"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Status" "No Change Required"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #***************************************************************************************** SCENARIO-06***************************************************************************************************
  @EndToEndSubSequent6 @EndToEndSubSequentRav5
  Scenario Outline: TC2067_End to End Manual add and Remove_Library_Codes_Copied_To_Custom_Rule_Validations_1_Library
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO ReviewSUBSEQUENTRUN" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "Update Tabs"
    And Select System Proposal "" "No Action"
    When user ADD Code "Billed With (And)","0009M"
    Then Validate BOBW Config Link Submit "Billed With And"
    And click on "Generate Summaries"
    Then validate BOBW Grid Data and Retire Rule Validation
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Review Segment "QA" "BW And/BWO Or Logic" "YES"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "NO"
    Then validate CPT Changes in Database "YES"
    And user Click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Testing Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When return rule from "Testing" to "QA"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review - Testing Return"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And user click on "" ""
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL-Subsequent"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Task" "Testing Review - QA Response"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When return rule from "Testing" to "PO"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Task" "Final PO Review - Testing Return"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Status" "Not Started"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  #***************************************************************************************** SCENARIO-07***************************************************************************************************
  @EndToEndSubSequent7 @EndToEndSubSequentDec3 @EndToEndSubSequentRav6
  Scenario Outline: TC2067_End to End Manual add and Remove_Library_Codes_Copied_To_Custom_Rule_Validations_2_Library
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO ReviewSUBSEQUENTRUN" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "Update Tabs"
    And Select System Proposal "" "No Action"
    When user ADD Code "Billed With (And)","0009M"
    Then Validate BOBW Config Link Submit "Billed With And"
    And click on "Generate Summaries"
    Then validate BOBW Grid Data and Retire Rule Validation
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Review Segment "QA" "BW And/BWO Or Logic" "YES"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "NO"
    Then validate CPT Changes in Database "YES"
    And user Click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Testing Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When return rule from "Testing" to "PO"
    #And user click on "" ""
    #Then validate Return Response Comments "Testing" "Test Automation Comments"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL-Subsequent"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Task" "Testing Review - Final PO Response"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then user Upload File in TestingReview and validate
    And Complete all testing Reviews
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Status" "Completed"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  #***************************************************************************************** SCENARIO-08***************************************************************************************************
  @EndToEndSubSequent8 @EndToEndSubSequentDec3 @EndToEndSubSequentRav7
  Scenario Outline: TC_7_4_Additional Configuration_Library
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO ReviewSUBSEQUENTRUN" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "" "No Action"
    And click on "Generate Summaries"
    And user Enter Final MD Config Comments
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Configuration Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Config Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And complete all Config Reviews
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review - Post Configuration"

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  #***************************************************************************************** SCENARIO-09***************************************************************************************************
  @EndToEndSubSequent9 @PASS @EndToEndSubSequentDec3 @EndToEndSubSequentRav8
  Scenario Outline: TC_7_2_Editorial verification_New_Rule_Version_Library
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO ReviewSUBSEQUENTRUN" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "Update Tabs"
    And Select System Proposal "" "No Action"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    When create versioned Rule "Yes"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then validate Editorial Changes in Database "SUB_RULE_DESC;SUB_RULE_NOTES;SUB_RULE_SCRIPT;SUB_RULE_RATIONALE;REFERENCE"

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  #***************************************************************************************** SCENARIO-10***************************************************************************************************
  @EndToEndSubSequent10 @EndToEndSubSequentDec3 @EndToEndSubSequentRav9
  Scenario Outline: TC_7_2_Editorial verification_Library
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO ReviewSUBSEQUENTRUN" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "Update Tabs"
    And Select System Proposal "" "No Action"
    And Select System Proposal "" "Modify"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "NO"
    Then validate CPT Changes in Database "YES"
    And user Click on QA Review Complete "YES"
    Then validate Editorial Changes in Database "SUB_RULE_DESC;SUB_RULE_NOTES;SUB_RULE_SCRIPT;SUB_RULE_RATIONALE;REFERENCE"

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  #***************************************************************************************** SCENARIO-11***************************************************************************************************
  @EndToEndSubSequent11 @EndToEndSubSequentDec3 @EndToEndSubSequentRav10
  Scenario Outline: TC_6_7_System suggested to retire MD diagreed_Custom
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO ReviewSUBSEQUENTRUN" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "" "No Action"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    And click on "CPM Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    #And retire rule validation in DB "loRuleID_EE_TC6_7" "12/31/9999" "No"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "NO"
    Then validate CPT Changes in Database "YES"
    And user Click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Testing Review"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #***************************************************************************************** SCENARIO-12***************************************************************************************************
  @EndToEndSubSequent12
  Scenario Outline: TC_6_6_System suggested to retire MD agreed by chagning the parameters_Custom
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final MD Review-Subsequent" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "" "No Action"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "NO"
    Then validate CPT Changes in Database "NO"
    And user Click on QA Review Complete "YES"
    Then validate Editorial Changes in Database "SUB_RULE_DESC;SUB_RULE_NOTES;SUB_RULE_SCRIPT;SUB_RULE_RATIONALE;REFERENCE"

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  #***************************************************************************************** SCENARIO-13***************************************************************************************************
  @EndToEndSubSequent13
  Scenario Outline: TC_6_5_Additional Configuration_Custom
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final MD Review-Subsequent" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "" "No Action"
    And click on "Generate Summaries"
    And user Enter Final MD Config Comments
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    And click on "CPM Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Configuration Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Configuration Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And complete all Config Reviews
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review - Post Configuration"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #***************************************************************************************** SCENARIO-14***************************************************************************************************
  @EndToEndSubSequent14 @PASS
  Scenario Outline: TC_6_2_Editorial verification_Custom
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final MD Review-Subsequent" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "Update Tabs"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    And click on "CPM Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then validate Editorial Changes in Database "SUB_RULE_DESC;SUB_RULE_NOTES;SUB_RULE_SCRIPT;SUB_RULE_RATIONALE;REFERENCE"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #***************************************************************************************** SCENARIO-15***************************************************************************************************
  @EndToEndSubSequent15
  Scenario Outline: TC_20_21_Final MD_Editorial_QA_Testing_RETURN_Custom_Rule
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final MD Review-Subsequent" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And click on "Generate Summaries"
    And user Enter Final MD Config Comments
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    And click on "CPM Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Editorial Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When return rule from "Editorial" to "PO"
    And navigate to My tasks and go to rule in instance "MyTasks" "PO Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And user click on "" ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Editorial Review - Final PO Response"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user complete all Editorial Reviews ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When return rule from "QA" to "MD"
    And navigate to My tasks and go to rule in instance "MyTasks" "PO Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And user click on "" ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review - Final PO Response"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When return rule from "QA" to "Editorial"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Final PO Review - QA Return"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And user click on "" ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review - Editorial Response"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate return response comments

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #***************************************************************************************** SCENARIO-16***************************************************************************************************
  @EndToEndSubSequent16
  Scenario Outline: TC_20_21_Final MD_Editorial_QA_Testing_RETURN_Library
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final MD Review-Subsequent" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And click on "Generate Summaries"
    And user Enter Final MD Config Comments
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Editorial Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When return rule from "Editorial" to "MD"
    And navigate to My tasks and go to rule in instance "MyTasks" "PO Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And user click on "" ""
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user complete all Editorial Reviews ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When return rule from "QA" to "MD"
    And navigate to My tasks and go to rule in instance "MyTasks" "PO Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And user click on "" ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review - Final MD Response"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate return response comments
    When return rule from "QA" to "Editorial"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And user click on "" ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review - Editorial Response"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate return response comments

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #***************************************************************************************** SCENARIO-17***************************************************************************************************
  @EndToEndSubSequent17
  Scenario Outline: TC754_End to End Requires presentation
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL PO DEL-Subsequent MULTIPAYER2" and "<FilterValue>"
    When user select Rule with Multiple Payers "ONECPMPAYERSDB"
    And navigate to My tasks and go to rule in instance "" "PO Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And Select System Proposal "DEL" "Modify"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When click on Require Presentation "select" and validate
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    And click on "CPM Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Status" "Manual RMR"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #***************************************************************************************** SCENARIO-18***************************************************************************************************
  @EndToEndSubSequent18
  Scenario Outline: TC695_End to End_No logical change skipping custom and returning_Custom
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final MD Review-Subsequent" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    When user ADD Code "Billed With (And)","0006T"
    And Select System Proposal "" "No Action"
    Then Validate BOBW Config Link Submit "Billed With And"
    When click on "Generate Summaries"
    Then validate BOBW Grid Data and Retire Rule Validation
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    And click on "CPM Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Editorial Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When return rule from "Editorial" to "MD"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Final PO Review - Editorial Return"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "PO Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    And click on "CPM Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Editorial Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user complete all Editorial Reviews ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate CPT Changes in Database "NO"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Testing Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And Complete all testing Reviews
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Status" "Completed"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #***************************************************************************************** SCENARIO-19***************************************************************************************************
  @EndToEndSubSequent19
  Scenario Outline: TC608_End to End MD determined to retired_Library
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final MD Review-Subsequent" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And Select System Proposal "DEL" "Modify"
    When click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Editorial Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user complete all Editorial Reviews ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate CPT Changes in Database "NO"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Testing Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And Complete all testing Reviews
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Status" "Completed"

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  #***************************************************************************************** SCENARIO-20***************************************************************************************************
  @EndToEndSubSequent20 @PASS
  Scenario Outline: TC19_End to End_No_ChangeRequired_ MD Logical_CPM Non Logical_NoChange in Editorial Review_Status No Change Required
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final MD Review-Subsequent" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And Select CPM System Proposal "" "NO ACTION" ""
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    And click on "CPM Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Editorial Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user complete all Editorial Reviews "No Editorial Changes Required"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Status" "No Change Required"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @EndToEndSubSequent21 @FilterSubsequentRun
  Scenario Outline: verify Filters intial run and subsequent Admin
    Then validate Admin rule review value "Admin-Filter" "FINAL PO DEL-Subsequent" "" ""
    Then capture all filter values in "Codes:"
    And Apply filters in My Task Rule Work Queue "Codes" and ""
    And Apply filters in My Task Rule Work Queue "Impact Run" and "Initial Run"
    Then capture all filter values in "Category Codes:"
    And Apply filters in My Task Rule Work Queue "Category Codes" and ""
    Then capture all filter values in "Payers:"
    And Apply filters in My Task Rule Work Queue "Payers" and ""
    Then capture all filter values in "Topic:"
    And Apply filters in My Task Rule Work Queue "Topic" and ""
    Then capture all filter values in "Priority:"
    And Apply filters in My Task Rule Work Queue "Priority" and ""
    Then capture all filter values in "Medical Policies:"
    And Apply filters in My Task Rule Work Queue "Medical Policies" and ""
    Then capture all filter values in "Decision Points:"
    And Apply filters in My Task Rule Work Queue "Decision Points" and ""
    Then capture all filter values in "Rules:"
    And Apply filters in My Task Rule Work Queue "Rules" and ""
    And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    And click on "Reset"

    #And select "Filterd-RuleID"
    #And click on "Clear"
    #And set "Unset No change required" in MD Review
    #Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Status" "Started"
    Examples: 
      | FiterName                                                                      | FilterValue                                                      |
      | Library Status;Rules With ARDs;Assignees;Task Status;Proposal Types;Impact Run | Custom;Exclude;iht_ittest01;Not Started;Deleted;Subsequent Run 1 |


  @EndToEndSubSequent22 @FilterSubsequentRun
  Scenario Outline: verify Filters MD subsequent
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    Then capture all filter values in "Codes:"
    And Apply filters in My Task Rule Work Queue "Codes" and ""
    Then capture all filter values in "Category Codes:"
    And Apply filters in My Task Rule Work Queue "Category Codes" and ""
    Then capture all filter values in "Payers:"
    And Apply filters in My Task Rule Work Queue "Payers" and ""
    Then capture all filter values in "Topic:"
    And Apply filters in My Task Rule Work Queue "Topic" and ""
    Then capture all filter values in "Priority:"
    And Apply filters in My Task Rule Work Queue "Priority" and ""
    Then capture all filter values in "Medical Policies:"
    And Apply filters in My Task Rule Work Queue "Medical Policies" and ""
    Then capture all filter values in "Decision Points:"
    And Apply filters in My Task Rule Work Queue "Decision Points" and ""
    Then capture all filter values in "Rules:"
    And Apply filters in My Task Rule Work Queue "Rules" and ""
    And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    And click on "Reset"

    Examples: 
      | FiterName                                                                      | FilterValue                                                      |
      | Library Status;Rules With ARDs;Assignees;Task Status;Proposal Types;Impact Run | Custom;Exclude;iht_ittest01;Not Started;Deleted;Subsequent Run 1 |

  @EndToEndSubSequent23 @FilterSubsequentRun
  Scenario Outline: verify Filters Testing subsequent
    When user click on "Testing Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    Then capture all filter values in "Codes:"
    And Apply filters in My Task Rule Work Queue "Codes" and ""
    Then capture all filter values in "Category Codes:"
    And Apply filters in My Task Rule Work Queue "Category Codes" and ""
    Then capture all filter values in "Payers:"
    And Apply filters in My Task Rule Work Queue "Payers" and ""
    Then capture all filter values in "Topic:"
    And Apply filters in My Task Rule Work Queue "Topic" and ""
    Then capture all filter values in "Priority:"
    And Apply filters in My Task Rule Work Queue "Priority" and ""
    Then capture all filter values in "Medical Policies:"
    And Apply filters in My Task Rule Work Queue "Medical Policies" and ""
    Then capture all filter values in "Decision Points:"
    And Apply filters in My Task Rule Work Queue "Decision Points" and ""
    Then capture all filter values in "Rules:"
    And Apply filters in My Task Rule Work Queue "Rules" and ""
    And click on "Reset"

    Examples: 
      | FiterName                                                                      | FilterValue                                                      |
      | Impact Run;Library Status;Rules With ARDs;Assignees;Task Status;Proposal Types | Subsequent Run 1;Custom;Exclude;iht_ittest01;Not Started;Deleted |

  @EndToEndSubSequent24 @FilterSubsequentRun
  Scenario Outline: verify Filters QA subsequent
    When user click on "QA Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    Then capture all filter values in "Codes:"
    And Apply filters in My Task Rule Work Queue "Codes" and ""
    Then capture all filter values in "Category Codes:"
    And Apply filters in My Task Rule Work Queue "Category Codes" and ""
    Then capture all filter values in "Payers:"
    And Apply filters in My Task Rule Work Queue "Payers" and ""
    Then capture all filter values in "Topic:"
    And Apply filters in My Task Rule Work Queue "Topic" and ""
    Then capture all filter values in "Priority:"
    And Apply filters in My Task Rule Work Queue "Priority" and ""
    Then capture all filter values in "Medical Policies:"
    And Apply filters in My Task Rule Work Queue "Medical Policies" and ""
    Then capture all filter values in "Decision Points:"
    And Apply filters in My Task Rule Work Queue "Decision Points" and ""
    Then capture all filter values in "Rules:"
    And Apply filters in My Task Rule Work Queue "Rules" and ""
    And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    And click on "Reset"

    Examples: 
      | FiterName                                                                      | FilterValue                                                      |
      | Library Status;Rules With ARDs;Assignees;Task Status;Proposal Types;Impact Run | Custom;Exclude;iht_ittest01;Not Started;Deleted;Subsequent Run 1 |

  @EndToEndSubSequent25 @FilterSubsequentRun
  Scenario Outline: verify Filters Configuration subsequent
    When user click on "Configuration Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    Then capture all filter values in "Codes:"
    And Apply filters in My Task Rule Work Queue "Codes" and ""
    Then capture all filter values in "Category Codes:"
    And Apply filters in My Task Rule Work Queue "Category Codes" and ""
    Then capture all filter values in "Payers:"
    And Apply filters in My Task Rule Work Queue "Payers" and ""
    Then capture all filter values in "Topic:"
    And Apply filters in My Task Rule Work Queue "Topic" and ""
    Then capture all filter values in "Priority:"
    And Apply filters in My Task Rule Work Queue "Priority" and ""
    Then capture all filter values in "Medical Policies:"
    And Apply filters in My Task Rule Work Queue "Medical Policies" and ""
    Then capture all filter values in "Decision Points:"
    And Apply filters in My Task Rule Work Queue "Decision Points" and ""
    Then capture all filter values in "Rules:"
    And Apply filters in My Task Rule Work Queue "Rules" and ""
    And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    And click on "Reset"

    Examples: 
      | FiterName                                                                      | FilterValue                                                      |
      | Library Status;Rules With ARDs;Assignees;Task Status;Proposal Types;Impact Run | Custom;Exclude;iht_ittest01;Not Started;Deleted;Subsequent Run 1 |
      
      
       @EndToEndSubSequent26 @FilterSubsequentRun
  Scenario Outline: verify Filters CPM Review subsequent
    When user click on "CPM Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    Then capture all filter values in "Codes:"
    And Apply filters in My Task Rule Work Queue "Codes" and ""
    Then capture all filter values in "Category Codes:"
    And Apply filters in My Task Rule Work Queue "Category Codes" and ""
    Then capture all filter values in "Payers:"
    And Apply filters in My Task Rule Work Queue "Payers" and ""
    Then capture all filter values in "Topic:"
    And Apply filters in My Task Rule Work Queue "Topic" and ""
    Then capture all filter values in "Priority:"
    And Apply filters in My Task Rule Work Queue "Priority" and ""
    Then capture all filter values in "Medical Policies:"
    And Apply filters in My Task Rule Work Queue "Medical Policies" and ""
    Then capture all filter values in "Decision Points:"
    And Apply filters in My Task Rule Work Queue "Decision Points" and ""
    Then capture all filter values in "Rules:"
    And Apply filters in My Task Rule Work Queue "Rules" and ""
    And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    And click on "Reset"

    Examples: 
      | FiterName                                                                      | FilterValue                                                      |
      | Library Status;Rules With ARDs;Assignees;Task Status;Proposal Types;Impact Run | Custom;Exclude;iht_ittest01;Not Started;Deleted;Subsequent Run 1 |
      
      
        
       @EndToEndSubSequent27 @FilterSubsequentRun
  Scenario Outline: verify Filters Editorial Review subsequent
    When user click on "Editorial Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    Then capture all filter values in "Codes:"
    And Apply filters in My Task Rule Work Queue "Codes" and ""
    Then capture all filter values in "Category Codes:"
    And Apply filters in My Task Rule Work Queue "Category Codes" and ""
    Then capture all filter values in "Payers:"
    And Apply filters in My Task Rule Work Queue "Payers" and ""
    Then capture all filter values in "Topic:"
    And Apply filters in My Task Rule Work Queue "Topic" and ""
    Then capture all filter values in "Priority:"
    And Apply filters in My Task Rule Work Queue "Priority" and ""
    Then capture all filter values in "Medical Policies:"
    And Apply filters in My Task Rule Work Queue "Medical Policies" and ""
    Then capture all filter values in "Decision Points:"
    And Apply filters in My Task Rule Work Queue "Decision Points" and ""
    Then capture all filter values in "Rules:"
    And Apply filters in My Task Rule Work Queue "Rules" and ""
    And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    And click on "Reset"

    Examples: 
      | FiterName                                                                      | FilterValue                                                      |
      | Library Status;Rules With ARDs;Assignees;Task Status;Proposal Types;Impact Run | Custom;Exclude;iht_ittest01;Not Started;Deleted;Subsequent Run 1 |
      
      
