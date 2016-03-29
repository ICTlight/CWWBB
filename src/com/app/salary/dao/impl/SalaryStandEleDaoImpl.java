package com.app.salary.dao.impl;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.salary.dao.ISalaryStandEleDao;
import com.app.salary.domain.SalaryStandEle;
import com.app.utils.exception.DaoException;

@Component
public class SalaryStandEleDaoImpl implements ISalaryStandEleDao {

	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<SalaryStandEle> findallStandEle() throws DaoException {
		return sqlSessionTemplate.selectList("com.app.salary.domain.SalaryStandEle.findallStandEle");
	}

	@Override
	public SalaryStandEle findStandEleByElename(String elename)
			throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.salary.domain.SalaryStandEle.findStandEleByElename",elename);
	}

}
