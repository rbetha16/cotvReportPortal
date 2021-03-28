package project.pageobjects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.WhenPageOpens;
import project.utilities.GenericUtils;
import project.utilities.ProjectVariables;
import project.utilities.SeleniumUtils;

public class CPHomePage extends PageObject {
	
	SeleniumUtils oSeleniumUtils;
	
	@FindBy(xpath = "//input[@name='username']")
	public WebElementFacade UserName_Txt;
	
	@FindBy(xpath = "//input[@name='password']")
	public WebElementFacade Password_Txt;
	
	@FindBy(xpath = "//button[@id='loginButton']")
	public WebElementFacade Login_Btn; 
	
	@FindBy(xpath = "//a[contains(text(),'Publisher')]")
	public WebElementFacade Publisher_Link;
	
	@FindBy(xpath = "//a[text()='Dashboard']")
	public WebElementFacade Dashboard_Link;
	
	@FindBy(xpath = "//a[text()=' Log Out ']")
	public WebElementFacade LogOut_Link;
	
	public String OnShoreCheckbox="// label[text()='On Shore Only']/preceding-sibling::input";

	 String sTab_Publisher="//a[contains(text(),'Publisher')]";
	 
	 public String sPopup_Loading="//div[@aria-hidden='true']/..//div[contains(text(),'Loading')]";
	 
	 String sPopup_Processing="//div[@aria-hidden='true']/..//div[contains(text(),'Processing')]";
	 
	 String sEdt_QuickSearch="//div/input[@class='GNFQ33GDE2 GNFQ33GDP1 GNFQ33GDO1']";
	 
	 String sBtn_QuickSearch="//div[@class='GNFQ33GDF2']/../../img";
	 
	 String sBtn_View_Edit="//div[@id='edit']/./img";

	public String ChooseFilebutton="//input[@id='file']";

	public String frame="//iframe[@id='CpPortalFrame']";
	
	public String GWTFrame = "//iframe[@class='frame ng-scope']";
	
	public String Span="(//span[contains(text(),'value')])";
	
	public String PayerShot="(//span[text()='sValue']/parent::div/child::div)";
	
	public String NavigationLink="//a[@ui-sref='.value']";
	
	public String DropDown="//label[text()='svalue']/following-sibling::div[@class='clint_fliter']/div/div/div/div";
	
	public String ClientSearchBox="//div[@id='innerListBoxngxDropDownListvalue']/div/div/div/input";
	
	public String LoadingIcon="//div[@id='spinner']/div/span";
	
	public String LoadingIcon1="//div[@id='cpt_master_spinner']/div/span";
	
	public String Add_button="//label[text()='value']/following-sibling::div[@class='clint_fliter']/div/div/button";
	
	public String Button_With_Text="//button[contains(text(),'value')]";
	

	public String Button_With_ExactText="//button[text()='value']";
	
	public String Locator_with_I_tag="//i[contains(@ng-click,'svalue')]";
	
	public String Icon_With_Div="(//div[@title='svalue'])"; 
	
	public String Btn_Applyfilters = "//button[contains(@ng-click,'applyFilters()')]";
	
	public String Text_with_Div="//div[contains(text(),'value')]";
	
	public String Button_with_ngclick="//button[contains(@ng-click,'svalue')]";
	
	public String Anchor_Tag="//a[text()='value']";
	
	public String PolicySetsIcon="(//button[@ng-click='cancelDeltaViewDialog()'])[1]";
	
	public String DeltaReady_Cancel_button="(//a[contains(text(),'Commit')])/preceding-sibling::a";
	
	public String DeltaReady_FilterIcon="//i[@class='ui-grid-icon-menu']/..";
	
	public String StateMedicaid_AuditLog="(//div[@title='Audit Log'])[3]/../following-sibling::div[1]";
	
	public String DeltaReady_FilterOptions="(//li[@ng-repeat='item in menuItems'])";

	public String Span_with_Exact_text="//span[text()='value']";

	public String TableType="//span[text()='value']";
	
	public String sNamedTab = "//div[@id='centerDeckPanel']/div[2]//ul//span[text()='Named Set Tables']";
	
	public String TableID="((//input[@title='Edit'])[svalue]/../../following-sibling::div/div)[3]";
	
	public String DMU_TableID="(//div[@title='Edit'])[svalue]/../following-sibling::div[columnnum]";
	
	public String NamedSetTable_ID="//div[text()='value'][@class='ui-grid-cell-contents ng-binding ng-scope']";
	
	public String TableName="//div[text()='value'][@class='ui-grid-cell-contents ng-binding ng-scope']/../following-sibling::div/div[contains(text(),'UNMAPPED')]";
	
	public String EditIcon_With_TableID="//div[text()='value']/../preceding-sibling::div/div/input[@title='Edit']";
	
	public String EditIcon_With_TableID_DMU="//div[text()='value']/../preceding-sibling::div/div[@title='Edit']";
	
	public String TableLoadStatus="(//li[contains(text(),'Table Load Status :')]/b)";

	public String InformationPopUp="//p[contains(text(),'value')]";
	
	public String DataloadStatus="//li/b[contains(text(),'value')]";
	
	public String PolicySetConfiguration_Div="(//div[@role='rowgroup'][@style='overflow: scroll;'])[1]";
	
	public String NamedSetTable_Size="(//div[text()='value']/../../../preceding-sibling::div)";

	public String State_Dropdown="//div[@class='modal-body row']/div/div[text()='State']/following-sibling::div/div/div";

	public String StatesSize="(//div[contains(@id,'listBoxContentinnerListBoxngxDropDownList')]/div/div/span)";
	
	public String ClaimType="//label[text()='value']/preceding-sibling::input[@type='radio']";
	
	public String StatesScrollbar="(//div[contains(@id,'ngxScrollBtnDownverticalScrollBarinnerListBoxngxDropDownList')])[2]";
	
	public String State="(//div[contains(@id,'listBoxContentinnerListBoxngxDropDownList')]/div/div/span[text()='value'])";

	public String StateMedicaid_EditIcon="//div[text()='state']/../following-sibling::div/div[text()='ctype']/../preceding-sibling::div/div[@title='Edit']";
	
	public String Additions="//span[@ng-show='getNumberOfAdditionsFn()>0']";

	public String Changes="//span[@ng-show='getNumberOfChangesFn()==0']";

	public String Div_With_Title="//div[contains(@title,'value')]";
	
	public String NamedSet_Icon="(//div[@class='gridIcon viewDataNamedSetIcon ng-scope'])";
	
	public String SourceConfig_DropDownList="(//div[contains(@id,'innerListBoxngxDropDownListvalue')]/span)";
	
	public String SaveandUpdate_Button="//a[@ng-click='onSave()']";
	
	public String EandM_Basis_Bilateral_type="//span[contains(text(),'value')]/../input";
	
	public String Delta_with_Id="//div[text()='value']/../preceding-sibling::div/div[contains(@title,'Delta')]";
	
	public String CurrentDerivationStatus="(//li[contains(text(),'Current Derivation')]/following-sibling::li/span)[1]";
	
	public String label="//label[text()='svalue']";
	
	public String Cancel_button="//a[contains(text(),'Cancel')][@ng-click='cancelDeltaViewDialog()']";
	
	public String State_Textbox="(//div[contains(@id,'listBoxContentinnerListBoxngxDropDownList')]/preceding-sibling::div/input)[2]";
	
	public String PolicySetConfig_Row="//div[@title='value']/../preceding-sibling::div";
	
	public String MappedCell_in_CMU="(//div[text()='payer'])/../following-sibling::div/div[text()='insurance']/../following-sibling::div[value]";
	
	public String SourceFile_Scroll_Down="//div[contains(@id,'ScrollWrapverticalScrollBarinnerListBoxngxDropDownListvalue')]/div[last()]";
	
	public String SelectAll_Checkbox="(//div[contains(@ng-if,'SelectAll')])";
	
	public String Div_with_ngclick="//div[contains(@ng-click,'svalue')]";
	
	public String BulkloadScreen_RowsCount="((//div[@role='grid'])[5]//div[@role='rowgroup'][2]/div[@class='ui-grid-canvas']//div[contains(@ng-repeat,'colContainer.renderedColumns')][value])[1]/div/..//div[@class='ng-scope']//input";
	
	public String DeltaScreenRowsCount_in_MUVDeltaTab="(//div[@class='ui-grid-canvas'])[5]/div";
	
	public String DeltaScreenRowsCount_in_ApprovedeltaTab="(//div[@class='ui-grid-canvas'])[6]/div";
	
	public String DeltaScreen_Table_Newcol_firstrowvalues="(//div[@class='ui-grid-canvas'])[5]/div/div/div[scount]";
	
	public String DeltaScreen_Table_Newcol_rowvalues="(//div[@class='ui-grid-canvas'])[5]/div/div[2]/div/div[2]/div/div[2]/div/div[rowvalue]/div/div[scount]";
	
	public String CMU_Mapped_ID_text="(//div[contains(@id,'innerListBoxngxDropDownListvalue')]/span[contains(text(),'MU Source')])";
	
	public String SourceFileDropDown_text="(//div[contains(@id,'innerListBoxngxDropDownListvalue')]/span[contains(text(),'source')])/..";

	public String DMUV_Delta_Screen_expected_Rows="((//div[@role='grid'])[5]//div[@role='rowgroup'][2]/div[@class='ui-grid-canvas']//div[contains(@ng-repeat,'colContainer.renderedColumns')][cell])[row]/div/..//div";
	
	public String MiddlePanel_cellslist="(//div[@ng-mousedown='grid.appScope.policySetClickFn(row, col, $event)'])";
	
	public String HyperLink_With_ngclick="//a[contains(@ng-click,'value')]";

	public String TableTypevalues="//div[contains(@id,'ContentinnerListBox')]/div/div/span[text()='value']";

	public String Unmapped_Count = "//div[text()=0]";
	
	public String Map1 = "(//div[text()=0])[1]";
	
	public String Map2 = "(//div[text()=0])[2]";
	
	public String btn_MSave = "//button[@ng-click='checkAndSavePolicySetsConfigFn()']";
	
	public String btn_Confirm = "//button[text()='Confirm']";
	
	public String Button_With_HyperLink="(//a[contains(text(),'svalue')])";
	
	public String text_with_header3="(//h3[contains(text(),'value')])";
	
	public String Icon="(//input[@class='editNamedSetIcon'])[position()=last()]";
	
	public String Icon_Edit = "(//div[@title='Edit'])[position()=last()]";
	
    public String Div_with_ExactText="(//div[text()='value'])";
    
    public String text_with_header2="(//h2[contains(text(),'value')])";
	
	public String Div_with_OR_ExactText="(//div[text()='value' or text()='0'])";
	
	public String SourceConfigurationDropdowns="(//li[contains(text(),'svalue')]/following-sibling::li/div/div/div/div[contains(@id,'dropdownlistWrapperngxDropDownList')])";
	//==========================================================================================================================//
	@WhenPageOpens
    public void waitUntilTitleAppears() {		
		UserName_Txt.withTimeoutOf(ProjectVariables.MID_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible();       
    }

	//==========================================================================================================================//
	
	public void Login_to_the_ClientProfile_application(String URL) throws Exception {
		//open(URL, withParameters(""));
		//open();
		getDriver().get(ProjectVariables.CPQAURL);
		getDriver().manage().window().maximize();
		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);
		// Enter Username
		oSeleniumUtils.highlightElement(UserName_Txt);
		UserName_Txt.withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible().clear();
		UserName_Txt.sendKeys(Get_UserName_Password_For_the_given_url(URL+"_UserName"));
		// Enter Password
		oSeleniumUtils.highlightElement(Password_Txt);
		Password_Txt.waitUntilVisible().clear();
		Password_Txt.waitUntilVisible().sendKeys(Get_UserName_Password_For_the_given_url(URL+"_Password"));
		oSeleniumUtils.Click_given_WebElement(Login_Btn);
	
	}

	//==========================================================================================================================//
	
	public String Get_UserName_Password_For_the_given_url(String URL) throws Exception {
	
		HashMap<String, String> oHashMap=new HashMap<String,String>();
		
		oHashMap.put("QA_URL_UserName", ProjectVariables.CPUSER_NAME);
		oHashMap.put("UAT_URL_UserName", ProjectVariables.CPUSER_NAME);
		oHashMap.put("QA_URL_Password", GenericUtils.decode(ProjectVariables.CPPASSWORD));
		oHashMap.put("UAT_URL_Password", GenericUtils.decode(ProjectVariables.CPPASSWORD));
		return oHashMap.get(URL);
	}
	
	public boolean User_navigates_to_Client_profile_application(String navigationlink) {
		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);
		
		if(!Publisher_Link.isVisible()){
			getDriver().switchTo().defaultContent();
		}
		
		List<String> PublisherLinkList=Arrays.asList(navigationlink.split(","));
		
		System.out.println("PublisherLink:"+PublisherLinkList.get(0));
		
		Publisher_Link.withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible().click();

		Publisher_Link.withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible().click();
		
		oSeleniumUtils.Click_given_Locator(StringUtils.replace(NavigationLink, "value", PublisherLinkList.get(0)));
		
		return oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(Span, "value", "Client Profile"));


	}

	//==========================================================================================================================//
	
	public boolean logout_From_ClientProfile_Application() {
		CPHomePage oCPHomePage = this.switchToPage(CPHomePage.class);
		SeleniumUtils oSeleniumUtils=this.switchToPage(SeleniumUtils.class);
		getDriver().switchTo().defaultContent();
		
		oSeleniumUtils.moveToElement(StringUtils.replace(Span, "value", ProjectVariables.CPUSER_NAME));
		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);
		LogOut_Link.withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible()
				.click();
		
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		return oCPHomePage.UserName_Txt.withTimeoutOf(ProjectVariables.MIN_SLEEP, TimeUnit.MILLISECONDS).waitUntilVisible()
				.isPresent();
	}
	
	
	public void DynamicWaitForLoadingIcon()
	{
		
		SeleniumUtils oSeleniumUtils=this.switchToPage(SeleniumUtils.class);
		do
		{
			SeleniumUtils.defaultWait(ProjectVariables.MIN_THREAD_WAIT);
			
		}while(oSeleniumUtils.is_WebElement_Displayed(LoadingIcon1)||oSeleniumUtils.is_WebElement_Displayed(LoadingIcon));
		
	}

	public boolean UserClickOntheGivenText(String text) {
		switch (text) {
		case "New Table":

			DynamicWaitForLoadingIcon();
			
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(Button_With_Text, "value","New"));
			
			DynamicWaitForLoadingIcon();
			return true;
		case "Mapped one":

			DynamicWaitForLoadingIcon();
			
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(Div_With_Title, "value",
					Serenity.sessionVariableCalled("NewTableID")));
			return true;
		case "Save":
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(Button_with_ngclick, "svalue", text));
			return true;
		case "Edit":

			DynamicWaitForLoadingIcon();
			
			//clickGivenElement(getElement(How.XPATH.toString(),Icon_Edit));
			if (oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(NamedSetTable_ID, "value",
					Serenity.sessionVariableCalled("NewTableID"))))
			{    
				SeleniumUtils.scrollingToGivenElement(getDriver(), StringUtils.replace(NamedSetTable_ID,
						"value", Serenity.sessionVariableCalled("NewTableID")));
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(EditIcon_With_TableID, "value",
						Serenity.sessionVariableCalled("NewTableID")));
			} 
			else 
			{
				Assert.assertTrue(Serenity.sessionVariableCalled("NewTableID")+" Edit icon is not displayed ",false);
			}
	
			return true;
		case "Edit-State Medicaid Source":
			System.out.println("state:" + ProjectVariables.State);
			System.out.println("ClaimType:" + ProjectVariables.ClaimType);
			String locator = StringUtils.replace(StateMedicaid_EditIcon, "state", ProjectVariables.State);
			String StateMedicaid_EditIcon = StringUtils.replace(locator, "ctype", ProjectVariables.ClaimType);
			int size = oSeleniumUtils
					.get_size_of_the_given_Locator(StringUtils.replace(Icon_With_Div, "svalue", "Edit"));
			while (!oSeleniumUtils.is_WebElement_Displayed(StateMedicaid_EditIcon)) {
				SeleniumUtils.scrollingToGivenElement(getDriver(),
						StringUtils.replace(Icon_With_Div, "svalue", "Edit") + "[" + size + "]");
			}
			Serenity.setSessionVariable("Statemedicaid_ID")
					.to(oSeleniumUtils.get_TextFrom_Locator(StateMedicaid_EditIcon + "/../following-sibling::div[2]"));
			oSeleniumUtils.Click_given_Locator(StateMedicaid_EditIcon);

			return true;
		case "Confirm":
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(Button_With_ExactText, "value", text));
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(Button_With_ExactText, "value", "Yes"));
			return true;

		case "Re-derive":
			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(Button_With_Text, "value", text));
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(Button_With_ExactText, "value", "Yes"));
			return true;

		case "Expand":
			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			if(oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(Locator_with_I_tag, "svalue", "expandable.toggleRow")))
			{
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(Locator_with_I_tag, "svalue", "expandable.toggleRow"));	
			}
			else
			{
				Assert.assertTrue(text+" button is not displayed", false);
			}
			return true;
		case "Add-Payer Short":
		case "Add-Table Type":
			SeleniumUtils.defaultWait(ProjectVariables.MIN_THREAD_WAIT);
			oSeleniumUtils.Click_given_Locator(
					StringUtils.replace(Add_button, "value", StringUtils.substringAfter(text, "-")));
			return true;
		case "Apply Filters":
			SeleniumUtils.defaultWait(ProjectVariables.MIN_THREAD_WAIT);
			oSeleniumUtils
					.Click_given_Locator(Btn_Applyfilters);
			return true;
		case "Save and Update":
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(Anchor_Tag, "value", " Save and Update"));
			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(Button_With_ExactText, "value", "Yes"));
			return true;
		case "DeriveBy-Highest":
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(EandM_Basis_Bilateral_type, "value",
					StringUtils.substringAfter(text, "-")));
			return true;
		default:
			Assert.assertTrue("Given "+text+" was not found in the Switch case", false);

		}
		return false;
	}

	public void ScrollingToGivenElementUntilTheDestinationElementisDisplayed(String Scrollinglocator, String DestinationLocator) {
		do 
		{
			SeleniumUtils.scrollingToGivenElement(getDriver(),Scrollinglocator);
		} while (!oSeleniumUtils
				.is_WebElement_Displayed(DestinationLocator));
			
		
	}
	
	public void UnmapTheExistingTableForMappingNewTable(String NewTable_ID, String unMappedtext_DMU) {

		int size = oSeleniumUtils.get_size_of_the_given_Locator(
				StringUtils.replace(NamedSetTable_Size, "value", NewTable_ID));
		

		do 
		{
			
			size = size - 1;

			System.out.println(
					StringUtils.replace(NamedSetTable_Size, "value", NewTable_ID) + "[" + size + "]");

			oSeleniumUtils.Click_given_Locator(
					StringUtils.replace(NamedSetTable_Size, "value", NewTable_ID) + "[" + size + "]");

			if (unMappedtext_DMU.equalsIgnoreCase("0"))
			{
				ProjectVariables.TableID_DivCount = "4";
			} else 
			{
				ProjectVariables.TableID_DivCount = "5";
			}
			System.out.println(StringUtils.replace(NamedSetTable_Size, "value", NewTable_ID) + "[" + size
					+ "]" + "/div/div[" + ProjectVariables.TableID_DivCount + "]/div");

			String ID = oSeleniumUtils
					.get_TextFrom_Locator(StringUtils.replace(NamedSetTable_Size, "value", NewTable_ID)
							+ "[" + size + "]" + "/div/div[" + ProjectVariables.TableID_DivCount + "]/div");
			System.out.println(StringUtils.replace(Div_With_Title, "value", ID));
			
			ClickGivenElementIfTheElementisDisplayed(StringUtils.replace(Div_With_Title, "value", ID));
			
			

		} while (!oSeleniumUtils
				.is_WebElement_Enabled(StringUtils.replace(Button_with_ngclick, "svalue", "Save")));

		oSeleniumUtils.Click_given_Locator(StringUtils.replace(Button_with_ngclick, "svalue", "Save"));
		
//		ClickGivenElementIfTheElementisDisplayed(StringUtils.replace(Button_With_ExactText, "value", "Yes"));
		
		ClickGivenElementIfTheElementisDisplayed(StringUtils.replace(Button_With_ExactText, "value", "Confirm"));
		
		if(oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(Button_With_ExactText, "value", "Yes"))){
			ClickGivenElementIfTheElementisDisplayed(StringUtils.replace(Button_With_ExactText, "value", "Yes"));
		}
		
		
		
		
	}
	
public void ClickGivenElementIfTheElementisDisplayed(String Elementlocator) {
		
		if (oSeleniumUtils.is_WebElement_Displayed(Elementlocator)) 
		{

			oSeleniumUtils.Click_given_Locator(Elementlocator);
		}
		else
		{
			Assert.assertTrue(Elementlocator+" is not displayed", false);
		}
	}


public void MapTheNewTableWithTheUnmappedOne(String NewTable_ID, String unMappedtext_DMU, String icon) {
	
	int PolicySet_UnmappedIcon_size = oSeleniumUtils.get_size_of_the_given_Locator(StringUtils.replace(Div_with_OR_ExactText, "value", unMappedtext_DMU));

	System.out.println("PolicySet_UnmappedIcon_size:" + PolicySet_UnmappedIcon_size);
	
	System.out.println(StringUtils.replace(Div_with_OR_ExactText, "value", unMappedtext_DMU) + "["
			+ PolicySet_UnmappedIcon_size + "]");
	
	SeleniumUtils.defaultWait(ProjectVariables.MIN_THREAD_WAIT);

	oSeleniumUtils.Click_given_Locator(StringUtils.replace(label, "svalue", "Include Unmapped"));

	int EditIconsize = oSeleniumUtils.get_size_of_the_given_Locator(StringUtils.replace(icon, "svalue", "Edit"));
	
	if(unMappedtext_DMU.equalsIgnoreCase(ProjectVariables.UnMappedtext))
	{
		ScrollingToGivenElementUntilTheDestinationElementisDisplayed(StringUtils.replace(icon, "svalue", "Edit") + "[" + EditIconsize + "]",StringUtils.replace(NamedSetTable_ID, "value", NewTable_ID));
			
	}
	else
	{
		int NamedSetIconsize_DMU = oSeleniumUtils.get_size_of_the_given_Locator(NamedSet_Icon);
		
		ScrollingToGivenElementUntilTheDestinationElementisDisplayed(NamedSet_Icon + "[" + NamedSetIconsize_DMU + "]",StringUtils.replace(NamedSetTable_ID, "value", NewTable_ID));
		
	}

	oSeleniumUtils.Click_given_Locator(StringUtils.replace(NamedSetTable_ID, "value", NewTable_ID));

	do {
		if (PolicySet_UnmappedIcon_size > 0) 
		{
			SeleniumUtils.defaultWait(ProjectVariables.MIN_THREAD_WAIT);
			oSeleniumUtils.Click_given_Locator(
					StringUtils.replace(Div_with_OR_ExactText, "value", unMappedtext_DMU) + "["
							+ PolicySet_UnmappedIcon_size + "]");
		} else 
		{
			Assert.assertTrue("PolicySet_UnmappedIcon is not cliked successfully", false);
		}
	} while (!oSeleniumUtils
			.is_WebElement_Enabled(StringUtils.replace(Button_with_ngclick, "svalue", "Save")));
	
	ClickGivenElementIfTheElementisDisplayed(StringUtils.replace(Button_with_ngclick, "svalue", "Save"));		
	
	ClickGivenElementIfTheElementisDisplayed(StringUtils.replace(Button_With_ExactText, "value", "Confirm"));
	if(oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(Button_With_ExactText, "value", "Yes"))){
		ClickGivenElementIfTheElementisDisplayed(StringUtils.replace(Button_With_ExactText, "value", "Yes"));
	}

}

	public String getDynamicXpath(String sValue, String sTestValue) {
		
			String sXpath="((//div[(div[1]='"+sValue+"') and (div[2]='"+sTestValue+"')])//div[text()='0'])[1]";
		
		return sXpath;
		
	}

	public boolean NAVIGATE_TAB(String sMainTab,String sSubTab){
		GenericUtils oGenericUtils=this.switchToPage(GenericUtils.class);
		boolean blnResult=false;
		int iTimer=0;
		try{
			do{
				List<WebElement> sList=getDriver().findElements(By.xpath(sTab_Publisher));
				if(sList.size()>0){
					Actions oAction=new Actions(getDriver());
					oAction.moveToElement(getDriver().findElement(By.xpath(sTab_Publisher))).build().perform();
					Thread.sleep(1000);
					//Click on Expected tab //a[normalize-space(.) = 'Payer Shorts']
					String sMaintabXpath="//a[normalize-space(.) ='"+sMainTab+"']";
					blnResult=oGenericUtils.CLICK_LINK_XPATH(sMaintabXpath);
					//Calling Loading Popup
					  LOADING_POPUP_FRAME(sPopup_Loading);
				}
			}while(blnResult!=true && iTimer!=60);					
		}catch(Exception e){
			oGenericUtils.Validate("Object not clicked Successfully , Failed due to :="+e.getMessage(),"FAILED");
		}
		getDriver().switchTo().defaultContent();
		return blnResult;
	}
	
	public boolean SELECT_PAYERSHORT_NAVIGATE_TAB(String sPayershort,String sTab){
		
		GenericUtils oGenericUtils=this.switchToPage(GenericUtils.class);
		
		boolean blnResult=false;
		try{
			//Switch to Frame
			getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[@class='frame ng-scope']")));
			//Enter Payershort in QuickSearch feild
			oGenericUtils.SET_VALUE(By.xpath(sEdt_QuickSearch), sPayershort);
			//Click on 'QuickSearch' button
			Thread.sleep(1000);
			
			Thread.sleep(1000);
			oGenericUtils.CLICK_LINK_XPATH(sBtn_QuickSearch);
			//Click on 'View/Edit' button
			oGenericUtils.CLICK_BUTTON(By.xpath(sBtn_View_Edit));
			
			/*//Navigate tab
			String sTabXpath="//span[.='"+sTab+"']/span";
			blnResult=oGenericUtils.CLICK_BUTTON(By.xpath(sTabXpath));*/
			
		}catch(Exception e){
			oGenericUtils.Validate("Object not clicked Successfully , Failed due to :="+e.getMessage(),"FAILED");
		}
		return blnResult;
	}
	
	public boolean LOADING_POPUP_FRAME(String sPOPUPVal){
		GenericUtils oGenericUtils=this.switchToPage(GenericUtils.class);
		boolean sFlag=false;
		int iTimer=0;
		try{
			//Condition for Loading screen
			do{
				//Switch to Frame
				List<WebElement> sFrameList = getDriver().findElements(By.xpath("//iframe[@class='frame ng-scope']"));
				
				if (sFrameList.size()>0){
					getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[@class='frame ng-scope']")));					
				}
				List<WebElement> sList=getDriver().findElements(By.xpath(sPOPUPVal));
				
				if(sList.size()>0){
					sFlag=true;
				}
				iTimer=iTimer+1;
				//System.out.println("iTimer:="+iTimer);
			}while(sFlag!=true && iTimer!=10);	
		}catch(Exception e){
			oGenericUtils.Validate("Object not clicked Successfully , Failed due to :="+e.getMessage(),"FAILED");
		}
		//Switch to default content
		//getDriver().switchTo().defaultContent();
		return sFlag;
	}
	
	  public boolean LOGOUT_CP_APPLICATION(){
          boolean blnResult=false;  
          try{
                 Actions oAction=new Actions(getDriver());
                 oAction.moveToElement(getDriver().findElement(By.xpath(StringUtils.replace(Span, "value", ProjectVariables.CPUSER_NAME)))).build().perform();
                 Thread.sleep(1000);
                 //Click 'LogOut'
                 oSeleniumUtils.Click_given_Locator("//a[contains(@ng-click,'logout(true)')]");
          }catch(Exception e){
       	  
                 GenericUtils.Verify("Object not clicked Successfully , Failed due to :="+e.getMessage(),true);
          }
          return blnResult;
   }
	
}

