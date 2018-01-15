package com.iitworkforce.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateNewAppointmentPage {
	WebDriver driver;
	By newAppLink = By.xpath("//a/input");
	By searchforpatient = By.xpath(".//*[@id='search']");
	By searchlink = By.xpath("//input[@value='search']");
	By patientclick = By.xpath("//tr/td[1]/a");
	By provider = By.xpath("//table//tr/td[2]//button[@id='opener']");
	By dateclick = By.id("datepicker");
	By currMonth = By.cssSelector(".ui-datepicker-title");
	By nextmonth = By.xpath("//span[contains(text(),'Next')]");
	By appTime = By.id("time");
	By dayList = By.xpath(".//*[@id='ui-datepicker-div']//td");
	By continuepage = By.id("ChangeHeatName");
	By textarea = By.xpath("//textarea");
	By submit = By.xpath("//input[@type='submit']");

	String apptDate;
	String appointmentString = "01/30/2018"; 
	Date appointmentDate = null;
	
	public CreateNewAppointmentPage(WebDriver driver) {
		this.driver = driver;
	}
	public void createNewAppLink() {
		driver.findElement(newAppLink).click();
	}
	public Date getAppintmentDate() {
		return appointmentDate;
	}
	public void bookAnAppointment()
	{
		createVisit();
		setAppointMonthYear(); 		
		selectDayandTime(); 	    
		enterMess();
	}
	public void createVisit() {
		driver.findElement(provider).click();
		driver.switchTo().frame("myframe");
		driver.findElement(dateclick).click();
	}
	public  void setAppointMonthYear() {
		try {
			System.out.println("appointmentString is" + appointmentString);
			appointmentDate  = new SimpleDateFormat("MM/dd/yyyy").parse(appointmentString);
			System.out.println("Datestr is" + appointmentDate);			
			String formatDate = new SimpleDateFormat("MMMM yyyy").format(appointmentDate);
			System.out.println("formatDate is" + formatDate);
			Date setDate = new SimpleDateFormat("MMMM yyyy").parse(formatDate);
			System.out.println("setdate is" + setDate);
			String currentDateString =   driver.findElement(currMonth).getText();
			System.out.println("current date string is" + currentDateString);
			Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currentDateString);
			System.out.println("currDate is" + setDate);
			if (currDate.equals(setDate)) {
				System.out.println("Month is selected"+ setDate +currDate);
			}
			else {
				driver.findElement(nextmonth).click(); 
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void selectDayandTime() {
		List<WebElement> dayList1 = driver.findElements(dayList);
		int count = dayList1.size();
		System.out.println("count: " + count);
		for(int i=1;i<count;i++) {
			System.out.println(" " + dayList1.get(i).getText());
			if(dayList1.get(i).getText().equals("30")){
				System.out.println("day selected"+ "30");
				dayList1.get(i).click();	
				
				WebElement e = driver.findElement(appTime);
				Select select = new Select(e);
				List <WebElement> timeList = select.getOptions();
				int count1 = timeList.size();		
				for(i=0; i<count1; i++) {
					System.out.println("Time List" + timeList.get(i).getText());
					if(timeList.get(i).getText().equals("11Am")) {					
						timeList.get(i).click();
					}
			    }
		    }
		 }
	 }
	public void enterMess() {
		driver.findElement(continuepage).click();
		driver.findElement(textarea).clear();
		driver.findElement(textarea).sendKeys("These are the symptoms...cold");
		driver.findElement(submit).click();
	}
}

