package com.app.service.user.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.user.ICompanyDao;
import com.app.domain.user.Company;
import com.app.service.user.ICompanyService;
import com.app.utils.exception.DaoException;
import com.app.utils.exception.ServiceException;

/**
 * @ file_name CompanyServiceImpl.java
 * @ author LiuTuo
 * @ description 
 */
@Component
@Service
@Transactional
public class CompanyServiceImpl implements ICompanyService {
	
	@Autowired
	private ICompanyDao companyDao;
	//记录日志
	private Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);

	public boolean saveCompany(Company company) throws ServiceException{
		System.out.println("CompanyServiceImpl.............");
		try {
			if(companyDao.saveCompany(company) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when saveCompany methods of CompanyServiceImpl.", e);
			throw new ServiceException("插入数据失败", e);
		}
		return false;
	}

	@Override
	public Company findCompanyByUserId(Long userid) throws ServiceException {
		return companyDao.findCompanyByUserId(userid);
	}

	@Override
	public boolean updateCompany(Company company) throws ServiceException {
		try {
			if(companyDao.updateCompany(company) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when updateUser methods of UserServiceImpl.", e);
			throw new ServiceException("修改数据失败", e);
		}
    	return false;
	}

	@Override
	public Company findCompanyByCompanyId(String companyid)
			throws ServiceException {
		return companyDao.findCompanyByCompanyid(companyid);
	}

}
