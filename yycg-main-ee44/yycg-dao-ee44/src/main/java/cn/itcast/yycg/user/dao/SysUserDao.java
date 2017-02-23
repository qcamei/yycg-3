package cn.itcast.yycg.user.dao;

import java.util.List;

import cn.itcast.yycg.base.dao.BaseDao;
import cn.itcast.yycg.domain.po.SysUser;
import cn.itcast.yycg.user.dao.query.SysUserQuery;

/**
 * 系统对象公共接口
 * 
 * @author xgh
 *
 */
public interface SysUserDao extends BaseDao<SysUser>{

	public List<SysUser> queryuser(SysUserQuery sysUserQuery);

	public int getTotalRecord(SysUserQuery sysUserQuery);

	public List<SysUser> findAll(SysUserQuery sysUserQuery, int startIndex, int pageSize); 
}
