package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IDictService;

@Controller
@RequestMapping("/dict")
public class DictController{
		@Resource
		private IDictService dictService;
		//���巽����ȡʡ����Ϣ
		@RequestMapping("/getProvince.do")
		@ResponseBody
		public ResponseResult<List<Province>> getProvince(){
			ResponseResult<List<Province>> rr=new ResponseResult<>(1, "�ɹ�");
			//1.����rr��������state��1��message:�ɹ�
			List list=dictService.getProvince();
			rr.setData(list);
			//2.����ҵ���ķ�����getprovince();����list����
			//3����list��ӵ�rr�����data������
			return rr;
		}
		//���巽����ȡ������Ϣ
		@RequestMapping("/getCity.do")
		@ResponseBody
		public ResponseResult<List<City>> getCity(String provinceCode){
			ResponseResult<List<City>> rr=new ResponseResult<>(1, "�ɹ�");
			//1.����rr��������state��1��message:�ɹ�
			List list=dictService.getCity(provinceCode);
			rr.setData(list);
			//2.����ҵ���ķ�����getpCity();����list����
			//3����list��ӵ�rr�����data������
			return rr;
		}
		//���巽����ȡ������Ϣ
		@RequestMapping("/getArea.do")
		@ResponseBody
		public ResponseResult<List<Area>> getArea(String cityCode){
			ResponseResult<List<Area>> rr=new ResponseResult<>(1, "�ɹ�");
			//1.����rr��������state��1��message:�ɹ�
			List list=dictService.getArea(cityCode);
			rr.setData(list);
			//2.����ҵ���ķ�����getpCity();����list����
			//3����list��ӵ�rr�����data������
			return rr;
		}
		
		
	
}
