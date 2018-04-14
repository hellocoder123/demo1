package edu.xidian.bos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.xidian.bos.dao.IUserDao;
import edu.xidian.bos.dao.base.impl.BaseDaoImpl;
import edu.xidian.bos.domain.User;

/**      
* @Description: TODO user对象的执行类
* @author sy.wang  
* @date 2018年4月14日 下午1:25:15  
* @version V1.0    
*/
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

	public User findByUsernameAndPassword(String username, String password) {
		String hql = "FROM User u WHERE u.username = ? AND u.password = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username,password);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

}
