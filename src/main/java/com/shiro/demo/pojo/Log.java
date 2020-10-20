package com.shiro.demo.pojo;

/**
 * @Project demo
 * @Description: Log
 * @Author Du Yi Code
 * @Explain
 * @Date 2020-10-20 16:51
 */
public class Log {
    private int id;
    private int userid;
    private float prices;

    public Log() {
    }

    public Log(int id, int userid, float prices) {
        this.id = id;
        this.userid = userid;
        this.prices = prices;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public float getPrices() {
        return prices;
    }

    public void setPrices(float prices) {
        this.prices = prices;
    }
}
