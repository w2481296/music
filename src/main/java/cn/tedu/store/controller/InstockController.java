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
import cn.tedu.store.bean.PageQueryBean;
import cn.tedu.store.bean.vipuser;
import cn.tedu.store.mapper.InstockMapper;
import cn.tedu.store.mapper.InstrumentsMapper;

@Controller
@RequestMapping("/in")
public class InstockController extends BaseController {
	@Autowired(required = false)
	public InstockMapper instockMapper;

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
	public PageQueryBean selectinstockByName(String inName, String inTime1, String inTime2,
			HttpServletResponse response) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		machiningList = instockMapper.selectinstockByName(inName, inTime1, inTime2);// 订单id
		PageQueryBean pageQueryBean = new PageQueryBean();
		pageQueryBean.setItems(machiningList);
		pageQueryBean.setTotalRows(machiningList.size());
		return pageQueryBean;
	}
	
	@RequestMapping("/selectinstockByName1.do")
	@ResponseBody
	public PageQueryBean selectinstockByName1(String inName, String inTime1, String inTime2,
			HttpServletResponse response) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		machiningList = instockMapper.selectinstockByName1(inName, inTime1, inTime2);// 订单id
		PageQueryBean pageQueryBean = new PageQueryBean();
		pageQueryBean.setItems(machiningList);
		pageQueryBean.setTotalRows(machiningList.size());
		return pageQueryBean;
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
		instockMapper.delMainInstockById(insid2);
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
		instockMapper.delMainInsstockById(ids2);
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
		machiningList = instockMapper.queryinstockById(ids2);
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
		instockMapper.updateinstock(instock);
		//修改乐器表
	}

	// 主乐器添加入库
	@RequestMapping("/addinstock.do")
	@ResponseBody
	public void addinstock(Instock instock) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		//添加到库存表
		instockMapper.addinstock(instock);
		machiningList=instockMapper.queryByName(instock);
		if(machiningList.size()!=0){
			//存在主表，更新数据
			Integer a=Integer.valueOf(machiningList.get(0).get("inQty").toString());
			Integer b=Integer.valueOf(instock.getInQty());
			instock.setInQty(String.valueOf(b+a));
			instockMapper.updateoldinfo(instock);
		}else{
			//添加到主表
			instockMapper.insertInfo(instock);
		}
		
	}
	// 配件添加入库
	@RequestMapping("/addpartsinstock.do")
	@ResponseBody
	public void addpartsinstock(Instock instock) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		//添加到库存表
		instockMapper.addpartsinstock(instock);
		machiningList=instockMapper.querypartsByName(instock);
		if(machiningList.size()!=0){
			//存在主表，更新数据
			Integer a=Integer.valueOf(machiningList.get(0).get("inQty").toString());
			Integer b=Integer.valueOf(instock.getInQty());
			instock.setInQty(String.valueOf(b+a));
			instockMapper.updateoldpartsinfo(instock);
		}else{
			//添加到主表
			instockMapper.insertpartsInfo(instock);
		}
		
	}
}
