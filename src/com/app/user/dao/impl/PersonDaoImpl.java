package com.app.user.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.user.dao.IPersonDao;
import com.app.user.domain.Person;
import com.app.user.domain.User;
import com.app.utils.exception.DaoException;

@Component
public class PersonDaoImpl implements IPersonDao {  
	  
	 /** 
     * 注入sqlSessionTemplate 
     */  
	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 创建用户功能
	 * @param person
	 * @return
	 */
    @Override  
    public int savePerson(Person person) throws DaoException{ 
    	System.out.println("PersonDaoImpl.............");
        return sqlSessionTemplate.insert("com.app.user.domain.Person.savePerson", person);
    }

	@Override
	public Person findPersonByUserId(Long userid) throws DaoException {
		Person person = (Person) sqlSessionTemplate.selectOne("com.app.user.domain.Person.findPersonByUserId", userid);
        return person;
	}

	@Override
	public int updatePerson(Person person) throws DaoException {
		return sqlSessionTemplate.update("com.app.user.domain.Person.updatePersonByid", person);
	}

	@Override
	public Person finduserbyidnumber(String idnumber) throws DaoException {
		Person person = (Person) sqlSessionTemplate.selectOne("com.app.user.domain.Person.finduserbyidnumber", idnumber);
        return person;
	}

	@Override
	public Person finduserbyRealname(String realname) throws DaoException {
		Person person = (Person) sqlSessionTemplate.selectOne("com.app.user.domain.Person.finduserbyRealname", realname);
        return person;
	}
}
