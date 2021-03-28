@Regression @CPMDecision
Feature: CPM DECISION MODULE

  @TCCPM05
  Scenario Outline: TC_05_CPM_Reassignment
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And Select System Proposal "DEL" "Remove"
    And Complete Editorials with "No Editorial Changes"
    And click on "Generate Summaries"
    And user Enter Final MD Config Comments
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    When user CPM Reassignment to "iht_ittest02"
    #Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"
    #Then validate Rule review value row wise "1" "CPM Review" "Not Started" "iht_ittest02"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "CPM Review"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Status" "Not Started"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Assignee" "iht_ittest02"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @TCCPM01 @Jan28nightrun
  Scenario Outline: TC_01_CPM Decisions
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL PO DEL MULTIPAYER2" and "<FilterValue>"
    When user select Rule with Multiple Payers "TWOCPMPAYERSDB"
    And navigate to My tasks and go to rule in instance "MyTasks" "PO Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "Modify"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When click on Require Presentation "SELECTFIRST" and validate
    Then validate CPM Decision and MD Recommendation
    Then user validate "Payer CPM Proposals" ""
    Then user validate "Presentation Warning" ""
    When click on Require Presentation "UNSELECTFIRST" and validate
    When user select different decisions at payer level
    And set CPM Decision as MD Recommendation
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Editorial Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When return rule from "Editorial" to "CPM"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "CPM Review - Editorial Return"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @TC2217 @Jan28nightrun
  Scenario Outline: PPMD-2217 _IU_ CPM review after final MD takes no deicsin, CPM system proposal grid should not auto populate the decisions
    							TC613_CPM_PPMD-2217 _IU_ CPM review after final MD takes no decisionCPM system proposal grid should not auto populate decisions

    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And Complete Editorials with "No Editorial Changes"
    And click on "Generate Summaries"
    And user Enter Final MD Config Comments
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And set CPM Decision as MD Recommendation
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @TC5428 @Jan28nightrun
  Scenario Outline: PPMD 5428 - Ability to show both MD and CPM details in BW And or BWO(Or) screen - when both have worked on saperate proposals.
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    When user ADD Code "Billed With (And)","0009M"
    When user ADD Code "Billed Without (Or)","0009M"
    And user Modify Code "MD MANUAL PROPOSALS" "" "No Decision"
    Then user click on Generate Summaries and validate Error message "MD"
    Then validate BOBW Config Link and Submit
    And click on "Generate Summaries"
    And Complete Editorials with "No Editorial Changes"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And user Modify Code "CPM MANUALPROPOSALS NOSAVE" "" "NO DECISION"
    Then user click on CPM Decision Complete and validate Error message "EmptyNoDecisionError"
    And user Modify Code "CPM MANUAL PROPOSALS" "" "MANUAL ADD"
    Then user click on CPM Decision Complete and validate Error message "CPM"
    Then validate BOBW Config Link and Submit
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    Then validate user in BWBWO Config Link "CPM" "iht_ittest01"
    When user Completed Authorize Decisions "CPM Summaries"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @TC740 @Jan28nightrun
  Scenario Outline: TC740- PPMD5425_CPM should get alert for BW BWO link if not completed
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "" "No Action"
    When user ADD Code "Billed With (And)","0006T"
    Then validate BOBW Config Link and Submit
    And user Modify Code "MD MANUAL PROPOSALS" "" "No Decision"
    Then validate user in BWBWO Config Link "NOLINK" "LinkName"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And user Modify Code "CPM MANUAL PROPOSALS" "" "MANUAL ADD"
     Then user click on CPM Decision Complete and validate Error message "CPM"
    #Then user click on CPM Decision Complete and validate Error message "SYSTEMPROPASAL","MANUAL ADD"
    Then validate BOBW Config Link and Submit
    When user Complete CPM Decesion "Agree"
    Then validate user in BWBWO Config Link "CPM" "iht_ittest01"
    And click on "Generate Summaries"
    
    When user Completed Authorize Decisions "CPM Summaries"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @TC941
  Scenario Outline: TC941- PPMD - 6780 - CPM Review - Unable to complete Billed with AND or Billed without OR screen
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "" "No Action"
    When user ADD Code "Billed With (And)","0006T"
    Then validate BOBW Config Link and Submit
    And user Modify Code "MD MANUAL PROPOSALS" "" "No Decision"
    Then validate user in BWBWO Config Link "NO" "LinkName"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When user Modify CPM Manual Proposals "NO DECISION","MANUAL ADD"
    Then Validate BOBW Config Link Submit "BWOLinkAvail"
    When user Modify CPM Manual Proposals "NO DECISION","DO NOT ADD"
    Then Validate BOBW Config Link Submit "BWOLinkNotAvail"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  
  
  @TC04CPM_Returndone
  Scenario Outline: TC_04_CPM_Return_Requires_Presentation_rule
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL MD DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
     And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL MD DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL MD DEL"
    And select "RuleID"
    And click on "Start Review"
    And click on "Require Presentation"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Status" "Requires Presentation"
    And click on "Return Require Present Rule"
    Then validate Admin rule review value in DB "" "Task" "CPM Review"
    Then validate Admin rule review value in DB "" "Status" "Not Started"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |