package com.app.dao.user;

import com.app.domain.user.Company;
import com.app.domain.user.Person;
import com.app.domain.user.User;
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
   	 * @ int updatePerson(Person person)
   	 * @ author LiuTuo
   	 * @ date 2015-10-19 10:55:54
   	 * @ description 修改用户基本信息
   	 * @ reviewed_by
   	 */
    public int updatePerson(Person person) throws DaoException;
}
