package cn.itcast.yycg.user.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.itcast.yycg.base.dao.impl.BaseDaoImpl;
import cn.itcast.yycg.domain.po.SysUser;
import cn.itcast.yycg.user.dao.SysUserDao;
import cn.itcast.yycg.user.dao.query.SysUserQuery;

/**
 * 系统用户实现类
 * 
 * @author xgh
 *
 */

@Repository
public class SysUserDaoImpl extends BaseDaoImpl<SysUser> implements SysUserDao {

	/**
	 * 查询所有
	 */
	@Override
	public List<SysUser> queryuser(SysUserQuery sysUserQuery) {
		// 创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(SysUser.class);
		List<SysUser> list = (List<SysUser>) getHibernateTemplate().findByCriteria(dc);
		return list;
	}

	@Override
	/**
	 * 查询数据的总记录数
	 */
	public int getTotalRecord(SysUserQuery sysUserQuery) {
		// 创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(SysUser.class);
		dc.setProjection(Projections.rowCount());
		if (sysUserQuery!=null) {
			
		
		if (StringUtils.isNotBlank(sysUserQuery.getUsercode())) {
			dc.add(Restrictions.like("usercode",sysUserQuery.getUsercode() , MatchMode.ANYWHERE));			
		}
		//判断用户名是否为空,如果不为空,添加条件
		if (StringUtils.isNotBlank(sysUserQuery.getUsername())) {
			dc.add(Restrictions.like("username",sysUserQuery.getUsername() , MatchMode.ANYWHERE));			
		}
		if (sysUserQuery.getSysDictInfoByGroupid()!=null&&StringUtils.isNotBlank(sysUserQuery.getSysDictInfoByGroupid().getId())) {
			dc.add(Restrictions.eq("sysDictInfoByGroupid", sysUserQuery.getSysDictInfoByGroupid()));
		}
		}
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		return list.get(0).intValue();
	}

	@Override
	/**
	 * 分页查询
	 */
	public List<SysUser> findAll(SysUserQuery sysUserQuery, int startIndex, int pageSize) {
		//创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(SysUser.class);
		//判断用户账号是否为空,如果不为空,添加条件
		if (sysUserQuery!=null) {
			
		
		if (StringUtils.isNotBlank(sysUserQuery.getUsercode())) {
			dc.add(Restrictions.like("usercode",sysUserQuery.getUsercode() , MatchMode.ANYWHERE));			
		}
		//判断用户名是否为空,如果不为空,添加条件
		if (StringUtils.isNotBlank(sysUserQuery.getUsername())) {
			dc.add(Restrictions.like("username",sysUserQuery.getUsername() , MatchMode.ANYWHERE));			
		}
		if (sysUserQuery.getSysDictInfoByGroupid()!=null&&StringUtils.isNotBlank(sysUserQuery.getSysDictInfoByGroupid().getId())) {
			dc.add(Restrictions.eq("sysDictInfoByGroupid.id", sysUserQuery.getSysDictInfoByGroupid().getId()));
		}
		}
		
		return (List<SysUser>) this.getHibernateTemplate().findByCriteria(dc, startIndex, pageSize);
	}

}
