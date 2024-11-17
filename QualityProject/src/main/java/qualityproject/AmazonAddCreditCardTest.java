package qualityproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonAddCreditCardTest {
    public static void main(String[] args) {
        // Set up WebDriver and specify the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Step 1: Log in to Amazon
            driver.get("https://www.amazon.com/ap/signin");
            driver.manage().window().maximize();

            // Enter email and click Continue
            WebElement emailField = driver.findElement(By.id("ap_email"));
            emailField.sendKeys("your_email@example.com"); // Replace with your test email
            driver.findElement(By.id("continue")).click();

            // Enter password and click Sign In
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password")));
            WebElement passwordField = driver.findElement(By.id("ap_password"));
            passwordField.sendKeys("your_password"); // Replace with your test password
            driver.findElement(By.id("signInSubmit")).click();

            // Step 2: Navigate to the payment options page
            driver.get("https://www.amazon.com/cpe/yourpayments/wallet");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pp-AddCreditCard"))); // Wait for the page to load

            // Step 3: Click "Add a Credit Card"
            WebElement addCreditCardButton = driver.findElement(By.id("pp-AddCreditCard"));
            addCreditCardButton.click();

            // Step 4: Fill in the credit card details
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ppw-accountHolderName")));
            WebElement nameField = driver.findElement(By.id("ppw-accountHolderName"));
            nameField.sendKeys("John Doe"); // Dummy name

            WebElement cardNumberField = driver.findElement(By.id("ppw-accountHolderName"));
            cardNumberField.sendKeys("4111111111111111"); // Dummy card number (use test data)

            WebElement expirationMonthDropdown = driver.findElement(By.id("ppw-expirationDate_month"));
            expirationMonthDropdown.sendKeys("12"); // Select December

            WebElement expirationYearDropdown = driver.findElement(By.id("ppw-expirationDate_year"));
            expirationYearDropdown.sendKeys("2027"); // Select a future year

            WebElement addCardButton = driver.findElement(By.name("ppw-widgetEvent:AddCreditCardEvent"));
            addCardButton.click();

            // Step 5: Verify card addition (dummy verification)
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation-message-id"))); // Replace with actual confirmation ID
            System.out.println("Card added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
