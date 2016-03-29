package com.app.salary.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.salary.dao.ISalaryDemoStEleDao;
import com.app.salary.domain.SalaryDemoStEle;
import com.app.utils.exception.DaoException;

@Component
public class SalaryDemoStEleDaoImpl implements ISalaryDemoStEleDao {

	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int saveSaldemostele(SalaryDemoStEle salarydemostele)
			throws DaoException {
		return sqlSessionTemplate.insert("com.app.salary.domain.SalaryDemoStEle.saveSaldemostele", salarydemostele);
	}

	@Override
	public Long getsaldemosteleid() throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.salary.domain.SalaryDemoStEle.getsaldemosteleid");
	}

	@Override
	public List<SalaryDemoStEle> findSaldemosteleBydemoid(Long demoid)
			throws DaoException {
		return sqlSessionTemplate.selectList("com.app.salary.domain.SalaryDemoStEle.findSaldemosteleBydemoid",demoid);
	}

	@Override
	public SalaryDemoStEle findSaldemosteleByEleid(Long eleid)
			throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.salary.domain.SalaryDemoStEle.findSaldemosteleByEleid",eleid);
	}

	@Override
	public int updateSaldemostelebyid(SalaryDemoStEle salarydemostele)
			throws DaoException {
		return sqlSessionTemplate.insert("com.app.salary.domain.SalaryDemoStEle.updateSaldemostelebyid", salarydemostele);
	}

	@Override
	public void deleteSaldemosteleBydemoid(Long demoid) throws DaoException {
		sqlSessionTemplate.update("com.app.salary.domain.SalaryDemoStEle.deleteSaldemosteleBydemoid",demoid);		
	}

	@Override
	public int delstelebyeleid(SalaryDemoStEle salarydemostele)
			throws DaoException {
		System.out.println("stand..................................");
		return sqlSessionTemplate.insert("com.app.salary.domain.SalaryDemoStEle.delstelebyeleid", salarydemostele);
	}

	@Override
	public int delstelebydemoid(SalaryDemoStEle salarydemostele)
			throws DaoException {
		return sqlSessionTemplate.insert("com.app.salary.domain.SalaryDemoStEle.delstelebydemoid", salarydemostele);
	}

	@Override
	public List<SalaryDemoStEle> findBasecodeBydemoid(Long demoid)
			throws DaoException {
		return sqlSessionTemplate.selectList("com.app.salary.domain.SalaryDemoStEle.findBasecodeBydemoid",demoid);
	}

}
