package com.app.salary.service;

import java.util.List;

import com.app.salary.domain.SalaryStandEle;
import com.app.utils.exception.ServiceException;

public interface ISalaryStandEleService {

	/** 
   	 * @ List<SalaryStandEle> findallStandEle()
   	 * @ author LiuTuo
   	 * @ date 2015-11-1 19:40:08
   	 * @ description 查询所有社保公积金信息列表
   	 * @ reviewed_by
   	 */
    public List<SalaryStandEle> findallStandEle() throws ServiceException;
    /** 
   	 * @ SalaryStandEle findStandEleByElename(String elename)
   	 * @ author LiuTuo
   	 * @ date 2015-11-1 22:40:48
   	 * @ description 查询社保公积金信息
   	 * @ reviewed_by
   	 */
    public SalaryStandEle findStandEleByElename(String elename) throws ServiceException;
}
