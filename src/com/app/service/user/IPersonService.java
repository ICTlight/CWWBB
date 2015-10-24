package com.app.service.user;

import com.app.domain.user.Person;
import com.app.domain.user.User;
import com.app.utils.exception.ServiceException;

public interface IPersonService {

	/** 
	 * @ boolean savePerson(Person person)
	 * @ author LiuTuo
	 * @ description 添加个人用户信息
	 */
	public boolean savePerson(Person person) throws ServiceException;
	/** 
	 * @ Person findPersonByUserId(Long userid)
	 * @ author LiuTuo
	 * @ description 获取最新的id
	 */
	public Person findPersonByUserId(Long userid) throws ServiceException;
	
	/** 
   	 * @ boolean updatePerson(Person person)
   	 * @ author LiuTuo
   	 * @ date 2015-10-19 10:59:06
   	 * @ description 修改用户基本信息
   	 * @ reviewed_by
   	 */
    public boolean updatePerson(Person person) throws ServiceException;
}
