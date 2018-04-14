package edu.xidian.bos.web.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.xidian.bos.domain.User;
import edu.xidian.bos.service.IUserService;
import edu.xidian.bos.web.action.base.BaseAction;

/**      
* @Description: TODO user对象的执行类
* @author sy.wang  
* @date 2018年4月14日 下午1:33:53  
* @version V1.0    
*/
@Controller
@Scope("prototype")//多例原型，项目启动时不会自动创建对象
public class UserAction extends BaseAction<User> {
	private String checkcode;
	/*
	 * 用户登陆
	 */
	@Autowired
	private IUserService userService;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	public String login() {
		String str = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		if(StringUtils.isNoneBlank(checkcode) && checkcode.equals(str)) {
			//验证码正确
			User user = userService.login(model);
			if(user!=null) {
				//登陆成功
				ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
				return HOME;
			}else{
				//登录失败，,设置提示信息，跳转到登录页面
				this.addActionError("用户名或者密码输入错误！");
				return LOGIN;
			}
		}else {
			//登陆失败，显示提示信息
			this.addActionError("输入的验证码错误！");
			return LOGIN;
		}
	}
	public String logout() {
		ServletActionContext.getRequest().getSession().invalidate();
		return LOGIN;
	}
}
