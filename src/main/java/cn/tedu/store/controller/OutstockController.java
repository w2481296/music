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
import cn.tedu.store.bean.Outstock;
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
	 * selectinstruByName(通过名字 查询出库相关信息)    
	 * &#64;param insName
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/selectoutstockByName.do")
	@ResponseBody
	public List<Map<String, Object>> selectoutstockByName(String inName, String inTime1, String inTime2,
			HttpServletResponse response) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		machiningList = outstockMapper.selectoutstockByName(inName, inTime1, inTime2);// 订单id
		return machiningList;
	}

	/**
	 * <pre>
	 * selectinstruByName(通过商品Id 删除出库相关信息)    
	 * &#64;param id
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/deloutstockById.do")
	@ResponseBody
	public String deloutstockById(String insid, HttpServletResponse response) {
		Integer insid2 = Integer.valueOf(insid);
		// 删除库存表
		outstockMapper.deloutstockById(insid2);
		// 删除主乐器表
		return "success";
	}

	/**
	 * <pre>
	 * selectinstruByName(通过乐器Id 批量删除出库相关信息)    
	 * &#64;param id
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/deloutstockByIds.do")
	@ResponseBody
	public String deloutstockByIds(String ids, HttpServletResponse response) {
		String[] aStrings = ids.split(",");
		Integer[] ids2 = new Integer[aStrings.length];
		for (int i = 0; i < ids2.length; i++) {
			ids2[i] = Integer.parseInt(aStrings[i]);
		}
		// 删除库存表
		outstockMapper.deloutstockByIds(ids2);
		return "success";
	}

	/**
	 * <pre>
	 * updateinstruById(通过商品Id查询出库相关信息)    
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
		// machiningList = outstockMapper.queryinstockById(ids2);
		return machiningList;
	}

	// 添加出库记录
	@RequestMapping("/addoutstock.do")
	@ResponseBody
	public void addoutstock(Outstock outstock) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		if (outstock.getOutType().equals("主乐器")) {
			machiningList = outstockMapper.queryByName(outstock);
			Integer a = Integer.valueOf(machiningList.get(0).get("insQty").toString());
			Integer a1 = Integer.valueOf(machiningList.get(0).get("insCost").toString());
			Integer b = Integer.valueOf(outstock.getOutQty());
			Integer b1 = Integer.valueOf(outstock.getOutPricing());
			outstock.setOutRemain(String.valueOf(a-b));
			outstock.setOutProfit(String.valueOf((b1 - a1)*b));
			//修改主乐器信息
			outstockMapper.updatemaininfo(outstock);
		} else if (outstock.getOutType().equals("配件")) {
			machiningList = outstockMapper.queryByName1(outstock);
			Integer a = Integer.valueOf(machiningList.get(0).get("insQty").toString());
			Integer a1 = Integer.valueOf(machiningList.get(0).get("insCost").toString());
			Integer b = Integer.valueOf(outstock.getOutQty());
			Integer b1 = Integer.valueOf(outstock.getOutPricing());
			outstock.setOutRemain(String.valueOf(a - b));
			outstock.setOutProfit(String.valueOf((b1 - a1)*b));
			outstockMapper.updatepartinfo(outstock);
			
		}
		//给会员添加积分
		if(outstock.getOutVip()!=""){
			String vipname=outstock.getOutVip();
			Integer jifen=Integer.valueOf(outstock.getOutProfit());
			String oldfen=outstockMapper.queryvipinfo(vipname);
			String fenshu;
			if(oldfen==null){
				fenshu=String.valueOf(jifen);
			}else{
				jifen+=Integer.valueOf(oldfen);
				fenshu=String.valueOf(jifen);
			}
			outstockMapper.addvipoutstock(vipname,fenshu);
		}
		// 添加到出库表
		outstockMapper.addoutstock(outstock);

	}
	
	@RequestMapping("/selectgoodsorname.do")
	@ResponseBody
	public List<Map<String, Object>> selectgoodsorname(String outName, HttpServletResponse response) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		machiningList = outstockMapper.selectgoodsorname(outName);
		return machiningList;
	}

}
