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
import cn.tedu.store.mapper.partsMapper;

@Controller
@RequestMapping("/parts")
public class PartsController {
	@Autowired(required = false)
	public partsMapper partsMapper;

	/**
	 * <pre>
	 * selectpartByName(ͨ������ ������������Ϣ)    
	 * &#64;param insName
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/selectpartByName.do")
	@ResponseBody
	public List<Map<String, Object>> selectinstruByName(String insName, String insTime1, String insTime2,
			HttpServletResponse response) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		machiningList = partsMapper.selinstruByName(insName, insTime1, insTime2);// ����id
		System.out.println(machiningList);
		return machiningList;
	}

	/**
	 * <pre>
	 * delpartById(ͨ������Id ɾ�����������Ϣ)    
	 * &#64;param id
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/delpartsById.do")
	@ResponseBody
	public String delMainInsById(String insid, HttpServletResponse response) {
		System.out.println("ɾ������id==" + insid);
		Integer insid2 = Integer.valueOf(insid);
		partsMapper.delMainInsById(insid2);
		return "success";
	}

	/**
	 * <pre>
	 * delsById(ͨ������Id ����ɾ�����������Ϣ)    
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
		partsMapper.deletesById(ids2);
		return "success";
	}

}
