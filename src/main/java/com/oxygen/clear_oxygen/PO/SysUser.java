package com.oxygen.clear_oxygen.PO;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

/**
 * 用户实体类
 */
@Data
public class SysUser {

    /**
     *  用户id
     */
    private long userId;

    /**
     *  账号
     */
    private String userName;

    /**
     *  用户名
     */
    private String nickName;

    /**
     *  用户类型
     */
    private int userType;

    /**
     *  手机号
     */
    private String phoneNumber;

    /**
     *  性别
     */
    private char sex;

    /**
     *  头像地址
     */
    private String avatar;

    /**
     *  密码
     */
    private String password;

    /**
     *  账号状态
     */
    private char status;

    /**
     *  删除标志
     */
    private char delFlag;

    /**
     *  登录ip
     */
    private String loginIp;

    /**
     *  登录日期
     */
    private LocalDateTime loginDate;

    /**
     *  创建者
     */
    private String createBy;

    /**
     *  创建时间
     */
    private LocalDateTime createTime;

    /**
     *  更新着
     */
    private String updateBy;

    /**
     *  更新时间
     */
    private LocalDateTime updateTime;

    /**
     *  备注
     */
    private String remark;
}
