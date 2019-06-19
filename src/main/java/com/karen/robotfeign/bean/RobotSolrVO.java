package com.karen.robotfeign.bean;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "mesrobot")
@Data
public class RobotSolrVO {
    @Field("id")
    private String id;
    @Field("total")
    private String total;
    @Field("rname")
    private String rname;
    @Field("status")
    private String status;
    @Field("rnote")
    private String rnote;
    @Field("ex1")
    private String ex1;
    @Field("ex2")
    private String ex2;
    @Field("ex3")
    private String ex3;
    @Field("ex4")
    private String ex4;
    @Field("ex5")
    private String ex5;
    @Field("ex6")
    private String ex6;
}
