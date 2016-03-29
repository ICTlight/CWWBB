package com.app.user.dao;

import com.app.user.domain.Company;
import com.app.utils.exception.DaoException;

public interface ICompanyDao {

	/** 
	 * @ int saveCompany(Company company)
	 * @ author LiuTuo
	 * @ description 添加个人用户信息
	 */
    public int saveCompany(Company company) throws DaoException;
    /** 
   	 * @ Company findCompanyByUserId(Long id)
   	 * @ author LiuTuo
   	 * @ date 2015-10-18 22:21:35
   	 * @ description 根据用户ID查找用户基本信息
   	 * @ reviewed_by
   	 */
    public Company findCompanyByUserId(Long userid) throws DaoException;
    
    /** 
   	 * @ int updateCompany(Company company)
   	 * @ author LiuTuo
   	 * @ date 2015-10-19 10:45:24
   	 * @ description 修改用户基本信息
   	 * @ reviewed_by
   	 */
    public int updateCompany(Company company) throws DaoException;
    
    /** 
   	 * @ Company findCompanyByCompanyid(String companyid)
   	 * @ author LiuTuo
   	 * @ date 2015-10-19 11:34:06
   	 * @ description 根据用户ID查找用户基本信息
   	 * @ reviewed_by
   	 */
    public Company findCompanyByCompanyid(String companyid) throws DaoException;
}
