package com.oxygen.clear_oxygen.PO;

import lombok.Data;

import java.time.LocalDateTime;

/**
 *  设备信息
 */
@Data
public class Device {

    /**
     *  设备id
     */
    private long id;

    /**
     *  用户id
     */
    private long userId;

    /**
     *  设备状态
     */
    private int status;

    /**
     *  设备模式
     */
    private int pattern;

    /**
     *  土壤湿度
     */
    private double humidity;

    /**
     *  养分含量
     */
    private double nutrient;

    /**
     *  位置
     */
    private String location;

    /**
     *  指标1
     */
    private String index1;

    /**
     *  指标2
     */
    private String index2;

    /**
     *  指标3
     */
    private String index3;

    /**
     *  参数1
     */
    private String parameter1;

    /**
     *  参数2
     */
    private String parameter2;

    /**
     *  参数3
     */
    private String parameter3;

    /**
     *  创建时间
     */
    private LocalDateTime createTime;
}
