package com.icypt.learn.cient;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class ESTest_Index_Delete {
    public static void main(String[] args) throws Exception {
        //创建客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        //删除索引
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("users");
        AcknowledgedResponse response = client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        //响应状态
        System.out.println(response.isAcknowledged());

        //关闭客户端
        client.close();
    }
}
