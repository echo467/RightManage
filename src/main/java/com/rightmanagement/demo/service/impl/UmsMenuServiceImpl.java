package com.rightmanagement.demo.service.impl;

import com.rightmanagement.demo.entity.UmsMenu;
import com.rightmanagement.demo.dao.UmsMenuDao;
import com.rightmanagement.demo.service.UmsMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 后台菜单表(UmsMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-02-25 19:25:17
 */
@Service("umsMenuService")
public class UmsMenuServiceImpl implements UmsMenuService {
    @Resource
    private UmsMenuDao umsMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UmsMenu queryById(Long id) {
        return this.umsMenuDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UmsMenu> queryAllByLimit(int offset, int limit) {
        return this.umsMenuDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param umsMenu 实例对象
     * @return 实例对象
     */
    @Override
    public UmsMenu insert(UmsMenu umsMenu) {
        this.umsMenuDao.insert(umsMenu);
        return umsMenu;
    }

    /**
     * 修改数据
     *
     * @param umsMenu 实例对象
     * @return 实例对象
     */
    @Override
    public UmsMenu update(UmsMenu umsMenu) {
        this.umsMenuDao.update(umsMenu);
        return this.queryById(umsMenu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.umsMenuDao.deleteById(id) > 0;
    }
}