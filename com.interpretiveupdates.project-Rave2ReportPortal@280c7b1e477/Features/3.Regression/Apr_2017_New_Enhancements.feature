#Author: trinath.kumar@cotiviti.com
@Regression @AprilEnhancements
Feature: Apr_2017_New_Enhancements

  Background: 
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen

  @AprilEnhancement1
  Scenario Outline: TC7632_IU PROD 2017 Annual - No Decision at Rule level should alert CPM to review MD Comment_Final MD - CPM
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    Then validate "Final PO Comments" No Decision
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And validate cpm decision complete alert "REMOVE"
    And click on "Generate Summaries"
    And click on "CPM Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Editorial Review"


    Examples:
    | FiterName        | FilterValue          |
    | FilterTaskStatus | Custom;Not Started;N |

  #************************************************************ SCENARIO-2 ***********************************************************************************
  @AprilEnhancement2
  Scenario Outline: TC7632_IU PROD 2017 Annual - No Decision at Rule level should alert CPM to review MD Comment_Final MD - Editorial Return
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
    And Select System Proposal "Modify Decisions" "No Decision"
    Then validate "Final PO Comments" No Decision
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And validate cpm decision complete alert "REMOVE"
    And click on "Generate Summaries"
    And click on "CPM Authorize Decisions"


    Examples:
    | FiterName        | FilterValue          |
    | FilterTaskStatus | Custom;Not Started;N |

  #************************************************************ SCENARIO-3 ***********************************************************************************
  @AprilEnhancement3
  Scenario Outline: TC7632_IU PROD 2017 Annual - No Decision at Rule level should alert CPM to review MD Comment_Final MD - Multiple CPMs
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL PO DEL MULTIPAYER2" and "<FilterValue>"
    When user select Rule with Multiple Payers "ONECPMPAYERSDB"
    And navigate to My tasks and go to rule in instance "" "PO Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    Then validate "Final PO Comments" No Decision
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And validate cpm decision complete alert "REMOVE"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "CPM Review Work Queue" for "FINAL PO DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And validate cpm decision complete alert "REMOVE"

    Examples:
    | FiterName        | FilterValue          |
    | FilterTaskStatus | Custom;Not Started;N |

  #************************************************************ SCENARIO-4 ***********************************************************************************
  @AprilEnhancement4
  Scenario Outline: TC7632_IU PROD 2017 Annual - No Decision at Rule level should alert CPM to review MD Comment_Final MD - Prelim MD
    When user click on "PO Review Work Queue" for "PRELIM MD DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Preliminary MD Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    Then validate "Preliminary Review Comments" No Decision
    Then validate Admin rule review value "Admin" "PRELIM MD DEL" "Task" "Final PO Review After Preliminary"
    When Reassign task "" "iht_ittest02"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    Then validate "Final PO Comments" No Decision
    Then validate Admin rule review value "Admin" "PRELIM MD DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "PRELIM MD DEL"
    And select "RuleID"
    And click on "Start Review"
    And validate cpm decision complete alert "REMOVE"
    And User should be Logged out from IU Application
    
 Examples:
    | FiterName        | FilterValue          |
    | FilterTaskStatus | Custom;Not Started;N |

  #************************************************************ SCENARIO-5 ***********************************************************************************
  @AprilEnhancement5
  Scenario Outline: TC7632_IU PROD 2017 Annual - No Decision at Rule level should alert CPM to review MD Comment_Final MD - QA Return
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And Complete Editorials with "Update Tabs"
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
    When return rule from "QA" to "PO"
    And navigate to My tasks and go to rule in instance "MyTasks" "PO Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "Modify Decisions" "No Decision"
    Then validate "Final PO Comments" No Decision
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And validate cpm decision complete alert "REMOVE"
      And click on "Generate Summaries"
    And click on "CPM Authorize Decisions"
      
 Examples:
    | FiterName        | FilterValue          |
    | FilterTaskStatus | Custom;Not Started;N |

  #************************************************************ SCENARIO-6 ***********************************************************************************
  @AprilEnhancement6
  Scenario Outline: TC7633-IU PROD 2017 Annual-Initiative to make changes to new proposals without the need to modify decision-Editorial- CPM
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
    When return rule from "Editorial" to "CPM"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review - Editorial Return"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And click on "Modify Decisions"
    And Select CPM System Proposal "" "REMOVE" "Modify Decision"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    And click on "CPM Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Editorial Review"

 Examples:
    | FiterName        | FilterValue          |
    | FilterTaskStatus | Custom;Not Started;N |

  #************************************************************ SCENARIO-7 ***********************************************************************************
  @AprilEnhancement7
  Scenario Outline: TC7634_IU PROD 2017 Annual_need to modify decision during returns_CPM_Review_QA Return
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And Complete Editorials with "Update Tabs"
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
    When return rule from "QA" to "CPM"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review - QA Return"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And Select CPM System Proposal "" "REMOVE" ""
    And click on "Generate Summaries"
    And click on "CPM Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Editorial Review"

    Examples:
    | FiterName        | FilterValue          |
    | FilterTaskStatus | Custom;Not Started;N |


  #************************************************************ SCENARIO-8 ***********************************************************************************
  @AprilEnhancement8
  Scenario Outline: TC7635 _Intuitive to make changes to new proposals without the need to modify decision during returns - Final MD-Editorial Return
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And user Enter Final MD Config Comments
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
    When return rule from "Editorial" to "PO"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Final PO Review - Editorial Return"
    And navigate to My tasks and go to rule in instance "MyTasks" "PO Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "Modify Decisions" "Modify"
    And click on "Modify Decisions"
    And Select System Proposal "" "ModifywithoutDate"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"

    Examples:
    | FiterName        | FilterValue          |
    | FilterTaskStatus | Custom;Not Started;N |

  #************************************************************ SCENARIO-9 ***********************************************************************************
  @AprilEnhancement9
  Scenario Outline: TC7636_Intuitive_to_make changes to new proposals without the need to modify decision during returns - Final MD -Review-QA Return
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
    When return rule from "QA" to "PO"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Final PO Review - QA Return"
    And navigate to My tasks and go to rule in instance "MyTasks" "PO Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "Modify Decisions" "Modify"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"

     Examples:
    | FiterName        | FilterValue          |
    | FilterTaskStatus | Custom;Not Started;N |

  #************************************************************ SCENARIO-10 ***********************************************************************************
  @AprilEnhancement10
  Scenario Outline: TC7636_Intuitive_to_make proposals without the need to modify decision during returns - CPM Review-QA Return_AfterUpdate
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
    And complete all QA Reviews
    When return rule from "QA" to "CPM"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review - QA Return"

    #And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    #And select "RuleID"
    #And click on "Start Review"
    #And verify Modify decisions Tab
     Examples:
    | FiterName        | FilterValue          |
    | FilterTaskStatus | Custom;Not Started;N |


  #************************************************************ SCENARIO-11 ***********************************************************************************
  @AprilEnhancement11
  Scenario Outline: TC7636_Intuitive_to_make proposals without the need to modify decision during returns - Final MD -Review-QA Return_AfterUpdate
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
    Then validate CPT Changes in Database "NO"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"

    #And complete all QA Reviews
    #When return rule from "QA" to "PO"
    #Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Final PO Review - QA Return"
     Examples:
    | FiterName        | FilterValue          |
    | FilterTaskStatus | Custom;Not Started;N |


  #************************************************************ SCENARIO-12 ***********************************************************************************
  @AprilEnhancement12
  Scenario Outline: TC7639_IU 2017 Annual update - User is unable to modify editorials on Editorial Review - QA Return task
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
    When user complete all Editorial Reviews ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When return rule from "QA" to "Editorial"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Editorial Review - QA Return"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "Update Tabs"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  #************************************************************ SCENARIO-13 ***********************************************************************************
  @AprilEnhancement13
  Scenario Outline: TC7643_All payers set to requires presentation should be shown under Requires Presentation Payers
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL PO DEL MULTIPAYER2" and "<FilterValue>"
    When user select Rule with Multiple Payers "ONECPMPAYERSDB"
    And navigate to My tasks and go to rule in instance "" "PO Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And navigate to My tasks and go to rule in instance "" "PO Review Work Queue" "FINAL PO DEL"
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
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    And click on "CPM Authorize Decisions"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    And click on "Start Review"

    Examples:
    | FiterName        | FilterValue          |
    | FilterTaskStatus | Custom;Not Started;N |
  
  #************************************************************ SCENARIO-14 ***********************************************************************************
  @AprilEnhancement14
  Scenario Outline: TC7645_Ability_To Highlight Fields with non default values for Manual Add Proposals
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And highlight non default values from manual proposals "START NEW","Billed With (Or)","0007T","58","Yes"
    And click on "Generate Summaries"
    And verify highlighted fields from summaries

    Examples:
    | FiterName        | FilterValue          |
    | FilterTaskStatus | Custom;Not Started;N |


  #************************************************************ SCENARIO-15 ***********************************************************************************
  @AprilEnhancement15
  Scenario: TC7646_IU PROD 2017 Annual - IU Work Queue Summary is showing different number compared to filtered Rule Review _Admin View
    And user navigate to IU "Admin" Instances Screen
    And click on instance with status from Admin "Admin PO Scrub Review"
    Then get total rules count in Rule Review Work Queue
    And navigate to IU report "Work Queue Summary Report"
    Then get IU Report rule count
    Then validate IU Report count with total rules count

  #************************************************************ SCENARIO-16 ***********************************************************************************
  @AprilEnhancement8
  Scenario Outline: TC7632_IU PROD 2017 Annual - No Decision at Rule level should alert CPM to review MD Comment_Final MD - CPM
  When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
  And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
  And select "RuleID"
  And click on "Start Review"
  And Select System Proposal "" "No Action"
  And Select System Proposal "DEL" "Modify"
  And click on "Generate Summaries"
  And click on "Authorize Decisions"
  Then validate Admin rule review value "Admin" "FINAL PO DEL" "Status" "Manual RMR"
  And select "RuleID"
  Then validate Split payer decsion in DB "Split payer decisions exist on the rule." ""
  
  Examples:
  | FiterName        | FilterValue           |
  | FilterTaskStatus | Library;Not Started;N |
  #
  #************************************************************ SCENARIO-17 ***********************************************************************************
  @AprilEnhancement17 @ApDryRun @Auto
  Scenario Outline: TC7668_Ability to update Manual RMR with required Instructions-When CPM decision to Retire a rule -Agree with MD to retire rule
  When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
  And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
  When user select Rule with "Final PO Review"
  And click on "Start Review"
  And Select System Proposal "" "No Action"
  And Select System Proposal "DEL" "Remove"
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
  Then validate Admin rule review value "Admin" "FINAL PO DEL" "Status" "Manual RMR"
  And select "RuleID"
  Then validate Split payer decsion in DB "Split payer decisions exist on the rule." ""
  
  Examples:
  | FiterName                                                          | FilterValue                                            |
  | Library Status;FilterTaskStatus;Task;Rules With ARDs;ProposalTypes | Custom;Not Started;Final PO Review;Restrict To;Similar |
  #
  #************************************************************ SCENARIO-19 ***********************************************************************************
  @AprilEnhancement8
  Scenario Outline: TC7670_Ability to update Manual RMR with required Instructions- generated at QA
  When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
  And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
  When user select Rule with "Final PO Review"
  And click on "Start Review"
  And Complete Editorials with "No Editorial Changes"
  And Select System Proposal "" "No Action"
  And click on "Generate Summaries"
  And click on "Authorize Decisions"
  Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review"
  When Reassign task "" "iht_ittest01"
  And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
  And select "RuleID"
  And click on "Start Review"
  Then validate Admin rule review value "Admin" "FINAL PO DEL" "Status" "Manual RMR"
  And select "RuleID"
  Then validate Split payer decsion in DB "Split payer decisions exist on the rule." ""
  
  Examples:
  | FiterName                                                          | FilterValue                                             |
  | Library Status;FilterTaskStatus;Task;Rules With ARDs;ProposalTypes | Library;Not Started;Final PO Review;Restrict To;Similar |
  #
  #************************************************************ SCENARIO-20 ***********************************************************************************
  @AprilEnhancement20
  Scenario Outline: TC7671_Ability to update Manual RMR Instructions-Manual RMR one CPM Agree with Config and Other CPM Disagree with Config
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
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
    When return rule from "QA" to "CPM"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review - QA Return"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  #************************************************************ SCENARIO-21 ***********************************************************************************
  @AprilEnhancement21
  Scenario: TC7672_Adding Run Type for Rule Review Report
    And user navigate to IU "Admin" Instances Screen
    And click on instance with status from Admin "Admin PO Scrub Review"
    And navigate to IU report "Same/Sim Data Report;eLL Review Report;CPM Review Report;Admin PO Scrub Report;Work Queue Summary Report"
    And navigate to IU report "Rule Review Report"
    And validate "Rule review Report" in IU Report
    And verify run type column "Initial Run"

  #************************************************************ SCENARIO-22 ***********************************************************************************
  @AprilEnhancement22
  Scenario Outline: TC7837_Ability To View Code Description clearly and completely for MDS and CPMs
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO Review" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And show rule review code "PO"
    And click on "Generate Summaries"
    And user Enter Final MD Config Comments
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And show rule review code "PO"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    And click on "CPM Authorize Decisions"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |