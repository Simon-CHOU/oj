package com.simon.oj.common.statistics.basic;

import java.util.List;

/**
 * 包含基本的计算方法
 */
public abstract class BasicStatistics {
    public <T>T max(List<T> list){
        T avgValue = null;
        return avgValue;
    }
    public <T>T min(List<T> list){
        T avgValue = null;
        return avgValue;
    }
    public <T>T mid(List<T> list){
        T avgValue = null;
        return avgValue;
    }
    /**
     * 计算平均值
     * @param list
     * @param <T>
     * @return
     */
    public <T>T avg(List<T> list){
        T avgValue = null;
        return avgValue;
    }

    /**
     * 第前25%的数值
     * @param list
     * @param <T>
     * @return
     */
    public <T>T Q1(List<T> list){
        T avgValue = null;
        return avgValue;
    }

    /**
     * 第前75%的数值
     * @param list
     * @param <T>
     * @return
     */
    public <T>T Q3(List<T> list){
        T avgValue = null;
        return avgValue;
    }

    /**
     * 大于x的比例
     * @param list
     * @param x
     * @param <T>
     * @return
     */
    public <T> Double ratioAbove(List<T> list,Integer x){
        T avgValue = null;
        return 0.0;
    }

    /**
     * 小于x的比例
     * @param list
     * @param x
     * @param <T>
     * @return
     */
    public <T>Double ratioBelow(List<T> list,Integer x){
        T avgValue = null;
        return 0.0;
    }


}
