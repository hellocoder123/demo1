package edu.xidian.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.xidian.bos.domain.Decidedzone;
import edu.xidian.bos.service.IDecidedzoneService;
import edu.xidian.bos.web.action.base.BaseAction;
import edu.xidian.crm.Customer;
import edu.xidian.crm.ICustomerService;

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
	
	//注入代理对象
	@Autowired
	private ICustomerService proxy;
	
	public String findListNotAssociation() {
		List<Customer> list =  proxy.findListNotAssociation();
		this.java2Json(list, new String[]{});
		return NONE;
	}
	
	public String findListHasAssociation() {
		String id = model.getId();
		List<Customer> list = proxy.findListHasAssociation(id);
		this.java2Json(list, new String[]{});
		return NONE;
	}
	
	public List<Integer> getCustomerIds() {
		return customerIds;
	}


	public void setCustomerIds(List<Integer> customerIds) {
		this.customerIds = customerIds;
	}


	public String[] getSubareaid() {
		return subareaid;
	}
	private List<Integer> customerIds;
	
	public String assigncustomerstodecidedzone() {
		proxy.assigncustomerstodecidedzone(model.getId(), customerIds);
		return LIST;
	}
}
