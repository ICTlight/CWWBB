package com.app.dao.user.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.dao.user.ICompanyDao;
import com.app.domain.user.Company;
import com.app.utils.exception.DaoException;

@Component
public class CompanyDaoImpl implements ICompanyDao {  
	  
		 /** 
	     * 注入sqlSessionTemplate 
	     */  
		@Autowired
	    private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 创建用户功能
	 * @param company
	 * @return
	 */
  @Override  
  public int saveCompany(Company company) throws DaoException{ 
	  System.out.println("CompanyDaoImpl.............");
      return sqlSessionTemplate.insert("com.app.domain.user.Company.saveCompany", company);
  }
  /**
	 * 根据ID查找用户信息功能
	 * @param ID
	 * @return
	 */  
  @Override  
  public Company findCompanyByUserId(Long userid) throws DaoException{	
  	Company company = (Company) sqlSessionTemplate.selectOne("com.app.domain.user.Company.findCompanyByUserId", userid);
      return company;
  }
@Override
public int updateCompany(Company company) throws DaoException {
	return sqlSessionTemplate.update("com.app.domain.user.Company.updateCompanybyid", company);
}

@Override
public Company findCompanyByCompanyid(String companyid) throws DaoException {
	Company company = (Company) sqlSessionTemplate.selectOne("com.app.domain.user.Company.findCompanyByCompanyid", companyid);
    return company;
}

}
