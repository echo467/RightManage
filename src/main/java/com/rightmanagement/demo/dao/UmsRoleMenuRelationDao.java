package com.rightmanagement.demo.dao;

import com.rightmanagement.demo.entity.UmsRoleMenuRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 后台角色菜单关系表(UmsRoleMenuRelation)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-25 19:26:24
 */
@Mapper
public interface UmsRoleMenuRelationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsRoleMenuRelation queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UmsRoleMenuRelation> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param umsRoleMenuRelation 实例对象
     * @return 对象列表
     */
    List<UmsRoleMenuRelation> queryAll(UmsRoleMenuRelation umsRoleMenuRelation);

    /**
     * 新增数据
     *
     * @param umsRoleMenuRelation 实例对象
     * @return 影响行数
     */
    int insert(UmsRoleMenuRelation umsRoleMenuRelation);

    /**
     * 修改数据
     *
     * @param umsRoleMenuRelation 实例对象
     * @return 影响行数
     */
    int update(UmsRoleMenuRelation umsRoleMenuRelation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}