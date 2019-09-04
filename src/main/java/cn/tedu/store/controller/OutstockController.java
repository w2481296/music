package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Instock;
import cn.tedu.store.bean.Instruments;
import cn.tedu.store.bean.vipuser;
import cn.tedu.store.mapper.InstockMapper;
import cn.tedu.store.mapper.InstrumentsMapper;
import cn.tedu.store.mapper.OutstockMapper;

@Controller
@RequestMapping("/out")
public class OutstockController extends BaseController {
	@Autowired(required = false)
	public OutstockMapper outstockMapper;

	/**
	 * <pre>
	 * selectinstruByName(通过名字 查出入库相关信息)    
	 * &#64;param insName
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/selectinstockByName.do")
	@ResponseBody
	public List<Map<String, Object>> selectinstockByName(String inName, String inTime1, String inTime2,
			HttpServletResponse response) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		machiningList = outstockMapper.selectinstockByName(inName, inTime1, inTime2);// 订单id
		return machiningList;
	}
	@RequestMapping("/selectinstockByName1.do")
	@ResponseBody
	public List<Map<String, Object>> selectinstockByName1(String inName, String inTime1, String inTime2,
			HttpServletResponse response) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		machiningList = outstockMapper.selectinstockByName1(inName, inTime1, inTime2);// 订单id
		return machiningList;
	}

	/**
	 * <pre>
	 * selectinstruByName(通过乐器Id 删除入库相关信息)    
	 * &#64;param id
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/delMainInstockById.do")
	@ResponseBody
	public String delMainInstockById(String insid, HttpServletResponse response) {
		Integer insid2 = Integer.valueOf(insid);
		//删除库存表
		outstockMapper.delMainInstockById(insid2);
		//删除主乐器表
		return "success";
	}

	/**
	 * <pre>
	 * selectinstruByName(通过乐器Id 批量删除入库相关信息)    
	 * &#64;param id
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/delMainInsstockById.do")
	@ResponseBody
	public String delMainInsstockById(String ids, HttpServletResponse response) {
		String[] aStrings = ids.split(",");
		Integer[] ids2 = new Integer[aStrings.length];
		for (int i = 0; i < ids2.length; i++) {
			ids2[i] = Integer.parseInt(aStrings[i]);
		}
		//删除库存表
		outstockMapper.delMainInsstockById(ids2);
		//删除主乐器表
		return "success";
	}

	/**
	 * <pre>
	 * updateinstruById(通过乐器Id 查询入库相关信息)    
	 * &#64;param id
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/queryinstockById.do")
	@ResponseBody
	public List<Map<String, Object>> queryinstockById(String ids, HttpServletResponse response) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		Integer ids2 = Integer.parseInt(ids);
		machiningList = outstockMapper.queryinstockById(ids2);
		return machiningList;
	}

	/**
	 * <pre>
	 * updateinstruById(修改入库相关信息)    
	 * &#64;
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/updateinstock.do")
	@ResponseBody
	public void updateinstock(Instock instock) {
		//修改库存表
		outstockMapper.updateinstock(instock);
		//修改乐器表
	}

	// 主乐器添加入库
	@RequestMapping("/addinstock.do")
	@ResponseBody
	public void addinstock(Instock instock) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		//添加到库存表
		outstockMapper.addinstock(instock);
		machiningList=outstockMapper.queryByName(instock);
		if(machiningList.size()!=0){
			//存在主表，更新数据
			Integer a=Integer.valueOf(machiningList.get(0).get("inQty").toString());
			Integer b=Integer.valueOf(instock.getInQty());
			instock.setInQty(String.valueOf(b+a));
			outstockMapper.updateoldinfo(instock);
		}else{
			//添加到主表
			outstockMapper.insertInfo(instock);
		}
		
	}
	// 配件添加入库
	@RequestMapping("/addpartsinstock.do")
	@ResponseBody
	public void addpartsinstock(Instock instock) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		//添加到库存表
		outstockMapper.addpartsinstock(instock);
		machiningList=outstockMapper.querypartsByName(instock);
		if(machiningList.size()!=0){
			//存在主表，更新数据
			Integer a=Integer.valueOf(machiningList.get(0).get("inQty").toString());
			Integer b=Integer.valueOf(instock.getInQty());
			instock.setInQty(String.valueOf(b+a));
			outstockMapper.updateoldpartsinfo(instock);
		}else{
			//添加到主表
			outstockMapper.insertpartsInfo(instock);
		}
		
	}
}
