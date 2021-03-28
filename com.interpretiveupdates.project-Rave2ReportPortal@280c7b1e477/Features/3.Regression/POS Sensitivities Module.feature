#Author: trinath.kumar@cotiviti.com

@POS
Feature: POS Sensitivity Functionality

  @POS01
  Scenario Outline: PPMD-6181_Filter dropdown for Sensitivity Identified column
    #Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    #And user navigate to IU "MyTasks" Instances Screen
    #When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    #And Apply filters in My Task and Retrive Rule in DB "MD DEL MULTIPAYER2 Deny" and "<FilterValue>"
    #When user select Rule with Multiple Payers "ONECPMPAYERSDB"
    #And navigate to My tasks and go to rule in instance "" "PO Review Work Queue" "FINAL PO DEL"
    #And select "RuleID"
    #And click on "Start Review"
    #And Select System Proposal "" "No Action"
    #And Add code function with POS code "Deny","0009M","POS-01","OverrideFlag-No"
    #And Add code function with POS code "Deny","0009T","POS-01","OverrideFlag-No"
    #And Add code function with POS code "Deny","0008M","POS-01","OverrideFlag-No"
    #And Add code function with POS code "Deny","0008T","POS-01","OverrideFlag-No"
    #And Add code function with POS code "Deny","0007T","POS-03","OverrideFlag-No"
    #And click on "Generate Summaries"
    #And click on "Authorize Decisions"
    #Then User should be Logged out from IU Application
    Given User login to Client Profile Application through "QA_URL"
    Then User should see the Client profile Homepage through "policysetsnew"
    When User Selects "Table Type" as "POS Sensitivities"
    When User Selects "Payer Short" as ""
    And user click on "Apply Filters"
    When user click on "New Table"
    Then user Should see the message as "New POS Sensitivity table is created successfully"
    And validate "MAPPED-Functionality" through New Table
    And user should be logged out from Client Profile application
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
 
     Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;Y |
      
      
      
     @POS02
  Scenario Outline: TC110_PPMD-6181_Filter dropdown for Sensitivity Identified column
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "SINGLEPAYER" and "<FilterValue>"
    And Get Rule and Payer value
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And click on "Generate Summaries"
    And user Enter Final MD Config Comments
    And click on "Authorize Decisions"
    And Add code function with POS code "Deny","0009M","POS-01","OverrideFlag-No"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    And user Enter Final MD Config Comments
    And click on "Authorize Decisions"
    Then User should be Logged out from IU Application
    Given User login to Client Profile Application through "QA_URL"
    Then User should see the Client profile Homepage through "policysetsnew"
    When User Selects "Table Type" as "POS Sensitivities"
    When User Selects "Payer Short" as ""
    And user click on "Apply Filters"
    When user click on "New Table"
    Then user Should see the message as "New POS Sensitivity table is created successfully"
    And validate "MAPPED-Functionality" through New Table
    And user should be logged out from Client Profile application
     Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And validate POS Sensitiviti "", "", "", "", ""
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    And click on "CPM Authorize Decisions"
    Then User should be Logged out from IU Application
    Given User login to Client Profile Application through "QA_URL"
    Then User should see the Client profile Homepage through "policysetsnew"
    When User Selects "Table Type" as "POS Sensitivities"
    When User Selects "Payer Short" as ""
    And user click on "Apply Filters"
    When user click on "New Table"
    Then user Should see the message as "New POS Sensitivity table is created successfully"
    And validate "MAPPED-Functionality" through New Table
    And user should be logged out from Client Profile application
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Editorial Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And validate POS Sensitiviti "", "", "", "", ""
    When user complete all Editorial Reviews ""
    Then User should be Logged out from IU Application
    Given User login to Client Profile Application through "QA_URL"
    Then User should see the Client profile Homepage through "policysetsnew"
    When User Selects "Table Type" as "POS Sensitivities"
    When User Selects "Payer Short" as ""
    And user click on "Apply Filters"
    When user click on "New Table"
    Then user Should see the message as "New POS Sensitivity table is created successfully"
    And validate "MAPPED-Functionality" through New Table
    And user should be logged out from Client Profile application
     Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And validate POS Sensitiviti "", "", "", "", ""
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then User should be Logged out from IU Application
    Given User login to Client Profile Application through "QA_URL"
    Then User should see the Client profile Homepage through "policysetsnew"
    When User Selects "Table Type" as "POS Sensitivities"
    When User Selects "Payer Short" as ""
    And user click on "Apply Filters"
    When user click on "New Table"
    Then user Should see the message as "New POS Sensitivity table is created successfully"
    And validate "MAPPED-Functionality" through New Table
    And user should be logged out from Client Profile application
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Configuration Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Configuration Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And validate POS Sensitiviti "", "", "", "", ""
    And complete all Config Reviews
    Then User should be Logged out from IU Application
    Given User login to Client Profile Application through "QA_URL"
    Then User should see the Client profile Homepage through "policysetsnew"
    When User Selects "Table Type" as "POS Sensitivities"
    When User Selects "Payer Short" as ""
    And user click on "Apply Filters"
    When user click on "New Table"
    Then user Should see the message as "New POS Sensitivity table is created successfully"
    And validate "MAPPED-Functionality" through New Table
    And user should be logged out from Client Profile application
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Testing Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And validate POS Sensitiviti "", "", "", "", ""
    And Complete all testing Reviews
    Then User should be Logged out from IU Application
    
        Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;Y |
      
    @POS03
  Scenario Outline: PPMD-6181_Filter dropdown for Sensitivity Identified column   
       Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL PO DEL MULTIPAYER2" and "<FilterValue>"
    When user select Rule with Multiple Payers "ONECPMPAYERSDB"
    And navigate to My tasks and go to rule in instance "" "PO Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "" "No Action"
    And Add code function with POS code "Billed With (Or)","0009M","POS-01","OverrideFlag-No"
    And Add code function with POS code "Billed With (Or)","0009T","POS-01","OverrideFlag-No"
    And Add code function with POS code "Billed With (Or)","0008M","POS-01","OverrideFlag-No"
    And Add code function with POS code "Billed With (Or)","0008T","POS-01","OverrideFlag-No"
    And Add code function with POS code "Billed With (Or)","0007T","POS-03","OverrideFlag-No"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then User should be Logged out from IU Application
    Given User login to Client Profile Application through "QA_URL"
    Then User should see the Client profile Homepage through "policysetsnew"
    When User Selects "Table Type" as "POS Sensitivities"
    When User Selects "Payer Short" as ""
    And user click on "Apply Filters"
    When user click on "New Table"
    Then user Should see the message as "New POS Sensitivity table is created successfully"
    And validate "MAPPED-Functionality" through New Table
    And user should be logged out from Client Profile application
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And validate POS Sensitiviti "", "", "", "", ""
    And validate POS Sensitiviti "", "", "", "", ""
    Then User should be Logged out from IU Application
    Given User login to Client Profile Application through "QA_URL"
    Then User should see the Client profile Homepage through "policysetsnew"
    When User Selects "Table Type" as "POS Sensitivities"
    When User Selects "Payer Short" as ""
    And user click on "Apply Filters"
    When user click on "New Table"
    Then user Should see the message as "New POS Sensitivity table is created successfully"
    And validate "MAPPED-Functionality" through New Table
    And user should be logged out from Client Profile application
    
      Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;Y |
      