package edu.xidian.bos.service;

import edu.xidian.bos.domain.Decidedzone;
import edu.xidian.bos.utils.PageBean;

/**      
* @Description: TODO 
* @author sy.wang  
* @date 2018年4月29日 下午3:38:00  
* @version V1.0    
*/
public interface IDecidedzoneService {

	public void save(Decidedzone model, String[] subareaid);

	public void pageQuery(PageBean pageBean);	
	
}
