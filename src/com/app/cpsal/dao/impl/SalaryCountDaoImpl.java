package com.app.cpsal.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.cpsal.dao.ISalaryCountDao;
import com.app.cpsal.domain.SalaryCount;
import com.app.utils.exception.DaoException;
@Component
public class SalaryCountDaoImpl implements ISalaryCountDao{

	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public int saveSalCount(SalaryCount salaryCount) throws DaoException {
		return sqlSessionTemplate.insert("com.app.cpsal.domain.SalaryCount.saveSalCount", salaryCount);
	}

	@Override
	public Long getsalcountid() throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.cpsal.domain.SalaryCount.getsalcountid");
	}

	@Override
	public int updateSalCountbyid(SalaryCount salaryCount) throws DaoException {
		return sqlSessionTemplate.insert("com.app.cpsal.domain.SalaryCount.updateSalCountbyid", salaryCount);
	}

	@Override
	public SalaryCount findSalCountByPeid(Long peid) throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.cpsal.domain.SalaryCount.findSalCountByPeid",peid);
	}

	@Override
	public int deletePaycountbypeid(SalaryCount salaryItem) throws DaoException {
		return sqlSessionTemplate.insert("com.app.cpsal.domain.SalaryCount.deletePaycountbypeid", salaryItem);
	}

	@Override
	public int deletePaycountbybyeleid(SalaryCount salaryItem)
			throws DaoException {
		return sqlSessionTemplate.insert("com.app.cpsal.domain.SalaryCount.deletePaycountbybyeleid", salaryItem);
	}

	@Override
	public int deletePaycountbydemoid(SalaryCount salaryItem)
			throws DaoException {
		return sqlSessionTemplate.insert("com.app.cpsal.domain.SalaryCount.deletePaycountbydemoid", salaryItem);
	}

}
