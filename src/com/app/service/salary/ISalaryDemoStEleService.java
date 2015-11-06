package com.app.service.salary;

import java.util.List;

import com.app.domain.salary.SalaryDemoStEle;
import com.app.utils.exception.DaoException;
import com.app.utils.exception.ServiceException;

public interface ISalaryDemoStEleService {

	/** 
	 * @ boolean saveSaldemostele(SalaryDemoEle salarydemostele)
	 * @ author LiuTuo
	 * @ date 2015-11-1 19:42:25
	 * @ description 添加工资模板项
	 */
    public boolean saveSaldemostele(SalaryDemoStEle salarydemostele) throws ServiceException;
    
    /** 
	 * @ long getsaldemosteleid()
	 * @ author LiuTuo
	 * @ date 2015-11-1 19:42:30
	 * @ description 获取最新的id
	 */
    public Long getsaldemosteleid() throws ServiceException;
    
    /** 
   	 * @ List<SalaryDemoEle> findSaldemosteleBydemoid()
   	 * @ author LiuTuo
   	 * @ date 2015-11-1 19:42:35
   	 * @ description 查询所有模板信息列表
   	 * @ reviewed_by
   	 */
    public List<SalaryDemoStEle> findSaldemosteleBydemoid(Long demoid) throws ServiceException;

    /** 
   	 * @ SalaryDemoStEle findSaldemosteleByEleid()
   	 * @ author LiuTuo
   	 * @ date 2015-11-1 19:42:41
   	 * @ description 查询模板项详细信息
   	 * @ reviewed_by
   	 */
    public SalaryDemoStEle findSaldemosteleByEleid(Long eleid) throws ServiceException;
    
    /** 
	 * @ boolean updateSaldemostelebyid(SalaryDemostEle salarydemostele)
	 * @ author LiuTuo
	 * @ date 2015-11-1 19:42:45
	 * @ description 修改工资模板项
	 */
    public boolean updateSaldemostelebyid(SalaryDemoStEle salarydemostele) throws ServiceException;
    
    /** 
	 * @ void updateSaldemostelebyid(SalaryDemostEle salarydemostele)
	 * @ author LiuTuo
	 * @ date 2015-11-1 22:32:14
	 * @ description 修改工资模板项
	 */
    public void deleteSaldemosteleBydemoid(Long demoid) throws ServiceException;
}
