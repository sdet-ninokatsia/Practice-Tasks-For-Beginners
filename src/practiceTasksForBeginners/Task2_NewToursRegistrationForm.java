package practiceTasksForBeginners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Task2_NewToursRegistrationForm {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/newtours/");

        // locate Register tab and click on it
        WebElement registerTab = driver.findElement(By.linkText("REGISTER"));
        registerTab.click();

        // wait for 2 seconds until all elements render on the new page
        Thread.sleep(2000);

        // Locate the web elements for the registration form
        WebElement firstName = driver.findElement(By.name("firstName"));
        WebElement lastName = driver.findElement(By.name("lastName"));
        WebElement phone = driver.findElement(By.name("phone"));
        WebElement email = driver.findElement(By.id("userName"));
        WebElement address = driver.findElement(By.name("address1"));
        WebElement city = driver.findElement(By.name("city"));
        WebElement state = driver.findElement(By.name("state"));
        WebElement postalCode = driver.findElement(By.name("postalCode"));
        WebElement country = driver.findElement(By.name("country"));
        Select optionsForCountry = new Select(country);
        List<WebElement> allOptions = optionsForCountry.getOptions();
        for (WebElement option : allOptions) {
            if (option.getText().equalsIgnoreCase("UNITED STATES")) {
                optionsForCountry.selectByVisibleText("UNITED STATES");
                break;
            }
        }
        WebElement userName = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement confirmPassword = driver.findElement(By.name("confirmPassword"));
        WebElement confirmButton = driver.findElement(By.name("submit"));

        // interact with the elements:
        firstName.sendKeys("John");
        lastName.sendKeys("Doe");
        phone.sendKeys("2121234567");
        email.sendKeys("johndoe1@gmail.com");
        address.sendKeys("123 Main Street");
        city.sendKeys("New York");
        state.sendKeys("New York");
        postalCode.sendKeys("10080");
        userName.sendKeys("testUsername");
        password.sendKeys("12345");
        confirmPassword.sendKeys("12345");
        confirmButton.click();

        // wait for 2 seconds
        Thread.sleep(2000);

        // get  url (current)
        String currentURL = driver.getCurrentUrl();

        // verify registration was successful
        if(currentURL.endsWith("register_sucess.php")){
            System.out.println("TEST: PASSED");
        }else{
            System.out.println("TEST: FAILED");
        }

        // Close driver
        driver.quit();

    }
}
