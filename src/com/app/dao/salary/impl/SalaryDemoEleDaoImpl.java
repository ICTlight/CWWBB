package com.app.dao.salary.impl;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.dao.salary.ISalaryDemoEleDao;
import com.app.domain.salary.SalaryDemoEle;
import com.app.utils.exception.DaoException;

@Component
public class SalaryDemoEleDaoImpl implements ISalaryDemoEleDao{
  
	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int saveSaldemoEle(SalaryDemoEle salarydemoele) throws DaoException {
		return sqlSessionTemplate.insert("com.app.domain.salary.SalaryDemoEle.saveSaldemoEle", salarydemoele);
	}

	@Override
	public Long getsaldemoeleid() throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.domain.salary.SalaryDemoEle.getsaldemoeleid");
	}

	@Override
	public List<SalaryDemoEle> findSaldemoeleBydemoid(Long demoid)
			throws DaoException {
		return sqlSessionTemplate.selectList("com.app.domain.salary.SalaryDemoEle.findSaldemoeleBydemoid",demoid);
	}

	@Override
	public SalaryDemoEle findSaldemoEleByEleid(Long eleid) throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.domain.salary.SalaryDemoEle.findSaldemoEleByEleid",eleid);
	}

	@Override
	public int updateSalDemoelebyid(SalaryDemoEle salarydemoele)
			throws DaoException {
		return sqlSessionTemplate.insert("com.app.domain.salary.SalaryDemoEle.updateSalDemoelebyid", salarydemoele);
	}

}
