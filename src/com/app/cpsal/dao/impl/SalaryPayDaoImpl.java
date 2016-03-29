package com.app.cpsal.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.app.cpsal.dao.ISalaryPayDao;
import com.app.cpsal.domain.SalaryPay;
import com.app.utils.exception.DaoException;
@Component
public class SalaryPayDaoImpl implements ISalaryPayDao {

	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int saveSalPay(SalaryPay salaryPay) throws DaoException {
		return sqlSessionTemplate.insert("com.app.cpsal.domain.SalaryPay.saveSalPay", salaryPay);
	}

	@Override
	public Long getsalpayid() throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.cpsal.domain.SalaryPay.getsalpayid");
	}

	@Override
	public int updateSalPaybyid(SalaryPay salaryPay) throws DaoException {
		return sqlSessionTemplate.insert("com.app.cpsal.domain.SalaryPay.updateSalPaybyid", salaryPay);
	}

	@Override
	public SalaryPay findSalPayByPeid(Long peid) throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.cpsal.domain.SalaryPay.findSalPayByPeid",peid);
	}

	@Override
	public List<SalaryPay> findSalPayByDemoid(Long demoid) throws DaoException {
		return sqlSessionTemplate.selectList("com.app.cpsal.domain.SalaryPay.findSalPayByDemoid",demoid);
	}

	@Override
	public List<Map<String, Object>> findSalComputeInfo(String addSql,
			String groupby, Long demoid) throws DaoException {
		StringBuffer sqlBuf = new StringBuffer("");
		sqlBuf.append("SELECT i.peid,i.pename ");
		sqlBuf.append(addSql);
		sqlBuf.append(" from ");
		sqlBuf.append(" pp_period_items i,pp_period_pay p");								
		sqlBuf.append(" where p.statu = '0' AND i.demoid = p.demoid AND i.peid = p.peid ");
		
		if(demoid != null) {
			sqlBuf.append(" and i.demoid = " + demoid);
		}
		
		sqlBuf.append(" group by i.peid "+groupby);
		
		System.out.println("huha: 最终的sql....。。。:  "+ sqlBuf.toString());
		List<Map<String, Object>> dataList = jdbcTemplate.queryForList(sqlBuf.toString());
		//System.out.println(sqlBuf.toString());
		return dataList;
	}

	@Override
	public int updateSPstatubydemoid(SalaryPay salaryPay) throws DaoException {
		return sqlSessionTemplate.insert("com.app.cpsal.domain.SalaryPay.updateSPstatubydemoid", salaryPay);
	}

	@Override
	public int deletePaybypeid(SalaryPay salaryItem) throws DaoException {
		return sqlSessionTemplate.insert("com.app.cpsal.domain.SalaryPay.deletePaybypeid", salaryItem);
	}

	@Override
	public int deletePaybybyeleid(SalaryPay salaryItem) throws DaoException {
		return sqlSessionTemplate.insert("com.app.cpsal.domain.SalaryPay.deletePaybybyeleid", salaryItem);
	}

}
