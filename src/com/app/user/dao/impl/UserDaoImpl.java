package com.app.user.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.user.dao.IUserDao;
import com.app.user.domain.User;
import com.app.utils.exception.DaoException;

@Component
public class UserDaoImpl  implements IUserDao {  
	  
		 /** 
	     * 注入sqlSessionTemplate 
	     */  
		@Autowired
	    private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 创建用户功能
	 * @param user
	 * @return
	 */
  @Override  
  public int saveUser(User user) throws DaoException{  
	  System.out.println("UserDaoImpl.............");
      return sqlSessionTemplate.insert("com.app.user.domain.User.saveUser", user);
  }

	@Override
	public Long getuserid() throws DaoException {		
		return sqlSessionTemplate.selectOne("com.app.user.domain.User.getuserid");
	}

	@Override
	public User findUserByuserame(String username)
			throws DaoException {
		User user = (User) sqlSessionTemplate.selectOne("com.app.user.domain.User.findUserByuserame", username);
        return user;
	}

	@Override
	public int updateUser(User user) throws DaoException {
		return sqlSessionTemplate.update("com.app.user.domain.User.updateUserbyid", user);
	}

	@Override
	public int findUsernameCount(String username) throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.user.domain.User.findUsernameCount", username);
	}

	@Override
	public int findEmailCount(String email) throws DaoException {
		return sqlSessionTemplate.selectOne("com.app.user.domain.User.findEmailCount", email);
	}

}
