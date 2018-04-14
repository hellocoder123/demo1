package edu.xidian.bos.dao;

import edu.xidian.bos.dao.base.IBaseDao;
import edu.xidian.bos.domain.User;

/**      
* @Description: TODO user对象的执行接口
* @author sy.wang  
* @date 2018年4月14日 下午1:19:00  
* @version V1.0    
*/
public interface IUserDao extends IBaseDao<User> {

	public User findByUsernameAndPassword(String username, String password);

}
