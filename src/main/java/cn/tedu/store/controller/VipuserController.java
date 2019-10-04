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
import cn.tedu.store.bean.PageQueryBean;
import cn.tedu.store.bean.User;
import cn.tedu.store.bean.vipuser;
import cn.tedu.store.mapper.VipuserMapper;

@Controller
@RequestMapping("/vip")
public class VipuserController {
	@Autowired(required = false)
	public VipuserMapper vipuserMapper;

	/**
	 * <pre>
	 * selectinstruByName(通过名字 查出乐器相关信息)    
	 * &#64;param insName
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/selectVipInfo.do")
	@ResponseBody
	public PageQueryBean selectVipInfo(String vipName, String vipTime1, String vipTime2, HttpServletResponse response) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		machiningList = vipuserMapper.selectVipInfo(vipName, vipTime1, vipTime2);// 订单id
		PageQueryBean pageQueryBean = new PageQueryBean();
		pageQueryBean.setItems(machiningList);
		pageQueryBean.setTotalRows(machiningList.size());
		return pageQueryBean;
	}

	// 删除单个会员
	@RequestMapping("/delvipById.do")
	@ResponseBody
	public String delvipById(String vipid, HttpServletResponse response) {
		Integer vipid2 = Integer.valueOf(vipid);
		vipuserMapper.delMainInsById(vipid2);
		return "success";
	}

	// 删除多个会员
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

	// 添加会员
	@RequestMapping("/addvipinfo.do")
	@ResponseBody
	public void addvipinfo(vipuser vipuser) {
		vipuserMapper.addvipinfo(vipuser);
	}

	/**
	 * <pre>
	 * queryvipById(通过vip Id 查询会员相关信息)    
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
		return machiningList;
	}

	/**
	 * <pre>
	 * updatevipinfo(修改会员相关信息)    
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

	// 查询登陆日志
	@RequestMapping("/querylogin.do")
	@ResponseBody
	public PageQueryBean querylogin(String vipName, String vipTime1, String vipTime2, HttpServletResponse response) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		machiningList = vipuserMapper.querylogin(vipName, vipTime1, vipTime2);// 订单id
		PageQueryBean pageQueryBean = new PageQueryBean();
		pageQueryBean.setItems(machiningList);
		pageQueryBean.setTotalRows(machiningList.size());
		return pageQueryBean;
	}

	/**
	 * user使用地方
	 * 
	 * @param vipName
	 * @param vipTime1
	 * @param vipTime2
	 * @param response
	 * @return
	 */
	@RequestMapping("/selectUserInfo.do")
	@ResponseBody
	public PageQueryBean selectUserInfo(String vipName, String vipTime1, String vipTime2,
			HttpServletResponse response) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		machiningList = vipuserMapper.selectUserInfo(vipName, vipTime1, vipTime2);// 订单id
		PageQueryBean pageQueryBean = new PageQueryBean();
		pageQueryBean.setItems(machiningList);
		pageQueryBean.setTotalRows(machiningList.size());
		return pageQueryBean;
	}

	// 删除单个用户
	@RequestMapping("/delUserById.do")
	@ResponseBody
	public String delUserById(String vipid, HttpServletResponse response) {
		Integer vipid2 = Integer.valueOf(vipid);
		vipuserMapper.delMainUserById(vipid2);
		vipuserMapper.delroleUserById(vipid2);
		return "success";
	}

	// 删除多个用户
	@RequestMapping("/delUsersByIds.do")
	@ResponseBody
	public String delUsersByIds(String ids, HttpServletResponse response) {
		String[] aStrings = ids.split(",");
		Integer[] ids2 = new Integer[aStrings.length];
		for (int i = 0; i < ids2.length; i++) {
			ids2[i] = Integer.parseInt(aStrings[i]);
		}
		vipuserMapper.delUsersByIds(ids2);
		vipuserMapper.delroleUsersByIds(ids2);
		return "success";
	}

	// 添加会员
	@RequestMapping("/addUserinfo.do")
	@ResponseBody
	public void addUserinfo(User user) {
		vipuserMapper.addUserinfo(user);
	}

	// 根据用户id查询用户信息
	@RequestMapping("/queryuserById.do")
	@ResponseBody
	public List<Map<String, Object>> queryuserById(String ids, HttpServletResponse response) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		Integer ids2 = Integer.parseInt(ids);
		machiningList = vipuserMapper.queryuserById(ids2);
		return machiningList;
	}

	@RequestMapping("/updateuserinfo.do")
	@ResponseBody
	public void updateuserinfo(User user) {
		vipuserMapper.updateuserinfo(user);
	}

	@RequestMapping("/updateroleinfo.do")
	@ResponseBody
	public void updateroleinfo(String role, Integer id) {
		vipuserMapper.updateroleinfo(Integer.valueOf(role), id);
	}

	@RequestMapping("/addrole.do")
	@ResponseBody
	public void addrole(String role, String username) {
		Integer id = vipuserMapper.queryuserByname(username);
		vipuserMapper.insertroleinfo(Integer.valueOf(role), id);
	}
	
	// 权限使用地方
	@RequestMapping("/selectrole.do")
	@ResponseBody
	public List<Map<String, Object>> selectrole() {
		return vipuserMapper.selectrole();
	}

	// 删除角色
	@RequestMapping("/delroleById.do")
	@ResponseBody
	public String delroleById(String vipid, HttpServletResponse response) {
		Integer vipid2 = Integer.valueOf(vipid);
		vipuserMapper.delroleById(vipid2);
		return "success";
	}

	// 所有菜单查询
	@RequestMapping("/selectmenu.do")
	@ResponseBody
	public List<Map<String, Object>> selectMenu() {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		machiningList = vipuserMapper.selectMenu();
		return machiningList;
	}

	// 新增角色
	@RequestMapping("/addrolemenu.do")
	@ResponseBody
	public String addrolemenu(String rolename, String remake, String valu) {
		if (vipuserMapper.qryroleid(rolename) != 0) {
			return "error";
		} else {
			vipuserMapper.addrole(rolename, remake);
		}
		;
		int id = vipuserMapper.qryroleid(rolename);
		String[] aa = valu.split(",");
		for (int i = 0; i < aa.length; i++) {
			vipuserMapper.addrolemenu(id, Integer.valueOf(aa[i]));
		}
		return "success";

	}

	// 编辑
	@RequestMapping("/editrolemenu.do")
	@ResponseBody
	public String editrolemenu(String id,String rolename,String remake, String valu) {
		vipuserMapper.delrolemenuById(Integer.valueOf(id));
		vipuserMapper.updaterole(rolename,remake);
		String[] aa = valu.split(",");
		for (int i = 0; i < aa.length; i++) {
			vipuserMapper.addrolemenu(Integer.valueOf(id), Integer.valueOf(aa[i]));
		}
		return "success";

	}

	// 指定角色菜单查询
	@RequestMapping("/selectmenubyid.do")
	@ResponseBody
	public List<Map<String, Object>> selectmenubyid(int id) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		Map<String, Object> a=vipuserMapper.selectrolebyid(id);
		machiningList = vipuserMapper.selectmenubyid(id);
		machiningList.add(a);
		return machiningList;
	}
}
