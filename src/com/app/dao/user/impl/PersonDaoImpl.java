package com.app.dao.user.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.dao.user.IPersonDao;
import com.app.domain.user.Person;
import com.app.domain.user.User;
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
        return sqlSessionTemplate.insert("com.app.domain.user.Person.savePerson", person);
    }

	@Override
	public Person findPersonByUserId(Long userid) throws DaoException {
		Person person = (Person) sqlSessionTemplate.selectOne("com.app.domain.user.Person.findPersonByUserId", userid);
        return person;
	}

	@Override
	public int updatePerson(Person person) throws DaoException {
		return sqlSessionTemplate.update("com.app.domain.user.Person.updatePersonByid", person);
	}
}
