#Author:
@CPMRegression @Regression 
Feature: CPM SUMMARIES

  Background: 
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen

  @CPMSummaries01
  Scenario Outline: TC_01_CPM_Summaries ***
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL PO DEL MULTIPAYER2" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
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
    Then Impact Code List Griddata and modify decision "CPM Summaries"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @CPMSummaries02 @Nowrun
  Scenario Outline: TC_02_CPM_Summaries_CPT_ARD***
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    #And Apply filters in My Task and Retrive Rule in DB "FINAL PO DEL MULTIPAYER2" and "<FilterValue>"
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    Then validate CPT ARD Link in CPM
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;Y |

  @CPMSummaries03 @Satnightdecrel4
  Scenario Outline: TC_05_CPM Summaries_ Warnings_ReqPresentation ***
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL PO DEL MULTIPAYER2" and "<FilterValue>"
    When user select Rule with Multiple Payers "ONECPMPAYERSDB"
    And navigate to My tasks and go to rule in instance "" "PO Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "CPM Review"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When click on Require Presentation "select" and validate
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @CPMSummaries04 @Decrelmonrun
  Scenario Outline: TC_07_CPM Summaries_ Retire Rule_All CPM_Agree_RMR Generated ***
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL PO DEL MULTIPAYER2" and "<FilterValue>"
    When user select Rule with Multiple Payers "ONECPMPAYERSDB"
    And navigate to My tasks and go to rule in instance "" "PO Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    When create versioned Rule "RetireRuleWithNoVersion"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "CPM Review"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "RetireRule"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "CPM Review Work Queue" for "FINAL PO DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "RetireRule"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Status" "Manual RMR"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @CPMSummaries05
  Scenario Outline: TC_08_CPM Summaries_WithPayerSpecDecision
  TC_11_CPM Summaries_PPMD2674 _provide correct message multiple CPM exist_took payer specific decisions
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL PO DEL MULTIPAYER2" and "<FilterValue>"
    When user select Rule with Multiple Payers "MULTIPAYERSINGLECPM"
    And navigate to My tasks and go to rule in instance "" "PO Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "CPM Review"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When user select different decisions at payer level
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    Then validate Config Summary Payer Specific Decision
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Status" "Manual RMR"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @CPMSummaries06 @Satnightdecrel4
  Scenario Outline: TC_10_CPM Summaries_ Retire Rule_DisAgree
  									TC682 U_CPM Summaries_ Retire Rule_DisAgree
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL PO DEL MULTIPAYER2" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
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
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  

  @CPMSummaries08
  Scenario Outline: TC_12_CPM Summaries_PPMD2764 provide correct msge config summary is not populated CPM1 Rule is set to Req Presention
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
    When click on Require Presentation "select" and validate
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "CPM Review Work Queue" for "FINAL MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    Then validate Config Summary Payer Specific Decision
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Status" "Manual RMR"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @CPMSummaries09
  Scenario Outline: TC_13_CPM Summaries_PPMD2764 provide correct msg config smary is not populated Multiple CPMs Obsolete Payer exists on the rule
     When user click on "PO Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL MD DEL MULTIPAYER2" and "<FilterValue>"
    When user select Rule with Multiple Payers "ONECPMOBSOLETE"
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
    When user Complete CPM Decesion "Agree"
    Then validate Config Summary Payer Specific Decision
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Status" "Manual RMR"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @CPMSummaries10****
  Scenario Outline: TC_14_CPM Summaries_PPMD-2674 _provide correct msg  to  config sumary is not popultd multiple CPM Reviws exst_ ARD Rule
      When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "CPM Review"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When user select different decisions at payer level
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    Then validate Config Summary Payer Specific Decision
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Status" "Manual RMR"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;Y |