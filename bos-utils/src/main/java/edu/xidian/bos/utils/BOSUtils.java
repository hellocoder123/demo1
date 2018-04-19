package edu.xidian.bos.utils;

import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import edu.xidian.bos.domain.User;

/**      
* @Description: TODO 
* @author sy.wang  
* @date 2018年4月15日 上午10:51:59  
* @version V1.0    
*/
public class BOSUtils {
	public static HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}
	public static User getLoginUser() {
		return (User) getSession().getAttribute("loginUser");
	}
}
