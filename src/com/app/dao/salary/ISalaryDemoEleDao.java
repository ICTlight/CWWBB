package com.app.dao.salary;

import java.util.List;

import com.app.domain.salary.SalaryDemo;
import com.app.domain.salary.SalaryDemoEle;
import com.app.utils.exception.DaoException;

public interface ISalaryDemoEleDao {
	/** 
	 * @ int saveSaldemoEle(SalaryDemoEle salarydemoele)
	 * @ author LiuTuo
	 * @ date 2015-10-30 11:53:05
	 * @ description 添加工资模板项
	 */
    public int saveSaldemoEle(SalaryDemoEle salarydemoele) throws DaoException;
    
    /** 
	 * @ long getsaldemoeleid()
	 * @ author LiuTuo
	 * @ date 2015-10-30 11:54:40
	 * @ description 获取最新的id
	 */
    public Long getsaldemoeleid() throws DaoException;
    
    /** 
   	 * @ List<SalaryDemoEle> findSaldemoeleBydemoid()
   	 * @ author LiuTuo
   	 * @ date 2015-10-29 16:59:47
   	 * @ description 查询所有模板信息列表
   	 * @ reviewed_by
   	 */
    public List<SalaryDemoEle> findSaldemoeleBydemoid(Long demoid) throws DaoException;

    /** 
   	 * @ SalaryDemoEle findSaldemoEleByEleid()
   	 * @ author LiuTuo
   	 * @ date 2015-10-30 11:55:55
   	 * @ description 查询模板项详细信息
   	 * @ reviewed_by
   	 */
    public SalaryDemoEle findSaldemoEleByEleid(Long eleid) throws DaoException;
}
