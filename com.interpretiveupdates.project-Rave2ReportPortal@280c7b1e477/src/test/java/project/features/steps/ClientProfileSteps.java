package project.features.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import project.feature.steps.definitions.ClientProfileStepDef;

public class ClientProfileSteps {
	
	@Steps
	ClientProfileStepDef oClientProfileStepdef;
	
	@Given("^User login to Client Profile Application through \"([^\"]*)\"$")
	
	public void user_login_to_Client_Profile_Application_through(String URL) throws Throwable {
	
		oClientProfileStepdef.Login_to_ClientProfile_application(URL);
	 
	}	
	
	//==========================================================================================================================//
	
	@Then("^User should see the Client profile Homepage through \"([^\"]*)\"$")
	public void user_should_see_the_Client_profile_Homepage_through(String arg1) throws Throwable {
		oClientProfileStepdef.User_should_see_the_Client_profile_Homepage(arg1);
	   
	}

	//==========================================================================================================================//
	
	@Then("^user should be logged out from Client Profile application$")
	public void user_should_be_logged_out_from_Client_Profile_application() throws Throwable {
		oClientProfileStepdef.user_should_be_logged_out_from_Client_Profile_application();
	    
	}
	
	
	@When("^User Selects \"([^\"]*)\" as \"([^\"]*)\"$")
	public void user_Selects_as(String arg1, String arg2) throws Throwable {
		oClientProfileStepdef.user_selects(arg1,arg2);
	}
	
	@When("^user click on \"([^\"]*)\"$")
	public void user_click_on(String arg1) throws Throwable {
		oClientProfileStepdef.user_click_on(arg1);
	 
	}
	
	@Then("^user Should see the message as \"([^\"]*)\"$")
	public void user_Should_see_the_message_as(String arg1) throws Throwable {
		oClientProfileStepdef.user_Should_see_the_message_as(arg1);
	 
	}
	
	@Then("^validate \"([^\"]*)\" through New Table$")
	public void validate_through_New_Table(String arg1) throws Throwable {
		oClientProfileStepdef.validate_through_New_Table(arg1);
	 
	}
	@When("^user Navigate \"([^\"]*)\" tab$")
	public void user_Navigate_tab(String arg1) throws Throwable {
		oClientProfileStepdef.user_Navigate_tab(arg1);
	}
	
	@Then("^select \"([^\"]*)\" and navigate to \"([^\"]*)\" tab$")
	public void select_and_navigate_to_tab(String arg1, String arg2) throws Throwable {
		
		oClientProfileStepdef.select_and_navigate_to_tab(arg1, arg2);
		
	}	
			
	@Then("^\"([^\"]*)\" onshore operations$")
	public void onshore_operations(String arg1) throws Throwable {

		oClientProfileStepdef.onshore_Operations(arg1);
	}
	
	/*@Given("^user login into jira$")
	public void user_login_into_jira() throws Throwable {
		oClientProfileStepdef.user_login_into_jira();
	}
*/

}
