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
	 * selectinstruByName(ͨ������ �����������Ϣ)    
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
		machiningList = instockMapper.selectinstockByName(inName, inTime1, inTime2);// ����id
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
		machiningList = instockMapper.selectinstockByName1(inName, inTime1, inTime2);// ����id
		PageQueryBean pageQueryBean = new PageQueryBean();
		pageQueryBean.setItems(machiningList);
		pageQueryBean.setTotalRows(machiningList.size());
		return pageQueryBean;
	}

	/**
	 * <pre>
	 * selectinstruByName(ͨ������Id ɾ����������Ϣ)    
	 * &#64;param id
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/delMainInstockById.do")
	@ResponseBody
	public String delMainInstockById(String insid, HttpServletResponse response) {
		Integer insid2 = Integer.valueOf(insid);
		//ɾ������
		instockMapper.delMainInstockById(insid2);
		//ɾ����������
		return "success";
	}

	/**
	 * <pre>
	 * selectinstruByName(ͨ������Id ����ɾ����������Ϣ)    
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
		//ɾ������
		instockMapper.delMainInsstockById(ids2);
		//ɾ����������
		return "success";
	}

	/**
	 * <pre>
	 * updateinstruById(ͨ������Id ��ѯ��������Ϣ)    
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
	 * updateinstruById(�޸���������Ϣ)    
	 * &#64;
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/updateinstock.do")
	@ResponseBody
	public void updateinstock(Instock instock) {
		//�޸Ŀ���
		instockMapper.updateinstock(instock);
		//�޸�������
	}

	// ������������
	@RequestMapping("/addinstock.do")
	@ResponseBody
	public void addinstock(Instock instock) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		//��ӵ�����
		instockMapper.addinstock(instock);
		machiningList=instockMapper.queryByName(instock);
		if(machiningList.size()!=0){
			//����������������
			Integer a=Integer.valueOf(machiningList.get(0).get("inQty").toString());
			Integer b=Integer.valueOf(instock.getInQty());
			instock.setInQty(String.valueOf(b+a));
			instockMapper.updateoldinfo(instock);
		}else{
			//��ӵ�����
			instockMapper.insertInfo(instock);
		}
		
	}
	// ���������
	@RequestMapping("/addpartsinstock.do")
	@ResponseBody
	public void addpartsinstock(Instock instock) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		//��ӵ�����
		instockMapper.addpartsinstock(instock);
		machiningList=instockMapper.querypartsByName(instock);
		if(machiningList.size()!=0){
			//����������������
			Integer a=Integer.valueOf(machiningList.get(0).get("inQty").toString());
			Integer b=Integer.valueOf(instock.getInQty());
			instock.setInQty(String.valueOf(b+a));
			instockMapper.updateoldpartsinfo(instock);
		}else{
			//��ӵ�����
			instockMapper.insertpartsInfo(instock);
		}
		
	}
}
