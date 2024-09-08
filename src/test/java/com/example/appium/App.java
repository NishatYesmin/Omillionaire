package com.example.appium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;




public class App {
    @SuppressWarnings({ "deprecation", "rawtypes" })
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

            WebElement captchaCheckbox = driver.findElement(
                    AppiumBy.xpath("//android.widget.ScrollView/android.view.View[6]"));

            if (captchaCheckbox != null) {
                System.out.println("Captcha Checkbox exists.");
                String bounds = captchaCheckbox.getAttribute("bounds");
                System.out.println("Bounds attribute: " + bounds);

                Thread.sleep(5000);

                // TouchAction touchAction = new TouchAction(driver);
                // touchAction.longPress(PointOption.point(160, 1980))
                //         .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                //         .release()
                //         .perform();

                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                Sequence swipe = new Sequence(finger, 1)
                        .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 160, 1980))
                        .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                        .addAction(new Pause(finger, Duration.ofMillis(500)))
                        .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

                driver.perform(Arrays.asList(swipe));

            }

            WebElement finalLoginButton = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.xpath("//android.view.View[@content-desc=\"LOG IN\"]")));
            finalLoginButton.click();

            Thread.sleep(10000);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                // driver.quit();
            }
        }
    }
}
