package com.app.service.salary.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.salary.ISalaryDemoDao;
import com.app.domain.salary.SalaryDemo;
import com.app.service.salary.ISalaryDemoService;
import com.app.utils.exception.DaoException;
import com.app.utils.exception.ServiceException;

@Component
@Service
@Transactional
public class SalaryDemoServiceImpl implements ISalaryDemoService {

	@Autowired
	private ISalaryDemoDao saldemodao;
	//记录日志
	private Logger logger = LoggerFactory.getLogger(SalaryDemoServiceImpl.class);
	@Override
	public boolean saveSaldemo(SalaryDemo salarydemo) throws ServiceException {
		System.out.println("saveSaldemo.............");
		try {
			if(saldemodao.saveSaldemo(salarydemo) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when saveCompany methods of CompanyServiceImpl.", e);
			throw new ServiceException("插入数据失败", e);
		}
		return false;
	}

	@Override
	public Long getsaldemoid() throws ServiceException {
		return saldemodao.getsaldemoid();
	}

	@Override
	public List<SalaryDemo> findSaldemoByCoid(Long coid) throws ServiceException {
		try {
			return saldemodao.findSaldemoByCoid(coid);
		} catch (DaoException e) {
			logger.error("Error occurred when findAllUser methods of CompanyServiceImpl.", e);
			throw new ServiceException("查找数据失败", e);
		}
	}


	@Override
	public SalaryDemo findSaldemoBySaldemoid(Long saldemoid)
			throws ServiceException {
		try {
			return saldemodao.findSaldemoBySaldemoid(saldemoid);
		} catch (DaoException e) {
			logger.error("Error occurred when findAllUser methods of CompanyServiceImpl.", e);
			throw new ServiceException("查找数据失败", e);
		}
	}

}
