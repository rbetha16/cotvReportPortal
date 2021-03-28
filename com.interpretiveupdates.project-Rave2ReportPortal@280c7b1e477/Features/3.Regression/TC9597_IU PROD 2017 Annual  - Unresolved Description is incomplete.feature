#Author:trinath.kumar@cotiviti.com
@Regression
Feature: IU PROD 2017 Annual  - Unresolved Description is incomplete in the grid
     
  @AdminScrubFail
  Scenario Outline: IU PROD 2017 Annual  - Unresolved Description is incomplete in the grid
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    And user click on "Admin MD Scrub Review" for "Admin Scrub" Instance
    Then Verify "<COLUMN>" Value as per RMI in Admin MD Scrub

    Examples: 
      | COLUMN                                                                                                              |
      | Sub Rule Description - Resolved;Sub Rule Description - Unresolved;Sub Rule Notes;Sub Rule Script;Sub Rule Rationale |

      
      