package com.wqy.boot.common.dto;

/**
 * 返回给前端的数据
 *
 * @author wqy
 * @version 1.0 2020/11/13
 */
public class ResultDTO<T> {

    /**
     * code
     */
    private Integer code;

    /**
     * 信息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    public ResultDTO() {
    }

    public static <T> ResultDTO<T> failure(String msg, T data) {
        ResultDTO<T> resultDTO = new ResultDTO<>();
        resultDTO.setCode(ResultCode.FAILURE.getCode());
        resultDTO.setMsg(msg == null ? "" : msg);
        resultDTO.setData(data);
        return resultDTO;
    }

    public static <T> ResultDTO<T> success(String msg, T data) {
        ResultDTO<T> resultDTO = new ResultDTO<>();
        resultDTO.setCode(ResultCode.SUCCESS.getCode());
        resultDTO.setMsg(msg == null ? "" : msg);
        resultDTO.setData(data);
        return resultDTO;
    }

    public enum ResultCode {

        /**
         * 成功
         */
        SUCCESS(0),

        /**
         * 失败
         */
        FAILURE(1),

        /**
         * 警告
         */
        WARNING(2);

        private final int code;

        ResultCode(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
