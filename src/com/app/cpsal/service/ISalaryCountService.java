package com.app.cpsal.service;

import com.app.cpsal.domain.SalaryCount;
import com.app.utils.exception.DaoException;
import com.app.utils.exception.ServiceException;

public interface ISalaryCountService {

	/** 
	 * @ boolean saveSalCount(SalaryCount salaryCount)
	 * @ author LiuTuo
	 * @ date 2015-11-16 18:31:57
	 * @ description 统计数据
	 */
    public boolean saveSalCount(SalaryCount salaryCount) throws ServiceException;
    
    /** 
	 * @ long getsalcountid()
	 * @ author LiuTuo
	 * @ date 2015-11-16 18:32:50
	 * @ description 获取最新的id
	 */
    public Long getsalcountid() throws ServiceException;
    
    /** 
	 * @ boolean updateSalCountbyid(SalaryCount salaryCount)
	 * @ author LiuTuo
	 * @ date 2015-11-16 18:34:10
	 * @ description 修改统计数据
	 */
    public boolean updateSalCountbyid(SalaryCount salaryCount) throws ServiceException;
    
    /** 
   	 * @ SalaryCount findSalCountByPeid
   	 * @ author LiuTuo
   	 * @ date 2015-11-18 13:14:22
   	 * @ description 查询员工薪酬信息列表
   	 * @ reviewed_by
   	 */
    public SalaryCount findSalCountByPeid(Long peid) throws ServiceException;
    
    /** 
	 * @  void deletePaycountbypeid(Long peid)
	 * @ author LiuTuo
	 * @ date 2015-11-10 14:47:55
	 * @ description 根据peid删除工资项
	 */
    public boolean deletePaycountbypeid(SalaryCount salaryItem) throws DaoException;
    /** 
	 * @  void deletePayitembybyeleid(Long peid)
	 * @ author LiuTuo
	 * @ date 2015-11-10 14:47:55
	 * @ description 根据peid删除工资项
	 */
    public boolean deletePaycountbybyeleid(SalaryCount salaryItem) throws DaoException;
    /** 
	 * @  void deletePayitembydemoid(Long peid)
	 * @ author LiuTuo
	 * @ date 2015-11-10 14:47:55
	 * @ description 根据peid删除工资项
	 */
    public boolean deletePaycountbydemoid(SalaryCount salaryItem) throws DaoException;
}
