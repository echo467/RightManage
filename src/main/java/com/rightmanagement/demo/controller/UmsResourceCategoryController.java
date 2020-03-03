package com.rightmanagement.demo.controller;

import com.rightmanagement.demo.entity.UmsResourceCategory;
import com.rightmanagement.demo.service.UmsResourceCategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 资源分类表(UmsResourceCategory)表控制层
 *
 * @author makejava
 * @since 2020-02-25 19:25:53
 */
@RestController
@RequestMapping("umsResourceCategory")
public class UmsResourceCategoryController {
    /**
     * 服务对象
     */
    @Resource
    private UmsResourceCategoryService umsResourceCategoryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UmsResourceCategory selectOne(Long id) {
        return this.umsResourceCategoryService.queryById(id);
    }

}