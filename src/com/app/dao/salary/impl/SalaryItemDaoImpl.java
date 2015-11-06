package com.app.dao.salary.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.dao.salary.ISalaryItemDao;
import com.app.domain.salary.SalaryItem;
import com.app.utils.exception.DaoException;

@Component
public class SalaryItemDaoImpl implements ISalaryItemDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public int saveSalItem(SalaryItem salaryItem) throws DaoException {
		return sqlSessionTemplate.insert("com.app.domain.salary.SalaryItem.saveSalItem", salaryItem);
	}

	@Override
	public Long getsalitemid() throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.domain.salary.SalaryItem.getsalitemid");
	}

	@Override
	public List<SalaryItem> findSalItemByDemoid(Long demoid)
			throws DaoException {
		return sqlSessionTemplate.selectList("com.app.domain.salary.SalaryItem.findSalItemByDemoid",demoid);
	}

	@Override
	public List<SalaryItem> findSalItemByEleid(Long eleid) throws DaoException {
		return sqlSessionTemplate.selectList("com.app.domain.salary.SalaryItem.findSalItemByEleid",eleid);
	}

	@Override
	public int updateSalItembyid(SalaryItem salaryItem) throws DaoException {
		return sqlSessionTemplate.insert("com.app.domain.salary.SalaryItem.updateSalItembyid", salaryItem);
	}

	@Override
	public List<SalaryItem> findPellistByDemoid(Long demoid)
			throws DaoException {
		return sqlSessionTemplate.selectList("com.app.domain.salary.SalaryItem.findPellistByDemoid",demoid);
	}

	@Override
	public List<SalaryItem> findPeldelistByPeid(Long peid) throws DaoException {
		return sqlSessionTemplate.selectList("com.app.domain.salary.SalaryItem.findPeldelistByPeid",peid);
	}

	@Override
	public String findPenameByPeid(Long peid) throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.domain.salary.SalaryItem.findPenameByPeid",peid);
	}

}
