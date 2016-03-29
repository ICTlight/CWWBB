package com.app.salary.dao.impl;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.salary.dao.ISalaryDemoEleDao;
import com.app.salary.domain.SalaryDemoEle;
import com.app.utils.exception.DaoException;

@Component
public class SalaryDemoEleDaoImpl implements ISalaryDemoEleDao{
  
	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int saveSaldemoEle(SalaryDemoEle salarydemoele) throws DaoException {
		return sqlSessionTemplate.insert("com.app.salary.domain.SalaryDemoEle.saveSaldemoEle", salarydemoele);
	}

	@Override
	public Long getsaldemoeleid() throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.salary.domain.SalaryDemoEle.getsaldemoeleid");
	}

	@Override
	public List<SalaryDemoEle> findSaldemoeleBydemoid(Long demoid)
			throws DaoException {
		return sqlSessionTemplate.selectList("com.app.salary.domain.SalaryDemoEle.findSaldemoeleBydemoid",demoid);
	}

	@Override
	public SalaryDemoEle findSaldemoEleByEleid(Long eleid) throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.salary.domain.SalaryDemoEle.findSaldemoEleByEleid",eleid);
	}

	@Override
	public int updateSalDemoelebyid(SalaryDemoEle salarydemoele)
			throws DaoException {
		return sqlSessionTemplate.insert("com.app.salary.domain.SalaryDemoEle.updateSalDemoelebyid", salarydemoele);
	}

	@Override
	public int delelebyeleid(SalaryDemoEle salarydemoele) throws DaoException {
		return sqlSessionTemplate.insert("com.app.salary.domain.SalaryDemoEle.delelebyeleid", salarydemoele);
	}

	@Override
	public int delelebydemoid(SalaryDemoEle salarydemoele) throws DaoException {
		return sqlSessionTemplate.insert("com.app.salary.domain.SalaryDemoEle.delelebydemoid", salarydemoele);
	}

}
