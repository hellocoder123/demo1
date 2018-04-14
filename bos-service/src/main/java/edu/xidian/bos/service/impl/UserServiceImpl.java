package edu.xidian.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xidian.bos.dao.IUserDao;
import edu.xidian.bos.domain.User;
import edu.xidian.bos.service.IUserService;
import edu.xidian.bos.utils.MD5Utils;

/**      
* @Description: TODO 
* @author sy.wang  
* @date 2018年4月14日 下午2:42:54  
* @version V1.0    
*/
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	//用户登陆
	@Autowired
	private IUserDao userDao;
	public User login(User user) {
		String password = MD5Utils.md5(user.getPassword());		
		return userDao.findByUsernameAndPassword(user.getUsername(),password);
	}

}
