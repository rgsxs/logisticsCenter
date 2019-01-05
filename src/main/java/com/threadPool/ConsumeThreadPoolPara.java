package com.threadPool;

import java.io.Serializable;

/**
 * 线程参数类
 */
public class ConsumeThreadPoolPara implements Serializable {
    private int minPools=10;
    private int maxPools=100;
    private int checkThreadPeriod=5;

    public int getMinPools(){
    return minPools;
    }
    public int getMaxPools(){
    return maxPools;
    }
    public int getCheckThreadPeriod(){
    return checkThreadPeriod;
    }
    public void setMinPools(int minPools){
    this.minPools = minPools;
    }
    public void setMaxPools(int maxPools){
    this.maxPools = maxPools;
    }
    public void setCheckThreadPeriod(int checkThreadPeriod){
    this.checkThreadPeriod = checkThreadPeriod;
    }
    public String toString(){
    return minPools+" " + maxPools+" "+checkThreadPeriod;
    }
    public ConsumeThreadPoolPara() {
    }
    public static void main(String[] args) {
    ConsumeThreadPoolPara consumeThreadPool1 = new ConsumeThreadPoolPara();
    }

}
