package project.feature.steps.definitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;



import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import net.thucydides.core.steps.ScenarioSteps;
import project.pageobjects.CPHomePage;
import project.utilities.GenericUtils;
import project.utilities.ProjectVariables;
import project.utilities.SeleniumUtils;

public class ClientProfileStepDef extends ScenarioSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CPHomePage oCPHomePage;
	
	SeleniumUtils oSeleniumUtils;
	GenericUtils oGenericUtils;
	
	ArrayList<String> sArrPayers=Serenity.sessionVariableCalled("PayerShots");
	
//	String str="EHHMO;GHIPP;GHIQC;HIPNY";
//	
//	List<String> sArrPayers=Arrays.asList(str.split(";"));
	
	//org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ClientProfileStepDef.class);
	
	@Step
	public void Login_to_ClientProfile_application(String URL) throws Exception {
		oCPHomePage.Login_to_the_ClientProfile_application(URL);
		
		/*sArrPayers.add("DHPMP");
		sArrPayers.add("DHPWI");*/
		
		
		 
	}
	
	@Step
	public void User_should_see_the_Client_profile_Homepage(String arg1) {
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		Assert.assertTrue("Dashboard Link is not displayed as expected",
				oSeleniumUtils.is_WebElement_Displayed(oCPHomePage.Dashboard_Link));

		Assert.assertTrue("Client profile HomePage was not displayed",
				oCPHomePage.User_navigates_to_Client_profile_application(arg1));

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		if (oSeleniumUtils.is_WebElement_Displayed(oCPHomePage.frame)) {
			oSeleniumUtils.SwitchToFrame(oCPHomePage.frame);
		} else {
			oSeleniumUtils.SwitchToFrame(oCPHomePage.GWTFrame);
		}

	}
	
	@Step
	public void user_should_be_logged_out_from_Client_Profile_application() {
		
		Assert.assertTrue("Suucessfully Logged out from the application",oCPHomePage.LOGOUT_CP_APPLICATION());

	}
	
	@Step
	public void user_selects(String tab, String data) throws AWTException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		oSeleniumUtils.Click_given_Locator(StringUtils.replace(oCPHomePage.DropDown, "svalue", tab));
		String ID;
		switch (tab) {
		case "Table Type":
			//
			ID = oSeleniumUtils.Get_Value_By_given_attribute("id",
					StringUtils.replace(oCPHomePage.DropDown, "svalue", tab));
			System.out.println("ID:" + StringUtils.substringAfter(ID, "List"));
			
			oSeleniumUtils.Enter_given_Text_Element(
					StringUtils.replace(oCPHomePage.ClientSearchBox, "value", StringUtils.substringAfter(ID, "List")),
					data);
			SeleniumUtils.defaultWait(ProjectVariables.MIN_THREAD_WAIT);
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oCPHomePage.Span, "value", data) + "[1]");
			
			//////////
			//SeleniumUtils.defaultWait(ProjectVariables.MIN_THREAD_WAIT);
			Serenity.setSessionVariable("TableType").to(data);
			//oSeleniumUtils.Click_given_Locator(StringUtils.replace(oCPHomePage.TableType, "value", data));
			SeleniumUtils.defaultWait(ProjectVariables.MIN_THREAD_WAIT);
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oCPHomePage.Add_button, "value", "Table Type"));
			break;
		case "Client":
			ID = oSeleniumUtils.Get_Value_By_given_attribute("id",StringUtils.replace(oCPHomePage.DropDown, "svalue", tab));
			 
			System.out.println("ID:" + StringUtils.substringAfter(ID, "List"));
			
			Serenity.setSessionVariable("Client").to(data);
			
			oSeleniumUtils.Enter_given_Text_Element(StringUtils.replace(oCPHomePage.ClientSearchBox, "value", StringUtils.substringAfter(ID, "List")),data);
			
			SeleniumUtils.defaultWait(ProjectVariables.MIN_THREAD_WAIT);
			
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oCPHomePage.Span, "value", data) + "[1]");
			
			SeleniumUtils.defaultWait(ProjectVariables.MIN_THREAD_WAIT);
			
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oCPHomePage.DropDown, "svalue", tab));
			
			SeleniumUtils.defaultWait(ProjectVariables.MIN_THREAD_WAIT);
			
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oCPHomePage.Add_button, "value", "Payer Short"));
			break;
			
		case "Payer Short":	
			
			ID = oSeleniumUtils.Get_Value_By_given_attribute("id",StringUtils.replace(oCPHomePage.DropDown, "svalue", tab));
			 
			System.out.println("ID:" + StringUtils.substringAfter(ID, "List"));
			
			//Serenity.setSessionVariable("Client").to(data);
			
//			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			System.out.println("payers: "+Serenity.sessionVariableCalled("PayerShots"));
			for (int i = 0; i < sArrPayers.size(); i++) {
			
			oSeleniumUtils.Enter_given_Text_Element(StringUtils.replace(oCPHomePage.ClientSearchBox, "value", StringUtils.substringAfter(ID, "List")),sArrPayers.get(i));
			
			Robot robot = new Robot();  	
	           
			robot.keyPress(KeyEvent.VK_ENTER);
	     		
			oGenericUtils.gfn_Click_String_object_Xpath(StringUtils.replace(oCPHomePage.PayerShot, "sValue", sArrPayers.get(i)) + "[1]");
			
			}
			//oSeleniumUtils.Click_given_Locator(StringUtils.replace(oCPHomePage.PayerShot, "sValue", data) + "[1]");
			
			SeleniumUtils.defaultWait(ProjectVariables.MIN_THREAD_WAIT);
			
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oCPHomePage.DropDown, "svalue", tab));
			
			SeleniumUtils.defaultWait(ProjectVariables.MIN_THREAD_WAIT);
			
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oCPHomePage.Add_button, "value", "Payer Short"));
			
			break;
		default:
			Assert.assertTrue("Given Field was not found in the Switch case", false);
		}

		oCPHomePage.DynamicWaitForLoadingIcon();

	}
	
	@Step
	public void user_click_on(String text) {
		
		boolean bStatus=oCPHomePage.UserClickOntheGivenText(text);
		
		if(bStatus==true)
		{
			//logger.info(text+" button was clicked successfully");
		}
		else
		{
			//logger.info(text+" button was not clicked successfully");
			Assert.assertTrue(text+" button was not clicked Successfully", false);
		}
		
		oCPHomePage.DynamicWaitForLoadingIcon();
	}
	
	@Step
	public void user_Should_see_the_message_as(String validationmessage) {
		
		boolean bStatus=oSeleniumUtils.get_TextFrom_Locator(StringUtils.replace(oCPHomePage.Span, "value", validationmessage)).contains(validationmessage);

		if(bStatus==true)
		{
			Assert.assertTrue(validationmessage + " is displayed as expected ",true);
		}
		else
		{
			Assert.assertTrue(validationmessage + " is not displayed as expected ",false);
		}
		
	}
	
	@Step
	public void validate_through_New_Table(String Functionality) throws InterruptedException {
		
		   //int EditIconsize = oSeleniumUtils.get_size_of_the_given_Locator(oCPHomePage.Icon);
		
		
		for (int i = 0; i < sArrPayers.size(); i++) {
			
			boolean bln=oSeleniumUtils.is_WebElement_Displayed(oCPHomePage.getDynamicXpath(sArrPayers.get(i),"Medicaid- TEST"));
		
		    boolean bln1=oSeleniumUtils.is_WebElement_Displayed(oCPHomePage.getDynamicXpath(sArrPayers.get(i),"Commercial- TEST"));
			
			boolean bln2=oSeleniumUtils.is_WebElement_Displayed(oCPHomePage.getDynamicXpath(sArrPayers.get(i),"Medicare- TEST"));
			
			if (bln==true) {

				oGenericUtils.gfn_Click_String_object_Xpath(oCPHomePage.getDynamicXpath(sArrPayers.get(i),"Medicaid- TEST"));

			} else if (bln1==true) {

				oGenericUtils.gfn_Click_String_object_Xpath(oCPHomePage.getDynamicXpath(sArrPayers.get(i),"Commercial- TEST"));
				
			} else if (bln2==true) {
				
				oGenericUtils.gfn_Click_String_object_Xpath(oCPHomePage.getDynamicXpath(sArrPayers.get(i),"Medicare- TEST"));
			}

		}
		
		oGenericUtils.gfn_Click_On_Object("button", " Save");
		
		oCPHomePage.DynamicWaitForLoadingIcon();
		
		oGenericUtils.gfn_Click_String_object_Xpath(oCPHomePage.Icon);
		
		oGenericUtils.gfn_Verify_String_Object_Exist("//span[contains(text(),'TEST - POS Sensitivities')]");
		
		oGenericUtils.gfn_Click_String_object_Xpath("//div[text()='01']/../preceding-sibling::div//div[contains(@ng-click,'selectButton')]");
			
		oGenericUtils.gfn_Click_String_object_Xpath("//div[text()='01']/../preceding-sibling::div//div[contains(@ng-click,'selectButton')]/../../../following-sibling::div[3]");
		
		oGenericUtils.gfn_Verify_Object_Exist("h3","Reasons");
		
		//String[] sValues={"Client Specific Reason","Industry Reference","Others","Provider Contractual Obligation","System Reason"};
		
		oGenericUtils.gfn_Click_String_object_Xpath("//label[text()='Industry Reference']/preceding-sibling::input/parent::div");
		
		oGenericUtils.gfn_Click_On_Object("button", "Apply");
		
		//oGenericUtils.gfn_Click_String_object_Xpath("//div[text()='01']/../preceding-sibling::div//div[contains(@ng-click,'selectButton')]/../../../following-sibling::div[4]");
		
		//oSeleniumUtils.Enter_given_Text_Element("//div[text()='01']/../preceding-sibling::div//div[contains(@ng-click,'selectButton')]/../../../following-sibling::div[4]//div", "Automation Test");
		
		oGenericUtils.gfn_Click_On_Object("a", " Save");
		
		oCPHomePage.DynamicWaitForLoadingIcon();
	
		}
		 
		
	@Step
	public void Validate_the_UnMappedFunctionality(int Edit_NamedSetIconsize, String functionality, String NewTableID) {
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		oSeleniumUtils.Click_given_Locator(StringUtils.replace(oCPHomePage.label, "svalue", "Include Unmapped"));

		do {

			System.out.println("EditIcon_size:" + Edit_NamedSetIconsize);
			if (!functionality.contains("DMU")) {
				SeleniumUtils.scrollingToGivenElement(getDriver(),
						StringUtils.replace(oCPHomePage.Icon, "svalue", "Edit") + "[" + Edit_NamedSetIconsize + "]");
			} else {
				SeleniumUtils.scrollingToGivenElement(getDriver(),
						oCPHomePage.NamedSet_Icon + "[" + Edit_NamedSetIconsize + "]");
			}

		} while (!oSeleniumUtils
				.is_WebElement_Displayed(StringUtils.replace(oCPHomePage.NamedSetTable_ID, "value", NewTableID)));

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(StringUtils.replace(oCPHomePage.NamedSetTable_ID, "value", NewTableID));

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		System.out.println("TableName:"
				+ oSeleniumUtils.get_TextFrom_Locator(StringUtils.replace(oCPHomePage.TableName, "value", NewTableID)));

		Assert.assertTrue("Unmapping functionality is working as expected",
				oSeleniumUtils.get_TextFrom_Locator(StringUtils.replace(oCPHomePage.TableName, "value", NewTableID))
						.contains(StringUtils.substringBefore(functionality, "-")));

	}
	
	@Step
	public void Validate_MappedFunctionality(int editIconsize, String unMappedtext_DMU, String tableID, String icon,
			String NewTable_ID) {
		System.out.println("New Table ID:" + NewTable_ID);
		
		oSeleniumUtils.Click_given_Locator(StringUtils.replace(icon, "svalue", "Edit") + "[" + editIconsize + "]");
		
		oSeleniumUtils.Click_given_Locator(StringUtils.replace(oCPHomePage.Button_With_ExactText, "value", "OK"));
		
		int PolicySet_UnmappedIcon_size = oSeleniumUtils.get_size_of_the_given_Locator(StringUtils.replace(oCPHomePage.Div_with_OR_ExactText, "value", unMappedtext_DMU));
		
		System.out.println("PolicySet_UnmappedIcon_size:" + PolicySet_UnmappedIcon_size);
		
		if (PolicySet_UnmappedIcon_size == 0) 
		{
			oCPHomePage.UnmapTheExistingTableForMappingNewTable(NewTable_ID,unMappedtext_DMU);

			oCPHomePage.DynamicWaitForLoadingIcon();

			oCPHomePage.MapTheNewTableWithTheUnmappedOne(NewTable_ID,unMappedtext_DMU,icon);
			
		} 
		else 
		{
			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			System.out.println(
					StringUtils.replace(oCPHomePage.Div_with_OR_ExactText, "value", unMappedtext_DMU) + "["
							+ PolicySet_UnmappedIcon_size + "]");
			System.out.println(oSeleniumUtils.is_WebElement_Displayed(
					StringUtils.replace(oCPHomePage.Div_with_OR_ExactText, "value", unMappedtext_DMU) + "["
							+ PolicySet_UnmappedIcon_size + "]"));
			if (oSeleniumUtils.is_WebElement_Displayed(
					StringUtils.replace(oCPHomePage.Div_with_OR_ExactText, "value", unMappedtext_DMU) + "["
							+ PolicySet_UnmappedIcon_size + "]")) 
			{
				
				System.out.println(StringUtils.replace(oCPHomePage.Div_with_OR_ExactText, "value", unMappedtext_DMU) + "["
						+ PolicySet_UnmappedIcon_size + "]");

				SeleniumUtils.defaultWait(ProjectVariables.MIN_THREAD_WAIT);
				
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(oCPHomePage.text_with_header2, "value", "Policy Set Configurations"));
				
				oSeleniumUtils.Click_given_Locator(
						StringUtils.replace(oCPHomePage.Div_with_OR_ExactText, "value", unMappedtext_DMU) + "["
								+ PolicySet_UnmappedIcon_size + "]");

				oSeleniumUtils.Click_given_Locator(StringUtils.replace(oCPHomePage.Button_with_ngclick, "svalue", "Save"));
				
				oCPHomePage.ClickGivenElementIfTheElementisDisplayed(StringUtils.replace(oCPHomePage.Button_With_ExactText, "value", "Confirm"));
				
				if(oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(oCPHomePage.Span, "value", ProjectVariables.ErrorMessage_in_mapping)))
				{
				Assert.assertTrue("Policy set configuration changes were not saved due to the unhandled exception", false);	
				}
				
				oCPHomePage.DynamicWaitForLoadingIcon();

			}
			else
			{
				Assert.assertTrue("No Policy Sets Available for mapping", false);
			}
		}
		
	}

	@Step
	public void user_Navigate_tab(String arg1) throws Throwable {
		oCPHomePage.NAVIGATE_TAB(arg1,"");
	}	
	
//===================================Enter Payer short and Navigate to respective tab=========================>
	@Step
	public void select_and_navigate_to_tab(String arg1, String arg2) throws Throwable {
		
		String sPayerShot=Serenity.sessionVariableCalled("PayerShot").toString();
		
		oCPHomePage.SELECT_PAYERSHORT_NAVIGATE_TAB(sPayerShot, arg2);
	}

	@Step
	public void onshore_Operations(String sOperation) throws InterruptedException {

			boolean isChecked=oSeleniumUtils.is_WebElement_Selected(oCPHomePage.OnShoreCheckbox);
			
			System.out.println("Checkbox returnig value"+isChecked);
			
			if (sOperation.equalsIgnoreCase("unCheck") && isChecked==true) {
				
				oGenericUtils.gfn_Click_String_object_Xpath(oCPHomePage.OnShoreCheckbox);
					
			}else if (sOperation.equalsIgnoreCase("Check") && isChecked==false) {
				
				oGenericUtils.gfn_Click_String_object_Xpath(oCPHomePage.OnShoreCheckbox);
					
			}else {
				
				verify("On Shore only check box under security section is"+sOperation+"ed", true);
			}
		
			oGenericUtils.gfn_Click_String_object_Xpath("//div[@id='save']/child::input/following-sibling::img");
			
			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			
			if (oSeleniumUtils.is_WebElement_Displayed("//div[text()='OK']")==true) {
				
				oGenericUtils.gfn_Click_On_Object("div", "OK");
				
			}
		
			oCPHomePage.LOADING_POPUP_FRAME(oCPHomePage.sPopup_Loading);
	}
			

	@Step
	public void verify(String sDescription, boolean blnStatus) {

		GenericUtils.Verify(sDescription, blnStatus);
	}

	/*@Step
	public void user_login_into_jira() throws Exception {
		
		oCPHomePage.user_login_into_jira();
		
       
		
		
	}*/

}
	
	
