package qualityproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginTest {
    public static void main(String[] args) {
        // Set up WebDriver and ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C://Users//Luz//Desktop//F Project//chromedriver-win64");
        WebDriver driver = new ChromeDriver();

        try {
            // Step 1: Navigate to Amazon login page
            driver.get("https://www.amazon.com/ap/signin");
            driver.manage().window().maximize();

            // Step 2: Enter email/phone number
            WebElement emailField = driver.findElement(By.id("ap_email"));
            emailField.sendKeys("your_email@example.com"); // Replace with your test email
            WebElement continueButton = driver.findElement(By.id("continue"));
            continueButton.click();

            // Step 3: Enter password
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password")));
            WebElement passwordField = driver.findElement(By.id("ap_password"));
            passwordField.sendKeys("your_password"); // Replace with your test password
            WebElement signInButton = driver.findElement(By.id("signInSubmit"));
            signInButton.click();

            // Step 4: Verify login was successful
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList-nav-line-1")));
            WebElement accountName = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
            System.out.println("Login Successful! Welcome: " + accountName.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
