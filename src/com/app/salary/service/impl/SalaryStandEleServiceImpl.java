package com.app.salary.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.salary.dao.ISalaryStandEleDao;
import com.app.salary.domain.SalaryStandEle;
import com.app.salary.service.ISalaryStandEleService;
import com.app.utils.exception.ServiceException;

@Component
@Service
@Transactional
public class SalaryStandEleServiceImpl implements ISalaryStandEleService {

	@Autowired
	private ISalaryStandEleDao salstanddao;
	private Logger logger = LoggerFactory.getLogger(SalaryDemoServiceImpl.class);
	@Override
	public List<SalaryStandEle> findallStandEle() throws ServiceException {
		return salstanddao.findallStandEle();
	}
	@Override
	public SalaryStandEle findStandEleByElename(String elename)
			throws ServiceException {
		return salstanddao.findStandEleByElename(elename);
	}

}
