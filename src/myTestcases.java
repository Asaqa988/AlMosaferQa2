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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestcases extends Parameters {

	@BeforeTest
	public void mySetup() {

		MySetupToEnterTheWebsite();

	}

	@Test(priority = 1, enabled = false)

	public void CheckTheEnglishLanguageIsDefault() throws IOException, InterruptedException {
		String ActualLaguage = driver.findElement(By.tagName("html")).getAttribute("lang");

		Assert.assertEquals(ActualLaguage, ExpectedLanguage);

		ScreenShot();
		
		
		

	}

	@Test(priority = 2, enabled = false)
	public void CheckTheDefaultCurrencyIsSAR() throws IOException, InterruptedException {
		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();

		Assert.assertEquals(ActualCurrency, ExpectedCurrency);
		ScreenShot();

	}

	@Test(priority = 3, enabled = false)
	public void CheckContactNumber() throws IOException {
		String ActualNumber = driver.findElement(By.cssSelector(".sc-hUfwpO.bWcsTG")).getText();


		Assert.assertEquals(ActualNumber, ExpectedNumber);

	}

	@Test(priority = 4, enabled = false)
	public void CheckQitafLogoIsThereInTheFooter() throws IOException {

		WebElement TheFooter = driver.findElement(By.tagName("footer"));
		boolean ActualResult = TheFooter.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ciodno.lkfeIG"))
				.isDisplayed();
	

		Assert.assertEquals(ActualResult, ExpectedResultForQitafLogo);

	}

	@Test(priority = 5, enabled = false)

	public void CheckHotelTabIsNotSelected() throws IOException {
		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));

		String ActualValue = HotelTab.getAttribute("aria-selected");

		Assert.assertEquals(ActualValue, ExpectedValue);

	}

	@Test(priority = 6, enabled = false)
	public void CheckDepatureDate() throws IOException {

		String ActualDepature = driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']"))
				.getText();

		Assert.assertEquals(ActualDepature, expectedDeparture);

	}

	@Test(priority = 7, enabled = false)
	public void CheckReturnDate() throws IOException {


		String ActualReturn = driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-fvLVrH hNjEjT']"))
				.getText();

		Assert.assertEquals(ActualReturn, ExpectedReturn);

	}

	@Test(priority = 8, enabled = true)
	public void RandomlyChangeTheLanguage() throws InterruptedException, IOException {


		randomlyEnterTheWebsite();
		
		WebElement HotelSearchBar = driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input"));


		CheckTheWebsiteLanguageToEnterTheCityName(HotelSearchBar);

		EnterNumberOfVistorsAfterClickOnTheFirstCity(); 

	}

	@Test(priority = 9, enabled = false)

	public void CheckThatThePageIsFullyLoaded() throws IOException {
		WebElement SearchResult = driver.findElement(By.xpath("//span[@data-testid='srp_properties_found']"));

		boolean ActualResult = SearchResult.getText().contains("found") || SearchResult.getText().contains("مكان");


		Assert.assertEquals(ActualResult, ExpectedValueForFinshingSearchAboutHotel);

	}

	@Test(priority = 10, enabled = true)
	public void CheckTheSortOption() throws InterruptedException, IOException {

		Thread.sleep(15000);

		WebElement SortOption = driver.findElement(By.xpath("//div[@data-testid='srp_sort_LOWEST_PRICE']"));
		SortOption.click();

		Thread.sleep(2000);


		SortOptionChecker();
	}

}
