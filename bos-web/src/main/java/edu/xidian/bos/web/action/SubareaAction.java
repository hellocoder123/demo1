package edu.xidian.bos.web.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.xidian.bos.domain.Subarea;
import edu.xidian.bos.service.ISubareaService;
import edu.xidian.bos.web.action.base.BaseAction;


@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea>{
	@Resource
	private ISubareaService subareaService;
	/**
	 * 添加分区
	 */
	public String add(){
		subareaService.save(model);
		return LIST;
	}
}
