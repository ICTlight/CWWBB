package com.app.cpsal.dao;

import com.app.cpsal.domain.SalaryCount;
import com.app.utils.exception.DaoException;

public interface ISalaryCountDao {

	/** 
	 * @ int saveSalCount(SalaryCount salaryCount)
	 * @ author LiuTuo
	 * @ date 2015-11-16 18:31:57
	 * @ description 统计数据
	 */
    public int saveSalCount(SalaryCount salaryCount) throws DaoException;
    
    /** 
	 * @ long getsalcountid()
	 * @ author LiuTuo
	 * @ date 2015-11-16 18:32:50
	 * @ description 获取最新的id
	 */
    public Long getsalcountid() throws DaoException;
    
    /** 
	 * @ int updateSalCountbyid(SalaryCount salaryCount)
	 * @ author LiuTuo
	 * @ date 2015-11-16 18:34:10
	 * @ description 修改统计数据
	 */
    public int updateSalCountbyid(SalaryCount salaryCount) throws DaoException;
    
    /** 
   	 * @ SalaryCount findSalCountByPeid
   	 * @ author LiuTuo
   	 * @ date 2015-11-18 13:14:22
   	 * @ description 查询员工薪酬信息列表
   	 * @ reviewed_by
   	 */
    public SalaryCount findSalCountByPeid(Long peid) throws DaoException;
    
    /** 
	 * @  void deletePaycountbypeid(Long peid)
	 * @ author LiuTuo
	 * @ date 2015-11-10 14:47:55
	 * @ description 根据peid删除工资项
	 */
    public int deletePaycountbypeid(SalaryCount salaryItem) throws DaoException;
    /** 
	 * @  void deletePayitembybyeleid(Long peid)
	 * @ author LiuTuo
	 * @ date 2015-11-10 14:47:55
	 * @ description 根据peid删除工资项
	 */
    public int deletePaycountbybyeleid(SalaryCount salaryItem) throws DaoException;
    /** 
	 * @  void deletePayitembydemoid(Long peid)
	 * @ author LiuTuo
	 * @ date 2015-11-10 14:47:55
	 * @ description 根据peid删除工资项
	 */
    public int deletePaycountbydemoid(SalaryCount salaryItem) throws DaoException;
}
