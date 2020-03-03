package com.rightmanagement.demo.entity;

import java.io.Serializable;

/**
 * 后台角色资源关系表(UmsRoleResourceRelation)实体类
 *
 * @author makejava
 * @since 2020-02-25 19:26:40
 */
public class UmsRoleResourceRelation implements Serializable {
    private static final long serialVersionUID = -81375914882311648L;
    
    private Long id;
    /**
    * 角色ID
    */
    private Long roleId;
    /**
    * 资源ID
    */
    private Long resourceId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

}