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

import cn.tedu.store.mapper.InstrumentsMapper;

@Controller
@RequestMapping("/ins")
public class InstrumentsController {
	@Autowired(required = false)
	public InstrumentsMapper instrumentsMapper;
	//@Resource
	//private InstrumentsService instrumentsService;
	/**
	 * <pre>selectinstruByName(通过名字 查出乐器相关信息)    
	 * @param insName
	 * @param response
	 * @return</pre>
	 */
	@RequestMapping("/selectinstruByName.do")
	@ResponseBody
	public List<Map<String, Object>> selectinstruByName(String insName, HttpServletResponse response) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		machiningList=instrumentsMapper.selinstruByName(insName);//订单id
		System.out.println(machiningList);
		return machiningList;
	}

	

}
