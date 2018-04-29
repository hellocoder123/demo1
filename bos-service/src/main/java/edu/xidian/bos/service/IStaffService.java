package edu.xidian.bos.service;

import java.util.List;

import edu.xidian.bos.domain.Staff;
import edu.xidian.bos.utils.PageBean;

/**      
* @Description: TODO 
* @author sy.wang  
* @date 2018年4月15日 下午2:29:05  
* @version V1.0    
*/
public interface IStaffService {
	public void save(Staff model);

	public void pageQuery(PageBean pageBean);

	public void deleteBatch(String ids);

	public Staff findById(String id);

	public void update(Staff staff);

	public List<Staff> findListNotDelete();
}
