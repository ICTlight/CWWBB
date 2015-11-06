package com.app.service.salary.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.salary.ISalaryItemDao;
import com.app.domain.salary.SalaryItem;
import com.app.service.salary.ISalaryItemService;
import com.app.utils.exception.DaoException;
import com.app.utils.exception.ServiceException;
@Component
@Service
@Transactional
public class SalaryItemServiceImpl implements ISalaryItemService{

	@Autowired
	private ISalaryItemDao salItemDao;
	private Logger logger = LoggerFactory.getLogger(SalaryItemServiceImpl.class);
	@Override
	public boolean saveSalItem(SalaryItem salaryItem) throws ServiceException {
		try {
			if(salItemDao.saveSalItem(salaryItem) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when saveCompany methods of SalaryItemServiceImpl.", e);
			throw new ServiceException("插入数据失败", e);
		}
		return false;
	}

	@Override
	public Long getsalitemid() throws ServiceException {
		return salItemDao.getsalitemid();
	}

	@Override
	public List<SalaryItem> findSalItemByDemoid(Long demoid)
			throws ServiceException {
		try {
			return salItemDao.findSalItemByDemoid(demoid);
		} catch (DaoException e) {
			logger.error("Error occurred when findAllUser methods of SalaryItemServiceImpl.", e);
			throw new ServiceException("查找数据失败", e);
		}
	}

	@Override
	public List<SalaryItem> findSalItemByEleid(Long eleid)
			throws ServiceException {
		try {
			return salItemDao.findSalItemByEleid(eleid);
		} catch (DaoException e) {
			logger.error("Error occurred when findAllUser methods of SalaryItemServiceImpl.", e);
			throw new ServiceException("查找数据失败", e);
		}
	}

	@Override
	public boolean updateSalItembyid(SalaryItem salaryItem)
			throws ServiceException {
		try {
			if(salItemDao.updateSalItembyid(salaryItem) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when saveCompany methods of SalaryItemServiceImpl.", e);
			throw new ServiceException("修改数据失败", e);
		}
		return false;
	}

	@Override
	public List<SalaryItem> findPellistByDemoid(Long demoid)
			throws ServiceException {
		try {
			return salItemDao.findPellistByDemoid(demoid);
		} catch (DaoException e) {
			logger.error("Error occurred when findAllUser methods of SalaryItemServiceImpl.", e);
			throw new ServiceException("查找数据失败", e);
		}
	}

	@Override
	public List<SalaryItem> findPeldelistByPeid(Long peid)
			throws ServiceException {
		try {
			return salItemDao.findPeldelistByPeid(peid);
		} catch (DaoException e) {
			logger.error("Error occurred when findAllUser methods of SalaryItemServiceImpl.", e);
			throw new ServiceException("查找数据失败", e);
		}
	}

	@Override
	public String findPenameByPeid(Long peid) throws ServiceException {
		return salItemDao.findPenameByPeid(peid);
	}

}
