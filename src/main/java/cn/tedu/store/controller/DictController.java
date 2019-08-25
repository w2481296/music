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
		//定义方法获取省份信息
		@RequestMapping("/getProvince.do")
		@ResponseBody
		public ResponseResult<List<Province>> getProvince(){
			ResponseResult<List<Province>> rr=new ResponseResult<>(1, "成功");
			//1.创建rr对象设置state：1，message:成功
			List list=dictService.getProvince();
			rr.setData(list);
			//2.调用业务层的方法，getprovince();返回list集合
			//3、把list添加到rr对象的data属性中
			return rr;
		}
		//定义方法获取城市信息
		@RequestMapping("/getCity.do")
		@ResponseBody
		public ResponseResult<List<City>> getCity(String provinceCode){
			ResponseResult<List<City>> rr=new ResponseResult<>(1, "成功");
			//1.创建rr对象设置state：1，message:成功
			List list=dictService.getCity(provinceCode);
			rr.setData(list);
			//2.调用业务层的方法，getpCity();返回list集合
			//3、把list添加到rr对象的data属性中
			return rr;
		}
		//定义方法获取区县信息
		@RequestMapping("/getArea.do")
		@ResponseBody
		public ResponseResult<List<Area>> getArea(String cityCode){
			ResponseResult<List<Area>> rr=new ResponseResult<>(1, "成功");
			//1.创建rr对象设置state：1，message:成功
			List list=dictService.getArea(cityCode);
			rr.setData(list);
			//2.调用业务层的方法，getpCity();返回list集合
			//3、把list添加到rr对象的data属性中
			return rr;
		}
		
		
	
}
