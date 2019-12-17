package tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {
        // if you have exception: cannot load class
        // that means that package name, doesn't match with location of the class itself

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com");

        //we want to navigate , to different page within the same browser
        // we wont be opening a new browser or new tab
        //URL can be passed as an object
        //or as a string
        //we use string
        driver.navigate().to("http://amazon.com");
        //if I want to comeback to previous page

        driver.navigate().back();
        //if I want to know the URL of current website
        String url = driver.getCurrentUrl();
        System.out.println(url);
        //selenium cannot close browser automatically
        //for this, we use method close()
        driver.close();

    }
}
