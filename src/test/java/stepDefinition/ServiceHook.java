package stepDefinition;

import CommonUtility.SeleniumMethods;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class ServiceHook {
    public static WebDriver driver = null;
    public static Scenario scenario;
    @Before
    public void openBrowser(Scenario scenario) {
        ServiceHook.scenario = scenario;
        driver= SeleniumMethods.initBrowser();
    }

    @After
    public void closeBrowser(Scenario scenario) {
        if(scenario.isFailed()){
            try{
                final byte[] screenshot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot,"image/png");
            }catch (WebDriverException e){
                e.printStackTrace();
            }
        }
        driver.quit();
    }

}
