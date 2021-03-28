#Author: trinath.kumar@cotiviti.com
@Regression @AdminScrub
Feature: Validating Admin scrub module fucntionality

  @AdminScrubTC1891
  Scenario: Admin MD_TC1891_Ability to have a filter DOES NOT CONTAIN for all the columns in Admin MD Scrub
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Admin PO Scrub Review" for "Admin Scrub" Instance
    Then validate sorting and filtering functionality
    And User should be Logged out from IU Application

  @AdminScrubTC01
  Scenario: TC_01_ADMIN_MD_SCRUB_GRID_VIEW
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Admin PO Scrub Review" for "Admin Scrub" Instance
    Then select all rows drag column header
    And User should be Logged out from IU Application

  @AdminScrubTC3102
  Scenario: Admin MD_TC3102_Show Completed Rules as part of Overview Screen
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "Admin" Instances Screen
    And click on "FINAL MD DEL" instance in Admin and navigate to Rule Review Page
    And navigate to overview link and validate options available for MD

  @AdminScrubTC3156
  Scenario: Admin MD_TC3156_Reassign functionality from Admin MD Scrub 2.0
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Admin PO Scrub Review" for "Admin Scrub" Instance
    Then verify Excel GUI in Admin Scrub
    Then validate Reassign functionality in Admin MD
    And User should be Logged out from IU Application

  @AdminScrubTC3210
  Scenario: Admin MD_TC3210_Dashboard view of rule assignments on Admin MD
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Admin PO Scrub Review" for "Admin Scrub" Instance
    Then validate Admin MD Dashboard
    And User should be Logged out from IU Application

  @AdminScrubTC3918
  Scenario: Admin MD_TC3918_Ability to retain filters on returning to Home Page
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Admin PO Scrub Review" for "Admin Scrub" Instance
    Then validate retain filters
    And User should be Logged out from IU Application

  @AdminScrubTC4042
  Scenario: Admin MD_TC4042_Ability to Disable Reassign Rules from one Admin MD to other for Scrubbing Activity
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Admin PO Scrub Review" for "Admin Scrub" Instance
    Then validate Admin view buttons disabled
    And User should be Logged out from IU Application

  @AdminScrubTC4353
  Scenario: Admin MD_TC4353_Disable Apply filter option when there no value to filter
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Admin PO Scrub Review" for "Admin Scrub" Instance
    Then verify column header and filter popup when AdminMD enters zero list values then Apply Filter button is Disabled
    And User should be Logged out from IU Application

  @AdminScrubTC4360
  Scenario: Admin MD_TC4360_Ability to Align Code Groups Category and Override flags with Appropriate Codes
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Admin PO Scrub Review" for "Admin Scrub" Instance
    Then verify following Label, and data is within that column of "ReviewCPT, Group, Mapped CPT, From-To, CAT, Override"
    And User should be Logged out from IU Application

  @PCA-19918 @PCA-19917
  Scenario: PCA-19918-(IU-CPT/HCPCS) Ability to validate if the Directly Released rules have routed to respective users
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Admin PO Scrub Review" for "Admin Scrub" Instance
    When user selects the rule and click on the on the "Process Candidates" button
    And user clicks on the "Retrieve Candidates" button
    Then validate Direct Release button "status" for "Direct Release"
    
    @PCA-19916
  Scenario: PCA-19916 (IU-HCPCS/CPT) Ability to select 'Direct Release' only Candidate Rules
   Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Admin PO Scrub Review" for "Admin Scrub" Instance
    When user selects the rule and click on the on the "Process Non Candidates" button
    And user enters the comments and click on the ok button
    And user clicks on the "Retrieve Non Candidates" button
    Then validate Direct Release button "status" for "Process Non Candidates"
    When user selects the rule and click on the on the "Process Candidates" button
    And user clicks on the "Retrieve Candidates" button
    Then validate Direct Release button "status" for "Process Candidates"
    And user clicks on the "Only Unscrubbed Rules Radio" button
    Then validate Direct Release button "status" for "Unscrubbed Rules"
    Then validate Direct Release button "status" for "Admin View"
    Then validate Direct Release button "status" for "Candidates Non Candidates"
