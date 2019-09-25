package cn.tedu.store.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 主页面以及内部嵌套跳转页面
 * 
 * */
@Controller
@RequestMapping("/main")
public class MainController {
	// 定义主显示页面
	@RequestMapping("/showIndex.do")
	public String showIndex() {
		return "index";
	}
	@RequestMapping("/showIndexx.do")
	public String showIndexx() {
		return "indexx";
	}
	// 定义主乐器页面
	@RequestMapping("/showIndex1.do")
	public String showIndex1() {
		return "MainInstrument";
	}
	// 定义配件管理页面
	@RequestMapping("/showIndex2.do")
	public String showIndex2() {
		return "AccInstrument";
	}
	// 定义乐器添加页面
	@RequestMapping("/showIndex3.do")
	public String showIndex3() {
		return "InstrumentAdd";
	}
	// 定义配件添加页面
	@RequestMapping("/showIndex4.do")
	public String showIndex4() {
		return "AccessoryAdd";
	}
	// 定义添加销售记录页面
	@RequestMapping("/showIndex6.do")
	public String showIndex6() {
		return "Addsalesrecords";
	}
	// 定义入库汇总页面
	@RequestMapping("/showIndex7.do")
	public String showIndex7() {
		return "Totalstorage";
	}
	// 定义出库汇总页面
	@RequestMapping("/showIndex8.do")
	public String showIndex8() {
		return "TotalDeposit";
	}
	// 定义汇总记录页面
	@RequestMapping("/showIndex9.do")
	public String showIndex9() {
		return "Salesrecords";
	}
	// 定义帐务情况页面
	@RequestMapping("/showIndex10.do")
	public String showIndex10() {
		return "Accountingsit";
	}
	// 定义会员信息页面
	@RequestMapping("/showIndex11.do")
	public String showIndex11() {
		return "MemberInfor";
	}
	// 定义修改密码页面
	@RequestMapping("/showIndex12.do")
	public String showIndex12() {
		return "ChangePwd";
	}
	// 跳转主乐器编辑页面
	@RequestMapping("/showIndex13.do")
	public String showIndex13() {
		return "Mainmusic-add";
	}
	// 跳转配件编辑页面
	@RequestMapping("/showIndex14.do")
	public String showIndex14() {
		return "Partmusic-add";
	}
	// 跳转会员编辑页面
	@RequestMapping("/showIndex15.do")
	public String showIndex15() {
		return "member-show";
	}
	// 跳转添加页面
	@RequestMapping("/showIndex16.do")
	public String showIndex16() {
		return "member-add";
	}
	// 跳转主乐器添加页面
	@RequestMapping("/showIndex17.do")
	public String showIndex17() {
		return "Parts-add";
	}
	// 跳转配件编辑页面
	@RequestMapping("/showIndex18.do")
	public String showIndex18() {
		return "Parts-show";
	}
	// 跳转入库乐器添加页面
	@RequestMapping("/showIndex19.do")
	public String showIndex19() {
		return "Mainmusic2-add";
	}
	// 跳转入库乐器编辑页面
	@RequestMapping("/showIndex20.do")
	public String showIndex20() {
		return "Mainmusic-show";
	}
	// 跳转配件连接页面
	@RequestMapping("/showIndex21.do")
	public String showIndex21() {
		return "partconnect";
	}
	// 跳转销售添加页面
	@RequestMapping("/showIndex22.do")
	public String showIndex22() {
		return "Salereocrd-add";
	}
	// 跳转销售商品选择页面
	@RequestMapping("/showIndex23.do")
	public String showIndex23() {
		return "goodsselect";
	}
	//汇总记录总页面跳转视图
	@RequestMapping("/showIndex24.do")
	public String showIndex24() {
		return "view1";
	}
	//账务记录总页面跳转视图
	@RequestMapping("/showIndex25.do")
	public String showIndex25() {
		return "view2";
	}
	//账务记录总页面跳转视图
	@RequestMapping("/showIndex26.do")
	public String showIndex26() {
		return "logincord";
	}
	@RequestMapping("/showIndex27.do")
	public String showIndex27() {
		return "userInfor";
	}
	@RequestMapping("/showIndex28.do")
	public String showIndex28() {
		return "import";
	}
	@RequestMapping("/showIndex29.do")
	public String showIndex29() {
		return "import2";
	}
	//添加用户
	@RequestMapping("/showIndex30.do")
	public String showIndex30() {
		return "user-add";
	}
	//编辑用户
	@RequestMapping("/showIndex31.do")
	public String showIndex31() {
		return "user-show";
	}
	//角色管理
	@RequestMapping("/showIndex32.do")
	public String showIndex32() {
		return "admin-role";
	}
	//角色管理编辑
	@RequestMapping("/showIndex33.do")
	public String showIndex33() {
		return "admin-role-edit";
	}
	//角色管理添加
	@RequestMapping("/showIndex34.do")
	public String showIndex34() {
		return "admin-role-add";
	}
}
