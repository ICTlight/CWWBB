package com.app.user.service;

import com.app.user.domain.User;
import com.app.utils.exception.ServiceException;

public interface IUserService {

	/** 
	 * @ boolean saveUser(User user)
	 * @ author LiuTuo
	 * @ description 添加个人用户信息
	 */
	public boolean saveUser(User user) throws ServiceException;
	
	/** 
	 * @ Long getuserid()
	 * @ author LiuTuo
	 * @ description 获取最新的id
	 */
	public Long getuserid() throws ServiceException;
	
	/** 
	 * @ User findUserByuserame(String username)
	 * @ author LiuTuo
	 * @ description 获取最新的id
	 */
	public User findUserByuserame(String username) throws ServiceException;
	
	/** 
   	 * @ boolean updateUser(User user)
   	 * @ author LiuTuo
   	 * @ date 2015-10-19 10:58:04
   	 * @ description 修改用户基本信息
   	 * @ reviewed_by
   	 */
    public boolean updateUser(User user) throws ServiceException;
    
    /** 
	 * @ Long Long updateUserbyid(String email)
	 * @ author LiuTuo
	 * @ date 2015-10-24 20:33:21
	 * @ description 用户名查重
	 * @ reviewed_by
	 */
	public int findUsernameCount(String username) throws ServiceException;
	
	/** 
	 * @ Long findEmailCount(String email)
	 * @ author LiuTuo
	 * @ date 2015-10-24 20:33:40
	 * @ description 邮箱查重
	 * @ reviewed_by
	 */
	public int findEmailCount(String email) throws ServiceException;
}
