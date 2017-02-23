package cn.itcast.yycg.system.service;

import java.util.List;

import cn.itcast.yycg.domain.po.SysDictInfo;

public interface SysDictInfoService {
	public List<SysDictInfo> findAllByTypecode(String typecode);
}
