package com.iitworkforce.tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.iitworkforce.pages.CreateNewAppointmentPage;
import com.iitworkforce.pages.PatientHomePage;
import com.namtg.baseclass.PatientBaseClass;
import com.namtg.util.PatientHelper;

public class VerifyScheduleAppointment extends PatientBaseClass {
//made some changes in the test
    @Parameters({"patienturl","patientUname","patientPswd","subject","reason"})
	@Test(description = "Schedule an Appointment by providing symptoms. The data should be shown as an entry in the patient portal.",enabled=false)
	public  void validatePatientMessage(String patienturl, String patientUname, String patientPswd, String subject,String reason) throws IOException {
		
		//login		
		PatientHelper.loginMyPatient(patienturl, driver, patientUname, patientPswd);
		//homepage--schedule appointments
		PatientHomePage patientHome = new PatientHomePage(driver);
		patientHome.scheduleAppointmentLink();
		//create new appointment
		CreateNewAppointmentPage newApp = new CreateNewAppointmentPage(driver);
		newApp.createNewAppLink();
		newApp.bookAnAppointment();
		Date appointmentDate = newApp.getAppintmentDate();
		Date scheduledDate = patientHome.scheduledDate();
		//validate in patient portal
		assertTrue(appointmentDate.equals(scheduledDate)) ;
		if(appointmentDate.equals(scheduledDate)){
			System.out.println("TC Pass");
		}
		else
		{
			System.out.println("TC fails");
		}
	}}
		/*	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeDriver driver1 = new ChromeDriver();
		driver1.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");

	}*/


