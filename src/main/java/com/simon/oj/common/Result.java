package com.simon.oj.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String msg;
    private Object data;

    public Result() {
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
