package com.app.service.salary;

import java.util.List;

import com.app.domain.salary.SalaryItem;
import com.app.utils.exception.DaoException;
import com.app.utils.exception.ServiceException;

public interface ISalaryItemService {

	/** 
	 * @ boolean saveSalItem(SalaryItem salaryItem)
	 * @ author LiuTuo
	 * @ date 2015-11-2 14:08:40
	 * @ description 添加工资模板项
	 */
    public boolean saveSalItem(SalaryItem salaryItem) throws ServiceException;
    
    /** 
	 * @ long getsalitemid()
	 * @ author LiuTuo
	 * @ date 2015-11-2 14:08:35
	 * @ description 获取最新的id
	 */
    public Long getsalitemid() throws ServiceException;
    
    /** 
   	 * @ List<SalaryItem> findSalItemByDemoid()
   	 * @ author LiuTuo
   	 * @ date 2015-11-2 14:08:32
   	 * @ description 查询所有模板信息列表
   	 * @ reviewed_by
   	 */
    public List<SalaryItem> findSalItemByDemoid(Long demoid) throws ServiceException;

    /** 
   	 * @ List<SalaryItem> findSalItemByEleid()
   	 * @ author LiuTuo
   	 * @ date 2015-11-2 14:08:28
   	 * @ description 查询模板项详细信息
   	 * @ reviewed_by
   	 */
    public List<SalaryItem> findSalItemByEleid(Long eleid) throws ServiceException;
    
    /** 
	 * @ boolean updateSalItembyid(SalaryItem salaryItem)
	 * @ author LiuTuo
	 * @ date 2015-11-2 14:08:23
	 * @ description 修改工资模板项
	 */
    public boolean updateSalItembyid(SalaryItem salaryItem) throws ServiceException;
    
    /** 
   	 * @ List<SalaryItem> findPellistByDemoid(Long demoid)
   	 * @ author LiuTuo
   	 * @ date 2015-11-2 14:00:32
   	 * @ description 查询模板项详细信息
   	 * @ reviewed_by181 4900 1135
   	 */
    public List<SalaryItem> findPellistByDemoid(Long demoid) throws ServiceException;
    /** 
   	 * @ List<SalaryItem> findPeldelistByPeid(Long peid)
   	 * @ author LiuTuo
   	 * @ date 2015-11-2 14:00:32
   	 * @ description 查询模板项详细信息
   	 * @ reviewed_by181 4900 1135
   	 */
    public List<SalaryItem> findPeldelistByPeid(Long peid) throws ServiceException;
    
    /** 
	 * @  String findPenameByPeid(Long peid) 
	 * @ author LiuTuo
	 * @ date 2015-11-3 10:14:36
	 * @ description 获取员工姓名
	 */
    public String findPenameByPeid(Long peid) throws ServiceException;
}
