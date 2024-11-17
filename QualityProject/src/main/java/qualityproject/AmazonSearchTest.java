package qualityproject;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.openqa.selenium.support.ui.ExpectedConditions;

	import java.time.Duration;

	public class AmazonSearchTest {
	    public static void main(String[] args) {
	        // Set up the WebDriver and specify the path to the ChromeDriver
	        System.setProperty("webdriver.chrome.driver", "C://Users//Luz//Downloads//chromedriver-win64//chromedriver-win64");
	        WebDriver driver = new ChromeDriver();

	        try {
	            // Step 1: Navigate to Amazon
	            driver.get("https://www.amazon.com/");
	            driver.manage().window().maximize();

	            // Step 2: Locate the search bar, enter a query, and submit
	            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
	            searchBox.sendKeys("Selenium WebDriver books");
	            WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
	            searchButton.click();

	            // Step 3: Wait for the search results to load
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.s-main-slot")));

	            // Step 4: Click on the first search result
	            WebElement firstResult = driver.findElement(By.cssSelector("div.s-main-slot div[data-index='0'] h2 a"));
	            firstResult.click();

	            // Step 5: Verify the product page loaded
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productTitle")));
	            WebElement productTitle = driver.findElement(By.id("productTitle"));
	            System.out.println("Product Page Title: " + productTitle.getText());

	            // Step 6: Validate the product title is displayed
	            if (productTitle.isDisplayed()) {
	                System.out.println("Test Passed: Product page loaded successfully.");
	            } else {
	                System.out.println("Test Failed: Product page did not load.");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close the browser
	            driver.quit();
	        }
	    }
	}



