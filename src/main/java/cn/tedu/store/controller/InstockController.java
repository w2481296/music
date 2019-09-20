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
	 * selectinstruByName(通过名字 查出入库相关信息)    
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
		machiningList = instockMapper.selectinstockByName(inName, inTime1, inTime2);// 订单id
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
		machiningList = instockMapper.selectinstockByName1(inName, inTime1, inTime2);// 订单id
		PageQueryBean pageQueryBean = new PageQueryBean();
		pageQueryBean.setItems(machiningList);
		pageQueryBean.setTotalRows(machiningList.size());
		return pageQueryBean;
	}

	/**
	 * <pre>
	 * selectinstruByName(通过乐器Id 删除入库相关信息)    
	 * &#64;param id
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/delMainInstockById.do")
	@ResponseBody
	public String delMainInstockById(String insid, HttpServletResponse response) {
		Integer insid2 = Integer.valueOf(insid);
		// 删除库存表
		instockMapper.delMainInstockById(insid2);
		// 删除主乐器表
		return "success";
	}

	/**
	 * <pre>
	 * selectinstruByName(通过乐器Id 批量删除入库相关信息)    
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
		// 删除库存表
		instockMapper.delMainInsstockById(ids2);
		// 删除主乐器表
		return "success";
	}

	/**
	 * <pre>
	 * updateinstruById(通过乐器Id 查询入库相关信息)    
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
	 * updateinstruById(修改主乐器入库相关信息)    
	 * &#64;
	 * &#64;param response
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/updateinstock.do")
	@ResponseBody
	public void updateinstock(Instock instock) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		// 原来入库数
		Integer num = instockMapper.querypartsqty(instock.getId());
		// 修改库存表
		instockMapper.updateinstock(instock);
		machiningList = instockMapper.queryByName(instock);
		// 修改相关商品表
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
			instockMapper.updateoldinfo(instock);
		}
	}

	/* 修改配件入库并修改配件表 */
	@RequestMapping("/updateinstock2.do")
	@ResponseBody
	public void updateinstock2(Instock instock) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		// 原来入库数
		Integer num = instockMapper.querypartsqty(instock.getId());
		// 修改库存表
		instockMapper.updateinstock(instock);
		machiningList = instockMapper.querypartsByName(instock);
		// 修改相关商品表
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
			instockMapper.updateoldpartsinfo(instock);
		}
	}

	// 主乐器添加入库
	@RequestMapping("/addinstock.do")
	@ResponseBody
	public void addinstock(Instock instock) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		// 添加到库存表
		instockMapper.addinstock(instock);
		machiningList = instockMapper.queryByName(instock);
		if (machiningList.size() != 0) {
			// 存在主表，更新数据
			Integer a = Integer.valueOf(machiningList.get(0).get("inQty").toString());
			Integer b = Integer.valueOf(instock.getInQty());
			instock.setInQty(String.valueOf(b + a));
			instockMapper.updateoldinfo(instock);
		} else {
			// 添加到主表
			instockMapper.insertInfo(instock);
		}

	}

	// 配件添加入库
	@RequestMapping("/addpartsinstock.do")
	@ResponseBody
	public void addpartsinstock(Instock instock) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		// 添加到库存表
		instockMapper.addpartsinstock(instock);
		machiningList = instockMapper.querypartsByName(instock);
		if (machiningList.size() != 0) {
			// 存在主表，更新数据
			Integer a = Integer.valueOf(machiningList.get(0).get("inQty").toString());
			Integer b = Integer.valueOf(instock.getInQty());
			instock.setInQty(String.valueOf(b + a));
			instockMapper.updateoldpartsinfo(instock);
		} else {
			// 添加到主表
			instockMapper.insertpartsInfo(instock);
		}

	}

	// 模板下载
	@RequestMapping("/downloadExcel")
	public void downloadExcel(HttpServletResponse response, HttpServletRequest request) throws IOException {
		// 获取输入流，原始模板位置
		String filePath = getClass().getResource("/resource/导入主乐器模板.xls").getPath();
		InputStream bis = new BufferedInputStream(new FileInputStream(new File(filePath)));
		// 假如以中文名下载的话，设置下载文件名称
		String filename = "导入模板.xls";
		// 转码，免得文件名中文乱码
		filename = URLEncoder.encode(filename, "UTF-8");
		// 设置文件下载头
		response.addHeader("Content-Disposition", "attachment;filename=" + filename);
		// 1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
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
	 * 导入
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/export")
	@ResponseBody
	public String export(@RequestParam("file") MultipartFile file, @RequestParam("type") String type,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("==" + type);
		try {
			List<Instock> instockList = new ArrayList<Instock>();
			// @RequestParam("file") MultipartFile file 是用来接收前端传递过来的文件
			// 1.创建workbook对象，读取整个文档
			InputStream inputStream = file.getInputStream();
			Workbook wb = WorkbookFactory.create(inputStream);
			// 2.读取页脚sheet
			Sheet sheetAt = wb.getSheetAt(0);
			if (sheetAt == null) {
				return "2";
			}
			// 遍历行row
			for (int rowNum = 1; rowNum <= sheetAt.getLastRowNum(); rowNum++) {
				// 获取每一行
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
				if (type.equals("主乐器")) {
					addinstock(instock);
				} else if (type.equals("配件")) {
					addpartsinstock(instock);
				}
				System.out.println(instock.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "1";
	}
}
