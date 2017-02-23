package cn.itcast.yycg.system.dao;

import java.util.List;

import cn.itcast.yycg.base.dao.BaseDao;
import cn.itcast.yycg.domain.po.SysDictInfo;
import cn.itcast.yycg.domain.po.SysDictType;

public interface SysDictInfoDao extends BaseDao<SysDictInfo>{
	/**
	 * 通过id查询字典信息
	 * @param typecode
	 * @return
	 */
	public List<SysDictInfo> findAllByTypecode(String typecode);

}
