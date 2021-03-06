package com.app.cpsal.dao;

import java.util.List;
import java.util.Map;
import com.app.cpsal.domain.SalaryPay;
import com.app.utils.exception.DaoException;

public interface ISalaryPayDao {

	/** 
	 * @ int saveSalPay(SalaryPay salaryPay)
	 * @ author LiuTuo
	 * @ date 2015-11-17 18:31:57
	 * @ description 统计数据
	 */
    public int saveSalPay(SalaryPay salaryPay) throws DaoException;
    
    /** 
	 * @ long getsalpayid()
	 * @ author LiuTuo
	 * @ date 2015-11-17 18:32:50
	 * @ description 获取最新的id
	 */
    public Long getsalpayid() throws DaoException;
    
    /** 
	 * @ int updateSalPaybyid(SalaryPay salaryPay)
	 * @ author LiuTuo
	 * @ date 2015-11-17 18:34:10
	 * @ description 修改统计数据
	 */
    public int updateSalPaybyid(SalaryPay salaryPay) throws DaoException;
    
    /** 
	 * @ int updateSPstatubydemoid(SalaryPay salaryPay)
	 * @ author LiuTuo
	 * @ date 2015-11-17 18:34:10
	 * @ description 修改统计数据
	 */
    public int updateSPstatubydemoid(SalaryPay salaryPay) throws DaoException;
    /** 
   	 * @ SalaryPay findSalPayByPeid
   	 * @ author LiuTuo
   	 * @ date 2015-11-22 11:40:43
   	 * @ description 
   	 * @ reviewed_by
   	 */
    public SalaryPay findSalPayByPeid(Long peid) throws DaoException;
    
    /** 
   	 * @ List<SalaryPay> findSalPayByDemoid(Long demoid) 
   	 * @ author LiuTuo
   	 * @ date 2015-11-22 11:40:31
   	 * @ description 
   	 * @ reviewed_by
   	 */
    public List<SalaryPay> findSalPayByDemoid(Long demoid) throws DaoException;
    
    /**
	 * @ List<Map<String,Object>> findSalComputeInfo()
	 * @ author LiuTuo
	 * @ date 2015-11-24 14:11:44
	 * @ description 
	 * @ reviewed_by 
	 */
	public List<Map<String, Object>> findSalComputeInfo(String addSql,String groupby,
			 Long demoid) throws DaoException;
	
	/** 
	 * @  void deletePaybypeid(Long peid)
	 * @ author LiuTuo
	 * @ date 2015-11-10 14:47:55
	 * @ description 根据peid删除工资项
	 */
    public int deletePaybypeid(SalaryPay salaryItem) throws DaoException;
    /** 
	 * @  void deletePayitembybyeleid(Long peid)
	 * @ author LiuTuo
	 * @ date 2015-11-10 14:47:55
	 * @ description 根据peid删除工资项
	 */
    public int deletePaybybyeleid(SalaryPay salaryItem) throws DaoException;
}
