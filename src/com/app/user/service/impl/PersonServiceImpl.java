package com.app.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.user.dao.IPersonDao;
import com.app.user.domain.Person;
import com.app.user.service.IPersonService;
import com.app.utils.exception.DaoException;
import com.app.utils.exception.ServiceException;

/**
 * @ file_name PersonServiceImpl.java
 * @ author LiuTuo
 * @ description 
 */
@Component
@Service
@Transactional
public class PersonServiceImpl implements IPersonService {
	
	@Autowired
	private IPersonDao personDao;
	//记录日志
	private Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

	public boolean savePerson(Person person) throws ServiceException{
		System.out.println("PersonServiceImpl.............");
		try {
			if(personDao.savePerson(person) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when savePerson methods of PersonServiceImpl.", e);
			throw new ServiceException("插入数据失败", e);
		}
		return false;
	}

	@Override
	public Person findPersonByUserId(Long userid) throws ServiceException {
		
		return personDao.findPersonByUserId(userid);
	}

	@Override
	public boolean updatePerson(Person person) throws ServiceException {
		try {
			if(personDao.updatePerson(person) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when updateUser methods of UserServiceImpl.", e);
			throw new ServiceException("修改数据失败", e);
		}
    	return false;
	}

	@Override
	public Person finduserbyidnumber(String idnumber) throws ServiceException {
		return personDao.finduserbyidnumber(idnumber);
	}

	@Override
	public Person finduserbyRealname(String realname) throws ServiceException {
		return personDao.finduserbyRealname(realname);
	}
}
