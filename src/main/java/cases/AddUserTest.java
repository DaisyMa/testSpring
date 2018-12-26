package cases;

import config.TestConfig;
import model.AddUserCase;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ConfigFile;
import utils.SqlSessionUtil;
import com.alibaba.fastjson.JSONObject;
import model.*;
import mapper.*;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddUserTest {
    DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @BeforeTest
    public void beforeTest(){
        TestConfig.defaultHttpClient = new DefaultHttpClient();
        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSER);
    }


    @Test
    public void addUser() throws IOException, InterruptedException {
        SqlSession session= SqlSessionUtil.getSqlSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        AddUserCase addUserCase=userMapper.addUserCase(10);
        String result = getResult(addUserCase);
        Thread.sleep(2000);

        String name=addUserCase.getName();
        Timestamp createTime=addUserCase.getCreateTime();
        String createTimeStr=dateFormat.format(createTime);

        Integer status=addUserCase.getStatus();
        User user = userMapper.addUserCheck(name,status,createTimeStr);

        System.out.println(user.toString());

        Assert.assertEquals(addUserCase.getExpected(),result);
    }


    private String getResult(AddUserCase addUserCase) throws IOException{
        HttpPost post=new HttpPost(TestConfig.addUserUrl);
        JSONObject req=new JSONObject();
        req.put("name",addUserCase.getName());
        req.put("status",addUserCase.getStatus());
        req.put("createTime",addUserCase.getCreateTime());
//        req.put("id",addUserCase.getId());
        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(req.toString(),"utf-8");
        post.setEntity(entity);
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);
        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        return result;
    }
}
