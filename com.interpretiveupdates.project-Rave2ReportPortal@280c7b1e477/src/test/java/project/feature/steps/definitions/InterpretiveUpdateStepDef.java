package project.feature.steps.definitions;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.jruby.ir.operands.Array;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import project.utilities.ExcelUtils;
import freemarker.template.utility.StringUtil;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.requirements.SerenityTestCaseFinder;
import net.thucydides.core.steps.ScenarioSteps;
import project.pageobjects.IUHomePage;
import project.pageobjects.IULoginPage;

import project.utilities.DBUtils;
import project.utilities.GenericUtils;
import project.utilities.ProjectVariables;
import project.utilities.SeleniumUtils;

public class InterpretiveUpdateStepDef extends ScenarioSteps {
	private static final long serialVersionUID = 1L;

	// private static final String WebElement = null;

	IULoginPage oIUloginPage;
	IUHomePage oIUHomePage;
	SeleniumUtils oSeleniumUtils;
	GenericUtils oGenericUtils;

	String sValueList;

	@Step
	public void userLogsInToInterpretiveUpdateApplication(String sEnvironmentType, String sUserID) throws Exception {

		switch (sEnvironmentType) {

		case "QA":

			oIUloginPage.IU_SignIn(ProjectVariables.sQA_URL, sUserID, ProjectVariables.PASSWORD);

			verify("IU " + Serenity.sessionVariableCalled("IUVersion").toString(), true);

			break;

		case "PROD":

			Serenity.setSessionVariable("Production").to(sEnvironmentType);

			oIUloginPage.IU_SignIn(ProjectVariables.sPRODUCTION_URL, ProjectVariables.PROD_USER_NAME,
					ProjectVariables.PROD_PASSWORD);

			break;

		default:
			Assert.assertTrue(
					"Environment Type is not matched for function user_Logs_In_To_Interpretive_Update_Application",
					false);

		}

	}

	@Step
	public void userNavigateToIUSmokeInstancesScreen(String sInstanceType) throws InterruptedException {

		int i = getDriver().findElements(By.xpath(oIUHomePage.NavigationComponentAdminScrub)).size();

		switch (sInstanceType) {

		case "Admin":

			if (i > 0) {

				oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.NavigationComponentAdminScrub);

			} else if (!oIUHomePage.AdminInterpretiveUpdateInstanceLink.isVisible()) {

				oGenericUtils.gfn_Click_On_Object("span", "Administration");

				oGenericUtils.gfn_Click_On_Object("a", "Interpretive Update Instances");

				oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			}

			oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.IUInstanceGrid);

			/*
			 * verify("Add button is displayed",
			 * oGenericUtils.gfn_Verify_Object_Exist("div", "Add"));
			 * 
			 * verify("Add button is clicked",
			 * oGenericUtils.gfn_Click_On_Object("div", "Add"));
			 * 
			 * SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			 * 
			 * oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.
			 * New_UpdateInstance_Screen);
			 * 
			 * verify("Cancel button is Displayed",
			 * oGenericUtils.gfn_Verify_Object_Exist("div", "Cancel"));
			 * 
			 * verify("Cancel button is clicked",
			 * oGenericUtils.gfn_Click_On_Object("div", "Cancel"));
			 * 
			 * verify(
			 * "Are you sure you want to cancel the current ADD process? message popup"
			 * , oGenericUtils.gfn_Verify_Object_Exist("div",
			 * "Are you sure you want to cancel the current ADD process?"));
			 * 
			 * verify("Yes button is clicked",
			 * oGenericUtils.gfn_Click_On_Object("div", "Yes"));
			 * 
			 * SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			 * 
			 * verify("Interpretive Update Instances link is clicked",
			 * oGenericUtils.gfn_Click_On_Object("a",
			 * "Interpretive Update Instances"));
			 * 
			 * SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			 */
			break;

		case "My Tasks":

			oGenericUtils.gfn_Click_On_Object("span", "My Tasks");

			oGenericUtils.gfn_Click_On_Object("a", "Interpretive Rule Update");

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.MyTasksIUInstanceGrid);

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TasksTabs, "sValue", "Group Tasks"));

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.GroupTasksGrid);

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TasksTabs, "sValue", "Individual Tasks"));

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.MyTasksIUInstanceGrid);

			SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

			break;

		case "ProductionTestMyTasks":

			oGenericUtils.gfn_Click_On_Object("span", "My Tasks");

			oGenericUtils.gfn_Click_On_Object("a", "Interpretive Rule Update");

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.MyTasksIUInstanceGrid);

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TasksTabs, "sValue", "Group Tasks"));

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.GroupTasksGrid);

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TasksTabs, "sValue", "Individual Tasks"));

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.MyTasksIUInstanceGrid);

			SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

			break;

		default:
			Assert.assertTrue("Instance Type is not matched for function user_Navigate_To_IU_Smoke_Instances_Screen",
					false);
		}

	}

	@Step
	public void userNavigateToIUInstancesScreen(String sInstanceType) throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		switch (sInstanceType) {

		case "MyTasks":

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.SpanTag, "sValue", "Group Tasks"));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oGenericUtils.gfn_Click_On_Object("span", "My Tasks");
			
			SeleniumUtils.defaultWait(ProjectVariables.MIN_THREAD_WAIT);

			oGenericUtils.gfn_Click_On_Object("a", "Interpretive Rule Update");

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			break;

		case "Admin":

			oGenericUtils.gfn_Click_On_Object("span", "Administration");

			oGenericUtils.gfn_Click_On_Object("a", "Interpretive Update Instances");

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			break;

		case "GroupTasks":

			oIUHomePage.closeAllTabs();

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.SpanTag, "sValue", "Group Tasks"));

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oGenericUtils.gfn_Click_On_Object("span", "My Tasks");

			oGenericUtils.gfn_Click_On_Object("a", "Interpretive Rule Update");

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.GroupTaskTab);

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			break;

		case "Admin PO Scrub":

			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

			oGenericUtils.gfn_Verify_Object_Exist("a", "Process Candidates");

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.AllRulesRadioBtn);

			SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

			oGenericUtils.gfn_Verify_String_Object_Exist(oIUHomePage.SelectAllCheckBoxAdminMDScrub);

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.SelectAllCheckBoxAdminMDScrub);

			oGenericUtils.gfn_Click_On_Object("a", "Process Candidates");

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oIUHomePage.closeAllTabs();

			break;

		case "Admin PO Scrub Release":

			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

			oGenericUtils.gfn_Click_On_Object("a", "Release");

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			getDriver().switchTo().defaultContent();

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			oIUHomePage.closeAllTabs();

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			break;
		case "Assignment Configuration":

			// SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			// oIUHomePage.closeAllTabs();

			oGenericUtils.gfn_Click_On_Object("span", "Administration");

			oGenericUtils.gfn_Click_On_Object("a", "Assignment Configuration");

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			boolean bln = oSeleniumUtils.is_WebElement_Displayed("//div[text()='Review Tasks']");

			if (bln == true) {

				oGenericUtils.gfn_Click_On_Object("div", "OK");
			}

			/*
			 * do { SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT); }
			 * while (bln==false);
			 */

			break;

		case "View All Tasks":

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oGenericUtils.gfn_Verify_String_Object_Exist(
					StringUtils.replace(oIUHomePage.AdminInstance, "sValue", ProjectVariables.FinalMDInstance));

			oGenericUtils.gfn_Click_String_object_Xpath(
					StringUtils.replace(oIUHomePage.AdminInstance, "sValue", ProjectVariables.FinalMDInstance));

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.Actions);

			oGenericUtils.gfn_Click_On_Object("span", "View All Tasks");

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			break;

		case "Admin PO Scrub Candidates":

			SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

			oGenericUtils.gfn_Verify_Object_Exist("a", "Process Candidates");

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.AllRulesRadioBtn);

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oGenericUtils.gfn_Verify_String_Object_Exist(oIUHomePage.AdminMDMidRule);

			oGenericUtils.gfn_Verify_String_Object_Exist(oIUHomePage.AdminMDRuleVersion);

			ArrayList<String> sMidRuleList = new ArrayList<String>();

			List<WebElement> iMidRuleCount = getDriver().findElements(By.xpath(oIUHomePage.AdminMDMidRule));

			for (int i = 0; i < iMidRuleCount.size(); i++) {

				sMidRuleList.add(iMidRuleCount.get(i).getText());
			}

			ArrayList<String> sRuleVersionList = new ArrayList<String>();

			List<WebElement> iRuleVersionCount = getDriver().findElements(By.xpath(oIUHomePage.AdminMDRuleVersion));

			for (int i = 0; i < iRuleVersionCount.size(); i++) {

				sRuleVersionList.add(iRuleVersionCount.get(i).getText());

			}

			for (int j = 0; j < sMidRuleList.size(); j++) {

				String sMidRule = sMidRuleList.get(j);

				String sVersion = sRuleVersionList.get(j);

				String sXpath = oIUHomePage.GetDynamicXPathForAdminMDRuleVersion(sMidRule, sVersion);

				oGenericUtils.gfn_Verify_String_Object_Exist(sXpath);
			}

			oIUHomePage.closeAllTabs();

			break;
		default:
			Assert.assertTrue("Instance Type is not matched for function user_Navigate_To_IU_Instances_Screen", false);
		}

	}

	@Step
	public void clickOnInstanceNamefromGridTable(String sInstanceName) {

		if (sInstanceName.equalsIgnoreCase("PO Review Work Queue")) {

			List<WebElement> MDTasklist = getDriver().findElements(By.xpath(oIUHomePage.MD_WorkQueue_CellData));

			for (int i = 0; i < MDTasklist.size(); i++) {

				if (MDTasklist.get(i).getText().equalsIgnoreCase(sInstanceName)) {

					MDTasklist.get(i).click();

					SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

					oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

					break;

				}

			}

		} else {

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.InstanceName, "sValue", sInstanceName));

			Assert.assertTrue("Actions is not Displayed", oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.Actions));

			oSeleniumUtils.highlightElement(oIUHomePage.Actions_Instance_Grid);

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.Actions);

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.SpanTag, "sValue", "Rule Review"));

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		}

	}

	@Step
	public void userShouldAbleToViewWorkQueue(String sTaskType) {

		switch (sTaskType) {

		case "Review Work Queue":

			oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.Rule_Review_WorkQueue);

			Serenity.setSessionVariable("Rule Version")
					.to(oSeleniumUtils.get_TextFrom_Locator(oIUHomePage.InstanceVersion));

			System.out.println("Rule Version: " + Serenity.sessionVariableCalled("Rule Version").toString());

			oSeleniumUtils.Click_given_Locator(oIUHomePage.InstanceVersion);

			SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

			System.out.println("Admin Final Rule Version under stubrmr id : "
					+ oSeleniumUtils.get_TextFrom_Locator(oIUHomePage.FinalRule_Version));

			Assert.assertTrue("Rule Version is not Displayed under stubrmr id : ",
					oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.FinalRule_Version));

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oIUHomePage.closeAllTabs();

			break;
		case "PO Review Work Queue":

			oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.MD_Review_WorkQueue);

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			Serenity.setSessionVariable("Rule Version")
					.to(oSeleniumUtils.get_TextFrom_Locator(oIUHomePage.MD_RuleReview_Version));

			System.out.println("Rule Version: " + Serenity.sessionVariableCalled("Rule Version").toString());

			oSeleniumUtils.Click_given_Locator(oIUHomePage.MD_RuleReview_Version);

			SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

			System.out.println("My Task Final Rule Version under stubrmr id : "
					+ oSeleniumUtils.get_TextFrom_Locator(oIUHomePage.FinalRule_Version));

			Assert.assertTrue("My Task Rule Version is not Displayed under stubrmr id:  ",
					oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.FinalRule_Version));

			getDriver().switchTo().defaultContent();

			break;
		default:
			Assert.assertTrue("TaskType cases are not matched for function user_Should_Able_To_View_Work_Queue", false);

		}

	}

	@Step
	public void userShouldbeLoggedout() throws InterruptedException {
		Assert.assertTrue("Sign out of IU Application", oIUHomePage.fn_JBPM_Sign_Out());
	}

	@Step
	public void clickTaskByInstanceName(String sTaskName, String sInstancetype) throws InterruptedException {

		String sInstance = null;

		switch (sInstancetype.trim()) {

		case "FINAL MD DEL":
		case "FINAL PO DEL":
			sInstance = ProjectVariables.FinalMDInstance;
			verify("Final MD Del Instance Name: " + sInstance, true);
			break;

		case "FINAL MD DEL-Subsequent":
		case "FINAL PO DEL-Subsequent":
			sInstance = ProjectVariables.FinalMDInstanceSubsequent;
			verify("Final MD Del Instance Name: " + sInstance, true);
			break;

		case "FINAL MD SIM":
			sInstance = ProjectVariables.FinalMDInstance;
			break;

		case "PRELIM MD DEL":
		case "PRELIM PO DEL":
			sInstance = ProjectVariables.PrelimMDInstance;
			verify("Prelim MD Del Instance Name: " + sInstance, true);
			break;

		case "Admin Scrub":
			sInstance = ProjectVariables.AdminScrubInstance;
			verify("Admin Scrub Instance Name: " + sInstance, true);
			break;
		case "Pool":
			sInstance = Serenity.sessionVariableCalled("Pool").toString();
			break;

		case "AE PRELIM MD DEL":
		case "AE PRELIM PO DEL":
			sInstance = ProjectVariables.AEPrelimInstance;
			break;
		case "New Scrub":
			sInstance = Serenity.sessionVariableCalled("NewInstanceName").toString();
			verify("Admin Scrub Instance Name: " + sInstance, true);
			break;

		default:
			Assert.assertTrue("Instance Name not matched for function click_Task_By_Instance_Name", false);
			break;
		}

		String sTaskType = StringUtil.replace(oIUHomePage.TaskandInstance, "sValue", sTaskName);

		String strInstance = StringUtil.replace(sTaskType, "sInstance", sInstance);

		Serenity.setSessionVariable("TaskandInstnaceName").to(strInstance);

		Serenity.setSessionVariable("IUInstanceName").to(sInstance);

		System.out.println("Instance Name " + Serenity.sessionVariableCalled("IUInstanceName").toString());

		oGenericUtils.gfn_Click_String_object_Xpath(strInstance);

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		/*
		 * if (sTaskName.equalsIgnoreCase("MD Review Work Queue")) {
		 * 
		 * verify(
		 * "Rules count is displaying at the side of pagination in Individual Task"
		 * , oGenericUtils.gfn_Verify_String_Object_Exist(
		 * "(//div[contains(text(),'Displaying 1')])[1]")); }
		 */
	}

	@Step
	public void applyActiveFilterMyTaskRuleWorkQueue(String sFilterName, String sFilterValue)
			throws InterruptedException {

		List<String> sFilterNameList = Arrays.asList(sFilterName.split(";"));

		List<String> sFilterValueList = Arrays.asList(sFilterValue.split(";"));

		String[] sListValue = null;

		for (int i = 0; i < sFilterNameList.size(); i++) {

			String sFilter = "//label[contains(text(),'" + sFilterNameList.get(i) + "')]/..//div//div/div//td//input";

			sListValue = Serenity.sessionVariableCalled(sFilterNameList.get(i));

			switch (sFilterNameList.get(i)) {

			case "Library Status":

				System.out.println(sFilterValueList.get(i));

				oSeleniumUtils.Enter_given_Text_Element(sFilter, sFilterValueList.get(i));

				oGenericUtils.gfn_Click_String_object_Xpath(
						StringUtil.replace(oIUHomePage.LibraryStatusFilter, "sValue", sFilterValueList.get(i)));

				oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

				if (sFilterValueList.get(i).equalsIgnoreCase("Custom")
						|| sFilterValueList.get(i).equalsIgnoreCase("Library")) {

					Assert.assertTrue("" + sFilterNameList.get(i) + " value is not displayed",
							sFilterValueList.get(i).equalsIgnoreCase(oSeleniumUtils.get_TextFrom_Locator((StringUtil
									.replace(oIUHomePage.FilterValuesValidation, "sValue", sFilterValueList.get(i))))));
				}

				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

				break;

			case "Rules With ARDs":
			case "Assignees":
			case "Impact Run":
			case "Proposal Types":
			case "Tasks":
			case "Task Status":

				oSeleniumUtils.Enter_given_Text_Element(sFilter, sFilterValueList.get(i));

				oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

				oGenericUtils.gfn_Click_String_object_Xpath(
						StringUtil.replace(oIUHomePage.ApplyFilterValues, "sValue", sFilterValueList.get(i)));

				oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

				boolean bFlag = oSeleniumUtils.is_WebElement_Displayed(
						StringUtil.replace(oIUHomePage.FilterValuesValidation, "sValue", sFilterValueList.get(i)));

				if (bFlag == false) {

					List<WebElement> ilength = getDriver().findElements(By.xpath(
							StringUtil.replace(oIUHomePage.FilterValuesValidation, "sValue", sFilterValueList.get(i))));

					verify("" + sFilterNameList.get(i) + " value is displayed",
							sFilterValueList.get(i)
									.equalsIgnoreCase(oSeleniumUtils
											.get_TextFrom_Locator("((//div[@class='GEFT4QHBBJC'])[2 or 3]//div[text()='"
													+ sFilterValueList.get(i) + "'])[" + ilength.size() + "]")));
				} else {

					verify("" + sFilterNameList.get(i) + " value is displayed",
							sFilterValueList.get(i).equalsIgnoreCase(oSeleniumUtils.get_TextFrom_Locator((StringUtil
									.replace(oIUHomePage.FilterValuesValidation, "sValue", sFilterValueList.get(i))))));
				}

				break;

			case "MedicalPolicies":

				oGenericUtils.gfn_Click_String_object_Xpath(
						StringUtil.replace(oIUHomePage.ActiveFiterDropDwnBtn, "sValue", "Medical Policies:"));

				oGenericUtils.gfn_Click_String_object_Xpath(
						StringUtil.replace(oIUHomePage.ApplyFilterValues, "sValue", sFilterValueList.get(i)));

				oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

				verify("MedicalPolicies value is displayed",
						sFilterValueList.get(i).equalsIgnoreCase(oSeleniumUtils.get_TextFrom_Locator((StringUtil
								.replace(oIUHomePage.FilterValuesValidation, "sValue", sFilterValueList.get(i))))));

				break;

			case "Topics":

				oGenericUtils.gfn_Click_String_object_Xpath(
						StringUtil.replace(oIUHomePage.ActiveFiterDropDwnBtn, "sValue", "Topics:"));

				oGenericUtils.gfn_Click_String_object_Xpath(
						StringUtil.replace(oIUHomePage.ApplyFilterValues, "sValue", sFilterValueList.get(i)));

				oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

				verify("Topics value should be displayed",
						sFilterValueList.get(i).equalsIgnoreCase(oSeleniumUtils.get_TextFrom_Locator((StringUtil
								.replace(oIUHomePage.FilterValuesValidation, "sValue", sFilterValueList.get(i))))));

				break;

			case "Topic":
			case "Payers":
			case "Medical Policies":
			case "Priority":
			case "Rules":
			case "Codes":
			case "Category Codes":
			case "Decision Points":

				for (int j = 0; j < sListValue.length; j++) {

					int iRandom = GenericUtils.generate_Random_Number_for_Given_Range(sListValue.length);

					// oSeleniumUtils.Enter_given_Text_Element(sFilter,sListValue[j]);

					oSeleniumUtils.Enter_given_Text_Element(sFilter, sListValue[iRandom]);

					oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

					boolean bln = oSeleniumUtils.is_WebElement_Displayed(
							StringUtil.replace(oIUHomePage.ApplyFilterValues, "sValue", sListValue[iRandom]));

					if (bln == true) {

						oGenericUtils.gfn_Click_String_object_Xpath(
								StringUtil.replace(oIUHomePage.ApplyFilterValues, "sValue", sListValue[iRandom]));

						oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

						verify("" + sFilterValueList.get(i) + " value should be displayed",
								oSeleniumUtils.is_WebElement_Displayed(((StringUtil
										.replace(oIUHomePage.FilterValuesValidation, "sValue", sListValue[iRandom])))));

						break;

					}

				}

				break;

			default:
				Assert.assertTrue("Active Filter cases are not matched for function click on", false);

			}

		}

	}

	@Step
	public void clickOnWorkQueue(String arg1) throws InterruptedException {

		switch (arg1) {

		case "Start Review":
			SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.StartReview);
			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);
			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.StartReviewPoPYesBtn);
			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			getDriver().switchTo().defaultContent();
			break;

		case "Generate Summaries":
			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);
			oGenericUtils.gfn_Click_On_Object("tab-heading", "Decisions");
			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			if ((oSeleniumUtils.is_WebElement_Present(oIUHomePage.Generate_Summaries))) {
				oSeleniumUtils.Click_given_Locator(oIUHomePage.Generate_Summaries);
			} else {
				oGenericUtils.gfn_Click_On_Object("label", "Generate Summaries");
			}

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oGenericUtils.gfn_Verify_Object_Exist("h3", "Success");

			Assert.assertTrue("Generate Summaries Message is not Displayed as expected",
					ProjectVariables.Generate_Summaries_Pop_Msg.equalsIgnoreCase(oSeleniumUtils
							.get_TextFrom_Locator(StringUtil.replace(oIUHomePage.h3Tag, "sValue", "Success"))));

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Ok"));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			getDriver().switchTo().defaultContent();
			break;

		case "Generate Change Log":
			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

			oGenericUtils.gfn_Click_On_Object("tab-heading", "Decisions");

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oSeleniumUtils.Click_given_Locator(oIUHomePage.GenerateChangeLog);

			verify("Change Log Popup is Displayed", oSeleniumUtils
					.is_WebElement_Displayed(StringUtil.replace(oIUHomePage.h3Tag, "sValue", "Change Log")));

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Ok"));

			getDriver().switchTo().defaultContent();

			break;

		case "Authorize Decisions":

			String SelCase;
			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Summaries"));

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oGenericUtils.gfn_Click_String_object_Xpath(("//label[contains(text(),'Authorize Decisions')]"));

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			int iEditorialWarning = getDriver()
					.findElements(
							By.xpath(StringUtils.replace(oIUHomePage.h3Tag, "sValue", "Editorial changes observed")))
					.size();

			if (iEditorialWarning > 0) {

				oGenericUtils.gfn_Click_On_Object("button", "No");
				oGenericUtils.gfn_Click_String_object_Xpath(("//label[contains(text(),'Authorize Decisions')]"));

			}

			List<WebElement> sList = getDriver().findElements(By.xpath(oIUHomePage.Authorize_Decisions));

			if (sList.size() > 0) {
				SelCase = "Empty";
			} else {
				SelCase = "Retire";
			}

			switch (SelCase) {
			case "Retire":

				oGenericUtils.gfn_Verify_Object_Exist("p", " Please Review Retire Rule before Authorizing Decisions");
				oGenericUtils.gfn_Click_On_Object("button", "Ok");
				SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
				oGenericUtils.gfn_Verify_Object_Exist("span", "Retire Rule");
				oGenericUtils.gfn_Click_On_Object("span", "Retire Rule");

				oSeleniumUtils.select_Given_Value_From_DropDown(oIUHomePage.Retirerule_MDecision, "Do Not Retire Rule");
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
				oIUHomePage.MD_Comments.click();

				oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.MD_Comments, ProjectVariables.TestComments);
				SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
				oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Save"));
				oGenericUtils.gfn_Verify_Object_Exist("button", "Ok");
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
				oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Ok"));
				SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
				oGenericUtils.gfn_Click_String_object_Xpath(("//label[contains(text(),'Authorize Decisions')]"));

				break;
			}

			oGenericUtils.gfn_Verify_Object_Exist("button", "Yes");
			// oIUHomePage.wait_Untill_ElementExists(oIUHomePage.Authorize_Decisions);

			Assert.assertTrue("Confirmation Warning should be displayed",
					oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.Authorize_Decisions));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Yes"));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oGenericUtils.gfn_Verify_Object_Exist("h3", "Authorize Decisions");

			Assert.assertTrue("Confirmation Warning should be displayed",
					oSeleniumUtils.is_WebElement_Displayed(StringUtil.replace(oIUHomePage.pTag, "sValue",
							" Rule moved to next step in rule review process successfully.")));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Ok"));

			getDriver().switchTo().defaultContent();

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			break;

		case "Require Presentation":
			requires_Presentation();
			break;

		case "Return Rule CPM":

			SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);
			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);
			oSeleniumUtils.Click_given_Locator(oIUHomePage.ReturnRule);
			oGenericUtils.gfn_Verify_Object_Exist("h3", "Editorial Return Rule - Custom Rule");
			oSeleniumUtils.select_Given_Value_From_DropDown_Using_StringLocator(oIUHomePage.EditorialReturnSelect,
					"CPM");
			oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.EditorialReturnReason, "Return to CPM");
			oGenericUtils.gfn_Click_On_Object("button", "Return Rule");
			oGenericUtils.gfn_Verify_Object_Exist("p",
					"Rule is being returned to CPM for clarification of Editorial concern. Continue?");
			oGenericUtils.gfn_Click_On_Object("button", "Yes");
			oGenericUtils.gfn_Verify_Object_Exist("p", " Rule Returned successfully.");
			oGenericUtils.gfn_Click_On_Object("button", "Ok");

			getDriver().switchTo().defaultContent();
			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);
			break;

		case "Return Rule Response":

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

			oSeleniumUtils.Click_given_Locator(oIUHomePage.ReturnRuleResponse);

			oGenericUtils.gfn_Verify_Object_Exist("h3", "Return Rule Response");

			oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.CPMResponse, ProjectVariables.ReturnRuleComments);

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.SaveReturnRuleResponse);

			oGenericUtils.gfn_Verify_Object_Exist("h3", "WARNING");

			oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.CPMResponse, ProjectVariables.ReturnRuleComments);

			oGenericUtils.gfn_Click_On_Object("button", "Return Response To Editorial");

			oGenericUtils.gfn_Verify_Object_Exist("h3", "WARNING");

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.StartReviewPoPYesBtn);

			oGenericUtils.gfn_Click_On_Object("button", "Ok");

			getDriver().switchTo().defaultContent();

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			break;

		case "Return Rule Response To Testing":

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

			oSeleniumUtils.Click_given_Locator(oIUHomePage.ReturnRuleResponse);

			oGenericUtils.gfn_Verify_Object_Exist("h3", "Return Rule Response");

			oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.CPMResponse, ProjectVariables.ReturnRuleComments);

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.SaveReturnRuleResponse);

			oGenericUtils.gfn_Verify_Object_Exist("h3", "WARNING");

			oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.CPMResponse, ProjectVariables.ReturnRuleComments);

			oGenericUtils.gfn_Click_On_Object("button", "Return Response To Testing");

			oGenericUtils.gfn_Verify_Object_Exist("h3", "WARNING");

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.StartReviewPoPYesBtn);

			oGenericUtils.gfn_Click_On_Object("button", "Ok");

			getDriver().switchTo().defaultContent();

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			break;

		case "Return Rule Response Testing":
			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

			oSeleniumUtils.Click_given_Locator(oIUHomePage.ReturnRuleResponse);

			oGenericUtils.gfn_Verify_Object_Exist("h3", "Return Rule Response");

			oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.CPMResponse, ProjectVariables.ReturnRuleComments);

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.SaveReturnRuleResponse);

			oGenericUtils.gfn_Verify_Object_Exist("h3", "WARNING");

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.StartReviewPoPYesBtn);

			oGenericUtils.gfn_Click_On_Object("button", "Ok");

			getDriver().switchTo().defaultContent();

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			break;

		case "CPM Decesion Complete":

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

			oSeleniumUtils
					.Click_given_Locator((StringUtil.replace(oIUHomePage.LabelTag, "sValue", "CPM Decision Complete")));

			oGenericUtils.gfn_Click_On_Object("span", "OK");
			oGenericUtils.gfn_Verify_Object_Exist("p", " CPM Decisions completed successfully");
			oGenericUtils.gfn_Click_On_Object("button", "Ok");

			getDriver().switchTo().defaultContent();
			break;

		case "CPM Authorize Decisions":

			SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			verify("clicked on CPM Summaries button", oSeleniumUtils
					.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "CPM Summaries")));

			verify("Clicked on Authorize Decisions button",
					oGenericUtils.gfn_Click_String_object_Xpath(("//label[contains(text(),'Authorize Decisions')]")));

			verify("clicked on Yes button ", oGenericUtils.gfn_Click_On_Object("button", "Yes"));

			getDriver().switchTo().defaultContent();

			break;
		case "Modify Decisions":

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oSeleniumUtils.Click_given_WebElement(oIUHomePage.ModifyDecisions);

			getDriver().switchTo().defaultContent();

			break;

		case "Peer Review":
			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);
			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			oGenericUtils.gfn_Click_String_object_Xpath(
					oIUHomePage.GetDynamicXPathWithString("CONTAINS LABEL", "Peer Agree", ""));
			oGenericUtils.gfn_Verify_Object_Exist("h3", "Peer Review Information");
			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.StartReviewPoPYesBtn);

			getDriver().switchTo().defaultContent();
			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			break;
		case "Set Require Presentation":

			setRequirePresentation();

			break;

		case "Return Require Present Rule":

			returnRequiresPresentationRule();

			break;
		case "Reset":

			oGenericUtils.gfn_Click_On_Object("div", arg1);

			verify("Data which we selected is empty", !oSeleniumUtils.is_WebElement_Displayed(
					"//span[text()='Type']/../../../../../../../..//div[@class='GEFT4QHBE3C']"));

			break;

		case "Clear":

			oGenericUtils.gfn_Click_On_Object("div", arg1);

			// verify("Data which we selected is empty",
			// !oSeleniumUtils.is_WebElement_Displayed("//span[text()='Type']/../../../../../../../..//div[@class='GEFT4QHBE3C']"));

			break;

		default:
			Assert.assertTrue("Case values are not matched for function click on", false);

		}

	}

	@Step
	public void selectSystemProposal(String sProposalType, String sDecision) throws InterruptedException {

		// SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		if (sProposalType.equalsIgnoreCase("Modify Decisions")) {

			oSeleniumUtils.Click_given_WebElement((oIUHomePage.ModifyDecisions));

		}

		// SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		switch (sDecision) {

		case "No Action":
		case "Remove":
		case "No Decision":

			// oSeleniumUtils.select_Given_Value_From_DropDown(oIUHomePage.SystemProposalDecision,
			// sDecision);

			// oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.SystemProposalCommments,
			// ProjectVariables.SystemProposalComments);

			List<WebElement> iMidRuleCount = getDriver()
					.findElements(By.xpath("//select[@name='decisionAction.decisionActionKey']"));

			System.out.println(iMidRuleCount.size());

			for (int i = 2; i <= iMidRuleCount.size(); i++) {
				int j = i - 1;
				System.out.println("(//select[@name='decisionAction.decisionActionKey'])[" + i + "]");
				oSeleniumUtils.select_Given_Value_From_DropDown_Using_StringLocator(
						"(//select[@name='decisionAction.decisionActionKey'])[" + i + "]", sDecision);
				oSeleniumUtils.Enter_given_Text_Element("(//textarea[@name='interpComment.comments'])[" + j + "]",
						ProjectVariables.SystemProposalComments);

			}

			break;

		case "Modify":

			oSeleniumUtils.select_Given_Value_From_DropDown(oIUHomePage.SystemProposalDecision, sDecision);

			oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.SystemProposalCommments,
					ProjectVariables.SystemProposalComments);

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.System_Proposal_DOS, "sValue", "1_dos"));

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oSeleniumUtils.Enter_given_Text_Element(
					StringUtil.replace(oIUHomePage.System_Proposal_DOS, "sValue", "toDOSDate"),
					ProjectVariables.SystemProposalDOS);

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.SpanTag, "sValue", "Ok"));

			break;

		case "ModifywithoutDate":

			oSeleniumUtils.select_Given_Value_From_DropDown(oIUHomePage.SystemProposalDecision,
					ProjectVariables.Decision);

			oSeleniumUtils.Enter_given_Text_Element("//textarea[@id='1_interpComment.comments']",
					ProjectVariables.SystemProposalComments);

			break;

		default:

		}

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.AnchorTag, "sValue", "Save"));

		boolean bln = oSeleniumUtils.is_WebElement_Displayed(
				"//p[contains(text(),' Please Modify the DOS value for Review Code')]).gfn_Verify_String_Object_Exist(");

		if (bln == true) {

			oGenericUtils.gfn_Click_On_Object("button", "Ok");

			getDriver().switchTo().defaultContent();

			selectSystemProposal(sProposalType, "Modify");

		}

		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void addCodeFunction(String sCategory, String sCPTCode) {

		Serenity.setSessionVariable("CPTCode").to(sCPTCode);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.LabelTag, "sValue", "Add Code"));

		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(oIUHomePage.StartNewRadio_Btn);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.AnchorTag, "sValue", "Start New"));

		oSeleniumUtils.select_Given_Value_From_DropDown(oIUHomePage.ManualProposalUpdateInstanceDropdwn, "Yes");

		oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.ManualProposalsRationaleComments,
				ProjectVariables.ManualProposalsComments);

		oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.ManualProposalsCptCode, sCPTCode);

		oSeleniumUtils.select_Given_Value_From_DropDown(oIUHomePage.ManualProposalCatgoryDropdwn, sCategory);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.LabelTag, "sValue", "Save"));

		Assert.assertTrue("Manual Proposal message no displayed", oSeleniumUtils.is_WebElement_Displayed(
				StringUtil.replace(oIUHomePage.pTag, "sValue", ProjectVariables.ManualProposalsDailogMsg)));

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Ok"));

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void completeEditorialInFinalMDReview(String sUpdateType) throws InterruptedException {

		oIUHomePage.Click_on_Editorial();

		switch (sUpdateType) {

		case "No Editorial Changes":

			// SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oSeleniumUtils.Click_given_Locator(
					StringUtil.replace(oIUHomePage.No_Edit_Required, "sValue", "No Editorial Changes Required"));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			verify("Confirmation Warning should be displayed", oSeleniumUtils.is_WebElement_Displayed(
					StringUtil.replace(oIUHomePage.pTag, "sValue", ProjectVariables.Editorial_MSG_NC_Required)));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oSeleniumUtils.Click_given_WebElement(oIUHomePage.Confirm_Yes);

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			if (Serenity.sessionVariableCalled("TaskType") != null) {

				if (Serenity.sessionVariableCalled("TaskType").toString().equalsIgnoreCase("Preliminary PO Review")) {

					verify("Confirmation Warning should be displayed",
							oSeleniumUtils.is_WebElement_Displayed(StringUtil.replace(oIUHomePage.pTag, "sValue",
									ProjectVariables.Editorial_MSG_Editorial_Saved_Prilim)));

				} else {

					verify("Confirmation Warning should be displayed", oSeleniumUtils.is_WebElement_Displayed(StringUtil
							.replace(oIUHomePage.pTag, "sValue", ProjectVariables.Editorial_MSG_Editorial_Saved)));
				}
			}

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oGenericUtils.gfn_Click_On_Object("button", "Ok");

			break;

		case "Editorial Changes":

			oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.EditNewRuleDesc,
					ProjectVariables.EditorialChangesDescripiton);

			oGenericUtils.gfn_Click_On_Object("label", "Save");

			oGenericUtils.gfn_Click_On_Object("button", "Ok");

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oGenericUtils.gfn_Click_On_Object("label", "Complete Editorials");

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oGenericUtils.gfn_Verify_Object_Exist("h3", "Success");

			oGenericUtils.gfn_Click_On_Object("button", "Ok");

			break;

		case "Edit Decription":

			// Edit Description
			oSeleniumUtils.Enter_given_Text_Element(
					oIUHomePage.GetDynamicXPathWithString("EDITORIAL TABS", "editables.newRuleDescription", ""),
					ProjectVariables.EditorialChangesDescripiton);
			oGenericUtils.gfn_Click_On_Object("label", "Save");
			oGenericUtils.gfn_Click_On_Object("button", "Ok");

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			break;

		case "Update Tabs":

			// Edit Description
			oSeleniumUtils.Enter_given_Text_Element(
					oIUHomePage.GetDynamicXPathWithString("EDITORIAL TABS", "editables.newRuleDescription", ""),
					ProjectVariables.EditorialChangesDescripiton);
			oGenericUtils.gfn_Click_On_Object("label", "Save");
			oGenericUtils.gfn_Click_On_Object("button", "Ok");
			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			// Edit Notes
			oGenericUtils.gfn_Click_On_Object("span", "Notes");
			oSeleniumUtils.Enter_given_Text_Element(
					oIUHomePage.GetDynamicXPathWithString("EDITORIAL TABS", "editables.updatedNotes", ""),
					ProjectVariables.EditorialChangesNotes);
			oGenericUtils.gfn_Click_On_Object("label", "Save");
			oGenericUtils.gfn_Click_On_Object("button", "Ok");
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			// Edit Script
			oGenericUtils.gfn_Click_On_Object("span", "Script");
			oSeleniumUtils.Enter_given_Text_Element(
					oIUHomePage.GetDynamicXPathWithString("EDITORIAL TABS", "editables.updatedScript", ""),
					ProjectVariables.EditorialChangesScript);
			oGenericUtils.gfn_Click_On_Object("label", "Save");
			oGenericUtils.gfn_Click_On_Object("button", "Ok");
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			// Edit Rationale
			oGenericUtils.gfn_Click_On_Object("span", "Rationale");
			oSeleniumUtils.Enter_given_Text_Element(
					oIUHomePage.GetDynamicXPathWithString("EDITORIAL TABS", "editables.updatedRationale", ""),
					ProjectVariables.EditorialChangesRationale);
			oGenericUtils.gfn_Click_On_Object("label", "Save");
			oGenericUtils.gfn_Click_On_Object("button", "Ok");
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			// Edit Reference
			oGenericUtils.gfn_Click_On_Object("span", "Reference");
			oSeleniumUtils.Enter_given_Text_Element(
					oIUHomePage.GetDynamicXPathWithString("EDITORIAL TABS", "editables.updatedReference", ""),
					ProjectVariables.EditorialChangesReference);
			oGenericUtils.gfn_Click_On_Object("label", "Save");
			oGenericUtils.gfn_Click_On_Object("button", "Ok");
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oGenericUtils.gfn_Click_On_Object("label", "Complete Editorials");

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

//			oGenericUtils.gfn_Verify_Object_Exist("h3", "Success");

			oGenericUtils.gfn_Click_On_Object("button", "Ok");

			break;

		case "Approve Editorials":

			oGenericUtils.gfn_Click_On_Object("label", sUpdateType);

			oGenericUtils.gfn_Click_On_Object("button", "Ok");

			break;

		case "Complete Editorials":
			/*
			 * oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage
			 * .No_Edit_Required, "sValue", "Approve Editorials"));
			 * 
			 * SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			 * 
			 * oGenericUtils.gfn_Click_On_Object("button", "Ok");
			 */

			// oIUHomePage.Click_on_Editorial();

			oSeleniumUtils.Click_given_Locator(
					StringUtil.replace(oIUHomePage.CompleteEditorials_Approve, "sValue", "Complete Editorials"));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oGenericUtils.gfn_Click_On_Object("button", "Ok");

			break;

		default:
			Assert.assertTrue("completeEditorialInFinalMDReview", false);

		}

		getDriver().close();

		SeleniumUtils.switchWindowUsingWindowCount(3, 1, getDriver());

		getDriver().switchTo().defaultContent();
	}

	@Step
	public void validateBOBWGridData() throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.SpanTag, "sValue", "Configurations Summary"));

		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

		if (!oIUHomePage.NoConfigSummaryContent.isVisible()) {

			Assert.assertTrue("Confirmation Warning should be displayed",
					oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.Configuration_Summary_Content));

		} else {
			oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.ConfigSummaryInstruction,
					ProjectVariables.TestComments);

			oSeleniumUtils.Click_given_WebElement(oIUHomePage.ConfigSummarySaveButton);

			oGenericUtils.gfn_Verify_Object_Exist("h3", "Success");

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Ok"));

		}

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void retireRuleCheck(String sCreateRuleVersion) throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Summaries"));

		oGenericUtils.gfn_Verify_Object_Exist("span", "Configurations Summary");

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		if (!(oSeleniumUtils
				.is_WebElement_Displayed(StringUtil.replace(oIUHomePage.SpanTag, "sValue", "Retire Rule")))) {

			oSeleniumUtils.Click_given_WebElement(oIUHomePage.RetireRuleBtn);

			oGenericUtils.gfn_Verify_Object_Exist("span", "Retire Rule");

		}

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.SpanTag, "sValue", "Retire Rule"));

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		if (sCreateRuleVersion.equalsIgnoreCase("Yes")) {

			if (oSeleniumUtils.is_WebElement_Present(oIUHomePage.Retirerule_MDecision)) {

				oSeleniumUtils.select_Given_Value_From_DropDown(oIUHomePage.Retirerule_MDecision, "Retire Rule");

				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

				Serenity.setSessionVariable("RetireRule-Yes").to(sCreateRuleVersion);
			}

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.CreateNewRuleVersion, "sValue", "-1"));
		}

		if (sCreateRuleVersion.equalsIgnoreCase("No")) {

			if (oSeleniumUtils.is_WebElement_Present(oIUHomePage.Retirerule_MDecision)) {

				oSeleniumUtils.select_Given_Value_From_DropDown(oIUHomePage.Retirerule_MDecision, "Do Not Retire Rule");

				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			}

			// oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.CreateNewRuleVersion,
			// "sValue", "0"));
		}

		if (sCreateRuleVersion.equalsIgnoreCase("RetireRuleWithNoVersion")) {

			if (oSeleniumUtils.is_WebElement_Present(oIUHomePage.Retirerule_MDecision)) {

				oSeleniumUtils.select_Given_Value_From_DropDown(oIUHomePage.Retirerule_MDecision, "Retire Rule");

				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			}
			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.CreateNewRuleVersion, "sValue", "0"));
		}

		oIUHomePage.MD_Comments.click();

		verify("Comments were entered",
				oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.MD_Comments, ProjectVariables.TestComments));

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		verify("Save button is clicked",
				oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Save")));

		oGenericUtils.gfn_Verify_Object_Exist("button", "Ok");

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		verify("Confirmation Warning should be displayed", oSeleniumUtils.is_WebElement_Displayed(
				StringUtil.replace(oIUHomePage.pTag, "sValue", ProjectVariables.Message_Saved)));

		verify("Ok button is clicked",
				oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Ok")));

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void authorizeDecisions() {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

		verify("Summaries clicked", oSeleniumUtils
				.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Summaries")));

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		verify("Authorize Decisions is clicked",
				oSeleniumUtils.Click_given_Locator("//label[contains(text(),'Authorize Decisions')]"));

		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

		oIUHomePage.wait_Untill_ElementExists(oIUHomePage.Authorize_Decisions);

		verify("Confirmation Warning should be displayed",
				oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.Authorize_Decisions));

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		verify("Yes button is cliked",
				oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Yes")));

		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

		verify("Confirmation Warning should be displayed", oSeleniumUtils.is_WebElement_Displayed(StringUtil
				.replace(oIUHomePage.pTag, "sValue", " Rule moved to next step in rule review process successfully.")));

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		verify("Ok button is clicked",
				oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Ok")));

		getDriver().switchTo().defaultContent();

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

	}

	@Step
	public void validateBOBWConfigLinkSubmit(String sCategoryType) {

		switch (sCategoryType) {

		case "Billed With And":
		case "Billed With (Or)":

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

			verify("BW And/BWO or Config Logic Link is clicked", oSeleniumUtils.Click_given_Locator(
					StringUtil.replace(oIUHomePage.AnchorTag, "sValue", "BW And/BWO or Config Logic")));

			SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

			verify("Billed With And/Billed Without Code displayed", oSeleniumUtils.is_WebElement_Displayed(StringUtil
					.replace(oIUHomePage.h3Tag, "sValue", "Billed With And/Billed Without Or Code Clarification")));

			List<WebElement> BWRadioBtn = getDriver().findElements(By.xpath("//label[@class='radio-inline']/input"));

			if (BWRadioBtn.size() > 1) {

				verify("Billed With Radio Button is Clicked",
						oSeleniumUtils.Click_given_WebElement(oIUHomePage.BW_Radio_button));

			} else {

				verify("New Billed With Radio Button is Clicked",
						oSeleniumUtils.Click_given_WebElement(oIUHomePage.NewBilled_Radio_button));

			}

			verify("Submit Button is Clicked",
					oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Submit")));

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			verify("Billed With And/Billed Without Code displayed", oSeleniumUtils
					.is_WebElement_Displayed(StringUtil.replace(oIUHomePage.pTag, "sValue", " Saved Successfully")));

			verify("Ok Button is Clicked",
					oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Ok")));

			getDriver().switchTo().defaultContent();

			break;

		case "BWOLinkAvail":

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

			if (!oIUHomePage.BWOConfigLink.isVisible()) {

				verify("BOBW Config Link is NOT Exist ", false);

			} else {
				verify("BOBW Config Link is Exist ", true);

			}

			getDriver().switchTo().defaultContent();

			break;

		case "BWOLinkNotAvail":

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

			/*
			 * int iBOBWConfigLink2 = getDriver() .findElements(
			 * By.xpath(StringUtil.replace(oIUHomePage.AnchorTag, "sValue",
			 * "BW And/BWO or Config Logic"))) .size();
			 * 
			 * if (iBOBWConfigLink2 > 0) { verify("BOBW Config Link is Exist ",
			 * false); } else { verify("BOBW Config Link is NOT Exist ", true);
			 * 
			 * }
			 */

			if (!oIUHomePage.BWOConfigLink.isVisible()) {

				verify("BOBW Config Link is NOT Exist ", true);

			} else {
				verify("BOBW Config Link is Exist ", false);

			}

			getDriver().switchTo().defaultContent();

			break;

		default:
			Assert.assertTrue("Case values are not matched for function validate_BOBW_Config_Link_Submit on", false);

		}

	}

	@Step
	public void selectRuleWithTask(String sTaskValue) {

		boolean sFlag = false;

		if (sTaskValue.equalsIgnoreCase("Final PO Review")) {

			Serenity.setSessionVariable("TaskType").to(sTaskValue);

			oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.MD_Review_WorkQueue);

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			List<WebElement> RuleVersionlist = getDriver().findElements(By.xpath(oIUHomePage.MyTaskRuleVersions));

			for (int i = 0; i < RuleVersionlist.size(); i++) {

				String[] sRuleVersion = RuleVersionlist.get(i).getText().split("\\.");

				// Execute Query Before selecting Rule from My Tasks
				String sQuery = "select DEACTIVATED_10 from rules.sub_rules where MID_RULE_KEY = '" + sRuleVersion[0]
						+ "' and RULE_VERSION = '" + sRuleVersion[1] + "'";

				System.out.println("Query: " + sQuery);

				String sDeactivateStatus = DBUtils.executeSQLQuery(sQuery);

				System.out.println("Query Status: " + sDeactivateStatus);

				if (sDeactivateStatus.equalsIgnoreCase("0")) {

					Serenity.setSessionVariable("MidRuleVersion").to(RuleVersionlist.get(i).getText());
					// Serenity.setSessionVariable("MidRuleVersion").to("12063.8");

					System.out.println(Serenity.sessionVariableCalled("MidRuleVersion").toString());
					verify("Selected Rule is :" + Serenity.sessionVariableCalled("MidRuleVersion").toString(), true);

					validateColumnStatus("Task", sTaskValue);

					SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
					RuleVersionlist.get(i).click();

					SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
					sFlag = true;
					break;

				}
			}

		}

		if (sTaskValue.equalsIgnoreCase("Preliminary PO Review")) {

			List<WebElement> PrelimRuleVersionlist = getDriver().findElements(By.xpath(oIUHomePage.MyTaskRuleVersions));
			Serenity.setSessionVariable("MidRuleVersion").to(PrelimRuleVersionlist.get(0).getText());
			PrelimRuleVersionlist.get(0).click();
			verify("Selected Rule is :" + Serenity.sessionVariableCalled("MidRuleVersion").toString(), true);
			sFlag = true;

		}

		if (sFlag == false) {

			verify("Selected Rules are Deactivated", false);
		}

	}

	@Step

	public void validateAdminRuleReviewValue(String sRole, String sInstanceType, String sColoumnName,
			String sColumnValue) throws InterruptedException {

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oIUHomePage.closeAllTabs();

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.SpanTag, "sValue", "Group Tasks"));

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.SpanTag, "sValue", "Administration"));

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(
				StringUtil.replace(oIUHomePage.AnchorTag, "sValue", "Interpretive Update Instances"));

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		clickInstanceinAdmin(sInstanceType);

		if (!sRole.equalsIgnoreCase("Admin-Filter")) {

			oIUHomePage.go_To_Rule(Serenity.sessionVariableCalled("MidRuleVersion").toString());

			validateRuleReviewColumnValues(sColoumnName, sColumnValue);

		}

		// Serenity.setSessionVariable("MidRuleVersion").to("2951.162");

	}

	@Step
	public void reassignTask(String sRole, String sReassignUserID) throws InterruptedException {

		oSeleniumUtils.Click_given_WebElement(oIUHomePage.Col_Rule_Grid);

		oSeleniumUtils.Click_given_WebElement(oIUHomePage.ReAssignNavigationAdmin);

		int i = getDriver().findElements(By.xpath(StringUtil.replace(oIUHomePage.SpanTag, "sValue", "Reassign")))
				.size();

		if (i > 0) {
			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.SpanTag, "sValue", "Reassign"));
		} else {
			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.DivTag, "sValue", "Reassign"));
		}

		if (sRole.equalsIgnoreCase("CPM")) {

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.ReassignCPM);

			oSeleniumUtils.Click_given_WebElement(oIUHomePage.CPM_Reassgin_ListNavigaion);

			oGenericUtils.gfn_Click_On_Object("div", sReassignUserID);

			oGenericUtils.gfn_Click_On_Object("div", "OK");

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		} else {

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			oSeleniumUtils.Click_given_Locator(oIUHomePage.ReAssignToListBoxIcon);

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oGenericUtils.gfn_Click_String_object_Xpath(
					StringUtils.replace(oIUHomePage.QAReassign, "sValue", sReassignUserID));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oGenericUtils.gfn_Click_On_Object("div", "Submit Reassignments");

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oGenericUtils.gfn_Click_String_object_Xpath(
					"//div[text()='Rules will be reassigned based on select options. Continue?']/parent::div/following-sibling::div//div[text()='Yes']");

			SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);
		}

	}

	@Step
	public void validateSeletedActiveFilterValues() {

		Assert.assertTrue("Library Status value is not displayed",
				Serenity.sessionVariableCalled("FiterValue").toString()
						.equalsIgnoreCase(oSeleniumUtils
								.get_TextFrom_Locator((StringUtil.replace(oIUHomePage.FilterValuesValidation, "sValue",
										Serenity.sessionVariableCalled("FiterValue").toString())))));

		Assert.assertTrue("Proposal Types value is not displayed",
				Serenity.sessionVariableCalled("FiterValue").toString()
						.equalsIgnoreCase(oSeleniumUtils
								.get_TextFrom_Locator((StringUtil.replace(oIUHomePage.FilterValuesValidation, "sValue",
										Serenity.sessionVariableCalled("FiterValue").toString())))));

		Assert.assertTrue("Filter Task Status value is not displayed",
				Serenity.sessionVariableCalled("FiterValue").toString()
						.equalsIgnoreCase(oSeleniumUtils
								.get_TextFrom_Locator((StringUtil.replace(oIUHomePage.FilterValuesValidation, "sValue",
										Serenity.sessionVariableCalled("FiterValue").toString())))));

		Assert.assertTrue("Task value is not displayed",
				Serenity.sessionVariableCalled("FiterValue").toString()
						.equalsIgnoreCase(oSeleniumUtils
								.get_TextFrom_Locator((StringUtil.replace(oIUHomePage.FilterValuesValidation, "sValue",
										Serenity.sessionVariableCalled("FiterValue").toString())))));

		Assert.assertTrue("Rules With ARDs value is not displayed",
				Serenity.sessionVariableCalled("FiterValue").toString()
						.equalsIgnoreCase(oSeleniumUtils
								.get_TextFrom_Locator((StringUtil.replace(oIUHomePage.FilterValuesValidation, "sValue",
										Serenity.sessionVariableCalled("FiterValue").toString())))));

	}

	@Step
	public void validateRemoveCode(String sReviewCode) throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.LabelTag, "sValue", "Remove Code"));

		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

		// Check Generate Remove window
		verify("Generate Remove Code Proposal PopUp should Display", oSeleniumUtils.is_WebElement_Displayed(
				StringUtil.replace(oIUHomePage.h4Tag, "sValue", "Generate Remove Code Proposal")));

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		// Enter value in Code to be removed and click search
		oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.Code_Removed, sReviewCode);

		oGenericUtils.gfn_Click_On_Object("button", " Search ");

		oGenericUtils.gfn_Click_String_object_Xpath("//b[text()='  " + sReviewCode + "  ']/preceding-sibling::input");

		oGenericUtils.gfn_Click_String_object_Xpath("//input[@ng-model='$parent.relatedToUpdate']");

		// oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag,
		// "sValue", " Search "));

		// Enter comments in Rationale Comment
		oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.Rational_Comment, "Autotext");

		// Click on Generate REmove Code
		oGenericUtils.gfn_Click_On_Object("button", "Generate Remove Code Proposals");

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		boolean bln = oSeleniumUtils.is_WebElement_Displayed(
				(StringUtil.replace(oIUHomePage.pTag, "sValue", " Manual proposal is created successfully")));

		if (bln == true) {

			// Verify Manual Proposal Created success message
			verify("Manual proposal is created successfully message should be display",
					oGenericUtils.gfn_Verify_String_Object_Exist((StringUtil.replace(oIUHomePage.pTag, "sValue",
							" Manual proposal is created successfully"))));

			oGenericUtils.gfn_Click_On_Object("button", "Ok");

		} else {

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			boolean blnError = oSeleniumUtils
					.is_WebElement_Displayed((StringUtil.replace(oIUHomePage.h3Tag, "sValue", "Error")));

			if (blnError == true) {

				oGenericUtils.gfn_Click_On_Object("button", "Ok");
			}

			String[] sCodes = { "01991", "0010M" };

			for (int i = 0; i < sCodes.length; i++) {

				// Enter value in Code to be removed and click search
				oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.Code_Removed, sCodes[i]);

				oGenericUtils.gfn_Click_On_Object("button", " Search ");

				oGenericUtils
						.gfn_Click_String_object_Xpath("//b[text()='  " + sCodes[i] + "  ']/preceding-sibling::input");

				// Enter comments in Rationale Comment
				oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.Rational_Comment, "Autotext");

				// Click on Generate REmove Code
				oGenericUtils.gfn_Click_On_Object("button", "Generate Remove Code Proposals");

				boolean blnMessage = oSeleniumUtils.is_WebElement_Displayed(
						(StringUtil.replace(oIUHomePage.pTag, "sValue", " Manual proposal is created successfully")));

				if (blnMessage == true) {

					// Verify Manual Proposal Created success message
					verify("Manual proposal is created successfully message should be display",
							oGenericUtils.gfn_Verify_String_Object_Exist((StringUtil.replace(oIUHomePage.pTag, "sValue",
									" Manual proposal is created successfully"))));

					oGenericUtils.gfn_Click_On_Object("button", "Ok");

					break;
				}

				if (blnError == true) {

					oGenericUtils.gfn_Click_On_Object("button", "Ok");
				}
			}

		}

		oGenericUtils.gfn_Click_On_Object("button", "x");

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void columnStatus(String sCloumnName, String sColumnValue) {
		switch (sCloumnName) {
		case "Status":
			oSeleniumUtils.get_TextFrom_Locator(StringUtil.replace(oIUHomePage.Column_Status, "sValue", "5"));
			break;
		case "Task":
			Assert.assertTrue("Task status is not valid", sColumnValue.equalsIgnoreCase(
					oSeleniumUtils.get_TextFrom_Locator(StringUtil.replace(oIUHomePage.Column_Status, "sValue", "4"))));
			break;
		case "Assignee":
			oSeleniumUtils.get_All_Text_from_Locator(StringUtil.replace(oIUHomePage.Assignee_Status, "sValue", "7"));
			break;
		}

	}

	@Step
	public void userShouldBeAbleSeeSelectedRuleVersion() {

		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		System.out
				.println("Get text from Locator" + oSeleniumUtils.get_TextFrom_Locator(oIUHomePage.FinalRule_Version));

		Assert.assertTrue("Rule Version is not Displayed",
				oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.FinalRule_Version));

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void navigateToMyTasksAndGoToRuleInInstance(String sRole, String sTaskName, String sInstancetype)
			throws InterruptedException {

		oIUHomePage.closeAllTabs();

		userNavigateToIUInstancesScreen("MyTasks");

		switch (sRole) {
		case "Admin PO Scrub":

			Assert.assertTrue("Work Queue Validation in My Task is not Displayed as expected", oSeleniumUtils
					.is_WebElement_Displayed(Serenity.sessionVariableCalled("TaskandInstnaceName").toString()));

			break;

		default:

			clickTaskByInstanceName(sTaskName, sInstancetype);

			oIUHomePage.go_To_Rule(Serenity.sessionVariableCalled("MidRuleVersion").toString());

		}

	}

	@Step
	public void completeAllQAReviewsAndUpdateQARule() throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "QA"));

		oGenericUtils.gfn_Verify_String_Object_Exist(oIUHomePage.QAReviewSegment);

		List<WebElement> rows = getDriver().findElements(By.xpath(oIUHomePage.QA_Review_Table));

		String sReviewSegValue = null;

		for (int i = 2; i <= rows.size(); i++) {

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "QA"));

			String sVal = Integer.toString(i);

			sReviewSegValue = oSeleniumUtils
					.get_TextFrom_Locator(StringUtil.replace(oIUHomePage.QA_Review_Table_Item, "sValue", sVal));

			// if (!(sReviewSegValue == "Editorials")) {
			if (!(sReviewSegValue.equalsIgnoreCase("Editorials"))) {

				oSeleniumUtils
						.Click_given_Locator(StringUtil.replace(oIUHomePage.QA_Review_Table_Item, "sValue", sVal));

				SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			}

			switch (sReviewSegValue) {
			case "BW And/BWO Or Logic":
				oGenericUtils.gfn_Verify_Object_Exist("h3", "Billed With And/Billed Without Or Code Clarification");

				if (!(oIUHomePage.NewBilled_Radio_button.isSelected())) {

					oSeleniumUtils.Click_given_WebElement(oIUHomePage.NewBilled_Radio_button);
				}
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
				oSeleniumUtils.Click_given_Locator(oIUHomePage.Complete_QA_Review_Sub);
				userClickOnReviewSuccessMsg(sReviewSegValue);
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

				break;

			case "Impact Code List":

				SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

				int icount = getDriver().findElements(By.xpath(oIUHomePage.ImpactReviewCodeList)).size();

				if (icount > 0) {

					if (!(oIUHomePage.ImpactChkName.isSelected())) {
						oSeleniumUtils.highlightElement(oIUHomePage.ImpactReviewCodeAll);
						oSeleniumUtils.Click_given_WebElement(oIUHomePage.ImpactReviewCodeAll);
						SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
					} else {
						System.out.println("Radio button is not availble");
					}
				}

				oSeleniumUtils.highlightElement(oIUHomePage.Complete_QA_Review);
				SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
				if (icount > 0) {
					oSeleniumUtils.Click_given_Locator(oIUHomePage.QAReview_Category);
				}
				oSeleniumUtils.highlightElement(oIUHomePage.Complete_QA_Review);
				oSeleniumUtils.highlightElement(oIUHomePage.Complete_QA_Review);
				oSeleniumUtils.Click_given_Locator(oIUHomePage.Complete_QA_Review);
				userClickOnReviewSuccessMsg(sReviewSegValue);

				oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "QA"));

				break;

			case "Potential Conflicts":
			case "Retire Rule - System Determined":

				oSeleniumUtils.Click_given_Locator(oIUHomePage.Complete_QA_Review);
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
				int iMsg = getDriver()
						.findElements(By.xpath(
								StringUtil.replace(oIUHomePage.pTag, "sValue", " Review completed successfully.")))
						.size();

				if (iMsg > 0) {

					userClickOnReviewSuccessMsg(sReviewSegValue);
				}

				break;

			default:

				if (!(sReviewSegValue.equalsIgnoreCase("Editorials"))) {
					oSeleniumUtils.Click_given_Locator(oIUHomePage.Complete_QA_Review);
					userClickOnReviewSuccessMsg(sReviewSegValue);
					oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "QA"));
					break;
				}

			}

		}

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "QA"));

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.AnchorTag, "sValue", "Editorials"));

		SeleniumUtils.switchWindowUsingWindowCount(5, 2, getDriver());

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(oIUHomePage.Complete_QA_Review_Editorial);

		userClickOnReviewSuccessMsg(sReviewSegValue);

		// getDriver().close(); // Close current page

		SeleniumUtils.switchWindowUsingWindowCount(3, 1, getDriver());

		getDriver().switchTo().defaultContent();

		// update_QA_Rule();

	}

	@Step
	public void userClickOnReviewSuccessMsg(String sReviewSegValue) throws InterruptedException {

		oGenericUtils.gfn_Verify_Object_Exist("p", " Review completed successfully.");

		Assert.assertTrue("Review completed Successfully", oSeleniumUtils.is_WebElement_Displayed(
				StringUtil.replace(oIUHomePage.pTag, "sValue", ProjectVariables.Review_Success)));

		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		verify("Review Completed and Segement Name is  :" + sReviewSegValue, true);

	}

	@Step
	public void completeAllTestingReviews() throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oGenericUtils.gfn_Verify_Object_Exist("span", "BRAT Test Results");

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Test"));

		String sReviewSegValue = null;

		List<WebElement> rows = getDriver().findElements(By.xpath(oIUHomePage.Testing_Review_Table));

		for (int i = 2; i <= rows.size(); i++) {

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Test"));

			// String sVal = Integer.toString(i);

			sReviewSegValue = oSeleniumUtils
					.get_TextFrom_Locator(oIUHomePage.GetDynamicXPath("TESTINGREVIEW TABLEITEM", i));
			System.out.println(sReviewSegValue);
			// if (!(sReviewSegValue == "Editorials")) {
			if (!(sReviewSegValue.equalsIgnoreCase("Editorials"))) {

				oSeleniumUtils.Click_given_Locator(oIUHomePage.GetDynamicXPath("TESTINGREVIEW TABLEITEM", i));
				SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			}

			switch (sReviewSegValue) {
			case "BW And/BWO Or Logic":
				oGenericUtils.gfn_Verify_Object_Exist("h3", "Billed With And/Billed Without Or Code Clarification");

				if (!(oIUHomePage.NewBilled_Radio_button.isSelected())) {

					oSeleniumUtils.Click_given_WebElement(oIUHomePage.NewBilled_Radio_button);
				}
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
				oGenericUtils.gfn_Click_On_Object("label", "Complete Testing Review");

				userClickOnReviewSuccessMsg(sReviewSegValue);
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

				break;

			case "Impact Code List":

				SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

				int icount = getDriver()
						.findElements(By
								.xpath("//div[@id='jqgh_impactCodeListGrid_testingReview10']//input[@id='impactSelectAll']"))
						.size();

				if (icount > 0) {

					if (!(oIUHomePage.ImpactChkboxTesting.isSelected())) {
						oSeleniumUtils.highlightElement(oIUHomePage.TestingImpactReviewCodeAll);
						oSeleniumUtils.Click_given_WebElement(oIUHomePage.TestingImpactReviewCodeAll);
						SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
					} else {
						System.out.println("Radio button is not availble");
					}
				}

				oSeleniumUtils.highlightElement(oIUHomePage.Complete_Test_Review);
				SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
				oSeleniumUtils.Click_given_Locator(oIUHomePage.QAReview_Category);
				oSeleniumUtils.highlightElement(oIUHomePage.Complete_Test_Review);
				oSeleniumUtils.Click_given_Locator(oIUHomePage.Complete_Test_Review);
				userClickOnReviewSuccessMsg(sReviewSegValue);
				oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Test"));

				break;

			default:

				if (!(sReviewSegValue.equalsIgnoreCase("Editorials"))) {
					oSeleniumUtils.Click_given_Locator(oIUHomePage.Complete_Test_Review);
					userClickOnReviewSuccessMsg(sReviewSegValue);
					oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Test"));
					break;
				}

			}

		}

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Test"));

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.AnchorTag, "sValue", "Editorials"));

		SeleniumUtils.switchWindowUsingWindowCount(5, 2, getDriver());

		// oIUHomePage.wait_Untill_ElementExists(oIUHomePage.Complete_QA_Review);

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oGenericUtils.gfn_Click_String_object_Xpath(
				oIUHomePage.GetDynamicXPathWithString("CONTAINS LABEL", "Complete Testing Review", ""));

		userClickOnReviewSuccessMsg(sReviewSegValue);

		getDriver().close(); // Close current page

		SeleniumUtils.switchWindowUsingWindowCount(3, 1, getDriver());

		getDriver().switchTo().defaultContent();

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);
		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "QA"));
		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Test"));

		oGenericUtils.gfn_Click_String_object_Xpath(
				oIUHomePage.GetDynamicXPathWithString("CONTAINS LABEL", "Testing Complete", ""));
		oGenericUtils.gfn_Verify_Object_Exist("h3", "Testing Completed");
		oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.TestingCompleteComments, "Test Reviews");
		oGenericUtils.gfn_Click_On_Object("button", "Testing Completed");
		oGenericUtils.gfn_Verify_Object_Exist("h3", "WARNING");
		oGenericUtils.gfn_Verify_Object_Exist("p", "Are you sure this RMR for the rule should be Closed? Continue?");
		oGenericUtils.gfn_Click_On_Object("button", "Yes");
		oGenericUtils.gfn_Verify_Object_Exist("h3", "Testing Complete");
		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		getDriver().switchTo().defaultContent();

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

	}

	@Step
	public void completeCPMReview(String sAgreePayer) throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		// Click on Config is not disabled
		String status_Config_Btn = getDriver().findElement(By.xpath(oIUHomePage.Config)).getAttribute("disabled");
		System.out.println(status_Config_Btn);

		// if (!((status_Config_Btn).equalsIgnoreCase("true"))) {
		if (status_Config_Btn == null) {
			oSeleniumUtils.Click_given_Locator(oIUHomePage.Config);
			oGenericUtils.gfn_Verify_Object_Exist("h4", "CPM Additional Configuration Approval");
			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			List<WebElement> CPM_Decesion_List = getDriver()
					.findElements(By.xpath(StringUtil.replace(oIUHomePage.tdTag, "sValue", "Select")));
			System.out.println(CPM_Decesion_List.size());

			if (CPM_Decesion_List.size() <= 4) {
				for (int i = 0; i < CPM_Decesion_List.size(); i++) {
					CPM_Decesion_List.get(i).click();
					oSeleniumUtils.select_Given_Value_From_DropDown_Using_StringLocator(
							oIUHomePage.GetDynamicXPath("CPM_PAYERS_DECESION", i + 1), sAgreePayer);
					oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.GetDynamicXPath("CPM_DECESION_COMMENTS", i + 1),
							"CPM Config Comments");
				}
			} else {
				oSeleniumUtils.Click_given_Locator(oIUHomePage.CPMPayerTreePlus);

				List<WebElement> CPM_Decesion = getDriver()
						.findElements(By.xpath(StringUtil.replace(oIUHomePage.tdTag, "sValue", "Select")));
				for (int j = 1; j < CPM_Decesion.size(); j++) {

					System.out.println(CPM_Decesion.size());
					CPM_Decesion.get(j).click();

				}

				List<WebElement> CPM_Decesion_Dropdown = getDriver()
						.findElements(By.xpath(("//select[@name='agree10']")));
				for (int k = 1; k <= CPM_Decesion_Dropdown.size(); k++) {

					oSeleniumUtils.select_Given_Value_From_DropDown_Using_StringLocator(
							oIUHomePage.GetDynamicXPath("CPM_PAYERS_DECESION", k), sAgreePayer);
					oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.GetDynamicXPath("CPM_DECESION_COMMENTS", k),
							"CPM Config Comments");

				}
			}

			oGenericUtils.gfn_Click_On_Object("button", "CPM Decision Complete");
			oGenericUtils.gfn_Verify_Object_Exist("p", " Successfully saved additional config approvals.");
			oGenericUtils.gfn_Click_On_Object("button", "Ok");
			getDriver().switchTo().defaultContent();
			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);
		}

		getDriver().switchTo().defaultContent();

		SeleniumUtils.defaultWait(ProjectVariables.MID_SLEEP);
		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);
		oSeleniumUtils
				.Click_given_Locator((StringUtil.replace(oIUHomePage.LabelTag, "sValue", "CPM Decision Complete")));

		oGenericUtils.gfn_Click_On_Object("span", "OK");
		oGenericUtils.gfn_Verify_Object_Exist("p", " CPM Decisions completed successfully");
		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		if (sAgreePayer.equalsIgnoreCase("RetireRule")) {
			// String status_CPM_Decision_Btn =
			// getDriver().findElement(By.xpath(StringUtil.replace(oIUHomePage.LabelTag,
			// "sValue", "Retire Rule"))).getAttribute("disabled");

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.LabelTag, "sValue", "Retire Rule"));
			oGenericUtils.gfn_Click_On_Object("button", "CPM Decision Complete");
			oGenericUtils.gfn_Click_On_Object("button", "Ok");

		}

		getDriver().switchTo().defaultContent();
		SeleniumUtils.defaultWait(ProjectVariables.MID_SLEEP);
	}

	@Step
	public void retireRuleCPM() {

		String status_CPM_Decision_Btn = getDriver()
				.findElement(By.xpath(StringUtil.replace(oIUHomePage.LabelTag, "sValue", "Retire Rule")))
				.getAttribute("disabled");
		if (((status_CPM_Decision_Btn) == "true")) {

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.LabelTag, "sValue", "Retire Rule"));
			oSeleniumUtils
					.Click_given_Locator(StringUtil.replace(oIUHomePage.LabelTag, "sValue", "CPM Decision Complete"));

		}

	}

	@Step
	public void authorize_CPM_Decisions() {

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.AnchorTag, "sValue", "CPM Summaries"));

		authorizeDecisions();

	}

	@Step
	public void update_QA_Rule() throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Summaries"));
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "QA"));
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oSeleniumUtils.highlightElement(oIUHomePage.Update_Rule);
		oSeleniumUtils.Click_given_Locator(oIUHomePage.Update_Rule);

		oGenericUtils.gfn_Verify_String_Object_Exist(oIUHomePage.Msg_Rule_Update);
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		Assert.assertTrue("Rule updated Successfully",
				oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.Msg_Rule_Update));
		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Ok"));

		oSeleniumUtils.highlightElement(oIUHomePage.Stub_RMR_ID);
		Serenity.setSessionVariable("Stub_RMR_ID").to(oIUHomePage.Stub_RMR_ID.getText());
		System.out.println(Serenity.sessionVariableCalled("Stub_RMR_ID").toString());

		oSeleniumUtils.highlightElement(oIUHomePage.QA_Review_Completed);
		oSeleniumUtils.Click_given_Locator(oIUHomePage.QA_Review_Completed);

		oGenericUtils.gfn_Verify_Object_Exist("p", " QA Review Completed");
		Assert.assertTrue("Rule updated Successfully", oSeleniumUtils
				.is_WebElement_Displayed(StringUtil.replace(oIUHomePage.pTag, "sValue", " QA Review Completed")));
		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Ok"));

		getDriver().switchTo().defaultContent();

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

	}

	@Step
	public void selectRule(String arg1) throws InterruptedException {

		switch (arg1) {

		case "RuleID":

//			Serenity.setSessionVariable("MidRuleVersion").to("14718.42");
			oIUHomePage.go_To_Rule(Serenity.sessionVariableCalled("MidRuleVersion").toString());

			if (!(oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(oIUHomePage.MyTaskRuleVersion, "sValue",
					Serenity.sessionVariableCalled("MidRuleVersion").toString())))) {

				oIUHomePage.go_To_Rule(Serenity.sessionVariableCalled("MidRuleVersion").toString());

				oGenericUtils.gfn_Click_String_object_Xpath(StringUtils.replace(oIUHomePage.MyTaskRuleVersion, "sValue",
						Serenity.sessionVariableCalled("MidRuleVersion").toString()));

			} else {

				oGenericUtils.gfn_Click_String_object_Xpath(StringUtils.replace(oIUHomePage.MyTaskRuleVersion, "sValue",
						Serenity.sessionVariableCalled("MidRuleVersion").toString()));

			}

			verify("MidRule Version is :" + Serenity.sessionVariableCalled("MidRuleVersion").toString(), true);

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			break;
		case "Filterd-RuleID":

			oIUHomePage.go_To_Rule(Serenity.sessionVariableCalled("MidRuleVersion").toString());

			break;
		case "Reportportal":

			int iEditorialWarning = getDriver()
			.findElements(
					By.xpath(StringUtils.replace(oIUHomePage.h3Tag, "sValue", "Editorial changes observed")))
			.size();

			if (iEditorialWarning > 0) {
		
			}else {
				verify("Object is not availble :" , false);
		
			}

			break;
			
		
		

		}

	}

	@Step
	public void ruleIDSelected(String sRule) {

	}

	@Step
	public void completeAuthorizeDecisions(String sTaskType) {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		switch (sTaskType) {

		case "Summaries":

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Summaries"));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oSeleniumUtils.highlightElement("//label[contains(text(),'Authorize Decisions')]");
			oSeleniumUtils.Click_given_Locator("//label[contains(text(),'Authorize Decisions')]");

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oIUHomePage.wait_Untill_ElementExists(oIUHomePage.Authorize_Decisions);

			Assert.assertTrue("Confirmation Warning should be displayed",
					oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.Authorize_Decisions));
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Yes"));
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			Assert.assertTrue("Confirmation Warning should be displayed",
					oSeleniumUtils.is_WebElement_Displayed(StringUtil.replace(oIUHomePage.pTag, "sValue",
							" Rule moved to next step in rule review process successfully.")));
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Ok"));

			break;

		case "CPM Summaries":

			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

			SeleniumUtils.defaultWait(ProjectVariables.MID_SLEEP);

			oSeleniumUtils
					.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "CPM Summaries"));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_THREAD_WAIT);

			oSeleniumUtils.Click_given_Locator("//label[contains(text(),'Authorize Decisions')]");

			oIUHomePage.wait_Untill_ElementExists(oIUHomePage.Authorize_Decisions);

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			Assert.assertTrue("Confirmation Warning should be displayed",
					oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.Authorize_Decisions));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Yes"));

			getDriver().switchTo().defaultContent();

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			break;
		}
	}

	@Step
	public void verify(String sDescription, boolean blnStatus) {

		GenericUtils.Verify(sDescription, blnStatus);
	}

	public void validateColumnStatus(String sColumnName, String sColumnValue) {

		String sValue = oIUHomePage.get_Column_Value(sColumnName);

		boolean sStatus = sColumnValue.equalsIgnoreCase(sValue);

		verify("Column Value Expected :" + sColumnValue + " and Actual is " + sValue, sStatus);
	}

	@Step
	public void clickInstanceinAdmin(String sInstancetype) throws InterruptedException {

		Serenity.setSessionVariable("AdminInstance").to(sInstancetype);

		String sInstance = null;

		switch (sInstancetype.trim()) {
		case "FINAL MD DEL":
		case "FINAL PO DEL":
			sInstance = ProjectVariables.FinalMDInstance;
			verify("Final MD Del Instance Name: " + sInstance, true);
			Serenity.setSessionVariable("AdminInstance").to(sInstance);
			break;

		case "FINAL MD SIM":
			sInstance = ProjectVariables.FinalMDInstance;
			break;

		case "PRELIM MD DEL":
		case "PRELIM PO DEL":
			sInstance = ProjectVariables.PrelimMDInstance;
			verify("Prelim MD Del Instance Name: " + sInstance, true);
			break;

		case "FINAL MD DEL-Subsequent":
			sInstance = ProjectVariables.FinalMDInstanceSubsequent;
			verify("Prelim MD Del Instance Name: " + sInstance, true);
			break;

		case "AE PRELIM MD DEL":
			sInstance = ProjectVariables.AEPrelimInstance;
			break;
		}

		oSeleniumUtils.Click_given_Locator(StringUtils.replace(oIUHomePage.AdminInstance, "sValue", sInstance));

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.Actions);

		// oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.SpanTag,
		// "sValue", "Rule Review"));

		oGenericUtils.gfn_Click_On_Object("span", "Rule Review");

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		// verify("Rules count is displaying at the side of pagination in
		// Admin",
		// oGenericUtils.gfn_Verify_String_Object_Exist("(//div[contains(text(),'Displaying
		// 1')])[2]"));

	}

	@Step
	public void getRuleFromWorkQueueForInstance(String sWorkQueue, String sInstance) throws InterruptedException {

		switch (sWorkQueue) {

		case "EditorialWorkQueue":

			Serenity.setSessionVariable("EditorialRuleVersion")
					.to(oSeleniumUtils.get_TextFrom_Locator(oIUHomePage.RuleVersionTxt));

			System.out.println(
					"Editorial Rule Version: " + Serenity.sessionVariableCalled("EditorialRuleVersion").toString());

			ruleIDSelected(Serenity.sessionVariableCalled("EditorialRuleVersion").toString());

			break;

		case "QAWorkQueue":

			Serenity.setSessionVariable("QARuleVersion")
					.to(oSeleniumUtils.get_TextFrom_Locator(oIUHomePage.RuleVersionTxt));

			System.out.println("QA Rule Version: " + Serenity.sessionVariableCalled("QARuleVersion").toString());

			ruleIDSelected(Serenity.sessionVariableCalled("QARuleVersion").toString());

			break;

		case "CPMWorkQueue":

			Serenity.setSessionVariable("CPMRuleVersion")
					.to(oSeleniumUtils.get_TextFrom_Locator(oIUHomePage.RuleVersionTxt));

			System.out.println("CPM Rule Version: " + Serenity.sessionVariableCalled("CPMRuleVersion").toString());

			ruleIDSelected(Serenity.sessionVariableCalled("CPMRuleVersion").toString());

			break;

		case "TestingWorkQueue":

			Serenity.setSessionVariable("TestingRuleVersion")
					.to(oSeleniumUtils.get_TextFrom_Locator(oIUHomePage.RuleVersionTxt));

			System.out.println(
					"Testing Rule Version: " + Serenity.sessionVariableCalled("TestingRuleVersion").toString());

			ruleIDSelected(Serenity.sessionVariableCalled("TestingRuleVersion").toString());

			break;

		default:
			Assert.assertTrue("Case Value is not matched for function getRuleFromWorkQueueForInstance", false);

		}

		oIUHomePage.closeAllTabs();

		userNavigateToIUInstancesScreen("MyTasks");

	}

	@Step
	public void veifyRuleInWorkQueueForInstance(String sWorkQueue, String sInstance) throws InterruptedException {

		oIUHomePage.closeAllTabs();

		switch (sWorkQueue) {

		case "EditorialWorkQueue":

			clickTaskByInstanceName("Editorial Review Work Queue", sInstance);

			oIUHomePage.go_To_Rule(Serenity.sessionVariableCalled("EditorialRuleVersion").toString());

			oGenericUtils.gfn_Verify_Object_Exist("div",
					Serenity.sessionVariableCalled("EditorialRuleVersion").toString());

			ruleIDSelected(Serenity.sessionVariableCalled("EditorialRuleVersion").toString());

			Assert.assertTrue("EditorialWorkQueue Rule Version is as expected after releasing the rules",
					Serenity.sessionVariableCalled("EditorialRuleVersion").toString()
							.equalsIgnoreCase(oSeleniumUtils
									.get_TextFrom_Locator(StringUtils.replace(oIUHomePage.DivTag, "sValue",
											Serenity.sessionVariableCalled("EditorialRuleVersion").toString()))));

			oGenericUtils.gfn_Click_On_Object("div", Serenity.sessionVariableCalled("EditorialRuleVersion").toString());

			break;

		case "QAWorkQueue":

			clickTaskByInstanceName("QA Review Work Queue", sInstance);

			oIUHomePage.go_To_Rule(Serenity.sessionVariableCalled("QARuleVersion").toString());

			oGenericUtils.gfn_Verify_Object_Exist("div", Serenity.sessionVariableCalled("QARuleVersion").toString());

			ruleIDSelected(Serenity.sessionVariableCalled("QARuleVersion").toString());

			Assert.assertTrue("QAWorkQueue Rule Version is as expected after releasing the rules",
					Serenity.sessionVariableCalled("QARuleVersion").toString().equalsIgnoreCase(
							oSeleniumUtils.get_TextFrom_Locator(StringUtils.replace(oIUHomePage.DivTag, "sValue",
									Serenity.sessionVariableCalled("QARuleVersion").toString()))));

			oGenericUtils.gfn_Click_On_Object("div", Serenity.sessionVariableCalled("QARuleVersion").toString());
			break;

		case "CPMWorkQueue":

			clickTaskByInstanceName("CPM Review Work Queue", sInstance);

			oIUHomePage.go_To_Rule(Serenity.sessionVariableCalled("CPMRuleVersion").toString());

			oGenericUtils.gfn_Verify_Object_Exist("div", Serenity.sessionVariableCalled("CPMRuleVersion").toString());

			ruleIDSelected(Serenity.sessionVariableCalled("CPMRuleVersion").toString());

			Assert.assertTrue("CPMorkQueue Rule Version is as expected after releasing the rules",
					Serenity.sessionVariableCalled("CPMRuleVersion").toString().equalsIgnoreCase(
							oSeleniumUtils.get_TextFrom_Locator(StringUtils.replace(oIUHomePage.DivTag, "sValue",
									Serenity.sessionVariableCalled("CPMRuleVersion").toString()))));

			oGenericUtils.gfn_Click_On_Object("div", Serenity.sessionVariableCalled("CPMRuleVersion").toString());
			break;

		case "TestingWorkQueue":

			clickTaskByInstanceName("Testing Review Work Queue", sInstance);

			oIUHomePage.go_To_Rule(Serenity.sessionVariableCalled("TestingRuleVersion").toString());

			oGenericUtils.gfn_Verify_Object_Exist("div",
					Serenity.sessionVariableCalled("TestingRuleVersion").toString());

			ruleIDSelected(Serenity.sessionVariableCalled("TestingRuleVersion").toString());

			Assert.assertTrue("TestingWorkQueue Rule Version is as expected after releasing the rules",
					Serenity.sessionVariableCalled("TestingRuleVersion").toString()
							.equalsIgnoreCase(oSeleniumUtils
									.get_TextFrom_Locator(StringUtils.replace(oIUHomePage.DivTag, "sValue",
											Serenity.sessionVariableCalled("TestingRuleVersion").toString()))));

			oGenericUtils.gfn_Click_On_Object("div", Serenity.sessionVariableCalled("TestingRuleVersion").toString());

			break;

		default:
			Assert.assertTrue("Case Value is not matched for function veifyRuleInWorkQueueForInstance", false);

		}

	}

	@Step
	public void selectRuleWithMultiPayer(String sPayerQuantity) throws InterruptedException {

		ArrayList<String> sArrPayers = new ArrayList<String>();

		Serenity.setSessionVariable("PayerShots").to(sArrPayers);

		int sPayersQuantity = 0;

		System.out
				.println("Rule Version no in Multipayer" + Serenity.sessionVariableCalled("MidRuleVersion").toString());

		switch (sPayerQuantity) {

		case "TWOCPMPAYERSDB":
		case "ONECPMPAYERSDB":
		case "ONECPMOBSOLETE":
		case "MULTIPAYERSINGLECPM":

			String sQuery = "select PAYERS_4_RULE from IRDM.interp_rule_details where   MID_RULE_DOT_VERSION='"
					+ Serenity.sessionVariableCalled("MidRuleVersion").toString() + "' and INTERP_RULE_KEY in"
					+ "(select interp_rule_key from IRDM.interp_rules where impact_key in "
					+ "(select impact_key from irdm.interp_impacts where update_instance_key ="
					+ "(select update_instance_key from IRDM.update_instances where update_instance_name ='"
					+ Serenity.sessionVariableCalled("IUInstanceName").toString() + "')))";

			System.out.println("Query is : " + sQuery);

			String sPayerList = DBUtils.executeSQLQuery(sQuery);
			System.out.println("Query Status: " + sPayerList);

			String[] ArrPayers = sPayerList.split(",");

			for (int i = 0; i < ArrPayers.length; i++) {
				String sAllPayers = ArrPayers[i].trim().split(" ")[0];
				System.out.println(sAllPayers);

				sArrPayers.add(sAllPayers);
			}

			if (sPayerQuantity.equalsIgnoreCase("TWOCPMPAYERSDB")) {

				sPayersQuantity = 2;
			}

			if (sPayerQuantity.equalsIgnoreCase("ONECPMPAYERSDB")) {

				sPayersQuantity = 1;
			}

			if (sPayerQuantity.equalsIgnoreCase("ONECPMOBSOLETE")) {

				sPayersQuantity = 1;
			}

			if (sPayerQuantity.equalsIgnoreCase("MULTIPAYERSFIRSTCPM")) {

				sPayersQuantity = 1;
			}

			if (sPayerQuantity.equalsIgnoreCase("MULTIPAYERSINGLECPM")) {

				sPayersQuantity = 11;
			}

			break;

		case "MULTIPAYERSFIRSTCPM":
			break;

		default:

			if (sPayerQuantity.equalsIgnoreCase("2")) {

				sPayersQuantity = 2;
			}

			if (sPayerQuantity.equalsIgnoreCase("1")) {

				sPayersQuantity = 1;
			}

			if (sPayerQuantity.equalsIgnoreCase("11")) {

				sPayersQuantity = 11;
			}

			sPayersQuantity = Integer.parseInt(sPayerQuantity);
			System.out.println(sPayersQuantity);

			List<WebElement> sRowCount = getDriver()
					.findElements(By.xpath("(//table[@class = 'GEFT4QHBI3C'])[last()]/tbody[2]/tr"));

			for (int i = 0; i < sRowCount.size(); i++) {

				String sXPayer = oIUHomePage.GetDynamicXPath("RULE PAYERS", i + 1);
				String sPayer = getDriver().findElement(By.xpath(sXPayer)).getText();
				String[] ArrPayers2 = sPayer.split(",");

				if (ArrPayers2.length > sPayersQuantity) {

					String sXRule = oIUHomePage.GetDynamicXPath("RULE VERSION", i + 1);
					String sRule = getDriver().findElement(By.xpath(sXRule)).getText();
					Serenity.setSessionVariable("MidRuleVersion").to(sRule);

					verify("MidRule Version is :" + Serenity.sessionVariableCalled("MidRuleVersion").toString(), true);
					System.out.println("Rule No : " + Serenity.sessionVariableCalled("MidRuleVersion").toString());

					for (int j = 0; j < ArrPayers2.length; j++) {
						String sAllPayers2 = ArrPayers2[j].trim().split(" ")[0];
						System.out.println(sAllPayers2);

						sArrPayers.add(sAllPayers2);

					}
					break;

				}
			}

			break;
		}

		oIUHomePage.userNavigateToAdministrationTab();

		oSeleniumUtils
				.Click_given_Locator(StringUtil.replace(oIUHomePage.AnchorTag, "sValue", "Assignment Configuration"));
		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		if ((oSeleniumUtils.is_WebElement_Present(StringUtil.replace(oIUHomePage.DivTag, "sValue", "OK")))) {
			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.DivTag, "sValue", "OK"));
		}

		oGenericUtils.gfn_Click_On_Object("span", "CPM Payer Assignments");
		// oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.SpanTag,
		// "sValue", "CPM Payer Assignments"));
		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		switch (sPayersQuantity) {

		case 2:
			for (int k = 0; k < sArrPayers.size(); k++) {
				System.out.println(sArrPayers.get(k));

				if (k == 0) {
					oIUHomePage.assignDifferentUserToPayer("", sArrPayers.get(k), "iht_ittest03");
				} else if (k == 1) {
					oIUHomePage.assignDifferentUserToPayer("", sArrPayers.get(k), "iht_ittest02");
				} else {
					oIUHomePage.assignDifferentUserToPayer("", sArrPayers.get(k), "iht_ittest01");
				}
			}
			break;

		case 11:
			for (int k = 0; k < sArrPayers.size(); k++) {
				if (k == 0) {
					oIUHomePage.assignDifferentUserToPayer("", sArrPayers.get(k), "iht_ittest01");
				} else {
					oIUHomePage.assignDifferentUserToPayer("", sArrPayers.get(k), "iht_ittest01");
				}
			}
			break;

		default:
			for (int k = 0; k < sArrPayers.size(); k++) {
				if (k == 0) {
					oIUHomePage.assignDifferentUserToPayer("", sArrPayers.get(k), "iht_ittest01");
				} else {
					oIUHomePage.assignDifferentUserToPayer("", sArrPayers.get(k), "iht_ittest02");
				}
			}
			break;
		}

		System.out.println("sPayerQuantity value :" + sPayerQuantity);

		if (sPayerQuantity.equalsIgnoreCase("ONECPMOBSOLETE")) {

			// for (int l = 0; l < sArrPayers.size(); l++) {

			oIUHomePage.checkObsoletePayer("", sArrPayers.get(1));

			// }

		}

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.CPM_Payer_Save);

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		if ((oSeleniumUtils.is_WebElement_Present(oIUHomePage.CPM_Payer_Yes))) {
			oSeleniumUtils.Click_given_Locator(oIUHomePage.CPM_Payer_Yes);
			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.CPM_Saving_Load);
		}

		oIUHomePage.closeAllTabs();

	}

	@Step
	public void requires_Presentation() throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);
		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.LabelTag, "sValue", "Requires Presentation"));

		oGenericUtils.gfn_Verify_Object_Exist("h4", "CPM: Change Requires Presentation Status");

		oSeleniumUtils.Click_given_WebElement(oIUHomePage.RequirePresentationChkbox);

		oSeleniumUtils.Click_given_Locator(oIUHomePage.Save_Button);

		oGenericUtils.gfn_Verify_Object_Exist("p",
				"All the decisions recorded for the payer will be lost and sensitivities will be refreshed once a payer is set to Requires Presentation.");

		oSeleniumUtils.Click_given_Locator(oIUHomePage.Continue_Button);
		getDriver().switchTo().defaultContent();

		SeleniumUtils.defaultWait(ProjectVariables.MID_SLEEP);
	}

	@Step
	public void userAssignPayerToCPMUser(String arg1) {

		oIUHomePage.assignDifferentUserToPayer("", "wwww", "iht_ittest01");
		oIUHomePage.assignDifferentUserToPayer("", "abcd1234", "iht_ittest02");
	}

	@Step
	public void click_on_AdminScrubTaskType(String sUser, String sReAssignee, String arg3) throws InterruptedException {

		oGenericUtils.gfn_Click_String_object_Xpath(
				StringUtils.replace(oIUHomePage.ViewAllAdminScrubCheckBox, "sValue", sUser));

		oGenericUtils.gfn_Click_On_Object("div", "Reassign");

		oGenericUtils.gfn_Verify_Object_Exist("div", "Selecte User to ReAssign");

		oSeleniumUtils
				.Click_given_Locator((StringUtils.replace(oIUHomePage.ReassignUseridChek, "sValue", sReAssignee)));

		oGenericUtils.gfn_Click_On_Object("div", "OK");

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

	}

	@Step
	public void enterFinalMDConfigComments() throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);
		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Summaries"));
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		oGenericUtils.gfn_Click_On_Object("span", "Configurations Summary");
		oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.ConfigSummaryInstruction,
				ProjectVariables.ConfigSummaryComments);
		oSeleniumUtils.Click_given_WebElement(oIUHomePage.ConfigSummarySaveButton);
		oGenericUtils.gfn_Verify_Object_Exist("h3", "Success");
		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Ok"));
		getDriver().switchTo().defaultContent();

		// }

	}

	@Step
	public void verifyColumnValueAsPerDBInAdminMD(String sColumnName) throws Exception {

		List<String> sColumnNameList = Arrays.asList(sColumnName.split(";"));

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oGenericUtils.gfn_Verify_Object_Exist("a", "Process Candidates");

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.AllRulesRadioBtn);

		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

		List<WebElement> iAdminScrubRowcount = getDriver().findElements(By.xpath(oIUHomePage.AdminMDScrubRows));

		System.out.println("AdminRowCount : " + iAdminScrubRowcount.size());

		for (int i = 2; i <= 3; i++) {

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			String sAdminMDScrubRule = getDriver()
					.findElement(By.xpath(oIUHomePage.getDynamicXPathAdminMD("MidRule", i))).getText();

			String sAdminMDScrubRuleVersion = getDriver()
					.findElement(By.xpath(oIUHomePage.getDynamicXPathAdminMD("RuleVersion", i))).getText();

			Serenity.setSessionVariable("MidRuleVersion").to(sAdminMDScrubRule + "." + sAdminMDScrubRuleVersion);

			System.out.println(Serenity.sessionVariableCalled("MidRuleVersion").toString());

			ruleIDSelected(Serenity.sessionVariableCalled("MidRuleVersion"));

			for (int j = 0; j < sColumnNameList.size(); j++) {

				String sDBValue = DBUtils.executeSQLQuery(oIUHomePage
						.getDynamicQuery(sColumnNameList.get(j), sAdminMDScrubRule, sAdminMDScrubRuleVersion).trim());

				String sDBValueText = StringUtils.replace(sDBValue, "  ", " ");

				String[] sAdimMDScrubColumns = { "Group", "From-To", "Override", "Sim Mappings",
						"Sub Rule Description - Resolved", "Sub Rule Description - Resolved",
						"Sub Rule Description - Unresolved", "Sub Rule Notes", "Sub Rule Script",
						"Sub Rule Rationale" };

				oIUHomePage.scrollToColumn("span", sAdimMDScrubColumns);

				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

				String sColumnData = get_CellText_from_given_Column(sColumnNameList.get(j), i);

				System.out.println("Pop Data :" + sColumnData);

				verifyAdminScrubCellData(sColumnData, sDBValueText);

			}

			String[] sColoumns = { "Sub Rule Description - Resolved", "Sim Mappings", "Override", "From-To", "Group",
					"Topic", "ARD", "Version" };

			oIUHomePage.scrollToMidRuleColumn("span", sColoumns);

		}

	}

	@Step
	public void navigateToPageOnAdminMDScrubScreen(String sUser, String sPage) throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		switch (sPage) {

		case "All rules":

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.AllRulesRadioBtn);

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			break;
		case "Only unscrubbed rules":

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.UnSubscribedRulesRadioBtn);

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			break;
		case "Retrieve Candidates":

			oGenericUtils.gfn_Verify_Object_Exist("a", sPage);

			oGenericUtils.gfn_Click_On_Object("a", sPage);

			break;
		case "Retrieve Non Candidates":

			oGenericUtils.gfn_Verify_Object_Exist("a", sPage);

			oGenericUtils.gfn_Click_On_Object("a", sPage);

			break;

		case "Admin View":

			oGenericUtils.gfn_Verify_Object_Exist("a", sPage);

			oGenericUtils.gfn_Click_On_Object("a", sPage);

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			break;

		default:
		}
		getDriver().switchTo().defaultContent();

	}

	@Step
	public void clickOnOneOfTheCellWhichContainsFieldText(String sColumn, String sFieldText) throws Exception {

		verifyColumnValueAsPerDBInAdminMD(sColumn);

	}

	@Step
	public void verifyAdminScrubCellData(String sCellPopText, String sColumnDBValue) {

		boolean sStatus = sCellPopText.equalsIgnoreCase(sColumnDBValue);

		verify("Column Value Expected : " + sColumnDBValue + "\n" + "Actual Value is : " + sCellPopText, sStatus);

	}

	@Step
	public String get_CellText_from_given_Column(String sColumn, int iRowno) throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		String sXColVal = oIUHomePage.getDynamicXPathAdminMD(sColumn, iRowno);

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.Doubleclick(sXColVal);

		oGenericUtils
				.gfn_Verify_String_Object_Exist(StringUtils.replace(oIUHomePage.CellPopTextHeader, "sValue", sColumn));

		oGenericUtils.gfn_Verify_String_Object_Exist(StringUtils.replace(oIUHomePage.CellPopText, "sValue", sColumn));

		String sVal = oSeleniumUtils
				.get_TextFrom_Locator(StringUtils.replace(oIUHomePage.CellPopText, "sValue", sColumn.trim()));

		oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.AdminPopCellSearchBox, sVal);

		oGenericUtils.gfn_Verify_String_Object_Exist(oIUHomePage.HighlightColor);

		oGenericUtils
				.gfn_Click_String_object_Xpath(StringUtils.replace(oIUHomePage.CloseCellPopup, "sValue", "Sub Rule"));

		return sVal;

	}

	@Step
	public void rulesWhichWereMarkedAsEitherCandidatesOrNonCandidatesByShouldNotBeReleased(String arg1)
			throws InterruptedException {

		userNavigateToIUInstancesScreen("Admin PO Scrub Candidates");

	}

	@Step
	public void get_Admin_Column_Value(String sColumn, String sStatus) {

		String sActualColValue = null;
		boolean sFlag = false;
		List<WebElement> AdminStatus = getDriver().findElements(By.xpath(oIUHomePage.Admin_Col_Status));
		for (int i = 0; i < AdminStatus.size(); i++) {
			sActualColValue = AdminStatus.get(i).getText().toString();
			System.out.println("Rule Review Status: " + AdminStatus.get(i).getText().toString());
			if (AdminStatus.get(i).getText().equals(sStatus)) {
				verify("Column Value Expected :" + sStatus + " and Actual is " + sActualColValue, true);
				System.out.println("Acutal Column Value: " + AdminStatus.get(i).getText().toString());
				sFlag = true;
				break;
			}
		}

		if (sFlag == false) {

			verify("Column Value Expected :" + sStatus + " and Actual is " + sActualColValue, false);
		}

	}

	@Step
	public void validateSplitpayerInstruction(String sInstruction, String sManualRMRID) {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oSeleniumUtils.highlightElement(oIUHomePage.Manual_RMR_ID);

		Serenity.setSessionVariable("Work_Order_Code")
				.to(oSeleniumUtils.get_TextFrom_Locator(oIUHomePage.Manual_RMR_ID).toString());

		getDriver().switchTo().defaultContent();

		System.out.println("Manual RMR ID: " + Serenity.sessionVariableCalled("Work_Order_Code").toString());

		String sQuery = "Select INSTRUCTIONS from AUTH_MASTER.WORK_ORDER_LOG where WORK_ORDER_CODE = '"
				+ Serenity.sessionVariableCalled("Work_Order_Code").toString() + "'";

		System.out.println("Query: " + sQuery);

		String sManualRMRInstr = DBUtils.executeSQLQuery(sQuery);

		boolean sStatus = sManualRMRInstr.equalsIgnoreCase(sInstruction);

		verify("Column Value Expected :" + sInstruction + " and Actual is " + sInstruction, sStatus);

		System.out.println(sManualRMRInstr);

	}

	@Step
	public void cpmSystemProposal(String sProposalType, String sDecision, String sCPMModify)
			throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oGenericUtils.gfn_Verify_Object_Exist("label", "CPM System Proposals:");

		// SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		if (sCPMModify.equals("Modify Decision")) {

			oGenericUtils.gfn_Click_On_Object("label", "Modify Decisions");

		}
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		// oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.SystemProposalType,
		// sProposalType);

		// SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.select_Given_Value_From_DropDown_Using_StringLocator(oIUHomePage.CPMDecision_Select, sDecision);

		if (sDecision.equals("Modify")) {

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.System_Proposal_DOS, "sValue", "1_dos"));

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oSeleniumUtils.Enter_given_Text_Element(
					StringUtil.replace(oIUHomePage.System_Proposal_DOS, "sValue", "toDOSDate"),
					ProjectVariables.SystemProposalDOS);

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.SpanTag, "sValue", "Ok"));

		}

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.SystemProposalCPM, ProjectVariables.SystemProposalComments);

		if (sCPMModify.equals("NotSaveProposals")) {
			System.out.println("User selected not to save proposals");
		} else {
			oSeleniumUtils.Click_given_Locator(oIUHomePage.SystemProposalSave);
			oGenericUtils.gfn_Click_On_Object("button", "Ok");
		}

		getDriver().switchTo().defaultContent();
	}

	@Step
	public void createInstance(String sNewInstancName, String sAdminOPS, String sAdminMD) throws InterruptedException {

		List<String> sAdminMDList = Arrays.asList(sAdminMD.split(";"));

		List<String> sAdminOPSList = Arrays.asList(sAdminOPS.split(";"));

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oGenericUtils.gfn_Verify_Object_Exist("div", "Add");

		oGenericUtils.gfn_Click_On_Object("div", "Add");

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		if (sNewInstancName.equalsIgnoreCase("Random")) {

			Serenity.setSessionVariable("NewInstanceName")
					.to("CPTPOAutoIV" + GenericUtils.generate_Random_Number_for_Given_Range(1000));

			System.out.println(Serenity.sessionVariableCalled("NewInstanceName").toString());

		} else {

			Serenity.setSessionVariable("NewInstanceName").to(sNewInstancName);
		}

		verify("Newly Created Instance Name:  " + Serenity.sessionVariableCalled("NewInstanceName").toString(), true);
		oSeleniumUtils.Enter_given_Text_Element(
				StringUtils.replace(oIUHomePage.NewInstanceCreate, "sValue", "Instance Name:"),
				Serenity.sessionVariableCalled("NewInstanceName").toString());

		oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.DescriptionTxt,
				Serenity.sessionVariableCalled("NewInstanceName").toString());

		String sTodaysDate = GenericUtils.getDate_given_Format();

		oSeleniumUtils.Enter_given_Text_Element(
				StringUtils.replace(oIUHomePage.NewInstanceCreate, "sValue", "Effective Date:"), sTodaysDate);

		oSeleniumUtils.Enter_given_Text_Element(
				StringUtils.replace(oIUHomePage.NewInstanceCreate, "sValue", "Update Type:"),
				ProjectVariables.UpdateType);

		for (int i = 0; i < sAdminOPSList.size(); i++) {

			oSeleniumUtils.Click_given_Locator(
					"//label[text()='Admin OPS:']/parent::div//label[text()='" + sAdminOPSList.get(i) + "']/..//input");

		}

		oSeleniumUtils.Enter_given_Text_Element(
				StringUtils.replace(oIUHomePage.NewInstanceCreate, "sValue", "Library PRM:"),
				ProjectVariables.LibCustomPRM);

		oSeleniumUtils.Enter_given_Text_Element(
				StringUtils.replace(oIUHomePage.NewInstanceCreate, "sValue", "Custom PRM:"),
				ProjectVariables.LibCustomPRM);

		for (int i = 0; i < sAdminMDList.size(); i++) {

			oSeleniumUtils.Click_given_Locator(
					"//label[text()='Admin PO:']/parent::div//label[text()='" + sAdminMDList.get(i) + "']/..//input");

		}

		oGenericUtils.gfn_Verify_Object_Exist("div", "Save");

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oGenericUtils.gfn_Click_On_Object("div", "Save");

		oGenericUtils.gfn_Verify_Object_Exist("div", "Administration - Interpretive Update Instances");

		oGenericUtils.gfn_Click_On_Object("div", "Yes");

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		oGenericUtils.gfn_Verify_Object_Exist("div", "Administration - Interpretive Update Instances");

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oGenericUtils.gfn_Click_On_Object("div", "OK");

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oIUHomePage.closeAllTabs();

	}

	@Step
	public void completeGroupTaskSegmentsInMyTask(String sNewInstance) throws InterruptedException {

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.GroupTaskTab);

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		if (sNewInstance.equalsIgnoreCase("Random")) {
			sNewInstance = Serenity.sessionVariableCalled("NewInstanceName").toString();
		}

		int iInstanceCount = getDriver()
				.findElements(By.xpath(StringUtils.replace(oIUHomePage.InstanceCount, "sValue", sNewInstance))).size();

		for (int i = 1; i <= iInstanceCount; i++) {

			oGenericUtils
					.gfn_Click_String_object_Xpath(oIUHomePage.getDynamicXpathCheckBoxInGroupTask(sNewInstance, i));

		}

		oGenericUtils.gfn_Verify_Object_Exist("div", "Claim Task");

		oGenericUtils.gfn_Click_On_Object("div", "Claim Task");

		oGenericUtils.gfn_Verify_Object_Exist("div", "Claim Tasks");

		oGenericUtils.gfn_Click_On_Object("div", "Claim Tasks");

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oGenericUtils.gfn_Click_On_Object("div", "OK");

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		oGenericUtils.gfn_Click_On_Object("span", "Individual Tasks - iht_ittest01");

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

	}

	@Step
	public void completeAssignments(String sTaskType, String sUser) throws Exception {

		switch (sTaskType) {

		case "Review DC Assignments":

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			oGenericUtils.gfn_Verify_Object_Exist("div", "Review Tasks");

			oGenericUtils.gfn_Click_On_Object("div", "OK");

			oGenericUtils.gfn_Click_On_Object("span", "Assignment Exceptions");

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			int iAEOKBtn2 = getDriver().findElements(By.xpath("//div[text()='OK']")).size();

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			if (iAEOKBtn2 > 0) {

				oGenericUtils.gfn_Click_On_Object("div", "OK");
			}

			oGenericUtils.gfn_Click_On_Object("span", "Decision Capture Assignments");

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oGenericUtils.gfn_Verify_String_Object_Exist(oIUHomePage.DCCaptureCheckBox);

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.DCCaptureCheckBox);

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.DCBluckAssign);

			if (sUser.equals("ASSIGNMENT EXCEPTIONS")) {

				oSeleniumUtils.Enter_given_Text_Element(
						StringUtils.replace(oIUHomePage.DecisionCapturePopUP, "sValue", "Preliminary Review:"),
						"iht_ittest01");

				oSeleniumUtils.Enter_given_Text_Element(
						StringUtils.replace(oIUHomePage.DecisionCapturePopUP, "sValue", "Preliminary Peer Review:"),
						"iht_ittest02");

				oSeleniumUtils.Enter_given_Text_Element(
						StringUtils.replace(oIUHomePage.DecisionCapturePopUP, "sValue", "Final Review:"),
						"iht_ittest03");

				oSeleniumUtils.Enter_given_Text_Element(
						StringUtils.replace(oIUHomePage.DecisionCapturePopUP, "sValue", "Final Peer Review:"),
						"iht_ittest04");

				oSeleniumUtils.Enter_given_Text_Element(
						StringUtils.replace(oIUHomePage.DecisionCapturePopUP, "sValue", "Editorial:"), "iht_ittest05");

				oSeleniumUtils.Enter_given_Text_Element(
						StringUtils.replace(oIUHomePage.DecisionCapturePopUP, "sValue", "QA:"), "iht_ittest06");

				oSeleniumUtils.Enter_given_Text_Element(
						StringUtils.replace(oIUHomePage.DecisionCapturePopUP, "sValue", "Configuration:"),
						"iht_ittest07");

				oSeleniumUtils.Enter_given_Text_Element(
						StringUtils.replace(oIUHomePage.DecisionCapturePopUP, "sValue", "Test:"), "iht_ittest08");

				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			} else {

				oSeleniumUtils.Enter_given_Text_Element(
						StringUtils.replace(oIUHomePage.DecisionCapturePopUP, "sValue", "Preliminary Review:"),
						ProjectVariables.PreliminaryReview);

				oSeleniumUtils.Enter_given_Text_Element(
						StringUtils.replace(oIUHomePage.DecisionCapturePopUP, "sValue", "Preliminary Peer Review:"),
						ProjectVariables.PreliminaryPeerReview);

				oSeleniumUtils.Enter_given_Text_Element(
						StringUtils.replace(oIUHomePage.DecisionCapturePopUP, "sValue", "Final Review:"),
						"iht_ittest01");

				oSeleniumUtils.Enter_given_Text_Element(
						StringUtils.replace(oIUHomePage.DecisionCapturePopUP, "sValue", "Final Peer Review:"),
						ProjectVariables.FinalPeerReview);

				oSeleniumUtils.Enter_given_Text_Element(
						StringUtils.replace(oIUHomePage.DecisionCapturePopUP, "sValue", "Editorial:"),
						ProjectVariables.Editorial);

				oSeleniumUtils.Enter_given_Text_Element(
						StringUtils.replace(oIUHomePage.DecisionCapturePopUP, "sValue", "QA:"), ProjectVariables.QA);

				oSeleniumUtils.Enter_given_Text_Element(
						StringUtils.replace(oIUHomePage.DecisionCapturePopUP, "sValue", "Configuration:"),
						ProjectVariables.Configuration);

				oSeleniumUtils.Enter_given_Text_Element(
						StringUtils.replace(oIUHomePage.DecisionCapturePopUP, "sValue", "Test:"),
						ProjectVariables.Testing);

				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			}

			oGenericUtils.gfn_Click_On_Object("div", "OK");

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oGenericUtils.gfn_Click_On_Object("div", "Complete DC Assignment Review");

			oGenericUtils.gfn_Verify_Object_Exist("div", "Complete Task");

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.ClaimTask);

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oGenericUtils.gfn_Click_On_Object("div", "OK");

			oGenericUtils.gfn_Verify_Object_Exist("div", "Copy Global Assignments");

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.DCSave);

			oGenericUtils.gfn_Verify_Object_Exist("div", "Yes");

			oGenericUtils.gfn_Click_On_Object("div", "Yes");

			oGenericUtils.gfn_Verify_Object_Exist("div", "OK");

			oGenericUtils.gfn_Click_On_Object("div", "OK");

			oIUHomePage.closeAllTabs();

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			break;

		case "Review UI Assignments":

			SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oGenericUtils.gfn_Verify_Object_Exist("div", "Review Tasks");

			oGenericUtils.gfn_Click_On_Object("div", "OK");

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oGenericUtils.gfn_Verify_Object_Exist("div", "Complete UI Assignment Review");

			oGenericUtils.gfn_Click_On_Object("div", "Complete UI Assignment Review");

			oGenericUtils.gfn_Verify_Object_Exist("div", "Complete Task");

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.ClaimTask);

			oGenericUtils.gfn_Verify_Object_Exist("div", "OK");

			oGenericUtils.gfn_Click_On_Object("div", "OK");

			oIUHomePage.closeAllTabs();

			break;

		case "Review Obsolete Payers":

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			oGenericUtils.gfn_Verify_Object_Exist("div", "Review Tasks");

			oGenericUtils.gfn_Click_On_Object("div", "OK");

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oGenericUtils.gfn_Click_On_Object("div", "Complete CPM Assignment Review");

			oGenericUtils.gfn_Verify_Object_Exist("div", "Complete Task");

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.ClaimTask);

			oGenericUtils.gfn_Click_On_Object("div", "OK");

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oGenericUtils.gfn_Click_On_Object("div", "Complete Obsolete Payer Review");

			oGenericUtils.gfn_Verify_Object_Exist("div", "Complete Task");

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.ClaimTask);

			oGenericUtils.gfn_Click_On_Object("div", "OK");

			oIUHomePage.closeAllTabs();

			break;
		case "Review PO Assignments":

			SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oGenericUtils.gfn_Verify_Object_Exist("div", "Review Tasks");

			oGenericUtils.gfn_Click_On_Object("div", "OK");

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oGenericUtils.gfn_Verify_Object_Exist("div", "Complete PO Assignment Review");

			oGenericUtils.gfn_Click_On_Object("div", "Complete PO Assignment Review");

			oGenericUtils.gfn_Verify_Object_Exist("div", "Complete Task");

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.ClaimTask);

			oGenericUtils.gfn_Click_On_Object("div", "OK");

			oIUHomePage.closeAllTabs();

			break;

		case "Assignment Exceptions":

			int sSheetNo = 0;

			SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			if (sUser.equals("0")) {

				sSheetNo = 0;
			} else {
				sSheetNo = 1;
			}

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			completeAssignmentExceptions("", sSheetNo);

			oIUHomePage.closeAllTabs();

			break;

		default:
			Assert.assertTrue("Case value is not matched for completeAssignments()", false);

		}

	}

	@Step
	public void returnRule(String sCurrentStatus, String sReturnTo) throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oSeleniumUtils.Click_given_Locator(oIUHomePage.ReturnRule);

		System.out.println("" + sCurrentStatus + "Return To:");

		oGenericUtils.gfn_Verify_Object_Exist("label", "" + sCurrentStatus + " Return To:");

		oSeleniumUtils.select_Given_Value_From_DropDown_Using_StringLocator(oIUHomePage.EditorialReturnSelect,
				sReturnTo);

		oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.EditorialReturnReason,
				StringUtils.replace(ProjectVariables.ReturnComments, "sValue", sCurrentStatus));

		oGenericUtils.gfn_Click_On_Object("button", "Return Rule");

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		String sActualPopText = oSeleniumUtils.get_TextFrom_Locator("//div[@id='sameSimCommentsConfirmation']//p");

		String sActualText = sActualPopText.replaceAll("\\s{2,}", " ");

		System.out.println("ActualText" + sActualText);

		String sExpected = "Rule is being returned to " + sReturnTo + " for clarification";

		// String sExpected="Rule is being returned to "+sReturnTo+" for
		// clarification of " + sCurrentStatus + " concern. Continue?";

		System.out.println("Expected" + sExpected);

		verify("Rule is being returned to " + sReturnTo + " for clarification" + "Expected Text:" + sExpected
				+ "Actual Text:" + sActualText, sActualText.contains(sExpected));

		oGenericUtils.gfn_Click_On_Object("button", "Yes");

		oGenericUtils.gfn_Verify_Object_Exist("p", " Rule Returned successfully.");

		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		getDriver().switchTo().defaultContent();

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

	}

	@Step
	public void insert_rules_of_with_Query(String arg1) throws InterruptedException {

		oGenericUtils.gfn_Click_On_Object("div", "Refresh");

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		oGenericUtils
				.gfn_Verify_String_Object_Exist(StringUtils.replace(oIUHomePage.AdminInstanceSamSim, "sValue", arg1));

		DBUtils.executeSQLQuery(StringUtils.replace(ProjectVariables.AdminScrubQuery, "sValue", arg1));

		DBUtils.insertSQLQuery(StringUtils.replace(ProjectVariables.AdminScrubQuery, "sValue", arg1));

		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

		oGenericUtils.gfn_Click_String_object_Xpath(StringUtils.replace(oIUHomePage.AdminInstance, "sValue", arg1));

		oGenericUtils.gfn_Verify_Object_Exist("div", "Request Impact Analysis");

		oGenericUtils.gfn_Click_On_Object("div", "Request Impact Analysis");

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.RequesImpactAnalysis);

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		oGenericUtils.gfn_Verify_Object_Exist("div", "OK");

		oGenericUtils.gfn_Click_On_Object("div", "OK");

	}

	@Step
	public void clickTaskWithNewInstanceName(String sTaskName, String sInstance) throws InterruptedException {
		// Serenity.setSessionVariable("NewInstanceName").to("TestMDToPO");

		if (sInstance.equalsIgnoreCase("Random")) {
			sInstance = Serenity.sessionVariableCalled("NewInstanceName").toString();
		}

		if (!(sTaskName.equalsIgnoreCase("Check Assignments"))) { // check any
																	// in-progress
			String sTaskType = StringUtil.replace(oIUHomePage.TaskandInstance, "sValue", sTaskName);

			String strInstance = StringUtil.replace(sTaskType, "sInstance", sInstance);

			oGenericUtils.gfn_Verify_String_Object_Exist(strInstance);

			oGenericUtils.gfn_Click_String_object_Xpath(strInstance);

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		} else {

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			// oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			int iInProgressItems = getDriver()
					.findElements(By.xpath("//div[text()='" + sInstance + "']/../../td//div[text()='In Progress']"))
					.size();
			if (iInProgressItems > 0) {
				// oGenericUtils.gfn_Click_String_object_Xpath(
				// "//div[text()='" + sInstance +
				// "']/../../td//div[text()='Review UI Assignments']");

				if (getDriver().findElements(By
						.xpath("(//div[text()='" + sInstance + "']/../../td//div[contains(text(),' Assignments')])[1]"))
						.size() > 0) {
					oGenericUtils.gfn_Click_String_object_Xpath(
							"(//div[text()='" + sInstance + "']/../../td//div[contains(text(),' Assignments')])[1]");
				}

				if (getDriver()
						.findElements(By.xpath(
								"(//div[text()='" + sInstance + "']/../../td//div[contains(text(),' Payers')])[1]"))
						.size() > 0) {
					oGenericUtils.gfn_Click_String_object_Xpath(
							"(//div[text()='" + sInstance + "']/../../td//div[contains(text(),' Payers')])[1]");
				}

				// SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

				oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

				SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

				oGenericUtils.gfn_Verify_Object_Exist("div", "Review Tasks");

				oGenericUtils.gfn_Click_On_Object("div", "OK");

				SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

				if (getDriver().findElements(By.xpath("//div[text()='Complete UI Assignment Review']")).size() > 0) {
					oGenericUtils.gfn_Click_On_Object("div", "Complete UI Assignment Review");
				}
				if (getDriver().findElements(By.xpath("//div[text()='Complete DC Assignment Review']")).size() > 0) {
					oGenericUtils.gfn_Click_On_Object("div", "Complete DC Assignment Review");
				}

				if (getDriver().findElements(By.xpath("//div[text()='Complete CPM Assignment Review']")).size() > 0) {
					oGenericUtils.gfn_Click_On_Object("div", "Complete CPM Assignment Review");
				}
				if (getDriver().findElements(By.xpath("//div[text()='Complete Obsolete Payer Review']")).size() > 0) {
					oGenericUtils.gfn_Click_On_Object("div", "Complete Obsolete Payer Review");
				}
				SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
				oGenericUtils.gfn_Verify_Object_Exist("div", "Complete Task");
				SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
				oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.ClaimTask);

				oGenericUtils.gfn_Verify_Object_Exist("div", "OK");

				oGenericUtils.gfn_Click_On_Object("div", "OK");

				oIUHomePage.closeAllTabs();

			} // end of loop of check in progress

		}
	}

	@Step
	public void navigateToAdminRuleReviewValidateColValues(String sRole, String sInstanceType, String sColoumnName,
			String sColumnValue) throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oIUHomePage.closeAllTabs();

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oGenericUtils.gfn_Click_On_Object("span", "Administration");

		oGenericUtils.gfn_Click_On_Object("a", "Interpretive Update Instances");

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		clickInstanceinAdmin(sInstanceType);

		applyAdminActiveFilters(sColoumnName, sColumnValue);

		if (sRole.contains("iht_ittest")) {

			sColoumnName = "Assignee";
			sColumnValue = sRole;

		}

		validateRuleReviewColumnValues(sColoumnName, sColumnValue);

	}

	@Step
	public void validateRuleReviewColumnValues(String SColName, String sColVal) {

		int rowVal = 0;
		String vFlag = null;
		String sColValue = null;
		if (SColName.equalsIgnoreCase("Assignee")) {
			rowVal = 8;
		}

		if (SColName.equalsIgnoreCase("Task")) {
			rowVal = 5;
		}

		if (SColName.equalsIgnoreCase("Status")) {
			rowVal = 6;
		}

		List<WebElement> ColStatus = getDriver()
				.findElements(By.xpath(oIUHomePage.GetDynamicXPath("RULEREVIEW COLVALUE", rowVal)));

		for (int i = 0; i < ColStatus.size(); i++) {

			sColValue = ColStatus.get(i).getText().toString();

			if (ColStatus.get(i).getText().equals(sColVal)) {
				verify("Column Value Expected :" + sColVal + " and Actual is " + sColValue, true);
				System.out.println("Acutal Column Value: " + ColStatus.get(i).getText().toString());
				vFlag = "Y";
			}

		}

		if (vFlag.equalsIgnoreCase("Y")) {
			verify("Column Value Expected :" + sColVal + "  and Actual is :" + sColValue, true);
		} else {
			verify("Column Value Expected :" + sColVal + "  and Actual is :" + sColValue, false);

		}

	}

	@Step
	public void validateRuleReviewColRowValues(String sRowNo, String sTask, String sStatus, String Assignee) {

		String vFlag = "N";
		String sAssigneeColVal = null;

		List<WebElement> ColStatus = getDriver()
				.findElements(By.xpath(oIUHomePage.GetDynamicXPath("RULEREVIEW COLVALUE", 8)));
		List<WebElement> RuleStatus = getDriver()
				.findElements(By.xpath(oIUHomePage.GetDynamicXPath("RULEREVIEW COLVALUE", 6)));

		List<WebElement> TaskStatus = getDriver()
				.findElements(By.xpath(oIUHomePage.GetDynamicXPath("RULEREVIEW COLVALUE", 5)));

		for (int i = 0; i < ColStatus.size(); i++) {
			sAssigneeColVal = ColStatus.get(i).getText().toString();

			if (ColStatus.get(i).getText().equals(Assignee)) {
				verify("Column Value Expected :" + Assignee + " and Actual is " + sAssigneeColVal, true);
				System.out.println("Acutal Column Value: " + ColStatus.get(i).getText().toString());

				if (RuleStatus.get(i).getText().equals(sStatus)) {
					verify("Column Value Expected :" + sStatus + " and Actual is "
							+ RuleStatus.get(i).getText().toString(), true);
				}

				// else {
				// verify("Column Value Expected :" + sStatus + " and Actual is
				// "
				// + RuleStatus.get(i).getText().toString(), false);
				// }

				if (TaskStatus.get(i).getText().equals(sTask)) {
					verify("Column Value Expected :" + sTask + " and Actual is "
							+ TaskStatus.get(i).getText().toString(), true);
				}

				// else {
				// verify("Column Value Expected :" + sTask + " and Actual is "
				// + TaskStatus.get(i).getText().toString(), false);
				// }

				vFlag = "Y";
			}
		}

		if (vFlag.equalsIgnoreCase("Y")) {
			verify("Column Value Expected :" + Assignee + "and Actual is :" + sAssigneeColVal, true);
		} else {
			verify("Column Value Expected :" + Assignee + "and Actual is :" + sAssigneeColVal, false);

		}

	}

	@Step
	public void applyAdminActiveFilters(String sFilterName, String sFilterValue) throws InterruptedException {

		List<String> sFilterNameList = Arrays.asList(sFilterName.split(";"));

		List<String> sFilterValueList = Arrays.asList(sFilterValue.split(";"));

		for (int i = 0; i < sFilterNameList.size(); i++) {

			switch (sFilterNameList.get(i)) {
			case "Library Status":

				oSeleniumUtils.Click_given_Locator(
						StringUtil.replace(oIUHomePage.ActiveFiterDropDwnBtn, "sValue", "Library Status:"));

				System.out.println(sFilterValueList.get(i));

				oGenericUtils.gfn_Click_String_object_Xpath(
						StringUtil.replace(oIUHomePage.LibraryAdminFilter, "sValue", sFilterValueList.get(i)));

				oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

				break;

			case "ProposalTypes":

				oSeleniumUtils.Click_given_Locator(
						StringUtil.replace(oIUHomePage.ActiveFiterDropDwnBtn, "sValue", "Proposal Types:"));

				oGenericUtils.gfn_Click_String_object_Xpath(
						StringUtil.replace(oIUHomePage.ApplyAdminFilterValues, "sValue", sFilterValueList.get(i)));

				oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

				break;

			case "FilterTaskStatus":
				oSeleniumUtils.Click_given_Locator(
						StringUtil.replace(oIUHomePage.ActiveFiterDropDwnBtn, "sValue", "Task Status:"));

				oGenericUtils.gfn_Click_String_object_Xpath(
						StringUtil.replace(oIUHomePage.ApplyAdminFilterValues, "sValue", sFilterValueList.get(i)));

				oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

				break;

			case "Task":
				SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
				oSeleniumUtils
						.Click_given_Locator(StringUtil.replace(oIUHomePage.ActiveFiterDropDwnBtn, "sValue", "Tasks:"));

				oGenericUtils.gfn_Click_String_object_Xpath(
						StringUtil.replace(oIUHomePage.ApplyAdminFilterValues, "sValue", sFilterValueList.get(i)));

				oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);
				break;

			case "Assignee":
				SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
				oSeleniumUtils.Click_given_Locator(
						StringUtil.replace(oIUHomePage.ActiveFiterDropDwnBtn, "sValue", "Assignees:"));

				oGenericUtils.gfn_Click_String_object_Xpath(
						StringUtil.replace(oIUHomePage.ApplyFilterValues, "sValue", sFilterValueList.get(i)));

				oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

				break;

			case "MedicalPolicies":

				System.out.println(sFilterValueList.get(i));
				oSeleniumUtils.Enter_given_Text_Element(
						"//div[@class='GEFT4QHBCW']//label[text()='Medical Policies:']/following-sibling::div[1]//div/div//table//tr//td//input",
						sFilterValueList.get(i));
				oGenericUtils.gfn_Click_On_Object("div", sFilterValueList.get(i));
				oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

				break;

			case "Topics":

				System.out.println(sFilterValueList.get(i));
				oSeleniumUtils.Enter_given_Text_Element(
						"//div[@class='GEFT4QHBCW']//label[text()='Topics:']/following-sibling::div[1]//div/div//table//tr//td//input",
						sFilterValueList.get(i));
				oGenericUtils.gfn_Click_On_Object("div", sFilterValueList.get(i));
				oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

				break;

			case "Decision Points":

				System.out.println(sFilterValueList.get(i));
				oSeleniumUtils.Enter_given_Text_Element(
						"//div[@class='GEFT4QHBCW']//label[text()='Decision Points:']/following-sibling::div[1]//div/div//table//tr//td//input",
						sFilterValueList.get(i));
				oGenericUtils.gfn_Click_On_Object("div", sFilterValueList.get(i));
				oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

				break;

			default:
				Assert.assertTrue("Active Filter cases are not matched for function applyAdminActiveFilters()", false);

			}
		}
	}

	@Step
	public void clickOnInstanceInAdminAndNavigateToRuleReviewPage(String arg1) throws InterruptedException {

		// clickInstanceinAdmin(arg1);
		navigateRuleReviewPage(arg1);

	}

	@Step
	public void clickOnReportHyperLinkInRuleReviewPage() throws InterruptedException {

		oGenericUtils.gfn_Click_On_Object("div", "Report");

		SeleniumUtils.switchWindowUsingWindowCount(5, 2, getDriver());

		System.out.println(getDriver().getTitle());

	}

	@Step
	public void verifyAdminScrubReportHyperlinkIsDisplayed(String arg1) throws InterruptedException {

		oGenericUtils.gfn_Click_On_Object("div", "Admin PO Scrub Report");

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		// getDriver().switchTo().defaultContent();

		oSeleniumUtils.SwitchToFrame(oIUHomePage.IUReportFrame);

		oGenericUtils.gfn_Click_On_Object("span", "Review");

		oGenericUtils.gfn_Click_String_object_Xpath(
				"(//span[text()='Review'])[2]/ancestor::div//div[@ng-if='grid.options.enableSelectAll']");

		oGenericUtils.gfn_Click_On_Object("button", "Apply Filter");

		oGenericUtils.gfn_Verify_String_Object_Exist("//div[.='A']//span//img");

		/*
		 * oGenericUtils.gfn_Click_On_Object("a", "Filters");
		 * 
		 * oGenericUtils.gfn_Verify_String_Object_Exist(
		 * "//div[.='A']//span//img");
		 * 
		 */

	}

	@Step
	public void completeAllEditorialReviews(String sOperation) throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oGenericUtils.gfn_Verify_String_Object_Exist(oIUHomePage.EditorialSegment);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Editorial"));

		String sReviewSegValue = null;
		List<WebElement> rows = getDriver().findElements(By.xpath(oIUHomePage.Editorial_Review_Table));
		// List<WebElement> rows =
		// getDriver().findElements(By.xpath(oIUHomePage.QA_Review_Table));

		System.out.println(rows);

		for (int i = 2; i <= rows.size(); i++) {

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Editorial"));

			String sVal = Integer.toString(i);

			sReviewSegValue = oSeleniumUtils
					.get_TextFrom_Locator(StringUtil.replace(oIUHomePage.Editorial_Review_Table_Item, "sValue", sVal));

			// if (!(sReviewSegValue == "Editorials")) {
			if (!(sReviewSegValue.equalsIgnoreCase("Editorials"))) {

				oSeleniumUtils.Click_given_Locator(
						StringUtil.replace(oIUHomePage.Editorial_Review_Table_Item, "sValue", sVal));

			}

			switch (sReviewSegValue) {
			case "BW And/BWO Or Logic":
				oGenericUtils.gfn_Verify_Object_Exist("h3", "Billed With And/Billed Without Or Code Clarification");

				if (!(oIUHomePage.NewBilled_Radio_button.isSelected())) {

					oSeleniumUtils.Click_given_WebElement(oIUHomePage.NewBilled_Radio_button);
				}
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

				oGenericUtils.gfn_Click_On_Object("Label", "Complete Editorial Review");
				userClickOnReviewSuccessMsg(sReviewSegValue);
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

				break;

			case "Impact Code List":

				SeleniumUtils.defaultWait(ProjectVariables.MID_SLEEP);

				int icount = getDriver()
						.findElements(By
								.xpath("//div[@id='jqgh_impactCodeListGrid_editorialReview10']//input[@id='impactSelectAll']"))
						.size();

				if (icount > 0) {

					/////// trinat;h///////
					if (!(oIUHomePage.ImpactChkNameEditorial.isSelected())) {
						oSeleniumUtils.highlightElement(oIUHomePage.EditorialImpactReviewCodeAll);
						oSeleniumUtils.Click_given_WebElement(oIUHomePage.EditorialImpactReviewCodeAll);
						SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
					} else {
						System.out.println("Radio button is not availble");
					}
				}

				oSeleniumUtils.highlightElement(oIUHomePage.Complete_Editorial_Review);
				SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
				if (icount > 0) {
					oSeleniumUtils.Click_given_Locator(oIUHomePage.QAReview_Category);
				}
				oSeleniumUtils.highlightElement(oIUHomePage.Complete_Editorial_Review);
				oSeleniumUtils.Click_given_Locator(oIUHomePage.Complete_Editorial_Review);
				userClickOnReviewSuccessMsg(sReviewSegValue);
				oSeleniumUtils
						.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Editorial"));

				break;

			case "Potential Conflicts":

				SeleniumUtils.defaultWait(ProjectVariables.MID_SLEEP);
				oSeleniumUtils.Click_given_Locator(oIUHomePage.Complete_Editorial_Review);
				SeleniumUtils.defaultWait(ProjectVariables.MID_SLEEP);

				oSeleniumUtils
						.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Editorial"));

				break;

			default:

				if (!(sReviewSegValue.equalsIgnoreCase("Editorials"))) {
					oSeleniumUtils.Click_given_Locator(oIUHomePage.Complete_Editorial_Review);
					userClickOnReviewSuccessMsg(sReviewSegValue);
					oSeleniumUtils
							.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Editorial"));
					break;
				}

			}

		}

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Editorial"));

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.AnchorTag, "sValue", "Editorials"));

		SeleniumUtils.switchWindowUsingWindowCount(5, 2, getDriver());

		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

		if (sOperation.equalsIgnoreCase("No Editorial Changes Required")) {

			oSeleniumUtils.Click_given_Locator(
					StringUtil.replace(oIUHomePage.No_Edit_Required, "sValue", "No Editorial Changes Required"));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			verify("Confirmation Warning should be displayed",
					oSeleniumUtils.is_WebElement_Displayed(StringUtil.replace(oIUHomePage.pTag, "sValue",
							"Rule is being set to No Editorial Changes Required. No changes to the Editorial fields will be allowed Continue?")));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oSeleniumUtils.Click_given_WebElement(oIUHomePage.Confirm_Yes);

			SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

			oGenericUtils.gfn_Click_On_Object("button", "Ok");
		}

		// Complete editorial

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		oGenericUtils.gfn_Click_On_Object("label", "Complete Editorials");

		// oSeleniumUtils.Click_given_Locator(oIUHomePage.Complete_QA_Review_Editorial);

		oSeleniumUtils.Click_given_WebElement(oIUHomePage.Confirm_Yes);

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		// getDriver().close(); // Close current page

		SeleniumUtils.switchWindowUsingWindowCount(3, 1, getDriver());

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void clickColumnAndValidateFilterFunctionality() throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.AllRulesRadioBtn);

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);

		String[] sAdminMDColumnNames = { "Reviewer", "MR", "Medical Policy", "IU Indicator", "Version", "Library",
				"ARD" };

		for (int i = 0; i < sAdminMDColumnNames.length; i++) {

			System.out.println(sAdminMDColumnNames[i]);

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oGenericUtils.gfn_Click_On_Object("span", sAdminMDColumnNames[i]);

			oGenericUtils.gfn_Verify_String_Object_Exist("(//span[text()='" + sAdminMDColumnNames[i]
					+ "'])[2]/parent::div/parent::div/parent::div/parent::div/parent::div/parent::div");

			validateFieldPrasentPopUp();

			switch (sAdminMDColumnNames[i]) {

			case "Version":
				applyFilter("version", sAdminMDColumnNames[i], "E");
				break;
			case "Library":
				applyFilter("libraryStatus", sAdminMDColumnNames[i], "H");

				break;
			case "ARD":
				applyFilter("ard", sAdminMDColumnNames[i], "I");
				break;
			case "IU Indicator":
				applyFilter("industryUpdate", sAdminMDColumnNames[i], "K");
				break;
			case "Medical Policy":
				applyFilter("medicalPolicy", sAdminMDColumnNames[i], "L");

				break;
			case "Reviewer":

				applyFilter("adminMDReviewer", sAdminMDColumnNames[i], "C");

				break;

			case "MR":
				applyFilter("mainRule", sAdminMDColumnNames[i], "D");

				break;

			default:
				Assert.assertTrue("Entered case value is not valid", false);

			}

		}
		getDriver().switchTo().defaultContent();

	}

	@Step
	public void reAssignToCPMUser(String sRole, String sCPMFrom, String sCPMTo) throws InterruptedException {

		// oSeleniumUtils.Click_given_WebElement(oIUHomePage.Column_GridCheck);

		List<WebElement> ColStatus = getDriver()
				.findElements(By.xpath(oIUHomePage.GetDynamicXPath("RULEREVIEW COLVALUE", 8)));
		for (int i = 0; i < ColStatus.size(); i++) {
			String sAssigneeColVal = ColStatus.get(i).getText().toString();

			if (ColStatus.get(i).getText().equals(sCPMFrom)) {
				verify("Column Value Expected :" + sCPMFrom + " and Actual is " + sAssigneeColVal, true);
				List<WebElement> ChkStatus = getDriver()
						.findElements(By.xpath(oIUHomePage.GetDynamicXPath("RULEREVIEW COLVALUE", 1)));

				System.out.println("Acutal Column Value: " + ChkStatus.get(i));
				oSeleniumUtils.clickOn(ChkStatus.get(i));
			}

		}

		oSeleniumUtils.Click_given_WebElement(oIUHomePage.ReAssignNavigationAdmin);

		int i = getDriver().findElements(By.xpath(StringUtil.replace(oIUHomePage.SpanTag, "sValue", "Reassign")))
				.size();

		if (i > 0) {
			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.SpanTag, "sValue", "Reassign"));
		} else {
			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.DivTag, "sValue", "Reassign"));
		}

		switch (sRole) {

		case "CPM":

			oGenericUtils.gfn_Verify_Object_Exist("div", "Reassign 1 CPM Review Rule");

			oSeleniumUtils.Click_given_WebElement(oIUHomePage.CPM_Reassgin_ListNavigaion);

			oGenericUtils.gfn_Click_On_Object("div", sCPMTo);

			oGenericUtils.gfn_Click_On_Object("div", "OK");

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			break;

		default:

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			oSeleniumUtils.Click_given_Locator(oIUHomePage.ReAssignToListBoxIcon);

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oGenericUtils.gfn_Click_String_object_Xpath(StringUtils.replace(oIUHomePage.QAReassign, "sValue", sCPMTo));

			oGenericUtils.gfn_Click_On_Object("div", "Submit Reassignments");

			oGenericUtils.gfn_Click_On_Object("div", "Yes");

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			break;

		}

	}

	@Step
	public void validateFieldPrasentPopUp() throws InterruptedException {

		verify("Sort Ascending label is displayed",
				oGenericUtils.gfn_Verify_String_Object_Exist("//a[contains(text(),'Sort Ascending')]"));

		verify("Sort Descending label is displayed",
				oGenericUtils.gfn_Verify_String_Object_Exist("//a[contains(text(),'Sort Descending')]"));

		verify("Filter Text Search label is displayed",
				oGenericUtils.gfn_Verify_String_Object_Exist("//input[@id='filterTextSearch']"));

		verify("Contains label is displayed",
				oGenericUtils.gfn_Verify_String_Object_Exist("//label[contains(text(),'Contains')]"));

		verify("Does Not Contain label is displayed",
				oGenericUtils.gfn_Verify_String_Object_Exist("//label[contains(text(),'Does Not Contain')]"));

		verify("Contains Only label is displayed",
				oGenericUtils.gfn_Verify_String_Object_Exist("//label[contains(text(),'Contains Only')]"));

		verify("Excludes Only label is displayed",
				oGenericUtils.gfn_Verify_String_Object_Exist("//label[contains(text(),'Excludes Only')]"));

		verify("Cancel label is displayed", oGenericUtils.gfn_Verify_Object_Exist("Span", "Cancel"));

		verify("Clear Filter label is displayed", oGenericUtils.gfn_Verify_Object_Exist("Span", "Clear Filter"));

		// oGenericUtils.gfn_Verify_Object_Exist("button", "Apply Filter");

	}

	@Step
	public void selectallRowsDragColumnHeader() throws InterruptedException {

		getDriver().switchTo().defaultContent();

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oGenericUtils.gfn_Verify_Object_Exist("a", "Process Candidates");

		String sTotalItems = oSeleniumUtils.get_TextFrom_Locator("//span[contains(text(),'Total')]");

		String sNoOFItems = StringUtils.substringAfter(sTotalItems, ":").trim();

		System.out.println(sNoOFItems);

		oSeleniumUtils.Click_given_Locator(oIUHomePage.SelectAllCheckBoxUnscrubbed);

		String sSelectedRows = oSeleniumUtils.get_TextFrom_Locator("//div[contains(text(),'Selected Row(s)')]");

		String sRows = StringUtils.substringAfter(sSelectedRows, ":").trim();

		System.out.println(sRows);

		verify("Only Unscrubbed Rules Rows count should match after selecting checkbox in adminscrub",
				sNoOFItems.equalsIgnoreCase(sRows));

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.AllRulesRadioBtn);

		String sTotalItemsAllRules = oSeleniumUtils.get_TextFrom_Locator("//span[contains(text(),'Total')]");

		String sNoOFItemsAllRules = StringUtils.substringAfter(sTotalItemsAllRules, ":").trim();

		System.out.println(sNoOFItemsAllRules);

		// oSeleniumUtils.Click_given_Locator(oIUHomePage.SelectAllCheckBoxAdminMDScrub);

		String sSelectedRowsAllRules = oSeleniumUtils.get_TextFrom_Locator("//div[contains(text(),'Selected Row(s)')]");

		String sRowsAllRules = StringUtils.substringAfter(sSelectedRowsAllRules, ":").trim();

		System.out.println(sRowsAllRules);

		// verify("All Rules Rows count should match after selecting checkbox in
		// adminscrub",sNoOFItems.equalsIgnoreCase(sRows));

		// oSeleniumUtils.Click_given_Locator(oIUHomePage.SelectAllCheckBoxAdminMDScrub);

		boolean bln = !oSeleniumUtils.is_WebElement_Selected(oIUHomePage.SelectAllCheckBoxAdminMDScrub);

		System.out.println(bln);

		if (bln == true) {

			verify("All rules Rows count was matched after selecting unchecking the checkbox in adminscrub",
					"0".equalsIgnoreCase(sRows));
		}

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		Actions act = new Actions(getDriver());

		oSeleniumUtils.highlightElement("//div[@class='ui-grid-cell-contents headerLetter column_5']");

		// find element which we need to drag
		WebElement drag = getDriver()
				.findElement(By.xpath("//div[@class='ui-grid-cell-contents headerLetter column_5']"));

		String sdragColumnValue = oSeleniumUtils
				.get_TextFrom_Locator("//div[@class='ui-grid-cell-contents headerLetter column_5']");

		oSeleniumUtils.highlightElement("//div[@class='ui-grid-cell-contents headerLetter column_9']");

		// find element which we need to drop
		WebElement drop = getDriver()
				.findElement(By.xpath("//div[@class='ui-grid-cell-contents headerLetter column_9']"));

		// this will drag element to destination
		act.dragAndDrop(drag, drop).build().perform();

		String sdropColumnValue = oSeleniumUtils
				.get_TextFrom_Locator("//div[@class='ui-grid-cell-contents headerLetter column_9']");

		verify("Column is dragged and dropped", sdragColumnValue.equalsIgnoreCase(sdropColumnValue));

		getDriver().switchTo().defaultContent();
	}

	@Step
	public void navigateToOverviewLinkAndValidateOptionsAvailableForMD() throws InterruptedException {

		oGenericUtils.gfn_Click_On_Object("div", "Overview");

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		String[] str = { "Not Started", "Started", "Completed" };

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		for (int i = 0; i < str.length; i++) {

			verify("" + str[i] + " text is displayed under view by", oGenericUtils
					.gfn_Verify_String_Object_Exist((StringUtils.replace(oIUHomePage.AnchorTag, "sValue", str[i]))));

			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oIUHomePage.AnchorTag, "sValue", str[i]));

			verify("Collapse all button is displayed under view by", oGenericUtils.gfn_Verify_String_Object_Exist(
					StringUtils.replace(oIUHomePage.AnchorTag, "sValue", "Collapse all")));

			verify("Expand all button is displayed under view by", oGenericUtils.gfn_Verify_String_Object_Exist(
					StringUtils.replace(oIUHomePage.AnchorTag, "sValue", "Expand all")));
		}

		/*
		 * verify("Started text is displayed under view by"
		 * ,oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(
		 * oIUHomePage.AnchorTag, "sValue", "Started")));
		 * 
		 * oSeleniumUtils.Click_given_Locator(StringUtils.replace(oIUHomePage.
		 * AnchorTag, "sValue", "Started"));
		 * 
		 * verify("Collapse all button is displayed under view by"
		 * ,oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(
		 * oIUHomePage.AnchorTag, "sValue", "Collapse all")));
		 * 
		 * verify("Expand all button is displayed under view by"
		 * ,oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(
		 * oIUHomePage.AnchorTag, "sValue", "Expand all")));
		 * 
		 * verify("Completed text is displayed under view by"
		 * ,oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(
		 * oIUHomePage.AnchorTag, "sValue", "Completed")));
		 * 
		 * oSeleniumUtils.Click_given_Locator(StringUtils.replace(oIUHomePage.
		 * AnchorTag, "sValue", "Completed"));
		 * 
		 * verify("Collapse all button is displayed under view by"
		 * ,oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(
		 * oIUHomePage.AnchorTag, "sValue", "Collapse all")));
		 * 
		 * verify("Expand all button is displayed under view by"
		 * ,oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(
		 * oIUHomePage.AnchorTag, "sValue", "Expand all")));
		 */

	}

	@Step
	public void verifyExcelGUIInAdminScrub() throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		String[] sAdminScrubTabs = { "Export", "Process Candidates", "Process Non Candidates", "Filters", "Hide/Unhide",
				"Retrieve Non Candidates", "Retrieve Candidates", "Night View", "Dashboard" };

		for (int i = 0; i < sAdminScrubTabs.length; i++) {

			System.out.println(sAdminScrubTabs[i]);

			oSeleniumUtils.highlightElement("//a[text()='" + sAdminScrubTabs[i] + "']");

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oGenericUtils.gfn_Verify_Object_Exist("a", sAdminScrubTabs[i]);

		}

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void validateReassignFunctionalityInAdminMD() throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		String sFiltertxt = null;

		String[] sAdminMDColumnNames = { "Medical Policy", "Topic" };

		for (int j = 0; j < sAdminMDColumnNames.length; j++) {

			verify("Click on " + sAdminMDColumnNames[j] + "",
					oGenericUtils.gfn_Click_On_Object("span", sAdminMDColumnNames[j]));

			oGenericUtils.gfn_Verify_String_Object_Exist("(//span[text()='" + sAdminMDColumnNames[j]
					+ "'])[2]/parent::div/parent::div/parent::div/parent::div/parent::div/parent::div");

			validateFieldPrasentPopUp();

			switch (sAdminMDColumnNames[j]) {
			case "Medical Policy":
				sFiltertxt = "Bilateral Procedures Policy";

				break;
			case "Topic":
				sFiltertxt = "Procedures that are Bilateral in Nature (Bilateral Indicator 2)";
				break;

			default:
				Assert.assertTrue("Entered case value is not valid", false);

			}

			oSeleniumUtils.Enter_given_Text_Element("//input[@id='filterTextSearch']", sFiltertxt);

			verify("Click on Apply Filter Button", oGenericUtils.gfn_Click_On_Object("button", "Apply Filter"));

			// oGenericUtils.gfn_Click_On_Object("button", "Apply Filter");

			verify("Click on Cancel Button", oGenericUtils.gfn_Click_On_Object("Span", "Cancel"));

		}

		verify("Click on Filters", oGenericUtils.gfn_Click_On_Object("a", "Filters"));

		verify("Click on Clear All Filters", oGenericUtils.gfn_Click_On_Object("a", "Clear All Filters"));

		verify("Click on All Rule Radio Button",
				oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.AllRulesRadioBtn));

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oGenericUtils.gfn_Click_String_object_Xpath(
				"(//input[@ng-model='grid.appScope.rowsList[grid.appScope.findRowIndex(row)].checked'])[1]");

		verify("Process Candidates is clicked", oGenericUtils.gfn_Click_On_Object("a", "Process Candidates"));

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		verify("Retrieve Candidates is clicked", oGenericUtils.gfn_Click_On_Object("a", "Retrieve Candidates"));

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oGenericUtils.gfn_Click_String_object_Xpath(
				"(//input[@ng-model='grid.appScope.rowsList[grid.appScope.findRowIndex(row)].checked'])[1]");

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		verify("Reassign Button is clicked in AdminScrub", oGenericUtils.gfn_Click_On_Object("a", "Reassign"));

		reassignUserInAdminScrub("Preliminary PO Review", "iht_ittest05");

		oGenericUtils.gfn_Click_String_object_Xpath(
				"(//input[@ng-model='grid.appScope.rowsList[grid.appScope.findRowIndex(row)].checked'])[1]");

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		verify("Reassign Button is clicked in AdminScrub", oGenericUtils.gfn_Click_On_Object("a", "Reassign"));

		reassignUserInAdminScrub("Final PO Review", "iht_ittest05");

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void reassignUserInAdminScrub(String sTask, String sUser) throws InterruptedException {

		oGenericUtils.gfn_Verify_Object_Exist("h5", "Re-Assign Rules");

		verify("Task Type Label is displayed", oGenericUtils.gfn_Verify_Object_Exist("span", "Task Type"));

		verify("MD Review Label is displayed", oGenericUtils.gfn_Verify_Object_Exist("span", "PO Review"));

		verify("Rule Count is displayed", oGenericUtils.gfn_Verify_Object_Exist("span", "Rule Count"));

		oGenericUtils.gfn_Verify_String_Object_Exist(
				"//span[text()='Rule Count']/parent::div/child::div/child::span[text()='1 ']");

		oGenericUtils.gfn_Verify_Object_Exist("span", "Task To Be Reassigned To ");

		oGenericUtils.gfn_Click_String_object_Xpath(
				"//span[text()='Task To Be Reassigned To ']/parent::div/child::div//input[@value='" + sTask + "']");

		verify("Reassign label is displayed", oGenericUtils.gfn_Verify_Object_Exist("span", "Reassign To "));

		oSeleniumUtils.select_Given_Value_From_DropDown_Using_StringLocator("//select[@ng-model='reassignToUser']",
				sUser);

		verify("Reassign button is clicked", oGenericUtils.gfn_Click_On_Object("button", "Reassign"));

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		System.out.println(oSeleniumUtils
				.get_TextFrom_Locator("(//div[@class='ngCellText ui-grid-cell-contents ng-binding ng-scope'])[7]"));

		verify("User id is changed after reassign", sUser.equalsIgnoreCase(oSeleniumUtils
				.get_TextFrom_Locator("(//div[@class='ngCellText ui-grid-cell-contents ng-binding ng-scope'])[7]")));

		verify("Task is changed after reassign", sTask.equalsIgnoreCase(oSeleniumUtils
				.get_TextFrom_Locator("(//div[@class='ngCellText ui-grid-cell-contents ng-binding ng-scope'])[6]")));

		// getDriver().switchTo().defaultContent();

	}

	@Step
	public void validateAdminMDDashboard() throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		verify("Click on Dashboard", oGenericUtils.gfn_Click_On_Object("a", "Dashboard"));

		SeleniumUtils.switchWindowUsingWindowCount(2, 2, getDriver());

		verify("Assinee is displayed", oGenericUtils.gfn_Verify_Object_Exist("span", "Assignee"));

		verify("Medical Policy is displayed", oGenericUtils.gfn_Verify_Object_Exist("span", "Medical Policy"));

		verify("Topic is displayed", oGenericUtils.gfn_Verify_Object_Exist("span", "Topic"));

		verify("Rule Count is displayed", oGenericUtils.gfn_Verify_Object_Exist("span", "Rule Count"));

		verify("Refresh is displayed", oGenericUtils.gfn_Verify_Object_Exist("a", "Refresh"));

		oGenericUtils.gfn_Click_String_object_Xpath(
				"//div[@class='ui-grid-tree-base-row-header-buttons ui-grid-icon-plus-squared']");

		List<WebElement> sList = getDriver().findElements(By.xpath("//i[@class='ui-grid-icon-minus-squared']"));

		for (int i = 1; i <= sList.size(); i++) {

			oGenericUtils.gfn_Verify_String_Object_Exist("(//i[@class='ui-grid-icon-minus-squared'])[" + i + "]");

			System.out.println("Tested clopse functionality");
		}

		SeleniumUtils.switchWindowUsingWindowCount(2, 1, getDriver());

		getDriver().switchTo().defaultContent();
	}

	@Step
	public void validateRetainFilters() throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.AllRulesRadioBtn);

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);

		String[] sAdminMDColumnNames = { "Version", "IU Indicator" };

		for (int i = 0; i < sAdminMDColumnNames.length; i++) {

			oGenericUtils.gfn_Click_On_Object("span", sAdminMDColumnNames[i]);

			oGenericUtils.gfn_Verify_String_Object_Exist("(//span[text()='" + sAdminMDColumnNames[i]
					+ "'])[2]/parent::div/parent::div/parent::div/parent::div/parent::div/parent::div");

			validateFieldPrasentPopUp();

			switch (sAdminMDColumnNames[i]) {

			case "Version":

				oGenericUtils.gfn_Verify_String_Object_Exist(
						"//span[@class='glyphicon glyphicon-home adminHome adminHomeHilight']");

				oSeleniumUtils.Enter_given_Text_Element("//input[@id='filterTextSearch']",
						oSeleniumUtils.get_TextFrom_Locator(
								"(//div[@class='ngCellText ui-grid-cell-contents ng-binding ng-scope'])[5]"));

				oGenericUtils.gfn_Click_On_Object("button", "Apply Filter");

				oGenericUtils.gfn_Click_On_Object("span", "Cancel");

				oGenericUtils.gfn_Verify_String_Object_Exist("//div[text()='E']/child::span//img");

				oGenericUtils.gfn_Click_On_Object("a", "Retrieve Candidates");

				oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);

				oGenericUtils.gfn_Verify_String_Object_Exist("//span[@class='glyphicon glyphicon-home adminHome']");

				oGenericUtils.gfn_Verify_String_Object_Exist("//div[text()='E']/child::span//img");

				oGenericUtils.gfn_Click_String_object_Xpath("//span[@class='glyphicon glyphicon-home adminHome']");

				oGenericUtils.gfn_Verify_String_Object_Exist(
						"//span[@class='glyphicon glyphicon-home adminHome adminHomeHilight']");

				break;
			case "IU Indicator":

				oGenericUtils.gfn_Verify_String_Object_Exist(
						"//span[@class='glyphicon glyphicon-home adminHome adminHomeHilight']");

				oSeleniumUtils.Enter_given_Text_Element("//input[@id='filterTextSearch']",
						oSeleniumUtils.get_TextFrom_Locator(
								"(//div[@class='ngCellText ui-grid-cell-contents ng-binding ng-scope'])[11]"));

				oGenericUtils.gfn_Click_On_Object("button", "Apply Filter");

				oGenericUtils.gfn_Click_On_Object("span", "Cancel");

				oGenericUtils.gfn_Verify_String_Object_Exist("//div[text()='K']/child::span//img");

				oGenericUtils.gfn_Click_On_Object("a", "Retrieve Candidates");

				oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);

				oGenericUtils.gfn_Verify_String_Object_Exist("//span[@class='glyphicon glyphicon-home adminHome']");

				oGenericUtils.gfn_Verify_String_Object_Exist("//div[text()='K']/child::span//img");

				oGenericUtils.gfn_Click_String_object_Xpath("//span[@class='glyphicon glyphicon-home adminHome']");

				oGenericUtils.gfn_Verify_String_Object_Exist(
						"//span[@class='glyphicon glyphicon-home adminHome adminHomeHilight']");
				break;

			default:
				Assert.assertTrue("Entered case value is not valid", false);

			}

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.AllRulesRadioBtn);

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);
		}

		getDriver().switchTo().defaultContent();
	}

	@Step
	public void validateAdminViewButtonsDisabled() throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.AllRulesRadioBtn);

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);

		String sTotalItems = oSeleniumUtils.get_TextFrom_Locator("//span[contains(text(),'Total')]");

		String sNoOFItemsHome = StringUtils.substringAfter(sTotalItems, ":").trim();

		oGenericUtils.gfn_Click_On_Object("a", "Admin View");

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);

		String sTotalItemAdmin = oSeleniumUtils.get_TextFrom_Locator("//span[contains(text(),'Total')]");

		String sNoOFItemsAdmin = StringUtils.substringAfter(sTotalItemAdmin, ":").trim();

		Assert.assertTrue("Total Items count displayed is not same for Home and Admin View",
				sNoOFItemsAdmin.equalsIgnoreCase(sNoOFItemsHome));

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.AllRulesRadioBtn);

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.SelectAllCheckBoxAdminMDScrub);

		Assert.assertFalse("Reassgin button is not disabled", oIUHomePage.Reassign_Btn.isCurrentlyEnabled());

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void verifyColumnHeaderAndFilterPopupWhenAdminMDEntersZeroListValues() throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.AllRulesRadioBtn);

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);

		String sFiltertxt = "TestAuto123";

		String[] sAdminMDColumnNames = { "Review", "Comment", "Reviewer", "MR", "Version", "Task Type", "Assignee",
				"Library", "ARD", "Reference", "IU Indicator", "Medical Policy", "Topic", "Decision Point", "Group" };

		for (int i = 0; i < sAdminMDColumnNames.length; i++) {

			System.out.println(sAdminMDColumnNames[i]);

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);

			oGenericUtils.gfn_Click_On_Object("span", sAdminMDColumnNames[i]);

			oGenericUtils.gfn_Verify_String_Object_Exist("(//span[text()='" + sAdminMDColumnNames[i]
					+ "'])[2]/parent::div/parent::div/parent::div/parent::div/parent::div/parent::div");

			validateFieldPrasentPopUp();

			oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.AdminScrubFilterTextSearch, sFiltertxt);

			Assert.assertFalse("Apply filter button is not disabled",
					oIUHomePage.ApplyFilterButton.isCurrentlyEnabled());

			oGenericUtils.gfn_Click_On_Object("Span", "Cancel");

		}
		getDriver().switchTo().defaultContent();
	}

	@Step
	public void verifyFollowingLabelAndDataIsWithinThatColumn(String arg) throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.AllRulesRadioBtn);

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);

		String[] sAdimMDScrubColumns = ProjectVariables.ColumnList;

		oIUHomePage.scrollToColumn("span", sAdimMDScrubColumns);

		oGenericUtils.gfn_Verify_Object_Exist("span", ProjectVariables.sColumns);

		String sFiltertxt = oSeleniumUtils.get_TextFrom_Locator(
				"(//div[@ng-bind-html='grid.appScope.wrapTextForMappingInfo(row.entity.mappingInfo)'])[1]//table//tr//td[1]");

		oSeleniumUtils.Doubleclick(
				"(//div[@ng-bind-html='grid.appScope.wrapTextForMappingInfo(row.entity.mappingInfo)'])[1]//table//tr");

		oGenericUtils.gfn_Verify_String_Object_Exist("(//span[text()='" + ProjectVariables.sColumns + "'])[2]");

		oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.AdminPopCellSearchBox, sFiltertxt);

		oGenericUtils.gfn_Verify_String_Object_Exist(oIUHomePage.HighlightColor);

		oGenericUtils.gfn_Click_String_object_Xpath(StringUtils.replace(oIUHomePage.CloseCellPopup, "sValue",
				"ReviewCPT   Group        Mapped CPT           From-To                         CAT          Override "));

		oGenericUtils.gfn_Click_On_Object("span", ProjectVariables.sColumns);

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oGenericUtils.gfn_Verify_String_Object_Exist("(//span[text()='" + ProjectVariables.sColumns + "'])[2]");

		oGenericUtils.gfn_Click_String_object_Xpath(
				"(//div[@class='ui-grid-selection-row-header-buttons ui-grid-icon-ok ng-scope'])[1]");

		oGenericUtils.gfn_Click_On_Object("button", "Apply Filter");

		oGenericUtils.gfn_Click_On_Object("Span", "Cancel");

		oGenericUtils.gfn_Verify_String_Object_Exist("//div[text()='U']/child::span//img");

		getDriver().switchTo().defaultContent();

	}

	@Step
	public static boolean compareList(String string, String string2) {

		return string.toString().contentEquals(string2.toString()) ? true : false;
	}

	@Step
	public void applyFilter(String sWebElementList, String sColumnName, String sFilterImgColumn)
			throws InterruptedException {

		String sCellTextXpath = "(//div[@ng-bind-html='row.entity." + sWebElementList + "'])";

		System.out.println(sCellTextXpath);

		List<WebElement> sWebList = getDriver()
				.findElements(By.xpath("(//div[@ng-bind-html='row.entity." + sWebElementList + "'])"));

		for (int j = 1; j <= sWebList.size(); j++) {

			System.out.println(oSeleniumUtils.get_TextFrom_Locator(sCellTextXpath + "[" + j + "]"));

			oSeleniumUtils.Enter_given_Text_Element("//input[@id='filterTextSearch']",
					oSeleniumUtils.get_TextFrom_Locator(sCellTextXpath + "[" + j + "]"));

			Assert.assertTrue("Cell value is not displayed",
					oSeleniumUtils.is_WebElement_Displayed(sCellTextXpath + "[" + j + "]"));

			oGenericUtils.gfn_Click_On_Object("button", "Apply Filter");

			oGenericUtils.gfn_Click_On_Object("span", "Cancel");

			oGenericUtils.gfn_Verify_String_Object_Exist("//div[text()='" + sFilterImgColumn + "']/child::span//img");

			oGenericUtils.gfn_Click_On_Object("a", "Filters");

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oGenericUtils.gfn_Click_On_Object("a", "Clear All Filters");

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);

			oGenericUtils.gfn_Click_On_Object("span", sColumnName);

			if (oIUHomePage.CancelButton.isVisible()) {

				oGenericUtils.gfn_Click_On_Object("span", "Cancel");

				break;
			}

		}
	}

	public void verifyGenerateSummariesEnabled() throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);
		oGenericUtils.gfn_Click_On_Object("tab-heading", "Decisions");
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		String status_Config_Btn = getDriver().findElement(By.xpath(oIUHomePage.Generate_Summaries))
				.getAttribute("disabled");
		System.out.println(status_Config_Btn);

		if (status_Config_Btn == null) {
			verify("Generate summaires enabled sucessfully", true);
		} else {
			verify("Generate summaires is disabled", false);
		}

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Summaries"));
		oGenericUtils.gfn_Verify_Object_Exist("span", "Decision Summary");
		oGenericUtils.gfn_Verify_Object_Exist("span", "Configurations Summary");
		oGenericUtils.gfn_Verify_Object_Exist("span", "Impact Code List");

		getDriver().switchTo().defaultContent();

	}

	public void validateSystemProposalListItems() throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		List<WebElement> iDecesionList = getDriver().findElements(By.xpath(oIUHomePage.SystemDecisionSel));

		List<String> sFilterNameList = Arrays.asList(ProjectVariables.SystemDecesionList.split(";"));

		for (int k = 0; k < sFilterNameList.size(); k++) {

			System.out.println("Expected Column Value: " + sFilterNameList.get(k).toString());

			for (int i = 0; i < iDecesionList.size(); i++) {

				System.out.println("Rule Review Status: " + iDecesionList.get(i).getText().toString());

				if (iDecesionList.get(i).getText().contains(sFilterNameList.get(k))) {

					verify("Column Value Expected :" + sFilterNameList.get(k) + " and Actual is "
							+ iDecesionList.get(i).getText(), true);

				} else {

					verify("Column Value Expected :" + sFilterNameList.get(k) + " and Actual is "
							+ iDecesionList.get(i).getText(), false);

				}
			}
		}

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		getDriver().switchTo().defaultContent();

	}

	public void validateNoDecisionError() throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);
		oSeleniumUtils.Click_given_Locator(oIUHomePage.NoDecision);
		oGenericUtils.gfn_Verify_Object_Exist("p",
				" Final PO comments needs to be provided before performing no decisions action.");
		oGenericUtils.gfn_Click_On_Object("button", "Ok");
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Comments"));

		oGenericUtils.gfn_Click_On_Object("span", "Final PO Comments");
		oSeleniumUtils.Enter_given_Text_Element(
				StringUtil.replace(oIUHomePage.Final_MD_Comments, "sValue", "Final PO Comments"), "Automation test");
		oGenericUtils.gfn_Click_On_Object("label", "Save");
		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Decisions"));

		oGenericUtils.gfn_Verify_Object_Exist("h3", "No Decisions");
		// oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.NoDecision);
		oGenericUtils.gfn_Click_On_Object("button", "Yes");

		getDriver().switchTo().defaultContent();

	}

	public void validateCPTChangesInDB(String sRuleUpdate) throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		String sNewRuleFlag = "False";

		SeleniumUtils.defaultWait(ProjectVariables.MID_SLEEP);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Summaries"));

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		if (oGenericUtils.gfn_Verify_Object_Exist(oIUHomePage.NewMidruleversion, 1) == true) {

			Serenity.setSessionVariable("MidRuleNewVersion")
					.to(oSeleniumUtils.get_TextFrom_Locator("//label[text()='New Rule Version: ']//..//label[2]"));

			System.out.println(Serenity.sessionVariableCalled("MidRuleNewVersion").toString());

			verify("New mid rule version is : " + Serenity.sessionVariableCalled("MidRuleNewVersion").toString(), true);

			sNewRuleFlag = "True";

			Serenity.setSessionVariable("NewRuleFlag").to(sNewRuleFlag);

		}

		if (oGenericUtils.gfn_Verify_Object_Exist(oIUHomePage.NewMidruleversion, 1) == true) {

			Serenity.setSessionVariable("MidRuleNewVersion")
					.to(oSeleniumUtils.get_TextFrom_Locator("//label[text()='New Rule Version: ']//..//label[2]"));

			System.out.println(Serenity.sessionVariableCalled("MidRuleNewVersion").toString());

			verify("New mid rule version is : " + Serenity.sessionVariableCalled("MidRuleNewVersion").toString(), true);

			sNewRuleFlag = "True";

			Serenity.setSessionVariable("NewRuleFlag").to(sNewRuleFlag);

		}

		oGenericUtils.gfn_Click_On_Object("span", "Configurations Summary");

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		List<WebElement> ConfigSummaryList = getDriver().findElements(By.xpath(oIUHomePage.ConfigSumTable));
		System.out.println(ConfigSummaryList.size());

		for (int i = 1; i <= ConfigSummaryList.size(); i++) {

			String sConfigAction = getDriver()
					.findElement(By.xpath(oIUHomePage.GetDynamicXPathWithRowCol("CONFIGSUMMARY VALUES", i + 1, 1)))
					.getText();
			String sCPTFrom = getDriver()
					.findElement(By.xpath(oIUHomePage.GetDynamicXPathWithRowCol("CONFIGSUMMARY VALUES", i + 1, 2)))
					.getText();
			String sCPTTo = getDriver()
					.findElement(By.xpath(oIUHomePage.GetDynamicXPathWithRowCol("CONFIGSUMMARY VALUES", i + 1, 3)))
					.getText();
			String sMod1 = getDriver()
					.findElement(By.xpath(oIUHomePage.GetDynamicXPathWithRowCol("CONFIGSUMMARY VALUES", i + 1, 5)))
					.getText();
			String sMod2 = getDriver()
					.findElement(By.xpath(oIUHomePage.GetDynamicXPathWithRowCol("CONFIGSUMMARY VALUES", i + 1, 7)))
					.getText();
			String sPoslike = getDriver()
					.findElement(By.xpath(oIUHomePage.GetDynamicXPathWithRowCol("CONFIGSUMMARY VALUES", i + 1, 13)))
					.getText();
			String sAppDateFrom = getDriver()
					.findElement(By.xpath(oIUHomePage.GetDynamicXPathWithRowCol("CONFIGSUMMARY VALUES", i + 1, 14)))
					.getText();
			System.out.println(sAppDateFrom);
			String sAppDateTo = getDriver()
					.findElement(By.xpath(oIUHomePage.GetDynamicXPathWithRowCol("CONFIGSUMMARY VALUES", i + 1, 15)))
					.getText();

			boolean sResult = validateDBRuleValidation(sRuleUpdate, sConfigAction, sCPTFrom, sCPTTo, sMod1, sMod2,
					sPoslike, sAppDateFrom, sAppDateTo);

			verify(+i + "-column Value Expected :" + sCPTFrom + " and Actual is: " + sResult, sResult);

		}

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "QA"));

		getDriver().switchTo().defaultContent();

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

	}

	public boolean validateDBRuleValidation(String sRuleUpdate, String sConfigAction, String sCPTFrom, String sCPTTo,
			String sMod1, String sMod2, String sPoslike, String sAppDateFrom, String sAppDateTo) {

		String[] sRuleVersion;
		String sDateFrom = oGenericUtils.convertStringDate(sAppDateFrom);
		System.out.println("datefrom" + sDateFrom);

		String sDateTo = oGenericUtils.convertStringDate(sAppDateTo);
		System.out.println("datefrom" + sDateTo);
		// System.out.println("new flag:"
		// +Serenity.sessionVariableCalled("NewRuleFlag").toString());

		if (Serenity.sessionVariableCalled("NewRuleFlag") != null) {

			sRuleVersion = Serenity.sessionVariableCalled("MidRuleNewVersion").toString().split("\\.");
			System.out.println(Serenity.sessionVariableCalled("MidRuleNewVersion").toString());
		} else {
			sRuleVersion = Serenity.sessionVariableCalled("MidRuleVersion").toString().split("\\.");
			System.out.println(Serenity.sessionVariableCalled("MidRuleVersion").toString());

		}

		System.out.println("Midrule:  " + sRuleVersion[0]);

		System.out.println("Rule version :  " + sRuleVersion[1]);

		// Execute Query Before selecting Rule from My Tasks
		String sQuery = " select CPT_FROM from RULES.SUB_RULES_CPT where sub_rule_key in "
				+ "( select sub_Rule_key from rules.sub_rules where mid_rule_key ='" + sRuleVersion[0]
				+ "' and rule_version = '" + sRuleVersion[1] + "') " + "and cpt_from = '" + sCPTFrom
				+ "' and cpt_to = '" + sCPTTo + "' and DATE_FROM= TO_DATE('" + sDateFrom
				+ "', 'MM/DD/YYYY') and DATE_TO= TO_DATE('" + sDateTo + "', 'MM/DD/YYYY') and CPT_MOD1 = '" + sMod1
				+ "' and CPT_MOD1 = '" + sMod2 + "' and POS_LIKE = '" + sPoslike + "' ";

		System.out.println("Query: " + sQuery);

		verify("Executed Query " + sQuery, true);

		String sQueryResult = DBUtils.executeSQLQuery(sQuery);

		System.out.println("Query Result: " + sQueryResult);

		// boolean sStatus = sQueryResult.equalsIgnoreCase(sCPTFrom);

		// verify("Column Value Expected :" + sCPTFrom + " and Actual is " +
		// sQueryResult, sStatus);

		switch (sConfigAction) {
		case "ADD":
		case "CHG TO":
			switch (sRuleUpdate) {

			case "YES":
				if (sQueryResult.equalsIgnoreCase(sCPTFrom)) {
					verify("Displayed Records in Backend Database for Action After Update :" + sCPTFrom
							+ "Records Added sucessfully from Backend Database After Update" + sQueryResult, true);
				} else {
					verify("Displayed Records in Backend Database for Action After Update :" + sCPTFrom
							+ "Record not Added in Database after Update" + sQueryResult, false);
				}

				break;

			case "NO":
				if (sQueryResult.equals("")) {
					verify("Should not Display Records for Action Before Update:" + sCPTFrom
							+ "Records not Displayed in Backend Database before Rule Update" + sQueryResult, true);
				} else {
					verify("Should not Display Records for Action Before Update:" + sCPTFrom
							+ "Records Displayed in Backend Database before Rule Update" + sQueryResult, false);
				}

				break;
			}
			break;

		case "DEL":
		case "CHG FROM":
			switch (sRuleUpdate) {

			case "YES":
				if (sQueryResult.equals("")) {
					verify("Should not Display Records for Action Before Update:" + sCPTFrom
							+ "Records not Displayed in Backend Database before Rule Update" + sQueryResult, true);
				} else {
					verify("Should not Display Records for Action Before Update:" + sCPTFrom
							+ "Records Displayed in Backend Database before Rule Update" + sQueryResult, false);
				}

				break;

			case "NO":
				if (sQueryResult.equalsIgnoreCase(sCPTFrom)) {
					verify("Displayed Records in Backend Database for Action After Update :" + sCPTFrom
							+ "Records Added sucessfully from Backend Database After Update" + sQueryResult, true);
				} else {
					verify("Displayed Records in Backend Database for Action After Update :" + sCPTFrom
							+ "Record not Added in Database after Update" + sQueryResult, false);
				}

				break;
			}
			break;

		}

		return true;

	}

	public void returnRuleResponse(String sRuleFrom, String ButtonName) throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oSeleniumUtils.Click_given_Locator(oIUHomePage.ReturnRuleResponse);

		oGenericUtils.gfn_Verify_Object_Exist("h3", "Return Rule Response");

		oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.CPMResponse, ProjectVariables.ReturnRuleComments);

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.SaveReturnRuleResponse);

		oGenericUtils.gfn_Verify_Object_Exist("h3", "WARNING");

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.StartReviewPoPYesBtn);

		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		getDriver().switchTo().defaultContent();

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

	}

	public void completePostAdditionalConfig() throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oGenericUtils.gfn_Click_On_Object("a", "Post Additional Configuration");

		oGenericUtils.gfn_Verify_String_Object_Exist(oIUHomePage.CompleteQAPostConfig);

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.CompleteQAPostConfig);

		oGenericUtils.gfn_Verify_Object_Exist("p", " Review completed successfully.");

		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.AdditionalConfigQA);

		oGenericUtils.gfn_Verify_Object_Exist("p", " QA Review Completed");

		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		getDriver().switchTo().defaultContent();

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

	}

	public void completeConfigReview() throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oGenericUtils.gfn_Click_On_Object("a", "Additional Configuration");

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.CompleteConfigReview);

		oGenericUtils.gfn_Verify_Object_Exist("p", " Review completed successfully.");

		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Summaries"));

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Config"));

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Summaries"));

		oGenericUtils.gfn_Verify_String_Object_Exist(oIUHomePage.ConfigComplete);

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.ConfigComplete);

		oGenericUtils.gfn_Verify_Object_Exist("h3", "WARNING");

		oGenericUtils
				.gfn_Click_String_object_Xpath(oIUHomePage.GetDynamicXPathWithString("CONTAINS BUTTON", "Yes", ""));

		oGenericUtils.gfn_Verify_Object_Exist("p", " Configuration review completed successfully.");

		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		getDriver().switchTo().defaultContent();

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

	}

	@Step
	public void validateReturnReviewComments(String sReturnFrom, String ReturnTo) throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Comments"));

		oGenericUtils.gfn_Click_On_Object("span", "Return Review Comments");

		oGenericUtils.gfn_Verify_Object_Exist("span", "Return Review Comments");

		String sReturnFromTask = getDriver()
				.findElement(By.xpath(oIUHomePage.GetDynamicXPath("RETURN REVIEW COMMENTS", 2))).getText();

		String sReturnToTask = getDriver()
				.findElement(By.xpath(oIUHomePage.GetDynamicXPath("RETURN REVIEW COMMENTS", 4))).getText();

		String sReturnComments = getDriver()
				.findElement(By.xpath(oIUHomePage.GetDynamicXPath("RETURN REVIEW COMMENTS", 5))).getText();

		String sResponseComments = getDriver()
				.findElement(By.xpath(oIUHomePage.GetDynamicXPath("RETURN REVIEW COMMENTS", 6))).getText();

		if (sReturnFromTask.equalsIgnoreCase(sReturnFrom)) {

			verify("Expected Value is :" + sReturnFrom + "Acutal Return From Task is: " + sReturnFromTask, true);
		} else {
			verify("Expected Value is :" + sReturnFrom + "Acutal Return From Task is: " + sReturnFromTask, false);

		}

		if (sReturnToTask.equalsIgnoreCase(ReturnTo)) {

			verify("Expected Value is :" + ReturnTo + "Acutal Return From Task is: " + sReturnToTask, true);
		} else {
			verify("Expected Value is :" + ReturnTo + "Acutal Return From Task is: " + sReturnToTask, false);

		}

		if (sReturnComments.equalsIgnoreCase(ProjectVariables.ReturnComments)) {
			verify("Expected Value is :" + ProjectVariables.ReturnRuleComments + "Acutal Return From Task is: "
					+ sReturnComments, true);
		} else {
			verify("Expected Value is :" + ProjectVariables.ReturnRuleComments + "Acutal Return From Task is: "
					+ sReturnComments, false);

		}

		if (sResponseComments.indexOf("testing") >= 0) {
			verify("Expected Value is :" + "[iht_ittest01] testing" + "Acutal Return From Task is: "
					+ sResponseComments, true);
		} else {
			verify("Expected Value is :" + "[iht_ittest01] testing" + "Acutal Return From Task is: "
					+ sResponseComments, false);

		}

		getDriver().switchTo().defaultContent();

	}

	public void validateEditorialChangesInDB() {

		System.out.println(Serenity.sessionVariableCalled("MidRuleVersion").toString());
		String[] sRuleVersion = Serenity.sessionVariableCalled("MidRuleVersion").toString().split("\\.");

		System.out.println("Midrule:  " + sRuleVersion[0]);

		System.out.println("Rule version :  " + sRuleVersion[1]);

		// Execute Query Before selecting Rule from My Tasks
		String sQuery = "select SUB_RULE_DESC from rules.sub_rules " + "where mid_rule_key = '" + sRuleVersion[0]
				+ "'  and rule_version = '" + sRuleVersion[1] + "'";

		System.out.println("Query: " + sQuery);

		String sQueryResult = DBUtils.executeSQLQuery(sQuery);

		System.out.println("Query Result: " + sQueryResult);

		if (sQueryResult.equalsIgnoreCase(ProjectVariables.EditorialChangesDescripiton)) {
			verify("Validate Rule Decription in RMI After Update:" + sQueryResult + "Rule Description is matching",
					true);
		} else {
			verify("Rule Descritpion is not matching : Actual is : " + sQueryResult
					+ "Expected Record should display : " + ProjectVariables.EditorialChangesDescripiton, false);
		}
	}

	public boolean validateEditorialChangesInDB(String sColumnName) {

		List<String> sEditorialTabList = Arrays.asList(sColumnName.split(";"));

		for (int i = 0; i < sEditorialTabList.size(); i++) {

			System.out.println(Serenity.sessionVariableCalled("MidRuleVersion").toString());

			String[] sRuleVersion;

			if (Serenity.sessionVariableCalled("RetireRule-Yes") != null) {

				sRuleVersion = Serenity.sessionVariableCalled("MidRuleNewVersion").toString().split("\\.");

			} else {

				sRuleVersion = Serenity.sessionVariableCalled("MidRuleVersion").toString().split("\\.");
			}

			System.out.println("Midrule:  " + sRuleVersion[0]);

			System.out.println("Rule version :  " + sRuleVersion[1]);

			String sExpTabComments = null;

			switch (sEditorialTabList.get(i)) {

			case "SUB_RULE_DESC":
				sExpTabComments = ProjectVariables.EditorialChangesDescripiton;
				break;

			case "SUB_RULE_NOTES":
				sExpTabComments = ProjectVariables.EditorialChangesNotes;
				break;

			case "SUB_RULE_SCRIPT":
				sExpTabComments = ProjectVariables.EditorialChangesScript;
				break;

			case "SUB_RULE_RATIONALE":
				sExpTabComments = ProjectVariables.EditorialChangesRationale;
				break;

			case "REFERENCE":
				sExpTabComments = ProjectVariables.EditorialChangesReference;
				break;

			}

			// Execute Query Before selecting Rule from My Tasks
			String sQuery = "select " + sEditorialTabList.get(i) + " from rules.sub_rules " + "where mid_rule_key = '"
					+ sRuleVersion[0] + "'  and rule_version = '" + sRuleVersion[1] + "'";

			System.out.println("Query: " + sQuery);

			String sQueryResult = DBUtils.executeSQLQuery(sQuery);

			System.out.println("Query Result: " + sQueryResult);

			if (sQueryResult.trim().equalsIgnoreCase(sExpTabComments.trim())) {

				verify("Validate Rule Decription in RMI After Update:" + sQueryResult + "Rule Description is matching",
						true);
			} else {
				System.out.println("Row Number: " + i);
				verify("Rule Descritpion is not matching : Actual is : " + sQueryResult
						+ "Expected Record should display : " + sExpTabComments, false);
			}
		}

		return true;
	}

	@Step
	public void navigateToIUTasksAndGoToRuleInInstance(String sTaskTab, String sTaskName, String sInstancetype)
			throws InterruptedException {

		oIUHomePage.closeAllTabs();

		userNavigateToIUInstancesScreen(sTaskTab);

		switch (sTaskTab) {
		case "Admin PO Scrub":

			Assert.assertTrue("Work Queue Validation in My Task is not Displayed as expected", oSeleniumUtils
					.is_WebElement_Displayed(Serenity.sessionVariableCalled("TaskandInstnaceName").toString()));

			break;

		case "GroupTasks":

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.GetDynamicXPathWithString("GROUPTASK TASKTYPE",
					ProjectVariables.FinalMDInstance, sTaskName));

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			oIUHomePage.go_To_Rule(Serenity.sessionVariableCalled("MidRuleVersion").toString());

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			break;

		default:

			clickTaskByInstanceName(sTaskName, sInstancetype);

			oIUHomePage.go_To_Rule(Serenity.sessionVariableCalled("MidRuleVersion").toString());

		}

	}

	@Step
	public void userClickonClaimTask() throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oGenericUtils.gfn_Click_String_object_Xpath((StringUtil.replace(oIUHomePage.SelectGridRuleChkbox, "sValue",
				Serenity.sessionVariableCalled("MidRuleVersion").toString())));

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oGenericUtils.gfn_Click_On_Object("div", "Claim Tasks");

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

	}

	@Step
	public void uploadFileInTestingReview() throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);
		oSeleniumUtils.Click_given_Locator(oIUHomePage.ChooseFile);

		getDriver().switchTo().defaultContent();

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		GenericUtils.attachFiles();

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);
		oGenericUtils.gfn_Click_On_Object("label", "Attach");

		oGenericUtils.gfn_Verify_Object_Exist("h3", "Success");
		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		// verify Brat Test Results
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		oGenericUtils.gfn_Verify_String_Object_Exist(oIUHomePage.NamedSetsData);

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.BratTestGrid);

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.Save_Brat);

		oGenericUtils.gfn_Verify_Object_Exist("h3", "Success");

		oGenericUtils.gfn_Click_On_Object("button", "Ok");
		getDriver().switchTo().defaultContent();

	}

	@Step
	public void CPMReassignRule(String sReassignUserID) throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oGenericUtils.gfn_Click_String_object_Xpath(
				oIUHomePage.GetDynamicXPathWithString("CONTAINS LABEL", "Reassign Rule", ""));

		oGenericUtils.gfn_Verify_Object_Exist("h3", "CPM Reassign");

		oSeleniumUtils.Click_given_Locator(oIUHomePage.SelectCPMReassign);

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(
				(StringUtil.replace(oIUHomePage.SelectCPMReassignUser, "sValue", sReassignUserID)));

		oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.ReasonReassign, "TestAutomation");

		oGenericUtils.gfn_Click_On_Object("button", "Reassign Rule");

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		getDriver().switchTo().defaultContent();

	}

	public void ADDCodeinMD(String sCategoryCode, String sCode) throws InterruptedException {

		String sArrayCode = null;

		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oGenericUtils.gfn_Click_On_Object("label", "Add Code");
		oGenericUtils.gfn_Verify_Object_Exist("h3", "Add Code");

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.StartNewCode);

		oGenericUtils.gfn_Click_On_Object("a", "Start New");

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		int iYesBtn = getDriver()
				.findElements(
						By.xpath("//table[@id='Manual_Proposals_grid']//tr[2]//td[2]//select//option[text()='Yes']"))
				.size();

		if (iYesBtn > 0) {

			oSeleniumUtils.Click_given_Locator(
					"//table[@id='Manual_Proposals_grid']//tr[2]//td[2]//select//option[text()='Yes']");
		}

		oSeleniumUtils.select_Given_Value_From_DropDown_Using_StringLocator(
				"//table[@id='Manual_Proposals_grid']//tr[2]//td[2]//select", "Yes");

		oSeleniumUtils.select_Given_Value_From_DropDown_Using_StringLocator(
				oIUHomePage.GetDynamicXPathWithRowCol("MANUALPROP FIELDS", 2, 3), "Manual Add");

		oSeleniumUtils.Enter_given_Text_Element(("//table[@id='Manual_Proposals_grid']//tr[2]//td[4]//textarea"),
				"Test");

		oSeleniumUtils.select_Given_Value_From_DropDown_Using_StringLocator(
				"//table[@id='Manual_Proposals_grid']//tr[2]//td[9]//select", sCategoryCode);

		// oSeleniumUtils.Click_given_Locator("//table[@id='Manual_Proposals_grid']//tr[2]//td[9]//select//option[text()='"
		// + sCategoryCode + "']");

		oSeleniumUtils.Enter_given_Text_Element(("//table[@id='Manual_Proposals_grid']//tr[2]//td[6]//input"), sCode);

		if (Serenity.sessionVariableCalled("POS CODE") != null) {

			if (Serenity.sessionVariableCalled("POS CODE").toString().contains("POS")) {

				String sPosCode = StringUtils.substringAfter(Serenity.sessionVariableCalled("POS CODE").toString(),
						"-");

				oSeleniumUtils.Enter_given_Text_Element(
						("//td[@aria-describedby='Manual_Proposals_grid_interpRuleCpt.posLike']//input"), sPosCode);
			}

		}

		if (Serenity.sessionVariableCalled("Override Flag") != null) {

			if (Serenity.sessionVariableCalled("Override Flag").toString().contains("OverrideFlag-Yes")) {

				verify("OVerride flag should be unchecked", !oSeleniumUtils.is_WebElement_Selected(
						"//td[@aria-describedby='Manual_Proposals_grid_interpRuleCpt.override']//input"));

				oSeleniumUtils.Click_given_Locator(
						"//td[@aria-describedby='Manual_Proposals_grid_interpRuleCpt.override']//input");

			}
		}

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oGenericUtils.gfn_Click_On_Object("label", "Save");

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		String arr[] = { "0075T", "0009T", "0006T", "0007T", "0004T" };

		for (int i = 0; i < arr.length; i++) {

			sArrayCode = arr[i];

			int iErrorMsg = getDriver().findElements(By.xpath(StringUtil.replace(oIUHomePage.pTag, "sValue",
					" One or more proposals already exists. Please review duplicates and save."))).size();

			if (iErrorMsg > 0) {

				oGenericUtils.gfn_Click_On_Object("button", "Ok");
				oSeleniumUtils.Enter_given_Text_Element(("//table[@id='Manual_Proposals_grid']//tr[2]//td[6]//input"),
						sArrayCode);
				oGenericUtils.gfn_Click_On_Object("label", "Save");

			}

			int iMsg = getDriver().findElements(By.xpath(StringUtil.replace(oIUHomePage.h3Tag, "sValue", "Success")))
					.size();

			if (iMsg > 0) {
				break;
			}

		}

		oGenericUtils.gfn_Verify_Object_Exist("h3", "Success");
		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		String sCPTValue = oSeleniumUtils
				.get_TextFrom_Locator("//table[@id='Manual_Proposals_grid']//tr[2]//td[6]//input");

		Serenity.setSessionVariable("CPTValue").to(sCPTValue);
		Serenity.setSessionVariable("CategoryCode").to(sCategoryCode);
		Serenity.setSessionVariable("AddCodeMD").to(sCPTValue);

		System.out.println("CategoryCode: " + Serenity.sessionVariableCalled("CategoryCode").toString());
		System.out.println("Add Code in MD: " + Serenity.sessionVariableCalled("AddCodeMD").toString());

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void clickonGenerateSummariesValidateMessage(String sWorkQueue) throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		if ((oSeleniumUtils.is_WebElement_Present(oIUHomePage.Generate_Summaries))) {
			oSeleniumUtils.Click_given_Locator(oIUHomePage.Generate_Summaries);
		} else {
			oGenericUtils.gfn_Click_On_Object("label", "Generate Summaries");
		}

		oGenericUtils.gfn_Verify_Object_Exist("p",
				" Billed With AND/Billed Without OR logic needs to be completed before generating summaries.");
		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void validateBOBWConfigLinkandSubmit() throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		int iBOBWConfigLink = getDriver()
				.findElements(
						By.xpath(StringUtil.replace(oIUHomePage.AnchorTag, "sValue", "BW And/BWO or Config Logic")))
				.size();

		if (iBOBWConfigLink > 0) {
			verify("BOBW Config Link is Exist ", true);
		} else {
			verify("BOBW Config Link is NOT Exist ", false);

		}

		oGenericUtils.gfn_Click_On_Object("a", "BW And/BWO or Config Logic");

		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

		int iBOBWScreen = getDriver()
				.findElements(By.xpath(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Submit"))).size();

		if (iBOBWScreen > 0) {
			verify("BOBW Screen is Displayed ", true);
		} else {
			verify("BOBW Screen is NOT Displayed ", false);

		}

		List<WebElement> iBOBWRadioBtnCount = getDriver()
				.findElements(By.xpath("//div[@class='col-md-12 table_data ng-scope']//label//input"));

		for (int i = 0; i < iBOBWRadioBtnCount.size(); i++) {

			// String status_Config_Btn =
			// getDriver().findElement(By.xpath(oIUHomePage.Config)).getAttribute("disabled");

			String sChkBtnStatus = iBOBWRadioBtnCount.get(i).getAttribute("disabled");

			if (sChkBtnStatus != "true") {

				iBOBWRadioBtnCount.get(i).click();

			}
			System.out.println(sChkBtnStatus);

		}

		oGenericUtils.gfn_Verify_Object_Exist("button", "Submit");
		oGenericUtils.gfn_Click_On_Object("button", "Submit");
		oGenericUtils.gfn_Verify_Object_Exist("h3", "Success");
		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void userModifyCode(String arg1, String arg2, String sDecision) throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		switch (arg1) {

		case "MD MANUAL PROPOSALS":
			oSeleniumUtils.select_Given_Value_From_DropDown_Using_StringLocator(
					oIUHomePage.GetDynamicXPathWithRowCol("MANUALPROP FIELDS", 2, 3), sDecision);
			SeleniumUtils.defaultWait(ProjectVariables.MID_SLEEP);
			oSeleniumUtils.Enter_given_Text_Element(("//table[@id='Manual_Proposals_grid']//tr[2]//td[4]//textarea"),
					"Auto Test");

			oGenericUtils.gfn_Click_On_Object("label", "Save");
			oGenericUtils.gfn_Verify_Object_Exist("h3", "Success");
			oGenericUtils.gfn_Click_On_Object("button", "Ok");
			getDriver().switchTo().defaultContent();

			break;

		case "CPM MANUAL PROPOSALS":

			oSeleniumUtils.select_Given_Value_From_DropDown_Using_StringLocator(
					"//table[@id='cpmManualProposalGrid']//tr[2]//td[4]//select", sDecision);

			oSeleniumUtils.Enter_given_Text_Element("//table[@id='cpmManualProposalGrid']//tr[2]//td[6]//textarea",
					"Automation Testing");

			int k = getDriver().findElements(By.xpath("//table[@id='cpmManualProposalGrid']//tr[3]//td[4]//select"))
					.size();

			if (k > 0) {
				oSeleniumUtils.select_Given_Value_From_DropDown_Using_StringLocator(
						"//table[@id='cpmManualProposalGrid']//tr[3]//td[4]//select", sDecision);

				oSeleniumUtils.Enter_given_Text_Element("//table[@id='cpmManualProposalGrid']//tr[3]//td[6]//textarea",
						"Automation Testing");

				SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);
			}
			oSeleniumUtils.Click_given_Locator("(//label[text()='Save'])[2]");
			oGenericUtils.gfn_Verify_Object_Exist("h3", "Success");
			oGenericUtils.gfn_Click_On_Object("button", "Ok");
			getDriver().switchTo().defaultContent();

			break;

		case "CPM PROPOSALS":

			oSeleniumUtils
					.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "CPM Decisions"));

			int oProposalsList = getDriver()
					.findElements(By
							.xpath("//table[@id='cpmProposalGrid']//tbody//tr//following-sibling::tr//input[@type='checkbox' and @role='checkbox']"))
					.size();

			if (oProposalsList > 0) {

				for (int i = 1; i <= oProposalsList; i++) {

					SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

					oSeleniumUtils.select_Given_Value_From_DropDown_Using_StringLocator(
							"//select[@id='" + i + "_cpmDecisionAction.decisionActionKey']", sDecision);

					oSeleniumUtils.Enter_given_Text_Element("//textarea[@id='" + i + "_cpmInterpComment.comments']",
							"Automation Testing");
				}

			} else {

				oSeleniumUtils.select_Given_Value_From_DropDown_Using_StringLocator(
						"//select[@id='1_cpmDecisionAction.decisionActionKey']", sDecision);

				oSeleniumUtils.Enter_given_Text_Element("//textarea[@id='1_cpmInterpComment.comments']",
						"Automation Testing");
			}

			oGenericUtils.gfn_Click_On_Object("label", "Save");
			oGenericUtils.gfn_Verify_Object_Exist("h3", "Success");
			oGenericUtils.gfn_Click_On_Object("button", "Ok");
			getDriver().switchTo().defaultContent();

			break;
			
		case "CPM MANUALPROPOSALS NOSAVE":

			oSeleniumUtils.select_Given_Value_From_DropDown_Using_StringLocator(
					"//table[@id='cpmManualProposalGrid']//tr[2]//td[4]//select", sDecision);

			oSeleniumUtils.Enter_given_Text_Element("//table[@id='cpmManualProposalGrid']//tr[2]//td[6]//textarea",
					"Automation Testing");

			int l = getDriver().findElements(By.xpath("//table[@id='cpmManualProposalGrid']//tr[3]//td[4]//select"))
					.size();

			if (l > 0) {
				oSeleniumUtils.select_Given_Value_From_DropDown_Using_StringLocator(
						"//table[@id='cpmManualProposalGrid']//tr[3]//td[4]//select", sDecision);

				oSeleniumUtils.Enter_given_Text_Element("//table[@id='cpmManualProposalGrid']//tr[3]//td[6]//textarea",
						"Automation Testing");

				SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);
			}
			oSeleniumUtils.Click_given_Locator("(//label[text()='Save'])[2]");
			
			getDriver().switchTo().defaultContent();

			break;
		}

	}

	@Step
	public void clickOnCPMValidateErrMsg(String arg1) throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		switch (arg1) {
		case "CPM":

			oSeleniumUtils
					.Click_given_Locator((StringUtil.replace(oIUHomePage.LabelTag, "sValue", "CPM Decision Complete")));

			int iBOBWScreen = getDriver()
					.findElements(By.xpath(StringUtil.replace(oIUHomePage.pTag, "sValue",
							" Billed With AND/Billed Without OR logic needs to be completed before CPM Decision Complete.")))
					.size();

			if (iBOBWScreen > 0) {
				verify("BOBW CPM Error Screen is Displayed ", true);
				oGenericUtils.gfn_Click_On_Object("button", "Ok");

			} else {
				verify("BOBW CPM Error Screen is NOT Displayed ", false);

			}

			break;

		case "EmptyNoDecisionError":
//			oSeleniumUtils
//					.Click_given_Locator((StringUtil.replace(oIUHomePage.LabelTag, "sValue", "CPM Decision Complete")));

			int jBOBWScreen = getDriver().findElements(By.xpath("//p[contains(text(),' CPM Decision should not be Blank or No Decision.')]")).size();
					
			if (jBOBWScreen > 0) {
				verify("CPM Decision should not be Blank ", true);
				oGenericUtils.gfn_Click_On_Object("button", "Ok");

			} else {
				verify("NOT DISPLAYED CPM Decision should not be Blank ", false);

			}

			break;
		}

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void validateUserBWBWOLink(String arg1, String arg2) throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		int iBOBWConfigLink = getDriver()
				.findElements(
						By.xpath(StringUtil.replace(oIUHomePage.AnchorTag, "sValue", "BW And/BWO or Config Logic")))
				.size();

		switch (arg1) {

		case "CPM":

			if (iBOBWConfigLink > 0) {
				verify("BOBW Config Link is Exist ", true);
			} else {
				verify("BOBW Config Link is NOT Exist ", false);

			}

			oGenericUtils.gfn_Click_On_Object("a", "BW And/BWO or Config Logic");

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			int iBOBWScreen = getDriver()
					.findElements(By.xpath(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Submit"))).size();

			if (iBOBWScreen > 0) {
				verify("BOBW Screen is Displayed ", true);
			} else {
				verify("BOBW Screen is NOT Displayed ", false);

			}

			List<WebElement> iBOBWUser = getDriver()
					.findElements(By.xpath("//span[text()='(Updated By the User: iht_ittest01)']"));

			for (int i = 0; i < iBOBWUser.size(); i++) {

				if (iBOBWUser.get(i).getText().contains(arg2)) {
					verify("Updated user is displayed in BOBW Screen", true);
				} else {
					verify("Updated user is NOT displayed in BOBW Screen", false);

				}
			}

			oGenericUtils.gfn_Click_On_Object("button", "Cancel");
			break;

		case "NOLINK":

			WebElement iBOBWConfigLink2 = getDriver().findElement(
					By.xpath(StringUtil.replace(oIUHomePage.AnchorTag, "sValue", "BW And/BWO or Config Logic")));

			if (!(iBOBWConfigLink2.isDisplayed())) {

				verify("BOBW Config Link Should not displayed ", true);

			} else {
				verify("BOBW Config Link is Exist ", false);

			}

			break;

		}

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void clickonRequirePresentation(String arg1) throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_SLEEP);
		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);
		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "CPM Decisions"));
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		String sRPPayer = "";
		String sRequirePresentationPayer = "";
		switch (arg1) {

		case "StatusValidate":

			oSeleniumUtils
					.Click_given_Locator(StringUtil.replace(oIUHomePage.LabelTag, "sValue", "Requires Presentation"));
			oGenericUtils.gfn_Verify_Object_Exist("h4", "CPM: Change Requires Presentation Status");
			String status_Require_Presentation_Chkbox = getDriver()
					.findElement(By.xpath("(//table[@id='requirePresentationGrid'])//tr[2]"))
					.getAttribute("aria-selected");

			if (status_Require_Presentation_Chkbox != "true") {
				verify("Require Presentation status is checked", true);
			} else {
				verify("Require Presentation status is NOT checked", false);
			}
			oSeleniumUtils.Click_given_Locator(oIUHomePage.RequirePresentCancel);

			break;

		case "SELECT":
		case "UNSELECT":

			oSeleniumUtils
					.Click_given_Locator(StringUtil.replace(oIUHomePage.LabelTag, "sValue", "Requires Presentation"));
			oGenericUtils.gfn_Verify_Object_Exist("h4", "CPM: Change Requires Presentation Status");

			oSeleniumUtils.Click_given_WebElement(oIUHomePage.SelectRequirePresent1);

			sRequirePresentationPayer = getDriver()
					.findElement(By.xpath("((//table[@id='requirePresentationGrid']//tr)[2])//td[3]"))
					.getAttribute("title");

			System.out.print(sRequirePresentationPayer);

			Serenity.setSessionVariable("sRequirePresentationPayer").to(sRPPayer);

			oSeleniumUtils.Click_given_Locator(oIUHomePage.Save_Button);

			oGenericUtils.gfn_Verify_Object_Exist("p",
					"All the decisions recorded for the payer will be lost and sensitivities will be refreshed once a payer is set to Requires Presentation.");

			oSeleniumUtils.Click_given_Locator(oIUHomePage.Continue_Button);

			oGenericUtils.gfn_Click_On_Object("button", "Ok");

			break;

		case "SELECTFIRST":
		case "UNSELECTFIRST":

			oSeleniumUtils
					.Click_given_Locator(StringUtil.replace(oIUHomePage.LabelTag, "sValue", "Requires Presentation"));
			oGenericUtils.gfn_Verify_Object_Exist("h4", "CPM: Change Requires Presentation Status");

			oSeleniumUtils.Click_given_WebElement(oIUHomePage.SelectFirstRequirePresent);

			sRequirePresentationPayer = getDriver()
					.findElement(By.xpath("((//table[@id='requirePresentationGrid']//tr)[2])//td[3]"))
					.getAttribute("title");

			System.out.print(sRequirePresentationPayer);

			Serenity.setSessionVariable("sRequirePresentationPayer").to(sRPPayer);

			System.out.println(Serenity.sessionVariableCalled("sRequirePresentationPayer").toString());

			verify("Selected Payer is  :" + Serenity.sessionVariableCalled("sRequirePresentationPayer").toString(),
					true);

			// verify("Selected Rule is :" +
			// Serenity.sessionVariableCalled("MidRuleVersion").toString(),
			// true);

			oSeleniumUtils.Click_given_Locator(oIUHomePage.Save_Button);

			oGenericUtils.gfn_Verify_Object_Exist("p",
					"All the decisions recorded for the payer will be lost and sensitivities will be refreshed once a payer is set to Requires Presentation.");

			oSeleniumUtils.Click_given_Locator(oIUHomePage.Continue_Button);

			oGenericUtils.gfn_Click_On_Object("button", "Ok");

			break;

		case "UNSELECT2":

			oSeleniumUtils
					.Click_given_Locator(StringUtil.replace(oIUHomePage.LabelTag, "sValue", "Requires Presentation"));
			oGenericUtils.gfn_Verify_Object_Exist("h4", "CPM: Change Requires Presentation Status");

			oSeleniumUtils.Click_given_WebElement(oIUHomePage.SelectRequirePresent1);

			oSeleniumUtils.Click_given_Locator(oIUHomePage.Save_Button);

			oGenericUtils.gfn_Verify_Object_Exist("p",
					"All the decisions recorded for the payer will be lost and sensitivities will be refreshed once a payer is set to Requires Presentation.");

			oSeleniumUtils.Click_given_Locator(oIUHomePage.Continue_Button);

			oGenericUtils.gfn_Click_On_Object("button", "Ok");

			break;

		default:

			oGenericUtils.gfn_Click_On_Object("label", "Requires Presentation");
			oGenericUtils.gfn_Verify_Object_Exist("h4", "CPM: Change Requires Presentation Status");
			// oGenericUtils.gfn_Click_String_object_Xpath("(//table[@id='requirePresentationGrid']//input)[1]");
			oGenericUtils.gfn_Click_String_object_Xpath("//input[@id='cb_requirePresentationGrid']");

			Serenity.setSessionVariable("CPMReviewPayer")
					.to(oSeleniumUtils.get_TextFrom_Locator(oIUHomePage.RequirePresentReviewPayer));

			oSeleniumUtils.Click_given_Locator(oIUHomePage.RequirePresentSave);
			oGenericUtils.gfn_Verify_Object_Exist("p",
					"All the decisions recorded for the payer will be lost and sensitivities will be refreshed once a payer is set to Requires Presentation.");
			oSeleniumUtils.Click_given_Locator(oIUHomePage.Continue_Button);

			// oGenericUtils.gfn_Click_On_Object("button", "Ok");

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);
			// oGenericUtils.gfn_Click_On_Object("button", "Ok");

			break;
		}

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void validate_editorial_update_popup(String sTab) throws InterruptedException {

		oIUHomePage.Click_on_Editorial();

		List<String> sTabs = Arrays.asList(sTab.split(";"));

		for (int i = 0; i < sTabs.size(); i++) {

			if (sTabs.get(i).equalsIgnoreCase("New Rule Description")) {

				oGenericUtils.gfn_Click_On_Object("span", "Description");

			} else {
				oGenericUtils.gfn_Click_On_Object("span", sTabs.get(i));
			}

			validatePopUpTabsInEditorial(sTabs.get(i));

			perfromEditorialActions("Reset", sTabs.get(i));

			validatePopUpTabsInEditorial(sTabs.get(i));

			perfromEditorialActions("Refresh", sTabs.get(i));

			validatePopUpTabsInEditorial(sTabs.get(i));

			perfromEditorialActions("Cancel", sTabs.get(i));

		}

		oGenericUtils.gfn_Click_On_Object("span", "Description");

		validatePopUpTabsInEditorial("New Rule Description");

		oGenericUtils.gfn_Click_On_Object("label", "Update Resolved Description");

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		String sResolvedRuleDescription = oIUHomePage.ResolvedRuleDescription.getAttribute("value");

		int cResolvedRuleDescription = sResolvedRuleDescription.length();

		String sResolvedRuleCharacterCount = oSeleniumUtils
				.get_TextFrom_Locator(oIUHomePage.ResolvedRuleCharacterCount);

		int iResolvedRuleCharacterCount = Integer.parseInt(sResolvedRuleCharacterCount);

		verify("Resolved Rule Description char count " + iResolvedRuleCharacterCount
				+ " is matching with length of data present in resolved rule description" + cResolvedRuleDescription,
				iResolvedRuleCharacterCount == cResolvedRuleDescription);

		oSeleniumUtils.Click_given_Locator(
				StringUtil.replace(oIUHomePage.No_Edit_Required, "sValue", "No Editorial Changes Required"));

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		verify("Confirmation Warning should be displayed", oSeleniumUtils.is_WebElement_Displayed(
				StringUtil.replace(oIUHomePage.pTag, "sValue", ProjectVariables.Editorial_MSG_NC_Required)));

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oSeleniumUtils.Click_given_WebElement(oIUHomePage.Confirm_Yes);

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		verify("Confirmation Warning should be displayed", oSeleniumUtils.is_WebElement_Displayed(
				StringUtil.replace(oIUHomePage.pTag, "sValue", ProjectVariables.Editorial_MSG_Editorial_Saved)));

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		WebElement oUnsetNoEditorialChangesRequiredbutton = getDriver().findElement(
				By.xpath(StringUtils.replace(oIUHomePage.LabelTag, "sValue", "Unset No Editorial Changes Required")));

		verify("Unset No Editorial Changes Required button", oUnsetNoEditorialChangesRequiredbutton.isDisplayed());

		getDriver().close();

		SeleniumUtils.switchWindowUsingWindowCount(3, 1, getDriver());

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void validatePopUpTabsInEditorial(String sValue) {

		WebElement oEditorialDescription = getDriver()
				.findElement(By.xpath(StringUtils.replace(oIUHomePage.EditDescriptioninEditorial, "sValue", sValue)));

		String sEditNewRuleDescription = oEditorialDescription.getAttribute("value");

		Serenity.setSessionVariable("EditNewRuleDescription").to(sEditNewRuleDescription.replaceAll("\\s", ""));

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.Enter_given_Text_Element(oEditorialDescription, "Test");

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		WebElement oMarkupText = getDriver()
				.findElement(By.xpath(StringUtils.replace(oIUHomePage.MarkUpinEditorial, "sValue", sValue)));

		verify("Markup Text is displayed for " + sValue + ":-" + oMarkupText.getText().trim() + "Edit" + sValue + ":-"
				+ sEditNewRuleDescription.trim(),
				sEditNewRuleDescription.replaceAll("\\s", "")
						.equalsIgnoreCase(oMarkupText.getText().replaceAll("\\s", "")));

		Serenity.setSessionVariable("MarkupText").to(oMarkupText.getText().replaceAll("\\s", ""));

		WebElement oUpdatedText = getDriver()
				.findElement(By.xpath(StringUtils.replace(oIUHomePage.UpdatedTextinEditorial, "sValue", sValue)));

		verify("Updated Text is displayed for" + sValue,
				"Test".toString().equalsIgnoreCase(oUpdatedText.getText().trim()));

	}

	@Step
	public void perfromEditorialActions(String sAction, String sValue) throws InterruptedException {

		switch (sAction) {
		case "Refresh":

			oSeleniumUtils
					.Click_given_Locator(oIUHomePage.GetDynamicXPathWithString("EditorialActions", sValue, sAction));

			oGenericUtils.gfn_Click_On_Object("button", "Refresh Data");

			oGenericUtils.gfn_Click_On_Object("button", "Ok");

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			verify("After refreshing same text appears in edit description" + sValue,
					Serenity.sessionVariableCalled("MarkupText").toString()
							.equalsIgnoreCase(Serenity.sessionVariableCalled("EditNewRuleDescription")));

			break;
		case "Reset":

			oSeleniumUtils
					.Click_given_Locator(oIUHomePage.GetDynamicXPathWithString("EditorialActions", sValue, sAction));

			oGenericUtils.gfn_Click_On_Object("button", "Reset Data");

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			verify("After Reseting same text appears in edit description" + sValue,
					Serenity.sessionVariableCalled("MarkupText").toString()
							.equalsIgnoreCase(Serenity.sessionVariableCalled("EditNewRuleDescription")));

			break;
		case "Cancel":

			oGenericUtils.gfn_Click_On_Object("label", "Cancel");

			oSeleniumUtils.Click_given_Locator(oIUHomePage.EditorialPopYesBtn);

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			verify("After cancel same text appears in edit description" + sValue,
					Serenity.sessionVariableCalled("MarkupText").toString()
							.equalsIgnoreCase(Serenity.sessionVariableCalled("EditNewRuleDescription")));

			break;

		default:
			Assert.assertTrue("No matching case", false);

		}

	}

	@Step
	public void user_navigate_to_group_task_IU_screen() {

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.GroupTaskTab);

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

	}

	@Step
	public void click_task_by_instance_name_in_group_tasks_tab(String sTask, String FilterValue)
			throws InterruptedException {

		Serenity.setSessionVariable("IUInstanceName").to(ProjectVariables.FinalMDInstance);

		List<WebElement> oTaskNames = getDriver().findElements(By.xpath("//tr[(td[2]='" + sTask + "')]//td[2]//div"));

		for (int i = 0; i < oTaskNames.size(); i++) {

			if (oTaskNames.get(i).getText().equalsIgnoreCase(sTask)) {

				WebElement oTaskName1 = getDriver()
						.findElement(By.xpath("//tr[(td[2]='" + sTask + "')][" + (i + 1) + "]//td[2]//div"));

				String sGroupTaskInstanceName = oSeleniumUtils
						.get_TextFrom_Locator("//tr[(td[2]='" + sTask + "')][" + (i + 1) + "]//td[3]//div");

				Serenity.setSessionVariable("Pool").to(sGroupTaskInstanceName);

				if (sGroupTaskInstanceName.equalsIgnoreCase(ProjectVariables.FinalMDInstance)) {

					oTaskName1.click();

					oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

					break;
				}

			}

		}

		if (FilterValue.equalsIgnoreCase("EditorialPool")) {

			applyActiveFilterMyTaskRuleWorkQueue("Assignees", FilterValue);
// fix required for str 
//			String str = StringUtils.substringBefore(FilterValue, "Pool");
//
//			applyActiveFilterMyTaskRuleWorkQueue("Task", str + " Review");
//
//			String sRuleText = oSeleniumUtils.get_TextFrom_Locator(
//					"(//div[@class='GEFT4QHBMHC'])[4]//tr[@class='GEFT4QHBK3C GEFT4QHBFN'][1]//td[@cellindex='1']//div");
//
//			Serenity.setSessionVariable("PoolRuleText").to(sRuleText);
//
//			WebElement sRuleCheckbox = getDriver().findElement(By.xpath(
//					("(//div[@class='GEFT4QHBMHC'])[4]//tr[@class='GEFT4QHBK3C GEFT4QHBFN'][1]//td[@cellindex='0']//div[1]//div")));
//
//			sRuleCheckbox.click();
//
//			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
//
//			oGenericUtils.gfn_Click_On_Object("div", "Claim Tasks");

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			oIUHomePage.closeAllTabs();
		}

	}

	@Step
	public void validate_multiple_rule_id() {

		oIUHomePage.go_To_Rule(Serenity.sessionVariableCalled("MidRuleVersion"));
		// oIUHomePage.go_To_Rule(Serenity.sessionVariableCalled("PoolRuleText"));

		WebElement oRuleVersion = getDriver()
				.findElement(By.xpath("//div[text()='" + Serenity.sessionVariableCalled("MidRuleVersion") + "']"));

		/*
		 * WebElement oRuleVersion = getDriver()
		 * .findElement(By.xpath("//div[text()='" +
		 * Serenity.sessionVariableCalled("PoolRuleText") + "']"));
		 */
		verify("Rule Value is displayed", oRuleVersion.isDisplayed());

	}

	@Step
	public void validateCPMAndMDDecision() throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_SLEEP);
		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);
		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "CPM Decisions"));

		String sCPMDecision = oSeleniumUtils
				.get_FirstSelected_Option_In_DropDown("(//table[@id='cpmProposalGrid'])//tr[2]//td[4]//select");

		System.out.println(sCPMDecision);

		String sMDRecommendation = oSeleniumUtils
				.get_TextFrom_Locator((oIUHomePage.GetDynamicXPath("CPM SYSTEMPROPOSAL", 7)));
		System.out.println(sMDRecommendation);

		Assert.assertTrue("Default value in Referenced Conditoned code",
				sMDRecommendation.equalsIgnoreCase(oSeleniumUtils.get_FirstSelected_Option_In_DropDown(
						"(//table[@id='cpmProposalGrid'])//tr[2]//td[4]//select")));

		if (sCPMDecision.equalsIgnoreCase(sMDRecommendation)) {
			verify("CPM Decisions and MD Recommendation should be same", true);
		} else {
			verify("CPM Decision and MD Recommendation are NOT SAME" + "Actual MD Recommendation is : "
					+ sMDRecommendation, false);

		}

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void validatePayerinCPMProposal(String sCase, String sDecision) throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_SLEEP);

		switch (sCase) {

		case "Payer CPM Proposals":
			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);
			oSeleniumUtils
					.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "CPM Decisions"));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.CPMDecisionsLists, "sValue", "By Payer"));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			List<WebElement> iPayersCount = getDriver()
					.findElements(By.xpath("//td[@aria-describedby='cpmProposalGrid_1_t_payerShort']"));

			for (int i = 0; i < iPayersCount.size(); i++) {
				System.out.println(iPayersCount.get(i).getText());

				String sText = Serenity.sessionVariableCalled("sRPPayer");

				if (!(iPayersCount.get(i).getText().equals(sText))) {

					verify(sText + " Payer is not displayed ", true);

				} else {

					verify(Serenity.sessionVariableCalled("sRPPayer")
							+ " Payer is displayed which should not be displayed", false);

				}
			}

			oSeleniumUtils.Click_given_Locator("(//table[@id='cpmProposalGrid'])//tr[2]//td[5]//select");
			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.CPMDecisionsLists, "sValue", "All"));
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.CPMSystemPropsalSave);
			oGenericUtils.gfn_Click_On_Object("button", "Ok");
			getDriver().switchTo().defaultContent();

			break;

		case "Presentation Warning":
			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);
			SeleniumUtils.defaultWait(ProjectVariables.MID_SLEEP);
			oSeleniumUtils
					.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "CPM Summaries"));
			SeleniumUtils.defaultWait(ProjectVariables.MID_SLEEP);
			oGenericUtils.gfn_Verify_String_Object_Exist(oIUHomePage.CPMReviewPayerWarning);
			getDriver().switchTo().defaultContent();

			break;

		}

	}

	@Step
	public void selDifferentDecisionAtCPMPayerLevel() throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "CPM Decisions"));

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.CPMDecisionsLists, "sValue", "By Payer"));

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		List<WebElement> iCPMDecisionCount = getDriver().findElements(
				By.xpath("//td[@aria-describedby='cpmProposalGrid_1_t_decisionAction.decisionActionKey']"));

		String arr[] = { "NO ACTION", "REMOVE" };

		for (int i = 0; i < iCPMDecisionCount.size(); i++) {

			System.out.println(iCPMDecisionCount.get(i).getText());

			iCPMDecisionCount.get(i).click();

			iCPMDecisionCount.get(i).click();

			int j = i + 1;

			String sRandomDecesion = arr[0];

			System.out.println((StringUtil.replace(oIUHomePage.GetDynamicXPath("CPM SYSTEMPROPOSAL2", 1), "sValue",
					sRandomDecesion)));

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.GetDynamicXPath("CPM SYSTEMPROPOSAL2", j),
					"sValue", sRandomDecesion));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.GetDynamicXPath("CPM PAYERSPEC COMMENTS", j),
					"Test Auto Comments");

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			arr[0] = arr[1];

		}

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.CPMSystemPropsalSave);

		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		getDriver().switchTo().defaultContent();
	}

	@Step
	public void setCPMDecisionAsMDRecommend() throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_SLEEP);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "CPM Decisions"));

		String sMDRecommendation = oSeleniumUtils
				.get_TextFrom_Locator(oIUHomePage.GetDynamicXPath("CPM SYSTEMPROPOSAL", 7));

		System.out.println(sMDRecommendation);

		oSeleniumUtils.Click_given_Locator(oIUHomePage.GetDynamicXPath("CPM SYSTEMPROPOSAL", 4));

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oSeleniumUtils
				.Click_given_Locator((StringUtil.replace(oIUHomePage.CPMDecisionList, "sValue", sMDRecommendation)));

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		/*
		 * oSeleniumUtils.Click_given_Locator(oIUHomePage.GetDynamicXPath(
		 * "CPM SYSTEMPROPOSAL", 5));
		 * 
		 * SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		 * 
		 * oSeleniumUtils
		 * .Click_given_Locator((StringUtil.replace(oIUHomePage.CPMDecisionList,
		 * "sValue", "All")));
		 */

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.CPMDecisionsLists, "sValue", "All"));

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oSeleniumUtils.Enter_given_Text_Element("//textarea[@id='1_cpmInterpComment.comments']", "Test CPM Comments");

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.CPMSystemPropsalSave);

		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		getDriver().switchTo().defaultContent();
	}

	@Step
	public void selectMultiPayerRuleNoAssignee(int sPayerQuantity) throws InterruptedException {

		List<WebElement> sRowCount = getDriver()
				.findElements(By.xpath("(//table[@class = 'GEFT4QHBI3C'])[last()]/tbody[2]/tr"));

		ArrayList<String> sArrPayers = new ArrayList<String>();

		for (int i = 0; i < sRowCount.size(); i++) {

			String sXPayer = oIUHomePage.GetDynamicXPath("RULE PAYERS", i + 1);
			String sPayer = getDriver().findElement(By.xpath(sXPayer)).getText();
			String[] ArrPayers = sPayer.split(",");

			if (ArrPayers.length > sPayerQuantity) {

				String sXRule = oIUHomePage.GetDynamicXPath("RULE VERSION", i + 1);
				String sRule = getDriver().findElement(By.xpath(sXRule)).getText();
				Serenity.setSessionVariable("MidRuleVersion").to(sRule);

				verify("MidRule Version is :" + Serenity.sessionVariableCalled("MidRuleVersion").toString(), true);
				System.out.println("Rule No : " + Serenity.sessionVariableCalled("MidRuleVersion").toString());

				for (int j = 0; j < ArrPayers.length; j++) {
					String sAllPayers = ArrPayers[j].trim().split(" ")[0];
					System.out.println(sAllPayers);

					sArrPayers.add(sAllPayers);
				}
				break;

			}
		}
	}

	@Step
	public void navigateToAdminRuleReviewApplyFilters(String sRole, String sInstanceType, String sColoumnName,
			String sColumnValue) throws InterruptedException {

//		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oIUHomePage.closeAllTabs();

//		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oGenericUtils.gfn_Click_On_Object("span", "Administration");

		oGenericUtils.gfn_Click_On_Object("a", "Interpretive Update Instances");

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

//		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		clickInstanceinAdmin(sInstanceType);

		applyAdminActiveFilters(sColoumnName, sColumnValue);

	}

	@Step
	public void navigate_And_Validate_OVerviewReport() throws InterruptedException {

		oGenericUtils.gfn_Click_On_Object("div", "Overview");

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		verify("Not Started Link displayed sucessfully", oGenericUtils.gfn_Verify_Object_Exist("a", "Not Started"));

		verify("Started Link displayed sucessfully", oGenericUtils.gfn_Verify_Object_Exist("a", "Started"));

		verify("Completed Link displayed sucessfully", oGenericUtils.gfn_Click_On_Object("a", "Completed"));

		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

		String oCount = oSeleniumUtils.get_TextFrom_Locator("//a[text()='Expand all']/following-sibling::div[1]");

		Serenity.setSessionVariable("TotalNoofRules").to(oCount);

		System.out.println(
				"Previous Count of Completed rules" + Serenity.sessionVariableCalled("TotalNoofRules").toString());

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void get_rule_from_overview_report() throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		verify("Not Started Link clicked sucessfully", oGenericUtils.gfn_Click_On_Object("a", "Not Started"));

		verify("Collape All Button is clicked", oSeleniumUtils
				.Click_given_Locator(StringUtils.replace(oIUHomePage.AnchorTag, "sValue", "Collapse all")));

		verify("Expand All Button is clicked",
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(oIUHomePage.AnchorTag, "sValue", "Expand all")));

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		WebElement oele = getDriver().findElement(By.xpath("(//a[text()='Collapse all']/..//span)[7]"));

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		if (oele.isDisplayed()) {

			verify("ExpandReason clicked sucessfully",
					oGenericUtils.gfn_Click_String_object_Xpath("(//a[text()='Collapse all']/..//span)[7]"));

		}

		oGenericUtils.gfn_Verify_String_Object_Exist("//tr[@ng-repeat='node in node.details'][1]//td//button");

		String sRule = oSeleniumUtils.get_TextFrom_Locator("//tr[@ng-repeat='node in node.details'][1]//td//button");

		Serenity.setSessionVariable("MidRuleVersion").to(sRule);

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void setNoChangeRequiredInMDReview(String arg1) throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		if (arg1.equalsIgnoreCase("No Change Required")) {

			verify("No Change Required Button is Clicked in Rule Review WorkQueue",
					oGenericUtils.gfn_Click_String_object_Xpath(
							"(//label[contains(text(),'No Change Required')])[position()=last()]"));

			SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

			verify("Text entered in No change Required Popup", oSeleniumUtils.Enter_given_Text_Element(
					"//h3[text()='No Change Required']/../..//textarea", "Editorial PopUp Test"));

			verify("Set button is Clicked on Popup window",
					oGenericUtils.gfn_Click_String_object_Xpath("//button[contains(text(),'Set')]"));

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			int iWarning = getDriver()
					.findElements(By.xpath(StringUtils.replace(oIUHomePage.pTag, "sValue",
							"Editorial changes exist for the rule that will not be applied if rule is set to No Change Required.]")))
					.size();

			if (iWarning > 0) {

				verify("Continue with No Change Required button is clicked",
						oGenericUtils.gfn_Click_String_object_Xpath(
								"//button[contains(text(),'Continue with No Change Required')]"));

			}

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		} else {

			verify("Unset No Change Required Button is Clicked in Rule Review WorkQueue Page", oGenericUtils
					.gfn_Click_String_object_Xpath("//label[contains(text(),'Unset No Change Required')]"));

			verify("After Clicking Unset No Change Required in Review WorkQueue Page Popup Text Expected: Successfully done Unset No Change Required.",
					oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(oIUHomePage.pTagContains, "sValue",
							" Successfully done Unset No Change Required.")));

			verify("Ok button is clicked on the Popup", oGenericUtils.gfn_Click_On_Object("button", "Ok"));

		}

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void validate_rule_and_completed_count_in_overview_report() throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		verify("Completed Link clicked sucessfully", oGenericUtils.gfn_Click_On_Object("a", "Completed"));

		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

		String sCompletedCount = oSeleniumUtils
				.get_TextFrom_Locator("//a[text()='Expand all']/following-sibling::div[1]");

		int iPeviousCount = Integer.parseInt(Serenity.sessionVariableCalled("TotalNoofRules"));

		int iCompletedCount = Integer.parseInt(sCompletedCount);

		System.out.println("Prasent Completed Count" + iCompletedCount);

		if (iCompletedCount > iPeviousCount) {

			verify("Completed count is increased sucessfully", true);

		} else {

			verify("Completed count is not increased sucessfully", false);
		}
	}

	@Step
	public void select_rule_and_validate_ruleid_tab() throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		verify("Overview Rule clicked sucessfully",
				oGenericUtils.gfn_Click_String_object_Xpath("//tr[@ng-repeat='node in node.details'][1]//td//button"));

		System.out.println("selected RuleID Tab is displayed successfully"
				+ Serenity.sessionVariableCalled("MidRuleVersion").toString());

		getDriver().switchTo().defaultContent();

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		verify("selected RuleID Tab is displayed successfully",
				oGenericUtils.gfn_Verify_String_Object_Exist(
						(("//span[@class='x-tab-strip-inner']//span[@class='x-tab-strip-text  ' and text()='"
								+ Serenity.sessionVariableCalled("MidRuleVersion").toString() + "']"))));

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void validate_overview_ruleid_tab() throws InterruptedException {

		verify("selected RuleID Tab is displayed successfully",
				oGenericUtils.gfn_Verify_String_Object_Exist("//span[@class='x-tab-strip-text  ' and text()='"
						+ Serenity.sessionVariableCalled("MidRuleVersion").toString() + "']"));
	}

	@Step
	public void authorize_decisions_and_validate_warning_message() throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Summaries"));

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oGenericUtils.gfn_Click_String_object_Xpath(("//label[contains(text(),'Authorize Decisions')]"));

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		verify("Authorize Decisions Warning Message validation",
				oGenericUtils.gfn_Verify_Object_Exist("p", ProjectVariables.sPrelimMDWarningEditorialNotCompleted));

		verify("Yes Button is Clicked", oGenericUtils.gfn_Click_On_Object("button", "Yes"));

		verify("Ok button is Clicked", oGenericUtils.gfn_Click_On_Object("button", "Ok"));

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void retireRule() throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Summaries"));

		if (oGenericUtils.gfn_Verify_Object_Exist("span", "Retire Rule") == true) {

			oGenericUtils.gfn_Click_On_Object("span", "Retire Rule");

			oSeleniumUtils.select_Given_Value_From_DropDown(oIUHomePage.Retirerule_MDecision, "Do Not Retire Rule");

			oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.MD_Comments, ProjectVariables.TestComments);

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			oGenericUtils.gfn_Click_On_Object("button", "Save");

			oGenericUtils.gfn_Click_On_Object("button", "Ok");

			oGenericUtils.gfn_Click_On_Object("span", "Retire Rule");

		}

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void validate_MD_Comments_No_Decision(String arg) throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Comments"));

		if (oGenericUtils.gfn_Verify_Object_Exist("span", arg) == true) {

			oGenericUtils.gfn_Click_On_Object("span", arg);
		}

		oSeleniumUtils.Enter_given_Text_Element(StringUtil.replace(oIUHomePage.Final_MD_Comments, "sValue", arg),
				ProjectVariables.loMDTestComments);

		oGenericUtils.gfn_Click_On_Object("label", "Save");

		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Decisions"));

		oSeleniumUtils.Click_given_Locator(oIUHomePage.NoDecision);

		oGenericUtils.gfn_Click_On_Object("button", "Yes");

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void validate_cpm_decision_complete_alert(String sDecision) throws InterruptedException {

		String sAlert_Message = "PO has taken 'No Decision' on the rule. Please make sure you reviewed the PO comments on 'Comments' tab. Click 'Yes' to continue and 'No' to review PO comments.";

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "CPM Decisions"));

		oGenericUtils.gfn_Click_On_Object("label", "CPM Decision Complete");

		oGenericUtils.gfn_Verify_String_Object_Exist(oIUHomePage.MDAlertMessage);

		String sAlertMessge = oSeleniumUtils.get_TextFrom_Locator(oIUHomePage.MDAlertMessage);

		verify("Alert Message" + sAlert_Message,
				sAlert_Message.replaceAll("//s", "").equalsIgnoreCase(sAlertMessge.replaceAll("//s", "")));

		oGenericUtils.gfn_Click_On_Object("button", "No");

		boolean sCommentVal = validateMDCommentsInCPM(ProjectVariables.loMDTestComments);

		verify("MD Comments in CPM ", sCommentVal);

		getDriver().switchTo().defaultContent();

		userModifyCode("CPM PROPOSALS", "CpmAlert", sDecision);

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oGenericUtils.gfn_Click_On_Object("label", "CPM Decision Complete");

		oGenericUtils.gfn_Click_On_Object("button", "Yes");

		oGenericUtils.gfn_Click_On_Object("span", "OK");

		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		getDriver().switchTo().defaultContent();

	}

	private boolean validateMDCommentsInCPM(String loMDTestComments) throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Comments"));

		if (!oIUHomePage.FMDComments.isDisplayed()) {

			oGenericUtils.gfn_Click_On_Object("span", "Final PO Comments");

		}

		String sMdcomment = oIUHomePage.FMDComments.getAttribute("value");

		boolean bln = sMdcomment.trim().equalsIgnoreCase(ProjectVariables.loMDTestComments);

		verify("Md Comment is displayed", bln);

		return bln;
	}

	@Step
	public void verify_Modify_decisions_Tab() throws InterruptedException {

		verify("Verify Modify Decisions tab should not display",
				oGenericUtils.gfn_Verify_Object_Exist("label", "Modify Decisions"));

		String str = oIUHomePage.ModifyDecisions.getAttribute("disabled");

		verify("Authorize Decisions is Disabled", str.equalsIgnoreCase("disabled"));

	}

	@Step
	public void highlight_non_default_values_from_manual_proposals(String sProposalType, String sCategory,
			String sCPTCode, String sPOSCode, String sOverrideFlag) throws InterruptedException {

		String sArrayCode = null;

		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oGenericUtils.gfn_Click_On_Object("label", "Add Code");

		switch (sProposalType) {

		case "START NEW":

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.StartNewCode);

			oGenericUtils.gfn_Click_On_Object("a", "Start New");

			oSeleniumUtils.Click_given_Locator(
					"//table[@id='Manual_Proposals_grid']//tr[2]//td[2]//select//option[text()='Yes']");

			oSeleniumUtils.select_Given_Value_From_DropDown_Using_StringLocator(
					oIUHomePage.GetDynamicXPathWithRowCol("MANUALPROP FIELDS", 2, 3), "Manual Add");

			oSeleniumUtils.Enter_given_Text_Element(("//table[@id='Manual_Proposals_grid']//tr[2]//td[4]//textarea"),
					"Test");

			oSeleniumUtils.select_Given_Value_From_DropDown(oIUHomePage.ManualProposalCatgoryDropdwn, sCategory);

			oSeleniumUtils.Enter_given_Text_Element(("//table[@id='Manual_Proposals_grid']//tr[2]//td[6]//input"),
					sCPTCode);

			oSeleniumUtils.Enter_given_Text_Element(
					("//td[@aria-describedby='Manual_Proposals_grid_interpRuleCpt.posLike']//input"), sPOSCode);

			if (sOverrideFlag.equalsIgnoreCase("Yes")) {

				verify("OVerride flag should be unchecked", !oSeleniumUtils.is_WebElement_Selected(
						"//td[@aria-describedby='Manual_Proposals_grid_interpRuleCpt.override']//input"));

				oSeleniumUtils.Click_given_Locator(
						"//td[@aria-describedby='Manual_Proposals_grid_interpRuleCpt.override']//input");
			}

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			WebElement oColoumn = getDriver().findElement(
					By.xpath("//td[@aria-describedby='Manual_Proposals_grid_interpRuleCpt.dateTo']//input"));

			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", oColoumn);

			oGenericUtils.gfn_Click_String_object_Xpath(
					"//td[@aria-describedby='Manual_Proposals_grid_interpRuleCpt.dateFrom']//input");

			oSeleniumUtils.Enter_given_Text_Element("//input[@id='FromDOSDate']", "01/08/1656");

			oGenericUtils.gfn_Click_On_Object("span", "Ok");

			oGenericUtils.gfn_Click_String_object_Xpath(
					"//td[@aria-describedby='Manual_Proposals_grid_interpRuleCpt.dateTo']//input");

			oSeleniumUtils.Enter_given_Text_Element("//input[@id='ToDOSDate']", "01/05/2015");

			oGenericUtils.gfn_Click_On_Object("span", "Ok");

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			WebElement oColoumn1 = getDriver()
					.findElement(By.xpath("//table[@id='Manual_Proposals_grid']//input[@name='interpRuleCpt.daysLo']"));

			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", oColoumn1);

			verify("ICD flag should be unchecked", !oSeleniumUtils.is_WebElement_Selected(
					"//td[@aria-describedby='Manual_Proposals_grid_interpRuleCpt.invokeIcd']//input"));

			oSeleniumUtils.Click_given_Locator(
					"//td[@aria-describedby='Manual_Proposals_grid_interpRuleCpt.invokeIcd']//input");

			verify("calendar year should be unchecked",
					!oSeleniumUtils.is_WebElement_Selected("//input[@id='-1_interpRuleCpt.calendarYear']"));

			oSeleniumUtils.Click_given_Locator("//input[@id='-1_interpRuleCpt.calendarYear']");

			oSeleniumUtils.Enter_given_Text_Element(
					"//table[@id='Manual_Proposals_grid']//input[@name='interpRuleCpt.daysLo']", "15");

			oSeleniumUtils.Enter_given_Text_Element(
					"//table[@id='Manual_Proposals_grid']//input[@name='interpRuleCpt.daysHi']", "25");

			break;

		case "COPY CODE":

			break;

		default:
			Assert.assertTrue("Highlight_non_default_values_from_manual_proposals", false);

		}

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oGenericUtils.gfn_Click_On_Object("label", "Save");

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		String arr[] = { "0075T", "0009T", "0006T", "0007T", "0004T" };

		for (int i = 0; i < arr.length; i++) {

			sArrayCode = arr[i];

			int iErrorMsg = getDriver().findElements(By.xpath(StringUtil.replace(oIUHomePage.pTag, "sValue",
					" One or more proposals already exists. Please review duplicates and save."))).size();

			if (iErrorMsg > 0) {

				oGenericUtils.gfn_Click_On_Object("button", "Ok");
				oSeleniumUtils.Enter_given_Text_Element(("//table[@id='Manual_Proposals_grid']//tr[2]//td[6]//input"),
						sArrayCode);
				oGenericUtils.gfn_Click_On_Object("label", "Save");

			}

			int iMsg = getDriver().findElements(By.xpath(StringUtil.replace(oIUHomePage.h3Tag, "sValue", "Success")))
					.size();

			if (iMsg > 0) {
				break;
			}

		}

		oGenericUtils.gfn_Verify_Object_Exist("h3", "Success");
		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		String[] str = ProjectVariables.HiglightedColumns;

		for (int i = 1; i <= str.length; i++) {

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			verify("check given coloumn is highlighted" + str[i - 1],
					oSeleniumUtils.is_WebElement_Displayed(
							"//table[@id='Decision_Summary_Manul_Proposals_grid']//tr[2]//td[contains(@style,'rgb')]["
									+ i + "]"));

		}

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void verify_highlighted_fields_from_summaries() throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Summaries"));

		oGenericUtils.gfn_Click_On_Object("span", "Decision Summary");

		String[] str = ProjectVariables.HiglightedColumns;

		for (int i = 1; i <= str.length; i++) {

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			verify("check given coloumn is highlighted" + str[i - 1],
					oSeleniumUtils.is_WebElement_Displayed(
							"//table[@id='Decision_Summary_Manul_Proposals_grid']//tr[2]//td[contains(@style,'rgb')]["
									+ i + "]"));

		}

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void get_total_rules_count_inRuleReviewWorkQueu() {

		String sRulesCount = oSeleniumUtils
				.get_TextFrom_Locator("(//div[contains(text(),'Displaying')])[position()=last()]");

		String sValue = StringUtils.substringAfter(sRulesCount, "of").trim();

		System.out.println(StringUtils.substringAfter(sRulesCount, "of").trim());

		Serenity.setSessionVariable("TotalCountInRuleReview").to(sValue);

	}

	@Step
	public void navigate_to_IU_report(String arg1) throws InterruptedException {

		List<String> sList = Arrays.asList(arg1.split(";"));

		if (sList.size() > 1) {

			for (int i = 0; i < sList.size(); i++) {

				oGenericUtils.gfn_Click_On_Object("div", "Report");

				SeleniumUtils.switchWindowUsingWindowCount(2, 2, getDriver());

				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

				oGenericUtils.gfn_Click_On_Object("div", sList.get(i));

				SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

				SeleniumUtils.switchWindowUsingWindowCount(2, 1, getDriver());

			}

		} else {

			oGenericUtils.gfn_Click_On_Object("div", "Report");

			SeleniumUtils.switchWindowUsingWindowCount(2, 2, getDriver());

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oGenericUtils.gfn_Click_On_Object("div", arg1);

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		}

	}

	@Step
	public void get_IU_Report_rule_count() throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.SummaryGroup1);

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.SummaryGroup2);

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.SummaryGroup3);

		oGenericUtils.gfn_Click_On_Object("div", "Search");

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		String sTotalRuleCountInIUReport = oSeleniumUtils
				.get_TextFrom_Locator("//td[text()='Totals : ']/following-sibling::td[1]");

		Serenity.setSessionVariable("TotalRuleCountInIUReport").to(sTotalRuleCountInIUReport);

		System.out.println("TotalRuleCountInIUReport" + sTotalRuleCountInIUReport);

	}

	@Step
	public void validate_IU_Report_count_with_total_rules_count() throws InterruptedException {

		verify("IU Report count with total rules count in Rule Review Work Queue",
				Serenity.sessionVariableCalled("TotalCountInRuleReview").toString()
						.equalsIgnoreCase(Serenity.sessionVariableCalled("TotalRuleCountInIUReport").toString()));

	}

	@Step
	public void click_on_instance_with_status_from_Admin(String sStatus) throws InterruptedException {

		oSeleniumUtils
				.Click_given_Locator(StringUtils.replace(oIUHomePage.AdminScrubInstanceInAdmin, "sValue", sStatus));

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.Actions);

		oGenericUtils.gfn_Click_On_Object("span", "Rule Review");

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

	}

	@Step
	public void select_rule_with_columnheader(String scolumn, String sHeaderValue) {

		List<WebElement> sRuleHeaderList = getDriver()
				.findElements(By.xpath("//td[@cellindex=12]//div[@class='GEFT4QHBE3C']"));

		for (int i = 0; i < sRuleHeaderList.size(); i++) {

			if (sRuleHeaderList.get(i).getText().equalsIgnoreCase(sHeaderValue)) {

				String str = oSeleniumUtils.get_TextFrom_Locator(
						"//td[@cellindex='1' and @class='GEFT4QHBC3C']//div[@class='GEFT4QHBE3C iht-HyperLinkText']["
								+ (i + 1) + "]");

				Serenity.setSessionVariable("MidRuleVersion").to(str);
			}

		}

	}

	@Step
	public void delete_manual_prop() throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		if (oGenericUtils
				.gfn_Click_String_object_Xpath("(//span[text()='Manual Proposals'])[position()=last()]") == true) {

			oGenericUtils.gfn_Click_String_object_Xpath("//input[@id='cb_Manual_Proposals_grid']");

			oGenericUtils.gfn_Click_On_Object("label", "Delete Selected");

			oGenericUtils.gfn_Click_On_Object("button", "Yes");

			oGenericUtils.gfn_Click_On_Object("label", "Save");

			oGenericUtils.gfn_Click_On_Object("button", "Ok");
		}

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void verify_run_type_column(String sRuntype) throws InterruptedException {

		oGenericUtils.gfn_Click_On_Object("div", "CPM Review Report");

		oGenericUtils.gfn_Click_On_Object("div", "Rule Review Report");

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.SwitchToFrame("//iframe[@class='gwt-Frame']");

		oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.RunTypeSearchBox, sRuntype);

		boolean bln = oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.RunTypeValue);

		verify("VERIFY_RUN_TYPE_COLUMN" + sRuntype, bln);

		getDriver().switchTo().defaultContent();
	}

	@Step
	public void validate_in_IU_Reports(String arg1) throws InterruptedException {

		String[] sRuleReviewColumnsList = { "Run Type", "Mid Rule", "Version", "Type", "Medical Policy", "Topic", "DP",
				"Task", "Task Status", "Prelim PO", "Prelim Peer", "Final PO", "Final Peer", "CPM(s)", "Review Payers",
				"Editorial User (Edtiorials)", "Editorial User (Potential Conflicts)", "QA", "Config", "Testing" };

		oSeleniumUtils.SwitchToFrame("//iframe[@class='gwt-Frame']");

		scrollToColumn(arg1, "span", sRuleReviewColumnsList);

		getDriver().switchTo().defaultContent();
	}

	@Step
	public void show_rule_review_code(String arg1) throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oGenericUtils.gfn_Click_String_object_Xpath("//tab-heading[text()='Decisions']");

		boolean bln = !oSeleniumUtils.is_WebElement_Selected("//input[@id='showDescriptions']");

		verify("showDescriptions_MD should not be selected", bln);

		oGenericUtils.gfn_Click_String_object_Xpath("//input[@id='showDescriptions']");

		verify("showDescriptions_MD should not be selected", oSeleniumUtils.is_WebElement_Displayed(
				"//td[@class='wrapColumnText']//textarea[@class='form-control ng-pristine ng-valid']"));

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void close_IU_Report_window() {

		getDriver().close();

	}

	public void complete_all_QA_Reviews() throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oGenericUtils.gfn_Verify_String_Object_Exist(oIUHomePage.QAReviewSegment);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "QA"));

		List<WebElement> rows = getDriver().findElements(By.xpath(oIUHomePage.QA_Review_Table));

		String sReviewSegValue = null;

		for (int i = 2; i <= rows.size(); i++) {

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "QA"));

			String sVal = Integer.toString(i);

			sReviewSegValue = oSeleniumUtils
					.get_TextFrom_Locator(StringUtil.replace(oIUHomePage.QA_Review_Table_Item, "sValue", sVal));

			// if (!(sReviewSegValue == "Editorials")) {
			if (!(sReviewSegValue.equalsIgnoreCase("Editorials"))) {

				oSeleniumUtils
						.Click_given_Locator(StringUtil.replace(oIUHomePage.QA_Review_Table_Item, "sValue", sVal));
				SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

			}

			switch (sReviewSegValue) {
			case "BW And/BWO Or Logic":
				oGenericUtils.gfn_Verify_Object_Exist("h3", "Billed With And/Billed Without Or Code Clarification");

				if (!(oIUHomePage.NewBilled_Radio_button.isSelected())) {

					oSeleniumUtils.Click_given_WebElement(oIUHomePage.NewBilled_Radio_button);
				}
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
				oSeleniumUtils.Click_given_Locator(oIUHomePage.Complete_QA_Review_Sub);
				userClickOnReviewSuccessMsg(sReviewSegValue);
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

				break;

			case "Impact Code List":

				SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

				int icount = getDriver().findElements(By.xpath(oIUHomePage.ImpactReviewCodeList)).size();

				if (icount > 0) {

					if (!(oIUHomePage.ImpactChkName.isSelected())) {
						oSeleniumUtils.highlightElement(oIUHomePage.ImpactReviewCodeAll);
						oSeleniumUtils.Click_given_WebElement(oIUHomePage.ImpactReviewCodeAll);
						SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
					} else {
						System.out.println("Radio button is not availble");
					}
				}

				oSeleniumUtils.highlightElement(oIUHomePage.Complete_QA_Review);
				SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
				if (icount > 0) {
					oSeleniumUtils.Click_given_Locator(oIUHomePage.QAReview_Category);
				}
				oSeleniumUtils.highlightElement(oIUHomePage.Complete_QA_Review);
				oSeleniumUtils.highlightElement(oIUHomePage.Complete_QA_Review);
				oSeleniumUtils.Click_given_Locator(oIUHomePage.Complete_QA_Review);
				userClickOnReviewSuccessMsg(sReviewSegValue);

				oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "QA"));

				break;

			default:

				if (!(sReviewSegValue.equalsIgnoreCase("Editorials"))) {
					oSeleniumUtils.Click_given_Locator(oIUHomePage.Complete_QA_Review);
					userClickOnReviewSuccessMsg(sReviewSegValue);
					oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "QA"));
					break;
				}

			}

		}

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		// oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag,
		// "sValue", "QA"));

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void selectRuleFromDB(String InstanceType) {

		boolean sFlag = false;

		String sRuleQuery = "select MID_RULE_DOT_VERSION from "
				+ "IPDE.task_details t , IPDE.task_status_lkp tsl, IRDM.interp_rule_details ird,ipde.task_type_lkp ittl"
				+ "  where  tsl.task_status_key = t.task_status_key and ird.INTERP_RULE_KEY = reference_rule_id "
				+ "and t.TASK_TYPE_KEY = ittl.TASK_TYPE_KEY and  LIBRARY_STATUS_DESC='Custom' and ittl.TASK_TYPE_KEY='10' and TASK_STATUS_DESC ='Not Started'"
				+ " and reference_rule_id in "
				+ "(select INTERP_RULE_KEY from IRDM.interp_rule_details where interp_rule_key in"
				+ " (select interp_rule_key from IRDM.interp_rules where impact_key = "
				+ "(select impact_key from irdm.interp_impacts where update_instance_key ="
				+ "(select update_instance_key from IRDM.update_instances where update_instance_name = 'AutoInstance234'))))";

		System.out.println(sRuleQuery);

		String sRuleValue = DBUtils.executeSQLQuery(sRuleQuery);

		System.out.println(sRuleValue);

		if (sFlag == false) {

			verify("Selected Rules are Deactivated", false);
		}

	}

	@Step
	public void potentialConflictsReview(String ConflictType) throws InterruptedException {

		navigateToAdminRuleReviewValidateColValues("Admin", "FINAL MD DEL", "Task", "Potential Conflicts Review");
		reassignTask("", "iht_ittest01");
		navigateToMyTasksAndGoToRuleInInstance("MyTasks", "Editorial Review Work Queue", "FINAL MD DEL");
		selectRule("RuleID");
		clickOnWorkQueue("Start Review");

		oGenericUtils.gfn_Click_String_object_Xpath(
				"//div[@class='ui-jqgrid-bdiv']//table[@id='potentialConflictGrid']//input[@type='radio' ][2]");
		oGenericUtils.gfn_Click_On_Object("label", "Save");
		oGenericUtils.gfn_Verify_Object_Exist("h3", "Information");
		oGenericUtils.gfn_Click_On_Object("button", "Ok");
		oGenericUtils.gfn_Click_On_Object("label", "Conflict Review Completed");
		oGenericUtils.gfn_Verify_Object_Exist("h3", "Information");
		oGenericUtils.gfn_Click_On_Object("button", "Ok");
		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		navigateToMyTasksAndGoToRuleInInstance("MyTasks", "PO Review Work Queue", "FINAL MD DEL");
		selectRule("RuleID");
		clickOnWorkQueue("Start Review");

	}

	@Step
	public void selectAEActions(String sInstance, String sActionType) throws Exception {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		oIUHomePage.closeAllTabs();
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.SpanTag, "sValue", "Group Tasks"));
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.SpanTag, "sValue", "Administration"));
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		oSeleniumUtils.Click_given_Locator(
				StringUtil.replace(oIUHomePage.AnchorTag, "sValue", "Interpretive Update Instances"));

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(StringUtils.replace(oIUHomePage.AdminInstance, "sValue", sInstance));

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.Actions);

		oGenericUtils.gfn_Click_On_Object("span", sActionType);

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		int iAEOKBtn = getDriver().findElements(By.xpath("//div[text()='OK']")).size();

		if (iAEOKBtn > 0) {

			oGenericUtils.gfn_Click_On_Object("div", "OK");
		}

	}

	@Step
	public void completeAssignmentExceptions(String sInstanceType, int sheet_NO) throws Exception {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		int iAEOKBtn2 = getDriver().findElements(By.xpath("//div[text()='OK']")).size();

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		if (iAEOKBtn2 > 0) {

			oGenericUtils.gfn_Click_On_Object("div", "OK");
		}

		oGenericUtils.gfn_Click_On_Object("span", "Assignment Exceptions");

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		int iAEOKBtn3 = getDriver().findElements(By.xpath("//div[text()='OK']")).size();

		if (iAEOKBtn3 > 0) {

			oGenericUtils.gfn_Click_On_Object("div", "OK");
		}

		int iTotalRows = ExcelUtils.GetRowCount(sheet_NO);
		System.out.println("Total Row Count :" + iTotalRows);

		for (int i = 1; i <= iTotalRows; i++) {

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.AEAddButton);
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			String sResource = ExcelUtils.getCellData(i, 0, sheet_NO);

			String sTask = ExcelUtils.getCellData(i, 1, sheet_NO);

			String sAssociatedTask = ExcelUtils.getCellData(i, 2, sheet_NO);

			String sAssociatedResource = ExcelUtils.getCellData(i, 3, sheet_NO);

			String sMedPolicyTitle = ExcelUtils.getCellData(i, 4, sheet_NO);

			String sTopicTitle1 = ExcelUtils.getCellData(i, 5, sheet_NO);

			String sTopicTitle = ExcelUtils.getCellData(i, 6, sheet_NO);

			String sDecisionPoint = ExcelUtils.getCellData(i, 7, sheet_NO);

			String sLibraryStatus = ExcelUtils.getCellData(i, 8, sheet_NO);

			System.out.println(sAssociatedTask);
			System.out.println(sAssociatedResource);

			List<WebElement> sAEListboxSize = getDriver().findElements(By.xpath("//div[@class='GEFT4QHBB1']"));

			sAEListboxSize.get(1).click();
			oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.GetDynamicXPath("SELECT AE VALUES", 4), sResource);
			oSeleniumUtils.Click_given_Locator("(//div[@class='GEFT4QHBKO'])[3]//div//div[text()='" + sResource + "']");

			sAEListboxSize.get(2).click();
			oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.GetDynamicXPath("SELECT AE VALUES", 5), sTask);
			oSeleniumUtils.Click_given_Locator("(//div[@class='GEFT4QHBKO'])[3]//div//div[text()='" + sTask + "']");

			sAEListboxSize.get(3).click();
			if (sAssociatedTask != null) {
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
				oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.GetDynamicXPath("SELECT AE VALUES", 6),
						sAssociatedTask);
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
				oSeleniumUtils.Click_given_Locator(
						"(//div[@class='GEFT4QHBKO'])[3]//div//div[text()='" + sAssociatedTask + "']");
			}

			sAEListboxSize.get(4).click();
			if (sAssociatedResource != null) {
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
				oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.GetDynamicXPath("SELECT AE VALUES", 7),
						sAssociatedResource);
				oSeleniumUtils.Click_given_Locator(
						"(//div[@class='GEFT4QHBKO'])[3]//div//div[text()='" + sAssociatedResource + "']");
			}

			sAEListboxSize.get(5).click();
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.GetDynamicXPath("SELECT AE VALUES", 8),
					sMedPolicyTitle);
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			oSeleniumUtils
					.Click_given_Locator("(//div[@class='GEFT4QHBKO'])[3]//div//div[text()='" + sMedPolicyTitle + "']");
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			if (sTopicTitle1 != null) {
				sAEListboxSize.get(6).click();
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
				oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.GetDynamicXPath("SELECT AE VALUES", 9),
						sTopicTitle1);
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
				oSeleniumUtils.Click_given_Locator(
						"(//div[@class='GEFT4QHBKO'])[3]//div//div[text()='" + sTopicTitle1 + "']");
				SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			}

			if (sTopicTitle != null) {
				sAEListboxSize.get(6).click();
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
				oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.GetDynamicXPath("SELECT AE VALUES", 9),
						sTopicTitle);
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
				oSeleniumUtils
						.Click_given_Locator("(//div[@class='GEFT4QHBKO'])[3]//div//div[text()='" + sTopicTitle + "']");
				SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			}

			if (sDecisionPoint != null) {
				sAEListboxSize.get(7).click();
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
				oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.GetDynamicXPath("SELECT AE VALUES", 10),
						sDecisionPoint);
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
				oSeleniumUtils.Click_given_Locator(
						"(//div[@class='GEFT4QHBKO'])[3]//div//div[text()='" + sDecisionPoint + "']");
			}

			if (sLibraryStatus != null) {
				sAEListboxSize.get(10).click();
				oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.GetDynamicXPath("SELECT AE VALUES", 13),
						sLibraryStatus);
				oSeleniumUtils.Click_given_Locator(
						"(//div[@class='GEFT4QHBKO'])[3]//div//div[text()='" + sLibraryStatus + "']");
			}

			System.out.print("Completed Row No" + i);
		}

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.AESaveButton);
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		oGenericUtils.gfn_Verify_Object_Exist("div", "Are you sure you want to save the assignments?");
		oGenericUtils.gfn_Click_On_Object("div", "Yes");
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		oGenericUtils.gfn_Verify_Object_Exist("div", "Administration - Interpretive Update Instances");
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		oGenericUtils.gfn_Click_On_Object("div", "OK");

	}

	@Step
	public void vaidateAdminRuleReviewDB(String sInstanceType, String sColumnName, String sColumnValue) {

		String sQuery = null;
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		System.out.println(Serenity.sessionVariableCalled("MidRuleVersion").toString());
		System.out.println(Serenity.sessionVariableCalled("IUInstanceName").toString());

		switch (sColumnName) {

		//		case "Status":
//			sQuery = "select TASK_STATUS_DESC from IPDE.TASK_STATUS_LKP where task_status_key in"
//					+ "(select TASK_STATUS_KEY from IPDE.task_details where REFERENCE_RULE_ID in"
//					+ "(select INTERP_RULE_KEY from IRDM.interp_rule_details where MID_RULE_DOT_VERSION = '"
//					+ Serenity.sessionVariableCalled("MidRuleVersion").toString() + "' and INTERP_RULE_KEY in"
//					+ "(select interp_rule_key from IRDM.interp_rules where impact_key in"
//					+ "(select impact_key from irdm.interp_impacts where update_instance_key ="
//					+ "(select update_instance_key from IRDM.update_instances where update_instance_name = '"
//					+ Serenity.sessionVariableCalled("IUInstanceName").toString() + "')))))";
//
//			System.out.println("Query: " + sQuery);
//			break;
			
		case "Status":

			sQuery = " SELECT TASK_STATUS_DESC FROM IRDM.INTERP_RULES IR JOIN IRDM.INTERP_RULE_DETAILS IRD ON IR.INTERP_RULE_KEY = IRD.INTERP_RULE_KEY JOIN IPDE.TASK_DETAILS TD ON TD.REFERENCE_RULE_ID = IR.INTERP_RULE_KEY LEFT JOIN \r\n"
					+ " IPDE.CPM_TASK_DETAILS CTD ON TD.TASK_DETAIL_KEY = CTD.TASK_DETAIL_KEY JOIN IPDE.TASK_TYPE_LKP TTL ON TTL.TASK_TYPE_KEY = CASE WHEN TD.TASK_TYPE_KEY = 16 THEN CTD.TASK_TYPE_KEY  ELSE TD.TASK_TYPE_KEY END JOIN \r\n"
					+ " IPDE.TASK_STATUS_LKP TSL ON TSL.TASK_STATUS_KEY = CASE WHEN TD.TASK_TYPE_KEY = 16 THEN CTD.TASK_STATUS_KEY ELSE TD.TASK_STATUS_KEY END  JOIN IPDE.USERS U  ON U.USER_KEY = CASE WHEN TD.TASK_TYPE_KEY = 16 \r\n"
					+ " THEN CTD.USER_KEY ELSE TD.TASK_USER_KEY END WHERE IR.IMPACT_KEY IN (SELECT IMPACT_KEY FROM IRDM.INTERP_IMPACTS II JOIN IRDM.UPDATE_INSTANCES I ON I.UPDATE_INSTANCE_KEY = II.UPDATE_INSTANCE_KEY \r\n"
					+ " WHERE UPDATE_INSTANCE_NAME = '" + Serenity.sessionVariableCalled("IUInstanceName").toString()
					+ "') AND IRD.MID_RULE_DOT_VERSION  ='"
					+ Serenity.sessionVariableCalled("MidRuleVersion").toString() + "' and rownum ='1'";
			System.out.println("Query is : " + sQuery);
			break;

		// case "Assignee": // changed from TASK_USER_KEY on 18 Jan 19
		// sQuery = "select USER_NAME from IPDE.USERS where USER_KEY in"
		// + "(select TASK_USER_KEY from IPDE.task_details where
		// REFERENCE_RULE_ID in"
		// + "(select INTERP_RULE_KEY from IRDM.interp_rule_details where
		// MID_RULE_DOT_VERSION = '"
		// + Serenity.sessionVariableCalled("MidRuleVersion").toString() + "'
		// and INTERP_RULE_KEY in"
		// + "(select interp_rule_key from IRDM.interp_rules where impact_key
		// in"
		// + "(select impact_key from irdm.interp_impacts where
		// update_instance_key ="
		// + "(select update_instance_key from IRDM.update_instances where
		// update_instance_name = '"
		// + Serenity.sessionVariableCalled("IUInstanceName").toString() +
		// "')))))";
		//
		// System.out.println("Query: " + sQuery);
		// break;

		case "Assignee":

			if (sColumnName.equalsIgnoreCase("Assignee")) {
				sColumnName = "USER_ID";
			}
			sQuery = " SELECT DISTINCT " + sColumnName
					+ " FROM IRDM.INTERP_RULES IR JOIN IRDM.INTERP_RULE_DETAILS IRD ON IR.INTERP_RULE_KEY = IRD.INTERP_RULE_KEY JOIN IPDE.TASK_DETAILS TD ON TD.REFERENCE_RULE_ID = IR.INTERP_RULE_KEY LEFT JOIN \r\n"
					+ " IPDE.CPM_TASK_DETAILS CTD ON TD.TASK_DETAIL_KEY = CTD.TASK_DETAIL_KEY JOIN IPDE.TASK_TYPE_LKP TTL ON TTL.TASK_TYPE_KEY = CASE WHEN TD.TASK_TYPE_KEY = 16 THEN CTD.TASK_TYPE_KEY  ELSE TD.TASK_TYPE_KEY END JOIN \r\n"
					+ " IPDE.TASK_STATUS_LKP TSL ON TSL.TASK_STATUS_KEY = CASE WHEN TD.TASK_TYPE_KEY = 16 THEN CTD.TASK_STATUS_KEY ELSE TD.TASK_STATUS_KEY END  JOIN IPDE.USERS U  ON U.USER_KEY = CASE WHEN TD.TASK_TYPE_KEY = 16 \r\n"
					+ " THEN CTD.USER_KEY ELSE TD.TASK_USER_KEY END WHERE IR.IMPACT_KEY IN (SELECT IMPACT_KEY FROM IRDM.INTERP_IMPACTS II JOIN IRDM.UPDATE_INSTANCES I ON I.UPDATE_INSTANCE_KEY = II.UPDATE_INSTANCE_KEY \r\n"
					+ " WHERE UPDATE_INSTANCE_NAME = '" + Serenity.sessionVariableCalled("IUInstanceName").toString()
					+ "') AND IRD.MID_RULE_DOT_VERSION  ='"
					+ Serenity.sessionVariableCalled("MidRuleVersion").toString() + "' and rownum ='1'";
			System.out.println("Query is : " + sQuery);
			break;

		case "Task":

			sQuery = " SELECT TASK_TYPE_DESC FROM IRDM.INTERP_RULES IR JOIN IRDM.INTERP_RULE_DETAILS IRD ON IR.INTERP_RULE_KEY = IRD.INTERP_RULE_KEY JOIN IPDE.TASK_DETAILS TD ON TD.REFERENCE_RULE_ID = IR.INTERP_RULE_KEY LEFT JOIN \r\n"
					+ " IPDE.CPM_TASK_DETAILS CTD ON TD.TASK_DETAIL_KEY = CTD.TASK_DETAIL_KEY JOIN IPDE.TASK_TYPE_LKP TTL ON TTL.TASK_TYPE_KEY = CASE WHEN TD.TASK_TYPE_KEY = 16 THEN CTD.TASK_TYPE_KEY  ELSE TD.TASK_TYPE_KEY END JOIN \r\n"
					+ " IPDE.TASK_STATUS_LKP TSL ON TSL.TASK_STATUS_KEY = CASE WHEN TD.TASK_TYPE_KEY = 16 THEN CTD.TASK_STATUS_KEY ELSE TD.TASK_STATUS_KEY END  JOIN IPDE.USERS U  ON U.USER_KEY = CASE WHEN TD.TASK_TYPE_KEY = 16 \r\n"
					+ " THEN CTD.USER_KEY ELSE TD.TASK_USER_KEY END WHERE IR.IMPACT_KEY IN (SELECT IMPACT_KEY FROM IRDM.INTERP_IMPACTS II JOIN IRDM.UPDATE_INSTANCES I ON I.UPDATE_INSTANCE_KEY = II.UPDATE_INSTANCE_KEY \r\n"
					+ " WHERE UPDATE_INSTANCE_NAME = '" + Serenity.sessionVariableCalled("IUInstanceName").toString()
					+ "') AND IRD.MID_RULE_DOT_VERSION  ='"
					+ Serenity.sessionVariableCalled("MidRuleVersion").toString() + "' and rownum ='1'";
			System.out.println("Query is : " + sQuery);
			break;

		}

		String sAdminRuleReviewDBVal = DBUtils.executeSQLQuery(sQuery);
		System.out.println("Query Status: " + sAdminRuleReviewDBVal);

		if (sAdminRuleReviewDBVal.equalsIgnoreCase(sColumnValue)) {

			verify("Rule Review Value is displayed Correctly: " + sAdminRuleReviewDBVal + "; Expected Value is: "
					+ sColumnValue, true);
		} else {
			verify("Actual Value is : " + sAdminRuleReviewDBVal + "; Expected Value is: " + sColumnValue, false);
			verify("Exeucted Query is : " + sQuery, false);

		}

	}

	@Step
	public void scrollToColumn(String sValue, String sTag, String[] sColumnList) throws InterruptedException {

		for (int i = 0; i < sColumnList.length; i++) {

			WebElement oColoumn = getDriver().findElement(By.xpath("//" + sTag + "[text()='" + sColumnList[i] + "']"));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			if (!oColoumn.isDisplayed()) {

				WebElement horizontal_scroll = oColoumn;

				((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
						horizontal_scroll);

			}

			verify("Column Values are displayed in" + sValue,
					oGenericUtils.gfn_Verify_Object_Exist("span", sColumnList[i]));

		}

	}

	@Step
	public void applyFiltersInMyTaskDB(String sTaskType, String sFilterValue) {

		String sQuery = null;

		String sFilterVal = null;

		String sType = StringUtils.substringBefore(sTaskType, "-");

		String TaskType = StringUtils.substringAfter(sTaskType, "-");

		Serenity.setSessionVariable("TaskType").to(sType);

		List<String> sFilterValueList = Arrays.asList(sFilterValue.split(";"));

		System.out.println(Serenity.sessionVariableCalled("IUInstanceName").toString());
		String sLibraryType = sFilterValueList.get(0);
		String sTaskStatus = sFilterValueList.get(1);
		String sARDStatus = sFilterValueList.get(2);

		int iFieldSize = sFilterValueList.size();
		System.out.println(iFieldSize);
		if (iFieldSize > 3) {
			sFilterVal = sFilterValueList.get(3);
		}

		switch (sType) {
		case "FINAL MD DEL MULTIPAYER1":
		case "FINAL PO DEL MULTIPAYER1":

			sQuery = "select MID_RULE_DOT_VERSION from IRDM.interp_rule_details where PAYERS_4_RULE like '%,%' and LIBRARY_STATUS_DESC ='"
					+ sLibraryType + "' and ARD_EXISTS_YN='" + sARDStatus + "'and INTERP_RULE_KEY in"
					+ "(select REFERENCE_RULE_ID from IPDE.task_details where task_status_key in"
					+ "(select TASK_STATUS_KEY from IPDE.TASK_STATUS_LKP where TASK_STATUS_DESC ='" + sTaskStatus
					+ "')and TASK_TYPE_KEY in"
					+ "(select TASK_TYPE_KEY from IPDE.TASK_TYPE_LKP where TASK_TYPE_DESC ='Final PO Review')  and REFERENCE_RULE_ID in"
					+ "(select INTERP_RULE_KEY from IRDM.interp_rule_details IRD, rules.sub_rules RSB where IRD.MID_RULE_KEY=RSB.MID_RULE_KEY and IRD.RULE_VERSION=RSB.RULE_VERSION and DEACTIVATED_10 <> '-1' and INTERP_RULE_KEY in"
					+ "((select interp_rule_key from IRDM.interp_rules where impact_key in"
					+ "(select impact_key from irdm.interp_impacts where update_instance_key ="
					+ "(select update_instance_key from IRDM.update_instances where update_instance_name = '"
					+ Serenity.sessionVariableCalled("IUInstanceName").toString() + "'))))))";

			System.out.println("Query is : " + sQuery);

			break;

		case "FINAL MD DEL MULTIPAYER2":
		case "FINAL PO DEL MULTIPAYER2":

			sQuery = "select MID_RULE_DOT_VERSION from IRDM.interp_rule_details where PAYERS_4_RULE like '%,%,%' and LIBRARY_STATUS_DESC ='"
					+ sLibraryType + "' and ARD_EXISTS_YN='" + sARDStatus + "'and INTERP_RULE_KEY in"
					+ "(select REFERENCE_RULE_ID from IPDE.task_details where task_status_key in"
					+ "(select TASK_STATUS_KEY from IPDE.TASK_STATUS_LKP where TASK_STATUS_DESC ='" + sTaskStatus
					+ "')and TASK_TYPE_KEY in"
					+ "(select TASK_TYPE_KEY from IPDE.TASK_TYPE_LKP where TASK_TYPE_DESC ='Final PO Review')  and REFERENCE_RULE_ID in"
					+ "(select INTERP_RULE_KEY from IRDM.interp_rule_details IRD, rules.sub_rules RSB where IRD.MID_RULE_KEY=RSB.MID_RULE_KEY and IRD.RULE_VERSION=RSB.RULE_VERSION and DEACTIVATED_10 <> '-1' and INTERP_RULE_KEY in"
					+ "((select interp_rule_key from IRDM.interp_rules where impact_key in"
					+ "(select impact_key from irdm.interp_impacts where update_instance_key ="
					+ "(select update_instance_key from IRDM.update_instances where update_instance_name = '"
					+ Serenity.sessionVariableCalled("IUInstanceName").toString() + "'))))))";

			System.out.println("Query is : " + sQuery);

			break;

		case "FINAL MD DEL MULTIPAYER2-Subsequent":
		case "FINAL PO DEL MULTIPAYER2-Subsequent":

			sQuery = "select MID_RULE_DOT_VERSION from IRDM.interp_rule_details where PAYERS_4_RULE like '%,%,%' and LIBRARY_STATUS_DESC ='"
					+ sLibraryType + "' and ARD_EXISTS_YN='" + sARDStatus + "'and INTERP_RULE_KEY in"
					+ "(select REFERENCE_RULE_ID from IPDE.task_details where task_status_key in"
					+ "(select TASK_STATUS_KEY from IPDE.TASK_STATUS_LKP where TASK_STATUS_DESC ='" + sTaskStatus
					+ "')and TASK_TYPE_KEY in"
					+ "(select TASK_TYPE_KEY from IPDE.TASK_TYPE_LKP where TASK_TYPE_DESC ='Final PO Review')  and REFERENCE_RULE_ID in"
					+ "(select INTERP_RULE_KEY from IRDM.interp_rule_details IRD, rules.sub_rules RSB where IRD.MID_RULE_KEY=RSB.MID_RULE_KEY and IRD.RULE_VERSION=RSB.RULE_VERSION and DEACTIVATED_10 <> '-1' and INTERP_RULE_KEY in"
					+ "((select interp_rule_key from IRDM.interp_rules where impact_key in"
					+ "(select impact_key from irdm.interp_impacts where update_instance_key ="
					+ "(select update_instance_key from IRDM.update_instances where update_instance_name = '"
					+ Serenity.sessionVariableCalled("IUInstanceName").toString() + "') AND IMPACT SEQ=2)))))";

			System.out.println("Query is : " + sQuery);

			break;

		case "RULE HEADER":

			sQuery = "select MID_RULE_DOT_VERSION from IRDM.interp_rule_details where LIBRARY_STATUS_DESC ='"
					+ sLibraryType + "' and RULE_HEADER_KEY='" + sFilterVal + "' and  ARD_EXISTS_YN='" + sARDStatus
					+ "'and INTERP_RULE_KEY in"
					+ "(select REFERENCE_RULE_ID from IPDE.task_details where task_status_key in"
					+ "(select TASK_STATUS_KEY from IPDE.TASK_STATUS_LKP where TASK_STATUS_DESC ='" + sTaskStatus
					+ "')and TASK_TYPE_KEY in"
					+ "(select TASK_TYPE_KEY from IPDE.TASK_TYPE_LKP where TASK_TYPE_DESC ='Final PO Review')  and REFERENCE_RULE_ID in"
					+ "(select INTERP_RULE_KEY from IRDM.interp_rule_details IRD, rules.sub_rules RSB where IRD.MID_RULE_KEY=RSB.MID_RULE_KEY and IRD.RULE_VERSION=RSB.RULE_VERSION and DEACTIVATED_10 <> '-1' and INTERP_RULE_KEY in"
					+ "((select interp_rule_key from IRDM.interp_rules where impact_key in"
					+ "(select impact_key from irdm.interp_impacts where update_instance_key ="
					+ "(select update_instance_key from IRDM.update_instances where update_instance_name = '"
					+ Serenity.sessionVariableCalled("IUInstanceName").toString() + "'))))))";

			System.out.println("Query is : " + sQuery);

			break;

		case "DEACTIVATE RULE":

			sQuery = "select MID_RULE_DOT_VERSION from IRDM.interp_rule_details where LIBRARY_STATUS_DESC ='"
					+ sLibraryType + "' and ARD_EXISTS_YN='" + sARDStatus + "'and INTERP_RULE_KEY in"
					+ "(select REFERENCE_RULE_ID from IPDE.task_details where task_status_key in"
					+ "(select TASK_STATUS_KEY from IPDE.TASK_STATUS_LKP where TASK_STATUS_DESC ='" + sTaskStatus
					+ "')and TASK_TYPE_KEY in"
					+ "(select TASK_TYPE_KEY from IPDE.TASK_TYPE_LKP where TASK_TYPE_DESC ='Final PO Review')  and REFERENCE_RULE_ID in"
					+ "(select INTERP_RULE_KEY from IRDM.interp_rule_details IRD, rules.sub_rules RSB where IRD.MID_RULE_KEY=RSB.MID_RULE_KEY and IRD.RULE_VERSION=RSB.RULE_VERSION and DEACTIVATED_10 = '-1' and INTERP_RULE_KEY in"
					+ "((select interp_rule_key from IRDM.interp_rules where  impact_key in"
					+ "(select impact_key from irdm.interp_impacts where update_instance_key ="
					+ "(select update_instance_key from IRDM.update_instances where update_instance_name = '"
					+ Serenity.sessionVariableCalled("IUInstanceName").toString() + "'))))))";

		case "SINGLEPAYER":

			sQuery = "select MID_RULE_DOT_VERSION from IRDM.interp_rule_details where  PAYERS_4_RULE not like '%,%' and LIBRARY_STATUS_DESC ='"
					+ sLibraryType + "' and ARD_EXISTS_YN='" + sARDStatus + "'and INTERP_RULE_KEY in"
					+ "(select REFERENCE_RULE_ID from IPDE.task_details where task_status_key in"
					+ "(select TASK_STATUS_KEY from IPDE.TASK_STATUS_LKP where TASK_STATUS_DESC ='" + sTaskStatus
					+ "')and TASK_TYPE_KEY in" + "(select TASK_TYPE_KEY from IPDE.TASK_TYPE_LKP where TASK_TYPE_DESC ='"
					+ TaskType + "')  and REFERENCE_RULE_ID in"
					+ "(select INTERP_RULE_KEY from IRDM.interp_rule_details IRD, rules.sub_rules RSB where IRD.MID_RULE_KEY=RSB.MID_RULE_KEY and IRD.RULE_VERSION=RSB.RULE_VERSION and DEACTIVATED_10 <> '-1' and INTERP_RULE_KEY in"
					+ "((select interp_rule_key from IRDM.interp_rules where impact_key in"
					+ "(select impact_key from irdm.interp_impacts where update_instance_key ="
					+ "(select update_instance_key from IRDM.update_instances where update_instance_name = '"
					+ Serenity.sessionVariableCalled("IUInstanceName").toString() + "'))))))";

			System.out.println("Query is : " + sQuery);

			break;

		case "MD DEL MULTIPAYER2 Deny":

			sQuery = "select MID_RULE_DOT_VERSION from IRDM.interp_rule_details where PAYERS_4_RULE like '%,%,%' and RULE_HEADER_DESC='Deny Procedure'  and LIBRARY_STATUS_DESC ='"
					+ sLibraryType + "' and ARD_EXISTS_YN='" + sARDStatus + "'and INTERP_RULE_KEY in"
					+ "(select REFERENCE_RULE_ID from IPDE.task_details where task_status_key in"
					+ "(select TASK_STATUS_KEY from IPDE.TASK_STATUS_LKP where TASK_STATUS_DESC ='" + sTaskStatus
					+ "')and TASK_TYPE_KEY in"
					+ "(select TASK_TYPE_KEY from IPDE.TASK_TYPE_LKP where TASK_TYPE_DESC ='Final PO Review')  and REFERENCE_RULE_ID in"
					+ "(select INTERP_RULE_KEY from IRDM.interp_rule_details IRD, rules.sub_rules RSB where IRD.MID_RULE_KEY=RSB.MID_RULE_KEY and IRD.RULE_VERSION=RSB.RULE_VERSION and DEACTIVATED_10 <> '-1' and INTERP_RULE_KEY in"
					+ "((select interp_rule_key from IRDM.interp_rules where impact_key in"
					+ "(select impact_key from irdm.interp_impacts where update_instance_key ="
					+ "(select update_instance_key from IRDM.update_instances where update_instance_name = '"
					+ Serenity.sessionVariableCalled("IUInstanceName").toString() + "'))))))";

			System.out.println("Query is : " + sQuery);

			break;

		case "CPMREVIEWMULTIPAYER":

			sQuery = "select MID_RULE_DOT_VERSION from IRDM.interp_rule_details where PAYERS_4_RULE like '%,%' and LIBRARY_STATUS_DESC ='"
					+ sLibraryType + "' and INTERP_RULE_KEY in"
					+ "(select REFERENCE_RULE_ID from IPDE.task_details where task_status_key in"
					+ "(select TASK_STATUS_KEY from IPDE.TASK_STATUS_LKP where TASK_STATUS_DESC ='" + sTaskStatus
					+ "')and TASK_TYPE_KEY in"
					+ "(select TASK_TYPE_KEY from IPDE.TASK_TYPE_LKP where TASK_TYPE_DESC ='CPM Review')  and REFERENCE_RULE_ID in"
					+ "(select INTERP_RULE_KEY from IRDM.interp_rule_details IRD, rules.sub_rules RSB where IRD.MID_RULE_KEY=RSB.MID_RULE_KEY and IRD.RULE_VERSION=RSB.RULE_VERSION and DEACTIVATED_10 <> '-1' and INTERP_RULE_KEY in"
					+ "((select interp_rule_key from IRDM.interp_rules where impact_key in"
					+ "(select impact_key from irdm.interp_impacts where update_instance_key ="
					+ "(select update_instance_key from IRDM.update_instances where update_instance_name = '"
					+ Serenity.sessionVariableCalled("IUInstanceName").toString() + "'))))))";

			System.out.println("Query is : " + sQuery);

			break;

		case "Final MD ReviewSUBSEQUENTRUN":
		case "Final PO ReviewSUBSEQUENTRUN":

			String sType1 = StringUtils.substringBefore(sTaskType, "SUBSEQUENTRUN");

			sQuery = "SELECT MID_RULE_DOT_VERSION FROM IRDM.interp_rule_details WHERE     LIBRARY_STATUS_DESC = '"
					+ sLibraryType
					+ "' AND ARD_EXISTS_YN = 'N' AND INTERP_RULE_KEY IN (SELECT REFERENCE_RULE_ID FROM IPDE.task_details WHERE     TASK_USER_KEY = (select user_key from ipde.users where user_name = 'iht_ittest01') AND task_status_key IN (SELECT TASK_STATUS_KEY FROM IPDE.TASK_STATUS_LKP WHERE TASK_STATUS_DESC = '"
					+ sTaskStatus
					+ "') AND TASK_TYPE_KEY IN (SELECT TASK_TYPE_KEY FROM IPDE.TASK_TYPE_LKP WHERE TASK_TYPE_DESC = '"
					+ sType1
					+ "') AND REFERENCE_RULE_ID IN (SELECT INTERP_RULE_KEY FROM IRDM.interp_rule_details IRD, rules.sub_rules RSB WHERE     IRD.MID_RULE_KEY = RSB.MID_RULE_KEY AND IRD.RULE_VERSION = RSB.RULE_VERSION AND DEACTIVATED_10 <> '-1' AND INTERP_RULE_KEY IN ( (SELECT interp_rule_key FROM IRDM.interp_rules WHERE impact_key IN (SELECT impact_key FROM irdm.interp_impacts WHERE update_instance_key = (SELECT update_instance_key FROM IRDM.update_instances WHERE update_instance_name = '"
					+ Serenity.sessionVariableCalled("IUInstanceName").toString() + "') AND IMPACT_SEQ =2   )))))\r\n";

			break;

		default:

			sQuery = "select MID_RULE_DOT_VERSION from IRDM.interp_rule_details where LIBRARY_STATUS_DESC ='"
					+ sLibraryType + "' and ARD_EXISTS_YN='" + sARDStatus + "'and INTERP_RULE_KEY in"
					+ "(select REFERENCE_RULE_ID from IPDE.task_details where TASK_USER_KEY =(select user_key from ipde.users where user_name = 'iht_ittest01') and task_status_key in"
					+ "(select TASK_STATUS_KEY from IPDE.TASK_STATUS_LKP where TASK_STATUS_DESC ='" + sTaskStatus
					+ "')and TASK_TYPE_KEY in" + "(select TASK_TYPE_KEY from IPDE.TASK_TYPE_LKP where TASK_TYPE_DESC ='"
					+ sType + "')  and REFERENCE_RULE_ID in"
					+ "(select INTERP_RULE_KEY from IRDM.interp_rule_details IRD, rules.sub_rules RSB where IRD.MID_RULE_KEY=RSB.MID_RULE_KEY and IRD.RULE_VERSION=RSB.RULE_VERSION and DEACTIVATED_10 <> '-1' and INTERP_RULE_KEY in"
					+ "((select interp_rule_key from IRDM.interp_rules where impact_key = "
					+ "(select impact_key from irdm.interp_impacts where update_instance_key ="
					+ "(select update_instance_key from IRDM.update_instances where update_instance_name = '"
					+ Serenity.sessionVariableCalled("IUInstanceName").toString() + "'))))))";

			// System.out.println("Query is : " + sQuery);

			break;
		}

		System.out.println(" " + sType + " Query is : " + sQuery);

		verify("" + sType + " Qurey:  " + sQuery, true);

		if (sTaskType.equalsIgnoreCase("FINAL MD DEL MULTIPAYER2")) {

			sTaskType = "Final PO Review";
		}

		System.out.println(sTaskType);

		Serenity.setSessionVariable("TaskType").to(sTaskType);

		SeleniumUtils.defaultWait(ProjectVariables.MID_SLEEP);

		// String sDBMidRuleVersion = DBUtils.executeSQLQuery(sQuery);
		// ============================================================================>

		ArrayList<String> sDBMidRuleVersion1 = DBUtils.executeSQLQueryMultipleRows(sQuery);

		Serenity.setSessionVariable("MidRuleVersion").to(
				sDBMidRuleVersion1.get(GenericUtils.generate_Random_Number_for_Given_Range(sDBMidRuleVersion1.size())));

		verify("Mid Rule Version is :  " + Serenity.sessionVariableCalled("MidRuleVersion").toString(), true);

		System.out.println("session rule:" + Serenity.sessionVariableCalled("MidRuleVersion").toString());

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

	}

	@Step
	public void complete_cpm_decision_complete(String sDecision) throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oGenericUtils.gfn_Click_On_Object("label", "CPM Decision Complete");

		oGenericUtils.gfn_Click_On_Object("span", "OK");

		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void assignCPMForDBRule() {

		ArrayList<String> sArrPayers = new ArrayList<String>();

		String sQuery = "select PAYERS_4_RULE from IRDM.interp_rule_details where   MID_RULE_DOT_VERSION='10409.15' and INTERP_RULE_KEY in"
				+ "(select interp_rule_key from IRDM.interp_rules where impact_key = "
				+ "(select impact_key from irdm.interp_impacts where update_instance_key ="
				+ "(select update_instance_key from IRDM.update_instances where update_instance_name = 'AutoInstanceE2E')))";

		System.out.println("Query is : " + sQuery);

		String sPayerList = DBUtils.executeSQLQuery(sQuery);
		System.out.println("Query Status: " + sPayerList);

		String[] ArrPayers = sPayerList.split(",");

		for (int i = 0; i < ArrPayers.length; i++) {
			String sAllPayers = ArrPayers[i].trim().split(" ")[0];
			System.out.println(sAllPayers);

			sArrPayers.add(sAllPayers);

		}
	}

	@Step
	public void retire_rule_validation_in_DB(String arg1, String sDosDate, String sRetired) {

		String sRule = Serenity.sessionVariableCalled("MidRuleVersion").toString();

		String[] sRuleID = sRule.split("\\.");

		String sQuery = "select DOS_TO,DEACTIVATED_10 from rules.sub_rules Where MID_RULE_KEY = '" + sRuleID[0]
				+ "' and RULE_VERSION = '" + sRuleID[1] + "'";

		ArrayList<String> sResult = DBUtils.executeSQLQueryMultipleRows(sQuery);

		System.out.println(sResult);

		System.out.println(sResult.get(0));

		System.out.println(sResult.get(0).replaceAll("-", "/"));

		if (sRetired.equalsIgnoreCase("YES")) {

			if (sDosDate.equalsIgnoreCase(sResult.get(0)) && sResult.get(1).equalsIgnoreCase("-1")) {

				verify("Rule Retired successfully", true);
			}

		} else {

			verify("Rule is not Retired", true);
		}

	}

	@Step
	public void validate_return_response_comments() throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Comments"));

		int iCommnetList = getDriver()
				.findElements(By.xpath("//td[@aria-describedby='returnReViewCommentsGrid_returnComments']")).size();

		if (iCommnetList > 0) {

			for (int j = 0; j < iCommnetList; j++) {

				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

				boolean bln = oGenericUtils.gfn_Verify_String_Object_Exist(
						("(//td[@aria-describedby='returnReViewCommentsGrid_returnComments'])[" + (j + 1) + "]"));

				verify("Response Comments are Updated Successfully", bln);
			}
		}

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void add_code_function_with_poscode(String sCategory, String sCPTCode, String sPOSCode, String sOverrideFlag)
			throws InterruptedException {

		Serenity.setSessionVariable("POS CODE").to(sPOSCode);

		Serenity.setSessionVariable("Override Flag").to(sOverrideFlag);

		ADDCodeinMD(sCategory, sCPTCode);

	}

	@Step
	public void validate_POS_Sensitivity(String sProposalTypes, String sFilter, String sIndicator, String sReason,
			String sComments) {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "CPM Decisions"));

		switch (sProposalTypes) {

		case "MANUAL PROPOSAL":

			break;

		case "MANUAL PROPOSAL FILTER VALIDATION":

			switch (sFilter) {

			case "BLANK":

				break;

			case "NOT BLANK":

				break;
			default:
				Assert.assertTrue("validate_POS_Sensitivity function case values are not matched" + sFilter, false);

			}

			break;
		case "MANUAL PROPOSAL NO SESTIVITI VALIDATION":

			break;

		default:
			Assert.assertTrue("validate_POS_Sensitivity function case values are not matched" + sProposalTypes, false);
		}

	}

	@Step
	public void validateReviewSegment(String sTask, String sReviewSegment, String sDisplay)
			throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", sTask));

		// oGenericUtils.gfn_Verify_String_Object_Exist(oIUHomePage.QAReviewSegment);

		// oSeleniumUtils.Click_given_Locator(
		// StringUtil.replace(oIUHomePage.AnchorTag, "sValue", "BW And/BWO or
		// Config Logic"));

		int i = getDriver().findElements(By.xpath(StringUtil.replace(oIUHomePage.AnchorTag, "sValue", sReviewSegment)))
				.size();
		System.out.println("Ivalue:" + i);

		switch (sDisplay) {

		case "YES":

			if (i > 0) {
				verify(sReviewSegment + " Should be displayed in " + sTask, true);
			} else {
				verify(sReviewSegment + " Not  displayed in " + sTask, false);
			}
			break;

		case "NO":
			if (i > 0) {
				verify(sReviewSegment + " Should be displayed in " + sTask, false);
			} else {
				verify(sReviewSegment + " Not  displayed in " + sTask, true);
			}
			break;
		}

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void updateQARuleNDReview(String sQAReview) throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		verify("Summaries button clicked", oSeleniumUtils
				.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Summaries")));

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		verify("QA button clicked",
				oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "QA")));

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oSeleniumUtils.highlightElement(oIUHomePage.Update_Rule);

		verify("Update Rule Button Clicked", oSeleniumUtils.Click_given_Locator(oIUHomePage.Update_Rule));

		verify("Rule Updated message popup is displayed",
				oGenericUtils.gfn_Verify_String_Object_Exist(oIUHomePage.Msg_Rule_Update));

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		Assert.assertTrue("Rule updated Successfully",
				oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.Msg_Rule_Update));

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Ok"));

		oSeleniumUtils.highlightElement(oIUHomePage.Stub_RMR_ID);

		Serenity.setSessionVariable("Stub_RMR_ID").to(oIUHomePage.Stub_RMR_ID.getText());

		if (Serenity.sessionVariableCalled("RetireRule-Yes") != null) {

			verify("New MidRule version is displayed in WorkQueue Page",
					oGenericUtils.gfn_Verify_String_Object_Exist(oIUHomePage.NewMidruleversion));

			String sNewMidRuleVersion = oSeleniumUtils.get_TextFrom_Locator(oIUHomePage.NewMidruleversion);

			Serenity.setSessionVariable("MidRuleNewVersion").to(sNewMidRuleVersion);

			verify("New MidRule Version" + sNewMidRuleVersion, true);
		}

		System.out.println(Serenity.sessionVariableCalled("Stub_RMR_ID").toString());

		getDriver().switchTo().defaultContent();

		if (sQAReview.equalsIgnoreCase("YES")) {

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Summaries"));

			oSeleniumUtils.highlightElement(oIUHomePage.QA_Review_Completed);

			oSeleniumUtils.Click_given_Locator(oIUHomePage.QA_Review_Completed);

			oGenericUtils.gfn_Verify_Object_Exist("p", " QA Review Completed");

			Assert.assertTrue("Rule updated Successfully", oSeleniumUtils
					.is_WebElement_Displayed(StringUtil.replace(oIUHomePage.pTag, "sValue", " QA Review Completed")));

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Ok"));

			getDriver().switchTo().defaultContent();

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);
		}

	}

	@Step
	public void clickOnQAReviewComplete(String sQAReview) throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);
		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Summaries"));
		oSeleniumUtils.highlightElement(oIUHomePage.QA_Review_Completed);
		oSeleniumUtils.Click_given_Locator(oIUHomePage.QA_Review_Completed);
		oGenericUtils.gfn_Verify_Object_Exist("p", " QA Review Completed");
		Assert.assertTrue("Rule updated Successfully", oSeleniumUtils
				.is_WebElement_Displayed(StringUtil.replace(oIUHomePage.pTag, "sValue", " QA Review Completed")));
		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Ok"));
		getDriver().switchTo().defaultContent();

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

	}

	@Step
	public void validateRMIInstruction(String sInstruction) {

		int sStatus = 0;

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		System.out.println("Manual RMR ID: " + Serenity.sessionVariableCalled("Stub_RMR_ID").toString());

		String sQuery = "Select INSTRUCTIONS from AUTH_MASTER.WORK_ORDER_LOG where WORK_ORDER_CODE = '"
				+ Serenity.sessionVariableCalled("Stub_RMR_ID").toString() + "'";

		System.out.println("Query: " + sQuery);

		System.out.println("Add Code in MD " + Serenity.sessionVariableCalled("AddCodeMD").toString());
		System.out.println("CategoryCode in MD " + Serenity.sessionVariableCalled("CategoryCode").toString());

		String sManualRMRInstr = DBUtils.executeSQLQuery(sQuery);

		if (sManualRMRInstr.contains(Serenity.sessionVariableCalled("AddCodeMD").toString())) {
			sStatus = sStatus + 1;
		}

		if (sManualRMRInstr.contains(Serenity.sessionVariableCalled("CategoryCode").toString())) {

			sStatus = sStatus + 1;
		}

		if (sStatus == 2) {

			verify("  Actual Value is " + sManualRMRInstr, true);
		} else {
			verify(" Expected value contains :" + Serenity.sessionVariableCalled("CategoryCode").toString()
					+ Serenity.sessionVariableCalled("AddCodeMD").toString() + " and Actual is " + sManualRMRInstr,
					false);
		}

		System.out.println(sManualRMRInstr);

	}

	@Step
	public void ADDCodeRecodeLogic(String sCategoryCode, String sCPTCode, String sValidation)
			throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		String sArrayCode = null;

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oGenericUtils.gfn_Click_On_Object("label", "Add Code");

		oGenericUtils.gfn_Verify_Object_Exist("h3", "Add Code");

		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.StartNewCode);

		oGenericUtils.gfn_Click_On_Object("a", "Start New");

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		int iYesBtn = getDriver()
				.findElements(
						By.xpath("//table[@id='Manual_Proposals_grid']//tr[2]//td[2]//select//option[text()='Yes']"))
				.size();

		if (iYesBtn > 0) {

			oSeleniumUtils.Click_given_Locator(
					"//table[@id='Manual_Proposals_grid']//tr[2]//td[2]//select//option[text()='Yes']");
		}

		oSeleniumUtils.select_Given_Value_From_DropDown_Using_StringLocator(
				oIUHomePage.GetDynamicXPathWithRowCol("MANUALPROP FIELDS", 2, 3), "Manual Add");

		oSeleniumUtils.Enter_given_Text_Element(("//table[@id='Manual_Proposals_grid']//tr[2]//td[4]//textarea"),
				"Test");

		oSeleniumUtils.Enter_given_Text_Element(("//table[@id='Manual_Proposals_grid']//tr[2]//td[6]//input"),
				sCPTCode);

		oSeleniumUtils.Click_given_Locator(
				"//table[@id='Manual_Proposals_grid']//tr[2]//td[9]//select//option[text()='" + sCategoryCode + "']");

		// oSeleniumUtils.Enter_given_Text_Element(("//table[@id='Manual_Proposals_grid']//tr[2]//td[6]//input"),sCode);

		// oSeleniumUtils.Enter_given_Text_Element(("//table[@id='Manual_Proposals_grid']//tr[2]//td[6]//input"),sCode);

		oGenericUtils.gfn_Click_On_Object("label", "Save");

		String arr[] = { "01230-01232", "01240-0124T", "01250-01260", "0126T-01270", "01270-01272" };

		for (int i = 0; i < arr.length; i++) {

			sArrayCode = arr[i];

			int iErrorMsg = getDriver().findElements(By.xpath(StringUtil.replace(oIUHomePage.pTag, "sValue",
					" Review code need to be entered with Code From and Code To for Re-code logic"))).size();

			if (iErrorMsg > 0) {

				oGenericUtils.gfn_Click_On_Object("button", "Ok");
				oSeleniumUtils.Enter_given_Text_Element(("//table[@id='Manual_Proposals_grid']//tr[2]//td[6]//input"),
						sArrayCode);
				oGenericUtils.gfn_Click_On_Object("label", "Save");

			}

			int iMsg = getDriver().findElements(By.xpath(StringUtil.replace(oIUHomePage.h3Tag, "sValue", "Success")))
					.size();

			if (iMsg > 0) {
				break;
			}

		}

		oGenericUtils.gfn_Verify_Object_Exist("h3", "Success");
		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void right_Panel_NewEdit_Edit(String strCase) {

	}

	@Step
	public void retriveNonCandidateRules(String strCase) throws InterruptedException {

		oGenericUtils.gfn_Click_On_Object("div", "Retrieve Non-Candidate Rules");

		int iNonCandidateRules = getDriver().findElements(By.xpath("//div[text()='Non Candidate Rules']")).size();

		if (iNonCandidateRules > 0) {

			oGenericUtils.gfn_Click_On_Object("div", "OK");
			verify("No Non Candidate Rules available for this instance", false);
		}

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		System.out.print(Serenity.sessionVariableCalled("AdminInstance").toString());

		String sQuery = "select MID_RULE_DOT_VERSION from IRDM.interp_rule_details where INTERP_RULE_KEY in"
				+ "(select INTERP_RULE_KEY from IRDM.interp_rule_details IRD, rules.sub_rules RSB where IRD.MID_RULE_KEY=RSB.MID_RULE_KEY and IRD.RULE_VERSION=RSB.RULE_VERSION and INTERP_RULE_KEY in"
				+ "((select interp_rule_key from IRDM.interp_rules where CANDIDATE_DEF_KEY<> 1 and impact_key = "
				+ "(select impact_key from irdm.interp_impacts where update_instance_key ="
				+ "(select update_instance_key from IRDM.update_instances where update_instance_name = '"
				+ Serenity.sessionVariableCalled("AdminInstance").toString() + "')))))";

		System.out.println(sQuery);
		String sDBNonCandRule = DBUtils.executeSQLQuery(sQuery);

		Serenity.setSessionVariable("MidRuleVersion").to(sDBNonCandRule);

		System.out.println("MidRuleVersion: " + Serenity.sessionVariableCalled("MidRuleVersion").toString());

		oGenericUtils.gfn_Verify_Object_Exist("div", Serenity.sessionVariableCalled("MidRuleVersion").toString());

		oIUHomePage.closeAllTabs();

		oGenericUtils.gfn_Click_On_Object("a", "Interpretive Update Instances");

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		clickOnInstanceInAdminAndNavigateToRuleReviewPage("FINAL MD DEL");

		int iNoNonCandidateRules = getDriver()
				.findElements(By
						.xpath("//div[text()='" + Serenity.sessionVariableCalled("MidRuleVersion").toString() + "' ]"))
				.size();

		if (iNoNonCandidateRules > 0) {

			verify("Non Candidate Rules available for this instance", false);
		} else {
			verify("No Non Candidate Rules available for this instance", true);
		}

	}

	@Step
	public void checkDeactivatedRuleMessages() throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.StartReview);
		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		oGenericUtils.gfn_Verify_Object_Exist(oIUHomePage.DeactivateErrorMsg, "20");

		oGenericUtils.gfn_Click_On_Object("button", "Ok");
		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void validateRationalComments(String arg1) throws InterruptedException {

		boolean sCommentVal = oIUHomePage.rationalComments(ProjectVariables.SystemProposalComments);

		verify("System Proposal Comments :  ", sCommentVal);
	}

	@Step
	public void getAndValidateSystemProposals(String arg1) {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		int iProposals = getDriver().findElements(By.xpath(oIUHomePage.NewRuleVersion)).size();

		// select[@id='1_decisionAction.decisionActionKey']//option

		String sModify = oSeleniumUtils
				.get_StringTextFrom_Locator(oIUHomePage.GetDynamicXPath("SYSTEM PROPOSAL VAL", 2));
		System.out.println(sModify);

		Assert.assertTrue("Modify option is displayed", sModify.equalsIgnoreCase("Modify"));

		String sNoAction = oSeleniumUtils
				.get_StringTextFrom_Locator(oIUHomePage.GetDynamicXPath("SYSTEM PROPOSAL VAL", 3));
		System.out.println(sNoAction);

		Assert.assertTrue("No Action option is displayed", sNoAction.equalsIgnoreCase("No Action"));

		String sRemove = oSeleniumUtils
				.get_StringTextFrom_Locator(oIUHomePage.GetDynamicXPath("SYSTEM PROPOSAL VAL", 4));
		System.out.println(sRemove);

		Assert.assertTrue("Remove option is displayed", sRemove.equalsIgnoreCase("Remove"));

		if (iProposals > 4) {

			String sNoDecision = oSeleniumUtils
					.get_StringTextFrom_Locator(oIUHomePage.GetDynamicXPath("SYSTEM PROPOSAL VAL", 5));
			System.out.println(sNoDecision);

			Assert.assertTrue("Remove option is displayed", sNoDecision.equalsIgnoreCase("No Decision"));
		}

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void getNewRuleVersion() {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		int iNewVersionExist = getDriver().findElements(By.xpath(oIUHomePage.NewRuleVersion)).size();

		if (iNewVersionExist > 0) {

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.NewRuleVersion);
			String sNewVersionRule = oSeleniumUtils.get_StringTextFrom_Locator(oIUHomePage.NewRuleVersion);
			Serenity.setSessionVariable("MidRuleVersion").to(sNewVersionRule);
			System.out.print("New Version Rule:" + sNewVersionRule);

			verify("New version Rule is created: " + sNewVersionRule, true);
		} else {
			verify("New version Rule is not created: ", false);
		}

		getDriver().switchTo().defaultContent();
	}

	@Step
	public void ruleRequest(String arg1) throws InterruptedException {

		oSeleniumUtils.Click_given_WebElement(oIUHomePage.ReAssignNavigationAdmin);

		int i = getDriver()
				.findElements(By.xpath(StringUtil.replace(oIUHomePage.DivTag, "sValue", "Rule Review Request"))).size();

		if (i > 0) {
			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.DivTag, "sValue", "Rule Review Request"));
		} else {
			oGenericUtils.gfn_Click_On_Object("span", "Rule Review Request");
		}

		oGenericUtils.gfn_Verify_Object_Exist("div", "Request Rule Review");

		oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.RuleProposal,
				Serenity.sessionVariableCalled("MidRuleVersion").toString());

		oGenericUtils.gfn_Click_On_Object("div", "Request Rule Review");

		oGenericUtils.gfn_Verify_Object_Exist(oIUHomePage.RuleReqMsg, "10");

		oGenericUtils.gfn_Click_On_Object("div", "OK");

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

	}

	@Step

	public void navigateRuleReviewPage(String sInstanceType) throws InterruptedException {

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oIUHomePage.closeAllTabs();

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.SpanTag, "sValue", "Group Tasks"));

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.SpanTag, "sValue", "Administration"));

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(
				StringUtil.replace(oIUHomePage.AnchorTag, "sValue", "Interpretive Update Instances"));

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		clickInstanceinAdmin(sInstanceType);
	}

	@Step
	public void modifyCPMSystemProposalError(String sMDRecomdations, String sDecision) throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oSeleniumUtils.select_Given_Value_From_DropDown_Using_StringLocator(
				oIUHomePage.GetDynamicXPathWithRowCol("MANUALPROP FIELDS", 2, 3), sDecision);
		oGenericUtils.gfn_Click_On_Object("label", "Save");
		oGenericUtils.gfn_Verify_Object_Exist("h3", "Success");
		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		oSeleniumUtils
				.Click_given_Locator((StringUtil.replace(oIUHomePage.LabelTag, "sValue", "CPM Decision Complete")));

		int iError = getDriver().findElements(By.xpath(StringUtil.replace(oIUHomePage.h3Tag, "sValue", "Error")))
				.size();

		if (iError > 0) {

			oGenericUtils.gfn_Verify_Object_Exist("p",
					" Billed With AND/Billed Without OR logic needs to be completed before CPM Decision Complete.");
			oGenericUtils.gfn_Click_On_Object("button", "Ok");

		}

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void modifyCPMManualProposals(String sMDRecomdations, String sDecision) throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.sFrame);
		oSeleniumUtils.select_Given_Value_From_DropDown_Using_StringLocator(
				"//table[@id='cpmManualProposalGrid']//tr[2]//td[4]//select", sDecision);
		oSeleniumUtils.Enter_given_Text_Element("//table[@id='cpmManualProposalGrid']//tr[2]//td[6]//textarea",
				ProjectVariables.CPMManualProposalComments);
		// oGenericUtils.gfn_Click_On_Object("label", "Save");
		oGenericUtils.gfn_Click_String_object_Xpath("//div[@ng-show='hasManualProposals']//label[text()='Save']");
		oGenericUtils.gfn_Verify_Object_Exist("h3", "Success");
		oGenericUtils.gfn_Click_On_Object("button", "Ok");
		getDriver().switchTo().defaultContent();

	}

	@Step
	public void ValidateROLLUpSystem(String arg1) throws InterruptedException {

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		int iPosRollBtn = getDriver().findElements(By.xpath(oIUHomePage.PosRollBtn)).size();

		if (iPosRollBtn > 0) {

			verify("Rollup button is displayed ", true);
		} else {
			verify("Rollup button is not displayed ", false);
		}

		oSeleniumUtils.Click_given_Locator(oIUHomePage.PosRollBtn);

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		List<WebElement> iMDRollDecisionCount = getDriver()
				.findElements(By.xpath("//table[@id='s_Data_Model_Decisions_grid_1']//tr//td[2]//select"));

		String arr[] = { "No Action", "Remove" };

		for (int i = 0; i < iMDRollDecisionCount.size(); i++) {

			System.out.println(iMDRollDecisionCount.get(i).getText());

			iMDRollDecisionCount.get(i).click();

			iMDRollDecisionCount.get(i).click();

			int j = i + 1;

			String sRandomDecesion = arr[0];

			System.out.print(sRandomDecesion);

			System.out.println(
					(StringUtil.replace(oIUHomePage.GetDynamicXPath("MD ROLLDECESION", j), "sValue", sRandomDecesion)));

			oSeleniumUtils.Click_given_Locator(
					StringUtil.replace(oIUHomePage.GetDynamicXPath("MD ROLLDECESION", j), "sValue", sRandomDecesion));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			System.out.print(oIUHomePage.GetDynamicXPath("CPM PAYERSPEC COMMENTS", j));

			oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.GetDynamicXPath("CPM PAYERSPEC COMMENTS", j),
					"Test Auto Comments");

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			arr[0] = arr[1];

		}

		// oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.CPMSystemPropsalSave);

		// oGenericUtils.gfn_Click_On_Object("button", "Ok");

		getDriver().switchTo().defaultContent();
	}

	@Step
	public void GetVersionInfo() {

		oSeleniumUtils.Click_given_Locator(oIUHomePage.VersionLink);

		String sVersionInfo = getDriver().findElement(By.xpath(oIUHomePage.VersionInfo)).getText();

		System.out.println(sVersionInfo);

	}

	@Step
	public void validate_the_user_role_operation(String sUserName, String sOperation) throws InterruptedException {

		String sXpath = "//div[text()='" + sUserName + "']/..//following-sibling::td//div[text()='" + sUserName
				+ "']/..//following-sibling::td[2]//input";

		SeleniumUtils.scrollingToGivenElement(getDriver(), sXpath);

		boolean isChecked = getDriver().findElement(By.xpath(sXpath)).isSelected();

		System.out.println("fdsffffffffffffffff+++++++++++++++++++++" + isChecked);

		if (sOperation.equalsIgnoreCase("unCheck") && isChecked == true) {

			oGenericUtils.gfn_Click_String_object_Xpath(sXpath);

		} else if (sOperation.equalsIgnoreCase("Check") && isChecked == false) {

			oGenericUtils.gfn_Click_String_object_Xpath(sXpath);

		} else {

			verify("User Role for US is Already " + sOperation + "ed", true);
		}

		boolean bln = oSeleniumUtils.is_WebElement_Displayed(
				"(//div[@class='GEFT4QHBNM GEFT4QHBHM GEFT4QHBEN GEFT4QHBBN'])[3]//div[text()='Save']");

		System.out.println("Save value is returning" + bln);

		if (bln == true) {

			oGenericUtils.gfn_Click_On_Object("div", "Save");

			oGenericUtils.gfn_Click_On_Object("div", "Yes");

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		}

	}

	@Step
	public void retriveMidRulePayer() throws InterruptedException {

		System.out
				.println("Rule Version no in Multipayer" + Serenity.sessionVariableCalled("MidRuleVersion").toString());

		String sQuery = "select PAYERS_4_RULE from IRDM.interp_rule_details where   MID_RULE_DOT_VERSION='"
				+ Serenity.sessionVariableCalled("MidRuleVersion").toString() + "' and INTERP_RULE_KEY in"
				+ "(select interp_rule_key from IRDM.interp_rules where impact_key = "
				+ "(select impact_key from irdm.interp_impacts where update_instance_key ="
				+ "(select update_instance_key from IRDM.update_instances where update_instance_name ='"
				+ Serenity.sessionVariableCalled("IUInstanceName").toString() + "')))";

		System.out.println("Query is : " + sQuery);

		String sPayer = DBUtils.executeSQLQuery(sQuery);

		Serenity.setSessionVariable("PayerShots").to(StringUtils.substringBefore(sPayer, "(").trim());

		System.out.println("Query Status: " + Serenity.sessionVariableCalled("PayerShots"));
	}

	@Step
	public void validate_rule_id() {

		oIUHomePage.go_To_Rule(Serenity.sessionVariableCalled("MidRuleVersion").toString());

		boolean bln = !oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(oIUHomePage.MyTaskRuleVersion,
				"sValue", Serenity.sessionVariableCalled("MidRuleVersion").toString()));

		verify("Rule version should not be displayed", bln);

	}

	public void cancel_Retire_Rule() {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Summaries"));

		String statusCancelRetireBtn = getDriver()
				.findElement(By.xpath("//label[contains(text(),'Cancel Retire Rule')]")).getAttribute("disabled");
		System.out.println(statusCancelRetireBtn);

		if (statusCancelRetireBtn == "true") {

			verify("Cancel Retire button is Disabled", false);
		} else {
			verify("Cancel Retire button is Enabled", true);

		}

		oSeleniumUtils.highlightElement(oIUHomePage.CancelRetireRule);

		oSeleniumUtils.Click_given_WebElement(oIUHomePage.CancelRetireRule);

		GenericUtils.clickOk();

		oGenericUtils.gfn_Click_String_object_Xpath(StringUtil.replace(oIUHomePage.ButtonTag, "sValue", "Ok"));

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void retireRule(String sCreateRuleVersion) throws InterruptedException {

		// SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Summaries"));

		String statusCancelRetireBtn = getDriver()
				.findElement(By.xpath("//label[contains(text(),'Cancel Retire Rule')]")).getAttribute("disabled");

		if (!(statusCancelRetireBtn == "true")) {

			verify("Cancel Retire button is Disabled", true);
		} else {
			verify("Cancel Retire button is enabled", false);

		}

		oSeleniumUtils.Click_given_WebElement(oIUHomePage.RetireRuleBtn);

		oGenericUtils.gfn_Click_On_Object("span", "Retire Rule");

		// oSeleniumUtils.select_Given_Value_From_DropDown(oIUHomePage.Retirerule_MDecision,
		// "Do Not Retire Rule");

		oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.MD_Comments, ProjectVariables.TestComments);

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		if (sCreateRuleVersion.equalsIgnoreCase("Yes")) {

			if (oSeleniumUtils.is_WebElement_Present(oIUHomePage.Retirerule_MDecision)) {

				oSeleniumUtils.select_Given_Value_From_DropDown(oIUHomePage.Retirerule_MDecision, "Retire Rule");

				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			}
			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.CreateNewRuleVersion, "sValue", "-1"));
		}

		if (sCreateRuleVersion.equalsIgnoreCase("No")) {

			if (oSeleniumUtils.is_WebElement_Present(oIUHomePage.Retirerule_MDecision)) {

				oSeleniumUtils.select_Given_Value_From_DropDown(oIUHomePage.Retirerule_MDecision, "Do Not Retire Rule");

				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			}

			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.CreateNewRuleVersion, "sValue", "0"));
		}

		oGenericUtils.gfn_Click_On_Object("button", "Save");

		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		oGenericUtils.gfn_Click_On_Object("span", "Retire Rule");

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void validateRetireRuleLink(String sDisplay) throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		String sCurrentTab = null;

		int iCurrentTab = getDriver()
				.findElements(By.xpath(StringUtils.replace(oIUHomePage.LabelTag, "sValue", "CPM System Proposals:")))
				.size();
		if (iCurrentTab > 0) {

			sCurrentTab = "CPM Summaries";
		}

		iCurrentTab = getDriver()
				.findElements(By.xpath(StringUtils.replace(oIUHomePage.SpanTag, "sValue", "QA Review"))).size();
		if (iCurrentTab > 0) {

			sCurrentTab = "QA";
		}

		iCurrentTab = getDriver()
				.findElements(By.xpath(StringUtils.replace(oIUHomePage.SpanTag, "sValue", "Editorial"))).size();

		if (iCurrentTab > 0) {

			sCurrentTab = "Editorial";
		}

		iCurrentTab = getDriver()
				.findElements(By.xpath(StringUtils.replace(oIUHomePage.SpanTag, "sValue", "Testing Review"))).size();
		if (iCurrentTab > 0) {

			sCurrentTab = "Test";
		}

		System.out.print(sCurrentTab);

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Summaries"));

		oGenericUtils.gfn_Verify_Object_Exist("span", "Configurations Summary");

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		switch (sDisplay) {

		case "NO":

			if (!(oSeleniumUtils
					.is_WebElement_Displayed(StringUtil.replace(oIUHomePage.SpanTag, "sValue", "Retire Rule")))) {

				verify("Retire Rule Button is Disabled", true);
			} else {

				verify("Retire Rule Button is Enabled", false);

			}
			break;

		case "YES":

			if (!(oSeleniumUtils
					.is_WebElement_Displayed(StringUtil.replace(oIUHomePage.SpanTag, "sValue", "Retire Rule")))) {

				verify("Retire Rule Button is Disabled", false);
			} else {

				verify("Retire Rule Button is Enabled", true);

			}
			break;
		}

		System.out.println(sCurrentTab);
		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", sCurrentTab));

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void retireRuleValidationInDB(String sDosDate, String sRetired) throws Exception {

		// Serenity.setSessionVariable("MidRuleVersion").to("11616.3");
		String[] sRuleVersion = Serenity.sessionVariableCalled("MidRuleVersion").toString().split("\\.");

		String sQuery = "select DEACTIVATED_10 from rules.sub_rules Where MID_RULE_KEY = '" + sRuleVersion[0]
				+ "' and RULE_VERSION = '" + sRuleVersion[1] + "'";

		String sQuery2 = "select DOS_TO from rules.sub_rules Where MID_RULE_KEY = '" + sRuleVersion[0]
				+ "' and RULE_VERSION = '" + sRuleVersion[1] + "'";

		System.out.println(sQuery);

		String sResult = DBUtils.executeSQLQuery(sQuery);
		System.out.println("result1 " + sResult);

		String sResult2 = DBUtils.executeSQLQuery(sQuery2);

		String[] sResultDOS = sResult2.split(" ");

		System.out.println("results2 " + sResultDOS[0]);

		switch (sRetired) {

		case "YES":

			if (((sResult.equalsIgnoreCase("-1")) && ((sResultDOS[0].equalsIgnoreCase(sDosDate))))) {

				verify("Validate Retire Rule Status in RMI-YES :"
						+ Serenity.sessionVariableCalled("MidRuleVersion").toString()
						+ "Rule Retired successfully Validated in RMI", true);

			} else {
				verify("Validate Retire Rule Status in RMI-YES :"
						+ Serenity.sessionVariableCalled("MidRuleVersion").toString() + " is Rule not Retired", false);
			}

			break;

		case "NO":

			if (((sResult.equalsIgnoreCase("0")) && ((sResultDOS[0].equalsIgnoreCase(sDosDate))))) {

				verify("Validate Retire Rule Status in RMI-NO :"
						+ Serenity.sessionVariableCalled("MidRuleVersion").toString()
						+ "Rule is not Retired Validated in RMI", true);

			} else {
				verify("Validate Retire Rule Status in RMI-NO :"
						+ Serenity.sessionVariableCalled("MidRuleVersion").toString() + " is Rule Retired", false);
			}

			break;
		}

	}

	@Step
	public void validateCPMImpactCodeListGrid(String sTab) throws InterruptedException {
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		switch (sTab) {

		case "Summaries":
			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "Summaries"));
			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.SpanTag, "sValue", "Impact Code List"));
			int iImpactCodeGridData = getDriver()
					.findElements(By
							.xpath("//table[@id='impactCodeListGrid']//tr[@class='ui-widget-content jqgrow ui-row-ltr']"))
					.size();
			int iImpactCPTCode = getDriver()
					.findElements(By.xpath("//table[@id='impactCodeListGrid']//td[@title='0019T']")).size();
			if (iImpactCodeGridData > 0) {

				verify("Impact Code List Details are displayed in Summaries ", true);
				if (iImpactCPTCode > 0) {
					verify("CPT code is displayed in Summaries ", true);
				} else {
					verify("CPT code is NOT displayed in Summaries ", true);
				}

			} else {

				verify("Impact Code List Details are displayed in Summaries ", false);
			}
			break;

		case "CPM Summaries":
			oSeleniumUtils
					.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag, "sValue", "CPM Summaries"));
			oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.SpanTag, "sValue", "Impact Code List"));
			int iImpactCodeGridData2 = getDriver()
					.findElements(By
							.xpath("//table[@id='impactCodeListGrid']//tr[@class='ui-widget-content jqgrow ui-row-ltr']"))
					.size();
			int iImpactCPTCode2 = getDriver()
					.findElements(By.xpath("//table[@id='impactCodeListGrid']//td[@title='0019T']")).size();

			if (iImpactCodeGridData2 > 0) {

				verify("Impact Code List Details are displayed in CPM Summaries ", true);

				if (iImpactCPTCode2 > 0) {
					verify("CPT code is displayed in CPM Summaries ", true);
				} else {
					verify("CPT code is NOT displayed in CPM Summaries ", true);
				}

			} else {

				verify("Impact Code List Details are displayed in CPM Summaries ", false);
			}
			break;
		}

		// oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.TabheadingTag,
		// "sValue", "Modify Decisions"));

		oGenericUtils.gfn_Click_String_object_Xpath("//label[contains(text(),'Modify Decisions')]");
		oSeleniumUtils.Enter_given_Text_Element(
				"//table[@id='cpmProposalGrid']//textarea[@name='cpmInterpComment.comments']", "Test");
		oGenericUtils.gfn_Click_String_object_Xpath("//div[@ng-show='hasSystemProposals']//label[text()='Save']");
		oGenericUtils.gfn_Click_On_Object("button", "Ok");

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void validateCPTARD() throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		int iCPTARDLink = getDriver().findElements(By.xpath("//a[text()='CPT ARD']")).size();

		if (iCPTARDLink > 0) {
			verify("CPTARD Link is displayed ", true);
			oGenericUtils.gfn_Click_String_object_Xpath("//a[text()='CPT ARD']");
		} else {
			verify("CPTARD Link is NOT displayed ", false);

		}
		getDriver().switchTo().defaultContent();

		SeleniumUtils.switchWindowUsingWindowCount(2, 2, getDriver());

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

		oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.BuilderARD_UserName, "iht_ittest01");
		oSeleniumUtils.Enter_given_Text_Element(oIUHomePage.BuilderARD_Password, "Ihealth123");
		oSeleniumUtils.Click_given_WebElement(oIUHomePage.Builder_SignInBtn);

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oGenericUtils.gfn_Verify_String_Object_Exist("//div[@class=' x-form-field-wrap x-form-readonly x-component']");

		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		SeleniumUtils.switchWindowUsingWindowCount(2, 1, getDriver());

	}

	@Step
	public void validateConfigPayerSpecificDecision() throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oGenericUtils.gfn_Click_String_object_Xpath(
				StringUtil.replace(oIUHomePage.SpanTag, "sValue", "Configurations Summary"));

		int iConfigSummaryData = getDriver()
				.findElements(By.xpath(StringUtil.replace(oIUHomePage.SpanTag, "sValue",
						" No Configuration Summary data displayed because Payer specific decisions exists for the rule")))
				.size();

		if (iConfigSummaryData > 0) {
			verify("Configurations Summary message for payer specific Decision is displayed successfully ", true);
			oGenericUtils.gfn_Click_String_object_Xpath("//a[text()='CPT ARD']");
		} else {
			verify("Configurations Summary message for payer specific Decision is NOT displayed ", false);

		}

		getDriver().switchTo().defaultContent();

	}

	@Step
	public void setRequirePresentation() {

		oIUHomePage.go_To_Rule(Serenity.sessionVariableCalled("MidRuleVersion").toString());

		verify("MidRule Version is :" + Serenity.sessionVariableCalled("MidRuleVersion").toString(), true);
		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.SelectRule, "sValue",
				Serenity.sessionVariableCalled("MidRuleVersion").toString()));
		oSeleniumUtils
				.Click_given_Locator((StringUtil.replace(oIUHomePage.DivTag, "sValue", "Set Requires Presentation")));
		oSeleniumUtils.Click_given_Locator(
				(StringUtil.replace(oIUHomePage.DivTag, "sValue", "Set to Requires Presentation")));

	}

	@Step
	public void returnRequiresPresentationRule() throws InterruptedException {

		oSeleniumUtils.Click_given_WebElement(oIUHomePage.Col_Rule_Grid);
		SeleniumUtils.defaultWait(ProjectVariables.MIN_THREAD_WAIT);
		

//		oGenericUtils.gfn_Click_On_Object("span", "Return Requires Presentation Rule");

		 int i = getDriver().findElements(By.xpath("//div[text()='Return Requires Presentation Rule']")) .size();
		
		 if (i > 0) {
			 oGenericUtils.gfn_Click_String_object_Xpath("//div[text()='Return Requires Presentation Rule']");
		 
		 } else {
			 oSeleniumUtils.Click_given_WebElement(oIUHomePage.ReAssignNavigationAdmin);
		 oGenericUtils.gfn_Click_On_Object("span", "Return Requires Presentation Rule");
		
		 }
		 SeleniumUtils.defaultWait(ProjectVariables.MIN_THREAD_WAIT);
		oGenericUtils.gfn_Verify_Object_Exist("div", "Return Requires Presentation Rule");

		oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ReturnRequirePresentRuleChk, "sValue",
				Serenity.sessionVariableCalled("MidRuleVersion").toString()));

		oGenericUtils.gfn_Click_On_Object("div", "Return Selected Rules for CPM Decision Review");

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

	}

	@Step
	public void capturingAllFilterValues(String sWorkQueue) throws InterruptedException {

		List<String> sFilters = Arrays.asList(sWorkQueue.split(","));

		for (int i = 0; i < sFilters.size(); i++) {

			oSeleniumUtils.Click_given_Locator(
					StringUtil.replace(oIUHomePage.ActiveFiterDropDwnBtn, "sValue", sFilters.get(i).replace(":", "")));

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.Loading);

			String[] sFilterValues = oSeleniumUtils.get_All_Text_from_Locator(oIUHomePage.FilterValuesInDropDown);

			String sValue = sFilters.get(i).replace(":", "");

			System.out.println("Filter List size" + sFilterValues.length);

			Serenity.setSessionVariable(sValue).to(sFilterValues);

			if (oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.CloseIconFilterDropDown) == true) {

				oGenericUtils.gfn_Click_String_object_Xpath("//label[contains(text(),'" + sValue + "')]");

				// oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.CloseIconFilterDropDown);

				if (oSeleniumUtils.is_WebElement_Displayed(oIUHomePage.CloseIconFilterDropDown) == true) {

					oGenericUtils.gfn_Click_String_object_Xpath("//label[contains(text(),'" + sValue + "')]");
				}

			} else {

				oSeleniumUtils.Click_given_Locator(StringUtil.replace(oIUHomePage.ActiveFiterDropDwnBtn, "sValue",
						sFilters.get(i).replace(":", "")));
			}

		}

	}

	public void user_selects_the_rule_in_AdminScrub(String arg1) throws InterruptedException {

		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);
		oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.AllRulesRadioBtn);

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oGenericUtils.gfn_Click_String_object_Xpath(
				"(//input[@ng-model='grid.appScope.rowsList[grid.appScope.findRowIndex(row)].checked'])[1]");

		String sRule = oSeleniumUtils
				.get_TextFrom_Locator("(//div[@class='ngCellText ui-grid-cell-contents ng-binding ng-scope'])[4]");

		Serenity.setSessionVariable("NonCandidateRule").to(sRule);

		String sVersion = oSeleniumUtils
				.get_TextFrom_Locator("(//div[@class='ngCellText ui-grid-cell-contents ng-binding ng-scope'])[5]");

		Serenity.setSessionVariable("NonCandidateRuleVersion").to(sVersion);

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		switch (arg1) {
		case "Process Candidates":

			oGenericUtils.gfn_Click_On_Object("a", arg1);

			break;
		case "Process Non Candidates":

			oGenericUtils.gfn_Click_On_Object("a", arg1);
			break;
		case "Process Non Candidates-RemainingRules":

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.AllRulesRadioBtn);

			oGenericUtils.gfn_Click_String_object_Xpath(
					"(//input[@ng-model='grid.appScope.rowsList[grid.appScope.findRowIndex(row)].checked'])[1]");

			oGenericUtils.gfn_Click_On_Object("a", "Process Non Candidates");

			break;
		case "Process Candidates-All Rules":

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.AllRulesRadioBtn);

			oSeleniumUtils.Click_given_Locator("//span[text()='Review']/parent::div/parent::div/parent::div//input");

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);

			oGenericUtils.gfn_Click_On_Object("a", "Process Candidates");
			break;

		}

		getDriver().switchTo().defaultContent();

	}

	public void click_On_button_AdminScrubPage(String arg1) throws InterruptedException {
		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);
		if (arg1.equalsIgnoreCase("All Rules Radio")) {

			oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.AllRulesRadioBtn);

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);

		} else if (arg1.equalsIgnoreCase("Only Unscrubbed Rules Radio"))

		{

			oGenericUtils.gfn_Click_String_object_Xpath("//input[@type='radio' and @value='all']");

			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);

		} else {

			if (arg1.equalsIgnoreCase("Release")) {

				int i = 0;

				while (oSeleniumUtils.is_WebElement_Displayed("//a[text()='Release' and @disabled='disabled' ]")
						& i != 50) {

					SeleniumUtils.defaultWait(1000);

					oGenericUtils.gfn_Click_String_object_Xpath("//input[@type='radio' and @value='all']");

					oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.AllRulesRadioBtn);

					i = i + 1;

					if (i == 50) {

						System.out.println("Release button is not enabled");

						GenericUtils.Verify("Release button is enabled" + "Wait Time: " + (i * 2) + "Secs", false);

					}

				}

			}

			oGenericUtils.gfn_Click_On_Object("a", arg1);

		}

		oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);

		getDriver().switchTo().defaultContent();

		// if (arg1.equalsIgnoreCase("Dashboard")) {
		//
		// SeleniumUtils.switchWindowUsingWindowCount(4, 3, getDriver());
		//
		// }
		//
		// SeleniumUtils.defaultWait(3000);

	}

	@Step
	public void validateDirectReleaseBtnStatus(String arg1, String arg2) throws InterruptedException {
		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);
		switch (arg2) {
		case "Process Non Candidates":

			verify("Direct Release button is Enabled",
					oIUHomePage.StatusBtnDirectRelease().equalsIgnoreCase("enabled"));

			oGenericUtils.gfn_Click_String_object_Xpath(
					"(//input[@ng-model='grid.appScope.rowsList[grid.appScope.findRowIndex(row)].checked'])[1]");
			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			WebElement e = getDriver().findElement(By.xpath("//a[text()='Direct Release']"));
			(new Actions(getDriver())).moveToElement(e).click().build().perform();
			// SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			// verify("Displayed 'Need to select row(s) to process' Messege "
			// ,oGenericUtils.gfn_Click_String_object_Xpath("//div[text()='Need
			// to select row(s) to process.']"));
			verify("Displayed  'Please select only Candidate Rules' Messege ",
					oGenericUtils.gfn_Click_String_object_Xpath("//div[text()='Please select only Candidate Rules']"));
			break;
		case "Process Candidates":

			verify("Direct Release button is Enabled",
					oIUHomePage.StatusBtnDirectRelease().equalsIgnoreCase("enabled"));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oGenericUtils.gfn_Click_String_object_Xpath(
					"(//input[@ng-model='grid.appScope.rowsList[grid.appScope.findRowIndex(row)].checked'])[1]");
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			verify("Mouse Over on Direct Release Button ", oIUHomePage.mouseOverDirectRelease());
			if (getDriver().findElements(By.xpath("//div[text()='Please select only Candidate Rules']")).size() > 0) {
				verify("Messege Should not be shown", false);
			}
			break;

		case "Unscrubbed Rules":

			verify("Direct Release button is  Enabled ",
					oIUHomePage.StatusBtnDirectRelease().equalsIgnoreCase("enabled"));
			verify("clicked on Direct Release button ", oGenericUtils.gfn_Click_On_Object("a", "Direct Release"));
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			verify("Displayed  'Need to select row(s) to process' Messege ",
					oGenericUtils.gfn_Click_String_object_Xpath("//div[text()='Need to select row(s) to process.']"));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			verify("selected Rule ", oGenericUtils.gfn_Click_String_object_Xpath(
					"(//input[@ng-model='grid.appScope.rowsList[grid.appScope.findRowIndex(row)].checked'])[1]"));
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			verify("click on Direct Release button ", oGenericUtils.gfn_Click_On_Object("a", "Direct Release"));
			verify("Displayed  'Please select only Candidate Rules' Messege ",
					oGenericUtils.gfn_Click_String_object_Xpath("//div[text()='Please select only Candidate Rules']"));

			break;

		case "Admin View":
			oGenericUtils.gfn_Click_On_Object("a", "Admin View");
			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);
			verify("Direct Release button is  disabled ",
					oIUHomePage.StatusBtnDirectRelease().equalsIgnoreCase("disabled"));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			oGenericUtils.gfn_Click_String_object_Xpath(
					"(//input[@ng-model='grid.appScope.rowsList[grid.appScope.findRowIndex(row)].checked'])[1]");
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			verify("Direct Release button is  disabled ",
					oIUHomePage.StatusBtnDirectRelease().equalsIgnoreCase("disabled"));

			break;
		case "Candidates Non Candidates":
			verify("User Clicked on AllRules ",
					oGenericUtils.gfn_Click_String_object_Xpath(oIUHomePage.AllRulesRadioBtn));
			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			oGenericUtils.gfn_Click_String_object_Xpath(
					"(//input[@ng-model='grid.appScope.rowsList[grid.appScope.findRowIndex(row)].checked'])[1]");
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			oGenericUtils.gfn_Click_String_object_Xpath(
					"(//input[@ng-model='grid.appScope.rowsList[grid.appScope.findRowIndex(row)].checked'])[2]");
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			verify("clicked on Direct Release button ", oGenericUtils.gfn_Click_On_Object("a", "Direct Release"));
			verify("Displayed  'Please select only Candidate Rules' Messege ",
					oGenericUtils.gfn_Click_String_object_Xpath("//div[text()='Please select only Candidate Rules']"));

			break;

		case "Direct Release":

			verify("Direct Release button is Enabled",
					oIUHomePage.StatusBtnDirectRelease().equalsIgnoreCase("enabled"));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			oGenericUtils.gfn_Click_String_object_Xpath(
					"(//input[@ng-model='grid.appScope.rowsList[grid.appScope.findRowIndex(row)].checked'])[1]");
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			String sRule = oSeleniumUtils
					.get_TextFrom_Locator("(//div[@class='ngCellText ui-grid-cell-contents ng-binding ng-scope'])[4]");
			Serenity.setSessionVariable("NonCandidateRule").to(sRule);

			String sVersion = oSeleniumUtils
					.get_TextFrom_Locator("(//div[@class='ngCellText ui-grid-cell-contents ng-binding ng-scope'])[5]");
			Serenity.setSessionVariable("NonCandidateRuleVersion").to(sVersion);

			String sMidRuleVersion = sRule + "." + sVersion;
			System.out.println(sMidRuleVersion);

			String sTaskType = oSeleniumUtils
					.get_TextFrom_Locator("(//div[@class='ngCellText ui-grid-cell-contents ng-binding ng-scope'])[6]");
			Serenity.setSessionVariable("TaskType").to(sTaskType);

			verify("Mouse Over on Direct Release Button ", oIUHomePage.mouseOverDirectRelease());
			if (getDriver().findElements(By.xpath("//div[text()='Please select only Candidate Rules']")).size() > 0) {
				verify("Messege Should not be shown", false);
			}
			verify("clicked on Direct Release button ", oGenericUtils.gfn_Click_On_Object("a", "Direct Release"));
			String sUIMsg = oSeleniumUtils.get_TextFrom_Locator("//div[contains(text(),'Directly Released rules ')]");

			verify("Displayed Messege 'Directly Released rules..' ",
					oSeleniumUtils.get_TextFrom_Locator("//div[contains(text(),'Directly Released rules ')]").trim()
							.contains("Directly Released rules shall be routed to Rule Review process"));
			oGenericUtils.gfn_Click_On_Object("button", "Yes");
			oIUHomePage.waitUntil_Loading_Dailog_Disappears(oIUHomePage.AdminScrubImageLoader);

			String sQuery = " SELECT DISTINCT TASK_TYPE_DESC FROM IRDM.INTERP_RULES IR JOIN IRDM.INTERP_RULE_DETAILS IRD ON IR.INTERP_RULE_KEY = IRD.INTERP_RULE_KEY JOIN IPDE.TASK_DETAILS TD ON TD.REFERENCE_RULE_ID = IR.INTERP_RULE_KEY LEFT JOIN \r\n"
					+ " IPDE.CPM_TASK_DETAILS CTD ON TD.TASK_DETAIL_KEY = CTD.TASK_DETAIL_KEY JOIN IPDE.TASK_TYPE_LKP TTL ON TTL.TASK_TYPE_KEY = CASE WHEN TD.TASK_TYPE_KEY = 16 THEN CTD.TASK_TYPE_KEY  ELSE TD.TASK_TYPE_KEY END JOIN \r\n"
					+ " IPDE.TASK_STATUS_LKP TSL ON TSL.TASK_STATUS_KEY = CASE WHEN TD.TASK_TYPE_KEY = 16 THEN CTD.TASK_STATUS_KEY ELSE TD.TASK_STATUS_KEY END  JOIN IPDE.USERS U  ON U.USER_KEY = CASE WHEN TD.TASK_TYPE_KEY = 16 \r\n"
					+ " THEN CTD.USER_KEY ELSE TD.TASK_USER_KEY END WHERE IR.IMPACT_KEY IN (SELECT IMPACT_KEY FROM IRDM.INTERP_IMPACTS II JOIN IRDM.UPDATE_INSTANCES I ON I.UPDATE_INSTANCE_KEY = II.UPDATE_INSTANCE_KEY \r\n"
					+ " WHERE UPDATE_INSTANCE_NAME = '" + Serenity.sessionVariableCalled("IUInstanceName").toString()
					+ "') AND IRD.MID_RULE_DOT_VERSION  ='" + sMidRuleVersion + "' and rownum ='1'";
			System.out.println("Query is : " + sQuery);

			String sDBTaskValue = DBUtils.executeSQLQuery(sQuery);
			// String sDBTaskValue =
			// DBUtils.executeSQLQuery(DBQueries.sQueryTaskTypeAndStatus("TTL.TASK_TYPE_DESC",
			// Serenity.sessionVariableCalled("InstanceName").toString(),
			// sMidRuleVersion));

			verify("Rule is Directly Released to " + sTaskType, sDBTaskValue.trim().equalsIgnoreCase(sTaskType.trim()));

			break;
		}

		getDriver().switchTo().defaultContent();
	}

	@Step
	public void user_enters_the_comments_and_click_on_the_button() throws InterruptedException {
		oSeleniumUtils.SwitchToFrame(oIUHomePage.frame);

		oGenericUtils.gfn_Click_String_object_Xpath("//textarea[@id='modalProcessTextArea']");
		oSeleniumUtils.Enter_given_Text_Element("//textarea[@id='modalProcessTextArea']", "Autotest");

		oGenericUtils.gfn_Click_On_Object("a", "Apply");

		SeleniumUtils.defaultWait(3000);
		getDriver().switchTo().defaultContent();

	}

	@Step
	public void loadSimDataInDB(String arg1, String arg2) throws InterruptedException {

		/*
		 * if (Serenity.sessionVariableCalled("NewInstanceName")!= null){
		 * Serenity.setSessionVariable("NewInstanceName").to(arg1); }
		 */
		String sQuery = "";
		switch (arg2) {
		case "QueryREV144":
			sQuery = "INSERT INTO IRDM.CPT_UPDATES (CPT_UPDATE_KEY,   CPT_CODE,   DESCRIPTION,  OLD_DESCRIPTION,  UPDATE_GROUP_KEY,     UPDATE_INSTANCE_KEY,  RULE_IMPACT_10,  RESEQ_10)  VALUES ( (SELECT MAX (CPT_UPDATE_KEY) + 1   FROM IRDM.CPT_UPDATES),"
					+ "  '" + arg1
					+ "',  'STOMA PLUG OR SEAL, ANY TYPE', 'CONTINENT DEVICE; PLUG FOR CONTINENT STOMA', '3',   (SELECT UPDATE_INSTANCE_KEY    FROM IRDM.UPDATE_INSTANCES   WHERE update_instance_name   = '"
					+ Serenity.sessionVariableCalled("NewInstanceName") + "' ), -1, 0 )\r\n";
			break;

		case "QueryDEL1K":
			sQuery = "INSERT INTO IRDM.CPT_UPDATES (CPT_UPDATE_KEY,   CPT_CODE,   DESCRIPTION,  OLD_DESCRIPTION,  UPDATE_GROUP_KEY,     UPDATE_INSTANCE_KEY,  RULE_IMPACT_10,  RESEQ_10)  VALUES ( (SELECT MAX (CPT_UPDATE_KEY) + 1   FROM IRDM.CPT_UPDATES),"
					+ "  '" + arg1
					+ "',  'STOMA PLUG OR SEAL, ANY TYPE', 'CONTINENT DEVICE; PLUG FOR CONTINENT STOMA', '2',   (SELECT UPDATE_INSTANCE_KEY    FROM IRDM.UPDATE_INSTANCES   WHERE update_instance_name   = '"
					+ Serenity.sessionVariableCalled("NewInstanceName") + "' ), -1, 0 )\r\n";
			break;
		}

		System.out.println("Insert Query " + sQuery);
		String sSubRuleKey = DBUtils.insertSQLQuery(sQuery);
		SeleniumUtils.defaultWait(ProjectVariables.MID_SLEEP);

	}

	@Step
	public void requestImpactAnalysis(String arg1, String arg2) throws InterruptedException {
		// Serenity.setSessionVariable("NewInstanceName").to("CPTAutoIV974");
		String sInstance = Serenity.sessionVariableCalled("NewInstanceName").toString();
		// oGenericUtils.gfn_Click_String_object_Xpath("//div[text()='Interpretive
		// Update Instances']");
		oGenericUtils.gfn_Click_String_object_Xpath("//div[text()='Refresh']");
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		oGenericUtils.gfn_Click_String_object_Xpath("(//div[text()='" + sInstance + "'])[1]");
		oGenericUtils.gfn_Click_String_object_Xpath("//div[text()='Request Impact Analysis']");
		oGenericUtils.gfn_Click_String_object_Xpath("(//div[text()='Request Impact Analysis'])[3]");
		oGenericUtils.gfn_Click_String_object_Xpath("//div[text()='Yes']");
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		oGenericUtils.gfn_Click_String_object_Xpath("//div[text()='OK']");

		oGenericUtils.gfn_Click_String_object_Xpath("//div[text()='Interpretive Update Instances']");
		oGenericUtils.gfn_Click_String_object_Xpath("//div[text()='Refresh']");

	}

	@Step
	public void checkInstanceAfterImpact(String arg1) throws InterruptedException {
		// Serenity.setSessionVariable("NewInstanceName").to("CPTAutoIV80");
		String sInstance = Serenity.sessionVariableCalled("NewInstanceName").toString();
		String sInstanceStatus = oSeleniumUtils
				.get_StringTextFrom_Locator("(//div[text()='" + sInstance + "'])[1]/../..//td[7]");
		verify("Instance Status is : " + sInstanceStatus + "", true);

		int iwaittime = 0;
		boolean blnFlag = false;
		int iTimer = 0;
		if (arg1.equalsIgnoreCase("6")) {
			iwaittime = 6;
		}
		if (arg1.equalsIgnoreCase("60")) {
			iwaittime = 60;
		}
		if (arg1.equalsIgnoreCase("7")) {
			iwaittime = 6;
		}
		if (arg1.equalsIgnoreCase("8")) {
			iwaittime = 6;
		}
		do {

			List<WebElement> sList = getDriver().findElements(
					By.xpath("(//div[text()='" + sInstance + "'])[1]/../..//td//div[text()='Admin PO Scrub Review']"));

			if (sList.size() > 0) {
				for (int i = 0; i < sList.size(); i++) {
					if (sList.get(i).isDisplayed()) {
						oSeleniumUtils.highlightElement(sList.get(i));
						
						blnFlag = true;
						break;
					}
				}
			}

			if (!blnFlag) {
				Thread.sleep(ProjectVariables.MID_TIME_OUT); // 10 Seconds
				oGenericUtils.gfn_Click_String_object_Xpath("//div[text()='Refresh']");
			}
			iTimer = iTimer + 1;

		} while ((blnFlag != true) && (iTimer != iwaittime));

		if (blnFlag != true) {
			verify(" Admin PO Scrub Review not found " + "Instance Status is " + sInstanceStatus, false);
			blnFlag = false;
		}

	}

}
