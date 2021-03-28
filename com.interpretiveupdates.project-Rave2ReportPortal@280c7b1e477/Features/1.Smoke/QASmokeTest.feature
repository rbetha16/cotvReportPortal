#Author trinath.kumar
@Smoke @QASmoke
Feature: 
  QA Smoke Test for Interpretive Update

  @QASmoke
  Scenario Outline: QA Smoke Test for Admin WorkFlow12
    Given user logs into "QA" with "<UserID>" into Interpretive Update Application
    #And user navigate to IU Smoke "Admin" Instances Screen
    #And click on "<Instance Name>" from Grid Table and navigate to Rule Review
    #Then user should able to view "Review Work Queue"
    And user navigate to IU "MyTasks" Instances Screen
    And click on "<Task Instance Name>" from Grid Table and navigate to Rule Review
    Then user should able to view "MD Review Work Queue"
    Then User should be Logged out from IU Application

    Examples: 
      | Instance Name | Task Instance Name   | UserID       |
      | TestAuto      | MD Review Work Queue | iht_ittest01 |
