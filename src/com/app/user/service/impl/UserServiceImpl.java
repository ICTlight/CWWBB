package com.app.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.user.dao.IUserDao;
import com.app.user.domain.User;
import com.app.user.service.IUserService;
import com.app.utils.exception.DaoException;
import com.app.utils.exception.ServiceException;

@Component
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	//记录日志
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	public boolean saveUser(User user) throws ServiceException{
		System.out.println("UserServiceImpl.............");
		try {
			if(userDao.saveUser(user) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when saveUser methods of UserServiceImpl.", e);
			throw new ServiceException("插入数据失败", e);
		}
		return false;
	}

	@Override
	public Long getuserid() throws ServiceException {
		return userDao.getuserid();
	}

	@Override
	public User findUserByuserame(String username) throws ServiceException {
		return userDao.findUserByuserame(username);
	}

	@Override
	public boolean updateUser(User user) throws ServiceException {		
		try {
			if(userDao.updateUser(user) > 0){
				return true;
			}
		} catch (DaoException e) {
			logger.error("Error occurred when updateUser methods of UserServiceImpl.", e);
			throw new ServiceException("修改数据失败", e);
		}
    	return false;
	}

	@Override
	public int findUsernameCount(String username) throws ServiceException {
		return userDao.findUsernameCount(username);
	}

	@Override
	public int findEmailCount(String email) throws ServiceException {
		return userDao.findEmailCount(email);
	}

}
