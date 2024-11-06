import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import net.bytebuddy.implementation.bytecode.constant.FieldConstant;

public class uploadfile {
	WebDriver driver = new ChromeDriver();


	    @Test
	    public void mytest() throws InterruptedException {
	        driver.manage().window().maximize();
	        Thread.sleep(1000);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	        driver.get("https://practice-automation.com/file-upload/");

	        
	        File myFile = new File("./ScreenShot/Tue Nov 05 21-41-45 EET 2024.png");
	        driver.findElement(By.xpath("//*[@id='file-upload']")).sendKeys(myFile.getAbsolutePath());

	        Thread.sleep(2000);
	        // Optional: Submit or perform additional actions if needed
	        driver.findElement(By.id("upload-btn")).click();  // Example for a submit button


}}
