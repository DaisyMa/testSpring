package utils;

import model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {
    private static ResourceBundle bundle=ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getUrl(InterfaceName interfaceName){
        String address=bundle.getString("test.url");
        String uri="";
        String testUrl;

        if(interfaceName==InterfaceName.LOGIN){
            uri=bundle.getString("login.uri");
        }

        if(interfaceName==InterfaceName.ADDUSER){
            uri=bundle.getString("addUser.uri");
        }

        testUrl=address+uri;
        return testUrl;

    }
}
