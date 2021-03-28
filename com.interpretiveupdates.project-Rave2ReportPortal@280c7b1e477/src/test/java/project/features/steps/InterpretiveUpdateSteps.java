package project.features.steps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import project.feature.steps.definitions.InterpretiveUpdateStepDef;

public class InterpretiveUpdateSteps {

	@Steps
	InterpretiveUpdateStepDef oInterpretiveUpdateStepDef;

	@Given("^user logs into \"([^\"]*)\" with \"([^\"]*)\" into Interpretive Update Application$")
	public void userlogsintoInterpretiveUpdateApplication(String sEnvironmentType, String sUserID) throws Throwable {

		oInterpretiveUpdateStepDef.userLogsInToInterpretiveUpdateApplication(sEnvironmentType, sUserID);
		
		//Serenity.setSessionVariable("MidRuleVersion").to("7754.233");
		
	}

	@Given("^user navigate to IU \"([^\"]*)\" Instances Screen$")
	public void usernavigatetoIUInstancesScreen(String sInstanceType) throws Throwable {
		
		oInterpretiveUpdateStepDef.userNavigateToIUInstancesScreen(sInstanceType);
	}

	@Given("^user navigate to IU Smoke \"([^\"]*)\" Instances Screen$")
	public void usernavigatetoIUSmokeInstancesScreen(String sInstanceType) throws Throwable {
		
		oInterpretiveUpdateStepDef.userNavigateToIUSmokeInstancesScreen(sInstanceType);
	}

	@Then("^User should be Logged out from IU Application$")
	public void usershouldbeLoggedoutfromIUApplication() throws Throwable {
		oInterpretiveUpdateStepDef.userShouldbeLoggedout();
	}

	@Given("^click on \"([^\"]*)\" from Grid Table and navigate to Rule Review$")
	public void clickonfromGridTable(String sInstanceName) throws Throwable {
		oInterpretiveUpdateStepDef.clickOnInstanceNamefromGridTable(sInstanceName);
	}

	@Then("^user should able to view \"([^\"]*)\"$")
	public void usershouldabletoviewRule(String sTaskType) throws Throwable {
		oInterpretiveUpdateStepDef.userShouldAbleToViewWorkQueue(sTaskType);
	}

	@When("^user click on \"([^\"]*)\" for \"([^\"]*)\" Instance$")
	public void userclickonforInstance(String sTaskName, String sInstanceName) throws Throwable {
		oInterpretiveUpdateStepDef.clickTaskByInstanceName(sTaskName, sInstanceName);
	}

	@Then("^validate seleted active filter values$")
	public void validateseletedactivefiltervalues() throws Throwable {
		oInterpretiveUpdateStepDef.validateSeletedActiveFilterValues();
	}

	@When("^user select Rule with \"([^\"]*)\"$")
	public void userselectRulewith(String arg1) throws Throwable {
		
		oInterpretiveUpdateStepDef.selectRuleWithTask(arg1);

	}

	@Given("^click on \"([^\"]*)\"$")
	public void clickon(String arg1) throws Throwable {
		oInterpretiveUpdateStepDef.clickOnWorkQueue(arg1);

	}

	@Then("^Complete Editorials with \"([^\"]*)\"$")
	public void completeEditorialswith(String sUpdateType) throws Throwable {

		oInterpretiveUpdateStepDef.completeEditorialInFinalMDReview(sUpdateType);

	}

	@Given("^Select System Proposal \"([^\"]*)\" \"([^\"]*)\"$")
	public void selectSystemProposal(String sProposalType, String sDecision) throws Throwable {
		oInterpretiveUpdateStepDef.selectSystemProposal(sProposalType, sDecision);

	}

	@Given("^Add \"([^\"]*)\" with \"([^\"]*)\"$")
	public void addwith(String sCategory, String sCPTCode) throws Throwable {
		oInterpretiveUpdateStepDef.addCodeFunction(sCategory, sCPTCode);

	}

	@Then("^Validate BOBW Config Link Submit \"([^\"]*)\"$")
	public void validateBOBWConfigLinkSubmit(String sCategoryType) throws Throwable {

		oInterpretiveUpdateStepDef.validateBOBWConfigLinkSubmit(sCategoryType);

	}

	@When("^user Remove \"([^\"]*)\"$")
	public void userRemove(String sCPTCode) throws Throwable {

		oInterpretiveUpdateStepDef.validateRemoveCode(sCPTCode);

	}

	@Then("^validate BOBW Grid Data$")
	public void validateBOBWGridData() throws Throwable {

		oInterpretiveUpdateStepDef.validateBOBWGridData();
	}

	@When("^create versioned Rule \"([^\"]*)\"$")
	public void create_versioned_Rule(String sCreateRuleVersion) throws Throwable {

		oInterpretiveUpdateStepDef.retireRuleCheck(sCreateRuleVersion);
	}

	@Then("^validate BOBW Grid Data and Retire Rule Validation$")
	public void validateBOBWGridDataandRetireRuleValidation() throws Throwable {

		oInterpretiveUpdateStepDef.validateBOBWGridData();

	}

	@Then("^validate Admin rule review value \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void validateAdminrulereviewvalue(String sRole, String sRuleReviewID, String sColoumnName,String sExpectedvalue) throws Throwable {
		oInterpretiveUpdateStepDef.validateAdminRuleReviewValue(sRole, sRuleReviewID, sColoumnName, sExpectedvalue);

	}

	@Then("^Reassign task \"([^\"]*)\" \"([^\"]*)\"$")
	public void reassigntask(String sRole, String sReassignUserID) throws Throwable {
		oInterpretiveUpdateStepDef.reassignTask(sRole, sReassignUserID);

	}

	@Then("^navigate to My tasks and go to rule in instance \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void navigatetoMytasksandgotoruleininstance(String arg1, String arg2, String arg3) throws Throwable {
		oInterpretiveUpdateStepDef.navigateToMyTasksAndGoToRuleInInstance(arg1, arg2, arg3);

	}

	@Then("^select \"([^\"]*)\"$")
	public void select(String arg1) throws Throwable {
		oInterpretiveUpdateStepDef.selectRule(arg1);

	}

	@Then("^validate Review Segment \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void validateReviewSegment(String sTask, String sReviewSegment, String sDisplay) throws Throwable {
				
		oInterpretiveUpdateStepDef.validateReviewSegment( sTask,  sReviewSegment,  sDisplay);

	}

	@Then("^complete all QA Reviews and update QA Rule and retrive Stub RMR ID$")
	public void completeallQAReviewsandupdateQARuleandretriveStubRMRID() throws Throwable {

		oInterpretiveUpdateStepDef.completeAllQAReviewsAndUpdateQARule();
	}

	@Then("^validate CPT changes in DB \"([^\"]*)\" \"([^\"]*)\"$")
	public void validateCPTchangesinDB(String arg1, String arg2) throws Throwable {
		throw new PendingException();

	}

	@Then("^Complete all testing Reviews$")
	public void completealltestingReviews() throws Throwable {
		oInterpretiveUpdateStepDef.completeAllTestingReviews();

	}

	@Then("^validate RMI instructions in DB \"([^\"]*)\" \"([^\"]*)\"$")
	public void validateRMIinstructionsinDB(String arg1, String arg2) throws Throwable {
		throw new PendingException();

	}

	@Then("^user should be able see selected RuleVersion in the Grid$")
	public void usershouldbeableseeselectedRuleVersionintheGrid() throws Throwable {
		oInterpretiveUpdateStepDef.userShouldBeAbleSeeSelectedRuleVersion();
	}

	@Then("^Apply filter in \"([^\"]*)\" for \"([^\"]*)\" \"([^\"]*)\" and validate seleted active filter values$")
	public void applyfilterinforandvalidateseletedactivefiltervalues(String arg1, String arg2, String arg3)
			throws Throwable {
		oInterpretiveUpdateStepDef.applyActiveFilterMyTaskRuleWorkQueue(arg1, arg2);
	}

	@When("^user Completed Authorize Decisions \"([^\"]*)\"$")
	public void userCompletedAuthorizeDecisions(String sTaskType) throws Throwable {

		oInterpretiveUpdateStepDef.completeAuthorizeDecisions(sTaskType);
	}

	@Given("^Get rule from \"([^\"]*)\" for \"([^\"]*)\" instance$")
	public void get_rule_from_for_instance(String sWorkQueue, String sInstance) throws Throwable {
		oInterpretiveUpdateStepDef.getRuleFromWorkQueueForInstance(sWorkQueue, sInstance);
	}

	@Then("^veify rule in \"([^\"]*)\" for \"([^\"]*)\" instance$")
	public void veify_rule_in_for_instance(String sWorkQueue, String sInstance) throws Throwable {
		oInterpretiveUpdateStepDef.veifyRuleInWorkQueueForInstance(sWorkQueue, sInstance);

	}

	@When("^user assign CPM User to Payer \"([^\"]*)\"$")
	public void user_assign_CPM_User_to_Payer(String arg1) throws Throwable {

		oInterpretiveUpdateStepDef.userAssignPayerToCPMUser(arg1);
	}

	@Given("^reassign task from user \"([^\"]*)\" to \"([^\"]*)\" for \"([^\"]*)\" Instance$")
	public void reassign_task_from_user_to_for_Instance(String arg1, String arg2, String arg3) throws Throwable {
		oInterpretiveUpdateStepDef.click_on_AdminScrubTaskType(arg1, arg2, arg3);
	}

	@When("^Apply filters in My Task Rule Work Queue \"([^\"]*)\" and \"([^\"]*)\"$")
	public void apply_filters_in_My_Task_Rule_Work_Queue_and(String sFilterName, String sFilterValue) throws Throwable {
		oInterpretiveUpdateStepDef.applyActiveFilterMyTaskRuleWorkQueue(sFilterName, sFilterValue);
	}

	@Given("^user Enter Final MD Config Comments$")
	public void user_Enter_Final_MD_Config_Comments() throws Throwable {

		
		oInterpretiveUpdateStepDef.enterFinalMDConfigComments();
	}

	@When("^user Complete CPM Decesion \"([^\"]*)\"$")
	public void user_Complete_CPM_Decesion(String sAgreePayer) throws Throwable {

		oInterpretiveUpdateStepDef.completeCPMReview(sAgreePayer);
	}

	@Then("^rules which were marked as either candidates or non candidates by \"([^\"]*)\" should not be released$")
	public void rules_which_were_marked_as_either_candidates_or_non_candidates_by_should_not_be_released(String arg1)throws Throwable {
		
		oInterpretiveUpdateStepDef.rulesWhichWereMarkedAsEitherCandidatesOrNonCandidatesByShouldNotBeReleased(arg1);
	}

	@Given("^Select CPM System Proposal \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void select_CPM_System_Proposal(String arg1, String arg2, String arg3) throws Throwable {

		oInterpretiveUpdateStepDef.cpmSystemProposal(arg1, arg2, arg3);

	}

	@When("^return rule from \"([^\"]*)\" to \"([^\"]*)\"$")
	public void return_rule_from_to(String arg1, String arg2) throws Throwable {
		
		oInterpretiveUpdateStepDef.returnRule(arg1, arg2);

	}

	@When("^user select Rule with Multiple Payers \"([^\"]*)\"$")
	public void user_select_Rule_with_Multiple_Payers(String arg1) throws Throwable {
		
		oInterpretiveUpdateStepDef.selectRuleWithMultiPayer(arg1);
	}

	@Then("^Verify \"([^\"]*)\" Value as per RMI in Admin MD Scrub$")
	public void verify_Value_as_per_RMI_in_Admin_MD_Scrub(String arg1) throws Throwable {
		
		oInterpretiveUpdateStepDef.verifyColumnValueAsPerDBInAdminMD(arg1);
	}

	@Given("^create instance with \"([^\"]*)\" and \"([^\"]*)\" \"([^\"]*)\"$")
	public void create_instance_with_and(String arg1, String arg2, String arg3) throws Throwable {
		
		oInterpretiveUpdateStepDef.createInstance(arg1, arg2, arg3);
	}

	@Then("^complete Group Task Segments in MyTask with \"([^\"]*)\"$")
	public void complete_Group_Task_Segments_in_MyTask_with(String arg1) throws Throwable {
		
		oInterpretiveUpdateStepDef.completeGroupTaskSegmentsInMyTask(arg1);
	}

	@Then("^complete \"([^\"]*)\" and assign \"([^\"]*)\"$")
	public void complete_and_assign(String arg1, String arg2) throws Throwable {
		
		oInterpretiveUpdateStepDef.completeAssignments(arg1, arg2);
	}

	@Given("^\"([^\"]*)\" is on \"([^\"]*)\" on Admin MD scrub screen$")
	public void is_on_on_Admin_MD_scrub_screen(String sUser, String sPage) throws Throwable {
		
		oInterpretiveUpdateStepDef.navigateToPageOnAdminMDScrubScreen(sUser, sPage);

	}

	@Given("^click on one of the \"([^\"]*)\" cell which contains \"([^\"]*)\"$")
	public void click_on_one_of_the_cell_which_contains(String sColumn, String sFieldText) throws Throwable {
		
		oInterpretiveUpdateStepDef.clickOnOneOfTheCellWhichContainsFieldText(sColumn, sFieldText);
	}

	@Then("^insert rules of \"([^\"]*)\" with Query$")
	public void insert_rules_of_with_Query(String arg1) throws Throwable {
		
		oInterpretiveUpdateStepDef.insert_rules_of_with_Query(arg1);
	}

	@Then("^navigate to Admin rule review and Validate Column value \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void navigate_to_Admin_rule_review_and_Validate_Column_value(String arg1, String arg2, String arg3,String arg4) throws Throwable {
		
		oInterpretiveUpdateStepDef.navigateToAdminRuleReviewValidateColValues(arg1, arg2, arg3, arg4);

	}

	@When("^user click on \"([^\"]*)\" with \"([^\"]*)\"$")
	public void clickTaskWithNewInstanceName(String sTaskName, String sInstanceName) throws Throwable {
		
		oInterpretiveUpdateStepDef.clickTaskWithNewInstanceName(sTaskName, sInstanceName);
	}
	
	@Given("^click on \"([^\"]*)\" instance in Admin and navigate to Rule Review Page$")
	public void click_on_instance_in_Admin_and_navigate_to_Rule_Review_Page(String arg1) throws Throwable {
	  
		oInterpretiveUpdateStepDef.clickOnInstanceInAdminAndNavigateToRuleReviewPage(arg1);
	}

	@Given("^click on report hyper link in Rule review page$")
	public void click_on_report_hyper_link_in_Rule_review_page() throws Throwable {
	    
		oInterpretiveUpdateStepDef.clickOnReportHyperLinkInRuleReviewPage();
	}

	@Then("^verify \"([^\"]*)\" Report hyperlink is displayed$")
	public void verify_Report_hyperlink_is_displayed(String arg1) throws Throwable {
	    
		oInterpretiveUpdateStepDef.verifyAdminScrubReportHyperlinkIsDisplayed(arg1);
	}
	
	@When("^user complete all Editorial Reviews \"([^\"]*)\"$")
	public void user_complete_all_Editorial_Reviews(String arg) throws Throwable {
	   
		oInterpretiveUpdateStepDef.completeAllEditorialReviews(arg);
	}
	
	@Then("^validate Rule review value row wise \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void validate_Rule_review_value_row_wise(String sRowNo, String sTask, String sStatus, String Assignee) throws Throwable {
	   
		oInterpretiveUpdateStepDef.validateRuleReviewColRowValues(sRowNo, sTask,sStatus,Assignee);
	   
	}

	@When("^Reassign CPM on specific row \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void reassign_CPM_on_specific_row(String sRole, String sCPMFrom,String sCPMTo) throws Throwable {
	    
		oInterpretiveUpdateStepDef.reAssignToCPMUser(sRole, sCPMFrom, sCPMTo );
	}


	@Then("^validate sorting and filtering functionality$")
	public void validate_sorting_and_filtering_functionality() throws Throwable {
		oInterpretiveUpdateStepDef.clickColumnAndValidateFilterFunctionality();
		}
	
	@Then("^select all rows drag column header$")
	public void select_all_rows_drag_column_header() throws Throwable {
		oInterpretiveUpdateStepDef.selectallRowsDragColumnHeader();
	}
	
	@Given("^navigate to overview link and validate options available for MD$")
	public void navigate_to_overview_link_and_validate_options_available_for_MD() throws Throwable {
		oInterpretiveUpdateStepDef.navigateToOverviewLinkAndValidateOptionsAvailableForMD();
	}

	@Then("^verify Excel GUI in Admin Scrub$")
	public void verify_Excel_GUI_in_Admin_Scrub() throws Throwable {
		oInterpretiveUpdateStepDef.verifyExcelGUIInAdminScrub();
	}
	
	@Then("^validate Reassign functionality in Admin MD$")
	public void validate_Reassign_functionality_in_Admin_MD() throws Throwable {
		oInterpretiveUpdateStepDef.validateReassignFunctionalityInAdminMD();
	}
	
	@Then("^validate Admin MD Dashboard$")
	public void validate_Admin_MD_Dashboard() throws Throwable {
		oInterpretiveUpdateStepDef.validateAdminMDDashboard();
	}
	
	@Then("^validate retain filters$")
	public void validate_retain_filters() throws Throwable {
		oInterpretiveUpdateStepDef.validateRetainFilters();
	}
	
	@Then("^validate Admin view buttons disabled$")
	public void validate_Admin_view_buttons_disabled() throws Throwable {
		oInterpretiveUpdateStepDef.validateAdminViewButtonsDisabled();
	}
	
	@Then("^verify column header and filter popup when AdminMD enters zero list values then Apply Filter button is Disabled$")
	public void verify_column_header_and_filter_popup_when_AdminMD_enters_zero_list_values_then_Apply_Filter_button_is_Disabled() throws Throwable {
		oInterpretiveUpdateStepDef.verifyColumnHeaderAndFilterPopupWhenAdminMDEntersZeroListValues();
	}
	
	@Then("^verify following Label, and data is within that column of \"([^\"]*)\"$")
	public void verify_following_Label_and_data_is_within_that_column_of(String arg1) throws Throwable {
		oInterpretiveUpdateStepDef.verifyFollowingLabelAndDataIsWithinThatColumn(arg1);
	}
	
	@Then("^validate Generate summaries button enabled$")
	public void validate_Generate_summaries_button_enabled() throws Throwable {
	   
		oInterpretiveUpdateStepDef.verifyGenerateSummariesEnabled();
	}
	
	@Then("^validate decesion and proposal type list items$")
	public void validate_decesion_and_proposal_type_list_items() throws Throwable {
		
		oInterpretiveUpdateStepDef.validateSystemProposalListItems();
	   
	}
	
	@Then("^validate NoDecision Error and Confirm$")
	public void validate_NoDecision_Error_and_Confirm() throws Throwable {
		
		oInterpretiveUpdateStepDef.validateNoDecisionError();
	    
	}

	@Then("^Validate CPM Data \"([^\"]*)\"$")
	public void validate_CPM_Data(String arg1) throws Throwable {
  
	}
	
	@Then("^validate Split payer decsion in DB \"([^\"]*)\" \"([^\"]*)\"$")
	public void validate_Split_payer_decsion_in_DB(String sInstruction, String sManualRMRID) throws Throwable {
		
		oInterpretiveUpdateStepDef.validateSplitpayerInstruction(sInstruction, sManualRMRID);
		
	}

	@Then("^validate CPT Changes in Database \"([^\"]*)\"$")
	public void validate_CPT_Changes_in_Database(String arg1) throws Throwable {
		
		oInterpretiveUpdateStepDef.validateCPTChangesInDB(arg1);
	    
	}
	
	@When("^complete all Config Reviews$")
	public void complete_all_Config_Reviews() throws Throwable {
		
		oInterpretiveUpdateStepDef.completeConfigReview();
	   
	}

	@Then("^Complete Post Additional Configuration$")
	public void complete_Post_Additional_Configuration() throws Throwable {
		
		oInterpretiveUpdateStepDef.completePostAdditionalConfig();
	   
	}
	
	@When("^user click on \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_click_on(String arg1, String arg2) throws Throwable {
	   
		oInterpretiveUpdateStepDef.returnRuleResponse(arg1,arg2);
	}
	
	@Then("^validate Return Response Comments \"([^\"]*)\" \"([^\"]*)\"$")
	public void validate_Return_Response_Comments(String arg1, String arg2) throws Throwable {
	   
		oInterpretiveUpdateStepDef.validateReturnReviewComments(arg1,arg2);
	}
	
	@Then("^validate Editorial Changes in Database \"([^\"]*)\"$")
	public void validate_Editorial_Changes_in_Database(String arg1) throws Throwable {
	   
		oInterpretiveUpdateStepDef.validateEditorialChangesInDB(arg1);
	   
	}
	
	@When("^user click on task tab and go to rule in instance \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_click_on_task_tab_and_go_to_rule_in_instance(String arg1, String arg2, String arg3) throws Throwable {
		
		oInterpretiveUpdateStepDef.navigateToIUTasksAndGoToRuleInInstance(arg1,arg2,arg3);
	   
	}
	
	
	@When("^user click on Claim Tasks$")
	public void user_click_on_Claim_Tasks() throws Throwable {
		
		oInterpretiveUpdateStepDef.userClickonClaimTask();
	    
	}
	
	@Then("^user Upload File in TestingReview and validate$")
	public void user_Upload_File_in_TestingReview_and_validate() throws Throwable {
		
		oInterpretiveUpdateStepDef.uploadFileInTestingReview();
	    
	}

	
	@Then("^validate \"([^\"]*)\" editorial update popup$")
	public void validation_editorial_update_popup(String arg1) throws Throwable {
	   
		oInterpretiveUpdateStepDef.validate_editorial_update_popup(arg1);
	}

	
	@When("^user CPM Reassignment to \"([^\"]*)\"$")
	public void user_CPM_Reassignment_to(String arg1) throws Throwable {
	   
		oInterpretiveUpdateStepDef.CPMReassignRule(arg1);
	   
	}
	
	@When("^user ADD Code \"([^\"]*)\",\"([^\"]*)\"$")
	public void user_ADD_Code(String arg1, String arg2) throws Throwable {
	    
		oInterpretiveUpdateStepDef.ADDCodeinMD(arg1,arg2);
	}

	@When("^user navigate to group task IU screen$")
	public void user_navigate_to_group_task_IU_screen() throws Throwable {
	    
		oInterpretiveUpdateStepDef.user_navigate_to_group_task_IU_screen();
		
	}

	@When("^click task \"([^\"]*)\" by instance name \"([^\"]*)\" in group tasks tab$")
	public void click_task_by_instance_name_in_group_tasks_tab(String sTask, String arg2) throws Throwable {
	   
		oInterpretiveUpdateStepDef.click_task_by_instance_name_in_group_tasks_tab(sTask,arg2);
	}

	@When("^user Modify Code \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_Modify_Code(String arg1, String arg2, String arg3) throws Throwable {
		
		oInterpretiveUpdateStepDef.userModifyCode(arg1,arg2,arg3);
		
	}

	@Then("^user click on Generate Summaries and validate Error message \"([^\"]*)\"$")
	public void user_click_on_Generate_Summaries_and_validate_Error_message(String arg1) throws Throwable {
		
		oInterpretiveUpdateStepDef.clickonGenerateSummariesValidateMessage(arg1);
	}

	@Then("^validate BOBW Config Link and Submit$")
	public void validate_BOBW_Config_Link_and_Submit() throws Throwable {
		
		oInterpretiveUpdateStepDef.validateBOBWConfigLinkandSubmit();
	}

	@Then("^validate user in BWBWO Config Link \"([^\"]*)\" \"([^\"]*)\"$")
	public void validate_user_in_BWBWO_Config_Link(String arg1, String arg2) throws Throwable {
		
		oInterpretiveUpdateStepDef.validateUserBWBWOLink(arg1,arg2);
	}

	@Then("^user click on CPM Decision Complete and validate Error message \"([^\"]*)\"$")
	public void user_click_on_CPM_Decision_Complete_and_validate_Error_message(String arg1) throws Throwable {
		
		oInterpretiveUpdateStepDef.clickOnCPMValidateErrMsg(arg1);
	}

	@Then("^validate multiple rule id$")
	public void validate_multiple_rule_id() throws Throwable {
	   
		oInterpretiveUpdateStepDef.validate_multiple_rule_id();
	}

	@When("^click on Require Presentation \"([^\"]*)\" and validate$")
	public void click_on_Require_Presentation_and_validate(String arg1) throws Throwable {
		
		oInterpretiveUpdateStepDef.clickonRequirePresentation(arg1);
	}

	@Then("^validate CPM Decision and MD Recommendation$")
	public void validate_CPM_Decision_and_MD_Recommendation() throws Throwable {
		
		oInterpretiveUpdateStepDef.validateCPMAndMDDecision();
	}

	@Then("^user validate \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_validate(String arg1, String arg2) throws Throwable {
		
		oInterpretiveUpdateStepDef.validatePayerinCPMProposal(arg1,arg2);
	}

	@When("^user select different decisions at payer level$")
	public void user_select_different_decisions_at_payer_level() throws Throwable {
		
		oInterpretiveUpdateStepDef.selDifferentDecisionAtCPMPayerLevel();
	}

	@When("^set CPM Decision as MD Recommendation$")
	public void set_CPM_Decision_as_MD_Recommendation() throws Throwable {
		
		oInterpretiveUpdateStepDef.setCPMDecisionAsMDRecommend();
	}
	
	@When("^user select Multiple Payers Rule with NoAssignee \"([^\"]*)\"$")
	public void user_select_Multiple_Payers_Rule_with_NoAssignee(int sPayerQuantity) throws Throwable {
	   
		oInterpretiveUpdateStepDef.selectMultiPayerRuleNoAssignee(sPayerQuantity);
	   
	}
	
    @Given("^navigate and validate overview report$")
    public void navigate_and_validate_overview_report() throws Throwable {
           oInterpretiveUpdateStepDef.navigate_And_Validate_OVerviewReport();
    }

    @Given("^get rule from overview report$")
    public void get_rule_from_overview_report() throws Throwable {
           oInterpretiveUpdateStepDef.get_rule_from_overview_report();
       
    }

    @Given("^set \"([^\"]*)\" in MD Review$")
    public void set_no_change_required_in_MD_Review(String arg1) throws Throwable {
           oInterpretiveUpdateStepDef.setNoChangeRequiredInMDReview(arg1);
    }

    @Given("^validate rule and completed count in overview report$")
    public void validate_rule_and_completed_count_in_overview_report() throws Throwable {
           oInterpretiveUpdateStepDef.validate_rule_and_completed_count_in_overview_report();
    }
    
    @When("^select rule and validate RuleID Tab$")
    public void select_rule_and_validate_RuleID_Tab() throws Throwable {
           oInterpretiveUpdateStepDef.select_rule_and_validate_ruleid_tab();
    }

    @When("^validate overview ruleid tab$")
    public void validate_overview_ruleid_tab() throws Throwable {
           oInterpretiveUpdateStepDef.validate_overview_ruleid_tab();
    }
    
    @Given("^Authorize and validate warning message$")
    public void authorize_and_validate_warning_message() throws Throwable {
           
           oInterpretiveUpdateStepDef.authorize_decisions_and_validate_warning_message();

    }

    @Given("^Retire Rule$")
    public void retire_Rule() throws Throwable {
           
          oInterpretiveUpdateStepDef.retireRule();
           
    }
    
    @When("^user navigate to Admin rule review and Apply Filters \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void user_navigate_to_Admin_rule_review_and_Apply_Filters(String arg1, String arg2, String arg3, String arg4) throws Throwable {
    	
    	oInterpretiveUpdateStepDef.navigateToAdminRuleReviewApplyFilters(arg1,arg2,arg3,arg4);
       
    }
    
    @When("^user Navigate to Instance and Select Admin Actions \"([^\"]*)\" \"([^\"]*)\"$")
    public void user_Navigate_to_Instance_and_Select_Admin_Actions(String sInstanceType, String sActionType) throws Throwable {
       
    	oInterpretiveUpdateStepDef.selectAEActions(sInstanceType, sActionType);
       
    }

	@Then("^validate \"([^\"]*)\" No Decision$")
	public void validate_No_Decision(String arg1) throws Throwable {
		
		oInterpretiveUpdateStepDef.validate_MD_Comments_No_Decision(arg1);
	}
    
    @When("^validate cpm decision complete alert \"([^\"]*)\"$")
    public void validate_cpm_decision_complete_alert(String arg) throws Throwable {
    	oInterpretiveUpdateStepDef.validate_cpm_decision_complete_alert(arg);
    }

    @Given("^verify Modify decisions Tab$")
    public void verify_Modify_decisions_Tab() throws Throwable {
    	oInterpretiveUpdateStepDef.verify_Modify_decisions_Tab();
    }

    @When("^highlight non default values from manual proposals \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void highlight_non_default_values_from_manual_proposals(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
    	oInterpretiveUpdateStepDef.highlight_non_default_values_from_manual_proposals(arg1,arg2,arg3,arg4,arg5);
    }
    

	@When("^verify highlighted fields from summaries$")
	public void verify_highlighted_fields_from_summaries() throws Throwable {
		oInterpretiveUpdateStepDef.verify_highlighted_fields_from_summaries();
	}
	
	@Then("^get total rules count in Rule Review Work Queue$")
	public void get_total_rules_count() throws Throwable {
		oInterpretiveUpdateStepDef.get_total_rules_count_inRuleReviewWorkQueu();
	}

	@Then("^navigate to IU report \"([^\"]*)\"$")
	public void navigate_to_IU_report(String arg1) throws Throwable {
		oInterpretiveUpdateStepDef.navigate_to_IU_report(arg1);
	}

	@Then("^get IU Report rule count$")
	public void get_IU_Report_rule_count() throws Throwable {
		oInterpretiveUpdateStepDef.get_IU_Report_rule_count();
	}

	@Then("^validate IU Report count with total rules count$")
	public void validate_IU_Report_count_with_total_rules_count() throws Throwable {
		oInterpretiveUpdateStepDef.validate_IU_Report_count_with_total_rules_count();
	}
	
	@Given("^click on instance with status from Admin \"([^\"]*)\"$")
	public void click_on_instance_with_status_from_Admin(String arg1) throws Throwable {
		oInterpretiveUpdateStepDef.click_on_instance_with_status_from_Admin(arg1);
	}

	@Given("^select rule with columnheader \"([^\"]*)\",\"([^\"]*)\"$")
	public void select_rule_with_columnheader(String arg1, String arg2) throws Throwable {
		oInterpretiveUpdateStepDef.select_rule_with_columnheader(arg1,arg2);
	}
	
	@Given("^delete manual prop$")
	public void delete_manual_prop() throws Throwable {
		oInterpretiveUpdateStepDef.delete_manual_prop();
	}

	@Given("^verify run type column \"([^\"]*)\"$")
	public void verify_run_type_column(String arg1) throws Throwable {
		oInterpretiveUpdateStepDef.verify_run_type_column(arg1);
	}

	@Given("^validate \"([^\"]*)\" in IU Report$")
	public void validate_in_IU_Report(String arg1) throws Throwable {
		oInterpretiveUpdateStepDef.validate_in_IU_Reports(arg1);
	}

	@Given("^show rule review code \"([^\"]*)\"$")
	public void show_rule_review_code(String arg1) throws Throwable {
		oInterpretiveUpdateStepDef.show_rule_review_code(arg1);
	}
	
	@Then("^close IU Report window$")	
	public void close_IU_Report_window() throws Throwable {
		oInterpretiveUpdateStepDef.close_IU_Report_window();
	}
	
	@Given("^complete all QA Reviews$")
	public void complete_all_QA_Reviews() throws Throwable {
		oInterpretiveUpdateStepDef.complete_all_QA_Reviews();
	}

	@Given("^Update QA Rule$")
	public void update_QA_Rule() throws Throwable {
		oInterpretiveUpdateStepDef.update_QA_Rule();
	}

    @Then("^complete Assignment Exceptions \"([^\"]*)\" \"([^\"]*)\"$")
    public void complete_Assignment_Exceptions(String sInstanceType, int arg2) throws Throwable {
       
    	oInterpretiveUpdateStepDef.completeAssignmentExceptions(sInstanceType, arg2 );
    }
     
    @When("^complete cpm decision complete \"([^\"]*)\"$")
    public void complete_cpm_decision_complete(String sDecision) throws Throwable {
    	oInterpretiveUpdateStepDef.complete_cpm_decision_complete(sDecision);
    }

    @Then("^validate Admin rule review value in DB \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void validate_Admin_rule_review_value_in_DB(String sInstanceType, String sColumnName, String sColumnValue) throws Throwable {
        
    	oInterpretiveUpdateStepDef.vaidateAdminRuleReviewDB(sInstanceType,sColumnName,sColumnValue);
    }
    
    @When("^Apply filters in My Task and Retrive Rule in DB \"([^\"]*)\" and \"([^\"]*)\"$")
    public void apply_filters_in_My_Task_and_Retrive_Rule_in_DB_and(String arg1, String arg2) throws Throwable {
       
    	oInterpretiveUpdateStepDef.applyFiltersInMyTaskDB(arg1, arg2);
    }
    
    @Given("^retire rule validation in DB \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void retire_rule_validation_in_DB(String arg1, String arg2, String arg3) throws Throwable {
    	
    	oInterpretiveUpdateStepDef.retire_rule_validation_in_DB(arg1,arg2,arg3);
    }

    
    @Then("^update QA Rule and click on QA Review Complete \"([^\"]*)\"$")
    public void update_QA_Rule_and_click_on_QA_Review_Complete(String arg1) throws Throwable {
    	
    	oInterpretiveUpdateStepDef.updateQARuleNDReview(arg1);
        
    }
    
    @Then("^validate return response comments$")
    public void validate_return_response_comments() throws Throwable {
    	
    	oInterpretiveUpdateStepDef.validate_return_response_comments();
    	
    }
    
    @When("^Add code function with POS code \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void add_code_function_with_POS_code(String sCategory, String sCPTCode, String sPOSCode, String sOverrideFlag) throws Throwable {
       
    	oInterpretiveUpdateStepDef.add_code_function_with_poscode(sCategory, sCPTCode, sPOSCode, sOverrideFlag);
    }


    @Then("^user Click on QA Review Complete \"([^\"]*)\"$")
    public void user_Click_on_QA_Review_Complete(String arg1) throws Throwable {
        
    	oInterpretiveUpdateStepDef.clickOnQAReviewComplete(arg1);
        
    }
    
    @Then("^validate RMI Instruction in DB \"([^\"]*)\"$")
    public void validate_RMI_Instruction_in_DB(String arg1) throws Throwable {
    	
    	oInterpretiveUpdateStepDef.validateRMIInstruction(arg1);
        
    }

    @Given("^validate the user role operation \"([^\"]*)\",\"([^\"]*)\"$")
    public void validate_the_user_role_operation(String arg1, String arg2) throws Throwable {
        
    	oInterpretiveUpdateStepDef.validate_the_user_role_operation(arg1,arg2);
    	
    }
    
    @When("^user ADD Code ReCode Logic \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void user_ADD_Code_ReCode_Logic(String arg1, String arg2, String arg3) throws Throwable {
        
    	oInterpretiveUpdateStepDef.ADDCodeRecodeLogic(arg1,arg2,arg3);
    }
    
    @When("^user retrieve non candiate rules to rule review \"([^\"]*)\"$")
    public void user_retrieve_non_candiate_rules_to_rule_review(String arg1) throws Throwable {
    	
    	oInterpretiveUpdateStepDef.retriveNonCandidateRules(arg1);
    	
        
    }


    @Given("^Get Rule and Payer value$")
    public void get_Rule_and_Payer_value() throws Throwable {
    	oInterpretiveUpdateStepDef.retriveMidRulePayer();
    }

    @Then("^validate rule in rule review screen \"([^\"]*)\"$")
    public void validate_rule_in_rule_review_screen(String arg1) throws Throwable {
        
        
    }
    
    @Then("^validate Deactivate error message$")
    public void validate_Deactivate_error_message() throws Throwable {
    	
    	oInterpretiveUpdateStepDef.checkDeactivatedRuleMessages();
    }
    
    @Then("^validate System Proposals comments \"([^\"]*)\"$")
    public void validate_System_Proposals_comments(String arg1) throws Throwable {
    	
    	oInterpretiveUpdateStepDef.validateRationalComments(arg1);
       
    }
    
    @When("^Get System Proposal Types \"([^\"]*)\"$")
    public void get_System_Proposal_Types(String arg1) throws Throwable {
    	
    	oInterpretiveUpdateStepDef.getAndValidateSystemProposals(arg1);
       
    }
    
    @When("^Get New Rule Version in QA$")
    public void get_New_Rule_Version_in_QA() throws Throwable {
       
    	oInterpretiveUpdateStepDef.getNewRuleVersion();
       
    }
    
    @When("^user click on Rule Request for \"([^\"]*)\"$")
    public void user_click_on_Rule_Request_for(String arg1) throws Throwable {
        
    	oInterpretiveUpdateStepDef.ruleRequest(arg1);
    }
    
    @Then("^user click on CPM Decision Complete and validate Error message \"([^\"]*)\",\"([^\"]*)\"$")
    public void user_click_on_CPM_Decision_Complete_and_validate_Error_message(String arg1, String arg2) throws Throwable {
    	
    	oInterpretiveUpdateStepDef.modifyCPMSystemProposalError(arg1, arg2);
        
    }
    
    @When("^user Modify CPM Manual Proposals \"([^\"]*)\",\"([^\"]*)\"$")
    public void user_Modify_CPM_Manual_Proposals(String arg1, String arg2) throws Throwable {
       
    	oInterpretiveUpdateStepDef.modifyCPMManualProposals(arg1,arg2);
    	
    }
    
   
    @Then("^validate Link \"([^\"]*)\" \"([^\"]*)\"$")
    public void validate_Link(String arg1, String arg2) throws Throwable {
       
    	//oInterpretiveUpdateStepDef
       
    }
    
    @Then("^validate Roll Up Functionality \"([^\"]*)\"$")
    public void validate_Roll_Up_Functionality(String arg1) throws Throwable {
       
    	oInterpretiveUpdateStepDef.ValidateROLLUpSystem(arg1);
    	
    }


    @Given("^validate rule id$")
    public void validate_rule_id() throws Throwable {
    	
    	oInterpretiveUpdateStepDef.validate_rule_id();
    }
    

	@Given("^validate POS Sensitiviti \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void validate_POS_Sensitiviti(String sProposalTypes, String sFilter, String sIndicator, String sReason, String sComments) throws Throwable {
		
		oInterpretiveUpdateStepDef.validate_POS_Sensitivity(sProposalTypes, sFilter, sIndicator, sReason, sComments);
	}
	
	@When("^user Cancel Retire Rule$")
	public void user_Cancel_Retire_Rule() throws Throwable {
	   
		oInterpretiveUpdateStepDef.cancel_Retire_Rule();
	}
	
	@When("^user click on Retire Rule \"([^\"]*)\"$")
	public void user_click_on_Retire_Rule(String arg1) throws Throwable {
	   
		oInterpretiveUpdateStepDef.retireRule(arg1);
	}
	
	@Then("^validate Retire Rule Link \"([^\"]*)\"$")
	public void validate_Retire_Rule_Link(String arg1) throws Throwable {
	   
		oInterpretiveUpdateStepDef.validateRetireRuleLink(arg1);
	}
	
	@Then("^Retire Rule Validation in DB \"([^\"]*)\",\"([^\"]*)\"$")
	public void retire_Rule_Validation_in_DB(String arg1, String arg2) throws Throwable {
	   
		oInterpretiveUpdateStepDef.retireRuleValidationInDB(arg1, arg2);
	   
	}
	
	@Then("^Impact Code List Griddata and modify decision \"([^\"]*)\"$")
	public void impact_Code_List_Griddata_and_modify_decision(String arg1) throws Throwable {
	    
		oInterpretiveUpdateStepDef.validateCPMImpactCodeListGrid(arg1);
	}
	
	
	@Then("^validate CPT ARD Link in CPM$")
	public void validate_CPT_ARD_Link_in_CPM() throws Throwable {
	   
		oInterpretiveUpdateStepDef.validateCPTARD();
	   
	}
	
	@Then("^validate Config Summary Payer Specific Decision$")
	public void validate_Config_Summary_Payer_Specific_Decision() throws Throwable {
	   
		oInterpretiveUpdateStepDef.validateConfigPayerSpecificDecision();
	   
	}
	
	@Then("^capture all filter values in \"([^\"]*)\"$")
	public void capture_all_filter_values_in(String arg1) throws Throwable {
	    
		oInterpretiveUpdateStepDef.capturingAllFilterValues(arg1);
	}
	
	@When("^user selects the rule and click on the on the \"([^\"]*)\" button$")
	public void user_selects_the_rule_and_click_on_the_on_the_button(String arg1) throws InterruptedException {
		
		oInterpretiveUpdateStepDef.user_selects_the_rule_in_AdminScrub(arg1);
	    
	}

	@When("^user clicks on the \"([^\"]*)\" button$")
	public void user_clicks_on_the_button(String arg1) throws InterruptedException {
	    
		oInterpretiveUpdateStepDef.click_On_button_AdminScrubPage(arg1);
	}

	@Then("^validate Direct Release button \"([^\"]*)\" for \"([^\"]*)\"$")
	public void validate_Direct_Release_button_for(String arg1, String arg2) throws InterruptedException {
		
		oInterpretiveUpdateStepDef.validateDirectReleaseBtnStatus(arg1,arg2);
	    
	}
	
	@Given("^user enters the comments and click on the ok button$")
	public void user_enters_the_comments_and_click_on_the_ok_button() throws InterruptedException {
	    
		oInterpretiveUpdateStepDef.user_enters_the_comments_and_click_on_the_button();
	}
	
	@When("^user load Same Sim data through Database \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_load_Same_Sim_data_through_Database(String arg1, String arg2) throws InterruptedException {
		
		oInterpretiveUpdateStepDef.loadSimDataInDB(arg1,arg2);
	   
	}

	@Then("^click on \"([^\"]*)\" and validate \"([^\"]*)\"$")
	public void click_on_and_validate(String arg1, String arg2) {
		
		
	   
	}
	
	@When("^user click on \"([^\"]*)\" for \"([^\"]*)\"$")
	public void user_click_on_for(String arg1, String arg2) throws InterruptedException {
		oInterpretiveUpdateStepDef.requestImpactAnalysis(arg1,arg2);
	    
	}
	
	@Then("^user wait for Scrub Status After Impact \"([^\"]*)\"$")
	public void user_wait_for_Scrub_Status_After_Impact(String arg1) throws InterruptedException {
	   
		oInterpretiveUpdateStepDef.checkInstanceAfterImpact(arg1);
	}
	

	
}
