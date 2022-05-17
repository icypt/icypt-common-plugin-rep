package com.icypt.learn;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.GetIndexResponse;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import jakarta.json.Json;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;

public class IndexOperation {
    public static void main(String[] args) throws Exception{
        //创建低级客户端
        RestClient restClient = RestClient.builder(
                new HttpHost("localhost", 9200)).build();
        //指定数据映射规则
        ElasticsearchTransport elasticsearchTransport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

        //创建API客户端
        ElasticsearchClient client = new ElasticsearchClient(elasticsearchTransport);

        //创建索引
//        client.indices().create(c -> c.index("blog"));

        //查询索引
        GetIndexResponse indexResponse = client.indices().get(c -> c.index("blog"));

        //获取索引返回数据
        System.out.println(indexResponse.result().get("blog").settings().index().uuid());

        //删除索引
        client.indices().delete(c -> c.index("blog"));

        //关闭客户端
        restClient.close();
    }
}
