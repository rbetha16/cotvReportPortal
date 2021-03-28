#Author: trinath.kumar@cotiviti.com
@Instance
Feature: Instance Creation
  Creating the new instance for Rules

  @Instance
  Scenario Outline: Create Instance
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "Admin" Instances Screen
    And create instance with "<NewInstanceName>" and "<Admin OPS>" "<Admin MD>"
    And user navigate to IU "MyTasks" Instances Screen
    Then complete Group Task Segments in MyTask with "<NewInstanceName>"
    When user click on "Review UI Assignments" with "<NewInstanceName>"
    Then complete "Review UI Assignments" and assign "iht_ittes01"
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Review PO Assignments" with "<NewInstanceName>"
    Then complete "Review PO Assignments" and assign "iht_ittest01"
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Review Obsolete Payers" with "<NewInstanceName>"
    Then complete "Review Obsolete Payers" and assign "iht_ittest01"
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Review DC Assignments" with "<NewInstanceName>"
    Then complete "Review DC Assignments" and assign "iht_ittest01"
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Check Assignments" with "<NewInstanceName>"
    And user navigate to IU "MyTasks" Instances Screen
    And user navigate to IU "Admin" Instances Screen
    And User should be Logged out from IU Application

    Examples: 
      | NewInstanceName | Admin OPS    | Admin MD                                            |
      | Random          | iht_ittest01 | iht_ittest01;iht_ittest02;iht_ittest03;iht_ittest04 |
      
      @InstanceLoadSimData
  Scenario Outline: Create Instance and Load Sim data
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "Admin" Instances Screen
    And create instance with "<NewInstanceName>" and "<Admin OPS>" "<Admin MD>"
    And user navigate to IU "MyTasks" Instances Screen
    Then complete Group Task Segments in MyTask with "<NewInstanceName>"
    When user click on "Review UI Assignments" with "<NewInstanceName>"
    Then complete "Review UI Assignments" and assign "iht_ittes01"
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Review PO Assignments" with "<NewInstanceName>"
    Then complete "Review PO Assignments" and assign "iht_ittest01"
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Review Obsolete Payers" with "<NewInstanceName>"
    Then complete "Review Obsolete Payers" and assign "iht_ittest01"
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Review DC Assignments" with "<NewInstanceName>"
    Then complete "Review DC Assignments" and assign "iht_ittest01"
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Check Assignments" with "<NewInstanceName>"
    #When user load Same Sim data through Database "C9349" "Query144"
    When user load Same Sim data through Database "0019T" "QueryDEL1K"
    And user navigate to IU "Admin" Instances Screen
    When user click on "Request Impact Analysis" for "Intial Run"
    Then user wait for Scrub Status After Impact "240" 
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Admin PO Scrub Review" for "New Scrub" Instance
    
    #Then validate Admin rule review value "Admin" "<NewInstanceName>" "Task" ""
    #Then click on "Request Impact Analysis" and validate "Impact Instance"
    #And user navigate to IU "ICD10-MyTasks" Instances Screen
    #And user navigate to IU "MyTasks" Instances Screen
    #And user navigate to IU "Admin" Instances Screen
    #And User should be Logged out from IU Application

    Examples: 
      | NewInstanceName | Admin OPS    | Admin MD                                            |
      | Random          | iht_ittest01 | iht_ittest01;iht_ittest02;iht_ittest03;iht_ittest04 |