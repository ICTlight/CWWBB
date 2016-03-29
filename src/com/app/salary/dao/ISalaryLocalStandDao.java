package com.app.salary.dao;

import java.util.List;
import com.app.salary.domain.SalaryLocalStand;
import com.app.utils.exception.DaoException;

public interface ISalaryLocalStandDao {

	/** 
   	 * @ SalaryLocalStand findSalLocalStandByAreacode(String areacode)
   	 * @ author LiuTuo
   	 * @ date 2015-11-26 14:23:02
   	 * @ description 查询查询社保公积金地方标准详细信息
   	 * @ reviewed_by
   	 */
    public SalaryLocalStand findSalLocalStandByAreacode(String areacode) throws DaoException;
    
    /** 
   	 * @  List<SalaryLocalStand> findSalLocalStandList()
   	 * @ author LiuTuo
   	 * @ date 2015-11-26 14:22:57
   	 * @ description 查询社保公积金地方标准列表
   	 * @ reviewed_by
   	 */
    public List<SalaryLocalStand> findSalLocalStandList() throws DaoException;
}
