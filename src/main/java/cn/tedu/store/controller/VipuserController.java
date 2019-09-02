package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Instruments;
import cn.tedu.store.bean.vipuser;
import cn.tedu.store.mapper.VipuserMapper;

@Controller
@RequestMapping("/vip")
public class VipuserController {
	@Autowired(required = false)
	public VipuserMapper vipuserMapper;

	/**
	 * <pre>
	 * selectinstruByName(ͨ������ ������������Ϣ)    
	 * &#64;param insName
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/selectVipInfo.do")
	@ResponseBody
	public List<Map<String, Object>> selectVipInfo(String vipName, String vipTime1, String vipTime2,
			HttpServletResponse response) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		machiningList = vipuserMapper.selectVipInfo(vipName, vipTime1, vipTime2);// ����id
		return machiningList;
	}
	//ɾ��������Ա
	@RequestMapping("/delvipById.do")
	@ResponseBody
	public String delvipById(String vipid, HttpServletResponse response) {
		Integer vipid2 = Integer.valueOf(vipid);
		vipuserMapper.delMainInsById(vipid2);
		return "success";
	}
	//ɾ�������Ա
	@RequestMapping("/delvipsByIds.do")
	@ResponseBody
	public String delvipsByIds(String ids, HttpServletResponse response) {
		String[] aStrings = ids.split(",");
		Integer[] ids2 = new Integer[aStrings.length];
		for (int i = 0; i < ids2.length; i++) {
			ids2[i] = Integer.parseInt(aStrings[i]);
		}
		vipuserMapper.delvipsByIds(ids2);
		return "success";
	}
	//��ӻ�Ա
	@RequestMapping("/addvipinfo.do")
	@ResponseBody
	public void addvipinfo(vipuser vipuser) {
		vipuserMapper.addvipinfo(vipuser);
	}
	/**
	 * <pre>
	 * queryvipById(ͨ��vip Id ��ѯ��Ա�����Ϣ)    
	 * &#64;param id
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/queryvipById.do")
	@ResponseBody
	public List<Map<String, Object>> queryvipById(String ids, HttpServletResponse response) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		Integer ids2 = Integer.parseInt(ids);
		machiningList = vipuserMapper.queryvipById(ids2);
		System.out.println(machiningList);
		return machiningList;
	}

	/**
	 * <pre>
	 * updatevipinfo(�޸Ļ�Ա�����Ϣ)    
	 * &#64;
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/updatevipinfo.do")
	@ResponseBody
	public void updatevipinfo(vipuser vipuser) {
		vipuserMapper.updatevipinfo(vipuser);
	}

}
