package com.app.cpsal.dao;

import java.util.List;

import com.app.cpsal.domain.SalaryPayItems;
import com.app.utils.exception.DaoException;

public interface ISalaryPayItemsDao {

	/** 
	 * @ int saveSalpayItem(SalaryPayItems salaryPayItems)
	 * @ author LiuTuo
	 * @ date 2015-11-27 16:11:03
	 * @ description 保存薪资计算结果项
	 */
    public int saveSalpayItem(SalaryPayItems salaryPayItems) throws DaoException;
    
    /** 
	 * @ long getsalpayitemid()
	 * @ author LiuTuo
	 * @ date 2015-11-27 16:12:43
	 * @ description 获取最新的id
	 */
    public Long getsalpayitemid() throws DaoException;
    
    /** 
   	 * @ List<SalaryPayItems> findPeldelistByPeid()
   	 * @ author LiuTuo
   	 * @ date 2015-12-11 16:03:16
   	 * @ description 查询员工薪酬信息列表
   	 * @ reviewed_by
   	 */
    public List<SalaryPayItems> findPeldelistByPeid(Long peid) throws DaoException;
    
    /** 
   	 * @ List<SalaryPayItems> findSallistByType(SalaryPayItems salaryItem)
   	 * @ author LiuTuo
   	 * @ date 2015-12-11 16:10:48
   	 * @ description 根据计算类型查询列表
   	 * @ reviewed_by
   	 */
    public List<SalaryPayItems> findSallistByType(SalaryPayItems salaryItem) throws DaoException;
    /** 
   	 * @ SalaryPayItems findCptypelist(Long demoid)
   	 * @ author LiuTuo
   	 * @ date 2015-12-11 16:10:56
   	 * @ description 查询模板项计算类型
   	 * @ reviewed_by
   	 */
    public List<SalaryPayItems> findCptypelist(Long demoid) throws DaoException;
    
    /** 
   	 * @ List<SalaryPayItems> findSalItemByDemoid()
   	 * @ author LiuTuo
   	 * @ date 2015-12-11 16:32:23
   	 * @ description 查询所有模板信息列表
   	 * @ reviewed_by
   	 */
    public List<SalaryPayItems> findSalItemByDemoid(Long demoid) throws DaoException;
    
    /** 
   	 * @ List<SalaryPayItems> findPellistByDemoid(Long demoid)
   	 * @ author LiuTuo
   	 * @ date 2015-12-11 16:35:46
   	 * @ description 查询模板项详细信息
   	 * @ reviewed_by
   	 */
    public List<SalaryPayItems> findPellistByDemoid(Long demoid) throws DaoException;
    /** 
	 * @  void deletePayitembypeid(Long peid)
	 * @ author LiuTuo
	 * @ date 2015-11-10 14:47:55
	 * @ description 根据peid删除工资项
	 */
    public int deletePayitembypeid(SalaryPayItems salaryItem) throws DaoException;
    /** 
	 * @  void deletePayitembybyeleid(Long peid)
	 * @ author LiuTuo
	 * @ date 2015-11-10 14:47:55
	 * @ description 根据peid删除工资项
	 */
    public int deletePayitembybyeleid(SalaryPayItems salaryItem) throws DaoException;
    /** 
	 * @  void deletePayitembydemoid(Long peid)
	 * @ author LiuTuo
	 * @ date 2015-11-10 14:47:55
	 * @ description 根据peid删除工资项
	 */
    public int deletePayitembydemoid(SalaryPayItems salaryItem) throws DaoException;
    

}
