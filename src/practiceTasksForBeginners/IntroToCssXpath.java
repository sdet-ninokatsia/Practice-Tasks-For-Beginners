package practiceTasksForBeginners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IntroToCssXpath {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // Go to url: https://magento.softwaretestingboard.com/
        driver.get("https://magento.softwaretestingboard.com/");

        // Optional: Maximize Window
       driver.manage().window().maximize();

        //Locate SignIn button and click on it
        WebElement signIn = driver.findElement(By.xpath("//header[@class = 'page-header']//a[contains(text(), 'Sign In')]"));
        signIn.click();

        // Using css locator identify "Email" box and enter username: testing123123@gmail.com
        WebElement emailInputBox = driver.findElement(By.cssSelector("#email"));
        emailInputBox.sendKeys("testing123123@gmail.com");

        // Using css locator identify "Email" box and enter password: testingautomation12345!(other than id)
        WebElement passwordInputBox = driver.findElement(By.cssSelector("[title=Password]"));
        passwordInputBox.sendKeys("testingautomation12345!");

        // Click SignIn
        WebElement signInBtn = driver.findElement(By.xpath("//fieldset//button"));
        signInBtn.click();

        // Print the title of the home page
        String pageTitle = driver.getTitle();
        System.out.println("The title of the page is: " + pageTitle);
        Thread.sleep(3000);

        //Locate the welcome message element
        WebElement welcomeMessageElement = driver.findElement(By.xpath("//div[@class = 'panel header']//span[contains(text(), 'Welcome')]"));

        //Verify that Sign in was successful
        if(welcomeMessageElement.isDisplayed()){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        // Close the browser
       driver.quit();

    }
}
