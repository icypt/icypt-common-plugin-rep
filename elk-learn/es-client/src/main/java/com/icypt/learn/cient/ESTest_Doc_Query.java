package com.icypt.learn.cient;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

public class ESTest_Doc_Query {
    public static void main(String[] args) throws Exception {
        //创建客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        //1、查询全量数据，matchAllQuery
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("users");
//        searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
//
//        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for(SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        //2、条件查询，matchAllQuery
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("users");
//        searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age", 20)));
//
//        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for(SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        //3、分页查询，from ,size
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("users");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        builder.from(2);
//        builder.size(2);
//        searchRequest.source(builder);
//
//        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for(SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        //4、查询排序，sort
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("users");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        builder.sort("age", SortOrder.DESC);
//        searchRequest.source(builder);
//
//        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for(SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        //5、字段过滤，fetchSource
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("users");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        String [] includes = {"name"};
//        String [] excludes = {};
//        builder.fetchSource(includes, excludes);
//        searchRequest.source(builder);
//
//        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for(SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        //6、组合查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("users");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//
//        BoolQueryBuilder queryBuilder = new BoolQueryBuilder();
////        queryBuilder.must(QueryBuilders.matchQuery("age", 20));
////        queryBuilder.must(QueryBuilders.matchQuery("sex", "女"));
//        queryBuilder.should(QueryBuilders.matchQuery("age", 20));
//        queryBuilder.should(QueryBuilders.matchQuery("age", 18));
//        builder.query(queryBuilder);
//        searchRequest.source(builder);
//
//        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for(SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        //7、范围查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("users");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//
//        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("age");
//        rangeQueryBuilder.gte(10);
//        rangeQueryBuilder.lte(20);
//        builder.query(rangeQueryBuilder);
//        searchRequest.source(builder);
//
//        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for(SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }


        //8、模糊查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("users");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//
//        FuzzyQueryBuilder fuzzyQueryBuilder = QueryBuilders.fuzzyQuery("name", "张三").fuzziness(Fuzziness.ONE);
//        builder.query(fuzzyQueryBuilder);
//        searchRequest.source(builder);
//
//        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for(SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        //9、高亮查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("users");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//
//        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", "张三");
//
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        highlightBuilder.preTags("<font color='red'>");
//        highlightBuilder.postTags("</font>");
//        highlightBuilder.field("name");
//        builder.highlighter(highlightBuilder);
//        builder.query(matchQueryBuilder);
//        searchRequest.source(builder);
//
//        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for(SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//            System.out.println(hit.getHighlightFields());
//        }

        //10、聚合查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("users");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//
//        AggregationBuilder aggregationBuilder = AggregationBuilders.max("maxAge").field("age");
//        builder.aggregation(aggregationBuilder);
//
//        searchRequest.source(builder);
//        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(JSON.toJSONString(response));
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        //11、分组查询
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("users");
        SearchSourceBuilder builder = new SearchSourceBuilder();

        AggregationBuilder aggregationBuilder = AggregationBuilders.terms("ageGroup").field("age");
        builder.aggregation(aggregationBuilder);

        searchRequest.source(builder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(JSON.toJSONString(response));
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());

        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }


        //关闭客户端
        client.close();
    }
}
