package tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelfMyFirstSeleniumScript {
    public static void main(String[] args) {
        //we have to setup webdriver based on the browser that we are gonna use
        WebDriverManager.chromedriver().setup();
        //we need to create an object of appropriate class
        ChromeDriver driver = new ChromeDriver();
        //lets open google.com
        //.get() method allows to open some websites
        driver.get("http://google.com");
        // to read page title, there is method .getTitle()

        // Test . verify that title of the page matches exactly matches "Google"
        String actualResult = driver.getTitle();
        String expectedResult = "Google";
        if (actualResult.equals(expectedResult)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
        //to close the browser
        driver.close();
    }
}
