package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

public interface DictMapper {
	//���巽������ѯ����ʡ����Ϣ
	List<Province> selectProvince();
	//��ѯ���г���
	List<City> selectCity(String provinceCode);
	//��ѯ��������
	List<Area> selectArea(String cityCode);
	//ͨ��ʡ�ı�Ų�ѯʡ������
	String selectByProvinceCode(String provinceCode);
	//ͨ���еı�Ų�ѯʡ������
	String selectByCityCode(String cityCode);
	//ͨ�����ı�Ų�ѯʡ������
	String selectByAreaCode(String areaCode);
}
