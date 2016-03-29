package com.app.salary.service;

import java.util.List;
import com.app.salary.domain.SalaryLocalStand;
import com.app.utils.exception.ServiceException;

public interface ISalaryLocalStandService {

	/** 
   	 * @ SalaryLocalStand findSalLocalStandByAreacode(String areacode)
   	 * @ author LiuTuo
   	 * @ date 2015-11-26 14:28:22
   	 * @ description 查询查询社保公积金地方标准详细信息
   	 * @ reviewed_by
   	 */
    public SalaryLocalStand findSalLocalStandByAreacode(String areacode) throws ServiceException;
    
    /** 
   	 * @  List<SalaryLocalStand> findSalLocalStandList()
   	 * @ author LiuTuo
   	 * @ date 2015-11-26 14:28:26
   	 * @ description 查询社保公积金地方标准列表
   	 * @ reviewed_by
   	 */
    public List<SalaryLocalStand> findSalLocalStandList() throws ServiceException;
}
