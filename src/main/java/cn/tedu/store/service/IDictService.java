package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

public interface IDictService{
	List<Province> getProvince();
	List<City> getCity(String ProvinceCode);
	List<Area> getArea(String cityCode);
}