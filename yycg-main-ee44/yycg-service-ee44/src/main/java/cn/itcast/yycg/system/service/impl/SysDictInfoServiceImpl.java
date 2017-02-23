package cn.itcast.yycg.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.yycg.domain.po.SysDictInfo;
import cn.itcast.yycg.system.dao.SysDictInfoDao;
import cn.itcast.yycg.system.service.SysDictInfoService;
@Service
public class SysDictInfoServiceImpl implements SysDictInfoService {
	@Autowired
	private SysDictInfoDao sysDictInfoDao;
	/**
	 * 根据code查询
	 */
	public List<SysDictInfo> findAllByTypecode(String typecode) {
		return sysDictInfoDao.findAllByTypecode(typecode);

	}
}
