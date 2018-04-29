package edu.xidian.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xidian.bos.dao.IDecidedzoneDao;
import edu.xidian.bos.dao.ISubareaDao;
import edu.xidian.bos.domain.Decidedzone;
import edu.xidian.bos.domain.Subarea;
import edu.xidian.bos.service.IDecidedzoneService;
import edu.xidian.bos.utils.PageBean;

/**      
* @Description: TODO 
* @author sy.wang  
* @date 2018年4月29日 下午3:43:30  
* @version V1.0    
*/
@Service
@Transactional
public class DecidedzoneServiceImpl implements IDecidedzoneService {
	@Autowired
	private IDecidedzoneDao decidedzoneDao;
	@Autowired
	private ISubareaDao subareaDao;
	
	/**
	 * 添加定区，同时关联分区
	 */
	public void save(Decidedzone model, String[] subareaid) {
		decidedzoneDao.save(model);
		for (String id : subareaid) {
			Subarea subarea = subareaDao.findById(id);
			//model.getSubareas().add(subarea);一方（定区）已经放弃维护外键权利，只能由多方（分区）负责维护
			subarea.setDecidedzone(model);//分区关联定区
		}
	}

	public void pageQuery(PageBean pageBean) {
		decidedzoneDao.pageQuery(pageBean);
		
	}


}
