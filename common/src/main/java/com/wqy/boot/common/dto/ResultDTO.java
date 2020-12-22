package com.wqy.boot.common.dto;

/**
 * 返回给前端的数据
 *
 * @author wqy
 * @version 1.0 2020/11/13
 */
public class ResultDTO<T> {

    //code
    private int code;

    //信息
    private String msg;

    //数据
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultDTO(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultDTO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultDTO() {}

    public enum ResultCode {

        SUCCESS(0),

        FAILURE(1),

        WARNING(2);

        private int code;

        ResultCode(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

    }
}
