package edu.xidian.bos.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xidian.bos.dao.IStaffDao;
import edu.xidian.bos.domain.Staff;
import edu.xidian.bos.service.IStaffService;
import edu.xidian.bos.utils.PageBean;

/**      
* @Description: TODO 
* @author sy.wang  
* @date 2018年4月15日 下午2:34:18  
* @version V1.0    
*/
@Service
@Transactional
public class StaffServiceImpl implements IStaffService {
	@Autowired
	private IStaffDao staffDao;
	public void save(Staff model) {
		staffDao.save(model);

	}
	
	public void pageQuery(PageBean pageBean) {
		staffDao.pageQuery(pageBean);
	}


	/**
	 * 取派员批量删除
	 * 逻辑删除，将deltag改为1
	 */
	public void deleteBatch(String ids) {//1,2,3,4
		if(StringUtils.isNotBlank(ids)){
			String[] staffIds = ids.split(",");
			for (String id : staffIds) {
				staffDao.executeUpdate("staff.delete", id);
			}
		}
	}
	
	/**
	 * 根据id查询取派员
	 */
	public Staff findById(String id) {
		return staffDao.findById(id);
	}
	
	/**
	 * 根据id修改取派员
	 */
	public void update(Staff staff) {
		staffDao.update(staff);
	}

	public List<Staff> findListNotDelete() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Staff.class);
		//添加过滤条件，deltag = 0;
		detachedCriteria.add(Restrictions.eq("deltag", "0"));
		return staffDao.findByCriteria(detachedCriteria);
	}

}
