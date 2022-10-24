package com.oxygen.clear_oxygen.PO;

import lombok.Data;

import java.time.LocalDateTime;

/**
 *  二级评论
 */
@Data
public class CommentSecond {
    /**
     *  二级评论id
     */
    private long id;

    /**
     *  一级评论id
     */
    private long firstId;

    /**
     *  用户id
     */
    private long userId;

    /**
     *  用户名称
     */
    private String name;

    /**
     *  头像路径
     */
    private String titleURL;

    /**
     *  评论内容
     */
    private String text;

    /**
     *  点赞数量
     */
    private int praiseNum;

    /**
     *  评论状态
     */
    private int status;

    /**
     *  创建时间
     */
    private LocalDateTime createTime;
}
