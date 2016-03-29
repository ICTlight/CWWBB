package com.app.user.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.user.dao.ICompanyDao;
import com.app.user.domain.Company;
import com.app.utils.exception.DaoException;

@Component
public class CompanyDaoImpl implements ICompanyDao {  

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

    @Override  
    public int saveCompany(Company company) throws DaoException{ 
	    System.out.println("CompanyDaoImpl.............");
        return sqlSessionTemplate.insert("com.app.user.domain.Company.saveCompany", company);
    }
    /**
	 * 根据ID查找用户信息功能
	 * @param ID
	 */  
    @Override  
    public Company findCompanyByUserId(Long userid) throws DaoException{	
  	    Company company = (Company) sqlSessionTemplate.selectOne("com.app.user.domain.Company.findCompanyByUserId", userid);
        return company;
    }
	@Override
	public int updateCompany(Company company) throws DaoException {
		return sqlSessionTemplate.update("com.app.user.domain.Company.updateCompanybyid", company);
	}
	
	@Override
	public Company findCompanyByCompanyid(String companyid) throws DaoException {
		Company company = (Company) sqlSessionTemplate.selectOne("com.app.user.domain.Company.findCompanyByCompanyid", companyid);
	    return company;
	}
}
