package practiceTasksForBeginners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3_SignIn_Magento {

        public static void main(String[] args) throws InterruptedException {

            WebDriver driver = new ChromeDriver();

           // Optional: maximize the window
            driver.manage().window().maximize();

            // Store the credentials that we will use to sign in
            String username = "testing123123@gmail.com";
            String password = "testingautomation12345!";

            // Navigate to the web-app
            driver.get("https://magento.softwaretestingboard.com/");

            // Locate and store the SignIn button
            WebElement signInBtn = driver.findElement(By.xpath("//div[@class = 'panel header']//a[contains(text(), 'Sign In')]"));

            // click on SignIn button
            signInBtn.click();

            // Wait for 2 seconds for the page to render
            Thread.sleep(2000);

            // Retrieve the title of the current page and print it
            String currentTitle =  driver.getTitle();
            System.out.println("The title of the page is: " + currentTitle);

            // Fill out sign in information
            WebElement emailInputBox = driver.findElement(By.cssSelector("#email"));
            emailInputBox.sendKeys(username);

            WebElement passwordInputBox = driver.findElement(By.cssSelector("#pass"));
            passwordInputBox.sendKeys(password);

            // submit
            WebElement signInSubmit = driver.findElement(By.xpath("//fieldset//button"));
            signInSubmit.click();
            Thread.sleep(3000);

            // Locate the web welcome message element
            WebElement welcomeMessageElement = driver.findElement(By.xpath("//div[@class = 'panel header']//span[contains(text(), 'Welcome, ')]"));
            Thread.sleep(3000);

            // Having the element, utilize getText() to retrieve the text from the web element
            String welcomeMessage = welcomeMessageElement.getText();

            // Print the message that comes from the web page
            System.out.println("Message: " + welcomeMessage);

            // Validation
            if(welcomeMessage.startsWith("Welcome,")){
                System.out.println("PASS");
            }else {
                System.out.println("FAIL");
            }

            // terminate driver session
            driver.quit();

        }
    }

