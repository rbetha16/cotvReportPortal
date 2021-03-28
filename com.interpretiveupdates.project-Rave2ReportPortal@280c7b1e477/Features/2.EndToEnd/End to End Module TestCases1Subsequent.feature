#Author: raveendra.betha@cotiviti.com

@Regression1 @EndToEndSubSequentPart1

Feature: End to End Scenarios part 1 subsequent

  Background: 
    Given user logs into "QA" with "iht_ittest01" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen

  @TC1865113A @EndToEndRav1
  Scenario Outline: TC1865_End to End Multiple CPM diferent decisions_CPT_ARD_EXIST
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL PO DEL MULTIPAYER2-Subsequent" and "<FilterValue>"
    When user select Rule with Multiple Payers "ONECPMPAYERSDB"
    And navigate to My tasks and go to rule in instance "" "PO Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "CPM Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And select "RuleID"
    And click on "Start Review"
    And Select CPM System Proposal "DEL" "NO ACTION" ""
    And click on "CPM Decesion Complete"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Status" "Manual RMR"

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;Y |

  @TC1865E2EB  @EndToEndRav2
  Scenario Outline: TC1865_End to End Multiple CPM diferent decisions_Disagree with MD Decisions
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL PO DEL MULTIPAYER2-Subsequent" and "<FilterValue>"
    When user select Rule with Multiple Payers "ONECPMPAYERSDB"
    And navigate to My tasks and go to rule in instance "" "PO Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "CPM Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And select "RuleID"
    And click on "Start Review"
    And Select CPM System Proposal "DEL" "NO ACTION" ""
    And click on "CPM Decesion Complete"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Status" "Manual RMR"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @TC1865E2EC @Feb1morrun @EndToEndR3 @EndToEndRav3
  Scenario Outline: TC1865_End to End Multiple CPM diferent decisions_Move_to_next_level
    						TC1865_End to End Multiple CPM diferent decisions_Same_Decision_with_different comments

    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL PO DEL MULTIPAYER2-Subsequent" and "<FilterValue>"
    When user select Rule with Multiple Payers "ONECPMPAYERSDB"
    And navigate to My tasks and go to rule in instance "" "PO Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "CPM Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And select "RuleID"
    And click on "Start Review"
    And click on "CPM Decesion Complete"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Task" "Editorial Review"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |


  @TC1865E2ED  @EndToEndR4 @EndToEndRav4

  Scenario Outline: TC1865_End to End Multiple CPM diferent decisions_Payer Specific Decision at one Payer
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL PO DEL MULTIPAYER2-Subsequent" and "<FilterValue>"
    When user select Rule with Multiple Payers "ONECPMPAYERSDB"
    And navigate to My tasks and go to rule in instance "" "PO Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user select different decisions at payer level
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "CPM Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And select "RuleID"
    And click on "Start Review"
    When user select different decisions at payer level
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Status" "Manual RMR"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @TC1865E2EE @Feb1morrun @EndToEndR5
  Scenario Outline: TC1865_End to End Multiple CPM diferent decisions_Set Require Presentation for one Payer
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL PO DEL MULTIPAYER2-Subsequent" and "<FilterValue>"
    When user select Rule with Multiple Payers "ONECPMPAYERSDB"
    And navigate to My tasks and go to rule in instance "" "PO Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When click on Require Presentation "select" and validate
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "CPM Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And select "RuleID"
    And click on "Start Review"
    When click on Require Presentation "select" and validate
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Status" "Manual RMR"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |


  @TCE2E11Custom 

  Scenario Outline: TC_1_1_End to End Billed with New code_Custom
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO ReviewSUBSEQUENTRUN" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "DEL" "No Action"
    When user ADD Code "Billed With (And)","0006T"
    Then Validate BOBW Config Link Submit "Billed With And"
    When user ADD Code "Billed Without (Or)","0009M"
    Then Validate BOBW Config Link Submit "Billed With And"
    And click on "Generate Summaries"
    Then validate BOBW Grid Data
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Review Segment "QA" "BW And/BWO Or Logic" "YES"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Testing Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Review Segment "Test" "BW And/BWO Or Logic" "YES"
    And Complete all testing Reviews
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Status" "Completed"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @TCE2E11Library @Feb30nightrun
  Scenario Outline: TC_1_1_End to End Billed with New code_Library
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO ReviewSUBSEQUENTRUN" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "DEL" "No Action"
    When user ADD Code "Billed With (And)","0009M"
    Then Validate BOBW Config Link Submit "Billed With And"
    When user ADD Code "Billed Without (Or)","0009M"
    Then Validate BOBW Config Link Submit "Billed With And"
    And click on "Generate Summaries"
    Then validate BOBW Grid Data
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Review Segment "QA" "BW And/BWO Or Logic" "YES"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Testing Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Review Segment "Test" "BW And/BWO Or Logic" "YES"
    And Complete all testing Reviews
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Status" "Completed"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  @TCE2E12Custom @Feb30nightrun
  Scenario Outline: TC_1_2_End to End Billed with Code Span_Custom
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO ReviewSUBSEQUENTRUN" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "DEL" "No Action"
    When user ADD Code "Billed With (And)","0006T"
    Then Validate BOBW Config Link Submit "Billed With And"
    And click on "Generate Summaries"
    Then validate BOBW Grid Data
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Review Segment "QA" "BW And/BWO Or Logic" "YES"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "NO"
    Then validate CPT Changes in Database "YES"
    And user Click on QA Review Complete ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Testing Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Review Segment "Test" "BW And/BWO Or Logic" "YES"
    And Complete all testing Reviews
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Status" "Completed"
    Then validate RMI Instruction in DB "Manual Add Codes for Billed With (And): 0006T."
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @TCE2E12Library @Feb30nightrun
  Scenario Outline: TC_1_2_End to End Billed with Code Span_Library
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO ReviewSUBSEQUENTRUN" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "DEL" "No Action"
    When user ADD Code "Billed With (And)","0006T"
    Then Validate BOBW Config Link Submit "Billed With And"
    And click on "Generate Summaries"
    Then validate BOBW Grid Data
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Review Segment "QA" "BW And/BWO Or Logic" "YES"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "NO"
    Then validate CPT Changes in Database "YES"
    And user Click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Testing Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Review Segment "Test" "BW And/BWO Or Logic" "YES"
    And Complete all testing Reviews
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Status" "Completed"
    Then validate RMI Instruction in DB "Manual Add Codes for Billed With (And): 0006T."
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  @TCE2E13CustomSample
  Scenario Outline: TC_1_3_End to End Billed with  alphanumeric_Custom
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO ReviewSUBSEQUENTRUN" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "DEL" "No Action"
    When user ADD Code "Billed With (And)","0006T"
    Then Validate BOBW Config Link Submit "Billed With And"
    And click on "Generate Summaries"
    Then validate BOBW Grid Data
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Review Segment "QA" "BW And/BWO Or Logic" "YES"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "NO"
    Then validate CPT Changes in Database "YES"
    And user Click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Testing Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Review Segment "Test" "BW And/BWO Or Logic" "YES"
    And Complete all testing Reviews
    Then validate RMI Instruction in DB "Manual Add Codes for Billed With (And): 0006T."
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @TCE2E13Library @Feb30nightrun
  Scenario Outline: TC_1_3_End to End Billed with  alphanumeric_Library
    When user click on "QA Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    #And Apply filters in My Task and Retrive Rule in DB "Final PO ReviewSUBSEQUENTRUN" and "<FilterValue>"
    #And select "RuleID"
    #And click on "Start Review"
    #And Complete Editorials with "No Editorial Changes"
    #And Select System Proposal "DEL" "No Action"
    #When user ADD Code "Billed With (And)","0006T"
    #Then Validate BOBW Config Link Submit "Billed With And"
    #And click on "Generate Summaries"
    #Then validate BOBW Grid Data
    #And click on "Authorize Decisions"
    #Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    #When Reassign task "" "iht_ittest01"
    #And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    #And click on "Start Review"
    #Then validate Review Segment "QA" "BW And/BWO Or Logic" "YES"
    #And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    #And update QA Rule and click on QA Review Complete "NO"
    Then validate CPT Changes in Database "YES"
    #And user Click on QA Review Complete "YES"
    #Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Testing Review"
    #When Reassign task "" "iht_ittest01"
    #And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL-Subsequent"
    #And select "RuleID"
    #And click on "Start Review"
    #Then validate Review Segment "Test" "BW And/BWO Or Logic" "YES"
    #And Complete all testing Reviews
    #Then validate RMI Instruction in DB "Manual Add Codes for Billed With (And): 0006T."
    #And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  @TCE2E14Custom
  Scenario Outline: TC_1_4_End to End Billed with  AND BWO Or Manual add_Custom
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO ReviewSUBSEQUENTRUN" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "DEL" "No Action"
    When user ADD Code "Billed With (And)","0006T"
    Then Validate BOBW Config Link Submit "Billed With And"
    When user ADD Code "Billed With (Or)","0006T"
    Then Validate BOBW Config Link Submit "Billed With (Or)"
    And click on "Generate Summaries"
    Then validate BOBW Grid Data
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Review Segment "QA" "BW And/BWO Or Logic" "YES"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Testing Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Review Segment "Test" "BW And/BWO Or Logic" "YES"
    And Complete all testing Reviews
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Status" "Completed"
    Then validate RMI Instruction in DB "Manual Add Codes for Billed With (And): 0006T."
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @TCE2E14Library @Feb30nightrun
  Scenario Outline: TC_1_4_End to End Billed with  AND BWO Or Manual add_Library
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO ReviewSUBSEQUENTRUN" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "DEL" "No Action"
    When user ADD Code "Billed With (And)","0006T"
    Then Validate BOBW Config Link Submit "Billed With And"
    When user ADD Code "Billed With (Or)","0006T"
    Then Validate BOBW Config Link Submit "Billed With (Or)"
    And click on "Generate Summaries"
    Then validate BOBW Grid Data
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Review Segment "QA" "BW And/BWO Or Logic" "YES"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Testing Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Review Segment "Test" "BW And/BWO Or Logic" "YES"
    And Complete all testing Reviews
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Status" "Completed"
    Then validate RMI Instruction in DB "Manual Add Codes for Billed With (And): 0006T."
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  @TCE2E151Custom 
  Scenario Outline: TC_1_5_End to End Manual add and Remove Rule Header 18
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "RULE HEADER" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "DEL" "No Action"
    When user ADD Code ReCode Logic "Include","01230","RECODE_HEADER"
    And click on "Generate Summaries"
    Then validate BOBW Grid Data
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "YES"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Testing Review"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue             |
      | FilterTaskStatus | Custom;Not Started;N;18 |

  @TCE2E15RemoveDE5263 @Feb1morrun
  Scenario Outline: TC_1_5_End to End Manual add and Remove_Custom
    							TC_1_5_End to End Manual add and Remove_Library

    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO ReviewSUBSEQUENTRUN" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "DEL" "No Action"
    When user ADD Code "Billed With (And)","0006T"
    Then Validate BOBW Config Link Submit "Billed With And"
    When user Remove "01991"
    And click on "Generate Summaries"
    Then validate BOBW Grid Data
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Review Segment "QA" "BW And/BWO Or Logic" "YES"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "NO"
    Then validate CPT Changes in Database "YES"
    And user Click on QA Review Complete ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Testing Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Review Segment "Test" "BW And/BWO Or Logic" "YES"
    And Complete all testing Reviews
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Status" "Completed"
    Then validate RMI Instruction in DB "Manual Add Codes for Billed With (And): 0006T."
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |


  @TC2997RequirePresent68 

  Scenario Outline: TC2997_6_8_Multiple CPM _Require Presentation
    When user click on "CPM Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL PO DEL MULTIPAYER2-Subsequent" and "<FilterValue>"
    When user select Rule with Multiple Payers "ONECPMPAYERSDB"
    And navigate to My tasks and go to rule in instance "" "PO Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When click on Require Presentation "select" and validate
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "CPM Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Status" "Manual RMR"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |


  @TC2997Obsolete68

  Scenario Outline: TC2997_6_8_Multiple CPM different decisions on config summaries_Obsolete
    When user click on "CPM Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL PO DEL MULTIPAYER2-Subsequent" and "<FilterValue>"
    When user select Rule with Multiple Payers "ONECPMOBSOLETE"
    And navigate to My tasks and go to rule in instance "" "PO Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "CPM Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Status" "Manual RMR"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @TCE2E12CodeSpan 
  Scenario Outline: TC_1_2_End to End Billed with Code Span_Custom
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO ReviewSUBSEQUENTRUN" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "DEL" "No Action"
    When user ADD Code "Billed With (And)","0006T"
    Then Validate BOBW Config Link Submit "Billed With And"
    And click on "Generate Summaries"
    Then validate BOBW Grid Data
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Review Segment "QA" "BW And/BWO Or Logic" "YES"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "NO"
    Then validate CPT Changes in Database "YES"
    And user Click on QA Review Complete ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Testing Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Review Segment "Test" "BW And/BWO Or Logic" "YES"
    And Complete all testing Reviews
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Status" "Completed"
    Then validate RMI Instruction in DB "Manual Add Codes for Billed With (And): 0006T."
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |

  @TCE2ECancelRetireCustom @Febday1fail
  Scenario Outline: TC_1_12_End to End Cancel retire_Custom
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO ReviewSUBSEQUENTRUN" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "DEL" "No Action"
    And Select System Proposal "DEL" "Modify"
    And click on "Generate Summaries"
    When user click on Retire Rule "No"
    When user Cancel Retire Rule
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    When Reassign task "CPM" "iht_ittest01 - iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    Then validate Retire Rule Link "NO"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Editorial Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Retire Rule Link "NO"
    When user complete all Editorial Reviews ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Retire Rule Link "NO"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "NO"
    Then Retire Rule Validation in DB "9999-12-31","NO"
    And user Click on QA Review Complete ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Testing Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Retire Rule Link "NO"
    And Complete all testing Reviews
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Status" "Completed"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |


  @TCE2ECancelRetireLibrary 

  Scenario Outline: TC_1_12_End to End Cancel retire_Library
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "Final PO ReviewSUBSEQUENTRUN" and "<FilterValue>"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "DEL" "No Action"
    And Select System Proposal "DEL" "Modify"
    And click on "Generate Summaries"
    When user click on Retire Rule "No"
    When user Cancel Retire Rule
    And click on "Authorize Decisions"
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Editorial Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Editorial Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Retire Rule Link "NO"
    When user complete all Editorial Reviews ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "QA Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "QA Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Retire Rule Link "NO"
    And complete all QA Reviews and update QA Rule and retrive Stub RMR ID
    And update QA Rule and click on QA Review Complete "NO"
    Then Retire Rule Validation in DB "9999-12-31","NO"
    And user Click on QA Review Complete ""
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Task" "Testing Review"
    When Reassign task "" "iht_ittest01"
    And navigate to My tasks and go to rule in instance "MyTasks" "Testing Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    Then validate Retire Rule Link "NO"
    And Complete all testing Reviews
    Then validate Admin rule review value "Admin" "FINAL PO DEL-Subsequent" "Status" "Completed"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue           |
      | FilterTaskStatus | Library;Not Started;N |

  @TC2997MDAccepted @Feb1morrun
  Scenario Outline: TC2997_6_8_Multiple_CPM_Both CPMs are FINAL MD Decision ACCEPTED
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL PO DEL MULTIPAYER2-Subsequent" and "<FilterValue>"
    When user select Rule with Multiple Payers "ONECPMPAYERSDB"
    And navigate to My tasks and go to rule in instance "" "PO Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And Complete Editorials with "No Editorial Changes"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And user Enter Final MD Config Comments
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "CPM Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Task" "QA Review"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |
      
      @TC2997MDAccepted @Decrelmonrun
  Scenario Outline: TC2997_6_8_Multiple_CPM_Both CPMs are FINAL MD Decision ACCEPTED
    When user click on "PO Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And Apply filters in My Task and Retrive Rule in DB "FINAL PO DEL MULTIPAYER2-Subsequent" and "<FilterValue>"
    When user select Rule with Multiple Payers "ONECPMPAYERSDB"
    And navigate to My tasks and go to rule in instance "" "PO Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    And Select System Proposal "DEL" "Remove"
    And click on "Generate Summaries"
    And user Enter Final MD Config Comments
    And click on "Authorize Decisions"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Task" "CPM Review"
    And navigate to My tasks and go to rule in instance "MyTasks" "CPM Review Work Queue" "FINAL PO DEL-Subsequent"
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    And User should be Logged out from IU Application
    Given user logs into "QA" with "iht_ittest02" into Interpretive Update Application
    And user navigate to IU "MyTasks" Instances Screen
    When user click on "CPM Review Work Queue" for "FINAL PO DEL-Subsequent" Instance
    And select "RuleID"
    And click on "Start Review"
    When user Complete CPM Decesion "Agree"
    And click on "Generate Summaries"
    When user Completed Authorize Decisions "CPM Summaries"
    Then validate Admin rule review value in DB "FINAL PO DEL-Subsequent" "Status" "QA Review"
    And User should be Logged out from IU Application

    Examples: 
      | FiterName        | FilterValue          |
      | FilterTaskStatus | Custom;Not Started;N |
      
      #
      #TC_1_6_End to End Multiple CPMs disagree MD decision and all CPMs in same page_Custom
#
#

#
#TC_7_5_System suggested to retire MD agreed by chagning the parameters_Library
#TC_7_6_System suggested to retire MD disagreed_Library
