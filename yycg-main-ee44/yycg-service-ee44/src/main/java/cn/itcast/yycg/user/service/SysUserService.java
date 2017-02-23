package cn.itcast.yycg.user.service;

import java.util.List;

import cn.itcast.yycg.domain.po.SysUser;
import cn.itcast.yycg.user.dao.query.SysUserQuery;
import cn.itcast.yycg.user.pojo.SysUserCustom;
import cn.itcast.yycg.user.pojo.SysUserQueryCustom;

/**
 * 系统用户service层接口
 * 
 * @author xgh
 *
 */
public interface SysUserService {

	/**
	 * 根据id查找用户
	 * 
	 * @param id
	 * @return
	 */
	public SysUser findById(String id);

	/**
	 * 查询所有
	 * 
	 * @param sysUserQuery
	 * @return
	 */
	public List<SysUser> queryuser(SysUserQuery sysUserQuery);

	/**
	 * 分页查询
	 * 
	 * @param sysUserQueryCustom
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<SysUser> findAll(SysUserQueryCustom sysUserQueryCustom, int startIndex, int pageSize);

	/**
	 * 获取总记录数
	 * 
	 * @param sysUserQueryCustom
	 * @return
	 */
	int getTotalRecord(SysUserQuery sysUserQueryCustom);

	/**
	 * 保存用户
	 * 
	 * @param sysUserCustom
	 */
	public void save(SysUserCustom sysUserCustom);

	/**
	 * 更新用户
	 * @param sysUserCustom
	 */
	public void update(SysUserCustom sysUserCustom);

	/**
	 * 删除用户
	 * @param id
	 */
	public void deleteuser(String id);
}
