package cn.tedu.store.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * ��ҳ���Լ��ڲ�Ƕ����תҳ��
 * 
 * */
@Controller
@RequestMapping("/main")
public class MainController {
	// ��������ʾҳ��
	@RequestMapping("/showIndex.do")
	public String showIndex() {
		return "index";
	}
	// ����������ҳ��
	@RequestMapping("/showIndex1.do")
	public String showIndex1() {
		return "MainInstrument";
	}
	// �����������ҳ��
	@RequestMapping("/showIndex2.do")
	public String showIndex2() {
		return "AccInstrument";
	}
	// �����������ҳ��
	@RequestMapping("/showIndex3.do")
	public String showIndex3() {
		return "InstrumentAdd";
	}
	// ����������ҳ��
	@RequestMapping("/showIndex4.do")
	public String showIndex4() {
		return "AccessoryAdd";
	}
	// ����������ۼ�¼ҳ��
	@RequestMapping("/showIndex6.do")
	public String showIndex6() {
		return "Addsalesrecords";
	}
	// ���������ҳ��
	@RequestMapping("/showIndex7.do")
	public String showIndex7() {
		return "Totalstorage";
	}
	// �����ܳ���ҳ��
	@RequestMapping("/showIndex8.do")
	public String showIndex8() {
		return "TotalDeposit";
	}
	// �������ۼ�¼ҳ��
	@RequestMapping("/showIndex9.do")
	public String showIndex9() {
		return "Salesrecords";
	}
	// �����������ҳ��
	@RequestMapping("/showIndex10.do")
	public String showIndex10() {
		return "Accountingsit";
	}
	// �����Ա��Ϣҳ��
	@RequestMapping("/showIndex11.do")
	public String showIndex11() {
		return "MemberInfor";
	}
	// �����޸�����ҳ��
	@RequestMapping("/showIndex12.do")
	public String showIndex12() {
		return "ChangePwd";
	}
	// ��ת�������༭ҳ��
	@RequestMapping("/showIndex13.do")
	public String showIndex13() {
		return "Mainmusic-add";
	}
	// ��ת����༭ҳ��
	@RequestMapping("/showIndex14.do")
	public String showIndex14() {
		return "Partmusic-add";
	}
}
