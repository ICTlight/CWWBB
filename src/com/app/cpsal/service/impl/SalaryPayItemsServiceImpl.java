package com.app.cpsal.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.cpsal.dao.ISalaryPayItemsDao;
import com.app.cpsal.domain.SalaryPayItems;
import com.app.cpsal.service.ISalaryPayItemsService;
import com.app.utils.exception.DaoException;
import com.app.utils.exception.ServiceException;

@Component
@Service
@Transactional
public class SalaryPayItemsServiceImpl implements ISalaryPayItemsService {

	@Autowired
	private ISalaryPayItemsDao payitem;
	private Logger logger = LoggerFactory.getLogger(SalaryCountServiceImpl.class);
	
	@Override
	public boolean saveSalpayItem(SalaryPayItems salaryPayItems)
			throws ServiceException {
		try {
			if(payitem.saveSalpayItem(salaryPayItems) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when saveSalpayItem methods of SalaryPayItemsServiceImpl.", e);
			throw new ServiceException("插入数据失败", e);
		}
		return false;
	}

	@Override
	public Long getsalpayitemid() throws ServiceException {
		return payitem.getsalpayitemid();
	}

	@Override
	public List<SalaryPayItems> findPeldelistByPeid(Long peid)
			throws DaoException {
		try {
			return payitem.findPeldelistByPeid(peid);
		} catch (DaoException e) {
			logger.error("Error occurred when findPeldelistByPeid methods of SalaryItemServiceImpl.", e);
			throw new ServiceException("查找数据失败", e);
		}
	}

	@Override
	public List<SalaryPayItems> findSallistByType(SalaryPayItems salaryItem)
			throws ServiceException {
		try {
			return payitem.findSallistByType(salaryItem);
		} catch (DaoException e) {
			logger.error("Error occurred when findSallistByType methods of SalaryItemServiceImpl.", e);
			throw new ServiceException("查找数据失败", e);
		}
	}

	@Override
	public List<SalaryPayItems> findCptypelist(Long demoid)
			throws ServiceException {
		try {
			return payitem.findCptypelist(demoid);
		} catch (DaoException e) {
			logger.error("Error occurred when findPeldelistByPeid methods of SalaryItemServiceImpl.", e);
			throw new ServiceException("查找数据失败", e);
		}
	}

	@Override
	public List<SalaryPayItems> findSalItemByDemoid(Long demoid)
			throws DaoException {
		try {
			return payitem.findSalItemByDemoid(demoid);
		} catch (DaoException e) {
			logger.error("Error occurred when findSalItemByDemoid methods of SalaryItemServiceImpl.", e);
			throw new ServiceException("查找数据失败", e);
		}
	}

	@Override
	public List<SalaryPayItems> findPellistByDemoid(Long demoid)
			throws ServiceException {
		try {
			return payitem.findPellistByDemoid(demoid);
		} catch (DaoException e) {
			logger.error("Error occurred when findPellistByDemoid methods of SalaryItemServiceImpl.", e);
			throw new ServiceException("查找数据失败", e);
		}
	}

	@Override
	public boolean deletePayitembypeid(SalaryPayItems salaryItem)
			throws ServiceException {
		try {
			if(payitem.deletePayitembypeid(salaryItem) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when deletePayitembypeid methods of SalaryPayItemsServiceImpl.", e);
			throw new ServiceException("修改数据失败", e);
		}
		return false;
	}

	@Override
	public boolean deletePayitembybyeleid(SalaryPayItems salaryItem)
			throws ServiceException {
		try {
			if(payitem.deletePayitembybyeleid(salaryItem) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when deletePayitembybyeleid methods of SalaryPayItemsServiceImpl.", e);
			throw new ServiceException("修改数据失败", e);
		}
		return false;
	}

	@Override
	public boolean deletePayitembydemoid(SalaryPayItems salaryItem)
			throws ServiceException {
		try {
			if(payitem.deletePayitembydemoid(salaryItem) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when deletePayitembydemoid methods of SalaryPayItemsServiceImpl.", e);
			throw new ServiceException("修改数据失败", e);
		}
		return false;
	}

}
