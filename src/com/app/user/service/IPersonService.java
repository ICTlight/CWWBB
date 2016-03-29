package com.app.user.service;

import com.app.user.domain.Person;
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
	 * @ Person finduserbyidnumber(String idnumber)
	 * @ author LiuTuo
	 * @ description 通过idnumber获取跟人信息
	 */
	public Person finduserbyidnumber(String idnumber) throws ServiceException;
	/** 
	 * @ Person finduserbyRealname(String realname)
	 * @ author LiuTuo
	 * @ description 通过realname获取跟人信息
	 */
	public Person finduserbyRealname(String realname) throws ServiceException;
	/** 
   	 * @ boolean updatePerson(Person person)
   	 * @ author LiuTuo
   	 * @ date 2015-10-19 10:59:06
   	 * @ description 修改用户基本信息
   	 * @ reviewed_by
   	 */
    public boolean updatePerson(Person person) throws ServiceException;
}
