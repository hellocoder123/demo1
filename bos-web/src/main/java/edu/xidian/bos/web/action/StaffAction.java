package edu.xidian.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.xidian.bos.domain.Staff;
import edu.xidian.bos.service.IStaffService;
import edu.xidian.bos.utils.PageBean;
import edu.xidian.bos.web.action.base.BaseAction;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**      
* @Description: TODO 取派员添加action
* @author sy.wang  
* @date 2018年4月15日 下午2:22:36  
* @version V1.0    
*/
@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {
	@Autowired
	private IStaffService staffService;
	
	public String add() {
		staffService.save(model);
		return LIST;
	}
	
	/**
	 * 分页查询方法
	 * @throws IOException 
	 */
	public String pageQuery() throws IOException{
		staffService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"decidedzones","currentPage","detachedCriteria","pageSize"});
		return NONE;
	}
	
	//属性驱动，接收页面提交的ids参数
		private String ids;
		
		/**
		 * 取派员批量删除
		 */
		public String deleteBatch(){
			staffService.deleteBatch(ids);
			return LIST;
		}
		
		/**
		 * 修改取派员信息
		 */
		public String edit(){
			//显查询数据库，根据id查询原始数据
			Staff staff = staffService.findById(model.getId());
			//使用页面提交的数据进行覆盖
			staff.setName(model.getName());
			staff.setTelephone(model.getTelephone());
			staff.setHaspda(model.getHaspda());
			staff.setStandard(model.getStandard());
			staff.setStation(model.getStation());
			staffService.update(staff);
			return LIST;
		}
		
		/**
		 * 查询所有未删除的取派员，返回json
		 */
		public String listajax(){
			List<Staff> list = staffService.findListNotDelete();
			this.java2Json(list, new String[]{"decidedzones","telephone","haspda","deltag","station","standard"});
			return NONE;
		}


		
		
		public IStaffService getStaffService() {
			return staffService;
		}

		public void setStaffService(IStaffService staffService) {
			this.staffService = staffService;
		}


		public String getIds() {
			return ids;
		}

		public void setIds(String ids) {
			this.ids = ids;
		}
}
