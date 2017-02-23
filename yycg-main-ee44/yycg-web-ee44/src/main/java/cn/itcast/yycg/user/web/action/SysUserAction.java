package cn.itcast.yycg.user.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.yycg.base.web.action.BaseAction;
import cn.itcast.yycg.domain.po.SysDictInfo;
import cn.itcast.yycg.domain.po.SysUser;
import cn.itcast.yycg.framework.web.result.ResultUtil;
import cn.itcast.yycg.system.service.DwService;
import cn.itcast.yycg.system.service.SysDictInfoService;
import cn.itcast.yycg.user.pojo.SysUserCustom;
import cn.itcast.yycg.user.service.SysUserService;
import cn.itcast.yycg.user.web.vo.SysUserVo;
import cn.itcast.yycg.util.MD5;
import cn.itcast.yycg.util.PageBean;

@Controller
@Scope("prototype")
public class SysUserAction extends BaseAction<SysUserVo> {

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SysDictInfoService sysDictInfoService;

	@Autowired
	private DwService dwService;

	public String findById() {
		// 获取id
		SysUserVo sysUserVo = this.getModel();
		String id = sysUserVo.getSysUserQueryCustom().getId();

		// 根据id查询对象
		SysUser sysUser = sysUserService.findById(id);

		// 回显数据
		SysUserCustom sysUserCustom = new SysUserCustom();
		BeanUtils.copyProperties(sysUser, sysUserCustom);
		sysUserVo.setSysUserCustom(sysUserCustom);

		return "findById";
	}

	/**
	 * 跳转页面
	 * 
	 * @return
	 */
	public String queryuser() {
		SysUserVo sysUserVo = this.getModel();
		List<SysDictInfo> userGroupList = sysDictInfoService.findAllByTypecode("s01");
		sysUserVo.setUserGroupList(userGroupList);
		return "queryuser";
	}

	/**
	 * 查询所有
	 */
	public void queryuser_result() {
		// 查询总记录数
		SysUserVo sysUserVo = this.getModel();
		int totalRecord = sysUserService.getTotalRecord(sysUserVo.getSysUserQueryCustom());
		// 创建pageBean对象
		PageBean pg = new PageBean(sysUserVo.getPage(), sysUserVo.getRows(), totalRecord);
		// 分页查询数据
		List<SysUser> rows = sysUserService.findAll(sysUserVo.getSysUserQueryCustom(), pg.getStartIndex(),
				pg.getPageSize());
		Map<String, Object> map = new HashMap<>();
		map.put("total", totalRecord);
		map.put("rows", rows);
		this.write_object(map);

	}

	/**
	 * 添加用户
	 * 
	 * @return
	 */
	public String adduser() {
		// 查询用户类型
		List<SysDictInfo> userGroupList = sysDictInfoService.findAllByTypecode("s01");
		List<SysDictInfo> userStateList = sysDictInfoService.findAllByTypecode("s02");
		SysUserVo sysUserVo = this.getModel();
		sysUserVo.setUserGroupList(userGroupList);
		sysUserVo.setUserStateList(userStateList);
		return "adduser";
	}

	/**
	 * 查询所属单位
	 */
	public void findDwByDictcode() {
		SysUserVo sysUserVo = this.getModel();

		List list = dwService.findAll(sysUserVo.getSysUserQueryCustom().getSysDictInfoByGroupid().getDictcode());
		this.write_object(list);
	}

	/**
	 * 添加用户
	 */
	public void adduser_submit() {
		try {
			SysUserVo sysUserVo = this.getModel();
			sysUserService.save(sysUserVo.getSysUserCustom());

			// 添加成功后的显示
			this.write_object(ResultUtil.createSubmitResult("保存成功"));
		} catch (Exception e) {
			ResultUtil.throwExcepionResult("添加用户失败,请检查是否填写正确");
			e.printStackTrace();
		}
	}

	/**
	 * 编辑用户
	 */
	public String edituser() {
		SysUserVo sysUserVo = this.getModel();
		//查看用户类型
		List<SysDictInfo> userGroupList = sysDictInfoService.findAllByTypecode("s01");
		//查看用户状态
		List<SysDictInfo> userStateList = sysDictInfoService.findAllByTypecode("s02");
		SysUser sysUser = sysUserService.findById(sysUserVo.getSysUserCustom().getId());
		BeanUtils.copyProperties(sysUser, sysUserVo.getSysUserCustom());
		List useredit = dwService.findAll(sysUserVo.getSysUserCustom().getSysDictInfoByGroupid().getDictcode());
		sysUserVo.setUseredit(useredit);
		sysUserVo.setUserGroupList(userGroupList);
		sysUserVo.setUserStateList(userStateList);
		return "edituser";
	}
	public void edituser_submit(){
		//获取模型
		SysUserVo sysUserVo = this.getModel();
		sysUserService.update(sysUserVo.getSysUserCustom());
		//设置成功后的响应
		this.write_object(ResultUtil.createSubmitResult("更新成功"));
	}
	public void deleteuser_submit(){
		//获取模型
		SysUserVo sysUserVo = this.getModel();
		sysUserService.deleteuser(sysUserVo.getSysUserCustom().getId());
		this.write_object(ResultUtil.createSubmitResult("删除成功"));
		
		
	}
}
