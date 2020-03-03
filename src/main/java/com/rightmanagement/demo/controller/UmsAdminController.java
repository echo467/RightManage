package com.rightmanagement.demo.controller;

import com.rightmanagement.demo.entity.UmsAdmin;
import com.rightmanagement.demo.service.UmsAdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 后台用户表(UmsAdmin)表控制层
 *
 * @author makejava
 * @since 2020-02-25 19:24:17
 */
@RestController
@RequestMapping("umsAdmin")
public class UmsAdminController {
    /**
     * 服务对象
     */
    @Resource
    private UmsAdminService umsAdminService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UmsAdmin selectOne(Long id) {
        return this.umsAdminService.queryById(id);
    }

}