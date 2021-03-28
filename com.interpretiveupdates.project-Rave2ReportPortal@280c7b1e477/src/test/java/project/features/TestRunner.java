package project.features;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
//import project.utilities.ExcelUtils;
//import project.utilities.DBUtils;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions( plugin = {"pretty", "html:target/cucumber-html-report"},features="Features",tags = {"@Sample4567"},monochrome = true)


public class TestRunner {
	
	@BeforeClass
    public static void killExcel() throws Exception{   
		 
          /* Runtime.getRuntime().exec("taskkill /F /IM EXCEL.EXE");
           String sDirectory = System.getProperty("user.dir");
           String sDriverPath = sDirectory+"\\src\\test\\resources\\Data";
           String sExcelPath = sDirectory+"\\src\\test\\resources\\Data\\Mail.xlsm";
           ExcelUtils.SetPath(7, 2, sDriverPath, sExcelPath); */  
    }

	
	@AfterClass
    public static void fn_SendMail() throws Exception{
		
       /*String sDirectory = System.getProperty("user.dir");
       
       String sDriverPath = sDirectory+"\\src\\test\\resources\\Data";
       
       String sExcelPath = sDirectory+"\\src\\test\\resources\\Data\\Mail.xlsm";

       Runtime.getRuntime().exec(new String[] { "wscript.exe", sDriverPath+"\\Trigger.vbs",sExcelPath}); */ 
       
//       DBUtils.DBLockTest();
       
    }
}
