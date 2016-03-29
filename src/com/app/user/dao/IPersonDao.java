package com.app.user.dao;

import com.app.user.domain.Company;
import com.app.user.domain.Person;
import com.app.user.domain.User;
import com.app.utils.exception.DaoException;

public interface IPersonDao {
	
	/** 
	 * @ int savePerson(Person person)
	 * @ author LiuTuo
	 * @ description 添加个人用户信息
	 */
    public int savePerson(Person person) throws DaoException;

    /** 
   	 * @ User findPersonByUserId(Long id)
   	 * @ author LiuTuo
   	 * @ date 2015-10-18 22:21:35
   	 * @ description 根据用户ID查找用户基本信息
   	 * @ reviewed_by
   	 */
    public Person findPersonByUserId(Long userid) throws DaoException;
    
    /** 
   	 * @ User finduserbyidnumber(String idnumber)
   	 * @ author LiuTuo
   	 * @ date 2015-11-15 13:42:22
   	 * @ description 根据用户身份证ID查找用户基本信息
   	 * @ reviewed_by
   	 */
    public Person finduserbyidnumber(String idnumber) throws DaoException;
    /** 
   	 * @ User finduserbyRealname(String realname)
   	 * @ author LiuTuo
   	 * @ date 2015-11-15 13:42:22
   	 * @ description 根据用户身份证ID查找用户基本信息
   	 * @ reviewed_by
   	 */
    public Person finduserbyRealname(String realname) throws DaoException;
    
    /** 
   	 * @ int updatePerson(Person person)
   	 * @ author LiuTuo
   	 * @ date 2015-10-19 10:55:54
   	 * @ description 修改用户基本信息
   	 * @ reviewed_by
   	 */
    public int updatePerson(Person person) throws DaoException;
}
