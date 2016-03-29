package com.app.salary.service;

import java.util.List;

import com.app.salary.domain.SalaryDemo;
import com.app.utils.exception.DaoException;
import com.app.utils.exception.ServiceException;

public interface ISalaryDemoService {

	/** 
	 * @ int saveSaldemo(SalDemo salarydemo)
	 * @ author LiuTuo
	 * @ date 2015-10-29 17:07:22
	 * @ description 添加个人用户信息
	 */
    public boolean saveSaldemo(SalaryDemo salarydemo) throws ServiceException;
    
    /** 
	 * @ long getsaldemoid()
	 * @ author LiuTuo
	 * @ date 2015-10-29 17:07:17
	 * @ description 获取最新的id
	 */
    public Long getsaldemoid() throws ServiceException;
    
    /** 
   	 * @ List<SalaryDemo> findSaldemoByCoid()
   	 * @ author LiuTuo
   	 * @ date 2015-10-29 17:07:09
   	 * @ description 查询所有模板信息列表
   	 * @ reviewed_by
   	 */
    public List<SalaryDemo> findSaldemoByCoid(Long coid) throws ServiceException;
    
    /** 
   	 * @ SalaryDemo findSaldemoBySaldemoid()
   	 * @ author LiuTuo
   	 * @ date 2015-10-29 17:07:09
   	 * @ description 查询所有模板信息列表
   	 * @ reviewed_by
   	 */
    public SalaryDemo findSaldemoBySaldemoid(Long saldemoid) throws ServiceException;
    
    /** 
 	 * @ boolean delelebydemoid(SalaryDemo salaryDemo) 
 	 * @ author LiuTuo
 	 * @ date 2015-11-10 14:47:55
 	 * @ description 根saldemoid删除工资项
 	 */
     public boolean delsaldemobyid(SalaryDemo salaryDemo) throws DaoException;

}
