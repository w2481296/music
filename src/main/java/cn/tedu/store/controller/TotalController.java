package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.PageQueryBean;
import cn.tedu.store.mapper.TotalMapper;

@Controller
@RequestMapping("/total")
public class TotalController extends BaseController {
	@Autowired(required = false)
	public TotalMapper totalMapper;

	@RequestMapping("/queryallinstock.do")
	@ResponseBody
	public PageQueryBean queryallinstock(String inName, String inTime1, String inTime2, HttpServletResponse response) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		machiningList = totalMapper.queryallinstock(inName, inTime1, inTime2);// 订单id
		PageQueryBean pageQueryBean = new PageQueryBean();
		pageQueryBean.setItems(machiningList);
		pageQueryBean.setTotalRows(machiningList.size());
		return pageQueryBean;
	}

	
	@RequestMapping("/queryalloutstock.do")
	@ResponseBody
	public PageQueryBean queryalloutstock(String inName, String inTime1, String inTime2, HttpServletResponse response) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		machiningList = totalMapper.queryalloutstock(inName, inTime1, inTime2);// 订单id
		PageQueryBean pageQueryBean = new PageQueryBean();
		pageQueryBean.setItems(machiningList);
		pageQueryBean.setTotalRows(machiningList.size());
		return pageQueryBean;
	}
	
	
	@RequestMapping("/queryallmoney.do")
	@ResponseBody
	public PageQueryBean queryallmoney(String insName, String insTime1, String insTime2, HttpServletResponse response) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		machiningList = totalMapper.queryallmoney(insName, insTime1, insTime2);// 订单id
		PageQueryBean pageQueryBean = new PageQueryBean();
		pageQueryBean.setItems(machiningList);
		pageQueryBean.setTotalRows(machiningList.size());
		return pageQueryBean;
	}
	
	@RequestMapping("/queryallstock.do")
	@ResponseBody
	public PageQueryBean queryallstock(String insName, String insTime1, String insTime2, HttpServletResponse response) {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		machiningList = totalMapper.queryallstock(insName, insTime1, insTime2);// 订单id
		PageQueryBean pageQueryBean = new PageQueryBean();
		pageQueryBean.setItems(machiningList);
		pageQueryBean.setTotalRows(machiningList.size());
		return pageQueryBean;
	}
	@RequestMapping("/querystockview.do")
	@ResponseBody
	public List<Map<String, Object>> querystockview() {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> machiningList1 = new ArrayList<Map<String, Object>>();
		machiningList=totalMapper.querystockviewin();//入库数据
		machiningList1=totalMapper.querystockviewout();//出库数据
		for(int i=0;i<machiningList1.size();i++){
			machiningList.add(machiningList1.get(i));
		}
		System.out.println(machiningList);
		return machiningList;
	}
	@RequestMapping("/querystockmview.do")
	@ResponseBody
	public List<Map<String, Object>> querystockmview() {
		List<Map<String, Object>> machiningList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> machiningList1 = new ArrayList<Map<String, Object>>();
		machiningList=totalMapper.querystockmviewin();//入库数据
		machiningList1=totalMapper.querystockmviewout();//出库数据
		for(int i=0;i<machiningList1.size();i++){
			machiningList.add(machiningList1.get(i));
		}
		System.out.println(machiningList);
		return machiningList;
	}

}
