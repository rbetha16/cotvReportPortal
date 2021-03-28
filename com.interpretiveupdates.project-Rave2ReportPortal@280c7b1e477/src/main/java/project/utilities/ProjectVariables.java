package project.utilities;

public class ProjectVariables {

	public String URL = "https://qajbpm.ihealthtechnologies.com/jbpm/#LogInPlace:login";

	public static String USER_NAME = "iht_ittest01";

	public static String PASSWORD = "SWhlYWx0aDEyMw==";
	
	public static String DB_USERNAME = "APP_MDM";

	public static String DB_PASSWORD = "APP_MDM";

	public static String DB_CONNECTION_URL = "jdbc:Oracle:thin:@vpmtst1.ihtech.com:1521/VPMTST1.iht.com";

	public static String DB_DRIVER_NAME = "oracle.jdbc.OracleDriver";

	// BROWSER SYNC TIME VARIABLES
	
	public static int Loading_Time_Out = 300000;
	
	public static int MIN_THREAD_WAIT = 2000;
	
	public static int MAX_TIME_OUT = 20000;

	public static int MID_TIME_OUT = 1000;
//	public static int MID_TIME_OUT = 10000;
	
	public static int MID_SLEEP = 7000;

	public static int MIN_TIME_OUT = 3000;

	public static int HIGHLIGHT_COUNT = 5;
	
	public static int SECONDS_MAX_COUNT = 120;
	
	public static int SECONDS_MAX_SLEEP = 240;
	
	public static int MIN_SLEEP=10000;
	
	public static String sPRODUCTION_URL = "https://prodpolicy.ihtech.com/jbpm/#LogInPlace:login";
	
	public static String sQA_URL = "https://qapolicy.cotiviti.com/jbpm/#LogInPlace:login";
	  
    public static String PROD_USER_NAME = "tkumar";
	
	public static String PROD_PASSWORD = "Q290dkAzNzkx";
	
	public static String Editorial_MSG_NC_Required="The No Change Required action loses all Editorial changes. Are you sure you want to continue?";
	
	public static String Editorial_MSG_Editorial_Saved=" Successfully saved editorial status:No Change Required";
	
	public static String Editorial_MSG_Editorial_Saved_Prilim=" Successfully saved editorial status:No Change Recommended";
	
	public static String StartReview_PopUp_Msg="Please confirm you wish to start Final PO Review.";
	
	public static String Generate_Summaries_Pop_Msg="Success";
	
	public static String ManualProposalsComments="Testing Rationale commnets";

	public static String ManualProposalsDailogMsg=" Manual Proposals saved successfully.";

	public static String SystemProposalComments="Automation testing";
	
	public static String Message_Saved=" Successfully saved.";
	
//	public static String FinalMDInstance= "CPTPOAutoIV618";
	public static String FinalMDInstance= "TestAuto";
	
//	public static String AEPrelimInstance= "CPTAutoIV501";
	public static String AEPrelimInstance= "CPTG0269Instance";
	

	public static String PrelimMDInstance="CPTPOAutoIV7";
	
	public static String AdminScrubInstance="CPTPOAutoIV990";
	
	public static String Review_Success=" Review completed successfully.";
	
	public static String Msg_CPM_Sucess=" CPM Decisions completed successfully";
	
	public static String Msg_CPM_Summaries=" Summaries generated successfully";

	public static String SystemProposalDOS="12/31/2019";

	public static String AdminScrubQuery="INSERT INTO IRDM.CPT_UPDATES (CPT_UPDATE_KEY,   CPT_CODE,   DESCRIPTION,  OLD_DESCRIPTION,  UPDATE_GROUP_KEY,     UPDATE_INSTANCE_KEY,  RULE_IMPACT_10,  RESEQ_10)  VALUES ( (SELECT MAX (CPT_UPDATE_KEY) + 1   FROM IRDM.CPT_UPDATES),  'G0269',  'Insertion of anterior segment aqueous drainage device, without extraocular reservoir; external approach', '', '2',   (SELECT UPDATE_INSTANCE_KEY    FROM IRDM.UPDATE_INSTANCES   WHERE update_instance_name   = 'sValue' ), -1, 0 )";

	public static int iRange=5000;

	public static String PreliminaryReview="N/A";	

	public static String PreliminaryPeerReview="N/A";
	
	public static String FinalPeerReview="N/A";	
	
	public static String Editorial="EditorialPool";	
	
	public static String QA="QAPool";	
	
	public static String Configuration="ConfigPool";	
	
	public static String Testing="TestingPool";	
	
	public static String ReturnRuleComments="testing";
	
	public static String TestComments="testing";

	public static String LibCustomPRM="RGUA-111820034118";
//	RGUA-092420080003
//	RGUA-092520101219

	public static String UpdateType="CPT/HCPCS";
	
	public static String SystemDecesionList="Select ...;Modify;No Action;Remove;No Decision";
	
	public static String ConfigSummaryComments= "Autotest Config Comments";
	
	public static String ReturnComments = "Rule Return Comments";
	
	public static String EditorialChangesDescripiton = "Duplicate Logic";
	
	public static String EditorialChangesNotes = "Face-to-face services do not include procedures that can be performed by a non-physician without personal supervision by a physician, so the Billed With code list excludes codes that have global or technical component with PC/TC Indicator of 5 or 7, or a Physician Supervision";
	
	public static String EditorialChangesScript = "The billed new patient Evaluation and Management service, CPT, was denied because the patient has received face-to-face services";
	
	public static String EditorialChangesRationale = "According to our policy, which is based on the AMA CPT Manual and CMS Policy, a new patient is one who has not received any professional services from the physician";
	
	public static String EditorialChangesReference = "AMA CPT Manual, HCPCS Level II Manual";

	public static String AssignmentExceptionData="iht_ittest01#Preliminary PO Review#Final PO Review#iht_ittest04#Multiple Procedure Reduction for Cardiovascular Services Policy#Multiple Procedure Reduction for Cardiovascular Services Overview#This topic is informational only for Multiple Procedure Reduction for Cardiovascular Services Overview.#Custom#"
			+ "iht_ittest01#Preliminary PO Review#Final PO Review#iht_ittest04#Multiple Procedure Reduction for Cardiovascular Services Policy#Multiple Procedure Reduction for Cardiovascular Services Overview#This topic is informational only for Multiple Procedure Reduction for Cardiovascular Services Overview.#Custom#"
			 + "iht_ittest01#Preliminary PO Review#Final PO Review#iht_ittest04#Multiple Procedure Reduction for Cardiovascular Services Policy#Multiple Procedure Reduction for Cardiovascular Services Overview#This topic is informational only for Multiple Procedure Reduction for Cardiovascular Services Overview.#Custom#";
			
	public static String sPrelimMDWarningEditorialNotCompleted="Editorials have not been completed during the PO Review and will be reviewed by the Editorial team. ";				
	
	public static String loMDTestComments = "Test PO Automation Comments";

	public static String sTestDataFilePath = "src\\test\\resources\\TestFiles\\AssignmentExceptionsTestData.xlsx";

	public static String Decision="Modify";

	public static String[] ColumnList={ "Group", "From-To", "Override", "Sim Mappings",
			"Sub Rule Description - Resolved", "Sub Rule Description - Resolved",
			"Sub Rule Description - Unresolved", "Sub Rule Notes", "Sub Rule Script",
			"Sub Rule Rationale" };

	public static String sColumns="ReviewCPT   Group        Mapped CPT           From-To                         CAT          Override ";

	public static String[] HiglightedColumns={ "POS", "DOSFrom_Summaries", "DOSTo_Summaries", "ICR_Summaries", "SameCalYear_Summaries","DaysLo_Summaries", "DaysHigh_Summaries" };

	public static String CPUSER_NAME = "iht_ittest09";

	public static String CPPASSWORD = "SWhlYWx0aDEyMw==";

//**********************************************************************************************************************
	
	public static String CPQAURL="https://qapolicy.cotiviti.com/IppApp/index";
	
	public static String ClaimType;

	public static String State;

	public static String Deletions="0 Deletions.";

	public static String TargetTablepopup="File is being loaded into Target table";

	public static String deltaStaus="Delta Generated";

	public static String TargetStaus="Table Loaded";

	public static String NewStateMedicaid="New State Medicaid Source";

	public static String States="AL,AK,WK,AS,AZ,AR,AE,AA,CA,CO,CT,DE,DC,EM,FM,FL,GA,GU,HI,ID,IL,IN,IA,EK,KS,KY,LA,ME,MH,MD,MA,FE,MI,MN,MS,MO,MT,NE,NV,NH,NJ,NM,NY,NC,ND,MP,OH,OK,OR,PW,PA,PR,RI,SC,SD,SN,TN,TX,UT,VT,VI,VA,WA,WM,WV,WI,WY";

	public static String Professional="Professional";

	public static String EandM_Bilateral_message="Select values for E&M and Bilateral Adjustments";
	
	public static String Bilateral_message="Select a value for Bilateral Adjustments";

	public static String Provider="Provider";
	
	public static String MOD_link_5_message="Payer must be configured for Mod_Link_5 rules for accurate adjudication on CMS values";
	
	public static String MOD_link_7_message="Payer must be configured for Mod_Link_7 rules for accurate adjudication of Bilateral codes.";

	public static String Client="Aetna";

	public static String UnMappedtext="0";
	
	public static String UnMappedtext_DMU="239-1";

	public static String TableID_DivCount;

	public static String MUV_Rowvalue="11";
	
	public static String Dosfrom_Rowvalue="12";
	
	public static String DosTo_Rowvalue="13";

	public static String ErrorMessage_in_mapping="Policy set configuration changes were not saved due to the unhandled exception. Please contact IT support team.";
	
	public static String DateBand_Error_msg="Date band error : DOS To should be greater than DOS From date.";
	
	public static String SouceConfigurartionValue="190 - CMS Medicare Professional";
	
    public static String CMUSourceFilePath=".\\src\\test\\resources\\SourceFile\\CMUSourceFile.xlsx";
	
	public static String CMUSourceFilePath_with_4CPTCodes=".\\src\\test\\resources\\SourceFile\\CMUSourceFileWith4CPTCodes.xls";
	
	public static String UploadSourceFile="Upload Client Max Unit Source file.";

	public static String UploadStateMedicaidSourceFile="Upload State Medicaid Source file.";
	
	public static String DeltaPopup="File is being processed for Delta";

	public static String Additions="6 Additions, Please select the CPT code row(s) you do not want to add and click Save.";

	public static String Additionsfor4cptcodes="4 Additions, Please select the CPT code row(s) you do not want to add and click Save.";
	
	public static String TableLoadStatus="Table Not Loaded";

	public static String LastCPTCodefor_191_Source="V2781";

	public static String LastCPTCodefor_51_Source="V2790";

	public static String LastCPTCodefor_190_Source="V5290";

	public static String DMUIDColnum="4";
	
	public static String Changes="0 Changes.";
	
	public static String CPMManualProposalComments= "CPMManualProposalComments";

	public static String FinalMDInstanceSubsequent="CPTAutoIV671";
	

}
