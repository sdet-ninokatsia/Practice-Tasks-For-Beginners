package practiceTasksForBeginners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_BrowserMethods {

    public static void main(String[] args) {

    WebDriver driver = new ChromeDriver();

    // go to website number 1 of your choice using get() method
    driver.get("https://www.bestbuy.com/");

    // maximize the window
    driver.manage().window().maximize();

    // go to website number 2 of your choice using get() method
    driver.get("https://www.amazon.com/");

    // go to website number 3 of your choice using navigate() method
    driver.navigate().to("https://www.facebook.com/");

    // print 3th website title on your console using getTitle() method
    System.out.println("The title of the 3rd page: " + driver.getTitle());

    // go back using back() method and print 2nd website title
    driver.navigate().back();
    System.out.println("The title of the 2nd page: " + driver.getTitle());

    // go back using back() method and print the  URL for the 1st website
    driver.navigate().back();
    System.out.println("The current URL: " + driver.getCurrentUrl());

    // close the driver
    driver.quit();
}

}
