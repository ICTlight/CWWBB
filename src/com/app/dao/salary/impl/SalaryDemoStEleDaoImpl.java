package com.app.dao.salary.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.dao.salary.ISalaryDemoStEleDao;
import com.app.domain.salary.SalaryDemoStEle;
import com.app.utils.exception.DaoException;

@Component
public class SalaryDemoStEleDaoImpl implements ISalaryDemoStEleDao {

	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int saveSaldemostele(SalaryDemoStEle salarydemostele)
			throws DaoException {
		return sqlSessionTemplate.insert("com.app.domain.salary.SalaryDemoStEle.saveSaldemostele", salarydemostele);
	}

	@Override
	public Long getsaldemosteleid() throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.domain.salary.SalaryDemoStEle.getsaldemosteleid");
	}

	@Override
	public List<SalaryDemoStEle> findSaldemosteleBydemoid(Long demoid)
			throws DaoException {
		return sqlSessionTemplate.selectList("com.app.domain.salary.SalaryDemoStEle.findSaldemosteleBydemoid",demoid);
	}

	@Override
	public SalaryDemoStEle findSaldemosteleByEleid(Long eleid)
			throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.domain.salary.SalaryDemoStEle.findSaldemosteleByEleid",eleid);
	}

	@Override
	public int updateSaldemostelebyid(SalaryDemoStEle salarydemostele)
			throws DaoException {
		return sqlSessionTemplate.insert("com.app.domain.salary.SalaryDemoStEle.updateSaldemostelebyid", salarydemostele);
	}

	@Override
	public void deleteSaldemosteleBydemoid(Long demoid) throws DaoException {
		sqlSessionTemplate.update("com.app.domain.salary.SalaryDemoStEle.deleteSaldemosteleBydemoid",demoid);		
	}

}
