package com.liu.coder.pojo;

/**
 * Created by Neal on 17.7.6.
 */
public class Job {
    private String jodId;//UUID生成
    private String jobTitle;
    private Integer minSalary;
    private Integer maxSalary;

    public Job() {
    }

    public String getJodId() {
        return jodId;
    }

    public void setJodId(String jodId) {
        this.jodId = jodId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }

    public Integer getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }
}
