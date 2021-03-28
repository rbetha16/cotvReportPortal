#Author:
@Regression @AssignmentExceptionSuit
Feature: Assignment Exception

  @TCAEInstance
  Scenario Outline: Create Assignment Exception Instance
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    #And user navigate to IU "Admin" Instances Screen
    And create instance with "<NewInstanceName>" and "<Admin OPS>" "<Admin MD>"
    #And user navigate to IU "MyTasks" Instances Screen
    #Then complete Group Task Segments in MyTask with "<NewInstanceName>"
    #When user click on "Review UI Assignments" with "<NewInstanceName>"
    #Then complete "Review UI Assignments" and assign "iht_ittes01"
    #And user navigate to IU "MyTasks" Instances Screen
    #When user click on "Review PO Assignments" with "<NewInstanceName>"
    #Then complete "Review PO Assignments" and assign "iht_ittest01"
    #And user navigate to IU "MyTasks" Instances Screen
    #When user click on "Review Obsolete Payers" with "<NewInstanceName>"
    #Then complete "Review Obsolete Payers" and assign "iht_ittest01"
    #And user navigate to IU "MyTasks" Instances Screen
    #When user Navigate to Instance and Select Admin Actions "<NewInstanceName>" "Update Instance Assignments"
    #Then complete "Assignment Exceptions" and assign "0"
    #And user navigate to IU "MyTasks" Instances Screen
    #When user click on "Review DC Assignments" with "<NewInstanceName>"
    #Then complete "Review DC Assignments" and assign "ASSIGNMENT EXCEPTIONS"
    #And user navigate to IU "Admin" Instances Screen
    And User should be Logged out from IU Application

    Examples: 
      | NewInstanceName | Admin OPS    | Admin MD                                                                                                |
      | AEInstance26Sep | iht_ittest01 | iht_ittest01;iht_ittest02;iht_ittest03;iht_ittest04;iht_ittest05;iht_ittest06;iht_ittest07;iht_ittest08 |

  @AssignmentException @AETC01and2 @TC01AE
  Scenario Outline: TC_01_AE_PrelimMDReview_Validate_Assignee_User_1
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application

    #When user navigate to Admin rule review and Apply Filters "" "AE PRELIM MD DEL" "<FiterName>" "<FilterValue>"
    #Then validate Rule review value row wise "1" "Preliminary PO Review" "Not Started" "rbetha"
    #And User should be Logged out from IU Application
    Examples: 
      | FiterName       | FilterValue                                   | Task                  | Status      | Assignee |
      | MedicalPolicies | Durable Medical Equipment and Supplies Policy | Preliminary PO Review | Not Started | rbetha   |

  @AssignmentException @AETC10203
  Scenario Outline: TC10203
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen

    #When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    #And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    When user select Rule with "Preliminary PO Review"
    #And click on "Start Review"
    #And click on "Generate Summaries"
    #And click on "Authorize Decisions"
    #Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "Preliminary PO Peer Review"
    #Then validate Admin rule review value in DB "FINAL PO DEL" "Assignee" "iht_ittest08"
    #And User should be Logged out from IU Application
    Examples: 
      | FiterName       | FilterValue       | Task                 | Status      | Assignee     |
      | MedicalPolicies | Healthplan Policy | Final PO Peer Review | Not Started | iht_ittest08 |

  @AssignmentException @AETC104
  Scenario Outline: TC104
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application

    #And user navigate to IU "MyTasks" Instances Screen
    #When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    #And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    #When user select Rule with "Preliminary PO Review"
    #And click on "Start Review"
    #And click on "Generate Summaries"
    #And click on "Authorize Decisions"
    #And User should be Logged out from IU Application
    #Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    #And user navigate to IU "MyTasks" Instances Screen
    #When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    #And select "RuleID"
    #And click on "Start Review"
    #And click on "Peer Review"
    #Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "Final PO Review After Preliminary"
    #Then validate Admin rule review value in DB "FINAL PO DEL" "Assignee" "vbathina"
    #And User should be Logged out from IU Application
    Examples: 
      | FiterName       | FilterValue                                         | Task                              | Status      | Assignee     |
      | MedicalPolicies | Professional, Technical, and Global Services Policy | Final PO Review After Preliminary | Not Started | iht_ittest01 |

  @ReportPortalSample1
  Scenario: ReportPortalSample1
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "FINAL MD DEL" Instance
    And select "Reportportal"

  @AssignmentException @AETC105
  Scenario Outline: TC105
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    When user select Rule with "Preliminary PO Review"
    And click on "Start Review"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Peer Review"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "Final PO Review After Preliminary"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest03" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "Final PO Peer Review"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Assignee" "iht_ittest05"

    Examples: 
      | FiterName       | FilterValue              | Task                 | Status      | Assignee     |
      | MedicalPolicies | Assistant Surgeon Policy | Final PO Peer Review | Not Started | iht_ittest06 |

  @AssignmentException @AETC107
  Scenario Outline: TC107_01_AE_PrelimMDReview_Validate_Assignee_User_1
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    When user select Rule with "Preliminary PO Review"
    And click on "Start Review"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Peer Review"
    Then validate Admin rule review value "Admin" "AE PRELIM MD DEL" "Task" "Final PO Review After Preliminary"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest03" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "Final PO Peer Review"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Assignee" "iht_ittest05"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName       | FilterValue              | Task                 | Status      | Assignee     |
      | MedicalPolicies | Assistant Surgeon Policy | Final PO Peer Review | Not Started | iht_ittest01 |

  @AssignmentException @AETC108
  Scenario Outline: TC108_01_AE_PrelimMDReview_Validate_Assignee_User_1
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    When user select Rule with "Preliminary PO Review"
    And click on "Start Review"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Peer Review"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "Final PO Review After Preliminary"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Assignee" "vbathina"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName       | FilterValue                                         | Task                              | Status      | Assignee     |
      | MedicalPolicies | Professional, Technical, and Global Services Policy | Final PO Review After Preliminary | Not Started | iht_ittest01 |

  @AssignmentException @AETC06
  Scenario Outline: TC_06_AE_FinalMDReview_With_FinalMDPeerReview_AssociatedTask_Validate_Assignee_User_Scenario_1
    					  TC_06_AE_FinalMDReview_With_FinalMDPeerReview_AssociatedTask_Validate_Assignee_User_Scenario_2
    					  TC_06_AE_FinalMDReview_With_FinalMDPeerReview_AssociatedTask_Validate_Assignee_User_Scenario_3
    					  TC_06_AE_FinalMDReview_With_FinalMDPeerReview_AssociatedTask_Validate_Assignee_User_Scenario_4
    					  TC_06_AE_FinalMDReview_With_FinalMDPeerReview_AssociatedTask_Validate_Assignee_User_Scenario_5
    					  TC_06_AE_FinalMDReview_With_FinalMDPeerReview_AssociatedTask_Validate_Assignee_User_Scenario_6
    					  TC_06_AE_FinalMDReview_With_FinalMDPeerReview_AssociatedTask_Validate_Assignee_User_Scenario_7
    					  TC_06_AE_FinalMDReview_With_FinalMDPeerReview_AssociatedTask_Validate_Assignee_User_Scenario_8
    					  TC_06_AE_FinalMDReview_With_FinalMDPeerReview_AssociatedTask_Validate_Assignee_User_Scenario_9

    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    When user select Rule with "Preliminary PO Review"
    And click on "Start Review"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Peer Review"
    Then validate Admin rule review value "Admin" "AE PRELIM MD DEL" "Task" "Final PO Review After Preliminary"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest03" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "Final PO Peer Review"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Assignee" "iht_ittest05"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName       | FilterValue              | Task                 | Status      | Assignee     |
      | MedicalPolicies | Assistant Surgeon Policy | Final PO Peer Review | Not Started | iht_ittest01 |

  @AssignmentException @AETC09 @Sundaysep30
  Scenario Outline: TC_09_AE_PreliminaryMDReview_With_PrelimMDPeerReview_Validate_Assignee_User_Scenario_1
    					  		TC_09_AE_PreliminaryMDReview_With_PrelimMDPeerReview_Validate_Assignee_User_Scenario_2
    					 TC_09_AE_PreliminaryMDReview_With_PrelimMDPeerReview_Validate_Assignee_User_Scenario_3
    					 TC_09_AE_PreliminaryMDReview_With_PrelimMDPeerReview_Validate_Assignee_User_Scenario_4
    					 TC_09_AE_PreliminaryMDReview_With_PrelimMDPeerReview_Validate_Assignee_User_Scenario_5
    					 TC_09_AE_PreliminaryMDReview_With_PrelimMDPeerReview_Validate_Assignee_User_Scenario_6
    					 TC_09_AE_PreliminaryMDReview_With_PrelimMDPeerReview_Validate_Assignee_User_Scenario_7
    					 TC_09_AE_PreliminaryMDReview_With_PrelimMDPeerReview_Validate_Assignee_User_Scenario_8
    					 TC_09_AE_PreliminaryMDReview_With_PrelimMDPeerReview_Validate_Assignee_User_Scenario_9

    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    When user select Rule with "Preliminary PO Review"
    And click on "Start Review"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "Preliminary PO Peer Review"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Assignee" "iht_ittest08"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName       | FilterValue       | Task                 | Status      | Assignee     |
      | MedicalPolicies | Healthplan Policy | Final PO Peer Review | Not Started | iht_ittest08 |

  @AssignmentException @AETC10 @Sundaysep30
  Scenario Outline: TC_10_AE_PreliminaryMDReview_With_FinalMDReviewAfterPreliminary_Validate_Assignee_User_Scenario_1
    					   TC_10_AE_PreliminaryMDReview_With_FinalMDReviewAfterPreliminary_Validate_Assignee_User_Scenario_2
    					 	 TC_10_AE_PreliminaryMDReview_With_FinalMDReviewAfterPreliminary_Validate_Assignee_User_Scenario_3
    						 TC_10_AE_PreliminaryMDReview_With_FinalMDReviewAfterPreliminary_Validate_Assignee_User_Scenario_4
    						 TC_10_AE_PreliminaryMDReview_With_FinalMDReviewAfterPreliminary_Validate_Assignee_User_Scenario_5
    					 	 TC_10_AE_PreliminaryMDReview_With_FinalMDReviewAfterPreliminary_Validate_Assignee_User_Scenario_6
    						 TC_10_AE_PreliminaryMDReview_With_FinalMDReviewAfterPreliminary_Validate_Assignee_User_Scenario_7
    						 TC_10_AE_PreliminaryMDReview_With_FinalMDReviewAfterPreliminary_Validate_Assignee_User_Scenario_8
    					 	 TC_10_AE_PreliminaryMDReview_With_FinalMDReviewAfterPreliminary_Validate_Assignee_User_Scenario_9

    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    When user select Rule with "Preliminary PO Review"
    And click on "Start Review"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Peer Review"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "Final PO Review After Preliminary"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Assignee" "vbathina"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName       | FilterValue                                         | Task                              | Status      | Assignee     |
      | MedicalPolicies | Professional, Technical, and Global Services Policy | Final PO Review After Preliminary | Not Started | iht_ittest01 |

  @AssignmentException @AETC11
  Scenario Outline: TC_11_AE_FinalMDReviewAfterPreliminary_With_FinalMDPeerReview_Validate_Assignee_User_Scenario_1
    TC_11_AE_FinalMDReviewAfterPreliminary_With_FinalMDPeerReview_Validate_Assignee_User_Scenario_2

    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    When user select Rule with "Preliminary PO Review"
    And click on "Start Review"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Peer Review"
    Then validate Admin rule review value "Admin" "AE PRELIM MD DEL" "Task" "Final PO Review After Preliminary"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest03" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "Final PO Peer Review"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Assignee" "iht_ittest05"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName       | FilterValue              | Task                 | Status      | Assignee     |
      | MedicalPolicies | Assistant Surgeon Policy | Final PO Peer Review | Not Started | iht_ittest01 |

  @AssignmentException @AETC12
  Scenario Outline: TC_12_AE_FinalMDReviewAfterPreliminary_With_Editorial_Review_Validate_Assignee_User_Scenario_1
    					  TC_12_AE_FinalMDReviewAfterPreliminary_With_Editorial_Review_Validate_Assignee_User_Scenario_2

    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    When user select Rule with "Preliminary PO Review"
    And click on "Start Review"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Peer Review"
    #Then validate Admin rule review value "Admin" "AE PRELIM MD DEL" "Task" "Final PO Review After Preliminary"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest03" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Authorize Decisions"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest04" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Peer Review"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "Editorial Review"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Assignee" "iht_ittest02"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName                      | FilterValue                                     | Task                  | Status      | Assignee     |
      | Library Status;MedicalPolicies | Library;Ambulatory Surgical Center (ASC) Policy | Preliminary PO Review | Not Started | iht_ittest08 |

  @AssignmentException @AETC13 @Sundaysep30
  Scenario Outline: TC_13_AE_ConfigReview_With_ConfigReview_Validate_Assignee_User
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    When user select Rule with "Preliminary PO Review"
    And click on "Start Review"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Peer Review"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest03" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And user Enter Final MD Config Comments
    And Complete Editorials with "Complete Editorials"
    And click on "Authorize Decisions"
    #Then validate Admin rule review value "Admin" "AE PRELIM MD DEL" "Task" "Final PO Peer Review"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest04" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Peer Review"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest07" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "QA Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "Configuration Review"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Assignee" "iht_ittest03"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName                       | FilterValue                                       | Task                  | Status      | Assignee     |
      | Library Status;MedicalPolicies; | Library;Evaluation and Management Services Policy | Preliminary PO Review | Not Started | iht_ittest01 |

  @AssignmentException @AETC14
  Scenario Outline: TC_14_AE_Editorial_Review_Validate_Assignee_User_Scenario_1
    					  TC_14_AE_Editorial_Review_Validate_Assignee_User_Scenario_2
    					  TC_14_AE_Editorial_Review_Validate_Assignee_User_Scenario_3
    					  TC_15_AE_Editorial_Review_With_Editorial_Review_Validate_Assignee_User

    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    When user select Rule with "Preliminary PO Review"
    And click on "Start Review"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Peer Review"
    #Then validate Admin rule review value "Admin" "AE PRELIM MD DEL" "Task" "Final PO Review After Preliminary"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest03" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Authorize Decisions"
    #Then validate Admin rule review value "Admin" "AE PRELIM MD DEL" "Task" "Final PO Peer Review"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest04" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Peer Review"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "Editorial Review"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Assignee" "iht_ittest02"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName                      | FilterValue                                     | Task                  | Status      | Assignee     |
      | Library Status;MedicalPolicies | Library;Ambulatory Surgical Center (ASC) Policy | Preliminary PO Review | Not Started | iht_ittest08 |

  @AssignmentException @AETC15
  Scenario Outline: TC_15_AE_Editorial_Review_With_Editorial_Review_Validate_Assignee_User
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    When user select Rule with "Preliminary PO Review"
    And click on "Start Review"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Peer Review"
    #Then validate Admin rule review value "Admin" "AE PRELIM MD DEL" "Task" "Final PO Review After Preliminary"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest03" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Authorize Decisions"
    #Then validate Admin rule review value "Admin" "AE PRELIM MD DEL" "Task" "Final PO Peer Review"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest04" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Peer Review"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "Editorial Review"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Assignee" "iht_ittest02"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName                      | FilterValue                                     | Task                  | Status      | Assignee     |
      | Library Status;MedicalPolicies | Library;Ambulatory Surgical Center (ASC) Policy | Preliminary PO Review | Not Started | iht_ittest08 |

  @AssignmentException @AETC16 @Satnightdecrel4
  Scenario Outline: TC_16_AE_Editorial_Review_With_QA_Review_Validate_Assignee_User_Scenario_1***
    								TC_16_AE_Editorial_Review_With_QA_Review_Validate_Assignee_User_Scenario_2
    								TC_16_AE_Editorial_Review_With_QA_Review_Validate_Assignee_User_Scenario_3

    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    When user select Rule with "Preliminary PO Review"
    And click on "Start Review"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Peer Review"
    #Then validate Admin rule review value "Admin" "AE PRELIM MD DEL" "Task" "Final PO Review After Preliminary"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest03" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Authorize Decisions"
    #Then validate Admin rule review value "Admin" "AE PRELIM MD DEL" "Task" "Final PO Peer Review"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest04" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Peer Review"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "Editorial Review"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Assignee" "iht_ittest05"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest05" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Editorial Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    When user complete all Editorial Reviews ""
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "QA Review"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Assignee" "iht_ittest07"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName                      | FilterValue                 | Task                  | Status      | Assignee     |
      | Library Status;MedicalPolicies | Library;Revenue Code Policy | Preliminary PO Review | Not Started | iht_ittest01 |

  @AssignmentException @AETC17 @Satnightdecrel4
  Scenario Outline: TC_17_AE_Editorial_Review_With_Testing_Review_Validate_Assignee_User_Scenario_1
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And Apply filters in My Task Rule Work Queue "<FiterName>" and "<FilterValue>"
    When user select Rule with "Preliminary PO Review"
    And click on "Start Review"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Peer Review"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "Final PO Review After Preliminary"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest03" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "Final PO Peer Review"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest04" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "PO Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "Peer Review"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "Editorial Review"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Assignee" "iht_ittest05"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest05" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "Editorial Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    When user complete all Editorial Reviews ""
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest07" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "QA Review Work Queue" for "AE PRELIM MD DEL" Instance
    And select "RuleID"
    And click on "Start Review"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Task" "Testing Review"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Status" "Not Started"
    Then validate Admin rule review value in DB "FINAL PO DEL" "Assignee" "iht_ittest06"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName                      | FilterValue                     | Task                  | Status      | Assignee     |
      | MedicalPolicies;Library Status | Bundled Services Policy;Library | Preliminary PO Review | Not Started | iht_ittest01 |
