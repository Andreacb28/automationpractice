package seleniumimplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class seleniumImplementation {
	Actions action;
	
	public seleniumImplementation(WebDriver driver) {
		action = new Actions(driver);
	}

	public void pressEnter() {
		action.sendKeys(Keys.ENTER).build().perform();
	}
	public void scrollDown(WebDriver driver) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scollBy(0,2000)", "");
	}
	
	public void performMouseHover(WebElement element) {
		action.moveToElement(element).build().perform();
	}
	
	public void clickUsingJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public static void main(String[] args) {
		System.setProperty("webDriver.chrome.driver","C:\\Windows\\System32\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		seleniumImplementation objSearch =new seleniumImplementation (driver);
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
		WebElement inputSearch = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
		inputSearch.sendKeys("Printed");
		objSearch.pressEnter();		
		objSearch.scrollDown(driver);
		
		String image = "2";
		WebElement searchImage = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li["+image+"]/div/div[1]/div/a[1]/img"));
		objSearch.performMouseHover(searchImage);
		
		WebElement btnAddToCart = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]/span"));
		objSearch.clickUsingJavaScriptExecutor(btnAddToCart, driver);

	}
	
}
		

