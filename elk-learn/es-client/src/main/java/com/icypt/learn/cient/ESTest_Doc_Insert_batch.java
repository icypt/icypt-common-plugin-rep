package com.icypt.learn.cient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icypt.learn.vo.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

public class ESTest_Doc_Insert_batch {
    public static void main(String[] args) throws Exception{
        //创建客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        //批量插入数据
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(new IndexRequest().index("users").id("1001").source(XContentType.JSON, "name", "张三", "sex", "男", "age", 10));
        bulkRequest.add(new IndexRequest().index("users").id("1002").source(XContentType.JSON, "name", "李四", "sex", "女", "age", 20));
        bulkRequest.add(new IndexRequest().index("users").id("1003").source(XContentType.JSON, "name", "王五", "sex", "男", "age", 30));
        bulkRequest.add(new IndexRequest().index("users").id("1004").source(XContentType.JSON, "name", "赵赵", "sex", "男", "age", 45));
        bulkRequest.add(new IndexRequest().index("users").id("1005").source(XContentType.JSON, "name", "晨晨", "sex", "女", "age", 18));
        bulkRequest.add(new IndexRequest().index("users").id("1006").source(XContentType.JSON, "name", "果果", "sex", "男", "age", 20));

        BulkResponse bulk = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulk.getTook());
        System.out.println(bulk.getItems());

        //关闭客户端
        client.close();
    }
}
