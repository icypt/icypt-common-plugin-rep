package com.icypt.learn;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;

public class CreateConnection {
    public static void main(String[] args) {
        //创建低级客户端
        RestClient restClient = RestClient.builder(
                new HttpHost("localhost", 9200)).build();
        //指定数据映射规则
        ElasticsearchTransport elasticsearchTransport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

        //创建API客户端
        ElasticsearchClient client = new ElasticsearchClient(elasticsearchTransport);

        System.out.println(client);
    }
}
