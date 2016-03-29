package com.app.salary.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.salary.dao.ISalaryDemoDao;
import com.app.salary.dao.ISalaryDemoEleDao;
import com.app.salary.domain.SalaryDemoEle;
import com.app.salary.service.ISalaryDemoEleService;
import com.app.utils.exception.DaoException;
import com.app.utils.exception.ServiceException;

@Component
@Service
@Transactional
public class SalaryDemoEleServiceImpl implements ISalaryDemoEleService {

	@Override
	public boolean delelebyeleid(SalaryDemoEle salarydemoele)
			throws ServiceException {
		try {
			if(saldemoeledao.delelebyeleid(salarydemoele) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when delelebyeleid methods of SalaryDemoEleServiceImpl.", e);
			throw new ServiceException("修改数据失败", e);
		}
		return false;
	}

	@Override
	public boolean delelebydemoid(SalaryDemoEle salarydemoele)
			throws ServiceException {
		try {
			if(saldemoeledao.delelebydemoid(salarydemoele) >= 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when delelebydemoid methods of SalaryDemoEleServiceImpl.", e);
			throw new ServiceException("修改数据失败", e);
		}
		return false;
	}

	@Autowired
	private ISalaryDemoEleDao saldemoeledao;
	//记录日志
	private Logger logger = LoggerFactory.getLogger(SalaryDemoEleServiceImpl.class);
	@Override
	public boolean saveSaldemoEle(SalaryDemoEle salarydemoele)
			throws ServiceException {
		try {
			if(saldemoeledao.saveSaldemoEle(salarydemoele) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when saveCompany methods of SalaryDemoEleServiceImpl.", e);
			throw new ServiceException("插入数据失败", e);
		}
		return false;
	}

	@Override
	public Long getsaldemoeleid() throws ServiceException {
		return saldemoeledao.getsaldemoeleid();
	}

	@Override
	public List<SalaryDemoEle> findSaldemoeleBydemoid(Long demoid)
			throws ServiceException {
		try {
			return saldemoeledao.findSaldemoeleBydemoid(demoid);
		} catch (DaoException e) {
			logger.error("Error occurred when findAllUser methods of SalaryDemoEleServiceImpl.", e);
			throw new ServiceException("查找数据失败", e);
		}
	}

	@Override
	public SalaryDemoEle findSaldemoEleByEleid(Long eleid)
			throws ServiceException {
		return saldemoeledao.findSaldemoEleByEleid(eleid);
	}

	@Override
	public boolean updateSalDemoelebyid(SalaryDemoEle salarydemoele)
			throws ServiceException {
		try {
			if(saldemoeledao.updateSalDemoelebyid(salarydemoele) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when saveCompany methods of SalaryDemoEleServiceImpl.", e);
			throw new ServiceException("修改数据失败", e);
		}
		return false;
	}

}
