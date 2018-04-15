package edu.xidian.bos.service;

import edu.xidian.bos.domain.User;

/**      
* @Description: TODO 
* @author sy.wang  
* @date 2018年4月14日 下午2:38:10  
* @version V1.0    
*/
public interface IUserService {

	public User login(User model);

	public void editPassword(String id, String password);
	
}
