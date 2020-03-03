package com.rightmanagement.demo.controller;

import com.rightmanagement.demo.entity.UmsAdminRoleRelation;
import com.rightmanagement.demo.service.UmsAdminRoleRelationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 后台用户和角色关系表(UmsAdminRoleRelation)表控制层
 *
 * @author makejava
 * @since 2020-02-25 19:24:57
 */
@RestController
@RequestMapping("umsAdminRoleRelation")
public class UmsAdminRoleRelationController {
    /**
     * 服务对象
     */
    @Resource
    private UmsAdminRoleRelationService umsAdminRoleRelationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UmsAdminRoleRelation selectOne(Long id) {
        return this.umsAdminRoleRelationService.queryById(id);
    }

}