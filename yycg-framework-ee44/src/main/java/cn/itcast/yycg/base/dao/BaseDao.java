package cn.itcast.yycg.base.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	/**
	 * 删除
	 */
	public void delete(T entity);

	/**
	 * 保存
	 * 
	 * @param enity
	 */
	public void save(T entity);

	/**
	 * 更新
	 * 
	 * @param enity
	 */
	public void update(T entity);

	/**
	 * 根据id查找
	 * 
	 * @param id
	 * @return
	 */
	public T findById(Serializable id);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<T> findAll();

}
