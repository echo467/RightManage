package com.rightmanagement.demo.dao;

import com.rightmanagement.demo.entity.UmsRoleResourceRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 后台角色资源关系表(UmsRoleResourceRelation)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-25 19:26:40
 */
@Mapper
public interface UmsRoleResourceRelationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsRoleResourceRelation queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UmsRoleResourceRelation> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param umsRoleResourceRelation 实例对象
     * @return 对象列表
     */
    List<UmsRoleResourceRelation> queryAll(UmsRoleResourceRelation umsRoleResourceRelation);

    /**
     * 新增数据
     *
     * @param umsRoleResourceRelation 实例对象
     * @return 影响行数
     */
    int insert(UmsRoleResourceRelation umsRoleResourceRelation);

    /**
     * 修改数据
     *
     * @param umsRoleResourceRelation 实例对象
     * @return 影响行数
     */
    int update(UmsRoleResourceRelation umsRoleResourceRelation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}