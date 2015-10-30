package com.app.service.salary;

import java.util.List;
import com.app.domain.salary.SalaryDemo;
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

}
