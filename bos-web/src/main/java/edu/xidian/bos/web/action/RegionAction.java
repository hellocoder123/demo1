package edu.xidian.bos.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.xidian.bos.domain.Region;
import edu.xidian.bos.service.IRegionService;
import edu.xidian.bos.utils.PinYin4jUtils;
import edu.xidian.bos.web.action.base.BaseAction;

/**      
* @Description: TODO 区域管理
* @author sy.wang  
* @date 2018年4月19日 下午2:43:15  
* @version V1.0    
*/
@Controller
@Scope("prototype")
public class RegionAction extends BaseAction<Region>{
	//属性驱动，接收上传的文件
		private File regionFile;
		@Autowired
		private IRegionService regionService;
		public void setRegionFile(File regionFile) {
			this.regionFile = regionFile;
		}
		
		/**
		 * 区域导入
		 * @throws Exception 
		 * 
		 */
		public String importXls() throws Exception{
//			System.out.println(regionFile);
			List<Region> regionList = new ArrayList<Region>();
			//包装一个Excel文件对象
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(regionFile));
			//读取文件中第一个Sheet标签页
			HSSFSheet hssfSheet = workbook.getSheetAt(0);
			
			for(Row row:hssfSheet) {
				int rowNum = row.getRowNum();
				if(rowNum==0) {
					continue;
				}
				String id = row.getCell(0).getStringCellValue();
				String province = row.getCell(1).getStringCellValue();
				String city = row.getCell(2).getStringCellValue();
				String district = row.getCell(3).getStringCellValue();
				String postcode = row.getCell(4).getStringCellValue();
				//包装一个区域对象
				Region region = new Region(id, province, city, district, postcode, null, null, null);
				
				province = province.substring(0, province.length() - 1);
				city = city.substring(0, city.length() - 1);
				district = district.substring(0, district.length() - 1);
				String info = province + city + district;
				String[] headByString = PinYin4jUtils.getHeadByString(info);
				String shortcode = StringUtils.join(headByString);
				//城市编码---->>shijiazhuang
				String citycode = PinYin4jUtils.hanziToPinyin(city, "");
				
				region.setShortcode(shortcode);
				region.setCitycode(citycode);
				regionList.add(region);
			}
			//批量保存
			regionService.saveBatch(regionList);
			return NONE;
		}


}
