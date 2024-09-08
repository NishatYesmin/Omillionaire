package com.example.appium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class App {
    public static void main(String[] args) throws InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid("4352395858364798")
                .setApp("C:\\Users\\selfi\\Downloads\\app-release.apk");

        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));    

    
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.xpath("//android.view.View[@content-desc=\"LOGIN\"]")));
            loginButton.click();

         
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.accessibilityId("🇦🇪\n+971")));
            button.click();

            WebElement bdButton = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().descriptionContains(\"+880\"))")));
            bdButton.click();

            WebElement mobileNumberField = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[1]")));
            mobileNumberField.click(); 
            mobileNumberField.sendKeys("1679014643"); 
            driver.hideKeyboard(); 


            WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[2]")));
            passwordField.click();
            passwordField.sendKeys("Ni@123456");
            driver.hideKeyboard();


            WebElement captchaCheckbox = driver.findElement(AppiumBy.accessibilityId("recaptcha-checkbox"));
            captchaCheckbox.click();
            

           
            WebElement finalLoginButton = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.xpath("//android.view.View[@content-desc=\"LOG IN\"]")));
            finalLoginButton.click();

           
            Thread.sleep(5000);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                // driver.quit(); 
        }
    }
    }}


