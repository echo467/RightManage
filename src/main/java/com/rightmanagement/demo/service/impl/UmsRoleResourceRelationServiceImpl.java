package com.rightmanagement.demo.service.impl;

import com.rightmanagement.demo.entity.UmsRoleResourceRelation;
import com.rightmanagement.demo.dao.UmsRoleResourceRelationDao;
import com.rightmanagement.demo.service.UmsRoleResourceRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 后台角色资源关系表(UmsRoleResourceRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-02-25 19:26:40
 */
@Service("umsRoleResourceRelationService")
public class UmsRoleResourceRelationServiceImpl implements UmsRoleResourceRelationService {
    @Resource
    private UmsRoleResourceRelationDao umsRoleResourceRelationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UmsRoleResourceRelation queryById(Long id) {
        return this.umsRoleResourceRelationDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UmsRoleResourceRelation> queryAllByLimit(int offset, int limit) {
        return this.umsRoleResourceRelationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param umsRoleResourceRelation 实例对象
     * @return 实例对象
     */
    @Override
    public UmsRoleResourceRelation insert(UmsRoleResourceRelation umsRoleResourceRelation) {
        this.umsRoleResourceRelationDao.insert(umsRoleResourceRelation);
        return umsRoleResourceRelation;
    }

    /**
     * 修改数据
     *
     * @param umsRoleResourceRelation 实例对象
     * @return 实例对象
     */
    @Override
    public UmsRoleResourceRelation update(UmsRoleResourceRelation umsRoleResourceRelation) {
        this.umsRoleResourceRelationDao.update(umsRoleResourceRelation);
        return this.queryById(umsRoleResourceRelation.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.umsRoleResourceRelationDao.deleteById(id) > 0;
    }
}