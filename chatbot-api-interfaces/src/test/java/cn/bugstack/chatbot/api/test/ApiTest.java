package cn.bugstack.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
//单元测试
public class ApiTest {
    //接口爬取信息
    @Test
    public void query_unanswered_questions() throws IOException {
        //创建 CloseableHttpClient对象；创建Http请求对象
        //获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        //创建get请求
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");

        get.addHeader("cookie", "zsxq_access_token=0114B2A0-E87C-7293-32D4-1B11C4D2E6FF_A1D15E2851EBC58A; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22218242512442181%22%2C%22first_id%22%3A%2218def797ffc3f1-01266ae519c68ca-4c657b58-921600-18def797ffd3a4%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThkZWY3OTdmZmMzZjEtMDEyNjZhZTUxOWM2OGNhLTRjNjU3YjU4LTkyMTYwMC0xOGRlZjc5N2ZmZDNhNCIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjIxODI0MjUxMjQ0MjE4MSJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22218242512442181%22%7D%2C%22%24device_id%22%3A%2218def797ffc3f1-01266ae519c68ca-4c657b58-921600-18def797ffd3a4%22%7D; zsxqsessionid=2b996e248c4a54e483157169fefff5b2; abtest_env=beta; mp_8b1215dbcc852955566c4df66e547374_mixpanel=%7B%22distinct_id%22%3A%20%2218de9ba350b3ac-0066d03b1022d-4c657b58-e1000-18de9ba350c10cd%22%2C%22%24device_id%22%3A%20%2218de9ba350b3ac-0066d03b1022d-4c657b58-e1000-18de9ba350c10cd%22%2C%22%24initial_referrer%22%3A%20%22https%3A%2F%2Fgithub.com%2Ffuzhengwei%2Fchatbot-api%3Ftab%3Dreadme-ov-file%22%2C%22%24initial_referring_domain%22%3A%20%22github.com%22%7D");
        //get.addHeader("cookie", "zsxq_access_token=0114B2A0-E87C-7293-32D4-1B11C4D2E6FF_A1D15E2851EBC58A; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22218242512442181%22%2C%22first_id%22%3A%2218def797ffc3f1-01266ae519c68ca-4c657b58-921600-18def797ffd3a4%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThkZWY3OTdmZmMzZjEtMDEyNjZhZTUxOWM2OGNhLTRjNjU3YjU4LTkyMTYwMC0xOGRlZjc5N2ZmZDNhNCIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjIxODI0MjUxMjQ0MjE4MSJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22218242512442181%22%7D%2C%22%24device_id%22%3A%2218def797ffc3f1-01266ae519c68ca-4c657b58-921600-18def797ffd3a4%22%7D; zsxqsessionid=2b996e248c4a54e483157169fefff5b2; abtest_env=beta; mp_8b1215dbcc852955566c4df66e547374_mixpanel=%7B%22distinct_id%22%3A%20%2218de9ba350b3ac-0066d03b1022d-4c657b58-e1000-18de9ba350c10cd%22%2C%22%24device_id%22%3A%20%2218de9ba350b3ac-0066d03b1022d-4c657b58-e1000-18de9ba350c10cd%22%2C%22%24initial_referrer%22%3A%20%22https%3A%2F%2Fgithub.com%2Ffuzhengwei%2Fchatbot-api%3Ftab%3Dreadme-ov-file%22%2C%22%24initial_referring_domain%22%3A%20%22github.com%22%7D");
        get.addHeader("Content-Type", "application/json;charset=utf-8");

        //由客户端调用execute方法执行(发送)Get请求
        CloseableHttpResponse response = httpClient.execute(get);

        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());// 从响应模型中获取响应实体
            System.out.println(res);
        }
        else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/412884248251548/answer");
        post.addHeader("cookie", "zsxq_access_token=0114B2A0-E87C-7293-32D4-1B11C4D2E6FF_A1D15E2851EBC58A; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22218242512442181%22%2C%22first_id%22%3A%2218def797ffc3f1-01266ae519c68ca-4c657b58-921600-18def797ffd3a4%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThkZWY3OTdmZmMzZjEtMDEyNjZhZTUxOWM2OGNhLTRjNjU3YjU4LTkyMTYwMC0xOGRlZjc5N2ZmZDNhNCIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjIxODI0MjUxMjQ0MjE4MSJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22218242512442181%22%7D%2C%22%24device_id%22%3A%2218def797ffc3f1-01266ae519c68ca-4c657b58-921600-18def797ffd3a4%22%7D; zsxqsessionid=2b996e248c4a54e483157169fefff5b2; abtest_env=beta; mp_8b1215dbcc852955566c4df66e547374_mixpanel=%7B%22distinct_id%22%3A%20%2218de9ba350b3ac-0066d03b1022d-4c657b58-e1000-18de9ba350c10cd%22%2C%22%24device_id%22%3A%20%2218de9ba350b3ac-0066d03b1022d-4c657b58-e1000-18de9ba350c10cd%22%2C%22%24initial_referrer%22%3A%20%22https%3A%2F%2Fgithub.com%2Ffuzhengwei%2Fchatbot-api%3Ftab%3Dreadme-ov-file%22%2C%22%24initial_referring_domain%22%3A%20%22github.com%22%7D");
        post.addHeader("Content-Type", "application/json;charset=utf-8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"自己去百度！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";
        ;

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }
        else{
            System.out.println(response.getStatusLine().getStatusCode());
        }



    }



}
