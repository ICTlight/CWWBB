package com.app.salary.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.salary.dao.ISalaryLocalStandDao;
import com.app.salary.domain.SalaryLocalStand;
import com.app.salary.service.ISalaryLocalStandService;
import com.app.utils.exception.DaoException;
import com.app.utils.exception.ServiceException;

@Component
@Service
@Transactional
public class SalaryLocalStandServiceImpl implements ISalaryLocalStandService {

	@Autowired
	private ISalaryLocalStandDao salStandDao;
	private Logger logger = LoggerFactory.getLogger(SalaryLocalStandServiceImpl.class);
	@Override
	public SalaryLocalStand findSalLocalStandByAreacode(String areacode)
			throws ServiceException {
		try {
			return salStandDao.findSalLocalStandByAreacode(areacode);
		} catch (DaoException e) {
			logger.error("Error occurred when findSalLocalStandByAreacode methods of SalaryLocalStandServiceImpl.", e);
			throw new ServiceException("查找数据失败", e);
		}
	}

	@Override
	public List<SalaryLocalStand> findSalLocalStandList()
			throws ServiceException {
		try {
			return salStandDao.findSalLocalStandList();
		} catch (DaoException e) {
			logger.error("Error occurred when findSalLocalStandList methods of SalaryLocalStandServiceImpl.", e);
			throw new ServiceException("查找数据失败", e);
		}
	}

}
