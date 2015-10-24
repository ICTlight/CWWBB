package com.app.service.user;

import com.app.domain.user.Company;
import com.app.utils.exception.ServiceException;

public interface ICompanyService {

	/** 
	 * @ boolean saveCompany(Company company)
	 * @ author LiuTuo
	 * @ description 添加个人用户信息
	 */
	public boolean saveCompany(Company company) throws ServiceException;
	/** 
	 * @ Company findPersonByUserId(Long userid)
	 * @ author LiuTuo
	 * @ description 获取最新的id
	 */
	public Company findCompanyByUserId(Long userid) throws ServiceException;
	
	/** 
   	 * @ boolean updateCompany(Company company)
   	 * @ author LiuTuo
   	 * @ date 2015-10-19 10:59:50
   	 * @ description 修改用户基本信息
   	 * @ reviewed_by
   	 */
    public boolean updateCompany(Company company) throws ServiceException;
    
	
	/** 
   	 * @ Company findCompanyByUserId(Long id)
   	 * @ author LiuTuo
   	 * @ date 2015-10-18 22:21:35
   	 * @ description 根据用户ID查找用户基本信息
   	 * @ reviewed_by
   	 */
    public Company findCompanyByCompanyId(String companyid) throws ServiceException;
    
}
