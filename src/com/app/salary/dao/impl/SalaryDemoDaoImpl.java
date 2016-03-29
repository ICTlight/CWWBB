package com.app.salary.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.salary.dao.ISalaryDemoDao;
import com.app.salary.domain.SalaryDemo;
import com.app.utils.exception.DaoException;

@Component
public class SalaryDemoDaoImpl implements ISalaryDemoDao {

	/** 
     * 注入sqlSessionTemplate 
     */  
	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int saveSaldemo(SalaryDemo salarydemo) throws DaoException {
		return sqlSessionTemplate.insert("com.app.salary.domain.SalaryDemo.saveSaldemo", salarydemo);
	}

	@Override
	public Long getsaldemoid() throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.salary.domain.SalaryDemo.getsaldemoid");
	}

	@Override
	public List<SalaryDemo> findSaldemoByCoid(Long coid) throws DaoException {
		return sqlSessionTemplate.selectList("com.app.salary.domain.SalaryDemo.findSaldemoByCoid",coid);
	}

	@Override
	public SalaryDemo findSaldemoBySaldemoid(Long saldemoid)
			throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.salary.domain.SalaryDemo.findSaldemoBySaldemoid",saldemoid);
	}

	@Override
	public int delsaldemobyid(SalaryDemo salaryDemo) throws DaoException {
		return sqlSessionTemplate.insert("com.app.salary.domain.SalaryDemo.delsaldemobyid", salaryDemo);
	}

}
