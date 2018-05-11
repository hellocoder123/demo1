package edu.xidian.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xidian.bos.dao.IWorkordermanageDao;
import edu.xidian.bos.domain.Workordermanage;
import edu.xidian.bos.service.IWorkordermanageService;

/**      
* @Description: TODO 
* @author sy.wang  
* @date 2018年5月11日 下午4:41:43  
* @version V1.0    
*/
@Service
@Transactional
public class WorkordermanageServiceImpl implements IWorkordermanageService {
	@Autowired
	private IWorkordermanageDao workordermanageDao;
	public void save(Workordermanage model) {
		workordermanageDao.save(model);
	}

}
