package com.app.salary.dao;

import java.util.List;

import com.app.salary.domain.SalaryItem;
import com.app.salary.domain.SalaryStandEle;
import com.app.utils.exception.DaoException;

public interface ISalaryStandEleDao {

	/** 
   	 * @ List<SalaryStandEle> findallStandEle()
   	 * @ author LiuTuo
   	 * @ date 2015-11-1 19:29:29
   	 * @ description 查询所有社保公积金信息列表
   	 * @ reviewed_by
   	 */
    public List<SalaryStandEle> findallStandEle() throws DaoException;
    
    /** 
   	 * @ SalaryStandEle findStandEleByElename(String elename)
   	 * @ author LiuTuo
   	 * @ date 2015-11-1 22:40:27
   	 * @ description 查询社保公积金信息
   	 * @ reviewed_by
   	 */
    public SalaryStandEle findStandEleByElename(String elename) throws DaoException;
}
