package com.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class ESTest_Index_Delete {
    public static void main(String[] args) throws IOException {
        // 创建ES客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );
        // 删除索引
        DeleteIndexRequest request = new DeleteIndexRequest("user");
        AcknowledgedResponse acknowledgedResponse = client.indices().delete(request,RequestOptions.DEFAULT);
        // 响应状态
        System.out.println(acknowledgedResponse.isAcknowledged());
        client.close();
    }
}
