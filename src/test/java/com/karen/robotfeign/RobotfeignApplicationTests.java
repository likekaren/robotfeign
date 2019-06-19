package com.karen.robotfeign;

import com.karen.robotfeign.service.RobotSolrClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableDiscoveryClient
@EnableFeignClients
public class RobotfeignApplicationTests {

    @Autowired(required = false)
    private RobotSolrClient robotSolrClient;
    @Test
    public void contextLoads() {
    }

    @Test
    public void testsolr() throws Exception {

        ArrayList list = robotSolrClient.solrQuery("停止，不正常");

        for(Object o : list){
            System.out.println(o);
        }

    }

}
