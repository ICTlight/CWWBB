package com.app.salary.dao;

import java.util.List;

import com.app.salary.domain.SalaryDemoStEle;
import com.app.salary.domain.SalaryStandEle;
import com.app.utils.exception.DaoException;

public interface ISalaryDemoStEleDao {

	/** 
	 * @ int saveSaldemostele(SalaryDemoEle salarydemostele)
	 * @ author LiuTuo
	 * @ date 2015-11-1 19:27:19
	 * @ description 添加工资模板项
	 */
    public int saveSaldemostele(SalaryDemoStEle salarydemostele) throws DaoException;
    
    /** 
	 * @ long getsaldemosteleid()
	 * @ author LiuTuo
	 * @ date 2015-11-1 19:27:14
	 * @ description 获取最新的id
	 */
    public Long getsaldemosteleid() throws DaoException;
    
    /** 
   	 * @ List<SalaryDemoEle> findSaldemosteleBydemoid()
   	 * @ author LiuTuo
   	 * @ date 2015-11-1 19:27:09
   	 * @ description 查询所有模板信息列表
   	 * @ reviewed_by
   	 */
    public List<SalaryDemoStEle> findSaldemosteleBydemoid(Long demoid) throws DaoException;

    /** 
   	 * @ SalaryDemoStEle findSaldemosteleByEleid()
   	 * @ author LiuTuo
   	 * @ date 2015-11-1 19:27:04
   	 * @ description 查询模板项详细信息
   	 * @ reviewed_by
   	 */
    public SalaryDemoStEle findSaldemosteleByEleid(Long eleid) throws DaoException;
    
    /** 
	 * @ int updateSaldemostelebyid(SalaryDemostEle salarydemostele)
	 * @ author LiuTuo
	 * @ date 2015-11-1 19:26:59
	 * @ description 修改工资模板项
	 */
    public int updateSaldemostelebyid(SalaryDemoStEle salarydemostele) throws DaoException;
    
    /** 
	 * @ void updateSaldemostelebyid(SalaryDemostEle salarydemostele)
	 * @ author LiuTuo
	 * @ date 2015-11-1 22:31:45
	 * @ description 修改工资模板项
	 */
    public void deleteSaldemosteleBydemoid(Long demoid) throws DaoException;
    
    /** 
	 * @  void delstelebyeleid(SalaryDemoStEle salarydemostele)
	 * @ author LiuTuo
	 * @ date 2015-11-10 14:47:55
	 * @ description 根据peid删除工资项
	 */
    public int delstelebyeleid(SalaryDemoStEle salarydemostele) throws DaoException;
    /** 
	 * @ void delstelebydemoid(SalaryDemoStEle salarydemostele)
	 * @ author LiuTuo
	 * @ date 2015-11-10 14:47:55
	 * @ description 根据peid删除工资项
	 */
    public int delstelebydemoid(SalaryDemoStEle salarydemostele) throws DaoException;
    
    /** 
   	 * @ List<SalaryDemoEle> findBasecodeBydemoid()
   	 * @ author LiuTuo
   	 * @ date 2015-11-1 19:27:09
   	 * @ description 查询模板下的社保基数
   	 * @ reviewed_by
   	 */
    public List<SalaryDemoStEle> findBasecodeBydemoid(Long demoid) throws DaoException;
}
