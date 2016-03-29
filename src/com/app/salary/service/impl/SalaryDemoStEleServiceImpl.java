package com.app.salary.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.salary.dao.ISalaryDemoStEleDao;
import com.app.salary.domain.SalaryDemoStEle;
import com.app.salary.service.ISalaryDemoStEleService;
import com.app.utils.exception.DaoException;
import com.app.utils.exception.ServiceException;

@Component
@Service
@Transactional
public class SalaryDemoStEleServiceImpl implements ISalaryDemoStEleService{

	@Autowired
	private ISalaryDemoStEleDao steledao;
	//记录日志
	private Logger logger = LoggerFactory.getLogger(SalaryDemoStEleServiceImpl.class);
	@Override
	public boolean saveSaldemostele(SalaryDemoStEle salarydemostele)
			throws ServiceException {
		try {
			if(steledao.saveSaldemostele(salarydemostele) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when saveCompany methods of SalaryDemoEleServiceImpl.", e);
			throw new ServiceException("插入数据失败", e);
		}
		return false;
	}

	@Override
	public Long getsaldemosteleid() throws ServiceException {
		
		return steledao.getsaldemosteleid();
	}

	@Override
	public List<SalaryDemoStEle> findSaldemosteleBydemoid(Long demoid)
			throws ServiceException {
		try {
			return steledao.findSaldemosteleBydemoid(demoid);
		} catch (DaoException e) {
			logger.error("Error occurred when findAllUser methods of SalaryDemoEleServiceImpl.", e);
			throw new ServiceException("查找数据失败", e);
		}
	}

	@Override
	public SalaryDemoStEle findSaldemosteleByEleid(Long eleid)
			throws ServiceException {
		
		return steledao.findSaldemosteleByEleid(eleid);
	}

	@Override
	public boolean updateSaldemostelebyid(SalaryDemoStEle salarydemostele)
			throws ServiceException {
		try {
			if(steledao.updateSaldemostelebyid(salarydemostele) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when saveCompany methods of SalaryDemoEleServiceImpl.", e);
			throw new ServiceException("修改数据失败", e);
		}
		return false;
	}

	@Override
	public boolean delstelebyeleid(SalaryDemoStEle salarydemostele)
			throws ServiceException {
		try {
			if(steledao.delstelebyeleid(salarydemostele) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when delstelebyeleid methods of SalaryDemoEleServiceImpl.", e);
			throw new ServiceException("删除数据失败", e);
		}
		return false;
	}

	@Override
	public boolean delstelebydemoid(SalaryDemoStEle salarydemostele)
			throws ServiceException {
		try {
			if(steledao.delstelebydemoid(salarydemostele) >= 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when delstelebydemoid methods of SalaryDemoEleServiceImpl.", e);
			throw new ServiceException("删除数据失败", e);
		}
		return false;
	}

	@Override
	public void deleteSaldemosteleBydemoid(Long demoid) throws ServiceException {
		steledao.deleteSaldemosteleBydemoid(demoid);	
	}

	@Override
	public List<SalaryDemoStEle> findBasecodeBydemoid(Long demoid)
			throws ServiceException {
		try {
			return steledao.findBasecodeBydemoid(demoid);
		} catch (DaoException e) {
			logger.error("Error occurred when findBasecodeBydemoid methods of SalaryDemoEleServiceImpl.", e);
			throw new ServiceException("查找数据失败", e);
		}
	}

}
