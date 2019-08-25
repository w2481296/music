package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

public interface DictMapper {
	//定义方法，查询所有省份信息
	List<Province> selectProvince();
	//查询所有城市
	List<City> selectCity(String provinceCode);
	//查询所有区县
	List<Area> selectArea(String cityCode);
	//通过省的编号查询省的名称
	String selectByProvinceCode(String provinceCode);
	//通过市的编号查询省的名称
	String selectByCityCode(String cityCode);
	//通过区的编号查询省的名称
	String selectByAreaCode(String areaCode);
}
