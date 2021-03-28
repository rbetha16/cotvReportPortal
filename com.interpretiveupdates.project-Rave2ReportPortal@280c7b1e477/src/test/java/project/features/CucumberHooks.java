package project.features;

import cucumber.api.Scenario;
import cucumber.api.java.After;
//import gherkin.formatter.model.Result;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;


public class CucumberHooks {
	
	@ManagedPages
	private Pages pages;
	
    	
        @After 
        public void cleanUp(Scenario sScenario) throws Exception{
        	
        	/*String sStatus = sScenario.getStatus();
        	String sTCname = sScenario.getName();
        	String sFeatureName = sScenario.getId().split(";")[0].replace("-", " ");
        	String sReason = null;
            String sReasonCode=null;
            String sErrormessage=null;
        	
        	if(sStatus.equalsIgnoreCase("failed")){
        		
        		Field sfield = sScenario.getClass().getDeclaredField("stepResults");
                sfield.setAccessible(true);
                ArrayList<Result> sResults = null;
                
                sResults = (ArrayList<Result>) sfield.get(sScenario);
               
                for (Result sResult: sResults){
                     
                     String stepstatus = sResult.getStatus();
                     if (stepstatus.equalsIgnoreCase("failed")){
                    	 try{
                    		 sErrormessage = sResult.getErrorMessage().toString();
                             System.out.println(sResult.getErrorMessage().toString());
                             sReason=sErrormessage.split("\\n")[0];
                             if(sReason.contains("SerenityManagedException")){
                             	sReason = sErrormessage.split("\\n")[0].split(":")[1];
                             }
                             System.out.println(sReason); 
                             if(sErrormessage.contains("AssertionError")||sErrormessage.contains("Element not available")||sErrormessage.contains("Element not found")||sErrormessage.contains("Validation not Successful")||sErrormessage.contains("no such element")){
                              	sReasonCode="Application Issue";
                             }else if(sErrormessage.contains("IndexOutOfBoundsException")||sErrormessage.contains("stale element reference")||sErrormessage.contains("NullPointerException")
                             		||sErrormessage.contains("Could not instantiate class")||sErrormessage.contains("ArithmeticException")||sErrormessage.contains("IOException")||sErrormessage.contains("No such file or directory")||sErrormessage.contains("ClassNotFoundException")||sErrormessage.contains("SQLException")){
                             	sReasonCode="Script Issue";
                             }else if(sErrormessage.contains("chrome not reachable")){
                             	sReasonCode="Network Issue";
                             }else{
                             	sReasonCode="Others";
                             }
                             break;
                    	 }catch(Exception e){
                    		 e.printStackTrace();
                    	 }
                           
                     }
                     
                }
        		
        	}
        	    	
        	pages.getDriver().quit();
       	    
        	String sDirectory = System.getProperty("user.dir");
        	String sDriverPath = sDirectory+"\\src\\test\\resources\\Data";
    		String sExcelPath = sDirectory+"\\src\\test\\resources\\Data\\Mail.xlsm";
        	  
    	    int iScenarioCount = ExcelUtils.SetCellDataXlsm(sFeatureName,sTCname,sStatus,sReasonCode,sReason,sExcelPath);

        	if (iScenarioCount % 20 == 0)
        		Runtime.getRuntime().exec(new String[] { "wscript.exe", sDriverPath+"\\Trigger.vbs",sExcelPath}); 
     
        }
      
*/
        	pages.getDriver().quit();
        }
}
