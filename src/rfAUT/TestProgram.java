package rfAUT;




import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



//Defining General Methods Class
class GeneralMethods
{
	WebDriver Brow;
	WebDriverWait wait;
	
	//Configure Browser
	public void ConfigDriver(String Browser)
	{
		if(Browser.equals("FF"))
		{
			//select Firefox browser to launch
			Brow=new FirefoxDriver();
		}
		
		else
		{
			System.out.println("Invalid Driver");
		}
		
	//wait 30 sec
	wait = new WebDriverWait(Brow, 40);
	
	//Maximize Browser
	Brow.manage().window().maximize();
		
	}


	
			
	//Open Application
	public void openAppl()
	{
		//Launch Application
		Brow.get("file:///C:/Users/schandrasekhar/Downloads/QA%20Test%20%281%29.html");					
	}
	
		
	//fill Test Form
	public void fillTestForm()
	{
		//fill Form fields		
		
		//Verifying First Name field
		verifyFirstName();
		//Enter First Name
		Brow.findElement(By.xpath(".//*[@id='fname']")).sendKeys("Sarath");
		
		//Verify Last Name field
		verifyLastName();
		//Enter Last Name
		Brow.findElement(By.xpath(".//*[@id='lname']")).sendKeys("Chandrasekhar");
		
		//verify Phone field
		verifyPhone();
		//Enter Phone number
		Brow.findElement(By.xpath(".//*[@id='phone']")).sendKeys("1234567890");
		
		//verify Submit 
		verifySubmitBtn();
		//click Submit button
		Brow.findElement(By.xpath(".//*[@id='submit']")).click();	
		}
	
	






//Define method for First Name field
public void verifyFirstName()
	{
		//Verify First Name text exists
		WebElement verifyFname = Brow.findElement(By.xpath("html/body/form/label[1]"));
		String verifyFnameTxt = verifyFname.getText();
		System.out.println(verifyFnameTxt+" text exists");
		Assert.assertEquals(verifyFnameTxt,"First Name:");	
		 
		//Verify First Name text box
		WebElement fnTextBox =Brow.findElement(By.xpath(".//*[@id='fname']"));
		Dimension fnTextBoxSize = fnTextBox.getSize();
		System.out.println("First Name text box dimensions are "+fnTextBoxSize);
		
		if(fnTextBoxSize.equals(null))
		{
			System.out.println("First Name text box does not exist");
		}
		else
		{
			System.out.println("First Name text box exists");
		}
	}
	

//Define method for Last Name field	
	public void verifyLastName()
	{
		//Verify Last Name text exists
		WebElement verifyLname = Brow.findElement(By.xpath("html/body/form/label[2]"));
		String verifyLnameTxt = verifyLname.getText();
		System.out.println(verifyLnameTxt+" text exists");
		Assert.assertEquals(verifyLnameTxt,"Last Name:");	
		 
		//Verify Last Name text box
		WebElement lnTextBox =Brow.findElement(By.xpath(".//*[@id='lname']"));
		Dimension lnTextBoxSize = lnTextBox.getSize();
		System.out.println("Last Name text box dimensions are "+lnTextBoxSize);
		
		if(lnTextBoxSize.equals(null))
		{
			System.out.println("Last Name text box does not exist");
		}
		else
		{
			System.out.println("Last Name text box exists");
		}
	}
	
	
//Define method for Phone field
	 public void verifyPhone()
	{
		//Verify Phone text exists
		WebElement verifyPhone = Brow.findElement(By.xpath("html/body/form/label[3]"));
		String verifyPhoneTxt = verifyPhone.getText();
		System.out.println(verifyPhoneTxt+" text exists");
		Assert.assertEquals(verifyPhoneTxt,"Phone:");	
		 
		//Verify First Name text box
		WebElement phoneTextBox =Brow.findElement(By.xpath(".//*[@id='phone']"));
		Dimension phonetextBoxSize = phoneTextBox.getSize();
		System.out.println("Phone text box dimensions are "+phonetextBoxSize);
		
		if(phonetextBoxSize.equals(null))
		{
			System.out.println("Phone text box does not exist");
		}
		else
		{
			System.out.println("Phone text box exists");
		}
	}
	
	
 









//Define method for Submit Button
	public void verifySubmitBtn()
	{
		//Verify Submit button text exists
		WebElement verifySubmitButton = Brow.findElement(By.xpath(".//*[@id='submit']"));
		String verifySubmitButtonTxt = verifySubmitButton.getAttribute("value");
		System.out.println(verifySubmitButtonTxt+"  text exists");
		Assert.assertEquals(verifySubmitButtonTxt,"Submit");	
 		
		 
		//Verify Submit button exists
		WebElement submitButton =Brow.findElement(By.xpath(".//*[@id='submit']"));
		Dimension submitButtonSize = submitButton.getSize();
		System.out.println("Submit button dimensions are "+submitButtonSize);
		
		if(submitButtonSize.equals(null))
		{
			System.out.println("Submit button does not exist");
		}
		else
		{
			System.out.println("Submit button exists");
		}
	}
	 
 	 	 
//Define method to verify page heading
	public void verifyHeading()
	{
	WebElement heading = Brow.findElement(By.xpath("html/body/h1"));
	String headingTxt = heading.getText();
	System.out.println(headingTxt);
	Assert.assertEquals(headingTxt,"Test Form");	
	}		
	
	





//Define method to verify result page text
public void verifyResultPage()
	{
	WebElement submitConf = Brow.findElement(By.xpath("html/body/p"));
	String submitConfTxt = submitConf.getText();
	System.out.println(submitConfTxt+" exists");
	Assert.assertEquals(submitConfTxt,"Form submitted!");	
	}		
}

//Main class
public class TestProgram
{

	public static void main(String[] args)
	{
		// Instantiate GeneralMethods object
		GeneralMethods Br = new GeneralMethods();
		
		
		Br.ConfigDriver("FF");
		Br.openAppl();
		Br.verifyHeading();
		Br.fillTestForm();		
		Br.verifyResultPage();		
	}

}
























