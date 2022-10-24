package com.oxygen.clear_oxygen.PO;

import lombok.Data;
import java.time.LocalDateTime;

/**
 *  用户角色
 */
@Data
public class SysRole {

    /**
     *  角色id
     */
    private long roleId;

    /**
     *  角色名称
     */
    private String roleName;

    /**
     *  角色权限字符串
     */
    private String roleKey;

    /**
     *  显示顺序
     */
    private int roleSort;

    /**
     *  数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    private char dataScope;

    /**
     *  菜单树选线是否关联显示
     */
    private Byte menu_check_strictly;

    /**
     *  部门树选项是否关联显示
     */
    private Byte dept_check_strictly;

    /**
     *  角色状态
     */
    private char status;

    /**
     *  删除标志
     */
    private char del_flag;

    /**
     *  创建人
     */
    private String createBy;

    /**
     *  创建时间
     */
    private LocalDateTime createTime;

    /**
     *  更新人
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
