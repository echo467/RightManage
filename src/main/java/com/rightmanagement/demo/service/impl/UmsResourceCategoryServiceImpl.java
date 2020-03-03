package com.rightmanagement.demo.service.impl;

import com.rightmanagement.demo.entity.UmsResourceCategory;
import com.rightmanagement.demo.dao.UmsResourceCategoryDao;
import com.rightmanagement.demo.service.UmsResourceCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 资源分类表(UmsResourceCategory)表服务实现类
 *
 * @author makejava
 * @since 2020-02-25 19:25:53
 */
@Service("umsResourceCategoryService")
public class UmsResourceCategoryServiceImpl implements UmsResourceCategoryService {
    @Resource
    private UmsResourceCategoryDao umsResourceCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UmsResourceCategory queryById(Long id) {
        return this.umsResourceCategoryDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UmsResourceCategory> queryAllByLimit(int offset, int limit) {
        return this.umsResourceCategoryDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param umsResourceCategory 实例对象
     * @return 实例对象
     */
    @Override
    public UmsResourceCategory insert(UmsResourceCategory umsResourceCategory) {
        this.umsResourceCategoryDao.insert(umsResourceCategory);
        return umsResourceCategory;
    }

    /**
     * 修改数据
     *
     * @param umsResourceCategory 实例对象
     * @return 实例对象
     */
    @Override
    public UmsResourceCategory update(UmsResourceCategory umsResourceCategory) {
        this.umsResourceCategoryDao.update(umsResourceCategory);
        return this.queryById(umsResourceCategory.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.umsResourceCategoryDao.deleteById(id) > 0;
    }
}