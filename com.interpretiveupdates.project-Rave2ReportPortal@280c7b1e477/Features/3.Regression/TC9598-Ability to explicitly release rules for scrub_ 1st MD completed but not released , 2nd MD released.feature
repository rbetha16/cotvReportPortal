#Author:trinath.kumar@cotiviti.com
@Regression
Feature: Ability to explicitly release rules for scrub_ 1st MD completed but not released , 2nd MD released

  @Scenario1
  Scenario: Ability to explicitly release rules for scrub_first MD completed but not released , 2nd MD released
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    And user click on "Admin MD Scrub Review" for "FINAL MD DEL" Instance
    Then user navigate to IU "Admin MD Scrub" Instances Screen
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Admin MD Scrub Review" for "FINAL MD DEL" Instance
    And user navigate to IU "Admin MD Scrub Candidates" Instances Screen
    Then User should be Logged out from IU Application
    
    Given user logs into "QA" with "iht_ittest03" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    And user click on "Admin MD Scrub Review" for "FINAL MD DEL" Instance
    And user navigate to IU "Admin MD Scrub" Instances Screen
    And user navigate to IU "MyTasks" Instances Screen
    And user click on "Admin MD Scrub Review" for "FINAL MD DEL" Instance
    And user navigate to IU "Admin MD Scrub Release" Instances Screen
    Then User should be Logged out from IU Application
    
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    And user click on "Admin MD Scrub Review" for "FINAL MD DEL" Instance
    Then rules which were marked as either candidates or non candidates by "iht_ittest02" should not be released
    Then User should be Logged out from IU Application

  @Scenario2
  Scenario: Ability to explicitly release rules for scrub_multiple MDs completed but not released,second MD released
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    And user click on "Admin MD Scrub Review" for "FINAL MD DEL" Instance
    And user navigate to IU "Admin MD Scrub" Instances Screen
    
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Admin MD Scrub Review" for "FINAL MD DEL" Instance
    And user navigate to IU "Admin MD Scrub Candidates" Instances Screen
    Then User should be Logged out from IU Application
    
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    And user click on "Admin MD Scrub Review" for "FINAL MD DEL" Instance
    And user navigate to IU "Admin MD Scrub" Instances Screen
    
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Admin MD Scrub Review" for "FINAL MD DEL" Instance
    And user navigate to IU "Admin MD Scrub Candidates" Instances Screen
    Then User should be Logged out from IU Application
    
    Given user logs into "QA" with "iht_ittest03" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    And user click on "Admin MD Scrub Review" for "FINAL MD DEL" Instance
    And user navigate to IU "Admin MD Scrub" Instances Screen
    
    Given user logs into "QA" with "iht_ittest03" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    And user click on "Admin MD Scrub Review" for "FINAL MD DEL" Instance
    And user navigate to IU "Admin MD Scrub Release" Instances Screen
    
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    And user click on "Admin MD Scrub Review" for "FINAL MD DEL" Instance
    Then rules which were marked as either candidates or non candidates by "iht_ittest01,iht_ittest02" should not be released
    Then User should be Logged out from IU Application
    
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    And user click on "Admin MD Scrub Review" for "FINAL MD DEL" Instance
    Then rules which were marked as either candidates or non candidates by "iht_ittest01,iht_ittest02" should not be released
    Then User should be Logged out from IU Application

  @Scenario3
  Scenario: Ability to explicitly release rules for scrub_multiple MDs completed but not released,second MD released
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "Admin" Instances Screen
    And user navigate to IU "View All Tasks" Instances Screen
    And reassign task from user "iht_ittest02" to "iht_ittest04" for "Final MD DEL" Instance
    Then User should be Logged out from IU Application
    
    Given user logs into "QA" with "iht_ittest04" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    And user click on "Admin MD Scrub Review" for "FINAL MD DEL" Instance
    And user navigate to IU "Admin MD Scrub" Instances Screen
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Admin MD Scrub Review" for "FINAL MD DEL" Instance
    And user navigate to IU "Admin MD Scrub Candidates" Instances Screen
    Then User should be Logged out from IU Application
    
    
    Given user logs into "QA" with "iht_ittest03" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    And user click on "Admin MD Scrub Review" for "FINAL MD DEL" Instance
    And user navigate to IU "Admin MD Scrub" Instances Screen
    Then User should be Logged out from IU Application
    And user navigate to IU "MyTasks" Instances Screen
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user click on "Admin MD Scrub Review" for "FINAL MD DEL" Instance
    And user navigate to IU "Admin MD Scrub Release" Instances Screen
    Then User should be Logged out from IU Application
  
    Given user logs into "QA" with "iht_ittest04" into Interpretive Update Application
     And user navigate to IU "MyTasks" Instances Screen
    And user click on "Admin MD Scrub Review" for "FINAL MD DEL" Instance
    Then rules which were marked as either candidates or non candidates by "iht_ittest04" should not be released
    Then User should be Logged out from IU Application
