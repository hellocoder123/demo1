package edu.xidian.bos.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import edu.xidian.bos.domain.User;
import edu.xidian.bos.utils.BOSUtils;

/**      
* @Description: TODO 自定义拦截器，用户未登陆自动跳转的登陆界面。
* @author sy.wang  
* @date 2018年4月15日 上午10:46:23  
* @version V1.0    
*/
public class BosLoginInterceptor extends MethodFilterInterceptor {

	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User user = BOSUtils.getLoginUser();
		if(user==null) {
			return "login";
		}
		return invocation.invoke();
	}

}
