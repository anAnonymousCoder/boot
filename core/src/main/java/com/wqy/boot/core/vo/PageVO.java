package com.wqy.boot.core.vo;

import java.util.List;

/**
 * 返回给前端的分页数据
 *
 * @param <T>
 * @author wqy
 * @version 1.0 2020/11/14
 */
public class PageVO<T> {

    public PageVO() {

    }

    //code
    private int code = 0;

    //信息
    private String msg = "";

    //记录数
    private long count;

    //分页记录
    private List<T> data;

    public PageVO(long count, List<T> data) {
        this.count = count;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
