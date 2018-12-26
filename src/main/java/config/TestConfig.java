package config;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

public class TestConfig {
    public static String loginUrl;
    //添加用户信息接口
    public static String addUserUrl;

    public static CookieStore store;
    //声明http客户端
    public static DefaultHttpClient defaultHttpClient;

}
