package cn.itcast.yycg.base.dao.impl;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.yycg.base.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class<T> clazz;

	public BaseDaoImpl() {
		// 获取父类的泛型
		Type type = this.getClass().getGenericSuperclass();
		// 判断是否属于参数化的类型
		if (type instanceof ParameterizedType) {
			// 将type转换成参数化的类型
			ParameterizedType param = (ParameterizedType) type;
			// 获取泛型
			Type[] types = param.getActualTypeArguments();
			// 赋值给class
			clazz = (Class<T>) types[0];
		}

	}

	/**
	 * 设置hibernate模板
	 * 
	 * @param hibernateTemplate
	 */
	@Autowired
	public void setHT(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate);

	}

	/**
	 * 删除
	 */
	@Override
	public void delete(T entity) {
		getHibernateTemplate().delete(entity);
	}

	/**
	 * 保存
	 */
	@Override
	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}

	/**
	 * 更新
	 */
	@Override
	public void update(T entity) {
		getHibernateTemplate().update(entity);

	}

	/**
	 * 根据id查询
	 */
	@Override
	public T findById(Serializable id) {
		return this.getHibernateTemplate().get(clazz, id);
	}

	/**
	 * 查询所有
	 */
	@Override
	public List<T> findAll() {
		return (List<T>) this.getHibernateTemplate().find("from " + clazz.getName());
	}

}
