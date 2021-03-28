package project.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class GenericUtils extends PageObject {
	
	SeleniumUtils oSeleniumUtils;
	
	public static String getDate_given_Format(){
		//String element = DA_PROJ_OR.LAST_SEARCH_TIME;
		String sExpectedTime = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
		String[] words=sExpectedTime.split("\\s");
    	System.out.println("System Date-->:- "+words[0]);
    			
	    	String sExpectedDate = words[0];
	    	
    		    	return sExpectedDate;
	}
	
	public static int generate_Random_Number_for_Given_Range(int range){
		Random rand = new Random(); 
		int value = rand.nextInt(range); 
		return value;
	}
	
	/*The idea is that 1 + nextInt(2) shall always give 1 or 2. 
	You then multiply it by 10000 to satisfy your requirement and then add a number between [0..9999].*/
	
	public static int GetRandomNumber() {
	    Random r = new Random( System.currentTimeMillis() );
	    return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}
	
	public static String decode(String value) throws Exception {
		byte[] decodedValue = null;
		try{
	     decodedValue = Base64.getDecoder().decode(value);	     
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return new String(decodedValue, StandardCharsets.UTF_8);
	  }
	
  /*public static void Verify(String sDescription, boolean blnStatus){
		
		if (blnStatus){			
			Assert.assertTrue("Validation Successful for "+sDescription,blnStatus);
		}else{
			Assert.assertTrue("Validation not Successful for "+sDescription,blnStatus);
		}		
		
	}
  */
  public static void Verify(String StepDetails, String sStatus) {

		if (sStatus.equalsIgnoreCase("PASSED")) {
			System.out.println(StepDetails);
			Serenity.recordReportData().withTitle(StepDetails).andContents(sStatus);
			Assert.assertTrue(StepDetails, true);
		} else {
			Serenity.recordReportData().withTitle(StepDetails).andContents(sStatus);
			Serenity.takeScreenshot();
			System.out.println(StepDetails);
			Assert.assertTrue(StepDetails, false);

		}
		
	}

	// ################################################################################################################################################################

	public static void Verify(String StepDetails, boolean sStatus) {

		if (sStatus) {
			System.out.println(StepDetails);
			Serenity.recordReportData().withTitle(StepDetails).andContents("Passed");
			Assert.assertTrue(StepDetails, true);
		} else {
			System.out.println(StepDetails);
			Serenity.recordReportData().withTitle(StepDetails).andContents("Failed");
			Serenity.takeScreenshot();
			Assert.assertTrue(StepDetails, false);
			

		}
	}

  public boolean gfn_Verify_Object_Exist(String sTagName, String sText) throws InterruptedException{

      boolean blnFlag = false;
      int iTimer = 0;
      String strXpath = "//"+sTagName+"[text()='"+sText+"']";

      try{  
             do {

                   List<WebElement> sList = getDriver().findElements(By.xpath(strXpath));

                   if (sList.size() > 0){
                          for (int i=0;i < sList.size();i++){
                                 if (sList.get(i).isDisplayed()){
                                	 oSeleniumUtils.highlightElement(sList.get(i));                              
                                        blnFlag = true;  
                                        break;                                   
                                 }
                          }
                   }

                   if (!blnFlag) {Thread.sleep(ProjectVariables.MID_TIME_OUT);}
                   iTimer = iTimer+1;  

             } while ((blnFlag != true) && (iTimer != 30));

             if ( blnFlag != true) {
                   System.out.println(sText+" object not found");
                   Verify(sText+" object not found", false);  
                   blnFlag = false ;
             }

      }   catch(Exception e){
             System.err.println(e); 
              
      } 

      return blnFlag;

}
  
  public boolean gfn_Click_On_Object(String sTagName, String sText) throws InterruptedException{

      boolean blnFlag = false;
      int iTimer = 0;
      String strXpath = "//"+sTagName+"[text()= '"+sText+"']";

      try{  
             do {

                   List<WebElement> sList = getDriver().findElements(By.xpath(strXpath));
                   
                   if (sList.size() > 0) {
                          for (int i=0;i < sList.size();i++){
                                 if (sList.get(i).isDisplayed() && sList.get(i).isEnabled()){
                                        oSeleniumUtils.highlightElement(sList.get(i));  
                                        sList.get(i).click();             
                                        blnFlag = true;  
                                        break;
                                 }
                          }
                   }
                   
                   if (!blnFlag) { Thread.sleep(ProjectVariables.MID_TIME_OUT);}
                   iTimer = iTimer+1;  
             } while ((blnFlag != true) && (iTimer != 18));

             if ( blnFlag != true) {
                   System.out.println(sText+" object not found");
                   blnFlag = false ;
//                   Verify(sText+" object not found", false);  
             }

      }    catch(Exception e){                      
             System.err.println(e); 
             
      } 

      return blnFlag;

}
  
  public boolean gfn_Click_String_object_Xpath(String sXpath){

      boolean blnFlag = false;
      int iTimer = 0; 
      try{  
             do {

                   List<WebElement> sList = getDriver().findElements(By.xpath(sXpath));
                    
                   if (sList.size() > 0){
                          for (int i=0;i < sList.size();i++){
                                 if (sList.get(i).isDisplayed()){
                                       oSeleniumUtils.highlightElement(sList.get(i));  
                                       sList.get(i).click();
                                        blnFlag = true;
                                        break;
                                 }
                          }
                   }
                   
                   if (!blnFlag) {Thread.sleep(ProjectVariables.MID_TIME_OUT);}
                   iTimer = iTimer+1; 
                   
             } while ((blnFlag != true) && (iTimer != 18));

             if ( blnFlag != true) {             
            	 Verify(sXpath+" object not found", false);  
                   blnFlag = false ;
             }

      }   catch(Exception e){     
             System.err.println(e); 
             
      } 

      return blnFlag;

}
  
  
  public boolean gfn_Verify_String_Object_Exist(String strXpath) throws InterruptedException{

      boolean blnFlag = false;
      int iTimer = 0;
      //String strXpath = "//"+sTagName+"[text()='"+sText+"']";

      try{  
             do {

                   List<WebElement> sList = getDriver().findElements(By.xpath(strXpath));

                   if (sList.size() > 0){
                          for (int i=0;i < sList.size();i++){
                                 if (sList.get(i).isDisplayed()){
                                	 oSeleniumUtils.highlightElement(sList.get(i));                              
                                        blnFlag = true;  
                                        break;                                   
                                 }
                          }
                   }

                   if (!blnFlag) {Thread.sleep(ProjectVariables.MID_SLEEP);}
                   iTimer = iTimer+1;  

             } while ((blnFlag != true) && (iTimer != 30));

             if ( blnFlag != true) {  
                   System.out.println(strXpath+" object not found");
                   blnFlag = false ;
                   Verify(strXpath+" object not found", false); 
             }

      }   catch(Exception e){
             System.err.println(e); 
             
      } 

      return blnFlag;

}
  
  
  public boolean gfn_Verify_Object_Exist(String strXpath,int sTime) throws InterruptedException{

      boolean blnFlag = false;
      int iTimer = 0;

      try{  
             do {

                   List<WebElement> sList = getDriver().findElements(By.xpath(strXpath));

                   if (sList.size() > 0){
                          for (int i=0;i < sList.size();i++){
                                 if (sList.get(i).isDisplayed()){
                                	 oSeleniumUtils.highlightElement(sList.get(i));                              
                                        blnFlag = true;  
                                        break;                                   
                                 }
                          }
                   }

                   if (!blnFlag) {Thread.sleep(ProjectVariables.MID_SLEEP);}
                   iTimer = iTimer+1;  

             } while ((blnFlag != true) && (iTimer != sTime));

             if ( blnFlag != true) {  
                   System.out.println(strXpath+" object not found");
                   blnFlag = false ;
             }

      }   catch(Exception e){
             System.err.println(e); 
      } 

      return blnFlag;

}
  
	
	public static String Get_SystemDate_for_the_given_format(String format) {

		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		String TodaysDate = dateFormat.format(date);
		System.out.println("Today's Date:" + TodaysDate); // 2016/11/16

		return TodaysDate;

	}


	public String convertStringDate(String dateInString) {
		
		String date_Temp=null;
		 SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");
	        
	        try {

	            Date date = formatter.parse(dateInString);
	            date_Temp=(formatter.format(date));
	            System.out.println(formatter.format(date));

	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        return date_Temp.toString();
	}
	
	@SuppressWarnings("unused")
	public static void attachFiles() {

		String sDirectory = System.getProperty("user.dir");
        String sDriverPath = sDirectory+"\\src\\test\\resources\\TestFiles";
        String sExcelPath = sDirectory+"\\src\\test\\resources\\TestFiles\\NAMEDSETS_DATA.txt"; 
		
		File sFile = new File(sExcelPath);
		System.out.println("File Path:- " + sFile.getAbsolutePath());
		StringSelection stringSelection = new StringSelection(sFile.getAbsolutePath());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		Robot robot;
		try {
			robot = new Robot();
			SeleniumUtils.defaultWait(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

	}

public static void attachDocument(String sFilePath){
		
		File sFile = new File(sFilePath);
		System.out.println("File Path:- "+sFile.getAbsolutePath());
		StringSelection stringSelection = new StringSelection(sFile.getAbsolutePath());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		Robot robot;
		try {
			robot = new Robot();
			SeleniumUtils.defaultWait(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

	}


public static void gfn_Writedata_toPropertyfile(String sKey,String sValue,String sFile) throws IOException{
      
    File configFile = new File(sFile);
    FileInputStream in = new FileInputStream(configFile);
    Properties props = new Properties();
    props.load(in);
    in.close();
    FileOutputStream out = new FileOutputStream(configFile);
    props.setProperty(sKey, sValue); 
    props.store(out, null);
    out.close();
}

//Set value in Edit Feild
		public boolean SET_VALUE(By sObjectType,String sInputVal){
			boolean blnResult=false;
			int iTimer=0;
			
			try{
				do{
					List<WebElement> sTxtElement = getDriver().findElements(sObjectType);
					//if size greater than zero
					if(sTxtElement.size()>0){
						
						getDriver().findElement(sObjectType).sendKeys(sInputVal);
						Thread.sleep(1000);
						blnResult=true;
						//oCPStepsDef.Validate("Value enterted sucessfully:="+sInputVal,"PASSED");
						Validate("Value enterted sucessfully:="+sInputVal,"PASSED");
						
					}
				
					iTimer=iTimer+1;
					//Thread.sleep(1000);
					
					
				}while((blnResult!=true) && (iTimer!=60));
				
				
			if 	(blnResult!=true){
				Validate("Object not found:="+sObjectType,"FAILED");
				getDriver().quit();
			}
			}catch(Exception e){
				Validate("Object not clicked Successfully , Failed due to :="+e.getMessage(),"FAILED");
			}
			return blnResult;
		}
		
		
		public void Validate(String StepDetails,String sStatus){
			
			try{
				if(sStatus.equalsIgnoreCase("PASSED")){
					System.out.println(StepDetails);
					Assert.assertTrue(sStatus,true);
				}else{
					System.out.println(StepDetails);
					Assert.assertTrue(sStatus,false);
				}
			}catch(Exception e){
				Validate("Object not clicked Successfully , Failed due to :="+e.getMessage(),"FAILED");
			}
		}
		
		public boolean CLICK_LINK_XPATH(String sLINK_XPATH){
			boolean blnResult=false;
			int iTimer=0;

			try{
				do{
					List<WebElement> sList =getDriver().findElements(By.xpath(sLINK_XPATH));
					if (sList.size()>0){
						
						//System.out.println("Link found");
						getDriver().findElement(By.xpath(sLINK_XPATH)).click();
						Validate("Link clicked sucessfully:="+sLINK_XPATH,"PASSED");
						Thread.sleep(1000);
						blnResult=true;
					}
					iTimer=iTimer+1;
				}while((blnResult!=true) && (iTimer!=60));
				//If flag false
				if(blnResult!=true){
					Validate("Object not found:="+sLINK_XPATH,"FAILED");
					getDriver().quit();
				}
				
			}catch(Exception e){
				Validate("Object not clicked Successfully , Failed due to :="+e.getMessage(),"FAILED");
			}
			
			return blnResult;
		}
		
		public boolean CLICK_BUTTON(By sObjectType){
			boolean blnResult=false;
			int iTimer=0;
			try{
				List<WebElement> sList=getDriver().findElements(sObjectType);
				do{
					if (sList.size()>0){
											
						getDriver().findElement(sObjectType).click();
						blnResult=true;
						Thread.sleep(2000);
						Validate("Button clicked sucessfully:="+sObjectType,"PASSED");
					}
					iTimer=iTimer+1;
				}while((blnResult!=true) && (iTimer!=60));
				//If flag false
				if(blnResult!=true){
					Validate("Object not found:="+sObjectType,"FAILED");
					getDriver().quit();
				}
				
			}catch(Exception e){
				Validate("Object not clicked Successfully , Failed due to :="+e.getMessage(),"FAILED");
			}
			
			return blnResult;
		}
		
		
		public static void clickOk(){
			
						
			Robot robot;
			try {
				robot = new Robot();
				SeleniumUtils.defaultWait(1000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);

			} catch (AWTException e) {
				e.printStackTrace();
			}
			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		}

		
	public static void savingResultsInFolder() {


		String sDirectory = System.getProperty("user.dir");
		
		LocalDateTime now = LocalDateTime.now();
		
		System.out.println("Before Formatting: " + now);
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
		String formatDateTime = now.format(format);

		String sModified = formatDateTime.replaceAll(":", "-");

		String ts = sModified.replaceAll("\\s", "IST");

		String sName = "H:\\DecRelease2018Day1" + "\\" + ts;

		File file = new File(sName);
		
		if (!file.exists()) {
			
			if (file.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}

			String sSourceDir = sDirectory + "\\target";

			File source = new File(sSourceDir);

			File dest = new File(sName);
			try {
				FileUtils.copyDirectory(source, dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
