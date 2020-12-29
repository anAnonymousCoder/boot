package com.wqy.boot.core.dao;

import com.wqy.boot.core.dao.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * 对BaseRepository进一步封装，抽离出需要的方法，不需要全部实现
 *
 * @param <T>  实体类型
 * @param <ID> 主键类型
 * @author wqy
 * @version 1.0 2020/10/9
 */

public interface BaseDao<T, ID, R extends BaseRepository<T, ID>> {

    /**
     * 通过id查找实体对象
     *
     * @param id 实体id
     * @return 实体
     */
    T findById(ID id);

    /**
     * 查找所有实体
     *
     * @return 实体列表
     */
    List<T> findAll();

    /**
     * 保存实体
     *
     * @param entity 实体
     * @return 实体子类对象
     */
    <S extends T> S save(S entity);

    /**
     * 保存多个实体
     *
     * @param entities 实体集合
     * @return 实体子类对象列表
     */
    <S extends T> List<S> saveAll(Iterable<S> entities);

    /**
     * 通过多个id查找多个实体
     *
     * @param ids id集合
     * @return 实体列表
     */
    List<T> findAllById(Iterable<ID> ids);

    /**
     * 根据id删除实体
     *
     * @param id 实体id
     */
    void deleteById(ID id);

    /**
     * 根据实体删除对应实体
     *
     * @param entity 实体
     */
    void deleteByEntity(T entity);

    /**
     * 删除一组实体
     *
     * @param entities 实体集合
     */
    void deleteAllByEntity(Iterable<? extends T> entities);

    /**
     * 返回实体的分页信息
     *
     * @param pageable 分页接口
     * @param spec     Specification
     * @return 实体分页信息
     */
    Page<T> page(Pageable pageable, Specification<T> spec);

    /**
     * 查找实体列表
     *
     * @param spec Specification
     * @return 实体列表
     */
    List<T> list(Specification<T> spec);
}
