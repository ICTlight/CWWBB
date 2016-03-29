package com.app.salary.dao.impl;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.salary.dao.ISalaryLocalStandDao;
import com.app.salary.domain.SalaryLocalStand;
import com.app.utils.exception.DaoException;

@Component
public class SalaryLocalStandDaoImpl implements ISalaryLocalStandDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public SalaryLocalStand findSalLocalStandByAreacode(String areacode) throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.salary.domain.SalaryLocalStand.findSalLocalStandByAreacode",areacode);
	}

	@Override
	public List<SalaryLocalStand> findSalLocalStandList()
			throws DaoException {
		return sqlSessionTemplate.selectList("com.app.salary.domain.SalaryLocalStand.findSalLocalStandList");
	}

}
