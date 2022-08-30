package CommonUtility;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pom.NuggetElement;

import java.nio.file.WatchEvent;
import java.util.List;
import java.util.Locale;

public class AssertMethods {

    public static void elementTextIsEqualTo(WebElement element,String validateText, String log) {
        Assert.assertEquals(element.getText(),validateText);
        CommonMethods.logInfo(log);
    }

    public static void textIsEqualTo(String test,String validateText, String log) {
        Assert.assertEquals(test,validateText);
        CommonMethods.logInfo(log);
    }

    public static void textIsEqualToIgnoreCase(String test,String validateText, String log) {
        Assert.assertEquals(test.toLowerCase(),validateText.toLowerCase());
        CommonMethods.logInfo(log);
    }

    public static void elementTextIsEqualToIgnoreCase(WebElement element,String validateText, String log) {

        Assert.assertEquals(element.getText().toLowerCase(),validateText.toLowerCase());
        CommonMethods.logInfo(log);
    }

    public static void elementTextIsNotEqualTo(WebElement element,String nonValidateText, String log) {
        boolean isTrue=false;
        if(!(element.getText().equals(nonValidateText))){
            isTrue=true;
        }
        Assert.assertTrue(isTrue);
        CommonMethods.logInfo(log);
    }

    public static void elementTextHasNotEqualTo(WebElement element,String nonValidateText, String log) {
        boolean isTrue=false;
        if(!(element.getText().contains(nonValidateText))){
            isTrue=true;
        }
        Assert.assertTrue(isTrue);
        CommonMethods.logInfo(log);
    }

    public static void elementIsDisplayed(WebElement element, String log) {
        Assert.assertTrue(element.isDisplayed());
        CommonMethods.logInfo(log);
    }

    public static void elementIsEnabled(WebElement element, String log) {
        Assert.assertTrue(element.isEnabled());
        CommonMethods.logInfo(log);
    }

    public static void elementAttributeValueIsEqualTo(WebElement element,String attributeName,String attributeValue, String log) {
        Assert.assertTrue(element.getAttribute(attributeName).equalsIgnoreCase(attributeValue));
        CommonMethods.logInfo(log);
    }

    public static void elementListIsNotEmpty(List<WebElement> elementList, String log) {
        Assert.assertTrue(!elementList.isEmpty());
        CommonMethods.logInfo(log);
    }

    public static void elementTextIsEndWith(String text,String validateText, String log) {
        Assert.assertTrue(text.endsWith(validateText));
        CommonMethods.logInfo(log);
    }

    public static void elementTextIsStartWith(String text,String validateText, String log) {
        Assert.assertTrue(text.startsWith(validateText));
        CommonMethods.logInfo(log);
    }

    public static void elementTextHasText(String text,String validateText, String log) {
        Assert.assertTrue(text.contains(validateText));
        CommonMethods.logInfo(log);
    }

    public static void elementListSizeIsSame(List<WebElement> elementList,int number, String log) {
        Assert.assertTrue(elementList.size()==number);
        CommonMethods.logInfo(log);
    }

    public static void isTrue(boolean flag, String log) {
        Assert.assertTrue(flag);
        CommonMethods.logInfo(log);
    }

    public static void elementIsNotDisplayed(WebElement element, String log){
        boolean isNotDisplayed=true;
        try {
            if (element.isDisplayed()) {
                isNotDisplayed=false;
            }
        } catch (Exception e) {}
        CommonMethods.logInfo(log);
        Assert.assertTrue(isNotDisplayed);
    }
}
