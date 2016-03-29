package com.app.cpsal.service.impl;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.cpsal.dao.ISalaryPayDao;
import com.app.cpsal.domain.SalaryPay;
import com.app.cpsal.service.ISalaryPayService;
import com.app.utils.exception.DaoException;
import com.app.utils.exception.ServiceException;

@Component
@Service
@Transactional
public class SalaryPayServiceImpl implements ISalaryPayService {

	@Autowired
	private ISalaryPayDao salPay;
	private Logger logger = LoggerFactory.getLogger(SalaryCountServiceImpl.class);
	@Override
	public boolean saveSalPay(SalaryPay salaryPay) throws ServiceException {
		try {
			if(salPay.saveSalPay(salaryPay) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when saveSalPay methods of SalaryPayServiceImpl.", e);
			throw new ServiceException("插入数据失败", e);
		}
		return false;
	}

	@Override
	public Long getsalpayid() throws ServiceException {
		return salPay.getsalpayid();
	}

	@Override
	public boolean updateSalPaybyid(SalaryPay salaryPay)
			throws ServiceException {
		try {
			if(salPay.updateSalPaybyid(salaryPay) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when updateSalPaybyid methods of SalaryPayServiceImpl.", e);
			throw new ServiceException("插入数据失败", e);
		}
		return false;
	}

	@Override
	public SalaryPay findSalPayByPeid(Long peid) throws ServiceException {
		try {
			return salPay.findSalPayByPeid(peid);
		} catch (DaoException e) {
			logger.error("Error occurred when findSalPayByPeid methods of SalaryPayServiceImpl.", e);
			throw new ServiceException("查找数据失败", e);
		}
	}

	@Override
	public List<SalaryPay> findSalPayByDemoid(Long demoid)
			throws ServiceException {
		try {
			return salPay.findSalPayByDemoid(demoid);
		} catch (DaoException e) {
			logger.error("Error occurred when findSalPayByDemoid methods of SalaryPayServiceImpl.", e);
			throw new ServiceException("查找数据失败", e);
		}
	}

	@Override
	public List<Map<String, Object>> findSalComputeInfo(String addSql,
			String groupby, Long demoid) throws ServiceException {
		System.out.println("huaha: 查询条件：。。。。。。" +addSql+"。。。"+ groupby+"。。。"+"。。。"+ demoid);
		List<Map<String, Object>> dataList = null;
		try {
			dataList = salPay.findSalComputeInfo(addSql,groupby, demoid);
		} catch (DaoException e) {			
			e.printStackTrace();			
		}
		return dataList;
	}

	@Override
	public boolean updateSPstatubydemoid(SalaryPay salaryPay)
			throws ServiceException {
		try {
			if(salPay.updateSPstatubydemoid(salaryPay) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when updateSPstatubydemoid methods of SalaryPayServiceImpl.", e);
			throw new ServiceException("插入数据失败", e);
		}
		return false;
	}

	@Override
	public boolean deletePaybypeid(SalaryPay salaryItem)
			throws ServiceException {
		try {
			if(salPay.deletePaybypeid(salaryItem) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when deletePaybypeid methods of SalaryPayServiceImpl.", e);
			throw new ServiceException("插入数据失败", e);
		}
		return false;
	}

	@Override
	public boolean deletePaybybyeleid(SalaryPay salaryItem)
			throws ServiceException {
		try {
			if(salPay.deletePaybybyeleid(salaryItem) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when deletePaybybyeleid methods of SalaryPayServiceImpl.", e);
			throw new ServiceException("插入数据失败", e);
		}
		return false;
	}

}
