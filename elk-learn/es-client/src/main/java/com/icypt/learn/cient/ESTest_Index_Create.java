package com.icypt.learn.cient;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class ESTest_Index_Create {
    public static void main(String[] args) throws Exception{
        //创建客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        //创建索引
        CreateIndexRequest indexRequest = new CreateIndexRequest("users");
        CreateIndexResponse indexResponse = client.indices().create(indexRequest, RequestOptions.DEFAULT);
        //响应状态
        boolean acknowledge = indexResponse.isAcknowledged();
        System.out.println("索引操作：" + acknowledge);

        //关闭客户端
        client.close();
    }
}
