package com.liu.coder.pojo;

import java.util.Date;

/**
 * Created by Neal on 17.7.7.
 */
public class Emp {
    private Integer empId;
    private String empName;
    private String email;
    private String phoneNum;
    private Date hireDate;
    private String jobId;
    private Double salary;
    private Integer deptId;

    public Emp() {
    }

    public Emp(String empName, String email, String phoneNum, Date hireDate, String jobId, Double salary, Integer deptId) {
        this.empName = empName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.hireDate = hireDate;
        this.jobId = jobId;
        this.salary = salary;
        this.deptId = deptId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {this.empName = empName;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}
