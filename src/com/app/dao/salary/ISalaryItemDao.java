package com.app.dao.salary;

import java.util.List;
import com.app.domain.salary.SalaryItem;
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
}
