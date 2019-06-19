package com.karen.robotfeign.controller;

import com.github.pagehelper.PageInfo;
import com.karen.robotfeign.bean.PageQuery;
import com.karen.robotfeign.bean.RobotSolrVO;
import com.karen.robotfeign.bean.RobotVo;
import com.karen.robotfeign.bean.Robot;
import com.karen.robotfeign.result.DataGridResultInfo;
import com.karen.robotfeign.service.RobotSolrClient;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class RobotController {


    @Autowired(required = false)
    private RobotSolrClient robotSolrClient;

    @RequestMapping("/rob")
    public String querybot() throws Exception{
        return "/rob";
    }

    @GetMapping("/main")
    public String bot() throws Exception{
        return "/rob/list";
    }

    @RequestMapping("/robotlist")
    public @ResponseBody
    DataGridResultInfo querystandard_result(RobotVo robotVo,
                                            Integer rows, Integer page) throws Exception {

        // 非空校验
        robotVo = robotVo != null ? robotVo
                : new RobotVo();
        // 获取 standardCustom
        RobotSolrVO robot = robotVo.getRobotSolrVO();
        // 非空 校验
        robot = robot != null ? robot
                : new RobotSolrVO();
        //分页支持
        PageQuery pageQuery = new PageQuery(page, rows);
        robotVo.setPageQuery(pageQuery);

        //得到前台数据
        String str = robot.getTotal();

        String fq = "total:*";
        if(!(null == str || str.length() == 0 || "undefined".equals(str))){
            fq = "total:"+ str;
        }

        //调用solr查询微服务
        ArrayList list = robotSolrClient.solrQuery(fq);
        for(Object o:list){
            System.out.println(o);
        }

        PageInfo<Robot> pageInfo = new PageInfo<>(list);
        int total = (int) pageInfo.getTotal();
        DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
        // 填充 total
        dataGridResultInfo.setTotal(total);
        // 填充 rows
        dataGridResultInfo.setRows(list);
        return dataGridResultInfo;
    }
}
