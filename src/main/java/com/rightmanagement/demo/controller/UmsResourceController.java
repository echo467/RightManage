package com.rightmanagement.demo.controller;

import com.rightmanagement.demo.entity.UmsResource;
import com.rightmanagement.demo.service.UmsResourceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 后台资源表(UmsResource)表控制层
 *
 * @author makejava
 * @since 2020-02-25 19:25:32
 */
@RestController
@RequestMapping("umsResource")
public class UmsResourceController {
    /**
     * 服务对象
     */
    @Resource
    private UmsResourceService umsResourceService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UmsResource selectOne(Long id) {
        return this.umsResourceService.queryById(id);
    }

}