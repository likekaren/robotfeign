package com.karen.robotfeign.bean;

public class RobotVo {
    private PageQuery pageQuery;
    private Robot robot;
    private RobotSolrVO robotSolrVO;

    public PageQuery getPageQuery() {
        return pageQuery;
    }

    public void setPageQuery(PageQuery pageQuery) {
        this.pageQuery = pageQuery;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public RobotSolrVO getRobotSolrVO() {
        return robotSolrVO;
    }

    public void setRobotSolrVO(RobotSolrVO robotSolrVO) {
        this.robotSolrVO = robotSolrVO;
    }
}
