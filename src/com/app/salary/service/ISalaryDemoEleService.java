package com.app.salary.service;

import java.util.List;

import com.app.salary.domain.SalaryDemoEle;
import com.app.salary.domain.SalaryDemoStEle;
import com.app.utils.exception.ServiceException;
public interface ISalaryDemoEleService {

	/** 
	 * @ boolean saveSaldemoEle(SalaryDemoEle salarydemoele) 
	 * @ author LiuTuo
	 * @ date 2015-10-30 13:14:40
	 * @ description 添加工资模板项
	 */
    public boolean saveSaldemoEle(SalaryDemoEle salarydemoele) throws ServiceException;
    
    /** 
	 * @ long getsaldemoeleid()
	 * @ author LiuTuo
	 * @ date 2015-10-30 13:14:46
	 * @ description 获取最新的id
	 */
    public Long getsaldemoeleid() throws ServiceException;
    
    /** 
   	 * @ List<SalaryDemoEle> findSaldemoeleBydemoid()
   	 * @ author LiuTuo
   	 * @ date 2015-10-30 13:14:54
   	 * @ description 查询所有模板信息列表
   	 * @ reviewed_by
   	 */
    public List<SalaryDemoEle> findSaldemoeleBydemoid(Long demoid) throws ServiceException;

    /** 
   	 * @ SalaryDemoEle findSaldemoEleByEleid()
   	 * @ author LiuTuo
   	 * @ date 2015-10-30 13:14:59
   	 * @ description 查询模板项详细信息
   	 * @ reviewed_by
   	 */
    public SalaryDemoEle findSaldemoEleByEleid(Long eleid) throws ServiceException;
    
    /** 
	 * @ boolean updateSalDemoelebyid(SalaryDemoEle salarydemoele) 
	 * @ author LiuTuo
	 * @ date 2015-11-1 09:24:25
	 * @ description 修改工资模板项
	 */
    public boolean updateSalDemoelebyid(SalaryDemoEle salarydemoele) throws ServiceException;
    
    /** 
	 * @ boolean delelebyeleid(SalaryDemoEle salarydemoele)
	 * @ author LiuTuo
	 * @ date 2015-11-10 15:12:50
	 * @ description 将该模板下的员工薪资信息置废
	 */
    public boolean delelebyeleid(SalaryDemoEle salarydemoele) throws ServiceException;
    /** 
	 * @ boolean delstelebydemoid(SalaryDemoEle salarydemoele)
	 * @ author LiuTuo
	 * @ date 2015-11-10 15:12:50
	 * @ description 将该模板下的员工薪资信息置废
	 */
    public boolean delelebydemoid(SalaryDemoEle salarydemoele) throws ServiceException;
}
