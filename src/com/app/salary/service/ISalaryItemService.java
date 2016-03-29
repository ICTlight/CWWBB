package com.app.salary.service;

import java.util.List;
import com.app.salary.domain.SalaryItem;
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
   	 * @ SalaryItem findCptypelist(Long demoid)
   	 * @ author LiuTuo
   	 * @ date 2015-11-18 09:57:10
   	 * @ description 查询模板项计算类型
   	 * @ reviewed_by
   	 */
    public List<SalaryItem> findCptypelist(Long demoid) throws ServiceException;
    /** 
   	 * @ List<SalaryItem> findSallistByType(SalaryItem salaryItem)
   	 * @ author LiuTuo
   	 * @ date 2015-11-18 10:06:06
   	 * @ description 根据计算类型查询列表
   	 * @ reviewed_by
   	 */
    public List<SalaryItem> findSallistByType(SalaryItem salaryItem) throws ServiceException;
    
    /** 
	 * @  String findPenameByPeid(Long peid) 
	 * @ author LiuTuo
	 * @ date 2015-11-3 10:14:36
	 * @ description 获取员工姓名
	 */
    public String findPenameByPeid(Long peid) throws ServiceException;
    
    /** 
	 * @ boolean deleteDemopelByPeid(Long peid)
	 * @ author LiuTuo
	 * @ date 2015-11-10 15:12:50
	 * @ description 将该模板下的员工薪资信息置废
	 */
    public boolean deleteDemopel(SalaryItem salaryItem) throws ServiceException;
    /** 
	 * @ boolean deleteDemopelByPeid(Long peid)
	 * @ author LiuTuo
	 * @ date 2015-11-10 15:12:50
	 * @ description 将该模板下的员工薪资信息置废
	 */
    public boolean deleteDemopelbyeleid(SalaryItem salaryItem) throws ServiceException;
    /** 
	 * @ boolean deleteDemopelByPeid(Long peid)
	 * @ author LiuTuo
	 * @ date 2015-11-10 15:12:50
	 * @ description 将该模板下的员工薪资信息置废
	 */
    public boolean deleteDemopelbydemoid(SalaryItem salaryItem) throws ServiceException;
    
    /** 
   	 * @ SalaryItem findDemoByPeid(Long peid)
   	 * @ author LiuTuo
   	 * @ date 2015-11-25 14:06:11
   	 * @ description 查询员工所在的工资模板信息
   	 * @ reviewed_by
   	 */
    public SalaryItem findDemoByPeid(Long peid) throws ServiceException;
    
    /** 
   	 * @ List<SalaryItem> findSalstlistByDemoid()
   	 * @ author LiuTuo
   	 * @ date  2015-11-26 17:02:17
   	 * @ description 查询模板内社保项信息列表
   	 * @ reviewed_by
   	 */
    public List<SalaryItem> findSalstlistByPeid(Long peid) throws ServiceException;
    
    /** 
   	 * @ List<SalaryItem> findDemoIdnumber(SalaryItem salaryItem)
   	 * @ author LiuTuo
   	 * @ date 2015-12-16 10:03:55
   	 * @ description 查询该身份证员工是否已经在公司模板中
   	 * @ reviewed_by
   	 */
    public List<SalaryItem> findDemoIdnumber(SalaryItem salaryItem) throws ServiceException;
}
