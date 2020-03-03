package com.rightmanagement.demo.service;

import com.rightmanagement.demo.entity.UmsRoleResourceRelation;
import java.util.List;

/**
 * 后台角色资源关系表(UmsRoleResourceRelation)表服务接口
 *
 * @author makejava
 * @since 2020-02-25 19:26:40
 */
public interface UmsRoleResourceRelationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsRoleResourceRelation queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UmsRoleResourceRelation> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param umsRoleResourceRelation 实例对象
     * @return 实例对象
     */
    UmsRoleResourceRelation insert(UmsRoleResourceRelation umsRoleResourceRelation);

    /**
     * 修改数据
     *
     * @param umsRoleResourceRelation 实例对象
     * @return 实例对象
     */
    UmsRoleResourceRelation update(UmsRoleResourceRelation umsRoleResourceRelation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}