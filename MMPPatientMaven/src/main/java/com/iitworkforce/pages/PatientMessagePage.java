package com.iitworkforce.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientMessagePage {
	WebDriver driver;
	public PatientMessagePage(WebDriver driver) {
		this.driver = driver;
	}
	By ContactReason = By.xpath(".//*[@id='subject']");
	By Subject = By.xpath(".//*[@id='message']");
	By SendButton = By.xpath("//table//tr[4]/td/input");
	
	public void sendMessages(String subject,String reason) {
		driver.findElement(Subject).sendKeys(subject);;
		driver.findElement(ContactReason).sendKeys(reason);
		driver.findElement(SendButton).click();	
}
	public String alertMessage() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("text of alert:" + text);
		alert.accept();
		return text;
}

}
