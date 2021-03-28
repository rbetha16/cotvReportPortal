package project.pageobjects;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import freemarker.template.utility.StringUtil;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import project.utilities.GenericUtils;
import project.utilities.ProjectVariables;
import project.utilities.SeleniumUtils;

public class IUHomePage extends PageObject {

	SeleniumUtils oSeleniumUtils;
	GenericUtils oGenericUtils;
	

//*****************************************************Elements with WebElementFacade ********************************************************	
	
	@FindBy(xpath = "//div[text()='Loading Rules ...' or text()='Loading...' or text()='Please Wait' or text()='Retrieving interpretive update role users ...'] | //span[text()='Progress']")
	public WebElementFacade Loading;

	@FindBy(xpath = "//img[@alt='No loading Image']")
	public WebElementFacade AdminMDScrubIcon;

	@FindBy(xpath = "//a[text()='Interpretive Rule Update']")
	public WebElementFacade MyTaskInterpretiveRuleUpdateLink;

	@FindBy(xpath = "//a[text()='Interpretive Update Instances']")
	public WebElementFacade AdminInterpretiveUpdateInstanceLink;

	@FindBy(xpath = "//div[@class='GEFT4QHBGMC']")
	public String IUInstanceGrid;

	@FindBy(xpath = "(//div[@class='GEFT4QHBKO'])[2]")
	public WebElementFacade MD_Review_WorkQueue;

	@FindBy(xpath = "//div[@class='GEFT4QHBJSC']")
	public WebElementFacade MyTasksIUInstanceGrid;

	@FindBy(xpath = "(//div[@class='GEFT4QHBKO'])[4]")
	public WebElementFacade Rule_Review_WorkQueue;

	@FindBy(xpath = "(//div[@class='GEFT4QHBIMC'])[2]")
	public WebElementFacade Actions_Instance_Grid;

	@FindBy(xpath = "(//a[@class='x-tab-strip-close'])[2]")
	public WebElementFacade Close_Btn;

	@FindBy(xpath = "//span[@class='GEFT4QHBKUC' and text()='Individual Tasks - iht_ittest01']")
	public WebElementFacade IndividualTasks_Tab;

	@FindBy(xpath = "//span[text()='Group Tasks']//ancestor::ul/parent::div//li[2]//ancestor::em/ancestor::a//ancestor::li/ancestor::ul/parent::div/parent::div/following-sibling::div/child::div")
	public WebElementFacade GroupTasksGrid;

	@FindBy(xpath = "//a[text()='Interpretive Rule Update']")
	public WebElementFacade InterpetiveUpdate_Btn_MyTasks;
	
	@FindBy(xpath = "//textarea[@id='1_cpmInterpComment.comments']")
	public WebElementFacade SystemProposalType;
	
	@FindBy(xpath = "//select[@id='1_decisionAction.decisionActionKey']")
	public WebElementFacade SystemProposalDecision;
	
	@FindBy(xpath = "//select[@name='decisionAction.decisionActionKey']")
	public WebElementFacade MDSystemProposal;
	
	
	
	@FindBy(xpath = "//select[@id='1_cpmDecisionAction.decisionActionKey']")
	public WebElementFacade CPMSystemProposal;

	@FindBy(id = "fullView")
	public WebElementFacade fullView_chckBox;

	@FindBy(xpath = "//select[@name='associatedWithUpdateInstance']")
	public WebElementFacade ManualProposalUpdateInstanceDropdwn;

	@FindBy(xpath = "(//input[@name='interpRuleCpt.cptCode'])[2]")
	public WebElementFacade ManualProposalsCptCode;

	@FindBy(xpath = "//table[@id='Manual_Proposals_grid']//textarea")
	public WebElementFacade ManualProposalsRationaleComments;

	@FindBy(xpath = "//td[@aria-describedby='Manual_Proposals_grid_category']//select")
	public WebElementFacade ManualProposalCatgoryDropdwn;

	@FindBy(id = "ddlMDDecision")
	public WebElementFacade Retirerule_MDecision;

	@FindBy(xpath = "//div[text()='PO Comments:']/following-sibling::div[@class='col-md-5']/textarea")
	public WebElementFacade MD_Comments;

	@FindBy(xpath = "//button[@class='btn btn-primary ng-binding']")
	public WebElementFacade Confirm_Yes;

	@FindBy(xpath = "//span[text()='Configuration Summaries']/parent::div/parent::div/child::div[3]//table")
	public WebElementFacade Configuration_Summary_Content;

	@FindBy(xpath = "//label[@class='radio-inline']/input")
	public WebElementFacade NewBilled_Radio_button;
	
	@FindBy(xpath = "(//label[@class='radio-inline']/input)[2]")
	public WebElementFacade BW_Radio_button;

	@FindBy(xpath = "//div[@class='GEFT4QHBGQ' and text()='GO']")
	public WebElementFacade GO_Btn_Admin;

	@FindBy(xpath = "(//input[@class='GEFT4QHBE0 GEFT4QHBP-'])[5]")
	public WebElementFacade GoToRuleAdmin;

	@FindBy(xpath = "//div[.='Remove Bulk Decision']/following-sibling::div[9]/child::div")
	public WebElementFacade ReAssignNavigationAdmin;

	@FindBy(xpath = "//div[.='Bulk Reassignment - Decision Capture']")
	public String BulkReassignmentDecision_Dailg;

	@FindBy(xpath = "//div[text()='Enter the Code to be removed and click search :']/following-sibling::div[@class='col-md-2']/input")
	public WebElementFacade Code_Removed;

	@FindBy(xpath = "//div[text()='Rationale Comment: ']/following-sibling::div[@class='col-md-5']/textarea")
	public WebElementFacade Rational_Comment;

	@FindBy(xpath = "(//div[@class='x-grid-row-checker']/../../../td[@cellindex='0']/child::div/child::div)[1]")
	public WebElementFacade Column_GridCheck;

	@FindBy(xpath = "//label[text()='Reassign the selected rules to:']/parent::div//input/parent::td/following-sibling::td/child::div")
	public WebElementFacade CPM_Reassgin_ListNavigaion;

	@FindBy(xpath = "//label[text()='Stub RMR ID: ']/following-sibling::label")
	public WebElementFacade Stub_RMR_ID;

	@FindBy(xpath = "//label[contains(text(),'Authorize Decisions')]/parent::div/child::label[3]")
	public WebElementFacade RetireRuleBtn;

	@FindBy(xpath = "(//input[@name='impactChkName1'])[2]")
	public WebElementFacade ImpactChkName;
	
	@FindBy(xpath = "(//input[@name='impactChkName1'])[1]")
	public WebElementFacade ImpactChkNameEditorial;

	@FindBy(xpath = "//div[@id='jqgh_impactCodeListGrid_qaReview10']//input[@id='impactSelectAll']")
	public WebElementFacade ImpactReviewCodeAll;
	
	@FindBy(xpath = "//div[@id='jqgh_impactCodeListGrid_editorialReview10']//input[@id='impactSelectAll']")
	public WebElementFacade EditorialImpactReviewCodeAll;
	
	@FindBy(xpath = "//textarea[@ng-model='config.additionalConfigInstructions']")
	public WebElementFacade ConfigSummaryInstruction;

	@FindBy(xpath = "//input[@type='button' and @value='Save']")
	public WebElementFacade ConfigSummarySaveButton;

	@FindBy(xpath = "//div[contains(text(),'No Configuration Summary Data Found')]")
	public WebElementFacade NoConfigSummaryContent;

	@FindBy(xpath = "//div[text()='Saving payer assignments...']")
	public WebElementFacade CPM_Saving_Load;

	@FindBy(xpath = "//a[text()='Interpretive Rule Update']")
	public WebElementFacade MyTaskInterpetiveUpdatelink;

	@FindBy(xpath = "//input[@id='ModalContentSearch']")
	public WebElementFacade AdminPopCellSearchBox;

	@FindBy(xpath = "(//select[@name='cpmDecisionAction.decisionActionKey'])[2]")
	public WebElementFacade CPM_Decision_Select;

	@FindBy(xpath = "//textarea[@name='cpmInterpComment.comments']")
	public WebElementFacade CPM_Decision_Comments;

	@FindBy(xpath = "//input[@id='cb_requirePresentationGrid']")
	public WebElementFacade RequirePresentationChkbox;

	@FindBy(xpath = "//select[@name='agree10']")
	public WebElementFacade Select_CPM_Agree;

	@FindBy(xpath = "//textarea[@name='cpmConfigComments']")
	public WebElementFacade Select_CPM_Config;
	
	@FindBy(xpath = "//div[@class='GEFT4QHBJ2C x-grid-hd-checker']")
	public WebElementFacade Col_Rule_Grid;
	
	@FindBy(xpath = "//span[text()='Reassign']")
	public WebElementFacade Reassign_Btn;
	
	@FindBy(xpath = "//div[@class='imageLoader']")
	public WebElementFacade AdminScrubImageLoader;
	
	@FindBy(xpath = "//input[@id='filterTextSearch']")
	public WebElementFacade AdminScrubFilterTextSearch;
	
	@FindBy(xpath = "//button[text()='Apply Filter']")
	public WebElementFacade ApplyFilterButton;
	
	@FindBy(xpath = "//span[text()='Cancel']")
	public WebElementFacade CancelButton;
	
	@FindBy(xpath = "//div[@ng-repeat='(colRenderIndex, col) in colContainer.renderedColumns track by col.uid']/child::div//input[iValue]")
	public WebElementFacade SelectCheckbox;

	@FindBy(xpath="(//label[contains(text(),'Modify Decisions')])[position()=last()]")
	public WebElementFacade ModifyDecisions;
	
	@FindBy(xpath="//span[text()='Final PO Comments']/../../../..//div[2]//textarea")
	public WebElementFacade FMDComments;
	
	public String MDAlertMessage="//h3[text()='Alert']/../following-sibling::div//div";
	
	@FindBy(xpath="(//label[text()='Resolved Rule Description:'])[1]/../following-sibling::div//textarea")
	public WebElementFacade ResolvedRuleDescription;
	
	@FindBy(xpath="(//textarea[text()='Automation testing'])[1]")
	public WebElementFacade RationalComments;
	
	@FindBy(xpath="((//table[@id='requirePresentationGrid']//tr)[2]//td//input)[1]")
	public WebElementFacade SelectRequirePresent1;
	
	
	@FindBy(xpath = "//label[text()='User Name :']/../..//input[@type='text']")
	public WebElementFacade BuilderARD_UserName;
	
	@FindBy(xpath = "//label[text()='Password :']/../..//input[@type='password']")
	public WebElementFacade BuilderARD_Password;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	public WebElementFacade Builder_SignInBtn; 
	
	@FindBy(xpath="//table[@id='requirePresentationGrid']//tr[2]//input")
	public WebElementFacade SelectFirstRequirePresent;
	

	@FindBy(xpath = "//th[@id='impactCodeListGrid_testingReview10']//input[@id='impactSelectAll']")
	public WebElementFacade TestingImpactReviewCodeAll;
	
	@FindBy(xpath = "//input[@id='testingReview10_1']")
	public WebElementFacade ImpactChkboxTesting;


//*****************************************************String XPaths********************************************************

	public String New_UpdateInstance_Screen = "//div[@class='GEFT4QHBKO xcomponent']";
	
	public String ImpactReviewCodeList="//div[@id='jqgh_impactCodeListGrid_qaReview10']//input[@id='impactSelectAll']";
	
	public String TasksTabs = "//span[@class='GEFT4QHBKUC' and contains(text(),'sValue')]";

	public String Rule_Version = "//label[text()='Rule Version: '][last()]";

	public String LibraryStatusFilter = "(//div[@class='GEFT4QHBKO'])[3 or 2]/child::div/div[text()='sValue']";
	
	public String LibraryAdminFilter = "//div[@class='GEFT4QHBOYC' and text()='sValue']";

	public String Col_Payers = "//td[15]//div[@class='GEFT4QHBE3C']";

	public String Admin_Col_Payers = "(//div[@class='GEFT4QHBBJC'])[3]//td[3]//div[@class='GEFT4QHBE3C']";

	public String CPM_Payer_Save = "(//div[@class='GEFT4QHBDVC x-toolbar x-toolbar-mark x-small-editor'])[3]//div[text()='Save']";

	public String CPM_Payer_Yes = "//div[@class='GEFT4QHBJYC']//div[text()='Yes']";

	public String AllRulesRadioBtn = "//input[@type='radio' and @value='allUserRules']";

	public String MyTaskRuleVersion = "//span[text()='Rule Version']/../../../../../../../following-sibling::div[1]/child::div/child::table//td[@cellindex='1']/div[text()='sValue']";

	public String RuleVersionTxt = "//span[text()='Rule Version']/../../../../../../../following-sibling::div[1]/child::div/child::table//td[@cellindex='1']//div";

	public String InstanceName = "//td[@cellindex='0']//div[text()='sValue']";

	public String TaskandInstance = "//tr[(td[1]='sValue') and (td[2]='sInstance')]//div[@class='GEFT4QHBE3C iht-HyperLinkText']";

	public String AdminTaskValidation = "//tr[(td[1]='sValue') and (td[2]='sInstance')]//div[@class='GEFT4QHBE3C iht-HyperLinkText']";

	public String AdminInstance = "//tr[(td[1]='sValue')]//div[@class='GEFT4QHBE3C iht-HyperLinkText']";
	
	public String AdminScrubInstanceInAdmin = "//tr[(td[1]='"+ProjectVariables.AdminScrubInstance+"' and td[7]='Admin PO Scrub Review')]//div[@class='GEFT4QHBE3C iht-HyperLinkText']";
	
	public String MD_WorkQueue_CellData = "(//div[@class='GEFT4QHBGIC GEFT4QHBKO'])[1]//tr//td";

	public String ActiveFiterDropDwnBtn = "//label[contains(text(),'sValue')]/..//td[2]//div";

	public String StartReview = "//label[@class='btn btn-primary ng-binding ng-scope ng-pristine ng-valid' and contains(text(),'Start Review')]";

	public String frame = "(//iframe[@class='gwt-Frame x-component'])[position()=last()]";
	
	public String oVerViewframe = "(//iframe[@class='gwt-Frame x-component'])[2]";

	public String IUReportFrame="//iframe[@class='gwt-Frame']";
	
	public String StartReviewPopMessage = "//p[text()='Please confirm you wish to start Final PO Review.']";

	//public String ApplyFilterValues = "(//table[@class='GEFT4QHBI3C'])[4 or 5]//div[text()='sValue']/../..//div//div";
	
	public String ApplyFilterValues = "//td[@class='GEFT4QHBC3C x-grid-cell-last']/child::div[text()='sValue']/parent::td/preceding-sibling::td/child::div/child::div";
	
	public String FilterValuesValidation = "(//div[@class='GEFT4QHBBJC'])[2 or 3]//div[text()='sValue']";

	public String InstanceVersion = "(//div[@class='GEFT4QHBKO'])[4]//tr[@class='GEFT4QHBK3C GEFT4QHBFN'][1]//td[@cellindex='1']//div";

	public String MD_RuleReview_Version = "(//div[@class='GEFT4QHBMHC'])[4]//tr[@class='GEFT4QHBK3C GEFT4QHBFN'][1]//td[@cellindex='1']//div";

	public String sFrame = ".//iframe[@class='gwt-Frame x-component']";

	public String AlertPopUpSys = "//p[text()=' Successfully saved proposal decisions.']";

	public String StartReviewPoPYesBtn = "//button[contains(text(),'Yes')]";

	public String MyTaskRuleVersions = "(//div[@class='GEFT4QHBKO'])[2]//table[@class='GEFT4QHBI3C']//tr[@class='GEFT4QHBK3C GEFT4QHBFN']//td[@cellindex=1]";

	public String StartNewRadio_Btn = "//input[@type='radio' and @value='startNew']";

	public String ManualProposalsComments = "(//textarea[@name='interpComment.comments'])[2]";

	public String SystemProposalCommments = "(//textarea[@name='interpComment.comments'])[1]";
	
	public String MDSystemProposalComments = "(//textarea[@name='interpComment.comments'])";
	
	public String SystemProposalChecbox = "//table[@id='Data_Model_Decisions_grid']//td[@class='td_cbox']//input[1]";

	public String Editorials = "//div[@class='btn-group reviewActBtnGroup']//label[contains(text(),'sValue')]";

	public String No_Edit_Required = "//label[@class='btn btn-primary' and text() ='sValue']";
	
	public String CompleteEditorials_Approve = "//label[@class='btn btn-primary ng-pristine ng-valid' and text() ='sValue']";

	public String Authorize_Decisions = "//p[contains(text(),'Selecting Authorize Decisions completes the')]";

	public String closeTabs = "//a[@class='x-tab-strip-close']";

	public String Go_to_Rule = "//div[.='Go To Rule:']/parent::div//input";

	public String Go_Btn = "//div[text()='Go To Rule:']/parent::div/div[.='GO']";

	public String ReAssignToListBox = "//td[.='Re-Assign To']/../following-sibling::tr/child::td[3]//td/following::div//div[text()='sValue']";

	public String ReAssignToListBoxIcon = "//td[.='Re-Assign To']/../following-sibling::tr/child::td[3]//td[2]//div";

	public String Column_Status = "//span[text()='Rule Version']/../../../../../../../following-sibling::div[1]/child::div/child::table//td[@cellindex='sValue']//span";

	public String Assignee_Status = "//span[text()='Rule Version']/../../../../../../../following-sibling::div[1]/child::div/child::table//td[@cellindex='sValue']";

	public String QA_Review_Table = "//table[@id='qareview_grid']//tr";

	public String QA_Review_Table_Item = "//table[@id='qareview_grid']//tr[sValue]//a";
	
	public String Editorial_Review_Table = "//table[@id='editorial_review_grid']//tr";
										
	public String Editorial_Review_Table_Item = "//table[@id='editorial_review_grid']//tr[sValue]//a";
	
	public String QA_Review_Completed = "//label[contains(text(),'QA Review Completed')]";

	public String Complete_QA_Review = "//label[contains(text(),'Complete QA Review')][@class='btn btn-primary ng-binding']";

	public String Complete_QA_Review_Sub = "//label[contains(text(),'Complete QA Review')][@class='btn btn-primary ng-scope']";
	
	public String Complete_QA_Review_Editorial = "//label[contains(text(),'Complete QA Review')]";
	
	public String Complete_Editorial_Review = "//label[contains(text(),'Complete Editorial Review')][@class='btn btn-primary ng-binding']";
	
	public String Editorial_Review_Complete="//label[contains(text(),'Editorial Review Completed')][@class='btn btn-primary ng-binding']";

	public String QAReview_Category = "(//input[@name='category'])[2]";

	public String Testing_Review_Table = "//table[@id='testing_review_grid']//tr";

	public String Testing_Review_Table_Item = "//table[@id='testing_review_grid']//tr[sValue]//a";

	public String Complete_Test_Review = "//label[contains(text(),'Complete Test Review')][@class='btn btn-primary ng-binding']";

	public String Msg_Complete_Decision = "//div[contains(text(),'Are you sure you want to complete decisions?')]";

	public String Select_CPM_Decision = "//select[@id='ddlMDDecision']/..//select[1]";

	public String Update_Rule = "//label[contains(text(),'Update Rule')]";

	public String Msg_Rule_Update = "//p[contains(text(),'Rule Updated Successfully.')]";

	public String FinalRule_Version = "//label[text()='Rule Version: '][last()]/parent::td/following-sibling::td/child::label[position()=last()]";

	public String SystemProposalsRowCount = "//table[@id='Data_Model_Decisions_grid']/descendant::tr/following-sibling::tr";

	public String TaskStatusAdmin = "(//table[@class='GEFT4QHBI3C'])[3]//tr[@class='GEFT4QHBK3C GEFT4QHBFN']//td[@cellindex='4']//div";

	public String MidRuleAdmin = "(//table[@class='GEFT4QHBI3C'])[3]//tr[@class='GEFT4QHBK3C GEFT4QHBFN']//td[@cellindex='1']//div";

	public String AdminGrid_Checkbox = "(//table[@class='GEFT4QHBI3C'])[3]//tr[@class='GEFT4QHBK3C GEFT4QHBFN']//td[@cellindex='0']//div";

	public String Generate_Summaries = "//label[contains(text(),'Generate Summaries')]";

	public String GenerateChangeLog = "//label[contains(text(),'Generate Change Log')]";
	
	public String System_Proposal_DOS = "//input[@id='sValue']";

	public String System_Proposal_DOS1 = "//input[@id='1_dos']";

	public String ViewAllTaskRows = "(//table[@class='GEFT4QHBI3C'])[2]/tbody[2]/tr";

	public String Save_Button = "//button[contains(text(),'Save')]";

	public String Continue_Button = "//button[contains(text(),'Continue')]";

	public String Ok_Button = "//button[contains(text(),'Ok')]";

	public String Save_CPM_System = "//label[text()='CPM System Proposals:']/..//div//label[contains(text(),'Save')]";

	public String Config = "//label[text()='Requires Presentation']/following-sibling::label[text()='Config']";

	public String Final_MD_Comments = "//span[text()='sValue']/ancestor::div[@class='panel-heading']/following::div[1]//textarea";

	public String Final_MD_Save = "//div[@class='col-md-offset-9']//label[text()='Save']";

	public String Manual_RMR_ID = "//label[text()='Manual RMR ID: ']/../a";

	public String Admin_Col_Status = "(//div[@class='GEFT4QHBBJC'])[3]//td[6]//div[@class='GEFT4QHBE3C']";

	public String ReturnRule = "//label[@class='btn btn-primary ng-binding ng-scope ng-pristine ng-valid' and contains(text(),'Return Rule')]";

	public String EditorialReturnSelect = "//select[@ng-options='task for task in possibleTasks']";

	public String EditorialReturnReason = "//textarea[@id='ruleReturnComments']";

	public String ReturnRuleResponse = "//label[contains(text(),'Return Rule Response')]";

	public String CPMResponse = "//textarea[@name='responseComment']";

	public String CPMDecision_Select = "//table[@id='cpmProposalGrid']//select[@name='cpmDecisionAction.decisionActionKey']";

	public String CPMPayerTreePlus = "(//div[@class='tree-wrap tree-wrap-ltr']//div)[1]";

	public String SystemProposalCPM = "//table[@id='cpmProposalGrid']//textarea[@name='cpmInterpComment.comments']";

	public String SystemProposalSave = "//div[@ng-show='hasSystemProposals']//label[text()='Save']";

	public String MyTasks = "//div[@class=' x-panel x-component x-panel-collapsed']//span[text()='My Tasks']";

	public String CreateNewRuleVersion = "//label[text()=' Create New Rule Version? ']/..//input[@type='radio' and @value='sValue']";

	public String RetireRuleAge = "//select[@ng-model='sValue']";

	public String QAReviewSegment = "//div[@id='jqgh_qareview_grid_reviewTypeDesc' and text()='Review Segment']";
	
	public String EditorialSegment = "//div[@id='jqgh_editorial_review_grid_reviewTypeDesc' and text()='Editorial Review Segment']";

	public String DecisionCapturePopUP = "//label[text()='sValue']/parent::div//input";

	public String MyTaskNotCollapsed = "//div[@class=' x-panel x-component x-panel-collapsed']";

	public String CellPopTextHeader = "(//span[text()='sValue'])[2]";

	public String DCBluckAssign="(//div[text()='Bulk Assign'])[2]";
	
	public String NewInstanceCreate="//label[text()='sValue']/parent::div//input";

	public String CellPopText = "(//span[text()='sValue'])[2]/parent::div/following-sibling::div/child::div[3]//div[@id='GridModalTextArea']";

	public String HighlightColor = "//span[@style='background-color: yellow;']";

	public String CloseCellPopup = "(//span[contains(text(),'sValue')])[last()]/preceding-sibling::button[text()='x']";

	public String UnSubscribedRulesRadioBtn = "//input[@type='radio' and @value='all']";

	public String AdminMDMidRule = "//div[@class='ui-grid-viewport ng-isolate-scope']/child::div/child::div/div/div[5]//descendant::div";

	public String AdminMDRuleVersion = "//div[@class='ui-grid-viewport ng-isolate-scope']/child::div/child::div/div/div[6]//descendant::div";

	public String AdminMDScrubRows = "//div[@class='ui-grid-viewport ng-isolate-scope']/child::div/child::div";

	public String ScrollToElement = "//span[text()='ReviewCPT   Group        Mapped CPT           From-To                         CAT          Override ']";

	public String Actions = "//div[@class='GEFT4QHBEKC']";
	
	public String DCSave ="((//div[@class='GEFT4QHBDVC x-toolbar x-toolbar-mark x-small-editor'])//div[text()='Save'])[3]";

	public String NavigationComponentAdminScrub = "//div[@class='x-panel-header']";

	public String SelectAllCheckBoxAdminMDScrub = "//span[text()='Review']/parent::div/parent::div/parent::div//input[@class='ngSelectionHeader ng-valid ng-scope ng-dirty ng-valid-parse ng-touched']";
	
	public String SelectAllCheckBoxUnscrubbed = "(//span[text()='Review']/parent::div/parent::div/parent::div//input)[position()=last()]";

	public String QAReassign = "//td[.='Re-Assign To']/../following-sibling::tr/child::td[3]//td/following::div//div[text()='sValue']";

	public String ReassignUseridChek = "(//table[@class='GEFT4QHBI3C'])[3]//div[@class='GEFT4QHBE3C' and text()='iht_ittest01']/parent::td[1]/../td[@cellindex='0']//div//div";

	public String ClaimTask = "(//div[text()='Complete Task'])[2]";

	public String DCCaptureCheckBox = "(//span[text()='Medical Policy'])[2]/.././.././preceding-sibling::td//div";

	public String ApplyAdminFilterValues = "(//table[@class='GEFT4QHBI3C'])[4]//div[text()='sValue']/../..//div//div";

	public String SaveReturnRuleResponse = "//button[@ng-click='saveReturnRuleResponse()']";
	
	public String ViewAllAdminScrubCheckBox="//div[text()='sValue']/parent::td/preceding-sibling::td[1]//div[text()='Admin PO Scrub Review']/parent::td/preceding-sibling::td[3]//div[text()='"+ProjectVariables.FinalMDInstance+"']/parent::td/preceding-sibling::td";

	public String NoDecision = "//label[contains(text(),'No Decision')]";
	
	public String ConfigSumTable ="//table[@id='Configuration_Summary_grid']//tr[@class='ui-widget-content jqgrow ui-row-ltr']";
	
	public String CompleteQAPostConfig ="//h4[text()='CPM Additional Configuration Summary']/../../../div[@class='col-md-12 ng-scope']//label[contains(text(),'Complete QA Review Post Configuration')]";
	
	public String AdditionalConfigQA = "//label[contains(text(),'Additional Config QA Completed')]";

	public String CompleteConfigReview="//label[contains(text(),'Complete Config Review')][@class='btn btn-primary ng-binding']";
	
	public String ReassignCPM="//div[contains(text(),'CPM Review Rule')]";
	
	public String EditNewRuleDesc = "//textarea[@ng-model='editables.newRuleDescription']";
	
	public String ChooseFile ="//div[@class='col-md-10 ng-scope']//form[@class='form-inline ng-pristine ng-valid']//input[@type='file']";
	
	public String NamedSetsData ="//a[contains(text(),'NAMEDSETS_DATA')]";
	
	public String BratTestGrid ="//input[@id='cb_brat_test_results_grid']";
	
	public String Save_Brat ="//label[@ng-click='bratTestResultsSave()' and text()='Save']";
	
	public String ResolvedRuleCharacterCount="(//label[text()='Resolved Rule Character Count:'])[1]/../..//input";
	
	public String EditDescriptioninEditorial="//label[text()='Edit sValue:']/../..//textarea";
	
	public String MarkUpinEditorial="//label[contains(text(),'sValue:')]/../..//del";
	
	public String UpdatedTextinEditorial="//label[contains(text(),'sValue:')]/../..//del/following-sibling::ins";
	
	public String EditorialPopYesBtn="//button[contains(text(),'Yes')]";
	
	public String SelectCPMReassign= "//div[text()='Select CPM for Reassignment :']/following-sibling::div";
	
	public String ReasonReassign="//div[text()='Reason for Reassignment :']/following-sibling::div/textarea";
	
	public String SelectCPMReassignUser = "//option[@label='sValue']";
	
	public String StartNewCode = "//div//input[@value='startNew']";	
	
	public String ManualPropTable = "//table[@id='Manual_Proposals_grid']//tr";
	
	public String RequirePresentCancel ="//button[@ng-click='saveRequirePresentation()']/following-sibling::button[text()='Cancel']";
	
	public String RequirePresentSave ="//button[@ng-click='saveRequirePresentation()' and text()='Save']";
	
	public String RequirePresentReviewPayer = "(//table[@id='requirePresentationGrid']//tr)[2]//td[3]";
	
	public String CPMPayerTable = "//table[@id='cpmProposalGrid_1_t']";
	
	public String CPMSystemPropsalSave ="//label[text()='CPM System Proposals:']/following-sibling::div//label[2][text()='Save']";
	
	public String CPMReviewPayerWarning ="//span[contains(text(),'WARNING!! Requires Presentation Decision Exists for Payers:')]";
	
	public String CPMDecisionList = "//select[@id='1_cpmDecisionAction.decisionActionKey']//option[text()='sValue']";
	
	public String CPMPayerLevel = "//select[@id='1_payerLevel']//option[text()='sValue']";
	
	public String CPMDecisionsLists= "(//table[@id='cpmProposalGrid'])//tr[2]//td[5]//select//option[text()='sValue']";
	
	public String CPMDecisionsLists2= "(//td[@aria-describedby='cpmProposalGrid_1_t_decisionAction.decisionActionKey'])[1]//select//option[text()='sValue']";
	
	public String AEDropDown= "(//td[@aria-describedby='cpmProposalGrid_1_t_decisionAction.decisionActionKey'])[1]//select//option[text()='sValue']";
	
	public String DeactivateErrorMsg = "//p[contains(text(),'Library rule has been deactivated.')]";
	
	public String NewRuleVersion = "//div[@ng-show='isNewMidRuleVersionCreated;']//label[2]";
	
	public String RuleProposal ="//label[text()='Enter rule for proposal assessment:']/..//div[1]//div//div//input";
			
	//public String RationalComments = "(//textarea[text()='"+ProjectVariables.SystemProposalComments+"'])[1])";
	
	public String ObsoleteYesBtn = "//div[@class='GEFT4QHBGQ' and text()='Yes']";
	
	public String ReturnRequirePresentRuleChk="//div[text()='Select rule(s) to return for CPM Decision Review:']/..//div//div[text()='sValue']/../..//div//div";
	
	public String SelectRule= "//div[text()='sValue']/..//..//div//div";
	
	public String NewMidruleversion="//label[text()='New Rule Version: ']//..//label[2]"; 
	
	

//*****************************************************String Xpath's Replacing sValue********************************************************
	
	public String ButtonTag = "//button[text()='sValue']";

	public String SpanTag = "//span[text()='sValue']";

	public String AnchorTag = "//a[text()='sValue']";

	public String LabelTag = "//label[text()='sValue']";

	public String DivTag = "(//div[text()='sValue'])[1]";

	public String pTag = "//p[text()='sValue']";
	
	public String pTagContains = "//p[contains(text(),'sValue')]";

	public String TabheadingTag = "//tab-heading[text()='sValue']";

	public String h3Tag = "//h3[text()='sValue']";

	public String h4Tag = "//h4[text()='sValue']";

	public String tdTag = "//td[text()='sValue']";

	public String AdminInstanceSamSim="//tr[(td[1]='sValue') and (td[7]='In Same/Sim Analysis')]//div[@class='GEFT4QHBE3C iht-HyperLinkText']";

	public String RequesImpactAnalysis="//div[text()='Request Impact Analysis'])[3]";

	public String DescriptionTxt="//label[text()='Description:']/parent::div//textarea";

	public String GroupTaskTab="(//span[text()='Group Tasks'])[2]";

	public String InstanceCount="//div[text()='sValue']/parent::td/preceding-sibling::td[2]";
	
	public String IULink="//a[text()='Interpretive Update Instances']";
	
	public String SystemDecisionSel="//select[@id='1_decisionAction.decisionActionKey']";
	
	public String NoChangeRequired="//label[contains(text(),'No Change Required')]";
	
	public String NoChangeComment="//textarea[@name='noChangeComment']";
	
	public String ConfigComplete ="//label[@class='btn btn-primary ng-binding ng-scope ng-pristine ng-valid' and contains(text(),'Config Complete')]";
	
	public String TestingCompleteComments="//textarea[@id='testingComments']";
	
	public String SelectGridRuleChkbox="//div[text()='sValue']/..//..//td//div[@class='GEFT4QHBE3C']//div[@class='x-grid-row-checker']";
	
	public String AEAddButton = "(//div[text()='Add'])[3]";
	
	public String AESaveButton = "(//div[text()='Save'])[5]";

	public String RunTypeSearchBox="(//input[@class='ui-grid-filter-input ng-pristine ng-valid'])[1]";

	public String RunTypeValue="(//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='Initial Run'])[1]";

	public String SummaryGroup1="//div[text()='Summary Group1']/../../../../../following-sibling::td[2]//label[text()='Task']/..//input";
	
	public String SummaryGroup2="//div[text()='Summary Group2']/../../../../../following-sibling::td[2]//label[text()='Status']/..//input";
	
	public String SummaryGroup3="//div[text()='Summary Group3']/../../../../../following-sibling::td[2]//label[text()='Assignee']/..//input";
	
	public String RuleReqMsg="//div[contains(text(),'Rule Review Request was successful for the rule: ')]";
	
	@FindBy(xpath = "//a[text()='BW And/BWO or Config Logic']")
	public WebElementFacade BWOConfigLink;
	
	public String PosRollBtn="//span[@id='posFlag1']";
	
	
	
	public String VersionInfo = "//label[contains(text(),'Version:')]";
	
	public String VersionLink = "//a[text()='Version Info']";
	
	//public String CancelRetireRule ="//label[contains(text(),'Cancel Retire Rule')]";
	
	@FindBy(xpath="//label[contains(text(),'Cancel Retire Rule')]")
	public WebElementFacade CancelRetireRule;
	

	public String FilterValuesInDropDown="//div[@class='GEFT4QHBKR GEFT4QHBPM GEFT4QHBD-C']/parent::td/../../../../../../../../..//div[@class='GEFT4QHBE3C']/parent::td[@cellindex='1']";
	
	public String CloseIconFilterDropDown="//div[contains(@class,'GEFT4QHBKR GEFT4QHBPM GEFT4QHBD-C')]";
	

	//public String NewMidruleversion="//label[text()='New Rule Version: ']//..//label[2]";
	
	
	
	
	

//*****************************************************LOGOUT FUNCTIONS********************************************************
	
	public boolean fn_JBPM_Sign_Out() {

		IULoginPage oIULoginPage = this.switchToPage(IULoginPage.class);
		
		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);
		
		oSeleniumUtils.Click_given_Locator(StringUtils.replace(ButtonTag, "sValue", "Sign Out"));
		
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		
		return oIULoginPage.UserName_Txt.withTimeoutOf(ProjectVariables.MID_TIME_OUT,TimeUnit.SECONDS).isDisplayed();
		
	}

//*****************************************************REUSABLES FUNCTIONS********************************************************
	
	public void waitUntil_Loading_Dailog_Disappears(WebElementFacade element) {

		do {
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		} while (element.isVisible());
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

	}

	public void wait_Untill_ElementExists(String xpath) {
		//$(xpath).withTimeoutOf(ProjectVariables.Loading_Time_Out,ChronoUnit.SECONDS).waitUntilVisible();
		$(xpath).withTimeoutOf(ProjectVariables.Loading_Time_Out,TimeUnit.SECONDS).waitUntilVisible();


	}

	public void wait_Max_Untill_ElementExists(String xpath, int MinutesInput) {
		//$(xpath).withTimeoutOf(MinutesInput, ChronoUnit.MINUTES).waitUntilVisible();
		$(xpath).withTimeoutOf(MinutesInput, TimeUnit.MINUTES).waitUntilVisible();

	}

	public void Click_on_Editorial() {

		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);
		
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		
		// Switching to frame and click on Editorials
		oSeleniumUtils.SwitchToFrame(frame);
		
		oSeleniumUtils.Click_given_Locator(StringUtil.replace(Editorials, "sValue", "Editorials"));
		
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		
		// Switch to new windoW
		SeleniumUtils.switchWindowUsingWindowCount(5, 2, getDriver());
		
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

	}

	public void click_On(String arg1) {

		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);
		oSeleniumUtils.Click_given_Locator((StringUtil.replace(SpanTag, "sValue", arg1)));
	}

	public void go_To_Rule(String sRuleReviewID) {

		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);
		oSeleniumUtils.Enter_given_Text_Element(Go_to_Rule, sRuleReviewID);
		oSeleniumUtils.Click_given_Locator(Go_Btn);
		waitUntil_Loading_Dailog_Disappears(Loading);
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

	}

	public void closeAllTabs() {

		getDriver().switchTo().defaultContent();

		List<WebElement> iCloseTabs = getDriver().findElements(By.xpath(closeTabs));

		for (int i = 1; i < iCloseTabs.size(); i++) {

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			iCloseTabs.get(i).click();

		}

	}

	public String get_Column_Value(String sCloumnName) {

		switch (sCloumnName) {
		case "Status":
			return oSeleniumUtils.get_TextFrom_Locator(StringUtil.replace(Column_Status, "sValue", "5"));

		case "Task":
			return oSeleniumUtils.get_TextFrom_Locator(StringUtil.replace(Column_Status, "sValue", "4"));

		case "Assignee":
			return oSeleniumUtils.get_TextFrom_Locator(StringUtil.replace(Assignee_Status, "sValue", "7"));

		}

		return sCloumnName;

	}

	public boolean assignDifferentUserToPayer(String sPayerSeq, String sPayer, String sUser) {
		
		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);
		if ((oSeleniumUtils.is_WebElement_Present(StringUtil.replace(DivTag, "sValue", "OK")))){
			oSeleniumUtils.Click_given_Locator(StringUtil.replace(DivTag, "sValue", "OK"));
		}
		
		System.out.println("Payer is: " +sPayer);
		
		List<WebElement> Payerslist = getDriver().findElements(By.xpath(("(//div[@class='GEFT4QHBBJC'])[3]//td[4]//div[@class='GEFT4QHBE3C']")));
		for (int i = 0; i < Payerslist.size(); i++) {
									
			if (Payerslist.get(i).getText().trim().equals((sPayer.trim()))){
				
				System.out.println("Rule version index 0:  "+Payerslist.get(i).getText().toString());
				//click on CPM
				i=i+1;
				System.out.println("CPM version index 0:  "+"((//div[@class='GEFT4QHBBJC'])[3]//td[7]//div[@class='GEFT4QHBE3C'])["+i+"]");
				oSeleniumUtils.Click_given_Locator(("((//div[@class='GEFT4QHBBJC'])[3]//td[7]//div[@class='GEFT4QHBE3C'])["+i+"]")); 
				oSeleniumUtils.Enter_given_Text_Element("//div[@class='GEFT4QHBD2C']//input", sUser);
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
				oSeleniumUtils.Click_given_Locator(("((//div[@class='GEFT4QHBBJC'])[3]//td[3]//div[@class='GEFT4QHBE3C'])["+i+"]")); 
										
				break;
			
			}
		}
		return true;
	}
	
	
	public boolean checkObsoletePayer(String sPayerSeq, String sPayer) {
		
		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);
		if ((oSeleniumUtils.is_WebElement_Present(StringUtil.replace(DivTag, "sValue", "OK")))){
			oSeleniumUtils.Click_given_Locator(StringUtil.replace(DivTag, "sValue", "OK"));
		}
		
		System.out.println("Payer is: " +sPayer);
		
		List<WebElement> Payerslist = getDriver().findElements(By.xpath(("(//div[@class='GEFT4QHBBJC'])[3]//td[4]//div[@class='GEFT4QHBE3C']")));
		for (int i = 0; i < Payerslist.size(); i++) {
									
			if (Payerslist.get(i).getText().trim().equals((sPayer.trim()))){
				
				System.out.println("Payer Name from x Path:  "+Payerslist.get(i).getText().toString());
				//click on CPM
				i=i+1;
				System.out.println("CPM X Path :  "+"((//div[@class='GEFT4QHBBJC'])[3]//td[7]//div[@class='GEFT4QHBE3C'])["+i+"]");
				System.out.println("Obsolete X Path :  "+"((//div[@class='GEFT4QHBBJC'])[3]//td[9]//div//input)["+i+"]");
				oSeleniumUtils.Click_given_Locator("((//div[@class='GEFT4QHBBJC'])[3]//td[9]//div//input)["+i+"]"); 
				
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
				
				oSeleniumUtils.Click_given_Locator(ObsoleteYesBtn);
													
				break;
			
			}
		}
		return true;
	}

	public boolean userNavigateToAdministrationTab() {

		waitUntil_Loading_Dailog_Disappears(Loading);

		closeAllTabs();

		Assert.assertTrue("Administration Tab should be displayed",oSeleniumUtils.is_WebElement_Displayed(StringUtil.replace(SpanTag, "sValue", "Administration")));

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(SpanTag, "sValue", "Administration"));

		Assert.assertTrue("Administration Tab should be displayed",oSeleniumUtils.is_WebElement_Displayed(StringUtil.replace(SpanTag, "sValue", "Administration")));

		return oSeleniumUtils.is_WebElement_Displayed(StringUtil.replace(SpanTag, "sValue", "Administration"));

	}

	public String GetDynamicXPath(String sXpath, int sVal) {

		String sFormattedXpath = null;

		switch (sXpath.toUpperCase()) {

		case "ASSIGNMENT PAYER":
			sFormattedXpath = "((//div[@class='GEFT4QHBKO'])[2]//table[@class='GEFT4QHBI3C']//tr[@class='GEFT4QHBK3C GEFT4QHBFN']//td[@cellindex=1])["+ sVal + "]";
			break;

		case "RULE VERSION":
			sFormattedXpath = "(//table[@class = 'GEFT4QHBI3C'])[last()]/tbody[2]/tr[" + sVal + "]/td[2]";
			break;

		case "RULE STATUS":
			sFormattedXpath = "(//table[@class = 'GEFT4QHBI3C'])[last()]/tbody[2]/tr[" + sVal + "]/td[6]";
			break;

		case "RULE TASK":
			sFormattedXpath = "(//table[@class = 'GEFT4QHBI3C'])[last()]/tbody[2]/tr[" + sVal + "]/td[5]";
			break;

		case "RULE PAYERS":
			sFormattedXpath = "(//table[@class = 'GEFT4QHBI3C'])[last()]/tbody[2]/tr[" + sVal + "]/td[15]";
			break;

		case "CPM_PAYERS_DECESION":
			sFormattedXpath = "(//select[@name='agree10'])[" + sVal + "]";
			break;

		case "CPM_DECESION_COMMENTS":
			sFormattedXpath = "(//textarea[@name='cpmConfigComments'])[" + sVal + "]";
			break;
			
		case "RULEREVIEW COLVALUE":
			sFormattedXpath = "(//div[@class='GEFT4QHBBJC'])[3]//td[" + sVal + "]//div[@class='GEFT4QHBE3C']";
			break;

		case "RULEREVIEW ROWTASKSTATUS":
			sFormattedXpath = "(//div[@class='GEFT4QHBBJC'])[3]//tr[" + sVal + "]//td[5]//div[@class='GEFT4QHBE3C']";
			break;
			
		case "RULEREVIEW ROWSTATSTATUS":
			sFormattedXpath = "(//div[@class='GEFT4QHBBJC'])[3]//tr[" + sVal + "]//td[6]//div[@class='GEFT4QHBE3C']";
			break;
			
		case "RULEREVIEW ASSIGNEESTATUS":
			sFormattedXpath = "(//div[@class='GEFT4QHBBJC'])[3]//tr[" + sVal + "]//td[8]//div[@class='GEFT4QHBE3C']";
			break;
			
		case "CONFIGSUMMARY VALUES":
			sFormattedXpath = "//table[@id='Configuration_Summary_grid']//tr[3]//td[" + sVal + "]";
			break;
			
		case "RETURN REVIEW COMMENTS":
			sFormattedXpath = "//table[@id='returnReViewCommentsGrid']//tr[2]//td[" + sVal + "]";
			break;
			
		case "TESTINGREVIEW TABLEITEM":
			sFormattedXpath = "//table[@id='testing_review_grid']//tr[" + sVal + "]//a";
			break;
			
		case "CPM SYSTEMPROPOSAL":
			sFormattedXpath="(//table[@id='cpmProposalGrid'])//tr[2]//td[" + sVal + "]";
		break;
		
		case "CPM SYSTEMPROPOSAL2":
			sFormattedXpath="(//td[@aria-describedby='cpmProposalGrid_1_t_decisionAction.decisionActionKey'])[" + sVal + "]//select//option[text()='sValue']";
		break;
		
		case "SELECT AE VALUES":
			sFormattedXpath="//td[text()='Resource']/../following-sibling::tr/td[" + sVal + "]//input";
		break;
		
		case "CPM PAYERSPEC COMMENTS":
			sFormattedXpath="(//textarea[@name='interpComment.comments'])[" + sVal + "]";
		break;
		
		case "BW RADIO BUTTON":
			sFormattedXpath="(//label[@class='radio-inline']/input)[" + sVal + "]";
		break;
		
		case "SYSTEM PROPOSAL VAL":
			sFormattedXpath="(//select[@id='1_decisionAction.decisionActionKey']//option)[" + sVal + "]";
		break;
		
		case "MD ROLLDECESION":
			sFormattedXpath="(//table[@id='s_Data_Model_Decisions_grid_1']//tr//td[2]//select)[" + sVal + "]//option[text()='sValue']";
		break;
		
		
		
						
		}

		return sFormattedXpath;
	}

	public String GetDynamicXPathForAdminMDRuleVersion(Object sVal, Object sVal2) {

		String sAdminMDXpath = "//div[@class='ui-grid-viewport ng-isolate-scope']//div[text()='" + sVal+ "']/parent::div/following-sibling::div//div[text()='" + sVal2 + "']";

		return sAdminMDXpath;
	}
	
	public String getDynamicXpathCheckBoxInGroupTask(String sValue, int iValue){
		
		String sGroupTaskCheckBox="(//div[text()='"+sValue+"'])["+iValue+"]/parent::td/preceding-sibling::td[2]";
		
		return sGroupTaskCheckBox;
		
	}

	public void scrollToColumn(String sTag, String[] sColumnList) {
		
		for (int i = 0; i < sColumnList.length; i++) {
			
			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			
	        WebElement oColoumn=getDriver().findElement(By.xpath("//"+sTag+"[text()='"+sColumnList[i]+"']"));
    		
    		if (!oColoumn.isDisplayed()) {
    		
    		WebElement horizontal_scroll = getDriver().findElement(By.xpath(StringUtils.replace(SpanTag, "sValue", sColumnList[i])));
    		
    		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", horizontal_scroll);
    		
    		}
		}

	}

	public void scrollToMidRuleColumn(String sTag, String[] sColumnList) {
		
	for (int i = 0; i < sColumnList.length; i++) {
			
	        WebElement oColoumn=getDriver().findElement(By.xpath("//+"+sTag+"+[text()='"+sColumnList[i]+"']"));
    		
    		if (!oColoumn.isDisplayed()) {
			
    		WebElement horizontal_scroll = getDriver().findElement(By.xpath(StringUtils.replace(SpanTag, "sValue", sColumnList[i])));
    		
    		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", horizontal_scroll);
    		
    		}
		}

	}
	
	public String getDynamicQuery(String sColumnName, String iMidRule, String iVersion) {

		String sFormattedQuery = null;

		switch (sColumnName) {

		case "Sub Rule Rationale":
			sFormattedQuery = "select SUB_RULE_RATIONALE from RULES.SUB_RULES where mid_rule_key ='" + iMidRule+ "' and rule_version= '" + iVersion + "'";
			break;
		case "Sub Rule Description - Resolved":
			sFormattedQuery = "select SUB_RULE_DESC from RULES.SUB_RULES where mid_rule_key ='" + iMidRule+ "' and rule_version= '" + iVersion + "'";
			break;
		case "Sub Rule Description - Unresolved":
			sFormattedQuery = "select SUB_RULE_DESC from RULES.SUB_RULES where mid_rule_key ='" + iMidRule+ "' and rule_version= '" + iVersion + "'";
			break;
		case "Sub Rule Script":
			sFormattedQuery = "select SUB_RULE_SCRIPT from RULES.SUB_RULES where mid_rule_key ='" + iMidRule+ "' and rule_version= '" + iVersion + "'";
			break;
		case "Sub Rule Notes":
			sFormattedQuery = "select SUB_RULE_NOTES from RULES.SUB_RULES where mid_rule_key ='" + iMidRule+ "' and rule_version= '" + iVersion + "'";
			break;
			
		case "EDITORIAL TABS":
			sFormattedQuery = "//textarea[@ng-model=" + iMidRule + "]";
			break;
		}

		return sFormattedQuery;
	}

	public String getDynamicXPathAdminMD(String sXpath, int sVal) {

		String sFormattedXpath = null;

		switch (sXpath) {

		case "MidRule":
			sFormattedXpath = "//div[@class='ui-grid-viewport ng-isolate-scope']/child::div/child::div[" + sVal+ "]/div/div[5]//descendant::div";
			break;
		case "RuleVersion":
			sFormattedXpath = "//div[@class='ui-grid-viewport ng-isolate-scope']/child::div/child::div[" + sVal+ "]/div/div[6]//descendant::div";
			break;
		case "Sub Rule Description - Resolved":
			sFormattedXpath = "(//div[@class='ngCellText ui-grid-cell-contents ng-binding ng-scope'] [@ng-bind='row.entity.subRuleDescResolved'])["+ sVal + "]";
			break;
		case "Sub Rule Description - Unresolved":
			sFormattedXpath = "(//div[@class='ngCellText ui-grid-cell-contents ng-binding ng-scope'] [@ng-bind='row.entity.subRuleDescUnresolved'])["+ sVal + "]";
			break;
		case "Sub Rule Rationale":
			sFormattedXpath = "(//div[@class='ngCellText ui-grid-cell-contents ng-binding ng-scope'] [@ng-bind='row.entity.subRuleRationale'])["+ sVal + "]";
			break;
		case "Sub Rule Notes":
			sFormattedXpath = "(//div[@class='ngCellText ui-grid-cell-contents ng-binding ng-scope'] [@ng-bind='row.entity.subRuleNotes'])["+ sVal + "]";
			break;
		case "Sub Rule Script":
			sFormattedXpath = "(//div[@class='ngCellText ui-grid-cell-contents ng-binding ng-scope'] [@ng-bind='row.entity.subRuleScript'])["+ sVal + "]";
			break;
			

		}

		return sFormattedXpath;
	}
	
	public String GetDynamicXPathWithRowCol(String sXpath, int sCol, int sRow) {

		String sFormattedXpath = null;

		switch (sXpath.toUpperCase()) {

		case "CONFIGSUMMARY VALUES":
			
			sFormattedXpath = "//table[@id='Configuration_Summary_grid']//tr[" + sCol + "]//td[" + sRow + "]";
			
			break;
			
		case "MANUALPROP FIELDS":
			
			sFormattedXpath = "//table[@id='Manual_Proposals_grid']//tr[" + sCol + "]//td[" + sRow + "]//select";
			
			break;
		
		}

		return sFormattedXpath;
	}
	
	public String GetDynamicXPathWithString(String sColumnName, String sVal, String sVal2) {

		String sFormattedXPath = null;

		switch (sColumnName) {
				
		case "EDITORIAL TABS":
			sFormattedXPath = "//textarea[@ng-model='" + sVal+ "']";
			break;
			
		case "CONTAINS LABEL":
			sFormattedXPath = "//label[contains(text(),'" + sVal+ "')]";
			break;
			
		case "CONTAINS BUTTON":
			sFormattedXPath = "//button[contains(text(),'" + sVal+ "')]";
			break;
			
		case "GROUPTASK TASKTYPE":
			sFormattedXPath = "//div[text()='" + sVal+ "']/../..//td//div[text()='" + sVal2+ "']";
			break;

		case "EditorialActions":
			sFormattedXPath="//label[text()='Edit "+sVal+":']/..//label[text()='"+sVal2+"']";

		}

		return sFormattedXPath;
	}
	

	public boolean rationalComments(String loSystemPropComments) throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		
		oSeleniumUtils.SwitchToFrame(frame);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(TabheadingTag, "sValue", "Decisions"));

		
		String sRationalComments= RationalComments.getText();
		
		System.out.println(sRationalComments);

		boolean bln = sRationalComments.trim().equalsIgnoreCase(loSystemPropComments);
		
		getDriver().switchTo().defaultContent();

		return bln;
	}
	
	

	public void GetVersionInfo() {
		
		oSeleniumUtils.Click_given_Locator(VersionLink);
				
		String sVersionInfo = getDriver().findElement(By.xpath(VersionInfo)).getText();
		
		System.out.println(sVersionInfo);
		
		Serenity.setSessionVariable("IUVersion").to(sVersionInfo);
			
		
	}
	
	public boolean mouseOverDirectRelease(){

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		WebElement e = getDriver().findElement(By.xpath("//a[text()='Direct Release']"));
		(new Actions(getDriver())).moveToElement(e).perform();
		return true;
}

public String StatusBtnDirectRelease(){
	String btnStatus=null;
	if(getDriver().findElements(By.xpath("//a[text()='Direct Release' and @disabled='disabled' ]")).size()>0){
		btnStatus="disabled";
	}else{
		btnStatus="enabled";
	}
		
	return btnStatus;
}
	
	
	
	
}
