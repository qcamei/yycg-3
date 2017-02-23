package cn.itcast.yycg.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.yycg.system.dao.DwGysDao;
import cn.itcast.yycg.system.dao.DwWssDao;
import cn.itcast.yycg.system.dao.DwWsyDao;
import cn.itcast.yycg.system.service.DwService;
@Service
public class DwServiceImpl implements DwService {
	@Autowired
	private DwGysDao dwGysDao;

	@Autowired
	private DwWssDao dwWssDao;

	@Autowired
	private DwWsyDao dwWsyDao;

	@Override
	public List findAll(String code) {	
		if ("1".equals(code) || "2".equals(code)) {
			return dwWsyDao.findAll();
		}
		if ("3".equals(code)) {
			return dwWssDao.findAll();
		}
		if ("4".equals(code)) {
			return dwGysDao.findAll();
		}

		return null;
	}

}
