package cn.itcast.yycg.system.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.itcast.yycg.base.dao.impl.BaseDaoImpl;
import cn.itcast.yycg.domain.po.SysDictInfo;
import cn.itcast.yycg.domain.po.SysDictType;
import cn.itcast.yycg.system.dao.SysDictInfoDao;
@Repository
public class SysDictInfoDaoImpl extends BaseDaoImpl<SysDictInfo> implements SysDictInfoDao {

	@Override
	/**
	 * 通过code查询对象
	 */
	public List<SysDictInfo> findAllByTypecode(String typecode) {
		DetachedCriteria dCriteria = DetachedCriteria.forClass(SysDictInfo.class);
		dCriteria.add(Restrictions.eq("sysDictType.typecode", typecode));
		return (List<SysDictInfo>) getHibernateTemplate().findByCriteria(dCriteria);
	}

}
