package com.karen.robotfeign.service;

import com.karen.robotfeign.result.ResultInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@FeignClient("solr-eureka")
public interface RobotSolrClient {
//    ResultInfo importAllRobots() throws Exception;

    @GetMapping("/robotlist")
    ArrayList solrQuery(String str) throws Exception;
//    ResultInfo solrDelete() throws Exception;
}
