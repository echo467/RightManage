package com.rightmanagement.demo.dao;

import com.rightmanagement.demo.entity.UmsResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 后台资源表(UmsResource)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-25 19:25:32
 */
@Mapper
public interface UmsResourceDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsResource queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UmsResource> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param umsResource 实例对象
     * @return 对象列表
     */
    List<UmsResource> queryAll(UmsResource umsResource);

    /**
     * 新增数据
     *
     * @param umsResource 实例对象
     * @return 影响行数
     */
    int insert(UmsResource umsResource);

    /**
     * 修改数据
     *
     * @param umsResource 实例对象
     * @return 影响行数
     */
    int update(UmsResource umsResource);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}