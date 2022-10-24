package com.oxygen.clear_oxygen.PO;

import lombok.Data;

import java.time.LocalDateTime;

/**
 *  动态
 */
@Data
public class Dynamic {

    /**
     *  动态id
     */
    private long id;

    /**
     *  作者id
     */
    private long userId;

    /**
     *  图片url
     */
    private String img;

    /**
     *  动态内容
     */
    private String content;

    /**
     *  点赞数量
     */
    private int praiseNum;

    /**
     *  收藏数量
     */
    private int collect;

    /**
     *  收藏状态
     */
    private int status;

    /**
     *  创建时间
     */
    private LocalDateTime createTime;
}
