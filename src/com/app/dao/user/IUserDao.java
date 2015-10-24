package com.app.dao.user;

import com.app.domain.user.User;
import com.app.utils.exception.DaoException;

public interface IUserDao {

	/** 
	 * @ int saveUser(User user)
	 * @ author LiuTuo
	 * @ description 添加个人用户信息
	 */
    public int saveUser(User user) throws DaoException;
    
    /** 
	 * @ long getuserid()
	 * @ author LiuTuo
	 * @ description 获取最新的id
	 */
    public Long getuserid() throws DaoException;
    
    /** 
   	 * @ User findUserByLogin(String username,String password)
   	 * @ author LiuTuo
   	 * @ date 2015-10-18 23:55:36
   	 * @ description 根据用户名查找用户信息
   	 * @ reviewed_by
   	 */
    public User findUserByuserame(String username) throws DaoException;
    
    /** 
   	 * @ int updateUser(User user)
   	 * @ author LiuTuo
   	 * @ date 2015-10-19 10:50:12
   	 * @ description 修改用户基本信息
   	 * @ reviewed_by
   	 */
    public int updateUser(User user) throws DaoException;
    
    /** 
	 * @ Long Long updateUserbyid(String email)
	 * @ author LiuTuo
	 * @ date 2015-10-24 20:33:21
	 * @ description 用户名查重
	 * @ reviewed_by
	 */
	public int findUsernameCount(String username) throws DaoException;
	
	/** 
	 * @ Long findEmailCount(String email)
	 * @ author LiuTuo
	 * @ date 2015-10-24 20:33:40
	 * @ description 邮箱查重
	 * @ reviewed_by
	 */
	public int findEmailCount(String email) throws DaoException;
}
