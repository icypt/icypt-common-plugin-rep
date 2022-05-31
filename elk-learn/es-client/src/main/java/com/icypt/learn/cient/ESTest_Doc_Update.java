package com.icypt.learn.cient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icypt.learn.vo.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

public class ESTest_Doc_Update {
    public static void main(String[] args) throws Exception{
        //创建客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        //修改数据
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index("users").id("1001");
        updateRequest.doc(XContentType.JSON, "sex", "女");

        UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(updateResponse.getResult());

        //关闭客户端
        client.close();
    }
}
