package edu.xidian.bos.web.action;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.xidian.bos.domain.Decidedzone;
import edu.xidian.bos.service.IDecidedzoneService;
import edu.xidian.bos.web.action.base.BaseAction;

/**      
* @Description: TODO 
* @author sy.wang  
* @date 2018年4月29日 下午3:32:53  
* @version V1.0    
*/
@Controller
@Scope("prototype")
public class DecidedzoneAction extends BaseAction<Decidedzone>{
	private String[] subareaid;

	public void setSubareaid(String[] subareaid) {
		this.subareaid = subareaid;
	}
	@Autowired
	private IDecidedzoneService decidedzoneService;
	/*
	 * 添加定区
	 */
	public String add() {
		decidedzoneService.save(model,subareaid);
		return LIST;
	}
	

	/**
	 * 分页查询方法
	 */
	public String pageQuery() throws IOException{
		decidedzoneService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"currentPage","detachedCriteria",
						"pageSize","subareas","decidedzones"});
		return NONE;
	}
}
