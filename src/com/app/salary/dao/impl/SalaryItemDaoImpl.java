package com.app.salary.dao.impl;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.salary.dao.ISalaryItemDao;
import com.app.salary.domain.SalaryItem;
import com.app.utils.exception.DaoException;

@Component
public class SalaryItemDaoImpl implements ISalaryItemDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public int saveSalItem(SalaryItem salaryItem) throws DaoException {
		return sqlSessionTemplate.insert("com.app.salary.domain.SalaryItem.saveSalItem", salaryItem);
	}

	@Override
	public Long getsalitemid() throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.salary.domain.SalaryItem.getsalitemid");
	}

	@Override
	public List<SalaryItem> findSalItemByDemoid(Long demoid)
			throws DaoException {
		return sqlSessionTemplate.selectList("com.app.salary.domain.SalaryItem.findSalItemByDemoid",demoid);
	}

	@Override
	public List<SalaryItem> findSalItemByEleid(Long eleid) throws DaoException {
		return sqlSessionTemplate.selectList("com.app.salary.domain.SalaryItem.findSalItemByEleid",eleid);
	}

	@Override
	public int updateSalItembyid(SalaryItem salaryItem) throws DaoException {
		return sqlSessionTemplate.insert("com.app.salary.domain.SalaryItem.updateSalItembyid", salaryItem);
	}

	@Override
	public List<SalaryItem> findPellistByDemoid(Long demoid)
			throws DaoException {
		return sqlSessionTemplate.selectList("com.app.salary.domain.SalaryItem.findPellistByDemoid",demoid);
	}

	@Override
	public List<SalaryItem> findPeldelistByPeid(Long peid) throws DaoException {
		return sqlSessionTemplate.selectList("com.app.salary.domain.SalaryItem.findPeldelistByPeid",peid);
	}

	@Override
	public String findPenameByPeid(Long peid) throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.salary.domain.SalaryItem.findPenameByPeid",peid);
	}

	@Override
	public int deleteDemopel(SalaryItem salaryItem) throws DaoException {
		return sqlSessionTemplate.insert("com.app.salary.domain.SalaryItem.deleteDemopel", salaryItem);
	}

	@Override
	public int deleteDemopelbyeleid(SalaryItem salaryItem) throws DaoException {
		return sqlSessionTemplate.insert("com.app.salary.domain.SalaryItem.deleteDemopelbyeleid", salaryItem);
	}

	@Override
	public int deleteDemopelbydemoid(SalaryItem salaryItem) throws DaoException {
		return sqlSessionTemplate.insert("com.app.salary.domain.SalaryItem.deleteDemopelbydemoid", salaryItem);
	}

	@Override
	public List<SalaryItem> findCptypelist(Long demoid) throws DaoException {
		return sqlSessionTemplate.selectList("com.app.salary.domain.SalaryItem.findCptypelist",demoid);
	}

	@Override
	public List<SalaryItem> findSallistByType(SalaryItem salaryItem)
			throws DaoException {
		return sqlSessionTemplate.selectList("com.app.salary.domain.SalaryItem.findSallistByType",salaryItem);
	}

	@Override
	public SalaryItem findDemoByPeid(Long peid) throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.salary.domain.SalaryItem.findDemoByPeid",peid);
	}

	@Override
	public List<SalaryItem> findSalstlistByPeid(Long peid)
			throws DaoException {
		return sqlSessionTemplate.selectList("com.app.salary.domain.SalaryItem.findSalstlistByPeid",peid);
	}

	@Override
	public List<SalaryItem> findDemoIdnumber(SalaryItem salaryItem)
			throws DaoException {
		return sqlSessionTemplate.selectList("com.app.salary.domain.SalaryItem.findDemoIdnumber",salaryItem);
	}

}
