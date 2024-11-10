import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class carer {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		String WebSiteURL = "https://careerak.com/admin/dashboard/user#!";
		
		driver.get(WebSiteURL);
		
driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/form/div[1]/div/input")).sendKeys("");
	}

}
