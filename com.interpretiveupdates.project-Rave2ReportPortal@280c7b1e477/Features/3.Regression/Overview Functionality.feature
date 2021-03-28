#Author:trinath.kumar@cotiviti.com
@Regression @Overview
Feature: Verfiy Overview Functionality

  Background: 
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen

  @OVerView1
  Scenario: TC_01_Overview_TC2597_Ability to refresh overview screen when a rule is completed through MD work queue
    TC_03_Overview_TC2614_PPMD-5721_Ability to show all rules in Edit mode for MD User (MD Decision Capture)

    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And navigate and validate overview report
    And get rule from overview report
    And select rule and validate RuleID Tab
    And click on "Start Review"
    And set "No Change Required" in MD Review
    And validate rule and completed count in overview report

  @OVerView2
  Scenario: TC_02_Overview_TC2611_PPMD-6076_Overview Screen - MD takes No Decision at rule level
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And navigate and validate overview report
    And get rule from overview report
    And select rule and validate RuleID Tab
    And click on "Start Review"
    And set "No Change Required" in MD Review
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Status" "No Change Required"
       
  @OVerView3
  Scenario: TC_04_Overview_TC2613_PPMD-6076_ Open the rule display screen for a Library rule in a new tab upon clicking on Mid Rule version
    When user click on "PO Review Work Queue" for "FINAL PO DEL" Instance
    And navigate and validate overview report
    And get rule from overview report 
    And navigate to My tasks and go to rule in instance "MyTasks" "PO Review Work Queue" "FINAL PO DEL"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "" "No Action"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL" "Task" "Final PO Review"
    
    