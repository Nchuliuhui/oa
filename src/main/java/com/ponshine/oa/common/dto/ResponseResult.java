package com.ponshine.oa.common.dto;

import java.util.Arrays;

/**
 * @author liuhui
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO   后台响应参数类
 * @date
 */
public class ResponseResult {
    private int[] resultArray = new int[] { 0, 1 };// 请求结果集，0为失败、1为成功
    private int result;// 请求结果标志，0为失败、1为成功
    private String resultInfo;// 请求结果原因信息
    private Object data;// 返回数据，结构按照约定来组织


    @Override
    public String toString() {
        return "ResponseResult{" +
                "resultArray=" + Arrays.toString(resultArray) +
                ", result=" + result +
                ", resultInfo='" + resultInfo + '\'' +
                ", data=" + data +
                '}';
    }

    public int[] getResultArray() {
        return resultArray;
    }

    public void setResultArray(int[] resultArray) {
        this.resultArray = resultArray;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
