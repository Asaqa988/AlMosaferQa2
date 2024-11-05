import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {
	
	WebDriver driver = new ChromeDriver();

	String WebSiteURL = "https://global.almosafer.com/en";
	Random rand = new Random();
	
	String ExpectedLanguage = "en";

	String ExpectedCurrency = "SAR";




public void MySetupToEnterTheWebsite() {
	driver.manage().window().maximize();
	driver.get(WebSiteURL);

	WebElement ButtonFortheCurrency = driver
			.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));

	ButtonFortheCurrency.click();
}

public void ScreenShot() throws IOException {
	Date myDate = new Date();

	String fileName = myDate.toString().replace(":", "-");

	System.out.println(fileName);

	TakesScreenshot screenshot = (TakesScreenshot) driver;
	File SrcFile = screenshot.getScreenshotAs(OutputType.FILE);

	File destFile = new File("./ScreenShot/" + fileName + ".png");
	FileUtils.copyFile(SrcFile, destFile);
}

}
