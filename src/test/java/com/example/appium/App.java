package com.example.appium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
// import org.openqa.selenium.Dimension;

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
    
                WebElement captchaCheckbox = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.view.View[6]"));
                
                if (captchaCheckbox != null) {
                    System.out.println("Captcha Checkbox exists.");
                    String bounds = captchaCheckbox.getAttribute("bounds");
                    System.out.println("Bounds attribute: " + bounds);
    
                    if (bounds == null || bounds.isEmpty()) {
                        System.out.println("Bounds attribute not available, using element's location and size.");
                        int x = captchaCheckbox.getLocation().getX();
                        int y = captchaCheckbox.getLocation().getY();
                        int width = captchaCheckbox.getSize().getWidth();
                        int height = captchaCheckbox.getSize().getHeight();
    
                        int centerX = x + (width / 2);
                        int centerY = y + (height / 2);
    
                        TouchAction touchAction = new TouchAction(driver);
                        touchAction.longPress(PointOption.point(centerX, centerY))
                                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                                .release()
                                .perform();
                    } else {
                        if (bounds.contains("][")) {
                        // DO NOT REMOVE THESE COMMENTED CODES
                        //     String[] points = bounds.replace("[", "").replace("]", "").split("\\]\\[");
                        //     if (points.length == 2) {
                        //         String[] startPoint = points[0].split(",");
                        //         String[] endPoint = points[1].split(",");
    
                        //         int startX = Integer.parseInt(startPoint[0]);
                        //         int startY = Integer.parseInt(startPoint[1]);
                        //         int endX = Integer.parseInt(endPoint[0]);
                        //         int endY = Integer.parseInt(endPoint[1]);
    
                        //         // Calculate the center of the element
                        //         int centerX = (startX + endX) / 2;
                        //         int centerY = (startY + endY) / 2;
    
                        //         // Perform a long press using TouchAction
                        //         TouchAction touchAction = new TouchAction(driver);
                        //         touchAction.longPress(PointOption.point(centerX, centerY))
                        //                 .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                        //                 .release()
                        //                 .perform();
                        //     } else {
                        //         System.out.println("Bounds format is invalid or unexpected.");
                        //     }
                        // String[] startPoint = points[0].split(",");
                        // String[] endPoint = points[1].split(",");

                        int startX = Integer.parseInt("156");
                        int startY = Integer.parseInt("1964");
                        int endX = Integer.parseInt("236");
                        int endY = Integer.parseInt("2044");

                        int centerX = (startX + endX) / 2;
                        int centerY = (startY + endY) / 2;

                        TouchAction touchAction = new TouchAction(driver);
                        touchAction.longPress(PointOption.point(centerX, centerY))
                                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                                .release()
                                .perform();
                        }
                    }
                } else {
                    System.out.println("Captcha Checkbox not found.");
                }
    
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
        }
    }
    