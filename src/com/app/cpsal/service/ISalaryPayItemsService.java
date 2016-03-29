package com.app.cpsal.service;

import java.util.List;
import com.app.cpsal.domain.SalaryPayItems;
import com.app.utils.exception.ServiceException;

public interface ISalaryPayItemsService {

	/** 
	 * @ Boolean saveSalpayItem(SalaryPayItems salaryPayItems)
	 * @ author LiuTuo
	 * @ date 2015-11-27 16:19:08
	 * @ description 保存薪资计算结果项
	 */
    public boolean saveSalpayItem(SalaryPayItems salaryPayItems) throws ServiceException;
    
    /** 
	 * @ long getsalpayitemid()
	 * @ author LiuTuo
	 * @ date 2015-11-27 16:19:04
	 * @ description 获取最新的id
	 */
    public Long getsalpayitemid() throws ServiceException;
    
    /** 
   	 * @ List<SalaryPayItems> findPeldelistByPeid()
   	 * @ author LiuTuo
   	 * @ date 2015-12-11 16:02:40
   	 * @ description 查询员工薪酬信息列表
   	 * @ reviewed_by
   	 */
    public List<SalaryPayItems> findPeldelistByPeid(Long peid) throws ServiceException;
    
    /** 
   	 * @ List<SalaryPayItems> findSallistByType(SalaryPayItems salaryItem)
   	 * @ author LiuTuo
   	 * @ date 2015-12-11 16:10:48
   	 * @ description 根据计算类型查询列表
   	 * @ reviewed_by
   	 */
    public List<SalaryPayItems> findSallistByType(SalaryPayItems salaryItem) throws ServiceException;
    /** 
   	 * @ SalaryPayItems findCptypelist(Long demoid)
   	 * @ author LiuTuo
   	 * @ date 2015-12-11 16:10:56
   	 * @ description 查询模板项计算类型
   	 * @ reviewed_by
   	 */
    public List<SalaryPayItems> findCptypelist(Long demoid) throws ServiceException;
    
    /** 
   	 * @ List<SalaryPayItems> findSalItemByDemoid()
   	 * @ author LiuTuo
   	 * @ date 2015-12-11 16:32:23
   	 * @ description 查询所有模板信息列表
   	 * @ reviewed_by
   	 */
    public List<SalaryPayItems> findSalItemByDemoid(Long demoid) throws ServiceException;
    
    /** 
   	 * @ List<SalaryPayItems> findPellistByDemoid(Long demoid)
   	 * @ author LiuTuo
   	 * @ date 2015-12-11 16:35:46
   	 * @ description 查询模板项详细信息
   	 * @ reviewed_by
   	 */
    public List<SalaryPayItems> findPellistByDemoid(Long demoid) throws ServiceException;
    
    /** 
	 * @  void deletePayitembypeid(Long peid)
	 * @ author LiuTuo
	 * @ date 2015-11-10 14:47:55
	 * @ description 根据peid删除工资项
	 */
    public boolean deletePayitembypeid(SalaryPayItems salaryItem) throws ServiceException;
    /** 
	 * @  void deletePayitembybyeleid(Long peid)
	 * @ author LiuTuo
	 * @ date 2015-11-10 14:47:55
	 * @ description 根据peid删除工资项
	 */
    public boolean deletePayitembybyeleid(SalaryPayItems salaryItem) throws ServiceException;
    /** 
	 * @  void deletePayitembydemoid(Long peid)
	 * @ author LiuTuo
	 * @ date 2015-11-10 14:47:55
	 * @ description 根据peid删除工资项
	 */
    public boolean deletePayitembydemoid(SalaryPayItems salaryItem) throws ServiceException;
}
