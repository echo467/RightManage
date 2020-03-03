package com.rightmanagement.demo.controller;

import com.rightmanagement.demo.entity.UmsRoleMenuRelation;
import com.rightmanagement.demo.service.UmsRoleMenuRelationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 后台角色菜单关系表(UmsRoleMenuRelation)表控制层
 *
 * @author makejava
 * @since 2020-02-25 19:26:24
 */
@RestController
@RequestMapping("umsRoleMenuRelation")
public class UmsRoleMenuRelationController {
    /**
     * 服务对象
     */
    @Resource
    private UmsRoleMenuRelationService umsRoleMenuRelationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UmsRoleMenuRelation selectOne(Long id) {
        return this.umsRoleMenuRelationService.queryById(id);
    }

}