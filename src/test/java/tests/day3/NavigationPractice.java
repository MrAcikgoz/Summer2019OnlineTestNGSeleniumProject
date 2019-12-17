package tests.day3;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class NavigationPractice {
    public static void main(String[] args) {
        //create a webdriver object, to work with a browser
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize(); //to maximize window
        driver.get("http://google.com");

        //wait for 3 seconds
        //this is out custom method
        //since method is static, we use class name to call the method
        //as a parameter, we provide number of seconds(time: in seconds)
        BrowserUtils.wait(3);

        //How to print page title?
        System.out.println(driver.getTitle());

        driver.navigate().to("http://amazon.com");

        //navigate back to google (previous URL)
        driver.navigate().back();

        //move forward to the amazon again
        driver.navigate().forward();

        // to refresh a webpage
        driver.navigate().refresh();

        //shutdown browser
        driver.quit();
        //if tab only one, close() will shutdown browser
        //and we cannot use driver anymore
        //so we have to recreate an object of WebDriver
        //what will happen, if I will call driver againn
        //after quit()?
        driver.get("http://google.com");
    }
}
