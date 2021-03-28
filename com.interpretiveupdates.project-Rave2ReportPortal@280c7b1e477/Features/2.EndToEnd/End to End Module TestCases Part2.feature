#Author: trinath.kumar@cotiviti.com
@Regression @EndtToEndPart2
Feature: End to End Scenarios part 2

  Background: 
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen

  #***************************************************************************************** SCENARIO-01***************************************************************************************************
  @EndToEnd1 @Sanity
  Scenario Outline: TC19_End to End_No_ChangeRequired_Custom
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

  #***************************************************************************************** SCENARIO-02 ***************************************************************************************************
  @EndToEnd2 @Sanity
  Scenario Outline: TC19_End to End_No_ChangeRequired_DEL_NoLogical_Editorial Not Completed_Move to Editorial
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "Editorial Review"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #***************************************************************************************** SCENARIO-03 ***************************************************************************************************
  @EndToEnd3 
  Scenario Outline: TC19_End to End_No_ChangeRequired_DEL_NoLogical_Move to QA
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "Update Tabs"
    And Select System Proposal "" "No Action"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "QA Review"

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  #***************************************************************************************** SCENARIO-04***************************************************************************************************
  @EndToEnd4
  Scenario Outline: TC19_End to End_No_ChangeRequired_Library
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
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  #***************************************************************************************** SCENARIO-05***************************************************************************************************
  @EndToEnd5
  Scenario Outline: TC19_End to End_No_ChangeRequired_Not_DEL_NoLogical_Move to No Change required
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "" "No Action"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Status" "No Change Required"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #***************************************************************************************** SCENARIO-06***************************************************************************************************
  @EndToEnd6 @Sanity
  Scenario Outline: TC2067_End to End Manual add and Remove_Library_Codes_Copied_To_Custom_Rule_Validations_1_Library
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "Update Tabs"
    And Select System Proposal "" "No Action"
    When user ADD Code "Billed With (And)","0009M"
    Then Validate BOBW Config Link Submit "Billed With And"
    And click on "Generate Summaries"
    Then validate BOBW Grid Data and Retire Rule Validation
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    Then validate Review Segment "QA" "BW And/BWO Or Logic" "YES"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "NO"
    Then validate CPT Changes in Database "YES"
    And user Click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Testing Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When return rule from "Testing" to "QA"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review - Testing Return"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And user click on "" ""
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "Testing Review - QA Response"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When return rule from "Testing" to "PO"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "Final PO Review - Testing Return"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Status" "Not Started"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  #***************************************************************************************** SCENARIO-07***************************************************************************************************
  @EndToEnd7 
  Scenario Outline: TC2067_End to End Manual add and Remove_Library_Codes_Copied_To_Custom_Rule_Validations_2_Library
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "Update Tabs"
    And Select System Proposal "" "No Action"
    When user ADD Code "Billed With (And)","0009M"
    Then Validate BOBW Config Link Submit "Billed With And"
    And click on "Generate Summaries"
    Then validate BOBW Grid Data and Retire Rule Validation
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    Then validate Review Segment "QA" "BW And/BWO Or Logic" "YES"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "NO"
    Then validate CPT Changes in Database "YES"
    And user Click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Testing Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When return rule from "Testing" to "PO"
    And navigate to My tasks and go to rule in instance "MyTasks" "PO Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And user click on "" ""
    Then validate Return Response Comments "Testing" "Test Automation Comments"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "Testing Review - Final PO Response"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    Then user Upload File in TestingReview and validate
    And Complete all testing Reviews
    Then validate Admin rule review value in DB "FINAL PO DEL" "Status" "Completed"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  #***************************************************************************************** SCENARIO-08***************************************************************************************************
  @EndToEnd8 
  Scenario Outline: TC_7_4_Additional Configuration_Library
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "" "No Action"
    And click on "Generate Summaries"
    And user Enter Final MD Config Comments
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Configuration Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Configuration Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And complete all Config Reviews
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review - Post Configuration"

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  #***************************************************************************************** SCENARIO-09***************************************************************************************************
  @EndToEnd9 
  Scenario Outline: TC_7_2_Editorial verification_New_Rule_Version_Library
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "Update Tabs"
    And Select System Proposal "" "No Action"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    When create versioned Rule "Yes"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then validate Editorial Changes in Database "SUB_RULE_DESC;SUB_RULE_NOTES;SUB_RULE_SCRIPT;SUB_RULE_RATIONALE;REFERENCE"

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  #***************************************************************************************** SCENARIO-10***************************************************************************************************
  @EndToEnd10 
  Scenario Outline: TC_7_2_Editorial verification_Library
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "Update Tabs"
    And Select System Proposal "" "No Action"
    And Select System Proposal "" "Modify"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
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
  @EndToEnd11 
  Scenario Outline: TC_6_7_System suggested to retire MD diagreed_Custom
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "" "No Action"
    And Select System Proposal "DEL" "Remove"
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
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    
    
    #And retire rule validation in DB "loRuleID_EE_TC6_7" "12/31/9999" "No"
    
    
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "NO"
    Then validate CPT Changes in Database "YES"
    And user Click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Testing Review"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #***************************************************************************************** SCENARIO-12***************************************************************************************************
  @EndToEnd12
  Scenario Outline: TC_6_6_System suggested to r	etire MD agreed by chagning the parameters_Custom
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "" "No Action"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
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
  @EndToEnd13 @Sanity
  Scenario Outline: TC_6_5_Additional Configuration_Custom
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
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
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Configuration Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Configuration Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And complete all Config Reviews
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review - Post Configuration"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #***************************************************************************************** SCENARIO-14***************************************************************************************************
  @EndToEnd14Ap @PASS @Sanity
  Scenario Outline: TC_6_2_Editorial verification_Custom
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "Update Tabs"
    And Select System Proposal "DEL" "Remove"
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
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then validate Editorial Changes in Database "SUB_RULE_DESC;SUB_RULE_NOTES;SUB_RULE_SCRIPT;SUB_RULE_RATIONALE;REFERENCE"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #***************************************************************************************** SCENARIO-15***************************************************************************************************
  @EndToEnd15
  Scenario Outline: TC_20_21_Final MD_Editorial_QA_Testing_RETURN_Custom_Rule
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
    When return rule from "Editorial" to "PO"
    And navigate to My tasks and go to rule in instance "MyTasks" "PO Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And user click on "" ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Editorial Review - Final PO Response"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When user complete all Editorial Reviews ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When return rule from "QA" to "PO"
    And navigate to My tasks and go to rule in instance "MyTasks" "PO Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And user click on "" ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review - Final PO Response"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When return rule from "QA" to "Editorial"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Editorial Review - QA Return"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And user click on "" ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review - Editorial Response"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    Then validate return response comments

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #***************************************************************************************** SCENARIO-16***************************************************************************************************
  @EndToEnd16
  Scenario Outline: TC_20_21_Final MD_Editorial_QA_Testing_RETURN_Library
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And click on "Generate Summaries"
    And user Enter Final MD Config Comments
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Editorial Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When return rule from "Editorial" to "PO"
    And navigate to My tasks and go to rule in instance "MyTasks" "PO Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And user click on "" ""
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When user complete all Editorial Reviews ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When return rule from "QA" to "PO"
    And navigate to My tasks and go to rule in instance "MyTasks" "PO Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And user click on "" ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review - Final PO Response"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    Then validate return response comments
    When return rule from "QA" to "Editorial"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And user click on "" ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review - Editorial Response"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    Then validate return response comments

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Library;Not Started;N |

  #***************************************************************************************** SCENARIO-17***************************************************************************************************
  @EndToEnd17
  Scenario Outline: TC754_End to End Requires presentation
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL PO DEL MULTIPAYER2" and "<FilterValue>"
    When user select Rule with Multiple Payers "ONECPMPAYERSDB"
    And navigate to My tasks and go to rule in instance "" "PO Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And Select System Proposal "DEL" "Modify"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When click on Require Presentation "select" and validate
   
    Then validate Admin rule review value in DB "FINAL PO DEL" "Status" "Requires presentation"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #***************************************************************************************** SCENARIO-18***************************************************************************************************
  @EndToEnd18
  Scenario Outline: TC695_End to End_No logical change skipping custom and returning_Custom
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    When user ADD Code "Billed With (And)","0006T"
    And Select System Proposal "" "No Action"
    Then Validate BOBW Config Link Submit "Billed With And"
    When click on "Generate Summaries"
    Then validate BOBW Grid Data and Retire Rule Validation
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
    When return rule from "Editorial" to "PO"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Final PO Review - Editorial Return"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "PO Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When click on "Generate Summaries"
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
    Then validate CPT Changes in Database "NO"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Testing Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And Complete all testing Reviews
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Status" "Completed"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #***************************************************************************************** SCENARIO-19***************************************************************************************************
  @EndToEnd19
  Scenario Outline: TC608_End to End MD determined to retired_Library
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And Select System Proposal "DEL" "Modify"
    When click on "Generate Summaries"
    And click on "Authorize Decisions"
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
    Then validate CPT Changes in Database "NO"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Testing Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And Complete all testing Reviews
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Status" "Completed"

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  #***************************************************************************************** SCENARIO-20***************************************************************************************************
  @EndToEnd20Test @PASS @Sanity
  Scenario Outline: TC19_End to End_No_ChangeRequired_ MD Logical_CPM Non Logical_NoChange in Editorial Review_Status No Change Required
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And Select CPM System Proposal "" "NO ACTION" ""
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    And click on "CPM Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Editorial Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When user complete all Editorial Reviews "No Editorial Changes Required"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Status" "No Change Required"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #@EndToEnd21 
  #Scenario Outline: verify Filters IntailRun
    #When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    #Then capture all filter values in "Codes:"
    #And Apply filters in My Task Rule Work Queue "Codes" and ""
    #Then capture all filter values in "Category Codes:"
    #And Apply filters in My Task Rule Work Queue "Category Codes" and ""
    #Then capture all filter values in "Payers:"
    #And Apply filters in My Task Rule Work Queue "Payers" and ""
    #Then capture all filter values in "Topic:"
    #And Apply filters in My Task Rule Work Queue "Topic" and ""
    #Then capture all filter values in "Priority:"
    #And Apply filters in My Task Rule Work Queue "Priority" and ""
    #Then capture all filter values in "Medical Policies:"
    #And Apply filters in My Task Rule Work Queue "Medical Policies" and ""
    #Then capture all filter values in "Decision Points:"
    #And Apply filters in My Task Rule Work Queue "Decision Points" and ""
    #Then capture all filter values in "Rules:"
    #And Apply filters in My Task Rule Work Queue "Rules" and ""
    #And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    #And click on "Reset"
#
    #Examples: 
      #| FiterName                                                                      | FilterValue                                                 |
      #| Library Status;Rules With ARDs;Assignees;Task Status;Proposal Types;Impact Run | Custom;Exclude;iht_ittest01;Not Started;Deleted;Initial Run |
#
  #@EndToEnd22 
  #Scenario Outline: verify Filters Testing IntialRun
    #When user click on "Testing Review Work Queue" for "FINAL PO DEL" Instance
    #And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    #Then capture all filter values in "Codes:"
    #And Apply filters in My Task Rule Work Queue "Codes" and ""
    #Then capture all filter values in "Category Codes:"
    #And Apply filters in My Task Rule Work Queue "Category Codes" and ""
    #Then capture all filter values in "Payers:"
    #And Apply filters in My Task Rule Work Queue "Payers" and ""
    #Then capture all filter values in "Topic:"
    #And Apply filters in My Task Rule Work Queue "Topic" and ""
    #Then capture all filter values in "Priority:"
    #And Apply filters in My Task Rule Work Queue "Priority" and ""
    #Then capture all filter values in "Medical Policies:"
    #And Apply filters in My Task Rule Work Queue "Medical Policies" and ""
    #Then capture all filter values in "Decision Points:"
    #And Apply filters in My Task Rule Work Queue "Decision Points" and ""
    #Then capture all filter values in "Rules:"
    #And Apply filters in My Task Rule Work Queue "Rules" and ""
    #And click on "Reset"
#
    #Examples: 
      #| FiterName                                                                                 | FilterValue                                                          |
      #| Impact Run;Library Status;Rules With ARDs;Assignees;Task Status;Proposal Types;Impact Run | Subsequent Run 1;Custom;Exclude;iht_ittest01;Not Started;Initial Run |
#
  #@EndToEnd23 @FilterIntialRun
  #Scenario Outline: verify Filters QA IntialRun
    #When user click on "QA Review Work Queue" for "FINAL PO DEL" Instance
    #Then capture all filter values in "Codes:"
    #And Apply filters in My Task Rule Work Queue "Codes" and ""
    #Then capture all filter values in "Category Codes:"
    #And Apply filters in My Task Rule Work Queue "Category Codes" and ""
    #Then capture all filter values in "Payers:"
    #And Apply filters in My Task Rule Work Queue "Payers" and ""
    #Then capture all filter values in "Topic:"
    #And Apply filters in My Task Rule Work Queue "Topic" and ""
    #Then capture all filter values in "Priority:"
    #And Apply filters in My Task Rule Work Queue "Priority" and ""
    #Then capture all filter values in "Medical Policies:"
    #And Apply filters in My Task Rule Work Queue "Medical Policies" and ""
    #Then capture all filter values in "Decision Points:"
    #And Apply filters in My Task Rule Work Queue "Decision Points" and ""
    #Then capture all filter values in "Rules:"
    #And Apply filters in My Task Rule Work Queue "Rules" and ""
    #And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    #And click on "Reset"
#
    #Examples: 
      #| FiterName                                                                      | FilterValue                                                 |
      #| Library Status;Rules With ARDs;Assignees;Task Status;Proposal Types;Impact Run | Custom;Exclude;iht_ittest01;Not Started;Deleted;Initial Run |
#
  #@EndToEnd24 @FilterIntialRun
  #Scenario Outline: verify Filters Configuration IntialRun
    #When user click on "Configuration Review Work Queue" for "FINAL PO DEL" Instance
    #Then capture all filter values in "Codes:"
    #And Apply filters in My Task Rule Work Queue "Codes" and ""
    #Then capture all filter values in "Category Codes:"
    #And Apply filters in My Task Rule Work Queue "Category Codes" and ""
    #Then capture all filter values in "Payers:"
    #And Apply filters in My Task Rule Work Queue "Payers" and ""
    #Then capture all filter values in "Topic:"
    #And Apply filters in My Task Rule Work Queue "Topic" and ""
    #Then capture all filter values in "Priority:"
    #And Apply filters in My Task Rule Work Queue "Priority" and ""
    #Then capture all filter values in "Medical Policies:"
    #And Apply filters in My Task Rule Work Queue "Medical Policies" and ""
    #Then capture all filter values in "Decision Points:"
    #And Apply filters in My Task Rule Work Queue "Decision Points" and ""
    #Then capture all filter values in "Rules:"
    #And Apply filters in My Task Rule Work Queue "Rules" and ""
    #And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    #And click on "Reset"
#
    #Examples: 
      #| FiterName                                                                      | FilterValue                                                 |
      #| Library Status;Rules With ARDs;Assignees;Task Status;Proposal Types;Impact Run | Custom;Exclude;iht_ittest01;Not Started;Deleted;Initial Run |
#
  #@EndToEnd25 @FilterIntialRun
  #Scenario Outline: verify Filters CPM Review IntialRun
    #When user click on "CPM Review Work Queue" for "FINAL PO DEL" Instance
    #Then capture all filter values in "Codes:"
    #And Apply filters in My Task Rule Work Queue "Codes" and ""
    #Then capture all filter values in "Category Codes:"
    #And Apply filters in My Task Rule Work Queue "Category Codes" and ""
    #Then capture all filter values in "Payers:"
    #And Apply filters in My Task Rule Work Queue "Payers" and ""
    #Then capture all filter values in "Topic:"
    #And Apply filters in My Task Rule Work Queue "Topic" and ""
    #Then capture all filter values in "Priority:"
    #And Apply filters in My Task Rule Work Queue "Priority" and ""
    #Then capture all filter values in "Medical Policies:"
    #And Apply filters in My Task Rule Work Queue "Medical Policies" and ""
    #Then capture all filter values in "Decision Points:"
    #And Apply filters in My Task Rule Work Queue "Decision Points" and ""
    #Then capture all filter values in "Rules:"
    #And Apply filters in My Task Rule Work Queue "Rules" and ""
    #And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    #And click on "Reset"
#
    #Examples: 
      #| FiterName                                                                      | FilterValue                                                 |
      #| Library Status;Rules With ARDs;Assignees;Task Status;Proposal Types;Impact Run | Custom;Exclude;iht_ittest01;Not Started;Deleted;Initial Run |
#
  #@EndToEnd26 @FilterIntialRun
  #Scenario Outline: verify Filters Editorail Review IntialRun
    #When user click on "Editorial Review Work Queue" for "FINAL PO DEL" Instance
    #Then capture all filter values in "Codes:"
    #And Apply filters in My Task Rule Work Queue "Codes" and ""
    #Then capture all filter values in "Category Codes:"
    #And Apply filters in My Task Rule Work Queue "Category Codes" and ""
    #Then capture all filter values in "Payers:"
    #And Apply filters in My Task Rule Work Queue "Payers" and ""
    #Then capture all filter values in "Topic:"
    #And Apply filters in My Task Rule Work Queue "Topic" and ""
    #Then capture all filter values in "Priority:"
    #And Apply filters in My Task Rule Work Queue "Priority" and ""
    #Then capture all filter values in "Medical Policies:"
    #And Apply filters in My Task Rule Work Queue "Medical Policies" and ""
    #Then capture all filter values in "Decision Points:"
    #And Apply filters in My Task Rule Work Queue "Decision Points" and ""
    #Then capture all filter values in "Rules:"
    #And Apply filters in My Task Rule Work Queue "Rules" and ""
    #And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    #And click on "Reset"
#
    #Examples: 
      #| FiterName                                                                      | FilterValue                                                 |
      #| Library Status;Rules With ARDs;Assignees;Task Status;Proposal Types;Impact Run | Custom;Exclude;iht_ittest01;Not Started;Deleted;Initial Run |
#
  #@EndToEnd27 @FilterIntialRun
  #Scenario Outline: verify Filters intial run Admin
    #Then validate Admin rule review value "Admin-Filter" "FINAL PO DEL" "" ""
    #Then capture all filter values in "Codes:"
    #And Apply filters in My Task Rule Work Queue "Codes" and ""
    #Then capture all filter values in "Category Codes:"
    #And Apply filters in My Task Rule Work Queue "Category Codes" and ""
    #Then capture all filter values in "Payers:"
    #And Apply filters in My Task Rule Work Queue "Payers" and ""
    #Then capture all filter values in "Topic:"
    #And Apply filters in My Task Rule Work Queue "Topic" and ""
    #Then capture all filter values in "Priority:"
    #And Apply filters in My Task Rule Work Queue "Priority" and ""
    #Then capture all filter values in "Medical Policies:"
    #And Apply filters in My Task Rule Work Queue "Medical Policies" and ""
    #Then capture all filter values in "Decision Points:"
    #And Apply filters in My Task Rule Work Queue "Decision Points" and ""
    #Then capture all filter values in "Rules:"
    #And Apply filters in My Task Rule Work Queue "Rules" and ""
    #And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    #And click on "Reset"
#
    #Examples: 
      #| FiterName                                                                      | FilterValue                                                 |
      #| Library Status;Rules With ARDs;Assignees;Task Status;Proposal Types;Impact Run | Custom;Exclude;iht_ittest01;Not Started;Deleted;Initial Run |