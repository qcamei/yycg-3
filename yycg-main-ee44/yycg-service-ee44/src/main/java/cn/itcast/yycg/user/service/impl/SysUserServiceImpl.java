package cn.itcast.yycg.user.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.yycg.domain.po.SysUser;
import cn.itcast.yycg.framework.web.result.ResultUtil;
import cn.itcast.yycg.user.dao.SysUserDao;
import cn.itcast.yycg.user.dao.query.SysUserQuery;
import cn.itcast.yycg.user.pojo.SysUserCustom;
import cn.itcast.yycg.user.pojo.SysUserQueryCustom;
import cn.itcast.yycg.user.service.SysUserService;
import cn.itcast.yycg.util.MD5;

/**
 * 系统用户service层
 * 
 * @author xgh
 *
 */
@Service
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserDao sysUserDao;

	/**
	 * 根据id查找用户
	 */
	@Override
	public SysUser findById(String id) {
		return sysUserDao.findById(id);
	}

	@Override
	public List<SysUser> queryuser(SysUserQuery sysUserQuery) {
		return sysUserDao.queryuser(sysUserQuery);
	}

	@Override
	public int getTotalRecord(SysUserQuery sysUserQueryCustom) {
		return sysUserDao.getTotalRecord(sysUserQueryCustom);

	}

	@Override
	public List<SysUser> findAll(SysUserQueryCustom sysUserQueryCustom, int startIndex, int pageSize) {
		return sysUserDao.findAll(sysUserQueryCustom, startIndex, pageSize);
	}

	@Override
	public void save(SysUserCustom sysUserCustom) {
		SysUser sysUser = new SysUser();
		BeanUtils.copyProperties(sysUserCustom, sysUser);
		String pwd = new MD5().getMD5ofStr(sysUser.getPwd());
		sysUser.setPwd(pwd);
		sysUserDao.save(sysUser);
	}

	@Override
	public void update(SysUserCustom sysUserCustom) {
		SysUser sysUser = sysUserDao.findById(sysUserCustom.getId());

		BeanUtils.copyProperties(sysUserCustom, sysUser);
		sysUserDao.update(sysUser);
	}

	/**
	 * 删除用户
	 */
	@Override
	public void deleteuser(String id) {
		SysUser sysUser = sysUserDao.findById(id);
		//判断用户是否为空
		if (sysUser == null) {
			ResultUtil.throwExcepionResult("删除失败");
		}
		//删除用户
		sysUserDao.delete(sysUser);

	}

}
