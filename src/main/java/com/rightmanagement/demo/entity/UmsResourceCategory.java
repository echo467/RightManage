package com.rightmanagement.demo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 资源分类表(UmsResourceCategory)实体类
 *
 * @author makejava
 * @since 2020-02-25 19:25:53
 */
public class UmsResourceCategory implements Serializable {
    private static final long serialVersionUID = -90691087721176835L;
    
    private Long id;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 分类名称
    */
    private String name;
    /**
    * 排序
    */
    private Integer sort;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

}