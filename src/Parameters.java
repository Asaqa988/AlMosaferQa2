import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Parameters {
	
	WebDriver driver = new ChromeDriver();

	String WebSiteURL = "https://global.almosafer.com/en";
	Random rand = new Random();
	
	String ExpectedLanguage = "en";

	String ExpectedCurrency = "SAR";

	String ExpectedNumber = "+966554400000";

	boolean ExpectedResultForQitafLogo = true;

	String ExpectedValue = "false";
	int today = LocalDate.now().getDayOfMonth();
	int Tomorrow = LocalDate.now().plusDays(1).getDayOfMonth();
	String expectedDeparture = String.format("%02d", Tomorrow);
	int DayAfterTomorrow = LocalDate.now().plusDays(2).getDayOfMonth();
	String ExpectedReturn = String.format("%02d", DayAfterTomorrow);
	String[] EnglishCitiesNames = { "jeddah", "riyadh", "dubai" };
	String[] ArabicCitiesNames = { "دبي", "جدة" };

	int randomArabicCity = rand.nextInt(ArabicCitiesNames.length);
	int randomEnglishCity = rand.nextInt(EnglishCitiesNames.length);

	String[] myWebsites = { "https://www.almosafer.com/ar", "https://www.almosafer.com/en" };

	int randomIndex = rand.nextInt(myWebsites.length);
	

	
	boolean ExpectedValueForFinshingSearchAboutHotel = true;

	
	
	
	public void SortOptionChecker() {
		WebElement Container = driver.findElement(By.cssSelector(".__ds__comp.undefined.MuiBox-root.muiltr-1smo8f0"));

		if (driver.getCurrentUrl().contains("en")) {
			List<WebElement> priceList = Container.findElements(By.cssSelector(
					".MuiTypography-root.MuiTypography-heading3SemBld.__ds__comp.undefined.muiltr-18vmb2l"));
			int lowestPrice = Integer.parseInt(priceList.get(0).getText().replace("SAR ", ""));
			int HighestPrice = Integer.parseInt(priceList.get(priceList.size() - 1).getText().replace("SAR ", ""));
			System.out.println(lowestPrice);
			System.out.println(HighestPrice);

			boolean ActualValue = lowestPrice < HighestPrice;
			boolean ExpectedValue = true;

			System.out.println(ActualValue);
			System.out.println(ExpectedValue);

			Assert.assertEquals(ActualValue, ExpectedValue);
		} else {
	
			List<WebElement> priceList = Container.findElements(By.cssSelector(
					".MuiTypography-root.MuiTypography-heading3SemBld.__ds__comp.undefined.muirtl-1l5b3qq"));
			int lowestPrice = Integer.parseInt(priceList.get(0).getText().replace("ر.س. ", ""));
			System.out.println();
			int HighestPrice = Integer.parseInt(priceList.get(priceList.size() - 1).getText().replace("ر.س. ", ""));
			System.out.println(lowestPrice);
			System.out.println(HighestPrice);

			boolean ActualValue = lowestPrice < HighestPrice;
			boolean ExpectedValue = true;

			System.out.println(ActualValue);
			System.out.println(ExpectedValue);

			Assert.assertEquals(ActualValue, ExpectedValue);

		}
	}

	
	
	

	
	
	public void CheckTheWebsiteLanguageToEnterTheCityName(WebElement HotelSearchBar ) throws InterruptedException {


		if (driver.getCurrentUrl().equals("https://www.almosafer.com/ar")) {
			String ActualLaguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			String ExpectedLanguage = "ar";

			Assert.assertEquals(ActualLaguage, ExpectedLanguage);
			HotelSearchBar.sendKeys(ArabicCitiesNames[randomArabicCity]);
		} else {
			String ActualLaguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			String ExpectedLanguage = "en";

			Assert.assertEquals(ActualLaguage, ExpectedLanguage);
			HotelSearchBar.sendKeys(EnglishCitiesNames[randomEnglishCity]);

		}
		
		
		
		Thread.sleep(2000);

		
	}
	
	public void EnterNumberOfVistorsAfterClickOnTheFirstCity() {
		WebElement CitiesList = driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List"));

		WebElement SelectNumerOfVistor = driver.findElement(By.cssSelector(".sc-tln3e3-1.gvrkTi"));
		CitiesList.findElements(By.tagName("li")).get(1).click();

		Select select = new Select(SelectNumerOfVistor);

		int randomVistorNumber = rand.nextInt(2);

		select.selectByIndex(randomVistorNumber);

		WebElement SearchButton = driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']"));
		SearchButton.click();
	}
	
	public void randomlyEnterTheWebsite () {
		driver.get(myWebsites[randomIndex]);

		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));

		HotelTab.click();
	}
	
	
	
	


public void MySetupToEnterTheWebsite() {
	driver.manage().window().maximize();
	driver.get(WebSiteURL);

	WebElement ButtonFortheCurrency = driver
			.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));

	ButtonFortheCurrency.click();
}

public void ScreenShot() throws IOException, InterruptedException {
	Thread.sleep(3000);

	Date myDate = new Date();

	String fileName = myDate.toString().replace(":", "-");

	System.out.println(fileName);

	TakesScreenshot screenshot = (TakesScreenshot) driver;
	File SrcFile = screenshot.getScreenshotAs(OutputType.FILE);

	File destFile = new File("./ScreenShot/" + fileName + ".png");
	FileUtils.copyFile(SrcFile, destFile);
}



}
