import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestcases {

	WebDriver driver = new ChromeDriver();

	String WebSiteURL = "https://global.almosafer.com/en";
	Random rand = new Random();

	@BeforeTest
	public void mySetup() {

		driver.manage().window().maximize();
		driver.get(WebSiteURL);

		WebElement ButtonFortheCurrency = driver
				.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));

		ButtonFortheCurrency.click();

	}

	@Test(priority = 1, enabled = false)

	public void CheckTheEnglishLanguageIsDefault() {
		String ActualLaguage = driver.findElement(By.tagName("html")).getAttribute("lang");
		String ExpectedLanguage = "en";

		Assert.assertEquals(ActualLaguage, ExpectedLanguage);
	}

	@Test(priority = 2, enabled = false)
	public void CheckTheDefaultCurrencyIsSAR() {
		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();
		String ExpectedCurrency = "SAR";

		Assert.assertEquals(ActualCurrency, ExpectedCurrency);

	}

	@Test(priority = 3, enabled = false)
	public void CheckContactNumber() {
		String ActualNumber = driver.findElement(By.cssSelector(".sc-hUfwpO.bWcsTG")).getText();

		String ExpectedNumber = "+966554400000";

		Assert.assertEquals(ActualNumber, ExpectedNumber);

	}

	@Test(priority = 4, enabled = false)
	public void CheckQitafLogoIsThereInTheFooter() {

		WebElement TheFooter = driver.findElement(By.tagName("footer"));
		boolean ActualResult = TheFooter.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ciodno.lkfeIG"))
				.isDisplayed();
		boolean ExpectedResult = true;

		Assert.assertEquals(ActualResult, ExpectedResult);

	}

	@Test(priority = 5, enabled = false)

	public void CheckHotelTabIsNotSelected() {
		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ExpectedValue = "false";

		String ActualValue = HotelTab.getAttribute("aria-selected");

		Assert.assertEquals(ActualValue, ExpectedValue);

	}

	@Test(priority = 6, enabled = false)
	public void CheckDepatureDate() {
		int today = LocalDate.now().getDayOfMonth();

		int Tomorrow = LocalDate.now().plusDays(1).getDayOfMonth();

//		System.out.println(today);
//		System.out.println(Tomorrow);
//		System.out.println(DayAfterTomorrow);

		String ActualDepature = driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']"))
				.getText();
		String ExpectedDepature = Integer.toString(Tomorrow);

		Assert.assertEquals(ActualDepature, ExpectedDepature);

		;

		System.out.println();

	}

	@Test(priority = 7, enabled = false)
	public void CheckReturnDate() {
		int today = LocalDate.now().getDayOfMonth();

		int DayAfterTomorrow = LocalDate.now().plusDays(2).getDayOfMonth();

		String ActualReturn = driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-fvLVrH hNjEjT']"))
				.getText();
		String ExpectedReturn = Integer.toString(DayAfterTomorrow);

		Assert.assertEquals(ActualReturn, ExpectedReturn);

	}

	@Test(priority = 8,enabled = false)
	public void RandomlyChangeTheLanguage() throws InterruptedException {

		String[] EnglishCitiesNames = { "jeddah", "riyadh", "dubai" };
		String[] ArabicCitiesNames = { "دبي", "جدة" };

		int randomArabicCity = rand.nextInt(ArabicCitiesNames.length);
		int randomEnglishCity = rand.nextInt(EnglishCitiesNames.length);

		String[] myWebsites = { "https://www.almosafer.com/ar", "https://www.almosafer.com/en" };

		int randomIndex = rand.nextInt(myWebsites.length);

		driver.get(myWebsites[randomIndex]);

		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));

		HotelTab.click();

		WebElement HotelSearchBar = driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input"));

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

		WebElement CitiesList = driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List"));

		WebElement SelectNumerOfVistor = driver.findElement(By.cssSelector(".sc-tln3e3-1.gvrkTi"));
		CitiesList.findElements(By.tagName("li")).get(1).click();

		Select select = new Select(SelectNumerOfVistor);

		int randomVistorNumber = rand.nextInt(2);

		select.selectByIndex(randomVistorNumber);

		WebElement SearchButton = driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']"));
		SearchButton.click();

		Thread.sleep(35000);

	}

	@Test(priority = 9,enabled = false)

	public void CheckThatThePageIsFullyLoaded() {
		WebElement SearchResult = driver.findElement(By.xpath("//span[@data-testid='srp_properties_found']"));

		boolean ActualResult = SearchResult.getText().contains("found") || SearchResult.getText().contains("مكان");

		boolean ExpectedResult = true;

		Assert.assertEquals(ActualResult, ExpectedResult);
	}

	@Test(priority = 10)
	public void CheckTheSortOption() throws InterruptedException {
		Thread.sleep(35000);
		
		driver.get("https://www.almosafer.com/ar/hotels/Dubai/10-11-2024/11-11-2024/2_adult?placeId=ChIJRcbZaklDXz4RYlEphFBu5r0&city=%D8%AF%D8%A8%D9%8A");

		WebElement LowestPriceButton = driver.findElement(By.xpath("//div[@data-testid='srp_sort_LOWEST_PRICE']"));

		LowestPriceButton.click();
		
		List<WebElement> allPrices = driver.findElements(By.cssSelector(".__ds__comp.undefined.MuiBox-root.muiltr-1nylpq2"));

		
		System.out.println(allPrices.size());
	}

}
