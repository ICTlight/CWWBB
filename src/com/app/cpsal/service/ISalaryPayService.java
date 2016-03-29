package com.app.cpsal.service;

import java.util.List;
import java.util.Map;
import com.app.cpsal.domain.SalaryPay;
import com.app.utils.exception.ServiceException;

public interface ISalaryPayService {

	/** 
	 * @ boolean saveSalPay(SalaryPay salaryPay)
	 * @ author LiuTuo
	 * @ date 2015-11-17 18:31:57
	 * @ description 统计数据
	 */
    public boolean saveSalPay(SalaryPay salaryPay) throws ServiceException;
    
    /** 
	 * @ long getsalpayid()
	 * @ author LiuTuo
	 * @ date 2015-11-17 18:32:50
	 * @ description 获取最新的id
	 */
    public Long getsalpayid() throws ServiceException;
    
    /** 
	 * @ boolean updateSalPaybyid(SalaryPay salaryPay)
	 * @ author LiuTuo
	 * @ date 2015-11-17 18:34:10
	 * @ description 修改统计数据
	 */
    public boolean updateSalPaybyid(SalaryPay salaryPay) throws ServiceException;
    
    /** 
   	 * @ SalaryPay findSalPayByPeid
   	 * @ author LiuTuo
   	 * @ date 2015-11-22 11:40:43
   	 * @ description 
   	 * @ reviewed_by
   	 */
    public SalaryPay findSalPayByPeid(Long peid) throws ServiceException;
    
    /** 
   	 * @ List<SalaryPay> findSalPayByDemoid(Long demoid) 
   	 * @ author LiuTuo
   	 * @ date 2015-11-22 11:40:31
   	 * @ description 
   	 * @ reviewed_by
   	 */
    public List<SalaryPay> findSalPayByDemoid(Long demoid) throws ServiceException;
    
	/**
	 * @ List<Map<String,Object>> findSalComputeInfo()
	 * @ author LiuTuo
	 * @ date 2015-11-24 14:11:44
	 * @ description 
	 * @ reviewed_by 
	 */
	public List<Map<String, Object>> findSalComputeInfo(String addSql,String groupby,
			 Long demoid) throws ServiceException;
	
	/** 
	 * @ boolean updateSPstatubydemoid(SalaryPay salaryPay)
	 * @ author LiuTuo
	 * @ date 2015-11-17 18:34:10
	 * @ description 修改统计数据
	 */
    public boolean updateSPstatubydemoid(SalaryPay salaryPay) throws ServiceException;
    
	/** 
	 * @  void deletePaybypeid(Long peid)
	 * @ author LiuTuo
	 * @ date 2015-11-10 14:47:55
	 * @ description 根据peid删除工资项
	 */
    public boolean deletePaybypeid(SalaryPay salaryItem) throws ServiceException;
    /** 
	 * @  void deletePayitembybyeleid(Long peid)
	 * @ author LiuTuo
	 * @ date 2015-11-10 14:47:55
	 * @ description 根据peid删除工资项
	 */
    public boolean deletePaybybyeleid(SalaryPay salaryItem) throws ServiceException;
}
