#Author trinath.kumar
@PRODIUSmoke
Feature: 
  Production Smoke Test for Interpretive Update

  @PRODIUSmoke
  Scenario Outline: Production Smoke Test for Interpretive Update
    Given user logs into "Production" with "<UserID>" into Interpretive Update Application
    And user navigate to IU Smoke "Admin" Instances Screen
    And click on "<Instance Name>" from Grid Table and navigate to Rule Review
    Then user should able to view "Review Work Queue"
    And user navigate to IU Smoke "ProductionTestMyTasks" Instances Screen
    #And click on "<Task Instance Name>" from Grid Table and navigate to Rule Review
    #Then user should able to view "MD Review Work Queue"
    Then User should be Logged out from IU Application

    Examples: 
      | Instance Name                 | Task Instance Name   |
      | Test Instance for Feb Release | MD Review Work Queue |
