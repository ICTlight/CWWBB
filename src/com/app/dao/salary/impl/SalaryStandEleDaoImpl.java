package com.app.dao.salary.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.dao.salary.ISalaryStandEleDao;
import com.app.domain.salary.SalaryStandEle;
import com.app.utils.exception.DaoException;

@Component
public class SalaryStandEleDaoImpl implements ISalaryStandEleDao {

	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<SalaryStandEle> findallStandEle() throws DaoException {
		return sqlSessionTemplate.selectList("com.app.domain.salary.SalaryStandEle.findallStandEle");
	}

	@Override
	public SalaryStandEle findStandEleByElename(String elename)
			throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.domain.salary.SalaryStandEle.findStandEleByElename",elename);
	}

}
