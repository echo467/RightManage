package com.rightmanagement.demo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 后台菜单表(UmsMenu)实体类
 *
 * @author makejava
 * @since 2020-02-25 19:25:17
 */
public class UmsMenu implements Serializable {
    private static final long serialVersionUID = -92713734178562783L;
    
    private Long id;
    /**
    * 父级ID
    */
    private Long parentId;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 菜单名称
    */
    private String title;
    /**
    * 菜单级数
    */
    private Integer level;
    /**
    * 菜单排序
    */
    private Integer sort;
    /**
    * 前端名称
    */
    private String name;
    /**
    * 前端图标
    */
    private String icon;
    /**
    * 前端隐藏
    */
    private Integer hidden;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getHidden() {
        return hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

}