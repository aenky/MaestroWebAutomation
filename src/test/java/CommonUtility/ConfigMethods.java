package CommonUtility;

import org.json.simple.JSONObject;

import java.io.File;

public class ConfigMethods {

    JSONObject main= CommonMethods.loadJsonFile(getConfigFilePath());

    public String getConfigFilePath() {
        String configName;
        configName="config.json";
        File file = new File(configName);
        return file.getAbsolutePath();
    }
    public String getBaseURL(){
        return main.get("baseURL").toString();
    }

    public String getBrowserName(){
        return main.get("browserName").toString();
    }

    public String userEmail(String roll){
        JSONObject object= (JSONObject) main.get(roll);
        return object.get("userEmail").toString();
    }

    public String userPassword(String roll){
        JSONObject object= (JSONObject) main.get(roll);
        return object.get("password").toString();
    }
}
