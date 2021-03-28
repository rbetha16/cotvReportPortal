#Author:
@DecisionCapture  @Octfix18run
Feature: Decision Capture

  @DC25U7
  Scenario: TC_25_DC_U_7.0_Rule Review Request_Link and 7.5_Rule Review Request_Go TO Rule search
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And user navigate to IU "Admin" Instances Screen
    When click on "FINAL PO DEL" instance in Admin and navigate to Rule Review Page
    When user retrieve non candiate rules to rule review "NO"
    And navigate to My tasks and go to rule in instance "MyTasks" "PO Review Work Queue" "FINAL PO DEL"
    Then validate rule in rule review screen "No"
    When user retrieve non candiate rules to rule review "YES"
    Then validate rule in rule review screen "YES"
    And User should be Logged out from IU Application

  @DCTC1047
  Scenario Outline: TC1047_DC_MD Reviews Generate summery
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
     When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "DEL" "Remove"
    Then validate Generate summaries button enabled
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    And User should be Logged out from IU Application

     Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @DecisionCapture
  Scenario Outline: TC1058_PPMD 1807 No Decision On fianl MD Rule Scenario 1
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
     When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    Then validate NoDecision Error and Confirm
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    Then Validate CPM Data "empty"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @DecisionCapture @TC1046
  Scenario: TC1046_DC_21_3_Roll Up Rows
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    #And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    And select "RuleID"
    #And click on "Start Review"
    #When user Modify Decisions
    Then validate Roll Up Functionality ""
    And User should be Logged out from IU Application

  @DecisionCapture @TC1036
  Scenario Outline: TC1036_DC_20_3_Decision value on proposal Type
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    #And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    #And click on "Start Review"
    Then validate decesion and proposal type list items
    And User should be Logged out from IU Application

     Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @DecisionCapture
  Scenario Outline: TC1045_DC_PPMD-4969_Ability to navigate to work queue after a rule is set to No Change Required
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And click on "No Change Required"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Status" "No Change Required"
    And User should be Logged out from IU Application

      Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @DecisionCapture
  Scenario Outline: TC1052_DC_Final PO Review of Preliminary Decisions
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Preliminary MD Review" for "PRELIM PO DEL" Instance
    And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    #And enter Preliminary MD Comments
    #And Select System Proposal "DEL" "No Action"
    #And click on "Generate Summaries"
    #And click on "Authorize Decisions"
    #And User should be Logged out from IU Application
    #Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    #And user navigate to IU "MyTasks" Instances Screen
    #When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    #And select "RuleID"
    #And click on "Start Review"
    #And Complete Preliminary Peer MD Comments
    #And User should be Logged out from IU Application
    #Given user logs into "QA" with "iht_ittest03" into Interpretive Update Application
    #And user navigate to IU "MyTasks" Instances Screen
    #When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    #And select "RuleID"
    #And click on "Start Review"
    #Then validate Decision Editable
    #And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue |
      | FilterTaskStatus | Not Started |

  @TC12LibRoCustRule
  Scenario Outline: TC_12_Decision_Lib_Ro_Cust_rule
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "Custom;Not Started;N"
    And select "RuleID"
    And click on "Start Review"
    #And Get Decision Values "Custom"
    #And user navigate to IU "MyTasks" Instances Screen
    #When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    #And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "Library;Not Started;N"
    #And Get Decision Values "Library"
    #Then compare Custom Rule and Library Rule
    #And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @TCDC15BulkDecision
  Scenario Outline: TC_15_DC_Bulk_Decision
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    #Then Bulk Decision Error Check
    #Then Bulk Decision Not Started Status
    #Then Bulk Decision Valid Status
    #Then Bulk Decision Rule Check
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @TCDC20RuleRequest
  Scenario Outline: TC_20_DC_Rule_Review_Request
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "SINGLEPAYER" and "Custom;Not Started;N"
    #Then user navigate Task to Rule Review and Validate Messeage "Errormsg"
    #And Apply filters in My Task and Retrive Rule in DB "SINGLEPAYER" and "Custom;Not Started;N"
    #When user retrieve non candiate rules to rule review "NO"
    #Then user navigate Task to Rule Review and Validate Messeage "Errormsg"
      And User should be Logged out from IU Application

       Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |
      
      
  @TCDC21CheckDeactivateRule
  Scenario: To Validate the Error Message for Deactive rule
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "DEACTIVATE RULE" and "Library;Not Started;N"
    And select "RuleID"
   Then validate Deactivate error message 
   Then validate Admin rule review value in DB "FINAL PO DEL" "Status" "Deactivated"
    And User should be Logged out from IU Application
   
 
  @TCDC22ValidatePrelimComments
  Scenario Outline: TC_22_DC_Rule Display - Main View_Comments section for Final PO Review After Prelim
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
     When user click on "Preliminary MD Review" for "PRELIM PO DEL" Instance
    And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    When user select Rule with "Preliminary MD Review"
    And click on "Start Review"
    And Select System Proposal "DEL" "No Action"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Peer Review"
    Then validate Admin rule review value "Admin" "AE PRELIM MD DEL" "Task" "Final PO Review After Preliminary"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest03" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    Then validate System Proposals comments ""
    And User should be Logged out from IU Application

    Examples: 
      | FiterName       | FilterValue                 | Task                 | Status      | Assignee     |
      | MedicalPolicies | Bilateral Procedures Policy | Final MD Peer Review | Not Started | iht_ittest01 |



	@TCDC31  @Octfix15run
  Scenario Outline: TC_31_Rule Review Request_New rule
  									U_7.0_Rule Review Request_New rule
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Get System Proposal Types ""
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
    And update QA Rule and click on QA Review Complete "NO"
    And Get New Rule Version in QA
    And user Click on QA Review Complete "YES"
    When click on "FINAL PO DEL" instance in Admin and navigate to Rule Review Page 
    When user click on Rule Request for "New MidRule"
    And navigate to My tasks and go to rule in instance "MyTasks" "PO Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Get System Proposal Types ""
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |
      
      

   