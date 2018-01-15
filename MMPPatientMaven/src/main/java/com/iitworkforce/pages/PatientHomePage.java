package com.iitworkforce.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientHomePage {
	WebDriver driver;
	By PatientMessLink = By.xpath("//span[contains(., 'Messages')]");
	By logoutLink = By.xpath("//span[contains(., 'Logout')]");
	By scheduledAppLink = By.xpath("//span[contains(., 'Schedule Appointment')]");
	//By AppointmentDate = By.xpath("//tr[1]/td[1]");
	//By appDateandDoc = By.xpath("//td[contains(text(),'01/30/2018')]/parent::tr/child::td[4]");
	By apppDate = By.xpath("//td[contains(text(),'Charlie')]/preceding-sibling::td[contains(text(),'01/30/2018')]");
	
	//String setDateStr = "29/01/2018";
		
	public PatientHomePage(WebDriver driver) {
		this.driver = driver; 
	}
	public void scheduleAppointmentLink(){
		driver.findElement(scheduledAppLink).click();		
	}
	public Date scheduledDate() {
		String scheduledDateString = driver.findElement(apppDate).getText();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date scheduledDate = null;
		try {
			scheduledDate = sdf.parse(scheduledDateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return scheduledDate;	
	}
	
/*	public Date patientPortalDate() {
		String appointmentDateString = driver.findElement(AppointmentDate).getText();
		System.out.println("Appointment date string SHOWING in patient portal is " + appointmentDateString);
		Date appDate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			appDate = sdf.parse(appointmentDateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return appDate;
	}*/
    public void patientMessLink() {
    	driver.findElement(PatientMessLink).click();
    }
	public void logout() {
    	driver.findElement(logoutLink).click();
	}
}
