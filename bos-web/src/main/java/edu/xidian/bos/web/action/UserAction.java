package edu.xidian.bos.web.action;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.xidian.bos.domain.User;
import edu.xidian.bos.service.IUserService;
import edu.xidian.bos.utils.BOSUtils;
import edu.xidian.bos.utils.MD5Utils;
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
	/**
	 * 用户登录,使用shiro框架提供的方式进行认证操作
	 */
	public String login(){
		//从Session中获取生成的验证码
		String validatecode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		//校验验证码是否输入正确
		if(StringUtils.isNotBlank(checkcode) && checkcode.equals(validatecode)){
			//使用shiro框架提供的方式进行认证操作
			Subject subject = SecurityUtils.getSubject();//获得当前用户对象,状态为“未认证”
			AuthenticationToken token = new UsernamePasswordToken(model.getUsername(),MD5Utils.md5(model.getPassword()));//创建用户名密码令牌对象
			try{
				subject.login(token);
			}catch(Exception e){
				e.printStackTrace();
				return LOGIN;
			}
			User user = (User) subject.getPrincipal();
			ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
			return HOME;
		}else{
			//输入的验证码错误,设置提示信息，跳转到登录页面
			this.addActionError("输入的验证码错误！");
			return LOGIN;
		}
	}
	public String logout() {
		ServletActionContext.getRequest().getSession().invalidate();
		return LOGIN;
	}
	
	public String editPassword() throws IOException{
		String f = "1";
		//获取当前登录用户
		User user = BOSUtils.getLoginUser();
		try{
			userService.editPassword(user.getId(),model.getPassword());
		}catch(Exception e){
			f = "0";
			e.printStackTrace();
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(f);
		return NONE;
	}
}
