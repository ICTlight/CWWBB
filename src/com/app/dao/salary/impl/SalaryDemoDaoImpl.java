package com.app.dao.salary.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.dao.salary.ISalaryDemoDao;
import com.app.domain.salary.SalaryDemo;
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
		return sqlSessionTemplate.insert("com.app.domain.salary.SalaryDemo.saveSaldemo", salarydemo);
	}

	@Override
	public Long getsaldemoid() throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.domain.salary.SalaryDemo.getsaldemoid");
	}

	@Override
	public List<SalaryDemo> findSaldemoByCoid(Long coid) throws DaoException {
		return sqlSessionTemplate.selectList("com.app.domain.salary.SalaryDemo.findSaldemoByCoid",coid);
	}

	@Override
	public SalaryDemo findSaldemoBySaldemoid(Long saldemoid)
			throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.domain.salary.SalaryDemo.findSaldemoBySaldemoid");
	}

}
