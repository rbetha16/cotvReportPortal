#Author: trinath.kumar@cotiviti.com
@Config @Regression
Feature: Config Module

  Background: 
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen

  @Config01 @NBOct41
  Scenario Outline: TC1038_41_5_QA_Response to Config TC2104 41.3 Config Return Rule To QA
  When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
  And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
  And select "RuleID"
  And click on "Start Review"
  And Select System Proposal "" "No Action"
  And Complete Editorials with "No Editorial Changes"
  And click on "Generate Summaries"
  And user Enter Final MD Config Comments
  And click on "Authorize Decisions"
  Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review"
  When Reassign task "" "iht_ittest01"
  And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
  And select "RuleID"
  And click on "Start Review"
  Then validate CPT Changes in Database "NO"
  And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
  And update QA Rule and click on QA Review Complete "YES"
  Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Configuration Review"
  When Reassign task "" "iht_ittest01"
  And navigate to My tasks and go to rule in instance "MyTasks" "Configuration Review Work Queue" "FINAL PO DEL"
  And select "RuleID"
  And click on "Start Review"
  When return rule from "Configuration" to "QA"
  Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review - Config Return"
  When Reassign task "" "iht_ittest01"
  And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
  And select "RuleID"
  And click on "Start Review"
  And user click on "Return Rule Response" ""
  Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Configuration Review - QA Response"
  
  Examples:
  | FiterName        | FilterValue           |
  | FilterTaskStatus | Library;Not Started;N |
  
  @Config02
  Scenario Outline: TC2853_TC2854_Config Verification Adding Code to create a span and Adding Code to Existing span
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "DEL" "Remove"
    When user ADD Code "Billed With (Or)","01968-01990"
    And click on "Generate Summaries"
    Then validate BOBW Grid Data and Retire Rule Validation

    #And click on "Modify Decisions"
    #When user ADD Code "Billed With (Or)","01991"
    #And click on "Generate Summaries"
    #Then validate BOBW Grid Data and Retire Rule Validation
    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @Config03
  Scenario Outline: TC2855_Config Verification by Adding an individual code Custom
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And Select System Proposal "DEL" "Remove"
    When user ADD Code "Billed With (Or)","0019T"
    And click on "Generate Summaries"
    Then validate BOBW Grid Data and Retire Rule Validation
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @Config04
  Scenario Outline: TC2855_Config Verification by Adding an individual code Library
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And Select System Proposal "DEL" "Remove"
    When user ADD Code "Billed With (Or)","0019T"
    And click on "Generate Summaries"
    Then validate BOBW Grid Data and Retire Rule Validation
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Editorial Review"

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  @Config05
  Scenario Outline: TC2856_Config Verification by Adding BWA or BWO OR  to existing span
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "DEL" "Remove"
    When user ADD Code "Billed With (And)","0008M"
    Then Validate BOBW Config Link Submit "Billed With And"
    And click on "Generate Summaries"
    Then validate BOBW Grid Data and Retire Rule Validation

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @Config06
  Scenario Outline: TC2857_Config Verification by Adding BWA or BWO OR Individual Code
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    When user ADD Code "Billed With (And)","A5082"
    Then Validate BOBW Config Link Submit "Billed With And"
    And click on "Generate Summaries"
    Then validate BOBW Grid Data and Retire Rule Validation

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @Config07 @DryRun
  Scenario Outline: TC2858_Config Verification by Remove an existing code from a span
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And user Remove "0010M"
    And click on "Generate Summaries"
    Then validate BOBW Grid Data and Retire Rule Validation

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @Config08
  Scenario Outline: TC2859_Config Verification by Do Not Add (Remove Code) a new code which exists in a span
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And user Remove "01991"
    And click on "Generate Summaries"
    Then validate BOBW Grid Data and Retire Rule Validation

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |
      
      