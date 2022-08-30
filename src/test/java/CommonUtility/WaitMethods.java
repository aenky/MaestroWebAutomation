package CommonUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinition.ServiceHook;

import java.beans.Visibility;

public class WaitMethods {


    public static WebElement waitForElementToBeClickable(By by, int maxWaitTimeInSecond) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(ServiceHook.driver, maxWaitTimeInSecond);
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return element;

    }

    public static WebElement waitForElementToBeClickable(By by,WebDriver newDriver, int maxWaitTimeInSecond) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(newDriver, maxWaitTimeInSecond);
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return element;

    }

    public static boolean waitForElementToLoad(By by, int maxWaitTimeInSecond) {
        boolean visibilityStatus = true;
        try {
            WebDriverWait wait = new WebDriverWait(ServiceHook.driver, maxWaitTimeInSecond);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception ex) {
            visibilityStatus = false;
            //ex.printStackTrace();
        }
        return visibilityStatus;
    }

    public static boolean waitForElementToLoad(By by, WebDriver newDriver, int maxWaitTimeInSecond) {
        boolean visibilityStatus = true;
        try {
            WebDriverWait wait = new WebDriverWait(newDriver, maxWaitTimeInSecond);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception ex) {
            visibilityStatus = false;
            //ex.printStackTrace();
        }
        return visibilityStatus;
    }


    public static void waitUntilElementDisappear(WebElement element, int maxWaitTimeInSecond) {
        try {
            WebDriverWait wait = new WebDriverWait(ServiceHook.driver, maxWaitTimeInSecond);
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            //e.printStackTrace();
        }

    }


    public static void pause(int sec) {
        try {
            Thread.sleep(1000 * sec);
        } catch (Exception E) {

        }
    }
}
