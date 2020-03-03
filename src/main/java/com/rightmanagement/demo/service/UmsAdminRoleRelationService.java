package com.rightmanagement.demo.service;

import com.rightmanagement.demo.entity.UmsAdminRoleRelation;
import java.util.List;

/**
 * 后台用户和角色关系表(UmsAdminRoleRelation)表服务接口
 *
 * @author makejava
 * @since 2020-02-25 19:24:57
 */
public interface UmsAdminRoleRelationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsAdminRoleRelation queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UmsAdminRoleRelation> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param umsAdminRoleRelation 实例对象
     * @return 实例对象
     */
    UmsAdminRoleRelation insert(UmsAdminRoleRelation umsAdminRoleRelation);

    /**
     * 修改数据
     *
     * @param umsAdminRoleRelation 实例对象
     * @return 实例对象
     */
    UmsAdminRoleRelation update(UmsAdminRoleRelation umsAdminRoleRelation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}