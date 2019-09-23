package cn.tedu.store.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.bean.Instock;
import cn.tedu.store.bean.PageQueryBean;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.mapper.InstockMapper;

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
	 * selectinstruByName(ͨ������Id ɾ����������Ϣ�͸�������������)    
	 * &#64;param id
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/delMainInstockById.do")
	@ResponseBody
	public String delMainInstockById(String insid, HttpServletResponse response) {
		Integer insid2 = Integer.valueOf(insid);
		//��ѯ��ǰ��¼����
		Instock instock=instockMapper.querypartsbean(insid2);
		Integer num=Integer.valueOf(instock.getInQty());
		// ɾ������
		instockMapper.delMainInstockById(insid2);
		// ������������
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		machiningList = instockMapper.queryByName(instock);
		//�õ�֮ǰ������������
		Integer a = Integer.valueOf(machiningList.get(0).get("inQty").toString());
		instock.setInQty(String.valueOf(a-num));
		//��������������Ϣ
		instockMapper.updateoldinfo(instock);
		return "success";
	}
	/**
	 * <pre>
	 * selectinstruByName(ͨ������Id ɾ����������Ϣ�͸�������������)    
	 * &#64;param id
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/delpartInstockById.do")
	@ResponseBody
	public String delpartInstockById(String insid, HttpServletResponse response) {
		Integer insid2 = Integer.valueOf(insid);
		//��ѯ��ǰ��¼����
		Instock instock=instockMapper.querypartsbean(insid2);
		Integer num=Integer.valueOf(instock.getInQty());
		// ɾ������
		instockMapper.delMainInstockById(insid2);
		// ���������
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		machiningList = instockMapper.querypartsByName(instock);
		//�õ�֮ǰ���������
		Integer a = Integer.valueOf(machiningList.get(0).get("inQty").toString());
		instock.setInQty(String.valueOf(a-num));
		//�����������Ϣ
		instockMapper.updateoldpartsinfo(instock);
		return "success";
	}
	/**
	 * <pre>
	 * selectinstruByName(ͨ�����Ids ɾ����������Ϣ�͸��������������������)    
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
			Instock instock=instockMapper.querypartsbean(ids2[i]);
			Integer num=Integer.valueOf(instock.getInQty());
			// ɾ������
			instockMapper.delMainInstockById(ids2[i]);
			if(instock.getInType().equals("������")){
				// ������������
				List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
				machiningList = instockMapper.queryByName(instock);
				//�õ�֮ǰ������������
				Integer a = Integer.valueOf(machiningList.get(0).get("inQty").toString());
				if(a-num>0){
					instock.setInQty(String.valueOf(a-num));
					//��������������Ϣ
					instockMapper.updateoldinfo(instock);
				}else{
					//ɾ��
					instockMapper.delMain(instock);
				}
				
			}else if(instock.getInType().equals("���")){
				List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
				machiningList = instockMapper.querypartsByName(instock);
				// �޸������Ʒ��
				Integer a = Integer.valueOf(machiningList.get(0).get("inQty").toString());
				if(a-num>0){
					instock.setInQty(String.valueOf(a-num));
					//�����������Ϣ
					instockMapper.updateoldpartsinfo(instock);
				}else{
					//ɾ��
					instockMapper.delPart(instock);
				}
			}
			
		}
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
	 * updateinstock(�޸���������Ϣ���޸�������Ϳ���)    
	 * �޸Ŀ��������ͬ�����ĳɱ��Ͷ���
	 * �޸ĵ�ǰ��¼������
	 * ��������������ٶ������������������޸�
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/updateinstock.do")
	@ResponseBody
	public void updateinstock(Instock instock) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		// ԭ�������
		Integer num = instockMapper.querypartsqty(instock.getId());
		// �޸Ŀ�浱ǰ��¼������
		instockMapper.updateinstockqty(instock);
		// �޸Ŀ��������ͬ�����ĳɱ��Ͷ���
		instockMapper.updateinstock(instock);
		machiningList = instockMapper.queryByName(instock);
		// �޸������Ʒ��
		Integer a = Integer.valueOf(machiningList.get(0).get("inQty").toString());
		Integer num2 = Integer.valueOf(instock.getInQty());
		if (num != num2) {
			if (num > num2) {
				a = a - num + num2;
				instock.setInQty(String.valueOf(a));
			} else {
				a += num2 - num;
				instock.setInQty(String.valueOf(a));
			}
		}
		instockMapper.updateoldinfo(instock);
	}

	/* �޸������Ⲣ�޸������ */
	@RequestMapping("/updateinstock2.do")
	@ResponseBody
	public void updateinstock2(Instock instock) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		// ԭ�������
		Integer num = instockMapper.querypartsqty(instock.getId());
		// �޸Ŀ�浱ǰ��¼������
		instockMapper.updateinstockqty(instock);
		// �޸Ŀ��������ͬ����ĳɱ��Ͷ���
		instockMapper.updateinstock(instock);
		machiningList = instockMapper.querypartsByName(instock);
		// �޸������Ʒ��
		Integer a = Integer.valueOf(machiningList.get(0).get("inQty").toString());

		Integer num2 = Integer.valueOf(instock.getInQty());
		if (num != num2) {
			if (num > num2) {
				a = a - num + num2;
				instock.setInQty(String.valueOf(a));
			} else {
				a += num2 - num;
				instock.setInQty(String.valueOf(a));
			}
		}
		instockMapper.updateoldpartsinfo(instock);
	}

	// ������������
	@RequestMapping("/addinstock.do")
	@ResponseBody
	public void addinstock(Instock instock) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		// ��ӵ�����
		instockMapper.addinstock(instock);
		machiningList = instockMapper.queryByName(instock);
		if (machiningList.size() != 0) {
			// ����������������
			Integer a = Integer.valueOf(machiningList.get(0).get("inQty").toString());
			Integer b = Integer.valueOf(instock.getInQty());
			instock.setInQty(String.valueOf(b + a));
			instockMapper.updateoldinfo(instock);
		} else {
			// ��ӵ�����
			instockMapper.insertInfo(instock);
		}

	}

	// ���������
	@RequestMapping("/addpartsinstock.do")
	@ResponseBody
	public void addpartsinstock(Instock instock) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		// ��ӵ�����
		instockMapper.addpartsinstock(instock);
		machiningList = instockMapper.querypartsByName(instock);
		if (machiningList.size() != 0) {
			// ����������������
			Integer a = Integer.valueOf(machiningList.get(0).get("inQty").toString());
			Integer b = Integer.valueOf(instock.getInQty());
			instock.setInQty(String.valueOf(b + a));
			instockMapper.updateoldpartsinfo(instock);
		} else {
			// ��ӵ�����
			instockMapper.insertpartsInfo(instock);
		}

	}

	// ģ������
	@RequestMapping("/downloadExcel")
	public void downloadExcel(HttpServletResponse response, HttpServletRequest request) throws IOException {
		// ��ȡ��������ԭʼģ��λ��
		String filePath = getClass().getResource("/resource/����������ģ��.xls").getPath();
		InputStream bis = new BufferedInputStream(new FileInputStream(new File(filePath)));
		// ���������������صĻ������������ļ�����
		String filename = "����ģ��.xls";
		// ת�룬����ļ�����������
		filename = URLEncoder.encode(filename, "UTF-8");
		// �����ļ�����ͷ
		response.addHeader("Content-Disposition", "attachment;filename=" + filename);
		// 1.�����ļ�ContentType���ͣ��������ã����Զ��ж������ļ�����
		response.setContentType("multipart/form-data");
		BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
		int len = 0;
		while ((len = bis.read()) != -1) {
			out.write(len);
			out.flush();
		}
		out.close();
	}

	/**
	 * ����
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/export")
	@ResponseBody
	public String export(@RequestParam("file") MultipartFile file, @RequestParam("type") String type,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Instock> instockList = new ArrayList<Instock>();
			// @RequestParam("file") MultipartFile file ����������ǰ�˴��ݹ������ļ�
			InputStream inputStream = file.getInputStream();
			// 1.����workbook���󣬶�ȡ�����ĵ�
			Workbook wb = WorkbookFactory.create(inputStream);
			// 2.��ȡҳ��sheet
			Sheet sheetAt = wb.getSheetAt(0);
			if (sheetAt == null) {
				return "2";
			}
			// ������row
			for (int rowNum = 1; rowNum <= sheetAt.getLastRowNum(); rowNum++) {
				//��һ���Ǳ��ⲻҪ���ӵڶ��п�ʼ
				// ��ȡÿһ��
				Row row = sheetAt.getRow(rowNum);
				if (row == null) {
					continue;
				}

				HSSFDataFormatter dataFormatter = new HSSFDataFormatter();
				Instock instock = new Instock();
				instock.setInName("" + row.getCell(0));
				instock.setInSpecifications("" + row.getCell(1));
				instock.setInCost("" + row.getCell(2));
				instock.setInPricing("" + row.getCell(3));
				instock.setInQty( dataFormatter.formatCellValue(row.getCell(4)));
				instock.setInManufacturers("" + row.getCell(5));
				instock.setInType(type);
				instockList.add(instock);
				if (type.equals("������")) {
					addinstock(instock);
				} else if (type.equals("���")) {
					addpartsinstock(instock);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "1";
	}
}
