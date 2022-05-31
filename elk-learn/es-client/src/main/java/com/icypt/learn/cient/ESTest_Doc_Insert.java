package com.icypt.learn.cient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icypt.learn.vo.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

public class ESTest_Doc_Insert {
    public static void main(String[] args) throws Exception{
        //创建客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        //插入数据
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.index("users").id("1007");

        //组装数据
        User user = new User();
        user.setName("张三强");
        user.setSex("男");
        user.setAge(10);

        //向Es中插入数据，数据必须是JSON格式
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        indexRequest.source(userJson, XContentType.JSON);

        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse.getResult());

        //关闭客户端
        client.close();
    }
}
