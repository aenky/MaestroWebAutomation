package CommonUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import stepDefinition.ServiceHook;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumMethods {
    private static WebElement element = null;
    private static List<WebElement> elementList = null;

    public static WebDriver initBrowser(){
        WebDriver driver=null;
        ConfigMethods config=new ConfigMethods();
        String browserName= config.getBrowserName();
        if(browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        if(browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        if(browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    public static void openURL(String url){
        ServiceHook.driver.get(url);
        CommonMethods.logInfo("Open '"+url+"' URl");
    }

    public static WebElement findElement(By by,  String log) {
        element = null;
        try {
            element = ServiceHook.driver.findElement(by);
            CommonMethods.logInfo(log);
        } catch (Exception e) {
            throw e;
        }
        return element;
    }


    public static WebElement findElementForElementNotVisible(By by,  String log) {
        element = null;
        try {
            element = ServiceHook.driver.findElement(by);
            CommonMethods.logInfo(log);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return element;
    }

    public static List<WebElement> findElements(By by, String log) {
        elementList = null;
        try {
            elementList =ServiceHook.driver.findElements(by);
            CommonMethods.logInfo(log);
        } catch (Exception e) {
            throw e;
        }
        return elementList;
    }

    public static void click(WebElement webElement,  String log) {
        webElement.click();
        CommonMethods.logInfo(log);
    }

    public static void clickWithJs(WebElement webElement,  String log) {
        JavascriptExecutor js= (JavascriptExecutor)ServiceHook.driver;
        js.executeScript("arguments[0].click();", webElement);
        CommonMethods.logInfo(log);
    }

    public static void sendKey(WebElement webElement,String enterText,  String log) {
        webElement.sendKeys(enterText);
        CommonMethods.logInfo(log+": "+enterText);
    }

    public static void clearField(WebElement webElement,  String log) {
        webElement.click();
        WaitMethods.pause(1);
        webElement.clear();
        CommonMethods.logInfo(log);
    }

    public static void clearTheField(WebElement webElement,  String log) {
        webElement.click();
        WaitMethods.pause(1);
        webElement.sendKeys(Keys.CONTROL + "A");
        webElement.sendKeys(Keys.DELETE);
        CommonMethods.logInfo(log);
    }

    public static String getCurrentURL(String log) {
        String currentURL=ServiceHook.driver.getCurrentUrl();
        CommonMethods.logInfo(log+": "+currentURL);
        return currentURL;
    }

    public static void moveCursorOnElement(WebElement element, String log) {
        Actions action = new Actions(ServiceHook.driver);
        action.moveToElement(element).build().perform();
        CommonMethods.logInfo(log);
        WaitMethods.pause(2);
    }

    public static void pressEnterKeyFromKeyBoard(WebElement element, String log) {
        element.sendKeys(Keys.RETURN);
        CommonMethods.logInfo(log);
    }


    public static String getElementText(WebElement webElement,  String log) {
        String text=webElement.getText();
        CommonMethods.logInfo(log+": "+text);
        return text;
    }


    public static void scrollBottom() {
        JavascriptExecutor js = ((JavascriptExecutor) ServiceHook.driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public static void scrollHorizontal() {
        JavascriptExecutor js = (JavascriptExecutor) ServiceHook.driver;
        js.executeScript("window.scrollBy(1000,0)", "");

    }

    public static void scrollToElementHorizontal(WebElement element, int iteration) {
        Actions action = new Actions(ServiceHook.driver);
        Actions moveToElement = action.moveToElement(element);
        for (int i = 0; i < iteration; i++) {
            moveToElement.sendKeys(Keys.RIGHT).build().perform();
        }
    }

    public static void scrollTop() {
        JavascriptExecutor js = ((JavascriptExecutor) ServiceHook.driver);
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
    }


    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) ServiceHook.driver);
        js.executeScript("arguments[0].scrollIntoView();", (element));
    }


    public static void scrollToCoordinate(String x, String y) {
        JavascriptExecutor js = (JavascriptExecutor) ServiceHook.driver;
        js.executeScript("window.scrollBy(" + x + ", " + y + ")");
    }

    public static void refreshPage() {
        ServiceHook.driver.navigate().refresh();
        CommonMethods.logInfo("Refresh The Page");
    }

    public static void openNewWindow(String log) {
        ((JavascriptExecutor) ServiceHook.driver).executeScript("window.open()");
        CommonMethods.logInfo(log);
    }

    public static void switchToNewWindow(String log) {
        ArrayList<String> tabs = new ArrayList<String>(ServiceHook.driver.getWindowHandles());
        ServiceHook.driver.switchTo().window(tabs.get(1));
        CommonMethods.logInfo(log);
    }

    public static void switchToNewWindowWithIndex(int index,String log) {
        ArrayList<String> tabs = new ArrayList<String>(ServiceHook.driver.getWindowHandles());
        ServiceHook.driver.switchTo().window(tabs.get(index));
        CommonMethods.logInfo(log);
    }

    public static void switchFrameById(String id) {
        ServiceHook.driver.switchTo().frame(id);
    }

    public static void switchMainFrame() {
        ServiceHook.driver.switchTo().parentFrame();
    }


}
