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
	@RequestMapping("/showIndexx.do")
	public String showIndexx() {
		return "indexx";
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
	// ����������ҳ��
	@RequestMapping("/showIndex7.do")
	public String showIndex7() {
		return "Totalstorage";
	}
	// ����������ҳ��
	@RequestMapping("/showIndex8.do")
	public String showIndex8() {
		return "TotalDeposit";
	}
	// ������ܼ�¼ҳ��
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
	// ��ת��Ա�༭ҳ��
	@RequestMapping("/showIndex15.do")
	public String showIndex15() {
		return "member-show";
	}
	// ��ת���ҳ��
	@RequestMapping("/showIndex16.do")
	public String showIndex16() {
		return "member-add";
	}
	// ��ת���������ҳ��
	@RequestMapping("/showIndex17.do")
	public String showIndex17() {
		return "Parts-add";
	}
	// ��ת����༭ҳ��
	@RequestMapping("/showIndex18.do")
	public String showIndex18() {
		return "Parts-show";
	}
	// ��ת����������ҳ��
	@RequestMapping("/showIndex19.do")
	public String showIndex19() {
		return "Mainmusic2-add";
	}
	// ��ת��������༭ҳ��
	@RequestMapping("/showIndex20.do")
	public String showIndex20() {
		return "Mainmusic-show";
	}
	// ��ת�������ҳ��
	@RequestMapping("/showIndex21.do")
	public String showIndex21() {
		return "partconnect";
	}
	// ��ת�������ҳ��
	@RequestMapping("/showIndex22.do")
	public String showIndex22() {
		return "Salereocrd-add";
	}
	// ��ת������Ʒѡ��ҳ��
	@RequestMapping("/showIndex23.do")
	public String showIndex23() {
		return "goodsselect";
	}
	//���ܼ�¼��ҳ����ת��ͼ
	@RequestMapping("/showIndex24.do")
	public String showIndex24() {
		return "view1";
	}
	//�����¼��ҳ����ת��ͼ
	@RequestMapping("/showIndex25.do")
	public String showIndex25() {
		return "view2";
	}
	//�����¼��ҳ����ת��ͼ
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
	//����û�
	@RequestMapping("/showIndex30.do")
	public String showIndex30() {
		return "user-add";
	}
	//�༭�û�
	@RequestMapping("/showIndex31.do")
	public String showIndex31() {
		return "user-show";
	}
	//��ɫ����
	@RequestMapping("/showIndex32.do")
	public String showIndex32() {
		return "admin-role";
	}
	//��ɫ����༭
	@RequestMapping("/showIndex33.do")
	public String showIndex33() {
		return "admin-role-edit";
	}
	//��ɫ�������
	@RequestMapping("/showIndex34.do")
	public String showIndex34() {
		return "admin-role-add";
	}
}
