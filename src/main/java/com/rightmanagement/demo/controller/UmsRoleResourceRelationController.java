package com.rightmanagement.demo.controller;

import com.rightmanagement.demo.entity.UmsRoleResourceRelation;
import com.rightmanagement.demo.service.UmsRoleResourceRelationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 后台角色资源关系表(UmsRoleResourceRelation)表控制层
 *
 * @author makejava
 * @since 2020-02-25 19:26:40
 */
@RestController
@RequestMapping("umsRoleResourceRelation")
public class UmsRoleResourceRelationController {
    /**
     * 服务对象
     */
    @Resource
    private UmsRoleResourceRelationService umsRoleResourceRelationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UmsRoleResourceRelation selectOne(Long id) {
        return this.umsRoleResourceRelationService.queryById(id);
    }

}