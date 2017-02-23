package cn.itcast.yycg.user.web.vo;

import java.util.List;

import cn.itcast.yycg.domain.po.SysDictInfo;
import cn.itcast.yycg.user.pojo.SysUserCustom;
import cn.itcast.yycg.user.pojo.SysUserQueryCustom;

/**
 * VO类，用于表单提交或数据回显
 * 
 * @author xgh
 *
 */
public class SysUserVo {
	private int page;
	private int rows;
	private List<SysDictInfo> userGroupList;
	private List<SysDictInfo> userStateList;
	private List useredit;
	
	public List getUseredit() {
		return useredit;
	}

	public void setUseredit(List useredit) {
		this.useredit = useredit;
	}

	public List<SysDictInfo> getUserStateList() {
		return userStateList;
	}

	public void setUserStateList(List<SysDictInfo> userStateList) {
		this.userStateList = userStateList;
	}

	public List<SysDictInfo> getUserGroupList() {
		return userGroupList;
	}

	public void setUserGroupList(List<SysDictInfo> userGroupList) {
		this.userGroupList = userGroupList;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	private SysUserCustom sysUserCustom;
	private SysUserQueryCustom sysUserQueryCustom;

	/**
	 * 获取自定义字段对象
	 * 
	 * @return
	 */
	public SysUserCustom getSysUserCustom() {
		return sysUserCustom;
	}

	/**
	 * 设置自定义字段对象
	 * 
	 * @param sysUserCustom
	 */
	public void setSysUserCustom(SysUserCustom sysUserCustom) {
		this.sysUserCustom = sysUserCustom;
	}

	/**
	 * 获取处理前对象
	 * 
	 * @return
	 */
	public SysUserQueryCustom getSysUserQueryCustom() {
		return sysUserQueryCustom;
	}

	/**
	 * 获取处理后对象
	 * 
	 * @param sysUserQueryCustom
	 */
	public void setSysUserQueryCustom(SysUserQueryCustom sysUserQueryCustom) {
		this.sysUserQueryCustom = sysUserQueryCustom;
	}
}
