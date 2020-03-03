package com.rightmanagement.demo.entity;

import java.io.Serializable;

/**
 * 后台用户和角色关系表(UmsAdminRoleRelation)实体类
 *
 * @author makejava
 * @since 2020-02-25 19:24:57
 */
public class UmsAdminRoleRelation implements Serializable {
    private static final long serialVersionUID = 387650400790319509L;
    
    private Long id;
    
    private Long adminId;
    
    private Long roleId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}