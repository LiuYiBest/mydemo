package com.liu.coder.utils;


import java.util.List;

/**
 * Created by Neal on 17.3.30.
 */
public class Page<T> {

    private Integer size;//在 service 里通过配置文件注入值，然后赋给 size
    private Integer total;
    private Integer maxPage;
    private Integer currPage;
    private List<T> rows;
    private Integer begin;
    /*private Integer end;*/    // Oracle 数据库分页需要 end

    public Page() {
    }

    /**
     * maxPage 的值直接由 size 和 total 获得
     *
     * @return
     */
    public Integer getMaxPage() {
        if (size != 0) {
            maxPage = total % size == 0 ? total / size : total / size + 1;
        }
        return maxPage;
    }

    /**
     * begin 的值直接由 currPage 和 size 获得
     *
     * @return
     */
    public Integer getBegin() {
        return (currPage - 1) * size;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
