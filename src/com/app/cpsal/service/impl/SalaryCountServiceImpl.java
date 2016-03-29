package com.app.cpsal.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.cpsal.dao.ISalaryCountDao;
import com.app.cpsal.domain.SalaryCount;
import com.app.cpsal.service.ISalaryCountService;
import com.app.salary.service.impl.SalaryDemoServiceImpl;
import com.app.utils.exception.DaoException;
import com.app.utils.exception.ServiceException;

@Component
@Service
@Transactional
public class SalaryCountServiceImpl implements ISalaryCountService {

	@Autowired
	private ISalaryCountDao salCount;
	private Logger logger = LoggerFactory.getLogger(SalaryCountServiceImpl.class);
	@Override
	public boolean saveSalCount(SalaryCount salaryCount)
			throws ServiceException {
		try {
			if(salCount.saveSalCount(salaryCount) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when saveSalCount methods of SalaryCountServiceImpl.", e);
			throw new ServiceException("插入数据失败", e);
		}
		return false;
	}

	@Override
	public Long getsalcountid() throws ServiceException {
		return salCount.getsalcountid();
	}

	@Override
	public boolean updateSalCountbyid(SalaryCount salaryCount)
			throws ServiceException {
		try {
			if(salCount.updateSalCountbyid(salaryCount) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when updateSalCountbyid methods of SalaryCountServiceImpl.", e);
			throw new ServiceException("更新数据失败", e);
		}
		return false;
	}

	@Override
	public SalaryCount findSalCountByPeid(Long peid) throws ServiceException {
		try {
			return salCount.findSalCountByPeid(peid);
		} catch (DaoException e) {
			logger.error("Error occurred when findSalCountByPeid methods of SalaryCountServiceImpl.", e);
			throw new ServiceException("查找数据失败", e);
		}
	}

	@Override
	public boolean deletePaycountbypeid(SalaryCount salaryItem)
			throws DaoException {
		try {
			if(salCount.deletePaycountbypeid(salaryItem) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when deletePaycountbypeid methods of SalaryCountServiceImpl.", e);
			throw new ServiceException("插入数据失败", e);
		}
		return false;
	}

	@Override
	public boolean deletePaycountbybyeleid(SalaryCount salaryItem)
			throws DaoException {
		try {
			if(salCount.deletePaycountbybyeleid(salaryItem) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when deletePaycountbybyeleid methods of SalaryCountServiceImpl.", e);
			throw new ServiceException("插入数据失败", e);
		}
		return false;
	}

	@Override
	public boolean deletePaycountbydemoid(SalaryCount salaryItem)
			throws DaoException {
		try {
			if(salCount.deletePaycountbydemoid(salaryItem) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when deletePaycountbydemoid methods of SalaryCountServiceImpl.", e);
			throw new ServiceException("插入数据失败", e);
		}
		return false;
	}

}
