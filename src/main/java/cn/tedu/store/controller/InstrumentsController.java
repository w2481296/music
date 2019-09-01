package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.tedu.store.bean.Instruments;
import cn.tedu.store.mapper.InstrumentsMapper;

@Controller
@RequestMapping("/ins")
public class InstrumentsController {
	@Autowired(required = false)
	public InstrumentsMapper instrumentsMapper;

	/**
	 * <pre>
	 * selectinstruByName(通过名字 查出乐器相关信息)    
	 * &#64;param insName
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/selectinstruByName.do")
	@ResponseBody
	public List<Map<String, Object>> selectinstruByName(String insName, String insTime1, String insTime2,
			HttpServletResponse response) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		machiningList = instrumentsMapper.selinstruByName(insName, insTime1, insTime2);// 订单id
		return machiningList;
	}

	/**
	 * <pre>
	 * selectinstruByName(通过乐器Id 删除乐器相关信息)    
	 * &#64;param id
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/delMainInsById.do")
	@ResponseBody
	public String delMainInsById(String insid, HttpServletResponse response) {
		Integer insid2 = Integer.valueOf(insid);
		instrumentsMapper.delMainInsById(insid2);
		return "success";
	}

	/**
	 * <pre>
	 * selectinstruByName(通过乐器Id 批量删除乐器相关信息)    
	 * &#64;param id
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/delsById.do")
	@ResponseBody
	public String delsById(String ids, HttpServletResponse response) {
		String[] aStrings = ids.split(",");
		Integer[] ids2 = new Integer[aStrings.length];
		for (int i = 0; i < ids2.length; i++) {
			ids2[i] = Integer.parseInt(aStrings[i]);
		}
		instrumentsMapper.deletesById(ids2);
		return "success";
	}

	/**
	 * <pre>
	 * updateinstruById(通过乐器Id 查询乐器相关信息)    
	 * &#64;param id
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/queryinstruById.do")
	@ResponseBody
	public List<Map<String, Object>> queryinstruById(String ids, HttpServletResponse response) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		Integer ids2 = Integer.parseInt(ids);
		machiningList = instrumentsMapper.queryinstruById(ids2);
		return machiningList;
	}

	/**
	 * <pre>
	 * updateinstruById(修改乐器相关信息)    
	 * &#64;
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/updateinfo.do")
	@ResponseBody
	public void updateinfo(Instruments instruments) {
		instrumentsMapper.updateinfo(instruments);
	}
}
