package com.app.salary.dao;

import java.util.List;
import com.app.salary.domain.SalaryItem;
import com.app.utils.exception.DaoException;

public interface ISalaryItemDao {

	/** 
	 * @ int saveSalItem(SalaryItem salaryItem)
	 * @ author LiuTuo
	 * @ date 2015-11-2 14:00:44
	 * @ description 添加工资模板项
	 */
    public int saveSalItem(SalaryItem salaryItem) throws DaoException;
    
    /** 
	 * @ long getsalitemid()
	 * @ author LiuTuo
	 * @ date 2015-11-2 14:00:41
	 * @ description 获取最新的id
	 */
    public Long getsalitemid() throws DaoException;
    
    /** 
   	 * @ List<SalaryItem> findSalItemByDemoid()
   	 * @ author LiuTuo
   	 * @ date 2015-11-2 14:00:36
   	 * @ description 查询所有模板信息列表
   	 * @ reviewed_by
   	 */
    public List<SalaryItem> findSalItemByDemoid(Long demoid) throws DaoException;
    
    /** 
   	 * @ List<SalaryItem> findPeldelistByPeid()
   	 * @ author LiuTuo
   	 * @ date 2015-11-2 14:00:36
   	 * @ description 查询员工薪酬信息列表
   	 * @ reviewed_by
   	 */
    public List<SalaryItem> findPeldelistByPeid(Long peid) throws DaoException;
    
    /** 
   	 * @ SalaryItem findDemoByPeid(Long peid)
   	 * @ author LiuTuo
   	 * @ date 2015-11-25 14:06:11
   	 * @ description 查询员工所在的工资模板信息
   	 * @ reviewed_by
   	 */
    public SalaryItem findDemoByPeid(Long peid) throws DaoException;

    /** 
   	 * @ List<SalaryItem> findSallistByType(SalaryItem salaryItem)
   	 * @ author LiuTuo
   	 * @ date 2015-11-18 10:06:06
   	 * @ description 根据计算类型查询列表
   	 * @ reviewed_by
   	 */
    public List<SalaryItem> findSallistByType(SalaryItem salaryItem) throws DaoException;
    /** 
   	 * @ SalaryItem findCptypelist(Long demoid)
   	 * @ author LiuTuo
   	 * @ date 2015-11-18 09:54:52
   	 * @ description 查询模板项计算类型
   	 * @ reviewed_by
   	 */
    public List<SalaryItem> findCptypelist(Long demoid) throws DaoException;
    /** 
   	 * @ SalaryItem findSalItemByEleid()
   	 * @ author LiuTuo
   	 * @ date 2015-11-2 14:00:32
   	 * @ description 查询模板项详细信息
   	 * @ reviewed_by
   	 */
    public List<SalaryItem> findSalItemByEleid(Long eleid) throws DaoException;
    
    /** 
   	 * @ List<SalaryItem> findPellistByDemoid(Long demoid)
   	 * @ author LiuTuo
   	 * @ date 2015-11-2 14:00:32
   	 * @ description 查询模板项详细信息
   	 * @ reviewed_by181 4900 1135
   	 */
    public List<SalaryItem> findPellistByDemoid(Long demoid) throws DaoException;
    /** 
	 * @ int updateSalItembyid(SalaryItem salaryItem)
	 * @ author LiuTuo
	 * @ date 2015-11-2 14:00:26
	 * @ description 修改工资模板项
	 */
    public int updateSalItembyid(SalaryItem salaryItem) throws DaoException;
    
    /** 
	 * @  String findPenameByPeid(Long peid) 
	 * @ author LiuTuo
	 * @ date 2015-11-3 10:12:45
	 * @ description 获取员工姓名
	 */
    public String findPenameByPeid(Long peid) throws DaoException;
    /** 
	 * @  void deleteDemopel(Long peid)
	 * @ author LiuTuo
	 * @ date 2015-11-10 14:47:55
	 * @ description 根据peid删除工资项
	 */
    public int deleteDemopel(SalaryItem salaryItem) throws DaoException;
    /** 
	 * @  void deleteDemopelbyeleid(Long peid)
	 * @ author LiuTuo
	 * @ date 2015-11-10 14:47:55
	 * @ description 根据peid删除工资项
	 */
    public int deleteDemopelbyeleid(SalaryItem salaryItem) throws DaoException;
    /** 
	 * @  void deleteDemopelbydemoid(Long peid)
	 * @ author LiuTuo
	 * @ date 2015-11-10 14:47:55
	 * @ description 根据peid删除工资项
	 */
    public int deleteDemopelbydemoid(SalaryItem salaryItem) throws DaoException;
    
    /** 
   	 * @ List<SalaryItem> findSalstlistByDemoid()
   	 * @ author LiuTuo
   	 * @ date 2015-11-26 17:02:28
   	 * @ description 查询模板内社保项信息列表
   	 * @ reviewed_by
   	 */
    public List<SalaryItem> findSalstlistByPeid(Long peid) throws DaoException;
    
    /** 
   	 * @ List<SalaryItem> findDemoIdnumber(SalaryItem salaryItem)
   	 * @ author LiuTuo
   	 * @ date 2015-12-16 10:03:55
   	 * @ description 查询该身份证员工是否已经在公司模板中
   	 * @ reviewed_by
   	 */
    public List<SalaryItem> findDemoIdnumber(SalaryItem salaryItem) throws DaoException;
}
