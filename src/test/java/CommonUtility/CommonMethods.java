package CommonUtility;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import stepDefinition.ServiceHook;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class CommonMethods {
    static Logger log = Logger.getLogger(CommonMethods.class);
    static Faker fakers=new Faker(new Locale("en-IND"));
    static String parentWindow="";
    static String childWindow="";

    public static void logInfo(String msg){
        log.info(msg);
        //System.out.println(msg);
        ServiceHook.scenario.write("=> "+msg);
    }

    public static void browserZoomIn() throws AWTException {
        Robot robot = new Robot();

        //for(int i=0;i<2;i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_MINUS);
            robot.keyRelease(KeyEvent.VK_MINUS);
            robot.keyRelease(KeyEvent.VK_CONTROL);

        //}
        WaitMethods.pause(2);
    }

    public static String getCurrentDateTime(String format) {
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(currentDate.getTime());
    }

    public static JSONObject loadJsonFile(String jsonFilePath){
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            Object obj = parser.parse(new FileReader(jsonFilePath));
            jsonObject = (JSONObject) obj;
        } catch (Exception e) {log.error("");}
        return jsonObject;
    }

    public static boolean isAttributePresent(WebElement element, String attribute) {
        Boolean result = false;
        try {
            String value = element.getAttribute(attribute);
            if (value != null){
                result = true;
            }
        } catch (Exception e) {}

        return result;
    }

    public static WebElement expandRootElement(WebElement element) {
        WebElement ele = (WebElement) ((JavascriptExecutor) ServiceHook.driver)
                .executeScript("return arguments[0].shadowRoot",element);
        return ele;
    }

    public static void switchNewWindow(String browser) {
        //Get parent window.
        parentWindow = ServiceHook.driver.getWindowHandle();
        //Get all open windows.
        Set<String> handles = ServiceHook.driver.getWindowHandles();

        for (String windowHandle : handles) {
            //Condition for get new window.
            if (!windowHandle.equals(parentWindow)) {
                childWindow = windowHandle;
                CommonMethods.logInfo("Switch to new window");
                //Switch to new window.
                ServiceHook.driver.switchTo().window(childWindow);
                if (browser.equals("firefox")) {
                    break;
                }
            }
        }
    }

    public static void switchMainWindow() {
        Set<String> handles = ServiceHook.driver.getWindowHandles();

        for (String windowHandle : handles) {
            //Condition for get new window.
            if (windowHandle.equals(parentWindow)) {
                ServiceHook.driver.switchTo().window(parentWindow);
                CommonMethods.logInfo("Switch to main / parent window");
            }
        }

    }

    public static WebElement settingOption(List<WebElement> list, String option) {
        for(WebElement el: list){
            if(el.getText().equals(option)){
                return el;
            }
        }

        return null;
    }

    public static void closeWindow() {
        ServiceHook.driver.close();
        CommonMethods.logInfo("Close the Window");
    }

    public static WebElement getShadowRootElement(WebElement element) {
        WebElement ele = (WebElement) ((JavascriptExecutor)ServiceHook.driver)
                .executeScript("return arguments[0].shadowRoot", element);
        return ele;
    }

    public static String nextMonth() {
        Calendar currentMonth = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
        currentMonth.add(Calendar.MONTH, 1);
        return dateFormat.format(currentMonth.getTime());
    }

    public static String nextYear() {
        Calendar currentMonth = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        currentMonth.add(Calendar.YEAR, 1);
        return dateFormat.format(currentMonth.getTime());
    }

    public static String captureScreenshot() {
        String path;
        try {
            File filePath = new File("screenshots");
            File scrFile = ((TakesScreenshot) ServiceHook.driver).getScreenshotAs(OutputType.FILE);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            path = filePath + "/Automation" +"_" + dtf.format(LocalDateTime.now()) + ".png";
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        return path;
    }

    // Random First Name
    public static String firstName() {
        return fakers.name().firstName();

    }

    // Random Last Name
    public static String lastName() {
        return fakers.name().lastName();
    }


    // Random Email
    public static String eMail() {
        return fakers.internet().emailAddress();

    }

    // Random user Name
    public static String userName() {
        return fakers.name().username();
    }

}
