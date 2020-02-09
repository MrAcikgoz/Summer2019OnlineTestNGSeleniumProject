package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class RadioButtons {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        //to go to radio buttons page
        //  <a href="/radio_buttons">Radio Buttons</a>
        // linkText works only with <a> elements
        //link text only in between >Text<
        // This step is common for all test cases
        driver.findElement(By.linkText("Radio Buttons")).click();
        driver.manage().window().maximize();
    }
    @Test ( description = "Verify that blue button is selected")
    public void test1(){
        //find blue radio button
        WebElement blueButton = driver.findElement(By.id("blue"));
        // Let's verify that radio button is selected
        Assert.assertTrue(blueButton.isSelected());
    }

    @Test (description = "Verify that red button is not selected")
    public void test2(){
        WebElement redButton = driver.findElement(By.id("red"));
        Assert.assertFalse(redButton.isSelected());
    }

    @Test (description = "Verify that the green button is not clickable")
    public void test3(){
        WebElement greenButton = driver.findElement(By.id("green"));
        // isEnabled() will return true if the button is available for interaction
        // that means you can click on it, in this case
        Assert.assertFalse(greenButton.isEnabled());
    }

        // Let's find all the radio buttons and click on them on by one
    @Test (description = "Click on all the radio buttons")
    public void test4(){
        // how to find all radio buttons
        // Find all the radio buttons
        // any radio button will have type='radio'
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        // let's click only if button is not clicked and is available for clicking
        for (WebElement button: radioButtons) {
            // if button is available for clicking and not clicked yet
            if( button.isEnabled() && !button.isSelected()){
                //then click on it
                button.click();
            // in this case, id attribute represents a name of the color
            // also, there is no text in this element
            // that's why I print attribute value
            // <input type='radio' id="green" name="color" disabled=""> attribute: type, id, name, disabled
                System.out.println("Button clicked: "+button.getAttribute("id"));
            } else{
                System.out.println("Button was not clicked: "+button.getAttribute("id"));
            }
            BrowserUtils.wait(1);
        }

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
