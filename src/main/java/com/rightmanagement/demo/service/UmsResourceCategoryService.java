package com.rightmanagement.demo.service;

import com.rightmanagement.demo.entity.UmsResourceCategory;
import java.util.List;

/**
 * 资源分类表(UmsResourceCategory)表服务接口
 *
 * @author makejava
 * @since 2020-02-25 19:25:53
 */
public interface UmsResourceCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsResourceCategory queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UmsResourceCategory> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param umsResourceCategory 实例对象
     * @return 实例对象
     */
    UmsResourceCategory insert(UmsResourceCategory umsResourceCategory);

    /**
     * 修改数据
     *
     * @param umsResourceCategory 实例对象
     * @return 实例对象
     */
    UmsResourceCategory update(UmsResourceCategory umsResourceCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}