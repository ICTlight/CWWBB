package com.app.salary.dao;

import java.util.List;
import com.app.salary.domain.SalaryDemo;
import com.app.utils.exception.DaoException;

public interface ISalaryDemoDao  {  
	  
	/** 
	 * @ int saveSaldemo(SalDemo salarydemo)
	 * @ author LiuTuo
	 * @ date 2015-10-29 16:51:05
	 * @ description 添加个人用户信息
	 */
    public int saveSaldemo(SalaryDemo salarydemo) throws DaoException;
    
    /** 
	 * @ long getsaldemoid()
	 * @ author LiuTuo
	 * @ date 2015-10-29 16:49:58
	 * @ description 获取最新的id
	 */
    public Long getsaldemoid() throws DaoException;
    
    /** 
   	 * @ List<SalaryDemo> findSaldemoByCoid()
   	 * @ author LiuTuo
   	 * @ date 2015-10-29 16:59:47
   	 * @ description 查询所有模板信息列表
   	 * @ reviewed_by
   	 */
    public List<SalaryDemo> findSaldemoByCoid(Long coid) throws DaoException;

    /** 
   	 * @ SalaryDemo findSaldemoBySaldemoid()
   	 * @ author LiuTuo
   	 * @ date 2015-10-29 16:59:47
   	 * @ description 查询所有模板信息列表
   	 * @ reviewed_by
   	 */
    public SalaryDemo findSaldemoBySaldemoid(Long saldemoid) throws DaoException;
    /** 
 	 * @  void delelebydemoid(SalaryDemo salaryDemo) 
 	 * @ author LiuTuo
 	 * @ date 2015-11-10 14:47:55
 	 * @ description 根saldemoid删除工资项
 	 */
     public int delsaldemobyid(SalaryDemo salaryDemo) throws DaoException;
}