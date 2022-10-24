package com.oxygen.clear_oxygen.PO;

import lombok.Data;

import java.time.LocalDateTime;

/**
 *  文章
 */
@Data
public class Story {

    /**
     *  文章id
     */
    private long id;

    /**
     *  作者id
     */
    private long userId;

    /**
     *  作者姓名
     */
    private String userName;

    /**
     *  文章类型
     */
    private int type;

    /**
     *  文章url
     */
    private String storyURL;

    /**
     *  文章标题
     */
    private String title;

    /**
     *  文章标题图片路径
     */
    private String titleImgURL;

    /**
     *  文章状态
     */
    private int status;

    /**
     *  创建时间
     */
    private LocalDateTime createTime;
}
