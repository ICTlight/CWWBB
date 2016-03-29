package com.app.cpsal.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.cpsal.dao.ISalaryPayItemsDao;
import com.app.cpsal.domain.SalaryPayItems;
import com.app.utils.exception.DaoException;
@Component
public class SalaryPayItemsDaoImpl implements ISalaryPayItemsDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public int saveSalpayItem(SalaryPayItems salaryPayItems)
			throws DaoException {
		return sqlSessionTemplate.insert("com.app.cpsal.domain.SalaryPayItems.saveSalpayItem", salaryPayItems);
	}

	@Override
	public Long getsalpayitemid() throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.cpsal.domain.SalaryPayItems.getsalpayitemid");
	}

	@Override
	public List<SalaryPayItems> findPeldelistByPeid(Long peid)
			throws DaoException {
		return sqlSessionTemplate.selectList("com.app.cpsal.domain.SalaryPayItems.findPeldelistByPeid",peid);
	}

	@Override
	public List<SalaryPayItems> findSallistByType(SalaryPayItems salaryItem)
			throws DaoException {
		return sqlSessionTemplate.selectList("com.app.cpsal.domain.SalaryPayItems.findSallistByType",salaryItem);
	}

	@Override
	public List<SalaryPayItems> findCptypelist(Long demoid) throws DaoException {
		return sqlSessionTemplate.selectList("com.app.cpsal.domain.SalaryPayItems.findCptypelist",demoid);
	}

	@Override
	public List<SalaryPayItems> findSalItemByDemoid(Long demoid)
			throws DaoException {
		return sqlSessionTemplate.selectList("com.app.cpsal.domain.SalaryPayItems.findSalItemByDemoid",demoid);
	}

	@Override
	public List<SalaryPayItems> findPellistByDemoid(Long demoid)
			throws DaoException {
		return sqlSessionTemplate.selectList("com.app.cpsal.domain.SalaryPayItems.findPellistByDemoid",demoid);
	}

	@Override
	public int deletePayitembypeid(SalaryPayItems salaryItem)
			throws DaoException {
		return sqlSessionTemplate.delete("com.app.cpsal.domain.SalaryPayItems.deletePayitembypeid", salaryItem);
	}

	@Override
	public int deletePayitembybyeleid(SalaryPayItems salaryItem)
			throws DaoException {
		return sqlSessionTemplate.insert("com.app.cpsal.domain.SalaryPayItems.deletePayitembybyeleid", salaryItem);
	}

	@Override
	public int deletePayitembydemoid(SalaryPayItems salaryItem)
			throws DaoException {
		return sqlSessionTemplate.insert("com.app.cpsal.domain.SalaryPayItems.deletePayitembydemoid", salaryItem);
	}

}
